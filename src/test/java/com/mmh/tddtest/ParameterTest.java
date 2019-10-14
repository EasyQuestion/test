package com.mmh.tddtest;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

/**
 * @author mumh@2423528736@qq.com
 * @date 2019/4/24 14:12
 */
@RunWith(Parameterized.class)
public class ParameterTest {

    //声明变量存放预期值和测试数据；
    Integer expected=0;
    Integer input1=0;
    Integer input2=0;

    @Parameterized.Parameters
    public static Collection<Object[]> test(){
        return Arrays.asList(new Object[][]{
                {3,1,2},
                {4,2,2}
        });
    }

    public ParameterTest(int expected, int input1, int input2) {
        this.expected = expected;
        this.input1 = input1;
        this.input2 = input2;
    }

    @Test
    public void testAdd(){
        Assert.assertEquals(expected,new User().add(input1,input2));
    }
}
