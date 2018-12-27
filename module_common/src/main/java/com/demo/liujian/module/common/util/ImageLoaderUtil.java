package com.demo.liujian.module.common.util;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.demo.liujian.module.common.R;

/**
 * Description:图片加载类 <br>
 * <br/>
 * Creator:jhliu <br>
 * Date:2017/3/6 0006 16:43
 */
public class ImageLoaderUtil {
    /**
     * 加载非gif图片(具有默认图片)
     *
     * @param mContext   上下文
     * @param url        图片加载地址
     * @param mImageView 图片显示控件
     */
    public static void loadImage(Context mContext, String url, ImageView mImageView) {
        Glide.with(mContext)
                .load(url)
                .centerCrop()
                .placeholder(R.drawable.bg_trans_circle)
                .crossFade()
                .diskCacheStrategy(DiskCacheStrategy.SOURCE)
                .into(mImageView);
    }

    /**
     * 不缓存，全部从网络加载图片
     *
     * @param context 组件对象
     * @param url      请求图片地址
     * @param iv       加载图片控件
     */
    public static void loadAll(Context context, String url, ImageView iv) {
        Glide.with(context)
                .load(url)
                .crossFade()
                .skipMemoryCache(true)
                .diskCacheStrategy(DiskCacheStrategy.NONE)
                .into(iv);
    }


    /**
     * 加载gif图片(不具有默认图片)
     *
     * @param mContext   上下文对象
     * @param url        图片加载地址
     * @param mImageView 图片显示控件
     */
    public static void loadGifImage(Context mContext, String url, ImageView mImageView) {
        Glide.with(mContext)
                .load(url)
                .asGif()
                .centerCrop()
                .crossFade()
                .diskCacheStrategy(DiskCacheStrategy.SOURCE)
                .into(mImageView);
    }

    /**
     * 加载gif图片(不具有默认图片)
     *
     * @param mContext   上下文对象
     * @param resId      图片加载地址
     * @param mImageView 图片显示控件
     */
    public static void loadGifImage(Context mContext, int resId, ImageView mImageView) {
        Glide.with(mContext)
                .load(resId)
                .asGif()
                .centerCrop()
                .crossFade()
                .diskCacheStrategy(DiskCacheStrategy.SOURCE)
                .into(mImageView);
    }

    /**
     * 加载gif图片(不具有默认图片)
     *
     * @param mContext   上下文对象
     * @param url        图片加载地址
     * @param mImageView 图片显示控件
     * @param width      图片宽
     * @param height     图片高
     */
    public static void loadGifImage(Context mContext, String url, ImageView mImageView,int width,int height) {
        Glide.with(mContext)
                .load(url)
                .asGif()
                .centerCrop()
                .diskCacheStrategy(DiskCacheStrategy.SOURCE)
                .override(width, height)
                .into(mImageView);
    }

    /**
     * 加载gif图片(不具有默认图片)
     *
     * @param mContext   上下文对象
     * @param resId      图片加载地址
     * @param mImageView 图片显示控件
     * @param width      图片宽
     * @param height     图片高
     */
    public static void loadGifImage(Context mContext, int resId, ImageView mImageView,int width,int height) {
        Glide.with(mContext)
                .load(resId)
                .asGif()
                .centerCrop()
                .diskCacheStrategy(DiskCacheStrategy.SOURCE)
                .override(width, height)
                .into(mImageView);
    }

}
