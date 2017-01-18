package com.example.liujianhui.gohappy.contants;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;

import com.example.liujianhui.gohappy.util.LogUtil;

/**
   *Description:url地址常量类 <br>
   * <br/>
   *Creator:jhliu <br>
   *Date:2017/1/18 0018 10:30
 */

public class SdkContant {
    private static final String TAG = "SdkContant";


    /**
     * 服务器地址，配置文件配置, 用于校验是否初始化请求路径使用
     **/
    private static boolean isInitUrl = false;

    public static class RequestUrl{
        /**
         * 登录密码
         */
        private static  String URL_ACCOUNT_LOGIN;

        /**
         * ilsApp 下AndroidManifest.xml 中接口服务器URL META_DATE KEY
         */
        public static final String META_DATE_DRIVER_SERVER_URL = "DRIVER_SERVER_ROOT_URL";


        /***
         * 初始化所有请求路径，根据用户配置修改 必须是ApplicationContext
         *
         * @param applicationContent 接口请求路径，配置文件中配置，用于打多个环境包配置。
         */
        public static void initRequestURL(Context applicationContent) {
            if (isInitUrl) {
                LogUtil.it(" 已经初始化 initRequestURL ，不需要重复初始化");
                return;
            }
            String ROOT_URL = "";

            try {
                // 获取metaData 配置的接口服务器路径
                ApplicationInfo appInfo = applicationContent.getPackageManager().getApplicationInfo(applicationContent.getPackageName(), PackageManager.GET_META_DATA);
                if (appInfo.metaData != null) {
                    ROOT_URL = appInfo.metaData.getString(META_DATE_DRIVER_SERVER_URL);
                }
            } catch (Exception e) {
                LogUtil.et("initRequestURL error:" + e.getMessage());
                isInitUrl = false;
                return;
            }
            if (TextUtils.isEmpty(ROOT_URL)) {
                LogUtil.et("初始化接口请求路径失败");
                isInitUrl = false;
                return;
            }
            isInitUrl = true;
            /* ============订单接口类型区=========================================================== */
            /**
             * 登录
             */
            URL_ACCOUNT_LOGIN = ROOT_URL + "logistics/mvc/outercall/api/applogin/login.json";
        }

    }
}
