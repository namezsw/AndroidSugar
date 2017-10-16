package com.seven.sugar.chengyu.presenter;

import com.seven.library.base.presenter.BasePresenter;
import com.seven.sugar.base.retrofit.model.Model;
import com.seven.sugar.base.retrofit.observer.ApiObserver;
import com.seven.sugar.chengyu.contract.ChengYuContract;
import com.seven.sugar.chengyu.model.bean.ChengYuBean;

import javax.inject.Inject;

import io.reactivex.disposables.Disposable;


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
        Disposable disposable = mInteractor.queryChengYu(word)
                .subscribeWith(new ApiObserver<ChengYuBean>() {
                    @Override
                    public void onNext(String msg, Model<ChengYuBean> chengYuBeanModel) {
                        mView.hideLoading();
                        if (chengYuBeanModel.getResult() != null) {
                            mView.showChengYu(chengYuBeanModel.getResult());
                        }
                    }

                    @Override
                    public void onError(int code, String msg) {
                        mView.hideLoading();
                        mView.showMessage(msg);
                    }
                });
        addDisposable(disposable);
    }
}
