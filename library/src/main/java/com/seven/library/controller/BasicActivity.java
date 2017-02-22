package com.seven.library.controller;

import android.app.Activity;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.seven.library.model.http.OkHttpRequestHelper;
import com.seven.library.model.http.callback.RequestCallback;
import com.seven.library.util.ToastUtils;

import java.util.LinkedList;
import java.util.List;

import butterknife.ButterKnife;
import okhttp3.Interceptor;
import okhttp3.Request;

/**
 * 基础Activity
 * Created by Seven on 2017/2/15.
 */
public abstract class BasicActivity extends AppCompatActivity {
    protected Context mContext;
    protected Bundle args;
    private long exitTime = 0;

    /**
     * 设置布局id
     *
     * @return 布局id
     */
    protected abstract int getLayoutId();

    /**
     * 布局初始化完成的回调
     *
     * @param saveInstanceState 保存状态
     */
    protected abstract void onViewCreatedFinish(Bundle saveInstanceState);

    /**
     * 收集本Activity请求时的url
     *
     * @return url
     */
    protected abstract String[] getRequestUrls();

    @Override
    protected final void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        int layoutId = getLayoutId();
        if (layoutId == 0)
            throw new RuntimeException("找不到Layout资源,Fragment初始化失败!");
        setContentView(layoutId);
        ActivityManager.getInstance().addActivity(this);//添加当前Activity到管理堆栈
        ButterKnife.bind(this);
        EventBusHelper.register(this);//注册EventBus
        mContext = this;
        this.args = getIntent().getExtras() != null ? getIntent().getExtras() : new Bundle();
        //布局初始化完成的回调
        onViewCreatedFinish(savedInstanceState);
    }

    @Override
    protected void onStop() {
        super.onStop();
        //Activity停止时取消所有请求
        String[] urls = getRequestUrls();
        for (String url : urls) {
            OkHttpRequestHelper.newInstance().cancelRequest(url);
        }
    }

    @Override
    protected void onDestroy() {
        ActivityManager.getInstance().removeActivity(this);
        super.onDestroy();
        EventBusHelper.unregister(this);//反注册EventBus
    }

    @Override
    public void onBackPressed() {
        if (getSupportFragmentManager().getBackStackEntryCount() > 0)
            getSupportFragmentManager().popBackStack();
        else
            super.onBackPressed();
    }

    /**
     * 网络请求
     *
     * @param request      request主体
     * @param cacheType    缓存策略
     * @param callback     请求回调(建议使用SimpleFastJsonCallback)
     * @param interceptors 网络拦截器组
     */
    protected void networkRequest(Request request, int cacheType, RequestCallback callback, List<Interceptor> interceptors) {
        if (request == null)
            throw new NullPointerException("request为空");
        OkHttpRequestHelper helper = OkHttpRequestHelper.newInstance();
        if (interceptors != null && interceptors.size() > 0)
            helper.addInterceptors(interceptors);
        if (cacheType != -1)
            helper.cacheType(cacheType);
        helper.request(request, callback);
    }

    /**
     * 网络请求
     *
     * @param request     request主体
     * @param cacheType   缓存策略
     * @param callback    请求回调(建议使用SimpleFastJsonCallback)
     * @param interceptor 网络拦截器
     */
    protected void networkRequest(Request request, int cacheType, RequestCallback callback, Interceptor interceptor) {
        List<Interceptor> interceptors = new LinkedList<>();
        interceptors.add(interceptor);
        networkRequest(request, cacheType, callback, interceptors);
    }

    /**
     * 网络请求
     *
     * @param request   request主体
     * @param cacheType 缓存策略
     * @param callback  请求回调(建议使用SimpleFastJsonCallback)
     */
    protected void networkRequest(Request request, int cacheType, RequestCallback callback) {
        networkRequest(request, cacheType, callback, new LinkedList<Interceptor>());
    }

    /**
     * 网络请求
     *
     * @param request  request主体
     * @param callback 请求回调(建议使用SimpleFastJsonCallback)
     */
    protected void networkRequest(Request request, RequestCallback callback) {
        networkRequest(request, -1, callback);
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
     */
    protected boolean exit() {
        return exit(2000);
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

}
