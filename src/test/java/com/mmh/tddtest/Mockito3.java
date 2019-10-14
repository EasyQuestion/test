package com.mmh.tddtest;

import com.mmh.tddtest.testtddresult.IUserService;
import com.mmh.tddtest.testtddresult.UserDTO;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author mumh@2423528736@qq.com
 * @date 2019/4/24 17:35
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class Mockito3 {
    private IUserService userService;
    private UserDTO userDTO1;
    private UserDTO userDTO2;

    @Before
    public void before() {
        userService = Mockito.mock(IUserService.class);
        userDTO1=UserDTO.builder().name("Mockito3").build();
        userDTO2=UserDTO.builder().name("Mockito3").build();
    }


    @Test
    public void test1() {
        Mockito.when(userService.insertUser(Mockito.eq(userDTO1))).thenReturn(1);
        System.out.println(userService.insertUser(userDTO2));
    }
    @Test
    public void test2() {
        Mockito.when(userService.insertUser(Mockito.any())).thenReturn(1);
        System.out.println(userService.insertUser(userDTO2));
    }
}
