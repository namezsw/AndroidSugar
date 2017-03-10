package com.seven.library.model.http.retrofit;

/**
 * Created by Seven on 2017/3/10.
 */
public interface BaseCallback<T> {

    void refreshData(T data);

    void loadMoreData(T data);

    void dataNoMore();

    void showSuccessToast(String msg);

    void showErrorToast(String msg);

    void showEmptyView();

    void showErrorView();

    void complete();
}
