
package com.demo.liujian.module.common.util;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.telephony.TelephonyManager;
import android.text.TextUtils;


import com.demo.liujian.module.common.base.BaseApplication;

import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.Enumeration;

/**
 * 网络工具
 * 
 * @version [1.0.0.0, 2012-7-16]
 */
public class NetworkUtil {

    /** wifi */
    public static final String NETWORK_TYPE_WIFI = "wifi";

    /** wap */
    public static final String NETWORK_TYPE_WAP = "wap";

    /** 2G */
    public static final String NETWORK_TYPE_2G = "2g";

    /** 3G */
    public static final String NETWORK_TYPE_3G = "3g";

    /** 4G */
    public static final String NETWORK_TYPE_4G = "4g";

    /**
     * Get the network info
     * 
     * @param context   上下文
     * @return  network info
     */
    public static NetworkInfo getNetworkInfo(Context context) {
        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        return cm == null ? null : cm.getActiveNetworkInfo();
    }

    /**
     * 检查是否有可用网络
     */
    public static boolean isNetworkConnected() {
        ConnectivityManager connectivityManager = (ConnectivityManager) BaseApplication.getInstance().getApplicationContext().getSystemService(Context.CONNECTIVITY_SERVICE);
        return connectivityManager.getActiveNetworkInfo() != null;
    }


    /**
     * 判断当前网络是否可用
     * 
     * @param ctx   上下文
     * @return true-可用，false-不可用
     */
    public static boolean isNetworkAvailable(Context ctx) {
        NetworkInfo info = NetworkUtil.getNetworkInfo(ctx);
        return (info != null && info.isConnected());
    }

    /**
     * 跳转到网络设置页面
     * 
     * @param ctx   上下文
     */
    public static void jumpToNetworkSettingPage(Context ctx) {
        if (android.os.Build.VERSION.SDK_INT > 10) {
            // 3.0以上打开设置界面，也可以直接用ACTION_WIRELESS_SETTINGS打开到wifi界面
            ctx.startActivity(new Intent(android.provider.Settings.ACTION_SETTINGS));
        } else {
            ctx.startActivity(new Intent(android.provider.Settings.ACTION_WIRELESS_SETTINGS));
        }
    }

    /**
     *  判断当前连接的是否为wifi
     * @param ctx   上下文
     * @return  true:是wifi,false:不是wifi
     */
    public static boolean isWiFi(Context ctx) {
        NetworkInfo info = NetworkUtil.getNetworkInfo(ctx);
        return (info != null && info.isConnected() && info.getType() == ConnectivityManager.TYPE_WIFI);
    }

    /**
     * Check if there is any connectivity to a mobile network
     * 
     * @param context   上下文
     * @return  true:是连接的手机,false:不是
     */
    public static boolean isConnectedMobile(Context context) {
        NetworkInfo info = NetworkUtil.getNetworkInfo(context);
        return (info != null && info.isConnected() && info.getType() == ConnectivityManager.TYPE_MOBILE);
    }

    /**
     * 获取设备ip地址
     * @return  设备ip
     */
    public static String getDeviceIp() {
        try {
            for (Enumeration<NetworkInterface> en = NetworkInterface.getNetworkInterfaces(); en.hasMoreElements();) {
                NetworkInterface intf = en.nextElement();
                for (Enumeration<InetAddress> enumIpAddr = intf.getInetAddresses(); enumIpAddr.hasMoreElements();) {
                    InetAddress inetAddress = enumIpAddr.nextElement();
                    if (!inetAddress.isLoopbackAddress() && inetAddress instanceof Inet4Address) {
                        // if (!inetAddress.isLoopbackAddress() && inetAddress instanceof Inet6Address) {
                        return inetAddress.getHostAddress();
                    }
                }
            }
        } catch (Exception e) {
            LogUtil.e(e, e.getMessage());
        }
        return null;
    }

