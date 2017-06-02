package com.seven.sugar.main.model.interactor;


import com.seven.library.base.di.scope.ActivityScope;
import com.seven.sugar.main.contract.MainContract;

import javax.inject.Inject;


/**
 * Created by Seven on 2017/4/10.
 */

@ActivityScope
public class MainInteractor implements MainContract.Interactor {

    @Inject
    public MainInteractor() {

    }

    @Override
    public void onDestroy() {

    }
}
