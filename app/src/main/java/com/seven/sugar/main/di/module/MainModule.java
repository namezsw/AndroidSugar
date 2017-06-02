package com.seven.sugar.main.di.module;


import com.seven.library.base.di.scope.ActivityScope;
import com.seven.sugar.main.contract.MainContract;
import com.seven.sugar.main.model.interactor.MainInteractor;

import dagger.Module;
import dagger.Provides;

@Module
public class MainModule {
    private MainContract.View view;

    public MainModule(MainContract.View view) {
        this.view = view;
    }

    @ActivityScope
    @Provides
    MainContract.View provideView() {
        return this.view;
    }

    @ActivityScope
    @Provides
    MainContract.Interactor provideModel(MainInteractor interactor) {
        return interactor;
    }
}
