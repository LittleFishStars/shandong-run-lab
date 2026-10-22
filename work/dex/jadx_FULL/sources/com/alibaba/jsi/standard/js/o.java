package com.alibaba.jsi.standard.js;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class o extends w {
    public o(com.alibaba.jsi.standard.b bVar) {
        super(bVar, Bridge.createNative(bVar, 7));
    }

    public boolean a(com.alibaba.jsi.standard.b bVar, int i, w wVar) {
        t();
        return Bridge.cmd(bVar, 101, this.u, (long) i, new Object[]{wVar}) != null;
    }

    public boolean b(com.alibaba.jsi.standard.b bVar, w wVar, w wVar2) {
        t();
        return Bridge.cmd(bVar, 100, this.u, new Object[]{wVar, wVar2}) != null;
    }

    public boolean c(com.alibaba.jsi.standard.b bVar, int i) {
        t();
        return Bridge.cmd(bVar, 107, this.u, (long) i) != null;
    }

    public w d(com.alibaba.jsi.standard.b bVar, w wVar) {
        t();
        Object objCmd = Bridge.cmd(bVar, 102, this.u, new Object[]{wVar});
        if (objCmd != null) {
            return (w) objCmd;
        }
        return null;
    }

    public boolean e(com.alibaba.jsi.standard.b bVar, w wVar) {
        t();
        return Bridge.cmd(bVar, 104, this.u, new Object[]{wVar}) != null;
    }

    @Override // com.alibaba.jsi.standard.js.w
    public o e_() {
        return this;
    }

    public boolean f(com.alibaba.jsi.standard.b bVar, w wVar) {
        t();
        return Bridge.cmd(bVar, 106, this.u, new Object[]{wVar}) != null;
    }

    public boolean g(com.alibaba.jsi.standard.b bVar, String str) {
        t();
        return Bridge.cmd(bVar, 115, this.u, new Object[]{str}) != null;
    }

    public d h(com.alibaba.jsi.standard.b bVar) {
        t();
        Object objCmd = Bridge.cmd(bVar, 110, this.u);
        if (objCmd != null) {
            return (d) objCmd;
        }
        return null;
    }

    public d i(com.alibaba.jsi.standard.b bVar) {
        t();
        Object objCmd = Bridge.cmd(bVar, 111, this.u);
        if (objCmd != null) {
            return (d) objCmd;
        }
        return null;
    }

    public w j(com.alibaba.jsi.standard.b bVar) {
        t();
        Object objCmd = Bridge.cmd(bVar, 116, this.u);
        if (objCmd != null) {
            return (w) objCmd;
        }
        return null;
    }

    public h k(com.alibaba.jsi.standard.b bVar) {
        t();
        Object objCmd = Bridge.cmd(bVar, 119, this.u);
        if (objCmd == null || !(objCmd instanceof h)) {
            return null;
        }
        return (h) objCmd;
    }

    @Override // com.alibaba.jsi.standard.js.w
    public boolean k() {
        return true;
    }

    public boolean l(com.alibaba.jsi.standard.b bVar) {
        t();
        return Bridge.cmd(bVar, 122, this.u) != null;
    }

    public com.alibaba.jsi.standard.c m() {
        t();
        Object objCmd = Bridge.cmd((com.alibaba.jsi.standard.b) null, 118, this.u);
        if (objCmd == null || !(objCmd instanceof Long)) {
            return null;
        }
        return com.alibaba.jsi.standard.c.a(((Long) objCmd).longValue());
    }

    @Override // com.alibaba.jsi.standard.js.w
    public final w n(com.alibaba.jsi.standard.b bVar) {
        return r(bVar);
    }

    @Override // com.alibaba.jsi.standard.js.w
    public final boolean o(com.alibaba.jsi.standard.b bVar) {
        return s(bVar);
    }

    public o(com.alibaba.jsi.standard.b bVar, long j) {
        super(bVar, j);
    }

    public boolean a(com.alibaba.jsi.standard.b bVar, String str, w wVar) {
        return b(bVar, new s(str), wVar);
    }

    public boolean b(com.alibaba.jsi.standard.b bVar, int i) {
        t();
        return Bridge.cmd(bVar, 105, this.u, (long) i) != null;
    }

    public boolean c(com.alibaba.jsi.standard.b bVar, String str) {
        return f(bVar, new s(str));
    }

    public w e(com.alibaba.jsi.standard.b bVar, String str) {
        t();
        Object objCmd = Bridge.cmd(bVar, 113, this.u, new Object[]{str});
        if (objCmd != null) {
            return (w) objCmd;
        }
        return null;
    }

    public boolean f(com.alibaba.jsi.standard.b bVar, String str) {
        t();
        return Bridge.cmd(bVar, 114, this.u, new Object[]{str}) != null;
    }

    public boolean g(com.alibaba.jsi.standard.b bVar, w wVar) {
        t();
        return Bridge.cmd(bVar, 117, this.u, new Object[]{wVar}) != null;
    }

    public w a(com.alibaba.jsi.standard.b bVar, int i) {
        t();
        Object objCmd = Bridge.cmd(bVar, 103, this.u, i);
        if (objCmd != null) {
            return (w) objCmd;
        }
        return null;
    }

    public boolean d(com.alibaba.jsi.standard.b bVar, int i) {
        t();
        return Bridge.cmd(bVar, 109, this.u, (long) i) != null;
    }

    public int h(com.alibaba.jsi.standard.b bVar, w wVar) {
        t();
        Object objCmd = Bridge.cmd(bVar, 120, this.u, new Object[]{wVar});
        if (objCmd == null || !(objCmd instanceof Long)) {
            return 0;
        }
        return ((Long) objCmd).intValue();
    }

    public boolean b(com.alibaba.jsi.standard.b bVar, String str) {
        return e(bVar, new s(str));
    }

    @Override // com.alibaba.jsi.standard.js.w
    public z m(com.alibaba.jsi.standard.b bVar) {
        return q(bVar);
    }

    public boolean b(com.alibaba.jsi.standard.b bVar, String str, w wVar) {
        t();
        return Bridge.cmd(bVar, 112, this.u, new Object[]{str, wVar}) != null;
    }

    public boolean d(com.alibaba.jsi.standard.b bVar, String str) {
        return a(bVar, new s(str));
    }

    public boolean e(com.alibaba.jsi.standard.b bVar, int i) {
        t();
        return Bridge.cmd(bVar, 121, this.u, (long) i) != null;
    }

    public w a(com.alibaba.jsi.standard.b bVar, String str) {
        return d(bVar, new s(str));
    }

    public boolean a(com.alibaba.jsi.standard.b bVar, l lVar) {
        t();
        return Bridge.cmd(bVar, 108, this.u, new Object[]{lVar}) != null;
    }
}
