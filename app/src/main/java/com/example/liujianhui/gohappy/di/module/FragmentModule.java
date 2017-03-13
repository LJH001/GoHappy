package com.example.liujianhui.gohappy.di.module;

import android.app.Activity;
import android.support.v4.app.Fragment;

import com.example.liujianhui.gohappy.di.scope.FragmentScope;

import dagger.Module;
import dagger.Provides;

import static android.R.attr.fragment;

/**
 * Created by issuser on 2017/3/13 0013.
 */
@Module
public class FragmentModule {
    private Fragment mFragment;

    public FragmentModule(Fragment mFragment){
        this.mFragment = mFragment;
    }

    @Provides
    @FragmentScope
    public Activity provideActivity() {
        return mFragment.getActivity();
    }
}
