package com.example.liujianhui.gohappy.component;

import android.app.IntentService;
import android.content.Context;
import android.content.Intent;

import com.example.liujianhui.gohappy.app.MyApplication;
import com.example.liujianhui.gohappy.contants.AppConstant;
import com.example.liujianhui.gohappy.contants.SdkContant;
import com.example.liujianhui.gohappy.util.LogUtil;
import com.example.liujianhui.gohappy.widget.AppBlockCanaryContext;
import com.github.moduth.blockcanary.BlockCanary;
import com.squareup.leakcanary.LeakCanary;
import com.squareup.leakcanary.RefWatcher;
import com.tencent.bugly.crashreport.CrashReport;

/**
   *Description:初始化app服务 <br>
   * <br/>
   *Creator:jhliu <br>
   *Date:2017/3/2 0002 17:12
 */

public class InitializeService extends IntentService {
    private static final String TAG = InitializeService.class.getSimpleName()+">>>";

    private static final String ACTION_INIT = "initApplication";

    private RefWatcher refWatcher;

    /**
     * Creates an IntentService.  Invoked by your subclass's constructor.
     *
     * @param name Used to name the worker thread, important only for debugging.
     */
    public InitializeService() {
        super("InitializeService");
    }

    public static  void  start(Context mContext){
        Intent mIntent = new Intent(mContext,InitializeService.class);
        mIntent.setAction(ACTION_INIT);
        mContext.startService(mIntent);
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        if(null == intent){
            LogUtil.e(TAG,"onHandleIntent params is null!");
           return;
        }
        if(ACTION_INIT.equals(intent.getAction())){
            initApplication();
        }
    }

    /**
     * 初始化应用
     */
    private void initApplication() {
        //初始化url设置
        SdkContant.RequestUrl.initRequestURL(getApplicationContext());

        //Bugly追踪 崩溃日志
        CrashReport.initCrashReport(getApplicationContext(), AppConstant.KEY_BUGLY_APPID, true);

        //调试时使用（监听内存泄漏）
        refWatcher = LeakCanary.install(MyApplication.getInstance());

        //发布时使用
        //  refWatcher = installLeakCanary();

        //初始化过度绘制检测
        BlockCanary.install(getApplicationContext(), new AppBlockCanaryContext()).start();
    }
    /**
     * 获取内存泄漏观察对象
     * @param context 上下文
     * @return 观察对象
     */
    public static RefWatcher getRefWatcher(Context context) {
       InitializeService appService = new InitializeService();
        return appService.refWatcher;
    }

    /**
     * 观察对象隐藏
     * @return
     */
    protected RefWatcher installLeakCanary() {
        return RefWatcher.DISABLED;
    }
}
