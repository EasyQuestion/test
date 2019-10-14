package com.mmh.tddtest;

import com.mmh.tddtest.exceptiontest.CustomService;
import com.mmh.tddtest.exceptiontest.NameNotFoundException;
import com.mmh.tddtest.readfiletest.SpringRequestKit;
import org.junit.*;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.exceptions.base.MockitoException;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.IOException;
import java.lang.reflect.Array;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.hamcrest.Matchers.hasProperty;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.fail;
import static org.junit.runners.MethodSorters.NAME_ASCENDING;

@RunWith(SpringRunner.class)
@SpringBootTest
@FixMethodOrder(value = NAME_ASCENDING)
/**MethodSorters.DEFAULT
 * 默认顺序由方法名hashcode值来决定，如果hash值大小一致，则按名字的字典顺序确定
 * MethodSorters.NAME_ASCENDING (推荐)
 * 按方法名称的进行排序，由于是按字符的字典顺序，所以以这种方式指定执行顺序会始终保持一致；
 * MethodSorters.JVM
 * 按JVM返回的方法名的顺序执行，此种方式下测试方法的执行顺序是不可预测的，即每次运行的顺序可能都不一样(JDK7里尤其如此)
 * */
public class TddtestApplicationTests {

    @Mock
    private UserService userService;

    @Before
    public void before(){
        System.out.println("before");
    }

    @BeforeClass
    public static void beforeClass(){
        System.out.println("beforeClass");
    }

    @After
    public void after(){
        System.out.println("after");
    }

    @AfterClass
    public static void afterClass(){
        System.out.println("after class");
    }

    @Ignore(value = "忽略这个测试了")
    @Test
    public void ignoreTest(){
        System.out.println("ignore this test");
    }

    @Test
    public void loginTest(){
        try {

            Mockito.when(userService.login(ArgumentMatchers.anyInt())).thenReturn(20);
            Assert.assertEquals(20,userService.login(Mockito.anyInt()));

            userService.login(1);
            Mockito.verify(userService,Mockito.times(1)).login(1);
            Mockito.when(userService.login(200)).thenThrow(new MockitoException("参数不能超过一百"));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Test(expected = Exception.class)
    public void spyTest()throws Exception{
        UserService userServiceImpl = new UserServiceImpl();
        UserService spy = Mockito.spy(userServiceImpl);
        Mockito.doReturn(20).when(spy.login(50));
        Mockito.doThrow(new MockitoException("参数不能超过一百")).when(spy).login(120);
//        Mockito.doReturn(new MockitoException("参数不能超过一百")).when(spy).login(120);
    }

    @Test
    public void saveUserTest() {
        User user = new User();
//        user.setUserName("Lee");
        int result = 0;
        try {
            result = userService.saveUser(user);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(result);
    }

    @Test
    public void demoTest(){
        System.out.println("demoTest");
    }

    @Test
    public void assertDemoTest(){
        System.out.println("assert demo test");
        Assert.assertEquals(1,1);
    }

    @Test
    public void answerTest(){
        List<String> mockList = Mockito.mock(List.class);
        Mockito.when(mockList.get(Mockito.anyInt())).thenAnswer(new CustomAnswer());
        Assert.assertEquals("hello world:0",mockList.get(0));
        Assert.assertEquals("hello world:99",mockList.get(99));
    }

    private class CustomAnswer implements Answer<String>{

        @Override
        public String answer(InvocationOnMock invocationOnMock) throws Throwable {
            System.out.println("======================="+invocationOnMock.getArguments().toString());
            return "hello world:"+invocationOnMock.getArguments()[0];
        }
    }

    //测试异常情况-----------------------------------------------------------

    /**
     * 使用@Test结合它的属性expected
     * 使用try-catch并且最后使用fail()
     * 使用@Rule和 ExpectedException
     */
    @Test(expected = ArithmeticException.class)
    public void testException(){
        int i=1/0;
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testException2(){
        new ArrayList<>().get(0);
    }

    @Test
    public void testException3(){
        try{
            int i=1/0;
            fail();
        }catch (Exception e){
            Assert.assertThat(e.getMessage(),is("/ by zero"));
        }
    }

    @Test(expected = RuntimeException.class)
    public void testException4(){
//        try {
//            new ArrayList<>().get(0);
//        }catch (Exception e){
//            Assert.assertThat(e.getMessage(),is("Index: 0, Size: 0"));
//        }
        Assert.assertEquals(1,1/0);
    }

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test
    public void testException5(){
        expectedException.expect(ArithmeticException.class);
        expectedException.expectMessage("/ by zero");
        int i=1/0;
    }

    @Test
    public void testException6() throws NameNotFoundException {
        expectedException.expect(NameNotFoundException.class);
        expectedException.expectMessage("Name is empty!");

        expectedException.expect(hasProperty("errCode"));
        expectedException.expect(hasProperty("errCode",is(666)));

        CustomService customService = new CustomService();
        customService.findByName("");
    }

    @Test(expected = NameNotFoundException.class)
    public void testException7() throws NameNotFoundException {
        CustomService customService = new CustomService();
        customService.findByName("");
    }

    @Test
    public void testException8(){
        try {
            CustomService customService = new CustomService();
            customService.findByName("");
        }catch (Exception e){
            Assert.assertThat(e.getMessage(),is("Name is empty!"));
        }
    }

    @Test
    public void readFileTest() throws IOException {
        HttpServletRequest mock = Mockito.mock(HttpServletRequest.class);
        Path path = Paths.get("user.txt");
        if(!Files.exists(path)){
            Files.createFile(path);
        }

        Files.write(path,"天天向上".getBytes(StandardCharsets.UTF_8));
        BufferedReader bufferedReader = Files.newBufferedReader(path);
        Mockito.when(mock.getReader()).thenReturn(bufferedReader);
        String str = SpringRequestKit.readData(mock);
        System.out.println(str);
    }

    @Test(timeout = 2000)
    public void testTimeout() throws InterruptedException {
        Thread.sleep(1000);
    }

    @Test
    public void testAssertNull(){
        List<User> userMap = new ArrayList<>(2);
        userMap.add(null);
        userMap.add(null);
        User user = userMap.get(0);
        Assert.assertNull("get user is null",user);

//        Assert.assertEquals("用户名不匹配","Lee","Jenny");
//        Assert.assertTrue("是否包含在其中",false);
    }

    @Test(expected = RuntimeException.class)
    public void testList(){
        List list = Mockito.mock(List.class);
        Mockito.when(list.get(0)).thenReturn("first");
        Mockito.doThrow(new RuntimeException()).when(list).get(99);
        System.out.println(list.get(0));
        System.out.println(list.get(99));
        Mockito.verify(list,Mockito.times(1)).get(0);
    }

}
