package com.cheney.bean.response;

import com.alibaba.fastjson.JSON;
import lombok.Data;

import java.io.Serializable;

@Data
public class ResponseEntity implements Serializable {

    private static final long serialVersionUID = -3551938110618562315L;

    public final static ResponseEntity DEFAULT_ERROR_RESPONSE = new ResponseEntity(Code.ERROR.getMsg(), Code.ERROR.getCode(), null);

    private String msg;

    private int code;

    private Object data;

    public ResponseEntity(String msg, int code, Object data) {
        this.msg = msg;
        this.code = code;
        this.data = data;
    }

    public ResponseEntity(Code code, Object data) {
        this.msg = code.getMsg();
        this.code = code.getCode();
        this.data = data;
    }

    public static ResponseEntity success(Object data) {
        return new ResponseEntity(Code.SUCCESS, data);
    }

    public static ResponseEntity unknownError() {
        return DEFAULT_ERROR_RESPONSE;
    }

    public static ResponseEntity error(Code code) {
        return new ResponseEntity(code.getMsg(), code.getCode(), null);
    }

    public static ResponseEntity error(String msg) {
        return new ResponseEntity(msg, Code.ERROR.getCode(), null);
    }

    public String toJson() {
        return JSON.toJSONString(this);
    }
}
