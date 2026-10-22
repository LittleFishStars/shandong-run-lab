package com.efs.sdk.net.a;

import java.util.HashMap;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class a {
    private static a c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private HashMap<String, c> f29906a;
    private HashMap<String, d> b;

    private a() {
        b();
    }

    public static a a() {
        if (c == null) {
            c = new a();
        }
        return c;
    }

    private void b() {
        if (this.f29906a == null) {
            this.f29906a = new HashMap<>();
        }
        this.f29906a.clear();
    }

    public final d c(String str) {
        if (this.b == null) {
            this.b = new HashMap<>();
        }
        if (this.b.containsKey(str)) {
            return this.b.get(str);
        }
        d dVar = new d();
        dVar.A = str;
        dVar.D = System.currentTimeMillis();
        this.b.put(str, dVar);
        return dVar;
    }

    public final void d(String str) {
        HashMap<String, d> map = this.b;
        if (map == null || !map.containsKey(str)) {
            return;
        }
        this.b.remove(str);
    }

    public final c a(String str) {
        if (this.f29906a == null) {
            b();
        }
        c cVar = this.f29906a.get(str);
        if (cVar != null) {
            return cVar;
        }
        c cVar2 = new c();
        cVar2.f29916a = str;
        cVar2.b = System.currentTimeMillis();
        this.f29906a.put(str, cVar2);
        return cVar2;
    }

    public final void b(String str) {
        HashMap<String, c> map = this.f29906a;
        if (map == null || !map.containsKey(str)) {
            return;
        }
        this.f29906a.remove(str);
    }
}
