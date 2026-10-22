package com.byazt.omf;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.os.SystemClock;
import android.util.SparseArray;
import com.byazt.aas.DeviceUtils;
import com.byazt.aas.nb;
import com.byazt.dna.qp;
import com.byazt.nys.PluginConstants;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import com.bytedance.pangle.annotations.ForbidWrapParam;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.huawei.hms.framework.common.hianalytics.CrashHianalyticsData;
import com.qq.e.comm.managers.status.SDKStatus;
import java.io.Serializable;
import java.util.Map;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.function.Function;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 31, 54})
public final class ve implements Function<SparseArray<Object>, Object> {
    public static final int VALUE_SET_AD_CONFIG_BUILDER_TIME = 25;
    public static final int VALUE_SET_BOOST_INIT_START_TIME = 27;
    public static final int VALUE_SET_PANGLE_CALL_INIT_TIME = 24;
    public static final int VALUE_SET_PANGLE_INIT_START_TIME = 1;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static AtomicBoolean f28886a;
    public static int c;
    public static Boolean tt;
    public com.byazt.fqg.c sp;
    public final md ve = new md();
    public volatile boolean uj = false;
    public AtomicBoolean n = new AtomicBoolean(false);

    public ve(Bundle bundle) {
        if (bundle == null || !bundle.containsKey(PluginConstants.KEY_PL_UPDATE_EVENT_LISTENER)) {
            return;
        }
        Serializable serializable = bundle.getSerializable(PluginConstants.KEY_PL_UPDATE_EVENT_LISTENER);
        if (serializable instanceof Function) {
            com.byazt.zj.ve.c().c((Function<SparseArray<Object>, Object>) serializable);
        }
    }

