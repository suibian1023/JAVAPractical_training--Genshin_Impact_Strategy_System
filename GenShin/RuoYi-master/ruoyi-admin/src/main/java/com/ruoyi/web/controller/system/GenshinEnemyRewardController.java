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
import com.ruoyi.system.domain.GenshinEnemyReward;
import com.ruoyi.system.service.IGenshinEnemyRewardService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 原神怪物掉落奖励Controller
 * 
 * @author ruoyi
 * @date 2026-05-29
 */
@Controller
@RequestMapping("/system/reward")
public class GenshinEnemyRewardController extends BaseController
{
    private String prefix = "system/reward";

    @Autowired
    private IGenshinEnemyRewardService genshinEnemyRewardService;

    @RequiresPermissions("system:reward:view")
    @GetMapping()
    public String reward()
    {
        return prefix + "/reward";
    }

    /**
     * 查询原神怪物掉落奖励列表
     */
    @RequiresPermissions("system:reward:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(GenshinEnemyReward genshinEnemyReward)
    {
        startPage();
        List<GenshinEnemyReward> list = genshinEnemyRewardService.selectGenshinEnemyRewardList(genshinEnemyReward);
        return getDataTable(list);
    }

    /**
     * 导出原神怪物掉落奖励列表
     */
    @RequiresPermissions("system:reward:export")
    @Log(title = "原神怪物掉落奖励", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(GenshinEnemyReward genshinEnemyReward)
    {
        List<GenshinEnemyReward> list = genshinEnemyRewardService.selectGenshinEnemyRewardList(genshinEnemyReward);
        ExcelUtil<GenshinEnemyReward> util = new ExcelUtil<GenshinEnemyReward>(GenshinEnemyReward.class);
        return util.exportExcel(list, "原神怪物掉落奖励数据");
    }

    /**
     * 新增原神怪物掉落奖励
     */
    @RequiresPermissions("system:reward:add")
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存原神怪物掉落奖励
     */
    @RequiresPermissions("system:reward:add")
    @Log(title = "原神怪物掉落奖励", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(GenshinEnemyReward genshinEnemyReward)
    {
        return toAjax(genshinEnemyRewardService.insertGenshinEnemyReward(genshinEnemyReward));
    }

    /**
     * 修改原神怪物掉落奖励
     */
    @RequiresPermissions("system:reward:edit")
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        GenshinEnemyReward genshinEnemyReward = genshinEnemyRewardService.selectGenshinEnemyRewardById(id);
        mmap.put("genshinEnemyReward", genshinEnemyReward);
        return prefix + "/edit";
    }

    /**
     * 修改保存原神怪物掉落奖励
     */
    @RequiresPermissions("system:reward:edit")
    @Log(title = "原神怪物掉落奖励", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(GenshinEnemyReward genshinEnemyReward)
    {
        return toAjax(genshinEnemyRewardService.updateGenshinEnemyReward(genshinEnemyReward));
    }

    /**
     * 删除原神怪物掉落奖励
     */
    @RequiresPermissions("system:reward:remove")
    @Log(title = "原神怪物掉落奖励", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(genshinEnemyRewardService.deleteGenshinEnemyRewardByIds(ids));
    }
}
