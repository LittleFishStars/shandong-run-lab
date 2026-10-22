package com.alibaba.jsi.standard.js;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class d extends o {
    public d(com.alibaba.jsi.standard.b bVar) {
        super(bVar, Bridge.createNative(bVar, 8));
    }

    public int a(com.alibaba.jsi.standard.b bVar) {
        t();
        Object objCmd = Bridge.cmd(bVar, 200, this.u);
        if (objCmd == null || !(objCmd instanceof Long)) {
            return 0;
        }
        return ((Long) objCmd).intValue();
    }

    @Override // com.alibaba.jsi.standard.js.w
    public boolean b() {
        return true;
    }

    public d(com.alibaba.jsi.standard.b bVar, int i) {
        super(bVar, Bridge.createNative(bVar, 8, i));
    }

    public d(com.alibaba.jsi.standard.b bVar, long j) {
        super(bVar, j);
    }
}
