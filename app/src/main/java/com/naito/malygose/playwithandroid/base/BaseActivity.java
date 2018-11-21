package com.naito.malygose.playwithandroid.base;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import com.naito.malygose.playwithandroid.R;
import com.naito.malygose.playwithandroid.util.network.NetUtil;
import com.naito.malygose.playwithandroid.util.network.NetWorkChangeHandler;

import butterknife.ButterKnife;


public abstract class BaseActivity extends AppCompatActivity implements NetWorkChangeHandler.NetEvent {

    private BaseActivity baseActivity;
    public static NetWorkChangeHandler.NetEvent netEvent;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getActivityResId());
        baseActivity = this;
        netEvent = this;
        ButterKnife.bind(baseActivity);
        initStatusColor();
        initView();
        initData();
    }

    protected abstract void initData();

    protected abstract void initView();

    private void initStatusColor() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            Window window = baseActivity.getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(getColor(R.color.colorPrimary));
            View mChildView = baseActivity.findViewById(Window.ID_ANDROID_CONTENT);
            if (mChildView != null) {
                ViewCompat.setFitsSystemWindows(mChildView, false);
            }


        }
    }

    protected abstract int getActivityResId();

    @Override
    public void onNetChange(int netMobile) {
        if (netMobile == NetUtil.NETWORK_NONE) {
            Log.e("onNetChange", "NETWORK_NONE");
        } else {
            Log.e("onNetChange", "NETWORK_NORMAL");
        }
    }

}
