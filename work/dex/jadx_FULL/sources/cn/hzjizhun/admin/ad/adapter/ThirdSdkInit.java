package cn.hzjizhun.admin.ad.adapter;

import android.content.Context;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public interface ThirdSdkInit {
    String getPlatformType();

    void init(Context context, String str);

    void setThirdSdkInitCallback(ThirdSdkInitCallback thirdSdkInitCallback);
}
