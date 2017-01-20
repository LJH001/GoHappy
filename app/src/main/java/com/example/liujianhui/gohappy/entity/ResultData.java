package com.example.liujianhui.gohappy.entity;

import java.util.List;

/**
 * 返回结果对象
 * Created by jhliu on 2016/8/25 0025.
 */
public class ResultData extends Entity {
    /**返回状态*/
    public String stat;

    public static class StatConstant{
        /**成功状态标记*/
        public static final String TAG_SUCCESS  = "1";

        /**失败状态标记*/
        public static final String TAG_FAIL  = "0";
    }

    /**返回数据集合*/
    public List<News> data;
}
