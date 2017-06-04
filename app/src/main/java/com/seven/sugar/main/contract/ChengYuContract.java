package com.seven.sugar.main.contract;


import com.seven.library.base.model.IInteractor;
import com.seven.library.base.ui.IView;
import com.seven.sugar.base.retrofit.model.Model;
import com.seven.sugar.main.model.bean.ChengYuBean;

import rx.Observable;

/**
 * Created by Seven on 2017/4/10.
 */

public interface ChengYuContract {
    interface View extends IView {
        void showChengYu(ChengYuBean bean);
    }

    interface Interactor extends IInteractor {
        Observable<Model<ChengYuBean>> queryChengYu(String word);
    }
}
