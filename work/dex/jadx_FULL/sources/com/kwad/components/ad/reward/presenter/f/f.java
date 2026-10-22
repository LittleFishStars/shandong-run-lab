package com.kwad.components.ad.reward.presenter.f;

import android.text.TextUtils;
import android.widget.FrameLayout;
import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.components.ad.reward.e.j;
import com.kwad.components.ad.reward.e.n;
import com.kwad.components.ad.reward.k.l;
import com.kwad.components.ad.reward.k.u;
import com.kwad.components.ad.reward.page.BackPressHandleResult;
import com.kwad.components.core.playable.PlayableSource;
import com.kwad.components.core.webview.jshandler.ae;
import com.kwad.components.core.webview.jshandler.p;
import com.kwad.components.core.webview.tachikoma.TKRenderFailReason;
import com.kwad.sdk.R;
import com.kwad.sdk.commercial.model.WebCloseStatus;
import com.kwad.sdk.components.t;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.model.LiveDetailReward;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public class f extends a implements j, com.kwad.components.core.innerEc.live.base.f, com.kwad.components.core.j.a.InterfaceC1214a {
    protected FrameLayout AC;
    private u AF;
    private List<com.kwad.components.core.j.c> bT;
    private com.kwad.components.core.webview.tachikoma.e oh;
    private boolean AE = false;
    private com.kwad.components.core.innerEc.live.base.f zE = new com.kwad.components.core.innerEc.live.base.f() { // from class: com.kwad.components.ad.reward.presenter.f.f.1
        @Override // com.kwad.components.core.innerEc.live.base.f
        public final void b(LiveDetailReward liveDetailReward) {
            com.kwad.sdk.core.d.c.w("TkRewardPagePresenter", "jky TKLivePresenter onUpdateLiveDetailReward: " + liveDetailReward);
            if (f.this.AF != null) {
                f.this.AF.a(liveDetailReward);
            }
        }
    };
    private final com.kwad.components.core.webview.tachikoma.f.a sK = new com.kwad.components.core.webview.tachikoma.f.a() { // from class: com.kwad.components.ad.reward.presenter.f.f.2
        @Override // com.kwad.components.core.webview.tachikoma.f.a
        public final void kw() {
            if (f.this.oh != null) {
                com.kwad.components.core.webview.tachikoma.c.a aVar = new com.kwad.components.core.webview.tachikoma.c.a();
                aVar.auh = f.this.uj.jh ? 1 : 0;
                f.this.oh.b(aVar);
            }
        }
    };

    private void X(boolean z) {
        com.kwad.sdk.core.d.c.d("TkRewardPagePresenter", "fullTK: " + z);
        FrameLayout frameLayout = this.AC;
        if (frameLayout == null) {
            return;
        }
        frameLayout.setVisibility(z ? 0 : 8);
    }

    private com.kwad.components.core.webview.tachikoma.c eK() {
        return new com.kwad.components.core.webview.tachikoma.c() { // from class: com.kwad.components.ad.reward.presenter.f.f.7
            @Override // com.kwad.components.core.webview.tachikoma.c, com.kwad.sdk.core.webview.c.a
            public final void a(String str, @NonNull com.kwad.sdk.core.webview.c.c cVar) {
                super.a(str, cVar);
                com.kwad.components.core.webview.tachikoma.c.c cVar2 = new com.kwad.components.core.webview.tachikoma.c.c();
                cVar2.auj = com.kwad.components.ad.reward.model.b.dX();
                cVar.b(cVar2);
            }
        };
    }

    private com.kwad.components.core.webview.tachikoma.e eL() {
        return new com.kwad.components.core.webview.tachikoma.e() { // from class: com.kwad.components.ad.reward.presenter.f.f.6
            @Override // com.kwad.components.core.webview.tachikoma.e, com.kwad.sdk.core.webview.c.a
            public final void a(String str, @NonNull com.kwad.sdk.core.webview.c.c cVar) {
                super.a(str, cVar);
                com.kwad.components.core.webview.tachikoma.c.a aVar = new com.kwad.components.core.webview.tachikoma.c.a();
                aVar.auh = f.this.uj.jh ? 1 : 0;
                cVar.b(aVar);
            }
        };
    }

    @Override // com.kwad.components.ad.reward.presenter.f.d, com.kwad.components.ad.reward.presenter.b, com.kwad.sdk.mvp.Presenter
    public final void ay() {
        super.ay();
        if (!this.AE) {
            X(true);
        }
        com.kwad.components.ad.reward.g gVar = this.uj;
        gVar.sP = true ^ this.AE;
        gVar.a((com.kwad.components.core.j.a.InterfaceC1214a) this);
        com.kwad.components.ad.reward.a.gs().a(this);
        this.uj.a(this.zE);
    }

    @IdRes
    public int dA() {
        return R.id.ksad_js_reward_card;
    }

    @Override // com.kwad.components.ad.reward.e.j
    public final void dq() {
        FrameLayout frameLayout;
        if (this.AE || (frameLayout = this.AC) == null) {
            return;
        }
        frameLayout.setVisibility(0);
    }

    @Override // com.kwad.components.ad.reward.e.j
    public final void dr() {
    }

    @Override // com.kwad.components.ad.reward.presenter.f.d, com.kwad.components.core.webview.tachikoma.j
    public final void g(AdTemplate adTemplate) {
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public FrameLayout getTKContainer() {
        return this.AC;
    }

    public String getTKReaderScene() {
        return "tk_reward";
    }

    public String getTkTemplateId() {
        return com.kwad.sdk.core.response.helper.b.eg(this.uj.mAdTemplate);
    }

    public final BackPressHandleResult hJ() {
        com.kwad.components.ad.reward.k.a.d dVar = this.AI;
        return dVar == null ? BackPressHandleResult.NOT_HANDLED : dVar.hJ();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.AC = (FrameLayout) findViewById(dA());
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onDestroy() {
        super.onDestroy();
        this.uj.b(this.zE);
    }

    @Override // com.kwad.components.core.j.a.InterfaceC1214a
    public final void onError(int i, String str) {
    }

    @Override // com.kwad.components.core.j.a.InterfaceC1214a
    public final void onRequestResult(int i) {
    }

    @Override // com.kwad.components.ad.reward.presenter.f.d, com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        this.uj.b((com.kwad.components.core.j.a.InterfaceC1214a) this);
        com.kwad.components.ad.reward.a.gs().b(this);
    }

    @Override // com.kwad.components.ad.reward.presenter.f.d, com.kwad.components.core.webview.tachikoma.j
    public final void a(@Nullable com.kwad.sdk.core.webview.d.b.a aVar) {
        if (aVar == null || com.kwad.sdk.core.response.helper.e.b(this.uj.mAdResultData.getProceedTemplateList(), aVar.creativeId, aVar.adStyle)) {
            this.uj.sy.dc();
            return;
        }
        if (aVar.adTemplate != null && !aVar.bdj) {
            this.uj.sy.dc();
            return;
        }
        com.kwad.components.core.j.c cVarA = com.kwad.components.ad.reward.g.a(this.bT, aVar.creativeId);
        if (cVarA != null) {
            this.uj.a(cVarA);
        }
    }

    @Override // com.kwad.components.core.innerEc.live.base.f
    public final void b(LiveDetailReward liveDetailReward) {
        com.kwad.sdk.core.d.c.w("TkRewardPagePresenter", "jky neo TK onUpdateLiveDetailReward: " + liveDetailReward);
        AdTemplate adTemplate = this.mAdTemplate;
        if (adTemplate.mLiveDetailRewardFromAdLive != null) {
            adTemplate.updateLiveDetailRewardFromAdLive(liveDetailReward);
        }
    }

    @Override // com.kwad.components.core.j.a.InterfaceC1214a
    public final void e(@Nullable List<com.kwad.components.core.j.c> list) {
        if (list == null || list.size() == 0 || this.AI == null) {
            return;
        }
        this.bT = list;
        List<AdTemplate> listA = a(list, this.uj.mAdTemplate);
        com.kwad.sdk.core.webview.b bVarYM = this.AI.yM();
        if (bVarYM != null) {
            bVarYM.setAdTemplateList(listA);
        }
        l lVarKU = this.AI.kU();
        if (lVarKU != null) {
            lVarKU.g(listA);
        } else {
            this.AI.h(listA);
        }
    }

    @Override // com.kwad.components.ad.reward.presenter.f.d, com.kwad.components.core.webview.tachikoma.j
    public final void a(TKRenderFailReason tKRenderFailReason) {
        super.a(tKRenderFailReason);
        com.kwad.components.ad.reward.monitor.c.a(this.mAdTemplate, tKRenderFailReason);
        com.kwad.sdk.core.d.c.d("TkRewardPagePresenter", "onTkLoadFailed");
        this.AE = true;
        this.uj.sP = false;
        X(false);
    }

    @Override // com.kwad.components.ad.reward.presenter.f.a, com.kwad.components.ad.reward.presenter.f.d, com.kwad.components.core.webview.tachikoma.j
    public final void a(t tVar, com.kwad.sdk.core.webview.b bVar) {
        super.a(tVar, bVar);
        tVar.c(new com.kwad.components.ad.reward.c.f(new com.kwad.components.ad.reward.c.d() { // from class: com.kwad.components.ad.reward.presenter.f.f.3
            @Override // com.kwad.components.ad.reward.c.d
            public final void a(com.kwad.components.ad.reward.c.b bVar2) {
                com.kwad.sdk.core.d.c.d("TkRewardPagePresenter", "onUpdateExtraReward : " + bVar2.ik());
                f.this.a(bVar2);
            }
        }));
        this.oh = eL();
        this.uj.a(this.sK);
        tVar.c(this.oh);
        tVar.c(new com.kwad.components.core.webview.tachikoma.b(new com.kwad.components.core.webview.tachikoma.b.a() { // from class: com.kwad.components.ad.reward.presenter.f.f.4
            @Override // com.kwad.components.core.webview.tachikoma.b.a
            public final void eU() {
                com.kwad.components.ad.reward.model.b.L(f.this.uj.mContext);
            }
        }));
        tVar.c(eK());
        tVar.c(new com.kwad.components.core.webview.jshandler.j(new p() { // from class: com.kwad.components.ad.reward.presenter.f.f.5
            @Override // com.kwad.components.core.webview.jshandler.p
            public final void a(com.kwad.components.core.webview.jshandler.j jVar, String str) {
                if (TextUtils.equals(str, "autoCallApp")) {
                    jVar.bk(com.kwad.components.ad.reward.g.g(com.kwad.sdk.core.response.helper.e.eO(f.this.uj.mAdTemplate)) && com.kwad.sdk.core.local.a.LZ() && f.this.uj.mScreenOrientation == 0);
                }
            }
        }));
        tVar.c(new com.kwad.components.core.innerEc.live.a.j(this));
        u uVar = new u();
        this.AF = uVar;
        tVar.c(uVar);
    }

    private static List<AdTemplate> a(List<com.kwad.components.core.j.c> list, AdTemplate adTemplate) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(adTemplate);
        arrayList.addAll(com.kwad.components.core.j.c.q(list));
        return arrayList;
    }

    @Override // com.kwad.components.ad.reward.e.j
    public final void a(PlayableSource playableSource, @Nullable n nVar) {
        FrameLayout frameLayout;
        if (this.AE || (frameLayout = this.AC) == null) {
            return;
        }
        frameLayout.setVisibility(8);
    }

    @Override // com.kwad.components.ad.reward.presenter.f.d, com.kwad.components.core.webview.tachikoma.j
    public final void a(com.kwad.components.core.webview.tachikoma.c.u uVar) {
        com.kwad.components.ad.reward.e.b bVar;
        com.kwad.sdk.core.d.c.d("TkRewardPagePresenter", "onSkipClick: " + uVar.apv);
        com.kwad.components.ad.reward.g gVar = this.uj;
        if (gVar != null && (bVar = gVar.sy) != null) {
            bVar.onVideoSkipToEnd(uVar.apv * 1000);
        }
        com.kwad.components.ad.reward.presenter.f.u(this.uj);
        com.kwad.components.ad.reward.g.a(this.uj.sG, new com.kwad.sdk.g.a<com.kwad.components.ad.reward.k.a>() { // from class: com.kwad.components.ad.reward.presenter.f.f.8
            private static void c(com.kwad.components.ad.reward.k.a aVar) {
                aVar.kh();
            }

            @Override // com.kwad.sdk.g.a
            public final /* synthetic */ void accept(com.kwad.components.ad.reward.k.a aVar) {
                c(aVar);
            }
        });
    }

    @Override // com.kwad.components.ad.reward.presenter.f.d, com.kwad.components.core.webview.tachikoma.j
    public final void a(WebCloseStatus webCloseStatus) {
        super.a(webCloseStatus);
    }

    @Override // com.kwad.components.ad.reward.presenter.f.a, com.kwad.components.core.webview.tachikoma.j
    public final void a(ae.a aVar) {
        float height;
        float width;
        float fBB = com.kwad.sdk.c.a.a.bB(getContext());
        FrameLayout frameLayout = this.AC;
        if (frameLayout != null) {
            height = frameLayout.getHeight();
            width = this.AC.getWidth();
        } else {
            height = 0.0f;
            width = 0.0f;
        }
        if (height != 0.0f && width != 0.0f) {
            aVar.width = (int) ((width / fBB) + 0.5f);
            aVar.height = (int) ((height / fBB) + 0.5f);
        } else {
            super.a(aVar);
        }
    }
}
