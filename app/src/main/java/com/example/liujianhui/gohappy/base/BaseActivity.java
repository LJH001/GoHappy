package com.example.liujianhui.gohappy.base;

import android.app.Activity;
import android.os.Bundle;

import com.example.liujianhui.gohappy.util.crashlog.CrashLogManager;

/**
   *Description:Activity基类 <br>
   * <br/>
   *Creator:jhliu <br>
   *Date:2017/1/18 0018 18:03
 */

public class BaseActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //崩溃处理
        CrashLogManager.getInstance().init(getApplicationContext());
    }
}
