package com.mydemo.service.user.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.mydemo.domain.User;
import com.mydemo.mapper.UserMapper;
import com.mydemo.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
     private UserMapper userMapper;

    @Override
    public User getUserById(int id) {

        return userMapper.selectByPrimaryKey(id);
    }

    @Override
    public Page<User> findByPage(int pageNo, int pageSize) {
        PageHelper.startPage(pageNo,pageSize);
        return userMapper.findByPage();
    }


}
