package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.TalentCosts;

/**
 * 天赋升级材料Service接口
 * 
 * @author ruoyi
 * @date 2026-05-29
 */
public interface ITalentCostsService 
{
    /**
     * 查询天赋升级材料
     * 
     * @param id 天赋升级材料主键
     * @return 天赋升级材料
     */
    public TalentCosts selectTalentCostsById(Long id);

    /**
     * 查询天赋升级材料列表
     * 
     * @param talentCosts 天赋升级材料
     * @return 天赋升级材料集合
     */
    public List<TalentCosts> selectTalentCostsList(TalentCosts talentCosts);

    /**
     * 新增天赋升级材料
     * 
     * @param talentCosts 天赋升级材料
     * @return 结果
     */
    public int insertTalentCosts(TalentCosts talentCosts);

    /**
     * 修改天赋升级材料
     * 
     * @param talentCosts 天赋升级材料
     * @return 结果
     */
    public int updateTalentCosts(TalentCosts talentCosts);

    /**
     * 批量删除天赋升级材料
     * 
     * @param ids 需要删除的天赋升级材料主键集合
     * @return 结果
     */
    public int deleteTalentCostsByIds(String ids);

    /**
     * 删除天赋升级材料信息
     * 
     * @param id 天赋升级材料主键
     * @return 结果
     */
    public int deleteTalentCostsById(Long id);
}
