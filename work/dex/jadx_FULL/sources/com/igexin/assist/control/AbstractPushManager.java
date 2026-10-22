package com.igexin.assist.control;

import android.content.Context;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public interface AbstractPushManager {
    String getBrandCode();

    String getToken(Context context);

    boolean isSupport();

    void register(Context context);

    void setSilentTime(Context context, int i, int i2);

    void turnOffPush(Context context);

    void turnOnPush(Context context);

    void unregister(Context context);
}
