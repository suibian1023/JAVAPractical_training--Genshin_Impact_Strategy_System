package com.ruoyi.system.domain;

import java.math.BigDecimal;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 原神怪物掉落奖励对象 genshin_enemy_reward
 * 
 * @author ruoyi
 * @date 2026-05-29
 */
public class GenshinEnemyReward extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 自增主键 */
    private Long id;

    /** 怪物ID */
    @Excel(name = "怪物ID")
    private Long enemyId;

    /** 物品ID */
    @Excel(name = "物品ID")
    private Long itemId;

    /** 物品名称 */
    @Excel(name = "物品名称")
    private String itemName;

    /** 掉落数量（可为小数，表示概率） */
    @Excel(name = "掉落数量", readConverterExp = "可=为小数，表示概率")
    private BigDecimal itemCount;

    /** 物品稀有度 */
    @Excel(name = "物品稀有度")
    private Long itemRarity;

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

    public void setItemCount(BigDecimal itemCount) 
    {
        this.itemCount = itemCount;
    }

    public BigDecimal getItemCount() 
    {
        return itemCount;
    }

    public void setItemRarity(Long itemRarity) 
    {
        this.itemRarity = itemRarity;
    }

    public Long getItemRarity() 
    {
        return itemRarity;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("enemyId", getEnemyId())
            .append("itemId", getItemId())
            .append("itemName", getItemName())
            .append("itemCount", getItemCount())
            .append("itemRarity", getItemRarity())
            .toString();
    }
}
