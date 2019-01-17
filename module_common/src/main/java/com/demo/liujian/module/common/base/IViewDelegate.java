package com.demo.liujian.module.common.base;


import android.support.annotation.Keep;
import android.view.View;

/**
  *descption:获取Fragment  和 View
  * <p>
  *packageName: com.demo.liujian.module.common.base
  * <p>
  *author:liujianhui
  *<p>
  *date:2019/1/15 10:36
*/
@Keep
public interface IViewDelegate {

    BaseFragment getFragment(String name);

    View getView(String name);

}
