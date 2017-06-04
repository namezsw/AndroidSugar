package com.seven.library.model.okhttp.interceptor;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * header信息拦截器
 * Created by Seven on 2017/2/15.
 */
public class HeaderInfoInterceptor implements Interceptor {
    private static final String TAG = HeaderInfoInterceptor.class.getSimpleName();
    private String version;

    public HeaderInfoInterceptor(String version) {
        this.version = version;
    }

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();
        Request newHeaderRequest = request.newBuilder()
                .addHeader("app-version", version)
                .build();

        return chain.proceed(newHeaderRequest);
    }
}
