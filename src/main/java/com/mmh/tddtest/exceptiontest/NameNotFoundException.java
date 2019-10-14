package com.mmh.tddtest.exceptiontest;

/**
 * @author mumh@2423528736@qq.com
 * @date 2019/4/24 10:05
 */
public class NameNotFoundException extends Exception{

    private int errCode;

    public NameNotFoundException(int errCode,String message) {
        super(message);
        this.errCode = errCode;
    }

    public int getErrCode() {
        return errCode;
    }

    public void setErrCode(int errCode) {
        this.errCode = errCode;
    }
}
