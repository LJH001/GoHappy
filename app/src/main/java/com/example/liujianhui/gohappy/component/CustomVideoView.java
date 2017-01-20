package com.example.liujianhui.gohappy.component;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.VideoView;
/**
   *Description:自定义VideoView视图 <br>
   * <br/>
   *Creator:jhliu <br>
   *Date:2017/1/19 0019 22:55
 */
public class CustomVideoView extends VideoView {
    private int mWidth = 0;
    private int mHeight = 0;

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
        if(mWidth>0&&mHeight>0)
            setMeasuredDimension(mWidth,mHeight);
        else
            super.onMeasure(widthMeasureSpec,heightMeasureSpec);
    }
}
