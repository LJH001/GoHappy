package com.example.liujianhui.gohappy.entity;


/**
 * 新闻返回数据对象
 *
 * Created by jhliu on 2016/8/25 0025.
 */
public class NewsReturnData<T extends Entity> extends Entity {
    /**返回标识*/
    public String reason;

    /** 封装返回数据对象，此处为返回的业务数据对象或者集合*/
    public ResultData result;

    /**错误码*/
    public int err_code;

}
