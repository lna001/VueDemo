package com.mydemo.service.itemcat;

import  com.mydemo.domain.TbItemCat;
import com.mydemo.domain.TbItemCatTreeData;

import java.util.List;


public interface ItemCatService {
    /***
     * 获得所有List数据
     * @return
     */
    List<TbItemCatTreeData> getTbItemCatList();


}
