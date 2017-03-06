package com.example.liujianhui.gohappy.util;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

/**
 * Description:图片加载类 <br>
 * <br/>
 * Creator:jhliu <br>
 * Date:2017/3/6 0006 16:43
 */
public class ImageLoaderUtil {
    /**
     * 图片加载
     * @param mContext 上下文
     * @param url 图片加载地址
     * @param resId 默认加载图片
     * @param mImageView 图片显示控件
     */
    public static void loadImage(Context mContext, String url, int resId, ImageView mImageView) {
        Glide
                .with(mContext)
                .load(url)
                .centerCrop()
                .placeholder(resId)
                .crossFade()
                .into(mImageView);
    }
}
