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
import com.ruoyi.system.domain.GenshinEnemy;
import com.ruoyi.system.service.IGenshinEnemyService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 原神怪物信息Controller
 * 
 * @author ruoyi
 * @date 2026-05-29
 */
@Controller
@RequestMapping("/system/enemy")
public class GenshinEnemyController extends BaseController
{
    private String prefix = "system/enemy";

    @Autowired
    private IGenshinEnemyService genshinEnemyService;

    @RequiresPermissions("system:enemy:view")
    @GetMapping()
    public String enemy()
    {
        return prefix + "/enemy";
    }

    /**
     * 查询原神怪物信息列表
     */
    @RequiresPermissions("system:enemy:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(GenshinEnemy genshinEnemy)
    {
        startPage();
        List<GenshinEnemy> list = genshinEnemyService.selectGenshinEnemyList(genshinEnemy);
        return getDataTable(list);
    }

    /**
     * 导出原神怪物信息列表
     */
    @RequiresPermissions("system:enemy:export")
    @Log(title = "原神怪物信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(GenshinEnemy genshinEnemy)
    {
        List<GenshinEnemy> list = genshinEnemyService.selectGenshinEnemyList(genshinEnemy);
        ExcelUtil<GenshinEnemy> util = new ExcelUtil<GenshinEnemy>(GenshinEnemy.class);
        return util.exportExcel(list, "原神怪物信息数据");
    }

    /**
     * 新增原神怪物信息
     */
    @RequiresPermissions("system:enemy:add")
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存原神怪物信息
     */
    @RequiresPermissions("system:enemy:add")
    @Log(title = "原神怪物信息", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(GenshinEnemy genshinEnemy)
    {
        return toAjax(genshinEnemyService.insertGenshinEnemy(genshinEnemy));
    }

    /**
     * 修改原神怪物信息
     */
    @RequiresPermissions("system:enemy:edit")
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        GenshinEnemy genshinEnemy = genshinEnemyService.selectGenshinEnemyById(id);
        mmap.put("genshinEnemy", genshinEnemy);
        return prefix + "/edit";
    }

    /**
     * 修改保存原神怪物信息
     */
    @RequiresPermissions("system:enemy:edit")
    @Log(title = "原神怪物信息", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(GenshinEnemy genshinEnemy)
    {
        return toAjax(genshinEnemyService.updateGenshinEnemy(genshinEnemy));
    }

    /**
     * 删除原神怪物信息
     */
    @RequiresPermissions("system:enemy:remove")
    @Log(title = "原神怪物信息", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(genshinEnemyService.deleteGenshinEnemyByIds(ids));
    }
}
