package com.zj.adlib;

import java.util.Objects;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public final class hb3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final bh3 f42090a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final p62 f16958a;
    public final p62 b;

    public hb3(p62 p62Var, p62 p62Var2, bh3 bh3Var) {
        this.f16958a = p62Var;
        this.b = p62Var2;
        this.f42090a = bh3Var;
    }

    public bh3 a() {
        return this.f42090a;
    }

    public p62 b() {
        return this.f16958a;
    }

    public p62 c() {
        return this.b;
    }

    public boolean d() {
        return this.b == null;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof hb3)) {
            return false;
        }
        hb3 hb3Var = (hb3) obj;
        return Objects.equals(this.f16958a, hb3Var.f16958a) && Objects.equals(this.b, hb3Var.b) && Objects.equals(this.f42090a, hb3Var.f42090a);
    }

    public int hashCode() {
        return (Objects.hashCode(this.f16958a) ^ Objects.hashCode(this.b)) ^ Objects.hashCode(this.f42090a);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[ ");
        sb.append(this.f16958a);
        sb.append(" , ");
        sb.append(this.b);
        sb.append(" : ");
        bh3 bh3Var = this.f42090a;
        sb.append(bh3Var == null ? "null" : Integer.valueOf(bh3Var.c()));
        sb.append(" ]");
        return sb.toString();
    }
}
