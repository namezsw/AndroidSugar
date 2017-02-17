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

    @Override
    public void onCreate() {
        super.onCreate();
        appContext = this;
        SPUtils.init("utilcode");
        Logger.init(true, false, 'v', "MyTag");
    }
}
