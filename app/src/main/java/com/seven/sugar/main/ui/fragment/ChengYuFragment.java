package com.seven.sugar.main.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.TextView;

import com.seven.library.base.ui.fragment.BaseMVPLazyFragment;
import com.seven.sugar.GlobalApplication;
import com.seven.sugar.R;
import com.seven.sugar.main.contract.ChengYuContract;
import com.seven.sugar.main.di.component.DaggerChengYuComponent;
import com.seven.sugar.main.di.module.ChengYuModule;
import com.seven.sugar.main.model.bean.ChengYuBean;
import com.seven.sugar.main.presenter.ChengYuPresenter;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * ChengYuFragment
 * Created by Seven on 2017/4/3.
 */
public class ChengYuFragment extends BaseMVPLazyFragment<ChengYuPresenter> implements ChengYuContract.View {

    @BindView(R.id.tv_info)
    TextView tvInfo;

    @Override
    protected void injectComponent() {
        DaggerChengYuComponent.builder()
                .appComponent((GlobalApplication.getInstance().getAppComponent()))
                .chengYuModule(new ChengYuModule(this))
                .build()
                .inject(this);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_chengyu;
    }

    @Override
    public void onViewCreateFinish(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreateFinish(view, savedInstanceState);
        tvInfo.setText(getArguments().getString("info"));
    }

    @OnClick(R.id.tv_info)
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_info:
                mPresenter.queryChengYu("积少成多");
                break;
        }
    }

    @Override
    public void showChengYu(ChengYuBean bean) {
        tvInfo.setText(bean.getChengyujs());
    }
}
