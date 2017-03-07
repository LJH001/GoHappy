package com.example.liujianhui.gohappy.model.entity;

/**
 * 新闻头条实体类
 * Created by issuser on 2016/8/25 0025.
 */
public class News extends Entity {
    /**标题*/
    public String title;

    /**新闻发布时间*/
    public String date;

    /**新闻类型*/
    public String category;

    /**图片地址1*/
    public String thumbnail_pic_s;

    /**文字链接地址*/
    public String url;

    /**图片地址3*/
    public String thumbnail_pic_s03;

    /**图片地址2*/
    public String thumbnail_pic_s02;

    /**唯一的key*/
    public String uniquekey;

    /**具体的类型*/
    public String realtype;

    /**新闻类型*/
    public String type;

    /***作者*/
    public String  author_name;

}
