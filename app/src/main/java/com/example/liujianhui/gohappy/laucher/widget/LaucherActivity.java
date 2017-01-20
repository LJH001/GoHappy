package com.example.liujianhui.gohappy.laucher.widget;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;

import com.example.liujianhui.gohappy.R;
import com.example.liujianhui.gohappy.contants.AppConstant;
import com.example.liujianhui.gohappy.main.widget.MainActivity;
import com.example.liujianhui.gohappy.util.JumpNextActivityUtil;
import com.example.liujianhui.gohappy.util.PackageInfoUtil;


/**
 * 启动页
 * Created by liujianhui on 2016/7/25.
 */
public class LaucherActivity extends Activity{
    //是否第一次安装
    private boolean isFirstInstall;

    private Handler mHandler = new Handler();

    //延迟时间
    private static final int DELAY_TIME = 2000;

    private MyThread mThread;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launcher);
        if (checkVersionCode()) {
            mThread = new MyThread(GuideActivity.class);
            mHandler.postDelayed(mThread, DELAY_TIME);
        } else {
            mThread = new MyThread(MainActivity.class);
            mHandler.postDelayed(mThread,DELAY_TIME);
        }
    }

    /**
     * 检查版本号
     */
    public boolean checkVersionCode() {
        isFirstInstall = true;
        String curVersionCode = new PackageInfoUtil(LaucherActivity.this).getVersionCode();
        SharedPreferences versionCodeSp = getSharedPreferences(AppConstant.KEY_SPF, MODE_PRIVATE);
        String saveVersionCode = versionCodeSp.getString(AppConstant.KEY_VERSION_CODE, "");
        isFirstInstall=!curVersionCode.equals(saveVersionCode) || curVersionCode.equals("") || curVersionCode == null;
        return isFirstInstall ;
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        mHandler.removeCallbacks(mThread);
    }

    /**
     * 跳转页面
     */
    class MyThread implements Runnable{
        private Class<?> mClass;

        /**
         * 构造方法
         *
         * @param mClass 跳转到的页面
         */
        public MyThread(Class<?> mClass){
            this.mClass = mClass;
        }
        @Override
        public void run() {
            JumpNextActivityUtil.jumpToNextActivity(LaucherActivity.this, mClass);
        }
    }
}
