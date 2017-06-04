package com.seven.sugar.main.presenter;

import com.seven.library.base.presenter.BasePresenter;
import com.seven.sugar.base.retrofit.model.Model;
import com.seven.sugar.base.retrofit.subscriber.ApiSubscriber1;
import com.seven.sugar.main.contract.ChengYuContract;
import com.seven.sugar.main.model.bean.ChengYuBean;

import javax.inject.Inject;

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
                .subscribe(new ApiSubscriber1<ChengYuBean>() {
                    @Override
                    public void onError(int code, String msg) {
                        mView.hideLoading();
                        mView.showMessage(msg);
                    }

                    @Override
                    public void onNext(String msg, Model<ChengYuBean> chengYuBeanModel) {
                        if (chengYuBeanModel.getResult() != null) {
                            mView.showChengYu(chengYuBeanModel.getResult());
                        }
                    }
                });
        subscriptions.add(subscription);
    }
}
