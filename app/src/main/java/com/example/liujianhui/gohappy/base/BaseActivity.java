package com.example.liujianhui.gohappy.base;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatDelegate;
import android.support.v7.widget.Toolbar;
import android.view.View;


import com.example.liujianhui.gohappy.app.MyApplication;
import com.example.liujianhui.gohappy.di.component.ActivityComponent;
import com.example.liujianhui.gohappy.di.component.DaggerActivityComponent;
import com.example.liujianhui.gohappy.di.module.ActivityModule;
import com.umeng.analytics.MobclickAgent;



import butterknife.ButterKnife;
import me.yokeyword.fragmentation.SupportActivity;

/**
   *Description:Activity基类 <br>
   * <br/>
   *Creator:jhliu <br>
   *Date:2017/1/18 0018 18:03
 */
public abstract class BaseActivity<T extends  BasePresenter> extends SupportActivity implements BaseView{
    //@Inject
    protected T mPresenter;

    /**
     * 上下文对象
     */
    protected Context mContext;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayout());
        ButterKnife.inject(this);
        mContext = this;
        initInject();
        if(null != mPresenter){
            mPresenter.attachView(this);
        }
        initEventAndData();

        MyApplication.getInstance().addActivity(this);

        //崩溃处理,发布时需要放开
       // CrashLogManager.getInstance().init(getApplicationContext());

        //日志加密
        MobclickAgent.enableEncrypt(true);//6.0.0版本及以后
    }

    @Override
    protected void onResume() {
        super.onResume();
        MobclickAgent.onResume(this);
    }

    @Override
    protected void onPause() {
        super.onPause();
        MobclickAgent.onPause(this);
    }

    @Override
    public void useNightMode(boolean isNight) {
        if (isNight) {
            AppCompatDelegate.setDefaultNightMode(
                    AppCompatDelegate.MODE_NIGHT_YES);
        } else {
            AppCompatDelegate.setDefaultNightMode(
                    AppCompatDelegate.MODE_NIGHT_NO);
        }
        recreate();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(null != mPresenter ){
            mPresenter.detachView();
        }
        ButterKnife.reset(this);
        MyApplication.getInstance().removeActivity(this);
    }

    /**
     * 设置工具栏
     * @param toolbar
     * @param title
     */
    protected void setToolBar(Toolbar toolbar, String title) {
        toolbar.setTitle(title);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressedSupport();
            }
        });
    }

    protected ActivityComponent getActivityComponent(){
        return  DaggerActivityComponent.builder()
                .myApplicationComponent(MyApplication.getAppComponent())
                .activityModule(getActivityModule())
                .build();
    }
    protected ActivityModule getActivityModule(){
        return new ActivityModule(this);
    }

    protected abstract void initInject();
    protected abstract int getLayout();
    protected abstract void initEventAndData();
}
