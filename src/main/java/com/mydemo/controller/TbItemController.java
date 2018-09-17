package com.mydemo.controller;


import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import com.mydemo.domain.TbItem;
import com.mydemo.domain.User;
import com.mydemo.service.item.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;
import java.util.Objects;

/****
 * 商品表业务控制层
 */
@Controller
@RequestMapping("/TbItem")
public class TbItemController {
     @Autowired
     private ItemService itemService;
    // 上传文件存储目录
    private static final String UPLOAD_FOLDER = "src/main/resources/static/upload/";
    @ResponseBody
    @RequestMapping(value="/uploadFile", method= RequestMethod.POST)
    public ModelMap uploadFile(MultipartFile file){
        ModelMap modelmap=new ModelMap();
        if (Objects.isNull(file) || file.isEmpty()) {
            modelmap.put("err", "文件为空，请重新上传");
        }
        try {
            byte[] bytes = file.getBytes();
            String fileName=file.getOriginalFilename();
            Path path = Paths.get(UPLOAD_FOLDER + fileName);
            //如果没有files文件夹，则创建
            if (!Files.isWritable(path)) {
                Files.createDirectories(Paths.get(UPLOAD_FOLDER));
            }
            //文件写入指定路径
            Files.write(path, bytes);
            modelmap.put("fileName", fileName);
        } catch (IOException e) {
            e.printStackTrace();
            modelmap.put("err", "后端异常");

        }
        return  modelmap;
    }


    /******
     * 分页查询数据
     * @param pageNo
     * @param pageSize
     * @return
     */
    @ResponseBody
    @RequestMapping(value="/list", method=RequestMethod.GET)
    public ModelMap list (int pageNo, int pageSize){
        ModelMap modelMap =new ModelMap();
        try{
            Page<TbItem> itemList=itemService.findByPage(pageNo,pageSize);
            //获取分页查询后的数据
            PageInfo<TbItem> pageInfo=new PageInfo<TbItem>(itemList);
            modelMap.put("itemList", itemList);
            // 总记录数
            modelMap.put("total", pageInfo.getTotal());
            // 当前页
            modelMap.put("courrentPage", pageInfo.getPageNum());
        }catch(Exception e){
            e.printStackTrace();
        }
        return  modelMap;
    }
    @ResponseBody
    @RequestMapping(value="/save", method= RequestMethod.POST)
    public ModelMap save(@RequestBody TbItem tbItem ){
        ModelMap modelmap=new ModelMap();
        try {
            tbItem.setCreated(new Date());
            tbItem.setUpdated(new Date());
            tbItem.setImage(tbItem.getImage().substring(0,tbItem.getImage().length()-1));
            int id= itemService.save(tbItem);
            modelmap.put("success","success");
            modelmap.put("msg","保存成功");
        }catch (Exception e){
            e.printStackTrace();
            modelmap.put("err", "后端异常");


        }
        return  modelmap;
    }
    @ResponseBody
    @RequestMapping(value="/delete", method= RequestMethod.POST)
    public ModelMap delete(@RequestBody TbItem tbItem ){
        ModelMap modelmap=new ModelMap();
        String success="filed";
        try {
            itemService.deleteById(tbItem.getId());
            success="success";
            modelmap.put("success",success);
        }catch (Exception e){
            modelmap.put("success",success);
            e.printStackTrace();

        }
        return  modelmap;
    }



}
