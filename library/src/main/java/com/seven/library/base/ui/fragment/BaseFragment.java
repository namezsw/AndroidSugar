package com.seven.library.base.ui.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.seven.library.controller.EventBusHelper;
import com.seven.library.view.LoadingHUD;
import com.trello.rxlifecycle2.components.support.RxFragment;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by Seven on 2017/4/10.
 */

public abstract class BaseFragment extends RxFragment {

    private View mFragmentView = null;
    protected LoadingHUD loading;//加载框
    private Unbinder unbinder;

    protected abstract int getLayoutId();

    public abstract void onViewCreatedFinish(View view, Bundle savedInstanceState);

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.loading = LoadingHUD.build(context);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public final View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mFragmentView = inflater.inflate(getLayoutId(), container, false);
        ViewGroup parent = (ViewGroup) mFragmentView.getParent();
        if (parent != null) {
            parent.removeView(mFragmentView);
        }
        return mFragmentView;
    }

    @Override
    public final void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        unbinder = ButterKnife.bind(this, view);
        onViewCreatedFinish(view, savedInstanceState);
        if (useEventBus()) {
            EventBusHelper.register(this);
        }
    }

    @Override
    public void onStop() {
        super.onStop();
        loading.dismiss();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if (useEventBus()) {
            EventBusHelper.unregister(this);
        }
        unbinder.unbind();
        if (mFragmentView != null) {
            ((ViewGroup) mFragmentView.getParent()).removeView(mFragmentView);
        }
    }

    protected boolean useEventBus() {
        return false;
    }

}
