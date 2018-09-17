package com.mydemo.service.item;

import com.github.pagehelper.Page;
import com.mydemo.domain.TbItem;



public interface ItemService {
    int save(TbItem tbItem);
    /****
     * 分页查询
     * @param pageNo 页号
     * @param pageSize 每页显示的记录数
     * @return
     */
    Page<TbItem> findByPage(int pageNo, int pageSize);
    void deleteById(Long  id);
}
