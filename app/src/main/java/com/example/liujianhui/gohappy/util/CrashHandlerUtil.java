
package com.example.liujianhui.gohappy.util;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Looper;
import android.widget.Toast;

import java.lang.Thread.UncaughtExceptionHandler;

/**
 * 捕获异常的Handler<br>
 * 提供默认的异常处理，保存异常到SharedPreferences中<br>
 * 同时1秒后重启应用
 */
public class CrashHandlerUtil implements UncaughtExceptionHandler {
    private static final String TAG = "CrashHandlerUtil";

    private static CrashHandlerUtil instance = new CrashHandlerUtil();

    private Context ctx;

    /** 重新启动某个组件（activity或service等）的 PendingIntent */
    static PendingIntent restartIntent = null;

    private CrashHandlerUtil() {
    }

    public static CrashHandlerUtil getInstance() {
        return instance;
    }

    /**
     * 初始化UncaughtExceptionHandler
     * 
     * @param ctx
     */
    public void init(Context ctx) {
        this.ctx = ctx;

        Thread.setDefaultUncaughtExceptionHandler(this);
    }

    @Override
    public void uncaughtException(Thread thread, Throwable e) {

        LogUtil.et(TAG, e, "程序崩溃了...");

//        handleException(e);

        new Thread() {
            @Override
            public void run() {
                Looper.prepare();
                Toast.makeText(ctx, "程序重新启动", Toast.LENGTH_SHORT).show();
                Looper.loop();
            }
        }.start();

        if (restartIntent == null) {

            // 可以更换为想去的界面
            Intent intent = ctx.getPackageManager().getLaunchIntentForPackage(ctx.getPackageName());
            restartIntent = PendingIntent.getActivity(ctx, 0, intent, Intent.FLAG_ACTIVITY_NEW_TASK);

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e1) {
            }

            AlarmManager mgr = (AlarmManager) ctx.getSystemService(Context.ALARM_SERVICE);
            mgr.set(AlarmManager.RTC, System.currentTimeMillis() + 1000, restartIntent); // 1秒钟后重启应用

            // 退出程序
            android.os.Process.killProcess(android.os.Process.myPid());
            System.exit(1);
        }

    }

  /**
     * 自定义错误处理,收集错误信息 发送错误报告等操作均在此完成. 开发者可以根据自己的情况来自定义异常处理逻辑
     * 
     * @param e 捕获的异常
     * @return true:如果处理了该异常信息;否则返回false
     */
 /*  private boolean handleException(Throwable e) {
        if (e == null) {
            return false;
        }

        // 处理crash异常数据
        CrashLog crashLog = new CrashLog();
        crashLog.when = System.currentTimeMillis();
        crashLog.content = e.getMessage() + "\r\n" + Log.getStackTraceString(e);
        crashLog.type = 1;

        CrashLogDao dao = new CrashLogDao();
        dao.insert(crashLog, ctx);

        return true;
    }*/
}
