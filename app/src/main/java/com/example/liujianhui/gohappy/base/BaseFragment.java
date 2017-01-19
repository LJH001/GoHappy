package com.example.liujianhui.gohappy.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;

import com.example.liujianhui.gohappy.app.MyApplication;
import com.squareup.leakcanary.RefWatcher;
import com.umeng.analytics.MobclickAgent;

/**
   *Description:Fragment 基类 <br>
   * <br/>
   *Creator:jhliu <br>
   *Date:2017/1/19 0019 15:05
 */

public abstract class BaseFragment extends Fragment {
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onResume() {
        super.onResume();
      //  MobclickAgent.onResume(getActivity());
    }

    @Override
    public void onPause() {
        super.onPause();
      //  MobclickAgent.onPause(getActivity());
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        RefWatcher refWatcher = MyApplication.getRefWatcher(getActivity());
        refWatcher.watch(this);
    }
}
