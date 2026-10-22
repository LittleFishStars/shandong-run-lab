package com.kc.dw.platform.custom.ca.splash;

import com.kc.dw.platform.custom.ca.listener.IChangeAdCall;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public interface IChangeSplashAdCall extends IChangeAdCall {
    void changeAdSkip();

    void changeAdTick(long j);

    void changeAdTimeOver();
}
