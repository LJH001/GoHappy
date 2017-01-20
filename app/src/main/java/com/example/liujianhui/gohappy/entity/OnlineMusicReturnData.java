package com.example.liujianhui.gohappy.entity;

/**
   *Description:网络音乐返回数据 <br>
   * <br/>
   *Creator:jhliu <br>
   *Date:2016/10/13 0013 16:40
 */
public class OnlineMusicReturnData<T extends Entity> extends Entity  {
    /**返回数据对象*/
    public  OnlineMusicReturnDataBody showapi_res_body;

    /**返回码*/
    public Integer showapi_res_code;

    /**返回错误码*/
    public Integer showapi_error;
}
