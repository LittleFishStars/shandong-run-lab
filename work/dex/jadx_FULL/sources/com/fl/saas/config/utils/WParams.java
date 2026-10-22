package com.fl.saas.config.utils;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class WParams {
    private String placeId;
    private long wakeUpTime;

    public WParams(long j, String str) {
        this.wakeUpTime = j;
        this.placeId = str;
    }

    public String getPlaceId() {
        return this.placeId;
    }

    public long getWakeUpTime() {
        return this.wakeUpTime;
    }
}
