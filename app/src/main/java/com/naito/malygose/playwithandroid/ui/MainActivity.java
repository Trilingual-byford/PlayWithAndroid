package com.naito.malygose.playwithandroid.ui;

import android.content.Context;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.naito.malygose.playwithandroid.R;
import com.naito.malygose.playwithandroid.base.BaseActivity;
import com.naito.malygose.playwithandroid.ui.main.MainFragment;
import com.naito.malygose.playwithandroid.util.network.NetWorkChangeHandler;

public class MainActivity extends BaseActivity {

    @Override
    protected void initData() {

    }

    @Override
    protected void initView() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            initNetWorkHandler(this);
        }
    }

    @RequiresApi(api = 21)
    public void initNetWorkHandler(Context context) {
        NetWorkChangeHandler.intNetWorkChangeHandler(context);
    }

    ;

    @Override
    protected int getActivityResId() {
        return R.layout.main_activity;
    }

    @Override
    public void onNetChange(int netMobile) {
        Toast.makeText(this, "Changed" + netMobile, Toast.LENGTH_LONG).show();
    }
}
