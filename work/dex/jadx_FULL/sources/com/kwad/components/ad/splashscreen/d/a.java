package com.kwad.components.ad.splashscreen.d;

import android.content.Context;
import android.os.SystemClock;
import androidx.annotation.NonNull;
import com.kwad.components.ad.k.b;
import com.kwad.components.ad.splashscreen.h;
import com.kwad.components.core.video.DetailVideoView;
import com.kwad.components.offline.api.core.api.OfflineOnAudioConflictListener;
import com.kwad.sdk.api.KsVideoPlayConfig;
import com.kwad.sdk.core.j.c;
import com.kwad.sdk.core.response.helper.e;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.model.VideoPlayerStatus;
import com.kwad.sdk.utils.bi;
import com.kwad.sdk.utils.cb;
import com.kwad.sdk.utils.j;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public final class a extends b implements c {
    private String CC;
    private final List<j.a> CF;
    private OfflineOnAudioConflictListener CH;
    public int HI;
    private boolean KN;
    public long KO;
    private Context mContext;
    private KsVideoPlayConfig mVideoPlayConfig;
    private VideoPlayerStatus mVideoPlayerStatus;
    private boolean qO;

    public a(@NonNull AdTemplate adTemplate, @NonNull final DetailVideoView detailVideoView, KsVideoPlayConfig ksVideoPlayConfig) {
        super(adTemplate, detailVideoView);
        this.CF = new ArrayList();
        this.CH = new OfflineOnAudioConflictListener() { // from class: com.kwad.components.ad.splashscreen.d.a.1
            @Override // com.kwad.components.offline.api.core.api.OfflineOnAudioConflictListener
            public final void onAudioBeOccupied() {
                synchronized (a.this.CF) {
                    Iterator it = a.this.CF.iterator();
                    while (it.hasNext()) {
                        ((j.a) it.next()).onAudioBeOccupied();
                    }
                }
            }

            @Override // com.kwad.components.offline.api.core.api.OfflineOnAudioConflictListener
            public final void onAudioBeReleased() {
                synchronized (a.this.CF) {
                    Iterator it = a.this.CF.iterator();
                    while (it.hasNext()) {
                        ((j.a) it.next()).onAudioBeReleased();
                    }
                }
            }
        };
        this.mVideoPlayConfig = ksVideoPlayConfig;
        this.mContext = detailVideoView.getContext();
        String strBf = com.kwad.sdk.core.response.helper.a.bf(e.eO(adTemplate));
        this.mVideoPlayerStatus = adTemplate.mVideoPlayerStatus;
        e.eO(adTemplate);
        this.HI = h.aj(adTemplate) ? 2 : 1;
        File fileCO = com.kwad.sdk.core.diskcache.b.a.Lx().cO(strBf);
        if (fileCO != null && fileCO.exists()) {
            this.CC = fileCO.getAbsolutePath();
        }
        this.Nx.a(new com.kwad.sdk.core.video.a.c.e() { // from class: com.kwad.components.ad.splashscreen.d.a.2
            @Override // com.kwad.sdk.core.video.a.c.e
            public final void a(com.kwad.sdk.core.video.a.c cVar) {
                com.kwad.sdk.core.d.c.d("SplashPlayModule", " onPrepared");
                detailVideoView.post(new bi() { // from class: com.kwad.components.ad.splashscreen.d.a.2.1
                    @Override // com.kwad.sdk.utils.bi
                    public final void doTask() {
                        long jElapsedRealtime = SystemClock.elapsedRealtime();
                        com.kwad.components.ad.splashscreen.monitor.b.mv();
                        AdTemplate adTemplate2 = a.this.mAdTemplate;
                        a aVar = a.this;
                        com.kwad.components.ad.splashscreen.monitor.b.a(adTemplate2, 1, aVar.HI, 2, jElapsedRealtime - aVar.KO, jElapsedRealtime - aVar.mAdTemplate.showTime);
                        boolean zA = cb.a(detailVideoView, 50, true);
                        com.kwad.sdk.core.d.c.d("SplashPlayModule", " onPrepared" + zA);
                        if (zA) {
                            a.this.Nx.start();
                        }
                    }
                });
            }
        });
        com.kwad.components.core.t.a.aO(this.mContext).a(this.CH);
    }

    private void by() {
        com.kwad.sdk.contentalliance.a.a.b bVarIG = new com.kwad.sdk.contentalliance.a.a.b.a(this.mAdTemplate).a(this.mVideoPlayerStatus).dQ(this.CC).dR(com.kwad.sdk.core.response.helper.h.b(e.eP(this.mAdTemplate))).b(com.kwad.sdk.contentalliance.a.a.a.cm(this.mAdTemplate)).IG();
        this.KO = SystemClock.elapsedRealtime();
        com.kwad.components.ad.splashscreen.monitor.b.mv();
        com.kwad.components.ad.splashscreen.monitor.b.k(this.mAdTemplate, 1, this.HI);
        this.Nx.a(bVarIG, this.mDetailVideoView);
        KsVideoPlayConfig ksVideoPlayConfig = this.mVideoPlayConfig;
        if (ksVideoPlayConfig != null) {
            setAudioEnabled(ksVideoPlayConfig.isVideoSoundEnable(), false);
        }
        this.Nx.prepareAsync();
    }

    public final void ah(boolean z) {
        this.KN = true;
    }

    @Override // com.kwad.sdk.core.j.c
    public final void bA() {
        pause();
    }

    @Override // com.kwad.sdk.core.j.c
    public final void bz() {
        resume();
    }

    public final long getCurrentPosition() {
        return this.Nx.getCurrentPosition();
    }

    public final void nQ() {
        if (this.Nx.xm() == null) {
            by();
        }
        this.Nx.start();
    }

    @Override // com.kwad.components.ad.k.b, com.kwad.components.ad.k.a
    public final void release() {
        super.release();
        com.kwad.components.core.t.a.aO(this.mContext).b(this.CH);
    }

    @Override // com.kwad.components.ad.k.b, com.kwad.components.ad.k.a
    public final void resume() {
        super.resume();
        if (this.qO && this.KN) {
            com.kwad.components.core.t.a.aO(this.mContext).bd(false);
            if (com.kwad.components.core.t.a.aO(this.mContext).wD()) {
                this.qO = false;
                setAudioEnabled(false, false);
            }
        }
    }

    @Override // com.kwad.components.ad.k.a
    public final void setAudioEnabled(boolean z, boolean z2) {
        this.qO = z;
        if (z && z2) {
            com.kwad.components.core.t.a.aO(this.mContext).bd(true);
        }
        this.Nx.setAudioEnabled(z);
    }

    public final void a(j.a aVar) {
        this.CF.add(aVar);
    }

    public final void b(j.a aVar) {
        this.CF.remove(aVar);
    }
}
