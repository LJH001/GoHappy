package com.example.liujianhui.gohappy.main.widget;

import android.os.Bundle;

import com.example.liujianhui.gohappy.R;
import com.example.liujianhui.gohappy.base.BaseActivity;
import com.example.liujianhui.gohappy.main.view.MainView;

/**
 *description:主页<br/>
 * <br/>
 *author:liujianhui
 *creatorTime:2017/1/21  21:02
*/
public class MainActivity extends BaseActivity implements MainView{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void switchNews() {

    }

    @Override
    public void switchMusic() {

    }

    @Override
    public void switchImages() {

    }

    @Override
    public void switchVideo() {

    }

    @Override
    public void switchSetSkin() {

    }

    @Override
    public void switchCollection() {

    }

    @Override
    public void switchPwdManager() {

    }

    @Override
    public void switchRegister() {

    }

    @Override
    public void switchLogin() {

    }
}
