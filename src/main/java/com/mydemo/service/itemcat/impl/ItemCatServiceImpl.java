package com.mydemo.service.itemcat.impl;

import com.mydemo.domain.TbItemCat;
import com.mydemo.domain.TbItemCatTreeData;
import com.mydemo.mapper.TbItemCatMapper;
import com.mydemo.service.itemcat.ItemCatService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class ItemCatServiceImpl implements ItemCatService{
    @Autowired
    private TbItemCatMapper tbItemCatMapper;


    @Override
    public List<TbItemCatTreeData> getTbItemCatList() {
        return tbItemCatMapper.getTbItemCatList();
    }
}
