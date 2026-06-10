package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 原神秘境信息对象 genshin_domain
 * 
 * @author ruoyi
 * @date 2026-05-29
 */
public class GenshinDomain extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 秘境ID */
    private Long id;

    /** 秘境名称 */
    @Excel(name = "秘境名称")
    private String name;

    /** 地区ID */
    @Excel(name = "地区ID")
    private Long regionId;

    /** 地区名称 */
    @Excel(name = "地区名称")
    private String regionName;

    /** 入口ID */
    @Excel(name = "入口ID")
    private Long entranceId;

    /** 入口名称 */
    @Excel(name = "入口名称")
    private String entranceName;

    /** 秘境类型编码 */
    @Excel(name = "秘境类型编码")
    private String domainType;

    /** 秘境类型名称 */
    @Excel(name = "秘境类型名称")
    private String domainText;

    /** 秘境描述 */
    @Excel(name = "秘境描述")
    private String description;

    /** 推荐等级 */
    @Excel(name = "推荐等级")
    private Long recommendedLevel;

    /** 推荐元素类型 */
    @Excel(name = "推荐元素类型")
    private String recommendedElements;

    /** 解锁冒险等阶 */
    @Excel(name = "解锁冒险等阶")
    private Long unlockRank;

    /** 开放星期 */
    @Excel(name = "开放星期")
    private String daysOfWeek;

    /** 秘境规则 */
    @Excel(name = "秘境规则")
    private String disorder;

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

    public void setRegionId(Long regionId) 
    {
        this.regionId = regionId;
    }

    public Long getRegionId() 
    {
        return regionId;
    }

    public void setRegionName(String regionName) 
    {
        this.regionName = regionName;
    }

    public String getRegionName() 
    {
        return regionName;
    }

    public void setEntranceId(Long entranceId) 
    {
        this.entranceId = entranceId;
    }

    public Long getEntranceId() 
    {
        return entranceId;
    }

    public void setEntranceName(String entranceName) 
    {
        this.entranceName = entranceName;
    }

    public String getEntranceName() 
    {
        return entranceName;
    }

    public void setDomainType(String domainType) 
    {
        this.domainType = domainType;
    }

    public String getDomainType() 
    {
        return domainType;
    }

    public void setDomainText(String domainText) 
    {
        this.domainText = domainText;
    }

    public String getDomainText() 
    {
        return domainText;
    }

    public void setDescription(String description) 
    {
        this.description = description;
    }

    public String getDescription() 
    {
        return description;
    }

    public void setRecommendedLevel(Long recommendedLevel) 
    {
        this.recommendedLevel = recommendedLevel;
    }

    public Long getRecommendedLevel() 
    {
        return recommendedLevel;
    }

    public void setRecommendedElements(String recommendedElements) 
    {
        this.recommendedElements = recommendedElements;
    }

    public String getRecommendedElements() 
    {
        return recommendedElements;
    }

    public void setUnlockRank(Long unlockRank) 
    {
        this.unlockRank = unlockRank;
    }

    public Long getUnlockRank() 
    {
        return unlockRank;
    }

    public void setDaysOfWeek(String daysOfWeek) 
    {
        this.daysOfWeek = daysOfWeek;
    }

    public String getDaysOfWeek() 
    {
        return daysOfWeek;
    }

    public void setDisorder(String disorder) 
    {
        this.disorder = disorder;
    }

    public String getDisorder() 
    {
        return disorder;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("name", getName())
            .append("regionId", getRegionId())
            .append("regionName", getRegionName())
            .append("entranceId", getEntranceId())
            .append("entranceName", getEntranceName())
            .append("domainType", getDomainType())
            .append("domainText", getDomainText())
            .append("description", getDescription())
            .append("recommendedLevel", getRecommendedLevel())
            .append("recommendedElements", getRecommendedElements())
            .append("unlockRank", getUnlockRank())
            .append("daysOfWeek", getDaysOfWeek())
            .append("disorder", getDisorder())
            .toString();
    }
}
