package com.kc.cw.ad.internal.nativead;

import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public interface NativeAdEventListener {
    void onADExposed();

    void onAdClick();

    void onAdClose();

    void onAdRenderFailed(int i);
}
