package com.kwad.components.ad.nativead.d;

import android.content.Context;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.components.ad.k.b;
import com.kwad.components.ad.nativead.g;
import com.kwad.components.core.internal.api.KSAdVideoPlayConfigImpl;
import com.kwad.components.core.video.DetailVideoView;
import com.kwad.components.core.video.m;
import com.kwad.components.offline.api.core.api.OfflineOnAudioConflictListener;
import com.kwad.sdk.api.KsAdVideoPlayConfig;
import com.kwad.sdk.core.j.c;
import com.kwad.sdk.core.response.helper.e;
import com.kwad.sdk.core.response.helper.h;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.aq;
import com.kwad.sdk.utils.o;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public final class a extends b {
    private boolean cA;
    private OfflineOnAudioConflictListener cM;
    private KsAdVideoPlayConfig ce;
    private final c fF;
    private com.kwad.components.core.l.a.b fU;
    private com.kwad.components.core.widget.a.c fx;
    private boolean hasNoCache;
    private final AdInfo mAdInfo;
    private Context mContext;
    private boolean qO;
    private boolean qP;
    private m qQ;
    private int qR;
    private long qS;

    public a(@NonNull final AdTemplate adTemplate, com.kwad.components.core.widget.a.c cVar, @NonNull DetailVideoView detailVideoView, @Nullable KsAdVideoPlayConfig ksAdVideoPlayConfig) {
        super(adTemplate, detailVideoView);
        this.hasNoCache = false;
        this.fF = new c() { // from class: com.kwad.components.ad.nativead.d.a.4
            @Override // com.kwad.sdk.core.j.c
            public final void bA() {
                com.kwad.components.core.l.a.tm().c(a.this.fU);
                a.this.pause();
            }

            @Override // com.kwad.sdk.core.j.c
            public final void bz() {
                com.kwad.components.core.l.a.tm().a(a.this.getCurrentVoiceItem());
                a.this.fV();
            }
        };
        this.cM = new OfflineOnAudioConflictListener() { // from class: com.kwad.components.ad.nativead.d.a.6
            @Override // com.kwad.components.offline.api.core.api.OfflineOnAudioConflictListener
            public final void onAudioBeOccupied() {
                a.c(a.this, false);
                a.this.setAudioEnabled(false);
            }

            @Override // com.kwad.components.offline.api.core.api.OfflineOnAudioConflictListener
            public final void onAudioBeReleased() {
            }
        };
        if (cVar == null) {
            View view = (View) detailVideoView.getParent();
            cVar = new g(view == null ? detailVideoView : view);
        }
        this.fx = cVar;
        AdInfo adInfoEO = e.eO(this.mAdTemplate);
        this.mAdInfo = adInfoEO;
        if (!(ksAdVideoPlayConfig instanceof KSAdVideoPlayConfigImpl) || ((KSAdVideoPlayConfigImpl) ksAdVideoPlayConfig).getVideoSoundValue() == 0) {
            this.qO = com.kwad.sdk.core.response.helper.a.ch(adInfoEO);
        } else {
            this.qO = ksAdVideoPlayConfig.isVideoSoundEnable();
        }
        this.ce = ksAdVideoPlayConfig;
        this.mContext = detailVideoView.getContext();
        if (ksAdVideoPlayConfig != null) {
            try {
                this.hasNoCache = ksAdVideoPlayConfig.isNoCache();
            } catch (Throwable th) {
                com.kwad.sdk.core.d.c.printStackTraceOnly(th);
            }
        }
        m mVar = new m() { // from class: com.kwad.components.ad.nativead.d.a.1
            @Override // com.kwad.components.core.video.m, com.kwad.components.core.video.i
            public final void onMediaPlayError(int i, int i2) {
                super.onMediaPlayError(i, i2);
                com.kwad.components.core.p.a.vL().m(adTemplate, i, i2);
            }
        };
        this.qQ = mVar;
        this.Nx.c(mVar);
        by();
        this.Nx.a(new com.kwad.sdk.core.video.a.c.e() { // from class: com.kwad.components.ad.nativead.d.a.2
            @Override // com.kwad.sdk.core.video.a.c.e
            public final void a(com.kwad.sdk.core.video.a.c cVar2) {
                try {
                    if (a.this.fW() && a.this.fx.ah() && a.this.fU()) {
                        a.this.Nx.a(com.kwad.sdk.contentalliance.a.a.a.cm(a.this.mAdTemplate));
                        com.kwad.components.core.l.a.tm().a(a.this.getCurrentVoiceItem());
                        a.this.Nx.start(a.this.qS);
                    }
                } catch (Throwable th2) {
                    ServiceProvider.reportSdkCaughtException(th2);
                }
            }
        });
    }

    public static /* synthetic */ int a(a aVar, int i) {
        aVar.qR = 3;
        return 3;
    }

    private void by() {
        this.Nx.a(new com.kwad.sdk.contentalliance.a.a.b.a(this.mAdTemplate).dQ(e.eQ(this.mAdTemplate)).dR(h.b(e.eP(this.mAdTemplate))).a(this.mAdTemplate.mVideoPlayerStatus).bD(this.hasNoCache).b(com.kwad.sdk.contentalliance.a.a.a.cm(this.mAdTemplate)).IG(), true, true, this.mDetailVideoView);
        setAudioEnabled(h(this.qO));
        if (fW()) {
            this.Nx.prepareAsync();
            com.kwad.components.core.t.a.aO(this.mContext).a(this.cM);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean fU() {
        int i = this.qR;
        return (i == 3 || i == 2) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fV() {
        int i = this.qR;
        if (i == 1) {
            start();
            return;
        }
        if (i == 2) {
            pause();
        } else if (i != 3) {
            resume();
        } else {
            stop();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean fW() {
        if (this.qP) {
            return true;
        }
        KsAdVideoPlayConfig ksAdVideoPlayConfig = this.ce;
        if (ksAdVideoPlayConfig instanceof KSAdVideoPlayConfigImpl) {
            KSAdVideoPlayConfigImpl kSAdVideoPlayConfigImpl = (KSAdVideoPlayConfigImpl) ksAdVideoPlayConfig;
            if (kSAdVideoPlayConfigImpl.getVideoAutoPlayType() == 1) {
                return aq.isNetworkConnected(this.mContext);
            }
            if (kSAdVideoPlayConfigImpl.getVideoAutoPlayType() == 2) {
                return aq.isWifiConnected(this.mContext);
            }
            if (kSAdVideoPlayConfigImpl.getVideoAutoPlayType() == 3) {
                return false;
            }
            if (kSAdVideoPlayConfigImpl.getDataFlowAutoStartValue() != 0) {
                return aq.isWifiConnected(this.mContext) || (kSAdVideoPlayConfigImpl.isDataFlowAutoStart() && aq.isMobileConnected(this.mContext));
            }
        }
        if (com.kwad.sdk.core.response.helper.a.cj(this.mAdInfo) && aq.isNetworkConnected(this.mContext)) {
            return true;
        }
        return com.kwad.sdk.core.response.helper.a.ck(this.mAdInfo) && aq.isWifiConnected(this.mContext);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.kwad.components.core.l.a.b getCurrentVoiceItem() {
        if (this.fU == null) {
            this.fU = new com.kwad.components.core.l.a.b(new com.kwad.components.core.l.a.c() { // from class: com.kwad.components.ad.nativead.d.a.5
                @Override // com.kwad.components.core.l.a.c
                public final void bL() {
                    a aVar = a.this;
                    aVar.setAudioEnabled(aVar.h(aVar.qO));
                }
            });
        }
        return this.fU;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setAudioEnabled(boolean z) {
        this.Nx.setAudioEnabled(z);
    }

    private void start() {
        if (this.qP) {
            resume();
        } else {
            fX();
        }
    }

    private void stop() {
        this.Nx.complete();
    }

    public final void af(int i) {
        this.qR = i;
        if (this.fx.ah()) {
            fV();
        }
    }

    public final void bu() {
        o.fr(this.mAdTemplate);
        if (this.Nx.xm() == null) {
            by();
        }
        if (fW() && this.fx.ah()) {
            this.Nx.a(com.kwad.sdk.contentalliance.a.a.a.cm(this.mAdTemplate));
            com.kwad.components.core.l.a.tm().a(getCurrentVoiceItem());
            this.Nx.start(this.qS);
        }
        this.Nx.c(new m() { // from class: com.kwad.components.ad.nativead.d.a.3
            @Override // com.kwad.components.core.video.m, com.kwad.components.core.video.i
            public final void onMediaPlayCompleted() {
                super.onMediaPlayCompleted();
                a.this.qS = 0L;
                a.a(a.this, 3);
            }

            @Override // com.kwad.components.core.video.m, com.kwad.components.core.video.i
            public final void onMediaPlayProgress(long j, long j2) {
                if (j != 0) {
                    a.this.qS = j2;
                }
            }
        });
        this.fx.a(this.fF);
    }

    public final void bw() {
        o.fp(this.mAdTemplate);
        this.fx.b(this.fF);
        this.Nx.release();
        com.kwad.components.core.l.a.tm().c(this.fU);
        com.kwad.components.core.t.a.aO(this.mContext).b(this.cM);
    }

    public final void fX() {
        this.qP = true;
        this.mAdInfo.isAllowVideoAutoPlay = true;
        if (this.fx.ah()) {
            o.fq(this.mAdTemplate);
            this.Nx.a(com.kwad.sdk.contentalliance.a.a.a.cm(this.mAdTemplate));
            com.kwad.components.core.l.a.tm().a(getCurrentVoiceItem());
            this.Nx.start(this.qS);
        }
    }

    @Override // com.kwad.components.ad.k.b, com.kwad.components.ad.k.a
    public final void resume() {
        com.kwad.components.core.l.a.tm().a(getCurrentVoiceItem());
        setAudioEnabled(h(this.qO));
        if (fW()) {
            this.Nx.start(this.qS);
        }
    }

    public static /* synthetic */ boolean c(a aVar, boolean z) {
        aVar.cA = false;
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean h(boolean z) {
        if (!z) {
            return false;
        }
        if (this.fU != null) {
            com.kwad.components.core.l.a.tm();
            if (!com.kwad.components.core.l.a.b(this.fU)) {
                return false;
            }
        }
        if (com.kwad.sdk.core.config.e.hO()) {
            if (!this.cA) {
                this.cA = com.kwad.components.core.t.a.aO(this.mContext).bd(true);
            }
            return this.cA;
        }
        if (com.kwad.components.core.t.a.aO(this.mContext).wE()) {
            return !com.kwad.components.core.t.a.aO(this.mContext).wD();
        }
        return com.kwad.components.core.t.a.aO(this.mContext).bd(false);
    }
}
