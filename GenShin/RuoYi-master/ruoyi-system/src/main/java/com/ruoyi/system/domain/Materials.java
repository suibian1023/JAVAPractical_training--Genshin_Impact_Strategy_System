package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 原神素材信息对象 materials
 * 
 * @author ruoyi
 */
public class Materials extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 素材ID */
    private Long id;

    /** 素材名称 */
    @Excel(name = "素材名称")
    private String name;

    /** 别名 */
    @Excel(name = "别名")
    private String dupealias;

    /** 稀有度(星级) */
    @Excel(name = "稀有度(星级)")
    private Long rarity;

    /** 类别 */
    @Excel(name = "类别")
    private String category;

    /** 类型文本 */
    @Excel(name = "类型文本")
    private String typeText;

    /** 掉落副本ID */
    @Excel(name = "掉落副本ID")
    private Long dropDomainId;

    /** 掉落副本名称 */
    @Excel(name = "掉落副本名称")
    private String dropDomainName;

    /** 周几掉落 */
    @Excel(name = "周几掉落")
    private String daysOfWeek;

    /** 来源(JSON数组) */
    @Excel(name = "来源")
    private String sources;

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

    public void setDupealias(String dupealias) 
    {
        this.dupealias = dupealias;
    }

    public String getDupealias() 
    {
        return dupealias;
    }

    public void setRarity(Long rarity) 
    {
        this.rarity = rarity;
    }

    public Long getRarity() 
    {
        return rarity;
    }

    public void setCategory(String category) 
    {
        this.category = category;
    }

    public String getCategory() 
    {
        return category;
    }

    public void setTypeText(String typeText) 
    {
        this.typeText = typeText;
    }

    public String getTypeText() 
    {
        return typeText;
    }

    public void setDropDomainId(Long dropDomainId) 
    {
        this.dropDomainId = dropDomainId;
    }

    public Long getDropDomainId() 
    {
        return dropDomainId;
    }

    public void setDropDomainName(String dropDomainName) 
    {
        this.dropDomainName = dropDomainName;
    }

    public String getDropDomainName() 
    {
        return dropDomainName;
    }

    public void setDaysOfWeek(String daysOfWeek) 
    {
        this.daysOfWeek = daysOfWeek;
    }

    public String getDaysOfWeek() 
    {
        return daysOfWeek;
    }

    public void setSources(String sources) 
    {
        this.sources = sources;
    }

    public String getSources() 
    {
        return sources;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("name", getName())
            .append("dupealias", getDupealias())
            .append("rarity", getRarity())
            .append("category", getCategory())
            .append("typeText", getTypeText())
            .append("dropDomainId", getDropDomainId())
            .append("dropDomainName", getDropDomainName())
            .append("daysOfWeek", getDaysOfWeek())
            .append("sources", getSources())
            .toString();
    }
}
