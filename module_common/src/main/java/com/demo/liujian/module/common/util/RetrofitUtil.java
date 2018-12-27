package com.demo.liujian.module.common.util;

import android.util.Log;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;

import okhttp3.Cookie;
import okhttp3.CookieJar;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
   *Description:网络请求框架 <br>
   * <br/>
   *Creator:jhliu <br>
   *Date:2017/3/16 0016 13:48
 */

public class RetrofitUtil {
    private static final String TAG = RetrofitUtil.class.getSimpleName()+"==";

    //读取超时
    private static final int READ_TIMEOUT = 60;

    //连接超时
    private static final int CONNECTION_TIMEOUT = 30;


    /**
     * 网络请求初始化
     */
    public void init(String baseUrl){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .client(getOkHttpClient())
                .build();
    }

    /**
     * 获取OkHttpClient对象
     *
     * @return
     */
    private OkHttpClient getOkHttpClient() {
        //日志显示级别
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
        httpClientBuilder.addInterceptor(loggingInterceptor)
                         .connectTimeout(CONNECTION_TIMEOUT, TimeUnit.SECONDS)
                         .readTimeout(READ_TIMEOUT,TimeUnit.SECONDS)
                         .retryOnConnectionFailure(true)
                         .cookieJar(new CookieJar() {
                             private final HashMap<HttpUrl, List<Cookie>> cookieStore = new HashMap<>();

                             @Override
                             public void saveFromResponse(HttpUrl url, List<Cookie> cookies) {
                                 cookieStore.put(HttpUrl.parse(url.host()),cookies);
                             }

                             @Override
                             public List<Cookie> loadForRequest(HttpUrl url) {
                                 List<Cookie> cookie = cookieStore.get(HttpUrl.parse(url.host()));
                                 return cookie == null ? new ArrayList<Cookie>():cookie;
                             }
                         });
        return httpClientBuilder.build();
    }


}
