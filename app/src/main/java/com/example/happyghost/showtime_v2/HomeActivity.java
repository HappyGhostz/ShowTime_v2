package com.example.happyghost.showtime_v2;

import android.content.ComponentName;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class HomeActivity extends AppCompatActivity {

    private Button mNewButton;
    private Button mLiveButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.app_activity_home);
        initView();
        initData();
    }

    private void initData() {
        mNewButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                ComponentName cn = new ComponentName("com.example.module1","com.example.module1.MainActivity");
                intent.setComponent(cn);
                startActivity(intent);
            }
        });
        mLiveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                ComponentName cn = new ComponentName("com.example.module2","com.example.module2.MainActivity");
                intent.setComponent(cn);
                startActivity(intent);
            }
        });
    }

    private void initView() {
        mNewButton = (Button) findViewById(R.id.app_button);
        mLiveButton = (Button) findViewById(R.id.app_button2);
    }
}