    public static boolean isDebug(com.byazt.dj.c cVar) {
        AtomicBoolean atomicBoolean = f28886a;
        if (atomicBoolean != null) {
            return atomicBoolean.get();
        }
        boolean z = cVar.x() && com.byazt.aas.sp.c();
        f28886a = new AtomicBoolean(z);
        return z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String n() {
        try {
            Class.forName("com.unity3d.player.UnityPlayer");
            try {
                Class.forName("com.bytedance.android.NativeAdManager");
                return MediationConstant.ADN_UNITY;
            } catch (Throwable unused) {
                return "unity_pure";
            }
        } catch (Throwable unused2) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean uj() {
        if (tt == null) {
            try {
                Class.forName("kotlin.Result");
                tt = Boolean.TRUE;
            } catch (Throwable unused) {
                tt = Boolean.FALSE;
            }
        }
        return tt.booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int ve() {
        if (c == 0) {
            try {
                try {
                    Class.forName("androidx.core.content.FileProvider");
                    c = 1;
                } catch (Throwable unused) {
                    c = -1;
                }
            } catch (Throwable unused2) {
                Class.forName("androidx.core.content.FileProvider");
                c = 2;
            }
        }
        return c;
    }

    public md getManager() {
        return this.ve;
    }

    public Map<String, Object> getReuseServiceMap() {
        com.byazt.fqg.c cVar = this.sp;
        if (cVar == null) {
            return null;
        }
        return cVar.c();
    }

    public void init(final Context context, @ForbidWrapParam final PluginValueSet pluginValueSet, @ForbidWrapParam final com.byazt.fb.ve veVar) {
        com.byazt.fb.ve veVar2;
        ve veVar3;
        long jElapsedRealtime;
        long jLongValue;
        String name;
        int priority;
        try {
            try {
                try {
                    jElapsedRealtime = pluginValueSet.longValue(1, SystemClock.elapsedRealtime());
                    jLongValue = pluginValueSet.longValue(27, 0L);
                } catch (Exception unused) {
                    jElapsedRealtime = SystemClock.elapsedRealtime();
                    jLongValue = 0;
                }
                final long jElapsedRealtime2 = jElapsedRealtime == 0 ? SystemClock.elapsedRealtime() : jElapsedRealtime;
                final long j = jLongValue <= 0 ? jElapsedRealtime : jLongValue;
                final qy qyVarC = qy.c("duration");
                final com.byazt.dj.c cVar = new com.byazt.dj.c(pluginValueSet != null ? pluginValueSet.sparseArray() : new SparseArray<>());
                gt.c(context);
                Thread threadCurrentThread = Thread.currentThread();
                try {
                    name = pluginValueSet.stringValue(2, threadCurrentThread.getName());
                } catch (Exception unused2) {
                    name = threadCurrentThread.getName();
                }
                final String str = name;
                try {
                    priority = pluginValueSet.intValue(3, threadCurrentThread.getPriority());
                } catch (Exception unused3) {
                    priority = threadCurrentThread.getPriority();
                }
                final int i = priority;
                tt(pluginValueSet);
                if (this.uj) {
                    c(veVar);
                    return;
                }
                x.m().yp();
                c(cVar, pluginValueSet);
                long jElapsedRealtime3 = SystemClock.elapsedRealtime();
                c(pluginValueSet);
                qyVarC.c("init_thread_cost", SystemClock.elapsedRealtime() - jElapsedRealtime3);
                long jElapsedRealtime4 = SystemClock.elapsedRealtime();
                this.sp = new com.byazt.fqg.c(pluginValueSet);
                qyVarC.c("init_autoservice_cost", SystemClock.elapsedRealtime() - jElapsedRealtime4);
                final long jElapsedRealtime5 = SystemClock.elapsedRealtime() - jElapsedRealtime2;
                qyVarC.tt("sync_cost");
                try {
                    ((qp) com.byazt.ut.uj.getService("thread_service")).getScheduledThreadPool().execute(new Runnable() { // from class: com.byazt.omf.ve.1
                        @Override // java.lang.Runnable
                        public void run() {
                            qyVarC.tt("async_wait_cost");
                            if (ve.this.c(context, cVar, veVar, qyVarC)) {
                                qyVarC.tt("async_done_cost");
                                long jElapsedRealtime6 = SystemClock.elapsedRealtime() - jElapsedRealtime2;
                                qyVarC.c();
                                long jElapsedRealtime7 = SystemClock.elapsedRealtime() - jElapsedRealtime2;
                                ve.this.c(context, jElapsedRealtime5, SystemClock.elapsedRealtime() - j, jElapsedRealtime6, jElapsedRealtime7, qyVarC, true, cVar, str, i, pluginValueSet, gt.tt().bw());
                            }
                        }
                    });
                    com.byazt.hef.tt.c();
                    veVar3 = this;
                    try {
                        com.byazt.bwm.n.tt(new com.byazt.bwm.sp("init Async") { // from class: com.byazt.omf.ve.2
                            @Override // java.lang.Runnable
                            public void run() {
                                try {
                                    if (ve.this.n.get()) {
                                        return;
                                    }
                                    ve.this.n.set(true);
                                    a.c();
                                    DeviceUtils.ve();
                                    com.byazt.lkt.c.c(false);
                                    com.byazt.qh.tt.c(context);
                                    com.byazt.qh.tt.c();
                                    com.byazt.fj.c.c().registerReceiver(context);
                                    com.byazt.qw.ve.ve().uj();
                                } catch (Throwable th) {
                                    com.byazt.nr.m.tt("Init sync exception: ".concat(String.valueOf(th)));
                                }
                            }
                        });
                        rh.c = true;
                        return;
                    } catch (Throwable th) {
                        th = th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    veVar3 = this;
                }
            } catch (Throwable th3) {
                th = th3;
                veVar3 = this;
            }
        } catch (Throwable th4) {
            th = th4;
            veVar2 = veVar;
            veVar3 = this;
        }
        veVar2 = veVar;
        veVar3.c(veVar2, th);
        c(new com.byazt.dj.c(pluginValueSet != null ? pluginValueSet.sparseArray() : new SparseArray<>()), veVar3.uj);
    }

    public boolean isInitSuccess() {
        return this.uj;
    }

    @Override // java.util.function.Function
    public Object apply(SparseArray<Object> sparseArray) {
        if (sparseArray == null) {
            return null;
        }
        PluginValueSet pluginValueSetTt = com.byazt.rl.c.c(sparseArray).tt();
        switch (pluginValueSetTt.intValue(-99999987)) {
            case -999002:
                return Boolean.valueOf(isInitSuccess());
            case -999001:
                init((Context) pluginValueSetTt.objectValue(-998000, Context.class), pluginValueSetTt, new com.byazt.fb.ve((Function) pluginValueSetTt.objectValue(15, Function.class)));
                return null;
            case -999000:
                return this.ve;
            default:
                return null;
        }
    }

    private void tt(@ForbidWrapParam PluginValueSet pluginValueSet) {
        try {
            Boolean bool = (Boolean) pluginValueSet.objectValue(14, Boolean.class);
            if (bool != null) {
                p.ve = bool.booleanValue();
            }
        } catch (Exception unused) {
        }
    }

    private static void c(com.byazt.dj.c cVar, boolean z) {
        if (isDebug(cVar)) {
            com.byazt.zlb.ve.ve(1, z ? "1" : "0");
            c(cVar.sl());
            com.byazt.zlb.ve.tt(2, cVar.c());
            try {
                Thread.currentThread().getContextClassLoader().loadClass("com.bytedance.sdk.openadsdk.core.GlobalInfo");
                com.byazt.zlb.ve.ve(2, "0");
            } catch (Exception unused) {
                com.byazt.zlb.ve.ve(2, "1");
            }
            com.byazt.zlb.ve.tt(0, p.n);
        }
    }

    private void tt(@ForbidWrapParam com.byazt.dj.c cVar, @ForbidWrapParam PluginValueSet pluginValueSet) {
        if (cVar == null) {
            return;
        }
        String strTt = cVar.tt();
        if (strTt == null || strTt.isEmpty()) {
            strTt = com.byazt.fh.c.da();
        }
        x.m().c((Function<SparseArray<Object>, Object>) pluginValueSet.objectValue(16, Function.class));
        x.m().uj(strTt);
        x.m().ve(cVar.c());
        x.m().ve(cVar.ve());
        x.m().n(cVar.uj());
        x.m().a(cVar.n());
        x.m().tt(cVar.a());
        x.m().n(cVar.yp());
        x.m().uj(cVar.sp());
        x.m().c(cVar.i());
        x.m().x(cVar.m());
        x.m().c(cVar.sl());
        x.m().uj(cVar.u());
        x.m().c(cVar.t());
        if (isDebug(cVar)) {
            com.byazt.nr.m.tt();
            com.byazt.zlb.ve.tt();
            com.byazt.x.c.c(2);
        }
    }

    private static void c(com.byazt.dj.uj ujVar) {
        String str;
        if (ujVar == null || ujVar.isDefaultController()) {
            ujVar = x.c;
        }
        com.byazt.zlb.ve.ve(19, ujVar.isDefaultController() ? "1" : "0");
        com.byazt.zlb.ve.ve(7, String.valueOf(ujVar.isCanUseLocation() ? 1 : 0));
        com.byazt.dj.ve tTLocation = ujVar.getTTLocation();
        String strTrim = "";
        if (tTLocation != null) {
            str = tTLocation.c() + "," + tTLocation.tt();
        } else {
            str = "";
        }
        com.byazt.zlb.ve.ve(8, str);
        com.byazt.zlb.ve.ve(9, String.valueOf(ujVar.isCanUsePhoneState() ? 1 : 0));
        String devImei = ujVar.getDevImei();
        com.byazt.zlb.ve.ve(10, devImei != null ? devImei.trim() : "");
        com.byazt.zlb.ve.ve(11, String.valueOf(ujVar.isCanUseWifiState() ? 1 : 0));
        com.byazt.zlb.ve.ve(12, String.valueOf(ujVar.isCanUseWriteExternal() ? 1 : 0));
        com.byazt.zlb.ve.ve(17, String.valueOf(ujVar.alist() ? 1 : 0));
        com.byazt.zlb.ve.ve(22, String.valueOf(ujVar.isCanUseAndroidId() ? 1 : 0));
        if (p.uj >= 7000) {
            com.byazt.zlb.ve.ve(24, String.valueOf(ujVar.isCanUseMessage() ? 1 : 0));
        }
        String macAddress = ujVar.getMacAddress();
        com.byazt.zlb.ve.ve(18, macAddress != null ? macAddress.trim() : "");
        try {
            if (ujVar.getDevOaid() != null) {
                strTrim = ujVar.getDevOaid().trim();
            }
            com.byazt.zlb.ve.ve(13, strTrim);
        } catch (Exception unused) {
            com.byazt.nr.m.ve("Get oaid from controller failed");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tt(@ForbidWrapParam final Context context, final long j, final long j2, final long j3, final long j4, final qy qyVar, final boolean z, final com.byazt.dj.c cVar, final String str, final int i, @ForbidWrapParam final PluginValueSet pluginValueSet, @ForbidWrapParam final com.byazt.ogz.sp spVar) {
        rh.ve();
        if (gt.tt().hj()) {
            com.byazt.ukr.yp.c().tt(new com.byazt.ee.c() { // from class: com.byazt.omf.ve.6
                /* JADX WARN: Code duplicated, block: B:7:0x00b6  */
                @Override // com.byazt.ee.c
                public com.byazt.qal.c c() throws Exception {
                    int iIntValue;
                    boolean zGt = x.m().gt();
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("duration", j);
                    jSONObject.put("is_async", z);
                    jSONObject.put("is_multi_process", cVar.da());
                    jSONObject.put("is_debug", ve.isDebug(cVar));
                    jSONObject.put("is_activate_init", zGt);
                    jSONObject.put("is_plugin", p.c());
                    jSONObject.put("has_kotlin", ve.uj());
                    jSONObject.put("use_mediation", cVar.m());
                    jSONObject.put("is_androidx", ve.ve());
                    jSONObject.put("host_abi", com.byazt.qya.tt.c());
                    jSONObject.put("minSdkVersion", nb.ve(context));
                    jSONObject.put("targetSdkVersion", nb.tt(context));
                    jSONObject.put("ttvideo_plugin_config", true);
                    jSONObject.put("ttvideo_can_use", p.n());
                    jSONObject.put("is_keva_init_success", com.byazt.aas.eo.tt());
                    jSONObject.put(CrashHianalyticsData.THREAD_NAME, str);
                    com.byazt.dna.gu guVar = (com.byazt.dna.gu) com.byazt.ut.uj.getService("m_d_s");
                    if (guVar != null) {
                        Object data = guVar.getData(3);
                        if (data instanceof Integer) {
                            iIntValue = ((Integer) data).intValue();
                        } else {
                            iIntValue = -1;
                        }
                    } else {
                        iIntValue = -1;
                    }
                    jSONObject.put("layer_init_type", iIntValue);
                    jSONObject.put("thread_priority", i);
                    jSONObject.put("is_boost", com.byazt.xo.c.n());
                    jSONObject.put("single_arch_sdk", pluginValueSet.booleanValue(26, false) ? 1 : 0);
                    jSONObject.put("opt_config", String.valueOf(spVar));
                    jSONObject.put("page_size", com.byazt.aas.zm.my());
                    jSONObject.put("j_fun", Function.class.getName());
                    x.m().tt(false);
                    Object objObjectValue = pluginValueSet.objectValue(9, Object.class);
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("main_cost", j);
                    jSONObject2.put("layer_real_cost_time", j2);
                    jSONObject2.put("callback_cost", j3);
                    jSONObject2.put("total_cost", j4);
                    if (objObjectValue != null) {
                        jSONObject2.put("plugin", objObjectValue);
                    }
                    JSONObject jSONObject3 = new JSONObject();
                    qyVar.c(jSONObject3, 20L);
                    jSONObject2.put("init", jSONObject3);
                    jSONObject.put("cost", jSONObject2);
                    if (!cVar.m()) {
                        try {
                            Object objInvoke = Class.forName("com.baidu.mobads.sdk.api.AdSettings").getMethod("getSDKVersion", new Class[0]).invoke(null, new Object[0]);
                            if (objInvoke instanceof String) {
                                jSONObject.put("baidu_version", objInvoke);
                            }
                        } catch (Throwable unused) {
                        }
                        try {
                            Object objInvoke2 = SDKStatus.class.getMethod("getIntegrationSDKVersion", new Class[0]).invoke(null, new Object[0]);
                            if (objInvoke2 instanceof String) {
                                jSONObject.put("gdt_version", objInvoke2);
                            }
                        } catch (Throwable unused2) {
                        }
                        try {
                            Object objInvoke3 = Class.forName("com.kwad.sdk.api.KsAdSDK").getMethod("getSDKVersion", new Class[0]).invoke(null, new Object[0]);
                            if (objInvoke3 instanceof String) {
                                jSONObject.put("ks_version", objInvoke3);
                            }
                        } catch (Throwable unused3) {
                        }
                    }
                    Object objN = ve.this.n();
                    if (objN != null) {
                        jSONObject.put("develop_type", objN);
                    }
                    com.byazt.qal.tt ttVarTt = com.byazt.qal.tt.tt().c("pangle_sdk_init").tt(jSONObject.toString());
                    StringBuilder sb = new StringBuilder();
                    sb.append(j3);
                    return ttVarTt.n(sb.toString());
                }
            }, "pangle_sdk_init");
        }
    }

    private void c(@ForbidWrapParam com.byazt.fb.ve veVar, Throwable th) {
        String message = null;
        if (veVar != null) {
            message = th != null ? th.getMessage() : null;
            if (message == null) {
                message = "init error";
            }
            veVar.c(1, com.byazt.yxi.n.c().c(false).c(4000).c(message).tt());
            com.byazt.nr.m.ve("TTAdSdk", " init fail, msg = ", message);
        }
        if (p.uj < 7300) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.putOpt("message", message);
                Boolean bool = Boolean.TRUE;
                jSONObject.putOpt("is_plugin", bool);
                jSONObject.putOpt("api", bool);
                jSONObject.putOpt("install_version", 7611);
                jSONObject.putOpt("code", 4000);
                com.byazt.ukr.yp.c().c("init", jSONObject, th);
            } catch (Throwable unused) {
            }
        }
        this.uj = false;
    }

    private void c(@ForbidWrapParam PluginValueSet pluginValueSet) {
        try {
            com.byazt.jv.c.c();
        } catch (Exception unused) {
        }
    }

    private void c(com.byazt.fb.ve veVar) {
        com.byazt.by.c.c();
        if (veVar != null) {
            ThreadPoolExecutor threadPoolExecutorI = com.byazt.bwm.i.tt.i();
            com.byazt.yxi.n nVarC = com.byazt.yxi.n.c().c(true);
            com.byazt.yxi.uj ujVarC = com.byazt.yxi.uj.c().c(20, threadPoolExecutorI);
            if (p.uj < 7500) {
                ujVarC.c(23, getReuseServiceMap());
            }
            veVar.c(8001, nVarC.c(ujVarC.tt()).tt());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean c(@ForbidWrapParam Context context, @ForbidWrapParam com.byazt.dj.c cVar, @ForbidWrapParam com.byazt.fb.ve veVar, qy qyVar) {
        if (this.uj) {
            c(veVar);
            return false;
        }
        try {
            if (com.byazt.xo.c.ve()) {
                c(veVar, new Exception("load maparmor fail"));
                return false;
            }
            c(context, cVar, qyVar);
            this.uj = true;
            c(cVar);
            c(context, cVar);
            qyVar.tt("async_init_cost");
            com.byazt.dna.n nVarTt = com.byazt.aas.gr.tt();
            if (nVarTt != null) {
                nVarTt.initPglCryptUtils();
            }
            qyVar.tt("armor_load_cost");
            com.byazt.nr.m.uj("TTAdSdk", "Init done finish: 7611");
            c(veVar);
            c(cVar, this.uj);
            return true;
        } catch (Throwable th) {
            c(veVar, th);
        }
    }

    private void c(@ForbidWrapParam com.byazt.dj.c cVar) {
        if (x.m().lr()) {
            com.byazt.lj.tt.c(cVar);
        }
    }

    private void c(@ForbidWrapParam Context context, @ForbidWrapParam com.byazt.dj.c cVar, qy qyVar) {
        try {
            if (isDebug(cVar)) {
                com.byazt.aas.nu.c();
                com.byazt.lt.tt.c();
                com.byazt.hm.c.c();
                com.byazt.zlb.ve.tt();
            }
        } catch (Throwable unused) {
        }
        qyVar.tt("debug_set_cost");
        com.byazt.ue.uj.c(context);
        qyVar.tt("web_dir_cost");
        com.byazt.hw.c.c((ThreadPoolExecutor) com.byazt.bwm.n.c());
        qyVar.tt("thread_pool_cost");
        com.byazt.oy.tt.c(cVar.da());
        if (cVar.da()) {
            com.byazt.ue.tt.c(cVar.c());
            x.m().eo();
        } else {
            com.byazt.ue.tt.tt(cVar.c());
        }
        qyVar.tt("multi_cost");
        com.byazt.oy.tt.c(context, null);
        com.byazt.ri.c.c(context);
        qyVar.tt("video_config_cost");
        rh.n();
        qyVar.tt("dyna_init_cost");
        com.byazt.aas.gr.ve();
        qyVar.tt("armor_init_cost");
    }

    private void c(@ForbidWrapParam com.byazt.dj.c cVar, @ForbidWrapParam PluginValueSet pluginValueSet) {
        tt(cVar, pluginValueSet);
        rh.uj();
        com.byazt.ukr.tt.tt();
        try {
            com.byazt.xs.n.c();
        } catch (Throwable th) {
            com.byazt.nr.m.c(th);
        }
        if (cVar.da()) {
            com.byazt.aas.eo.c();
        }
        com.byazt.by.ve.c().c(cVar.da());
    }

    private void c(@ForbidWrapParam final Context context, @ForbidWrapParam final com.byazt.dj.c cVar) {
        com.byazt.bwm.n.c(new com.byazt.bwm.sp("init sync") { // from class: com.byazt.omf.ve.3
            @Override // java.lang.Runnable
            public void run() {
                try {
                    com.byazt.yih.i.uj();
                    com.byazt.ogz.sl slVarTt = gt.tt();
                    if (!slVarTt.il()) {
                        synchronized (slVarTt) {
                            if (!slVarTt.il()) {
                                slVarTt.c();
                            }
                        }
                    }
                    ve.this.c(cVar.da(), context, true, 10000L);
                    com.byazt.nr.da.c().postDelayed(new Runnable() { // from class: com.byazt.omf.ve.3.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (x.m().d()) {
                                return;
                            }
                            com.byazt.qh.tt.c(cVar.c());
                        }
                    }, com.igexin.push.config.c.l);
                    com.byazt.oy.tt.c(com.byazt.hy.n.c().tt().a());
                    com.byazt.ukr.tt.c(context, cVar.da());
                    com.byazt.yih.tt.c();
                    eo.ve();
                    com.byazt.xiv.n.c();
                    com.byazt.ri.c.c(com.byazt.bzd.sl.c(0));
                    if (slVarTt.gt()) {
                        final com.byazt.fk.c cVarC = com.byazt.bzd.sl.c(1);
                        com.byazt.bwm.n.tt(new com.byazt.bwm.sp("preloadTTVideo") { // from class: com.byazt.omf.ve.3.2
                            @Override // java.lang.Runnable
                            public void run() {
                                com.byazt.btt.tt.c().preloadTTVideo(context, cVarC.getOtherCacheDir(), 52428800, com.byazt.bzd.sl.tt(), com.byazt.bzd.sl.ve(), ve.isDebug(cVar));
                            }
                        });
                    }
                    DeviceUtils.sp();
                    rh.c(context);
                    com.byazt.tl.tt.c();
                    com.byazt.hef.tt.ve(context);
                    com.byazt.tjs.uj.c(context);
                    if (Build.VERSION.SDK_INT >= 29) {
                        try {
                            com.byazt.nr.qy.c();
                        } catch (Exception unused) {
                        }
                    }
                    com.byazt.aas.sl.c();
                    com.byazt.aas.sp.c(cVar);
                    com.byazt.aas.gr.c();
                    com.byazt.la.c.c().c(context);
                    com.byazt.aas.cu.c();
                    com.byazt.qcl.uj.c(cVar.c());
                    com.byazt.fh.n.c().tt();
                    com.byazt.tlc.c.c(context, cVar.c(), slVarTt);
                    x.m().ve().c(com.byazt.rgb.n.uj);
                    com.byazt.rgb.n.c(1);
                } catch (Throwable th) {
                    com.byazt.nr.m.tt("TTAdSdk", "Unexpected asyn init error: ".concat(String.valueOf(th)));
                }
            }
        }, 10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(final boolean z, @ForbidWrapParam final Context context, final boolean z2, long j) {
        com.byazt.nr.da.c().postDelayed(new Runnable() { // from class: com.byazt.omf.ve.4
            @Override // java.lang.Runnable
            public void run() {
                com.byazt.apd.tt.c();
                if (!z) {
                    com.byazt.ogz.x.c(gt.tt()).uj();
                } else if (com.byazt.nr.gt.c(context)) {
                    com.byazt.ogz.x.c(gt.tt()).uj();
                    com.byazt.nr.m.c("TTAdSdk", "Load setting in main process");
                }
                if (z2) {
                    com.byazt.ukr.tt.uj();
                }
            }
        }, j);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(@ForbidWrapParam final Context context, final long j, final long j2, final long j3, final long j4, final qy qyVar, final boolean z, final com.byazt.dj.c cVar, final String str, final int i, @ForbidWrapParam final PluginValueSet pluginValueSet, @ForbidWrapParam final com.byazt.ogz.sp spVar) {
        com.byazt.nr.da.c().postDelayed(new Runnable() { // from class: com.byazt.omf.ve.5
            @Override // java.lang.Runnable
            public void run() {
                try {
                    ve.this.tt(context, j, j2, j3, j4, qyVar, z, cVar, str, i, pluginValueSet, spVar);
                } catch (Throwable unused) {
                }
            }
        }, 5000L);
    }
}
