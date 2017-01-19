package com.example.liujianhui.gohappy.base;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

import com.example.liujianhui.gohappy.util.crashlog.CrashLogManager;
import com.umeng.analytics.AnalyticsConfig;
import com.umeng.analytics.MobclickAgent;

/**
   *Description:Activity基类 <br>
   * <br/>
   *Creator:jhliu <br>
   *Date:2017/1/18 0018 18:03
 */

public class BaseActivity extends FragmentActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //崩溃处理,发布时需要放开
       // CrashLogManager.getInstance().init(getApplicationContext());

        //日志加密
        MobclickAgent.enableEncrypt(true);//6.0.0版本及以后
    }

    @Override
    protected void onResume() {
        super.onResume();
        MobclickAgent.onResume(this);
    }

    @Override
    protected void onPause() {
        super.onPause();
        MobclickAgent.onPause(this);
    }
}
