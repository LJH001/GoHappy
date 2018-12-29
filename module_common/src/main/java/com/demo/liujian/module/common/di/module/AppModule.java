package com.demo.liujian.module.common.di.module;

import com.demo.liujian.module.common.base.BaseApplication;
import javax.inject.Singleton;
import dagger.Module;
import dagger.Provides;

/**
 * Created by issuser on 2017/3/13 0013.
 */
@Module
public class AppModule {
    BaseApplication myApp;

    public AppModule(BaseApplication myApp){
        this.myApp = myApp;
    }

    @Provides
    @Singleton
    public BaseApplication getApplication(){
        return myApp;
    }
}
