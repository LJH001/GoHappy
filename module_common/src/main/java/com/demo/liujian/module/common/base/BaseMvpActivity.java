package com.demo.liujian.module.common.base;

import android.support.v7.app.AppCompatDelegate;
import com.demo.liujian.module.common.di.module.ActivityModule;
import javax.inject.Inject;


/**
   *Description:Activity基类 <br>
   * <br/>
   *Creator:jhliu <br>
   *Date:2017/1/18 0018 18:03
 */
public abstract class BaseMvpActivity<T extends  BasePresenter> extends BaseActivity implements BaseView{
    @Inject
    protected T mPresenter;


    @Override
    protected void initView() {
        initInject();
        if(null != mPresenter){
            mPresenter.attachView(this);
        }
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
        if(null != mPresenter ){
            mPresenter.detachView();
            mPresenter = null;
        }
        super.onDestroy();
    }


/*    protected ActivityComponent getActivityComponent(){
        return  DaggerActivityComponent.builder()
                .myApplicationComponent(BaseApplication.getAppComponent())
                .activityModule(getActivityModule())
                .build();
    }*/
    protected ActivityModule getActivityModule(){
        return new ActivityModule(this);
    }

    protected abstract void initInject();

}
