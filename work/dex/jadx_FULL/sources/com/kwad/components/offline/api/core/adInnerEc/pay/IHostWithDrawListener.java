package com.kwad.components.offline.api.core.adInnerEc.pay;

import androidx.annotation.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
@Keep
public interface IHostWithDrawListener {
    void onWithdrawCancel(String str);

    void onWithdrawFailure(int i, String str);

    void onWithdrawSuccess(String str);
}
