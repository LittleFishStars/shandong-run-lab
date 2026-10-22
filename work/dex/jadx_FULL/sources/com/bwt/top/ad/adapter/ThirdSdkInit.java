package com.bwt.top.ad.adapter;

import android.content.Context;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public interface ThirdSdkInit {
    String getPlatformType();

    void init(Context context, String str);

    void setThirdSdkInitCallback(ThirdSdkInitCallback thirdSdkInitCallback);
}
