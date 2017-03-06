package com.example.liujianhui.gohappy.main.widget;

import android.os.Bundle;
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
import com.example.liujianhui.gohappy.images.widget.ImageFragment;
import com.example.liujianhui.gohappy.main.presenter.MainPresenter;
import com.example.liujianhui.gohappy.main.presenter.MainPresenterImpl;
import com.example.liujianhui.gohappy.main.view.MainView;
import com.example.liujianhui.gohappy.music.widget.MusicFragment;
import com.example.liujianhui.gohappy.news.widget.NewsFragment;
import com.example.liujianhui.gohappy.video.widget.VideoFragment;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * description:主页<br/>
 * <br/>
 * author:liujianhui
 * creatorTime:2017/1/21  21:02
 */
public class MainActivity extends BaseActivity implements MainView,View.OnClickListener{
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

    //主页控制器对象
    private MainPresenter mMainPresenter;

    //新闻界面
    private Fragment newsFragment;

    //音乐界面
    private Fragment musicFragment;

    //图片
    private Fragment imagesFragment;

    //电影
    private Fragment videoFragment;

    private Fragment curShowFragment;

    private  FragmentManager fragmentManager;

    private ActionBarDrawerToggle mDrawerToggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.inject(this);
        setSupportActionBar(mToolbar);

        mDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, mToolbar, R.string.str_navigation_open,
                R.string.str_navigation_close);
        mDrawerToggle.syncState();
        drawerLayout.addDrawerListener(mDrawerToggle);


        setupDrawerContent(navigationView);
        bindEvent();

        fragmentManager = getSupportFragmentManager();
        mMainPresenter = new MainPresenterImpl(this);
        switchNews();  //默认新闻为首页
    }

    /**
     * 监听tab栏点击事件
     */
    private void bindEvent() {
        tvMainNews.setOnClickListener(this);
        tvMainMusics.setOnClickListener(this);
        tvMainImages.setOnClickListener(this);
        tvMainMovies.setOnClickListener(this);
    }

    /**
     * 设置导航栏监听
     * @param navigationView
     */
    private void setupDrawerContent(NavigationView navigationView) {
        navigationView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(MenuItem menuItem) {
                        mMainPresenter.switchNavigation(menuItem.getItemId());
                        menuItem.setChecked(true);
                        drawerLayout.closeDrawers();
                        return true;
                    }
                });
    }

    @Override
    public void switchNews() {
        mToolbar.setTitle(R.string.str_main_tab_index);
        if (null == newsFragment) {
            newsFragment = new NewsFragment();
        }
        switchTabStatus(tvMainNews,newsFragment);
    }

    @Override
    public void switchMusic() {
        mToolbar.setTitle(R.string.str_main_tab_music);
        if (null == musicFragment) {
            musicFragment = new MusicFragment();
        }
        switchTabStatus(tvMainMusics,musicFragment);
    }

    @Override
    public void switchImages() {
        mToolbar.setTitle(R.string.str_main_tab_images);
        if (null == imagesFragment) {
            imagesFragment = new ImageFragment();
        }
        switchTabStatus(tvMainImages,imagesFragment);
    }

    @Override
    public void switchVideo() {
        mToolbar.setTitle(R.string.str_main_tab_movies);
        if (null == videoFragment) {
            videoFragment = new VideoFragment();
        }
        switchTabStatus(tvMainMovies,videoFragment);
    }

    @Override
    public void switchSetSkin() {
        mToolbar.setTitle(R.string.str_me_skin_setting_title);
    }

    @Override
    public void switchCollection() {
        mToolbar.setTitle(R.string.str_me_collect_title);
    }

    @Override
    public void switchPwdManager() {
        mToolbar.setTitle(R.string.str_me_pwd_manager_title);
    }

    @Override
    public void switchVersionUpdate() {
        mToolbar.setTitle(R.string.str_me_version_update_title);
    }

    @Override
    public void switchRegister() {
        mToolbar.setTitle(R.string.str_me_register_title);
    }

    @Override
    public void switchLogin() {
        mToolbar.setTitle(R.string.str_me_login_title);
    }

    /**
     * 改变tab的状态（颜色）
     */
    private void switchTabStatus(TextView selectedTv, Fragment mFragment){
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

        switchContent(mFragment);
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
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.tv_main_news:
                mMainPresenter.switchTab(R.id.tv_main_news);
                break;
            case R.id.tv_main_musics:
                mMainPresenter.switchTab(R.id.tv_main_musics);
                break;
            case R.id.tv_main_images:
                mMainPresenter.switchTab(R.id.tv_main_images);
                break;
            case R.id.tv_main_movies:
                mMainPresenter.switchTab(R.id.tv_main_movies);
                break;
        }
    }
}
