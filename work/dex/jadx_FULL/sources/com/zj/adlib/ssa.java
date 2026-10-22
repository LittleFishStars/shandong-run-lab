package com.zj.adlib;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public final class ssa {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public a f44767a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public b f19644a;
    public b b;

    public static class a extends rsa {
    }

    public static class b extends rsa {
    }

    public final synchronized void a() {
        a aVar = this.f44767a;
        if (aVar != null) {
            aVar.a();
            this.f44767a = null;
        }
        b bVar = this.f19644a;
        if (bVar != null) {
            bVar.a();
            this.f19644a = null;
        }
        b bVar2 = this.b;
        if (bVar2 != null) {
            bVar2.a();
            this.b = null;
        }
    }
}
