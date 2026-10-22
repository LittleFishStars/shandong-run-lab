package com.zj.adlib;

import javax.annotation.concurrent.Immutable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
@Immutable
public class x64 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final x64 f45752a = b().a();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final int f20608a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final boolean f20609a;
    public final int b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public final boolean f20610b;
    public final boolean c;
    public final boolean d;

    public x64(y64 y64Var) {
        this.f20608a = y64Var.f();
        this.b = y64Var.b();
        this.f20609a = y64Var.e();
        this.f20610b = y64Var.d();
        this.c = y64Var.g();
        this.d = y64Var.c();
    }

    public static x64 a() {
        return f45752a;
    }

    public static y64 b() {
        return new y64();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        x64 x64Var = (x64) obj;
        return this.b == x64Var.b && this.f20609a == x64Var.f20609a && this.f20610b == x64Var.f20610b && this.c == x64Var.c && this.d == x64Var.d;
    }

    public int hashCode() {
        return (this.b * 31) + (this.f20609a ? 1 : 0);
    }

    public String toString() {
        return String.format(null, "%d-%d-%b-%b-%b-%b", Integer.valueOf(this.f20608a), Integer.valueOf(this.b), Boolean.valueOf(this.f20609a), Boolean.valueOf(this.f20610b), Boolean.valueOf(this.c), Boolean.valueOf(this.d));
    }
}
