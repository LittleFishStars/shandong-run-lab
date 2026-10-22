package com.kc.cw.ad.internal.b;

import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.kc.cw.ad.NativeAdResponse;
import com.kc.cw.ad.internal.p;
import com.kc.cw.ad.internal.q;
import com.kc.cw.ad.internal.s;
import com.kc.openset.R;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.lang.ref.SoftReference;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class d extends s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final SoftReference<c> f38874a;
    private String b;

    public d(c cVar, String str) {
        this.f38874a = new SoftReference<>(cVar);
        this.b = str;
    }

    @Override // com.kc.cw.ad.internal.e
    public void a() {
        c cVar = this.f38874a.get();
        if (cVar == null) {
            com.kc.cw.ad.internal.c.f.e(com.kc.cw.ad.internal.c.f.f38946a, "Before execute request manager, you should set ad request!");
            return;
        }
        try {
            if (q.a().c()) {
                cVar.l().a(MediationConstant.ErrorCode.ADN_AD_SHOW_ERROR);
                return;
            }
            e();
            cVar.a(this);
            cVar.a(this.b);
        } catch (Exception e) {
            com.kc.cw.ad.d.b.f.a("OctopusAd", "An Exception Caught", e);
        }
    }

    @Override // com.kc.cw.ad.internal.e
    public void a(int i) {
        f();
        c cVar = this.f38874a.get();
        if (cVar != null) {
            cVar.l().a(i);
        }
    }

    public void a(b bVar) {
        f();
        c cVar = this.f38874a.get();
        if (cVar != null) {
            cVar.l().a(bVar);
        }
    }

    @Override // com.kc.cw.ad.internal.e
    public void a(f fVar) {
        c cVar = this.f38874a.get();
        if (cVar != null) {
            if (!fVar.u()) {
                com.kc.cw.ad.internal.c.f.d(com.kc.cw.ad.internal.c.f.e, com.kc.cw.ad.internal.c.f.a(R.string.response_no_ads));
                cVar.l().a(80100);
                return;
            }
            e eVar = (e) fVar.l();
            if (eVar == null) {
                return;
            }
            eVar.f(cVar.c());
            a(new b(this, cVar, eVar, fVar) { // from class: com.kc.cw.ad.internal.b.d.1

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                final c f38875a;
                final e b;
                final f c;
                final d d;

                {
                    this.d = this;
                    this.f38875a = cVar;
                    this.b = eVar;
                    this.c = fVar;
                }

                @Override // com.kc.cw.ad.internal.b.b
                public p a() {
                    return this.f38875a.getMediaType();
                }

                @Override // com.kc.cw.ad.internal.b.b
                public NativeAdResponse b() {
                    return this.b;
                }

                @Override // com.kc.cw.ad.internal.b.b
                public int c() {
                    return this.c.q();
                }

                @Override // com.kc.cw.ad.internal.b.b
                public String d() {
                    return this.c.s();
                }

                @Override // com.kc.cw.ad.internal.b.b
                public long e() {
                    return this.c.t();
                }
            });
        }
    }

    @Override // com.kc.cw.ad.internal.e
    public com.kc.cw.ad.internal.d b() {
        c cVar = this.f38874a.get();
        if (cVar != null) {
            return cVar.j();
        }
        return null;
    }

    @Override // com.kc.cw.ad.internal.s
    public void c() {
    }
}