    /**
     * 获取通过mobile连接方式时的连接类型名称。例如：{@link #NETWORK_TYPE_4G}
     * 
     * @param context   上下文
     * @return  类型名称
     * @author yansu
     */
    public static String getMobileNetworkTypeName(Context context) {
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);
        switch (telephonyManager.getNetworkType()) {
            case TelephonyManager.NETWORK_TYPE_1xRTT:
                return NETWORK_TYPE_2G; // ~ 50-100 kbps
            case TelephonyManager.NETWORK_TYPE_CDMA:
                return NETWORK_TYPE_2G; // ~ 14-64 kbps
            case TelephonyManager.NETWORK_TYPE_EDGE:
                return NETWORK_TYPE_2G; // ~ 50-100 kbps
            case TelephonyManager.NETWORK_TYPE_EVDO_0:
                return NETWORK_TYPE_3G; // ~ 400-1000 kbps
            case TelephonyManager.NETWORK_TYPE_EVDO_A:
                return NETWORK_TYPE_3G; // ~ 600-1400 kbps
            case TelephonyManager.NETWORK_TYPE_GPRS:
                return NETWORK_TYPE_2G; // ~ 100 kbps
            case TelephonyManager.NETWORK_TYPE_HSDPA:
                return NETWORK_TYPE_3G; // ~ 2-14 Mbps
            case TelephonyManager.NETWORK_TYPE_HSPA:
                return NETWORK_TYPE_3G; // ~ 700-1700 kbps
            case TelephonyManager.NETWORK_TYPE_HSUPA:
                return NETWORK_TYPE_3G; // ~ 1-23 Mbps
            case TelephonyManager.NETWORK_TYPE_UMTS:
                return NETWORK_TYPE_3G; // ~ 400-7000 kbps
            case TelephonyManager.NETWORK_TYPE_EHRPD:
                return NETWORK_TYPE_3G; // ~ 1-2 Mbps
            case TelephonyManager.NETWORK_TYPE_EVDO_B:
                return NETWORK_TYPE_3G; // ~ 5 Mbps
            case TelephonyManager.NETWORK_TYPE_HSPAP:
                return NETWORK_TYPE_4G; // ~ 10-20 Mbps
            case TelephonyManager.NETWORK_TYPE_IDEN:
                return NETWORK_TYPE_2G; // ~25 kbps
            case TelephonyManager.NETWORK_TYPE_LTE:
                return NETWORK_TYPE_4G; // ~ 10+ Mbps
            case TelephonyManager.NETWORK_TYPE_UNKNOWN:
                return NETWORK_TYPE_2G;
            default:
                return NETWORK_TYPE_2G;
        }
    }

    /**
     * 获取当前网络连接的类型名称
     * 
     * @param context   上下文
     * @return 返回网络类型名称，例如：{@link #NETWORK_TYPE_WIFI}。<br/>
     *         如果当前连接的类型不是wifi、mobile则返回系统定义的类型名称。
     * @author yansu
     */
    public static String getNetworkTypeName(Context context) {

        ConnectivityManager manager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = manager.getActiveNetworkInfo();
        String mNetWorkType = null;
        if (networkInfo != null && networkInfo.isConnected()) {
            int type = networkInfo.getType();
            if (type == ConnectivityManager.TYPE_WIFI) {
                mNetWorkType = NETWORK_TYPE_WIFI;
            } else if (type == ConnectivityManager.TYPE_MOBILE) {
                String proxyHost = android.net.Proxy.getDefaultHost();
                if (TextUtils.isEmpty(proxyHost)) {
                    mNetWorkType = getMobileNetworkTypeName(context);
                } else {
                    mNetWorkType = NETWORK_TYPE_WAP;
                }
            } else {
                // 当前连接的类型不是wifi、mobile时，返回系统给出的类别名称
                mNetWorkType = networkInfo.getTypeName();
            }
        }
        return mNetWorkType;
    }

    /**
     * Check if there is fast connectivity
     * 
     * @param context   上下文
     * @return  true: is fast connectivity, falss: no
     */
    public static boolean isConnectedFast(Context context) {
        NetworkInfo info = NetworkUtil.getNetworkInfo(context);
        return (info != null && info.isConnected() && NetworkUtil.isConnectionFast(info.getType(), info.getSubtype()));
    }

    private static boolean isConnectionFast(int type, int subType) {
        if (type == ConnectivityManager.TYPE_WIFI) {
            return true;
        } else if (type == ConnectivityManager.TYPE_MOBILE) {
            switch (subType) {
                case TelephonyManager.NETWORK_TYPE_1xRTT:
                    return false; // ~ 50-100 kbps
                case TelephonyManager.NETWORK_TYPE_CDMA:
                    return false; // ~ 14-64 kbps
                case TelephonyManager.NETWORK_TYPE_EDGE:
                    return false; // ~ 50-100 kbps
                case TelephonyManager.NETWORK_TYPE_EVDO_0:
                    return true; // ~ 400-1000 kbps
                case TelephonyManager.NETWORK_TYPE_EVDO_A:
                    return true; // ~ 600-1400 kbps
                case TelephonyManager.NETWORK_TYPE_GPRS:
                    return false; // ~ 100 kbps
                case TelephonyManager.NETWORK_TYPE_HSDPA:
                    return true; // ~ 2-14 Mbps
                case TelephonyManager.NETWORK_TYPE_HSPA:
                    return true; // ~ 700-1700 kbps
                case TelephonyManager.NETWORK_TYPE_HSUPA:
                    return true; // ~ 1-23 Mbps
                case TelephonyManager.NETWORK_TYPE_UMTS:
                    return true; // ~ 400-7000 kbps
                    /*
                     * Above API level 7, make sure to set android:targetSdkVersion to appropriate level to use these
                     */
                case TelephonyManager.NETWORK_TYPE_EHRPD: // API level 11
                    return true; // ~ 1-2 Mbps
                case TelephonyManager.NETWORK_TYPE_EVDO_B: // API level 9
                    return true; // ~ 5 Mbps
                case TelephonyManager.NETWORK_TYPE_HSPAP: // API level 13
                    return true; // ~ 10-20 Mbps
                case TelephonyManager.NETWORK_TYPE_IDEN: // API level 8
                    return false; // ~25 kbps
                case TelephonyManager.NETWORK_TYPE_LTE: // API level 11
                    return true; // ~ 10+ Mbps
                    // Unknown
                case TelephonyManager.NETWORK_TYPE_UNKNOWN:
                default:
                    return false;
            }
        } else {
            return false;
        }
    }

}
