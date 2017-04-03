package com.seven.sugar.home.presenter.impl;

import android.os.Bundle;

import com.seven.library.base.presenter.BasePresenterImpl;
import com.seven.sugar.GlobalApplication;
import com.seven.sugar.R;
import com.seven.sugar.home.model.bean.ChengYu;
import com.seven.sugar.home.model.interactor.ChengYuInteractor;
import com.seven.sugar.home.model.interactor.impl.ChengYuInteractorImpl;
import com.seven.sugar.home.presenter.ChnegYuPresenter;
import com.seven.sugar.home.view.ChengYuView;

import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by Seven on 2017/4/3.
 */
public class ChengYuPresenterImpl extends BasePresenterImpl<ChengYuView, ChengYuInteractor> implements ChnegYuPresenter {

    public ChengYuPresenterImpl(ChengYuView view) {
        super(view);
    }

    @Override
    protected ChengYuInteractor createInteractor() {
        return new ChengYuInteractorImpl();
    }

    @Override
    public void initData(Bundle bundle) {
        mInteractor.initData(bundle);
    }

    @Override
    public void queryChengYu(String word) {
        mView.showLoading();
        Subscription subscription = mInteractor.queryChengYu(word)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<ChengYu>() {
                    @Override
                    public void onCompleted() {
                        mView.dismissLoading();
                    }

                    @Override
                    public void onError(Throwable e) {
                        mView.showToast(GlobalApplication.getInstance().getString(R.string.not_network));
                    }

                    @Override
                    public void onNext(ChengYu chengYu) {
                        if (chengYu.getError_code() == 0) {
                            mView.showChengYu(chengYu.getResult());
                        } else {
                            mView.showToast(chengYu.getReason());
                        }
                    }
                });
        subscriptions.add(subscription);
    }

    @Override
    public void subscribe() {

    }

    @Override
    public void unSubscribe() {
        super.unSubscribe();
    }
}
