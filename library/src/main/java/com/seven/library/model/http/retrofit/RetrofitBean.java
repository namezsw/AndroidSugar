package com.seven.library.model.http.retrofit;

/**
 * Created by Seven on 2017/3/10.
 */
public class RetrofitBean<T> {
    private T data;
    private int http_code;//接口状态码
    private String msg;

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public int getHttp_code() {
        return http_code;
    }

    public void setHttp_code(int http_code) {
        this.http_code = http_code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
