package com.mmh.tddtest;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PowerMockIgnore;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.powermock.modules.junit4.PowerMockRunnerDelegate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author mumh@2423528736@qq.com
 * @date 2019/4/23 17:25
 */
//@SpringBootTest
//@RunWith(PowerMockRunner.class)
//@PowerMockRunnerDelegate(SpringRunner.class)
//@PrepareForTest({ExcelPoiUtils.class})
//@PowerMockIgnore({"javax.management.*", "javax.net.ssl.*"})

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTest {

    @Autowired
    private UserService userService;

    @MockBean
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
    public void saveUserTest()throws Exception{

        Mockito.when(userMapper.saveUser(Mockito.any())).thenReturn(1);

        Mockito.when(userService.saveUser(user1)).thenAnswer(new Answer<Integer>() {
            @Override
            public Integer answer(InvocationOnMock invocation) throws Throwable {
                User user = invocation.getArgument(0);
                user.setUserId("1");
                return 1;
            }
        });
        Assert.assertEquals(1,userService.saveUser(user1));


//        PowerMockito.mockStatic(ExcelPoiUtils.class);
//        PowerMockito.when(ExcelPoiUtils.getExcelData(Mockito.anyString(),Mockito.any())).thenReturn(excelData);

    }



}
