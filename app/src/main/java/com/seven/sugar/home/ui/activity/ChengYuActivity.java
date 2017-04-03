package com.seven.sugar.home.ui.activity;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import com.seven.library.base.ui.activity.BaseActivity;
import com.seven.library.util.ToastUtils;
import com.seven.sugar.R;
import com.seven.sugar.home.model.bean.ChengYu;
import com.seven.sugar.home.presenter.ChnegYuPresenter;
import com.seven.sugar.home.presenter.impl.ChengYuPresenterImpl;
import com.seven.sugar.home.view.ChengYuView;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by Seven on 2017/4/3.
 */
public class ChengYuActivity extends BaseActivity<ChnegYuPresenter> implements ChengYuView {

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.test_text_view)
    TextView testTextView;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_test;
    }

    @Override
    protected void onViewCreatedFinish(Bundle saveInstanceState) {
        setSupportActionBar(toolbar);
    }

    @Override
    protected ChnegYuPresenter createPresenter() {
        return new ChengYuPresenterImpl(this);
    }

    @OnClick({R.id.test_text_view})
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.test_text_view:
                mPresenter.queryChengYu("积少成多");
                break;
        }
    }

    @Override
    public void showChengYu(ChengYu.ResultBean bean) {
        testTextView.setText(bean.getChengyujs());
    }

    @Override
    public void showToast(String msg) {
        ToastUtils.showToastShort(mContext, msg);
    }

    @Override
    public void showLoading() {
        loading.show();
    }

    @Override
    public void dismissLoading() {
        loading.dismiss();
    }
}