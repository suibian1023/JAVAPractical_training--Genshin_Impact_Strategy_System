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
import com.ruoyi.system.domain.GenshinWeapon;
import com.ruoyi.system.service.IGenshinWeaponService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 原神武器信息Controller
 *
 * @author ruoyi
 * @date 2026-06-05
 */
@Controller
@RequestMapping("/system/weapon")
public class GenshinWeaponController extends BaseController
{
    private String prefix = "system/weapon";

    @Autowired
    private IGenshinWeaponService genshinWeaponService;

    @RequiresPermissions("system:weapon:view")
    @GetMapping()
    public String weapon()
    {
        return prefix + "/weapon";
    }

    /**
     * 查询原神武器信息列表
     */
    @RequiresPermissions("system:weapon:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(GenshinWeapon genshinWeapon)
    {
        startPage();
        List<GenshinWeapon> list = genshinWeaponService.selectGenshinWeaponList(genshinWeapon);
        return getDataTable(list);
    }

    /**
     * 导出原神武器信息列表
     */
    @RequiresPermissions("system:weapon:export")
    @Log(title = "原神武器信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(GenshinWeapon genshinWeapon)
    {
        List<GenshinWeapon> list = genshinWeaponService.selectGenshinWeaponList(genshinWeapon);
        ExcelUtil<GenshinWeapon> util = new ExcelUtil<GenshinWeapon>(GenshinWeapon.class);
        return util.exportExcel(list, "原神武器信息数据");
    }

    /**
     * 新增原神武器信息
     */
    @RequiresPermissions("system:weapon:add")
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存原神武器信息
     */
    @RequiresPermissions("system:weapon:add")
    @Log(title = "原神武器信息", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(GenshinWeapon genshinWeapon)
    {
        return toAjax(genshinWeaponService.insertGenshinWeapon(genshinWeapon));
    }

    /**
     * 修改原神武器信息
     */
    @RequiresPermissions("system:weapon:edit")
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        GenshinWeapon genshinWeapon = genshinWeaponService.selectGenshinWeaponById(id);
        mmap.put("genshinWeapon", genshinWeapon);
        return prefix + "/edit";
    }

    /**
     * 修改保存原神武器信息
     */
    @RequiresPermissions("system:weapon:edit")
    @Log(title = "原神武器信息", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(GenshinWeapon genshinWeapon)
    {
        return toAjax(genshinWeaponService.updateGenshinWeapon(genshinWeapon));
    }

    /**
     * 删除原神武器信息
     */
    @RequiresPermissions("system:weapon:remove")
    @Log(title = "原神武器信息", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(genshinWeaponService.deleteGenshinWeaponByIds(ids));
    }
}
