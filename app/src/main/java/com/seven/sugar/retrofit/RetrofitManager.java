package com.seven.sugar.retrofit;

import com.seven.sugar.retrofit.api.JuHeApi;

/**
 * Created by riven_chris on 16/7/3.
 */
public class RetrofitManager {

    private static RetrofitManager instance = null;

    public static RetrofitManager getInstance() {
        if (instance == null) {
            synchronized (RetrofitManager.class) {
                if (instance == null) {
                    instance = new RetrofitManager();
                }
            }
        }
        return instance;
    }

    /**
     * 聚合数据Api
     */
    public static JuHeApi getJuHeRetrofit() {
        return RetrofitFactory.getJuHeRetrofit().create(JuHeApi.class);
    }

}
