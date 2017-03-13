package com.example.liujianhui.gohappy.di.component;


import android.app.Activity;

import com.example.liujianhui.gohappy.di.module.ActivityModule;
import com.example.liujianhui.gohappy.di.scope.ActivityScope;
import com.example.liujianhui.gohappy.ui.main.activity.MainActivity;

import dagger.Component;

/**
   *Description:activity组件 <br>
   * <br/>
   *Creator:jhliu <br>
   *Date:2017/3/13 0013 15:37
 */
@ActivityScope
@Component(dependencies = {MyApplicationComponent.class},modules = {ActivityModule.class})
public interface ActivityComponent {

    Activity getActivity();

    void inject(MainActivity mActivity);
}
