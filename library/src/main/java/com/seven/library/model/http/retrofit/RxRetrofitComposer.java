package com.seven.library.model.http.retrofit;


import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by Seven on 2017/3/10.
 */

public class RxRetrofitComposer {

    public static <T> Observable.Transformer<T, T> applySchedulers() {
        return new Observable.Transformer<T, T>() {
            @Override
            public Observable<T> call(Observable<T> observable) {
                return observable.observeOn(AndroidSchedulers.mainThread())
                        .subscribeOn(Schedulers.io())
                        .unsubscribeOn(Schedulers.io());
            }
        };
    }
}
