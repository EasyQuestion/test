package com.mmh.tddtest.testtddresult;

import java.util.List;

/**
 * @author mumh@2423528736@qq.com
 * @date 2019/4/25 9:32
 */
public interface IUserService {
    String getUsername(int id);

    String getUsername(String id);
    int insertUser(UserDTO userDTO);

    String getUsername(List<String> list);
}
