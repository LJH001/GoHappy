package com.demo.liujian.module.common.component;

import android.app.Service;
import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.util.AttributeSet;
import android.widget.VideoView;

import java.lang.reflect.Field;

/**
   *Description:自定义VideoView视图 <br>
   * <br/>
   *Creator:jhliu <br>
   *Date:2017/1/19 0019 22:55
 */
public class CustomVideoView extends VideoView {
    private int mWidth = 1;
    private int mHeight = 1;

    public CustomVideoView(Context context) {
        super(context);
    }

    public CustomVideoView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public CustomVideoView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public void setWidthHeight(int width,int height){
        mWidth = width;
        mHeight = height;
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int width = getDefaultSize(0, widthMeasureSpec);
        int height = getDefaultSize(0, heightMeasureSpec);
        setMeasuredDimension(width, height);
     /*   if(mWidth>0&&mHeight>0)
            setMeasuredDimension(mWidth,mHeight);
        else
            super.onMeasure(widthMeasureSpec,heightMeasureSpec);*/
    }

    /**
     * @param volume 音量大小
     * @param object VideoView实例
     * */
    public void setVolume(float volume,Object object) {
        try {
            Class<?> forName = Class.forName("android.widget.VideoView");
            Field field = forName.getDeclaredField("mMediaPlayer");
            field.setAccessible(true);
            MediaPlayer mMediaPlayer = (MediaPlayer) field.get(object);
            mMediaPlayer.setVolume(volume, volume);
        } catch (Exception e) {
        }
    }

    /**
     * 使用AudioManager控制音量
     * @param value
     * @param context
     *  https://github.com/lucid-lynxz/BlogSamples/blob/master/VideoViewDemo/app/src/main/java/org/lynxz/videoviewdemo/MainActivity.java
     */
    public void setVoiceVolume(float value,Context context) {
        try {
            AudioManager audioManager=
                    (AudioManager)context.getSystemService(Service.AUDIO_SERVICE);
            int currentVolume = audioManager.getStreamVolume(AudioManager.STREAM_MUSIC);
            int maxVolume = audioManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC);//(最大值是15)
            int flag = value > 0 ? -1 : 1;
            currentVolume += flag * 0.1 * maxVolume;
            // 对currentVolume进行限制
            audioManager.setStreamVolume(AudioManager.STREAM_MUSIC, currentVolume, 0);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
