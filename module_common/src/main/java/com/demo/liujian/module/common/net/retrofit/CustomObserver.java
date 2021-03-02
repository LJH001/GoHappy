package com.demo.liujian.module.common.net.retrofit;

import com.demo.liujian.module.common.util.LogUtil;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * <p>Class: com.demo.liujian.module.common.net.retrofit.CustomObserver</p>
 * <p>Description: </p>
 * <pre>
 *
 * </pre>
 *
 * @author liujianhui
 * @date 2021/3/2/15:36
 */


public abstract class CustomObserver<T> implements Observer<T> {
    private static final String TAG = CustomObserver.class.getSimpleName();

    @Override
    public void onSubscribe(Disposable disposable) {

    }

    @Override
    public void onNext(T o) {
        onResult(o);
    }

    @Override
    public void onError(Throwable throwable) {
        if (throwable instanceof Exception) {
            onError(ThrowHandler.handlerThrow(throwable));
        } else {

        }
    }

    @Override
    public void onComplete() {
        LogUtil.i(TAG, "onComplete ......");
    }

    public abstract void onError(HttpThrow httpThrowable);

    public abstract void onResult(T result);

}

