package com.mmh.tddtest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

/**
 * @author mumh@2423528736@qq.com
 * @date 2019/4/23 11:06
 */
@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserMapper userMapper;

    @Override
    public User showUser()throws Exception{
        return userMapper.showUser();
    }

    @Override
    public int saveUser(User user)throws Exception{
        Objects.requireNonNull(user);
        return userMapper.saveUser(user);
    }

    @Override
    public int deleteUser(String userName){
        return userMapper.deleteUser(userName);
    }

    @Override
    public int changeUser(User user){
        return userMapper.changeUser(user);
    }

    @Override
    public int login(int userId) throws Exception {
        if(userId>100){
            throw new Exception("参数不能超过一百");
        }
        System.out.println("login");
        return 20;
    }
}
