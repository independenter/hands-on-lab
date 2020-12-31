package com.dbapp.core.exception;

import cn.hutool.core.exceptions.ExceptionUtil;
import cn.hutool.core.util.StrUtil;
import com.dbapp.core.response.ResponseEnum;

/**
 * @author dobb
 */
public class LabException extends RuntimeException{

    transient int  code;

    public LabException(int code) {
        this.code = code;
    }

    public LabException(String message, int code) {
        super(message);
        this.code = code;
    }

    public LabException(String message, Throwable cause, int code) {
        super(message, cause);
        this.code = code;
    }

    public LabException(Throwable cause, int code) {
        super(cause);
        this.code = code;
    }

    public LabException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace, int code) {
        super(message, cause, enableSuppression, writableStackTrace);
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public static void trueThrow(boolean flag,String message,String... args){
        if(flag){
            throw new LabException(StrUtil.format(message,args), ResponseEnum.ERROR.getCode());
        }
    }

    public static void printLog(org.slf4j.Logger logger,Throwable e){
        logger.info(ExceptionUtil.stacktraceToString(e));
    }
}
