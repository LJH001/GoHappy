package com.example.liujianhui.gohappy.contants;

import com.example.liujianhui.gohappy.app.MyApplication;

import java.io.File;

/**
   *Description: 常量类<br>
   * <br/>
   *Creator:jhliu <br>
   *Date:2017/1/20 0020 14:44
 */

public class AppConstant {

    /**
     * Bugly申请的 AppId
     */
    public static final String KEY_BUGLY_APPID = "64d7453d29";

    /**
     * APP新闻头条key
     */
    public static final String KEY_NEWS_TOP = "dc22f2ee5be360ecd9618570bfd018b3";

    /**
     * QQ号码测吉凶
     */
    public static final String KEY_QQ_NUMBER = "5c1dad50e7f73c0674672ce244a51d1e";

    /**
     * 在线音乐秘钥  secret=  0c61eab383254476b3f796296c1cb3cc    appId = 25535
     */
    public static final String KEY_ONLINE_MUSIC_SECRET = "0c61eab383254476b3f796296c1cb3cc";

    /**
     * 在线音乐appID
     */
    public static final String KEY_ONLINE_MUSIC_APPID = "25535";


    //=============================SharePrefrence文本保存 Key值===========================================//

    /**
     * 保存版本号编辑器 key
     */
    public static final String KEY_SPF = "version_code_spf";

    /**
     * 版本号
     */
    public static final String KEY_VERSION_CODE = "version_code";

    //====================================Path===================================================//
    public static final String PATH_DATA = MyApplication.getInstance().getCacheDir().getAbsolutePath() + File.separator + "data";

}
