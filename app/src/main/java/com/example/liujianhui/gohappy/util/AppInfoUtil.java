
package com.example.liujianhui.gohappy.util;

import android.app.ActivityManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.util.DisplayMetrics;
import android.view.WindowManager;

import java.util.List;

/**
 * 获取APP相关内容的工具类
 *
 * @author yansu
 */
public class AppInfoUtil {

    /**
     * 获取上下文对应的app的label
     * 
     * @param context   上下文
     * @return  label
     * @author yansu
     */
    public static String getAppLabel(Context context) {
        CharSequence label = context.getPackageManager().getApplicationLabel(context.getApplicationInfo());
        if (label != null) {
            return label.toString();
        }
        return null;
    }

    /**
     * 获取指定包名的app的label
     * 
     * @param context       上下文
     * @param packageName   包名
     * @return      label
     * @author yansu
     */
    public static String getAppLabel(Context context, String packageName) {
        PackageManager pm = context.getPackageManager();
        try {
            PackageInfo info = pm.getPackageInfo(packageName, 0);
            CharSequence label = info.applicationInfo.loadLabel(pm);
            if (label != null) {
                return label.toString();
            }
        } catch (NameNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 获取app的icon
     * 
     * @param context   上下文
     * @return      icon
     * @author yansu
     */
    public static Drawable getAppIcon(Context context) {
        return context.getPackageManager().getApplicationIcon(context.getApplicationInfo());
    }
    
    /**
     * 获取指定包名的app的icon
     * 
     * @param context       上下文
     * @param packageName   包名
     * @return      icon
     * @author yansu
     */
    public static Drawable getAppIcon(Context context, String packageName) {
        PackageManager pm = context.getPackageManager();
        try {
            PackageInfo info = pm.getPackageInfo(packageName, 0);
            return info.applicationInfo.loadIcon(pm);
        } catch (NameNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 当前屏幕显示是否为竖屏
     * 
     * @param context       上下文
     * @return      true:竖屏, false:横屏
     * @author yansu
     */
    public static boolean isScreenPortrait(Context context) {
        return context.getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT;
    }

    /**
     * 获取应用版本-VersionCode
     * 
     * @param context   上下文
     * @return 获取失败，则返回null
     * @author yansu
     */
    public static String getAppVersionCode(Context context) {
        try {
            PackageInfo localPackageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
            return String.valueOf(localPackageInfo.versionCode);
        } catch (NameNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 获取应用版本-VersionName
     * 
     * @param context   上下文
     * @return 获取失败，则返回null
     * @author yansu
     */
    public static String getAppVersionName(Context context) {
        try {
            PackageInfo localPackageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
            return localPackageInfo.versionName;
        } catch (NameNotFoundException e) {
            e.printStackTrace();
        }
        return "";
    }

    /**
     * 获取当前屏幕分辨率
     * 
     * @param context   上下文
     * @return 屏幕分辨率(宽x高)，例如：“480x800”
     * @author yansu
     */
    public static String getDisplayResolution(Context context) {
        int[] wh = getDisplayResolutionWH(context);
        return wh[0] + "x" + wh[1];
    }
    
    /**
     * 获取当前屏幕分辨率
     * 
     * @param context   上下文
     * @return 屏幕分辨率(宽 高)，例如：[480,800]
     * @author yansu
     */
    public static int[] getDisplayResolutionWH(Context context) {
        DisplayMetrics dm = new DisplayMetrics();
        WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        wm.getDefaultDisplay().getMetrics(dm);
        return new int[]{dm.widthPixels,dm.heightPixels};
    }

    /**
     * 检查权限
     * 
     * @param context           上下文
     * @param permissionString  检查的权限
     * @return      true:有该权限,false:没有该权限
     * @author yansu
     */
    public static boolean checkPermission(Context context, String permissionString) {
        return context.getPackageManager().checkPermission(permissionString, context.getPackageName()) == 0;
    }
    
    /**
     * 清空task堆栈中的activity
     * 
     * @param context   上下文
     * @author yansu
     */
    public static void clearTask(Context context){
        try {
            /**
             * 清除task中所有的activity
             */
            // 通过context获取系统服务，得到ActivityManager
            ActivityManager manager = (ActivityManager) context
                    .getSystemService(Context.ACTIVITY_SERVICE);
    
            // 获取当前运行中的TaskInfo
            // 获取的是一个List集合，也就是说当前系统中的task有多个
            // 关于该方法的参数，我从源码看了下，是指返回集合的最大可能条目数，实际返回数可能
            // 小于这个数目，取决于用户启动了几个task
            List<ActivityManager.RunningTaskInfo> tasks = manager.getRunningTasks(1);
            ComponentName baseActivity = tasks.get(0).baseActivity;
            Intent i = new Intent();
            i.setComponent(baseActivity);
            i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
            i.putExtra("exit", "1");
            context.startActivity(i);
        }catch(Exception e){
            LogUtil.et("ClearTask", e, e.getMessage());
        }
    }

}
