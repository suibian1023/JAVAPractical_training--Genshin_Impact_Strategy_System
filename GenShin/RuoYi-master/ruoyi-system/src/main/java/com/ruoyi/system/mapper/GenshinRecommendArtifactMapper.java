package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.GenshinRecommendArtifact;

/**
 * 角色圣遗物推荐Mapper接口
 * 
 * @author ruoyi
 * @date 2026-05-29
 */
public interface GenshinRecommendArtifactMapper 
{
    /**
     * 查询角色圣遗物推荐
     * 
     * @param id 角色圣遗物推荐主键
     * @return 角色圣遗物推荐
     */
    public GenshinRecommendArtifact selectGenshinRecommendArtifactById(Long id);

    /**
     * 查询角色圣遗物推荐列表
     * 
     * @param genshinRecommendArtifact 角色圣遗物推荐
     * @return 角色圣遗物推荐集合
     */
    public List<GenshinRecommendArtifact> selectGenshinRecommendArtifactList(GenshinRecommendArtifact genshinRecommendArtifact);

    /**
     * 新增角色圣遗物推荐
     * 
     * @param genshinRecommendArtifact 角色圣遗物推荐
     * @return 结果
     */
    public int insertGenshinRecommendArtifact(GenshinRecommendArtifact genshinRecommendArtifact);

    /**
     * 修改角色圣遗物推荐
     * 
     * @param genshinRecommendArtifact 角色圣遗物推荐
     * @return 结果
     */
    public int updateGenshinRecommendArtifact(GenshinRecommendArtifact genshinRecommendArtifact);

    /**
     * 删除角色圣遗物推荐
     * 
     * @param id 角色圣遗物推荐主键
     * @return 结果
     */
    public int deleteGenshinRecommendArtifactById(Long id);

    /**
     * 批量删除角色圣遗物推荐
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteGenshinRecommendArtifactByIds(String[] ids);
}
