package com.seven.sugar.base.retrofit.observer;


import com.seven.sugar.base.retrofit.model.Model;

/**
 * Created by Seven on 2017/4/10.
 */

public abstract class ApiObserver<T> extends BaseObserver<Model<T>> {

    @Override
    public final void onNext(Model<T> t) {
        int code = t.getError_code();
        String msg = t.getReason();
        boolean success = t.isSuccess();
        onResponse(success, code, msg, t);
    }
}