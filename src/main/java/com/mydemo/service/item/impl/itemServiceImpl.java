package com.mydemo.service.item.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.mydemo.domain.TbItem;
import com.mydemo.mapper.TbItemMapper;
import com.mydemo.service.item.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class itemServiceImpl implements ItemService {
    @Autowired
    private TbItemMapper tbItemMapper;

    @Override
    public int save(TbItem tbItem) {
        return tbItemMapper.insertSelective(tbItem);
    }

    @Override
    public Page<TbItem> findByPage(int pageNo, int pageSize) {
        PageHelper.startPage(pageNo,pageSize);
        return tbItemMapper.findByPage();
    }

    @Override
    public void deleteById(Long id) {
        tbItemMapper.deleteByPrimaryKey(id);
    }
}
