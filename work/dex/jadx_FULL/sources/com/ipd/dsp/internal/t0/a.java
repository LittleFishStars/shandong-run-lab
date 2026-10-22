package com.ipd.dsp.internal.t0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public enum a {
    DATUM_AUTO(0),
    DATUM_WIDTH(1),
    DATUM_HEIGHT(2);

    public final int f;

    a(int i) {
        this.f = i;
    }

    public static a a(int i) {
        a aVar = DATUM_WIDTH;
        if (i == aVar.f) {
            return aVar;
        }
        a aVar2 = DATUM_HEIGHT;
        return i == aVar2.f ? aVar2 : DATUM_AUTO;
    }
}
