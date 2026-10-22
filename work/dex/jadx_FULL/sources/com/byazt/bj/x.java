package com.byazt.bj;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
public enum x {
    UNDEFINED(0),
    EXACTLY(1),
    AT_MOST(2);

    public final int uj;

    x(int i) {
        this.uj = i;
    }

    public static x c(int i) {
        if (i == 0) {
            return UNDEFINED;
        }
        if (i == 1) {
            return EXACTLY;
        }
        if (i == 2) {
            return AT_MOST;
        }
        throw new IllegalArgumentException("Unknown enum value: ".concat(String.valueOf(i)));
    }
}
