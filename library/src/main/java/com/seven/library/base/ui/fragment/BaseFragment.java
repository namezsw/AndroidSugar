package com.seven.library.base.ui.fragment;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.seven.library.base.presenter.IPresenter;
import com.seven.library.base.ui.activity.BaseActivity;
import com.seven.library.view.LoadingHUD;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by Seven on 2017/3/10.
 */
public abstract class BaseFragment<P extends IPresenter> extends Fragment {

    protected P mPresenter;
    private View mFragmentView = null;
    protected Context mContext;
    protected Bundle args;//传递的参数值
    protected LoadingHUD loading;//加载框
    //fragment管理器
    protected FragmentManager mFragmentManager;
    private Unbinder unbinder;

    protected abstract int getLayoutId();

    protected abstract P createPresenter();

    public abstract void onViewCreatedFinish(Bundle savedInstanceState);

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mContext = context;
        this.loading = LoadingHUD.getInstance(context);
        loading.setSpinnerType(LoadingHUD.SIMPLE_ROUND_SPINNER);
        mFragmentManager = getActivity().getSupportFragmentManager();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        args = getArguments();
    }

    @Nullable
    @Override
    public final View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        int layoutId = getLayoutId();
        if (layoutId == 0)
            throw new RuntimeException("找不到Layout资源,Fragment初始化失败!");
        mFragmentView = inflater.inflate(layoutId, container, false);
        ViewGroup parent = (ViewGroup) mFragmentView.getParent();
        if (parent != null)
            parent.removeView(mFragmentView);
        unbinder = ButterKnife.bind(this, mFragmentView);
        mPresenter = createPresenter();
        return mFragmentView;
    }

    @Override
    public final void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        onViewCreatedFinish(savedInstanceState);
    }

    @Override
    public void onStop() {
        super.onStop();
        loading.dismiss();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
        if (mFragmentView != null)
            ((ViewGroup) mFragmentView.getParent()).removeView(mFragmentView);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (mPresenter != null)
            mPresenter.onDestroy();
    }

    /**
     * 跳转目标Activity
     *
     * @param targetClass 目标Activity类型
     */
    protected void startActivity(Class<? extends Activity> targetClass) {
        ((BaseActivity) getActivity()).startActivity(targetClass);
    }

    /**
     * 跳转目标Activity(传递参数)
     *
     * @param targetClass 目标Activity类型
     * @param args        传递参数
     */
    public void startActivity(Class<? extends Activity> targetClass, Bundle args) {
        ((BaseActivity) getActivity()).startActivity(targetClass, args);
    }

    /**
     * 隐式跳转目标Activity
     *
     * @param action 隐式动作
     */
    public void startActivity(String action) {
        ((BaseActivity) getActivity()).startActivity(action);
    }

    /**
     * 隐式跳转目标Activity
     *
     * @param action 隐式动作
     */
    public void startActivity(String action, Bundle args) {
        ((BaseActivity) getActivity()).startActivity(action, args);
    }

}
