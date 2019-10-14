package com.mmh.tddtest;

import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

/**
 * @author mumh@2423528736@qq.com
 * @date 2019/4/23 9:57
 */
@Repository
@Mapper
public interface UserMapper {

    @Select("SELECT userId,userName FROM t_user WHERE userId='1'")
    User showUser()throws Exception;

    @Update("UPDATE t_user SET userName=#{userName} WHERE userId=#{userId}")
    int changeUser(User user);

    @Insert("INSERT INTO t_user(userName)VALUES(#{userName})")
    int saveUser(User user);

    @Delete("DELETE FROM t_user WHERE userName=#{userName}")
    int deleteUser(String userName);
}
