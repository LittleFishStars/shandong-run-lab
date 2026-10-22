package com.kwad.components.ad.reward.presenter.h;

import android.content.DialogInterface;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.components.ad.reward.k.a.d;
import com.kwad.components.ad.reward.m.e;
import com.kwad.components.ad.reward.presenter.f.g;
import com.kwad.components.ad.reward.presenter.i;
import com.kwad.components.core.n.a.b;
import com.kwad.components.core.video.m;
import com.kwad.components.core.webview.jshandler.ae;
import com.kwad.components.core.webview.jshandler.az;
import com.kwad.components.core.webview.tachikoma.TKRenderFailReason;
import com.kwad.components.core.webview.tachikoma.b.o;
import com.kwad.components.core.webview.tachikoma.b.p;
import com.kwad.components.core.webview.tachikoma.c.n;
import com.kwad.components.core.webview.tachikoma.c.u;
import com.kwad.components.core.webview.tachikoma.c.w;
import com.kwad.components.core.webview.tachikoma.f;
import com.kwad.components.core.webview.tachikoma.j;
import com.kwad.sdk.R;
import com.kwad.sdk.commercial.model.WebCloseStatus;
import com.kwad.sdk.components.t;
import com.kwad.sdk.core.d.c;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.as;
import com.kwad.sdk.utils.au;
import com.kwad.sdk.utils.bt;
import com.kwad.sdk.utils.by;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public final class a extends g implements j {
    private d AI;
    private boolean Bu;
    private f Bv;
    private long Bw;
    private AdInfo mAdInfo;
    private boolean yc;
    private boolean yd;
    private com.kwad.components.ad.reward.g.b ye = new com.kwad.components.ad.reward.g.b() { // from class: com.kwad.components.ad.reward.presenter.h.a.1
        @Override // com.kwad.components.ad.reward.g.b
        public final boolean interceptPlayCardResume() {
            return a.this.Ba != null && a.this.Ba.getVisibility() == 0;
        }
    };
    private final com.kwad.components.core.n.a.a wH = new b() { // from class: com.kwad.components.ad.reward.presenter.h.a.2
        @Override // com.kwad.components.core.n.a.b, com.kwad.components.core.n.a.a
        public final void c(com.kwad.components.core.proxy.f fVar) {
            a.this.Bu = false;
            if (a.this.Bv == null) {
                return;
            }
            w wVar = new w();
            if (com.kwad.components.core.r.a.wm().ws()) {
                com.kwad.components.core.r.a.wm().bc(false);
                if (com.kwad.sdk.core.response.helper.a.aT(a.this.mAdInfo) == 0) {
                    wVar.auy = 1;
                    a.this.Bv.a(wVar);
                    return;
                } else if (com.kwad.components.core.r.a.wm().wo()) {
                    wVar.auy = 1;
                    a.this.Bv.a(wVar);
                    return;
                } else {
                    wVar.auy = 0;
                    a.this.Bv.a(wVar);
                    return;
                }
            }
            if (com.kwad.components.core.r.a.wm().wq() && com.kwad.sdk.core.response.helper.a.aT(a.this.mAdInfo) == 1) {
                if (com.kwad.components.core.r.a.wm().wr() != 1) {
                    if (com.kwad.components.core.r.a.wm().wr() == 3) {
                        wVar.auy = 1;
                        com.kwad.components.core.r.a.wm().bV(0);
                        a.this.Bv.a(wVar);
                        return;
                    }
                    return;
                }
                if (!au.aw(a.this.getContext(), com.kwad.sdk.core.response.helper.a.aE(a.this.mAdInfo))) {
                    wVar.auy = 0;
                    a.this.Bv.a(wVar);
                } else {
                    wVar.auy = 2;
                    com.kwad.components.core.r.a.wm().bV(2);
                    a.this.Bv.a(wVar);
                }
            }
        }

        @Override // com.kwad.components.core.n.a.b, com.kwad.components.core.n.a.a
        public final void d(com.kwad.components.core.proxy.f fVar) {
            super.d(fVar);
            a.this.Bu = true;
        }
    };
    private final m kf = new m() { // from class: com.kwad.components.ad.reward.presenter.h.a.3
        @Override // com.kwad.components.core.video.m, com.kwad.components.core.video.i
        public final void onMediaPlayProgress(long j, long j2) {
            super.onMediaPlayProgress(j, j2);
            long jH = com.kwad.components.ad.reward.g.h(a.this.mAdInfo);
            long jAS = ((long) com.kwad.sdk.core.response.helper.a.aS(a.this.mAdInfo)) * 1000;
            if (j2 <= a.this.Bw || jH - j2 <= jAS || a.this.yc) {
                return;
            }
            if (com.kwad.sdk.core.response.helper.a.aT(a.this.mAdInfo) == 1) {
                if (au.aw(a.this.getContext(), com.kwad.sdk.core.response.helper.a.aE(a.this.mAdInfo))) {
                    return;
                }
            } else if (a.this.uj.jh) {
                return;
            }
            a.b(a.this, true);
            a.this.AI.a(a.this.uj.getActivity(), a.this.uj.mAdResultData, a.this);
            a.this.kA();
        }
    };

    private void iT() {
        boolean z = i.z(this.uj);
        c.d("jky", "onPlayCompleted: " + z);
        if (z) {
            by.runOnUiThreadDelay(new Runnable() { // from class: com.kwad.components.ad.reward.presenter.h.a.6
                @Override // java.lang.Runnable
                public final void run() {
                    if (a.this.uj.sy != null) {
                        a.this.uj.sy.onRewardVerify();
                    }
                    a.this.uj.sz.pause();
                    a.this.uj.gW();
                }
            }, 200L);
            return;
        }
        com.kwad.components.ad.reward.e.b bVar = this.uj.sy;
        if (bVar != null) {
            bVar.onRewardVerify();
        }
        this.uj.sz.pause();
        this.uj.gW();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void kA() {
        this.Ba.setVisibility(0);
        e eVar = this.uj.sz;
        if (eVar != null) {
            eVar.pause();
        }
        this.yd = true;
    }

    private f kB() {
        return new f() { // from class: com.kwad.components.ad.reward.presenter.h.a.5
            @Override // com.kwad.components.core.webview.tachikoma.b.w, com.kwad.sdk.core.webview.c.a
            public final void a(String str, @NonNull com.kwad.sdk.core.webview.c.c cVar) {
                super.a(str, cVar);
            }
        };
    }

    @Override // com.kwad.components.ad.reward.presenter.f.d, com.kwad.components.core.webview.tachikoma.j
    public final void a(az azVar) {
    }

    @Override // com.kwad.components.ad.reward.presenter.f.d, com.kwad.components.core.webview.tachikoma.j
    public final void a(o oVar) {
    }

    @Override // com.kwad.components.ad.reward.presenter.f.d, com.kwad.components.core.webview.tachikoma.j
    public final void a(p pVar) {
    }

    @Override // com.kwad.components.ad.reward.presenter.f.d, com.kwad.components.core.webview.tachikoma.j
    public final void a(n nVar) {
    }

    @Override // com.kwad.components.ad.reward.presenter.f.d, com.kwad.components.core.webview.tachikoma.j
    public final void a(u uVar) {
    }

    @Override // com.kwad.components.ad.reward.presenter.f.d, com.kwad.components.core.webview.tachikoma.j
    public final void aF() {
    }

    @Override // com.kwad.components.ad.reward.presenter.f.d, com.kwad.components.ad.reward.presenter.b, com.kwad.sdk.mvp.Presenter
    public final void ay() {
        super.ay();
        getContext();
        if (as.VM()) {
            this.Bu = false;
            c.d("TkRewardVideoTaskPresenter", "onBind: ");
            if (this.AI == null) {
                this.AI = new d(this.uj, -1L, getContext(), new DialogInterface.OnDismissListener() { // from class: com.kwad.components.ad.reward.presenter.h.a.4
                    @Override // android.content.DialogInterface.OnDismissListener
                    public final void onDismiss(DialogInterface dialogInterface) {
                        if (a.this.Bv == null) {
                            return;
                        }
                        w wVar = new w();
                        if (com.kwad.components.core.r.a.wm().ws()) {
                            com.kwad.components.core.r.a.wm().bc(false);
                            if (com.kwad.sdk.core.response.helper.a.aT(a.this.mAdInfo) == 0) {
                                wVar.auy = 1;
                                a.this.Bv.a(wVar);
                                return;
                            } else if (com.kwad.components.core.r.a.wm().wo()) {
                                wVar.auy = 1;
                                a.this.Bv.a(wVar);
                                return;
                            } else {
                                wVar.auy = 0;
                                a.this.Bv.a(wVar);
                                return;
                            }
                        }
                        if (com.kwad.components.core.r.a.wm().wq() && com.kwad.sdk.core.response.helper.a.aT(a.this.mAdInfo) == 1) {
                            if (com.kwad.components.core.r.a.wm().wr() == 1) {
                                if (au.aw(a.this.getContext(), com.kwad.sdk.core.response.helper.a.aE(a.this.mAdInfo))) {
                                    return;
                                }
                                wVar.auy = 0;
                                a.this.Bv.a(wVar);
                                return;
                            }
                            if (com.kwad.components.core.r.a.wm().wr() == 3) {
                                wVar.auy = 1;
                                com.kwad.components.core.r.a.wm().bV(0);
                                a.this.Bv.a(wVar);
                            }
                        }
                    }
                });
            }
            AdInfo adInfoEO = com.kwad.sdk.core.response.helper.e.eO(this.uj.mAdTemplate);
            this.mAdInfo = adInfoEO;
            this.Bw = ((long) com.kwad.sdk.core.response.helper.a.aR(adInfoEO)) * 1000;
            e eVar = this.uj.sz;
            if (eVar != null) {
                eVar.a(this.kf);
            }
            this.uj.a(this.ye);
            this.uj.abk.add(this.wH);
        }
    }

    @Override // com.kwad.components.ad.reward.presenter.f.d, com.kwad.components.core.webview.tachikoma.j
    public final void g(AdTemplate adTemplate) {
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final String getTKReaderScene() {
        return "tk_reward_task_card";
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final String getTkTemplateId() {
        return com.kwad.sdk.core.response.helper.b.el(this.uj.mAdTemplate);
    }

    @Override // com.kwad.components.ad.reward.presenter.f.d, com.kwad.components.core.webview.tachikoma.j
    public final com.kwad.sdk.widget.g getTouchCoordsView() {
        return this.uj.mRootContainer;
    }

    @Override // com.kwad.components.ad.reward.presenter.f.g
    public final int jj() {
        return R.id.ksad_js_task;
    }

    @Override // com.kwad.components.ad.reward.presenter.f.d, com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        e eVar = this.uj.sz;
        if (eVar != null) {
            eVar.b(this.kf);
        }
        this.uj.b(this.ye);
        this.uj.abk.remove(this.wH);
        d dVar = this.AI;
        if (dVar != null) {
            dVar.kV();
            this.AI = null;
        }
        this.Ba.setVisibility(8);
        com.kwad.components.core.r.a.wm().clear();
        this.yc = false;
        this.yd = false;
        this.Bu = false;
    }

    public static /* synthetic */ boolean b(a aVar, boolean z) {
        aVar.yc = true;
        return true;
    }

    @Override // com.kwad.components.ad.reward.presenter.f.d, com.kwad.components.core.webview.tachikoma.j
    public final void a(TKRenderFailReason tKRenderFailReason) {
        c.d("TkRewardVideoTaskPresenter", "onTkLoadFailed: ");
        this.Ba.setVisibility(8);
    }

    @Override // com.kwad.components.ad.reward.presenter.f.d, com.kwad.components.core.webview.tachikoma.j
    public final void a(t tVar, com.kwad.sdk.core.webview.b bVar) {
        f fVarKB = kB();
        this.Bv = fVarKB;
        tVar.c(fVarKB);
    }

    @Override // com.kwad.components.ad.reward.presenter.f.d, com.kwad.components.core.webview.tachikoma.j
    public final void a(@Nullable com.kwad.sdk.core.webview.d.b.a aVar) {
        this.uj.sy.dc();
        c.d("jky", "onAdClicked convertPageType: " + aVar.bdg);
        if (com.kwad.sdk.core.response.helper.a.aU(this.mAdInfo)) {
            com.kwad.components.core.r.a.wm().bU(aVar.bdg);
            if (aVar.bdg == -1) {
                com.kwad.components.core.r.a.wm().bc(false);
                com.kwad.components.core.r.a.wm().bV(0);
            } else {
                if (com.kwad.sdk.core.response.helper.a.aL(this.mAdInfo)) {
                    if (com.kwad.components.core.r.a.wm().wr() == 2) {
                        com.kwad.components.core.r.a.wm().bV(3);
                        return;
                    } else {
                        com.kwad.components.core.r.a.wm().bV(1);
                        return;
                    }
                }
                com.kwad.components.core.r.a.wm().bc(true);
            }
        }
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final void a(ae.a aVar) {
        float fBB = com.kwad.sdk.c.a.a.bB(getContext());
        aVar.width = (int) ((bt.getScreenWidth(getContext()) / fBB) + 0.5f);
        aVar.height = (int) ((bt.getScreenHeight(getContext()) / fBB) + 0.5f);
    }

    @Override // com.kwad.components.ad.reward.presenter.f.d, com.kwad.components.core.webview.tachikoma.j
    public final void a(WebCloseStatus webCloseStatus) {
        boolean z = false;
        this.uj.sR = webCloseStatus != null && webCloseStatus.interactSuccess;
        int iWn = com.kwad.components.core.r.a.wm().wn();
        com.kwad.components.ad.reward.g gVar = this.uj;
        e eVar = gVar.sz;
        if (eVar != null) {
            if (gVar.sR) {
                eVar.lp();
                if (iWn == 1) {
                    iT();
                    z = true;
                }
            }
            if (this.yd && !this.Bu && !z) {
                this.uj.sz.resume();
            }
        }
        this.Ba.setVisibility(8);
    }
}
