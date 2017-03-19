package com.example.liujianhui.gohappy.ui.image.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.liujianhui.gohappy.R;
import com.example.liujianhui.gohappy.base.BaseFragment;

/**
   *Description:图片界面 <br>
   * <br/>
   *Creator:jhliu <br>
   *Date:2017/1/23 0023 16:18
 */

public class ImageFragment extends BaseFragment {
    private static final String TAG = ImageFragment.class.getSimpleName();


    @Override
    protected void initInject() {
        getFragmentComponent().inject(this);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_music;
    }

    @Override
    protected void initEventAndData() {

    }

    @Override
    public void showError(String msg) {

    }

    @Override
    public void useNightMode(boolean isNight) {

    }
}
