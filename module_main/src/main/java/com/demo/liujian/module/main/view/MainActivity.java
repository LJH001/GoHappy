package com.demo.liujian.module.main.view;

import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.View;

import com.demo.liujian.module.common.base.BaseActivity;
import com.demo.liujian.module.common.base.BaseFragment;
import com.demo.liujian.module.common.base.FragmentAdapter;
import com.demo.liujian.module.common.base.ViewManager;
import com.demo.liujian.module.common.component.NoScrollViewPager;
import com.demo.liujian.module.main.R;
import com.luseen.spacenavigation.SpaceItem;
import com.luseen.spacenavigation.SpaceNavigationView;
import com.luseen.spacenavigation.SpaceOnClickListener;

import java.util.ArrayList;
import java.util.List;

/**
 * descption:项目主页
 * <p>
 * packageName: com.demo.liujian.module.main
 * <p>
 * author:liujianhui
 * <p>
 * date:2018/12/27 15:20
 */
public class MainActivity extends BaseActivity {
    private static final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {

    }



    @Override
    protected void initEventAndData() {
    }
}
