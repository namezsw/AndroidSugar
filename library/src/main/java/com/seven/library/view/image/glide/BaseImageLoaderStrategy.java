package com.seven.library.view.image.glide;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.request.RequestOptions;


/**
 * Created by Seven on 2017/10/15.
 */

interface BaseImageLoaderStrategy {

    void loadImage(String url, int placeholderId, ImageView imageView);

    void loadImage(String url, RequestOptions requestOptions, ImageView imageView);

    void loadImage(String url, int placeholderId, int weigth, int height, ImageView imageView);

    void loadImage(Context context, String url, int placeholderId, ImageView imageView);

    //无占位图
    void loadImage(String url, ImageView imageView);

    void loadCircleImage(String url, int placeholderId, ImageView imageView);

    void loadRoundImage(String url, int placeholderId, int radius, ImageView imageView);

    void loadGifImage(String url, int placeholderId, ImageView imageView);

    void loadGifImage(int resId, ImageView imageView);

    //清除硬盘缓存
    void clearImageDiskCache(final Context context);

    //清除内存缓存
    void clearImageMemoryCache(Context context);

    //根据不同的内存状态，来响应不同的内存释放策略
    void trimMemory(Context context, int level);

}
