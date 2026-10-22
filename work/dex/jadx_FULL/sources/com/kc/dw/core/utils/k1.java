package com.kc.dw.core.utils;

import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class k1 extends com.kc.dw.core.safe.j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final byte[] f39379a;
    public final String b;
    public final com.kc.dw.cache.d c;

    public k1(byte[] bArr, String str, com.kc.dw.cache.d dVar) {
        this.f39379a = bArr;
        this.b = str;
        this.c = dVar;
    }

    @Override // com.kc.dw.core.safe.j
    public void safeRun() {
        super.safeRun();
        byte[] bArr = this.f39379a;
        if (bArr == null || bArr.length <= 0 || !i.a(bArr, this.b)) {
            this.c.b(4);
        } else {
            this.c.a(null, this.f39379a, true);
        }
    }
}
