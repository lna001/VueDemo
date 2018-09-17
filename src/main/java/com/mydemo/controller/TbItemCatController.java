package com.mydemo.controller;

import com.mydemo.domain.TbItemCat;
import com.mydemo.domain.TbItemCatTreeData;
import com.mydemo.service.itemcat.ItemCatService;
import com.mydemo.utils.TreeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("TbItemCart")
public class TbItemCatController {
     @Autowired
     private ItemCatService itemCatService;
    @ResponseBody
    @RequestMapping(value="/ItemCatTree", method= RequestMethod.GET)
    public ModelMap ItemCatTree(){
        ModelMap modelmap=new ModelMap();
        try{
            //查询所有数据
            List<TbItemCatTreeData>  TbItemCatTreeList=itemCatService.getTbItemCatList();
            //通过工具转化数据
            List<TbItemCatTreeData> tree = TreeUtils.getTreeList("0", TbItemCatTreeList);
            modelmap.put("data",tree);
        }catch(Exception e){
            e.printStackTrace();
        }
        return  modelmap;
    }

}
