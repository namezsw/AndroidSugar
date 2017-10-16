package com.seven.library.base.presenter;

import com.seven.library.base.model.IInteractor;
import com.seven.library.base.ui.IView;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;


/**
 * Created by Seven on 2017/4/10.
 */

public class BasePresenter<V extends IView, M extends IInteractor> implements IPresenter {

    protected V mView;
    protected M mInteractor;
    private CompositeDisposable disposables;

    public BasePresenter(V view, M interactor) {
        mView = view;
        mInteractor = interactor;
    }

    @Override
    public void subscribe() {

    }

    @Override
    public void unSubscribe() {
        if (disposables != null) {
            disposables.clear();
        }
    }

    @Override
    public void onDestroy() {
        unSubscribe();
        mView = null;
        if (mInteractor != null) {
            mInteractor.onDestroy();
            mInteractor = null;
        }
    }

    protected void addDisposable(Disposable disposable) {
        if (disposables == null) {
            disposables = new CompositeDisposable();
        }
        disposables.add(disposable);
    }

}
