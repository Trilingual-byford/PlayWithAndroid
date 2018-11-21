package com.naito.malygose.playwithandroid.base;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.naito.malygose.playwithandroid.R;
import com.naito.malygose.playwithandroid.base.contract.BaseView;
import com.naito.malygose.playwithandroid.util.network.NetWorkChangeHandler;

import butterknife.ButterKnife;
import butterknife.Unbinder;

public abstract class BaseFragment extends Fragment implements BaseView, NetWorkChangeHandler.NetEvent {
    private int netMobile;


    /**
     * 处理页面加载中、页面加载失败、页面没数据
     */
    private static final int NORMAL_STATE = 0;
    private static final int LOADING_STATE = 1;
    public static final int ERROR_STATE = 2;
    public static final int EMPTY_STATE = 3;
    private Activity activity;
    private Application application;
    private Unbinder bind;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(getFragmentRsId(), container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        activity = getActivity();
        application = Application.getInstance();
        bind = ButterKnife.bind(this, view);
        initView();
        initData();
    }

    protected void initView() {
        if(getView()==null){
            return;
        }
        getView().findViewById(R.id.normal_view);
        if (getView() == null) {
            throw new IllegalStateException("The subclass of RootActivity must contain a View named 'mNormalView'.");
        }

        if (!(getView().getParent() instanceof ViewGroup)) {
            throw new IllegalStateException(" mNormalView's ParentView should be a ViewGroup.");

        }


    }

    protected abstract void initData();


    @Override
    public void onDestroy() {
        super.onDestroy();
        bind.unbind();
    }

    private int getFragmentRsId() {
        return 0;
    }

    @Override
    public void showNormal() {

    }

    @Override
    public void showError(String err) {

    }

    @Override
    public void showLoading() {

    }

    @Override
    public void showEmpty() {

    }

    @Override
    public void reload() {

    }

    @Override
    public void onNetChange(int netMobile) {

    }
}
