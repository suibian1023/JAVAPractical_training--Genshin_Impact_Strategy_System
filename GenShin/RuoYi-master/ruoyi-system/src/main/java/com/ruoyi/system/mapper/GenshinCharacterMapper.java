package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.GenshinCharacter;

/**
 * 原神角色基础信息Mapper接口
 * 
 * @author ruoyi
 * @date 2026-05-29
 */
public interface GenshinCharacterMapper 
{
    /**
     * 查询原神角色基础信息
     * 
     * @param id 原神角色基础信息主键
     * @return 原神角色基础信息
     */
    public GenshinCharacter selectGenshinCharacterById(Long id);

    /**
     * 查询原神角色基础信息列表
     * 
     * @param genshinCharacter 原神角色基础信息
     * @return 原神角色基础信息集合
     */
    public List<GenshinCharacter> selectGenshinCharacterList(GenshinCharacter genshinCharacter);

    /**
     * 新增原神角色基础信息
     * 
     * @param genshinCharacter 原神角色基础信息
     * @return 结果
     */
    public int insertGenshinCharacter(GenshinCharacter genshinCharacter);

    /**
     * 修改原神角色基础信息
     * 
     * @param genshinCharacter 原神角色基础信息
     * @return 结果
     */
    public int updateGenshinCharacter(GenshinCharacter genshinCharacter);

    /**
     * 删除原神角色基础信息
     * 
     * @param id 原神角色基础信息主键
     * @return 结果
     */
    public int deleteGenshinCharacterById(Long id);

    /**
     * 批量删除原神角色基础信息
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteGenshinCharacterByIds(String[] ids);
}
