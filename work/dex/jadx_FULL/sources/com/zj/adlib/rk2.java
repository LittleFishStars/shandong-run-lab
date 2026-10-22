package com.zj.adlib;

import androidx.annotation.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class rk2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f44473a;

    @Nullable
    public final String b;

    @Nullable
    public final String c;

    public rk2(String str, @Nullable String str2, @Nullable String str3) {
        this.f44473a = str;
        this.b = str2;
        this.c = str3;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || rk2.class != obj.getClass()) {
            return false;
        }
        rk2 rk2Var = (rk2) obj;
        return gj9.c(this.f44473a, rk2Var.f44473a) && gj9.c(this.b, rk2Var.b) && gj9.c(this.c, rk2Var.c);
    }

    public int hashCode() {
        int iHashCode = this.f44473a.hashCode() * 31;
        String str = this.b;
        int iHashCode2 = (iHashCode + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.c;
        return iHashCode2 + (str2 != null ? str2.hashCode() : 0);
    }
}
