package com.getui.gtc.dim;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public enum Caller {
    UNKNOWN(1),
    PUSH(2),
    GY(4),
    IDO(8),
    WUS(16),
    ONEID(32);

    public final int index;

    Caller(int i) {
        this.index = i;
    }

    public final boolean containAt(int i) {
        return (i & this.index) != 0;
    }
}
