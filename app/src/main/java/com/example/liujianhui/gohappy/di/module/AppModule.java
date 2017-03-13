package com.example.liujianhui.gohappy.di.module;

import com.example.liujianhui.gohappy.app.MyApplication;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by issuser on 2017/3/13 0013.
 */
@Module
public class AppModule {
    MyApplication myApp;

    public AppModule(MyApplication myApp){
        this.myApp = myApp;
    }

    @Provides
    @Singleton
    public MyApplication getApplication(){
        return myApp;
    }
}
