package com.example.liujianhui.gohappy.main.presenter;

import com.example.liujianhui.gohappy.R;
import com.example.liujianhui.gohappy.main.view.MainView;

/**
 *description: 主页控制器<br/>
 * <br/>
 *author:liujianhui
 *creatorTime:2017/1/21  21:10
*/
public class MainPresenterImpl implements MainPresenter{
    private static final String TAG = "MainPresenterImpl==";

    private MainView mMainView;

    public MainPresenterImpl(MainView mMainView){
        this.mMainView = mMainView;
    }
    @Override
    public void switchTab(int id) {
        switch (id){
            case R.id.tv_main_news:
                mMainView.switchNews();
                break;
            case R.id.tv_main_musics:
                mMainView.switchMusic();
                break;
            case R.id.tv_main_images:
                mMainView.switchImages();
                break;
            case R.id.tv_main_movies:
                mMainView.switchVideo();
                break;
        }
    }

    @Override
    public void switchNavigation(int id) {
        switch(id){
            case R.id.navigation_item_skin_setting:
                mMainView.switchSetSkin();
                break;
            case R.id.navigation_item_collect:
                mMainView.switchCollection();
                break;
            case R.id.navigation_item_version_update:
                mMainView.switchVersionUpdate();
                break;
            case R.id.navigation_item_pwd_manager:
                mMainView.switchPwdManager();
                break;
            case R.id.navigation_item_register:
                mMainView.switchRegister();
                break;
            case R.id.navigation_item_login:
                mMainView.switchLogin();
                break;
        }
    }
}
