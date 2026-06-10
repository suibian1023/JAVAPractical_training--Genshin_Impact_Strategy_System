package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.MaterialsMapper;
import com.ruoyi.system.domain.Materials;
import com.ruoyi.system.service.IMaterialsService;

/**
 * 原神素材信息Service业务层处理
 * 
 * @author ruoyi
 */
@Service
public class MaterialsServiceImpl implements IMaterialsService
{
    @Autowired
    private MaterialsMapper materialsMapper;

    @Override
    public Materials selectMaterialsById(Long id)
    {
        return materialsMapper.selectMaterialsById(id);
    }

    @Override
    public List<Materials> selectMaterialsList(Materials materials)
    {
        return materialsMapper.selectMaterialsList(materials);
    }

    @Override
    public Materials selectMaterialsByName(String name)
    {
        return materialsMapper.selectMaterialsByName(name);
    }
}
