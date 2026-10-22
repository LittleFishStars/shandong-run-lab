package com.kc.cw.ad.internal;

import android.content.Context;
import android.text.TextUtils;
import com.kc.cw.ad.utils.ThreadUtils;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class m extends com.kc.cw.ad.internal.c.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f39045a;

    public m(String str) {
        super(true);
        this.f39045a = str;
    }

    @Override // com.kc.cw.ad.internal.c.d
    public String a() {
        return this.f39045a;
    }

    @Override // com.kc.cw.ad.internal.c.d
    public void a(com.kc.cw.ad.internal.c.e eVar) {
        Context contextL = q.a().l();
        if (eVar != null && !TextUtils.isEmpty(eVar.d())) {
            try {
                if (!"{}".equals(eVar.d())) {
                    com.kc.cw.ad.internal.c.o.a(contextL, "responseBody", eVar.d());
                }
                com.kc.cw.ad.internal.c.o.a(contextL, "lastReqTime", Long.valueOf(com.kc.cw.ad.d.b.i.d()));
            } catch (Exception e) {
                com.kc.cw.ad.d.b.f.a("OctopusAd", "An Exception Caught", e);
            }
        }
        ThreadUtils.runOnThreadPool(new com.kc.cw.ad.d.b.b(contextL));
    }
}
