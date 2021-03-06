package com.seven.sugar.chengyu.di.module;


import com.seven.library.base.di.scope.ActivityScope;
import com.seven.sugar.chengyu.contract.ChengYuContract;
import com.seven.sugar.chengyu.model.interactor.ChengYuInteractor;

import dagger.Module;
import dagger.Provides;

@Module
public class ChengYuModule {
    private ChengYuContract.View view;

    public ChengYuModule(ChengYuContract.View view) {
        this.view = view;
    }

    @ActivityScope
    @Provides
    ChengYuContract.View provideView() {
        return this.view;
    }

    @ActivityScope
    @Provides
    ChengYuContract.Interactor provideModel(ChengYuInteractor interactor) {
        return interactor;
    }
}
