package com.google.zxing;

import com.zj.adlib.qv0;
import com.zj.adlib.tv0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public abstract class Binarizer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LuminanceSource f32491a;

    public Binarizer(LuminanceSource luminanceSource) {
        this.f32491a = luminanceSource;
    }

    public abstract Binarizer a(LuminanceSource luminanceSource);

    public abstract tv0 b() throws NotFoundException;

    public abstract qv0 c(int i, qv0 qv0Var) throws NotFoundException;

    public final int d() {
        return this.f32491a.b();
    }

    public final LuminanceSource e() {
        return this.f32491a;
    }

    public final int f() {
        return this.f32491a.e();
    }
}
