package com.seven.sugar.base.retrofit.subscriber;

import rx.Subscriber;

/**
 * Created by Seven on 2017/4/10.
 */

abstract class ApiSubscriber<T> extends Subscriber<T> {

    @Override
    public void onCompleted() {

    }

    @Override
    public final void onError(Throwable e) {
        onResponse(false, -1, "当前网络不可用", null);
    }

    final void onResponse(boolean success, int code, String msg, T data) {
        if (success) {
            onNext(msg, data);
        } else {
            onError(code, msg);
        }
    }

    public abstract void onNext(String msg, T t);

    public abstract void onError(int code, String msg);
}
