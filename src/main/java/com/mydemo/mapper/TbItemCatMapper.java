package com.mydemo.mapper;

import com.mydemo.domain.TbItemCat;
import com.mydemo.domain.TbItemCatTreeData;
import org.apache.ibatis.annotations.MapKey;

import java.util.List;
import java.util.Map;

public interface TbItemCatMapper {
    int deleteByPrimaryKey(Long id);

    int insert(TbItemCat record);

    int insertSelective(TbItemCat record);

    TbItemCat selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(TbItemCat record);

    int updateByPrimaryKey(TbItemCat record);
    @MapKey("id")
    Map<Object, TbItemCat> getTbItemCatMap();

    List<TbItemCatTreeData> getTbItemCatList();
}