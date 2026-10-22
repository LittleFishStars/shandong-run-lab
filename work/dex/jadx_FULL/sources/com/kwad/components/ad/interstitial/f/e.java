package com.kwad.components.ad.interstitial.f;

import androidx.annotation.Nullable;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.by;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public final class e extends b implements com.kwad.components.core.video.a.c {
    private static long nF = 1000;
    private AdTemplate mAdTemplate;
    private c mN;

    @Nullable
    private a nG;
    private int nH;

    /* JADX INFO: Access modifiers changed from: private */
    public void aa(int i) {
        c cVar = this.mN;
        com.kwad.components.ad.interstitial.h.d dVar = cVar.mO;
        if (dVar == null) {
            return;
        }
        if (i != 0) {
            dVar.b(true, i);
        } else {
            if (cVar.ec()) {
                return;
            }
            this.mN.c(getContext(), this.mAdTemplate);
            eC();
            c cVar2 = this.mN;
            cVar2.a(true, -1, cVar2.cB);
        }
    }

    private void eC() {
        com.kwad.sdk.core.video.videoview.a aVar = this.mN.cB;
        if (aVar != null) {
            aVar.release();
        }
        this.mN.lx.dismiss();
        this.mN.ac();
    }

    @Override // com.kwad.components.core.video.a.c
    public final void as() {
    }

    @Override // com.kwad.components.core.video.a.c
    public final void at() {
        if (this.mN.ec()) {
            return;
        }
        this.mN.c(getContext(), this.mAdTemplate);
        eC();
    }

    @Override // com.kwad.components.ad.interstitial.f.b, com.kwad.sdk.mvp.Presenter
    public final void ay() {
        super.ay();
        com.kwad.sdk.core.d.c.d("InterstitialPlayablePresenter", this + " onBind");
        c cVar = (c) SB();
        this.mN = cVar;
        AdTemplate adTemplate = cVar.mAdTemplate;
        this.mAdTemplate = adTemplate;
        AdInfo adInfoEO = com.kwad.sdk.core.response.helper.e.eO(adTemplate);
        long j = adInfoEO.adInsertScreenInfo.autoCloseTime;
        if (j > 0) {
            this.nH = (int) Math.min(com.kwad.components.ad.interstitial.b.b.b(adInfoEO), j);
        } else {
            this.nH = com.kwad.components.ad.interstitial.b.b.b(adInfoEO);
        }
        com.kwad.components.ad.interstitial.h.d dVar = this.mN.mO;
        if (dVar != null) {
            dVar.b(true, this.nH);
        }
        if (com.kwad.sdk.core.response.helper.a.bi(adInfoEO)) {
            this.nG = null;
            this.mN.a(this);
        } else {
            a aVar = new a(this, (byte) 0);
            this.nG = aVar;
            by.a(aVar, null, 1000L);
        }
    }

    @Override // com.kwad.components.core.video.a.c
    public final void d(long j) {
        aa(this.nH - ((int) (j / 1000)));
    }

    @Override // com.kwad.components.ad.interstitial.f.b
    public final void dY() {
        super.dY();
        a aVar = this.nG;
        if (aVar != null) {
            aVar.s(false);
        }
    }

    @Override // com.kwad.components.ad.interstitial.f.b
    public final void dZ() {
        super.dZ();
        a aVar = this.nG;
        if (aVar != null) {
            aVar.s(true);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        com.kwad.sdk.core.d.c.d("InterstitialPlayablePresenter", this + " onUnbind");
        this.mN.b(this);
        a aVar = this.nG;
        if (aVar != null) {
            aVar.r(true);
            by.b(this.nG);
            this.nG = null;
        }
    }

    @Override // com.kwad.components.core.video.a.c
    public final void onVideoPlayStart() {
    }

    public class a implements Runnable {
        private int nI;
        private boolean nJ;
        private boolean nK;

        private a() {
            this.nI = Integer.MIN_VALUE;
            this.nJ = false;
            this.nK = false;
        }

        public final void r(boolean z) {
            this.nK = true;
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (this.nK) {
                return;
            }
            if (this.nJ) {
                by.a(this, null, e.nF);
                return;
            }
            if (this.nI == Integer.MIN_VALUE) {
                this.nI = e.this.nH;
            }
            if (this.nI < 0) {
                return;
            }
            com.kwad.sdk.core.d.c.d("InterstitialPlayablePresenter", e.this.toString() + ", this: " + toString() + " PlayableTimerRunnable run : " + this.nI);
            e.this.aa(this.nI);
            this.nI = this.nI + (-1);
            by.a(this, null, e.nF);
        }

        public final void s(boolean z) {
            this.nJ = z;
        }

        public /* synthetic */ a(e eVar, byte b) {
            this();
        }
    }
}
