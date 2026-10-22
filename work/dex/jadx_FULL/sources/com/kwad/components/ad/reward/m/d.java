package com.kwad.components.ad.reward.m;

import android.content.Context;
import androidx.annotation.MainThread;
import com.kwad.components.ad.reward.g;
import com.kwad.components.core.video.DetailVideoView;
import com.kwad.components.core.video.k;
import com.kwad.components.core.video.m;
import com.kwad.components.offline.api.core.api.OfflineOnAudioConflictListener;
import com.kwad.sdk.api.KsVideoPlayConfig;
import com.kwad.sdk.core.response.helper.h;
import com.kwad.sdk.core.response.model.VideoPlayerStatus;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.j;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public final class d extends com.kwad.components.ad.k.b implements g.a {
    private String CC;
    private AtomicBoolean CD;
    private boolean CE;
    private final List<j.a> CF;
    private final List<Object> CG;
    private OfflineOnAudioConflictListener CH;
    private Context mContext;
    private KsVideoPlayConfig mVideoPlayConfig;
    private VideoPlayerStatus mVideoPlayerStatus;
    private boolean nK;
    private boolean qO;
    private m qQ;
    private g uj;

    public d(g gVar, DetailVideoView detailVideoView) {
        super(gVar.mAdTemplate, detailVideoView);
        this.CD = new AtomicBoolean(false);
        this.CE = false;
        this.nK = false;
        this.CF = new ArrayList();
        this.CG = new ArrayList();
        this.CH = new OfflineOnAudioConflictListener() { // from class: com.kwad.components.ad.reward.m.d.1
            @Override // com.kwad.components.offline.api.core.api.OfflineOnAudioConflictListener
            public final void onAudioBeOccupied() {
                d.a(d.this, true);
                if (d.this.Nx != null) {
                    d.this.Nx.setAudioEnabled(false);
                }
                synchronized (d.this.CF) {
                    Iterator it = d.this.CF.iterator();
                    while (it.hasNext()) {
                        ((j.a) it.next()).onAudioBeOccupied();
                    }
                }
            }

            @Override // com.kwad.components.offline.api.core.api.OfflineOnAudioConflictListener
            public final void onAudioBeReleased() {
                synchronized (d.this.CF) {
                    Iterator it = d.this.CF.iterator();
                    while (it.hasNext()) {
                        ((j.a) it.next()).onAudioBeReleased();
                    }
                }
            }
        };
        this.uj = gVar;
        this.mContext = gVar.mContext;
        this.mVideoPlayConfig = gVar.mVideoPlayConfig;
        this.mVideoPlayerStatus = this.mAdTemplate.mVideoPlayerStatus;
        this.CC = getVideoUrl();
    }

    private void by() {
        if (lq()) {
            return;
        }
        this.Nx.a(new com.kwad.sdk.contentalliance.a.a.b.a(this.mAdTemplate).dQ(this.CC).dR(h.b(com.kwad.sdk.core.response.helper.e.eP(this.mAdTemplate))).a(this.mVideoPlayerStatus).b(com.kwad.sdk.contentalliance.a.a.a.cm(this.mAdTemplate)).IG(), this.mDetailVideoView);
        KsVideoPlayConfig ksVideoPlayConfig = this.mVideoPlayConfig;
        if (ksVideoPlayConfig != null) {
            setAudioEnabled(ksVideoPlayConfig.isVideoSoundEnable(), false);
        }
        this.Nx.prepareAsync();
    }

    private String getVideoUrl() {
        return lq() ? "" : k.j(this.mContext, this.mAdTemplate);
    }

    private boolean lq() {
        return com.kwad.sdk.core.response.helper.a.cY(com.kwad.sdk.core.response.helper.e.eO(this.mAdTemplate));
    }

    private void stop() {
        pause();
        this.nK = true;
    }

    @Override // com.kwad.components.ad.k.b, com.kwad.components.ad.k.a
    public final long getPlayDuration() {
        if (this.CD.get()) {
            return super.getPlayDuration();
        }
        return 0L;
    }

    @Override // com.kwad.components.ad.reward.g.a
    public final void hp() {
        this.CE = false;
    }

    @Override // com.kwad.components.ad.reward.g.a
    public final void hq() {
        if (this.nK) {
            return;
        }
        resume();
        if (this.qO || (com.kwad.components.ad.reward.a.b.hO() && this.CE)) {
            com.kwad.components.core.t.a.aO(this.mContext).bd(com.kwad.components.ad.reward.a.b.hO());
            if (com.kwad.components.ad.reward.a.b.hO() && this.CE) {
                this.CE = false;
                this.qO = true;
                setAudioEnabled(true, false);
            } else {
                if (this.uj.sx || !com.kwad.components.core.t.a.aO(this.mContext).wD()) {
                    return;
                }
                this.qO = false;
                setAudioEnabled(false, false);
            }
        }
    }

    @Override // com.kwad.components.ad.reward.g.a
    public final void hr() {
        pause();
    }

    @Override // com.kwad.components.ad.reward.g.a
    public final void hs() {
        com.kwad.components.core.video.b bVar;
        this.CE = false;
        if (!this.CD.get() || (bVar = this.Nx) == null) {
            return;
        }
        bVar.d(this.qQ);
        this.Nx.release();
    }

    public final void lo() {
        if (this.CD.get()) {
            return;
        }
        this.CD.set(true);
        by();
        m mVar = new m() { // from class: com.kwad.components.ad.reward.m.d.2
            @Override // com.kwad.components.core.video.m, com.kwad.components.core.video.i
            public final void onMediaPlayError(int i, int i2) {
                super.onMediaPlayError(i, i2);
                com.kwad.components.core.p.a.vL().m(d.this.mAdTemplate, i, i2);
            }
        };
        this.qQ = mVar;
        this.Nx.c(mVar);
        this.Nx.a(new com.kwad.sdk.core.video.a.c.e() { // from class: com.kwad.components.ad.reward.m.d.3
            @Override // com.kwad.sdk.core.video.a.c.e
            public final void a(com.kwad.sdk.core.video.a.c cVar) {
                try {
                    com.kwad.sdk.core.c.b.LW();
                    if (com.kwad.sdk.core.c.b.isAppOnForeground()) {
                        d.this.Nx.start();
                    }
                } catch (Throwable th) {
                    ServiceProvider.reportSdkCaughtException(th);
                }
            }
        });
        this.Nx.start();
        com.kwad.components.core.t.a.aO(this.mContext).a(this.CH);
    }

    public final void lp() {
        Iterator<Object> it = this.CG.iterator();
        while (it.hasNext()) {
            it.next();
        }
    }

    @Override // com.kwad.components.ad.k.b, com.kwad.components.ad.k.a
    public final void pause() {
        if (!this.CD.get() || this.Nx == null || lq()) {
            return;
        }
        super.pause();
    }

    @Override // com.kwad.components.ad.k.b, com.kwad.components.ad.k.a
    @MainThread
    public final void release() {
        super.release();
        com.kwad.components.core.t.a.aO(this.mContext).b(this.CH);
    }

    @Override // com.kwad.components.ad.k.b, com.kwad.components.ad.k.a
    public final void resume() {
        this.nK = false;
        if (!this.CD.get() || this.Nx == null || lq() || g.b(this.uj)) {
            return;
        }
        super.resume();
    }

    @Override // com.kwad.components.ad.k.a
    public final void setAudioEnabled(boolean z, boolean z2) {
        this.qO = z;
        if (!this.CD.get() || this.Nx == null) {
            return;
        }
        if (z && z2) {
            com.kwad.components.core.t.a.aO(this.mContext).bd(true);
        }
        this.Nx.setAudioEnabled(z);
    }

    @Override // com.kwad.components.ad.k.a
    @Deprecated
    public final void skipToEnd() {
        com.kwad.components.core.video.b bVar;
        if (!this.CD.get() || (bVar = this.Nx) == null) {
            return;
        }
        bVar.onPlayStateChanged(9);
        stop();
    }

    public static /* synthetic */ boolean a(d dVar, boolean z) {
        dVar.CE = true;
        return true;
    }

    public final void b(j.a aVar) {
        this.CF.remove(aVar);
    }

    public final void a(j.a aVar) {
        this.CF.add(aVar);
    }
}
