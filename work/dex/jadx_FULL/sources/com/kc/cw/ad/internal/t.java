package com.kc.cw.ad.internal;

import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class t extends com.kc.cw.ad.internal.c.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f39062a;
    private com.kc.cw.ad.internal.c.d.a b;

    public t(String str) {
        super(true);
        this.f39062a = str;
    }

    public t a(com.kc.cw.ad.internal.c.d.a aVar) {
        this.b = aVar;
        return this;
    }

    @Override // com.kc.cw.ad.internal.c.d
    public String a() {
        return this.f39062a;
    }

    @Override // com.kc.cw.ad.internal.c.d
    public void a(com.kc.cw.ad.internal.c.e eVar) {
        com.kc.cw.ad.internal.c.d.a aVar = this.b;
        if (aVar == null || eVar == null) {
            return;
        }
        aVar.a(eVar.b(), eVar.a(), eVar.d());
    }
}
