package com.example.liujianhui.gohappy.di.module;

import com.example.liujianhui.gohappy.ui.news.fragment.NewsFragment;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by codeest on 2017/2/26.
 */

@Module
public class PageModule {

    @Singleton
    @Provides
    NewsFragment provideZhihuMain() {
        return new NewsFragment();
    }
}
