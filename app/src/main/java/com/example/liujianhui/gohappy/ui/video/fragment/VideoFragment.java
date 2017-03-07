package com.example.liujianhui.gohappy.ui.video.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.liujianhui.gohappy.R;
import com.example.liujianhui.gohappy.base.BaseFragment;

/**
   *Description:电影界面 <br>
   * <br/>
   *Creator:jhliu <br>
   *Date:2017/1/23 0023 16:18
 */

public class VideoFragment extends BaseFragment {
    private static final String TAG = VideoFragment.class.getSimpleName();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View  mNewsView = LayoutInflater.from(getContext()).inflate(R.layout.fragment_music,null);
            return mNewsView;
    }

}
