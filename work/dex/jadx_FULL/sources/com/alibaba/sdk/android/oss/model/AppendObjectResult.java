package com.alibaba.sdk.android.oss.model;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class AppendObjectResult extends OSSResult {
    private long nextPosition;
    private String objectCRC64;

    public long getNextPosition() {
        return this.nextPosition;
    }

    public String getObjectCRC64() {
        return this.objectCRC64;
    }

    public void setNextPosition(Long l) {
        this.nextPosition = l.longValue();
    }

    public void setObjectCRC64(String str) {
        this.objectCRC64 = str;
    }
}
