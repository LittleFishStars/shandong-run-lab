package com.fl.saas.common.saas.bean;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public enum CloseButtonPosition {
    FLOAT_TOP_RIGHT(0),
    IMAGE_BOTTOM_CENTER(1),
    IMAGE_TOP_RIGHT(2);

    private final int value;

    CloseButtonPosition(int i) {
        this.value = i;
    }

    public static CloseButtonPosition create(int i) {
        for (CloseButtonPosition closeButtonPosition : values()) {
            if (closeButtonPosition.getValue() == i) {
                return closeButtonPosition;
            }
        }
        return FLOAT_TOP_RIGHT;
    }

    public int getValue() {
        return this.value;
    }
}
