package com.mydemo.mapper;

import com.github.pagehelper.Page;
import com.mydemo.domain.User;

public interface UserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    /***
     * 分页查询
     * @return
     */
    Page<User> findByPage();
}