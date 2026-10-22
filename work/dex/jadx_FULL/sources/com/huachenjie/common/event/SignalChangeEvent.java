package com.huachenjie.common.event;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
public class SignalChangeEvent {
    private int validLocCount;

    public SignalChangeEvent(int validCount) {
        this.validLocCount = validCount;
    }

    public int getValidLocCount() {
        return this.validLocCount;
    }

    public void setValidLocCount(int validLocCount) {
        this.validLocCount = validLocCount;
    }
}
