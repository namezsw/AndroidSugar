package com.seven.library.view.recycler.animators;

import android.animation.Animator;
import android.view.View;

/**
 * 动画组接口
 * Created by Seven on 2017/3/10.
 */
public interface IAnimation {

    Animator[] getAnimators(View view);
}
