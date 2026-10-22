package com.beizi.fusion;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public enum j7 {
    DEVICE_UNKNOWN(0),
    DEVICE_PHONE(1),
    DEVICE_FLAT(2),
    DEVICE_WEAR(3),
    DEVICE_PC(4),
    DEVICE_OTHER(5);


    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f27427a;

    j7(int i) {
        this.f27427a = i;
    }

    public final int b() {
        return this.f27427a;
    }
}
