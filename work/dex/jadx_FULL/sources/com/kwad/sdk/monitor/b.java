package com.kwad.sdk.monitor;

import androidx.annotation.Nullable;
import com.ksad.json.annotation.KsJson;
import com.kwad.components.offline.api.core.api.ILoggerReporter;
import com.kwad.sdk.commercial.c;
import com.kwad.sdk.commercial.d;
import com.kwad.sdk.core.config.e;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.ab;
import com.kwad.sdk.utils.bi;
import com.kwad.sdk.utils.i;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
public class b {
    static final /* synthetic */ boolean $assertionsDisabled = false;

    @KsJson
    public static class a extends com.kwad.sdk.commercial.c.a {
        public String bdL;
        public int bjg;
        public String sdkVersion;
    }

    /* JADX INFO: renamed from: com.kwad.sdk.monitor.b$b, reason: collision with other inner class name */
    @KsJson
    public static class C1305b extends com.kwad.sdk.commercial.c.a {
        public int bjh;
        public String bji;
        public String bjj;
        public String bjk;
        public String bjl;
        public String bjm;
    }

    public static void Sx() {
        i.execute(new bi() { // from class: com.kwad.sdk.monitor.b.1
            @Override // com.kwad.sdk.utils.bi
            public final void doTask() {
                b.Sy();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void Sy() {
        a aVarA;
        JSONObject jSONObject = (JSONObject) e.JS().getAppConfigData(null, new com.kwad.sdk.g.b<JSONObject, JSONObject>() { // from class: com.kwad.sdk.monitor.b.2
            private static JSONObject p(JSONObject jSONObject2) {
                return jSONObject2.optJSONObject("sdkTTPerfMonitor");
            }

            @Override // com.kwad.sdk.g.b
            public final /* synthetic */ JSONObject apply(JSONObject jSONObject2) {
                return p(jSONObject2);
            }
        });
        if (jSONObject == null) {
            return;
        }
        C1305b c1305b = new C1305b();
        try {
            c1305b.parseJson(jSONObject);
            if (c1305b.bjh == 1 && (aVarA = a(ServiceProvider.getContext().getClassLoader(), c1305b)) != null) {
                c.d(d.In().m1062do(ILoggerReporter.Category.APM_LOG).g(0.01d).Q("ad_sdk_tt_sdk_info", com.alipay.sdk.m.w.a.v).A(aVarA).a(com.kwai.adclient.kscommerciallogger.model.a.buA));
            }
        } catch (Throwable unused) {
        }
    }

    @Nullable
    private static a a(ClassLoader classLoader, C1305b c1305b) {
        Class<?> clsA = ab.a(c1305b.bji, classLoader);
        if (clsA == null) {
            return null;
        }
        a aVar = new a();
        aVar.bjg = ab.classExists(c1305b.bjj) ? 1 : 0;
        Object objCallStaticMethod = ab.callStaticMethod(clsA, c1305b.bjk, new Object[0]);
        aVar.sdkVersion = (String) ab.callMethod(objCallStaticMethod, c1305b.bjl, new Object[0]);
        aVar.bdL = (String) ab.callMethod(objCallStaticMethod, c1305b.bjm, new Object[0]);
        return aVar;
    }
}
