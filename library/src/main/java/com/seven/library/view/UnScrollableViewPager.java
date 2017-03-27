package com.seven.library.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;

import com.seven.library.R;

/**
 * 可设置不可滑动的ViewPager
 * Created by Seven on 2017/3/20.
 */
public class UnScrollableViewPager extends ViewPager {

    private boolean enableTouchScroll;
    private boolean enableSelectScroll;

    public UnScrollableViewPager(Context context) {
        super(context);
        setOverScrollMode(OVER_SCROLL_NEVER);
    }

    public UnScrollableViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
        initStyleable(context, attrs);
        setOverScrollMode(OVER_SCROLL_NEVER);
    }

    private void initStyleable(Context context, AttributeSet attrs) {
        TypedArray array = context.obtainStyledAttributes(attrs, R.styleable.UnScrollableViewPager);
        enableTouchScroll = array.getBoolean(R.styleable.UnScrollableViewPager_enable_touch_scroll, true);
        enableSelectScroll = array.getBoolean(R.styleable.UnScrollableViewPager_enable_select_scroll, true);
        array.recycle();
    }

    public void setEnableTouchScroll(boolean enableTouchScroll) {
        this.enableTouchScroll = enableTouchScroll;
    }

    public void setEnableSelectScroll(boolean enableSelectScroll) {
        this.enableSelectScroll = enableSelectScroll;
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        return enableTouchScroll && super.onTouchEvent(ev);
    }

    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        return enableTouchScroll && super.onTouchEvent(ev);
    }

    @Override
    public void setCurrentItem(int item) {
        super.setCurrentItem(item, enableSelectScroll);
    }
}
