package com.demo.liujian.module.common.component;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.demo.liujian.module.common.R;
import com.demo.liujian.module.common.util.LogUtil;

/**
  *descption:欢迎页指示器
  * <p>
  *packageName: com.demo.liujian.demofirst
  * <p>
  *author:liujianhui
  *<p>
  *date:2019/1/16 18:30
*/
public class IndicatorView extends View {
    private  int mCount = 4;  //指示器圆点个数

    private Paint mPaint;  //画笔

    private float radius = 10f; //指示器半径

    private int position = 0;  //指示器颜色

    private int unSelectColor = R.color.colorAccent;  //未选择的颜色

    private int selectColor = R.color.colorPrimary;  //选择的颜色

    public IndicatorView(Context context) {
        super(context);
    }

    public IndicatorView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

        TypedArray typedArray = context.obtainStyledAttributes(attrs,R.styleable.mIndicator);
        unSelectColor = typedArray.getInteger(R.styleable.mIndicator_unSelectColor,unSelectColor);
        selectColor = typedArray.getInteger(R.styleable.mIndicator_selectColor,selectColor);
        radius = typedArray.getFloat(R.styleable.mIndicator_radius,radius);
        mCount = typedArray.getInteger(R.styleable.mIndicator_count,mCount);
        typedArray.recycle();
    }

    public IndicatorView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        mPaint = new Paint();
        for(int i = 0;i<mCount;i++){
            LogUtil.e("indicator","position ==  "+position+",,,, i == "+i);
            if(position == i){
                mPaint.setColor(getResources().getColor(selectColor));
            }else{
                mPaint.setColor(getResources().getColor(unSelectColor));
            }
            canvas.drawCircle(20+30*i,15,radius,mPaint);
        }
    }

    /**
     * 设置指示器位置
     */
    public void setPosition(int position){
        this.position = position;
    }

    /**
     * 设置圆的半径
     */
    public void setRadius(float radius){
        this.radius = radius;
    }

    /**
     * 设置绘制圆的个数
     */
    public void setCount(int mCount){
        this.mCount = mCount;
    }

    /**
     * 设置没有选择的颜色
     * @param unSelectColor
     */
    public void setPaintUnSelectColor(int unSelectColor){
        this.unSelectColor = unSelectColor;
    }

    /**
     * 设置已选择的颜色
     * @param selectColor
     */
    public void setPaintSelectColor(int selectColor){
        this.selectColor = selectColor;
    }
}
