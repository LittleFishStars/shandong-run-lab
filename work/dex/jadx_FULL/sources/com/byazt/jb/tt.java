package com.byazt.jb;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
public enum tt {
    NO_ERROR(0),
    PROTOCOL_ERROR(1),
    INTERNAL_ERROR(2),
    FLOW_CONTROL_ERROR(3),
    REFUSED_STREAM(7),
    CANCEL(8);

    public final int sp;

    tt(int i) {
        this.sp = i;
    }

    public static tt c(int i) {
        try {
            for (tt ttVar : values()) {
                if (ttVar.sp == i) {
                    return ttVar;
                }
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }
}
