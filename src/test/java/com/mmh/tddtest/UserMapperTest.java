package com.mmh.tddtest;

import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author mumh@2423528736@qq.com
 * @date 2019/4/23 17:58
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
@Sql(value="classpath:user.sql")
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class UserMapperTest {

    @Autowired
    private UserMapper userMapper;

    private User user1;
    private User user2;

    @Before
    public void before(){
        user1 = new User();
        user1.setUserName("Jenny");
        user2 = new User();
        user2.setUserName("LiMing");
    }

    @Test
    public void saveUserTest(){
        Assert.assertEquals(1,userMapper.saveUser(user1));
    }
}
