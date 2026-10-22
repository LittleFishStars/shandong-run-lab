package com.kc.dw.ad.view;

import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class c extends com.kc.dw.core.safe.j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f39189a;
    public final int b;
    public final a c;

    public c(a aVar, int i, int i2) {
        this.c = aVar;
        this.f39189a = i;
        this.b = i2;
    }

    @Override // com.kc.dw.core.safe.j
    public void safeRun() {
        super.safeRun();
        a aVar = this.c;
        StringBuilder sbA = com.kc.dw.activity.a.a("media player error. what:");
        sbA.append(this.f39189a);
        sbA.append(",extra:");
        sbA.append(this.b);
        aVar.b(3, sbA.toString());
    }
}
