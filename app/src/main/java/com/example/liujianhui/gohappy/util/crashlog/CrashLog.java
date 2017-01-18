package com.example.liujianhui.gohappy.util.crashlog;

/**
   *Description:崩溃日志实体类 <br>
   * <br/>
   *Creator:jhliu <br>
   *Date:2017/1/18 0018 17:18
 */

public class CrashLog {
    /** 日志发生时间 */
    public Long when;

    /** 日志信息，具体内容 */
    public String content;

    /** 日志类型, 0: 一般日志、1: 错误日志 */
    public Integer type;
}
