package com.igexin.push.f.b;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class a extends f {
    private static volatile a b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private List<c> f38121a;

    private a() {
        super(60000L, (byte) 0);
        this.p = true;
        this.f38121a = new ArrayList();
    }

    public static a g() {
        if (b == null) {
            synchronized (a.class) {
                if (b == null) {
                    b = new a();
                }
            }
        }
        return b;
    }

    private void i() {
        a(360000L, TimeUnit.MILLISECONDS);
    }

    public final boolean a(c cVar) {
        List<c> list = this.f38121a;
        return (list == null || list.contains(cVar) || !this.f38121a.add(cVar)) ? false : true;
    }

    @Override // com.igexin.c.a.d.a.e
    public final int c() {
        return 0;
    }

    @Override // com.igexin.push.f.b.f
    public final void h() {
        com.igexin.push.core.a.b.d();
        com.igexin.push.core.a.b.k();
        for (c cVar : this.f38121a) {
            if (cVar.c()) {
                cVar.b();
                cVar.a(System.currentTimeMillis());
            }
        }
        a(360000L, TimeUnit.MILLISECONDS);
        com.igexin.c.a.b.e.a().a((Object) this);
    }
}
