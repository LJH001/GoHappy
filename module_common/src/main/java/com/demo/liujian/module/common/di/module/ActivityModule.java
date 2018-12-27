package com.demo.liujian.module.common.di.module;

import android.app.Activity;


import com.demo.liujian.module.common.di.scope.ActivityScope;

import dagger.Module;
import dagger.Provides;

/**
 * Created by issuser on 2017/3/13 0013.
 */
@Module
public class ActivityModule {
    private Activity mActivity;

    public ActivityModule(Activity mActivity){
        this.mActivity = mActivity;
    }

    @Provides
    @ActivityScope
    public Activity getmActivity(){
        return mActivity;
    }
}
