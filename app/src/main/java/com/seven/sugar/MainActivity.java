package com.seven.sugar;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.seven.library.util.Logger;
import com.seven.library.util.ToastUtils;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ToastUtils.showToastShort(this,"hello sugar");
        showlog();
    }

    private void showlog(){
        Logger.d("hello sugar");
    }
}
