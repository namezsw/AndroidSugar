package com.seven.library.base.activity;

import android.app.Activity;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.seven.library.base.presenter.IPresenter;
import com.seven.library.controller.ActivityManager;
import com.seven.library.controller.EventBusHelper;
import com.seven.library.util.ToastUtils;

import butterknife.ButterKnife;

/**
 * 基础Activity
 * Retrofit + MVP
 * Created by Seven on 2017/3/10.
 */
public abstract class BaseActivity<P extends IPresenter> extends AppCompatActivity {

    protected P mPresenter;
    protected Context mContext;
    protected Bundle args;
    private long exitTime = 0;

    /**
     * 设置布局id
     *
     * @return 布局id
     */
    protected abstract int getLayoutId();

    protected abstract P createPresenter();

    /**
     * 布局初始化完成的回调
     *
     * @param saveInstanceState 保存状态
     */
    protected abstract void onViewCreatedFinish(Bundle saveInstanceState);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        int layoutId = getLayoutId();
        if (layoutId == 0)
            throw new RuntimeException("找不到Layout资源,Fragment初始化失败!");
        setContentView(layoutId);
        ButterKnife.bind(this);
        ActivityManager.getInstance().addActivity(this);//添加当前Activity到管理堆栈
        mContext = this;
        mPresenter = createPresenter();
        this.args = getIntent().getExtras() != null ? getIntent().getExtras() : new Bundle();
        EventBusHelper.register(this);//注册EventBus
        //布局初始化完成的回调
        onViewCreatedFinish(savedInstanceState);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ActivityManager.getInstance().removeActivity(this);
        EventBusHelper.unregister(this);//反注册EventBus
        if (mPresenter != null)
            mPresenter.onDestroy();
    }

    @Override
    public void onBackPressed() {
        if (getSupportFragmentManager().getBackStackEntryCount() > 0)
            getSupportFragmentManager().popBackStack();
        else
            super.onBackPressed();
    }

    /**
     * 跳转目标Activity
     *
     * @param targetClass 目标Activity类型
     */
    public void startActivity(Class<? extends Activity> targetClass) {
        startActivity(targetClass, null);
    }

    /**
     * 跳转目标Activity(传递参数)
     *
     * @param targetClass 目标Activity类型
     * @param args        传递参数
     */
    public void startActivity(Class<? extends Activity> targetClass, Bundle args) {
        Intent intent = new Intent(this, targetClass);
        if (args != null)
            intent.putExtras(args);
        startActivity(intent);
    }

    /**
     * 隐式跳转目标Activity
     *
     * @param action 隐式动作
     */
    public void startActivity(String action) {
        startActivity(action, null);
    }

    /**
     * 隐式跳转目标Activity
     *
     * @param action 隐式动作
     */
    public void startActivity(String action, Bundle args) {
        Intent intent = new Intent(action);
        if (args != null)
            intent.putExtras(args);
        startActivity(intent);
    }

    /**
     * 启动目标Service
     *
     * @param targetClass 目标Service类型
     * @param args        传递参数
     */
    public void startService(Class<? extends Service> targetClass, Bundle args) {
        Intent intent = new Intent(this, targetClass);
        if (args != null)
            intent.putExtras(args);
        startService(intent);
    }

    /**
     * 启动目标Service
     *
     * @param targetClass 目标Service类型
     */
    public void startService(Class<? extends Service> targetClass) {
        startService(targetClass, null);
    }

    /**
     * 隐式跳转目标Service
     *
     * @param action 隐式动作
     */
    public void startService(String action) {
        startService(action, null);
    }

    /**
     * 隐式跳转目标Service
     *
     * @param action 隐式动作
     */
    protected void startService(String action, Bundle args) {
        Intent intent = new Intent(action);
        if (args != null)
            intent.putExtras(args);
        startService(intent);
    }

    /**
     * 双击退出App
     *
     * @param exit 退出时间(毫秒数)
     */
    protected boolean exit(long exit) {
        if (System.currentTimeMillis() - exitTime > exit) {
            ToastUtils.showToastShort(mContext, "再按一次退出程序");
            exitTime = System.currentTimeMillis();
        } else {
            ActivityManager.getInstance().finishAllActivity();
        }
        return true;
    }

    /**
     * 双击退出App
     */
    protected boolean exit() {
        return exit(2000);
    }

}
