package com.example.liujianhui.gohappy.entity;

/**
   *Description: 网络音乐实体类<br>
   * <br/>
   *Creator:jhliu <br>
   *Date:2016/10/13 0013 16:15
 */
public class Song extends Entity {
    /**专辑id*/
    public  String albumid;

    /**子专辑id*/
    public  String albummid;

    /**专辑大图片，高宽300*/
    public  String albumpic_big;

    /**专辑小图片，高宽90*/
    public  String albumpic_small;

    /**mp3下载链接*/
    public  String downUrl;

    /**歌手id*/
    public  String singerid;

    /**歌手名*/
    public  String singername;

    /**歌曲id*/
    public  String songid;

    /**歌曲名称*/
    public  String songname;

    /**歌曲播放总时间*/
    public Integer seconds;

    /**流媒体播放地址*/
    public String url;
}
