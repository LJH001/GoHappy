package com.example.liujianhui.gohappy.presenter.contracts;

import com.example.liujianhui.gohappy.base.BasePresenter;
import com.example.liujianhui.gohappy.base.BaseView;
import com.tbruyelle.rxpermissions.RxPermissions;

/**
 * Description:主界面接口 <br>
 * <br/>
 * Creator:jhliu <br>
 * Date:2017/3/8 0008 15:15
 */
public interface MainContract {
    interface MainView {

        void showUpdateDialog(String versionContent);

        void startDownloadService();
    }

    interface Presenter extends BasePresenter<BaseView>{

        void checkVersion(String currentVersion);

        void checkPermissions(RxPermissions rxPermissions);
    }
}
