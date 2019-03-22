package com.demo.liujian.module.common.di.module;


import dagger.Module;


/**
 *description:网络请求模块<br/>
 * <br/>
 *author:liujianhui
 *creatorTime:2017/3/18  23:12
*/
@Module
public class HttpModule {
    private static final String TAG = HttpModule.class.getSimpleName();

 /*   @Singleton
    @Provides
    OkHttpClient.Builder provideOkHttpBuilder(){
        return new  OkHttpClient.Builder();
    }


    @Singleton
    @Provides
    Retrofit.Builder provideRetrofitBuilder(){
       return new Retrofit.Builder();
    }

    *//**
     * 创建Retrofit对象
     *//*
    @Singleton
    @NewsUrl
    @Provides
    Retrofit provideNewsRetrofit(Retrofit.Builder builder,OkHttpClient okHttpClient){
        return createRetrofit(builder, SdkContant.RequestUrl.URL_NEWS_ROOT,okHttpClient);
    }

    *//**
     *调用新闻接口
     *//*
//    @Singleton
//    @Provides
//    NewsApi provideNewsService(@NewsUrl Retrofit retrofit){
//        return retrofit.create(NewsApi.class);
//    }

    *//**
     * 获取Retrofit对象
     * @return
     *//*
    private Retrofit createRetrofit(Retrofit.Builder builder,String url,OkHttpClient okHttpClient){
        Retrofit retrofit = builder
                                .baseUrl(url)
                                .client(okHttpClient)
                                .addConverterFactory( GsonConverterFactory.create())
                                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                                .build();
        return retrofit;
    }

    @Singleton
    @Provides
     OkHttpClient provideHttpClient(OkHttpClient.Builder builder) {
         if(BuildConfig.DEBUG){
             //日志显示级别
             HttpLoggingInterceptor.Level level= HttpLoggingInterceptor.Level.BODY;
             //新建log拦截器
             HttpLoggingInterceptor loggingInterceptor=new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() {
                 @Override
                 public void log(String message) {
                     Log.d(TAG,"网络请求日志打印："+message);
                 }
             });
             loggingInterceptor.setLevel(level);
             builder.addInterceptor(loggingInterceptor);

             File cacheFile = new File(AppConstant.PATH_CACHE);
             Cache cache = new Cache(cacheFile,1024 * 1024 * 60);

             Interceptor cacheInterceptor = new Interceptor() {
                 @Override
                 public Response intercept(Chain chain) throws IOException {
                     Request request = chain.request();
                     //断网下
                    if(!NetworkUtil.isNetworkConnected()){
                        request = request.newBuilder()
                                         .cacheControl(request.cacheControl())
                                         .build();
                     }
                     Response response = chain.proceed(request);
                     if(NetworkUtil.isNetworkConnected()){
                         int maxAge = 0;
                         // 有网络时, 不缓存, 最大保存时长为0
                         response.newBuilder()
                                 .header("Cache-Control", "public, max-age=" + maxAge)
                                 .removeHeader("Pragma")
                                 .build();
                     }else{
                         int maxState = 24 * 28 * 60 * 60;
                         // 有网络时, 不缓存, 最大保存时长为4周
                         response.newBuilder()
                                 .header("Cache-Control",  "public, only-if-cached, max-stale="+ maxState)
                                 .removeHeader("Pragma")
                                 .build();
                     }
                     return response;
                 }
             };
             builder.cache(cache);
             builder.addNetworkInterceptor(cacheInterceptor);
             builder.addInterceptor(cacheInterceptor);
             builder.connectTimeout(30, TimeUnit.SECONDS);
             builder.readTimeout(60,TimeUnit.SECONDS);
             builder.writeTimeout(30,TimeUnit.SECONDS);
             builder.retryOnConnectionFailure(true);
         }

        //OkHttp进行添加拦截器loggingInterceptor
        return  builder.build();
    }
*/
}
