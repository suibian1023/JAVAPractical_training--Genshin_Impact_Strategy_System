package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.GenshinDomainMapper;
import com.ruoyi.system.domain.GenshinDomain;
import com.ruoyi.system.service.IGenshinDomainService;
import com.ruoyi.common.core.text.Convert;

/**
 * 原神秘境信息Service业务层处理
 * 
 * @author ruoyi
 * @date 2026-05-29
 */
@Service
public class GenshinDomainServiceImpl implements IGenshinDomainService 
{
    @Autowired
    private GenshinDomainMapper genshinDomainMapper;

    /**
     * 查询原神秘境信息
     * 
     * @param id 原神秘境信息主键
     * @return 原神秘境信息
     */
    @Override
    public GenshinDomain selectGenshinDomainById(Long id)
    {
        return genshinDomainMapper.selectGenshinDomainById(id);
    }

    /**
     * 查询原神秘境信息列表
     * 
     * @param genshinDomain 原神秘境信息
     * @return 原神秘境信息
     */
    @Override
    public List<GenshinDomain> selectGenshinDomainList(GenshinDomain genshinDomain)
    {
        return genshinDomainMapper.selectGenshinDomainList(genshinDomain);
    }

    /**
     * 新增原神秘境信息
     * 
     * @param genshinDomain 原神秘境信息
     * @return 结果
     */
    @Override
    public int insertGenshinDomain(GenshinDomain genshinDomain)
    {
        return genshinDomainMapper.insertGenshinDomain(genshinDomain);
    }

    /**
     * 修改原神秘境信息
     * 
     * @param genshinDomain 原神秘境信息
     * @return 结果
     */
    @Override
    public int updateGenshinDomain(GenshinDomain genshinDomain)
    {
        return genshinDomainMapper.updateGenshinDomain(genshinDomain);
    }

    /**
     * 批量删除原神秘境信息
     * 
     * @param ids 需要删除的原神秘境信息主键
     * @return 结果
     */
    @Override
    public int deleteGenshinDomainByIds(String ids)
    {
        return genshinDomainMapper.deleteGenshinDomainByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除原神秘境信息信息
     * 
     * @param id 原神秘境信息主键
     * @return 结果
     */
    @Override
    public int deleteGenshinDomainById(Long id)
    {
        return genshinDomainMapper.deleteGenshinDomainById(id);
    }
}
