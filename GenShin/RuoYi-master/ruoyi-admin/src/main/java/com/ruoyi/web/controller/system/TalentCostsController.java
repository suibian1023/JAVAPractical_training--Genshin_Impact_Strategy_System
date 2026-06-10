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
import com.ruoyi.system.domain.TalentCosts;
import com.ruoyi.system.service.ITalentCostsService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 天赋升级材料Controller
 * 
 * @author ruoyi
 * @date 2026-05-29
 */
@Controller
@RequestMapping("/system/costs")
public class TalentCostsController extends BaseController
{
    private String prefix = "system/costs";

    @Autowired
    private ITalentCostsService talentCostsService;

    @RequiresPermissions("system:costs:view")
    @GetMapping()
    public String costs()
    {
        return prefix + "/costs";
    }

    /**
     * 查询天赋升级材料列表
     */
    @RequiresPermissions("system:costs:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(TalentCosts talentCosts)
    {
        startPage();
        List<TalentCosts> list = talentCostsService.selectTalentCostsList(talentCosts);
        return getDataTable(list);
    }

    /**
     * 导出天赋升级材料列表
     */
    @RequiresPermissions("system:costs:export")
    @Log(title = "天赋升级材料", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(TalentCosts talentCosts)
    {
        List<TalentCosts> list = talentCostsService.selectTalentCostsList(talentCosts);
        ExcelUtil<TalentCosts> util = new ExcelUtil<TalentCosts>(TalentCosts.class);
        return util.exportExcel(list, "天赋升级材料数据");
    }

    /**
     * 新增天赋升级材料
     */
    @RequiresPermissions("system:costs:add")
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存天赋升级材料
     */
    @RequiresPermissions("system:costs:add")
    @Log(title = "天赋升级材料", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(TalentCosts talentCosts)
    {
        return toAjax(talentCostsService.insertTalentCosts(talentCosts));
    }

    /**
     * 修改天赋升级材料
     */
    @RequiresPermissions("system:costs:edit")
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        TalentCosts talentCosts = talentCostsService.selectTalentCostsById(id);
        mmap.put("talentCosts", talentCosts);
        return prefix + "/edit";
    }

    /**
     * 修改保存天赋升级材料
     */
    @RequiresPermissions("system:costs:edit")
    @Log(title = "天赋升级材料", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(TalentCosts talentCosts)
    {
        return toAjax(talentCostsService.updateTalentCosts(talentCosts));
    }

    /**
     * 删除天赋升级材料
     */
    @RequiresPermissions("system:costs:remove")
    @Log(title = "天赋升级材料", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(talentCostsService.deleteTalentCostsByIds(ids));
    }
}
