package com.demo.liujian.module.common.net.retrofit;

import android.accounts.NetworkErrorException;

import org.json.JSONException;

import java.net.ConnectException;
import java.util.concurrent.TimeoutException;

import javax.net.ssl.SSLException;

import retrofit2.HttpException;

/**
 * <p>Class: com.demo.liujian.module.common.net.retrofit.ThrowHandler</p>
 * <p>Description: </p>
 * <pre>
 *
 * </pre>
 *
 * @author liujianhui
 * @date 2021/3/2/15:34
 */


public class ThrowHandler {

    public static HttpThrow handlerThrow(Throwable throwable){
       if (throwable instanceof HttpException){
           return new HttpThrow(HttpThrow.HTTP_ERROR, throwable.getMessage(),throwable);
       }else if(throwable instanceof JSONException){
           return new HttpThrow(HttpThrow.PARSE_ERROR,throwable.getMessage(),throwable);
       }else if(throwable instanceof ConnectException){
           return new HttpThrow(HttpThrow.CONNECT_ERROR,throwable.getMessage(),throwable);
       }else if(throwable instanceof NetworkErrorException){
           return new HttpThrow(HttpThrow.NO_NET_ERROR,throwable.getMessage(),throwable);
       }else if(throwable instanceof TimeoutException){
           return new HttpThrow(HttpThrow.TIME_OUT_ERROR,throwable.getMessage(),throwable);
       }else if(throwable instanceof SSLException){
           return new HttpThrow(HttpThrow.SSL_ERROR,throwable.getMessage(),throwable);
       }else{
           return  new HttpThrow(HttpThrow.UNKNOWN,throwable.getMessage(),throwable);
       }
    }
}
