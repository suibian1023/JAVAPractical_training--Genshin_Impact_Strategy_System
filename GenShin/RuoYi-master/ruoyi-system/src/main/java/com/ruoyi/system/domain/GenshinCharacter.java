package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 原神角色基础信息对象 genshin_character
 * 
 * @author ruoyi
 * @date 2026-05-29
 */
public class GenshinCharacter extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 角色唯一ID */
    private Long id;

    /** 角色名称 */
    @Excel(name = "角色名称")
    private String name;

    /** 角色称号 */
    @Excel(name = "角色称号")
    private String title;

    /** 角色描述 */
    @Excel(name = "角色描述")
    private String description;

    /** 武器类型编码 */
    @Excel(name = "武器类型编码")
    private String weaponType;

    /** 武器类型名称 */
    @Excel(name = "武器类型名称")
    private String weaponText;

    /** 体型编码 */
    @Excel(name = "体型编码")
    private String bodyType;

    /** 性别 */
    @Excel(name = "性别")
    private String gender;

    /** 品质编码 */
    @Excel(name = "品质编码")
    private String qualityType;

    /** 星级 */
    @Excel(name = "星级")
    private Long rarity;

    /** 生日月日 */
    @Excel(name = "生日月日")
    private String birthdayMmdd;

    /** 生日 */
    @Excel(name = "生日")
    private String birthday;

    /** 元素编码 */
    @Excel(name = "元素编码")
    private String elementType;

    /** 元素名称 */
    @Excel(name = "元素名称")
    private String elementText;

    /** 所属组织 */
    @Excel(name = "所属组织")
    private String affiliation;

    /** 阵营类型 */
    @Excel(name = "阵营类型")
    private String associationType;

    /** 地区 */
    @Excel(name = "地区")
    private String region;

    /** 副属性编码 */
    @Excel(name = "副属性编码")
    private String substatType;

    /** 副属性名称 */
    @Excel(name = "副属性名称")
    private String substatText;

    /** 命之座 */
    @Excel(name = "命之座")
    private String constellation;

    /** 中文CV */
    @Excel(name = "中文CV")
    private String cvChinese;

    /** 英文CV */
    @Excel(name = "英文CV")
    private String cvEnglish;

    /** 日文CV */
    @Excel(name = "日文CV")
    private String cvJapanese;

    /** 韩文CV */
    @Excel(name = "韩文CV")
    private String cvKorean;

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

    public void setTitle(String title) 
    {
        this.title = title;
    }

    public String getTitle() 
    {
        return title;
    }

    public void setDescription(String description) 
    {
        this.description = description;
    }

    public String getDescription() 
    {
        return description;
    }

    public void setWeaponType(String weaponType) 
    {
        this.weaponType = weaponType;
    }

    public String getWeaponType() 
    {
        return weaponType;
    }

    public void setWeaponText(String weaponText) 
    {
        this.weaponText = weaponText;
    }

    public String getWeaponText() 
    {
        return weaponText;
    }

    public void setBodyType(String bodyType) 
    {
        this.bodyType = bodyType;
    }

    public String getBodyType() 
    {
        return bodyType;
    }

    public void setGender(String gender) 
    {
        this.gender = gender;
    }

    public String getGender() 
    {
        return gender;
    }

    public void setQualityType(String qualityType) 
    {
        this.qualityType = qualityType;
    }

    public String getQualityType() 
    {
        return qualityType;
    }

    public void setRarity(Long rarity) 
    {
        this.rarity = rarity;
    }

    public Long getRarity() 
    {
        return rarity;
    }

    public void setBirthdayMmdd(String birthdayMmdd) 
    {
        this.birthdayMmdd = birthdayMmdd;
    }

    public String getBirthdayMmdd() 
    {
        return birthdayMmdd;
    }

    public void setBirthday(String birthday) 
    {
        this.birthday = birthday;
    }

    public String getBirthday() 
    {
        return birthday;
    }

    public void setElementType(String elementType) 
    {
        this.elementType = elementType;
    }

    public String getElementType() 
    {
        return elementType;
    }

    public void setElementText(String elementText) 
    {
        this.elementText = elementText;
    }

    public String getElementText() 
    {
        return elementText;
    }

    public void setAffiliation(String affiliation) 
    {
        this.affiliation = affiliation;
    }

    public String getAffiliation() 
    {
        return affiliation;
    }

    public void setAssociationType(String associationType) 
    {
        this.associationType = associationType;
    }

    public String getAssociationType() 
    {
        return associationType;
    }

    public void setRegion(String region) 
    {
        this.region = region;
    }

    public String getRegion() 
    {
        return region;
    }

    public void setSubstatType(String substatType) 
    {
        this.substatType = substatType;
    }

    public String getSubstatType() 
    {
        return substatType;
    }

    public void setSubstatText(String substatText) 
    {
        this.substatText = substatText;
    }

    public String getSubstatText() 
    {
        return substatText;
    }

    public void setConstellation(String constellation) 
    {
        this.constellation = constellation;
    }

    public String getConstellation() 
    {
        return constellation;
    }

    public void setCvChinese(String cvChinese) 
    {
        this.cvChinese = cvChinese;
    }

    public String getCvChinese() 
    {
        return cvChinese;
    }

    public void setCvEnglish(String cvEnglish) 
    {
        this.cvEnglish = cvEnglish;
    }

    public String getCvEnglish() 
    {
        return cvEnglish;
    }

    public void setCvJapanese(String cvJapanese) 
    {
        this.cvJapanese = cvJapanese;
    }

    public String getCvJapanese() 
    {
        return cvJapanese;
    }

    public void setCvKorean(String cvKorean) 
    {
        this.cvKorean = cvKorean;
    }

    public String getCvKorean() 
    {
        return cvKorean;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("name", getName())
            .append("title", getTitle())
            .append("description", getDescription())
            .append("weaponType", getWeaponType())
            .append("weaponText", getWeaponText())
            .append("bodyType", getBodyType())
            .append("gender", getGender())
            .append("qualityType", getQualityType())
            .append("rarity", getRarity())
            .append("birthdayMmdd", getBirthdayMmdd())
            .append("birthday", getBirthday())
            .append("elementType", getElementType())
            .append("elementText", getElementText())
            .append("affiliation", getAffiliation())
            .append("associationType", getAssociationType())
            .append("region", getRegion())
            .append("substatType", getSubstatType())
            .append("substatText", getSubstatText())
            .append("constellation", getConstellation())
            .append("cvChinese", getCvChinese())
            .append("cvEnglish", getCvEnglish())
            .append("cvJapanese", getCvJapanese())
            .append("cvKorean", getCvKorean())
            .toString();
    }
}
