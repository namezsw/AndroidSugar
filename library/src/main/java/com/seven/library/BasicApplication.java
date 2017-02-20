package com.seven.library;

import android.app.Application;

import com.seven.library.util.Logger;
import com.seven.library.util.SPUtils;

import okhttp3.OkHttpClient;

/**
 * 基础Application
 * Created by Seven on 2017/2/15.
 */
public abstract class BasicApplication extends Application {

    private static BasicApplication appContext;

    public static BasicApplication getInstance() {
        return appContext;
    }
    public static String sdCardPath;//SdCard路径
    private static OkHttpClient mOkHttpClient;//OkHttpClient
    private static int maxAge;//网络缓存最大时间

    @Override
    public void onCreate() {
        super.onCreate();
        appContext = this;
        //sdCard缓存路径
        sdCardPath = getSdCardPath();
        //SharePreference初始化
        SPUtils.init("utilcode");
        //Log初始化
        Logger.init(getLogTag()).setLogLevel(Logger.LogLevel.FULL).setSaveLog(false);
        //OkHttp初始化
        mOkHttpClient = initOkHttpClient();
        //网络缓存最大时间
        maxAge = getNetworkCacheMaxAgeTime();
    }

    public static OkHttpClient getOkHttpClient() {
        return mOkHttpClient;
    }

    public static int getMaxAge() {
        return maxAge;
    }

    /**
     * 设置OkHttpClient
     *
     * @return sdCard路径
     */
    public abstract OkHttpClient initOkHttpClient();

    /**
     * 设置调试日志标签名
     *
     * @return 调试日志标签名
     */
    protected abstract String getLogTag();

    /**
     * 设置sdCard路径
     *
     * @return sdCard路径
     */
    protected abstract String getSdCardPath();

    /**
     * 网络缓存文件夹路径
     *
     * @return 缓存文件夹路径
     */
    protected abstract String getNetworkCacheDirectoryPath();

    /**
     * 网络缓存文件大小
     *
     * @return 缓存文件大小
     */
    protected abstract int getNetworkCacheSize();

    /**
     * 网络缓存最大时间
     *
     * @return 缓存最大时间
     */
    protected abstract int getNetworkCacheMaxAgeTime();
}
