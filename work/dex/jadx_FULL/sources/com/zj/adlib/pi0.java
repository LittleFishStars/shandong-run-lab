package com.zj.adlib;

import androidx.annotation.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class pi0 {
    public static final int b = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float f43985a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final int f18849a;

    public pi0(int i, float f) {
        this.f18849a = i;
        this.f43985a = f;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || pi0.class != obj.getClass()) {
            return false;
        }
        pi0 pi0Var = (pi0) obj;
        return this.f18849a == pi0Var.f18849a && Float.compare(pi0Var.f43985a, this.f43985a) == 0;
    }

    public int hashCode() {
        return ((527 + this.f18849a) * 31) + Float.floatToIntBits(this.f43985a);
    }
}
