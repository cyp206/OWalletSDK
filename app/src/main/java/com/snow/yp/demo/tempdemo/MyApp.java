package com.snow.yp.demo.tempdemo;

import android.content.Context;
import android.support.multidex.MultiDex;
import android.support.multidex.MultiDexApplication;

import rehanced.com.simpleetherwallet.WalletSDK;


/**
 * Created by y on 2017/7/9.
 */

public class MyApp extends MultiDexApplication {

    private static Context mContext;


    @Override
    protected void attachBaseContext(Context base) {
        // longlive sdk
//        initLongLiveSdk(base);
        super.attachBaseContext(base);
        MultiDex.install(this);

    }


    @Override
    public void onCreate() {
        super.onCreate();
        mContext = this;
        WalletSDK.DEBUG(true);

        WalletSDK.init(this);

        //隐藏监听


    }

    public static Context getContext() {
        return mContext;
    }


}
