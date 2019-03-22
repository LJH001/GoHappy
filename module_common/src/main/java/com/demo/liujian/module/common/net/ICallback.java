package com.demo.liujian.module.common.net;

/**
  *descption:网络接口回调
  * <p>
  *packageName: com.demo.liujian.module.common.net
  * <p>
  *author:liujianhui
  *<p>
  *date:2019/1/21 10:48
*/
public interface ICallback<T> {
    void onSuccess(T response);

    void onError(Throwable errorMsg);
}
