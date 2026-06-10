package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 原神锻造配方材料对象 genshin_craft_recipe
 * 
 * @author ruoyi
 */
public class GenshinCraftRecipe extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 自增主键 */
    private Long id;

    /** 配方ID */
    @Excel(name = "配方ID")
    private Long craftId;

    /** 材料ID */
    @Excel(name = "材料ID")
    private Long materialId;

    /** 材料名称 */
    @Excel(name = "材料名称")
    private String materialName;

    /** 所需数量 */
    @Excel(name = "所需数量")
    private Long materialCount;

    /** 是否为替代配方 0:主配方 1:替代配方 */
    @Excel(name = "是否为替代配方")
    private Long isAlt;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }

    public void setCraftId(Long craftId) 
    {
        this.craftId = craftId;
    }

    public Long getCraftId() 
    {
        return craftId;
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

    public void setMaterialCount(Long materialCount) 
    {
        this.materialCount = materialCount;
    }

    public Long getMaterialCount() 
    {
        return materialCount;
    }

    public void setIsAlt(Long isAlt) 
    {
        this.isAlt = isAlt;
    }

    public Long getIsAlt() 
    {
        return isAlt;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("craftId", getCraftId())
            .append("materialId", getMaterialId())
            .append("materialName", getMaterialName())
            .append("materialCount", getMaterialCount())
            .append("isAlt", getIsAlt())
            .toString();
    }
}
