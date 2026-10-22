package com.ipd.dsp.api;

import androidx.annotation.IntRange;
import androidx.annotation.Keep;
import androidx.annotation.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class BidFailedReason {

    @Nullable
    public String adTitle;

    @Nullable
    public String adUserName;

    @IntRange(from = 0)
    public int adnName;
    public int clickStatus;
    public int exposureStatus;
    public final int reasonCode;

    @Nullable
    public String requestId;

    @IntRange(from = 0)
    public int winECPM;

    public BidFailedReason(int i) {
        this.reasonCode = i;
    }
}
