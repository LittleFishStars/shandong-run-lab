package com.kwad.sdk.core.adlog;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.components.ad.reward.monitor.FraudVerifyCode;
import com.kwad.sdk.commercial.e;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.threads.GlobalThreadPools;
import com.kwad.sdk.h;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.ac;
import com.kwad.sdk.utils.aq;
import com.kwad.sdk.utils.bi;
import com.kwad.sdk.utils.by;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class b {
    public static void IS() {
        GlobalThreadPools.Oi().execute(new bi() { // from class: com.kwad.sdk.core.adlog.b.2
            @Override // com.kwad.sdk.utils.bi
            public final void doTask() {
                com.kwad.sdk.core.adlog.a.a aVarIY = com.kwad.sdk.core.adlog.a.b.IV().IY();
                if (aVarIY != null) {
                    JSONObject jSONObject = aVarIY.aLM;
                    ac.putValue(jSONObject, "retryCount", aVarIY.retryCount);
                    ac.putValue(jSONObject, "cacheType", 1);
                    b.a(aVarIY.url, jSONObject, aVarIY.aLN, aVarIY);
                }
            }
        });
    }

    public static void a(@NonNull final com.kwad.sdk.core.adlog.c.a aVar) {
        GlobalThreadPools.Oi().execute(new bi() { // from class: com.kwad.sdk.core.adlog.b.1
            @Override // com.kwad.sdk.utils.bi
            public final void doTask() {
                a aVar2 = new a(aVar);
                b.a(aVar2.getUrl(), aVar2.getBody(), aVar, null);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void a(String str, JSONObject jSONObject, @NonNull com.kwad.sdk.core.adlog.c.a aVar, @Nullable com.kwad.sdk.core.adlog.a.a aVar2) {
        AdTemplate adTemplate = aVar.adTemplate;
        int i = aVar.aKI;
        try {
            com.kwad.sdk.core.adlog.b.c.a(adTemplate, i, aVar2);
            if (!aq.isNetworkConnected(ServiceProvider.getContext())) {
                com.kwad.sdk.core.d.c.w("AdLogRequestManager", "no network while report log");
                com.kwad.sdk.core.adlog.b.c.a(adTemplate, i, str, 100004, "no network", aVar2);
                com.kwad.sdk.core.adlog.a.b.IV().a(aVar2, str, jSONObject, aVar, 100004, "no network");
                return;
            }
            if (by.ir(str)) {
                com.kwad.sdk.core.adlog.b.c.b(adTemplate, i, str, FraudVerifyCode.RerwardFraudUnknown, "", aVar2);
                return;
            }
            com.kwad.sdk.core.network.c cVarDoPost = h.EG().doPost(str, (Map<String, String>) null, jSONObject);
            AdLogRequestResult adLogRequestResult = new AdLogRequestResult();
            adLogRequestResult.parseResult(cVarDoPost.aSY);
            int i2 = cVarDoPost.code;
            if (i2 != 200) {
                int iDt = e.dt(i2);
                String str2 = cVarDoPost.aSY;
                com.kwad.sdk.core.adlog.b.c.d(adTemplate, i, str, iDt, str2, aVar2);
                com.kwad.sdk.core.adlog.a.b.IV().a(aVar2, str, jSONObject, aVar, iDt, str2);
                return;
            }
            if (adLogRequestResult.isResultOk()) {
                com.kwad.sdk.core.adlog.b.c.b(adTemplate, i, aVar2);
                b(aVar);
                com.kwad.sdk.core.adlog.a.b.IV().IW();
                return;
            }
            if (adLogRequestResult.isCheatingFlow()) {
                adTemplate.setCheatingFlow(adLogRequestResult.isCheatingFlow());
                com.kwad.sdk.core.adlog.b.c.c(adTemplate, i, str, adLogRequestResult.result, adLogRequestResult.errorMsg, aVar2);
                return;
            }
            int i3 = adLogRequestResult.result;
            String str3 = adLogRequestResult.errorMsg;
            com.kwad.sdk.core.d.c.w("AdLogRequestManager", "request fail code:" + i3 + ", errorMsg:" + str3 + ", url=" + str);
            com.kwad.sdk.core.adlog.b.c.c(adTemplate, i, str, i3, str3, aVar2);
            com.kwad.sdk.core.adlog.a.b.IV().a(aVar2, str, jSONObject, aVar, i3, str3);
        } catch (Throwable th) {
            com.kwad.sdk.core.adlog.b.c.b(adTemplate, i, "", 100000, by.y(th), aVar2);
            com.kwad.sdk.core.d.c.printStackTrace(th);
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void b(@NonNull com.kwad.sdk.core.adlog.c.a aVar) {
        try {
            com.kwad.sdk.core.track.a.e(aVar);
        } catch (Throwable th) {
            com.kwad.sdk.core.d.c.printStackTrace(th);
            ServiceProvider.reportSdkCaughtException(th);
        }
    }
}
