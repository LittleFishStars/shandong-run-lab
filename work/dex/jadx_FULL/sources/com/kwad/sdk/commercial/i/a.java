package com.kwad.sdk.commercial.i;

import android.text.TextUtils;
import com.ksad.json.annotation.KsJson;
import com.kwad.components.offline.api.core.api.ILoggerReporter;
import com.kwad.sdk.commercial.d;
import com.kwad.sdk.commercial.e;
import com.kwad.sdk.core.c;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.service.a.h;
import com.kwad.sdk.utils.ac;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class a {
    private static C1271a aKG;

    /* JADX INFO: renamed from: com.kwad.sdk.commercial.i.a$a, reason: collision with other inner class name */
    @KsJson
    public static class C1271a extends com.kwad.sdk.core.response.a.a {
        public List<String> aKH;
    }

    private static C1271a Iy() {
        String strGc = ((h) ServiceProvider.get(h.class)).Gc();
        if (!TextUtils.isEmpty(strGc)) {
            aKG = (C1271a) ac.b(strGc, new c<C1271a>() { // from class: com.kwad.sdk.commercial.i.a.1
                private static C1271a Iz() {
                    return new C1271a();
                }

                @Override // com.kwad.sdk.core.c
                public final /* synthetic */ com.kwad.sdk.core.b IA() {
                    return Iz();
                }
            });
        }
        return aKG;
    }

    private static void a(AdTemplate adTemplate, b bVar) {
        a(adTemplate, false, bVar);
    }

    private static boolean dK(String str) {
        C1271a c1271aIy;
        List<String> list;
        if (TextUtils.isEmpty(str) || (c1271aIy = Iy()) == null || (list = c1271aIy.aKH) == null) {
            return false;
        }
        for (String str2 : list) {
            if (!TextUtils.isEmpty(str2) && str.contains(str2)) {
                return true;
            }
        }
        return false;
    }

    public static void o(AdTemplate adTemplate, int i, String str) {
        try {
            a(adTemplate, b.IB().dF(4).dG(i).dL(str).setAdTemplate(adTemplate));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void p(AdTemplate adTemplate, int i, String str) {
        try {
            a(adTemplate, b.IB().dF(1).dG(i).dL(str).setAdTemplate(adTemplate));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    private static void a(AdTemplate adTemplate, boolean z, b bVar) {
        if (dK(bVar.aKA)) {
            return;
        }
        com.kwad.sdk.commercial.c.d(d.In().m1062do(z ? ILoggerReporter.Category.ERROR_LOG : ILoggerReporter.Category.APM_LOG).g(z ? 1.0d : 0.001d).b(e.bA(adTemplate)).Q("ad_sdk_track_performance", "status").A(bVar));
    }

    public static void a(AdTemplate adTemplate, String str, String str2, String str3, String str4) {
        try {
            com.kwad.sdk.commercial.c.d(d.In().m1062do(ILoggerReporter.Category.ERROR_LOG).g(1.0d).b(e.bA(adTemplate)).Q("ad_sdk_macro_check_performance", "error_name").A(com.kwad.sdk.commercial.h.a.Ix().dD(str).dF(str2).dG(str3).dE(str4).setAdTemplate(adTemplate)));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void a(AdTemplate adTemplate, int i, String str, int i2, int i3) {
        try {
            a(adTemplate, b.IB().dF(2).dG(i).dL(str).dH(i3).setErrorCode(i2).setAdTemplate(adTemplate));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void a(AdTemplate adTemplate, int i, String str, String str2, int i2, String str3, int i3) {
        try {
            a(adTemplate, true, b.IB().dF(3).dG(i).dL(str).dM(str2).setErrorCode(i2).setErrorMsg(str3).dH(i3).setAdTemplate(adTemplate));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }
}
