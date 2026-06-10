package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.GenshinEnemy;

/**
 * 原神怪物信息Mapper接口
 * 
 * @author ruoyi
 * @date 2026-05-29
 */
public interface GenshinEnemyMapper 
{
    /**
     * 查询原神怪物信息
     * 
     * @param id 原神怪物信息主键
     * @return 原神怪物信息
     */
    public GenshinEnemy selectGenshinEnemyById(Long id);

    /**
     * 查询原神怪物信息列表
     * 
     * @param genshinEnemy 原神怪物信息
     * @return 原神怪物信息集合
     */
    public List<GenshinEnemy> selectGenshinEnemyList(GenshinEnemy genshinEnemy);

    /**
     * 新增原神怪物信息
     * 
     * @param genshinEnemy 原神怪物信息
     * @return 结果
     */
    public int insertGenshinEnemy(GenshinEnemy genshinEnemy);

    /**
     * 修改原神怪物信息
     * 
     * @param genshinEnemy 原神怪物信息
     * @return 结果
     */
    public int updateGenshinEnemy(GenshinEnemy genshinEnemy);

    /**
     * 删除原神怪物信息
     * 
     * @param id 原神怪物信息主键
     * @return 结果
     */
    public int deleteGenshinEnemyById(Long id);

    /**
     * 批量删除原神怪物信息
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteGenshinEnemyByIds(String[] ids);
}
