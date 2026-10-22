package com.kc.cw.ad.internal.e;

import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class d implements e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final long f39027a;
    private final c b;
    private final boolean c;

    public d(c cVar, Long l, boolean z) {
        this.f39027a = l.longValue();
        this.b = cVar;
        this.c = z;
    }

    @Override // com.kc.cw.ad.internal.e.e
    public long a() {
        return this.f39027a;
    }

    @Override // com.kc.cw.ad.internal.e.e
    public boolean b() {
        return this.c;
    }

    @Override // com.kc.cw.ad.internal.e.e
    public b c() {
        c cVar = this.b;
        if (cVar == null) {
            return null;
        }
        return cVar.getAdWebView();
    }
}
