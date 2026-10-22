package com.kwad.components.ad.draw.c;

import android.content.Context;
import androidx.annotation.NonNull;
import com.kwad.components.ad.k.b;
import com.kwad.components.core.video.DetailVideoView;
import com.kwad.components.core.video.l;
import com.kwad.components.core.video.m;
import com.kwad.sdk.core.j.c;
import com.kwad.sdk.core.response.helper.e;
import com.kwad.sdk.core.response.helper.h;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.o;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public final class a extends b {
    private boolean fA;
    private int fB;
    public boolean fC;
    public int fD;
    private boolean fE;
    private final c fF;
    private long fw;
    private com.kwad.components.core.widget.a.c fx;
    private com.kwad.sdk.contentalliance.a.a.a fy;
    private boolean fz;
    private Context mContext;

    public a(@NonNull AdTemplate adTemplate, @NonNull com.kwad.components.core.widget.a.c cVar, @NonNull DetailVideoView detailVideoView) {
        super(adTemplate, detailVideoView);
        this.fA = false;
        this.fB = -1;
        this.fC = true;
        this.fD = 0;
        this.fF = new c() { // from class: com.kwad.components.ad.draw.c.a.3
            @Override // com.kwad.sdk.core.j.c
            public final void bA() {
                a.this.pause();
            }

            @Override // com.kwad.sdk.core.j.c
            public final void bz() {
                if (a.this.fy == null) {
                    a aVar = a.this;
                    aVar.fy = com.kwad.sdk.contentalliance.a.a.a.cm(aVar.mAdTemplate);
                    a.this.Nx.a(a.this.fy);
                }
                if (a.this.fE || a.this.fz || !a.this.bv()) {
                    return;
                }
                a.this.resume();
            }
        };
        this.fw = com.kwad.sdk.core.response.helper.a.ae(e.eO(this.mAdTemplate));
        this.fx = cVar;
        this.mContext = detailVideoView.getContext();
        by();
        if (com.kwad.sdk.core.response.helper.a.ci(e.eO(this.mAdTemplate))) {
            this.Nx.setVolume(0.0f, 0.0f);
            this.fA = true;
        }
        this.Nx.a(new com.kwad.sdk.core.video.a.c.e() { // from class: com.kwad.components.ad.draw.c.a.1
            @Override // com.kwad.sdk.core.video.a.c.e
            public final void a(com.kwad.sdk.core.video.a.c cVar2) {
                try {
                    a.this.start(o.fs(a.this.mAdTemplate));
                } catch (Throwable th) {
                    ServiceProvider.reportSdkCaughtException(th);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bv() {
        int i = this.fD;
        if (i == 1) {
            return true;
        }
        if (i != 2) {
            return this.fC;
        }
        return false;
    }

    private void by() {
        this.Nx.a(new com.kwad.sdk.contentalliance.a.a.b.a(this.mAdTemplate).dQ(e.eQ(this.mAdTemplate)).dR(h.b(e.eP(this.mAdTemplate))).a(this.mAdTemplate.mVideoPlayerStatus).b(new com.kwad.sdk.contentalliance.a.a.a(this.mAdTemplate, System.currentTimeMillis())).IG(), this.mDetailVideoView);
        this.Nx.prepareAsync();
        if (this.fB != -1 || this.fA) {
            setVideoSound(!this.fA);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void start(long j) {
        if (this.fx.ah() && bv() && !this.fE) {
            this.Nx.a(new com.kwad.sdk.contentalliance.a.a.a(this.mAdTemplate, j));
            this.Nx.start();
        }
    }

    public final void bu() {
        long jFs = o.fs(this.mAdTemplate);
        if (this.Nx.xm() == null) {
            by();
        }
        start(jFs);
        this.fx.a(this.fF);
        b((l) new m() { // from class: com.kwad.components.ad.draw.c.a.2
            @Override // com.kwad.components.core.video.m, com.kwad.components.core.video.i
            public final void onMediaPlayCompleted() {
                a.a(a.this, true);
            }
        });
    }

    public final void bw() {
        this.fy = null;
        this.fx.b(this.fF);
        this.Nx.release();
    }

    public final boolean bx() {
        return this.fE;
    }

    @Override // com.kwad.components.ad.k.b, com.kwad.components.ad.k.a
    public final void resume() {
        super.resume();
        com.kwad.components.core.t.a.aO(this.mContext).bd(false);
    }

    public final void setVideoSound(boolean z) {
        com.kwad.components.core.video.b bVar = this.Nx;
        if (bVar == null) {
            return;
        }
        if (z) {
            bVar.setVolume(1.0f, 1.0f);
            this.fA = false;
        } else {
            bVar.setVolume(0.0f, 0.0f);
            this.fA = true;
        }
        this.fB = 1;
    }

    public final void g(boolean z) {
        this.fz = z;
    }

    public static /* synthetic */ boolean a(a aVar, boolean z) {
        aVar.fE = true;
        return true;
    }
}
