package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.GenshinEnemyReward;

/**
 * 原神怪物掉落奖励Mapper接口
 * 
 * @author ruoyi
 * @date 2026-05-29
 */
public interface GenshinEnemyRewardMapper 
{
    /**
     * 查询原神怪物掉落奖励
     * 
     * @param id 原神怪物掉落奖励主键
     * @return 原神怪物掉落奖励
     */
    public GenshinEnemyReward selectGenshinEnemyRewardById(Long id);

    /**
     * 查询原神怪物掉落奖励列表
     * 
     * @param genshinEnemyReward 原神怪物掉落奖励
     * @return 原神怪物掉落奖励集合
     */
    public List<GenshinEnemyReward> selectGenshinEnemyRewardList(GenshinEnemyReward genshinEnemyReward);

    /**
     * 新增原神怪物掉落奖励
     * 
     * @param genshinEnemyReward 原神怪物掉落奖励
     * @return 结果
     */
    public int insertGenshinEnemyReward(GenshinEnemyReward genshinEnemyReward);

    /**
     * 修改原神怪物掉落奖励
     * 
     * @param genshinEnemyReward 原神怪物掉落奖励
     * @return 结果
     */
    public int updateGenshinEnemyReward(GenshinEnemyReward genshinEnemyReward);

    /**
     * 删除原神怪物掉落奖励
     * 
     * @param id 原神怪物掉落奖励主键
     * @return 结果
     */
    public int deleteGenshinEnemyRewardById(Long id);

    /**
     * 批量删除原神怪物掉落奖励
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteGenshinEnemyRewardByIds(String[] ids);
}
