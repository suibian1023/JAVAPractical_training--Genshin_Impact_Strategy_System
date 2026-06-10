package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.GenshinEnemyInvestigation;

/**
 * 原神怪物调查信息Mapper接口
 * 
 * @author ruoyi
 * @date 2026-05-29
 */
public interface GenshinEnemyInvestigationMapper 
{
    /**
     * 查询原神怪物调查信息
     * 
     * @param id 原神怪物调查信息主键
     * @return 原神怪物调查信息
     */
    public GenshinEnemyInvestigation selectGenshinEnemyInvestigationById(Long id);

    /**
     * 查询原神怪物调查信息列表
     * 
     * @param genshinEnemyInvestigation 原神怪物调查信息
     * @return 原神怪物调查信息集合
     */
    public List<GenshinEnemyInvestigation> selectGenshinEnemyInvestigationList(GenshinEnemyInvestigation genshinEnemyInvestigation);

    /**
     * 新增原神怪物调查信息
     * 
     * @param genshinEnemyInvestigation 原神怪物调查信息
     * @return 结果
     */
    public int insertGenshinEnemyInvestigation(GenshinEnemyInvestigation genshinEnemyInvestigation);

    /**
     * 修改原神怪物调查信息
     * 
     * @param genshinEnemyInvestigation 原神怪物调查信息
     * @return 结果
     */
    public int updateGenshinEnemyInvestigation(GenshinEnemyInvestigation genshinEnemyInvestigation);

    /**
     * 删除原神怪物调查信息
     * 
     * @param id 原神怪物调查信息主键
     * @return 结果
     */
    public int deleteGenshinEnemyInvestigationById(Long id);

    /**
     * 批量删除原神怪物调查信息
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteGenshinEnemyInvestigationByIds(String[] ids);
}
