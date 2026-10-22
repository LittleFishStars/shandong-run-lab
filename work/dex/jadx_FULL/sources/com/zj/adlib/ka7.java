package com.zj.adlib;

import android.net.Uri;
import androidx.annotation.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class ka7 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f42775a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final long f17627a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final String f17628a;
    public final long b;

    public ka7(@Nullable String str, long j, long j2) {
        this.f17628a = str == null ? "" : str;
        this.f17627a = j;
        this.b = j2;
    }

    @Nullable
    public ka7 a(@Nullable ka7 ka7Var, String str) {
        String strC = c(str);
        if (ka7Var != null && strC.equals(ka7Var.c(str))) {
            long j = this.b;
            if (j != -1) {
                long j2 = this.f17627a;
                if (j2 + j == ka7Var.f17627a) {
                    long j3 = ka7Var.b;
                    return new ka7(strC, j2, j3 != -1 ? j + j3 : -1L);
                }
            }
            long j4 = ka7Var.b;
            if (j4 != -1) {
                long j5 = ka7Var.f17627a;
                if (j5 + j4 == this.f17627a) {
                    return new ka7(strC, j5, j != -1 ? j4 + j : -1L);
                }
            }
        }
        return null;
    }

    public Uri b(String str) {
        return rh9.f(str, this.f17628a);
    }

    public String c(String str) {
        return rh9.e(str, this.f17628a);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || ka7.class != obj.getClass()) {
            return false;
        }
        ka7 ka7Var = (ka7) obj;
        return this.f17627a == ka7Var.f17627a && this.b == ka7Var.b && this.f17628a.equals(ka7Var.f17628a);
    }

    public int hashCode() {
        if (this.f42775a == 0) {
            this.f42775a = ((((527 + ((int) this.f17627a)) * 31) + ((int) this.b)) * 31) + this.f17628a.hashCode();
        }
        return this.f42775a;
    }

    public String toString() {
        return "RangedUri(referenceUri=" + this.f17628a + ", start=" + this.f17627a + ", length=" + this.b + ")";
    }
}
