package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 原神怪物调查信息对象 genshin_enemy_investigation
 * 
 * @author ruoyi
 * @date 2026-05-29
 */
public class GenshinEnemyInvestigation extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 自增主键 */
    private Long id;

    /** 怪物ID */
    @Excel(name = "怪物ID")
    private Long enemyId;

    /** 调查ID */
    @Excel(name = "调查ID")
    private Long investigationId;

    /** 调查名称 */
    @Excel(name = "调查名称")
    private String name;

    /** 调查分类编码 */
    @Excel(name = "调查分类编码")
    private String categoryType;

    /** 调查分类名称 */
    @Excel(name = "调查分类名称")
    private String categoryText;

    /** 调查描述 */
    @Excel(name = "调查描述")
    private String description;

    /** 解锁描述 */
    @Excel(name = "解锁描述")
    private String lockdesc;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }

    public void setEnemyId(Long enemyId) 
    {
        this.enemyId = enemyId;
    }

    public Long getEnemyId() 
    {
        return enemyId;
    }

    public void setInvestigationId(Long investigationId) 
    {
        this.investigationId = investigationId;
    }

    public Long getInvestigationId() 
    {
        return investigationId;
    }

    public void setName(String name) 
    {
        this.name = name;
    }

    public String getName() 
    {
        return name;
    }

    public void setCategoryType(String categoryType) 
    {
        this.categoryType = categoryType;
    }

    public String getCategoryType() 
    {
        return categoryType;
    }

    public void setCategoryText(String categoryText) 
    {
        this.categoryText = categoryText;
    }

    public String getCategoryText() 
    {
        return categoryText;
    }

    public void setDescription(String description) 
    {
        this.description = description;
    }

    public String getDescription() 
    {
        return description;
    }

    public void setLockdesc(String lockdesc) 
    {
        this.lockdesc = lockdesc;
    }

    public String getLockdesc() 
    {
        return lockdesc;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("enemyId", getEnemyId())
            .append("investigationId", getInvestigationId())
            .append("name", getName())
            .append("categoryType", getCategoryType())
            .append("categoryText", getCategoryText())
            .append("description", getDescription())
            .append("lockdesc", getLockdesc())
            .toString();
    }
}
