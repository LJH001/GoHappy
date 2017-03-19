package com.example.liujianhui.gohappy.model.http.api;

import com.example.liujianhui.gohappy.model.entity.NewsReturnData;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;


/**
 *description:新闻api（"头条","娱乐", "社会","时尚","财经","科技","国内","国际"）<br/>
 * <br/>
 *author:liujianhui
 *creatorTime:2017/3/19  11:10
*/
public interface NewsApi {
    /**
     * 头条新闻
     *
     * @param apiKey 新闻key值
     * @param type 新闻类型
     */
    @GET("toutiao/index")
    Observable<NewsReturnData> getTopNews(@Query("key") String apiKey, @Query("type") String type);

}
