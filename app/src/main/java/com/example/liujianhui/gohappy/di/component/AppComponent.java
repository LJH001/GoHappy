package com.example.liujianhui.gohappy.di.component;

import com.example.liujianhui.gohappy.app.MyApplication;
import com.example.liujianhui.gohappy.di.module.AppModule;
import com.example.liujianhui.gohappy.ui.news.fragment.NewsFragment;

import javax.inject.Singleton;

import dagger.Component;

/**
   *Description:App Component <br>
   * <br/>
   *Creator:jhliu <br>
   *Date:2017/3/13 0013 17:32
 */
@Singleton
@Component(dependencies = {AppModule.class})
public interface AppComponent {

    MyApplication getAppContext();

    NewsFragment getNewsFragment();
}
