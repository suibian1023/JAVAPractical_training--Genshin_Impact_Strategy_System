package com.ruoyi.web.controller.system;

import java.util.List;
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
import com.ruoyi.system.domain.GenshinEnemyInvestigation;
import com.ruoyi.system.service.IGenshinEnemyInvestigationService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 原神怪物调查信息Controller
 * 
 * @author ruoyi
 * @date 2026-05-29
 */
@Controller
@RequestMapping("/system/investigation")
public class GenshinEnemyInvestigationController extends BaseController
{
    private String prefix = "system/investigation";

    @Autowired
    private IGenshinEnemyInvestigationService genshinEnemyInvestigationService;

    @RequiresPermissions("system:investigation:view")
    @GetMapping()
    public String investigation()
    {
        return prefix + "/investigation";
    }

    /**
     * 查询原神怪物调查信息列表
     */
    @RequiresPermissions("system:investigation:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(GenshinEnemyInvestigation genshinEnemyInvestigation)
    {
        startPage();
        List<GenshinEnemyInvestigation> list = genshinEnemyInvestigationService.selectGenshinEnemyInvestigationList(genshinEnemyInvestigation);
        return getDataTable(list);
    }

    /**
     * 导出原神怪物调查信息列表
     */
    @RequiresPermissions("system:investigation:export")
    @Log(title = "原神怪物调查信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(GenshinEnemyInvestigation genshinEnemyInvestigation)
    {
        List<GenshinEnemyInvestigation> list = genshinEnemyInvestigationService.selectGenshinEnemyInvestigationList(genshinEnemyInvestigation);
        ExcelUtil<GenshinEnemyInvestigation> util = new ExcelUtil<GenshinEnemyInvestigation>(GenshinEnemyInvestigation.class);
        return util.exportExcel(list, "原神怪物调查信息数据");
    }

    /**
     * 新增原神怪物调查信息
     */
    @RequiresPermissions("system:investigation:add")
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存原神怪物调查信息
     */
    @RequiresPermissions("system:investigation:add")
    @Log(title = "原神怪物调查信息", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(GenshinEnemyInvestigation genshinEnemyInvestigation)
    {
        return toAjax(genshinEnemyInvestigationService.insertGenshinEnemyInvestigation(genshinEnemyInvestigation));
    }

    /**
     * 修改原神怪物调查信息
     */
    @RequiresPermissions("system:investigation:edit")
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        GenshinEnemyInvestigation genshinEnemyInvestigation = genshinEnemyInvestigationService.selectGenshinEnemyInvestigationById(id);
        mmap.put("genshinEnemyInvestigation", genshinEnemyInvestigation);
        return prefix + "/edit";
    }

    /**
     * 修改保存原神怪物调查信息
     */
    @RequiresPermissions("system:investigation:edit")
    @Log(title = "原神怪物调查信息", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(GenshinEnemyInvestigation genshinEnemyInvestigation)
    {
        return toAjax(genshinEnemyInvestigationService.updateGenshinEnemyInvestigation(genshinEnemyInvestigation));
    }

    /**
     * 删除原神怪物调查信息
     */
    @RequiresPermissions("system:investigation:remove")
    @Log(title = "原神怪物调查信息", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(genshinEnemyInvestigationService.deleteGenshinEnemyInvestigationByIds(ids));
    }
}
