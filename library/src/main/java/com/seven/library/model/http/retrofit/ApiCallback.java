package com.seven.library.model.http.retrofit;

/**
 * Created by Seven on 2017/3/10.
 */
public interface ApiCallback<T> {

    void onSuccess(boolean intermediate, T response);

    void onSuccessEmpty();

    void onFailed(int code, String msg);

    void onCompleted(boolean success, String msg);
}
