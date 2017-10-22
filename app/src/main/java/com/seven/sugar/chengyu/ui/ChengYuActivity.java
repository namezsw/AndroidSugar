package com.seven.sugar.chengyu.ui;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import com.seven.library.base.ui.activity.BaseMVPActivity;
import com.seven.sugar.GlobalApplication;
import com.seven.sugar.R;
import com.seven.sugar.chengyu.contract.ChengYuContract;
import com.seven.sugar.chengyu.di.component.DaggerChengYuComponent;
import com.seven.sugar.chengyu.di.module.ChengYuModule;
import com.seven.sugar.chengyu.model.bean.ChengYuBean;
import com.seven.sugar.chengyu.presenter.ChengYuPresenter;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by Seven on 2017/4/3.
 */
public class ChengYuActivity extends BaseMVPActivity<ChengYuPresenter> implements ChengYuContract.View {

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.test_text_view)
    TextView testTextView;

    @Override
    protected void injectComponent() {
        DaggerChengYuComponent.builder()
                .appComponent(GlobalApplication.getInstance().getAppComponent())
                .chengYuModule(new ChengYuModule(this))
                .build()
                .inject(this);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_test;
    }

    @Override
    protected void onViewCreated(Bundle savedInstanceState) {
        super.onViewCreated(savedInstanceState);
        setSupportActionBar(toolbar);
    }

    @OnClick({R.id.test_text_view})
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.test_text_view:
                mPresenter.queryChengYu("积少成多");
                break;
            default:
                break;
        }
    }

    @Override
    public void showChengYu(ChengYuBean bean) {
        testTextView.setText(bean.getChengyujs());
    }

}