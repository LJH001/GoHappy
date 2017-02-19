package com.example.liujianhui.gohappy.news.view;

/**
 *description:新闻界面加载<br/>
 * <br/>
 *author:liujianhui
 *creatorTime:2017/2/17  21:52
*/

public interface NewsView  {
    /**
     * 添加新闻
     */
    void addNews(int newsType);

    /**
     * 显示加载进度条
     */
    void showProgress();

    /**
     * 隐藏加载进度条
     */
    void  hideProgress();
}
