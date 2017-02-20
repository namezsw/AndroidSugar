package com.seven.library.view.image.processor;

import android.content.Context;
import android.graphics.Bitmap;

/**
 * 图片处理接口
 * Created by Seven on 2017/2/15.
 */
public abstract class ProcessorInterface {

    public abstract void process(Context context, Bitmap bitmap);

    public void process(Context context, Bitmap bitmap, int position) {

    }
}
