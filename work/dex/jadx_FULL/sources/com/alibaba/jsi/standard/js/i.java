package com.alibaba.jsi.standard.js;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class i implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    com.alibaba.jsi.standard.b f24582a;
    long b;
    private boolean c = false;

    public i(com.alibaba.jsi.standard.b bVar, String str) {
        this.f24582a = bVar;
        this.b = Bridge.createNative(bVar, 21, new Object[]{str});
        com.alibaba.jsi.standard.d.a(this.f24582a, this);
    }

    private void b() {
        if (this.c) {
            throw new RuntimeException("JSException has been deleted: " + this);
        }
    }

    @Override // com.alibaba.jsi.standard.js.b
    public void a() {
        long j = this.b;
        if (j != 0 && !this.c) {
            Bridge.nativeDelete(j, 4);
            this.b = 0L;
            com.alibaba.jsi.standard.d.b(this.f24582a, this);
        }
        this.c = true;
    }

    public String c(com.alibaba.jsi.standard.b bVar) {
        b();
        Object objCmd = Bridge.cmd(bVar, 602, this.b);
        if (objCmd == null || !(objCmd instanceof String)) {
            return null;
        }
        return (String) objCmd;
    }

    public String d(com.alibaba.jsi.standard.b bVar) {
        b();
        Object objCmd = Bridge.cmd(bVar, 603, this.b);
        if (objCmd == null || !(objCmd instanceof String)) {
            return null;
        }
        return (String) objCmd;
    }

    public w e(com.alibaba.jsi.standard.b bVar) {
        b();
        Object objCmd = Bridge.cmd(bVar, 604, this.b);
        if (objCmd == null || !(objCmd instanceof w)) {
            return null;
        }
        return (w) objCmd;
    }

    public String b(com.alibaba.jsi.standard.b bVar) {
        b();
        Object objCmd = Bridge.cmd(bVar, 601, this.b);
        if (objCmd == null || !(objCmd instanceof String)) {
            return null;
        }
        return (String) objCmd;
    }

    public i(com.alibaba.jsi.standard.b bVar, long j) {
        this.f24582a = bVar;
        this.b = j;
        com.alibaba.jsi.standard.d.a(bVar, this);
    }

    public String a(com.alibaba.jsi.standard.b bVar) {
        b();
        Object objCmd = Bridge.cmd(bVar, 600, this.b);
        if (objCmd == null || !(objCmd instanceof String)) {
            return null;
        }
        return (String) objCmd;
    }
}
