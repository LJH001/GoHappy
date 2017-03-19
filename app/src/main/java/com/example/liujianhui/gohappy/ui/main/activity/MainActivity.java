package com.example.liujianhui.gohappy.ui.main.activity;

import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.example.liujianhui.gohappy.R;
import com.example.liujianhui.gohappy.base.BaseActivity;
import com.example.liujianhui.gohappy.contants.AppConstant;
import com.example.liujianhui.gohappy.presenter.MainPresenter;
import com.example.liujianhui.gohappy.presenter.contracts.MainContract;
import com.example.liujianhui.gohappy.ui.image.fragment.ImageFragment;
import com.example.liujianhui.gohappy.ui.music.fragment.MusicFragment;
import com.example.liujianhui.gohappy.ui.news.fragment.NewsFragment;
import com.example.liujianhui.gohappy.ui.video.fragment.VideoFragment;
import com.example.liujianhui.gohappy.util.SharepreferenceUtil;

import javax.inject.Inject;

import butterknife.InjectView;
import butterknife.OnClick;
import me.yokeyword.fragmentation.SupportFragment;

/**
 * description:主页<br/>
 * <br/>
 * author:liujianhui
 * creatorTime:2017/1/21  21:02
 */
public class MainActivity extends BaseActivity implements MainContract.MainView, View.OnClickListener {
    @InjectView(R.id.flayout_content)
    FrameLayout flayoutContent;

    @InjectView(R.id.tv_main_news)
    TextView tvMainNews;

    @InjectView(R.id.tv_main_musics)
    TextView tvMainMusics;

    @InjectView(R.id.tv_main_images)
    TextView tvMainImages;

    @InjectView(R.id.tv_main_movies)
    TextView tvMainMovies;

    @InjectView(R.id.main_content)
    CoordinatorLayout mainContent;

    @InjectView(R.id.toolbar)
    Toolbar mToolbar;

    @InjectView(R.id.navigation_view)
    NavigationView navigationView;

    @InjectView(R.id.drawer_layout)
    DrawerLayout drawerLayout;

    @InjectView(R.id.appbar)
    AppBarLayout appbar;

    //主页控制器对象
    private MainPresenter mMainPresenter;

    //新闻界面
    @Inject
    NewsFragment newsFragment;

    //音乐界面
//    @Inject
    MusicFragment musicFragment;

    //图片
//    @Inject
    ImageFragment imagesFragment;

    //电影
//    @Inject
    VideoFragment videoFragment;

    Fragment curShowFragment;

    FragmentManager fragmentManager;

    ActionBarDrawerToggle mDrawerToggle;

    private int showFragment = AppConstant.TAB_MAIN;

