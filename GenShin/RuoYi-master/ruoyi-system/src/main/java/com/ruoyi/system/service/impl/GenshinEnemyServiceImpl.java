package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.GenshinEnemyMapper;
import com.ruoyi.system.domain.GenshinEnemy;
import com.ruoyi.system.service.IGenshinEnemyService;
import com.ruoyi.common.core.text.Convert;

/**
 * 原神怪物信息Service业务层处理
 * 
 * @author ruoyi
 * @date 2026-05-29
 */
@Service
public class GenshinEnemyServiceImpl implements IGenshinEnemyService 
{
    @Autowired
    private GenshinEnemyMapper genshinEnemyMapper;

    /**
     * 查询原神怪物信息
     * 
     * @param id 原神怪物信息主键
     * @return 原神怪物信息
     */
    @Override
    public GenshinEnemy selectGenshinEnemyById(Long id)
    {
        return genshinEnemyMapper.selectGenshinEnemyById(id);
    }

    /**
     * 查询原神怪物信息列表
     * 
     * @param genshinEnemy 原神怪物信息
     * @return 原神怪物信息
     */
    @Override
    public List<GenshinEnemy> selectGenshinEnemyList(GenshinEnemy genshinEnemy)
    {
        return genshinEnemyMapper.selectGenshinEnemyList(genshinEnemy);
    }

    /**
     * 新增原神怪物信息
     * 
     * @param genshinEnemy 原神怪物信息
     * @return 结果
     */
    @Override
    public int insertGenshinEnemy(GenshinEnemy genshinEnemy)
    {
        return genshinEnemyMapper.insertGenshinEnemy(genshinEnemy);
    }

    /**
     * 修改原神怪物信息
     * 
     * @param genshinEnemy 原神怪物信息
     * @return 结果
     */
    @Override
    public int updateGenshinEnemy(GenshinEnemy genshinEnemy)
    {
        return genshinEnemyMapper.updateGenshinEnemy(genshinEnemy);
    }

    /**
     * 批量删除原神怪物信息
     * 
     * @param ids 需要删除的原神怪物信息主键
     * @return 结果
     */
    @Override
    public int deleteGenshinEnemyByIds(String ids)
    {
        return genshinEnemyMapper.deleteGenshinEnemyByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除原神怪物信息信息
     * 
     * @param id 原神怪物信息主键
     * @return 结果
     */
    @Override
    public int deleteGenshinEnemyById(Long id)
    {
        return genshinEnemyMapper.deleteGenshinEnemyById(id);
    }
}
