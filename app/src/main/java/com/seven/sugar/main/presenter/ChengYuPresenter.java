package com.seven.sugar.main.presenter;

import com.seven.library.base.presenter.BasePresenter;
import com.seven.sugar.main.contract.ChengYuContract;
import com.seven.sugar.main.model.bean.ChengYu;

import javax.inject.Inject;

import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by Seven on 2017/4/3.
 */
public class ChengYuPresenter extends BasePresenter<ChengYuContract.View, ChengYuContract.Interactor> {

    @Inject
    public ChengYuPresenter(ChengYuContract.View view, ChengYuContract.Interactor interactor) {
        super(view, interactor);
    }

    public void queryChengYu(String word) {
        mView.showLoading();
        Subscription subscription = mInteractor.queryChengYu(word)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<ChengYu>() {
                    @Override
                    public void onCompleted() {
                    }

                    @Override
                    public void onError(Throwable e) {
                        mView.hideLoading();
                        mView.showMessage("");
                    }

                    @Override
                    public void onNext(ChengYu chengYu) {
                        mView.hideLoading();
                        if (chengYu.getError_code() == 0) {
                            mView.showChengYu(chengYu.getResult());
                        } else {
                            mView.showMessage(chengYu.getReason());
                        }
                    }
                });
        subscriptions.add(subscription);
    }
}
