package com.example.liujianhui.gohappy.util;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.liujianhui.gohappy.app.MyApplication;
import com.example.liujianhui.gohappy.contants.AppConstant;

/**
   *Description:保存 <br>
   * <br/>
   *Creator:jhliu <br>
   *Date:2017/3/8 0008 18:01
 */
public class SharepreferenceUtil {
    private static final boolean DEFAULT_NIGHT_MODE = false;

    public static SharedPreferences getAppSp() {
        return MyApplication.getInstance().getSharedPreferences(AppConstant.KEY_SPF, Context.MODE_PRIVATE);
    }

    /**
     * 获取夜间模式状态
     * @return
     */
    public static boolean getNightModeState() {
        return getAppSp().getBoolean(AppConstant.SP_NIGHT_MODE, DEFAULT_NIGHT_MODE);
    }

    /**
     * 设置夜间模式状态
     * @param state
     */
    public static void setNightModeState(boolean state) {
        getAppSp().edit().putBoolean(AppConstant.SP_NIGHT_MODE, state).apply();
    }
}
