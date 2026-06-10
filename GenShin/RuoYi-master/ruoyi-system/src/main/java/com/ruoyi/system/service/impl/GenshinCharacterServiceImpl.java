package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.GenshinCharacterMapper;
import com.ruoyi.system.domain.GenshinCharacter;
import com.ruoyi.system.service.IGenshinCharacterService;
import com.ruoyi.common.core.text.Convert;

/**
 * 原神角色基础信息Service业务层处理
 * 
 * @author ruoyi
 * @date 2026-05-29
 */
@Service
public class GenshinCharacterServiceImpl implements IGenshinCharacterService 
{
    @Autowired
    private GenshinCharacterMapper genshinCharacterMapper;

    /**
     * 查询原神角色基础信息
     * 
     * @param id 原神角色基础信息主键
     * @return 原神角色基础信息
     */
    @Override
    public GenshinCharacter selectGenshinCharacterById(Long id)
    {
        return genshinCharacterMapper.selectGenshinCharacterById(id);
    }

    /**
     * 查询原神角色基础信息列表
     * 
     * @param genshinCharacter 原神角色基础信息
     * @return 原神角色基础信息
     */
    @Override
    public List<GenshinCharacter> selectGenshinCharacterList(GenshinCharacter genshinCharacter)
    {
        return genshinCharacterMapper.selectGenshinCharacterList(genshinCharacter);
    }

    /**
     * 新增原神角色基础信息
     * 
     * @param genshinCharacter 原神角色基础信息
     * @return 结果
     */
    @Override
    public int insertGenshinCharacter(GenshinCharacter genshinCharacter)
    {
        return genshinCharacterMapper.insertGenshinCharacter(genshinCharacter);
    }

    /**
     * 修改原神角色基础信息
     * 
     * @param genshinCharacter 原神角色基础信息
     * @return 结果
     */
    @Override
    public int updateGenshinCharacter(GenshinCharacter genshinCharacter)
    {
        return genshinCharacterMapper.updateGenshinCharacter(genshinCharacter);
    }

    /**
     * 批量删除原神角色基础信息
     * 
     * @param ids 需要删除的原神角色基础信息主键
     * @return 结果
     */
    @Override
    public int deleteGenshinCharacterByIds(String ids)
    {
        return genshinCharacterMapper.deleteGenshinCharacterByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除原神角色基础信息信息
     * 
     * @param id 原神角色基础信息主键
     * @return 结果
     */
    @Override
    public int deleteGenshinCharacterById(Long id)
    {
        return genshinCharacterMapper.deleteGenshinCharacterById(id);
    }
}
