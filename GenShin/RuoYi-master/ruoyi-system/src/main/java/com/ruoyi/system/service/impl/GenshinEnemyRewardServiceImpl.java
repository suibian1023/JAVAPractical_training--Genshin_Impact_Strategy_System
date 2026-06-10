package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.GenshinEnemyRewardMapper;
import com.ruoyi.system.domain.GenshinEnemyReward;
import com.ruoyi.system.service.IGenshinEnemyRewardService;
import com.ruoyi.common.core.text.Convert;

/**
 * 原神怪物掉落奖励Service业务层处理
 * 
 * @author ruoyi
 * @date 2026-05-29
 */
@Service
public class GenshinEnemyRewardServiceImpl implements IGenshinEnemyRewardService 
{
    @Autowired
    private GenshinEnemyRewardMapper genshinEnemyRewardMapper;

    /**
     * 查询原神怪物掉落奖励
     * 
     * @param id 原神怪物掉落奖励主键
     * @return 原神怪物掉落奖励
     */
    @Override
    public GenshinEnemyReward selectGenshinEnemyRewardById(Long id)
    {
        return genshinEnemyRewardMapper.selectGenshinEnemyRewardById(id);
    }

    /**
     * 查询原神怪物掉落奖励列表
     * 
     * @param genshinEnemyReward 原神怪物掉落奖励
     * @return 原神怪物掉落奖励
     */
    @Override
    public List<GenshinEnemyReward> selectGenshinEnemyRewardList(GenshinEnemyReward genshinEnemyReward)
    {
        return genshinEnemyRewardMapper.selectGenshinEnemyRewardList(genshinEnemyReward);
    }

    /**
     * 新增原神怪物掉落奖励
     * 
     * @param genshinEnemyReward 原神怪物掉落奖励
     * @return 结果
     */
    @Override
    public int insertGenshinEnemyReward(GenshinEnemyReward genshinEnemyReward)
    {
        return genshinEnemyRewardMapper.insertGenshinEnemyReward(genshinEnemyReward);
    }

    /**
     * 修改原神怪物掉落奖励
     * 
     * @param genshinEnemyReward 原神怪物掉落奖励
     * @return 结果
     */
    @Override
    public int updateGenshinEnemyReward(GenshinEnemyReward genshinEnemyReward)
    {
        return genshinEnemyRewardMapper.updateGenshinEnemyReward(genshinEnemyReward);
    }

    /**
     * 批量删除原神怪物掉落奖励
     * 
     * @param ids 需要删除的原神怪物掉落奖励主键
     * @return 结果
     */
    @Override
    public int deleteGenshinEnemyRewardByIds(String ids)
    {
        return genshinEnemyRewardMapper.deleteGenshinEnemyRewardByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除原神怪物掉落奖励信息
     * 
     * @param id 原神怪物掉落奖励主键
     * @return 结果
     */
    @Override
    public int deleteGenshinEnemyRewardById(Long id)
    {
        return genshinEnemyRewardMapper.deleteGenshinEnemyRewardById(id);
    }
}
