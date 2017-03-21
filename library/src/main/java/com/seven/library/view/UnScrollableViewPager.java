package com.seven.library.view;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;

/**
 * 可设置不可滑动的ViewPager
 * Created by Seven on 2017/3/20.
 */
public class UnScrollableViewPager extends ViewPager {

    private boolean noTouchScroll = false;
    private boolean noItemScroll = false;

    public UnScrollableViewPager(Context context) {
        super(context);
        setOverScrollMode(OVER_SCROLL_NEVER);
    }

    public UnScrollableViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
        setOverScrollMode(OVER_SCROLL_NEVER);
    }

    public void setNoTouchScroll(boolean noTouchScroll) {
        this.noTouchScroll = noTouchScroll;
    }

    public void setNoItemScroll(boolean noItemScroll) {
        this.noItemScroll = noItemScroll;
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        return !noTouchScroll && super.onTouchEvent(ev);
    }

    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        return !noTouchScroll && super.onTouchEvent(ev);
    }

    @Override
    public void setCurrentItem(int item) {
        super.setCurrentItem(item, !noItemScroll);
    }
}
