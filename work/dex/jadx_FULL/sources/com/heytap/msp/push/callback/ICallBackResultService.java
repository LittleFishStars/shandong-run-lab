package com.heytap.msp.push.callback;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public interface ICallBackResultService {
    void onError(int i, String str, String str2, String str3);

    void onGetNotificationStatus(int i, int i2);

    void onGetPushStatus(int i, int i2);

    void onRegister(int i, String str, String str2, String str3);

    void onSetPushTime(int i, String str);

    void onUnRegister(int i, String str, String str2);
}
