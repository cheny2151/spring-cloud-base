package com.cheney.bean.response;

public enum Code {

    SUCCESS("success", 200),

    ERROR("unknown error", 500);

    private String msg;

    private int code;

    Code(String msg, int code) {
        this.msg = msg;
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public int getCode() {
        return code;
    }

}
