package com.byazt.sx;

import android.annotation.SuppressLint;
import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.ComponentCallbacks;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.util.SparseArray;
import androidx.annotation.NonNull;
import com.byazt.eu.n;
import com.byazt.ng.a;
import com.byazt.nr.m;
import com.byazt.omf.x;
import com.byazt.vx.eo;
import com.byazt.vx.gr;
import com.byazt.vx.nu;
import com.byazt.vx.yv;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 928, 54})
public class ve {
    public static long sp = 0;
    public static long tt = 0;
    public static volatile boolean uj = false;
    public static boolean ve = false;
    public static long x;
    public static AtomicBoolean n = new AtomicBoolean(false);
    public static Runnable c = new Runnable() { // from class: com.byazt.sx.ve.3
        @Override // java.lang.Runnable
        public void run() {
            com.byazt.eu.tt.c("TMe", "--==-- queueSize: " + ((ThreadPoolExecutor) n.a()).getQueue().size());
            n.c(ve.c, 5000L);
        }
    };

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ComponentCallbacks f29037a = new ComponentCallbacks() { // from class: com.byazt.sx.ve.4
        @Override // android.content.ComponentCallbacks
        public void onConfigurationChanged(@NonNull Configuration configuration) {
        }

        @Override // android.content.ComponentCallbacks
        public void onLowMemory() {
            com.byazt.hk.c.c().tt();
        }
    };

