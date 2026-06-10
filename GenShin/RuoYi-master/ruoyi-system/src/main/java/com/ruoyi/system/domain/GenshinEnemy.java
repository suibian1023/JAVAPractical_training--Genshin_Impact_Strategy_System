package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 原神怪物信息对象 genshin_enemy
 * 
 * @author ruoyi
 * @date 2026-05-29
 */
public class GenshinEnemy extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 怪物ID */
    private Long id;

    /** 怪物内部ID */
    @Excel(name = "怪物内部ID")
    private Long monsterId;

    /** 怪物名称 */
    @Excel(name = "怪物名称")
    private String name;

    /** 特殊名称列表 */
    @Excel(name = "特殊名称列表")
    private String specialNames;

    /** 怪物类型编码 */
    @Excel(name = "怪物类型编码")
    private String monsterType;

    /** 敌人类型(NORMAL/ELITE/BOSS) */
    @Excel(name = "敌人类型(NORMAL/ELITE/BOSS)")
    private String enemyType;

    /** 分类编码 */
    @Excel(name = "分类编码")
    private String categoryType;

    /** 分类名称 */
    @Excel(name = "分类名称")
    private String categoryText;

    /** 怪物描述 */
    @Excel(name = "怪物描述")
    private String description;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }

    public void setMonsterId(Long monsterId) 
    {
        this.monsterId = monsterId;
    }

    public Long getMonsterId() 
    {
        return monsterId;
    }

    public void setName(String name) 
    {
        this.name = name;
    }

    public String getName() 
    {
        return name;
    }

    public void setSpecialNames(String specialNames) 
    {
        this.specialNames = specialNames;
    }

    public String getSpecialNames() 
    {
        return specialNames;
    }

    public void setMonsterType(String monsterType) 
    {
        this.monsterType = monsterType;
    }

    public String getMonsterType() 
    {
        return monsterType;
    }

    public void setEnemyType(String enemyType) 
    {
        this.enemyType = enemyType;
    }

    public String getEnemyType() 
    {
        return enemyType;
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

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("monsterId", getMonsterId())
            .append("name", getName())
            .append("specialNames", getSpecialNames())
            .append("monsterType", getMonsterType())
            .append("enemyType", getEnemyType())
            .append("categoryType", getCategoryType())
            .append("categoryText", getCategoryText())
            .append("description", getDescription())
            .toString();
    }
}
