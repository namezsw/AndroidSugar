package com.seven.sugar.chengyu.model.interactor;


import com.seven.library.base.di.scope.ActivityScope;
import com.seven.sugar.base.retrofit.api.JuHeApi;
import com.seven.sugar.base.retrofit.model.Model;
import com.seven.sugar.main.Constants;
import com.seven.sugar.chengyu.contract.ChengYuContract;
import com.seven.sugar.chengyu.model.bean.ChengYuBean;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;

import rx.Observable;


/**
 * Created by Seven on 2017/4/10.
 */

@ActivityScope
public class ChengYuInteractor implements ChengYuContract.Interactor {

    private JuHeApi juHeApi;

    @Inject
    public ChengYuInteractor(JuHeApi juHeApi) {
        this.juHeApi = juHeApi;
    }

    @Override
    public Observable<Model<ChengYuBean>> queryChengYu(String word) {
        Map<String, String> params = new HashMap<>();
        params.put(Constants.Parameter.PARAM_KEY, Constants.JUHE_APP_KEY);
        params.put(Constants.Parameter.PARAM_WORD, word);
        return juHeApi.queryChengYu(params);
    }

    @Override
    public void onDestroy() {

    }
}