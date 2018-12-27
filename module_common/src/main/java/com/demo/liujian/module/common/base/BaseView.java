package com.demo.liujian.module.common.base;

/**
   *Description:基础view类 <br>
   * <br/>
   *Creator:jhliu <br>
   *Date:2017/3/7 0007 18:14
 */
public interface BaseView {
    /**
     * 显示错误信息
     * @param msg
     */
    void showError(String msg);

    /**
     * 使用夜间模式
     * @param isNight
     */
    void useNightMode(boolean isNight);
}
