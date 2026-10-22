package com.igexin.push.core.i.a;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class f extends b<e> implements l {
    public f(e eVar) {
        super(eVar);
    }

    @Override // com.igexin.push.core.i.a.b, com.igexin.push.core.i.a.l
    public final void b() {
        ((e) this.f38058a).a().prepareToDraw();
    }

    @Override // com.igexin.push.core.i.a.m
    public final Class<e> d() {
        return e.class;
    }

    @Override // com.igexin.push.core.i.a.m
    public final int e() {
        h hVar = ((e) this.f38058a).c.f38062a;
        return hVar.f38064a.m() + hVar.j;
    }

    @Override // com.igexin.push.core.i.a.m
    public final void f() {
        ((e) this.f38058a).stop();
        e eVar = (e) this.f38058a;
        eVar.e = true;
        h hVar = eVar.c.f38062a;
        hVar.b.clear();
        hVar.b();
        hVar.c = false;
        if (hVar.e != null) {
            hVar.e = null;
        }
        if (hVar.g != null) {
            hVar.g = null;
        }
        if (hVar.i != null) {
            hVar.i = null;
        }
        hVar.f38064a.o();
        hVar.f = true;
    }
}
