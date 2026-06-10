package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.GenshinEnemyInvestigationMapper;
import com.ruoyi.system.domain.GenshinEnemyInvestigation;
import com.ruoyi.system.service.IGenshinEnemyInvestigationService;
import com.ruoyi.common.core.text.Convert;

/**
 * 原神怪物调查信息Service业务层处理
 * 
 * @author ruoyi
 * @date 2026-05-29
 */
@Service
public class GenshinEnemyInvestigationServiceImpl implements IGenshinEnemyInvestigationService 
{
    @Autowired
    private GenshinEnemyInvestigationMapper genshinEnemyInvestigationMapper;

    /**
     * 查询原神怪物调查信息
     * 
     * @param id 原神怪物调查信息主键
     * @return 原神怪物调查信息
     */
    @Override
    public GenshinEnemyInvestigation selectGenshinEnemyInvestigationById(Long id)
    {
        return genshinEnemyInvestigationMapper.selectGenshinEnemyInvestigationById(id);
    }

    /**
     * 查询原神怪物调查信息列表
     * 
     * @param genshinEnemyInvestigation 原神怪物调查信息
     * @return 原神怪物调查信息
     */
    @Override
    public List<GenshinEnemyInvestigation> selectGenshinEnemyInvestigationList(GenshinEnemyInvestigation genshinEnemyInvestigation)
    {
        return genshinEnemyInvestigationMapper.selectGenshinEnemyInvestigationList(genshinEnemyInvestigation);
    }

    /**
     * 新增原神怪物调查信息
     * 
     * @param genshinEnemyInvestigation 原神怪物调查信息
     * @return 结果
     */
    @Override
    public int insertGenshinEnemyInvestigation(GenshinEnemyInvestigation genshinEnemyInvestigation)
    {
        return genshinEnemyInvestigationMapper.insertGenshinEnemyInvestigation(genshinEnemyInvestigation);
    }

    /**
     * 修改原神怪物调查信息
     * 
     * @param genshinEnemyInvestigation 原神怪物调查信息
     * @return 结果
     */
    @Override
    public int updateGenshinEnemyInvestigation(GenshinEnemyInvestigation genshinEnemyInvestigation)
    {
        return genshinEnemyInvestigationMapper.updateGenshinEnemyInvestigation(genshinEnemyInvestigation);
    }

    /**
     * 批量删除原神怪物调查信息
     * 
     * @param ids 需要删除的原神怪物调查信息主键
     * @return 结果
     */
    @Override
    public int deleteGenshinEnemyInvestigationByIds(String ids)
    {
        return genshinEnemyInvestigationMapper.deleteGenshinEnemyInvestigationByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除原神怪物调查信息信息
     * 
     * @param id 原神怪物调查信息主键
     * @return 结果
     */
    @Override
    public int deleteGenshinEnemyInvestigationById(Long id)
    {
        return genshinEnemyInvestigationMapper.deleteGenshinEnemyInvestigationById(id);
    }
}
