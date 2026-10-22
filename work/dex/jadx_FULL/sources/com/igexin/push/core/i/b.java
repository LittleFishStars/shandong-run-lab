package com.igexin.push.core.i;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class b {
    private static b b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Map<Long, a> f38069a = new HashMap();

    private b() {
    }

    public static b a() {
        if (b == null) {
            b = new b();
        }
        return b;
    }

    private void b(a aVar) {
        if (aVar != null) {
            a(aVar);
        }
    }

    private void c(a aVar) {
        if (aVar != null) {
            this.f38069a.put(aVar.a(), aVar);
        }
    }

    public final a a(Long l) {
        return this.f38069a.get(l);
    }

    public final void a(a aVar) {
        if (aVar != null) {
            this.f38069a.remove(aVar.a());
        }
    }
}
