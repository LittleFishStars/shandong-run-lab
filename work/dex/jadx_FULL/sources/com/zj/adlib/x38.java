package com.zj.adlib;

import androidx.annotation.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class x38 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final x38 f45741a = new x38(0, 0);

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final long f20602a;
    public final long b;

    public x38(long j, long j2) {
        this.f20602a = j;
        this.b = j2;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || x38.class != obj.getClass()) {
            return false;
        }
        x38 x38Var = (x38) obj;
        return this.f20602a == x38Var.f20602a && this.b == x38Var.b;
    }

    public int hashCode() {
        return (((int) this.f20602a) * 31) + ((int) this.b);
    }

    public String toString() {
        return "[timeUs=" + this.f20602a + ", position=" + this.b + "]";
    }
}
