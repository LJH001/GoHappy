package com.demo.liujian.module.common.base;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;



import me.yokeyword.fragmentation.SupportFragment;


/**
   *Description:Fragment 基类 <br>
   * <br/>
   *Creator:jhliu <br>
   *Date:2017/1/19 0019 15:05
 */

public abstract class BaseFragment<T extends BasePresenter> extends SupportFragment implements BaseView{

 //   @Inject
    protected T mPresenter;

    /**
     * 上下文对象
     */
    protected Context mContext;

    /**
     * 所关联的activity
     */
    protected Activity mActivity;

    /**
     * 是否初始化
     */
    boolean isInit = false;


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mContext = context;
        mActivity = (Activity) context;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View mView = inflater.inflate(getLayoutId(),null);
        initInject();
        return mView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
//        ButterKnife.bind(this,view);
        if(null != mPresenter){
            mPresenter.attachView(this);
        }
        if(null == savedInstanceState){
            if(!isHidden()){
                isInit = true;
                initEventAndData();
            }
        }else{
            if(!isSupportHidden()){
                isInit = true;
                initEventAndData();
            }
        }
    }

    @Override
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
        if(!isInit && !hidden){
            isInit = true;
            initEventAndData();
        }
    }

    @Override
    public void onResume() {
        super.onResume();
      //  MobclickAgent.onResume(getActivity());
    }

    @Override
    public void onPause() {
        super.onPause();
      //  MobclickAgent.onPause(getActivity());
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
//        ButterKnife.reset(this);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if(mPresenter != null){
            mPresenter.detachView();
        }

       /* RefWatcher refWatcher = MyApplication.getRefWatcher(getActivity());
        refWatcher.watch(this);*/
    }

/*    protected FragmentComponent getFragmentComponent(){
        return  DaggerFragmentComponent.builder()
                .myApplicationComponent(BaseApplication.getAppComponent())
                .fragmentModule(getFragmentModule())
                .build();
    }
    protected FragmentModule getFragmentModule(){
        return new FragmentModule(this);
    }*/


    protected abstract void initInject();
    protected abstract int getLayoutId();
    protected abstract void initEventAndData();
}
