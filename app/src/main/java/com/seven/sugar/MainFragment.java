package com.seven.sugar;

import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.widget.TextView;

import com.seven.library.base.fragment.BaseFragment;
import com.seven.library.base.presenter.IPresenter;

import butterknife.BindView;

/**
 * Created by bruce on 2016/11/1.
 * BaseFragment
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
        tvInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.make(v, "Don't click me.please!.", Snackbar.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    protected IPresenter createPresenter() {
        return null;
    }

}
