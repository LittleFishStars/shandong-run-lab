package com.kwad.sdk.commercial;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.WorkerThread;
import androidx.camera.video.AudioStats;
import com.ali.auth.third.login.LoginConstants;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.czhj.sdk.common.Constants;
import com.kwad.components.offline.api.BuildConfig;
import com.kwad.components.offline.api.core.api.ILoggerReporter;
import com.kwad.sdk.commercial.model.HybridLoadMsg;
import com.kwad.sdk.commercial.model.WebViewCommercialMsg;
import com.kwad.sdk.commercial.model.WebViewLoadMsg;
import com.kwad.sdk.core.network.j;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.service.a.h;
import com.kwad.sdk.utils.ac;
import com.kwad.sdk.utils.bi;
import com.kwad.sdk.utils.bz;
import com.kwad.sdk.utils.i;
import com.kwai.adclient.kscommerciallogger.model.BusinessType;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class c {
    private static final AtomicBoolean aJA = new AtomicBoolean();
    private static final AtomicBoolean aJB = new AtomicBoolean();
    private static boolean aJC = false;
    private static volatile boolean aJD = false;
    private static List<d> aJE = null;
    private static a aJF = null;
    private static Map<String, com.kwad.sdk.commercial.c.c> aJG = null;
    private static Map<String, com.kwad.sdk.commercial.a> aJH = null;
    private static float aJu = -1.0f;
    private static float aJv = -1.0f;
    private static float aJw = -1.0f;
    private static float aJx = -1.0f;
    private static float aJy = -1.0f;
    private static float aJz = -1.0f;

    public interface a {
        @WorkerThread
        boolean GX();

        @WorkerThread
        boolean GY();

        @WorkerThread
        JSONObject GZ();

        @WorkerThread
        JSONObject Ha();

        String Hb();

        @WorkerThread
        void j(String str, String str2, boolean z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void Ii() {
        try {
            aJG = new HashMap();
            JSONObject jSONObjectGZ = aJF.GZ();
            if (jSONObjectGZ == null) {
                return;
            }
            Iterator<String> itKeys = jSONObjectGZ.keys();
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                JSONObject jSONObjectOptJSONObject = jSONObjectGZ.optJSONObject(next);
                if (jSONObjectOptJSONObject != null) {
                    a(next, jSONObjectOptJSONObject.optJSONArray("ratio"));
                    b(next, jSONObjectOptJSONObject.optJSONArray("ratioApmRL"));
                }
            }
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void Ij() {
        try {
            aJH = new HashMap();
            JSONObject jSONObjectHa = aJF.Ha();
            if (jSONObjectHa == null) {
                return;
            }
            Iterator<String> itKeys = jSONObjectHa.keys();
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                JSONObject jSONObjectOptJSONObject = jSONObjectHa.optJSONObject(next);
                if (jSONObjectOptJSONObject != null) {
                    com.kwad.sdk.commercial.a aVar = new com.kwad.sdk.commercial.a();
                    aVar.parseJson(jSONObjectOptJSONObject);
                    aJH.put(next, aVar);
                }
            }
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static synchronized void a(final a aVar, final boolean z) {
        if (aJC) {
            return;
        }
        aJC = true;
        aJF = aVar;
        i.execute(new bi() { // from class: com.kwad.sdk.commercial.c.1
            @Override // com.kwad.sdk.utils.bi
            public final void doTask() {
                try {
                    c.b(aVar, z);
                    c.Ii();
                    c.Ij();
                    c.aJA.set(true);
                    c.pg();
                } catch (Throwable th) {
                    c.aJB.set(true);
                    ServiceProvider.reportSdkCaughtException(th);
                }
            }
        });
    }

    private static void b(String str, JSONArray jSONArray) {
        if (jSONArray != null) {
            try {
                if (jSONArray.length() == 0) {
                    return;
                }
                for (int i = 0; i < jSONArray.length(); i++) {
                    Object obj = jSONArray.get(i);
                    if (obj instanceof String) {
                        com.kwad.sdk.commercial.c.c cVar = new com.kwad.sdk.commercial.c.c();
                        String strA = a(cVar, (String) obj);
                        com.kwad.sdk.commercial.c.c cVar2 = aJG.get(strA);
                        if (cVar2 != null) {
                            cVar2.aKn = true;
                            cVar2.aKj = Double.parseDouble(str);
                        } else {
                            cVar.aKn = true;
                            cVar.aKj = Double.parseDouble(str);
                            aJG.put(strA, cVar);
                        }
                    }
                }
            } catch (Throwable th) {
                ServiceProvider.reportSdkCaughtException(th);
            }
        }
    }

    public static synchronized void d(d dVar) {
        try {
            if (com.kwad.framework.a.a.pe.booleanValue()) {
                if (dVar.category.equals(ILoggerReporter.Category.ERROR_LOG)) {
                    com.kwad.sdk.core.d.c.e("KCLogReporter", "reportItem: " + dVar);
                } else {
                    com.kwad.sdk.core.d.c.d("KCLogReporter", "reportItem: " + dVar);
                }
            }
            if (aJA.get()) {
                b(dVar);
            } else {
                if (!aJB.get()) {
                    c(dVar);
                }
            }
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void e(boolean z, com.kwad.sdk.commercial.c.a aVar) {
        try {
            d(d.In().m1062do(ILoggerReporter.Category.APM_LOG).g(0.01d).Q(z ? "ad_sdk_reward_callback_load" : "ad_sdk_fullscreen_callback_load", "callback_type").b(z ? BusinessType.AD_REWARD : BusinessType.AD_FULLSCREEN).A(aVar).a(com.kwai.adclient.kscommerciallogger.model.a.buA));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void f(com.kwad.sdk.commercial.c.a aVar) {
        try {
            d(d.In().m1062do(ILoggerReporter.Category.APM_LOG).g(0.01d).Q("ad_sdk_reward_check_result", "check_type").b(BusinessType.AD_REWARD).A(aVar).a(new com.kwai.adclient.kscommerciallogger.model.b("RESULT_CHECK_REWARD")));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void g(com.kwad.sdk.commercial.c.a aVar) {
        try {
            d(d.In().m1062do(ILoggerReporter.Category.APM_LOG).g(0.5d).Q("ad_sdk_webview_track", Constants.AD_SCENE_ID).b(BusinessType.AD_WEBVIEW).A(aVar).a(com.kwai.adclient.kscommerciallogger.model.a.buA));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void h(com.kwad.sdk.commercial.c.a aVar) {
        try {
            d(d.In().m1062do(ILoggerReporter.Category.ERROR_LOG).g(0.01d).Q("ad_sdk_reward_performance", MediationConstant.BAIDU_REWARD_TYPE).b(BusinessType.AD_REWARD).A(aVar).a(com.kwai.adclient.kscommerciallogger.model.d.bvc));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void i(com.kwad.sdk.commercial.c.a aVar) {
        try {
            d(d.In().m1062do(ILoggerReporter.Category.APM_LOG).g(0.01d).Q("ad_sdk_reward_performance", "page_status").b(BusinessType.AD_REWARD).A(aVar).a(com.kwai.adclient.kscommerciallogger.model.d.bvc));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void j(final com.kwad.sdk.commercial.c.a aVar) {
        if (((h) ServiceProvider.get(h.class)).Gk()) {
            i.schedule(new bi() { // from class: com.kwad.sdk.commercial.c.4
                @Override // com.kwad.sdk.utils.bi
                public final void doTask() {
                    c.d(d.In().m1062do(ILoggerReporter.Category.APM_LOG).g(0.1d).Q("ad_sdk_splash_load", "status").b(BusinessType.AD_SPLASH).A(aVar).a(com.kwai.adclient.kscommerciallogger.model.a.buA));
                }
            }, 10L, TimeUnit.SECONDS);
            return;
        }
        try {
            d(d.In().m1062do(ILoggerReporter.Category.APM_LOG).g(0.1d).Q("ad_sdk_splash_load", "status").b(BusinessType.AD_SPLASH).A(aVar).a(com.kwai.adclient.kscommerciallogger.model.a.buA));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void k(final com.kwad.sdk.commercial.c.a aVar) {
        if (((h) ServiceProvider.get(h.class)).Gk()) {
            i.schedule(new bi() { // from class: com.kwad.sdk.commercial.c.5
                @Override // com.kwad.sdk.utils.bi
                public final void doTask() {
                    c.d(d.In().m1062do(ILoggerReporter.Category.APM_LOG).g(0.1d).Q("ad_sdk_splash_preload", "status").b(BusinessType.AD_SPLASH).A(aVar).a(com.kwai.adclient.kscommerciallogger.model.a.buA));
                }
            }, 10L, TimeUnit.SECONDS);
            return;
        }
        try {
            d(d.In().m1062do(ILoggerReporter.Category.APM_LOG).g(0.1d).Q("ad_sdk_splash_preload", "status").b(BusinessType.AD_SPLASH).A(aVar).a(com.kwai.adclient.kscommerciallogger.model.a.buA));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void l(final com.kwad.sdk.commercial.c.a aVar) {
        if (((h) ServiceProvider.get(h.class)).Gk()) {
            i.schedule(new bi() { // from class: com.kwad.sdk.commercial.c.7
                @Override // com.kwad.sdk.utils.bi
                public final void doTask() {
                    c.d(d.In().m1062do(ILoggerReporter.Category.APM_LOG).g(0.01d).Q("ad_sdk_splash_cache", "cache").b(BusinessType.AD_SPLASH).A(aVar).a(com.kwai.adclient.kscommerciallogger.model.a.buz));
                }
            }, 10L, TimeUnit.SECONDS);
            return;
        }
        try {
            d(d.In().m1062do(ILoggerReporter.Category.APM_LOG).g(0.01d).Q("ad_sdk_splash_cache", "cache").b(BusinessType.AD_SPLASH).A(aVar).a(com.kwai.adclient.kscommerciallogger.model.a.buz));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void m(final com.kwad.sdk.commercial.c.a aVar) {
        if (((h) ServiceProvider.get(h.class)).Gk()) {
            i.schedule(new bi() { // from class: com.kwad.sdk.commercial.c.8
                @Override // com.kwad.sdk.utils.bi
                public final void doTask() {
                    c.d(d.In().m1062do(ILoggerReporter.Category.APM_LOG).g(0.01d).Q("ad_sdk_splash_show", "status").b(BusinessType.AD_SPLASH).A(aVar).a(com.kwai.adclient.kscommerciallogger.model.a.buA));
                }
            }, 10L, TimeUnit.SECONDS);
            return;
        }
        try {
            d(d.In().m1062do(ILoggerReporter.Category.APM_LOG).g(0.01d).Q("ad_sdk_splash_show", "status").b(BusinessType.AD_SPLASH).A(aVar).a(com.kwai.adclient.kscommerciallogger.model.a.buA));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void n(final com.kwad.sdk.commercial.c.a aVar) {
        if (((h) ServiceProvider.get(h.class)).Gk()) {
            i.schedule(new bi() { // from class: com.kwad.sdk.commercial.c.9
                @Override // com.kwad.sdk.utils.bi
                public final void doTask() {
                    c.d(d.In().m1062do(ILoggerReporter.Category.ERROR_LOG).g(1.0d).Q("ad_sdk_splash_monitor_view_error", "status").b(BusinessType.AD_SPLASH).A(aVar).a(com.kwai.adclient.kscommerciallogger.model.a.buA));
                }
            }, 10L, TimeUnit.SECONDS);
            return;
        }
        try {
            d(d.In().m1062do(ILoggerReporter.Category.ERROR_LOG).g(1.0d).Q("ad_sdk_splash_monitor_view_error", "status").b(BusinessType.AD_SPLASH).A(aVar).a(com.kwai.adclient.kscommerciallogger.model.a.buA));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void o(final com.kwad.sdk.commercial.c.a aVar) {
        if (((h) ServiceProvider.get(h.class)).Gk()) {
            i.schedule(new bi() { // from class: com.kwad.sdk.commercial.c.10
                @Override // com.kwad.sdk.utils.bi
                public final void doTask() {
                    c.d(d.In().m1062do(ILoggerReporter.Category.ERROR_LOG).g(1.0d).Q("ad_sdk_splash_monitor_template_data_error", "status").b(BusinessType.AD_SPLASH).A(aVar).a(com.kwai.adclient.kscommerciallogger.model.a.buA));
                }
            }, 10L, TimeUnit.SECONDS);
            return;
        }
        try {
            d(d.In().m1062do(ILoggerReporter.Category.ERROR_LOG).g(1.0d).Q("ad_sdk_splash_monitor_template_data_error", "status").b(BusinessType.AD_SPLASH).A(aVar).a(com.kwai.adclient.kscommerciallogger.model.a.buA));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void p(final com.kwad.sdk.commercial.c.a aVar) {
        if (((h) ServiceProvider.get(h.class)).Gk()) {
            i.schedule(new bi() { // from class: com.kwad.sdk.commercial.c.2
                @Override // com.kwad.sdk.utils.bi
                public final void doTask() {
                    c.d(d.In().m1062do(ILoggerReporter.Category.ERROR_LOG).g(1.0d).Q("ad_sdk_splash_monitor_errorcode_error", "status").b(BusinessType.AD_SPLASH).A(aVar).a(com.kwai.adclient.kscommerciallogger.model.a.buA));
                }
            }, 10L, TimeUnit.SECONDS);
            return;
        }
        try {
            d(d.In().m1062do(ILoggerReporter.Category.ERROR_LOG).g(1.0d).Q("ad_sdk_splash_monitor_errorcode_error", "status").b(BusinessType.AD_SPLASH).A(aVar).a(com.kwai.adclient.kscommerciallogger.model.a.buA));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static synchronized void pg() {
        List<d> list = aJE;
        if (list == null) {
            return;
        }
        Iterator<d> it = list.iterator();
        while (it.hasNext()) {
            b(it.next());
        }
        aJE.clear();
        aJE = null;
    }

    public static void q(com.kwad.sdk.commercial.c.a aVar) {
        try {
            d(d.In().m1062do(ILoggerReporter.Category.APM_LOG).g(0.01d).Q("ad_sdk_block_info", "block").a(com.kwai.adclient.kscommerciallogger.model.b.buT).A(aVar));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void r(com.kwad.sdk.commercial.c.a aVar) {
        try {
            d(d.In().m1062do(ILoggerReporter.Category.APM_LOG).g(0.01d).Q("ad_image_load_perf", "image_perf").A(aVar).a(com.kwai.adclient.kscommerciallogger.model.d.bvc));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void s(com.kwad.sdk.commercial.c.a aVar) {
        try {
            d(d.In().m1062do(ILoggerReporter.Category.APM_LOG).g(1.0d).Q("ad_thread_monitor", "thread_perf").A(aVar).a(com.kwai.adclient.kscommerciallogger.model.d.bvc));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void t(com.kwad.sdk.commercial.c.a aVar) {
        try {
            d(d.In().m1062do(ILoggerReporter.Category.APM_LOG).g(0.001d).Q("ad_video_load_perf", "video_load_perf").dp("ad_video_load_perf").A(aVar).a(com.kwai.adclient.kscommerciallogger.model.d.bvc));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void u(com.kwad.sdk.commercial.c.a aVar) {
        try {
            d(d.In().m1062do(ILoggerReporter.Category.APM_LOG).g(0.001d).Q("ad_video_load_failed", "video_load_failed").dp("ad_video_load_failed").A(aVar).a(com.kwai.adclient.kscommerciallogger.model.d.bvc));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void v(com.kwad.sdk.commercial.c.a aVar) {
        try {
            d(d.In().m1062do(ILoggerReporter.Category.APM_LOG).g(1.0d).Q("ad_sdk_aggregation_monitor", "ranger").dp("ad_sdk_aggregation_monitor").A(aVar).a(com.kwai.adclient.kscommerciallogger.model.d.bvc));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void w(com.kwad.sdk.commercial.c.a aVar) {
        try {
            d(d.In().m1062do(ILoggerReporter.Category.APM_LOG).g(0.01d).Q("ad_wayne_player_vse_monitor", "status").A(aVar).a(com.kwai.adclient.kscommerciallogger.model.d.bvc));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void x(com.kwad.sdk.commercial.c.a aVar) {
        try {
            d(d.In().m1062do(ILoggerReporter.Category.APM_LOG).g(0.01d).Q("ad_sdk_installer_info", "status").A(aVar).a(com.kwai.adclient.kscommerciallogger.model.d.bvc));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void y(com.kwad.sdk.commercial.c.a aVar) {
        try {
            d(d.In().m1062do(ILoggerReporter.Category.APM_LOG).g(0.01d).Q("ad_sdk_uaid_data_performance", "status").A(aVar).a(com.kwai.adclient.kscommerciallogger.model.a.buA));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void z(com.kwad.sdk.commercial.c.a aVar) {
        try {
            d(d.In().m1062do(ILoggerReporter.Category.APM_LOG).g(0.01d).Q("ad_sdk_bid_token", "status").A(aVar).a(com.kwai.adclient.kscommerciallogger.model.d.bvc));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    private static void c(d dVar) {
        if (aJE == null) {
            aJE = new CopyOnWriteArrayList();
        }
        h hVar = (h) ServiceProvider.get(h.class);
        if (aJE.size() < (hVar != null ? hVar.Gm() : 500)) {
            aJE.add(dVar);
        }
    }

    private static void a(String str, JSONArray jSONArray) {
        if (jSONArray != null) {
            try {
                if (jSONArray.length() == 0) {
                    return;
                }
                for (int i = 0; i < jSONArray.length(); i++) {
                    Object obj = jSONArray.get(i);
                    if (obj instanceof String) {
                        com.kwad.sdk.commercial.c.c cVar = new com.kwad.sdk.commercial.c.c();
                        String strA = a(cVar, (String) obj);
                        com.kwad.sdk.commercial.c.c cVar2 = aJG.get(strA);
                        if (cVar2 != null) {
                            cVar2.aKm = true;
                            cVar2.aJV = Double.parseDouble(str);
                        } else {
                            cVar.aKm = true;
                            cVar.aJV = Double.parseDouble(str);
                            aJG.put(strA, cVar);
                        }
                    }
                }
            } catch (JSONException e) {
                ServiceProvider.reportSdkCaughtException(e);
            }
        }
    }

    public static void c(boolean z, com.kwad.sdk.commercial.c.a aVar) {
        try {
            d(d.In().m1062do(ILoggerReporter.Category.APM_LOG).g(0.01d).Q(z ? "ad_sdk_reward_page_show" : "ad_sdk_fullscreen_page_show", "page_status").b(z ? BusinessType.AD_REWARD : BusinessType.AD_FULLSCREEN).A(aVar).a(com.kwai.adclient.kscommerciallogger.model.a.buq));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void f(boolean z, com.kwad.sdk.commercial.c.a aVar) {
        try {
            d(d.In().m1062do(ILoggerReporter.Category.ERROR_LOG).g(1.0d).Q(z ? "ad_sdk_reward_play_error" : "ad_sdk_fullscreen_play_error", MediationConstant.BAIDU_REWARD_TYPE).b(z ? BusinessType.AD_REWARD : BusinessType.AD_FULLSCREEN).A(aVar).a(com.kwai.adclient.kscommerciallogger.model.b.buT));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void g(final boolean z, final com.kwad.sdk.commercial.c.a aVar) {
        if (((h) ServiceProvider.get(h.class)).Gk()) {
            i.schedule(new bi() { // from class: com.kwad.sdk.commercial.c.6
                @Override // com.kwad.sdk.utils.bi
                public final void doTask() {
                    c.d(d.In().m1062do(ILoggerReporter.Category.APM_LOG).g(z ? 1.0d : 0.01d).Q("ad_sdk_splash_single_cache", "status").b(BusinessType.AD_SPLASH).A(aVar).a(com.kwai.adclient.kscommerciallogger.model.a.buz));
                }
            }, 10L, TimeUnit.SECONDS);
            return;
        }
        try {
            d(d.In().m1062do(ILoggerReporter.Category.APM_LOG).g(z ? 1.0d : 0.01d).Q("ad_sdk_splash_single_cache", "status").b(BusinessType.AD_SPLASH).A(aVar).a(com.kwai.adclient.kscommerciallogger.model.a.buz));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void h(JSONObject jSONObject) {
        try {
            int iOptInt = jSONObject.optInt("load_status");
            d(d.In().m1062do((iOptInt == 3 || iOptInt == 4 || iOptInt == 7) ? ILoggerReporter.Category.ERROR_LOG : ILoggerReporter.Category.APM_LOG).g(1.0d).h(0.1d).i(0.001d).Q("ad_sdk_dynamic_update", "load_status").a(com.kwai.adclient.kscommerciallogger.model.a.buA).i(jSONObject));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void e(com.kwad.sdk.commercial.c.a aVar, boolean z) {
        try {
            d(d.In().m1062do(ILoggerReporter.Category.ERROR_LOG).g(z ? 1.0d : 1.0E-4d).Q("ad_sdk_disk_monitor", MediationConstant.BAIDU_REWARD_TYPE).A(aVar).a(com.kwai.adclient.kscommerciallogger.model.b.buV));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void d(boolean z, com.kwad.sdk.commercial.c.a aVar) {
        try {
            d(d.In().m1062do(ILoggerReporter.Category.APM_LOG).g(0.01d).Q(z ? "ad_sdk_reward_callback_interaction" : "ad_sdk_fullscreen_callback_interaction", "callback_type").b(z ? BusinessType.AD_REWARD : BusinessType.AD_FULLSCREEN).A(aVar).a(com.kwai.adclient.kscommerciallogger.model.a.buA));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    private static void b(d dVar) {
        com.kwai.adclient.kscommerciallogger.model.c.a aVarYp;
        if (aJD) {
            com.kwad.sdk.commercial.c.b bVarA = a(dVar);
            if (aJu == -1.0f) {
                aJu = new Random().nextFloat();
            }
            if (aJx == -1.0f) {
                aJx = new Random().nextFloat();
            }
            if (aJF.GY() || !a(bVarA)) {
                try {
                    if (ILoggerReporter.Category.ERROR_LOG.equals(a(dVar.category, dVar))) {
                        aVarYp = com.kwai.adclient.kscommerciallogger.model.c.a.Yo();
                    } else {
                        aVarYp = com.kwai.adclient.kscommerciallogger.model.c.a.Yp();
                    }
                    com.kwai.adclient.kscommerciallogger.a.Yf().a(aVarYp.c(dVar.aJP).b(dVar.aJQ).iK(TextUtils.isEmpty(dVar.tag) ? dVar.eventId : dVar.tag).b(dVar.aJR).iL(dVar.eventId).B(a(dVar.msg, bVarA)).Yq());
                } catch (Throwable th) {
                    ServiceProvider.reportSdkCaughtException(th);
                }
            }
        }
    }

    public static void f(com.kwad.sdk.commercial.c.a aVar, boolean z) {
        try {
            d(d.In().m1062do(ILoggerReporter.Category.APM_LOG).g(0.01d).Q("ad_media_configuration_switch", "device_os_id").A(aVar).a(com.kwai.adclient.kscommerciallogger.model.d.bvc));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    private static String a(com.kwad.sdk.commercial.c.b bVar, String str) {
        try {
            int iLastIndexOf = str.lastIndexOf(95);
            int length = str.length() - 1;
            if (str.charAt(length) >= '0' && str.charAt(length) <= '9' && iLastIndexOf != -1) {
                bVar.aKk = str.substring(iLastIndexOf + 1);
                return str.substring(0, iLastIndexOf);
            }
        } catch (Throwable unused) {
        }
        return str;
    }

    public static void d(com.kwad.sdk.commercial.c.a aVar, boolean z) {
        try {
            d(d.In().m1062do(z ? ILoggerReporter.Category.ERROR_LOG : ILoggerReporter.Category.APM_LOG).g(z ? 1.0d : 0.001d).Q("ad_sdk_resource_warmup", "warm_up").b(BusinessType.OTHER).A(aVar).a(com.kwai.adclient.kscommerciallogger.model.a.buy));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    @NonNull
    private static com.kwad.sdk.commercial.c.b a(d dVar) {
        double d;
        double d2;
        String str;
        com.kwad.sdk.commercial.c.c cVar;
        com.kwad.sdk.commercial.c.c cVar2;
        com.kwad.sdk.commercial.c.b bVar = new com.kwad.sdk.commercial.c.b();
        try {
            Boolean bool = com.kwad.framework.a.a.pe;
            if (bool.booleanValue()) {
                bVar.aJV = dVar.aJN;
            } else {
                bVar.aJV = dVar.aJM;
            }
            bVar.aKj = dVar.aJO;
            if (!aJG.containsKey(dVar.eventId) || (cVar2 = aJG.get(dVar.eventId)) == null) {
                d = -1.0d;
                d2 = -1.0d;
            } else {
                d = cVar2.aKm ? cVar2.aJV : -1.0d;
                d2 = cVar2.aKn ? cVar2.aKj : -1.0d;
                if (!TextUtils.isEmpty(cVar2.aKk)) {
                    bVar.aKk = cVar2.aKk;
                }
            }
            if (TextUtils.isEmpty(dVar.primaryKey) && bool.booleanValue()) {
                throw new Exception("primaryKey为空");
            }
            String str2 = dVar.eventId;
            if (!TextUtils.isEmpty(dVar.primaryKey)) {
                if (dVar.msg.has(dVar.primaryKey)) {
                    str = str2 + LoginConstants.UNDER_LINE + dVar.msg.opt(dVar.primaryKey);
                } else {
                    str = str2 + LoginConstants.UNDER_LINE + dVar.primaryKey;
                }
                if (aJG.containsKey(str) && (cVar = aJG.get(str)) != null) {
                    if (cVar.aKm) {
                        d = cVar.aJV;
                    }
                    if (cVar.aKn) {
                        d2 = cVar.aKj;
                    }
                    if (!TextUtils.isEmpty(cVar.aKk)) {
                        bVar.aKk = cVar.aKk;
                    }
                }
            }
            Map<String, com.kwad.sdk.commercial.a> map = aJH;
            if (map != null && map.containsKey(dVar.eventId)) {
                com.kwad.sdk.core.d.c.d("KCLRefineReport", "命中精细化采样配置 " + dVar.eventId);
                com.kwad.sdk.commercial.a aVar = aJH.get(dVar.eventId);
                if (aVar != null && aVar.aJs > AudioStats.AUDIO_AMPLITUDE_NONE) {
                    String str3 = aVar.minVersion;
                    bVar.aKk = str3;
                    if (bz.aE(BuildConfig.VERSION_NAME, str3)) {
                        d = aVar.aJs;
                    }
                    com.kwad.sdk.core.d.c.d("KCLRefineReport", "默认采样率： " + aVar.aJs + "  minVersion: " + aVar.minVersion);
                    List<f> list = aVar.aJt;
                    if (list == null) {
                        d2 = -1.0d;
                        break;
                    }
                    Iterator<f> it = list.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            d2 = -1.0d;
                            break;
                        }
                        f next = it.next();
                        if (next != null && next.e(dVar)) {
                            d = next.aJV;
                            d2 = next.aJW;
                            bVar.aKk = next.minVersion;
                            bVar.aKl = bz.aE(next.maxVersion, "0") ? next.maxVersion : null;
                            bVar.aJX = next.aJX;
                            com.kwad.sdk.core.d.c.d("KCLRefineReport", "命中精细化采样规则: for msg " + dVar.msg + " minVersion: " + next.minVersion + " maxVersion: " + next.maxVersion + " deviceMode: " + next.aJX + " ratio: " + next.aJV + " convert: " + next.aJW);
                            break;
                        }
                    }
                }
            }
            if (d != -1.0d) {
                bVar.aJV = d;
            }
            if (d2 != -1.0d) {
                bVar.aKj = d2;
            } else {
                bVar.aKj = ((h) ServiceProvider.get(h.class)).FU();
            }
            dVar.aJM = bVar.aJV;
            dVar.aJO = bVar.aKj;
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
        return bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(final a aVar, boolean z) {
        boolean zGX = aVar.GX();
        aJD = zGX;
        if (zGX) {
            JSONObject jSONObject = new JSONObject();
            ac.putValue(jSONObject, "publish_type", 0);
            ac.putValue(jSONObject, "plug_sdk", z ? 1 : 0);
            com.kwai.adclient.kscommerciallogger.a aVarYf = com.kwai.adclient.kscommerciallogger.a.Yf();
            b bVar = new b();
            com.kwai.adclient.kscommerciallogger.a.b bVar2 = new com.kwai.adclient.kscommerciallogger.a.b() { // from class: com.kwad.sdk.commercial.c.3
                private void P(String str, String str2) {
                    aVar.j(str, str2, false);
                }

                @Override // com.kwai.adclient.kscommerciallogger.a.b
                public final void O(@NonNull String str, @NonNull String str2) {
                    P(str, str2);
                }
            };
            Boolean bool = com.kwad.framework.a.a.pe;
            aVarYf.a(bVar, bVar2, jSONObject, bool.booleanValue(), bool.booleanValue());
            com.kwad.sdk.commercial.g.a.Iv().dC(aVar.Hb());
        }
    }

    public static void b(boolean z, com.kwad.sdk.commercial.c.a aVar) {
        try {
            d(d.In().m1062do(ILoggerReporter.Category.ERROR_LOG).g(1.0d).Q(z ? "ad_sdk_reward_download_error" : "ad_sdk_fullscreen_download_error", "download_type").b(z ? BusinessType.AD_REWARD : BusinessType.AD_FULLSCREEN).A(aVar).a(com.kwai.adclient.kscommerciallogger.model.b.buN));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void b(String str, com.kwad.sdk.commercial.c.a aVar) {
        try {
            d(d.In().m1062do(ILoggerReporter.Category.ERROR_LOG).g(1.0d).Q(str, "status").b(BusinessType.OTHER).A(aVar).a(com.kwai.adclient.kscommerciallogger.model.b.buV));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void b(String str, HybridLoadMsg hybridLoadMsg) {
        try {
            d(d.In().m1062do(str).g(ILoggerReporter.Category.ERROR_LOG.equals(str) ? 1.0d : 0.001d).Q("union_web_cache_load_event", "state").b(BusinessType.WEB_CACHE).A(hybridLoadMsg).a(com.kwai.adclient.kscommerciallogger.model.d.bvc));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void b(j jVar) {
        try {
            d(d.In().m1062do(ILoggerReporter.Category.APM_LOG).g(1.0E-5d).Q("ad_perf_monitor_net_success", "network_monitor").A(jVar).a(com.kwai.adclient.kscommerciallogger.model.d.bvc));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    private static boolean a(com.kwad.sdk.commercial.c.b bVar) {
        if (!bz.aE(BuildConfig.VERSION_NAME, bVar.aKk)) {
            return false;
        }
        if (aJw == -1.0f) {
            aJw = new Random().nextFloat();
        }
        if (aJz == -1.0f) {
            aJz = new Random().nextFloat();
        }
        aJy = new Random().nextFloat();
        float fNextFloat = new Random().nextFloat();
        aJv = fNextFloat;
        if (bVar.aJX != 0) {
            aJu = aJw;
            aJx = aJy;
        } else {
            aJu = fNextFloat;
            aJx = aJy;
        }
        com.kwad.sdk.core.d.c.d("KCLRefineReport", " 随机数采样率： " + aJv + " 设备随机采样率：" + aJw + " 随机离线转实时采样率： " + aJy + " 设备随机离线转实时采样率： " + aJz + " 当前采用的采样率： " + aJu + " 采用离线转实时采样率： " + aJx + " 客户端埋点采样率： " + bVar.aJV);
        return ((double) aJu) > bVar.aJV;
    }

    public static void b(com.kwad.sdk.core.network.i iVar) {
        try {
            d(d.In().m1062do(ILoggerReporter.Category.APM_LOG).g(0.1d).Q("ad_perf_monitor_net_error", "network_monitor").A(iVar).a(com.kwai.adclient.kscommerciallogger.model.d.bvc));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void b(@NonNull com.kwad.sdk.utils.b.a aVar) {
        try {
            d(d.In().m1062do(ILoggerReporter.Category.APM_LOG).g(0.01d).Q("ad_union_kv_fail_rate", "kv").A(aVar).a(com.kwai.adclient.kscommerciallogger.model.d.bvc));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    private static String a(String str, d dVar) {
        return (!str.equals(ILoggerReporter.Category.APM_LOG) || ((double) aJx) >= dVar.aJO) ? str : ILoggerReporter.Category.ERROR_LOG;
    }

    public static void a(String str, com.kwai.adclient.kscommerciallogger.model.d dVar, com.kwad.sdk.commercial.c.a aVar) {
        try {
            d(d.In().m1062do(str).g(0.001d).Q(ILoggerReporter.Category.ERROR_LOG.equals(str) ? "ad_sdk_init_error_performance" : "ad_sdk_init_performance", "init_status").b(BusinessType.AD_SDK_INIT).A(aVar).a(dVar));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void b(String str, com.kwai.adclient.kscommerciallogger.model.d dVar, com.kwad.sdk.commercial.c.a aVar) {
        try {
            d(d.In().m1062do(str).g(0.001d).Q("ad_sdk_local_warmup", "warm_up").b(BusinessType.OTHER).A(aVar).a(dVar));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void a(boolean z, com.kwad.sdk.commercial.c.a aVar, com.kwai.adclient.kscommerciallogger.model.d dVar) {
        try {
            d(d.In().m1062do(ILoggerReporter.Category.APM_LOG).g(0.01d).Q(z ? "ad_sdk_reward_load" : "ad_sdk_fullscreen_load", "load_status").b(z ? BusinessType.AD_REWARD : BusinessType.AD_FULLSCREEN).A(aVar).a(dVar));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void b(boolean z, com.kwad.sdk.commercial.c.a aVar, com.kwai.adclient.kscommerciallogger.model.d dVar) {
        try {
            d(d.In().m1062do(z ? ILoggerReporter.Category.ERROR_LOG : ILoggerReporter.Category.APM_LOG).g(z ? 1.0d : 0.01d).Q(z ? "ad_sdk_innerec_error" : "ad_sdk_innerec_performance", "status").b(BusinessType.OTHER).A(aVar).a(dVar));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void a(boolean z, String str, com.kwad.sdk.commercial.c.a aVar) {
        try {
            d(d.In().m1062do(ILoggerReporter.Category.ERROR_LOG).g(1.0d).Q(str, MediationConstant.BAIDU_REWARD_TYPE).b(z ? BusinessType.AD_REWARD : BusinessType.AD_FULLSCREEN).A(aVar).a(com.kwai.adclient.kscommerciallogger.model.b.buT));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void a(String str, HybridLoadMsg hybridLoadMsg) {
        try {
            d(d.In().m1062do(str).g(1.0E-4d).Q("union_web_cache_download_event", "state").b(BusinessType.WEB_CACHE).A(hybridLoadMsg).a(com.kwai.adclient.kscommerciallogger.model.d.bvc));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void a(String str, WebViewLoadMsg webViewLoadMsg) {
        try {
            d(d.In().m1062do(str).g(1.0d).Q("union_webview_load_event", "state").A(webViewLoadMsg).a(com.kwai.adclient.kscommerciallogger.model.d.bvc));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void a(String str, WebViewCommercialMsg webViewCommercialMsg) {
        try {
            double d = webViewCommercialMsg.rate;
            if (d >= AudioStats.AUDIO_AMPLITUDE_NONE) {
                ac.putValue(webViewCommercialMsg.msg, "ratio", d);
            }
            if (TextUtils.isEmpty(webViewCommercialMsg.primaryKey)) {
                webViewCommercialMsg.primaryKey = "web_log";
            }
            d(d.In().m1062do(str).g(webViewCommercialMsg.rate).Q(webViewCommercialMsg.eventId, webViewCommercialMsg.primaryKey).b(webViewCommercialMsg.biz).a(webViewCommercialMsg.subBiz).i(webViewCommercialMsg.msg).a(com.kwai.adclient.kscommerciallogger.model.d.bvc));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    private static JSONObject a(JSONObject jSONObject, com.kwad.sdk.commercial.c.b bVar) {
        try {
            ac.putValue(jSONObject, "ratio", bVar.aJV);
            double d = bVar.aJV;
            if (d > AudioStats.AUDIO_AMPLITUDE_NONE) {
                ac.putValue(jSONObject, "ratio_count", a(1.0d, d, 0));
            }
            ac.putValue(jSONObject, "debug_mode", com.kwad.framework.a.a.pe.booleanValue() ? 1 : 0);
            ac.putValue(jSONObject, "convert_ratio", bVar.aKj);
            double d2 = bVar.aKj;
            if (d2 > AudioStats.AUDIO_AMPLITUDE_NONE) {
                ac.putValue(jSONObject, "convert_ratio_count", a(1.0d, d2, 0));
            }
            return jSONObject;
        } catch (Exception e) {
            com.kwad.sdk.core.d.c.printStackTrace(e);
            return jSONObject;
        }
    }

    private static double a(double d, double d2, int i) {
        return new BigDecimal(Double.toString(1.0d)).divide(new BigDecimal(Double.toString(d2)), 0, RoundingMode.HALF_UP).doubleValue();
    }
}
