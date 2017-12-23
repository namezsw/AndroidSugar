package com.seven.sugar.base.di.module;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.seven.library.base.di.scope.AppScope;
import com.seven.library.model.retrofit.RetrofitFactory;
import com.seven.sugar.base.BaseApi;
import com.seven.sugar.base.retrofit.api.JuHeApi;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;



/**
 * Created by Seven on 2017/4/10.
 */
@Module
public final class ApiModule {

    @Provides
    @AppScope
    Gson provideGson() {
        GsonBuilder gsonBuilder = new GsonBuilder();
        return gsonBuilder.create();
    }

    @Provides
    @AppScope
    JuHeApi provideParkApi(Gson gson, OkHttpClient okHttpClient) {
        return RetrofitFactory
                .create(gson, okHttpClient, BaseApi.JU_HE_URL)
                .create(JuHeApi.class);
    }
}
