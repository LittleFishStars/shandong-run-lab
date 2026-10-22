package com.getui.gtc.dim;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public enum AllowSysCall {
    NOT_ALLOW(0),
    ONLY_ALLOW_FORE_CALL(1),
    ALL_ALLOW(2);

    private final int value;

    AllowSysCall(int i) {
        this.value = i;
    }

    public static AllowSysCall valueOf(int i) {
        if (i != 0) {
            return i != 1 ? ALL_ALLOW : ONLY_ALLOW_FORE_CALL;
        }
        return NOT_ALLOW;
    }

    public final int getValue() {
        return this.value;
    }
}
