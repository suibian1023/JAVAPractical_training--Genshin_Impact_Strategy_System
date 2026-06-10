package com.ruoyi.system.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 天赋升级材料对象 talent_costs
 * 
 * @author ruoyi
 * @date 2026-05-29
 */
public class TalentCosts extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long id;

    /** 角色ID */
    @Excel(name = "角色ID")
    private Long characterId;

    /** 天赋等级(2-10) */
    @Excel(name = "天赋等级(2-10)")
    private Long level;

    /** 材料ID */
    @Excel(name = "材料ID")
    private Long materialId;

    /** 材料名称 */
    @Excel(name = "材料名称")
    private String materialName;

    /** 所需数量 */
    @Excel(name = "所需数量")
    private Long count;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Date createdAt;

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

    public void setLevel(Long level) 
    {
        this.level = level;
    }

    public Long getLevel() 
    {
        return level;
    }

    public void setMaterialId(Long materialId) 
    {
        this.materialId = materialId;
    }

    public Long getMaterialId() 
    {
        return materialId;
    }

    public void setMaterialName(String materialName) 
    {
        this.materialName = materialName;
    }

    public String getMaterialName() 
    {
        return materialName;
    }

    public void setCount(Long count) 
    {
        this.count = count;
    }

    public Long getCount() 
    {
        return count;
    }

    public void setCreatedAt(Date createdAt) 
    {
        this.createdAt = createdAt;
    }

    public Date getCreatedAt() 
    {
        return createdAt;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("characterId", getCharacterId())
            .append("level", getLevel())
            .append("materialId", getMaterialId())
            .append("materialName", getMaterialName())
            .append("count", getCount())
            .append("createdAt", getCreatedAt())
            .toString();
    }
}
