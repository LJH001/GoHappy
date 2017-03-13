package com.example.liujianhui.gohappy.base;

/**
   *Description:RxJava presenter基类 <br>
   * <br/>
   *Creator:jhliu <br>
   *Date:2017/3/8 0008 13:54
 */

public class RxPresenter<T extends BaseView> implements BasePresenter<T> {
    protected T mView;

    @Override
    public void attachView(T mView) {
        this.mView = mView;
    }

    @Override
    public void detachView() {
        mView = null;
    }
}
