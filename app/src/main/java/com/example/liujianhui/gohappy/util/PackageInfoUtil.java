package com.example.liujianhui.gohappy.util;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;

/**
 * app版本信息
 *
 * Created by liujianhui on 2016/8/2.
 */
public class PackageInfoUtil {
    private Context mContext;

    public PackageInfoUtil(Context mContext){
        this.mContext = mContext;
    }
    /**
     * 获取版本信息
     */
    private PackageInfo getPackageInfo(){
        PackageInfo packageInfo = null;
        PackageManager pm = mContext.getPackageManager();
        try {
             packageInfo =  pm.getPackageInfo(mContext.getPackageName(), PackageManager.GET_CONFIGURATIONS);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return packageInfo;
    }
    /**
     * 获取版本号
     */
    public String getVersionCode(){
        return String.valueOf(getPackageInfo().versionCode);
    }
    /**
     * 获取版本名
     */
    public String getVersionName(){
        return getPackageInfo().versionName;
    }
}
