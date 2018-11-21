package com.naito.malygose.playwithandroid.base.contract;

public interface BaseView {
    void showNormal();

    void showError(String err);

    void showLoading();

    void showEmpty();

    void reload();
}
