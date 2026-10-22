package com.kwad.components.ad.interstitial.h;

import android.content.Context;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.components.ad.interstitial.f.f;
import com.kwad.components.core.webview.tachikoma.f.g;
import com.kwad.sdk.R;
import com.kwad.sdk.api.KsAdVideoPlayConfig;
import com.kwad.sdk.api.KsInterstitialAd;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdResultData;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.as;
import com.kwad.sdk.widget.KSFrameLayout;
import com.kwad.sdk.wrapper.m;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public class c extends a {
    public KsAdVideoPlayConfig ce;
    public KsInterstitialAd.AdInteractionListener ls;
    public com.kwad.components.ad.interstitial.d lx;
    protected AdInfo mAdInfo;

    @NonNull
    public AdResultData mAdResultData;

    @NonNull
    protected AdTemplate mAdTemplate;
    protected com.kwad.components.ad.interstitial.f.c mN;
    private boolean mR;
    private com.kwad.components.ad.interstitial.f.c.a mS;
    private g mU;
    private int nb;

    @Nullable
    protected com.kwad.components.ad.interstitial.f.b oA;
    private boolean oB;
    public ViewGroup oC;

    public c(@NonNull Context context) {
        this(context, null);
    }

    public static /* synthetic */ boolean a(c cVar, boolean z) {
        cVar.oB = false;
        return false;
    }

    private com.kwad.components.ad.interstitial.f.c ff() {
        com.kwad.components.ad.interstitial.f.c cVar = new com.kwad.components.ad.interstitial.f.c();
        cVar.a(this.mAdResultData);
        cVar.setAdTemplate(this.mAdTemplate);
        cVar.ls = this.ls;
        cVar.lx = this.lx;
        cVar.mApkDownloadHelper = new com.kwad.components.core.e.d.d(this.mAdTemplate);
        cVar.ce = this.ce;
        cVar.cB = new com.kwad.sdk.core.video.videoview.a(this.mContext);
        KSFrameLayout kSFrameLayout = (KSFrameLayout) this.oC.findViewById(R.id.ksad_container);
        cVar.gp = kSFrameLayout;
        com.kwad.components.ad.interstitial.g.b bVar = new com.kwad.components.ad.interstitial.g.b(kSFrameLayout, com.kwad.sdk.core.config.e.Jx());
        cVar.lq = bVar;
        bVar.Aa();
        cVar.nb = this.nb;
        cVar.mR = this.mR;
        cVar.mS = this.mS;
        cVar.mU = this.mU;
        cVar.mO = a(this.mContext, com.kwad.sdk.core.response.helper.e.eO(this.mAdTemplate), cVar);
        return cVar;
    }

    @Override // com.kwad.components.ad.interstitial.h.a
    public final void dH() {
        com.kwad.components.ad.interstitial.f.b bVar = this.oA;
        if (bVar != null) {
            bVar.dY();
        }
    }

    @Override // com.kwad.components.ad.interstitial.h.a
    public final void dI() {
        com.kwad.components.ad.interstitial.f.b bVar = this.oA;
        if (bVar != null) {
            bVar.dZ();
        }
    }

    @NonNull
    public final com.kwad.components.ad.interstitial.f.b fg() {
        com.kwad.components.ad.interstitial.f.b bVar = new com.kwad.components.ad.interstitial.f.b();
        if (this.oB) {
            bVar.a(new com.kwad.components.ad.interstitial.f.a.b());
        } else {
            if (com.kwad.sdk.core.response.helper.a.bi(this.mAdInfo)) {
                bVar.a(new f());
            }
            bVar.a(new com.kwad.components.ad.interstitial.f.g());
            bVar.a(new com.kwad.components.ad.interstitial.f.d());
            if (com.kwad.sdk.core.response.helper.a.aV(this.mAdInfo)) {
                bVar.a(new com.kwad.components.ad.interstitial.f.a());
            }
            if (this.mN.M(getContext())) {
                bVar.a(new com.kwad.components.ad.interstitial.f.e());
            }
            try {
                if (this.lx.mStartRenderTime > 0) {
                    com.kwad.sdk.commercial.convert.d.b(com.kwad.sdk.core.response.helper.e.eI(this.mN.mAdTemplate), 1, SystemClock.elapsedRealtime() - this.lx.mStartRenderTime);
                }
            } catch (Throwable th) {
                ServiceProvider.reportSdkCaughtException(th);
            }
        }
        return bVar;
    }

    public final void fh() {
        com.kwad.components.ad.interstitial.f.c cVar = this.mN;
        if (cVar == null || !cVar.mZ) {
            return;
        }
        cVar.ea();
    }

    public final void fi() {
        com.kwad.components.ad.interstitial.f.c cVar = this.mN;
        if (cVar != null) {
            if (this.oB || cVar.mZ) {
                cVar.eb();
            }
        }
    }

    public final void fj() {
        if (this.mN != null) {
            this.mN.a(new com.kwad.components.ad.interstitial.f.c.C1150c(this.mContext).l(true).X(1).n(true).W(2));
        }
    }

    public final boolean fk() {
        com.kwad.components.ad.interstitial.f.c cVar = this.mN;
        if (cVar != null) {
            return cVar.na;
        }
        return false;
    }

    public int getLayoutId() {
        return R.layout.ksad_interstitial;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        com.kwad.components.ad.interstitial.f.c cVar = this.mN;
        if (cVar != null) {
            cVar.release();
        }
        com.kwad.components.ad.interstitial.f.b bVar = this.oA;
        if (bVar != null) {
            bVar.destroy();
        }
    }

    public void setAdAggregateClickActionListener(com.kwad.components.ad.interstitial.f.c.a aVar) {
        this.mS = aVar;
        com.kwad.components.ad.interstitial.f.c cVar = this.mN;
        if (cVar != null) {
            cVar.mS = aVar;
        }
    }

    @Override // com.kwad.components.ad.interstitial.h.a
    public void setAdInteractionListener(KsInterstitialAd.AdInteractionListener adInteractionListener) {
        this.ls = adInteractionListener;
        com.kwad.components.ad.interstitial.f.c cVar = this.mN;
        if (cVar != null) {
            cVar.ls = adInteractionListener;
        }
    }

    public void setAggregateAdView(boolean z) {
        this.mR = z;
        com.kwad.components.ad.interstitial.f.c cVar = this.mN;
        if (cVar != null) {
            cVar.mR = z;
        }
    }

    public void setAggregateShowTriggerType(int i) {
        this.nb = i;
        com.kwad.components.ad.interstitial.f.c cVar = this.mN;
        if (cVar != null) {
            cVar.nb = i;
        }
    }

    public void setTkLoadListenerAdapter(g gVar) {
        this.mU = gVar;
    }

    public c(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.nb = -1;
        this.mU = new g() { // from class: com.kwad.components.ad.interstitial.h.c.1
            @Override // com.kwad.components.core.webview.tachikoma.f.g
            public final void a(String str, long j, long j2, long j3) {
                c cVar = c.this;
                com.kwad.components.ad.interstitial.f.c cVar2 = cVar.mN;
                cVar2.na = true;
                try {
                    if (cVar.lx.mStartRenderTime > 0) {
                        com.kwad.sdk.commercial.convert.d.b(com.kwad.sdk.core.response.helper.e.eI(cVar2.mAdTemplate), 2, SystemClock.elapsedRealtime() - c.this.lx.mStartRenderTime);
                    }
                } catch (Throwable th) {
                    ServiceProvider.reportSdkCaughtException(th);
                }
            }

            @Override // com.kwad.components.core.webview.tachikoma.f.b
            public final void x(String str) {
                if ("tk_interstitial".equals(str)) {
                    c.a(c.this, false);
                    com.kwad.components.ad.interstitial.f.b bVar = c.this.oA;
                    if (bVar != null) {
                        bVar.oe();
                    }
                    c cVar = c.this;
                    cVar.oA = cVar.fg();
                    c cVar2 = c.this;
                    cVar2.oA.N(cVar2.oC);
                    c cVar3 = c.this;
                    cVar3.oA.q(cVar3.mN);
                }
            }
        };
        this.oC = (ViewGroup) m.inflate(context, getLayoutId(), this);
    }

    private d a(Context context, AdInfo adInfo, com.kwad.components.ad.interstitial.f.c cVar) {
        boolean zA = com.kwad.components.ad.interstitial.f.c.a(this.mContext, adInfo);
        d.a aVar = new d.a();
        aVar.w(zA);
        boolean z = true;
        aVar.x(!cVar.M(context) && com.kwad.components.ad.interstitial.b.b.dP());
        aVar.ac(com.kwad.components.ad.interstitial.b.b.dQ());
        if (com.kwad.sdk.core.response.helper.a.bc(adInfo) && as.VM()) {
            z = false;
        }
        aVar.y(z);
        return new d(context, aVar);
    }

    @Override // com.kwad.components.ad.interstitial.h.a
    public final void a(@NonNull AdResultData adResultData, com.kwad.components.ad.interstitial.d dVar, @NonNull KsAdVideoPlayConfig ksAdVideoPlayConfig, KsInterstitialAd.AdInteractionListener adInteractionListener, int i) {
        a(adResultData, i);
        AdTemplate adTemplate = this.mAdTemplate;
        adTemplate.realShowType = 2;
        this.ce = ksAdVideoPlayConfig;
        this.lx = dVar;
        this.oB = com.kwad.sdk.core.response.helper.b.dJ(adTemplate);
        this.ls = adInteractionListener;
        this.mN = ff();
        if (this.oA == null) {
            this.oA = fg();
        }
        this.oA.N(this.oC);
        this.oA.q(this.mN);
    }

    @Override // com.kwad.components.ad.interstitial.h.a
    public final void a(@NonNull AdResultData adResultData, com.kwad.components.ad.interstitial.d dVar, @NonNull KsAdVideoPlayConfig ksAdVideoPlayConfig, KsInterstitialAd.AdInteractionListener adInteractionListener, int i, boolean z) {
        a(adResultData, i);
        this.mAdTemplate.realShowType = 2;
        this.ce = ksAdVideoPlayConfig;
        this.lx = dVar;
        this.oB = z;
        this.ls = adInteractionListener;
        this.mN = ff();
        if (this.oA == null) {
            this.oA = fg();
        }
        this.oA.N(this.oC);
        this.oA.q(this.mN);
    }

    public void a(AdResultData adResultData, int i) {
        List<AdTemplate> adTemplateList = adResultData.getAdTemplateList();
        if (adTemplateList != null && i < adTemplateList.size()) {
            this.mAdTemplate = adTemplateList.get(i);
        } else {
            this.mAdTemplate = com.kwad.sdk.core.response.helper.c.r(adResultData);
        }
        this.mAdResultData = com.kwad.sdk.core.response.helper.c.a(adResultData, this.mAdTemplate);
        this.mAdInfo = com.kwad.sdk.core.response.helper.e.eO(this.mAdTemplate);
    }
}
