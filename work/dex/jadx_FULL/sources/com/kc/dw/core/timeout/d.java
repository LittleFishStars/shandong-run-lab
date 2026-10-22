package com.kc.dw.core.timeout;

import com.kc.dw.core.safe.j;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class d extends j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f39333a;
    public final String b;
    public final c c;

    public d(c cVar, int i, String str) {
        this.c = cVar;
        this.f39333a = i;
        this.b = str;
    }

    @Override // com.kc.dw.core.safe.j
    public void safeRun() {
        this.c.b(this.f39333a, this.b);
    }
}
