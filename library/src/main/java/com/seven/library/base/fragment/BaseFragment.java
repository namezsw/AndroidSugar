package com.seven.library.base.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.seven.library.base.presenter.IPresenter;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by Seven on 2017/3/10.
 */
public abstract class BaseFragment<P extends IPresenter> extends Fragment {

    protected P mPresenter;
    private View mFragmentView = null;
    protected Context mContext;

    //fragment管理器
    protected FragmentManager mFragmentManager;
    protected Bundle args;//传递的参数值
    private Unbinder unbinder;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mContext = context;
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

    protected abstract int getLayoutId();

    protected abstract P createPresenter();

    public abstract void onViewCreatedFinish(Bundle savedInstanceState);

}
