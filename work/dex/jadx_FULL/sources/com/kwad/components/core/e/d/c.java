package com.kwad.components.core.e.d;

import android.content.Context;
import android.text.TextUtils;
import com.kwad.components.core.page.AdWebViewActivityProxy;
import com.kwad.components.core.page.AdWebViewVideoActivityProxy;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.ae;
import com.kwad.sdk.utils.ag;
import com.kwad.sdk.utils.aq;
import com.kwad.sdk.utils.au;
import com.kwad.sdk.utils.bi;
import com.kwad.sdk.utils.i;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public final class c {
    private static int F(AdInfo adInfo) {
        com.kwad.sdk.core.download.a.K(adInfo);
        return 3;
    }

    private static int a(a.C1201a c1201a, AdTemplate adTemplate, Context context) {
        AdWebViewActivityProxy.launch(context, new AdWebViewActivityProxy.a.C1220a().aZ(com.kwad.sdk.core.response.helper.b.dm(adTemplate)).aY(adTemplate).aS(c1201a.pS()).bv(1).ua());
        a.f(adTemplate, 14);
        return 14;
    }

    private static int b(a.C1201a c1201a) {
        Context context = c1201a.getContext();
        AdTemplate adTemplate = c1201a.getAdTemplate();
        AdWebViewActivityProxy.launch(context, new AdWebViewActivityProxy.a.C1220a().aZ(com.kwad.sdk.core.response.helper.b.dm(adTemplate)).aY(adTemplate).aR(true).ua());
        a.f(adTemplate, 20);
        return 20;
    }

    private static int d(final AdTemplate adTemplate, AdInfo adInfo) {
        i.execute(new bi() { // from class: com.kwad.components.core.e.d.c.1
            @Override // com.kwad.sdk.utils.bi
            public final void doTask() {
                com.kwad.sdk.components.d.f(com.kwad.components.a.a.a.class);
            }
        });
        au.az(ServiceProvider.getContext(), com.kwad.sdk.core.response.helper.a.aE(adInfo));
        return 6;
    }

    private static boolean j(a.C1201a c1201a) {
        AdTemplate adTemplate = c1201a.getAdTemplate();
        boolean zL = com.kwad.sdk.utils.f.l(c1201a.getContext(), adTemplate);
        if (zL) {
            t(c1201a);
            a.f(adTemplate, 11);
        }
        return zL;
    }

    public static int q(a.C1201a c1201a) {
        e.aD(false);
        Context context = c1201a.getContext();
        AdTemplate adTemplate = c1201a.getAdTemplate();
        AdInfo adInfoEO = com.kwad.sdk.core.response.helper.e.eO(adTemplate);
        if (c1201a.pV()) {
            return b(c1201a);
        }
        int iF = e.F(c1201a);
        if (iF == 1) {
            t(c1201a);
            return 13;
        }
        if (iF == 2) {
            return 16;
        }
        int iS = s(c1201a);
        if (iS == 1) {
            return 12;
        }
        if (iS == 2) {
            return 17;
        }
        if (!com.kwad.sdk.core.response.helper.a.aL(adInfoEO)) {
            if (adTemplate.isWebViewDownload) {
                int iA = a(c1201a, adTemplate, adInfoEO);
                t(c1201a);
                adTemplate.isWebViewDownload = false;
                return iA;
            }
            if (j(c1201a)) {
                return 11;
            }
            t(c1201a);
            return a(c1201a, adTemplate, context);
        }
        if (c1201a.qh() == 2 || c1201a.qh() == 1) {
            c1201a.av(false);
            t(c1201a);
            return a(c1201a, adTemplate, adInfoEO);
        }
        if (!c1201a.qc() || !com.kwad.sdk.core.response.helper.a.b(adInfoEO, com.kwad.sdk.core.config.e.JJ()) || TextUtils.isEmpty(com.kwad.sdk.core.response.helper.a.aY(adInfoEO)) || AdWebViewVideoActivityProxy.showingAdWebViewVideoActivity) {
            t(c1201a);
            c1201a.av(true);
            return a(c1201a, adTemplate, adInfoEO);
        }
        int iU = c1201a.iv().u(c1201a);
        if (iU == 0) {
            t(c1201a);
            return a(c1201a, adTemplate, context);
        }
        t(c1201a);
        a.f(adTemplate, iU);
        return iU;
    }

    private static int r(a.C1201a c1201a) {
        Context context = c1201a.getContext();
        AdTemplate adTemplate = c1201a.getAdTemplate();
        AdInfo adInfoEO = com.kwad.sdk.core.response.helper.e.eO(adTemplate);
        if (com.kwad.sdk.utils.f.a(context, com.kwad.sdk.core.response.helper.a.dd(adInfoEO), adTemplate) || a(c1201a, adTemplate)) {
            return 11;
        }
        if (aq.isNetworkConnected(context)) {
            return F(adInfoEO);
        }
        ae.V(context, ag.dl(context));
        return 2;
    }

    private static int s(a.C1201a c1201a) {
        Context context = c1201a.getContext();
        AdTemplate adTemplate = c1201a.getAdTemplate();
        int iF = f.f(context, adTemplate);
        if (iF == 1) {
            t(c1201a);
            a.f(adTemplate, 12);
        }
        return iF;
    }

    private static void t(a.C1201a c1201a) {
        if (c1201a.pR() != null) {
            try {
                c1201a.pR().onAdClicked();
            } catch (Throwable th) {
                ServiceProvider.reportSdkCaughtException(th);
            }
        }
    }

    private static int a(a.C1201a c1201a, AdTemplate adTemplate, AdInfo adInfo) {
        int iR;
        d dVarIv = c1201a.iv();
        dVarIv.qs();
        switch (adInfo.status) {
            case 0:
            case 1:
            case 5:
            case 6:
            case 7:
                iR = r(c1201a);
                break;
            case 2:
            case 3:
            case 10:
            default:
                iR = 0;
                break;
            case 4:
                iR = dVarIv.qA();
                break;
            case 8:
            case 9:
            case 11:
                iR = dVarIv.qx();
                break;
            case 12:
                iR = d(adTemplate, adInfo);
                break;
        }
        a.f(c1201a.getAdTemplate(), iR);
        return iR;
    }

    private static boolean a(a.C1201a c1201a, AdTemplate adTemplate) {
        return com.kwad.sdk.utils.f.l(c1201a.getContext(), adTemplate);
    }
}
