package com.kc.dw.core.utils;

import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class w1 extends com.kc.dw.core.safe.j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.kc.dw.core.bquery.e f39415a;

    public w1(com.kc.dw.core.bquery.e eVar) {
        this.f39415a = eVar;
    }

    @Override // com.kc.dw.core.safe.j
    public void safeRun() {
        x1.a aVar;
        com.kc.dw.core.bquery.e eVar = this.f39415a;
        if (eVar == null || (aVar = ((u1) eVar).f39410a) == null) {
            return;
        }
        aVar.onStartDownload();
    }
}
