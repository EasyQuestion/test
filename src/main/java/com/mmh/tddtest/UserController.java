package com.mmh.tddtest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author mumh@2423528736@qq.com
 * @date 2019/4/23 16:40
 */
@Controller
@RestController("/")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("showUser")
    public User showUser(){
        try {
            return userService.showUser();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @RequestMapping("saveUser")
    public String saveUser(User user){
        int result = 0;
        try {
            result = userService.saveUser(user);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if(result>0){
            return "添加成功！";
        }
        return "添加失败！";
    }

    @RequestMapping("deleteUser")
    public String deleteUser(String userName){
        int result = 0;
        try {
            result = userService.deleteUser(userName);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if(result>0){
            return "删除成功！";
        }
        return "删除失败！";
    }

    @RequestMapping("changeUser")
    public String changeUser(User user){
        int result = 0;
        try {
            result = userService.changeUser(user);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if(result>0){
            return "修改成功！";
        }
        return "修改失败！";
    }
}
