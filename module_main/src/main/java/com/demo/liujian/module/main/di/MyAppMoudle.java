package com.demo.liujian.module.main.di;

import dagger.Module;
import dagger.Provides;

@Module
public class MyAppMoudle {

    @Provides
    AB providerAA(){
        return new AB();
    }

}
