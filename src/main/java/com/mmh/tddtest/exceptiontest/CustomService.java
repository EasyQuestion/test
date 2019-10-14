package com.mmh.tddtest.exceptiontest;

import java.util.ArrayList;
import java.util.List;

/**
 * @author mumh@2423528736@qq.com
 * @date 2019/4/24 10:03
 */
public class CustomService {

    public Customer findByName(String name)throws NameNotFoundException{
        if("".equalsIgnoreCase(name)){
            throw new NameNotFoundException(666,"Name is empty!");
        }
        return new Customer(name);
    }

    static class Customer{
        private String name;

        public Customer(String name) {
            super();
            this.name = name;
        }
    }
}
