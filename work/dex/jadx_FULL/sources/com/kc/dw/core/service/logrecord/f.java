package com.kc.dw.core.service.logrecord;

import com.kc.dw.core.safe.j;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class f extends j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final d f39320a;

    public f(d dVar) {
        this.f39320a = dVar;
    }

    @Override // com.kc.dw.core.safe.j
    public void safeRun() {
        d dVar = this.f39320a;
        dVar.i = null;
        if (!dVar.c() || c.f39315a) {
            return;
        }
        this.f39320a.a(false);
    }
}
