package com.seven.sugar;

import android.os.Bundle;
import android.os.Handler;

import com.seven.library.base.presenter.IPresenter;
import com.seven.library.base.ui.activity.BaseActivity;
import com.seven.sugar.home.ui.activity.MainActivity;

/**
 * Created by Seven on 2017/4/3.
 */

public class SplashActivity extends BaseActivity {

    @Override
    protected int getLayoutId() {
        return R.layout.activity_splash;
    }

    @Override
    protected void onViewCreatedFinish(Bundle saveInstanceState) {

    }

    @Override
    protected IPresenter createPresenter() {
        return null;
    }

    @Override
    protected void onResume() {
        super.onResume();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(MainActivity.class);
                finish();
            }
        }, 2000);
    }
}
