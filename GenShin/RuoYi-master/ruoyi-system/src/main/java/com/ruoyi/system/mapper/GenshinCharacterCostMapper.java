package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.GenshinCharacterCost;

/**
 * 角色突破材料Mapper接口
 * 
 * @author ruoyi
 */
public interface GenshinCharacterCostMapper 
{
    /**
     * 查询角色突破材料
     * 
     * @param id 角色突破材料主键
     * @return 角色突破材料
     */
    public GenshinCharacterCost selectGenshinCharacterCostById(Long id);

    /**
     * 查询角色突破材料列表
     * 
     * @param genshinCharacterCost 角色突破材料
     * @return 角色突破材料集合
     */
    public List<GenshinCharacterCost> selectGenshinCharacterCostList(GenshinCharacterCost genshinCharacterCost);

    /**
     * 新增角色突破材料
     * 
     * @param genshinCharacterCost 角色突破材料
     * @return 结果
     */
    public int insertGenshinCharacterCost(GenshinCharacterCost genshinCharacterCost);

    /**
     * 修改角色突破材料
     * 
     * @param genshinCharacterCost 角色突破材料
     * @return 结果
     */
    public int updateGenshinCharacterCost(GenshinCharacterCost genshinCharacterCost);

    /**
     * 删除角色突破材料
     * 
     * @param id 角色突破材料主键
     * @return 结果
     */
    public int deleteGenshinCharacterCostById(Long id);

    /**
     * 批量删除角色突破材料
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteGenshinCharacterCostByIds(String[] ids);
}
