package com.google.android.gms.internal.mlkit_vision_barcode;

import com.zj.adlib.jtd;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public abstract class zzuv {
    public static zzuv g(float f, float f2, float f3, float f4, float f5) {
        return new jtd(f, f2, f3, f4, 0.0f);
    }

    public abstract float a();

    public abstract float b();

    public abstract float c();

    public abstract float d();

    public abstract float e();

    public final float f() {
        if (h()) {
            return (b() - c()) * (d() - e());
        }
        return 0.0f;
    }

    public final boolean h() {
        return c() >= 0.0f && c() < b() && b() <= 1.0f && e() >= 0.0f && e() < d() && d() <= 1.0f;
    }
}
