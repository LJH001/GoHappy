package com.example.liujianhui.gohappy.base;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatDelegate;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.liujianhui.gohappy.app.MyApplication;
import com.umeng.analytics.MobclickAgent;

import javax.inject.Inject;

import butterknife.ButterKnife;
import me.yokeyword.fragmentation.SupportActivity;

/**
   *Description:Activity基类 <br>
   * <br/>
   *Creator:jhliu <br>
   *Date:2017/1/18 0018 18:03
 */
public abstract class BaseActivity<T extends  BasePresenter> extends SupportActivity implements BaseView{
    @Inject
    T mPresenter;
    /**
     * 上下文对象
     */
    protected Context mContext;

    /**
     * 左边按钮
     */
    protected Button leftBtn;

    /**
     * 返回按钮
     */
    protected Button backBtn;

    /**
     * 标题
     */
    protected TextView titleTv;

    /**
     * 右边按钮
     */
    protected Button rightBtn;

    /**
     * 标题
     */
    protected RelativeLayout titleRlayout;

    /**
     * 内容
     */
    protected LinearLayout contentLlayout;



    /**
     * 进度条描述
     */
    protected TextView progressTv;

    /**
     * 进度条布局
     */
    protected LinearLayout loadingLlayout;

    /**
     * 键盘控制器
     */
    private InputMethodManager imm;


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

    protected abstract void initInject();
    protected abstract int getLayout();
    protected abstract void initEventAndData();
}
