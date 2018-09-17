package com.mydemo.domain;


import com.mydemo.common.DataTree;

import java.util.List;

/****
 * 生成树数据的接收类
 */

public class TbItemCatTreeData implements DataTree<TbItemCatTreeData>{
    private String id;
    private String parentId;
    private String label;
    private List<TbItemCatTreeData> children;

    public List<TbItemCatTreeData> getChildren() {
        return children;
    }

    public void setChildren(List<TbItemCatTreeData> children) {
        this.children = children;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    @Override

    public String getId() {
        return this.id;
    }
    @Override
    public String getParentId() {
        return this.parentId;
    }


}
