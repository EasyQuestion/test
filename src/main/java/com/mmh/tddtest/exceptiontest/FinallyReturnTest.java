package com.mmh.tddtest.exceptiontest;

/**
 * @author mumh@2423528736@qq.com
 * @date 2019/5/7 10:20
 */
public class FinallyReturnTest {

    public static void main(String[] args) {
        int i = 1;

        int j = 0;

        try {

            System.out.println("try........");

            divsion(i, j);

        } catch (Exception e) {

            System.out.println("catch.........");

        } finally {

            System.out.println("finally........");

        }

    }

    static int divsion(int i, int j) {

        int k=0;
        try {

            k = i / j;

        } catch (Exception e) {

            System.out.println("[divsion] catch.........");

            throw e;

        } finally {

            System.out.println("[divsion] finally.........");

//            return k;

        }

        return k;

    }
//    static int divsion(int i, int j) {
//
//        try {
//
//            int k = i / j;
//
//        } catch (Exception e) {
//
//            System.out.println("[divsion] catch.........");
//
//            throw e;
//
//        } finally {
//
//            System.out.println("[divsion] finally.........");
//
//            return 0;
//
//        }
//
//
//
//    }
}
