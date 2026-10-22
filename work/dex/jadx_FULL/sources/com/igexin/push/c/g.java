package com.igexin.push.c;

import android.text.TextUtils;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class g extends h implements i {
    private static g e;

    private g() {
        super(com.igexin.push.core.e.ap, com.igexin.push.core.e.ar);
        this.d.j = false;
    }

    public static synchronized g a() {
        if (e == null) {
            e = new g();
        }
        return e;
    }

    @Override // com.igexin.push.c.i
    public final void a(int i, d dVar) {
        e eVarA;
        if (dVar == null || TextUtils.isEmpty(dVar.a()) || (eVarA = a(dVar.a())) == null) {
            return;
        }
        a(dVar);
        eVarA.a();
        m();
        if (i == b.a.f37887a) {
            l();
        }
    }

    @Override // com.igexin.push.c.i
    public final void b() {
    }

    @Override // com.igexin.push.c.h
    public final int c() {
        return b.EnumC0851b.b;
    }

    @Override // com.igexin.push.c.h
    public final i d() {
        return this;
    }
}
