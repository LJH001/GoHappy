package com.example.liujianhui.gohappy.ui.news.fragment;

import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.liujianhui.gohappy.R;
import com.example.liujianhui.gohappy.base.BaseFragment;

/**
   *Description:新闻界面 <br>
   * <br/>
   *Creator:jhliu <br>
   *Date:2017/1/23 0023 16:18
 */

public class NewsFragment extends BaseFragment {
    private static final String TAG = NewsFragment.class.getSimpleName();

    /**全部*/
    private static final int TAB_ALL = 0;

    /**娱乐*/
    private static final int TAB_YULE = 1;

    /**社会*/
    private static final int TAB_SHEHUI = 2;

    /**时尚*/
    private static final int TAB_SHISHANG = 3;

    /**财经*/
    private static final int TAB_CAIJING = 4;

    /**科技*/
    private static final int TAB_KEJI = 5;

    /**国内*/
    private static final int TAB_GUONEI = 6;

    /**国际*/
    private static final int TAB_GUOJI = 7;

    private static final String[] TITLE_TAB = {"头条","娱乐", "社会","时尚","财经",
            "科技","国内","国际",};

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View  mNewsView = LayoutInflater.from(getContext()).inflate(R.layout.fragment_news,null);
        return mNewsView;
    }


}
