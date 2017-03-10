package com.seven.library.view.recycler.animators;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.view.View;

/**
 * 缩放进入动画
 * Created by Seven on 2017/3/10.
 */
public class ScaleInAnimation implements IAnimation {
    private final float DEFAULT_SCALE_FROM = 0.5F;
    private final float mFrom;

    public ScaleInAnimation() {
        mFrom = DEFAULT_SCALE_FROM;
    }

    public ScaleInAnimation(float from) {
        mFrom = from;
    }

    @Override
    public Animator[] getAnimators(View view) {
        return new Animator[]{
                ObjectAnimator.ofFloat(view, "scaleX", mFrom, 1.0F),
                ObjectAnimator.ofFloat(view, "scaleY", mFrom, 1.0F)
        };
    }
}
