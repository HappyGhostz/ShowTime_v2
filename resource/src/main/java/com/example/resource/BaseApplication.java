package com.example.resource;

import android.app.Application;
import android.content.Context;

import com.example.resource.netutile.RetrofitService;

/**
 * @author Zhao Chenping
 * @creat 2017/8/19.
 * @description
 */

public class BaseApplication extends Application {
    private static volatile BaseApplication mInstance;
    private static Context mContext;

    @Override
    public void onCreate() {
        super.onCreate();
        mContext = getApplicationContext();
        RetrofitService.init(mContext);
    }
    public static void getInstance(){
        if(mInstance==null){
            synchronized (BaseApplication.class){
                if(mInstance==null){
                    mInstance = new BaseApplication();
                }
            }
        }
    }

    public static Context getBaseMyContext(){
        return mContext;
    }
}
