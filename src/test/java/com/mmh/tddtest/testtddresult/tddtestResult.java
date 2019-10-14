package com.mmh.tddtest.testtddresult;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

/**
 * @author mumh@2423528736@qq.com
 * @date 2019/4/25 9:24
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class tddtestResult {

    private IUserService userService;
    private List<String> list;

    @Before
    public void before() {
        userService=new UserServiceImpl();
        list=Mockito.mock(List.class);
    }
    @Test
    public void test1() {
        userService.getUsername(list);
        Mockito.verify(list,Mockito.times(1)).size();
    }

    @Test
    public void test2() {
        userService=Mockito.mock(IUserService.class);
        userService.getUsername(list);
        Mockito.verify(list,Mockito.times(0)).size();
    }


//    private static final String name1="Mockito1";
//    private static final String name2="Mockito2";
//    private IUserService userService;
//    @Before
//    public void before() {
//        userService=Mockito.mock(IUserService.class);
//    }
//
//    @Test
//    public void test1() {
//        Mockito.when(userService.getUsername(11)).thenReturn(name1);
//        Assert.assertEquals(name1, userService.getUsername(11));
//    }
//    @Test
//    public void test2() {
//        Mockito.when(userService.getUsername(Mockito.anyInt())).thenReturn(name2);
//        Assert.assertEquals(name2, userService.getUsername(11));
//    }
//
//    @Test(expected = IllegalArgumentException.class)
//    public void test3() {
//        Mockito.when(userService.getUsername(Mockito.anyInt())).thenReturn(name2);
//        Assert.assertEquals(name2, userService.getUsername(11));
//    }
//    @Test(expected = RuntimeException.class)
//    public void test4() {
//        Mockito.when(userService.getUsername(Mockito.anyInt())).thenThrow(new
//                IllegalArgumentException("数据非法"));
//        Assert.assertEquals(name2, userService.getUsername(11));
//    }

//    @Test
//    public void test3(){
//        Mockito.when(userService.getUsername("1")).thenReturn(name1);
//        Assert.assertEquals(name1,userService.getUsername("1"));
//    }
//    @Test
//    public void test4() {
//        Mockito.when(userService.getUsername(Mockito.anyString())).thenReturn(name2);
//        Assert.assertEquals(name2,userService.getUsername("3"));
//    }

//    private List<String> list;
//    private List<String> list2;
//
//
//    @Before
//    public void beforeClass() {
//        list = Mockito.mock(List.class);
//        list2=new ArrayList<>();
//    }
//
//    @Test
//    public void test1() {
//        Mockito.when(list.get(1)).thenReturn("2");
//        Assert.assertEquals("2",list.get(1));
//    }
//
//    @Test
//    public void test2() {
//        Mockito.when(list2.get(1)).thenReturn("2");
//        Assert.assertEquals("2",list2.get(1));
//    }


//    @Test
//    public void test1(){
//        Assert.assertEquals(1L,1);
//    }
//    @Test(expected = RuntimeException.class)
//    public void test2(){
//        Assert.assertEquals(1,1/0);
//    }
//
//    @Test
//    public void test4(){
//        Assert.assertEquals("1",1);
//    }
}
