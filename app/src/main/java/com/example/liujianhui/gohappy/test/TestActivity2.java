package com.example.liujianhui.gohappy.test;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Toast;

import com.example.liujianhui.gohappy.util.LogUtil;
import com.example.liujianhui.gohappy.util.ToastUtil;
import com.google.gson.Gson;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.Callback;

import okhttp3.Call;
import okhttp3.Response;


/**
 * Created by issuser on 2017/3/15 0015.
 */
public class TestActivity2 extends Activity {
    private String TAG = "TestActivity2==";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

       requestNewsDatas();
    }



    private void requestNewsDatas() {
        //  mNewsUrl = URLEncoder.encode(news_url.toString(), "UTF-8");
        new Thread() {
            @Override
            public void run() {
                super.run();
                String news_urls = "http://v.juhe.cn/weather/index?cityname=%E6%B7%B1%E5%9C%B3&dtype=json&format=1&key=801a2aa81d72560e28227d0cb82bc9cf";

                OkHttpUtils
                        .get()
                        .url(news_urls)
                        .id(101)
                        .build()
                        .execute(new NewsCallBack() {
                            @Override
                            public void onError(Call call, Exception e, int id) {
                                Toast.makeText(TestActivity2.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                            }

                            @Override
                            public void onResponse(Weather response, int id) {

                                if (response == null) {
                                    LogUtil.d(TAG, "response is null");
                                    ToastUtil.shortToast(TestActivity2.this,"response is null");
                                    return;
                                } else {
                                    if (response.getResultcode().equals("200")){
                                        if (response.getResult() == null) {
                                            LogUtil.d(TAG, "response result is null");
                                            return;
                                        }else{
                                            LogUtil.d(TAG, "当前城市是："+response.getResult().getToday().getCity());
                                            ToastUtil.shortToast(TestActivity2.this,"当前城市是："+response.getResult().getToday().getCity());
                                        }
                                    }else{
                                        LogUtil.d(TAG,"请求失败Resultcode != 200。。。");
                                    }

                                }
                            }
                        });
            }
        }.start();

    }

    class NewsCallBack extends Callback<Weather> {
        @Override
        public Weather parseNetworkResponse(Response response, int id) throws Exception {
            String res = response.body().string();
            LogUtil.d(TAG,res+">>>");
            Weather newsReturnData = new Gson().fromJson(res, Weather.class); //从String类型转为ReturnData类型
            return newsReturnData;
        }

        @Override
        public void onError(Call call, Exception e, int id) {
            LogUtil.d(TAG,e.getMessage());
        }

        @Override
        public void onResponse(Weather response, int id) {

        }
    }
}
