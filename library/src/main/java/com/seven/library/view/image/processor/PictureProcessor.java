package com.seven.library.view.image.processor;

import android.content.Context;
import android.graphics.Bitmap;

import com.facebook.imagepipeline.request.BaseRepeatedPostProcessor;

import java.util.LinkedList;

/**
 * fresco图片处理
 * Created by Seven on 2017/2/15.
 */
public class PictureProcessor extends BaseRepeatedPostProcessor {
    private Context mContext;
    private int mPosition;
    private ProcessorInterface mProcessorInterface;
    private LinkedList<ProcessorInterface> processorList = new LinkedList<>();

    public PictureProcessor(Context context) {
        mContext = context;
    }

    public PictureProcessor addProcessor(ProcessorInterface processorInterface) {
        processorList.add(processorInterface);
        return this;
    }

    public PictureProcessor addProcessor(ProcessorInterface processorInterface, int position) {
        mProcessorInterface = processorInterface;
        mPosition = position;
        return this;
    }

    @Override
    public void process(Bitmap bitmap) {
        for (ProcessorInterface processor : processorList) {
            processor.process(mContext, bitmap);
        }
        if (null != mProcessorInterface)
            mProcessorInterface.process(mContext, bitmap, mPosition);
    }
}
