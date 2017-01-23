package com.example.liujianhui.gohappy.base;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.liujianhui.gohappy.util.crashlog.CrashLogManager;
import com.umeng.analytics.AnalyticsConfig;
import com.umeng.analytics.MobclickAgent;

/**
   *Description:Activity基类 <br>
   * <br/>
   *Creator:jhliu <br>
   *Date:2017/1/18 0018 18:03
 */

public class BaseActivity extends AppCompatActivity {
    /**
     * 左边按钮
     */
    protected Button leftBtn;

    /**
     * 返回按钮
     */
    protected Button backBtn;

    /**
     * 标题
     */
    protected TextView titleTv;

    /**
     * 右边按钮
     */
    protected Button rightBtn;

    /**
     * 标题
     */
    protected RelativeLayout titleRlayout;

    /**
     * 内容
     */
    protected LinearLayout contentLlayout;



    /**
     * 进度条描述
     */
    protected TextView progressTv;

    /**
     * 进度条布局
     */
    protected LinearLayout loadingLlayout;

    /**
     * 键盘控制器
     */
    private InputMethodManager imm;



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
