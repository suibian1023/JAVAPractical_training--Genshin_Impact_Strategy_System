package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.GenshinCraftMapper;
import com.ruoyi.system.domain.GenshinCraft;
import com.ruoyi.system.domain.GenshinCraftRecipe;
import com.ruoyi.system.service.IGenshinCraftService;

/**
 * 原神锻造配方Service业务层处理
 * 
 * @author ruoyi
 */
@Service
public class GenshinCraftServiceImpl implements IGenshinCraftService
{
    @Autowired
    private GenshinCraftMapper genshinCraftMapper;

    @Override
    public GenshinCraft selectGenshinCraftById(Long id)
    {
        return genshinCraftMapper.selectGenshinCraftById(id);
    }

    @Override
    public List<GenshinCraft> selectGenshinCraftList(GenshinCraft genshinCraft)
    {
        return genshinCraftMapper.selectGenshinCraftList(genshinCraft);
    }

    @Override
    public GenshinCraft selectGenshinCraftByName(String name)
    {
        return genshinCraftMapper.selectGenshinCraftByName(name);
    }

    @Override
    public List<GenshinCraftRecipe> selectGenshinCraftRecipeByCraftId(Long craftId)
    {
        return genshinCraftMapper.selectGenshinCraftRecipeByCraftId(craftId);
    }
}
