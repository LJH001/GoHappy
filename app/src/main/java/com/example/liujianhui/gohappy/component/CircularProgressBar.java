package com.example.liujianhui.gohappy.component;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ProgressBar;



/**
 * 自定义 五颜六色进度条
 * <p/>
 * Created by liujianhui on 2016/7/28.
 */
public class CircularProgressBar extends ProgressBar {

    public CircularProgressBar(Context context) {
        this(context, null);
    }

    public CircularProgressBar(Context context, AttributeSet attrs) {
        this(context, attrs, R.attr.cpbStyle);
    }

    public CircularProgressBar(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);

        if (isInEditMode()) {
            setIndeterminateDrawable(new CircularProgressDrawable.Builder(context, true).build());
            return;
        }

        Resources res = context.getResources();
        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.CircularProgressBar, defStyle, 0);

        final int color = a.getColor(R.styleable.CircularProgressBar_cpb_color, res.getColor(R.color.cpb_default_color));
        final float strokeWidth = a.getDimension(R.styleable.CircularProgressBar_cpb_stroke_width, 10f);
        final float sweepSpeed = a.getFloat(R.styleable.CircularProgressBar_cpb_sweep_speed, Float.parseFloat("1"));
        final float rotationSpeed = a.getFloat(R.styleable.CircularProgressBar_cpb_rotation_speed, Float.parseFloat("1"));
        final int colorsId = a.getResourceId(R.styleable.CircularProgressBar_cpb_colors, 0);
        final int minSweepAngle = a.getInteger(R.styleable.CircularProgressBar_cpb_min_sweep_angle, 20);
        final int maxSweepAngle = a.getInteger(R.styleable.CircularProgressBar_cpb_max_sweep_angle, 300);
        a.recycle();

        int[] colors = null;
        //colors
        if (colorsId != 0) {
            colors = res.getIntArray(colorsId);
        }

        Drawable indeterminateDrawable;
        CircularProgressDrawable.Builder builder = new CircularProgressDrawable.Builder(context)
                .sweepSpeed(sweepSpeed)    //扫描速度 = 单位时间转过的角度 / 时间
                .rotationSpeed(rotationSpeed)  //旋转速度
                .strokeWidth(strokeWidth)  //环的宽度
                .minSweepAngle(minSweepAngle) //最小扫描角度
                .maxSweepAngle(maxSweepAngle);  //最大扫描角度

        if (colors != null && colors.length > 0)
            builder.colors(colors);
        else
            builder.color(color);

        indeterminateDrawable = builder.build();
        setIndeterminateDrawable(indeterminateDrawable);
    }

    /**
     * 检查圆形进度条是否为空
     */
    private CircularProgressDrawable checkIndeterminateDrawable() {
        Drawable ret = getIndeterminateDrawable();
        if (ret == null || !(ret instanceof CircularProgressDrawable))
            throw new RuntimeException("The drawable is not a CircularProgressDrawable");
        return (CircularProgressDrawable) ret;
    }

    /**
     * 进度条转动停止
     */
    public void progressiveStop() {
        checkIndeterminateDrawable().progressiveStop();
    }

    /**
     * 进度条转动停止
     *
     * @param listener 进度条转动停止监听器
     */
    public void progressiveStop(CircularProgressDrawable.OnEndListener listener) {
        checkIndeterminateDrawable().progressiveStop(listener);
    }
}
