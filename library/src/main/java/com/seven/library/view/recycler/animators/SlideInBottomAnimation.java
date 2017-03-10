package com.seven.library.view.recycler.animators;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.view.View;

/**
 * 底部进入
 * Created by Seven on 2017/3/10.
 */
public class SlideInBottomAnimation implements IAnimation {

    @Override
    public Animator[] getAnimators(View view) {
        return new Animator[]{
                ObjectAnimator.ofFloat(view, "translationY", view.getMeasuredHeight(), 0)
        };
    }
}
