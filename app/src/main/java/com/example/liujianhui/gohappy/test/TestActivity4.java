package com.example.liujianhui.gohappy.test;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

import com.example.liujianhui.gohappy.model.entity.NewsReturnData;
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
import retrofit2.http.Query;

/**
 * Created by issuser on 2017/3/13 0013.
 */
public class TestActivity4 extends Activity {
    public static final String TAG = "TestActivity==";

    public static final String BASE_URL = "http://v.juhe.cn/";

    Call<NewsReturnData>  call = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        testRetrofit();
    }

    /**
     * 测试Retrofit
     *
     * url = http://v.juhe.cn/toutiao/index?type=top&key=dc22f2ee5be360ecd9618570bfd018b3
     * 中文需要 转码 ：java.net.URLEncoder.encode(address,"gb2312") 基本意思是把我发送的内容进行编码为gb2312
     */
    private void testRetrofit() {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(getOkHttpClient())
                .build();

        ApiWeather mWeather = retrofit.create(ApiWeather.class);
        try {
            call = mWeather.getMyWeather("dc22f2ee5be360ecd9618570bfd018b3","top");

            call.enqueue(new  Callback<NewsReturnData>(){

                @Override
                public void onResponse(Call<NewsReturnData> call, Response<NewsReturnData> response) {
                    if(response == null){
                        LogUtil.d(TAG,"返回数据response为空。。。");
                        ToastUtil.shortToast(TestActivity4.this,"返回数据response为空。。。");
                        return;
                    }else{
                        if(response.body() == null){
                            LogUtil.d(TAG,"返回数据response  body为空。。。");
                            ToastUtil.shortToast(TestActivity4.this,"返回数据response  body为空。。。");
                            return;
                        }else{
                            if(response.body().result == null){
                                LogUtil.d(TAG,"返回数据response body getResult为空。。。");
                                ToastUtil.shortToast(TestActivity4.this,"返回数据response  body为空。。。");
                                return;
                            }
                            String strBody = response.body().result.data.get(0).title;
                            LogUtil.d(TAG,"返回数据成功 ："+ strBody);
                            ToastUtil.shortToast(TestActivity4.this,"返回数据成功 ："+ strBody);
                        }
                    }

                }

                @Override
                public void onFailure(Call<NewsReturnData> call, Throwable t) {
                    LogUtil.d(TAG,"返回数据失败："+t.getMessage());
                    ToastUtil.shortToast(TestActivity4.this,"返回数据失败 ："+ t.getMessage());
                }
            } );
        } catch (Exception e) {
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
        @GET("toutiao/index")
        Call<NewsReturnData> getMyWeather( @Query("key") String apiKey, @Query("type") String type);
    }
}
