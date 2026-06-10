package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 角色圣遗物推荐对象 genshin_recommend_artifact
 * 
 * @author ruoyi
 * @date 2026-05-29
 */
public class GenshinRecommendArtifact extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long id;

    /** 角色ID */
    @Excel(name = "角色ID")
    private Long characterId;

    private String characterName;

    /** 推荐圣遗物套装ID */
    @Excel(name = "推荐圣遗物套装ID")
    private Long artifactId;

    private String artifactName;

    /** 件套需求: 4件套/2件套 */
    @Excel(name = "件套需求: 4件套/2件套")
    private Long pieces;

    /** 沙漏主词条推荐(如: 攻击力/充能) */
    @Excel(name = "沙漏主词条推荐(如: 攻击力/充能)")
    private String sandStat;

    /** 杯子主词条推荐(如: 冰元素伤害/物理伤害) */
    @Excel(name = "杯子主词条推荐(如: 冰元素伤害/物理伤害)")
    private String cupStat;

    /** 头冠主词条推荐(如: 暴击率/暴击伤害) */
    @Excel(name = "头冠主词条推荐(如: 暴击率/暴击伤害)")
    private String crownStat;

    /** 副词条优先级(如: 双暴>攻击>充能) */
    @Excel(name = "副词条优先级(如: 双暴>攻击>充能)")
    private String subStats;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }

    public void setCharacterId(Long characterId) 
    {
        this.characterId = characterId;
    }

    public Long getCharacterId() 
    {
        return characterId;
    }

    public String getCharacterName() {
        return characterName;
    }

    public void setCharacterName(String characterName) {
        this.characterName = characterName;
    }

    public void setArtifactId(Long artifactId) 
    {
        this.artifactId = artifactId;
    }

    public Long getArtifactId() 
    {
        return artifactId;
    }

    public String getArtifactName() {
        return artifactName;
    }

    public void setArtifactName(String artifactName) {
        this.artifactName = artifactName;
    }

    public void setPieces(Long pieces) 
    {
        this.pieces = pieces;
    }

    public Long getPieces() 
    {
        return pieces;
    }

    public void setSandStat(String sandStat) 
    {
        this.sandStat = sandStat;
    }

    public String getSandStat() 
    {
        return sandStat;
    }

    public void setCupStat(String cupStat) 
    {
        this.cupStat = cupStat;
    }

    public String getCupStat() 
    {
        return cupStat;
    }

    public void setCrownStat(String crownStat) 
    {
        this.crownStat = crownStat;
    }

    public String getCrownStat() 
    {
        return crownStat;
    }

    public void setSubStats(String subStats) 
    {
        this.subStats = subStats;
    }

    public String getSubStats() 
    {
        return subStats;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("characterId", getCharacterId())
            .append("artifactId", getArtifactId())
            .append("pieces", getPieces())
            .append("sandStat", getSandStat())
            .append("cupStat", getCupStat())
            .append("crownStat", getCrownStat())
            .append("subStats", getSubStats())
            .toString();
    }
}
