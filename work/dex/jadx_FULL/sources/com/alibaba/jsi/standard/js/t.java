package com.alibaba.jsi.standard.js;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class t extends o {
    public t(com.alibaba.jsi.standard.b bVar, s sVar) {
        super(bVar, Bridge.createNative(bVar, 17, new Object[]{sVar}));
    }

    public String c(com.alibaba.jsi.standard.b bVar) {
        t();
        Object objCmd = Bridge.cmd(bVar, 302, this.u);
        if (objCmd == null || !(objCmd instanceof s)) {
            return null;
        }
        return ((s) objCmd).f_();
    }

    @Override // com.alibaba.jsi.standard.js.w
    public boolean q() {
        return true;
    }

    public t(com.alibaba.jsi.standard.b bVar, long j) {
        super(bVar, j);
    }
}
