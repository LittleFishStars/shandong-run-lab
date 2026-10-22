package com.zj.adlib;

import androidx.annotation.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class f17 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public final String f41569a;

    @Nullable
    public final String b;

    @Nullable
    public final String c;

    @Nullable
    public final String d;

    @Nullable
    public final String e;

    public f17(@Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4, @Nullable String str5) {
        this.f41569a = str;
        this.b = str2;
        this.c = str3;
        this.d = str4;
        this.e = str5;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof f17)) {
            return false;
        }
        f17 f17Var = (f17) obj;
        return gj9.c(this.f41569a, f17Var.f41569a) && gj9.c(this.b, f17Var.b) && gj9.c(this.c, f17Var.c) && gj9.c(this.d, f17Var.d) && gj9.c(this.e, f17Var.e);
    }

    public int hashCode() {
        String str = this.f41569a;
        int iHashCode = (527 + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.b;
        int iHashCode2 = (iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.c;
        int iHashCode3 = (iHashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.d;
        int iHashCode4 = (iHashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.e;
        return iHashCode4 + (str5 != null ? str5.hashCode() : 0);
    }
}
