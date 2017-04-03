package com.seven.sugar.home.view;


import com.seven.library.base.view.IView;
import com.seven.sugar.home.model.bean.ChengYu;

/**
 * Created by Seven on 2017/4/3.
 */
public interface ChengYuView extends IView {

    void showChengYu(ChengYu.ResultBean bean);

    /**
     * 显示错误信息
     */
    void showToast(String msg);

    void showLoading();

    void dismissLoading();
}
