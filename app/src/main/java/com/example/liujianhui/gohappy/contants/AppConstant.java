package com.example.liujianhui.gohappy.contants;

import android.os.Environment;

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


    //==============================服务器地址=====================================//

    /**
     * 新闻头条
     */
    public static final String URL_NEWS_TOP = "http://v.juhe.cn/toutiao/index";

    /**
     * QQ号码测吉凶
     */
    public static final String URL_QQ = "http://japi.juhe.cn/qqevaluate/qq";


    //=============================SharePrefrence文本保存 Key值===========================================//

    /**
     * 保存版本号编辑器 key
     */
    public static final String KEY_SPF = "version_code_spf";

    /**
     * 版本号
     */
    public static final String KEY_VERSION_CODE = "version_code";

    /**
     * 夜间模式
     */
    public static final String SP_NIGHT_MODE = "night_mode";

    //====================================Path===================================================//
    public static final String PATH_DATA = MyApplication.getInstance().getCacheDir().getAbsolutePath() + File.separator + "data";

    public static final String PATH_CACHE = PATH_DATA + "/NetCache";

    public static final String PATH_SDCARD = Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator + "gohappy" + File.separator + "GoHappy";

    //====================================tab、NavigationView中的item 的id值标记=====================================//
    public static final int TAB_MAIN = 1;

    public static final int TAB_MUSIC = 2;

    public static final int TAB_IMAGE = 3;

    public static final int TAB_VIDEO = 4;

    public static final int TAB_SKIN_SETTING = 5;

    public static final int TAB_COLLECTION = 6;

    public static final int TAB_VERSION_UPDATE = 7;

    public static final int TAB_PASSWORD_MANAGER = 8;

    public static final int TAB_REGISTER = 9;

    public static final int TAB_LOGIN = 10;

}
