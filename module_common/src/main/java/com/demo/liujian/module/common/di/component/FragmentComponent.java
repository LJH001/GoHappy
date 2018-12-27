package com.demo.liujian.module.common.di.component;

import android.app.Activity;
import android.support.v4.app.Fragment;


import com.demo.liujian.module.common.di.module.FragmentModule;
import com.demo.liujian.module.common.di.scope.FragmentScope;

import dagger.Component;

/**
   *Description:Fragment Component <br>
   * <br/>
   *Creator:jhliu <br>
   *Date:2017/3/13 0013 17:32
 */
@FragmentScope
@Component(dependencies = AppComponent.class, modules = FragmentModule.class)
public interface FragmentComponent {

    Activity getMyActivity();

    void inject(Fragment newsFragment);

}
