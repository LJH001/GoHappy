package com.example.liujianhui.gohappy.util;

import android.util.Log;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 *description:Retrofit的二次封装<br/>
 * <br/>
 *author:liujianhui
 *creatorTime:2017/3/15  22:15
*/

public class RetrofitUtil {
    private static final String TAG = "RetrofitUtil==";
    private static final String BASE_URL = "";

    public RetrofitUtil(){init();}

    public  void  init(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(getOkHttpClient())
                .build();

    }

    /**
     * 获取OkHttpClient对象
     *
     * @return OkHttpClient对象
     */
    private OkHttpClient getOkHttpClient() {
        //日志显示级别为最低级
        HttpLoggingInterceptor.Level level= HttpLoggingInterceptor.Level.BODY;
        //新建log拦截器
        HttpLoggingInterceptor loggingInterceptor=new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() {
            @Override
            public void log(String message) {
                Log.d(TAG,"网络请求日志打印："+message);
            }
        });
        loggingInterceptor.setLevel(level);
        //定制OkHttp
        OkHttpClient.Builder httpClientBuilder = new OkHttpClient.Builder();
        //OkHttp进行添加拦截器loggingInterceptor
        httpClientBuilder.addInterceptor(loggingInterceptor);

        return httpClientBuilder.build();
    }
}
