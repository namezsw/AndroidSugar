package com.seven.sugar.home.model.interactor.impl;


import android.os.Bundle;

import com.seven.library.base.model.BaseInteractorImpl;
import com.seven.sugar.retrofit.RetrofitManager;
import com.seven.sugar.home.Constants;
import com.seven.sugar.home.model.bean.ChengYu;
import com.seven.sugar.home.model.interactor.ChengYuInteractor;

import java.util.HashMap;
import java.util.Map;

import rx.Observable;


/**
 * Created by Seven on 2017/4/3.
 */
public class ChengYuInteractorImpl extends BaseInteractorImpl implements ChengYuInteractor {

    @Override
    public void initData(Bundle bundle) {

    }

    @Override
    public Observable<ChengYu> queryChengYu(String word) {
        Map<String, String> params = new HashMap<>();
        params.put(Constants.Parameter.PARAM_KEY, Constants.JUHE_APP_KEY);
        params.put(Constants.Parameter.PARAM_WORD, word);
        return RetrofitManager.getJuHeRetrofit().queryChengYu(params);
    }
}
