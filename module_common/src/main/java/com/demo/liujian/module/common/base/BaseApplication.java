package com.demo.liujian.module.common.base;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.support.multidex.MultiDex;
import android.support.v7.app.AppCompatDelegate;


import com.demo.liujian.module.common.di.component.AppComponent;
import com.demo.liujian.module.common.di.module.AppModule;
import com.demo.liujian.module.common.di.module.HttpModule;
import com.demo.liujian.module.common.service.InitializeService;
import com.demo.liujian.module.common.util.LogUtil;

import java.util.HashSet;
import java.util.Set;


/**
 * Description:自定义Application <br>
 * <br/>
 * Creator:jhliu <br>
 * Date:2017/1/18 0018 14:51
 */
public abstract class  BaseApplication extends Application {
    private static final String TAG = "MyApplication";

    private static volatile BaseApplication mInstance;

    private Set<Activity> allActivities;


    public  static BaseApplication getInstance() {
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
        InitializeService.start(this);   //初始化应用
    }

    /**
     * 获取APP 组件
     * @return
     */
/*    public static AppComponent getAppComponent() {
        return  DaggerBaseAppComponent.builder()
                .appModule(new AppModule(this))
             //   .retrofitModule(new HttpModule(this))
                .build();
    }*/

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

}
