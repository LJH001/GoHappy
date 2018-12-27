package com.demo.liujian.module.common.di.component;

import com.demo.liujian.module.common.di.module.AppModule;
import com.demo.liujian.module.common.di.module.HttpModule;


import javax.inject.Singleton;

import dagger.Component;

/**
   *Description:App Component <br>
   * <br/>
   *Creator:jhliu <br>
   *Date:2017/3/13 0013 17:32
 */
@Singleton
@Component(modules = {AppModule.class, HttpModule.class})
public interface AppComponent {


}
