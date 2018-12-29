package com.demo.liujian.module.main.di;

import com.demo.liujian.module.common.di.component.AppComponent;
import com.demo.liujian.module.common.di.module.AppModule;
import com.demo.liujian.module.common.di.scope.ActivityScope;

import dagger.Component;

@ActivityScope
@Component(dependencies = {AppComponent.class},modules = {AppModule.class})
public interface MyAppComponent {

}
