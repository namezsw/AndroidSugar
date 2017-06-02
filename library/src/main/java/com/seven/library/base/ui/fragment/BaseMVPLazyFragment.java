package com.seven.library.base.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.seven.library.R;
import com.seven.library.base.presenter.BasePresenter;
import com.seven.library.base.ui.IView;
import com.seven.library.util.StringUtils;
import com.seven.library.util.ToastUtils;

import javax.inject.Inject;

/**
 * Created by Seven on 2017/4/10.
 */

public abstract class BaseMVPLazyFragment<P extends BasePresenter> extends BaseV4Fragment implements IView {

    private boolean isFirstVisible = true;
    private boolean isFirstInvisible = true;

    @Inject
    protected P mPresenter;

    @Override
    public void onViewCreateFinish(View view, @Nullable Bundle savedInstanceState) {
        injectComponent();
    }

    protected abstract void injectComponent();

    @Override
    public void showMessage(String msg) {
        ToastUtils.showToastShort(getContext(), !StringUtils.isEmpty(msg) ? msg : getString(R.string.not_network));
    }

    @Override
    public void showLoading() {
        loading.show();
    }

    @Override
    public void hideLoading() {
        loading.dismiss();
    }

    protected void onFirstUserVisible() {
    }

    protected void onFirstUserInvisible() {
    }

    protected void onUserVisible() {
    }

    protected void onUserInvisible() {
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (isVisibleToUser) {
            if (isFirstVisible) {
                isFirstVisible = false;
                onFirstUserVisible();
            } else {
                onUserVisible();
            }
        } else {
            if (isFirstInvisible) {
                isFirstInvisible = false;
                onFirstUserInvisible();
            } else {
                onUserInvisible();
            }
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if (mPresenter != null) {
            mPresenter.onDestroy();
            mPresenter = null;
        }
    }
}
