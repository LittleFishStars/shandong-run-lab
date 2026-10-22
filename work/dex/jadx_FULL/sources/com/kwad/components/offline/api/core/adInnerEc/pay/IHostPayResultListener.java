package com.kwad.components.offline.api.core.adInnerEc.pay;

import androidx.annotation.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
@Keep
public interface IHostPayResultListener {
    void onPayCancel();

    void onPayFailure(String str);

    void onPaySuccess();

    void onPayUnknown();
}
