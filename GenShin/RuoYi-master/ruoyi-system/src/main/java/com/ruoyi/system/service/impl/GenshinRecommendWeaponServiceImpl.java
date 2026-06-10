package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.GenshinRecommendWeaponMapper;
import com.ruoyi.system.domain.GenshinRecommendWeapon;
import com.ruoyi.system.service.IGenshinRecommendWeaponService;
import com.ruoyi.common.core.text.Convert;

/**
 * 【请填写功能名称】Service业务层处理
 * 
 * @author ruoyi
 * @date 2026-05-29
 */
@Service
public class GenshinRecommendWeaponServiceImpl implements IGenshinRecommendWeaponService 
{
    @Autowired
    private GenshinRecommendWeaponMapper genshinRecommendWeaponMapper;

    /**
     * 查询【请填写功能名称】
     * 
     * @param id 【请填写功能名称】主键
     * @return 【请填写功能名称】
     */
    @Override
    public GenshinRecommendWeapon selectGenshinRecommendWeaponById(Long id)
    {
        return genshinRecommendWeaponMapper.selectGenshinRecommendWeaponById(id);
    }

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param genshinRecommendWeapon 【请填写功能名称】
     * @return 【请填写功能名称】
     */
    @Override
    public List<GenshinRecommendWeapon> selectGenshinRecommendWeaponList(GenshinRecommendWeapon genshinRecommendWeapon)
    {
        return genshinRecommendWeaponMapper.selectGenshinRecommendWeaponList(genshinRecommendWeapon);
    }

    /**
     * 新增【请填写功能名称】
     * 
     * @param genshinRecommendWeapon 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int insertGenshinRecommendWeapon(GenshinRecommendWeapon genshinRecommendWeapon)
    {
        return genshinRecommendWeaponMapper.insertGenshinRecommendWeapon(genshinRecommendWeapon);
    }

    /**
     * 修改【请填写功能名称】
     * 
     * @param genshinRecommendWeapon 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int updateGenshinRecommendWeapon(GenshinRecommendWeapon genshinRecommendWeapon)
    {
        return genshinRecommendWeaponMapper.updateGenshinRecommendWeapon(genshinRecommendWeapon);
    }

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param ids 需要删除的【请填写功能名称】主键
     * @return 结果
     */
    @Override
    public int deleteGenshinRecommendWeaponByIds(String ids)
    {
        return genshinRecommendWeaponMapper.deleteGenshinRecommendWeaponByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除【请填写功能名称】信息
     * 
     * @param id 【请填写功能名称】主键
     * @return 结果
     */
    @Override
    public int deleteGenshinRecommendWeaponById(Long id)
    {
        return genshinRecommendWeaponMapper.deleteGenshinRecommendWeaponById(id);
    }
}
