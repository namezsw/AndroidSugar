package com.seven.sugar.home.presenter;

import android.os.Bundle;

import com.seven.library.base.presenter.IPresenter;


/**
 * Created by Seven on 2017/4/3.
 */
public interface ChnegYuPresenter extends IPresenter {

    void initData(Bundle bundle);

    void queryChengYu(String word);
}
