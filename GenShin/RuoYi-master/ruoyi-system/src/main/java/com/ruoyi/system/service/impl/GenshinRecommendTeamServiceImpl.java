package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.GenshinRecommendTeamMapper;
import com.ruoyi.system.domain.GenshinRecommendTeam;
import com.ruoyi.system.service.IGenshinRecommendTeamService;
import com.ruoyi.common.core.text.Convert;

/**
 * 【请填写功能名称】Service业务层处理
 * 
 * @author ruoyi
 * @date 2026-05-29
 */
@Service
public class GenshinRecommendTeamServiceImpl implements IGenshinRecommendTeamService 
{
    @Autowired
    private GenshinRecommendTeamMapper genshinRecommendTeamMapper;

    /**
     * 查询【请填写功能名称】
     * 
     * @param id 【请填写功能名称】主键
     * @return 【请填写功能名称】
     */
    @Override
    public GenshinRecommendTeam selectGenshinRecommendTeamById(Long id)
    {
        return genshinRecommendTeamMapper.selectGenshinRecommendTeamById(id);
    }

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param genshinRecommendTeam 【请填写功能名称】
     * @return 【请填写功能名称】
     */
    @Override
    public List<GenshinRecommendTeam> selectGenshinRecommendTeamList(GenshinRecommendTeam genshinRecommendTeam)
    {
        return genshinRecommendTeamMapper.selectGenshinRecommendTeamList(genshinRecommendTeam);
    }

    /**
     * 新增【请填写功能名称】
     * 
     * @param genshinRecommendTeam 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int insertGenshinRecommendTeam(GenshinRecommendTeam genshinRecommendTeam)
    {
        return genshinRecommendTeamMapper.insertGenshinRecommendTeam(genshinRecommendTeam);
    }

    /**
     * 修改【请填写功能名称】
     * 
     * @param genshinRecommendTeam 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int updateGenshinRecommendTeam(GenshinRecommendTeam genshinRecommendTeam)
    {
        return genshinRecommendTeamMapper.updateGenshinRecommendTeam(genshinRecommendTeam);
    }

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param ids 需要删除的【请填写功能名称】主键
     * @return 结果
     */
    @Override
    public int deleteGenshinRecommendTeamByIds(String ids)
    {
        return genshinRecommendTeamMapper.deleteGenshinRecommendTeamByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除【请填写功能名称】信息
     * 
     * @param id 【请填写功能名称】主键
     * @return 结果
     */
    @Override
    public int deleteGenshinRecommendTeamById(Long id)
    {
        return genshinRecommendTeamMapper.deleteGenshinRecommendTeamById(id);
    }
}
