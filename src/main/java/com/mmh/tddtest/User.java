package com.mmh.tddtest;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author mumh@2423528736@qq.com
 * @date 2019/4/23 9:48
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {


    private String userId;
    private String userName;

    public static Integer add(Integer a,Integer b){
        return a+b;
    }
}
