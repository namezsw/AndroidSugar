package com.seven.sugar.splash;

import android.content.Intent;
import android.os.Bundle;

import com.seven.library.base.ui.activity.BaseActivity;
import com.seven.sugar.R;
import com.seven.sugar.main.ui.activity.MainActivity;

import java.util.concurrent.TimeUnit;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

/**
 * Created by Seven on 2017/4/3.
 */

public class SplashActivity extends BaseActivity {

    @Override
    protected int getLayoutId() {
        return R.layout.activity_splash;
    }

    @Override
    protected void onViewCreateFinish(Bundle savedInstanceState) {

    }

    @Override
    protected void onResume() {
        super.onResume();
        Observable.timer(2, TimeUnit.SECONDS).subscribeOn(Schedulers.computation())
                .observeOn(AndroidSchedulers.mainThread()).compose(this.<Long>bindToLifecycle())
                .subscribe(new Action1<Long>() {
                    @Override
                    public void call(Long aLong) {
                        Intent intent = new Intent(SplashActivity.this, MainActivity.class);
                        startActivity(intent);
                        finish();
                    }
                });
    }
}
