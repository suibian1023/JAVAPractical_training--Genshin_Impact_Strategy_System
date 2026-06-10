package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.GenshinWeaponMapper;
import com.ruoyi.system.domain.GenshinWeapon;
import com.ruoyi.system.service.IGenshinWeaponService;
import com.ruoyi.common.core.text.Convert;

/**
 * 原神武器信息Service业务层处理
 * 
 * @author ruoyi
 * @date 2026-06-05
 */
@Service
public class GenshinWeaponServiceImpl implements IGenshinWeaponService 
{
    @Autowired
    private GenshinWeaponMapper genshinWeaponMapper;

    /**
     * 查询原神武器信息
     * 
     * @param id 原神武器信息主键
     * @return 原神武器信息
     */
    @Override
    public GenshinWeapon selectGenshinWeaponById(Long id)
    {
        return genshinWeaponMapper.selectGenshinWeaponById(id);
    }

    /**
     * 查询原神武器信息列表
     * 
     * @param genshinWeapon 原神武器信息
     * @return 原神武器信息
     */
    @Override
    public List<GenshinWeapon> selectGenshinWeaponList(GenshinWeapon genshinWeapon)
    {
        return genshinWeaponMapper.selectGenshinWeaponList(genshinWeapon);
    }

    /**
     * 新增原神武器信息
     * 
     * @param genshinWeapon 原神武器信息
     * @return 结果
     */
    @Override
    public int insertGenshinWeapon(GenshinWeapon genshinWeapon)
    {
        return genshinWeaponMapper.insertGenshinWeapon(genshinWeapon);
    }

    /**
     * 修改原神武器信息
     * 
     * @param genshinWeapon 原神武器信息
     * @return 结果
     */
    @Override
    public int updateGenshinWeapon(GenshinWeapon genshinWeapon)
    {
        return genshinWeaponMapper.updateGenshinWeapon(genshinWeapon);
    }

    /**
     * 批量删除原神武器信息
     * 
     * @param ids 需要删除的原神武器信息主键
     * @return 结果
     */
    @Override
    public int deleteGenshinWeaponByIds(String ids)
    {
        return genshinWeaponMapper.deleteGenshinWeaponByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除原神武器信息信息
     * 
     * @param id 原神武器信息主键
     * @return 结果
     */
    @Override
    public int deleteGenshinWeaponById(Long id)
    {
        return genshinWeaponMapper.deleteGenshinWeaponById(id);
    }
}
