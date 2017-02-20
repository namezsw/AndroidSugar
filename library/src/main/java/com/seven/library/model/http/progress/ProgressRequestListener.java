package com.seven.library.model.http.progress;

/**
 * 请求体进度回调接口，比如用于文件上传中
 * Created by Seven on 2017/2/15.
 */
public interface ProgressRequestListener {

    void onRequestProgress(long bytesWritten, long contentLength, boolean done);
}
