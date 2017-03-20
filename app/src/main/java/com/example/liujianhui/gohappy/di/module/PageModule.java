package com.example.liujianhui.gohappy.di.module;

import com.example.liujianhui.gohappy.ui.image.fragment.ImageFragment;
import com.example.liujianhui.gohappy.ui.music.fragment.MusicFragment;
import com.example.liujianhui.gohappy.ui.news.fragment.NewsFragment;
import com.example.liujianhui.gohappy.ui.video.fragment.VideoFragment;

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
    NewsFragment provideNewsFragment() {
        return new NewsFragment();
    }

    @Singleton
    @Provides
    ImageFragment provideImageFragment() {
        return new ImageFragment();
    }

    @Singleton
    @Provides
    MusicFragment provideMusicFragment() {
        return new MusicFragment();
    }

    @Singleton
    @Provides
    VideoFragment provideVideoFragment() {
        return new VideoFragment();
    }
}
