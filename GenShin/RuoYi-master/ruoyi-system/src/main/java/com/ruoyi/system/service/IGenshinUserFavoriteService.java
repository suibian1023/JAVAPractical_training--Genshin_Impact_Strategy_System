package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.GenshinUserFavorite;

/**
 * 【请填写功能名称】Service接口
 * 
 * @author ruoyi
 * @date 2026-05-29
 */
public interface IGenshinUserFavoriteService 
{
    /**
     * 查询【请填写功能名称】
     * 
     * @param id 【请填写功能名称】主键
     * @return 【请填写功能名称】
     */
    public GenshinUserFavorite selectGenshinUserFavoriteById(Long id);

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param genshinUserFavorite 【请填写功能名称】
     * @return 【请填写功能名称】集合
     */
    public List<GenshinUserFavorite> selectGenshinUserFavoriteList(GenshinUserFavorite genshinUserFavorite);

    /**
     * 新增【请填写功能名称】
     * 
     * @param genshinUserFavorite 【请填写功能名称】
     * @return 结果
     */
    public int insertGenshinUserFavorite(GenshinUserFavorite genshinUserFavorite);

    /**
     * 修改【请填写功能名称】
     * 
     * @param genshinUserFavorite 【请填写功能名称】
     * @return 结果
     */
    public int updateGenshinUserFavorite(GenshinUserFavorite genshinUserFavorite);

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param ids 需要删除的【请填写功能名称】主键集合
     * @return 结果
     */
    public int deleteGenshinUserFavoriteByIds(String ids);

    /**
     * 删除【请填写功能名称】信息
     * 
     * @param id 【请填写功能名称】主键
     * @return 结果
     */
    public int deleteGenshinUserFavoriteById(Long id);
}
