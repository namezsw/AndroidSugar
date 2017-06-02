package com.seven.sugar.base.retrofit.model;

import java.io.Serializable;

/**
 * Created by Seven on 2017/4/10.
 */

public class Model<T> implements Serializable {
    private T data;
    private int http_code;
    private String msg = "";

    public int getHttp_code() {
        return http_code;
    }

    public void setHttp_code(int http_code) {
        this.http_code = http_code;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

}
