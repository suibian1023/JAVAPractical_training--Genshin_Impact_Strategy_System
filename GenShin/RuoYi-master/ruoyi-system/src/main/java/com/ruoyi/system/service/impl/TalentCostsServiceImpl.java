package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.TalentCostsMapper;
import com.ruoyi.system.domain.TalentCosts;
import com.ruoyi.system.service.ITalentCostsService;
import com.ruoyi.common.core.text.Convert;

/**
 * 天赋升级材料Service业务层处理
 * 
 * @author ruoyi
 * @date 2026-05-29
 */
@Service
public class TalentCostsServiceImpl implements ITalentCostsService 
{
    @Autowired
    private TalentCostsMapper talentCostsMapper;

    /**
     * 查询天赋升级材料
     * 
     * @param id 天赋升级材料主键
     * @return 天赋升级材料
     */
    @Override
    public TalentCosts selectTalentCostsById(Long id)
    {
        return talentCostsMapper.selectTalentCostsById(id);
    }

    /**
     * 查询天赋升级材料列表
     * 
     * @param talentCosts 天赋升级材料
     * @return 天赋升级材料
     */
    @Override
    public List<TalentCosts> selectTalentCostsList(TalentCosts talentCosts)
    {
        return talentCostsMapper.selectTalentCostsList(talentCosts);
    }

    /**
     * 新增天赋升级材料
     * 
     * @param talentCosts 天赋升级材料
     * @return 结果
     */
    @Override
    public int insertTalentCosts(TalentCosts talentCosts)
    {
        return talentCostsMapper.insertTalentCosts(talentCosts);
    }

    /**
     * 修改天赋升级材料
     * 
     * @param talentCosts 天赋升级材料
     * @return 结果
     */
    @Override
    public int updateTalentCosts(TalentCosts talentCosts)
    {
        return talentCostsMapper.updateTalentCosts(talentCosts);
    }

    /**
     * 批量删除天赋升级材料
     * 
     * @param ids 需要删除的天赋升级材料主键
     * @return 结果
     */
    @Override
    public int deleteTalentCostsByIds(String ids)
    {
        return talentCostsMapper.deleteTalentCostsByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除天赋升级材料信息
     * 
     * @param id 天赋升级材料主键
     * @return 结果
     */
    @Override
    public int deleteTalentCostsById(Long id)
    {
        return talentCostsMapper.deleteTalentCostsById(id);
    }
}
