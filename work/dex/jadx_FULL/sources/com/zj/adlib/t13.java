package com.zj.adlib;

import androidx.annotation.NonNull;
import java.util.Arrays;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class t13 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final f33 f44826a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final byte[] f19693a;

    public t13(@NonNull f33 f33Var, @NonNull byte[] bArr) {
        if (f33Var == null) {
            throw new NullPointerException("encoding is null");
        }
        if (bArr == null) {
            throw new NullPointerException("bytes is null");
        }
        this.f44826a = f33Var;
        this.f19693a = bArr;
    }

    public byte[] a() {
        return this.f19693a;
    }

    public f33 b() {
        return this.f44826a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof t13)) {
            return false;
        }
        t13 t13Var = (t13) obj;
        if (this.f44826a.equals(t13Var.f44826a)) {
            return Arrays.equals(this.f19693a, t13Var.f19693a);
        }
        return false;
    }

    public int hashCode() {
        return ((this.f44826a.hashCode() ^ 1000003) * 1000003) ^ Arrays.hashCode(this.f19693a);
    }

    public String toString() {
        return "EncodedPayload{encoding=" + this.f44826a + ", bytes=[...]}";
    }
}
