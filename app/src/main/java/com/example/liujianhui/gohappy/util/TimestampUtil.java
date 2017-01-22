package com.example.liujianhui.gohappy.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/**
 * 时间戳操作
 * <p/>
 * Created by zhuwentao on 2016-06-14.
 */
public class TimestampUtil {

    /**
     * 日期格式：yyyy-MM-dd HH:mm:ss
     */
    public static String TIME_FORMAT_ONE = "yyyy-MM-dd HH:mm:ss";

    /**
     * 日期格式：yyyy-MM-dd HH:mm:ss
     */
    public static String TIME_FORMAT_ONE_S = "yyyy-MM-dd HH:mm";

    /**
     * 日期格式：yyyyMMddHHmmssSSS
     */
    public static String TIME_FORMAT_TWO = "yyyyMMddHHmmssSSS";

    /**
     * 日期格式：yyyyMMddHHmm
     */
    public static String TIME_FORMAT_THREE = "yyyyMMddHHmm";

    /**
     * 获得系统当前时间戳
     */
    public static String getNowTimestamp() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmssSSS", Locale.getDefault());
        Date date = new Date(System.currentTimeMillis());
        return simpleDateFormat.format(date);
    }

    /**
     * 获得系统当前时间戳(单位：毫秒)
     */
    public static long getNowTimestamp2() {
        Date date = new Date(System.currentTimeMillis());
        return date.getTime();
    }

    /**
     * 获得系统当时间戳
     * @param Timeformat 指定的格式
     * @return
     */
    public static String getNowTimestamp(String Timeformat) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(Timeformat, Locale.getDefault());
        Date date = new Date(System.currentTimeMillis());
        return simpleDateFormat.format(date);
    }

    /**
     * start
     * 今天开始时间戳
     */
    public static String getTodayStartTime() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd", Locale.getDefault());
        return simpleDateFormat.format(new Date()) + "000000000";
    }

    /**
     * end
     * 今天结束时间戳
     */
    public static String getTodayEndTime() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd", Locale.getDefault());
        return simpleDateFormat.format(new Date()) + "235959999";
    }

    /**
     * start
     * 本周开始时间戳-以星期一为本周的第一天
     */
    public static String getWeekStartTime() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd", Locale.getDefault());
        Calendar cal = Calendar.getInstance();
        int day_of_week = cal.get(Calendar.DAY_OF_WEEK) - 1;
        if (day_of_week == 0) {
            day_of_week = 7;
        }
        cal.add(Calendar.DATE, -day_of_week + 1);
        return simpleDateFormat.format(cal.getTime()) + "000000000";
    }

    /**
     * end
     * 本周结束时间戳-以星期一为本周的第一天
     */
    public static String getWeekEndTime() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd", Locale.getDefault());
        Calendar cal = Calendar.getInstance();
        int day_of_week = cal.get(Calendar.DAY_OF_WEEK) - 1;
        if (day_of_week == 0) {
            day_of_week = 7;
        }
        cal.add(Calendar.DATE, -day_of_week + 7);
        return simpleDateFormat.format(cal.getTime()) + "235959999";
    }

    /**
     * 把时间戳转变为指定格式的日期
     * @param timestamp 时间戳
     * @param timeFormat 转换的格式
     * @return 格式化日期
     */
    public static String ChangeTimestampToDate(String timestamp, String timeFormat) {
        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(TIME_FORMAT_TWO, Locale.getDefault());
            Date date = simpleDateFormat.parse(timestamp);
            SimpleDateFormat dateFormat = new SimpleDateFormat(timeFormat, Locale.getDefault());
            return dateFormat.format(date);
        } catch (Exception e) {
            LogUtil.e("changeTimestampToDate is error -> " + e.getMessage());
            e.printStackTrace();
        }
        return "";
    }

    /**
     * 把时间戳转变为指定格式的日期
     * @param timestamp 时间戳
     * @param timeFormat 转换的格式
     * @return 格式化日期
     */
    public static String ChangeTimestampToDateThree(String timestamp, String timeFormat) {
        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(TIME_FORMAT_THREE, Locale.getDefault());
            Date date = simpleDateFormat.parse(timestamp);
            SimpleDateFormat dateFormat = new SimpleDateFormat(timeFormat, Locale.getDefault());
            return dateFormat.format(date);
        } catch (Exception e) {
            LogUtil.e("changeTimestampToDate is error -> " + e.getMessage());
            e.printStackTrace();
        }
        return "";
    }

    /**
     * 把指定的日期格式转变为时间戳
     * @param timestamp 日期
     * @param timeFormat 日期格式
     * @return 格式化日期
     */
    public static String ChangeDateToTimestamp(String timestamp, String timeFormat, String changeFormat) {
        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(timeFormat, Locale.getDefault());
            Date date = simpleDateFormat.parse(timestamp);
            SimpleDateFormat dateFormat = new SimpleDateFormat(changeFormat, Locale.getDefault());
            return dateFormat.format(date);
        } catch (Exception e) {
            LogUtil.e("changeTimestampToDate is error -> " + e.getMessage());
            e.printStackTrace();
        }
        return "";
    }

    /**
     * 获取随机秒数
     * @return 00~59之间的数
     */
    public static String getRandomSecondTime() {
        String secondtime;
        int second = (int) (Math.random() * 60);
        if (second < 10) {
            secondtime = "0" + String.valueOf(second);
        } else {
            secondtime = String.valueOf(second);
        }
        return secondtime;
    }

    /**
     * start
     * 获取上一个月时间开始时间
     */
    public static Date getStartMonthTime() {
        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date());
        cal.set(Calendar.MONTH, cal.get(Calendar.MONTH) - 1); // 上一个月
        return cal.getTime();
    }

    /**
     * start
     * 获取当前月的一号开始时间
     */
    public static Date getStartMonthOneTime() {
        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date());
        cal.add(Calendar.MONTH, 0);
        cal.set(Calendar.DAY_OF_MONTH, 1);  // 设置为1号
        return cal.getTime();
    }
}
