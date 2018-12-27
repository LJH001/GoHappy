package com.demo.liujian.module.common.base;


/**
   *Description:mvp 基础控制器 <br>
   * <br/>
   *Creator:jhliu <br>
   *Date:2017/3/7 0007 17:46
 */

public class BaseMvpPresenter<T extends BaseView>  implements BasePresenter<T>{
     private T baseView;

    @Override
    public void attachView(T baseView) {
        this.baseView = baseView;
    }

    @Override
    public void detachView() {
        baseView = null;
    }


}
