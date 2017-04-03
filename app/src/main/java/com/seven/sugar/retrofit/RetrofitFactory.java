package com.seven.sugar.retrofit;


import com.seven.sugar.GlobalApplication;
import com.seven.sugar.retrofit.api.BaseApi;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Seven on 2017/4/3.
 */
class RetrofitFactory {

    static Retrofit getJuHeRetrofit() {
        return JuHeRetrofitPlaceHolder.RETROFIT;
    }


    private static class JuHeRetrofitPlaceHolder {
        static final Retrofit RETROFIT = build(BaseApi.JU_HE_URL);
    }

    private static Retrofit build(String url) {
        return new Retrofit.Builder()
                .baseUrl(url)
                .client(GlobalApplication.getOkHttpClient())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }
}
