package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 角色突破材料对象 genshin_character_cost
 * 
 * @author ruoyi
 */
public class GenshinCharacterCost extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 自增主键 */
    private Long id;

    /** 角色ID */
    @Excel(name = "角色ID")
    private Long characterId;

    /** 突破等级 1-6 */
    @Excel(name = "突破等级")
    private Long ascendLevel;

    /** 材料ID */
    @Excel(name = "材料ID")
    private Long itemId;

    /** 材料名称 */
    @Excel(name = "材料名称")
    private String itemName;

    /** 需要数量 */
    @Excel(name = "需要数量")
    private Long itemCount;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }

    public void setCharacterId(Long characterId) 
    {
        this.characterId = characterId;
    }

    public Long getCharacterId() 
    {
        return characterId;
    }

    public void setAscendLevel(Long ascendLevel) 
    {
        this.ascendLevel = ascendLevel;
    }

    public Long getAscendLevel() 
    {
        return ascendLevel;
    }

    public void setItemId(Long itemId) 
    {
        this.itemId = itemId;
    }

    public Long getItemId() 
    {
        return itemId;
    }

    public void setItemName(String itemName) 
    {
        this.itemName = itemName;
    }

    public String getItemName() 
    {
        return itemName;
    }

    public void setItemCount(Long itemCount) 
    {
        this.itemCount = itemCount;
    }

    public Long getItemCount() 
    {
        return itemCount;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("characterId", getCharacterId())
            .append("ascendLevel", getAscendLevel())
            .append("itemId", getItemId())
            .append("itemName", getItemName())
            .append("itemCount", getItemCount())
            .toString();
    }
}
