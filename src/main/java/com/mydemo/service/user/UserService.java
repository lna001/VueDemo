package com.mydemo.service.user;

import com.github.pagehelper.Page;
import com.mydemo.domain.User;

public interface UserService {
    User getUserById(int id);

    /****
     * 分页查询
     * @param pageNo 页号
     * @param pageSize 每页显示的记录数
     * @return
     */
    Page<User> findByPage(int pageNo, int pageSize);


}
