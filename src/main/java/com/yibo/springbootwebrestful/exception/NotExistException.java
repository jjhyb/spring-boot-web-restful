package com.yibo.springbootwebrestful.exception;

/**
 * @author: wb-hyb441488
 * @Date: 2018/12/17 16:09
 * @Description:
 */
public class NotExistException extends RuntimeException {

    public NotExistException(String msg) {
        super(msg);
    }
}
