package com.kwad.components.ad.draw;

import android.content.Context;
import android.os.SystemClock;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.api.KsDrawAd;
import com.kwad.sdk.api.core.AbstractKsDrawAd;
import com.kwad.sdk.api.model.AdExposureFailedReason;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.response.helper.e;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdResultData;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.o;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.wrapper.m;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public final class c extends AbstractKsDrawAd implements com.kwad.components.core.internal.api.a {

    @Nullable
    private KsDrawAd.AdInteractionListener dB;
    private com.kwad.components.ad.draw.view.b dC;
    private com.kwad.components.ad.draw.view.a dD;
    private com.kwad.components.ad.draw.view.c dE;
    private FrameLayout dG;
    private AdInfo mAdInfo;

    @NonNull
    private AdResultData mAdResultData;

    @NonNull
    private AdTemplate mAdTemplate;
    private long startTime;
    private boolean dF = false;
    private com.kwad.components.core.internal.api.c bz = new com.kwad.components.core.internal.api.c();
    private final com.kwad.sdk.core.j.b dH = new com.kwad.sdk.core.j.b() { // from class: com.kwad.components.ad.draw.c.2
        @Override // com.kwad.sdk.core.j.b
        public final void aP() {
            c.this.bz.h(c.this);
        }

        @Override // com.kwad.sdk.core.j.b
        public final void aQ() {
            c.this.bz.i(c.this);
        }
    };
    private final KsDrawAd.AdInteractionListener dI = new KsDrawAd.AdInteractionListener() { // from class: com.kwad.components.ad.draw.c.3
        @Override // com.kwad.sdk.api.KsDrawAd.AdInteractionListener
        public final void onAdClicked() {
            if (c.this.dB != null) {
                c.this.dB.onAdClicked();
            }
        }

        @Override // com.kwad.sdk.api.KsDrawAd.AdInteractionListener
        public final void onAdShow() {
            if (c.this.dB != null) {
                c.this.dB.onAdShow();
            }
        }

        @Override // com.kwad.sdk.api.KsDrawAd.AdInteractionListener
        public final void onVideoPlayEnd() {
            if (c.this.dB != null) {
                try {
                    c.this.dB.onVideoPlayEnd();
                } catch (Throwable th) {
                    com.kwad.sdk.core.d.c.printStackTraceOnly(th);
                }
            }
        }

        @Override // com.kwad.sdk.api.KsDrawAd.AdInteractionListener
        public final void onVideoPlayError() {
            if (c.this.dB != null) {
                try {
                    c.this.dB.onVideoPlayError();
                } catch (Throwable th) {
                    com.kwad.sdk.core.d.c.printStackTraceOnly(th);
                }
            }
        }

        @Override // com.kwad.sdk.api.KsDrawAd.AdInteractionListener
        public final void onVideoPlayPause() {
            if (c.this.dB != null) {
                try {
                    c.this.dB.onVideoPlayPause();
                } catch (Throwable th) {
                    com.kwad.sdk.core.d.c.printStackTraceOnly(th);
                }
            }
        }

        @Override // com.kwad.sdk.api.KsDrawAd.AdInteractionListener
        public final void onVideoPlayResume() {
            if (c.this.dB != null) {
                try {
                    c.this.dB.onVideoPlayResume();
                } catch (Throwable th) {
                    com.kwad.sdk.core.d.c.printStackTraceOnly(th);
                }
            }
        }

        @Override // com.kwad.sdk.api.KsDrawAd.AdInteractionListener
        public final void onVideoPlayStart() {
            if (c.this.dB != null) {
                try {
                    c.this.dB.onVideoPlayStart();
                } catch (Throwable th) {
                    com.kwad.sdk.core.d.c.printStackTraceOnly(th);
                }
            }
        }
    };

    public interface a {
        void aN();

        void aO();
    }

    public c(@NonNull AdResultData adResultData) {
        this.mAdResultData = adResultData;
        AdTemplate adTemplateR = com.kwad.sdk.core.response.helper.c.r(adResultData);
        this.mAdTemplate = adTemplateR;
        AdInfo adInfoEO = e.eO(adTemplateR);
        this.mAdInfo = adInfoEO;
        KSImageLoader.preloadImage(com.kwad.sdk.core.response.helper.a.bA(adInfoEO).getUrl(), this.mAdTemplate);
        com.kwad.components.ad.i.b.gd().a(this);
    }

    private boolean aM() {
        FrameLayout frameLayout = this.dG;
        return frameLayout != null && frameLayout.getChildCount() == 1;
    }

    @Override // com.kwad.sdk.api.KsDrawAd
    public final void controlPlayerStatus() {
        this.dF = true;
        com.kwad.components.ad.draw.view.b bVar = this.dC;
        if (bVar != null) {
            bVar.bQ();
        }
        com.kwad.components.ad.draw.view.c cVar = this.dE;
        if (cVar != null) {
            cVar.bQ();
        }
    }

    @Override // com.kwad.components.core.internal.api.a
    public final AdTemplate getAdTemplate() {
        return this.mAdTemplate;
    }

    @Override // com.kwad.sdk.api.core.AbstractKsDrawAd
    @Nullable
    public final View getDrawView2(Context context) {
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        if (context == null || !o.Gs().Fx()) {
            return null;
        }
        if (aM()) {
            return this.dG;
        }
        this.dG = new FrameLayout(context);
        com.kwad.components.ad.draw.a.d.m(this.mAdTemplate);
        this.startTime = SystemClock.elapsedRealtime();
        try {
            context = m.wrapContextIfNeed(context);
            if (com.kwad.sdk.core.response.helper.b.dF(this.mAdTemplate)) {
                a(context, this.dG);
            } else {
                b(context, this.dG);
                com.kwad.components.ad.draw.a.d.b(this.mAdTemplate, SystemClock.elapsedRealtime() - this.startTime, 1, 1, true);
            }
        } catch (Throwable th) {
            if (!o.Gs().Fu()) {
                throw th;
            }
            RuntimeException runtimeException = new RuntimeException("context:" + context.getClass().getName() + "--classloader:" + context.getClass().getClassLoader());
            runtimeException.addSuppressed(th);
            com.kwad.components.ad.draw.a.d.c(this.mAdTemplate, SystemClock.elapsedRealtime() - this.startTime, th.getMessage());
            com.kwad.components.core.d.a.reportSdkCaughtException(runtimeException);
        }
        if (!aM()) {
            return null;
        }
        try {
            com.kwad.sdk.commercial.convert.d.f(e.eI(this.mAdTemplate), SystemClock.elapsedRealtime() - jElapsedRealtime);
        } catch (Throwable th2) {
            ServiceProvider.reportSdkCaughtException(th2);
        }
        return this.dG;
    }

    @Override // com.kwad.sdk.api.KsDrawAd
    public final int getECPM() {
        return com.kwad.sdk.core.response.helper.a.aX(e.eO(this.mAdTemplate));
    }

    @Override // com.kwad.sdk.api.KsDrawAd
    public final int getInteractionType() {
        return com.kwad.sdk.core.response.helper.a.aW(e.eO(this.mAdTemplate));
    }

    @Override // com.kwad.sdk.api.KsDrawAd
    public final int getMaterialType() {
        return com.kwad.sdk.core.response.helper.a.bk(e.eO(this.mAdTemplate));
    }

    @Override // com.kwad.sdk.api.BaseKSAd
    public final Map<String, Object> getMediaExtraInfo() {
        HashMap map = new HashMap();
        if (com.kwad.sdk.core.config.e.JP()) {
            map.put("llsid", Long.valueOf(this.mAdTemplate.llsid));
        }
        return map;
    }

    @Override // com.kwad.sdk.api.KsDrawAd
    public final void pause() {
        if (this.dF) {
            com.kwad.components.ad.draw.view.b bVar = this.dC;
            if (bVar != null) {
                bVar.pause();
            }
            com.kwad.components.ad.draw.view.c cVar = this.dE;
            if (cVar != null) {
                cVar.L(2);
            }
        }
    }

    @Override // com.kwad.sdk.api.KsDrawAd
    public final void play() {
        if (this.dF) {
            com.kwad.components.ad.draw.view.b bVar = this.dC;
            if (bVar != null) {
                bVar.play();
            }
            com.kwad.components.ad.draw.view.c cVar = this.dE;
            if (cVar != null) {
                cVar.L(1);
            }
        }
    }

    @Override // com.kwad.sdk.api.KsDrawAd
    public final void reportAdExposureFailed(int i, AdExposureFailedReason adExposureFailedReason) {
        com.kwad.sdk.core.adlog.c.a(this.mAdTemplate, i, adExposureFailedReason);
    }

    @Override // com.kwad.sdk.api.KsDrawAd
    public final void setAdInteractionListener(KsDrawAd.AdInteractionListener adInteractionListener) {
        this.dB = adInteractionListener;
        com.kwad.components.ad.draw.view.b bVar = this.dC;
        if (bVar != null) {
            bVar.setAdInteractionListener(adInteractionListener);
        }
    }

    @Override // com.kwad.sdk.api.KsDrawAd
    public final void setBidEcpm(int i) {
        setBidEcpm(i, -1L);
    }

    @Override // com.kwad.sdk.api.KsDrawAd
    public final void setVideoSoundEnable(boolean z) {
        com.kwad.components.ad.draw.view.b bVar = this.dC;
        if (bVar != null) {
            bVar.setVideoSound(z);
        }
        com.kwad.components.ad.draw.view.a aVar = this.dD;
        if (aVar != null) {
            aVar.setVideoSound(z);
        }
        com.kwad.components.ad.draw.view.c cVar = this.dE;
        if (cVar != null) {
            cVar.setVideoSound(z);
        }
    }

    @Override // com.kwad.components.core.internal.api.a
    public final boolean supportPushAd() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(Context context, ViewGroup viewGroup) {
        if (com.kwad.sdk.core.response.helper.a.cY(this.mAdInfo)) {
            if (this.dD == null) {
                com.kwad.components.ad.draw.view.a aVar = new com.kwad.components.ad.draw.view.a(context, this.mAdTemplate);
                this.dD = aVar;
                aVar.setPageExitListener(this.dH);
                this.dD.setAdInteractionListener(this.dB);
                this.dD.bE();
            } else {
                com.kwad.sdk.core.d.c.i("KSDrawAdControl", "mDrawAdLiveView is not null");
            }
            a(viewGroup, this.dD);
            return;
        }
        if (this.dC == null) {
            com.kwad.components.ad.draw.view.b bVar = new com.kwad.components.ad.draw.view.b(context);
            this.dC = bVar;
            bVar.setPageExitListener(this.dH);
            this.dC.setAdInteractionListener(this.dB);
            this.dC.o(this.mAdTemplate);
        } else {
            com.kwad.sdk.core.d.c.i("KSDrawAdControl", "mDrawVideoView is not null");
        }
        a(viewGroup, this.dC);
        try {
            com.kwad.sdk.commercial.convert.d.b(e.eI(this.mAdTemplate), 1, SystemClock.elapsedRealtime() - this.startTime);
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    @Override // com.kwad.sdk.api.KsDrawAd
    public final void setBidEcpm(long j, long j2) {
        AdTemplate adTemplate = this.mAdTemplate;
        adTemplate.mBidEcpm = j;
        com.kwad.sdk.core.adlog.c.m(adTemplate, j2);
    }

    private void a(final Context context, final ViewGroup viewGroup) {
        if (this.dE == null) {
            com.kwad.components.ad.draw.view.c cVar = new com.kwad.components.ad.draw.view.c(context);
            this.dE = cVar;
            cVar.setPageExitListener(this.dH);
            this.dE.setAdInteractionListener(this.dB);
            this.dE.setTKLoadStateListener(new a() { // from class: com.kwad.components.ad.draw.c.1
                @Override // com.kwad.components.ad.draw.c.a
                public final void aN() {
                    try {
                        com.kwad.sdk.commercial.convert.d.b(e.eI(c.this.mAdTemplate), 2, SystemClock.elapsedRealtime() - c.this.startTime);
                    } catch (Throwable th) {
                        ServiceProvider.reportSdkCaughtException(th);
                    }
                    com.kwad.components.ad.draw.a.d.b(c.this.mAdTemplate, SystemClock.elapsedRealtime() - c.this.startTime, 2, 2, false);
                }

                @Override // com.kwad.components.ad.draw.c.a
                public final void aO() {
                    viewGroup.removeAllViews();
                    c.this.b(context, viewGroup);
                    com.kwad.components.ad.draw.a.d.b(c.this.mAdTemplate, SystemClock.elapsedRealtime() - c.this.startTime, 1, 2, true);
                }
            });
            this.dE.c(this.mAdResultData);
        }
        a(viewGroup, this.dE);
    }

    private static void a(ViewGroup viewGroup, View view) {
        if (viewGroup == null || view == null || view.getParent() != null) {
            return;
        }
        viewGroup.removeAllViews();
        viewGroup.addView(view);
    }

    @Override // com.kwad.components.core.internal.api.a
    public final void a(com.kwad.components.core.internal.api.b bVar) {
        this.bz.a(bVar);
    }

    @Override // com.kwad.components.core.internal.api.a
    public final void b(com.kwad.components.core.internal.api.b bVar) {
        this.bz.b(bVar);
    }
}
