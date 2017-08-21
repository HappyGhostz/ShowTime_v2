package com.example.module1.net;

import com.example.module1.data.NewsInfo;


import java.util.List;


import io.reactivex.Observable;
import retrofit2.http.GET;

import retrofit2.http.Headers;



import static com.example.module1.net.NewsApi.CACHE_CONTROL_NETWORK;

/**
 * @author Zhao Chenping
 * @creat 2017/8/21.
 * @description
 */

public interface NewsApi {
    //(假如请求了服务器并在a时刻返回响应结果，则在max-age规定的秒数内，浏览器将不会发送对应的请求到服务器，数据由缓存直接返回)
    static final String CACHE_CONTROL_NETWORK = "Cache-Control: public, max-age=3600";
    // 避免出现 HTTP 403 Forbidden，参考：http://stackoverflow.com/questions/13670692/403-forbidden-with-java-but-not-web-browser
    static final String AVOID_HTTP403_FORBIDDEN = "User-Agent: Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.11 (KHTML, like Gecko) Chrome/23.0.1271.95 Safari/537.11";
    /**
     * 获取新闻列表
     * eg: http://c.m.163.com/nc/article/headline/T1348647909107/60-20.html
     *      http://c.m.163.com/nc/article/list/T1348647909107/60-20.html
     *
     * @param
     * @param
     * @param
     * @return
     */
//    @Headers(CACHE_CONTROL_NETWORK)
//    @GET("nc/article/headline/T1348647909107/60-20.html")
//    Observable<Map<String, List<NewsInfo>>> getNewsList(@Path("type") String type, @Path("id") String id,
////                                                        @Path("startPage") int startPage);
    @Headers(AVOID_HTTP403_FORBIDDEN)
    @GET("nc/article/headline/T1348648756099/60-20.html")
    Observable<NewsInfo> getNewInfos();
}
