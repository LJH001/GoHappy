package com.demo.liujian.module.common.net;

import com.demo.liujian.module.common.util.LogUtil;

import java.util.Map;

/**
  *descption:网络请求类
  * <p>
  *packageName: com.demo.liujian.module.common.net
  * <p>
  *author:liujianhui
  *<p>
  *date:2019/1/21 14:36
*/
public class HttpHelper implements IHttpProcess{
    private static final String TAG = HttpHelper.class.getSimpleName();
    private IHttpProcess iHttpProcess = null;
    private static volatile HttpHelper mHttpHelper = null;

    private HttpHelper(){
    }

    /**
     * 调用网络请求前必须进行初始化
     * @param iHttpProcess
     */
    public void init(IHttpProcess iHttpProcess){
        this.iHttpProcess = iHttpProcess;
    }

    public static HttpHelper getInstance(){
        if(null == mHttpHelper){
            synchronized (HttpHelper.class){
                if(null == mHttpHelper){
                    mHttpHelper = new HttpHelper();
                }
            }
        }
        return mHttpHelper;
    }

    @Override
    public void post(String url, Map<String, String> params, ICallback callback) {
        if(null == iHttpProcess){
           LogUtil.e(TAG,"null == iHttpProcess");
           return;
        }
        iHttpProcess.post(url,params,callback);
    }

    @Override
    public void get(String url, Map<String, String> params, ICallback callback) {
        if(null == iHttpProcess){
            LogUtil.e(TAG,"null == iHttpProcess");
            return;
        }
        iHttpProcess.get(url,params,callback);
    }
}
