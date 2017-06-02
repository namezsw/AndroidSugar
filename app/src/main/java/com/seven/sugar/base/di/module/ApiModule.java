package com.seven.sugar.base.di.module;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.seven.library.base.di.scope.AppScope;
import com.seven.sugar.base.BaseApi;
import com.seven.sugar.base.retrofit.api.JuHeApi;
import com.seven.sugar.base.retrofit.RetrofitFactory;

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
        gsonBuilder.setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES);
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
