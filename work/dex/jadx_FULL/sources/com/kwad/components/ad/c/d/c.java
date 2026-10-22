package com.kwad.components.ad.c.d;

import android.animation.ObjectAnimator;
import android.os.Handler;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.WorkerThread;
import com.kwad.components.ad.KsAdLoadManager;
import com.kwad.components.ad.c.g;
import com.kwad.components.core.e.d.d;
import com.kwad.components.core.request.j;
import com.kwad.components.core.request.model.ImpInfo;
import com.kwad.components.core.t.t;
import com.kwad.sdk.R;
import com.kwad.sdk.core.config.e;
import com.kwad.sdk.core.response.model.AdResultData;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.internal.api.SceneImpl;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.bi;
import com.kwad.sdk.utils.l;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public final class c extends a {
    private com.kwad.components.ad.c.b.a cT;
    private com.kwad.components.ad.c.b.a cU;
    private FrameLayout cV;
    private boolean cW;
    private boolean cX;
    private boolean cY;
    private long cZ;
    private boolean db;
    private boolean dc;
    boolean dg;
    private long startTime;
    private Handler handler = new Handler();
    private boolean da = false;
    private boolean dd = true;
    private bi de = new bi() { // from class: com.kwad.components.ad.c.d.c.1
        @Override // com.kwad.sdk.utils.bi
        public final void doTask() {
            if (c.this.dd) {
                c.this.cZ = System.currentTimeMillis() - c.this.startTime;
                if (!c.this.cX || (c.this.cZ >= e.KE() && com.kwad.sdk.core.response.helper.a.dB(com.kwad.sdk.core.response.helper.e.eO(c.this.cS.mAdTemplate)))) {
                    c.this.aB();
                    c.this.cY = true;
                    c.b(c.this, true);
                    if (c.this.cZ >= e.KE()) {
                        c.this.startTime = System.currentTimeMillis();
                    }
                }
                if (com.kwad.sdk.core.response.helper.a.dB(com.kwad.sdk.core.response.helper.e.eO(c.this.cS.mAdTemplate))) {
                    c.this.handler.postDelayed(this, 1000L);
                }
            }
        }
    };
    private int df = 0;

    /* JADX INFO: Access modifiers changed from: private */
    public void aA() {
        this.handler.removeCallbacksAndMessages(this.de);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void az() {
        this.handler.removeCallbacksAndMessages(this.de);
        this.handler.post(this.de);
    }

    public final void aB() {
        if (this.cY || this.cS.bT.isEmpty()) {
            return;
        }
        try {
            final long jElapsedRealtime = SystemClock.elapsedRealtime();
            com.kwad.components.ad.c.b.a aVar = new com.kwad.components.ad.c.b.a(getContext(), this.cS.bT.get(this.df), new com.kwad.components.ad.c.b.a.InterfaceC1132a() { // from class: com.kwad.components.ad.c.d.c.3
                @Override // com.kwad.components.ad.c.b.a.InterfaceC1132a
                public final void a(final int i, int i2, final AdTemplate adTemplate) {
                    com.kwad.components.core.e.d.a.C1201a c1201aA = new com.kwad.components.core.e.d.a.C1201a(c.this.getContext()).aJ(adTemplate).ax(true).b(new d(adTemplate)).au(false).aN(i2).aM(i).a(new com.kwad.components.core.e.d.a.b() { // from class: com.kwad.components.ad.c.d.c.3.1
                        @Override // com.kwad.components.core.e.d.a.b
                        public final void onAdClicked() {
                            com.kwad.sdk.core.adlog.c.a aVar2 = new com.kwad.sdk.core.adlog.c.a();
                            com.kwad.sdk.core.adlog.a.C1273a c1273a = new com.kwad.sdk.core.adlog.a.C1273a();
                            aVar2.QZ = c1273a;
                            c1273a.templateId = "101";
                            aVar2.nm = i;
                            com.kwad.sdk.core.adlog.c.a(adTemplate, aVar2, (JSONObject) null);
                            if (c.this.dc) {
                                return;
                            }
                            c.e(c.this, true);
                            AdTemplate adTemplate2 = adTemplate;
                            com.kwad.components.ad.c.c.c.c(adTemplate2, 1, com.kwad.components.ad.c.b.a(adTemplate2) ? 2 : 1);
                        }
                    });
                    com.kwad.components.core.e.d.a.a(c1201aA);
                    if (com.kwad.components.core.e.d.a.c(c1201aA)) {
                        return;
                    }
                    c.this.cS.ab();
                    com.kwad.components.ad.c.c.c.d(adTemplate, 1, com.kwad.components.ad.c.b.a(adTemplate) ? 2 : 1);
                }

                @Override // com.kwad.components.ad.c.b.a.InterfaceC1132a
                public final void d(AdTemplate adTemplate) {
                    if (!c.this.da) {
                        try {
                            com.kwad.components.ad.c.b bVar = c.this.cS;
                            if (bVar.bU > 0) {
                                com.kwad.sdk.commercial.convert.d.b(com.kwad.sdk.core.response.helper.e.eI(bVar.mAdTemplate), 1, SystemClock.elapsedRealtime() - c.this.cS.bU);
                                com.kwad.components.ad.c.c.c.a(c.this.cS.mAdTemplate, SystemClock.elapsedRealtime() - c.this.cS.bU, 1, com.kwad.components.ad.c.b.a(adTemplate) ? 2 : 1, true);
                            }
                        } catch (Throwable th) {
                            ServiceProvider.reportSdkCaughtException(th);
                        }
                        c.d(c.this, true);
                    }
                    com.kwad.components.ad.c.c.c.a(c.this.cS.mAdTemplate, 1, com.kwad.components.ad.c.b.a(adTemplate) ? 2 : 1);
                    if (adTemplate.mPvReported) {
                        return;
                    }
                    com.kwad.sdk.core.adlog.c.b bVar2 = new com.kwad.sdk.core.adlog.c.b();
                    com.kwad.sdk.core.adlog.a.C1273a c1273a = new com.kwad.sdk.core.adlog.a.C1273a();
                    c1273a.templateId = "101";
                    c1273a.aLu = com.kwad.sdk.core.response.helper.a.dB(com.kwad.sdk.core.response.helper.e.eO(c.this.cS.mAdTemplate)) ? 1 : 2;
                    bVar2.b(c1273a);
                    com.kwad.components.core.t.b.wF().a(adTemplate, null, bVar2);
                    c.this.cS.aa();
                    com.kwad.components.ad.c.c.c.b(adTemplate, 1, com.kwad.components.ad.c.b.a(adTemplate) ? 2 : 1);
                    com.kwad.components.ad.c.c.c.a(adTemplate, SystemClock.elapsedRealtime() - c.this.cS.bU, 1, com.kwad.components.ad.c.b.a(adTemplate) ? 2 : 1);
                }

                @Override // com.kwad.components.ad.c.b.a.InterfaceC1132a
                public final void e(AdTemplate adTemplate) {
                    com.kwad.sdk.core.adlog.c.h(adTemplate, null);
                    c.this.cS.ac();
                    com.kwad.components.ad.c.c.c.f(adTemplate, 1, com.kwad.components.ad.c.b.a(adTemplate) ? 2 : 1);
                    c.this.cS.bQ.removeAllViews();
                    c.this.handler.removeCallbacksAndMessages(null);
                    com.kwad.components.ad.c.c.c.e(adTemplate, 1, com.kwad.components.ad.c.b.a(adTemplate) ? 2 : 1);
                    c.this.onDestroy();
                }

                @Override // com.kwad.components.ad.c.b.a.InterfaceC1132a
                public final void o(String str) {
                    c.this.cS.c(0, "onMediaPlayError");
                    c cVar = c.this;
                    com.kwad.components.ad.c.c.c.a(cVar.cS.bT.get(cVar.df), SystemClock.elapsedRealtime() - jElapsedRealtime, str);
                }
            });
            aVar.a(this.cS.bS);
            com.kwad.components.ad.c.b bVar = this.cS;
            bVar.b(bVar.bT.get(this.df));
            if (this.cW) {
                this.cU = aVar;
                this.cV.addView(aVar);
                this.cU.aq();
                this.handler.postDelayed(new bi() { // from class: com.kwad.components.ad.c.d.c.5
                    @Override // com.kwad.sdk.utils.bi
                    public final void doTask() {
                        if (c.this.cT != null) {
                            c.this.cV.removeView(c.this.cT);
                        }
                        c.this.cY = false;
                    }
                }, 500L);
                this.cW = false;
            } else {
                this.cT = aVar;
                this.cV.addView(aVar);
                this.cT.aq();
                this.handler.postDelayed(new bi() { // from class: com.kwad.components.ad.c.d.c.4
                    @Override // com.kwad.sdk.utils.bi
                    public final void doTask() {
                        if (c.this.cU != null) {
                            c.this.cV.removeView(c.this.cU);
                        }
                        c.this.cY = false;
                    }
                }, 500L);
                this.cW = true;
            }
            int i = this.df + 1;
            this.df = i;
            if (i == this.cS.bT.size()) {
                aC();
                this.df = 0;
            }
            if (!this.dg) {
                this.dg = true;
                return;
            }
            ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(aVar, "translationX", this.cV.getWidth(), 0.0f);
            objectAnimatorOfFloat.setDuration(300L);
            objectAnimatorOfFloat.start();
        } catch (Exception e) {
            com.kwad.components.core.d.a.reportSdkCaughtException(e);
            com.kwad.sdk.core.d.c.printStackTraceOnly(e);
        }
    }

    public final void aC() {
        final SceneImpl sceneImplCovert = SceneImpl.covert(g.cf);
        sceneImplCovert.setBidResponse(null);
        sceneImplCovert.setBidResponseV2(null);
        final long jCurrentTimeMillis = System.currentTimeMillis();
        com.kwad.sdk.commercial.convert.e.d(sceneImplCovert);
        com.kwad.components.ad.c.c.c.a(sceneImplCovert, this.db ? 2 : 1);
        boolean zB = t.wU().b(sceneImplCovert, "loadBannerAd");
        sceneImplCovert.setAdStyle(5);
        KsAdLoadManager.O().a(new com.kwad.components.core.request.model.a.C1230a().e(new ImpInfo(sceneImplCovert)).aZ(zB).a(new j() { // from class: com.kwad.components.ad.c.d.c.7
            @Override // com.kwad.components.core.request.j
            @WorkerThread
            public final void ak() {
            }
        }).a(new com.kwad.components.core.request.d() { // from class: com.kwad.components.ad.c.d.c.6
            @Override // com.kwad.components.core.request.d, com.kwad.components.core.request.c
            public final void a(@NonNull AdResultData adResultData, boolean z) {
                com.kwad.components.ad.c.c.c.a(sceneImplCovert, c.this.cS.bT.size(), SystemClock.elapsedRealtime() - jCurrentTimeMillis, c.this.db ? 1 : 0);
                c.this.db = false;
                c.this.cS.bT = adResultData.getAdTemplateList();
                if (c.this.cS.bT.isEmpty()) {
                    onError(com.kwad.sdk.core.network.e.aTe.errorCode, TextUtils.isEmpty(adResultData.testErrorMsg) ? com.kwad.sdk.core.network.e.aTe.msg : adResultData.testErrorMsg);
                    l.at("bannerAd_", "数据为空");
                }
            }

            @Override // com.kwad.components.core.request.d, com.kwad.components.core.request.l
            public final void onError(int i, String str) {
                c.this.handler.postDelayed(new bi() { // from class: com.kwad.components.ad.c.d.c.6.1
                    @Override // com.kwad.sdk.utils.bi
                    public final void doTask() {
                        if (c.this.db) {
                            c.this.cY = true;
                        } else {
                            c.this.aC();
                            c.this.db = true;
                        }
                    }
                }, e.KE());
                com.kwad.components.ad.c.c.c.a(sceneImplCovert, i, str, SystemClock.elapsedRealtime() - jCurrentTimeMillis, c.this.db ? 1 : 0);
            }
        }).wd());
    }

    @Override // com.kwad.components.ad.c.d.a, com.kwad.sdk.mvp.Presenter
    public final void ay() {
        super.ay();
        this.cV = (FrameLayout) findViewById(R.id.ksad_banner_base_content);
        this.startTime = System.currentTimeMillis();
        az();
        b(this.cV);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onDestroy() {
        super.onDestroy();
        this.handler.removeCallbacksAndMessages(null);
    }

    public static /* synthetic */ boolean d(c cVar, boolean z) {
        cVar.da = true;
        return true;
    }

    public static /* synthetic */ boolean e(c cVar, boolean z) {
        cVar.dc = true;
        return true;
    }

    public static /* synthetic */ boolean b(c cVar, boolean z) {
        cVar.cX = true;
        return true;
    }

    private void b(ViewGroup viewGroup) {
        if (e.Kg() || e.Kf() < 0.0f) {
            return;
        }
        com.kwad.components.core.widget.a aVar = new com.kwad.components.core.widget.a(viewGroup.getContext(), viewGroup);
        viewGroup.addView(aVar);
        aVar.setViewCallback(new com.kwad.components.core.widget.a.InterfaceC1245a() { // from class: com.kwad.components.ad.c.d.c.2
            @Override // com.kwad.components.core.widget.a.InterfaceC1245a
            public final void aD() {
            }

            @Override // com.kwad.components.core.widget.a.InterfaceC1245a
            public final void ae() {
            }

            @Override // com.kwad.components.core.widget.a.InterfaceC1245a
            public final void af() {
            }

            @Override // com.kwad.components.core.widget.a.InterfaceC1245a
            public final void b(View view) {
                c.this.az();
            }

            @Override // com.kwad.components.core.widget.a.InterfaceC1245a
            public final void onWindowFocusChanged(boolean z) {
                if (!z) {
                    c.this.dd = false;
                    c.this.aA();
                } else {
                    c.this.dd = true;
                    c.this.startTime = System.currentTimeMillis() - c.this.cZ;
                    c.this.az();
                }
            }
        });
        aVar.zM();
    }
}
