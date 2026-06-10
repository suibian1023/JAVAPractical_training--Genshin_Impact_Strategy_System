package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.GenshinRecommendWeapon;

/**
 * 【请填写功能名称】Mapper接口
 * 
 * @author ruoyi
 * @date 2026-05-29
 */
public interface GenshinRecommendWeaponMapper 
{
    /**
     * 查询【请填写功能名称】
     * 
     * @param id 【请填写功能名称】主键
     * @return 【请填写功能名称】
     */
    public GenshinRecommendWeapon selectGenshinRecommendWeaponById(Long id);

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param genshinRecommendWeapon 【请填写功能名称】
     * @return 【请填写功能名称】集合
     */
    public List<GenshinRecommendWeapon> selectGenshinRecommendWeaponList(GenshinRecommendWeapon genshinRecommendWeapon);

    /**
     * 新增【请填写功能名称】
     * 
     * @param genshinRecommendWeapon 【请填写功能名称】
     * @return 结果
     */
    public int insertGenshinRecommendWeapon(GenshinRecommendWeapon genshinRecommendWeapon);

    /**
     * 修改【请填写功能名称】
     * 
     * @param genshinRecommendWeapon 【请填写功能名称】
     * @return 结果
     */
    public int updateGenshinRecommendWeapon(GenshinRecommendWeapon genshinRecommendWeapon);

    /**
     * 删除【请填写功能名称】
     * 
     * @param id 【请填写功能名称】主键
     * @return 结果
     */
    public int deleteGenshinRecommendWeaponById(Long id);

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteGenshinRecommendWeaponByIds(String[] ids);
}
