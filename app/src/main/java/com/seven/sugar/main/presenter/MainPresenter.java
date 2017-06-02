package com.seven.sugar.main.presenter;

import com.seven.library.base.presenter.BasePresenter;
import com.seven.sugar.main.contract.MainContract;

import javax.inject.Inject;

/**
 * Created by Seven on 2017/4/3.
 */
public class MainPresenter extends BasePresenter<MainContract.View, MainContract.Interactor> {

    @Inject
    public MainPresenter(MainContract.View view, MainContract.Interactor interactor) {
        super(view, interactor);
    }

}
