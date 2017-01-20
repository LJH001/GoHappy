package com.example.liujianhui.gohappy.util;

import android.graphics.Bitmap;
import android.graphics.Matrix;

/**
 * bitmap工具类
 *
 * Created by liujianhui on 2016/10/7.
 */
public class BitmapUtil {
    /**
     * 将bitmap转换为  宽为x,高为y的图
     *
     * @param x 宽
     * @param y 高
     * @return bitmap对象
     */
    public static Bitmap big(Bitmap b,float x,float y)
    {
        int w=b.getWidth();
        int h=b.getHeight();
        float sx=(float)x/w;//要强制转换
        float sy=(float)y/h;
        Matrix matrix = new Matrix();
        matrix.postScale(sx, sy); // 长和宽放大缩小的比例
        Bitmap resizeBmp = Bitmap.createBitmap(b, 0, 0, w, h, matrix, true);

        return resizeBmp;
    }


}
