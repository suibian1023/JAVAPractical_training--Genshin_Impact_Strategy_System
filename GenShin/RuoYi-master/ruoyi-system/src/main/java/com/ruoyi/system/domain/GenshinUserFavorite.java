package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 用户收藏对象 genshin_user_favorite
 * 
 * @author ruoyi
 * @date 2026-05-29
 */
public class GenshinUserFavorite extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long id;

    /** 对应若依自带的 sys_user 表中的 userId */
    @Excel(name = "对应若依自带的 sys_user 表中的 userId")
    private Long userId;

    /** 收藏类型: character/team */
    @Excel(name = "收藏类型: character/team")
    private String targetType;

    /** 对应角色ID或配队ID */
    @Excel(name = "对应角色ID或配队ID")
    private Long targetId;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }

    public void setUserId(Long userId) 
    {
        this.userId = userId;
    }

    public Long getUserId() 
    {
        return userId;
    }

    public void setTargetType(String targetType) 
    {
        this.targetType = targetType;
    }

    public String getTargetType() 
    {
        return targetType;
    }

    public void setTargetId(Long targetId) 
    {
        this.targetId = targetId;
    }

    public Long getTargetId() 
    {
        return targetId;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("userId", getUserId())
            .append("targetType", getTargetType())
            .append("targetId", getTargetId())
            .append("createTime", getCreateTime())
            .toString();
    }
}
