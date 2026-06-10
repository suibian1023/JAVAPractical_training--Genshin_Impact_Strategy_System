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
import com.ruoyi.system.domain.GenshinUserFavorite;
import com.ruoyi.system.service.IGenshinUserFavoriteService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 原神用户收藏Controller
 * 
 * @author ruoyi
 * @date 2026-05-29
 */
@Controller
@RequestMapping("/system/favorite")
public class GenshinUserFavoriteController extends BaseController
{
    private String prefix = "system/favorite";

    @Autowired
    private IGenshinUserFavoriteService genshinUserFavoriteService;

    @RequiresPermissions("system:favorite:view")
    @GetMapping()
    public String favorite()
    {
        return prefix + "/favorite";
    }

    /**
     * 查询【请填写功能名称】列表
     */
    @RequiresPermissions("system:favorite:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(GenshinUserFavorite genshinUserFavorite)
    {
        startPage();
        List<GenshinUserFavorite> list = genshinUserFavoriteService.selectGenshinUserFavoriteList(genshinUserFavorite);
        return getDataTable(list);
    }

    /**
     * 导出【请填写功能名称】列表
     */
    @RequiresPermissions("system:favorite:export")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(GenshinUserFavorite genshinUserFavorite)
    {
        List<GenshinUserFavorite> list = genshinUserFavoriteService.selectGenshinUserFavoriteList(genshinUserFavorite);
        ExcelUtil<GenshinUserFavorite> util = new ExcelUtil<GenshinUserFavorite>(GenshinUserFavorite.class);
        return util.exportExcel(list, "【请填写功能名称】数据");
    }

    /**
     * 新增【请填写功能名称】
     */
    @RequiresPermissions("system:favorite:add")
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存【请填写功能名称】
     */
    @RequiresPermissions("system:favorite:add")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(GenshinUserFavorite genshinUserFavorite)
    {
        return toAjax(genshinUserFavoriteService.insertGenshinUserFavorite(genshinUserFavorite));
    }

    /**
     * 修改【请填写功能名称】
     */
    @RequiresPermissions("system:favorite:edit")
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        GenshinUserFavorite genshinUserFavorite = genshinUserFavoriteService.selectGenshinUserFavoriteById(id);
        mmap.put("genshinUserFavorite", genshinUserFavorite);
        return prefix + "/edit";
    }

    /**
     * 修改保存【请填写功能名称】
     */
    @RequiresPermissions("system:favorite:edit")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(GenshinUserFavorite genshinUserFavorite)
    {
        return toAjax(genshinUserFavoriteService.updateGenshinUserFavorite(genshinUserFavorite));
    }

    /**
     * 删除【请填写功能名称】
     */
    @RequiresPermissions("system:favorite:remove")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(genshinUserFavoriteService.deleteGenshinUserFavoriteByIds(ids));
    }
}
