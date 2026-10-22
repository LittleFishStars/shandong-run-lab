package com.zj.adlib;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public final class tn2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f44961a;
    public final int b;

    public tn2(int i, int i2) {
        if (i < 0 || i2 < 0) {
            throw new IllegalArgumentException();
        }
        this.f44961a = i;
        this.b = i2;
    }

    public int a() {
        return this.b;
    }

    public int b() {
        return this.f44961a;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof tn2)) {
            return false;
        }
        tn2 tn2Var = (tn2) obj;
        return this.f44961a == tn2Var.f44961a && this.b == tn2Var.b;
    }

    public int hashCode() {
        return (this.f44961a * 32713) + this.b;
    }

    public String toString() {
        return this.f44961a + "x" + this.b;
    }
}
