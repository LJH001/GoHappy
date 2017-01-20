package com.example.liujianhui.gohappy.entity;

/**
   *Description:分页对象 <br>
   * <br/>
   *Creator:jhliu <br>
   *Date:2016/10/13 0013 17:55
 */

public class PageBean extends Entity {
    /**条目列表*/
    public Song[]  songlist;

    /**颜色*/
    public Integer color;

    /**评论数*/
    public Integer comment_num;

    /**当前页所有歌曲数目*/
    public String cur_song_num;

    /**返回数据返回码*/
    public Integer ret_code;

    /**当前页*/
    public Integer currentPage;

    /**歌曲开始*/
    public Integer song_begin;


    /**当前页所有歌曲数*/
    public Integer total_song_num;

    /**所有歌曲数*/
    public Integer totalpage;

}
