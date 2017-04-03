package com.seven.sugar.home.model.interactor;

import android.os.Bundle;

import com.seven.library.base.model.IInteractor;
import com.seven.sugar.home.model.bean.ChengYu;

import rx.Observable;

/**
 * Created by Seven on 2017/4/3.
 */
public interface ChengYuInteractor extends IInteractor {

    void initData(Bundle bundle);

    Observable<ChengYu> queryChengYu(String word);

}
