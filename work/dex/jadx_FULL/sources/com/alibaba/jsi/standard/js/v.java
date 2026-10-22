package com.alibaba.jsi.standard.js;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class v extends o {
    public v(com.alibaba.jsi.standard.b bVar, u uVar) {
        super(bVar, Bridge.createNative(bVar, 18, new Object[]{uVar}));
    }

    public u c(com.alibaba.jsi.standard.b bVar) {
        t();
        Object objCmd = Bridge.cmd(bVar, 303, this.u);
        if (objCmd == null || !(objCmd instanceof u)) {
            return null;
        }
        return (u) objCmd;
    }

    @Override // com.alibaba.jsi.standard.js.w
    public boolean s() {
        return true;
    }

    public v(com.alibaba.jsi.standard.b bVar, long j) {
        super(bVar, j);
    }
}
