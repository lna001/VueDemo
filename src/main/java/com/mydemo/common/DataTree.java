package com.mydemo.common;

import java.util.List;

/****
 * 树形数据实体接口
 * @param  <T>
 *
 * */
public interface DataTree<T> {
    public String getId();
    public String getParentId();
    public void setChildren(List<T> childList);
    public List<T> getChildren();
}
