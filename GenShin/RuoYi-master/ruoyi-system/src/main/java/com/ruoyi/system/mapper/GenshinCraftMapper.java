package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.GenshinCraft;
import com.ruoyi.system.domain.GenshinCraftRecipe;

/**
 * 原神锻造配方Mapper接口
 * 
 * @author ruoyi
 */
public interface GenshinCraftMapper 
{
    public GenshinCraft selectGenshinCraftById(Long id);

    public List<GenshinCraft> selectGenshinCraftList(GenshinCraft genshinCraft);
    
    public GenshinCraft selectGenshinCraftByName(String name);
    
    public List<GenshinCraftRecipe> selectGenshinCraftRecipeByCraftId(Long craftId);
}
