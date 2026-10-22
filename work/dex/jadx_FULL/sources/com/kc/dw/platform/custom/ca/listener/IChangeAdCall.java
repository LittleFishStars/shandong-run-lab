package com.kc.dw.platform.custom.ca.listener;

import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public interface IChangeAdCall {
    void changeAdClicked();

    void changeAdClosed();

    void changeAdExposure();

    void changeRenderError(int i, String str);

    void changeRenderSuccess();
}
