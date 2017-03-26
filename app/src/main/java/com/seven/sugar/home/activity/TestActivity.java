package com.seven.sugar.home.activity;

import android.app.Activity;
import android.os.Bundle;

import com.seven.sugar.R;


public class TestActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        TestDataModel.getInstance(this);
    }
}