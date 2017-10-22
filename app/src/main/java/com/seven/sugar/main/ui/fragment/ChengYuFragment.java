package com.seven.sugar.main.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.TextView;

import com.seven.library.base.ui.fragment.BaseMVPFragment;
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
 * ChengYuFragment
 * Created by Seven on 2017/4/3.
 */
public class ChengYuFragment extends BaseMVPFragment<ChengYuPresenter> implements ChengYuContract.View {

    @BindView(R.id.tv_info)
    TextView tvInfo;

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
        return R.layout.fragment_chengyu;
    }

    @Override
    public void onViewCreatedFinish(@Nullable Bundle savedInstanceState) {
        super.onViewCreatedFinish(savedInstanceState);
        tvInfo.setText(getArguments().getString("info"));
    }

    @OnClick(R.id.tv_info)
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_info:
                mPresenter.queryChengYu("积少成多");
                break;
            default:
                break;
        }
    }

    @Override
    public void showChengYu(ChengYuBean bean) {
        tvInfo.setText(bean.getChengyujs());
    }
}
