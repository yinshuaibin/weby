package com.y.exception;

import lombok.Data;

@Data
public class Yexception extends RuntimeException {
    private static final long serialVersionUID = 1L;
    // 业务代码
    private int errorCode;
    // 错误信息
    private String msg;

    public Yexception(int errorCode, String msg){
        super(msg);
        this.errorCode=errorCode;
        this.msg=msg;
    }

    public Yexception(String msg){
        super(msg);
        this.msg=msg;
    }
}
