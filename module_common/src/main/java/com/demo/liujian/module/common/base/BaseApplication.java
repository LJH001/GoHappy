package com.demo.liujian.module.common.base;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.support.multidex.MultiDex;
import android.support.v7.widget.ThemedSpinnerAdapter;

import com.demo.liujian.module.common.net.HttpHelper;
import com.demo.liujian.module.common.net.OkGoProcess;
import com.demo.liujian.module.common.service.InitializeService;
import com.demo.liujian.module.common.util.LogUtil;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.cache.CacheEntity;
import com.lzy.okgo.cache.CacheMode;
import com.lzy.okgo.https.HttpsUtils;
import com.lzy.okgo.interceptor.HttpLoggingInterceptor;

import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;

import javax.net.ssl.X509TrustManager;

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

    private OkGo mOkGo = null;

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
        initNetConfiguration();
    }

    /**
     * 初始化全局网络配置
     */
    private void initNetConfiguration(){
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor("OkGo");
        httpLoggingInterceptor.setColorLevel(Level.INFO);
        httpLoggingInterceptor.setPrintLevel(HttpLoggingInterceptor.Level.BODY);
        mBuilder = new OkHttpClient.Builder();
        mBuilder.addInterceptor(httpLoggingInterceptor);
        mBuilder.readTimeout(OkGo.DEFAULT_MILLISECONDS, TimeUnit.MILLISECONDS);
        mBuilder.writeTimeout(OkGo.DEFAULT_MILLISECONDS,TimeUnit.MILLISECONDS);
        mBuilder.connectTimeout(OkGo.DEFAULT_MILLISECONDS,TimeUnit.MILLISECONDS);
        HttpsUtils.SSLParams sslParams = HttpsUtils.getSslSocketFactory(new X509TrustManager() {
            @Override
            public void checkClientTrusted(X509Certificate[] chain, String authType) throws CertificateException {

            }

            @Override
            public void checkServerTrusted(X509Certificate[] chain, String authType) throws CertificateException {

            }

            @Override
            public X509Certificate[] getAcceptedIssuers() {
                return new X509Certificate[0];
            }
        });
        mBuilder.sslSocketFactory(sslParams.sSLSocketFactory,sslParams.trustManager);
        mBuilder.hostnameVerifier(HttpsUtils.UnSafeHostnameVerifier);
        mOkGo = OkGo.getInstance();
        mOkGo.init(this)
             .setOkHttpClient(mBuilder.build())
             .setCacheMode(CacheMode.DEFAULT)
             .setCacheTime(CacheEntity.CACHE_NEVER_EXPIRE)
             .setRetryCount(3);

       mHttpHelper =  HttpHelper.getInstance();
       mHttpHelper.init(OkGoProcess.getInstance());
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
