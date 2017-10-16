package com.seven.sugar.base.retrofit.observer;

import io.reactivex.annotations.NonNull;
import io.reactivex.observers.ResourceObserver;

/**
 * Created by Seven on 2017/4/10.
 */

abstract class BaseObserver<T> extends ResourceObserver<T> {

    @Override
    public void onComplete() {

    }

    @Override
    public void onNext(@NonNull T t) {

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
