package com.veryworks.android.fragmentbasic2;

import android.content.res.Configuration;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
    }

    private void init(){
        if(getResources().getConfiguration().orientation
                == Configuration.ORIENTATION_PORTRAIT){ // 현재 레이아웃? 세로체크
            initFragment();
        }
    }

    private void initFragment(){ // 프래그먼트 더하기
        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.container, new ListFragment())
                .commit();
    }
}
