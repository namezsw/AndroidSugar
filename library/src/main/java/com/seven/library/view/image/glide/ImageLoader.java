package com.seven.library.view.image.glide;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.request.RequestOptions;


/**
 * Created by Seven on 2017/10/15.
 */
public class ImageLoader {

    //图片默认加载类型 以后有可能有多种类型
    public static final int PIC_DEFAULT_TYPE = 0;

    //图片默认加载策略 以后有可能有多种图片加载策略
    public static final int LOAD_STRATEGY_DEFAULT = 0;

    private static ImageLoader mInstance;

    private BaseImageLoaderStrategy mStrategy;

    public ImageLoader() {
        mStrategy = new GlideImageLoaderStrategy();
    }

    //单例模式，节省资源
    public static ImageLoader getInstance() {
        if (mInstance == null) {
            synchronized (ImageLoader.class) {
                if (mInstance == null) {
                    mInstance = new ImageLoader();
                    return mInstance;
                }
            }
        }
        return mInstance;
    }

    public void loadImage(String url, int placeholder, ImageView imageView) {
        mStrategy.loadImage(url, placeholder, imageView);
    }

    public void loadImage(String url, RequestOptions requestOptions, ImageView imageView) {
        mStrategy.loadImage(url, requestOptions, imageView);
    }

    public void loadImage(Context context, String url, int placeholder, ImageView imageView) {
        mStrategy.loadImage(context, url, placeholder, imageView);
    }

    public void loadImage(String url, int placeholder, int width, int height, ImageView imageView) {
        mStrategy.loadImage(url, placeholder, width, height, imageView);
    }

    public void loadImage(String url, ImageView imageView) {
        mStrategy.loadImage(url, imageView);
    }

    public void loadGifImage(String url, int placeholder, ImageView imageView) {
        mStrategy.loadGifImage(url, placeholder, imageView);
    }

    public void loadGifImage(int resId, ImageView imageView) {
        mStrategy.loadGifImage(resId, imageView);
    }

    public void loadCircleImage(String url, int placeholder, ImageView imageView) {
        mStrategy.loadCircleImage(url, placeholder, imageView);
    }

    public void loadRoundImage(String url, int placeholder, int radius, ImageView imageView) {
        mStrategy.loadRoundImage(url, placeholder, radius, imageView);
    }

    /**
     * 策略模式的注入操作
     *
     * @param strategy
     */
    public void setLoadImgStrategy(BaseImageLoaderStrategy strategy) {
        mStrategy = strategy;
    }

    /**
     * 清除图片磁盘缓存
     */
    public void clearImageDiskCache(final Context context) {
        mStrategy.clearImageDiskCache(context);
    }

    /**
     * 清除图片内存缓存
     */
    public void clearImageMemoryCache(Context context) {
        mStrategy.clearImageMemoryCache(context);
    }

    /**
     * 根据不同的内存状态，来响应不同的内存释放策略
     *
     * @param context
     * @param level
     */
    public void trimMemory(Context context, int level) {
        mStrategy.trimMemory(context, level);
    }

    /**
     * 清除图片所有缓存
     */
    public void clearImageAllCache(Context context) {
        clearImageDiskCache(context.getApplicationContext());
        clearImageMemoryCache(context.getApplicationContext());
    }
}
