package com.seven.sugar.chengyu.presenter;

import com.seven.library.base.presenter.BasePresenter;
import com.seven.sugar.base.retrofit.model.Model;
import com.seven.sugar.base.retrofit.observer.ApiObserver;
import com.seven.sugar.chengyu.contract.ChengYuContract;
import com.seven.sugar.chengyu.model.bean.ChengYuBean;

import javax.inject.Inject;

import io.reactivex.Observer;
import io.reactivex.annotations.NonNull;
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
        Observer<ChengYuBean> observer= new Observer<ChengYuBean>() {

            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(ChengYuBean value) {


            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {
            }
        };

        mView.showLoading();
        mInteractor.queryChengYu(word)
                .subscribe(new ApiObserver<ChengYuBean>() {
                    @Override
                    public void onNext(String msg, Model<ChengYuBean> chengYuBeanModel) {

                    }

                    @Override
                    public void onError(int code, String msg) {

                    }
                });
        addDisposable(disposable);
    }
}
