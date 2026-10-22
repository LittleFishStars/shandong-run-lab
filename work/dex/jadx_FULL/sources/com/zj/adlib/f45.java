package com.zj.adlib;

import androidx.annotation.Nullable;
import java.util.Arrays;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public final class f45<V> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public final V f41590a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public final Throwable f16449a;

    public f45(V v) {
        this.f41590a = v;
        this.f16449a = null;
    }

    @Nullable
    public Throwable a() {
        return this.f16449a;
    }

    @Nullable
    public V b() {
        return this.f41590a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof f45)) {
            return false;
        }
        f45 f45Var = (f45) obj;
        if (b() != null && b().equals(f45Var.b())) {
            return true;
        }
        if (a() == null || f45Var.a() == null) {
            return false;
        }
        return a().toString().equals(a().toString());
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{b(), a()});
    }

    public f45(Throwable th) {
        this.f16449a = th;
        this.f41590a = null;
    }
}
