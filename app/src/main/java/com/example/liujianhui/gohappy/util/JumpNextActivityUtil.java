package com.example.liujianhui.gohappy.util;

import android.app.Activity;
import android.content.Intent;

import com.example.liujianhui.gohappy.R;


/**
 * 页面跳转工具类
 *
 * Created by liujianhui on 2016/6/13 0013.
 */
public class JumpNextActivityUtil {
    /**
     * 跳转到下一个页面
     *
     * @param mActivity 上下文
     * @param mClass 页面
     */
    public static void jumpToNextActivity(Activity mActivity,Class<?> mClass){
        Intent mIntent = new Intent(mActivity, mClass);
        mActivity.startActivity(mIntent);
        mActivity.finish();
        mActivity.overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
    }
    /**
     * 跳转到下一个页面
     *
     * @param mActivity 上下文
     * @param mClass 页面
     */
    public static void jump2NextActivity(Activity mActivity,Class<?> mClass){
        Intent mIntent = new Intent(mActivity, mClass);
        mActivity.startActivity(mIntent);
        mActivity.overridePendingTransition(R.anim.slide_in_right,R.anim.slide_out_left);
    }
}
