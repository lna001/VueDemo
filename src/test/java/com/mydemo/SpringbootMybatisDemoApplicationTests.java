package com.mydemo;

import com.mydemo.domain.TbItemCat;
import com.mydemo.domain.TbItemCatTreeData;
import com.mydemo.service.itemcat.ItemCatService;

import com.mydemo.utils.TreeUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootMybatisDemoApplicationTests {
	@Autowired
	private ItemCatService itemCatService;
	@Test
	public void contextLoads() {
	}

	@Test
	public void selectMap() {

		List<TbItemCatTreeData>  TbItemCatTreeList=itemCatService.getTbItemCatList();
		//通过工具转化数据
		List<TbItemCatTreeData> tree = TreeUtils.getTreeList("0", TbItemCatTreeList);
		System.out.print(tree);
	}



}
