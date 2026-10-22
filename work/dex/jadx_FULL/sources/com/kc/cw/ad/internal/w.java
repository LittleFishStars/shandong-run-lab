package com.kc.cw.ad.internal;

import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.util.concurrent.RejectedExecutionException;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class w extends s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private com.kc.cw.ad.internal.b.a f39067a;
    private final d b;
    private String c;

    public w(String str) {
        d dVar = new d(q.a().l(), com.kc.cw.ad.internal.c.p.a());
        this.b = dVar;
        dVar.a(p.SPLASH);
        dVar.b(str);
    }

    @Override // com.kc.cw.ad.internal.e
    public void a() {
        String str;
        StringBuilder sb;
        String str2;
        this.f39067a = new com.kc.cw.ad.internal.b.a(new com.kc.cw.ad.internal.b.a.C1001a());
        e();
        try {
            this.f39067a.a(this);
            this.c = this.f39067a.a(this.b, true);
        } catch (RejectedExecutionException e) {
            e = e;
            str = com.kc.cw.ad.internal.c.f.f38946a;
            sb = new StringBuilder();
            str2 = "Concurrent Thread Exception while firing new ad request: ";
            sb.append(str2);
            sb.append(e.getMessage());
            com.kc.cw.ad.internal.c.f.e(str, sb.toString());
        } catch (Exception e2) {
            e = e2;
            str = com.kc.cw.ad.internal.c.f.f38946a;
            sb = new StringBuilder();
            str2 = "Exception while firing new ad request: ";
            sb.append(str2);
            sb.append(e.getMessage());
            com.kc.cw.ad.internal.c.f.e(str, sb.toString());
        }
    }

    @Override // com.kc.cw.ad.internal.e
    public void a(int i) {
        com.kc.cw.ad.internal.c.f.b(com.kc.cw.ad.internal.c.f.f, "Failed to load prefetch request: " + i);
    }

    @Override // com.kc.cw.ad.internal.e
    public void a(com.kc.cw.ad.internal.b.f fVar) {
        for (String str : fVar.ae()) {
            com.kc.cw.ad.internal.c.f.b(com.kc.cw.ad.internal.c.f.f38946a, "Prefetch resource: " + str);
        }
    }

    @Override // com.kc.cw.ad.internal.e
    public d b() {
        return this.b;
    }

    @Override // com.kc.cw.ad.internal.s
    public void c() {
        if (this.f39067a != null) {
            this.f39067a = null;
        }
    }

    public String d() {
        return this.c;
    }
}
