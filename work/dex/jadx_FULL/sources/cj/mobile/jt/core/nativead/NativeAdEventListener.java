package cj.mobile.jt.core.nativead;

import cj.mobile.jt.core.modle.AdError;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_13_8952cls.dex */
public interface NativeAdEventListener {
    void onAdClicked();

    void onAdClose();

    void onAdExposed();

    void onShowError(AdError adError);
}
