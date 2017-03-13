package com.example.liujianhui.gohappy.model.entity;

/**
 * 音乐实体类
 *
 * Created by liujianhui on 2016/9/16.
 */
public class Music extends Entity {
    /**文件id*/
    public  String  fid;

    /**秘钥*/
    public String kid;

    /**文件名*/
    public String filename;

    /**歌手名*/
    public String singername;

    /**头部图片*/
    public String headpic;

    /**歌曲名*/
    public String album_name;

    /**哈希码*/
    public String  hash;

    /**歌曲文字数目*/
    public String ownercount;

    /**歌曲url*/
    public  String url;

    /**歌曲播放总时间*/
    public String time;

    public String title;  //标题

    public String singer; //歌手名

    public String album;  //唱片

    public String size; //歌曲内存大小

    public String name; //歌名

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public String getSinger() {
        return singer;
    }

    public void setSinger(String singer) {
        this.singer = singer;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }


}
