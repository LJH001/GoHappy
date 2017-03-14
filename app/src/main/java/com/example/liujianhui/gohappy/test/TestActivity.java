package com.example.liujianhui.gohappy.test;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

import com.example.liujianhui.gohappy.util.LogUtil;
import com.example.liujianhui.gohappy.util.ToastUtil;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Query;

/**
 * Created by issuser on 2017/3/13 0013.
 */
public class TestActivity extends Activity {
    public static final String TAG = "TestActivity==";

    public static final String BASE_URL = "http://v.juhe.cn/";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        testRetrofit();
    }

    /**
     * 测试Retrofit
     *
     * url = http://v.juhe.cn/weather/index?format=1&cityname=深圳&key=801a2aa81d72560e28227d0cb82bc9cf
     * 中文需要 转码 ：java.net.URLEncoder.encode(address,"gb2312") 基本意思是把我发送的内容进行编码为gb2312
     */
    private void testRetrofit() {
        Call<Weather>  call = null;
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(getOkHttpClient())
                .build();
        ApiWeather mWeather = retrofit.create(ApiWeather.class);
        try {
            String cityName = URLEncoder.encode("深圳","UTF-8");
            call = mWeather.getMyWeather("%E6%B7%B1%E5%9C%B3","801a2aa81d72560e28227d0cb82bc9cf",1);
            call.enqueue(new  Callback<Weather>(){

                @Override
                public void onResponse(Call<Weather> call, Response<Weather> response) {
                    if(response == null){
                        LogUtil.d(TAG,"返回数据response为空。。。");
                        ToastUtil.shortToast(TestActivity.this,"返回数据response为空。。。");
                        return;
                    }else{
                        if(response.body() == null){
                            LogUtil.d(TAG,"返回数据response  body为空。。。");
                            ToastUtil.shortToast(TestActivity.this,"返回数据response  body为空。。。");
                            return;
                        }else{
                            if(response.body().getResult() == null){
                                LogUtil.d(TAG,"返回数据response body getResult为空。。。");
                                ToastUtil.shortToast(TestActivity.this,"返回数据response  body为空。。。");
                                return;
                            }
                            String strBody = response.body().getResult().toString();
                            LogUtil.d(TAG,"返回数据成功 ："+ strBody);
                            ToastUtil.shortToast(TestActivity.this,"返回数据成功 ："+ strBody);
                        }
                    }

                }

                @Override
                public void onFailure(Call<Weather> call, Throwable t) {
                    LogUtil.d(TAG,"返回数据失败："+t.getMessage());
                    ToastUtil.shortToast(TestActivity.this,"返回数据失败 ："+ t.getMessage());
                }
            } );
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

    }

    private OkHttpClient getOkHttpClient() {
        //日志显示级别
        HttpLoggingInterceptor.Level level= HttpLoggingInterceptor.Level.BODY;
        //新建log拦截器
        HttpLoggingInterceptor loggingInterceptor=new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() {
            @Override
            public void log(String message) {
                Log.d(TAG,"日志打印："+message);
            }
        });
        loggingInterceptor.setLevel(level);
        //定制OkHttp
        OkHttpClient.Builder httpClientBuilder = new OkHttpClient.Builder();
        //OkHttp进行添加拦截器loggingInterceptor
        httpClientBuilder.addInterceptor(loggingInterceptor);
        return httpClientBuilder.build();
    }

    interface ApiWeather{
        @GET("weather/index")
        Call<Weather> getMyWeather(@Query("cityname") String cityName, @Query("key") String apiKey, @Query("format")int format);
    }
}
