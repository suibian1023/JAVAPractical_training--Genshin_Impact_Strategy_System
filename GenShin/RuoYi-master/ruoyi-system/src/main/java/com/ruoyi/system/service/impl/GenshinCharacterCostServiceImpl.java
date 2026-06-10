package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.GenshinCharacterCostMapper;
import com.ruoyi.system.domain.GenshinCharacterCost;
import com.ruoyi.system.service.IGenshinCharacterCostService;

/**
 * 角色突破材料Service业务层处理
 * 
 * @author ruoyi
 */
@Service
public class GenshinCharacterCostServiceImpl implements IGenshinCharacterCostService
{
    @Autowired
    private GenshinCharacterCostMapper genshinCharacterCostMapper;

    @Override
    public GenshinCharacterCost selectGenshinCharacterCostById(Long id)
    {
        return genshinCharacterCostMapper.selectGenshinCharacterCostById(id);
    }

    @Override
    public List<GenshinCharacterCost> selectGenshinCharacterCostList(GenshinCharacterCost genshinCharacterCost)
    {
        return genshinCharacterCostMapper.selectGenshinCharacterCostList(genshinCharacterCost);
    }

    @Override
    public int insertGenshinCharacterCost(GenshinCharacterCost genshinCharacterCost)
    {
        return genshinCharacterCostMapper.insertGenshinCharacterCost(genshinCharacterCost);
    }

    @Override
    public int updateGenshinCharacterCost(GenshinCharacterCost genshinCharacterCost)
    {
        return genshinCharacterCostMapper.updateGenshinCharacterCost(genshinCharacterCost);
    }

    @Override
    public int deleteGenshinCharacterCostByIds(String ids)
    {
        return genshinCharacterCostMapper.deleteGenshinCharacterCostByIds(ids.split(","));
    }

    @Override
    public int deleteGenshinCharacterCostById(Long id)
    {
        return genshinCharacterCostMapper.deleteGenshinCharacterCostById(id);
    }
}
