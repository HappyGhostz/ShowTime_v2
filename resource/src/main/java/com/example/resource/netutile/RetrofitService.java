package com.example.resource.netutile;

import android.content.Context;
import android.util.Log;

import com.example.resource.BaseApplication;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.concurrent.TimeUnit;

import okhttp3.Cache;
import okhttp3.CacheControl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okio.Buffer;

/**
 * @author Zhao Chenping
 * @creat 2017/8/19.
 * @description
 */

public class RetrofitService {
    private static final String TAG = "RetrofitService.class";
    //设缓存有效期为1天
    static final long CACHE_STALE_SEC = 60 * 60 * 24 * 1;
    //查询缓存的Cache-Control设置，为if-only-cache时只查询缓存而不会请求服务器，max-stale可以配合设置缓存失效时间
    private static final String CACHE_CONTROL_CACHE = "only-if-cached, max-stale=" + CACHE_STALE_SEC;
    /**
     * 初始化网络通信服务
     * @param mContext
     */
    public static void init(Context mContext){
        File cacheDir = mContext.getCacheDir();
        File file = new File(cacheDir, "OkHttpCache");
        // 指定缓存路径,缓存大小100Mb
        Cache cache = new Cache(file,1024*1024*1024);
        OkHttpClient okHttpClient = new OkHttpClient().newBuilder().cache(cache)
                .retryOnConnectionFailure(true)//重连
                .addInterceptor(mLogginginterceptor)
                .addInterceptor(mCacheContralInterceptor)
                .addNetworkInterceptor(mCacheContralInterceptor)
                .connectTimeout(10, TimeUnit.SECONDS)
                .build();
    }

    /**
     * 云端响应拦截器，用来配置缓存策略
     */
    private static Interceptor mCacheContralInterceptor = new Interceptor() {
        @Override
        public Response intercept(Chain chain) throws IOException {
            Request request = chain.request();
            if(!NetUtils.isNetworkAvailable(BaseApplication.getBaseMyContext())){
                request.newBuilder().cacheControl(CacheControl.FORCE_CACHE).build();
            }
            Response response = chain.proceed(request);
            if(NetUtils.isNetworkAvailable(BaseApplication.getBaseMyContext())){
                String cacheString = request.cacheControl().toString();
                return response.newBuilder()
                        .addHeader("Cache-Control", cacheString)
                        .removeHeader("Pragma")
                        .build();
            }else {
                return response.newBuilder()
                        .addHeader("Cache-Control", "public, " + CACHE_CONTROL_CACHE)
                        .removeHeader("Pragma")
                        .build();
            }
        }
    };

    /**
     * 打印返回的json拦截器
     */
    private static Interceptor mLogginginterceptor = new Interceptor() {
        @Override
        public Response intercept(Chain chain) throws IOException {
            Request request = chain.request();
            Buffer buffer = new Buffer();
            if(request.body()!=null){
                request.body().writeTo(buffer);
            }else {
                Log.e(TAG, "intercept: request's body is null" );
            }
            //打印url信息
            String urlInfo = request.url()+(request.body()!=null? parseParams(request.body(),buffer):"null");
            Log.e(TAG, "intercept: urlInfo::: "+ urlInfo);
            Response response = chain.proceed(request);
            return response;
        }
    };

    private static String parseParams(RequestBody body, Buffer buffer) throws UnsupportedEncodingException {
        if(body.contentType()!=null&&body.contentType().toString().contains("multipart")){
            return URLDecoder.decode(buffer.readUtf8(),"UTF-8");
        }
        return null;
    }
}
