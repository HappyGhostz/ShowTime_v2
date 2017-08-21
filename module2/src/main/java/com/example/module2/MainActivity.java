package com.example.module2;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.resource.BaseApplication;
import com.example.resource.rxbus.RxBus;
import com.example.resource.rxmessage.RxBusMessageForText;



import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;

public class MainActivity extends AppCompatActivity {

    private RxBus rxBus;
    private Context baseMyContext;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.m2_activity_main);
        baseMyContext = BaseApplication.getBaseMyContext();
        init();
    }

    private void init() {
        Intent intent = getIntent();
        String stringExtra = intent.getStringExtra("app");
        button = (Button) findViewById(R.id.m2_button);
        button.setOnClickListener(new View.OnClickListener() {
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
        button.setText(stringExtra);
    }

}
