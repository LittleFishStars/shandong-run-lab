package com.kwad.components.ad.reward.presenter;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.bi;
import com.kwad.sdk.utils.by;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public final class f {
    private static long wA;

    private static boolean R(AdTemplate adTemplate) {
        return com.kwad.sdk.core.response.helper.e.n(adTemplate, com.kwad.components.ad.reward.a.b.l(com.kwad.sdk.core.response.helper.e.eO(adTemplate)));
    }

    private static boolean S(AdTemplate adTemplate) {
        return com.kwad.sdk.core.response.helper.e.S(adTemplate);
    }

    private static boolean Z(AdTemplate adTemplate) {
        return com.kwad.sdk.core.response.helper.a.ao(com.kwad.sdk.core.response.helper.e.eO(adTemplate));
    }

    public static void a(final com.kwad.components.ad.reward.g gVar, boolean z) {
        AdTemplate adTemplate = gVar.mAdTemplate;
        final AdInfo adInfoEO = com.kwad.sdk.core.response.helper.e.eO(adTemplate);
        if (!gVar.sO) {
            o(gVar);
            return;
        }
        q(gVar);
        boolean z2 = !gVar.hi() && Z(gVar.mAdTemplate);
        if (R(adTemplate) || S(adTemplate) || gVar.tn < com.kwad.sdk.core.response.helper.a.ak(adInfoEO)) {
            if (z2) {
                a(gVar, new com.kwad.components.ad.reward.h.b() { // from class: com.kwad.components.ad.reward.presenter.f.2
                    @Override // com.kwad.components.ad.reward.h.b, com.kwad.components.core.webview.tachikoma.f.c
                    public final void H(boolean z3) {
                        super.H(z3);
                        if (com.kwad.components.ad.reward.a.b.l(adInfoEO)) {
                            gVar.iM();
                        } else if (com.kwad.sdk.core.response.helper.a.cd(adInfoEO)) {
                            f.p(gVar);
                        } else {
                            f.r(gVar);
                            com.kwad.components.ad.reward.l.j(gVar);
                        }
                    }
                });
                return;
            } else if (com.kwad.sdk.core.response.helper.a.cd(adInfoEO)) {
                p(gVar);
                return;
            } else {
                r(gVar);
                com.kwad.components.ad.reward.l.j(gVar);
                return;
            }
        }
        if (gVar.th) {
            gVar.iM();
            return;
        }
        if (!gVar.to && gVar.tn < com.kwad.sdk.core.response.helper.a.ak(adInfoEO)) {
            if (z) {
                gVar.iM();
                return;
            }
            return;
        }
        if (gVar.to) {
            gVar.aj(2);
        } else {
            gVar.aj(1);
        }
        y(gVar);
        if (com.kwad.sdk.core.response.helper.a.cd(adInfoEO)) {
            p(gVar);
        } else {
            r(gVar);
            com.kwad.components.ad.reward.l.j(gVar);
        }
    }

    private static void o(final com.kwad.components.ad.reward.g gVar) {
        if (com.kwad.sdk.core.response.helper.a.cc(com.kwad.sdk.core.response.helper.e.eO(gVar.mAdTemplate))) {
            p(gVar);
            return;
        }
        if (gVar.sQ) {
            r(gVar);
            return;
        }
        gVar.sT = true;
        com.kwad.components.ad.reward.g.a(gVar.sG, new com.kwad.sdk.g.a<com.kwad.components.ad.reward.k.a>() { // from class: com.kwad.components.ad.reward.presenter.f.1
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.g.a
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public void accept(com.kwad.components.ad.reward.k.a aVar) {
                aVar.kh();
            }
        });
        gVar.sy.onVideoSkipToEnd(0L);
        com.kwad.sdk.core.adlog.c.i(gVar.mAdTemplate, gVar.mReportExtData);
        com.kwad.components.ad.reward.m.e eVar = gVar.sz;
        if (eVar != null) {
            eVar.release();
        }
        gVar.gW();
        u(gVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void p(final com.kwad.components.ad.reward.g gVar) {
        by.runOnUiThread(new bi() { // from class: com.kwad.components.ad.reward.presenter.f.3
            @Override // com.kwad.sdk.utils.bi
            public final void doTask() {
                gVar.hj();
                com.kwad.components.ad.reward.g gVar2 = gVar;
                gVar2.sy.onVideoSkipToEnd(gVar2.tn);
                gVar.release();
                gVar.iM();
            }
        });
    }

    private static void q(com.kwad.components.ad.reward.g gVar) {
        long j = gVar.tm;
        int i = j != 0 ? (int) (j / 1000) : 0;
        long j2 = gVar.tn;
        com.kwad.sdk.core.adlog.c.e(gVar.mAdTemplate, gVar.mReportExtData, new com.kwad.sdk.core.adlog.c.b().ee(69).eh(i).ei(j2 != 0 ? (int) (j2 / 1000) : 0));
    }

    public static void r(final com.kwad.components.ad.reward.g gVar) {
        gVar.sT = true;
        gVar.hj();
        if (i.z(gVar)) {
            by.runOnUiThreadDelay(new Runnable() { // from class: com.kwad.components.ad.reward.presenter.f.4
                @Override // java.lang.Runnable
                public final void run() {
                    f.s(gVar);
                }
            }, 200L);
        } else {
            s(gVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void s(final com.kwad.components.ad.reward.g gVar) {
        com.kwad.components.ad.reward.g.a(gVar.sG, new com.kwad.sdk.g.a<com.kwad.components.ad.reward.k.a>() { // from class: com.kwad.components.ad.reward.presenter.f.5
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.g.a
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public void accept(com.kwad.components.ad.reward.k.a aVar) {
                aVar.kh();
            }
        });
        com.kwad.components.ad.reward.m.e eVar = gVar.sz;
        if (eVar != null) {
            eVar.skipToEnd();
        }
    }

    public static void t(com.kwad.components.ad.reward.g gVar) {
        x(gVar);
        gVar.iM();
    }

    public static void u(com.kwad.components.ad.reward.g gVar) {
        com.kwad.sdk.core.d.c.d("openAppMarket", "tryOpenAppMarket");
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        if (jElapsedRealtime - wA < 300) {
            com.kwad.sdk.core.d.c.d("openAppMarket", "连续点击");
            return;
        }
        wA = jElapsedRealtime;
        AdTemplate adTemplate = gVar.mAdTemplate;
        AdInfo adInfoEO = com.kwad.sdk.core.response.helper.e.eO(adTemplate);
        if (a(adInfoEO, "openAppMarket")) {
            return;
        }
        Context context = gVar.mContext;
        if (a("openAppMarket", adTemplate, adInfoEO)) {
            return;
        }
        com.kwad.sdk.core.adlog.c.b bVarEo = new com.kwad.sdk.core.adlog.c.b().ec(182).eo(8);
        boolean z = com.kwad.sdk.core.download.a.b.I(context, com.kwad.sdk.core.response.helper.a.da(adInfoEO)) == 1;
        com.kwad.sdk.core.d.c.i("openAppMarket", "handleDeepLink dpSuccess: " + z);
        if (z) {
            com.kwad.components.ad.reward.j.b.a(adTemplate, "native_id", "autoLaunchMarket", bVarEo, (JSONObject) null);
            com.kwad.components.ad.reward.h.a.J(context);
            return;
        }
        String strDd = com.kwad.sdk.core.response.helper.a.dd(adInfoEO);
        com.kwad.sdk.core.d.c.i("openAppMarket", "tryOpenMiAppStore url：" + strDd);
        if (com.kwad.sdk.utils.f.a(context, strDd, adTemplate)) {
            com.kwad.components.ad.reward.j.b.a(adTemplate, "native_id", "autoLaunchMarket", bVarEo, (JSONObject) null);
            com.kwad.sdk.core.adlog.c.n(adTemplate, 1, 8);
            com.kwad.components.ad.reward.h.a.J(context);
        } else {
            if (!com.kwad.sdk.utils.f.l(context, adTemplate)) {
                com.kwad.sdk.core.d.c.i("openAppMarket", "tryOpenMiAppStore failed");
                return;
            }
            com.kwad.components.ad.reward.j.b.a(adTemplate, "native_id", "autoLaunchMarket", bVarEo, (JSONObject) null);
            com.kwad.sdk.core.adlog.c.n(adTemplate, 0, 8);
            com.kwad.components.ad.reward.h.a.J(context);
        }
    }

    public static void v(com.kwad.components.ad.reward.g gVar) {
        AdTemplate adTemplate = gVar.mAdTemplate;
        AdInfo adInfoEO = com.kwad.sdk.core.response.helper.e.eO(adTemplate);
        if (!gVar.sO) {
            x(gVar);
            gVar.iM();
            return;
        }
        boolean z = true;
        if (R(adTemplate) || S(adTemplate)) {
            q(gVar);
            if ((gVar.hi() || !Z(gVar.mAdTemplate) || gVar.sT) ? false : true) {
                w(gVar);
                return;
            } else {
                x(gVar);
                gVar.iM();
                return;
            }
        }
        long jAk = com.kwad.sdk.core.response.helper.a.ak(adInfoEO);
        if (!gVar.to && gVar.tn < jAk) {
            z = false;
        }
        if (z) {
            y(gVar);
        }
        x(gVar);
        gVar.iM();
    }

    private static void w(final com.kwad.components.ad.reward.g gVar) {
        final AdTemplate adTemplate = gVar.mAdTemplate;
        com.kwad.components.ad.reward.g.a(gVar, com.kwad.components.ad.reward.h.a(gVar, (String) null), new com.kwad.components.ad.reward.h.b() { // from class: com.kwad.components.ad.reward.presenter.f.6
            @Override // com.kwad.components.ad.reward.h.b, com.kwad.components.core.webview.tachikoma.f.c
            public final void H(boolean z) {
                gVar.F(false);
                if (!z) {
                    com.kwad.sdk.core.adlog.c.t(adTemplate, 151);
                }
                f.x(gVar);
                gVar.iM();
            }

            @Override // com.kwad.components.ad.reward.h.b, com.kwad.components.core.webview.tachikoma.f.c
            public final void hm() {
                gVar.F(true);
                com.kwad.sdk.core.adlog.c.b(adTemplate, 149, gVar.mReportExtData);
            }

            @Override // com.kwad.components.ad.reward.h.b, com.kwad.components.core.webview.tachikoma.f.c
            public final void hv() {
                gVar.F(false);
                com.kwad.sdk.core.adlog.c.t(adTemplate, 150);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void x(com.kwad.components.ad.reward.g gVar) {
        gVar.sy.i(false);
    }

    private static void y(com.kwad.components.ad.reward.g gVar) {
        gVar.sy.onRewardVerify();
    }

    private static boolean a(String str, AdTemplate adTemplate, AdInfo adInfo) {
        if (com.kwad.sdk.core.response.helper.a.bQ(adInfo)) {
            com.kwad.sdk.core.d.c.i(str, "is playable return");
            return true;
        }
        if (!com.kwad.sdk.core.response.helper.a.aL(adInfo)) {
            com.kwad.sdk.core.d.c.i(str, "is not Download type");
            return true;
        }
        if (com.kwad.sdk.core.response.helper.e.n(adTemplate, com.kwad.components.ad.reward.a.b.l(adInfo))) {
            com.kwad.sdk.core.d.c.i(str, "isRewardLaunchAppTask");
            return true;
        }
        if (!com.kwad.components.ad.reward.g.g(adInfo)) {
            return false;
        }
        com.kwad.sdk.core.d.c.i(str, "is Aggregation return");
        return true;
    }

    private static boolean a(AdInfo adInfo, String str) {
        if (!com.kwad.components.ad.reward.a.b.hX()) {
            com.kwad.sdk.core.d.c.e(str, "isEnable false");
            return true;
        }
        if (TextUtils.isEmpty(com.kwad.sdk.core.response.helper.a.dd(adInfo))) {
            return true;
        }
        int iHW = com.kwad.components.ad.reward.a.b.hW();
        com.kwad.sdk.core.d.c.d(str, "JumpDirectMaxCount " + iHW);
        return iHW <= 0 || com.kwad.components.ad.reward.h.a.dV() >= iHW;
    }

    private static void a(final com.kwad.components.ad.reward.g gVar, @NonNull final com.kwad.components.ad.reward.h.b bVar) {
        String str;
        final AdTemplate adTemplate = gVar.mAdTemplate;
        AdInfo adInfoEO = com.kwad.sdk.core.response.helper.e.eO(adTemplate);
        final JSONObject jSONObject = gVar.mReportExtData;
        long jAg = com.kwad.sdk.core.response.helper.a.ag(adInfoEO);
        if (jAg <= 0 || com.kwad.sdk.core.response.helper.a.N(adInfoEO) <= jAg) {
            str = "观看完整视频即可获取奖励";
        } else {
            str = "观看视频" + jAg + "s即可获取奖励";
        }
        final com.kwad.components.ad.reward.h.c cVarA = com.kwad.components.ad.reward.h.a(gVar, str);
        com.kwad.components.ad.reward.g.a(gVar, cVarA, new com.kwad.components.ad.reward.h.b() { // from class: com.kwad.components.ad.reward.presenter.f.7
            @Override // com.kwad.components.ad.reward.h.b, com.kwad.components.core.webview.tachikoma.f.c
            public final void H(boolean z) {
                gVar.F(false);
                if (!z) {
                    com.kwad.sdk.core.adlog.c.t(adTemplate, 151);
                }
                com.kwad.components.ad.reward.h.b bVar2 = bVar;
                if (bVar2 != null) {
                    bVar2.H(z);
                }
            }

            @Override // com.kwad.components.ad.reward.h.b, com.kwad.components.ad.reward.h.a
            public final void h(int i, int i2) {
                super.h(i, i2);
                com.kwad.components.ad.reward.g gVar2 = gVar;
                gVar2.a(1, gVar2.mContext, i, i2);
            }

            @Override // com.kwad.components.ad.reward.h.b, com.kwad.components.core.webview.tachikoma.f.c
            public final void hm() {
                com.kwad.components.ad.reward.m.e eVar = gVar.sz;
                if (eVar != null) {
                    eVar.pause();
                }
                gVar.F(true);
                if (cVarA.getStyle() == 0) {
                    com.kwad.sdk.core.adlog.c.j(adTemplate, jSONObject);
                } else {
                    com.kwad.sdk.core.adlog.c.b(adTemplate, 149, jSONObject);
                }
            }

            @Override // com.kwad.components.ad.reward.h.b, com.kwad.components.ad.reward.h.a
            public final void ht() {
                super.ht();
                com.kwad.sdk.core.adlog.c.t(adTemplate, 150);
                com.kwad.components.ad.reward.g gVar2 = gVar;
                gVar2.a(1, gVar2.mContext, 156, 1);
            }

            @Override // com.kwad.components.ad.reward.h.b, com.kwad.components.core.webview.tachikoma.f.c
            public final void hu() {
                super.hu();
                gVar.F(false);
            }

            @Override // com.kwad.components.ad.reward.h.b, com.kwad.components.core.webview.tachikoma.f.c
            public final void hv() {
                gVar.F(false);
                com.kwad.components.ad.reward.m.e eVar = gVar.sz;
                if (eVar != null) {
                    eVar.resume();
                }
                if (cVarA.getStyle() == 1 || cVarA.getStyle() == 2 || cVarA.getStyle() == 5 || cVarA.getStyle() == 8) {
                    com.kwad.sdk.core.adlog.c.t(adTemplate, 150);
                } else {
                    com.kwad.sdk.core.adlog.c.k(adTemplate, jSONObject);
                }
            }
        });
    }
}
