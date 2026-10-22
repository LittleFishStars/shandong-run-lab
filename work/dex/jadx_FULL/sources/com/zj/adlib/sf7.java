package com.zj.adlib;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class sf7 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f44682a;
    public final int b;

    public sf7(int i, int i2) {
        ax6.d(i > 0);
        ax6.d(i2 > 0);
        this.f44682a = i;
        this.b = i2;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof sf7)) {
            return false;
        }
        sf7 sf7Var = (sf7) obj;
        return this.f44682a == sf7Var.f44682a && this.b == sf7Var.b;
    }

    public int hashCode() {
        return yy3.b(this.f44682a, this.b);
    }

    public String toString() {
        return String.format(null, "%dx%d", Integer.valueOf(this.f44682a), Integer.valueOf(this.b));
    }
}
