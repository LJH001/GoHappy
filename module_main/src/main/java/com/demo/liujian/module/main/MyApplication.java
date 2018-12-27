package com.demo.liujian.module.main;

import android.app.Application;
import android.content.Context;
import android.support.multidex.MultiDex;
import android.support.v7.app.AppCompatDelegate;


public class MyApplication extends Application {
    private static final String TAG = "MyApplication";

    private static volatile MyApplication mInstance;


//    public static MyApplicationComponent myApplicationComponent;


    public  static MyApplication getInstance() {
        return mInstance;
    }

    /**
     * APP为白天模式
     */
    static {
        AppCompatDelegate.setDefaultNightMode(
                AppCompatDelegate.MODE_NIGHT_NO);
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mInstance = this;
    }


    /**
     * 当方法数超过65536个时，进行分包
     *
     * @param base 上下文对象
     */
    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(this);
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
    }

}
