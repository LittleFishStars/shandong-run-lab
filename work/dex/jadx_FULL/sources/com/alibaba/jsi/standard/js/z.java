package com.alibaba.jsi.standard.js;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class z implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private com.alibaba.jsi.standard.b f24591a;
    private w b;

    public z(com.alibaba.jsi.standard.b bVar, w wVar, boolean z) {
        this.f24591a = bVar;
        this.b = wVar;
        if (z) {
            com.alibaba.jsi.standard.d.a(bVar, this);
        }
    }

    public w a(com.alibaba.jsi.standard.b bVar) {
        w wVar = this.b;
        if (wVar != null) {
            return wVar.n(bVar);
        }
        return null;
    }

    public boolean b(com.alibaba.jsi.standard.b bVar) {
        w wVar = this.b;
        if (wVar != null) {
            return wVar.o(bVar);
        }
        return true;
    }

    @Override // com.alibaba.jsi.standard.js.b
    public void a() {
        com.alibaba.jsi.standard.d.b(this.f24591a, this);
        w wVar = this.b;
        if (wVar != null) {
            wVar.a();
        }
    }
}
