package com.mmh.tddtest;

import net.minidev.json.JSONValue;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


/**
 * @author mumh@2423528736@qq.com
 * @date 2019/4/23 16:45
 */
@RunWith(SpringRunner.class)
@WebMvcTest(UserController.class)
public class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    UserService userService;

    @Test
    public void saveUser()throws Exception{
        User user = new User();
//        user.setUserName("Lee");
        Mockito.when(userService.saveUser(Mockito.any())).thenReturn(1);

        mockMvc.perform(post("/saveUser")
                .param("userName","Lee"))
                .andDo(data-> System.out.println(data.getResponse().getContentAsString()))
                .andExpect(status().isOk())
//                .andExpect(jsonPath("name").exists())
//                .andExpect(jsonPath("time").value("4545"))
                .andReturn();
        Mockito.verify(userService, Mockito.times(1)).saveUser(Mockito.any());
    }
}
