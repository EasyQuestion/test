package com.mmh.tddtest;

/**
 * @author mumh@2423528736@qq.com
 * @date 2019/4/23 10:00
 */
public interface UserService {
    User showUser()throws Exception;
    int saveUser(User user)throws Exception;
    int deleteUser(String userName);
    int changeUser(User user);

    int login(int userId) throws Exception;
}
