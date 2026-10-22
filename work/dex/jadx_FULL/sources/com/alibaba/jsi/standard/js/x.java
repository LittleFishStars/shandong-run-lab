package com.alibaba.jsi.standard.js;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class x implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    long f24589a;

    public x(Long l) {
        long jLongValue = l.longValue();
        this.f24589a = jLongValue;
        if (jLongValue != 0) {
            com.alibaba.jsi.standard.d.a(this);
        }
    }

    @Override // com.alibaba.jsi.standard.js.b
    public void a() {
        long j = this.f24589a;
        if (j != 0) {
            Bridge.cmd((com.alibaba.jsi.standard.b) null, 752, j);
            this.f24589a = 0L;
            com.alibaba.jsi.standard.d.b(this);
        }
    }

    public w a(com.alibaba.jsi.standard.b bVar) {
        Object objCmd = Bridge.cmd(bVar, 751, this.f24589a);
        if (objCmd == null || !(objCmd instanceof w)) {
            return null;
        }
        return (w) objCmd;
    }
}
