package com.beizi.fusion;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public enum n7 {
    RENDER_UNKNOWN(0),
    RENDER_VIDEO(1),
    RENDER_PIC(2),
    RENDER_H5(3),
    RENDER_JSON(4),
    RENDER_VAST_VIDEO(5),
    RENDER_UNIFIED(6);


    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f27555a;

    n7(int i2) {
        this.f27555a = i2;
    }

    public static n7 a(int i2) {
        switch (i2) {
            case 0:
                return RENDER_UNKNOWN;
            case 1:
                return RENDER_VIDEO;
            case 2:
                return RENDER_PIC;
            case 3:
                return RENDER_H5;
            case 4:
                return RENDER_JSON;
            case 5:
                return RENDER_VAST_VIDEO;
            case 6:
                return RENDER_UNIFIED;
            default:
                return null;
        }
    }
}
