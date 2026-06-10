package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 推荐武器对象 genshin_recommend_weapon
 * 
 * @author ruoyi
 * @date 2026-05-29
 */
public class GenshinRecommendWeapon extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long id;

    /** 角色ID */
    @Excel(name = "角色ID")
    private Long characterId;

    /** 推荐武器ID */
    @Excel(name = "推荐武器ID")
    private Long weaponId;

    /** 推荐梯度: T0专武/T1极佳/T2过渡 */
    @Excel(name = "推荐梯度: T0专武/T1极佳/T2过渡")
    private String recommendDegree;

    // ==================== 💡 核心手工补全：多表联查扩展属性 ====================

    /** 角色名称 */
    private String characterName;

    /** 武器名称 */
    private String weaponName;

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

    public void setWeaponId(Long weaponId) 
    {
        this.weaponId = weaponId;
    }

    public Long getWeaponId() 
    {
        return weaponId;
    }

    public void setRecommendDegree(String recommendDegree) 
    {
        this.recommendDegree = recommendDegree;
    }

    public String getRecommendDegree() 
    {
        return recommendDegree;
    }

    // ==================== 💡 核心手工补全：扩展属性的 Getter / Setter ====================

    public String getCharacterName() { return characterName; }
    public void setCharacterName(String characterName) { this.characterName = characterName; }

    public String getWeaponName() { return weaponName; }
    public void setWeaponName(String weaponName) { this.weaponName = weaponName; }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("characterId", getCharacterId())
            .append("weaponId", getWeaponId())
            .append("recommendDegree", getRecommendDegree())
            .append("remark", getRemark())
            .append("characterName", getCharacterName())
            .append("weaponName", getWeaponName())
            .toString();
    }
}
