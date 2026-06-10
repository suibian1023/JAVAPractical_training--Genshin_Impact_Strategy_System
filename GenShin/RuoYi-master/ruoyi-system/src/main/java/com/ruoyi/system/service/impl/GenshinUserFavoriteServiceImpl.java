package com.ruoyi.system.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.GenshinUserFavoriteMapper;
import com.ruoyi.system.domain.GenshinUserFavorite;
import com.ruoyi.system.service.IGenshinUserFavoriteService;
import com.ruoyi.common.core.text.Convert;

/**
 * 【请填写功能名称】Service业务层处理
 * 
 * @author ruoyi
 * @date 2026-05-29
 */
@Service
public class GenshinUserFavoriteServiceImpl implements IGenshinUserFavoriteService 
{
    @Autowired
    private GenshinUserFavoriteMapper genshinUserFavoriteMapper;

    /**
     * 查询【请填写功能名称】
     * 
     * @param id 【请填写功能名称】主键
     * @return 【请填写功能名称】
     */
    @Override
    public GenshinUserFavorite selectGenshinUserFavoriteById(Long id)
    {
        return genshinUserFavoriteMapper.selectGenshinUserFavoriteById(id);
    }

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param genshinUserFavorite 【请填写功能名称】
     * @return 【请填写功能名称】
     */
    @Override
    public List<GenshinUserFavorite> selectGenshinUserFavoriteList(GenshinUserFavorite genshinUserFavorite)
    {
        return genshinUserFavoriteMapper.selectGenshinUserFavoriteList(genshinUserFavorite);
    }

    /**
     * 新增【请填写功能名称】
     * 
     * @param genshinUserFavorite 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int insertGenshinUserFavorite(GenshinUserFavorite genshinUserFavorite)
    {
        genshinUserFavorite.setCreateTime(DateUtils.getNowDate());
        return genshinUserFavoriteMapper.insertGenshinUserFavorite(genshinUserFavorite);
    }

    /**
     * 修改【请填写功能名称】
     * 
     * @param genshinUserFavorite 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int updateGenshinUserFavorite(GenshinUserFavorite genshinUserFavorite)
    {
        return genshinUserFavoriteMapper.updateGenshinUserFavorite(genshinUserFavorite);
    }

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param ids 需要删除的【请填写功能名称】主键
     * @return 结果
     */
    @Override
    public int deleteGenshinUserFavoriteByIds(String ids)
    {
        return genshinUserFavoriteMapper.deleteGenshinUserFavoriteByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除【请填写功能名称】信息
     * 
     * @param id 【请填写功能名称】主键
     * @return 结果
     */
    @Override
    public int deleteGenshinUserFavoriteById(Long id)
    {
        return genshinUserFavoriteMapper.deleteGenshinUserFavoriteById(id);
    }
}
