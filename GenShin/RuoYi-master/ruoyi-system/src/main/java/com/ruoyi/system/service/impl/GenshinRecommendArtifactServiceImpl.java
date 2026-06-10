package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.GenshinRecommendArtifactMapper;
import com.ruoyi.system.domain.GenshinRecommendArtifact;
import com.ruoyi.system.service.IGenshinRecommendArtifactService;
import com.ruoyi.common.core.text.Convert;

/**
 * 角色圣遗物推荐Service业务层处理
 * 
 * @author ruoyi
 * @date 2026-05-29
 */
@Service
public class GenshinRecommendArtifactServiceImpl implements IGenshinRecommendArtifactService 
{
    @Autowired
    private GenshinRecommendArtifactMapper genshinRecommendArtifactMapper;

    /**
     * 查询角色圣遗物推荐
     * 
     * @param id 角色圣遗物推荐主键
     * @return 角色圣遗物推荐
     */
    @Override
    public GenshinRecommendArtifact selectGenshinRecommendArtifactById(Long id)
    {
        return genshinRecommendArtifactMapper.selectGenshinRecommendArtifactById(id);
    }

    /**
     * 查询角色圣遗物推荐列表
     * 
     * @param genshinRecommendArtifact 角色圣遗物推荐
     * @return 角色圣遗物推荐
     */
    @Override
    public List<GenshinRecommendArtifact> selectGenshinRecommendArtifactList(GenshinRecommendArtifact genshinRecommendArtifact)
    {
        return genshinRecommendArtifactMapper.selectGenshinRecommendArtifactList(genshinRecommendArtifact);
    }

    /**
     * 新增角色圣遗物推荐
     * 
     * @param genshinRecommendArtifact 角色圣遗物推荐
     * @return 结果
     */
    @Override
    public int insertGenshinRecommendArtifact(GenshinRecommendArtifact genshinRecommendArtifact)
    {
        return genshinRecommendArtifactMapper.insertGenshinRecommendArtifact(genshinRecommendArtifact);
    }

    /**
     * 修改角色圣遗物推荐
     * 
     * @param genshinRecommendArtifact 角色圣遗物推荐
     * @return 结果
     */
    @Override
    public int updateGenshinRecommendArtifact(GenshinRecommendArtifact genshinRecommendArtifact)
    {
        return genshinRecommendArtifactMapper.updateGenshinRecommendArtifact(genshinRecommendArtifact);
    }

    /**
     * 批量删除角色圣遗物推荐
     * 
     * @param ids 需要删除的角色圣遗物推荐主键
     * @return 结果
     */
    @Override
    public int deleteGenshinRecommendArtifactByIds(String ids)
    {
        return genshinRecommendArtifactMapper.deleteGenshinRecommendArtifactByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除角色圣遗物推荐信息
     * 
     * @param id 角色圣遗物推荐主键
     * @return 结果
     */
    @Override
    public int deleteGenshinRecommendArtifactById(Long id)
    {
        return genshinRecommendArtifactMapper.deleteGenshinRecommendArtifactById(id);
    }
}
