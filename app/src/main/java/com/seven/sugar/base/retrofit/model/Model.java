package com.seven.sugar.base.retrofit.model;

import java.io.Serializable;

/**
 * Created by Seven on 2017/4/10.
 */

public class Model<T> implements Serializable {
    private T result;
    private int error_code;
    private String reason = "";

    public boolean isSuccess() {
        return error_code == 0;
    }

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }

    public int getError_code() {
        return error_code;
    }

    public void setError_code(int error_code) {
        this.error_code = error_code;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }
}
