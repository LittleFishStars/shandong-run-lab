package cj.mobile.wm.common.Ibase;

import android.os.Bundle;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public interface IBaseInterface<T> {
    String getCurrentVCode();

    int getECPM();

    String getRequestId();

    boolean isReady();

    void sendLossNotificationWithInfo(Bundle bundle);

    void sendWinNotificationWithInfo(Bundle bundle);

    void setImplement(T t);
}
