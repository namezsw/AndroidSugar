package com.seven.sugar.home.activity;

import android.content.Context;

public class TestDataModel {

    private static TestDataModel sInstance;
    private Context mContext;

    public TestDataModel(Context mContext) {
        this.mContext = mContext;
    }

    public static TestDataModel getInstance(Context context) {
        if (sInstance == null) {
            sInstance = new TestDataModel(context);
        }
        return sInstance;
    }
}