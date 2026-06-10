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
import com.ruoyi.system.domain.GenshinDomain;
import com.ruoyi.system.service.IGenshinDomainService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 原神秘境信息Controller
 * 
 * @author ruoyi
 * @date 2026-05-29
 */
@Controller
@RequestMapping("/system/domain")
public class GenshinDomainController extends BaseController
{
    private String prefix = "system/domain";

    @Autowired
    private IGenshinDomainService genshinDomainService;

    @RequiresPermissions("system:domain:view")
    @GetMapping()
    public String domain()
    {
        return prefix + "/domain";
    }

    /**
     * 查询原神秘境信息列表
     */
    @RequiresPermissions("system:domain:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(GenshinDomain genshinDomain)
    {
        startPage();
        List<GenshinDomain> list = genshinDomainService.selectGenshinDomainList(genshinDomain);
        return getDataTable(list);
    }

    /**
     * 导出原神秘境信息列表
     */
    @RequiresPermissions("system:domain:export")
    @Log(title = "原神秘境信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(GenshinDomain genshinDomain)
    {
        List<GenshinDomain> list = genshinDomainService.selectGenshinDomainList(genshinDomain);
        ExcelUtil<GenshinDomain> util = new ExcelUtil<GenshinDomain>(GenshinDomain.class);
        return util.exportExcel(list, "原神秘境信息数据");
    }

    /**
     * 新增原神秘境信息
     */
    @RequiresPermissions("system:domain:add")
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存原神秘境信息
     */
    @RequiresPermissions("system:domain:add")
    @Log(title = "原神秘境信息", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(GenshinDomain genshinDomain)
    {
        return toAjax(genshinDomainService.insertGenshinDomain(genshinDomain));
    }

    /**
     * 修改原神秘境信息
     */
    @RequiresPermissions("system:domain:edit")
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        GenshinDomain genshinDomain = genshinDomainService.selectGenshinDomainById(id);
        mmap.put("genshinDomain", genshinDomain);
        return prefix + "/edit";
    }

    /**
     * 修改保存原神秘境信息
     */
    @RequiresPermissions("system:domain:edit")
    @Log(title = "原神秘境信息", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(GenshinDomain genshinDomain)
    {
        return toAjax(genshinDomainService.updateGenshinDomain(genshinDomain));
    }

    /**
     * 删除原神秘境信息
     */
    @RequiresPermissions("system:domain:remove")
    @Log(title = "原神秘境信息", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(genshinDomainService.deleteGenshinDomainByIds(ids));
    }
}
