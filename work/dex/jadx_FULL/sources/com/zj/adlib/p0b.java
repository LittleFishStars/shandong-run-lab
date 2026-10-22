package com.zj.adlib;

import com.amap.api.col.p0003l.ea;
import com.amap.api.col.p0003l.r;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public final class p0b implements ea {
    @Override // com.amap.api.col.p0003l.ea
    public final void a(int i, String str, String str2) {
        if (i == 0) {
            r.c(zwa.t()).i(m6b.b(str, str2));
        } else {
            r.c(zwa.t()).i(m6b.f(str, str2));
        }
    }

    @Override // com.amap.api.col.p0003l.ea
    public final void a() {
        try {
            r.c(zwa.t()).e();
        } catch (Throwable unused) {
        }
    }
}
