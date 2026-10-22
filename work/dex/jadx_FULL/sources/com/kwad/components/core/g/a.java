package com.kwad.components.core.g;

import com.kwad.components.offline.api.core.api.ILoggerReporter;
import com.kwad.sdk.commercial.c;
import com.kwad.sdk.commercial.d;
import com.kwad.sdk.core.config.e;
import com.kwad.sdk.core.threads.GlobalThreadPools;
import com.kwad.sdk.service.ServiceProvider;
import com.kwai.adclient.kscommerciallogger.model.BusinessType;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public final class a {
    public static int RY;
    public static AtomicInteger RZ = new AtomicInteger(0);

    public static void a(final BusinessType businessType) {
        GlobalThreadPools.Oi().execute(new Runnable() { // from class: com.kwad.components.core.g.a.1
            @Override // java.lang.Runnable
            public final void run() {
                try {
                    String strKN = e.KN();
                    if (strKN == null) {
                        return;
                    }
                    JSONObject jSONObject = new JSONObject(strKN);
                    boolean zOptBoolean = jSONObject.optBoolean("isCheatUser", false);
                    boolean zOptBoolean2 = jSONObject.optBoolean("enableAdClientCheaterReport", false);
                    a.RY = jSONObject.optInt("maxCollectCount", 0);
                    if (zOptBoolean2 && a.RZ.incrementAndGet() <= a.RY) {
                        c.d(d.In().m1062do(ILoggerReporter.Category.APM_LOG).g(1.0d).b(businessType).Q("ad_sdk_feature_info_collect", "default_type").i(b.qV().aI(zOptBoolean).aU(a.RY).toJson()));
                    }
                } catch (Throwable th) {
                    ServiceProvider.reportSdkCaughtException(th);
                }
            }
        });
    }
}
