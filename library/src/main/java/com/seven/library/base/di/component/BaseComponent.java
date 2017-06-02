package com.seven.library.base.di.component;

import android.app.Application;

import com.seven.library.base.di.module.BaseModule;
import com.seven.library.base.di.module.NetModule;

import javax.inject.Singleton;

import dagger.Component;
import okhttp3.OkHttpClient;

/**
 * Created by Seven on 2017/4/10.
 */

@Singleton
@Component(modules = {BaseModule.class, NetModule.class})
public interface BaseComponent {

    Application application();

    OkHttpClient okHttpClient();
}
