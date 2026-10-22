package com.fl.saas;

import java.io.Serializable;

/* JADX INFO: renamed from: com.fl.saas.q0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public enum EnumC1430q0 implements Serializable {
    VERTICAL(0),
    HORIZONTAL(1),
    ENVELOPE(2);


    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f30187a;

    EnumC1430q0(int i) {
        this.f30187a = i;
    }

    public int b() {
        return this.f30187a;
    }

    public static EnumC1430q0 a(int i) {
        for (EnumC1430q0 enumC1430q0 : values()) {
            if (enumC1430q0.b() == i) {
                return enumC1430q0;
            }
        }
        return VERTICAL;
    }
}
