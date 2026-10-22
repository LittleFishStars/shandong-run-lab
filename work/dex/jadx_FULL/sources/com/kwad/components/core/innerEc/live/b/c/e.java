package com.kwad.components.core.innerEc.live.b.c;

import android.content.Intent;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.components.core.innerEc.live.a.k;
import com.kwad.components.core.innerEc.live.a.l;
import com.kwad.components.core.innerEc.live.a.m;
import com.kwad.components.core.innerEc.live.a.n;
import com.kwad.components.core.innerEc.live.a.o;
import com.kwad.components.core.innerEc.live.a.p;
import com.kwad.components.core.webview.jshandler.ae;
import com.kwad.components.core.webview.jshandler.az;
import com.kwad.components.core.webview.tachikoma.TKRenderFailReason;
import com.kwad.components.core.webview.tachikoma.c.u;
import com.kwad.components.offline.api.core.adInnerEc.fullAdLive.model.PbSCActivityLiveInfo;
import com.kwad.components.offline.api.core.adInnerEc.fullAdLive.model.PbSCFeedPush;
import com.kwad.components.offline.api.core.adInnerEc.fullAdLive.model.PbSCShopEntranceControl;
import com.kwad.components.offline.api.core.adInnerEc.longconnection.listener.SCMessageListener;
import com.kwad.sdk.R;
import com.kwad.sdk.commercial.model.WebCloseStatus;
import com.kwad.sdk.components.t;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.model.LiveDetailReward;
import com.kwad.sdk.core.response.model.LiveInfo;
import com.kwad.sdk.core.response.model.LiveRewardInfo;
import com.kwad.sdk.utils.af;
import java.util.Iterator;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public final class e extends com.kwad.components.core.innerEc.live.b.a.a implements com.kwad.components.core.innerEc.live.base.f, com.kwad.components.core.webview.tachikoma.j {
    private LiveInfo TD;
    private com.kwad.components.core.innerEc.live.config.b UV;
    private com.kwad.components.core.webview.tachikoma.i VG;
    private com.kwad.components.core.innerEc.live.a.c VH;
    private com.kwad.components.core.innerEc.live.a.i VI;
    private com.kwad.components.core.innerEc.live.a.g VJ;
    private com.kwad.components.core.innerEc.live.a.f VK;
    private com.kwad.components.core.innerEc.live.a.h VL;
    private l VM;
    private com.kwad.components.core.innerEc.live.base.d VN;
    private com.kwad.components.core.innerEc.live.base.c VO;
    private com.kwad.components.core.innerEc.live.base.e VP;
    private com.kwad.components.core.innerEc.live.f.a VQ;
    private com.kwad.components.core.innerEc.live.a.d VR;
    private com.kwad.components.core.innerEc.live.a.b VS;
    private n VT;
    private k VU;
    private com.kwad.components.core.innerEc.live.a.a VV;
    private o VW;
    private m VX;
    private com.kwad.components.core.innerEc.live.g.d Wc;
    private FrameLayout dG;

    /* JADX INFO: renamed from: do, reason: not valid java name */
    private az f15076do;
    private AdInfo mAdInfo;
    private boolean KG = false;
    private final com.kwad.components.core.innerEc.live.base.a UA = new com.kwad.components.core.innerEc.live.base.a() { // from class: com.kwad.components.core.innerEc.live.b.c.e.1
        @Override // com.kwad.components.core.innerEc.live.base.a
        public final void c(float f, float f2) {
            if (e.this.VX != null) {
                e.this.VX.a(m.a(e.this.getContext(), f, f2));
            }
        }
    };
    private final SCMessageListener VY = new com.kwad.components.core.innerEc.live.g.c() { // from class: com.kwad.components.core.innerEc.live.b.c.e.3
        /* JADX INFO: Access modifiers changed from: private */
        @Override // com.kwad.components.core.innerEc.live.g.a
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void g(@NonNull PbSCFeedPush pbSCFeedPush) {
            if (e.this.VJ != null) {
                com.kwad.sdk.core.d.c.d("LiveDetailTKPresenter", "displayLikeCount:" + pbSCFeedPush.getDisplayLikeCount() + ", displayWatchingCount:" + pbSCFeedPush.getDisplayWatchingCount());
                e.this.VN = new com.kwad.components.core.innerEc.live.base.d();
                e.this.VN.Tx = pbSCFeedPush.getDisplayLikeCount();
                e.this.VN.Ty = pbSCFeedPush.getDisplayWatchingCount();
                e.this.Ub.Tx = pbSCFeedPush.getDisplayLikeCount();
                e.this.Ub.Ty = pbSCFeedPush.getDisplayWatchingCount();
                e.this.VJ.a(e.this.VN);
            }
        }
    };
    private final com.kwad.components.core.innerEc.live.g.b VZ = new com.kwad.components.core.innerEc.live.g.b() { // from class: com.kwad.components.core.innerEc.live.b.c.e.4
        /* JADX INFO: Access modifiers changed from: private */
        @Override // com.kwad.components.core.innerEc.live.g.a
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void g(@NonNull PbSCActivityLiveInfo pbSCActivityLiveInfo) {
            if (e.this.VK != null) {
                e.this.VO = new com.kwad.components.core.innerEc.live.base.c();
                e.this.VO.Tv = pbSCActivityLiveInfo.getAccumulatedWatchCount();
                e.this.VO.Tw = pbSCActivityLiveInfo.getLiteAccumulatedWatchCount();
                e.this.VK.a(e.this.VO);
            }
        }
    };
    private final com.kwad.components.core.innerEc.live.g.e Wa = new com.kwad.components.core.innerEc.live.g.e() { // from class: com.kwad.components.core.innerEc.live.b.c.e.5
        @Override // com.kwad.components.core.innerEc.live.g.e, com.kwad.components.core.innerEc.live.g.a
        /* JADX INFO: renamed from: a */
        public final void g(@NonNull PbSCShopEntranceControl pbSCShopEntranceControl) {
            if (e.this.VL != null) {
                e.this.VP = new com.kwad.components.core.innerEc.live.base.e();
                e.this.VP.TA = pbSCShopEntranceControl.getOnSaleCount();
                e.this.VP.Tz = pbSCShopEntranceControl.isShowYellowCart();
                e.this.VL.a(e.this.VP);
            }
        }
    };
    private final com.kwad.components.core.innerEc.live.config.a UY = new com.kwad.components.core.innerEc.live.config.a() { // from class: com.kwad.components.core.innerEc.live.b.c.e.6
        @Override // com.kwad.components.core.innerEc.live.config.a
        public final void a(@NonNull com.kwad.components.core.innerEc.live.config.net.g gVar) {
            com.kwad.sdk.core.d.c.d("LiveDetailTKPresenter", "onAfterConfigUpdatedLiveFail call JsHandlerLiveStartPlay");
            if (e.this.VI != null) {
                e.this.VI.a(gVar);
            }
        }

        @Override // com.kwad.components.core.innerEc.live.config.a
        public final void b(@NonNull com.kwad.components.core.innerEc.live.config.net.g gVar) {
            com.kwad.sdk.core.d.c.d("LiveDetailTKPresenter", "onAfterConfigUpdated call JsHandlerLiveStartPlay");
            if (e.this.VI != null) {
                e.this.VI.a(gVar);
            }
        }
    };
    private final com.kwad.components.core.innerEc.live.end.c Wb = new com.kwad.components.core.innerEc.live.end.c() { // from class: com.kwad.components.core.innerEc.live.b.c.e.7
        @Override // com.kwad.components.core.innerEc.live.end.c
        public final void sg() {
            com.kwad.sdk.core.d.c.d("LiveDetailTKPresenter", "onLiveStop");
            if (e.this.VR != null) {
                e.this.VR.a(com.kwad.components.core.innerEc.live.a.d.a.rw().aK(true));
            }
        }
    };
    private final com.kwad.sdk.core.j.c Wd = new com.kwad.sdk.core.j.c() { // from class: com.kwad.components.core.innerEc.live.b.c.e.9
        @Override // com.kwad.sdk.core.j.c
        public final void bA() {
            if (e.this.f15076do != null) {
                e.this.f15076do.yC();
            }
        }

        @Override // com.kwad.sdk.core.j.c
        public final void bz() {
            if (e.this.f15076do != null) {
                e.this.f15076do.yB();
            } else {
                e.a(e.this, true);
            }
        }
    };

    private static LiveInfo aL(AdTemplate adTemplate) {
        boolean z = com.kwad.sdk.core.response.helper.e.eI(adTemplate) == 2;
        LiveInfo liveInfo = adTemplate.liveInfo;
        if (z && liveInfo != null) {
            LiveRewardInfo liveRewardInfo = liveInfo.rewardInfo;
            LiveDetailReward liveDetailReward = adTemplate.mLiveDetailRewardFromAdLive;
            liveRewardInfo.rewardTimeSecond = liveDetailReward.countDownSecond;
            liveRewardInfo.rewardVerified = liveDetailReward.success;
            com.kwad.sdk.core.d.c.d("LiveDetailTKPresenter", "initLiveDetailInfo rewardTimeSecond = " + liveInfo.rewardInfo.rewardTimeSecond + ", rewardVerified:" + liveInfo.rewardInfo.rewardVerified);
        }
        return liveInfo;
    }

    private com.kwad.components.core.innerEc.live.g.d se() {
        com.kwad.components.core.innerEc.live.g.d dVar = this.Wc;
        if (dVar != null) {
            return dVar;
        }
        com.kwad.components.core.innerEc.live.g.d dVar2 = new com.kwad.components.core.innerEc.live.g.d(this.Ub) { // from class: com.kwad.components.core.innerEc.live.b.c.e.8
            @Override // com.kwad.components.core.innerEc.live.g.d
            public final void a(com.kwad.components.core.innerEc.live.f.a aVar) {
                com.kwad.sdk.core.d.c.d("LiveDetailTKPresenter", "call JsHandlerProductIntroduction");
                if (e.this.VM != null) {
                    e.this.VQ = aVar;
                    e.this.VM.a(e.this.VQ);
                }
            }
        };
        this.Wc = dVar2;
        return dVar2;
    }

    private void sf() {
        this.VG = new com.kwad.components.core.webview.tachikoma.i(getContext());
        com.kwad.sdk.core.d.c.d("LiveDetailTKPresenter", "initTKLiveAdPage LiveDetailFragment mLiveDetailInfo: " + this.TD);
        this.VV = new com.kwad.components.core.innerEc.live.a.a();
        this.VW = new o();
        this.VH = new com.kwad.components.core.innerEc.live.a.c(this.TD);
        this.VI = new com.kwad.components.core.innerEc.live.a.i();
        this.VJ = new com.kwad.components.core.innerEc.live.a.g();
        this.VR = new com.kwad.components.core.innerEc.live.a.d();
        this.VM = new l();
        this.VK = new com.kwad.components.core.innerEc.live.a.f();
        this.VL = new com.kwad.components.core.innerEc.live.a.h();
        this.Ub.US = new p();
        this.VT = new n(new n.a() { // from class: com.kwad.components.core.innerEc.live.b.c.e.10
            @Override // com.kwad.components.core.innerEc.live.a.n.a
            public final void rx() {
                com.kwad.sdk.core.d.c.d("LiveDetailTKPresenter", "onCallShowSoftInput: ");
                e.this.Ub.UN.apply(null);
            }
        });
        this.VS = new com.kwad.components.core.innerEc.live.a.b(new com.kwad.components.core.innerEc.live.a.b.a() { // from class: com.kwad.components.core.innerEc.live.b.c.e.2
            @Override // com.kwad.components.core.innerEc.live.a.b.a
            public final void aJ(boolean z) {
                com.kwad.sdk.core.d.c.d("LiveDetailTKPresenter", "onExplainCardHide: " + z);
                e.this.Ub.UQ.apply(Boolean.valueOf(z));
            }
        });
        this.VU = new k(getActivity());
        this.VX = new m();
        this.VG.a("cardMarginBottom", (Object) 0);
        com.kwad.sdk.core.d.c.d("LiveDetailTKPresenter", "initTKLiveAdPage mAdResultData: " + this.Ub.mAdResultData);
        com.kwad.components.core.innerEc.logger.a.aV(this.Ub.mAdTemplate);
        this.VG.a(getActivity(), this.Ub.mAdResultData, this);
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final void a(com.kwad.components.core.webview.jshandler.a.C1235a c1235a) {
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final void a(com.kwad.components.core.webview.tachikoma.b.o oVar) {
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final void a(com.kwad.components.core.webview.tachikoma.b.p pVar) {
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final void a(com.kwad.components.core.webview.tachikoma.c.n nVar) {
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final void a(u uVar) {
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final void a(@Nullable com.kwad.sdk.core.webview.d.b.a aVar) {
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final void aE() {
        az azVar;
        com.kwad.sdk.core.d.c.d("LiveDetailTKPresenter", "onTkLoadSuccess: ");
        az azVar2 = this.f15076do;
        if (azVar2 != null) {
            azVar2.yx();
            this.f15076do.yy();
        }
        if (this.KG && (azVar = this.f15076do) != null) {
            azVar.yB();
        }
        this.dG.setVisibility(0);
        this.Ub.UR.sJ();
        Iterator<com.kwad.sdk.g.b<Object, Object>> it = this.Ub.UO.iterator();
        while (it.hasNext()) {
            it.next().apply(null);
        }
        com.kwad.components.core.innerEc.live.a aVar = com.kwad.components.core.innerEc.live.b.Tr;
        if (aVar != null) {
            aVar.rs();
        }
        com.kwad.components.core.innerEc.logger.a.aW(this.Ub.mAdTemplate);
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final void aF() {
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final void aG() {
    }

    @Override // com.kwad.components.core.innerEc.live.b.a.a, com.kwad.sdk.mvp.Presenter
    public final void ay() {
        super.ay();
        com.kwad.components.core.innerEc.live.b.a.b bVar = this.Ub;
        this.UV = bVar.UF;
        AdTemplate adTemplate = bVar.mAdTemplate;
        this.TD = aL(adTemplate);
        this.mAdInfo = com.kwad.sdk.core.response.helper.e.eO(adTemplate);
        com.kwad.components.core.innerEc.live.b.a.b bVar2 = this.Ub;
        bVar2.UA = this.UA;
        bVar2.UE.a(this.Wd);
        this.Ub.UE.Aa();
        sf();
        this.UV.a(this.UY);
        this.Ub.UH.registerSCMessageListener(this.VY);
        this.Ub.UH.registerSCMessageListener(se());
        this.Ub.UH.registerSCMessageListener(this.VZ);
        this.Ub.UH.registerSCMessageListener(this.Wa);
        this.Ub.UK.a(this.Wb);
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final void g(AdTemplate adTemplate) {
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final String getRegisterViewKey() {
        return "";
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final FrameLayout getTKContainer() {
        return this.dG;
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final String getTKReaderScene() {
        return "tk_adinnerec_full_live_card";
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final String getTkTemplateId() {
        return com.kwad.sdk.core.response.helper.b.ei(this.Ub.mAdTemplate);
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final com.kwad.sdk.widget.g getTouchCoordsView() {
        return null;
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        FrameLayout frameLayout = (FrameLayout) findViewById(R.id.ksad_live_ad_container);
        this.dG = frameLayout;
        frameLayout.setVisibility(0);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onDestroy() {
        super.onDestroy();
        com.kwad.components.core.innerEc.live.video.a.b bVar = this.Ub.UI;
        if (bVar != null) {
            bVar.destroy();
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        az azVar = this.f15076do;
        if (azVar != null) {
            azVar.yz();
            this.f15076do.yA();
        }
        this.Ub.UE.b(this.Wd);
        com.kwad.components.core.webview.tachikoma.i iVar = this.VG;
        if (iVar != null) {
            iVar.kV();
        }
        this.UV.b(this.UY);
        this.Ub.UH.unregisterSCMessageListener(this.VY);
        this.Ub.UH.registerSCMessageListener(this.Wc);
        this.Ub.UH.unregisterSCMessageListener(this.VZ);
        this.Ub.UH.unregisterSCMessageListener(this.Wa);
        this.Ub.UK.b(this.Wb);
        this.VN = null;
        this.VQ = null;
        this.Ub.UO.clear();
    }

    @Override // com.kwad.components.core.innerEc.live.base.f
    public final void b(LiveDetailReward liveDetailReward) {
        if (liveDetailReward == null) {
            return;
        }
        com.kwad.sdk.core.d.c.d("LiveDetailTKPresenter", "onUpdateLiveDetailReward: " + liveDetailReward);
        if (liveDetailReward.success) {
            af.dj(getContext()).i(new Intent("REWARD_LIVE_ACTION_VERIFY"));
        } else {
            Intent intent = new Intent("REWARD_LIVE_ACTION_PROGRESS");
            intent.putExtra("countDownSecond", liveDetailReward.countDownSecond);
            intent.putExtra("hasRewardTime", liveDetailReward.hasRewardTime);
            af.dj(getContext()).i(intent);
        }
    }

    public static /* synthetic */ boolean a(e eVar, boolean z) {
        eVar.KG = true;
        return true;
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final void a(TKRenderFailReason tKRenderFailReason) {
        com.kwad.sdk.core.d.c.d("LiveDetailTKPresenter", "onTkLoadFailed: " + tKRenderFailReason.name());
        az azVar = this.f15076do;
        if (azVar != null) {
            azVar.yz();
            this.f15076do.yA();
        }
        this.dG.setVisibility(8);
        this.Ub.UR.b(tKRenderFailReason);
        com.kwad.components.core.innerEc.live.a aVar = com.kwad.components.core.innerEc.live.b.Tr;
        if (aVar != null) {
            aVar.rt();
        }
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final void a(t tVar, com.kwad.sdk.core.webview.b bVar) {
        tVar.c(this.VH);
        tVar.c(this.VI);
        this.VI.a(this.Ub.UM);
        com.kwad.components.core.innerEc.live.a.g gVar = new com.kwad.components.core.innerEc.live.a.g();
        this.VJ = gVar;
        tVar.c(gVar);
        com.kwad.components.core.innerEc.live.base.d dVar = this.VN;
        if (dVar != null) {
            this.VJ.a(dVar);
        }
        this.Ub.UT = new com.kwad.components.core.innerEc.live.a.e();
        tVar.c(this.Ub.UT);
        tVar.c(this.VK);
        com.kwad.components.core.innerEc.live.base.c cVar = this.VO;
        if (cVar != null) {
            this.VK.a(cVar);
        }
        tVar.c(this.VL);
        com.kwad.components.core.innerEc.live.base.e eVar = this.VP;
        if (eVar != null) {
            this.VL.a(eVar);
        }
        l lVar = new l();
        this.VM = lVar;
        tVar.c(lVar);
        com.kwad.components.core.innerEc.live.f.a aVar = this.VQ;
        if (aVar != null) {
            this.VM.a(aVar);
        }
        tVar.c(this.VR);
        if (this.Ub.UK.sD()) {
            this.VR.a(com.kwad.components.core.innerEc.live.a.d.a.rw().aK(true));
        }
        tVar.c(this.VT);
        tVar.c(this.VS);
        tVar.c(this.VU);
        tVar.c(this.VV);
        tVar.c(this.VW);
        tVar.c(this.VX);
        tVar.c(this.Ub.US);
        tVar.c(new com.kwad.components.core.innerEc.live.a.j(this));
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final void a(ae.a aVar) {
        float fBB = com.kwad.sdk.c.a.a.bB(getContext());
        aVar.width = (int) (getTKContainer().getWidth() / fBB);
        aVar.height = (int) (getTKContainer().getHeight() / fBB);
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final void a(WebCloseStatus webCloseStatus) {
        getActivity().onBackPressed();
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final void a(az azVar) {
        this.f15076do = azVar;
        azVar.bm(true);
    }
}
