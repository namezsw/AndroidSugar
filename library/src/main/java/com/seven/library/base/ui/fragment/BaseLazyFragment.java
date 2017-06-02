package com.seven.library.base.ui.fragment;

/**
 * Created by Seven on 2017/4/10.
 */

public abstract class BaseLazyFragment extends BaseV4Fragment {

    private boolean isFirstVisible = true;
    private boolean isFirstInvisible = true;

    protected void onFirstUserVisible() {
    }

    protected void onFirstUserInvisible() {
    }

    protected void onUserVisible() {
    }

    protected void onUserInvisible() {
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (isVisibleToUser) {
            if (isFirstVisible) {
                isFirstVisible = false;
                onFirstUserVisible();
            } else {
                onUserVisible();
            }
        } else {
            if (isFirstInvisible) {
                isFirstInvisible = false;
                onFirstUserInvisible();
            } else {
                onUserInvisible();
            }
        }
    }
}
