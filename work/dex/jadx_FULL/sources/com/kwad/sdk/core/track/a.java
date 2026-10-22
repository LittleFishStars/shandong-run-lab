package com.kwad.sdk.core.track;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.kwad.components.ad.reward.monitor.FraudVerifyCode;
import com.kwad.sdk.core.d.c;
import com.kwad.sdk.core.response.helper.e;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.export.proxy.AdHttpProxy;
import com.kwad.sdk.h;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.ak;
import com.kwad.sdk.utils.ar;
import com.kwad.sdk.utils.by;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class a {
    private static List<String> a(AdTemplate adTemplate, int i, @NonNull com.kwad.sdk.core.adlog.c.a aVar) {
        List<String> list;
        ArrayList arrayList = new ArrayList();
        AdInfo adInfoEO = e.eO(adTemplate);
        List<AdInfo.AdTrackInfo> list2 = adInfoEO.adTrackInfoList;
        if (ar.R(list2)) {
            return arrayList;
        }
        List<String> listA = a(i, aVar, arrayList, adInfoEO, list2);
        if (listA != null) {
            return listA;
        }
        for (AdInfo.AdTrackInfo adTrackInfo : list2) {
            if (adTrackInfo.type == i && (list = adTrackInfo.urls) != null) {
                arrayList.addAll(list);
                break;
            }
        }
        return arrayList;
    }

    public static void e(@NonNull com.kwad.sdk.core.adlog.c.a aVar) {
        AdTemplate adTemplate = aVar.adTemplate;
        AdInfo adInfoEO = e.eO(adTemplate);
        int i = aVar.aKI;
        List<String> listA = a(adTemplate, i, aVar);
        if (ar.R(listA)) {
            return;
        }
        boolean zDE = com.kwad.sdk.core.response.helper.a.dE(adInfoEO);
        boolean zDF = com.kwad.sdk.core.response.helper.a.dF(adInfoEO);
        for (String str : listA) {
            com.kwad.sdk.commercial.i.a.p(adTemplate, i, str);
            if (adTemplate.isCheatingFlow()) {
                com.kwad.sdk.commercial.i.a.o(adTemplate, i, str);
                return;
            }
            if (by.ir(str)) {
                com.kwad.sdk.commercial.i.a.a(adTemplate, i, str, "", FraudVerifyCode.RerwardFraudUnknown, "", 0);
                return;
            }
            HashMap map = null;
            String strA = ak.a(ServiceProvider.getContext(), str, i == 2 ? aVar.no : null, com.kwad.sdk.core.response.helper.a.aH(e.eO(adTemplate)));
            ak.f(adTemplate, str, strA);
            AdHttpProxy adHttpProxyEG = h.EG();
            int i2 = adHttpProxyEG instanceof com.kwad.sdk.core.network.c.a ? 2 : 1;
            c.d("AdTrackUtil", "handleTrackUrl useKwaiUA: " + zDE);
            if (zDE) {
                com.kwad.sdk.core.i.c cVarK = com.kwad.sdk.core.i.a.k(zDE, zDF);
                c.d("AdTrackUtil", "handleTrackUrl uaGetter: " + cVarK);
                if (cVarK != null) {
                    map = new HashMap();
                    map.put("User-Agent", cVarK.OC());
                }
            }
            com.kwad.sdk.core.network.c cVarDoGetWithoutResponse = adHttpProxyEG.doGetWithoutResponse(strA, map, !zDE);
            if (eK(cVarDoGetWithoutResponse.code)) {
                c.d("AdTrackUtil", "trackUrl request success actionType: " + i);
                com.kwad.sdk.commercial.i.a.a(adTemplate, i, str, cVarDoGetWithoutResponse.code, i2);
            } else {
                com.kwad.sdk.commercial.i.a.a(adTemplate, i, str, strA, com.kwad.sdk.commercial.e.dt(cVarDoGetWithoutResponse.code), cVarDoGetWithoutResponse.aSY, i2);
            }
        }
    }

    private static boolean eK(int i) {
        return i >= 200 && i < 300;
    }

    private static List<String> a(int i, com.kwad.sdk.core.adlog.c.a aVar, List<String> list, AdInfo adInfo, List<AdInfo.AdTrackInfo> list2) {
        int iOptInt;
        List<String> list3;
        if (i != 402 || !com.kwad.sdk.core.response.helper.a.bu(adInfo)) {
            return null;
        }
        try {
            if (!TextUtils.isEmpty(aVar.QY)) {
                iOptInt = new JSONObject(aVar.QY).optInt("photoPlaySecond");
            } else {
                iOptInt = aVar.aMf;
            }
            JSONObject jSONObject = new JSONObject(adInfo.adBaseInfo.videoPlayedNSConfig);
            for (AdInfo.AdTrackInfo adTrackInfo : list2) {
                if (adTrackInfo.type == jSONObject.optInt(String.valueOf(iOptInt)) && (list3 = adTrackInfo.urls) != null) {
                    list.addAll(list3);
                    break;
                }
            }
        } catch (Throwable unused) {
        }
        return list;
    }
}