    private int hideFragment = AppConstant.TAB_MAIN;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (savedInstanceState == null) {
            useNightMode(false);
        } else {
            showFragment = SharepreferenceUtil.getCurrentItem();
            hideFragment = AppConstant.TAB_MAIN;
            showHideFragment(getTargetFragment(showFragment),getTargetFragment(hideFragment));
            hideFragment = showFragment;
        }
    }

    @Override
    protected void initInject() {
        getActivityComponent().inject(this);
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_main;
    }

    @Override
    protected void initEventAndData() {
        setToolBar(mToolbar, getString(R.string.str_tab_news));
        mDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, mToolbar, R.string.str_navigation_open, R.string.str_navigation_close);
        mDrawerToggle.syncState();
        drawerLayout.addDrawerListener(mDrawerToggle);
       loadMultipleRootFragment(R.id.flayout_content,1,newsFragment);
        navigationView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(MenuItem menuItem) {
                        switch (menuItem.getItemId()){
                            case R.id.navigation_item_skin_setting:
                                showFragment = AppConstant.TAB_SKIN_SETTING;
                                break;
                            case R.id.navigation_item_collect:
                                showFragment = AppConstant.TAB_COLLECTION;
                                break;
                            case R.id.navigation_item_version_update:
                                showFragment = AppConstant.TAB_VERSION_UPDATE;
                                break;
                            case R.id.navigation_item_pwd_manager:
                                showFragment = AppConstant.TAB_PASSWORD_MANAGER;
                                break;
                            case R.id.navigation_item_register:
                                showFragment = AppConstant.TAB_REGISTER;
                                break;
                            case R.id.navigation_item_login:
                                showFragment = AppConstant.TAB_LOGIN;
                                break;
                        }
                        showHideFragment(getTargetFragment(showFragment),getTargetFragment(hideFragment));
                        menuItem.setChecked(true);
                        hideFragment = showFragment;
                        mToolbar.setTitle(menuItem.getTitle());
                        SharepreferenceUtil.saveCurrentItem(showFragment);
                        drawerLayout.closeDrawers();
                        return true;
                    }
                });
    }

    /**
     * 获取目标Fragment
     *
     * @return fragment界面
     */
    private SupportFragment getTargetFragment(int id) {
        switch (id) {
            case AppConstant.TAB_MAIN:
                return newsFragment;
            case AppConstant.TAB_MUSIC:
                return musicFragment;
            case AppConstant.TAB_IMAGE:
                return imagesFragment;
            case AppConstant.TAB_VIDEO:
                return videoFragment;
            case AppConstant.TAB_SKIN_SETTING:
                break;
            case AppConstant.TAB_COLLECTION:
                break;
            case AppConstant.TAB_VERSION_UPDATE:
                break;
            case AppConstant.TAB_PASSWORD_MANAGER:
                break;
            case AppConstant.TAB_REGISTER:
                break;
            case AppConstant.TAB_LOGIN:
                break;
        }
        return null;
    }

    @OnClick({R.id.tv_main_news, R.id.tv_main_musics, R.id.tv_main_images, R.id.tv_main_movies})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tv_main_news:
                showFragment = AppConstant.TAB_MAIN;
                showHideFragment(getTargetFragment(showFragment),getTargetFragment(hideFragment));
                hideFragment = showFragment;
                mToolbar.setTitle(R.string.str_tab_news);
                SharepreferenceUtil.saveCurrentItem(showFragment);
                switchTabStatus(tvMainNews,null);
                break;
            case R.id.tv_main_musics:
                showFragment = AppConstant.TAB_MUSIC;
                showHideFragment(getTargetFragment(showFragment),getTargetFragment(hideFragment));
                hideFragment = showFragment;
                mToolbar.setTitle(R.string.str_tab_music);
                SharepreferenceUtil.saveCurrentItem(showFragment);
                switchTabStatus(tvMainMusics,null);
                break;
            case R.id.tv_main_images:
                showFragment = AppConstant.TAB_IMAGE;
                showHideFragment(getTargetFragment(showFragment),getTargetFragment(hideFragment));
                hideFragment = showFragment;
                mToolbar.setTitle(R.string.str_tab_images);
                SharepreferenceUtil.saveCurrentItem(showFragment);
                switchTabStatus(tvMainImages,null);
                break;
            case R.id.tv_main_movies:
                showFragment = AppConstant.TAB_VIDEO;
                showHideFragment(getTargetFragment(showFragment),getTargetFragment(hideFragment));
                hideFragment = showFragment;
                mToolbar.setTitle(R.string.str_tab_video);
                SharepreferenceUtil.saveCurrentItem(showFragment);
                switchTabStatus(tvMainMovies,null);
                break;
        }
    }

    /**
     * 改变tab的状态（颜色）
     */
    private void switchTabStatus(TextView selectedTv, Fragment mFragment) {
        tvMainNews.setSelected(false);
        tvMainMusics.setSelected(false);
        tvMainMovies.setSelected(false);
        tvMainImages.setSelected(false);
        tvMainNews.setTextColor(getResources().getColor(R.color.c_424242));
        tvMainMusics.setTextColor(getResources().getColor(R.color.c_424242));
        tvMainMovies.setTextColor(getResources().getColor(R.color.c_424242));
        tvMainImages.setTextColor(getResources().getColor(R.color.c_424242));

        selectedTv.setSelected(true);
        selectedTv.setTextColor(getResources().getColor(R.color.c_ef5f45));

      //  switchContent(mFragment);
    }

    /**
     * 跳转内容对应的Fragment
     *
     * @param to 被跳转的Fragment
     */
    private void switchContent(Fragment to) {
        if (null == curShowFragment) {
            fragmentManager.beginTransaction().add(R.id.flayout_content, to).commit();
            curShowFragment = to;
        } else {
            if (curShowFragment != to) {
                FragmentTransaction transaction = fragmentManager.beginTransaction();
                if (!to.isAdded()) {
                    transaction.hide(curShowFragment).add(R.id.flayout_content, to).commit();
                } else {
                    transaction.hide(curShowFragment).show(to).commit();
                }
                curShowFragment = to;
            }
        }
    }

    @Override
    public void showError(String msg) {

    }


    @Override
    public void showUpdateDialog(String versionContent) {

    }

    @Override
    public void startDownloadService() {

    }
}
