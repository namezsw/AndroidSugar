package com.seven.library.view.image.glide;

import android.content.Context;

import com.bumptech.glide.GlideBuilder;
import com.bumptech.glide.annotation.GlideModule;
import com.bumptech.glide.load.engine.cache.ExternalCacheDiskCacheFactory;
import com.bumptech.glide.module.AppGlideModule;

/**
 * Created by Seven on 2017/10/15.
 */

@GlideModule
public class MyAppGlideModule extends AppGlideModule {

    @Override
    public void applyOptions(Context context, GlideBuilder builder) {

        String diskCacheName = "glide_cache";//设置磁盘缓存文件夹的文件夹名
        int diskCacheSizeBytes = 50 * 1024 * 1024;//设置磁盘缓存的大小50MB
        builder.setDiskCache(new ExternalCacheDiskCacheFactory(context,
                diskCacheName, diskCacheSizeBytes));
    }
}
