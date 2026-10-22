package com.kwad.components.ad.reward.presenter.c;

import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import com.kwad.components.ad.reward.g;
import com.kwad.components.ad.reward.model.EcOrderCardStyle;
import com.kwad.components.ad.reward.monitor.c;
import com.kwad.components.ad.reward.monitor.d;
import com.kwad.components.ad.reward.presenter.b;
import com.kwad.components.core.video.j;
import com.kwad.components.core.video.m;
import com.kwad.sdk.core.response.helper.e;
import com.kwad.sdk.core.response.model.AdInfo;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public final class a extends b {
    private List<Integer> cv;
    private AdInfo mAdInfo;
    private m wO;
    private final j yn = new j();
    private long te = 0;
    private Handler jk = new Handler(Looper.getMainLooper());
    private boolean yo = true;
    private volatile boolean eV = false;
    private Runnable yp = new Runnable() { // from class: com.kwad.components.ad.reward.presenter.c.a.1
        @Override // java.lang.Runnable
        public final void run() {
            if (a.this.yn.xS()) {
                long jElapsedRealtime = SystemClock.elapsedRealtime() - a.this.yn.xU();
                int iXV = a.this.yn.xT().xV();
                a.this.uj.a(jElapsedRealtime, a.this.yn.xT().xW(), iXV);
            } else if (a.this.yo) {
                a.this.uj.a(5000L, 5000L, 1);
            }
            com.kwad.components.core.p.a.vL().bf(a.this.mAdTemplate);
        }
    };
    private m wP = new m() { // from class: com.kwad.components.ad.reward.presenter.c.a.2
        @Override // com.kwad.components.core.video.m, com.kwad.components.core.video.i
        public final void onMediaPlayCompleted() {
            super.onMediaPlayCompleted();
            a.this.iT();
        }

        @Override // com.kwad.components.core.video.m, com.kwad.components.core.video.i
        public final void onMediaPlayPaused() {
            super.onMediaPlayPaused();
            a.this.yn.xR();
        }

        @Override // com.kwad.components.core.video.m, com.kwad.components.core.video.i
        public final void onMediaPlayProgress(long j, long j2) {
            super.onMediaPlayProgress(j, j2);
            a.this.c(j2);
            a.this.te = j2;
            a.this.yn.xR();
            a.a(a.this, false);
            a.this.uj.te = j2;
            if (a.this.eV) {
                return;
            }
            a.b(a.this, true);
            com.kwad.components.core.p.a.vL().a(a.this.mAdTemplate, System.currentTimeMillis(), 1);
            d.b(a.this.uj.sO, a.this.mAdTemplate, a.this.uj.mPageEnterTime);
        }

        @Override // com.kwad.components.core.video.m, com.kwad.components.core.video.i
        public final void onMediaPlayStart() {
            super.onMediaPlayStart();
            a.this.jn();
        }
    };
    private m kf = new m() { // from class: com.kwad.components.ad.reward.presenter.c.a.3
        @Override // com.kwad.components.core.video.m, com.kwad.components.core.video.i
        public final void onMediaPlayCompleted() {
            a.this.iT();
        }

        @Override // com.kwad.components.core.video.m, com.kwad.components.core.video.i
        public final void onMediaPlayError(int i, int i2) {
            super.onMediaPlayError(i, i2);
            d.a(a.this.uj.sO, a.this.uj.mAdTemplate, a.this.uj.tn, i, i2);
            c.c(a.this.uj.sO, a.this.mAdTemplate);
        }

        @Override // com.kwad.components.core.video.m, com.kwad.components.core.video.i
        public final void onMediaPlayPaused() {
            super.onMediaPlayPaused();
            a.this.yn.xR();
        }

        @Override // com.kwad.components.core.video.m, com.kwad.components.core.video.i
        public final void onMediaPlayProgress(long j, long j2) {
            a.this.c(j2);
            a.this.te = j2;
        }

        @Override // com.kwad.components.core.video.m, com.kwad.components.core.video.i
        public final void onMediaPlayStart() {
            super.onMediaPlayStart();
            a.this.jn();
        }

        @Override // com.kwad.components.core.video.m, com.kwad.components.core.video.i
        public final void onMediaPlaying() {
            super.onMediaPlaying();
            a.this.yn.xR();
            a.a(a.this, false);
            if (a.this.eV) {
                return;
            }
            a.b(a.this, true);
            com.kwad.components.core.p.a.vL().a(a.this.mAdTemplate, System.currentTimeMillis(), 1);
            d.b(a.this.uj.sO, a.this.mAdTemplate, a.this.uj.mPageEnterTime);
        }

        @Override // com.kwad.components.core.video.m, com.kwad.components.core.video.l
        public final void onVideoPlayBufferingPaused() {
            super.onVideoPlayBufferingPaused();
            a.this.yn.xQ();
            a.this.jk.removeCallbacks(a.this.yp);
            a.this.jk.postDelayed(a.this.yp, 5000L);
        }

        @Override // com.kwad.components.core.video.m, com.kwad.components.core.video.l
        public final void onVideoPlayBufferingPlaying() {
            super.onVideoPlayBufferingPlaying();
            a.this.yn.xQ();
            a.this.jk.removeCallbacks(a.this.yp);
            a.this.jk.postDelayed(a.this.yp, 5000L);
        }
    };

    private void checkExposure() {
        AdInfo adInfo = this.mAdInfo;
        long j = adInfo.adRewardInfo.callBackStrategyInfo.impressionCheckMs;
        if (j <= 0 || com.kwad.sdk.core.response.helper.a.ak(adInfo) <= 5000) {
            return;
        }
        this.jk.postDelayed(new Runnable() { // from class: com.kwad.components.ad.reward.presenter.c.a.4
            @Override // java.lang.Runnable
            public final void run() {
                com.kwad.components.ad.reward.m.a(1, a.this.uj);
            }
        }, j);
    }

    @Override // com.kwad.components.ad.reward.presenter.b, com.kwad.sdk.mvp.Presenter
    public final void ay() {
        super.ay();
        AdInfo adInfoEO = e.eO(this.mAdTemplate);
        this.mAdInfo = adInfoEO;
        this.cv = com.kwad.sdk.core.response.helper.a.bv(adInfoEO);
        if (this.uj.sz.ls()) {
            this.wO = this.wP;
        } else {
            this.wO = this.kf;
        }
        this.uj.sz.a(this.wO);
        this.jk.postDelayed(this.yp, 5000L);
    }

    public final void iT() {
        g gVar = this.uj;
        if (!gVar.sO || !gVar.sT) {
            com.kwad.sdk.core.adlog.c.g(this.mAdTemplate, gVar.mReportExtData);
        }
        this.yn.xR();
    }

    public final void jn() {
        this.eV = false;
        EcOrderCardStyle ecOrderCardStyleCreateFromAdInfo = EcOrderCardStyle.createFromAdInfo(this.mAdInfo);
        com.kwad.sdk.core.adlog.c.b bVar = new com.kwad.sdk.core.adlog.c.b();
        if (ecOrderCardStyleCreateFromAdInfo != null) {
            com.kwad.sdk.core.adlog.a.C1273a c1273a = new com.kwad.sdk.core.adlog.a.C1273a();
            c1273a.aLl = String.valueOf(ecOrderCardStyleCreateFromAdInfo.getValue());
            bVar.b(c1273a);
        }
        if (!this.mAdTemplate.mPvReported) {
            checkExposure();
        }
        com.kwad.components.ad.reward.j.b.a(true, this.mAdTemplate, null, bVar);
        com.kwad.sdk.core.adlog.c.f(this.mAdTemplate, this.uj.mReportExtData);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        this.jk.removeCallbacksAndMessages(null);
        this.uj.sz.b(this.wO);
        j.a aVarXT = this.yn.xT();
        com.kwad.components.core.p.a.vL().a(this.uj.mAdTemplate, this.te, aVarXT.xW(), aVarXT.xV());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(long j) {
        int iCeil = (int) Math.ceil(j / 1000.0f);
        List<Integer> list = this.cv;
        if (list == null || list.isEmpty()) {
            return;
        }
        for (Integer num : this.cv) {
            if (iCeil >= num.intValue()) {
                com.kwad.sdk.core.adlog.c.a(this.mAdTemplate, iCeil, this.uj.mReportExtData);
                this.cv.remove(num);
                return;
            }
        }
    }

    public static /* synthetic */ boolean a(a aVar, boolean z) {
        aVar.yo = false;
        return false;
    }

    public static /* synthetic */ boolean b(a aVar, boolean z) {
        aVar.eV = true;
        return true;
    }
}
