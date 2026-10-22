package com.zj.adlib;

import androidx.annotation.Nullable;
import com.google.common.base.g;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class vr0 {
    public static final int c = 1;
    public static final int d = 1;
    public static final int e = Integer.MIN_VALUE;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f45424a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final String f20281a;
    public final int b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public final String f20282b;

    public vr0(String str) {
        this(str, str, Integer.MIN_VALUE, 1);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof vr0)) {
            return false;
        }
        vr0 vr0Var = (vr0) obj;
        return this.f45424a == vr0Var.f45424a && this.b == vr0Var.b && g.a(this.f20281a, vr0Var.f20281a) && g.a(this.f20282b, vr0Var.f20282b);
    }

    public int hashCode() {
        return g.b(this.f20281a, this.f20282b, Integer.valueOf(this.f45424a), Integer.valueOf(this.b));
    }

    public vr0(String str, String str2, int i, int i2) {
        this.f20281a = str;
        this.f20282b = str2;
        this.f45424a = i;
        this.b = i2;
    }
}
