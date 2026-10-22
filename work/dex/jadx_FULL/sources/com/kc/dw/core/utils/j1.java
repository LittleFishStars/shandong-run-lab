package com.kc.dw.core.utils;

import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class j1 extends com.kc.dw.core.safe.j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.kc.dw.cache.d f39377a;
    public final byte[] b;

    public j1(com.kc.dw.cache.d dVar, byte[] bArr) {
        this.f39377a = dVar;
        this.b = bArr;
    }

    @Override // com.kc.dw.core.safe.j
    public void safeRun() {
        super.safeRun();
        this.f39377a.a(null, this.b, true);
    }
}
