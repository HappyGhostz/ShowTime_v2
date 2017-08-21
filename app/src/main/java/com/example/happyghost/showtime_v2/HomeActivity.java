package com.example.happyghost.showtime_v2;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.resource.BaseApplication;
import com.example.resource.rxbus.RxBus;
import com.example.resource.rxmessage.RxBusMessageForText;

import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;

public class HomeActivity extends AppCompatActivity {

    private Button mNewButton;
    private Button mLiveButton;
    private Context baseMyContext;
    private RxBus rxBus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.app_activity_home);
        baseMyContext = BaseApplication.getBaseMyContext();
        initView();
        initData();
        initRxBus();
    }

    private void initData() {
        mNewButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Intent intent = new Intent(baseMyContext,Class.forName("com.example.module1.MainActivity"));
                    startActivity(intent);
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
            }
        });
        mLiveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Intent intent = new Intent(baseMyContext,Class.forName("com.example.module2.MainActivity"));
                    intent.putExtra("app","来自主APP");
                    startActivity(intent);
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }

            }
        });
    }

    private void initView() {
        mNewButton = (Button) findViewById(R.id.app_button);
        mLiveButton = (Button) findViewById(R.id.app_button2);
    }
    private void initRxBus() {
        rxBus = RxBus.getIntanceBus();
        registerRxBus(RxBusMessageForText.class, new Consumer<RxBusMessageForText>() {
            @Override
            public void accept(@NonNull RxBusMessageForText rxBusMessage) throws Exception {
                //根据事件类型进行处理
                Toast.makeText(baseMyContext,rxBusMessage.getModuleMessage(),Toast.LENGTH_SHORT).show();
                mNewButton.setText(rxBusMessage.getModuleMessage());
            }
        });
    }

    //注册
    public <T> void registerRxBus(Class<T> eventType, Consumer<T> action) {
        Disposable disposable = rxBus.doSubscribe(eventType, action, new Consumer<Throwable>() {
            @Override
            public void accept(@NonNull Throwable throwable) throws Exception {
                Log.e("NewsMainPresenter", throwable.toString());
            }
        });
        rxBus.addSubscription(this,disposable);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        rxBus.unSubscribe(this);
    }
}
