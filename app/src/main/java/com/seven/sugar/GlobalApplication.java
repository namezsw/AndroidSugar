package com.seven.sugar;

import com.seven.library.BasicApplication;
import com.seven.library.util.SDCardUtils;

import java.io.File;

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

    @Override
    protected String getLogTag() {
        return "android_sugar";
    }

    @Override
    protected String getSdCardPath() {
        return SDCardUtils.getSDCardPath() + File.separator + getLogTag();
    }
}
