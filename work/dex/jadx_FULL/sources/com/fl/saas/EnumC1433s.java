package com.fl.saas;

import java.io.Serializable;

/* JADX INFO: renamed from: com.fl.saas.s, reason: case insensitive filesystem */
/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public enum EnumC1433s implements Serializable {
    FLOAT_TOP_RIGHT(0),
    IMAGE_BOTTOM_CENTER(1),
    IMAGE_TOP_RIGHT(2);


    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f30189a;

    EnumC1433s(int i) {
        this.f30189a = i;
    }

    public int b() {
        return this.f30189a;
    }

    public static EnumC1433s a(int i) {
        for (EnumC1433s enumC1433s : values()) {
            if (enumC1433s.b() == i) {
                return enumC1433s;
            }
        }
        return FLOAT_TOP_RIGHT;
    }
}
