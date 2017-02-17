package com.seven.library;

import android.app.Application;

import com.seven.library.util.Logger;
import com.seven.library.util.SPUtils;

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
    }

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
}
