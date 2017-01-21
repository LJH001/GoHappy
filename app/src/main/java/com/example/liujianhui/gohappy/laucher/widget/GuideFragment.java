package com.example.liujianhui.gohappy.laucher.widget;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;


import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.example.liujianhui.gohappy.R;
import com.example.liujianhui.gohappy.util.ScreenInfoUtil;

import butterknife.ButterKnife;


/**
 * 引导页面Fragment
 * Created by liujianhui on 2016/8/3.
 */
public class GuideFragment extends Fragment {
    public static String TAG = GuideFragment.class.getSimpleName();

    public static String KEY = "index";
    /**引导页索引*/
    private int index;


    @Override
    public void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle bundle = getArguments();
        index = bundle.getInt(KEY);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View guideView = inflater.inflate(R.layout.fragment_guide, container, false);
        ImageView ivGuide1 = (ImageView) guideView.findViewById(R.id.iv_guide1);
        ImageView ivGuide2 = (ImageView) guideView.findViewById(R.id.iv_guide2);
        ImageView ivGuide3 = (ImageView) guideView.findViewById(R.id.iv_guide3);
        ScreenInfoUtil screenInfoUtil = new ScreenInfoUtil(getActivity());
        int screenWidth = screenInfoUtil.getWidth()+20;
        int screenHeight = screenInfoUtil.getHeight()+20;

        switch (index) {
            case 0:
                ivGuide1.setVisibility(View.VISIBLE);
                Glide.with(this).load(R.drawable.ic_guide_1).asGif().diskCacheStrategy(DiskCacheStrategy.SOURCE)
                        .override(screenWidth, screenHeight).centerCrop() .into(ivGuide1);
                ivGuide2.setVisibility(View.GONE);
                ivGuide3.setVisibility(View.GONE);
                break;
            case 1:
                ivGuide1.setVisibility(View.GONE);
                ivGuide2.setVisibility(View.VISIBLE);
                Glide.with(this).load(R.drawable.ic_guide_2).asGif().diskCacheStrategy(DiskCacheStrategy.SOURCE)
                        .override(screenWidth, screenHeight).centerCrop() .into(ivGuide2);
                ivGuide3.setVisibility(View.GONE);
                break;
            case 2:
                ivGuide1.setVisibility(View.GONE);
                ivGuide2.setVisibility(View.GONE);
                ivGuide3.setVisibility(View.VISIBLE);
                Glide.with(this).load(R.drawable.ic_guide_3).asGif().diskCacheStrategy(DiskCacheStrategy.SOURCE)
                        .override(screenWidth, screenHeight).centerCrop() .into(ivGuide3);
                break;
        }

        return guideView;
    }

    /**
     * 实例化GuideFragment
     *
     * @param index 页面索引
     */
    public static GuideFragment newInstance(int index) {
        Bundle args = new Bundle();
        args.putInt(KEY, index);

        GuideFragment fragment = new GuideFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.reset(this);
    }
}
