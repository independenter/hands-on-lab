package com.dbapp.exception;

import cn.hutool.core.exceptions.ExceptionUtil;
import cn.hutool.core.util.StrUtil;

/**
 * @author dobb
 */
public class ServiceException extends RuntimeException{

    transient int  code;

    public ServiceException(int code) {
        this.code = code;
    }

    public ServiceException(String message, int code) {
        super(message);
        this.code = code;
    }

    public ServiceException(String message, Throwable cause, int code) {
        super(message, cause);
        this.code = code;
    }

    public ServiceException(Throwable cause, int code) {
        super(cause);
        this.code = code;
    }

    public ServiceException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace, int code) {
        super(message, cause, enableSuppression, writableStackTrace);
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public static void trueThrow(boolean flag,String message,String... args){
        if(flag){
            throw new ServiceException(StrUtil.format(message,args), -1);
        }
    }

    public static void printLog(org.slf4j.Logger logger,Throwable e){
        logger.info(ExceptionUtil.stacktraceToString(e));
    }
}
