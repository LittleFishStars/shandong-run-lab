package com.fl.saas.config.http;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public interface HttpCallbackStringListener {
    void onError(Exception exc);

    void onJump(String str);

    void onSuccess(String str);
}
