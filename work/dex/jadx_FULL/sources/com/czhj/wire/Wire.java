package com.czhj.wire;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class Wire {
    private Wire() {
    }

    public static <T> T get(T t, T t2) {
        return t != null ? t : t2;
    }
}
