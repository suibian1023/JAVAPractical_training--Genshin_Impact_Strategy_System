package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 配队推荐对象 genshin_recommend_team
 * * @author ruoyi
 * @date 2026-05-29
 */
public class GenshinRecommendTeam extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键ID */
    private Long id;

    /** 队伍名称(如: 雷九万班 / 神鹤万心) */
    @Excel(name = "队伍名称(如: 雷九万班 / 神鹤万心)")
    private String teamName;

    /** 1号位角色ID(主C) */
    @Excel(name = "1号位角色ID(主C)")
    private Long char1Id;

    /** 2号位角色ID(副C) */
    @Excel(name = "2号位角色ID(副C)")
    private Long char2Id;

    /** 3号位角色ID(增伤/辅助) */
    @Excel(name = "3号位角色ID(增伤/辅助)")
    private Long char3Id;

    /** 4号位角色ID(生存/盾奶) */
    @Excel(name = "4号位角色ID(生存/盾奶)")
    private Long char4Id;

    /** 元素共鸣效果 */
    @Excel(name = "元素共鸣效果")
    private String teamBonus;

    /** 输出手法/队伍简评 */
    @Excel(name = "输出手法/队伍简评")
    private String rotation;

    // ==================== 💡 核心手工补全：多表联查扩展属性 ====================

    private String char1Name;
    private String char2Name;
    private String char3Name;
    private String char4Name;

    // ==================== 标准原生属性的 Getter / Setter ====================

    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getId()
    {
        return id;
    }

    public void setTeamName(String teamName)
    {
        this.teamName = teamName;
    }

    public String getTeamName()
    {
        return teamName;
    }

    public void setChar1Id(Long char1Id)
    {
        this.char1Id = char1Id;
    }

    public Long getChar1Id()
    {
        return char1Id;
    }

    public void setChar2Id(Long char2Id)
    {
        this.char2Id = char2Id;
    }

    public Long getChar2Id()
    {
        return char2Id;
    }

    public void setChar3Id(Long char3Id)
    {
        this.char3Id = char3Id;
    }

    public Long getChar3Id()
    {
        return char3Id;
    }

    public void setChar4Id(Long char4Id)
    {
        this.char4Id = char4Id;
    }

    public Long getChar4Id()
    {
        return char4Id;
    }

    public void setTeamBonus(String teamBonus)
    {
        this.teamBonus = teamBonus;
    }

    public String getTeamBonus()
    {
        return teamBonus;
    }

    public void setRotation(String rotation)
    {
        this.rotation = rotation;
    }

    public String getRotation()
    {
        return rotation;
    }

    // ==================== 💡 核心手工补全：扩展属性的 Getter / Setter ====================

    public String getChar1Name() { return char1Name; }
    public void setChar1Name(String char1Name) { this.char1Name = char1Name; }

    public String getChar2Name() { return char2Name; }
    public void setChar2Name(String char2Name) { this.char2Name = char2Name; }

    public String getChar3Name() { return char3Name; }
    public void setChar3Name(String char3Name) { this.char3Name = char3Name; }

    public String getChar4Name() { return char4Name; }
    public void setChar4Name(String char4Name) { this.char4Name = char4Name; }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("id", getId())
                .append("teamName", getTeamName())
                .append("char1Id", getChar1Id())
                .append("char2Id", getChar2Id())
                .append("char3Id", getChar3Id())
                .append("char4Id", getChar4Id())
                .append("teamBonus", getTeamBonus())
                .append("rotation", getRotation())
                .append("char1Name", getChar1Name())
                .append("char2Name", getChar2Name())
                .append("char3Name", getChar3Name())
                .append("char4Name", getChar4Name())
                .toString();
    }
}