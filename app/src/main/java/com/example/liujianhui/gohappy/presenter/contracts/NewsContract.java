package com.example.liujianhui.gohappy.presenter.contracts;

import com.example.liujianhui.gohappy.base.BasePresenter;
import com.example.liujianhui.gohappy.base.BaseView;
import com.example.liujianhui.gohappy.model.entity.NewsReturnData;

import java.util.List;

/**
 * Created by liujianhui on 2017/3/19.
 */

public interface NewsContract {
    interface View extends BaseView {

        void showContent(List<NewsReturnData> newsListBean);

     //   void showMoreContent(List<GoldListBean> goldMoreListBean, int start, int end);
    }

    interface Presenter extends BasePresenter<View> {

        void getNewsData(String type);

  //    void getMoreGoldData();
    }
}
