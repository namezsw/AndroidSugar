package com.seven.sugar;

import com.seven.library.BasicApplication;
import com.seven.library.model.http.OkHttpManager;
import com.seven.library.model.http.interceptor.CacheStrategyInterceptor;
import com.seven.library.model.http.interceptor.HeaderInfoInterceptor;
import com.seven.library.model.http.interceptor.NetworkInterceptor;
import com.seven.library.util.AppUtils;
import com.seven.library.util.SDCardUtils;
import com.seven.sugar.retrofit.api.BaseApi;
import com.squareup.leakcanary.LeakCanary;

import java.io.File;

import okhttp3.OkHttpClient;

/**
 * 全局变量
 * Created by Seven on 2017/2/15.
 */
public class GlobalApplication extends BasicApplication {

    @Override
    public void onCreate() {
        super.onCreate();
        //LeakCanary初始化
        if(isDebug()){
            LeakCanary.install(this);
        }
        //Api初始化
        BaseApi.init(BaseApi.HOST_FORMAL);
    }

    @Override
    public boolean isDebug() {
        //根据需求更改
        return BaseApi.isDebug();
    }

    @Override
    protected String getLogTag() {
        return "android_sugar";
    }

    @Override
    protected String getSdCardPath() {
        return SDCardUtils.getSDCardPath() + File.separator + getLogTag();
    }

    @Override
    public OkHttpClient initOkHttpClient() {
        return OkHttpManager.getInstance(getNetworkCacheDirectoryPath(), getNetworkCacheSize())
                .addInterceptor(new NetworkInterceptor())
                .addInterceptor(new CacheStrategyInterceptor())
                .addInterceptor(new HeaderInfoInterceptor(AppUtils.getAppVersionName(this)))
                .build();
    }

    @Override
    protected String getNetworkCacheDirectoryPath() {
        return sdCardPath + File.separator + "http_cache";
    }

    @Override
    protected int getNetworkCacheSize() {
        return 20 * 1024 * 1024;
    }

    @Override
    protected int getNetworkCacheMaxAgeTime() {
        return 0;
    }
}
