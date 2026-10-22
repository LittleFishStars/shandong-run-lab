package com.kwad.components.ad.splashscreen;

import android.text.TextUtils;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public final class d {
    public static int GF;
    private String GG;
    private int GH = 2;

    public static d a(AdTemplate adTemplate, AdInfo adInfo, com.kwad.components.core.e.d.d dVar, int i) {
        d dVar2 = new d();
        GF = i;
        if (adInfo != null && dVar != null) {
            if (i == 1 || i == 4) {
                dVar2.ad(a(adTemplate, adInfo, dVar));
            } else if (i == 10) {
                if (com.kwad.sdk.core.response.helper.a.aL(adInfo)) {
                    int iQn = dVar.qn();
                    if (iQn == 2) {
                        dVar2.ad(a(adTemplate, adInfo, iQn, 0));
                    } else {
                        dVar2.ad("扭动或点击" + a(adTemplate, adInfo, iQn, 0));
                    }
                } else {
                    try {
                        String strDU = com.kwad.sdk.core.response.helper.b.dU(adInfo);
                        if (TextUtils.isEmpty(strDU)) {
                            dVar2.ad("或点击跳转详情页或第三方应用");
                        } else {
                            dVar2.ad("扭动或点击" + strDU);
                        }
                    } catch (Exception unused) {
                        dVar2.ad("或点击跳转详情页或第三方应用");
                    }
                }
            } else if (com.kwad.sdk.core.response.helper.a.aL(adInfo)) {
                dVar2.ad("或点击" + a(adTemplate, adInfo, dVar.qn(), 0));
            } else {
                String strA = com.kwad.sdk.core.config.e.a(com.kwad.components.ad.splashscreen.b.a.Hl);
                if (TextUtils.isEmpty(strA)) {
                    strA = "点击跳转详情页或第三方应用";
                }
                dVar2.ad("或" + strA);
            }
        }
        dVar2.av(com.kwad.sdk.core.response.helper.b.eb(adInfo));
        return dVar2;
    }

    private void ad(String str) {
        this.GG = str;
    }

    private void av(int i) {
        this.GH = i;
    }

    public final String lW() {
        return this.GG;
    }

    public final int lX() {
        return this.GH;
    }

    public static String a(AdTemplate adTemplate, AdInfo adInfo, int i, int i2) {
        String strAK = com.kwad.sdk.core.response.helper.a.aK(adInfo);
        if (i == 2) {
            return i2 + "%";
        }
        if (i == 4) {
            return com.ipd.dsp.internal.b1.b.a.n;
        }
        if (i != 8) {
            return i != 12 ? strAK : com.kwad.sdk.core.response.helper.a.af(adInfo);
        }
        return com.kwad.sdk.core.response.helper.a.cK(adTemplate);
    }

    private static String a(AdInfo adInfo, int i) {
        if (i == 1) {
            return com.kwad.sdk.core.response.helper.b.dU(adInfo) != null ? com.kwad.sdk.core.response.helper.b.dU(adInfo) : "";
        }
        return (i != 4 || com.kwad.sdk.core.response.helper.b.dV(adInfo) == null) ? "" : com.kwad.sdk.core.response.helper.b.dV(adInfo);
    }

    private static String a(AdTemplate adTemplate, AdInfo adInfo, com.kwad.components.core.e.d.d dVar) {
        if (com.kwad.sdk.core.response.helper.a.aL(adInfo)) {
            return a(adTemplate, adInfo, dVar.qn(), 0);
        }
        String strA = a(adInfo, GF);
        return TextUtils.isEmpty(strA) ? "点击跳转详情页或第三方应用" : strA;
    }
}
