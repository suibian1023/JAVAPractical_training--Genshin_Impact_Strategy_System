package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.Materials;

/**
 * 原神素材信息Service接口
 * 
 * @author ruoyi
 */
public interface IMaterialsService 
{
    public Materials selectMaterialsById(Long id);

    public List<Materials> selectMaterialsList(Materials materials);
    
    public Materials selectMaterialsByName(String name);
}
