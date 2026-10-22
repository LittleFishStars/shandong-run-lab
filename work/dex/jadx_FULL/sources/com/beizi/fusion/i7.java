package com.beizi.fusion;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public enum i7 {
    ADP_UNKNOWN(0),
    ADP_IVIDEO(1),
    ADP_LOADING(2),
    ADP_TABLE(3),
    ADP_BANNER(4),
    ADP_CUSTOMER(5),
    ADP_NATIVE(6);


    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f27402a;

    i7(int i2) {
        this.f27402a = i2;
    }

    public static i7 a(int i2) {
        switch (i2) {
            case 0:
                return ADP_UNKNOWN;
            case 1:
                return ADP_IVIDEO;
            case 2:
                return ADP_LOADING;
            case 3:
                return ADP_TABLE;
            case 4:
                return ADP_BANNER;
            case 5:
                return ADP_CUSTOMER;
            case 6:
                return ADP_NATIVE;
            default:
                return null;
        }
    }
}
