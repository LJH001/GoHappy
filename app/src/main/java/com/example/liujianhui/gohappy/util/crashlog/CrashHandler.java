package com.example.liujianhui.gohappy.util.crashlog;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Looper;
import android.os.SystemClock;
import android.util.Log;
import android.widget.Toast;

import com.example.liujianhui.gohappy.util.LogUtil;
import com.umeng.analytics.MobclickAgent;


/**
   *Description:崩溃处理 <br>
   * <br/>
   *Creator:jhliu <br>
   *Date:2017/1/18 0018 15:55
 */

public class CrashHandler implements Thread.UncaughtExceptionHandler {
    private static final String TAG = "CrashHandler==";

    private Context ctx;
    private static CrashHandler crashHandler = new CrashHandler();
    private static PendingIntent pendingIntent = null;

    private CrashHandler(){

    }
    /**
       *Description:单例模式<br>
       *Return:崩溃处理实例 <br>
       *Creator:jhliu
      */
    public static CrashHandler getInstance(){
        return crashHandler;
    }

    /**
     * 崩溃处理初始化
     */
    public   void init(Context ctx){
        this.ctx = ctx;

        Thread.setDefaultUncaughtExceptionHandler(this);
    }

    @Override
    public void uncaughtException(Thread thread, Throwable ex) {
        LogUtil.e(TAG,"程序崩溃了...");

        handleException(ex);

        new Thread(new Runnable() {
            @Override
            public void run() {
                Looper.prepare();
                Toast.makeText(ctx,"程序开了个小差，即将重启...",Toast.LENGTH_SHORT).show();
                Looper.loop();
            }
        }).start();
        if(pendingIntent == null){
            Intent mIntent = ctx.getPackageManager().getLaunchIntentForPackage(ctx.getPackageName());
            pendingIntent = PendingIntent.getActivity(ctx,0, mIntent, Intent.FLAG_ACTIVITY_NEW_TASK);

            SystemClock.sleep(1000);

            AlarmManager am = (AlarmManager) ctx.getSystemService(Context.ALARM_SERVICE);
            am.set(AlarmManager.RTC,1000,pendingIntent);

            MobclickAgent.onKillProcess(ctx);
            android.os.Process.killProcess(android.os.Process.myPid());
            System.exit(1);
        }
    }

    /**
     * 处理异常,将错误日志记录到文件中
     */
    private boolean handleException(Throwable e) {
        // 处理crash异常数据
        CrashLog crashLog = new CrashLog();
        crashLog.when = System.currentTimeMillis();
        crashLog.content = e.getMessage() + "\r\n" + Log.getStackTraceString(e);
        crashLog.type = 1;

        CrashLogDao crashLogDao = new CrashLogDao();
        crashLogDao.insert(crashLog,ctx);
        return true;
    }
}
