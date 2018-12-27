package com.demo.liujian.module.common.util;

/**
 * 时间转换工具
 *
 * Created by liujianhui on 2016/9/19.
 */
public class TimeUtil {
    /**
     * 时间格式转换
     *
     * @param time(ms)
     * @return
     */
    public static String toTime(int time) {

        time /= 1000;
        int minute = time / 60;
        int hour = minute / 60;
        int second = time % 60;
        minute %= 60;
        return String.format("%02d:%02d", minute, second);
    }

}
