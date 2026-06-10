package com.ruoyi.system.domain;

import java.math.BigDecimal;
import java.util.Date;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 原神武器信息对象 weapons
 * 
 * @author ruoyi
 * @date 2026-06-05
 */
public class GenshinWeapon extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 武器ID */
    private Long id;

    /** 武器名称 */
    @Excel(name = "武器名称")
    private String name;

    /** 武器描述 */
    @Excel(name = "武器描述")
    private String description;

    /** 武器类型编码 */
    @Excel(name = "武器类型编码")
    private String weaponType;

    /** 武器类型名称 */
    @Excel(name = "武器类型名称")
    private String weaponText;

    /** 星级 */
    @Excel(name = "星级")
    private Integer rarity;

    /** 基础攻击力 */
    @Excel(name = "基础攻击力")
    private BigDecimal baseAtkValue;

    /** 主属性类型 */
    @Excel(name = "主属性类型")
    private String mainStatType;

    /** 主属性名称 */
    @Excel(name = "主属性名称")
    private String mainStatText;

    /** 基础属性文本 */
    @Excel(name = "基础属性文本")
    private String baseStatText;

    /** 武器效果名称 */
    @Excel(name = "武器效果名称")
    private String effectName;

    /** 精炼1描述 */
    private String r1Description;

    /** 精炼2描述 */
    private String r2Description;

    /** 精炼3描述 */
    private String r3Description;

    /** 精炼4描述 */
    private String r4Description;

    /** 精炼5描述 */
    private String r5Description;

    /** 突破材料JSON */
    private String costsJson;

    /** 武器故事 */
    private String story;

    /** 创建时间 */
    private Date createdAt;

    /** 更新时间 */
    private Date updatedAt;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }

    public void setName(String name) 
    {
        this.name = name;
    }

    public String getName() 
    {
        return name;
    }

    public void setDescription(String description) 
    {
        this.description = description;
    }

    public String getDescription() 
    {
        return description;
    }

    public void setWeaponType(String weaponType) 
    {
        this.weaponType = weaponType;
    }

    public String getWeaponType() 
    {
        return weaponType;
    }

    public void setWeaponText(String weaponText) 
    {
        this.weaponText = weaponText;
    }

    public String getWeaponText() 
    {
        return weaponText;
    }

    public void setRarity(Integer rarity) 
    {
        this.rarity = rarity;
    }

    public Integer getRarity() 
    {
        return rarity;
    }

    public void setBaseAtkValue(BigDecimal baseAtkValue) 
    {
        this.baseAtkValue = baseAtkValue;
    }

    public BigDecimal getBaseAtkValue() 
    {
        return baseAtkValue;
    }

    public void setMainStatType(String mainStatType) 
    {
        this.mainStatType = mainStatType;
    }

    public String getMainStatType() 
    {
        return mainStatType;
    }

    public void setMainStatText(String mainStatText) 
    {
        this.mainStatText = mainStatText;
    }

    public String getMainStatText() 
    {
        return mainStatText;
    }

    public void setBaseStatText(String baseStatText) 
    {
        this.baseStatText = baseStatText;
    }

    public String getBaseStatText() 
    {
        return baseStatText;
    }

    public void setEffectName(String effectName) 
    {
        this.effectName = effectName;
    }

    public String getEffectName() 
    {
        return effectName;
    }

    public void setR1Description(String r1Description) 
    {
        this.r1Description = r1Description;
    }

    public String getR1Description() 
    {
        return r1Description;
    }

    public void setR2Description(String r2Description) 
    {
        this.r2Description = r2Description;
    }

    public String getR2Description() 
    {
        return r2Description;
    }

    public void setR3Description(String r3Description) 
    {
        this.r3Description = r3Description;
    }

    public String getR3Description() 
    {
        return r3Description;
    }

    public void setR4Description(String r4Description) 
    {
        this.r4Description = r4Description;
    }

    public String getR4Description() 
    {
        return r4Description;
    }

    public void setR5Description(String r5Description) 
    {
        this.r5Description = r5Description;
    }

    public String getR5Description() 
    {
        return r5Description;
    }

    public void setCostsJson(String costsJson) 
    {
        this.costsJson = costsJson;
    }

    public String getCostsJson() 
    {
        return costsJson;
    }

    public void setStory(String story) 
    {
        this.story = story;
    }

    public String getStory() 
    {
        return story;
    }

    public void setCreatedAt(Date createdAt) 
    {
        this.createdAt = createdAt;
    }

    public Date getCreatedAt() 
    {
        return createdAt;
    }

    public void setUpdatedAt(Date updatedAt) 
    {
        this.updatedAt = updatedAt;
    }

    public Date getUpdatedAt() 
    {
        return updatedAt;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("name", getName())
            .append("description", getDescription())
            .append("weaponType", getWeaponType())
            .append("weaponText", getWeaponText())
            .append("rarity", getRarity())
            .append("baseAtkValue", getBaseAtkValue())
            .append("mainStatType", getMainStatType())
            .append("mainStatText", getMainStatText())
            .append("baseStatText", getBaseStatText())
            .append("effectName", getEffectName())
            .append("r1Description", getR1Description())
            .append("r2Description", getR2Description())
            .append("r3Description", getR3Description())
            .append("r4Description", getR4Description())
            .append("r5Description", getR5Description())
            .append("costsJson", getCostsJson())
            .append("story", getStory())
            .append("createdAt", getCreatedAt())
            .append("updatedAt", getUpdatedAt())
            .toString();
    }
}
