package com.demo.liujian.module.main;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

import com.demo.liujian.module.common.base.BaseActivity;
import com.demo.liujian.module.common.component.CustomVideoView;
import com.demo.liujian.module.common.contants.AppConstant;
import com.demo.liujian.module.common.util.JumpNextActivityUtil;
import com.demo.liujian.module.common.util.ScreenInfoUtil;
import com.demo.liujian.module.common.util.SharepreferenceUtil;

import butterknife.InjectView;

/**
 * descption:启动界面
 * <p>
 * packageName: com.demo.liujian.module.main
 * <p>
 * author:liujianhui
 * <p>
 * date:2018/12/29 15:36
 */
public class SplashActivity extends BaseActivity {
    @InjectView(R.id.vv_splash)
    CustomVideoView vvSplash;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_splash;
    }

    @Override
    protected void initView() {
        JumpNextActivityUtil.jumpToNextActivity(SplashActivity.this,MainActivity.class);

        //playVideo();
    }

    private void playVideo() {
        vvSplash.setWidthHeight(ScreenInfoUtil.getWidth(),ScreenInfoUtil.getHeight());
        vvSplash.setVoiceVolume(0f,SplashActivity.this);
        final String uri = "android.resource://" + getPackageName() + "/" + R.raw.launch_video1;
        vvSplash.setVideoURI(Uri.parse(uri));
        vvSplash.start();
    }

    @Override
    protected void initEventAndData() {
        vvSplash.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                mp.start();
                mp.setLooping(false);
                vvSplash.setVoiceVolume(0f,SplashActivity.this);
            }
        });

        vvSplash.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                if(isFirstInstall()){
                    JumpNextActivityUtil.jumpToNextActivity(SplashActivity.this,GuideActivity.class);
                }else{
                    JumpNextActivityUtil.jumpToNextActivity(SplashActivity.this,MainActivity.class);
                }
            }
        });
    }

    /**
     * 是否是第一次安装
     * @return
     */
    public boolean isFirstInstall(){
        boolean isFirst = SharepreferenceUtil.getBoolean(this, AppConstant.KEY_SPF,true);
        return isFirst;
    }
}
