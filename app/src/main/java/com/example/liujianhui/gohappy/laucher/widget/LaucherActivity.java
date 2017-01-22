package com.example.liujianhui.gohappy.laucher.widget;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.liujianhui.gohappy.R;
import com.example.liujianhui.gohappy.contants.AppConstant;
import com.example.liujianhui.gohappy.main.widget.MainActivity;
import com.example.liujianhui.gohappy.util.JumpNextActivityUtil;
import com.example.liujianhui.gohappy.util.PackageInfoUtil;

import java.util.Timer;
import java.util.TimerTask;

import butterknife.ButterKnife;
import butterknife.InjectView;


/**
 * 启动页
 * Created by liujianhui on 2016/7/25.
 */
public class LaucherActivity extends Activity {
    @InjectView(R.id.tv_timer)
    TextView tvTimer;

    @InjectView(R.id.iv_launcher)
    ImageView ivLauncher;

    //是否第一次安装
    private boolean isFirstInstall;

    //定时器
    private Timer startTimer;

    //倒计时总时间
    private int timer = 3000;

    private static final int TIME_WHAT = 1000;

    private Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case TIME_WHAT:
                    tvTimer.setText(String.valueOf(timer / 1000));
                    timer = timer - 1000;

                    if (timer == 0) {
                        startTimer.cancel();
                        if (checkVersionCode()) {
                            JumpNextActivityUtil.jumpToNextActivity(LaucherActivity.this, GuideActivity.class);
                        } else {
                            JumpNextActivityUtil.jumpToNextActivity(LaucherActivity.this, MainActivity.class);
                        }
                    }
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launcher);
        ButterKnife.inject(this);
        startCountDown();
        startAnimation();
    }

    /**
     * 启动缩放动画
     */
    private void startAnimation() {
        final ScaleAnimation animation = new ScaleAnimation(0.1f, 1.0f, 0.1f, 1.0f,
                Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        animation.setDuration(3000);//设置动画持续时间
        animation.setRepeatCount(1);//设置重复次数
        animation.setFillAfter(true);//动画执行完后是否停留在执行完的状态
        animation.setStartOffset(0);//执行前的等待时间
        ivLauncher.setAnimation(animation);
    }

    /**
     * 开始倒计时
     */
    private void startCountDown() {
        if (startTimer == null) {
            startTimer = new Timer();
            TimerTask task = new TimerTask() {
                public void run() {
                    mHandler.sendEmptyMessage(TIME_WHAT);
                }
            };
            startTimer.schedule(task, TIME_WHAT, TIME_WHAT);
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
        isFirstInstall = !curVersionCode.equals(saveVersionCode) || curVersionCode.equals("") || curVersionCode == null;
        return isFirstInstall;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (null != startTimer) {
            startTimer = null;
        }
    }
}
