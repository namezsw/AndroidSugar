package com.seven.library.view;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;

import com.seven.library.R;

import static com.seven.library.R.id.iv_icon;

/**
 * loading对话框
 * Created by Seven on 2017/3/10.
 */
public class LoadingHUD extends Dialog {

    private ImageView ivIcon;
    private Context context;
    private RotateAnimation mRotateAnimation;//旋转动画

    public static LoadingHUD build(Context context) {
        return new LoadingHUD(context);
    }

    public LoadingHUD(Context context) {
        super(context, R.style.LoadingDialogTheme);
        this.setCanceledOnTouchOutside(false);
        this.context = context;
        View view = getLayoutInflater().inflate(R.layout.widget_loading_dialog_progress, null);
        ivIcon = (ImageView) view.findViewById(iv_icon);
        this.setContentView(view);
    }

    /**
     * 初始化旋转动画
     */
    private void initAnimation() {
        mRotateAnimation = new RotateAnimation(0, 360, Animation.RELATIVE_TO_SELF, 0.5F, Animation.RELATIVE_TO_SELF, 0.5F);
        mRotateAnimation.setInterpolator(new LinearInterpolator());
        mRotateAnimation.setDuration(1000);
        mRotateAnimation.setRepeatCount(Animation.INFINITE);
    }

    @Override
    public void show() {
        try {
            if (this.isShowing()) {
                return;
            }
            if (!((Activity) context).isFinishing()) {
                super.show();
                if (mRotateAnimation == null) {
                    initAnimation();
                }
                ivIcon.startAnimation(mRotateAnimation);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void dismiss() {
        ivIcon.clearAnimation();
        super.dismiss();
    }

}