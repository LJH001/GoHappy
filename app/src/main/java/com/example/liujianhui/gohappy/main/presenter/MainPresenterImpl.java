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

        }

    }

    @Override
    public void switchNavigation(int id) {
        switch(id){

        }
    }
}
