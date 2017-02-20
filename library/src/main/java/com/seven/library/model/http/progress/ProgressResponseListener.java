package com.seven.library.model.http.progress;

/**
 * 响应体进度回调接口，比如用于文件下载中
 * Created by Seven on 2017/2/15.
 */
public interface ProgressResponseListener {

    void onResponseProgress(long bytesRead, long contentLength, boolean done);
}
