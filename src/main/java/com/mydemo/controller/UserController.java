package com.mydemo.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import com.mydemo.domain.JsonResult;
import com.mydemo.domain.User;
import com.mydemo.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("user")
public class UserController {
    @Autowired
    private UserService userService;

    /****
     * 根据ID查询用户
     * @param user1
     * @return
     */
       @ResponseBody
       @RequestMapping(value="/getUserById",method= RequestMethod.POST)
         public JsonResult getByUserId(@RequestBody User user1 ,HttpServletRequest request){
         JsonResult jsonResult= new JsonResult();
         try{
             User user=userService.getUserById(user1.getId());
             jsonResult.setResult(user);
             jsonResult.setStatus("ok");
         }catch(Exception e){

             jsonResult.setResult(e.getClass().getName() + ":" + e.getMessage());
             jsonResult.setStatus("error");
             e.printStackTrace();

         }

         return  jsonResult;
    }
    @RequestMapping(value="/hello",method= RequestMethod.GET)
    public String  hello(String  id){
         int userId=Integer.parseInt(id);

        User user=userService.getUserById(userId);
        return  "hello  " +user.getUsername();
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
            Page<User> userList=userService.findByPage(pageNo,pageSize);
             //获取分页查询后的数据
             PageInfo<User> pageInfo=new PageInfo<User>(userList);
            modelMap.put("userList", userList);
            // 总记录数
            modelMap.put("total", pageInfo.getTotal());
            // 当前页
            modelMap.put("courrentPage", pageInfo.getPageNum());
        }catch(Exception e){
            e.printStackTrace();
        }
        return  modelMap;
    }



}
