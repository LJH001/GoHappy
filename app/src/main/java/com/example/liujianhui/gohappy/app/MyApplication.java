package com.example.liujianhui.gohappy.app;

import android.app.Application;

import com.example.liujianhui.gohappy.component.InitializeService;
import com.example.liujianhui.gohappy.util.LogUtil;

/**
   *Description:自定义Application <br>
   * <br/>
   *Creator:jhliu <br>
   *Date:2017/1/18 0018 14:51
 */

public class MyApplication extends Application {
    private static final String TAG = "MyApplication";

    private static MyApplication mInstance;

    public synchronized static  MyApplication getInstance(){
        return mInstance;
    }
    @Override
    public void onCreate() {
        super.onCreate();
        mInstance = this;
        InitializeService.start(this);
    }


    @Override
    public void onTerminate() {
        LogUtil.d(TAG, "onTerminate()");
        super.onTerminate();
    }
}
