package com.demo.liujian.module.common.base;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.umeng.analytics.MobclickAgent;
import butterknife.ButterKnife;
import me.yokeyword.fragmentation.SupportActivity;

import static com.demo.liujian.module.common.base.BaseApplication.mHttpHelper;

/**
   *Description:Activity基类 <br>
   * <br/>
   *Creator:jhliu <br>
   *Date:2017/1/18 0018 18:03
 */
public abstract class BaseActivity extends SupportActivity {

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

        initView();

        initEventAndData();

        BaseApplication.getInstance().addActivity(this);

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
    protected void onDestroy() {
        super.onDestroy();

        ButterKnife.reset(this);
        BaseApplication.getInstance().removeActivity(this);
    }

    protected abstract int getLayout();

    protected abstract void initView();

    protected abstract void initEventAndData();

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
}
