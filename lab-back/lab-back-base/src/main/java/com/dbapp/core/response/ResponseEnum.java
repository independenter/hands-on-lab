package com.dbapp.core.response;

/**
 * <p> 请求返回状态的枚举
 *
 * @author independenter
 * @since
 */
public enum ResponseEnum implements IResultCode{

    //成功
    OK(0,"success"),
    //失败
    ERROR(-1,"Error"),
    //重新登陆
    LOGIN(10001,"请重新登陆")
    ;

    private int code;
    private String msg;

    ResponseEnum(int code,String msg){
        this.code = code;
        this.msg = msg;
    }


    @Override
    public Integer getCode() {
        return code;
    }

    @Override
    public String getMsg() {
        return msg;
    }
}
