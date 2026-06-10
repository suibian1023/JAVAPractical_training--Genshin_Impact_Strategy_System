package com.ruoyi.web.controller.system;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.system.domain.GenshinCharacter;
import com.ruoyi.system.domain.GenshinCharacterCost;
import com.ruoyi.system.domain.GenshinCraftRecipe;
import com.ruoyi.system.domain.Materials;
import com.ruoyi.system.domain.TalentCosts;
import com.ruoyi.system.service.IGenshinCharacterCostService;
import com.ruoyi.system.service.IGenshinCharacterService;
import com.ruoyi.system.service.IGenshinCraftService;
import com.ruoyi.system.service.IMaterialsService;
import com.ruoyi.system.service.ITalentCostsService;

/**
 * 养成计算器Controller
 * 
 * @author ruoyi
 */
@Controller
@RequestMapping("/system/calculator")
public class GenshinCalculatorController extends BaseController
{
    private String prefix = "system/calculator";

    @Autowired
    private IGenshinCharacterService genshinCharacterService;

    @Autowired
    private ITalentCostsService talentCostsService;

    @Autowired
    private IGenshinCharacterCostService genshinCharacterCostService;

    @Autowired
    private IMaterialsService materialsService;

    @Autowired
    private IGenshinCraftService genshinCraftService;

    @RequiresPermissions("system:calculator:view")
    @GetMapping()
    public String calculator(ModelMap mmap)
    {
        GenshinCharacter query = new GenshinCharacter();
        mmap.put("characters", genshinCharacterService.selectGenshinCharacterList(query));
        return prefix + "/calculator";
    }

    /**
     * 综合计算：角色突破0→90 + 天赋1→10 + 总摩拉 + 来源分类 + 合成路线
     */
    @RequiresPermissions("system:calculator:list")
    @PostMapping("/calculateAll")
    @ResponseBody
    public AjaxResult calculateAll(Long characterId)
    {
        if (characterId == null) {
            return error("请选择角色");
        }

        GenshinCharacter character = genshinCharacterService.selectGenshinCharacterById(characterId);
        if (character == null) {
            return error("角色不存在");
        }

        // ===== 1. 计算天赋材料 (1→10) =====
        TalentCosts tcQuery = new TalentCosts();
        tcQuery.setCharacterId(characterId);
        List<TalentCosts> allTalentCosts = talentCostsService.selectTalentCostsList(tcQuery);

        Map<String, MaterialItem> talentMaterialMap = new HashMap<>();
        long talentMora = 0L;
        for (TalentCosts cost : allTalentCosts) {
            if (cost.getLevel() != null && cost.getLevel() > 1 && cost.getLevel() <= 10) {
                String name = cost.getMaterialName();
                Long count = cost.getCount();
                if (name != null && count != null) {
                    if ("摩拉".equals(name)) {
                        talentMora += count;
                    } else {
                        talentMaterialMap.computeIfAbsent(name, k -> new MaterialItem(name));
                        talentMaterialMap.get(name).addCount(count);
                    }
                }
            }
        }

        // ===== 2. 计算突破材料 (0→90, ascend_level 1-6) =====
        GenshinCharacterCost ascQuery = new GenshinCharacterCost();
        ascQuery.setCharacterId(characterId);
        List<GenshinCharacterCost> allAscCosts = genshinCharacterCostService.selectGenshinCharacterCostList(ascQuery);

        Map<String, MaterialItem> ascensionMaterialMap = new HashMap<>();
        long ascensionMora = 0L;
        for (GenshinCharacterCost cost : allAscCosts) {
            if (cost.getAscendLevel() != null && cost.getAscendLevel() >= 1 && cost.getAscendLevel() <= 6) {
                String name = cost.getItemName();
                Long count = cost.getItemCount();
                if (name != null && count != null) {
                    if ("摩拉".equals(name)) {
                        ascensionMora += count;
                    } else {
                        ascensionMaterialMap.computeIfAbsent(name, k -> new MaterialItem(name));
                        ascensionMaterialMap.get(name).addCount(count);
                    }
                }
            }
        }

        // ===== 3. 合并所有材料并查询来源 =====
        Map<String, Map<String, Object>> mergedMap = new HashMap<>();
        
        // 处理天赋材料
        for (MaterialItem item : talentMaterialMap.values()) {
            Map<String, Object> entry = new HashMap<>();
            entry.put("materialName", item.name);
            entry.put("totalCount", item.count);
            entry.put("category", "talent");
            mergedMap.put(item.name, entry);
        }
        
        // 处理突破材料
        for (MaterialItem item : ascensionMaterialMap.values()) {
            if (mergedMap.containsKey(item.name)) {
                Map<String, Object> entry = mergedMap.get(item.name);
                entry.put("totalCount", ((Number) entry.get("totalCount")).longValue() + item.count);
                entry.put("category", "both");
            } else {
                Map<String, Object> entry = new HashMap<>();
                entry.put("materialName", item.name);
                entry.put("totalCount", item.count);
                entry.put("category", "ascension");
                mergedMap.put(item.name, entry);
            }
        }

        // ===== 4. 丰富材料信息（来源分类、秘境、合成路线、怪物来源） =====
        List<Map<String, Object>> materialList = new ArrayList<>();
        for (Map.Entry<String, Map<String, Object>> entry : mergedMap.entrySet()) {
            String materialName = entry.getKey();
            Map<String, Object> item = entry.getValue();

            // 查询 materials 表
            Materials mat = materialsService.selectMaterialsByName(materialName);
            
            // 来源分类
            String sourceType = classifySource(mat);
            item.put("sourceType", sourceType);
            item.put("sourceTypeName", getSourceTypeName(sourceType));
            
            // 秘境信息
            if (mat != null) {
                item.put("dropDomainName", mat.getDropDomainName());
                item.put("daysOfWeek", mat.getDaysOfWeek());
                item.put("typeText", mat.getTypeText());
                item.put("rarity", mat.getRarity());
                item.put("sources", mat.getSources());
            }

            // 合成路线
            List<Map<String, Object>> craftRoutes = lookupCraftRoute(materialName);
            item.put("craftRoutes", craftRoutes);

            materialList.add(item);
        }

        // 按来源类型排序：采集 → 大世界怪物 → BOSS → 秘境
        materialList.sort((a, b) -> {
            int orderA = getSourceOrder((String) a.get("sourceType"));
            int orderB = getSourceOrder((String) b.get("sourceType"));
            return Integer.compare(orderA, orderB);
        });

        // ===== 5. 构建结果 =====
        Map<String, Object> result = new HashMap<>();
        result.put("character", character);
        result.put("materials", materialList);
        result.put("totalMaterialTypes", materialList.size());
        result.put("talentMora", talentMora);
        result.put("ascensionMora", ascensionMora);
        result.put("totalMora", talentMora + ascensionMora);
        result.put("talentFrom", 1);
        result.put("talentTo", 10);
        result.put("ascensionFrom", 0);
        result.put("ascensionTo", 6);

        // 按来源分类统计
        Map<String, List<Map<String, Object>>> bySource = new HashMap<>();
        for (Map<String, Object> item : materialList) {
            String st = (String) item.get("sourceType");
            bySource.computeIfAbsent(st, k -> new ArrayList<>()).add(item);
        }
        result.put("bySource", bySource);

        return success(result);
    }

