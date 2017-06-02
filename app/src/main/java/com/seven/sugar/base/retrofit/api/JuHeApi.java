package com.seven.sugar.base.retrofit.api;

import com.seven.sugar.base.BaseApi;
import com.seven.sugar.main.model.bean.ChengYu;

import java.util.Map;

import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import rx.Observable;

/**
 * Created by Seven on 2017/4/3.
 */
public interface JuHeApi {

    @FormUrlEncoded
    @POST(BaseApi.Url.URL_CHENG_YU_QUERY)
    Observable<ChengYu> queryChengYu(@FieldMap Map<String, String> map);
}
