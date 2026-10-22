package com.kwad.components.ad.draw.presenter.a;

import android.view.View;
import com.kwad.components.ad.draw.a.d;
import com.kwad.components.core.video.m;
import com.kwad.sdk.core.adlog.c;
import com.kwad.sdk.core.response.helper.b;
import com.kwad.sdk.core.response.helper.e;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.view.AdBasePvFrameLayout;
import com.kwad.sdk.utils.o;
import com.kwad.sdk.widget.l;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public final class a extends com.kwad.components.ad.draw.b.a {
    private List<Integer> cv;
    private AdInfo mAdInfo;
    private AdTemplate mAdTemplate;
    private boolean eU = false;
    private volatile boolean eV = false;
    private l eW = new l() { // from class: com.kwad.components.ad.draw.presenter.a.a.1
        @Override // com.kwad.sdk.widget.l
        public final void aZ() {
            o.fr(a.this.mAdTemplate);
        }
    };
    private com.kwad.components.core.video.l mVideoPlayStateListener = new m() { // from class: com.kwad.components.ad.draw.presenter.a.a.2
        @Override // com.kwad.components.core.video.m, com.kwad.components.core.video.i
        public final void onMediaPlayCompleted() {
            c.cu(a.this.mAdTemplate);
            if (a.this.dQ.dB != null) {
                try {
                    a.this.dQ.dB.onVideoPlayEnd();
                } catch (Throwable th) {
                    com.kwad.sdk.core.d.c.printStackTraceOnly(th);
                }
            }
        }

        @Override // com.kwad.components.core.video.m, com.kwad.components.core.video.i
        public final void onMediaPlayError(int i, int i2) {
            super.onMediaPlayError(i, i2);
            if (a.this.dQ.dB != null) {
                try {
                    a.this.dQ.dB.onVideoPlayError();
                } catch (Throwable th) {
                    com.kwad.sdk.core.d.c.printStackTraceOnly(th);
                }
            }
        }

        @Override // com.kwad.components.core.video.m, com.kwad.components.core.video.i
        public final void onMediaPlayPaused() {
            super.onMediaPlayPaused();
            if (a.this.dQ.dB != null) {
                try {
                    a.this.dQ.dB.onVideoPlayPause();
                } catch (Throwable th) {
                    com.kwad.sdk.core.d.c.printStackTraceOnly(th);
                }
            }
            a.this.eU = true;
        }

        @Override // com.kwad.components.core.video.m, com.kwad.components.core.video.i
        public final void onMediaPlayProgress(long j, long j2) {
            a.this.c(j2);
        }

        @Override // com.kwad.components.core.video.m, com.kwad.components.core.video.i
        public final void onMediaPlayStart() {
            a.this.eV = false;
            if (!a.this.mAdTemplate.mPvReported && a.this.dQ.dB != null) {
                a.this.dQ.dB.onAdShow();
                d.g(a.this.mAdTemplate, 1, b.dF(a.this.mAdTemplate) ? 2 : 1);
                d.a(a.this.mAdTemplate, 1);
            }
            if (a.this.dQ.dB != null) {
                try {
                    a.this.dQ.dB.onVideoPlayStart();
                } catch (Throwable th) {
                    com.kwad.sdk.core.d.c.printStackTraceOnly(th);
                }
                a.this.eU = false;
            }
            com.kwad.sdk.core.adlog.c.b bVar = new com.kwad.sdk.core.adlog.c.b();
            bVar.b(new com.kwad.sdk.core.adlog.a.C1273a());
            com.kwad.components.core.t.b.wF().a(a.this.mAdTemplate, null, bVar);
            c.ct(a.this.mAdTemplate);
        }

        @Override // com.kwad.components.core.video.m, com.kwad.components.core.video.i
        public final void onMediaPlaying() {
            super.onMediaPlaying();
            if (!a.this.eU) {
                if (a.this.eV) {
                    return;
                }
                a.this.eV = true;
                com.kwad.components.core.p.a.vL().a(a.this.mAdTemplate, System.currentTimeMillis(), 1);
                return;
            }
            a.this.eU = false;
            if (a.this.dQ.dB != null) {
                try {
                    a.this.dQ.dB.onVideoPlayResume();
                } catch (Throwable th) {
                    com.kwad.sdk.core.d.c.printStackTraceOnly(th);
                }
            }
        }
    };

    @Override // com.kwad.components.ad.draw.b.a, com.kwad.sdk.mvp.Presenter
    public final void ay() {
        super.ay();
        AdTemplate adTemplate = this.dQ.mAdTemplate;
        this.mAdTemplate = adTemplate;
        AdInfo adInfoEO = e.eO(adTemplate);
        this.mAdInfo = adInfoEO;
        this.cv = com.kwad.sdk.core.response.helper.a.bv(adInfoEO);
        this.dQ.dS.b(this.mVideoPlayStateListener);
        a(this.eW);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        this.dQ.dS.a(this.mVideoPlayStateListener);
        a((l) null);
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
                c.a(this.mAdTemplate, iCeil, (JSONObject) null);
                this.cv.remove(num);
                return;
            }
        }
    }

    private void a(l lVar) {
        View rootView = getRootView();
        if (rootView instanceof AdBasePvFrameLayout) {
            ((AdBasePvFrameLayout) rootView).setVisibleListener(lVar);
        }
    }
}
