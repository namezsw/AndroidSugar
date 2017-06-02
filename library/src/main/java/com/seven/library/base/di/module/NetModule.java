package com.seven.library.base.di.module;

import android.app.Application;

import com.seven.library.BaseApplication;
import com.seven.library.model.http.interceptor.CacheStrategyInterceptor;
import com.seven.library.model.http.interceptor.HeaderInfoInterceptor;
import com.seven.library.util.AppUtils;
import com.seven.library.util.Logger;

import java.io.File;
import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.Cache;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;

/**
 * Created by Seven on 2017/4/10.
 */

@Module
public class NetModule {

    /**
     * 网络缓存文件夹路径
     */
    @Provides
    @Singleton
    Cache provideOkHttpCache() {
        Cache cache = new Cache(new File(BaseApplication.sdCardPath, "http_cache"), 20 * 1024 * 1024); //20 MiB
        return cache;
    }

    /**
     * 提供OkhttpClient
     */
    @Provides
    @Singleton
    OkHttpClient provideOkHttpClient(Application application, Cache cache) {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();

        builder.connectTimeout(10 * 1000, TimeUnit.MILLISECONDS)
                .writeTimeout(10 * 1000, TimeUnit.MILLISECONDS)
                .readTimeout(10 * 1000, TimeUnit.MILLISECONDS);

        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() {
            @Override
            public void log(String message) {
                Logger.d(message);
            }
        });
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        builder.addInterceptor(loggingInterceptor);
        builder.addInterceptor(new CacheStrategyInterceptor());
        builder.addInterceptor(new HeaderInfoInterceptor(AppUtils.getAppVersionName(application)));

        builder.cache(cache);

        return builder.build();
    }
}
