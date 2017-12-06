package com.seven.library;

import android.app.Application;
import android.content.Context;

import com.seven.library.base.di.component.BaseComponent;
import com.seven.library.base.di.component.DaggerBaseComponent;
import com.seven.library.base.di.module.BaseModule;
import com.seven.library.controller.ActivityManager;
import com.seven.library.controller.BaseActivityLifecycleCallback;
import com.seven.library.util.Logger;
import com.seven.library.util.SPUtils;

/**
 * 基础Application
 * Created by Seven on 2017/2/15.
 */
public abstract class BaseApplication extends Application {

    private static Context appContext;

    public static Context getInstance() {
        return appContext;
    }

    public static String sdCardPath;

    private BaseActivityLifecycleCallback activityLifecycleCallbacks;
    protected BaseComponent baseComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        appContext = getApplicationContext();
        sdCardPath = getSDCardPath();
        //API环境初始化
        initEnvironment();
        //SharePreference初始化
        SPUtils.init(getLogTag());
        //Logger初始化
        Logger.init(getLogTag(), getSDCardPath()).hideThreadInfo()
                .setLogLevel(BuildConfig.DEBUG ? Logger.LogLevel.NONE : Logger.LogLevel.FULL)
                .setSaveLog(false);
        //Dagger2初始化
        baseComponent = DaggerBaseComponent.builder()
                .baseModule(new BaseModule(this))
                .build();
        //ActivityLifecycle初始化
        activityLifecycleCallbacks = new BaseActivityLifecycleCallback(ActivityManager.getInstance());
        registerActivityLifecycleCallbacks(activityLifecycleCallbacks);
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
        unregisterActivityLifecycleCallbacks(activityLifecycleCallbacks);
    }

    /**
     * 初始化API环境
     */
    protected abstract void initEnvironment();

    /**
     * debug模式
     *
     * @return 是否开启
     */
    protected abstract boolean isDebug();

    /**
     * 设置调试日志标签名
     *
     * @return 调试日志标签名
     */
    protected abstract String getLogTag();

    /**
     * 设置SDCard路径
     *
     * @return SDCard路径
     */
    protected abstract String getSDCardPath();

}
