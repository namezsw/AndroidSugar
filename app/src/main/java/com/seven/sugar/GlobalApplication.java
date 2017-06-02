package com.seven.sugar;

import com.seven.library.BaseApplication;
import com.seven.library.util.AppUtils;
import com.seven.sugar.base.BaseApi;
import com.seven.sugar.base.di.component.AppComponent;
import com.seven.sugar.base.di.component.DaggerAppComponent;
import com.squareup.leakcanary.LeakCanary;

/**
 * 全局Application
 * Created by Seven on 2017/2/15.
 */
public class GlobalApplication extends BaseApplication {

    private static GlobalApplication appContext;
    public static GlobalApplication getInstance() {
        return appContext;
    }

    private AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        appContext = this;
        appComponent = DaggerAppComponent.builder()
                .baseComponent(baseComponent)
                .build();
        //LeakCanary初始化
        if (isDebug()) {
            LeakCanary.install(this);
        }
    }

    public AppComponent getAppComponent() {
        return appComponent;
    }

    @Override
    protected void initEnvironment() {
        BaseApi.init(BaseApi.HOST_FORMAL);
    }

    @Override
    public boolean isDebug() {
        return BaseApi.isDebug();
    }

    @Override
    protected String getLogTag() {
        return AppUtils.getAppPackageName(this);
    }

    @Override
    protected String getSDCardPath() {
        return AppUtils.getAppCachePath(this);
    }

}