    @com.byazt.zqa.c(c = {0, 1, 928, 24})
    public static class c extends BroadcastReceiver {
        private c() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent == null || x.m().d()) {
                return;
            }
            com.byazt.eu.tt.c(MediationConstant.TAG, "--==-- event multi receiver");
            if (intent.getIntExtra("b_msg_id", -1) == 1) {
                try {
                    if (gr.c(context)) {
                        com.byazt.ng.ve.ve();
                    } else {
                        com.byazt.eu.tt.c(MediationConstant.TAG, "--==-- event multi receiver not in main proc");
                    }
                } catch (Throwable th) {
                    m.c(th);
                }
            }
        }
    }

    public interface tt {
        public static final String c = eo.c() + ".openadsdk.permission.TT_PANGOLIN";
    }

    public static void a() {
        com.byazt.bp.tt.tt().ve(1);
        if (!n.get()) {
            n();
        }
        Context context = com.byazt.bp.tt.getContext();
        if (context == null) {
            return;
        }
        try {
            com.byazt.eu.tt.tt("TNCManager_GroMore", "尝试刷新TNC tryRefreshTNCConfig");
            com.byazt.yp.tt.c().tt().c(context, false);
        } catch (Exception unused) {
        }
    }

    private static void m() {
        com.byazt.eu.tt.c(MediationConstant.TAG, "AppStateListener开始注册");
        com.byazt.aas.c cVarVe = x.m().ve();
        if (cVarVe != null) {
            com.byazt.eu.tt.c(MediationConstant.TAG, "AppStateListener注册成功");
            sp = SystemClock.elapsedRealtime();
            cVarVe.c(new com.byazt.aas.c.tt() { // from class: com.byazt.sx.ve.5
                @Override // com.byazt.aas.c.tt
                public void onAppBackground() {
                    long jElapsedRealtime = SystemClock.elapsedRealtime();
                    long j = com.byazt.xo.c.n() != 2 ? ve.sp > 0 ? jElapsedRealtime - ve.sp : 0L : 0L;
                    a.tt(j);
                    com.byazt.bp.c.t().tt(j);
                    com.byazt.eu.tt.c(MediationConstant.TAG, "--==-- AppStateListener on background: " + j + ", " + com.byazt.xo.c.n());
                    if (jElapsedRealtime - ve.x < 3000) {
                        com.byazt.eu.tt.tt(MediationConstant.TAG, "badkground too frequently ms: " + (jElapsedRealtime - ve.x));
                    } else if (com.byazt.ng.ve.tt()) {
                        long unused = ve.x = jElapsedRealtime;
                        if (gr.c(com.byazt.bp.tt.getContext())) {
                            com.byazt.ng.ve.ve();
                        } else {
                            ve.nu();
                        }
                    }
                }

                @Override // com.byazt.aas.c.tt
                public void onAppExit() {
                }

                @Override // com.byazt.aas.c.tt
                public void onAppForeground() {
                    int iN = com.byazt.xo.c.n();
                    com.byazt.eu.tt.c(MediationConstant.TAG, "--==-- AppStateListener on foreground, ".concat(String.valueOf(iN)));
                    long unused = ve.sp = SystemClock.elapsedRealtime();
                    if (iN != 2) {
                        com.byazt.bg.c.ve();
                    }
                }

                @Override // com.byazt.aas.c.tt
                public void onAppStart() {
                }
            });
        }
        if (com.byazt.bp.c.t().yp()) {
            try {
                com.byazt.bp.tt.getContext().registerReceiver(new c(), new IntentFilter("com.bytedance.msdk.sdkinit.EventMultiFlushReceiver"), tt.c, null);
            } catch (Throwable th) {
                m.c(th);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void my() {
        if (com.byazt.bp.tt.tt().aw()) {
            Map<String, String> mapIc = com.byazt.bp.tt.tt().ic();
            a.c((com.byazt.yl.ve) null, (com.byazt.ll.tt) null, nu.c(), 1);
            a.c(nu.c(mapIc));
        }
    }

    public static void n() {
        Context context;
        if (n.get()) {
            return;
        }
        com.byazt.eu.tt.tt("TNCManager_GroMore", "初始化TNC initTTAdNetTNC：supportTNC：" + com.byazt.bp.tt.tt().sv());
        if (com.byazt.bp.tt.tt().sv() && (context = com.byazt.bp.tt.getContext()) != null) {
            try {
                com.byazt.yp.tt.c().tt().c(context, true, (com.byazt.hw.tt) new com.byazt.yp.c(context));
            } catch (Exception unused) {
            }
            n.set(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void nu() {
        if (com.byazt.bp.tt.getContext() != null) {
            try {
                Intent intent = new Intent();
                intent.setPackage(eo.c());
                intent.setAction("com.bytedance.msdk.sdkinit.EventMultiFlushReceiver");
                intent.putExtra("b_msg_id", 1);
                com.byazt.bp.tt.getContext().sendBroadcast(intent, tt.c);
            } catch (Throwable th) {
                m.c(th);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void rh() {
        if (com.byazt.bp.tt.tt().pf()) {
            my();
        } else {
            new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: com.byazt.sx.ve.6
                @Override // java.lang.Runnable
                public void run() {
                    ve.my();
                }
            }, 2000L);
        }
    }

    public static String uj() {
        try {
            com.byazt.ly.uj ujVarC = com.byazt.px.tt.c().c(MediationConstant.ADN_PANGLE);
            return ujVarC != null ? ujVarC.getNetworkSdkPluginVersion() : "";
        } catch (Throwable unused) {
            return "";
        }
    }

    public static boolean ve() {
        return uj;
    }

    private static void yp() {
        com.byazt.ko.c cVarQp;
        if (!ve || (cVarQp = com.byazt.bp.c.t().qp()) == null) {
            return;
        }
        cVarQp.c();
        com.byazt.bp.c.t().c((com.byazt.ko.c) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void z() {
        Application applicationC = com.byazt.bp.tt.c.c();
        if (applicationC == null) {
            com.byazt.eu.tt.c(MediationConstant.TAG, "lowMemoryListener注册失败, app = null");
            return;
        }
        com.byazt.eu.tt.c(MediationConstant.TAG, "lowMemoryListener注册成功");
        ComponentCallbacks componentCallbacks = f29037a;
        applicationC.unregisterComponentCallbacks(componentCallbacks);
        applicationC.registerComponentCallbacks(componentCallbacks);
    }

    public static boolean tt() {
        return ve;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void ve(Context context, JSONObject jSONObject) {
        com.byazt.ng.ve.c(context, jSONObject);
        com.byazt.ng.ve.c();
    }

    private static void tt(final Context context, final JSONObject jSONObject) {
        com.byazt.eu.tt.uj("TTMediationSDK_SDK_Init", "msdk_init v1.............");
        c(true);
        tt = SystemClock.elapsedRealtime();
        m();
        uj.c(context.getApplicationContext());
        com.byazt.tjo.a.c(jSONObject, "s-prepare");
        c(jSONObject);
        com.byazt.tjo.a.c(jSONObject, "s-local_cfg");
        if (com.byazt.bp.tt.tt().ve()) {
            n.c(new Runnable() { // from class: com.byazt.sx.ve.1
                @Override // java.lang.Runnable
                public void run() {
                    ve.ve(context, jSONObject);
                    com.byazt.tjo.a.c(jSONObject, "s-adlog2");
                    com.byazt.ng.ve.c(com.byazt.bp.tt.getContext());
                }
            });
        } else {
            ve(context, jSONObject);
        }
        uj = true;
        com.byazt.tjo.a.c(jSONObject, "s-adlog");
        com.byazt.bp.tt.tt().c(true, jSONObject, new com.byazt.sc.tt() { // from class: com.byazt.sx.ve.2
            @Override // com.byazt.sc.tt
            public void c() {
                com.byazt.bp.tt.tt().c((com.byazt.sc.tt) null);
                n.uj(new Runnable() { // from class: com.byazt.sx.ve.2.1
                    @Override // java.lang.Runnable
                    public void run() {
                        yv.c(yv.tt() + 1);
                        com.byazt.ng.ve.c(com.byazt.bp.tt.getContext());
                        ve.tt(context, ve.tt);
                        ve.z();
                    }
                });
                ve.rh();
            }
        });
        tt(jSONObject);
    }

    public static long c() {
        return tt;
    }

    private static void c(boolean z) {
        ve = z;
        yp();
    }

    public static void c(@NonNull com.byazt.yf.c cVar, Context context, JSONObject jSONObject) {
        c(context);
        com.byazt.tjo.a.c(jSONObject, "s-init_context");
        c(cVar, jSONObject);
        com.byazt.tjo.a.c(jSONObject, "s-global_info_end");
        tt(context, jSONObject);
    }

    @SuppressLint({"WrongConstant"})
    private static void c(com.byazt.yf.c cVar, JSONObject jSONObject) {
        com.byazt.bp.c.t().c(cVar.yp());
        com.byazt.bp.c.t().c(System.currentTimeMillis());
        com.byazt.tjo.a.c(jSONObject, "s-global_info_1");
        com.byazt.bp.c.t().ve(cVar.c());
        com.byazt.bp.c.t().a(cVar.tt());
        com.byazt.bp.c.t().ve(cVar.z());
        com.byazt.bp.c.t().n(cVar.a().ve());
        com.byazt.bp.c.t().a(cVar.a().uj());
        com.byazt.bp.c.t().c(cVar.a().tt());
        com.byazt.bp.c.t().c(cVar.a().n());
        com.byazt.bp.c.t().c(cVar.a().a());
        com.byazt.bp.c.t().uj(cVar.a().c());
        com.byazt.bp.c.t().uj(cVar.uj());
        com.byazt.bp.c.t().tt(cVar.n());
        com.byazt.bp.c.t().n(cVar.a().sp());
        com.byazt.bp.c.t().c(cVar.a().x());
        com.byazt.bp.c.t().c(cVar.i(), true);
        com.byazt.bp.c.t().sp(cVar.a().i());
        com.byazt.bp.c.t().tt(cVar.da());
        com.byazt.bp.c.t().ve(cVar.u());
        com.byazt.bp.c.t().sp(cVar.sl());
        com.byazt.tjo.a.c(jSONObject, "s-global_info_2");
        com.byazt.bp.c.t().c(cVar.t());
        com.byazt.tjo.a.c(jSONObject, "s-global_info_3");
        com.byazt.bp.c.t().x(cVar.sp().tt());
        com.byazt.bp.c.t().x(cVar.sp().c());
        com.byazt.bp.c.t().i(cVar.sp().ve());
        com.byazt.bp.c.t().da(cVar.sp().uj());
        if (cVar.u() != null) {
            try {
                com.byazt.bp.c.t().c((List<String>) cVar.u().get(MediationConstant.GM_EXTRA_KEY_PRIME_RIT_LIST));
            } catch (Throwable unused) {
            }
        }
        if (cVar.x() != null) {
            com.byazt.bp.c.t().tt(cVar.x().c());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void tt(Context context, long j) {
        if (!uj.c()) {
            com.byazt.eu.tt.c("TMe", "-----==---- 延时上报sdk_init");
            uj.c(j);
        } else {
            com.byazt.eu.tt.c("TMe", "-----==---- 正常上报sdk_init");
            uj.tt(j);
        }
    }

    private static void tt(JSONObject jSONObject) {
        com.byazt.qe.tt.c(com.byazt.bp.tt.tt()).c(0, jSONObject);
    }

    public static void c(SparseArray<Object> sparseArray) {
        for (com.byazt.ly.uj ujVar : com.byazt.px.tt.c().ve()) {
            if (ujVar != null) {
                try {
                    ujVar.setPrivacyConfig(com.byazt.bp.c.t().qy(), sparseArray);
                } catch (Throwable th) {
                    m.c(th);
                }
            }
        }
    }

    public static void c(Context context) {
        if (context != null) {
            com.byazt.bp.tt.c(context);
        }
    }

    private static void c(JSONObject jSONObject) {
        try {
            com.byazt.bp.tt.tt().c(true, jSONObject);
        } catch (Throwable th) {
            com.byazt.eu.tt.uj(MediationConstant.TAG, "InitHelper-->initSetting->loadData Exception=" + th.toString());
        }
    }
}
