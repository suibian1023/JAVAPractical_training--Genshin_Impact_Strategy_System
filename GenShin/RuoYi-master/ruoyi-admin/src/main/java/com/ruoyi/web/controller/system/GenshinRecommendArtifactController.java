package com.ruoyi.web.controller.system;

import java.util.List;

import com.ruoyi.system.domain.GenshinCharacter;
import com.ruoyi.common.core.domain.entity.SysDictData;
import com.ruoyi.system.service.IGenshinCharacterService;
import com.ruoyi.system.service.ISysDictDataService;
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
import com.ruoyi.system.domain.GenshinRecommendArtifact;
import com.ruoyi.system.service.IGenshinRecommendArtifactService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 角色圣遗物推荐Controller
 *
 * @author ruoyi
 * @date 2024-05-21
 */
@Controller
@RequestMapping("/system/artifact")
public class GenshinRecommendArtifactController extends BaseController
{
    private final String prefix = "system/artifact";

    @Autowired
    private IGenshinRecommendArtifactService genshinRecommendArtifactService;

    @Autowired
    private IGenshinCharacterService genshinCharacterService;

    @Autowired
    private ISysDictDataService dictDataService;

    @RequiresPermissions("system:artifact:view")
    @GetMapping()
    public String artifact(ModelMap mmap)
    {
        mmap.put("characters", genshinCharacterService.selectGenshinCharacterList(new GenshinCharacter()));
        SysDictData dictData = new SysDictData();
        dictData.setDictType("genshin_artifact_sets");
        mmap.put("artifacts", dictDataService.selectDictDataList(dictData));
        return prefix + "/artifact";
    }

    /**
     * 查询角色圣遗物推荐列表
     */
    @RequiresPermissions("system:artifact:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(GenshinRecommendArtifact genshinRecommendArtifact)
    {
        startPage();
        List<GenshinRecommendArtifact> list = genshinRecommendArtifactService.selectGenshinRecommendArtifactList(genshinRecommendArtifact);
        return getDataTable(list);
    }

    /**
     * 导出角色圣遗物推荐列表
     */
    @RequiresPermissions("system:artifact:export")
    @Log(title = "角色圣遗物推荐", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(GenshinRecommendArtifact genshinRecommendArtifact)
    {
        List<GenshinRecommendArtifact> list = genshinRecommendArtifactService.selectGenshinRecommendArtifactList(genshinRecommendArtifact);
        ExcelUtil<GenshinRecommendArtifact> util = new ExcelUtil<>(GenshinRecommendArtifact.class);
        return util.exportExcel(list, "角色圣遗物推荐数据");
    }

    /**
     * 新增角色圣遗物推荐
     */
    @RequiresPermissions("system:artifact:add")
    @GetMapping("/add")
    public String add(ModelMap mmap)
    {
        mmap.put("characters", genshinCharacterService.selectGenshinCharacterList(new GenshinCharacter()));
        SysDictData dictData = new SysDictData();
        dictData.setDictType("genshin_artifact_sets");
        mmap.put("artifacts", dictDataService.selectDictDataList(dictData));
        return prefix + "/add";
    }

    /**
     * 新增保存角色圣遗物推荐
     */
    @RequiresPermissions("system:artifact:add")
    @Log(title = "角色圣遗物推荐", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(GenshinRecommendArtifact genshinRecommendArtifact)
    {
        return toAjax(genshinRecommendArtifactService.insertGenshinRecommendArtifact(genshinRecommendArtifact));
    }

    /**
     * 修改角色圣遗物推荐
     */
    @RequiresPermissions("system:artifact:edit")
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        GenshinRecommendArtifact genshinRecommendArtifact = genshinRecommendArtifactService.selectGenshinRecommendArtifactById(id);
        mmap.put("genshinRecommendArtifact", genshinRecommendArtifact);
        mmap.put("characters", genshinCharacterService.selectGenshinCharacterList(new GenshinCharacter()));
        SysDictData dictData = new SysDictData();
        dictData.setDictType("genshin_artifact_sets");
        mmap.put("artifacts", dictDataService.selectDictDataList(dictData));
        return prefix + "/edit";
    }

    /**
     * 修改保存角色圣遗物推荐
     */
    @RequiresPermissions("system:artifact:edit")
    @Log(title = "角色圣遗物推荐", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(GenshinRecommendArtifact genshinRecommendArtifact)
    {
        return toAjax(genshinRecommendArtifactService.updateGenshinRecommendArtifact(genshinRecommendArtifact));
    }

    /**
     * 删除角色圣遗物推荐
     */
    @RequiresPermissions("system:artifact:remove")
    @Log(title = "角色圣遗物推荐", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(genshinRecommendArtifactService.deleteGenshinRecommendArtifactByIds(ids));
    }
}
