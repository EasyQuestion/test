package com.mmh.tddtest.exceptiontest;

import java.util.Optional;
import java.util.function.Consumer;

/**
 * @author mumh@2423528736@qq.com
 * @date 2019/5/7 10:35
 */
public class OptionalTest {

//    public static void main(String[] args) {
//        Optional<Integer> optional1 = Optional.of(1);
////        Optional<Integer> optional2 = Optional.of(null);//参数不能是null,直接报错
//
//        Optional<Integer> optional2 = Optional.ofNullable(null);
//        Optional<Integer> optional3=Optional.ofNullable(null);
//        Optional<Integer> optional4=Optional.ofNullable(2);
//        Optional<Integer> optional5=Optional.ofNullable(2);
////        System.out.println(optional1);
////        System.out.println(optional2);
////        System.out.println(optional3);
////        System.out.println(optional4);
//
////        Object o1 = Optional.<Integer>empty();
////        Object o2 = Optional.<String>empty();
////
////        System.out.println(optional2 == optional3);//true
////        System.out.println(optional4 == optional5);//false
////        System.out.println(optional4.get().equals(optional5.get()));//true
////        System.out.println(optional2 == Optional.<Integer>empty());//true
////        System.out.println(o1 == o2);//true
//
//        System.out.println(optional1.isPresent() == true);
//        System.out.println(optional2.isPresent() == false);
//
//
//    }

//    public static void main(String[] args) {
//        Optional<Integer> optional1 = Optional.ofNullable(1);
//        Optional<Integer> optional2 = Optional.ofNullable(null);
//
//// 如果不是null,调用Consumer
//        optional1.ifPresent((t)-> {
//                System.out.println("value is " + t);
//        });
//
//// null,不调用Consumer
//        optional2.ifPresent((t)-> {
//                System.out.println("value is " + t);
//        });
//    }

    public static void main(String[] args) {
        Optional<Integer> optional1 = Optional.ofNullable(1);
        Optional<Integer> optional2 = Optional.ofNullable(null);

// orElse
//        System.out.println(optional1.orElse(1000) == 1);// true
//        System.out.println(optional2.orElse(1000) == 1000);// true
//
//        System.out.println(optional1.orElseGet(() -> {
//            return 1000;
//        }) == 1);//true
//
//        System.out.println(optional2.orElseGet(() -> {
//            return 1000;
//        }) == 1000);//true


            optional1.orElseThrow(() ->
                new IllegalStateException()
            );


        try{
            // 抛出异常
            optional2.orElseThrow(()-> new IllegalStateException());
        }catch(IllegalStateException e ){
            e.printStackTrace();
        }
    }


}
