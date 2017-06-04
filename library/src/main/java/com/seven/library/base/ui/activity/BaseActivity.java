package com.seven.library.base.ui.activity;

import android.os.Bundle;

import com.seven.library.controller.EventBusHelper;
import com.seven.library.view.LoadingHUD;
import com.trello.rxlifecycle.components.support.RxAppCompatActivity;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * 基础Activity
 * Created by Seven on 2017/3/10.
 */

public abstract class BaseActivity extends RxAppCompatActivity {

    private Unbinder unbinder;
    protected LoadingHUD loading;

    /**
     * 设置布局id
     *
     * @return 布局id
     */
    protected abstract int getLayoutId();

    /**
     * 布局初始化完成的回调
     */
    protected abstract void onViewCreateFinish(Bundle savedInstanceState);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        unbinder = ButterKnife.bind(this);
        loading = LoadingHUD.build(this);
        if (useEventBus())
            EventBusHelper.register(this);
        onViewCreateFinish(savedInstanceState);
    }

    @Override
    protected void onStop() {
        super.onStop();
        loading.dismiss();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unbinder.unbind();
        if (useEventBus())
            EventBusHelper.unregister(this);
    }

    protected boolean useEventBus() {
        return false;
    }

}
