package com.fl.saas.adx.api;

import com.fl.saas.adx.base.bean.AdInfo;

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
}
