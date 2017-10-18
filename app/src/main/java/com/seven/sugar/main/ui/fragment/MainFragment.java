package com.seven.sugar.main.ui.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.TextView;

import com.seven.library.base.ui.fragment.BaseFragment;
import com.seven.sugar.R;
import com.seven.sugar.chengyu.ui.ChengYuActivity;

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
    public void onViewCreatedFinish(@Nullable Bundle savedInstanceState) {
        tvInfo.setText(getArguments().getString("info"));
    }

    @OnClick(R.id.tv_info)
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_info:
//                Snackbar.make(tvInfo, "Don't click me.please!.", Snackbar.LENGTH_SHORT).show();
                Intent intent = new Intent(getContext(), ChengYuActivity.class);
                startActivity(intent);
                break;
            default:
                break;
        }
    }
}
