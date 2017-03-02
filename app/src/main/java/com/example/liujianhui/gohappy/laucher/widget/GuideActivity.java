package com.example.liujianhui.gohappy.laucher.widget;

import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.liujianhui.gohappy.R;
import com.example.liujianhui.gohappy.contants.AppConstant;
import com.example.liujianhui.gohappy.main.widget.MainActivity;
import com.example.liujianhui.gohappy.util.JumpNextActivityUtil;
import com.example.liujianhui.gohappy.util.PackageInfoUtil;
import com.example.liujianhui.gohappy.util.ZoomOutPageTransformer;

import java.util.Arrays;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;


/**
 * 引导页
 * Created by liujianhui on 2016/7/30.
 */
public class GuideActivity extends FragmentActivity {
    /**滑动页面组件*/
    @InjectView(R.id.vp_guide)
    ViewPager mViewPager;

    /**立即体验按钮*/
    @InjectView(R.id.btn_experience)
    Button experienceBtn;

    /**引导页第一页的第一个点*/
    @InjectView(R.id.guide_dot1)
    ImageView mDotOne;

    /**引导页第一页的第二个点*/
    @InjectView(R.id.guide_dot2)
    ImageView mDotTwo;

    /**引导页第一页的第三个点*/
    @InjectView(R.id.guide_dot3)
    ImageView mDotThree;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guide);
        ButterKnife.inject(this);
        saveVersionCode();
        initData();
        bindEvent();
    }

    /**
     * 保存版本号
     */
    public void saveVersionCode() {
        SharedPreferences spf = getSharedPreferences(AppConstant.KEY_SPF, MODE_PRIVATE);
        SharedPreferences.Editor editor = spf.edit();
        editor.clear().commit(); //先清除旧版本号
        String curVersionCode = new PackageInfoUtil(GuideActivity.this).getVersionCode();
        editor.putString(AppConstant.KEY_VERSION_CODE, curVersionCode).commit();
    }

    /**
     * 初始化数据
     */
    private void initData() {
        GuideFragment guideFragment1 = GuideFragment.newInstance(0);
        GuideFragment guideFragment2 = GuideFragment.newInstance(1);
        GuideFragment guideFragment3 = GuideFragment.newInstance(2);

        List<? extends Fragment> mFragmentList = Arrays.asList(guideFragment1, guideFragment2, guideFragment3);
        GuideFragmentPagerAdapter mAdapter = new GuideFragmentPagerAdapter(getSupportFragmentManager(), mFragmentList);
        mViewPager.setAdapter(mAdapter);
        // 判断Android版本是否大于3.0
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
            mViewPager.setPageTransformer(true, new ZoomOutPageTransformer());
        }
        //设置小圆点
        mDotOne.setImageResource(R.drawable.common_dot_selected);
    }

    /**
     * 绑定事件
     */
    private void bindEvent() {
        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                mDotOne.setImageResource(R.drawable.common_dot_unselected);
                mDotTwo.setImageResource(R.drawable.common_dot_unselected);
                mDotThree.setImageResource(R.drawable.common_dot_unselected);
                switch (position) {
                    case 0:
                        mDotOne.setImageResource(R.drawable.common_dot_selected);
                        break;
                    case 1:
                        mDotTwo.setImageResource(R.drawable.common_dot_selected);
                        break;
                    case 2:
                        mDotThree.setImageResource(R.drawable.common_dot_selected);
                        break;
                }
                //设置当滑动到最后一页时，显示两个按钮
                if (position == 2) {
                    experienceBtn.setVisibility(View.VISIBLE);
                    experienceBtn.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            JumpNextActivityUtil.jumpToNextActivity(GuideActivity.this, MainActivity.class);
                        }
                    });
                } else {
                    experienceBtn.setVisibility(View.GONE);
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    /**
     * 引导页适配器
     */
    public static class GuideFragmentPagerAdapter extends FragmentPagerAdapter {

        private List<? extends Fragment> fragments;

        public GuideFragmentPagerAdapter(FragmentManager fm, List<? extends Fragment> fragments) {
            super(fm);
            this.fragments = fragments;
        }

        @Override
        public Fragment getItem(int position) {
            return fragments.get(position);
        }

        @Override
        public int getCount() {
            return fragments.size();
        }
    }

}
