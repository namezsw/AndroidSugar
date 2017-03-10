package com.seven.library.base.model;

import com.seven.library.model.http.retrofit.HttpHelper;

/**
 * Created by Seven on 2017/3/10.
 */
public class BaseInteractorImpl {

    public void unSubscribe() {
        HttpHelper.getInstance().clearCallsByTag(getClass().getSimpleName());
    }

    public void onDestroy() {
        unSubscribe();
    }
}