    /**
     * 分类材料来源
     */
    private String classifySource(Materials mat) {
        if (mat == null) return "unknown";
        
        // 1. 有秘境掉落 → 秘境
        if (mat.getDropDomainName() != null && !mat.getDropDomainName().isEmpty()) {
            // 角色天赋素材 → 秘境（天赋）
            // 武器突破素材 → 秘境（武器）
            // 角色突破素材 → BOSS/秘境
            if ("AVATAR_MATERIAL".equals(mat.getCategory())) {
                return "domain_talent";
            }
            if ("WEAPON_MATERIAL".equals(mat.getCategory()) || "WEAPON_PROMOTE".equals(mat.getCategory())) {
                return "domain_weapon";
            }
            return "domain";
        }
        
        // 2. 检查来源文本
        String sources = mat.getSources();
        if (sources != null) {
            if (sources.contains("采集") || sources.contains("野外")) {
                return "gather";
            }
            if (sources.contains("BOSS") || sources.contains("征讨") || sources.contains("领主")) {
                return "boss";
            }
            if (sources.contains("合成")) {
                return "craft_only";
            }
            if (sources.contains("活动")) {
                return "event";
            }
            if (sources.contains("兑换") || sources.contains("商城")) {
                return "shop";
            }
        }
        
        // 3. 根据类型文本判断
        String typeText = mat.getTypeText();
        if (typeText != null) {
            if (typeText.contains("特产")) {
                return "gather";
            }
            if (typeText.contains("BOSS") || typeText.contains("Boss")) {
                return "boss";
            }
            if (typeText.contains("角色突破")) {
                return "boss";
            }
        }
        
        return "unknown";
    }

    private String getSourceTypeName(String type) {
        switch (type) {
            case "gather": return "大世界采集";
            case "domain_talent": return "秘境·天赋培养";
            case "domain_weapon": return "秘境·武器突破";
            case "domain": return "秘境";
            case "boss": return "BOSS掉落";
            case "craft_only": return "合成获得";
            case "event": return "活动奖励";
            case "shop": return "商城兑换";
            default: return "其他";
        }
    }

    private int getSourceOrder(String type) {
        switch (type) {
            case "gather": return 1;
            case "boss": return 2;
            case "domain": return 3;
            case "domain_talent": return 3;
            case "domain_weapon": return 3;
            case "craft_only": return 4;
            case "event": return 5;
            case "shop": return 6;
            default: return 99;
        }
    }

    /**
     * 查询材料合成路线（低阶→高阶）
     */
    private List<Map<String, Object>> lookupCraftRoute(String materialName) {
        List<Map<String, Object>> routes = new ArrayList<>();
        try {
            // 查找是否有配方可以合成此材料
            com.ruoyi.system.domain.GenshinCraft craft = genshinCraftService.selectGenshinCraftByName(materialName);
            if (craft != null) {
                List<GenshinCraftRecipe> recipes = genshinCraftService.selectGenshinCraftRecipeByCraftId(craft.getId());
                if (recipes != null && !recipes.isEmpty()) {
                    Map<String, Object> route = new HashMap<>();
                    route.put("resultName", materialName);
                    route.put("resultCount", craft.getResultCount());
                    route.put("moraCost", craft.getMoraCost());
                    route.put("unlockRank", craft.getUnlockRank());
                    
                    List<Map<String, Object>> ingredients = new ArrayList<>();
                    for (GenshinCraftRecipe recipe : recipes) {
                        if (recipe.getIsAlt() == null || recipe.getIsAlt() == 0) {
                            Map<String, Object> ing = new HashMap<>();
                            ing.put("materialName", recipe.getMaterialName());
                            ing.put("materialCount", recipe.getMaterialCount());
                            ingredients.add(ing);
                        }
                    }
                    route.put("ingredients", ingredients);
                    routes.add(route);
                }
            }
        } catch (Exception e) {
            // 忽略查询错误
        }
        return routes;
    }

    /**
     * 内部类：材料统计辅助
     */
    static class MaterialItem {
        String name;
        long count;
        MaterialItem(String name) { this.name = name; this.count = 0L; }
        void addCount(long c) { this.count += c; }
    }
}
