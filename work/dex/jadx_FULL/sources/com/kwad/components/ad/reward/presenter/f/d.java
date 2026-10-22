package com.kwad.components.ad.reward.presenter.f;

import android.content.DialogInterface;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.camera.video.AudioStats;
import com.kwad.components.ad.reward.RewardRenderResult;
import com.kwad.components.ad.reward.e.l;
import com.kwad.components.ad.reward.k.i;
import com.kwad.components.ad.reward.k.j;
import com.kwad.components.ad.reward.k.k;
import com.kwad.components.core.playable.PlayableSource;
import com.kwad.components.core.video.m;
import com.kwad.components.core.webview.jshandler.ah;
import com.kwad.components.core.webview.jshandler.ak;
import com.kwad.components.core.webview.jshandler.az;
import com.kwad.components.core.webview.jshandler.bj;
import com.kwad.components.core.webview.tachikoma.TKRenderFailReason;
import com.kwad.components.core.webview.tachikoma.b.o;
import com.kwad.components.core.webview.tachikoma.b.p;
import com.kwad.components.core.webview.tachikoma.b.y;
import com.kwad.components.core.webview.tachikoma.c.n;
import com.kwad.components.core.webview.tachikoma.c.q;
import com.kwad.components.core.webview.tachikoma.c.r;
import com.kwad.components.core.webview.tachikoma.c.u;
import com.kwad.components.core.webview.tachikoma.c.z;
import com.kwad.sdk.commercial.model.WebCloseStatus;
import com.kwad.sdk.components.t;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.model.TKAdLiveShopItemInfo;
import com.kwad.sdk.utils.bi;
import com.kwad.sdk.utils.by;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public abstract class d extends com.kwad.components.ad.reward.presenter.b implements DialogInterface.OnDismissListener, com.kwad.components.ad.reward.k.a.e, y.a {
    protected com.kwad.components.ad.reward.k.a.d AI;
    private p AJ;
    private o AK;
    private i AL;
    private j AM;
    private z AN;
    private boolean AO;
    private com.kwad.components.core.webview.tachikoma.b.h AP;

    @Nullable
    protected e AQ;
    private bj.b AR = new bj.b() { // from class: com.kwad.components.ad.reward.presenter.f.d.1
        @Override // com.kwad.components.core.webview.jshandler.bj.b
        public final void ao(int i) {
            com.kwad.sdk.core.adlog.c.b bVarF = new com.kwad.sdk.core.adlog.c.b().ec(i).f(d.this.uj.mRootContainer.getTouchCoords());
            com.kwad.components.core.e.d.a.a(new com.kwad.components.core.e.d.a.C1201a(d.this.getContext()).aJ(d.this.uj.mAdTemplate).b(d.this.uj.mApkDownloadHelper).as(false));
            com.kwad.components.ad.reward.j.b.a(d.this.uj.mAdTemplate, d.this.kr(), (String) null, bVarF, (JSONObject) null);
        }
    };
    private final com.kwad.sdk.utils.j.a kF = new com.kwad.sdk.utils.j.a() { // from class: com.kwad.components.ad.reward.presenter.f.d.5
        @Override // com.kwad.sdk.utils.j.a
        public final void onAudioBeOccupied() {
            if (d.this.AK == null || com.kwad.components.ad.reward.a.b.hO()) {
                return;
            }
            n nVar = new n();
            nVar.aut = true;
            d.this.AK.c(nVar);
        }

        @Override // com.kwad.sdk.utils.j.a
        public final void onAudioBeReleased() {
        }
    };
    private final l mRewardVerifyListener = new l() { // from class: com.kwad.components.ad.reward.presenter.f.d.6
        @Override // com.kwad.components.ad.reward.e.l
        public final void onRewardVerify() {
            if (d.this.AL != null) {
                com.kwad.components.core.webview.tachikoma.c.h hVar = new com.kwad.components.core.webview.tachikoma.c.h();
                hVar.aum = 1;
                d.this.AL.a(hVar);
            }
        }
    };
    private final com.kwad.components.ad.reward.e.g mPlayEndPageListener = new com.kwad.components.ad.reward.e.a() { // from class: com.kwad.components.ad.reward.presenter.f.d.7
        @Override // com.kwad.components.ad.reward.e.g
        public final void dd() {
            if (d.this.AM != null) {
                by.runOnUiThreadDelay(new bi() { // from class: com.kwad.components.ad.reward.presenter.f.d.7.1
                    @Override // com.kwad.sdk.utils.bi
                    public final void doTask() {
                        com.kwad.components.core.webview.tachikoma.c.p pVar = new com.kwad.components.core.webview.tachikoma.c.p();
                        pVar.scene = 1;
                        d.this.AM.a(pVar);
                        if (d.this.AP != null) {
                            d.this.AP.bn(d.this.uj.ts);
                        }
                    }
                }, 0L);
            }
        }
    };
    private final m kf = new m() { // from class: com.kwad.components.ad.reward.presenter.f.d.8
        @Override // com.kwad.components.core.video.m, com.kwad.components.core.video.i
        public final void onMediaPlayCompleted() {
            d.this.iT();
        }

        @Override // com.kwad.components.core.video.m, com.kwad.components.core.video.i
        public final void onMediaPlayError(int i, int i2) {
            d.this.kp();
        }

        @Override // com.kwad.components.core.video.m, com.kwad.components.core.video.i
        public final void onMediaPlayProgress(long j, long j2) {
            d.this.a(j, j2);
        }

        @Override // com.kwad.components.core.video.m, com.kwad.components.core.video.i
        public final void onMediaPlayStart() {
            d.this.e(AudioStats.AUDIO_AMPLITUDE_NONE);
        }

        @Override // com.kwad.components.core.video.m, com.kwad.components.core.video.i
        public final void onMediaPreparing() {
            d.this.e(AudioStats.AUDIO_AMPLITUDE_NONE);
        }
    };

    public d() {
        if (ki()) {
            this.AQ = new e();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void iT() {
        if (this.uj.sT) {
            kp();
        } else {
            ko();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void kj() {
        com.kwad.components.ad.reward.g gVar = this.uj;
        com.kwad.sdk.core.adlog.c.b(gVar.mAdTemplate, 17, gVar.mReportExtData);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void kk() {
        this.uj.E(kr());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void kl() {
        com.kwad.components.ad.reward.j.b.a(this.uj.mAdTemplate, kr(), "endTopBar", new com.kwad.sdk.core.adlog.c.b().ec(39).f(this.uj.mRootContainer.getTouchCoords()), this.uj.mReportExtData);
        this.uj.sy.dc();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void km() {
        com.kwad.components.ad.reward.j.b.a(this.uj.mAdTemplate, kr(), (String) null, new com.kwad.sdk.core.adlog.c.b().ec(40).f(this.uj.mRootContainer.getTouchCoords()), this.uj.mReportExtData);
        this.uj.sy.dc();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void kn() {
        com.kwad.components.ad.reward.j.b.a(this.uj.mAdTemplate, kr(), (String) null, new com.kwad.sdk.core.adlog.c.b().ec(41).f(this.uj.mRootContainer.getTouchCoords()), this.uj.mReportExtData);
        this.uj.sy.dc();
    }

    private void ko() {
        z zVar = this.AN;
        zVar.ajf = true;
        zVar.auB = false;
        zVar.rq = com.kwad.sdk.core.response.helper.a.N(com.kwad.sdk.core.response.helper.e.eO(this.uj.mAdTemplate));
        kq();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void kp() {
        z zVar = this.AN;
        zVar.auB = true;
        zVar.ajf = false;
        kq();
    }

    private void kq() {
        z zVar;
        p pVar = this.AJ;
        if (pVar == null || (zVar = this.AN) == null) {
            return;
        }
        pVar.a(zVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String kr() {
        com.kwad.components.ad.reward.k.a.d dVar = this.AI;
        if (dVar == null) {
            return null;
        }
        return dVar.getTkTemplateId();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyRewardVerify() {
        this.uj.sy.onRewardVerify();
    }

    public void a(WebCloseStatus webCloseStatus) {
    }

    public void aE() {
        e eVar = this.AQ;
        if (eVar != null) {
            eVar.aE();
        }
    }

    public void aF() {
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final void aG() {
    }

    @Override // com.kwad.components.ad.reward.presenter.b, com.kwad.sdk.mvp.Presenter
    public void ay() {
        super.ay();
        this.AO = true;
        this.uj.a(this);
        if (this.AI == null) {
            this.AI = new com.kwad.components.ad.reward.k.a.d(this.uj, -1L, getContext());
        }
        if (this.AN == null) {
            this.AN = new z();
        }
        this.AI.a(this.uj.getActivity(), this.uj.mAdResultData, this);
        e eVar = this.AQ;
        if (eVar != null) {
            eVar.A(this.uj);
        }
    }

    public void g(AdTemplate adTemplate) {
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public String getRegisterViewKey() {
        return null;
    }

    public com.kwad.sdk.widget.g getTouchCoordsView() {
        return this.uj.mRootContainer;
    }

    public boolean ki() {
        return false;
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        com.kwad.components.ad.reward.k.a.d dVar = this.AI;
        if (dVar == null || dVar.kT() == null) {
            return;
        }
        this.AI.kT().im();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void onUnbind() {
        super.onUnbind();
        if (this.AO) {
            e eVar = this.AQ;
            if (eVar != null) {
                eVar.B(this.uj);
            }
            this.uj.b(this);
            com.kwad.components.ad.reward.k.a.d dVar = this.AI;
            if (dVar != null) {
                dVar.kV();
            }
            com.kwad.components.ad.reward.m.e eVar2 = this.uj.sz;
            if (eVar2 != null) {
                eVar2.b(this.kf);
                this.uj.sz.b(this.kF);
            }
            com.kwad.components.ad.reward.b.gw().b(this.mRewardVerifyListener);
            this.uj.c(this.mPlayEndPageListener);
        }
    }

    private void d(long j, long j2) {
        long jMin = Math.min(com.kwad.sdk.core.response.helper.a.ak(this.uj.mAdTemplate.adInfoList.get(0)), j);
        if (j2 < jMin - 800) {
            this.uj.tk = (int) (((jMin - j2) / 1000.0f) + 0.5f);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(double d) {
        z zVar = this.AN;
        zVar.auB = false;
        zVar.ajf = false;
        zVar.rq = (int) ((d / 1000.0d) + 0.5d);
        kq();
    }

    public void a(t tVar, com.kwad.sdk.core.webview.b bVar) {
        k kVar = new k();
        kVar.a(new k.a() { // from class: com.kwad.components.ad.reward.presenter.f.d.9
            @Override // com.kwad.components.ad.reward.k.k.a
            public final void d(r rVar) {
                com.kwad.components.ad.reward.c.gz().c(rVar);
            }
        });
        tVar.c(kVar);
        long j = this.uj.tm;
        tVar.c(new com.kwad.components.ad.reward.k.g(j > 0 ? ((int) j) / 1000 : 0));
        i iVar = new i();
        this.AL = iVar;
        tVar.c(iVar);
        j jVar = new j();
        this.AM = jVar;
        tVar.c(jVar);
        com.kwad.components.ad.reward.b.gw().a(this.mRewardVerifyListener);
        this.uj.b(this.mPlayEndPageListener);
        tVar.c(new ak(new ak.b() { // from class: com.kwad.components.ad.reward.presenter.f.d.10
            @Override // com.kwad.components.core.webview.jshandler.ak.b
            public final void a(ak.a aVar) {
                d.this.getTKContainer().setVisibility(8);
            }
        }));
        com.kwad.components.ad.reward.k.d dVar = new com.kwad.components.ad.reward.k.d();
        dVar.a(new com.kwad.components.ad.reward.k.d.a() { // from class: com.kwad.components.ad.reward.presenter.f.d.11
            @Override // com.kwad.components.ad.reward.k.d.a
            public final void a(final q qVar) {
                com.kwad.components.core.e.d.a.a(new com.kwad.components.core.e.d.a.C1201a(d.this.getContext()).aJ(d.this.uj.mAdTemplate).b(d.this.uj.mApkDownloadHelper).aN(1).a(new com.kwad.components.core.e.d.a.b() { // from class: com.kwad.components.ad.reward.presenter.f.d.11.1
                    @Override // com.kwad.components.core.e.d.a.b
                    public final void onAdClicked() {
                        if (qVar.auv) {
                            d.this.kl();
                        } else {
                            d.this.km();
                        }
                    }
                }));
            }
        });
        tVar.c(dVar);
        com.kwad.components.ad.reward.k.e eVar = new com.kwad.components.ad.reward.k.e();
        eVar.a(new com.kwad.components.ad.reward.k.e.a() { // from class: com.kwad.components.ad.reward.presenter.f.d.12
            @Override // com.kwad.components.ad.reward.k.e.a
            public final void ks() {
                com.kwad.components.core.e.d.a.a(new com.kwad.components.core.e.d.a.C1201a(d.this.getContext()).aJ(d.this.uj.mAdTemplate).b(d.this.uj.mApkDownloadHelper).aN(2).a(new com.kwad.components.core.e.d.a.b() { // from class: com.kwad.components.ad.reward.presenter.f.d.12.1
                    @Override // com.kwad.components.core.e.d.a.b
                    public final void onAdClicked() {
                        d.this.kn();
                    }
                }));
            }
        });
        tVar.c(eVar);
        tVar.c(new com.kwad.components.ad.reward.k.h(new com.kwad.components.ad.reward.k.h.a() { // from class: com.kwad.components.ad.reward.presenter.f.d.13
            @Override // com.kwad.components.ad.reward.k.h.a
            public final void ap(int i) {
                if (com.kwad.components.ad.reward.g.T(d.this.uj.mAdTemplate)) {
                    if (!com.kwad.components.ad.reward.g.R(d.this.uj.mAdTemplate) || d.this.uj.ti == null) {
                        if (com.kwad.components.ad.reward.g.S(d.this.uj.mAdTemplate) && d.this.uj.tj != null && !d.this.uj.tj.lh()) {
                            d.this.uj.tj.lg();
                        }
                    } else if (!d.this.uj.ti.lh()) {
                        d.this.uj.ti.lg();
                    }
                }
                if (d.this.uj.he() != RewardRenderResult.DEFAULT) {
                    d.this.uj.sY = i;
                }
                d.this.notifyRewardVerify();
            }
        }));
        tVar.c(new com.kwad.components.ad.reward.k.c() { // from class: com.kwad.components.ad.reward.presenter.f.d.14
            @Override // com.kwad.components.ad.reward.k.c
            public final void kt() {
                super.kt();
                d.this.kk();
            }
        });
        tVar.c(new com.kwad.components.ad.reward.k.f() { // from class: com.kwad.components.ad.reward.presenter.f.d.15
            @Override // com.kwad.components.ad.reward.k.f
            public final void W(boolean z) {
                super.W(z);
                com.kwad.components.ad.reward.presenter.f.v(d.this.uj);
            }
        });
        tVar.c(new com.kwad.components.ad.reward.k.b() { // from class: com.kwad.components.ad.reward.presenter.f.d.16
            @Override // com.kwad.components.ad.reward.k.b
            public final void kt() {
                super.kt();
                d.this.kj();
            }
        });
        tVar.c(new com.kwad.components.core.webview.tachikoma.b.q() { // from class: com.kwad.components.ad.reward.presenter.f.d.2
            @Override // com.kwad.components.core.webview.tachikoma.b.q, com.kwad.sdk.core.webview.c.a
            public final void a(String str, @NonNull com.kwad.sdk.core.webview.c.c cVar) {
                super.a(str, cVar);
                com.kwad.components.core.t.n.i(d.this.getContext(), d.this.uj.mAdTemplate);
            }
        });
        tVar.c(new com.kwad.components.ad.reward.i.b(getContext(), this.uj.mAdTemplate, PlayableSource.ACTIONBAR_CLICK));
        com.kwad.components.core.webview.tachikoma.b.h hVar = new com.kwad.components.core.webview.tachikoma.b.h();
        this.AP = hVar;
        hVar.a(new com.kwad.components.core.webview.tachikoma.b.h.a() { // from class: com.kwad.components.ad.reward.presenter.f.d.3
            @Override // com.kwad.components.core.webview.tachikoma.b.h.a
            public final void a(com.kwad.components.core.webview.tachikoma.b.h hVar2) {
                hVar2.bn(d.this.uj.ts);
            }
        });
        tVar.c(this.AP);
        tVar.c(new ah());
        tVar.c(new bj(bVar, this.uj.mApkDownloadHelper, this.AR));
        tVar.c(new y(this));
    }

    public void a(p pVar) {
        this.AJ = pVar;
        com.kwad.components.ad.reward.m.e eVar = this.uj.sz;
        if (eVar != null) {
            eVar.a(this.kf);
        }
    }

    public void a(u uVar) {
        com.kwad.components.ad.reward.presenter.f.a(this.uj, false);
    }

    public void a(TKRenderFailReason tKRenderFailReason) {
        e eVar = this.AQ;
        if (eVar != null) {
            eVar.kv();
        }
    }

    public void a(az azVar) {
        e eVar = this.AQ;
        if (eVar != null) {
            eVar.b(azVar);
        }
    }

    /* JADX WARN: Code duplicated, block: B:31:0x0069  */
    @Override // com.kwad.components.core.webview.tachikoma.j
    public final void a(com.kwad.components.core.webview.jshandler.a.C1235a c1235a) {
        com.kwad.components.ad.reward.g gVar = this.uj;
        if (gVar == null || gVar.sy == null) {
            return;
        }
        try {
            com.kwad.components.core.webview.jshandler.a.c cVar = new com.kwad.components.core.webview.jshandler.a.c();
            cVar.parseJson(new JSONObject(c1235a.apt));
            switch (c1235a.aps) {
                case "adClickCallback":
                    this.uj.sy.dc();
                    break;
                case "videoPlayStartCallback":
                    this.uj.sy.onVideoPlayStart();
                    break;
                case "videoPlayErrorCallback":
                    this.uj.sy.onVideoPlayError(cVar.errorCode, cVar.apu);
                    break;
                case "videoPlayEndCallback":
                    this.uj.sy.onVideoPlayEnd();
                    break;
                case "adSkipWithPlayTimeCallback":
                    this.uj.sy.onVideoSkipToEnd(cVar.apv);
                    break;
                case "adCloseCallback":
                    this.uj.sy.i(cVar.apw);
                    break;
                case "rewardVerifyCallback":
                    this.uj.sy.onRewardVerify();
                    break;
            }
        } catch (Throwable th) {
            com.kwad.sdk.core.d.c.e("TKBasePresenter", "onOutCallback Error: " + th.getMessage());
        }
    }

    public void a(n nVar) {
        com.kwad.components.ad.reward.m.e eVar = this.uj.sz;
        if (eVar != null) {
            eVar.setAudioEnabled(!nVar.aut, true);
        }
    }

    public void a(@Nullable com.kwad.sdk.core.webview.d.b.a aVar) {
        this.uj.sy.dc();
    }

    public final void a(com.kwad.components.ad.reward.c.b bVar) {
        com.kwad.components.ad.reward.g gVar = this.uj;
        if (gVar != null) {
            gVar.b(bVar);
        }
    }

    public void a(o oVar) {
        this.AK = oVar;
        com.kwad.components.ad.reward.m.e eVar = this.uj.sz;
        if (eVar != null) {
            eVar.a(this.kF);
        }
        by.runOnUiThread(new bi() { // from class: com.kwad.components.ad.reward.presenter.f.d.4
            @Override // com.kwad.sdk.utils.bi
            public final void doTask() {
                boolean z = com.kwad.components.core.t.a.aO(d.this.getContext()).wD() || !d.this.uj.mVideoPlayConfig.isVideoSoundEnable();
                n nVar = new n();
                nVar.aut = z;
                d.this.AK.c(nVar);
                if (d.this.uj.sz != null) {
                    d.this.uj.sz.setAudioEnabled(!z, false);
                }
            }
        });
    }

    public final void a(long j, long j2) {
        d(j, j2);
        e(j2);
    }

    @Override // com.kwad.components.core.webview.tachikoma.b.y.a
    public final void a(TKAdLiveShopItemInfo tKAdLiveShopItemInfo) {
        this.uj.mAdTemplate.tkLiveShopItemInfo = tKAdLiveShopItemInfo;
    }
}
