package com.demo.liujian.module.common.util;

import android.content.Context;
import android.content.SharedPreferences;

import com.demo.liujian.module.common.base.BaseApplication;
import com.demo.liujian.module.common.contants.AppConstant;

/**
   *Description:保存 <br>
   * <br/>
   *Creator:jhliu <br>
   *Date:2017/3/8 0008 18:01
 */
public class SharepreferenceUtil {
    private static final boolean DEFAULT_NIGHT_MODE = false;

    public static SharedPreferences getAppSp() {
        return BaseApplication.getInstance().getSharedPreferences(AppConstant.KEY_SPF, Context.MODE_PRIVATE);
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

    /**
     * 保存选中的item和tab值
     * @param itemId
     */
    public static void saveCurrentItem(int itemId) {
        getAppSp().edit().putInt(AppConstant.SP_NIGHT_MODE, itemId).apply();
    }

    /**
     *获取选中的item和tab值
     */
    public static int getCurrentItem() {
        return getAppSp().getInt(AppConstant.SP_NIGHT_MODE, 1);
    }
}
