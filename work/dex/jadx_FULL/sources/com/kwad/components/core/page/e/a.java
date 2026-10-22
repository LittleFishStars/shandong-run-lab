package com.kwad.components.core.page.e;

import android.content.Context;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import com.kwad.components.core.proxy.f;
import com.kwad.components.core.video.DetailVideoView;
import com.kwad.components.core.video.b;
import com.kwad.components.core.video.k;
import com.kwad.components.core.video.l;
import com.kwad.components.core.video.m;
import com.kwad.components.offline.api.core.api.OfflineOnAudioConflictListener;
import com.kwad.sdk.api.KsVideoPlayConfig;
import com.kwad.sdk.core.response.helper.e;
import com.kwad.sdk.core.response.helper.h;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.model.VideoPlayerStatus;
import com.kwad.sdk.core.video.a.c;
import com.kwad.sdk.internal.api.SceneImpl;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.j;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public final class a implements com.kwad.components.core.n.a.a {
    private String CC;
    private boolean CE = false;
    private final List<j.a> CF = new ArrayList();
    private OfflineOnAudioConflictListener CH = new OfflineOnAudioConflictListener() { // from class: com.kwad.components.core.page.e.a.1
        @Override // com.kwad.components.offline.api.core.api.OfflineOnAudioConflictListener
        public final void onAudioBeOccupied() {
            a.a(a.this, true);
            if (a.this.Nx != null) {
                a.this.Nx.setAudioEnabled(false);
            }
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
    private b Nx;
    private AdTemplate mAdTemplate;
    private Context mContext;
    private DetailVideoView mDetailVideoView;
    private KsVideoPlayConfig mVideoPlayConfig;
    private VideoPlayerStatus mVideoPlayerStatus;
    private boolean qO;
    private m qQ;

    public a(@NonNull final AdTemplate adTemplate, @NonNull DetailVideoView detailVideoView, KsVideoPlayConfig ksVideoPlayConfig) {
        this.mVideoPlayConfig = ksVideoPlayConfig;
        this.mAdTemplate = adTemplate;
        Context context = detailVideoView.getContext();
        this.mContext = context;
        this.mVideoPlayerStatus = adTemplate.mVideoPlayerStatus;
        this.CC = k.j(context, adTemplate);
        this.mDetailVideoView = detailVideoView;
        this.Nx = new b(detailVideoView, adTemplate);
        by();
        m mVar = new m() { // from class: com.kwad.components.core.page.e.a.2
            @Override // com.kwad.components.core.video.m, com.kwad.components.core.video.i
            public final void onMediaPlayError(int i, int i2) {
                super.onMediaPlayError(i, i2);
                com.kwad.components.core.p.a.vL().m(adTemplate, i, i2);
            }
        };
        this.qQ = mVar;
        this.Nx.c(mVar);
        this.Nx.a(new c.e() { // from class: com.kwad.components.core.page.e.a.3
            @Override // com.kwad.sdk.core.video.a.c.e
            public final void a(c cVar) {
                try {
                    a.this.Nx.start();
                } catch (Throwable th) {
                    ServiceProvider.reportSdkCaughtException(th);
                }
            }
        });
        com.kwad.components.core.t.a.aO(this.mContext).a(this.CH);
    }

    private void by() {
        this.Nx.a(new com.kwad.sdk.contentalliance.a.a.b.a(this.mAdTemplate).dQ(this.CC).dR(h.b(e.eP(this.mAdTemplate))).a(this.mVideoPlayerStatus).b(com.kwad.sdk.contentalliance.a.a.a.cm(this.mAdTemplate)).IG(), this.mDetailVideoView);
        KsVideoPlayConfig ksVideoPlayConfig = this.mVideoPlayConfig;
        if (ksVideoPlayConfig != null) {
            setAudioEnabled(ksVideoPlayConfig.isVideoSoundEnable(), false);
        }
        this.Nx.prepareAsync();
    }

    private void pause() {
        SceneImpl sceneImpl;
        AdTemplate adTemplate = this.mAdTemplate;
        if (adTemplate.mXiaomiAppStoreDetailViewOpen && (sceneImpl = adTemplate.mAdScene) != null && sceneImpl.getAdStyle() == 2) {
            return;
        }
        this.Nx.pause();
    }

    private void resume() {
        this.Nx.resume();
    }

    private void setAudioEnabled(boolean z, boolean z2) {
        this.qO = z;
        this.Nx.setAudioEnabled(z);
    }

    @Override // com.kwad.components.core.n.a.a
    public final void c(f fVar) {
        resume();
    }

    @Override // com.kwad.components.core.n.a.a
    public final void d(f fVar) {
        pause();
    }

    @Override // com.kwad.components.core.n.a.a
    public final void hk() {
        this.CE = false;
        if (this.Nx.xm() == null) {
            by();
        }
    }

    @Override // com.kwad.components.core.n.a.a
    public final void hl() {
        this.CE = false;
        b bVar = this.Nx;
        if (bVar != null) {
            bVar.d(this.qQ);
            this.Nx.release();
        }
    }

    @MainThread
    public final void release() {
        b bVar = this.Nx;
        if (bVar != null) {
            bVar.clear();
            this.Nx.release();
        }
        com.kwad.components.core.t.a.aO(this.mContext).b(this.CH);
    }

    public static /* synthetic */ boolean a(a aVar, boolean z) {
        aVar.CE = true;
        return true;
    }

    @MainThread
    public final void b(l lVar) {
        if (lVar == null) {
            return;
        }
        this.Nx.d(lVar);
    }

    @MainThread
    public final void a(l lVar) {
        if (lVar == null) {
            return;
        }
        this.Nx.c(lVar);
    }
}
