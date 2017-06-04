package com.seven.sugar.base.retrofit.subscriber;


import com.seven.sugar.base.retrofit.model.Model;

/**
 * Created by Seven on 2017/4/10.
 */

public abstract class ApiSubscriber1<T> extends ApiSubscriber<Model<T>> {

    @Override
    public final void onNext(Model<T> t) {
        int code = t.getError_code();
        String msg = t.getReason();
        boolean success = (code == 0);
        onResponse(success, code, msg, t);
    }
}