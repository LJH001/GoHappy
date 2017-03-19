package com.example.liujianhui.gohappy.base;


/**
   *Description:基础控制器 <br>
   * <br/>
   *Creator:jhliu <br>
   *Date:2017/3/7 0007 17:46
 */

public interface BasePresenter<T extends BaseView> {

    /**
     * 与某视图相关联
     * @param view
     */
    void  attachView(T view);

    /**
     * 取消关联
     */
    void detachView();
}
