package com.seven.library.base.presenter;


import com.seven.library.base.model.IInteractor;
import com.seven.library.base.view.IView;

import rx.subscriptions.CompositeSubscription;

/**
 * Created by Seven on 2017/3/10.
 */
public abstract class BasePresenterImpl<V extends IView, I extends IInteractor> {

    protected V mView;
    protected I mInteractor;
    protected CompositeSubscription subscriptions;

    public BasePresenterImpl(V view) {
        mView = view;
        mInteractor = createInteractor();
        subscriptions = new CompositeSubscription();
    }

    protected abstract I createInteractor();

    public void unSubscribe() {
        mInteractor.unSubscribe();
        if (subscriptions != null) {
            subscriptions.unsubscribe();
        }
    }

    public void onDestroy() {
        if (subscriptions != null) {
            subscriptions.unsubscribe();
        }
        if (mInteractor != null) {
            mInteractor.onDestroy();
            mInteractor = null;
        }
        mView = null;
    }
}
