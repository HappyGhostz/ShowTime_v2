package com.example.module1;

import android.content.Context;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.module1.adapter.RvAdapter;
import com.example.module1.adapter.RvItemDecoration;
import com.example.module1.data.NewsInfo;
import com.example.module1.net.NewsApi;
import com.example.resource.BaseApplication;
import com.example.resource.netutile.RetrofitService;

import org.reactivestreams.Subscription;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;


public class MainActivity extends AppCompatActivity {

    private static final String TAG = "module1";
    private RecyclerView mRv;
    private List<NewsInfo.NewsInfoBean> mNewsInfos ;
    private Context mBaseMyContext;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.m1_activity_main);
        mBaseMyContext = BaseApplication.getBaseMyContext();
        mNewsInfos = new ArrayList<>();
        initNet();
        initView();
//        initData();
    }

    private void initView() {
        mRv = (RecyclerView) findViewById(R.id.m1_rv);
    }

    private void initData() {

        mRv.setLayoutManager(new LinearLayoutManager(mBaseMyContext,LinearLayoutManager.VERTICAL,false));
        RvAdapter mRvAdapter = new RvAdapter(mBaseMyContext, mNewsInfos);
        mRv.setAdapter(mRvAdapter);
        mRv.addItemDecoration(new RvItemDecoration(LinearLayoutManager.VERTICAL));
    }

    private void initNet() {
        Retrofit retrofit = RetrofitService.init(mBaseMyContext);
        NewsApi newsApi = retrofit.create(NewsApi.class);
        Observable<NewsInfo> newsInfoFlowable = newsApi.getNewInfos()
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .subscribeOn(AndroidSchedulers.mainThread())
                .observeOn(AndroidSchedulers.mainThread());
        newsInfoFlowable
                .subscribe(new Observer<NewsInfo>() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {

            }

            @Override
            public void onNext(@NonNull NewsInfo newsInfo) {
                List<NewsInfo.NewsInfoBean> newsInfoBean = newsInfo.getNewsInfoBean();
                mNewsInfos.addAll(newsInfoBean);
                initData();
            }

            @Override
            public void onError(@NonNull Throwable e) {
                e.printStackTrace();
            }

            @Override
            public void onComplete() {
            }
        });

    }
}