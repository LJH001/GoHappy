package com.demo.liujian.module.common.util.crashlog;


import android.content.Context;

/**
   *Description:崩溃日志管理类 <br>
   * <br/>
   *Creator:jhliu <br>
   *Date:2017/1/18 0018 15:51
 */

public class CrashLogManager {

    /** 默认的最大存储条数 */
    public static final int MAX_CRASHLOG_SIZE = 5;

    private int crashLogSize = MAX_CRASHLOG_SIZE;

  //  private CrashLogDao dao = new CrashLogDao();

    private CrashLogManager() {
    }

    private static class CrashLogManagerHolder {
        private static CrashLogManager instance = new CrashLogManager();
    }

    /**
     * 获取单例实体
     *
     * @return 单例实体
     */
    public static CrashLogManager getInstance() {
        return CrashLogManagerHolder.instance;
    }

    /**
     * 初始化抓取崩溃日志的handler
     *
     * @param ctx 上下文对象
     */
    public void init(Context ctx) {
        // 初始化crash handler
        CrashHandler.getInstance().init(ctx);
    }

    /**
     * 设置存储崩溃日志的最大数量（默认为5条崩溃日志）
     *
     * @param num 如果小于等于0，则不做更改
     */
    public void setMaxCrashLogSize(int num) {
        if (crashLogSize > 0) {
            crashLogSize = num;
        }
    }

    /**
     * 获取存储崩溃日志的最大数量
     *
     * @return 返回日志最大存储数量
     */
    public int getMaxCrashLogSize() {
        return crashLogSize;
    }

}

