package com.kwad.components.ad.reward.monitor;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public enum LivePlayMonitorType {
    AD_LIVE_IMPL_LOAD_ERROR(1),
    LIVE_PLAY_MODULE_RELEASE_INNER_EXCEPTION(9);

    private int type;

    LivePlayMonitorType(int i) {
        this.type = i;
    }

    public final int getValue() {
        return this.type;
    }
}
