package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.GenshinCraft;
import com.ruoyi.system.domain.GenshinCraftRecipe;

/**
 * 原神锻造配方Service接口
 * 
 * @author ruoyi
 */
public interface IGenshinCraftService 
{
    public GenshinCraft selectGenshinCraftById(Long id);

    public List<GenshinCraft> selectGenshinCraftList(GenshinCraft genshinCraft);
    
    public GenshinCraft selectGenshinCraftByName(String name);
    
    public List<GenshinCraftRecipe> selectGenshinCraftRecipeByCraftId(Long craftId);
}
