package com.kc.bw.common.Ibase;

import android.os.Bundle;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public interface IBaseInterface<T> {
    String getCurrentVCode();

    int getECPM();

    String getRequestId();

    boolean isReady();

    void sendLossNotificationWithInfo(Bundle bundle);

    void sendWinNotificationWithInfo(Bundle bundle);

    void setImplement(T t);
}
