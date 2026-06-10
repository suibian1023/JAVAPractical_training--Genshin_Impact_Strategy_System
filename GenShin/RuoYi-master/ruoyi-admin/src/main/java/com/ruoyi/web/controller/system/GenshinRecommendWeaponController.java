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
import com.ruoyi.system.domain.GenshinRecommendWeapon;
import com.ruoyi.system.domain.GenshinCharacter;
import com.ruoyi.system.domain.GenshinWeapon;
import com.ruoyi.system.service.IGenshinRecommendWeaponService;
import com.ruoyi.system.service.IGenshinCharacterService;
import com.ruoyi.system.service.IGenshinWeaponService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 角色推荐武器管理Controller
 * 
 * @author ruoyi
 * @date 2026-05-29
 */
@Controller
@RequestMapping("/system/recommendWeapon")
public class GenshinRecommendWeaponController extends BaseController
{
    private String prefix = "system/recommendWeapon";

    @Autowired
    private IGenshinRecommendWeaponService genshinRecommendWeaponService;

    @Autowired
    private IGenshinCharacterService genshinCharacterService;

    @Autowired
    private IGenshinWeaponService genshinWeaponService;

    @RequiresPermissions("system:recommendWeapon:view")
    @GetMapping()
    public String weapon(ModelMap mmap)
    {
        // 查询所有角色列表用于下拉选择
        List<GenshinCharacter> characterList = genshinCharacterService.selectGenshinCharacterList(new GenshinCharacter());
        mmap.put("characterList", characterList);
        // 查询所有武器列表用于下拉选择
        List<GenshinWeapon> weaponList = genshinWeaponService.selectGenshinWeaponList(new GenshinWeapon());
        mmap.put("weaponList", weaponList);
        return prefix + "/weapon";
    }

    /**
     * 查询推荐武器列表
     */
    @RequiresPermissions("system:recommendWeapon:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(GenshinRecommendWeapon genshinRecommendWeapon)
    {
        startPage();
        List<GenshinRecommendWeapon> list = genshinRecommendWeaponService.selectGenshinRecommendWeaponList(genshinRecommendWeapon);
        return getDataTable(list);
    }

    /**
     * 导出推荐武器列表
     */
    @RequiresPermissions("system:recommendWeapon:export")
    @Log(title = "推荐武器", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(GenshinRecommendWeapon genshinRecommendWeapon)
    {
        List<GenshinRecommendWeapon> list = genshinRecommendWeaponService.selectGenshinRecommendWeaponList(genshinRecommendWeapon);
        ExcelUtil<GenshinRecommendWeapon> util = new ExcelUtil<GenshinRecommendWeapon>(GenshinRecommendWeapon.class);
        return util.exportExcel(list, "推荐武器数据");
    }

    /**
     * 新增推荐武器
     */
    @RequiresPermissions("system:recommendWeapon:add")
    @GetMapping("/add")
    public String add(ModelMap mmap)
    {
        // 查询所有角色列表用于下拉选择
        List<GenshinCharacter> characterList = genshinCharacterService.selectGenshinCharacterList(new GenshinCharacter());
        mmap.put("characterList", characterList);
        // 查询所有武器列表用于下拉选择
        List<GenshinWeapon> weaponList = genshinWeaponService.selectGenshinWeaponList(new GenshinWeapon());
        mmap.put("weaponList", weaponList);
        return prefix + "/add";
    }

    /**
     * 新增保存推荐武器
     */
    @RequiresPermissions("system:recommendWeapon:add")
    @Log(title = "推荐武器", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(GenshinRecommendWeapon genshinRecommendWeapon)
    {
        return toAjax(genshinRecommendWeaponService.insertGenshinRecommendWeapon(genshinRecommendWeapon));
    }

    /**
     * 修改推荐武器
     */
    @RequiresPermissions("system:recommendWeapon:edit")
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        GenshinRecommendWeapon genshinRecommendWeapon = genshinRecommendWeaponService.selectGenshinRecommendWeaponById(id);
        mmap.put("genshinRecommendWeapon", genshinRecommendWeapon);
        // 查询所有角色列表用于下拉选择
        List<GenshinCharacter> characterList = genshinCharacterService.selectGenshinCharacterList(new GenshinCharacter());
        mmap.put("characterList", characterList);
        // 查询所有武器列表用于下拉选择
        List<GenshinWeapon> weaponList = genshinWeaponService.selectGenshinWeaponList(new GenshinWeapon());
        mmap.put("weaponList", weaponList);
        return prefix + "/edit";
    }

    /**
     * 修改保存推荐武器
     */
    @RequiresPermissions("system:recommendWeapon:edit")
    @Log(title = "推荐武器", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(GenshinRecommendWeapon genshinRecommendWeapon)
    {
        return toAjax(genshinRecommendWeaponService.updateGenshinRecommendWeapon(genshinRecommendWeapon));
    }

    /**
     * 删除推荐武器
     */
    @RequiresPermissions("system:recommendWeapon:remove")
    @Log(title = "推荐武器", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(genshinRecommendWeaponService.deleteGenshinRecommendWeaponByIds(ids));
    }
}
