package com.seven.sugar.main.contract;


import com.seven.library.base.model.IInteractor;
import com.seven.library.base.ui.IView;
import com.seven.sugar.main.model.bean.ChengYu;

import rx.Observable;

/**
 * Created by Seven on 2017/4/10.
 */

public interface ChengYuContract {
    interface View extends IView {
        void showChengYu(ChengYu.ResultBean bean);
    }

    interface Interactor extends IInteractor {
        Observable<ChengYu> queryChengYu(String word);
    }
}
