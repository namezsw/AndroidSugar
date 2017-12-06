package com.seven.library.view.image.glide;

import android.content.Context;
import android.os.Looper;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;
import com.bumptech.glide.request.RequestOptions;
import com.seven.library.R;
import com.seven.library.view.image.glide.transformation.GlideCircleTransform;
import com.seven.library.view.image.glide.transformation.GlideRoundTransform;


/**
 * Created by Seven on 2017/10/15.
 */

public class GlideImageLoaderStrategy implements BaseImageLoaderStrategy {

    @Override
    public void loadImage(String url, int placeholderId, ImageView imageView) {
        Glide.with(imageView.getContext())
                .load(url)
                .apply(new RequestOptions()
                        .placeholder(placeholderId)
                        .error(placeholderId)
                        .centerCrop()
                        .diskCacheStrategy(DiskCacheStrategy.ALL))
                .transition(DrawableTransitionOptions.withCrossFade())
                .into(imageView);
    }

    @Override
    public void loadImage(Context context, String url, int placeholderId, ImageView imageView) {
        Glide.with(context)
                .load(url)
                .apply(new RequestOptions()
                        .placeholder(placeholderId)
                        .error(placeholderId)
                        .centerCrop()
                        .diskCacheStrategy(DiskCacheStrategy.ALL))
                .transition(DrawableTransitionOptions.withCrossFade())
                .into(imageView);
    }


    @Override
    public void loadImage(String url, RequestOptions requestOptions, ImageView imageView) {
        Glide.with(imageView.getContext())
                .load(url)
                .apply(requestOptions)
                .transition(DrawableTransitionOptions.withCrossFade())
                .into(imageView);
    }

    @Override
    public void loadImage(String url, int placeholderId, int width, int height, ImageView imageView) {
        Glide.with(imageView.getContext())
                .load(url)
                .apply(new RequestOptions()
                        .placeholder(placeholderId)
                        .error(placeholderId)
                        .override(width, height)
                        .centerCrop()
                        .diskCacheStrategy(DiskCacheStrategy.ALL))
                .transition(DrawableTransitionOptions.withCrossFade())
                .into(imageView);
    }

    @Override
    public void loadImage(String url, ImageView imageView) {
        Glide.with(imageView.getContext())
                .load(url)
                .apply(new RequestOptions()
                        .placeholder(imageView.getDrawable())
                        .error(imageView.getDrawable())
                        .centerCrop()
                        .diskCacheStrategy(DiskCacheStrategy.ALL))
                .transition(DrawableTransitionOptions.withCrossFade())
                .into(imageView);
    }

    @Override
    public void loadCircleImage(String url, int placeholderId, ImageView imageView) {
        Glide.with(imageView.getContext())
                .load(url)
                .apply(new RequestOptions()
                        .placeholder(placeholderId)
                        .error(placeholderId)
                        .transforms(new CenterCrop(imageView.getContext())
                                , new GlideCircleTransform())
                        .diskCacheStrategy(DiskCacheStrategy.DATA))
                .transition(DrawableTransitionOptions.withCrossFade())
                .into(imageView);
    }

    @Override
    public void loadRoundImage(String url, int placeholderId, int radius, ImageView imageView) {
        Glide.with(imageView.getContext())
                .load(url)
                .apply(new RequestOptions()
                        .placeholder(placeholderId)
                        .error(placeholderId)
                        .transforms(new CenterCrop(imageView.getContext())
                                , new GlideRoundTransform())
                        .diskCacheStrategy(DiskCacheStrategy.DATA))
                .transition(DrawableTransitionOptions.withCrossFade())
                .into(imageView);
    }


    @Override
    public void loadGifImage(String url, int placeholderId, ImageView imageView) {
        Glide.with(imageView.getContext())
                .load(R.drawable.ani_loading)
                .apply(new RequestOptions()
                        .placeholder(placeholderId)
                        .error(placeholderId)
                        .diskCacheStrategy(DiskCacheStrategy.DATA))
                .into(imageView);
    }

    @Override
    public void loadGifImage(int resId, ImageView imageView) {
        Glide.with(imageView.getContext())
                .load(resId)
                .apply(new RequestOptions()
                        .placeholder(imageView.getDrawable())
                        .error(imageView.getDrawable())
                        .diskCacheStrategy(DiskCacheStrategy.DATA))
                .into(imageView);
    }

    @Override
    public void clearImageDiskCache(final Context context) {
        try {
            if (Looper.myLooper() == Looper.getMainLooper()) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        Glide.get(context.getApplicationContext()).clearDiskCache();
                    }
                }).start();
            } else {
                Glide.get(context.getApplicationContext()).clearDiskCache();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void clearImageMemoryCache(Context context) {
        try {
            if (Looper.myLooper() == Looper.getMainLooper()) { //只能在主线程执行
                Glide.get(context.getApplicationContext()).clearMemory();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void trimMemory(Context context, int level) {
        Glide.get(context).trimMemory(level);
    }

}
