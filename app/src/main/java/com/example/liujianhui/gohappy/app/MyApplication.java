package com.example.liujianhui.gohappy.app;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.support.multidex.MultiDex;
import android.support.v7.app.AppCompatDelegate;

import com.example.liujianhui.gohappy.component.InitializeService;
import com.example.liujianhui.gohappy.di.component.DaggerMyApplicationComponent;
import com.example.liujianhui.gohappy.di.component.MyApplicationComponent;
import com.example.liujianhui.gohappy.di.module.MyApplicationModule;
import com.example.liujianhui.gohappy.util.LogUtil;

import java.util.HashSet;
import java.util.Set;

/**
 * Description:自定义Application <br>
 * <br/>
 * Creator:jhliu <br>
 * Date:2017/1/18 0018 14:51
 */
public class MyApplication extends Application {
    private static final String TAG = "MyApplication";

    private static MyApplication mInstance;

    private Set<Activity> allActivities;

    public static MyApplicationComponent myApplicationComponent;

    public synchronized static MyApplication getInstance() {
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
        InitializeService.start(this);
    }

    /**
     * Activity进栈
     * @param mAty
     */
    public void addActivity(Activity mAty) {
        if(null == allActivities){
            allActivities = new HashSet<>();
        }
        allActivities.add(mAty);
    }

    /**
     * Activity出栈
     * @param mAty
     */
    public void removeActivity(Activity mAty) {
        if(null != allActivities){
            allActivities.remove(mAty);
        }
    }

    /**
     * 清空栈，退出App
     */
    public void exitApp() {
        if (allActivities != null) {
            synchronized (allActivities) {
                for (Activity act : allActivities) {
                    act.finish();
                }
            }
        }
        android.os.Process.killProcess(android.os.Process.myPid());
        System.exit(0);
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
        LogUtil.d(TAG, "onTerminate()");
        super.onTerminate();
    }

    public static MyApplicationComponent getAppComponent(){
        if (myApplicationComponent == null) {
            myApplicationComponent = DaggerMyApplicationComponent.builder()
                    .myApplicationModule(new MyApplicationModule(mInstance))
                    .build();
        }
        return myApplicationComponent;
    }
}
