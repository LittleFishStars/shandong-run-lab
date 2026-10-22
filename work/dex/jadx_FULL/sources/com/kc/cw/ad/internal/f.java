package com.kc.cw.ad.internal;

import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.kc.cw.ad.NativeAdResponse;
import com.kc.openset.R;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.lang.ref.SoftReference;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
class f extends s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final SoftReference<com.kc.cw.ad.internal.e.a> f39033a;
    private com.kc.cw.ad.internal.b.a b;
    private String c;

    public f(com.kc.cw.ad.internal.e.a aVar, String str) {
        com.kc.cw.ad.d.b.f.c("OctopusAd_Time", "AdViewRequestManagerImpl 开始");
        this.f39033a = new SoftReference<>(aVar);
        this.c = str;
    }

    private void a(com.kc.cw.ad.internal.e.a aVar, com.kc.cw.ad.internal.b.f fVar) {
        try {
            aVar.f38976a = fVar;
            boolean z = false;
            aVar.getAdParameters().a(false);
            a(new com.kc.cw.ad.internal.b.b(this, aVar, fVar) { // from class: com.kc.cw.ad.internal.f.1

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                final com.kc.cw.ad.internal.e.a f39034a;
                final com.kc.cw.ad.internal.b.f b;
                final f c;

                {
                    this.c = this;
                    this.f39034a = aVar;
                    this.b = fVar;
                }

                @Override // com.kc.cw.ad.internal.b.b
                public p a() {
                    return this.f39034a.getMediaType();
                }

                @Override // com.kc.cw.ad.internal.b.b
                public NativeAdResponse b() {
                    return null;
                }

                @Override // com.kc.cw.ad.internal.b.b
                public int c() {
                    return this.b.q();
                }

                @Override // com.kc.cw.ad.internal.b.b
                public String d() {
                    return this.b.s();
                }

                @Override // com.kc.cw.ad.internal.b.b
                public long e() {
                    return this.b.t();
                }
            });
            com.kc.cw.ad.internal.e.b bVar = new com.kc.cw.ad.internal.e.b(aVar);
            bVar.a(fVar);
            if (fVar.a() != null && fVar.a().i() != null) {
                aVar.a(fVar.a().i(), fVar.p() > 0 ? fVar.p() / 640.0f : 1.0f);
                z = true;
            }
            if (z) {
                aVar.a(fVar.an(), fVar.p());
            } else {
                aVar.a(fVar.am(), fVar.an(), fVar.p());
            }
            com.kc.cw.ad.internal.e.b bVarC = bVar;
            if (aVar.getMediaType() != p.INTERSTITIAL && aVar.getMediaType() != p.FULLSCREEN) {
                if (aVar.getMediaType() == p.REWARD) {
                    bVarC = bVar;
                    bVarC = bVar;
                } else {
                    bVarC = bVar;
                    bVarC = bVar.c();
                }
            }
            bVarC = bVar;
            aVar.getAdDispatcher().a(bVarC);
        } catch (Exception e) {
            com.kc.cw.ad.d.b.f.a("OctopusAd", "An Exception Caught", e);
            com.kc.cw.ad.internal.c.f.e(com.kc.cw.ad.internal.c.f.f38946a, "Exception initializing the view: " + e.getMessage());
            a(MediationConstant.ErrorCode.ADN_AD_LOAD_FAIL);
        }
    }

    @Override // com.kc.cw.ad.internal.e
    public void a() {
        com.kc.cw.ad.internal.e.a aVar = this.f39033a.get();
        if (aVar == null || d() == null) {
            com.kc.cw.ad.internal.c.f.e(com.kc.cw.ad.internal.c.f.f38946a, "Before execute request manager, you should set ad request!");
            return;
        }
        try {
            if (q.a().c()) {
                aVar.getAdDispatcher().a(MediationConstant.ErrorCode.ADN_AD_SHOW_ERROR);
                return;
            }
            this.b = new com.kc.cw.ad.internal.b.a(d());
            com.kc.cw.ad.d.b.f.c("OctopusAd_Time", "new AdRequestImpl");
            e();
            this.b.a(this);
            this.b.a(this.c);
            aVar.getAdDispatcher().c();
        } catch (Exception e) {
            com.kc.cw.ad.d.b.f.a("OctopusAd", "An Exception Caught", e);
        }
    }

    @Override // com.kc.cw.ad.internal.e
    public void a(int i) {
        f();
        com.kc.cw.ad.internal.e.a aVar = this.f39033a.get();
        if (aVar == null || aVar.getAdDispatcher() == null) {
            return;
        }
        com.kc.cw.ad.d.b.f.c("OctopusAd_Time", "send onAdFailedToLoad");
        aVar.getAdDispatcher().a(i);
    }

    public void a(com.kc.cw.ad.internal.b.b bVar) {
        f();
        com.kc.cw.ad.internal.e.a aVar = this.f39033a.get();
        if (aVar != null) {
            aVar.getAdDispatcher().a(bVar);
        }
    }

    @Override // com.kc.cw.ad.internal.e
    public void a(com.kc.cw.ad.internal.b.f fVar) {
        com.kc.cw.ad.internal.e.a aVar = this.f39033a.get();
        if (aVar != null) {
            if (fVar != null && fVar.u()) {
                com.kc.cw.ad.d.b.f.c("OctopusAd_Time", "handleStandardAds");
                a(aVar, fVar);
            } else {
                com.kc.cw.ad.internal.c.f.d(com.kc.cw.ad.internal.c.f.e, com.kc.cw.ad.internal.c.f.a(R.string.response_no_ads));
                if (aVar.getAdDispatcher() != null) {
                    aVar.getAdDispatcher().a(80100);
                }
            }
        }
    }

    @Override // com.kc.cw.ad.internal.e
    public d b() {
        com.kc.cw.ad.internal.e.a aVar = this.f39033a.get();
        if (aVar != null) {
            return aVar.getAdParameters();
        }
        return null;
    }

    @Override // com.kc.cw.ad.internal.s
    public void c() {
        if (this.b != null) {
            this.b = null;
        }
    }

    public com.kc.cw.ad.internal.b.a.C1001a d() {
        if (this.f39033a.get() != null) {
            return this.f39033a.get().getAdRequest();
        }
        return null;
    }
}
