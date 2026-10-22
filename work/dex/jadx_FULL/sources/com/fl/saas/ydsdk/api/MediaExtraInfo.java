package com.fl.saas.ydsdk.api;

import com.fl.saas.base.widget.AdInfo;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public interface MediaExtraInfo {
    default void biddingResultUpload(boolean z, int i, int i2) {
    }

    default AdInfo getAdInfo() {
        return null;
    }

    default int getECPM() {
        return 0;
    }

    default String getMaterialJson() {
        return "";
    }
}
