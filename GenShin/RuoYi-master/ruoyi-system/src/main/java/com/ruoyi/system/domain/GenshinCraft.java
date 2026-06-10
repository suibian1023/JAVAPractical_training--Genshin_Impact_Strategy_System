package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 原神锻造配方对象 genshin_craft
 * 
 * @author ruoyi
 */
public class GenshinCraft extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 配方ID */
    private Long id;

    /** 配方名称 */
    @Excel(name = "配方名称")
    private String name;

    /** 分类筛选文本 */
    @Excel(name = "分类筛选文本")
    private String filterText;

    /** 排序序号 */
    @Excel(name = "排序序号")
    private Long sortOrder;

    /** 解锁等级要求 */
    @Excel(name = "解锁等级要求")
    private Long unlockRank;

    /** 产出数量 */
    @Excel(name = "产出数量")
    private Long resultCount;

    /** 摩拉消耗 */
    @Excel(name = "摩拉消耗")
    private Long moraCost;

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

    public void setFilterText(String filterText) 
    {
        this.filterText = filterText;
    }

    public String getFilterText() 
    {
        return filterText;
    }

    public void setSortOrder(Long sortOrder) 
    {
        this.sortOrder = sortOrder;
    }

    public Long getSortOrder() 
    {
        return sortOrder;
    }

    public void setUnlockRank(Long unlockRank) 
    {
        this.unlockRank = unlockRank;
    }

    public Long getUnlockRank() 
    {
        return unlockRank;
    }

    public void setResultCount(Long resultCount) 
    {
        this.resultCount = resultCount;
    }

    public Long getResultCount() 
    {
        return resultCount;
    }

    public void setMoraCost(Long moraCost) 
    {
        this.moraCost = moraCost;
    }

    public Long getMoraCost() 
    {
        return moraCost;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("name", getName())
            .append("filterText", getFilterText())
            .append("sortOrder", getSortOrder())
            .append("unlockRank", getUnlockRank())
            .append("resultCount", getResultCount())
            .append("moraCost", getMoraCost())
            .toString();
    }
}
