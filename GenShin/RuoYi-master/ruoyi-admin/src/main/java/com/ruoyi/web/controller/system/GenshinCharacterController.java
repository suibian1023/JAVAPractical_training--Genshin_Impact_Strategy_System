package com.ruoyi.web.controller.system;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.system.domain.GenshinCharacter;
import com.ruoyi.system.domain.GenshinRecommendArtifact;
import com.ruoyi.system.domain.GenshinRecommendTeam;
import com.ruoyi.system.domain.GenshinRecommendWeapon;
import com.ruoyi.system.domain.TalentCosts;
import com.ruoyi.system.service.IGenshinCharacterService;
import com.ruoyi.system.service.IGenshinRecommendArtifactService;
import com.ruoyi.system.service.IGenshinRecommendTeamService;
import com.ruoyi.system.service.IGenshinRecommendWeaponService;
import com.ruoyi.system.service.ITalentCostsService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 原神角色基础信息Controller
 * 
 * @author ruoyi
 * @date 2026-05-29
 */
@Controller
@RequestMapping("/system/character")
public class GenshinCharacterController extends BaseController
{
    private String prefix = "system/character";

    @Autowired
    private IGenshinCharacterService genshinCharacterService;

    @Autowired
    private IGenshinRecommendWeaponService genshinRecommendWeaponService;

    @Autowired
    private IGenshinRecommendArtifactService genshinRecommendArtifactService;

    @Autowired
    private IGenshinRecommendTeamService genshinRecommendTeamService;

    @Autowired
    private ITalentCostsService talentCostsService;

    @RequiresPermissions("system:character:view")
    @GetMapping()
    public String character()
    {
        return prefix + "/character";
    }

    /**
     * 查询原神角色基础信息列表
     */
    @RequiresPermissions("system:character:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(GenshinCharacter genshinCharacter)
    {
        startPage();
        List<GenshinCharacter> list = genshinCharacterService.selectGenshinCharacterList(genshinCharacter);
        return getDataTable(list);
    }

    /**
     * 导出原神角色基础信息列表
     */
    @RequiresPermissions("system:character:export")
    @Log(title = "原神角色基础信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(GenshinCharacter genshinCharacter)
    {
        List<GenshinCharacter> list = genshinCharacterService.selectGenshinCharacterList(genshinCharacter);
        ExcelUtil<GenshinCharacter> util = new ExcelUtil<GenshinCharacter>(GenshinCharacter.class);
        return util.exportExcel(list, "原神角色基础信息数据");
    }

    /**
     * 新增原神角色基础信息
     */
    @RequiresPermissions("system:character:add")
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存原神角色基础信息
     */
    @RequiresPermissions("system:character:add")
    @Log(title = "原神角色基础信息", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(GenshinCharacter genshinCharacter)
    {
        return toAjax(genshinCharacterService.insertGenshinCharacter(genshinCharacter));
    }

    /**
     * 修改原神角色基础信息
     */
    @RequiresPermissions("system:character:edit")
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        GenshinCharacter genshinCharacter = genshinCharacterService.selectGenshinCharacterById(id);
        mmap.put("genshinCharacter", genshinCharacter);
        return prefix + "/edit";
    }

    /**
     * 修改保存原神角色基础信息
     */
    @RequiresPermissions("system:character:edit")
    @Log(title = "原神角色基础信息", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(GenshinCharacter genshinCharacter)
    {
        return toAjax(genshinCharacterService.updateGenshinCharacter(genshinCharacter));
    }

    /**
     * 删除原神角色基础信息
     */
    @RequiresPermissions("system:character:remove")
    @Log(title = "原神角色基础信息", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(genshinCharacterService.deleteGenshinCharacterByIds(ids));
    }

    /**
     * 角色培养路线图列表
     */
    @RequiresPermissions("system:character:list")
    @GetMapping("/build")
    public String buildList(ModelMap mmap)
    {
        mmap.put("characters", genshinCharacterService.selectGenshinCharacterList(new GenshinCharacter()));
        return prefix + "/buildList";
    }

    /**
     * 角色培养路线图
     */
    @RequiresPermissions("system:character:list")
    @GetMapping("/build/{id}")
    public String build(@PathVariable("id") Long id, ModelMap mmap)
    {
        // 1. 角色基础信息
        mmap.put("character", genshinCharacterService.selectGenshinCharacterById(id));

        // 2. 推荐武器列表
        GenshinRecommendWeapon weaponQuery = new GenshinRecommendWeapon();
        weaponQuery.setCharacterId(id);
        mmap.put("weapons", genshinRecommendWeaponService.selectGenshinRecommendWeaponList(weaponQuery));

        // 3. 圣遗物推荐列表
        GenshinRecommendArtifact artifactQuery = new GenshinRecommendArtifact();
        artifactQuery.setCharacterId(id);
        mmap.put("artifacts", genshinRecommendArtifactService.selectGenshinRecommendArtifactList(artifactQuery));

        // 4. 配队推荐 - 查所有队伍，过滤包含该角色的
        List<GenshinRecommendTeam> allTeams = genshinRecommendTeamService.selectGenshinRecommendTeamList(new GenshinRecommendTeam());
        List<GenshinRecommendTeam> filteredTeams = allTeams.stream()
            .filter(t -> Objects.equals(t.getChar1Id(), id) || Objects.equals(t.getChar2Id(), id)
                       || Objects.equals(t.getChar3Id(), id) || Objects.equals(t.getChar4Id(), id))
            .collect(Collectors.toList());
        mmap.put("teams", filteredTeams);

        // 5. 天赋升级材料
        TalentCosts talentQuery = new TalentCosts();
        talentQuery.setCharacterId(id);
        mmap.put("talentCosts", talentCostsService.selectTalentCostsList(talentQuery));

        return prefix + "/build";
    }
}
