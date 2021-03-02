package com.demo.liujian.module.main.net;

import com.demo.liujian.module.common.net.retrofit.NetworkManager;
import com.demo.liujian.module.main.api.ObtainProgramApi;

import okhttp3.Request;

/**
 * <p>Class: com.demo.liujian.module.main.net.MainNetManager</p>
 * <p>Description: </p>
 * <pre>
 *
 * </pre>
 *
 * @author liujianhui
 * @date 2021/3/1/16:11
 */


public class MainNetManager {
    private ObtainProgramApi mObtainProgramApi;
    private volatile static MainNetManager mMainNetManager;

    public static MainNetManager getInstance(){
        if(mMainNetManager == null){
            synchronized (MainNetManager.class){
                if(mMainNetManager == null){
                    mMainNetManager = new MainNetManager();
                }
            }
        }
        return mMainNetManager;
    }

    public ObtainProgramApi getObtainProgramApi() {
        if (mObtainProgramApi == null) {
            synchronized (Request.class) {
                mObtainProgramApi = NetworkManager.getRetrofit().create(ObtainProgramApi.class);
            }
        }
        return mObtainProgramApi;
    }
}
