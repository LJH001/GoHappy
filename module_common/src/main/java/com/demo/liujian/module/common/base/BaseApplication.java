package com.demo.liujian.module.common.base;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.support.multidex.MultiDex;

import com.demo.liujian.module.common.net.HttpHelper;
import com.demo.liujian.module.common.service.InitializeService;
import com.demo.liujian.module.common.util.LogUtil;
import com.demo.liujian.module.common.net.retrofit.NetworkManager;

import java.util.HashSet;
import java.util.Set;
import okhttp3.OkHttpClient;


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


    private OkHttpClient.Builder mBuilder = null;


    public static HttpHelper mHttpHelper = null;
    /**
     * APP为白天模式
     */
   /* static {
        AppCompatDelegate.setDefaultNightMode(
                AppCompatDelegate.MODE_NIGHT_NO);
    }*/

    @Override
    public void onCreate() {
        super.onCreate();
        mInstance = this;
        InitializeService.start(this);   //初始化应用
        NetworkManager.getInstance().init();  //初始化网络
//        CrashLogManager.getInstance().init(this);  //程序崩溃重启
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
