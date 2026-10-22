package com.amap.api.col.p0003l;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public abstract class ip {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ip f25975a;

    public ip() {
    }

    public int a() {
        ip ipVar = this.f25975a;
        return Math.min(Integer.MAX_VALUE, ipVar != null ? ipVar.a() : Integer.MAX_VALUE);
    }

    public void b(int i) {
        ip ipVar = this.f25975a;
        if (ipVar != null) {
            ipVar.b(i);
        }
    }

    public void c(boolean z) {
        ip ipVar = this.f25975a;
        if (ipVar != null) {
            ipVar.c(z);
        }
    }

    public abstract boolean c();

    public final boolean d() {
        ip ipVar = this.f25975a;
        if (ipVar != null ? ipVar.d() : true) {
            return c();
        }
        return false;
    }

    public ip(ip ipVar) {
        this.f25975a = ipVar;
    }
}
