package com.example.liujianhui.gohappy.test;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

import com.example.liujianhui.gohappy.R;
import com.example.liujianhui.gohappy.base.BaseActivity;
import com.example.liujianhui.gohappy.model.entity.NewsReturnData;
import com.example.liujianhui.gohappy.util.LogUtil;
import com.example.liujianhui.gohappy.util.ToastUtil;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by issuser on 2017/3/13 0013.
 */
public class TestActivity3 extends BaseActivity {
    public static final String TAG = "TestActivity==";

    public static final String BASE_URL = "http://v.juhe.cn/";

    Observable<NewsReturnData>  call = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        testRetrofit();
    }

    /**
     * 测试Retrofit
     *
     * url = http://v.juhe.cn/toutiao/index?key=dc22f2ee5be360ecd9618570bfd018b3
     */
    private void testRetrofit() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())   //对于使用Rxjava必须要添加该项，
                .client(getOkHttpClient())
                .build();
        ApiWeather mWeather = retrofit.create(ApiWeather.class);
        try {
            call = mWeather.getMyWeather("dc22f2ee5be360ecd9618570bfd018b3","top");

            call.subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new Observer<NewsReturnData>() {
                        @Override
                        public void onCompleted() {
                            LogUtil.d(TAG,"返回数据成功。。。");
                        }

                        @Override
                        public void onError(Throwable e) {
                            LogUtil.d(TAG,"返回数据失败："+e.getMessage());
                            ToastUtil.shortToast(TestActivity3.this,"返回数据失败 ："+ e.getMessage());
                        }

                        @Override
                        public void onNext(NewsReturnData response) {
                            if(response == null){
                                LogUtil.d(TAG,"返回数据response为空。。。");
                                ToastUtil.shortToast(TestActivity3.this,"返回数据response为空。。。");
                                return;
                            }else{
                                if(response.result== null){
                                    LogUtil.d(TAG,"返回数据response body getResult为空。。。");
                                    ToastUtil.shortToast(TestActivity3.this,"返回数据response  body getResult为空。。。");
                                    return;
                                }
                                String strBody = response.result.data.get(0).title;
                                LogUtil.d(TAG,"返回数据成功 ："+ strBody);
                                ToastUtil.shortToast(TestActivity3.this,"返回数据成功 ："+ strBody);
                            }
                        }
                    });

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

    @Override
    public void showError(String msg) {

    }

    interface ApiWeather{
        @GET("toutiao/index")
        Observable<NewsReturnData> getMyWeather(@Query("key") String apiKey, @Query("type") String type);
    }



    @Override
    protected void initInject() {

    }

    @Override
    protected int getLayout() {
        return R.layout.activity_launcher;
    }

    @Override
    protected void initEventAndData() {

    }
}
