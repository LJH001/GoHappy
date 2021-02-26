package com.demo.liujian.module.common.net;


import java.util.Map;


/**
 * descption:网络代理类
 * <p>
 * packageName: com.demo.liujian.module.common.net
 * <p>
 * author:liujianhui
 * <p>
 * date:2019/1/21 14:13
 */
public interface IHttpProcess {
    void post(String url, Map<String, String> params, ICallback callback);

    void get(String url, Map<String, String> params,ICallback callback);

}
