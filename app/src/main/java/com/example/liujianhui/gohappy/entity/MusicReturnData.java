package com.example.liujianhui.gohappy.entity;


import java.util.List;

/**
 * 音乐返回数据对象
 *
 * Created by jhliu on 2016/8/25 0025.
 */
public class MusicReturnData<T extends Entity> extends Entity {
    /**返回标识*/
    public String status;

    public static class Status{
        public static final String SUCCESS_MUSIC_STATUS = "200";
    }

    /** 错误信息*/
    public String error;

    /**请求歌曲数目*/
    public int count;

    /**歌曲集合*/
    public List<Music> data;
}
