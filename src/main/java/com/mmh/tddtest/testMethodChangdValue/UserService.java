package com.mmh.tddtest.testMethodChangdValue;

import java.util.ArrayList;
import java.util.List;

/**
 * @author mumh@2423528736@qq.com
 * @date 2019/4/24 11:37
 */
public class UserService {

    private List<User> userList;

    public void init(){
        userList = new ArrayList<>();

        User user1 = new User();
        user1.setUserId(1);
        user1.setUserName("Jenny");

        User user2 = new User();
        user2.setUserId(2);
        user2.setUserName("Jenny");

        User user3 = new User();
        user3.setUserId(3);
        user3.setUserName("Jenny");

        User user4 = new User();
        user4.setUserId(4);
        user4.setUserName("Jenny");

        User user5 = new User();
        user5.setUserId(5);
        user5.setUserName("Jenny");

        userList.add(user1);
        userList.add(user2);
        userList.add(user3);
        userList.add(user4);
        userList.add(user5);
    }

    public void changeUserId(){
        for(User user:userList){
            user.setUserId(12);
        }
    }

    public static void main(String[] args) {
        UserService userService = new UserService();
        userService.init();
        userService.changeUserId();
        System.out.println("123");
    }
}
