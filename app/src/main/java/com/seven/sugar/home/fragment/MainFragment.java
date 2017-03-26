package com.seven.sugar.home.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.seven.library.base.fragment.BaseFragment;
import com.seven.library.base.presenter.IPresenter;
import com.seven.sugar.R;
import com.seven.sugar.home.activity.TestActivity;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * MainFragment
 * Created by Seven on 2017/3/20.
 */
public class MainFragment extends BaseFragment {

    @BindView(R.id.tv_info)
    TextView tvInfo;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_main;
    }

    @Override
    public void onViewCreatedFinish(Bundle savedInstanceState) {
        tvInfo.setText(getArguments().getString("info"));
    }

    @Override
    protected IPresenter createPresenter() {
        return null;
    }

    @OnClick(R.id.tv_info)
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_info:
//                Snackbar.make(tvInfo, "Don't click me.please!.", Snackbar.LENGTH_SHORT).show();
                Intent intent = new Intent(mContext, TestActivity.class);
                startActivity(intent);
                break;
        }
    }
}
