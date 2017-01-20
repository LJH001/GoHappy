package com.example.liujianhui.gohappy.app;

import android.app.Application;
import android.content.Context;
import android.widget.Toast;


import com.example.liujianhui.gohappy.contants.AppConstant;
import com.example.liujianhui.gohappy.contants.SdkContant;
import com.example.liujianhui.gohappy.util.LogUtil;
import com.squareup.leakcanary.LeakCanary;
import com.squareup.leakcanary.RefWatcher;
import com.tencent.bugly.crashreport.CrashReport;

/**
   *Description:自定义Application <br>
   * <br/>
   *Creator:jhliu <br>
   *Date:2017/1/18 0018 14:51
 */

public class MyApplication extends Application {
    private static final String TAG = "MyApplication";

    private RefWatcher refWatcher;

    @Override
    public void onCreate() {
        super.onCreate();

        //初始化url设置
        SdkContant.RequestUrl.initRequestURL(getApplicationContext());

        //Bugly追踪 崩溃日志
        CrashReport.initCrashReport(getApplicationContext(), AppConstant.KEY_BUGLY_APPID, true);

        //调试时使用（监听内存泄漏）
        refWatcher = LeakCanary.install(this);

        //发布时使用
      //  refWatcher = installLeakCanary();
    }

    /**
     * 获取内存泄漏观察对象
     * @param context 上下文
     * @return 观察对象
     */
    public static RefWatcher getRefWatcher(Context context) {
        MyApplication application = (MyApplication) context.getApplicationContext();
        return application.refWatcher;
    }

    /**
     * 观察对象隐藏
     * @return
     */
    protected RefWatcher installLeakCanary() {
        return RefWatcher.DISABLED;
    }


    @Override
    public void onTerminate() {
        LogUtil.d(TAG, "onTerminate()");
        super.onTerminate();
    }
}
