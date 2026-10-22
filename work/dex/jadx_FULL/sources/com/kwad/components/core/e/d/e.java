package com.kwad.components.core.e.d;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.internal.api.SceneImpl;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.au;
import com.kwad.sdk.utils.by;
import com.kwad.sdk.wrapper.m;
import java.util.concurrent.Callable;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public final class e {
    private static boolean Rv = false;
    private static final b Rw = new b() { // from class: com.kwad.components.core.e.d.e.4
        long RD;

        @Override // com.kwad.sdk.core.c.d, com.kwad.sdk.core.c.c
        public final void onBackToBackground() {
            super.onBackToBackground();
            this.RD = System.currentTimeMillis();
        }

        @Override // com.kwad.sdk.core.c.d, com.kwad.sdk.core.c.c
        public final void onBackToForeground() {
            super.onBackToForeground();
            if (this.RD != 0) {
                com.kwad.sdk.core.adlog.c.n(getAdTemplate(), System.currentTimeMillis() - this.RD);
            }
            com.kwad.sdk.core.c.b.LW();
            com.kwad.sdk.core.c.b.b((com.kwad.sdk.core.c.c) e.Rw);
            setAdTemplate(null);
            this.RD = 0L;
        }
    };

    public static int F(a.C1201a c1201a) {
        Context context = c1201a.getContext();
        final AdTemplate adTemplate = c1201a.getAdTemplate();
        String strB = b(c1201a, adTemplate);
        if (TextUtils.isEmpty(strB)) {
            return 0;
        }
        final AdInfo adInfoEO = com.kwad.sdk.core.response.helper.e.eO(adTemplate);
        final String strA = a(strB, c1201a, adInfoEO);
        return com.kwad.sdk.core.download.a.b.a(context, strA, new com.kwad.sdk.core.download.a.b.a() { // from class: com.kwad.components.core.e.d.e.2
            @Override // com.kwad.sdk.core.download.a.b.a
            public final void aT(int i) {
            }

            @Override // com.kwad.sdk.core.download.a.b.a
            public final void onError(Throwable th) {
                com.kwad.sdk.commercial.e.a.d(adTemplate, strA, by.y(th));
            }

            @Override // com.kwad.sdk.core.download.a.b.a
            public final void onPreStart() {
                com.kwad.sdk.commercial.e.a.o(adTemplate, strA);
            }

            @Override // com.kwad.sdk.core.download.a.b.a
            public final void onStart() {
                com.kwad.sdk.commercial.e.a.q(adTemplate, strA);
            }

            @Override // com.kwad.sdk.core.download.a.b.a
            public final void onSuccess() {
                com.kwad.sdk.commercial.e.a.r(adTemplate, strA);
            }

            @Override // com.kwad.sdk.core.download.a.b.a
            public final void qG() {
                com.kwad.sdk.commercial.e.a.p(adTemplate, strA);
            }

            @Override // com.kwad.sdk.core.download.a.b.a
            public final boolean qH() {
                return com.kwad.sdk.core.response.helper.a.cr(adInfoEO);
            }
        });
    }

    public static int a(final a.C1201a c1201a, int i) {
        Context context = c1201a.getContext();
        final AdTemplate adTemplate = c1201a.getAdTemplate();
        String strB = b(c1201a, adTemplate);
        if (TextUtils.isEmpty(strB)) {
            return 0;
        }
        final AdInfo adInfoEO = com.kwad.sdk.core.response.helper.e.eO(adTemplate);
        Activity activityFromContext = m.getActivityFromContext(context);
        if (activityFromContext == null || !com.kwad.sdk.core.response.helper.a.W(adInfoEO) || c1201a.pP()) {
            final String strA = a(strB, c1201a, adInfoEO);
            final int i2 = 1;
            return com.kwad.sdk.core.download.a.b.a(context, strA, new com.kwad.sdk.core.download.a.b.a() { // from class: com.kwad.components.core.e.d.e.1
                @Override // com.kwad.sdk.core.download.a.b.a
                public final void aT(int i3) {
                    a.C1201a c1201a2 = c1201a;
                    if (c1201a2.QZ == null) {
                        c1201a2.QZ = new com.kwad.sdk.core.adlog.a.C1273a();
                    }
                    a.C1201a c1201a3 = c1201a;
                    c1201a3.QZ.aLG = c1201a3.pP() ? 2 : 1;
                    com.kwad.sdk.core.adlog.c.a aVarQa = c1201a.qa();
                    if (qH()) {
                        if (aVarQa.QZ == null) {
                            aVarQa.QZ = new com.kwad.sdk.core.adlog.a.C1273a();
                        }
                        aVarQa.QZ.aLr = true;
                    }
                    aVarQa.aMv = i3;
                    com.kwad.sdk.core.adlog.c.a(adTemplate, "", i2, aVarQa);
                }

                @Override // com.kwad.sdk.core.download.a.b.a
                public final void onError(Throwable th) {
                    com.kwad.sdk.core.adlog.c.a aVar = new com.kwad.sdk.core.adlog.c.a();
                    aVar.QZ = new com.kwad.sdk.core.adlog.a.C1273a();
                    if (qH()) {
                        aVar.QZ.aLr = true;
                    }
                    aVar.QZ.aLG = c1201a.pP() ? 2 : 1;
                    com.kwad.sdk.core.adlog.c.d(adTemplate, "", i2, aVar);
                    com.kwad.sdk.commercial.e.a.d(adTemplate, strA, by.y(th));
                }

                @Override // com.kwad.sdk.core.download.a.b.a
                public final void onPreStart() {
                    a.C1201a c1201a2 = c1201a;
                    if (c1201a2.QZ == null) {
                        c1201a2.QZ = new com.kwad.sdk.core.adlog.a.C1273a();
                    }
                    a.C1201a c1201a3 = c1201a;
                    c1201a3.QZ.aLG = c1201a3.pP() ? 2 : 1;
                    com.kwad.sdk.core.adlog.c.a aVarQa = c1201a.qa();
                    if (qH()) {
                        if (aVarQa.QZ == null) {
                            aVarQa.QZ = new com.kwad.sdk.core.adlog.a.C1273a();
                        }
                        aVarQa.QZ.aLr = true;
                    }
                    com.kwad.sdk.core.adlog.c.b(adTemplate, "", i2, aVarQa);
                    com.kwad.sdk.commercial.e.a.o(adTemplate, strA);
                }

                @Override // com.kwad.sdk.core.download.a.b.a
                public final void onStart() {
                    com.kwad.components.core.proxy.launchdialog.e.vJ().ba(adTemplate);
                    e.Rw.setAdTemplate(adTemplate);
                    com.kwad.sdk.core.c.b.LW();
                    com.kwad.sdk.core.c.b.a(e.Rw);
                    com.kwad.sdk.core.adlog.c.aLJ = e.ar(strA);
                    com.kwad.sdk.commercial.e.a.q(adTemplate, strA);
                }

                @Override // com.kwad.sdk.core.download.a.b.a
                public final void onSuccess() {
                    a.C1201a c1201a2 = c1201a;
                    if (c1201a2.QZ == null) {
                        c1201a2.QZ = new com.kwad.sdk.core.adlog.a.C1273a();
                    }
                    a.C1201a c1201a3 = c1201a;
                    c1201a3.QZ.aLG = c1201a3.pP() ? 2 : 1;
                    com.kwad.sdk.core.adlog.c.a aVarQa = c1201a.qa();
                    if (qH()) {
                        if (aVarQa.QZ == null) {
                            aVarQa.QZ = new com.kwad.sdk.core.adlog.a.C1273a();
                        }
                        aVarQa.QZ.aLr = true;
                    }
                    com.kwad.sdk.commercial.e.a.r(adTemplate, strA);
                    com.kwad.sdk.core.adlog.c.c(adTemplate, "", i2, aVarQa);
                    e.a(adTemplate, strA, i2, c1201a.QZ.aLG);
                }

                @Override // com.kwad.sdk.core.download.a.b.a
                public final void qG() {
                    com.kwad.sdk.commercial.e.a.p(adTemplate, strA);
                }

                @Override // com.kwad.sdk.core.download.a.b.a
                public final boolean qH() {
                    return com.kwad.sdk.core.response.helper.a.cr(adInfoEO);
                }
            });
        }
        c1201a.aK(1);
        com.kwad.components.core.e.e.e.a(activityFromContext, c1201a);
        return 2;
    }

    public static void aD(boolean z) {
        com.kwad.sdk.core.adlog.c.aLK = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void aE(boolean z) {
        Rv = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static JSONObject ar(String str) {
        try {
            return new JSONObject(Uri.parse(str).getQueryParameter("universeClientInfo"));
        } catch (Throwable unused) {
            return null;
        }
    }

    private static String l(String str, String str2) {
        Uri.Builder builderAppendQueryParameter = Uri.parse(str).buildUpon().appendQueryParameter("returnBack", "liveunion_" + ServiceProvider.getAppId());
        if (TextUtils.isEmpty(str2)) {
            str2 = "0";
        }
        return builderAppendQueryParameter.appendQueryParameter("back_url", str2).toString();
    }

    private static boolean qE() {
        return Rv;
    }

    private static String b(a.C1201a c1201a, AdTemplate adTemplate) {
        AdInfo adInfoEO = com.kwad.sdk.core.response.helper.e.eO(adTemplate);
        for (AdInfo.AdConversionInfo.DeeplinkItemInfo deeplinkItemInfo : adInfoEO.adConversionInfo.deeplinkConf) {
            boolean zContains = deeplinkItemInfo.areaConf.contains(Integer.valueOf(c1201a.eg()));
            boolean zContains2 = deeplinkItemInfo.sceneConf.contains(Integer.valueOf(c1201a.pT()));
            if ((zContains && zContains2) || ((zContains && deeplinkItemInfo.sceneConf.size() == 0) || (zContains2 && deeplinkItemInfo.areaConf.size() == 0))) {
                if (!TextUtils.isEmpty(deeplinkItemInfo.url)) {
                    return deeplinkItemInfo.url + adInfoEO.adConversionInfo.deeplinkExtra;
                }
            }
        }
        return com.kwad.sdk.core.response.helper.a.da(adInfoEO);
    }

    private static String a(String str, a.C1201a c1201a, AdInfo adInfo) {
        AdTemplate adTemplate = c1201a.getAdTemplate();
        if (com.kwad.sdk.core.response.helper.a.bs(adInfo)) {
            str = b(c1201a, adInfo, str);
        }
        if (com.kwad.sdk.core.response.helper.a.cY(adInfo)) {
            str = a(c1201a, adInfo, str);
        }
        return ((com.kwad.sdk.core.response.helper.a.cQ(adInfo) || com.kwad.sdk.core.response.helper.a.cW(adInfo)) && adTemplate.mAdScene != null) ? a(str, c1201a.getContext(), adTemplate.mAdScene) : str;
    }

    private static String b(a.C1201a c1201a, AdInfo adInfo, String str) {
        long jMax = c1201a.getAdTemplate().getmCurPlayTime();
        if (jMax > 0) {
            jMax = Math.max(jMax - com.kwad.sdk.core.response.helper.a.bt(adInfo), 0L);
        }
        return Uri.parse(str).buildUpon().appendQueryParameter("playStartTime", String.valueOf(jMax)).toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void a(final AdTemplate adTemplate, final String str, final int i, final int i2) {
        if (qE()) {
            return;
        }
        aE(true);
        int iJK = com.kwad.sdk.core.config.e.JK();
        com.kwad.sdk.core.config.e.JL();
        int iAbs = Math.abs(iJK);
        if (iAbs > 0) {
            by.a(new Runnable() { // from class: com.kwad.components.core.e.d.e.3
                @Override // java.lang.Runnable
                public final void run() {
                    e.aE(false);
                    com.kwad.sdk.core.c.b.LW();
                    if (com.kwad.sdk.core.c.b.isAppOnForeground()) {
                        return;
                    }
                    com.kwad.sdk.core.adlog.c.d(adTemplate, "", i, i2);
                    com.kwad.sdk.commercial.e.a.s(adTemplate, str);
                }
            }, null, ((long) iAbs) * 1000);
        } else {
            aE(false);
        }
    }

    private static String a(a.C1201a c1201a, AdInfo adInfo, String str) {
        String strCall;
        String strValueOf;
        if (!com.kwad.sdk.core.response.helper.a.bp(adInfo)) {
            return str;
        }
        Callable<String> callablePO = c1201a.pO();
        if (callablePO != null) {
            try {
                strCall = callablePO.call();
            } catch (Exception unused) {
                strCall = null;
            }
        } else {
            strCall = null;
        }
        if (TextUtils.isEmpty(strCall)) {
            strCall = c1201a.pN();
        }
        if (TextUtils.isEmpty(strCall)) {
            return (str.contains("__itemId__") || str.contains("__simpleItemId__")) ? com.kwad.sdk.core.response.helper.a.da(adInfo) : str;
        }
        try {
            strValueOf = String.valueOf(com.kwad.components.core.e.b.a.am(strCall));
        } catch (Throwable unused2) {
            strValueOf = strCall;
        }
        return str.replaceAll("__itemId__", strCall).replaceAll("__simpleItemId__", strValueOf);
    }

    private static String a(String str, Context context, SceneImpl sceneImpl) {
        if (sceneImpl == null) {
            return "";
        }
        int i = 0;
        if (!au.aw(context, "com.smile.gifmaker") && au.aw(context, "com.kuaishou.nebula")) {
            i = 3;
        }
        String backUrl = sceneImpl.getBackUrl();
        return a(str, i, TextUtils.isEmpty(backUrl) ? "" : backUrl);
    }

    private static String a(String str, int i, String str2) {
        if (TextUtils.isEmpty(str2)) {
            return str;
        }
        return (i == 0 || i == 3) ? l(str, str2) : str;
    }
}
