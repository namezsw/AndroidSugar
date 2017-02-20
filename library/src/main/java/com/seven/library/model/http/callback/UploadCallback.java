package com.seven.library.model.http.callback;

import com.alibaba.fastjson.JSONObject;

/**
 * Created by Seven on 2017/2/15.
 */
public abstract class UploadCallback {
    public abstract void onSuccess(JSONObject result);
    public void onFail(){

    }

}
