package com.demo.liujian.module.common.net;





/**
 * descption:OkGo 网络代理
 * <p>
 * packageName: com.demo.liujian.module.common.net
 * <p>
 * author:liujianhui
 * <p>
 * date:2019/1/21 14:17
 */
//public class OkGoProcess<T> implements IHttpProcess {
//    private static final String TAG = OkGoProcess.class.getSimpleName();
//
//    private static volatile OkGoProcess mOkGoProxy = null;
//
//
//    public static OkGoProcess getInstance() {
//        if (mOkGoProxy == null) {
//            synchronized (OkGoProcess.class) {
//                if (mOkGoProxy == null) {
//                    mOkGoProxy = new OkGoProcess();
//                }
//            }
//        }
//        return mOkGoProxy;
//    }
//
//    private OkGoProcess() {
//
//    }
//
//
//    @Override
//    public void post(String url, Map<String, String> params, final ICallback callback) {
//        //post 方法前面必须要加泛型
//        OkGo
//                .<T>post(url)
//                .params(params,true)
//                .tag(this)               // 请求的 tag, 主要用于取消对应的请求
//                .execute(new JsonCallback<T>() {
//                    @Override
//                    public void onSuccess(Response<T> response) {
//                        callback.onSuccess(response.body());
//                    }
//
//                    @Override
//                    public void onError(Response<T> response) {
//                        super.onError(response);
//                        Throwable throwable = response.getException();
//                        if (throwable != null) {
//                            throwable.printStackTrace();
//                            callback.onError(response.getException());
//                        }
//                    }
//
//                });
//    }
//
//    @Override
//    public void get(String url, Map<String, String> params, final ICallback callback) {
//        OkGo
//                .<T>get(url)
//                .params(params,true)
//                .tag(this)   // 请求的 tag, 主要用于取消对应的请求
//                .execute(new JsonCallback<T>() {
//                    @Override
//                    public void onSuccess(Response<T> response) {
//                        callback.onSuccess(response.body());
//                    }
//
//                    @Override
//                    public void onError(Response<T> response) {
//                        super.onError(response);
//                        Throwable throwable = response.getException();
//                        if (throwable != null) {
//                            throwable.printStackTrace();
//                            callback.onError(response.getException());
//                        }
//                    }
//
//                });
//    }
//
//}
