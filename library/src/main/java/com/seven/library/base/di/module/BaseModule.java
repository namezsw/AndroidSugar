package com.seven.library.base.di.module;

import android.app.Application;

import com.seven.library.BaseApplication;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Seven on 2017/4/10.
 */

@Module
public final class BaseModule {
    private BaseApplication mApplication;

    public BaseModule(BaseApplication application) {
        mApplication = application;
    }

    @Provides
    @Singleton
    Application providesBaseApplication() {
        return mApplication;
    }
}
