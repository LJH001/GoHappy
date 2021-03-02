package com.example.liujianhui.gohappy;

import android.os.Build;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.widget.LinearLayout;

import com.demo.liujian.module.common.base.BaseActivity;
import com.demo.liujian.module.common.component.ColorShades;
import com.demo.liujian.module.common.contants.AppConstant;
import com.demo.liujian.module.common.util.JumpNextActivityUtil;
import com.demo.liujian.module.common.util.SharepreferenceUtil;
import com.demo.liujian.module.common.util.ZoomOutPageTransformer;
import com.demo.liujian.module.main.view.IndexActivity;
import com.readystatesoftware.systembartint.SystemBarTintManager;


/**
 * descption:引导页
 * <p>
 * packageName: com.demo.liujian.module.main.di
 * <p>
 * author:liujianhui
 * <p>
 * date:2019/1/7 17:01
 */
public class GuideActivity extends BaseActivity {
    private ViewPager vpGuide;
    private LinearLayout llayoutGuide;

    private int[] colorBg = new int[5];

    //颜色渐变
    private ColorShades shades;

    //系统状态栏管理
    private SystemBarTintManager mTintManager;

    private GuideAdapter introPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
//        ButterKnife.bind(this);
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_guide;
    }

    @Override
    protected void initView() {
        // 判断Android版本是否大于3.0
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
            vpGuide.setPageTransformer(true, new ZoomOutPageTransformer());
        }
        vpGuide = (ViewPager) findViewById(R.id.vp_guide);
        llayoutGuide = (LinearLayout) findViewById(R.id.llayout_guide);
        shades = new ColorShades();
        colorBg = getResources().getIntArray(R.array.splash_bg);
        vpGuide = (ViewPager) findViewById(R.id.vp_guide);
        introPager = new GuideAdapter(R.array.splash_icon, R.array.splash_desc, this);
        vpGuide.setAdapter(introPager);
        mTintManager = new SystemBarTintManager(this);
        // 激活状态栏设置
        mTintManager.setStatusBarTintEnabled(true);
        mTintManager.setNavigationBarTintEnabled(true);
        SharepreferenceUtil.putBoolean(this, AppConstant.KEY_SPF, false);
    }

    @Override
    protected void initEventAndData() {
        vpGuide.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                shades.setFromColor(colorBg[position % colorBg.length])
                        .setToColor(colorBg[(position + 1) % colorBg.length])
                        .setShade(positionOffset);
                llayoutGuide.setBackgroundColor(shades.generate());
                //   StatusBarUtil.setStatusBarColor(GuideActivity.this,R.color.red);
                applySelectedColor(shades.generate());
                introPager.setPosition(position);
            }

            @Override
            public void onPageSelected(int position) {
            }

            @Override
            public void onPageScrollStateChanged(int state) {
            }
        });

        introPager.setOnClickCallback(new GuideAdapter.OnClickCallback() {
            @Override
            public void onClick() {
                JumpNextActivityUtil.jumpToNextActivity(GuideActivity.this, IndexActivity.class);
            }
        });

    }

    /**
     * 设置状态栏颜色，在onPageScrolled里进行背景颜色一样的设置值。
     *
     * @param color 颜色值
     */
    private void applySelectedColor(int color) {
        mTintManager.setTintColor(color);
    }

}
