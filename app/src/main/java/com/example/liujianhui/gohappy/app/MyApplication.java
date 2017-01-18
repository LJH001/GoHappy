package com.example.liujianhui.gohappy.app;

import android.app.Application;
import android.widget.Toast;


import com.example.liujianhui.gohappy.contants.SdkContant;
import com.example.liujianhui.gohappy.util.LogUtil;
import com.example.liujianhui.gohappy.util.crashlog.CrashLogManager;
import com.tencent.bugly.crashreport.CrashReport;

/**
   *Description:自定义Application <br>
   * <br/>
   *Creator:jhliu <br>
   *Date:2017/1/18 0018 14:51
 */

public class MyApplication extends Application {
    private static final String TAG = "MyApplication";

    @Override
    public void onCreate() {
        super.onCreate();

        //初始化url设置
        SdkContant.RequestUrl.initRequestURL(getApplicationContext());

        //Bugly 追踪崩溃日志
        CrashReport.initCrashReport(getApplicationContext(), "64d7453d29", true);

        CrashReport.testJavaCrash();
    }

    @Override
    public void onTerminate() {
        LogUtil.d(TAG, "onTerminate()");
        super.onTerminate();
    }
}
