package com.seven.sugar;

import com.seven.library.BasicApplication;

import okhttp3.OkHttpClient;

/**
 * 全局变量
 * Created by Seven on 2017/2/15.
 */
public class GlobalApplication extends BasicApplication {

    private static OkHttpClient mOkHttpClient;//OkHttpClient

    @Override
    public void onCreate() {
        super.onCreate();

    }
}
