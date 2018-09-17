package com.mydemo.mapper;

import com.github.pagehelper.Page;
import com.mydemo.domain.TbItem;
import com.mydemo.domain.User;

public interface TbItemMapper {
    int deleteByPrimaryKey(Long id);

    int insert(TbItem record);

    int insertSelective(TbItem record);

    TbItem selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(TbItem record);

    int updateByPrimaryKey(TbItem record);
    /***
     * 分页查询
     * @return
     */
    Page<TbItem > findByPage();
}