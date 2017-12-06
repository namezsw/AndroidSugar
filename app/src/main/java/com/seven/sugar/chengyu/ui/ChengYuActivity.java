package com.seven.sugar.chengyu.ui;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.seven.library.base.ui.activity.BaseMVPActivity;
import com.seven.library.view.image.glide.ImageLoader;
import com.seven.sugar.GlobalApplication;
import com.seven.sugar.R;
import com.seven.sugar.chengyu.contract.ChengYuContract;
import com.seven.sugar.chengyu.di.component.DaggerChengYuComponent;
import com.seven.sugar.chengyu.di.module.ChengYuModule;
import com.seven.sugar.chengyu.model.bean.ChengYuBean;
import com.seven.sugar.chengyu.presenter.ChengYuPresenter;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by Seven on 2017/4/3.
 */
public class ChengYuActivity extends BaseMVPActivity<ChengYuPresenter> implements ChengYuContract.View {

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.test_text_view)
    TextView testTextView;
    @BindView(R.id.anim_view)
    ImageView animView;
    @BindView(R.id.anim_view2)
    ImageView animView2;
    @BindView(R.id.anim_view3)
    ImageView animView3;

    @Override
    protected void injectComponent() {
        DaggerChengYuComponent.builder()
                .appComponent(GlobalApplication.getInstance().getAppComponent())
                .chengYuModule(new ChengYuModule(this))
                .build()
                .inject(this);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_test;
    }

    @Override
    protected void onViewCreated(Bundle savedInstanceState) {
        super.onViewCreated(savedInstanceState);
        setSupportActionBar(toolbar);
        ImageLoader.getInstance().loadGifImage(R.drawable.score_curves, animView);
        ImageLoader.getInstance().loadRoundImage("http://image.sports.baofeng.com/25a3dbb0c99c5e48e52e60941ed230be",
                R.drawable.avata_default,8, animView2);
        ImageLoader.getInstance().loadImage("http://image.sports.baofeng.com/19ce5d6ac3b4fff255196f200b1d3079",
                R.color.white, animView3);

    }

    @OnClick({R.id.test_text_view})
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.test_text_view:
                mPresenter.queryChengYu("积少成多");
                break;
            default:
                break;
        }
    }

    @Override
    public void showChengYu(ChengYuBean bean) {
        testTextView.setText(bean.getChengyujs());
    }

}