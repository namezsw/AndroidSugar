package com.seven.library.view.image;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.text.TextUtils;
import android.util.AttributeSet;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.drawable.ScalingUtils;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.common.ResizeOptions;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import com.seven.library.util.ResourcesUtils;
import com.seven.library.view.image.processor.PictureProcessor;
import com.seven.library.view.image.processor.ProcessorInterface;


/**
 * Fresco图片加载控件
 * Created by Seven on 2017/2/15.
 */
public class ImageDraweeView extends SimpleDraweeView {
    private ResizeOptions mResizeOptions;
    private PictureProcessor mProcessor;

    public ImageDraweeView(Context context) {
        this(context, null);
    }

    public ImageDraweeView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    private void init(Context context) {
        GenericDraweeHierarchy hierarchy = getHierarchy();
        hierarchy.setFadeDuration(0);//淡入淡出
        setHierarchy(hierarchy);
        mProcessor = new PictureProcessor(context);
    }

    public ImageDraweeView resize(int width, int height) {
        if (width == 0 || height == 0) {
            mResizeOptions = null;
            return this;
        }
        mResizeOptions = new ResizeOptions(width, height);
        return this;
    }

    /**
     * 添加加载后处理器
     *
     * @param processor 加载后处理器
     */
    public ImageDraweeView addProcessor(ProcessorInterface processor) {
        mProcessor.addProcessor(processor);
        return this;
    }

    /**
     * 添加加载后处理器
     *
     * @param processor 加载后处理器
     */
    public ImageDraweeView addProcessor(ProcessorInterface processor, int position) {
        mProcessor.addProcessor(processor, position);
        return this;
    }

    /**
     * 设置默认图片
     *
     * @param bitmap 默认图片
     */
    public void setDefaultImage(Bitmap bitmap) {
        GenericDraweeHierarchy hierarchy = getHierarchy();
        hierarchy.setPlaceholderImage(new BitmapDrawable(bitmap), ScalingUtils.ScaleType.FOCUS_CROP);
        setHierarchy(hierarchy);
    }

    /**
     * 设置默认图片
     *
     * @param resId 默认图片资源id
     */
    public void setDefaultImage(int resId) {
        Drawable drawable = ResourcesUtils.getDrawable(getContext(), resId);
        GenericDraweeHierarchy hierarchy = getHierarchy();
        hierarchy.setPlaceholderImage(drawable, ScalingUtils.ScaleType.FOCUS_CROP);
        setHierarchy(hierarchy);
    }

    /**
     * 设置默认图片
     *
     * @param drawable 默认图片
     */
    public void setDefaultImage(Drawable drawable) {
        GenericDraweeHierarchy hierarchy = getHierarchy();
        hierarchy.setPlaceholderImage(drawable, ScalingUtils.ScaleType.FOCUS_CROP);
        setHierarchy(hierarchy);
    }

    /**
     * 设置ScaleType
     *
     * @param scaleType ScaleType
     */
    public void setScaleType(ScalingUtils.ScaleType scaleType) {
        GenericDraweeHierarchy hierarchy = getHierarchy();
        hierarchy.setActualImageScaleType(scaleType);
        setHierarchy(hierarchy);
    }

    /**
     * 加载图片
     *
     * @param url 图片的url
     */
    public void setImageURL(String url) {
        setImageURL(url, false);
    }

    /**
     * 加载图片
     *
     * @param url             图片的url
     * @param isNeedProcessor 是否需要后加载器
     */
    public void setImageURL(String url, boolean isNeedProcessor) {
        if (TextUtils.isEmpty(url))
            return;
        Uri uri = Uri.parse(url);
        ImageRequestBuilder imageRequestBuilder = ImageRequestBuilder.newBuilderWithSource(uri)
                .setAutoRotateEnabled(true)
                .setLocalThumbnailPreviewsEnabled(true)
                .setResizeOptions(mResizeOptions);
        ImageRequest request;
        if (isNeedProcessor)
            request = imageRequestBuilder.setPostprocessor(mProcessor).build();
        else
            request = imageRequestBuilder.build();
        DraweeController controller = Fresco.newDraweeControllerBuilder()
                .setAutoPlayAnimations(true)
                .setImageRequest(request)
                .setTapToRetryEnabled(false)//加载失败时点击重新加载
                .setOldController(getController())
                .build();
        setController(controller);
    }
}
