package com.demo.liujian.module.common.di.component;


import android.app.Activity;


import com.demo.liujian.module.common.di.module.ActivityModule;
import com.demo.liujian.module.common.di.scope.ActivityScope;

import dagger.Component;

/**
   *Description:activity组件 <br>
   * <br/>
   *Creator:jhliu <br>
   *Date:2017/3/13 0013 15:37
 */
@ActivityScope
@Component(dependencies = {AppComponent.class},modules = {ActivityModule.class})
public interface ActivityComponent {

    Activity getActivity();

    void inject(Activity mActivity);
}
