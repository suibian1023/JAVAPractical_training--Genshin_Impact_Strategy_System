package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.GenshinDomain;

/**
 * 原神秘境信息Service接口
 * 
 * @author ruoyi
 * @date 2026-05-29
 */
public interface IGenshinDomainService 
{
    /**
     * 查询原神秘境信息
     * 
     * @param id 原神秘境信息主键
     * @return 原神秘境信息
     */
    public GenshinDomain selectGenshinDomainById(Long id);

    /**
     * 查询原神秘境信息列表
     * 
     * @param genshinDomain 原神秘境信息
     * @return 原神秘境信息集合
     */
    public List<GenshinDomain> selectGenshinDomainList(GenshinDomain genshinDomain);

    /**
     * 新增原神秘境信息
     * 
     * @param genshinDomain 原神秘境信息
     * @return 结果
     */
    public int insertGenshinDomain(GenshinDomain genshinDomain);

    /**
     * 修改原神秘境信息
     * 
     * @param genshinDomain 原神秘境信息
     * @return 结果
     */
    public int updateGenshinDomain(GenshinDomain genshinDomain);

    /**
     * 批量删除原神秘境信息
     * 
     * @param ids 需要删除的原神秘境信息主键集合
     * @return 结果
     */
    public int deleteGenshinDomainByIds(String ids);

    /**
     * 删除原神秘境信息信息
     * 
     * @param id 原神秘境信息主键
     * @return 结果
     */
    public int deleteGenshinDomainById(Long id);
}
