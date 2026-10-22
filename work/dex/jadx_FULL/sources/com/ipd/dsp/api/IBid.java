package com.ipd.dsp.api;

import androidx.annotation.Keep;
import androidx.annotation.NonNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public interface IBid {
    @Keep
    int getEcpm();

    @Keep
    void onBiddingFailed(@NonNull BidFailedReason bidFailedReason);

    @Keep
    void onBiddingSuccess(int i, int i2);
}
