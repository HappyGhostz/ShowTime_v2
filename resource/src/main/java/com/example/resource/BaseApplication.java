package com.example.resource;

import android.app.Application;
import android.content.Context;
import android.support.annotation.NonNull;
import android.util.Log;

import com.example.resource.netutile.RetrofitService;
import com.example.resource.rxbus.RxBus;

import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;

/**
 * @author Zhao Chenping
 * @creat 2017/8/19.
 * @description
 */

public class BaseApplication extends Application {
    private static volatile BaseApplication mInstance;
    private static Context mContext;
    private RxBus rxBus;

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
