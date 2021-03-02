package com.demo.liujian.module.common.net.retrofit;

/**
 * <p>Class: com.demo.liujian.module.common.net.retrofit.HttpThrow</p>
 * <p>Description: </p>
 * <pre>
 *
 * </pre>
 *
 * @author liujianhui
 * @date 2021/3/2/16:54
 */


public class HttpThrow extends Exception{
    public int errType;

    public String errMessage;

    public Throwable mThrowable;

    /**
     * 未知错误
     */
    public static final int UNKNOWN = 1000;
    /**
     * 解析错误
     */
    public static final int PARSE_ERROR = 1001;
    /**
     * 连接错误
     */
    public static final int CONNECT_ERROR = 1002;
    /**
     * DNS解析失败（无网络）
     */
    public static final int NO_NET_ERROR = 1003;
    /**
     * 连接超时错误
     */
    public static final int TIME_OUT_ERROR = 1004;
    /**
     * 网络（协议）错误
     */
    public static final int HTTP_ERROR = 1005;
    /**
     * 证书错误
     */
    public static final int SSL_ERROR = 1006;

    public HttpThrow(int errType,String errMessage, Throwable throwable){
        super(throwable);
        this.errType = errType;
        this.errMessage = errMessage;
        this.mThrowable = throwable;
    }
}
