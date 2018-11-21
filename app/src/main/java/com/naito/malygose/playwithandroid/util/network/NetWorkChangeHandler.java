package com.naito.malygose.playwithandroid.util.network;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkRequest;
import android.os.Build;
import android.support.annotation.RequiresApi;

import com.naito.malygose.playwithandroid.base.BaseActivity;

public class NetWorkChangeHandler {
    public static NetEvent netEvent=BaseActivity.netEvent;
    @RequiresApi(api = 21)
    public static void intNetWorkChangeHandler(Context context){
        NetUtil.init(context);
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        connectivityManager.requestNetwork(new NetworkRequest.Builder().build(),new ConnectivityManager.NetworkCallback(){
            @Override
            public void onAvailable(Network network) {
                super.onAvailable(network);

                int netWorkState=NetUtil.getNetWorkState();
                netEvent.onNetChange(netWorkState);
            }

            @Override
            public void onLost(Network network) {
                super.onLost(network);
                int netWorkState=NetUtil.getNetWorkState();
                netEvent.onNetChange(netWorkState);
            }
        });
//        NetUtil.init(context);
//        int netWorkState=NetUtil.getNetWorkState();
    }
//        if(intent.getAction().equals("CONNECTIVITY_CHANGE")){
//            NetUtil.init(context);
//            int netWorkState=NetUtil.getNetWorkState();
//            netEvent.onNetChange(netWorkState);
//        }

    public interface NetEvent{
        void onNetChange(int netMobile);
    }
}
