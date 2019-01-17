package com.demo.liujian.module.common.base;

import android.support.annotation.Keep;

/**
  *descption:Application 代理类，管理组件声明周期
  * <p>
  *packageName: com.demo.liujian.module.common.base
  * <p>
  *author:liujianhui
  *<p>
  *date:2019/1/15 10:37
*/
@Keep
public interface IApplicationDelegate {

    void onCreate();

    void onTerminate();

    void onLowMemory();

    void onTrimMemory(int level);

}
