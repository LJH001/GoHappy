package com.example.liujianhui.gohappy.util;

import android.app.Activity;
import android.util.DisplayMetrics;

/**
 * 屏幕工具类
 * Created by liujianhui on 2016/7/31.
 */
public class ScreenInfoUtil {
    private Activity mActivity;
    /**手机屏幕宽*/
    public  int mWidth;

    /**手机屏幕高*/
    public int mHeight;

    /**手机密度（0.75 / 1.0 / 1.5）*/
    public float mDensity;

    /**屏幕密度DPI（120 / 160 / 240）*/
    public int mDensityDpi;


    /**
     * 构造方法
     * @param mActivity
     */
    public ScreenInfoUtil(Activity mActivity){
        this.mActivity =  mActivity;
        init();
    }

    private void init() {
        DisplayMetrics metrics = new DisplayMetrics();
        mActivity.getWindowManager().getDefaultDisplay().getMetrics(metrics);
        mWidth =  metrics.widthPixels;
        mHeight = metrics.heightPixels;
        mDensity = metrics.density;
        mDensityDpi = metrics.densityDpi;
    }
    /**
     * 设置屏幕的宽
     */
    public void setWidth(int width){
        mWidth =  width;
    }
    /**
     * 获取屏幕的宽
     */
    public int getWidth(){
        return mWidth;
    }
    /**
     * 设置屏幕的宽
     */
    public void setHeight(int height){
        mHeight =  height;
    }
    /**
     * 获取屏幕的高
     */
    public int getHeight(){
        return mHeight;
    }
}
