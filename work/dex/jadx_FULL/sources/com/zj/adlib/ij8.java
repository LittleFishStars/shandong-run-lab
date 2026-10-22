package com.zj.adlib;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class ij8 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f42370a;
    public final int b;

    public ij8(int i, int i2) {
        this.f42370a = i;
        this.b = i2;
    }

    @NonNull
    public static ij8 c(@NonNull String str) throws NumberFormatException {
        if (str == null) {
            throw new IllegalArgumentException("string must not be null");
        }
        int iIndexOf = str.indexOf(42);
        if (iIndexOf < 0) {
            iIndexOf = str.indexOf(120);
        }
        if (iIndexOf < 0) {
            throw d(str);
        }
        try {
            return new ij8(Integer.parseInt(str.substring(0, iIndexOf)), Integer.parseInt(str.substring(iIndexOf + 1)));
        } catch (NumberFormatException unused) {
            throw d(str);
        }
    }

    public static NumberFormatException d(String str) {
        throw new NumberFormatException("Invalid Size: \"" + str + "\"");
    }

    public int a() {
        return this.b;
    }

    public int b() {
        return this.f42370a;
    }

    public boolean equals(@Nullable Object obj) {
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (obj instanceof ij8) {
            ij8 ij8Var = (ij8) obj;
            if (this.f42370a == ij8Var.f42370a && this.b == ij8Var.b) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        int i = this.b;
        int i2 = this.f42370a;
        return i ^ ((i2 >>> 16) | (i2 << 16));
    }

    @NonNull
    public String toString() {
        return this.f42370a + "x" + this.b;
    }
}
