package com.fl.saas.common.saas.bean;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public enum Orientation {
    VERTICAL(0),
    HORIZONTAL(1),
    ENVELOPE(2);

    private final int value;

    Orientation(int i) {
        this.value = i;
    }

    public static Orientation create(int i) {
        for (Orientation orientation : values()) {
            if (orientation.getValue() == i) {
                return orientation;
            }
        }
        return VERTICAL;
    }

    public int getValue() {
        return this.value;
    }
}
