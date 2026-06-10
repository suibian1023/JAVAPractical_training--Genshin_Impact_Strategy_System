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
import com.ruoyi.system.domain.GenshinRecommendTeam;
import com.ruoyi.system.domain.GenshinCharacter;
import com.ruoyi.system.service.IGenshinRecommendTeamService;
import com.ruoyi.system.service.IGenshinCharacterService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 配队推荐Controller
 * 
 * @author ruoyi
 * @date 2026-05-29
 */
@Controller
@RequestMapping("/system/team")
public class GenshinRecommendTeamController extends BaseController
{
    private String prefix = "system/team";

    @Autowired
    private IGenshinRecommendTeamService genshinRecommendTeamService;

    @Autowired
    private IGenshinCharacterService genshinCharacterService;

    @RequiresPermissions("system:team:view")
    @GetMapping()
    public String team(ModelMap mmap)
    {
        // 查询所有角色列表用于下拉选择
        List<GenshinCharacter> characterList = genshinCharacterService.selectGenshinCharacterList(new GenshinCharacter());
        mmap.put("characterList", characterList);
        return prefix + "/team";
    }

    /**
     * 查询配队推荐列表
     */
    @RequiresPermissions("system:team:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(GenshinRecommendTeam genshinRecommendTeam)
    {
        startPage();
        List<GenshinRecommendTeam> list = genshinRecommendTeamService.selectGenshinRecommendTeamList(genshinRecommendTeam);
        return getDataTable(list);
    }

    /**
     * 导出配队推荐列表
     */
    @RequiresPermissions("system:team:export")
    @Log(title = "配队推荐", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(GenshinRecommendTeam genshinRecommendTeam)
    {
        List<GenshinRecommendTeam> list = genshinRecommendTeamService.selectGenshinRecommendTeamList(genshinRecommendTeam);
        ExcelUtil<GenshinRecommendTeam> util = new ExcelUtil<GenshinRecommendTeam>(GenshinRecommendTeam.class);
        return util.exportExcel(list, "配队推荐数据");
    }

    /**
     * 新增配队推荐
     */
    @RequiresPermissions("system:team:add")
    @GetMapping("/add")
    public String add(ModelMap mmap)
    {
        // 查询所有角色列表用于下拉选择
        List<GenshinCharacter> characterList = genshinCharacterService.selectGenshinCharacterList(new GenshinCharacter());
        mmap.put("characterList", characterList);
        return prefix + "/add";
    }

    /**
     * 新增保存配队推荐
     */
    @RequiresPermissions("system:team:add")
    @Log(title = "配队推荐", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(GenshinRecommendTeam genshinRecommendTeam)
    {
        return toAjax(genshinRecommendTeamService.insertGenshinRecommendTeam(genshinRecommendTeam));
    }

    /**
     * 修改配队推荐
     */
    @RequiresPermissions("system:team:edit")
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        GenshinRecommendTeam genshinRecommendTeam = genshinRecommendTeamService.selectGenshinRecommendTeamById(id);
        mmap.put("genshinRecommendTeam", genshinRecommendTeam);
        // 查询所有角色列表用于下拉选择
        List<GenshinCharacter> characterList = genshinCharacterService.selectGenshinCharacterList(new GenshinCharacter());
        mmap.put("characterList", characterList);
        return prefix + "/edit";
    }

    /**
     * 修改保存配队推荐
     */
    @RequiresPermissions("system:team:edit")
    @Log(title = "配队推荐", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(GenshinRecommendTeam genshinRecommendTeam)
    {
        return toAjax(genshinRecommendTeamService.updateGenshinRecommendTeam(genshinRecommendTeam));
    }

    /**
     * 删除配队推荐
     */
    @RequiresPermissions("system:team:remove")
    @Log(title = "配队推荐", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(genshinRecommendTeamService.deleteGenshinRecommendTeamByIds(ids));
    }
}
