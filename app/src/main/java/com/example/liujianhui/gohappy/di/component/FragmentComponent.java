package com.example.liujianhui.gohappy.di.component;

import android.app.Activity;

import com.example.liujianhui.gohappy.di.module.FragmentModule;
import com.example.liujianhui.gohappy.di.scope.FragmentScope;
import com.example.liujianhui.gohappy.ui.news.fragment.NewsFragment;

import dagger.Component;

/**
   *Description:Fragment Component <br>
   * <br/>
   *Creator:jhliu <br>
   *Date:2017/3/13 0013 17:32
 */
@FragmentScope
@Component(dependencies = MyApplicationComponent.class, modules = FragmentModule.class)
public interface FragmentComponent {

    Activity getMyActivity();

    void inject(NewsFragment newsFragment);
}
