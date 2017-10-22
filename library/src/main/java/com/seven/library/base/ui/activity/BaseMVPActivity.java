package com.seven.library.base.ui.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.seven.library.R;
import com.seven.library.base.presenter.BasePresenter;
import com.seven.library.base.ui.IView;
import com.seven.library.util.StringUtils;
import com.seven.library.util.ToastUtils;

import javax.inject.Inject;

/**
 * Created by Seven on 2017/4/10.
 */

public abstract class BaseMVPActivity<P extends BasePresenter> extends BaseActivity implements IView {

    @Inject
    protected P mPresenter;

    @Override
    protected void onViewCreated(@Nullable Bundle savedInstanceState) {
        injectComponent();
    }

    protected abstract void injectComponent();

    @Override
    public void showMessage(String msg) {
        ToastUtils.showToastShort(this, !StringUtils.isEmpty(msg) ? msg : getString(R.string.not_network));
    }

    @Override
    public void showLoading() {
        loading.show();
    }

    @Override
    public void hideLoading() {
        loading.dismiss();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mPresenter != null) {
            mPresenter.onDestroy();
            mPresenter = null;
        }
    }
}
