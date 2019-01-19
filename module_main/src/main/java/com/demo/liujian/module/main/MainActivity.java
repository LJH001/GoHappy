package com.demo.liujian.module.main;

import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.View;
import android.widget.Toast;

import com.demo.liujian.module.common.base.BaseActivity;
import com.demo.liujian.module.common.base.BaseFragment;
import com.demo.liujian.module.common.base.FragmentAdapter;
import com.demo.liujian.module.common.base.ViewManager;
import com.demo.liujian.module.common.component.NoScrollViewPager;
import com.luseen.spacenavigation.SpaceItem;
import com.luseen.spacenavigation.SpaceNavigationView;
import com.luseen.spacenavigation.SpaceOnClickListener;

import java.util.ArrayList;
import java.util.List;

import butterknife.InjectView;

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

    @InjectView(R.id.container_pager)
    NoScrollViewPager containerPager;

    @InjectView(R.id.space)
    SpaceNavigationView spaceNavigationView;

    @InjectView(R.id.main_content)
    CoordinatorLayout mainContent;

    @InjectView(R.id.navigation_view)
    NavigationView navigationView;

    @InjectView(R.id.drawerLayout)
    DrawerLayout drawerLayout;

    @InjectView(R.id.tool_bar)
    Toolbar toolBar;

    private FragmentAdapter pagerAdapter;
    private List<BaseFragment> mFragments;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        spaceNavigationView.initWithSaveInstanceState(savedInstanceState);
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {
        toolBar.setTitle("首页");
        toolBar.setTitleTextColor(getResources().getColor(R.color.white));
        toolBar.setNavigationIcon(R.mipmap.ic_header);
        setSupportActionBar(toolBar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(this,drawerLayout,
                toolBar,R.string.str_navigation_open,R.string.str_navigation_close);
        actionBarDrawerToggle.setDrawerIndicatorEnabled(true);
        actionBarDrawerToggle.syncState();
        drawerLayout.addDrawerListener(actionBarDrawerToggle);

        spaceNavigationView.addSpaceItem(new SpaceItem("新闻", R.drawable.bg_main_tab_home));
        spaceNavigationView.addSpaceItem(new SpaceItem("音乐", R.drawable.bg_main_tab_music));
        spaceNavigationView.addSpaceItem(new SpaceItem("视频", R.drawable.bg_main_tab_movies));
        spaceNavigationView.addSpaceItem(new SpaceItem("图片", R.drawable.bg_main_tab_images));

        containerPager.setPagerEnabled(true);
        mFragments = ViewManager.getInstance().getAllFragment();
        mFragments = new ArrayList<>();
        pagerAdapter = new FragmentAdapter(getSupportFragmentManager(), mFragments);
        containerPager.setAdapter(pagerAdapter);

      //  drawerLayout.openDrawer(Gravity.LEFT);//侧滑打开

    }

    /**
     * 显示侧滑
     */
    private void showDrawerLayout() {
        if (!drawerLayout.isDrawerOpen(Gravity.LEFT)) {
            drawerLayout.openDrawer(Gravity.LEFT);
        } else {
            drawerLayout.closeDrawer(Gravity.LEFT);
        }
    }

    @Override
    protected void initEventAndData() {
        toolBar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerLayout.openDrawer(Gravity.LEFT);
            }
        });
        spaceNavigationView.setSpaceOnClickListener(new SpaceOnClickListener() {
            @Override
            public void onCentreButtonClick() {
            }

            @Override
            public void onItemClick(int itemIndex, String itemName) {
            }

            @Override
            public void onItemReselected(int itemIndex, String itemName) {
            }
        });
    }
}
