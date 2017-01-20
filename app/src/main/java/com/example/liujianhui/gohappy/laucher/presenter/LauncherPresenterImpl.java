package com.example.liujianhui.gohappy.laucher.presenter;

import com.example.liujianhui.gohappy.laucher.view.LauncherView;

/**
   *Description:启动控制器接口实现类 <br>
   * <br/>
   *Creator:jhliu <br>
   *Date:2017/1/20 0020 16:31
 */
public class LauncherPresenterImpl implements LauncherPresenter{
    private static final String TAG = "LauncherPresenterImpl==";

    private LauncherView mLauncherView;

    public LauncherPresenterImpl(LauncherView mLauncherView){
        this.mLauncherView = mLauncherView;
    }

    @Override
    public void loadLauncherView() {
        mLauncherView.showLaucher();
    }
}
