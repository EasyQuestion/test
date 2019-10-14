package com.mmh.tddtest.testtddresult;

import java.util.List;
import java.util.StringJoiner;

/**
 * @author mumh@2423528736@qq.com
 * @date 2019/4/25 9:38
 */
public class UserServiceImpl implements IUserService {
    @Override
    public String getUsername(int id) {
        if (id>10){
            throw new IllegalArgumentException("数据非法");
        }
        StringJoiner stringJoiner=new StringJoiner("-","UserServiceImpl",
                "getUsername");
        return stringJoiner.add(String.valueOf(id)).toString();
    }

    @Override
    public String getUsername(String id) {
        return null;
    }

    @Override
    public int insertUser(UserDTO userDTO) {
        return 0;
    }

    @Override
    public String getUsername(List<String> list) {
        return String.valueOf(list.size());
    }
}
