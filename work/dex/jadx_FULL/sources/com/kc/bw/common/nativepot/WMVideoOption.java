package com.kc.bw.common.nativepot;

import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class WMVideoOption {
    public boolean isAutoPlay;
    public boolean isSilence;

    public boolean isAutoPlay() {
        return this.isAutoPlay;
    }

    public boolean isSilence() {
        return this.isSilence;
    }

    public WMVideoOption setAutoPlay(boolean z) {
        this.isAutoPlay = z;
        return this;
    }

    public WMVideoOption setSilence(boolean z) {
        this.isSilence = z;
        return this;
    }
}
