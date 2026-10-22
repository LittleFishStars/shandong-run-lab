package com.kwad.components.ad.reward.presenter.f;

import android.widget.FrameLayout;
import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import com.kwad.components.ad.reward.k.u;
import com.kwad.components.ad.reward.page.BackPressHandleResult;
import com.kwad.components.core.innerEc.live.a.j;
import com.kwad.components.core.webview.jshandler.ae;
import com.kwad.components.core.webview.jshandler.x;
import com.kwad.components.core.webview.tachikoma.TKRenderFailReason;
import com.kwad.components.core.webview.tachikoma.c.y;
import com.kwad.sdk.R;
import com.kwad.sdk.components.t;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.model.LiveDetailReward;
import com.kwad.sdk.utils.bi;
import com.kwad.sdk.utils.by;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public class b extends d implements com.kwad.components.core.innerEc.live.base.f {
    private FrameLayout AC;
    private u AF;
    private boolean AE = false;
    private com.kwad.components.core.innerEc.live.base.f zE = new com.kwad.components.core.innerEc.live.base.f() { // from class: com.kwad.components.ad.reward.presenter.f.b.1
        @Override // com.kwad.components.core.innerEc.live.base.f
        public final void b(LiveDetailReward liveDetailReward) {
            com.kwad.sdk.core.d.c.w("TKLivePresenter", "jky TKLivePresenter onUpdateLiveDetailReward: " + liveDetailReward);
            if (b.this.AF != null) {
                b.this.AF.a(liveDetailReward);
            }
        }
    };

    private void V(boolean z) {
        this.AC.setVisibility(z ? 0 : 8);
    }

    private com.kwad.components.core.webview.tachikoma.c eK() {
        return new com.kwad.components.core.webview.tachikoma.c() { // from class: com.kwad.components.ad.reward.presenter.f.b.2
            @Override // com.kwad.components.core.webview.tachikoma.c, com.kwad.sdk.core.webview.c.a
            public final void a(String str, @NonNull com.kwad.sdk.core.webview.c.c cVar) {
                super.a(str, cVar);
                com.kwad.components.core.webview.tachikoma.c.c cVar2 = new com.kwad.components.core.webview.tachikoma.c.c();
                cVar2.auj = com.kwad.components.ad.reward.model.b.dX();
                cVar.b(cVar2);
            }
        };
    }

    @Override // com.kwad.components.ad.reward.presenter.f.d, com.kwad.components.ad.reward.presenter.b, com.kwad.sdk.mvp.Presenter
    public final void ay() {
        super.ay();
        this.uj.a(this.zE);
        if (this.AE) {
            return;
        }
        V(true);
    }

    @IdRes
    public int dA() {
        return R.id.ksad_js_reward_card;
    }

    @Override // com.kwad.components.ad.reward.presenter.f.d, com.kwad.components.core.webview.tachikoma.j
    public final void g(AdTemplate adTemplate) {
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public FrameLayout getTKContainer() {
        return this.AC;
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public String getTKReaderScene() {
        return "tk_live_video";
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public String getTkTemplateId() {
        return com.kwad.sdk.core.response.helper.b.eh(this.uj.mAdTemplate);
    }

    public final BackPressHandleResult hJ() {
        com.kwad.components.ad.reward.k.a.d dVar = this.AI;
        return dVar == null ? BackPressHandleResult.NOT_HANDLED : dVar.hJ();
    }

    @Override // com.kwad.components.ad.reward.presenter.f.d
    public final boolean ki() {
        return true;
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

    @Override // com.kwad.components.ad.reward.presenter.f.d, com.kwad.components.core.webview.tachikoma.j
    public final void a(t tVar, com.kwad.sdk.core.webview.b bVar) {
        super.a(tVar, bVar);
        tVar.c(eK());
        tVar.c(new com.kwad.components.core.webview.tachikoma.b(new com.kwad.components.core.webview.tachikoma.b.a() { // from class: com.kwad.components.ad.reward.presenter.f.b.3
            @Override // com.kwad.components.core.webview.tachikoma.b.a
            public final void eU() {
                com.kwad.components.ad.reward.model.b.L(b.this.uj.mContext);
            }
        }));
        tVar.c(new x() { // from class: com.kwad.components.ad.reward.presenter.f.b.4
            @Override // com.kwad.components.core.webview.jshandler.x
            public final void a(y yVar) {
                super.a(yVar);
                long jZw = yVar.zw();
                b.this.uj.sy.onVideoPlayError(yVar.errorCode, (int) jZw);
                com.kwad.components.ad.reward.monitor.d.a(b.this.uj.sO, b.this.uj.mAdTemplate, b.this.uj.tn, yVar.errorCode, jZw);
                com.kwad.components.ad.reward.monitor.c.c(b.this.uj.sO, b.this.mAdTemplate);
            }

            @Override // com.kwad.components.core.webview.jshandler.x
            public final void b(y yVar) {
                super.b(yVar);
                b.this.uj.sy.onVideoPlayStart();
                com.kwad.components.ad.reward.monitor.d.b(b.this.uj.sO, b.this.uj.mAdTemplate, b.this.uj.mPageEnterTime);
            }

            @Override // com.kwad.components.core.webview.jshandler.x
            public final void c(y yVar) {
                super.c(yVar);
                b.this.uj.sy.onVideoPlayEnd();
                b.this.uj.mAdTemplate.setmCurPlayTime(-1L);
                com.kwad.components.ad.reward.presenter.f.u(b.this.uj);
            }

            @Override // com.kwad.components.core.webview.jshandler.x
            public final void d(y yVar) {
                super.d(yVar);
                b.this.uj.mAdTemplate.setmCurPlayTime(yVar.rq);
            }
        });
        tVar.c(new j(this));
        u uVar = new u();
        this.AF = uVar;
        tVar.c(uVar);
    }

    @Override // com.kwad.components.core.innerEc.live.base.f
    public final void b(LiveDetailReward liveDetailReward) {
        AdTemplate adTemplate = this.mAdTemplate;
        if (adTemplate.mLiveDetailRewardFromAdLive != null) {
            adTemplate.updateLiveDetailRewardFromAdLive(liveDetailReward);
        }
    }

    @Override // com.kwad.components.ad.reward.presenter.f.d, com.kwad.components.core.webview.tachikoma.j
    public final void a(final com.kwad.components.core.webview.tachikoma.c.u uVar) {
        com.kwad.sdk.core.d.c.d("TKLivePresenter", "onSkipClick: " + uVar.apv);
        by.postOnUiThread(new bi() { // from class: com.kwad.components.ad.reward.presenter.f.b.5
            @Override // com.kwad.sdk.utils.bi
            public final void doTask() {
                if (b.this.uj != null && b.this.uj.sy != null) {
                    b.this.uj.sy.onVideoSkipToEnd(uVar.apv * 1000);
                }
                com.kwad.components.ad.reward.presenter.f.u(b.this.uj);
            }
        });
    }

    @Override // com.kwad.components.ad.reward.presenter.f.d, com.kwad.components.core.webview.tachikoma.j
    public final void a(TKRenderFailReason tKRenderFailReason) {
        super.a(tKRenderFailReason);
        com.kwad.components.ad.reward.monitor.c.a(this.mAdTemplate, tKRenderFailReason);
        this.AE = true;
        V(false);
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final void a(ae.a aVar) {
        float screenHeight;
        float screenWidth;
        float fBB = com.kwad.sdk.c.a.a.bB(getContext());
        FrameLayout frameLayout = this.AC;
        if (frameLayout != null) {
            screenHeight = frameLayout.getHeight();
            screenWidth = this.AC.getWidth();
        } else {
            screenHeight = 0.0f;
            screenWidth = 0.0f;
        }
        if (screenHeight == 0.0f || screenWidth == 0.0f) {
            screenHeight = com.kwad.sdk.c.a.a.getScreenHeight(getContext());
            screenWidth = com.kwad.sdk.c.a.a.getScreenWidth(getContext());
        }
        aVar.width = (int) ((screenWidth / fBB) + 0.5f);
        aVar.height = (int) ((screenHeight / fBB) + 0.5f);
    }
}
