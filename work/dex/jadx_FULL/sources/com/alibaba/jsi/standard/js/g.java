package com.alibaba.jsi.standard.js;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class g extends o {
    public g(com.alibaba.jsi.standard.b bVar, boolean z) {
        super(bVar, Bridge.createNative(bVar, 15, z ? 1L : 0L));
    }

    public boolean c(com.alibaba.jsi.standard.b bVar) {
        t();
        Object objCmd = Bridge.cmd(bVar, 301, this.u);
        if (objCmd == null || !(objCmd instanceof f)) {
            return false;
        }
        return ((f) objCmd).b_();
    }

    @Override // com.alibaba.jsi.standard.js.w
    public boolean e() {
        return true;
    }

    public g(com.alibaba.jsi.standard.b bVar, long j) {
        super(bVar, j);
    }
}
