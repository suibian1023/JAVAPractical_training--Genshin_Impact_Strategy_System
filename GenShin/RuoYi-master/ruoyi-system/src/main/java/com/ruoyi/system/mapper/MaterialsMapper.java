package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.Materials;

/**
 * 原神素材信息Mapper接口
 * 
 * @author ruoyi
 */
public interface MaterialsMapper 
{
    public Materials selectMaterialsById(Long id);

    public List<Materials> selectMaterialsList(Materials materials);
    
    public Materials selectMaterialsByName(String name);
}
