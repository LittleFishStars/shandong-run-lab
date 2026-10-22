package com.zj.adlib;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public class p62 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f43912a;
    public final int b;

    public p62(int i, int i2) {
        this.f43912a = i;
        this.b = i2;
    }

    public final int a() {
        return this.b;
    }

    public final int b() {
        return this.f43912a;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof p62)) {
            return false;
        }
        p62 p62Var = (p62) obj;
        return this.f43912a == p62Var.f43912a && this.b == p62Var.b;
    }

    public final int hashCode() {
        return this.f43912a ^ this.b;
    }

    public final String toString() {
        return this.f43912a + "(" + this.b + ')';
    }
}
