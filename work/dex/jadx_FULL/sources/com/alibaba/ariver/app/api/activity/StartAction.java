package com.alibaba.ariver.app.api.activity;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public enum StartAction {
    SHOW_LOADING,
    SHOW_ERROR,
    DIRECT_START;

    public boolean needWaitIpc() {
        return this == SHOW_LOADING;
    }
}
