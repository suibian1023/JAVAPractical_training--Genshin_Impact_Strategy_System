package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.GenshinWeapon;

/**
 * 原神武器信息Mapper接口
 * 
 * @author ruoyi
 * @date 2026-06-05
 */
public interface GenshinWeaponMapper 
{
    /**
     * 查询原神武器信息
     * 
     * @param id 原神武器信息主键
     * @return 原神武器信息
     */
    public GenshinWeapon selectGenshinWeaponById(Long id);

    /**
     * 查询原神武器信息列表
     * 
     * @param genshinWeapon 原神武器信息
     * @return 原神武器信息集合
     */
    public List<GenshinWeapon> selectGenshinWeaponList(GenshinWeapon genshinWeapon);

    /**
     * 新增原神武器信息
     * 
     * @param genshinWeapon 原神武器信息
     * @return 结果
     */
    public int insertGenshinWeapon(GenshinWeapon genshinWeapon);

    /**
     * 修改原神武器信息
     * 
     * @param genshinWeapon 原神武器信息
     * @return 结果
     */
    public int updateGenshinWeapon(GenshinWeapon genshinWeapon);

    /**
     * 删除原神武器信息
     * 
     * @param id 原神武器信息主键
     * @return 结果
     */
    public int deleteGenshinWeaponById(Long id);

    /**
     * 批量删除原神武器信息
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteGenshinWeaponByIds(String[] ids);
}
