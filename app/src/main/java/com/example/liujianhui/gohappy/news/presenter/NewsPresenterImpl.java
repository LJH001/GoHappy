package com.example.liujianhui.gohappy.news.presenter;

import com.example.liujianhui.gohappy.news.view.NewsView;

/**
 *description:新闻控制器实现类<br/>
 * <br/>
 *author:liujianhui
 *creatorTime:2017/2/17  21:54
*/
public class NewsPresenterImpl implements NewsPresenter {
    private NewsView mNewsView;

    public NewsPresenterImpl(NewsView mNewsView){
        this.mNewsView = mNewsView;
    }
    @Override
    public void loadNews(int type) {

    }
}
