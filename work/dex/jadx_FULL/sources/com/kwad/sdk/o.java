package com.kwad.sdk;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RawRes;
import com.kwad.components.core.t.t;
import com.kwad.components.offline.api.BuildConfig;
import com.kwad.sdk.api.KsLoadManager;
import com.kwad.sdk.api.SdkConfig;
import com.kwad.sdk.api.core.IKsAdSDK;
import com.kwad.sdk.api.loader.DynamicInstallReceiver;
import com.kwad.sdk.api.proxy.BaseProxyActivity;
import com.kwad.sdk.api.proxy.BaseProxyFragmentActivity;
import com.kwad.sdk.api.proxy.IComponentProxy;
import com.kwad.sdk.core.imageloader.ImageLoaderPerfUtil;
import com.kwad.sdk.core.response.model.SdkConfigData;
import com.kwad.sdk.core.threads.GlobalThreadPools;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.ad;
import com.kwad.sdk.utils.ai;
import com.kwad.sdk.utils.at;
import com.kwad.sdk.utils.ba;
import com.kwad.sdk.utils.bf;
import com.kwad.sdk.utils.bj;
import com.kwad.sdk.utils.bv;
import java.io.File;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
public final class o {
    private g aGA;
    private g aGB;
    private g aGC;
    private g aGD;
    private volatile boolean aGE;
    private boolean aGF;
    private boolean aGG;
    private String aGH;
    private volatile AtomicBoolean aGo;
    private volatile AtomicBoolean aGp;
    private volatile AtomicBoolean aGq;
    private volatile AtomicBoolean aGr;
    private AtomicBoolean aGs;
    private volatile Boolean aGt;
    private String aGu;
    private int aGv;
    private boolean aGw;

    @Nullable
    private com.kwad.components.core.b aGx;
    private long aGy;
    private long aGz;
    private long alK;

    public static class a {
        private static final o aGL = new o(0);
    }

    public /* synthetic */ o(byte b) {
        this();
    }

    private static void GA() {
        try {
            com.kwad.sdk.components.c.init(ServiceProvider.getContext());
        } catch (Throwable th) {
            q.s(th);
        }
    }

    private static void GB() {
        try {
            com.kwad.components.core.proxy.launchdialog.e.vJ().init(ServiceProvider.getContext());
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    private static void GC() {
        try {
            com.kwad.components.core.d.a.initAsync(ServiceProvider.getContext());
        } catch (Throwable th) {
            q.s(th);
        }
    }

    private static void GD() {
        try {
            com.kwad.components.core.d.a.am(ServiceProvider.getContext());
        } catch (Throwable th) {
            q.s(th);
        }
    }

    private void GE() {
        try {
            com.kwad.sdk.components.d.init(getContext());
        } catch (Throwable th) {
            q.s(th);
        }
    }

    private void GF() {
        try {
            com.kwad.components.core.offline.b.b.init(getContext());
        } catch (Throwable th) {
            q.s(th);
        }
    }

    private void GG() {
        ai.ap(ServiceProvider.getContext(), this.aGH);
        this.aGH = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void GH() {
        try {
            Map<String, String> jSON2MapString = ad.parseJSON2MapString(com.kwad.sdk.core.config.c.aPI.getValue());
            for (String str : jSON2MapString.keySet()) {
                GlobalThreadPools.r(str, Integer.parseInt((String) requireNonNull(jSON2MapString.get(str))));
            }
            GlobalThreadPools.NU();
            com.kwad.sdk.core.config.c.aQC.getValue().booleanValue();
            GlobalThreadPools.NS();
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    private void GI() {
        GlobalThreadPools.Oi().execute(new Runnable() { // from class: com.kwad.sdk.o.10
            @Override // java.lang.Runnable
            public final void run() {
                try {
                    com.kwad.components.core.c.a.oI().oK();
                } catch (Exception e) {
                    com.kwad.sdk.core.d.c.w("KSAdSDK", Log.getStackTraceString(e));
                }
            }
        });
    }

    private static void GJ() {
        try {
            com.kwad.sdk.core.d.c.init(ServiceProvider.getSDKConfig().enableDebug);
        } catch (Throwable th) {
            q.s(th);
        }
    }

    private static void GK() {
        try {
            com.kwad.sdk.wrapper.f.XT().init();
        } catch (Throwable th) {
            q.s(th);
        }
    }

    private static void GL() {
        try {
            com.kwad.sdk.core.c.b.LW().init(ServiceProvider.getContext());
        } catch (Throwable th) {
            q.s(th);
        }
    }

    private void GM() {
        try {
            com.kwad.sdk.core.webview.b.a.PH().init(getContext());
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    private void GN() {
        try {
            com.kwad.sdk.core.network.idc.a.Mo().init(getContext());
        } catch (Throwable th) {
            q.s(th);
        }
    }

    private static void GO() {
        try {
            com.kwad.sdk.core.download.a.bQ(ServiceProvider.getContext());
        } catch (Throwable th) {
            q.s(th);
        }
    }

    private void GP() {
        try {
            com.kwad.sdk.core.diskcache.a.bP(getContext());
        } catch (Throwable th) {
            q.s(th);
        }
    }

    private static void GQ() {
        try {
            t.wU().init();
        } catch (Throwable th) {
            q.s(th);
        }
    }

    private static void GR() {
        com.kwad.components.core.q.b.wf();
        com.kwad.components.core.q.b.f(com.kwad.sdk.core.config.e.JA(), com.kwad.sdk.core.config.e.JB());
    }

    private void GS() {
        try {
            bf.init(getContext());
        } catch (Throwable th) {
            q.s(th);
        }
    }

    private static void GT() {
        try {
            com.kwad.sdk.app.b.HO().init();
        } catch (Throwable th) {
            q.s(th);
        }
    }

    private void GU() {
        try {
            com.kwad.library.solder.lib.i.a(new com.kwad.library.solder.lib.i.a() { // from class: com.kwad.sdk.o.2
                @Override // com.kwad.library.solder.lib.i.a
                public final boolean DT() {
                    return com.kwad.sdk.core.config.e.a(com.kwad.sdk.core.config.c.aOO);
                }

                @Override // com.kwad.library.solder.lib.i.a
                public final void b(String str, File file) {
                    com.kwad.sdk.core.download.a.a(str, file, true);
                }

                @Override // com.kwad.library.solder.lib.i.a
                public final void f(String str, Throwable th) {
                    if (th instanceof Exception) {
                        com.kwad.sdk.core.network.idc.a.Mo().h(str, th);
                    }
                }

                @Override // com.kwad.library.solder.lib.i.a
                public final int getCorePoolSize() {
                    return com.kwad.sdk.core.config.e.JD();
                }

                @Override // com.kwad.library.solder.lib.i.a
                public final int getMaxRetryCount() {
                    return com.kwad.sdk.core.config.e.a(com.kwad.sdk.core.config.c.aOP);
                }
            });
        } catch (Throwable th) {
            q.s(th);
        }
    }

    public static o Gs() {
        return a.aGL;
    }

    private boolean Gw() {
        return q.bk(getContext());
    }

    private void Gx() {
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        this.alK = jElapsedRealtime;
        com.kwad.sdk.service.c.init();
        k.Fo();
        GJ();
        GK();
        boolean zGv = Gv();
        Log.d("KSAdSDK", "initSDKModule enableInitStartMode: " + zGv);
        if (this.aGA == null) {
            this.aGA = g.aj(this.aGy);
        }
        if (!zGv) {
            this.aGA.report();
        }
        GA();
        GN();
        GO();
        GU();
        GG();
        if (!zGv) {
            Gy();
            g(null);
        }
        GC();
        GE();
        GF();
        GL();
        GS();
        GQ();
        com.kwad.sdk.wrapper.l.Ov();
        GB();
        com.kwad.sdk.core.h.a.Ov();
        if (!zGv) {
            com.kwad.sdk.a.a.c.Hl().Hn();
            com.kwad.components.core.p.a.vL().vM();
        }
        if (com.kwad.framework.a.a.pd.booleanValue()) {
            try {
                com.kwad.sdk.components.d.f(com.kwad.sdk.components.a.class);
            } catch (Exception unused) {
            }
        }
        long jElapsedRealtime2 = SystemClock.elapsedRealtime() - jElapsedRealtime;
        com.kwad.sdk.core.d.c.d("KSAdSDK", "KSAdSDK init time:" + jElapsedRealtime2);
        com.kwad.sdk.core.d.c.i("KSAdSDK", "SDK_VERSION_NAME: 5.4.10.2 TK_VERSION_CODE: 6.2.3 BRIDGE_VERSION: 1.3");
        if (this.aGB == null) {
            this.aGB = g.ak(jElapsedRealtime2);
        }
        if (!zGv) {
            this.aGB.report();
        }
        long j = Gs().aGz;
        if (j > 0) {
            p.ar(SystemClock.elapsedRealtime() - j);
        }
        f.a(ServiceProvider.getSDKConfig(), j);
        this.aGo.set(true);
    }

    private void Gy() {
        com.kwad.sdk.mobileid.a.init(getContext());
    }

    private void Gz() {
        try {
            com.kwad.sdk.commercial.c.a(new com.kwad.sdk.commercial.c.a() { // from class: com.kwad.sdk.o.6
                @Override // com.kwad.sdk.commercial.c.a
                public final boolean GX() {
                    return com.kwad.sdk.core.config.e.b(com.kwad.sdk.core.config.c.aND);
                }

                @Override // com.kwad.sdk.commercial.c.a
                public final boolean GY() {
                    return com.kwad.sdk.core.config.e.a(com.kwad.sdk.core.config.c.aNC);
                }

                @Override // com.kwad.sdk.commercial.c.a
                public final JSONObject GZ() {
                    return com.kwad.sdk.core.config.e.a(com.kwad.sdk.core.config.c.aNO);
                }

                @Override // com.kwad.sdk.commercial.c.a
                public final JSONObject Ha() {
                    return com.kwad.sdk.core.config.e.a(com.kwad.sdk.core.config.c.aNP);
                }

                @Override // com.kwad.sdk.commercial.c.a
                public final String Hb() {
                    return com.kwad.sdk.core.config.e.a(com.kwad.sdk.core.config.c.aQf);
                }

                @Override // com.kwad.sdk.commercial.c.a
                public final void j(String str, String str2, boolean z) {
                    com.kwad.components.core.p.a.vL().e(str, str2, false);
                }
            }, this.aGw);
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    private static boolean bg(Context context) {
        String processName = ba.getProcessName(context);
        return !TextUtils.isEmpty(processName) && processName.endsWith("kssdk_remote");
    }

    private static void c(SdkConfig sdkConfig) {
        f.c(sdkConfig);
    }

    public static String cT(String str) {
        return com.kwad.sdk.core.a.d.ax(str);
    }

    public static String cU(String str) {
        return com.kwad.sdk.core.a.d.getResponseData(str);
    }

    public static void deleteCache() {
        com.kwad.sdk.core.diskcache.b.a.Lx().delete();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(SdkConfigData sdkConfigData) {
        try {
            com.kwad.sdk.core.config.e.Ju();
            GD();
        } catch (Throwable th) {
            com.kwad.sdk.core.d.c.e("KSAdSDK", Log.getStackTraceString(th));
        }
        Gz();
        GM();
        com.kwad.sdk.core.config.e.Fs();
        if ((com.kwad.sdk.core.config.e.a(com.kwad.sdk.core.config.c.aNB) && ba.isInMainProcess(ServiceProvider.Ud())) || com.kwad.framework.a.a.pe.booleanValue()) {
            DynamicInstallReceiver.registerToApp(ServiceProvider.Ud());
        }
        if (com.kwad.sdk.core.config.e.Kl()) {
            com.kwad.sdk.b.a.init(com.kwad.sdk.wrapper.m.Yb());
        }
        GR();
        bj.init(getContext());
        com.kwad.components.core.a.a.oE().az();
        com.kwad.sdk.utils.h.a(getContext(), 30000L, new com.kwad.sdk.collector.h() { // from class: com.kwad.sdk.o.8
            @Override // com.kwad.sdk.collector.h
            public final void c(@NonNull JSONArray jSONArray) {
                com.kwad.components.core.p.a.vL().c(jSONArray);
            }
        });
        com.kwad.sdk.core.network.idc.a.Mo().a(com.kwad.sdk.core.config.e.Km(), com.kwad.sdk.core.config.e.Kn());
        com.kwad.sdk.ip.direct.a.a(sdkConfigData.httpDnsInfo);
        bv.a(com.kwad.sdk.core.config.e.Ko(), com.kwad.sdk.core.config.e.Kp(), ServiceProvider.getContext());
        GT();
        GP();
        com.kwad.components.core.i.a.ra().at(getContext());
        com.kwad.sdk.crash.online.monitor.a.dC(com.kwad.sdk.core.config.e.a(com.kwad.sdk.core.config.c.aPu));
        ImageLoaderPerfUtil.report();
        com.kwad.sdk.m.f.dC(com.kwad.sdk.core.config.e.a(com.kwad.sdk.core.config.c.aPD));
        at.VN().dC(com.kwad.sdk.core.config.e.a(com.kwad.sdk.core.config.c.aPF));
        com.kwad.sdk.core.threads.c.dC(com.kwad.sdk.core.config.e.a(com.kwad.sdk.core.config.c.aPH));
        com.kwad.sdk.monitor.b.Sx();
        com.kwad.sdk.wrapper.m.E(getContext(), ((Boolean) sdkConfigData.getAppConfigData(Boolean.FALSE, new com.kwad.sdk.g.b<JSONObject, Boolean>() { // from class: com.kwad.sdk.o.9
            private static Boolean g(JSONObject jSONObject) {
                return Boolean.valueOf(jSONObject.optBoolean("useContextClassLoader"));
            }

            @Override // com.kwad.sdk.g.b
            public final /* synthetic */ Boolean apply(JSONObject jSONObject) {
                return g(jSONObject);
            }
        })).booleanValue());
        com.kwad.sdk.kgeo.a.fc(com.kwad.sdk.core.config.e.a(com.kwad.sdk.core.config.c.aPZ));
        try {
            com.kwad.components.core.webview.tachikoma.g.yH().init();
        } catch (Throwable th2) {
            com.kwad.components.core.d.a.reportSdkCaughtException(th2);
        }
        GI();
        try {
            com.kwad.sdk.f.a.a.Ra().init(com.kwad.sdk.core.config.e.a(com.kwad.sdk.core.config.c.aPE));
        } catch (Throwable th3) {
            com.kwad.components.core.d.a.reportSdkCaughtException(th3);
        }
        com.kwad.components.core.pfmonitor.d.aF(getContext());
    }

    public static void f(@NonNull Map<String, String> map) {
        com.kwad.sdk.core.a.d.h(map);
    }

    private void g(final com.kwad.sdk.g.a aVar) {
        try {
            com.kwad.components.core.request.h.a(new com.kwad.components.core.request.h.b() { // from class: com.kwad.sdk.o.7
                @Override // com.kwad.components.core.request.h.a
                public final void d(@NonNull SdkConfigData sdkConfigData) {
                    com.kwad.sdk.core.d.c.i("KSAdSDK", "onConfigRefresh()");
                    try {
                        o.this.e(sdkConfigData);
                        com.kwad.sdk.g.a aVar2 = aVar;
                        if (aVar2 != null) {
                            aVar2.accept(null);
                        }
                    } catch (Throwable th) {
                        com.kwad.components.core.d.a.reportSdkCaughtException(th);
                    }
                }

                @Override // com.kwad.components.core.request.h.a
                public final void vZ() {
                    com.kwad.sdk.core.d.c.i("KSAdSDK", "onCacheLoaded()");
                    o.this.GH();
                }

                @Override // com.kwad.components.core.request.h.b
                public final void wa() {
                    try {
                        com.kwad.sdk.g.a aVar2 = aVar;
                        if (aVar2 != null) {
                            aVar2.accept(null);
                        }
                    } catch (Throwable th) {
                        com.kwad.components.core.d.a.reportSdkCaughtException(th);
                    }
                }
            });
        } catch (Throwable th) {
            q.s(th);
        }
    }

    public static String getAppId() {
        return ServiceProvider.getSDKConfig().appId;
    }

    public static JSONObject getAppInfo() {
        return com.kwad.sdk.core.request.model.a.Np();
    }

    public static String getAppName() {
        return ServiceProvider.getSDKConfig().appName;
    }

    public static Context getContext() {
        return ServiceProvider.getContext();
    }

    public static JSONObject getDeviceInfo() {
        return com.kwad.sdk.core.request.model.b.Nr().toJson();
    }

    public static String getDid() {
        return bf.getDeviceId();
    }

    public static JSONObject getNetworkInfo() {
        return com.kwad.sdk.core.request.model.d.Nu().toJson();
    }

    public static String getSDKVersion() {
        return BuildConfig.VERSION_NAME;
    }

    public static SdkConfig getSdkConfig() {
        return ServiceProvider.getSDKConfig();
    }

    public static boolean isDebugLogEnable() {
        return ServiceProvider.getSDKConfig().enableDebug;
    }

    public static <T> T newInstance(Class<T> cls) {
        try {
            return (T) com.kwad.sdk.service.c.h(cls).newInstance();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void pauseCurrentPlayer() {
        com.kwad.sdk.components.d.f(com.kwad.components.a.a.a.class);
    }

    public static void r(Throwable th) {
        ServiceProvider.reportSdkCaughtException(th);
    }

    private static <T> T requireNonNull(T t) {
        t.getClass();
        return t;
    }

    public static void resumeCurrentPlayer() {
        com.kwad.sdk.components.d.f(com.kwad.components.a.a.a.class);
    }

    public static void setLoadingLottieAnimation(boolean z, @RawRes int i) {
        com.kwad.sdk.components.d.f(com.kwad.components.a.a.a.class);
    }

    public static void setLoadingLottieAnimationColor(boolean z, @ColorInt int i) {
        com.kwad.sdk.components.d.f(com.kwad.components.a.a.a.class);
    }

    public static void setThemeMode(int i) {
        com.kwad.sdk.components.d.f(com.kwad.components.a.a.a.class);
    }

    public final boolean Fu() {
        return this.aGw;
    }

    public final boolean Fv() {
        return this.aGE;
    }

    public final boolean Fw() {
        return this.aGF;
    }

    public final boolean Fx() {
        return this.aGo.get();
    }

    public final boolean GV() {
        if (Gv()) {
            return this.aGo.get() && this.aGp.get();
        }
        return this.aGo.get();
    }

    public final long GW() {
        return this.alK;
    }

    public final void Gt() {
        this.aGr.set(true);
        boolean zGV = Gs().GV();
        com.kwad.sdk.core.d.c.d("jky", "startAsync call: " + zGV);
        if (zGV) {
            return;
        }
        GlobalThreadPools.NW().submit(new Runnable() { // from class: com.kwad.sdk.o.5
            @Override // java.lang.Runnable
            public final void run() {
                o.this.start();
            }
        });
        f.b(ServiceProvider.getSDKConfig());
    }

    public final boolean Gu() {
        return this.aGq.get() && this.aGr.get();
    }

    public final boolean Gv() {
        try {
            if (Gw()) {
                Log.d("KSAdSDK", "enableInitStartMode return false hadLastTimeInitError");
                return false;
            }
            if (this.aGt == null) {
                this.aGt = Boolean.valueOf(com.kwad.sdk.core.config.e.Gv());
            }
            if (!this.aGt.booleanValue()) {
                Log.d("KSAdSDK", "enableInitStartMode return false mConfigEnableInitStart");
                return false;
            }
            if (this.aGs.get()) {
                Log.d("KSAdSDK", "enableInitStartMode return true mApiHadStartMethod");
                return true;
            }
            IKsAdSDK.class.getDeclaredMethod("start", new Class[0]);
            this.aGs.set(true);
            Log.d("KSAdSDK", "enableInitStartMode return mApiHadStartMethod: " + this.aGs);
            return this.aGs.get();
        } catch (Throwable th) {
            Log.e("KSAdSDK", th.getMessage());
            th.printStackTrace();
            this.aGs.set(false);
        }
    }

    public final void b(final Context context, final SdkConfig sdkConfig) {
        Log.w("jky", "KSAdSDK initAsync call mIsSdkInit:" + this.aGo);
        this.aGq.set(true);
        if (this.aGo.get()) {
            a((Context) null, sdkConfig);
            return;
        }
        a(context, sdkConfig);
        GlobalThreadPools.NW().submit(new Runnable() { // from class: com.kwad.sdk.o.4
            @Override // java.lang.Runnable
            public final void run() {
                o.this.init(context, sdkConfig);
            }
        });
        f.a(sdkConfig);
    }

    @NonNull
    public final KsLoadManager getAdManager() {
        if (this.aGx == null) {
            this.aGx = new com.kwad.components.core.b();
        }
        return this.aGx;
    }

    public final String getApiVersion() {
        return this.aGu;
    }

    public final int getApiVersionCode() {
        return this.aGv;
    }

    public final synchronized void init(Context context, SdkConfig sdkConfig) {
        if (context != null && sdkConfig != null) {
            try {
                if (!TextUtils.isEmpty(sdkConfig.appId)) {
                    Log.d("KSAdSDK", "init appId:" + sdkConfig.appId + "--mIsSdkInit:" + this.aGo.get());
                    if (this.aGo.get()) {
                        a((Context) null, sdkConfig);
                        return;
                    }
                    a(context, sdkConfig);
                    if (bg(context)) {
                        Log.d("KSAdSDK", "intKSRemoteProcess appId=" + sdkConfig.appId);
                        ServiceProvider.Uc();
                        k.Fo();
                        GJ();
                        this.aGo.set(true);
                    } else {
                        try {
                            q.He();
                            Gx();
                            q.bj(context);
                        } catch (Throwable th) {
                            Log.e("KSAdSDK", "initSDKModule error", th);
                            String stackTraceString = Log.getStackTraceString(th);
                            q.a(th, stackTraceString);
                            f.a(sdkConfig, new e(10002, stackTraceString));
                            return;
                        }
                    }
                }
            } catch (Throwable th2) {
                Log.e("KSAdSDK", "init error", th2);
                String stackTraceString2 = Log.getStackTraceString(th2);
                q.a(th2, stackTraceString2);
                f.a(sdkConfig, new e(10002, stackTraceString2));
            }
            return;
        }
        Log.e("KSAdSDK", "KSAdSDK SDKInit:init error,please check appID and config item");
        f.a(sdkConfig, e.aFO);
    }

    public final <T extends IComponentProxy> T newComponentProxy(Class<?> cls, Object obj) {
        try {
            Class clsG = com.kwad.sdk.service.c.g(cls);
            if (clsG == null) {
                if (obj instanceof BaseProxyActivity) {
                    clsG = com.kwad.components.core.proxy.d.class;
                } else if (obj instanceof BaseProxyFragmentActivity) {
                    clsG = com.kwad.components.core.proxy.e.class;
                }
                com.kwad.components.core.d.a.reportSdkCaughtException(new RuntimeException("--getIsExternal:" + Fu() + "--mIsSdkInit:" + Fx() + "--componentClass" + cls));
            }
            return (T) clsG.newInstance();
        } catch (Exception e) {
            com.kwad.components.core.d.a.reportSdkCaughtException(e);
            com.kwad.sdk.core.d.c.printStackTrace(e);
            return null;
        }
    }

    public final void setAdxEnable(boolean z) {
        this.aGG = z;
    }

    public final void setApiVersion(String str) {
        this.aGu = str;
    }

    public final void setApiVersionCode(int i) {
        this.aGv = i;
    }

    public final void setAppTag(String str) {
        if (this.aGo.get()) {
            ai.ap(ServiceProvider.getContext(), this.aGH);
        } else {
            this.aGH = str;
        }
    }

    public final void setInitStartTime(long j) {
        this.aGz = j;
        com.kwad.sdk.utils.q.setInitStartTime(System.currentTimeMillis());
    }

    public final void setIsExternal(boolean z) {
        this.aGw = z;
    }

    public final void setLaunchTime(long j) {
        this.aGy = j;
        com.kwad.sdk.utils.q.setLaunchTime(j);
    }

    public final void setPersonalRecommend(boolean z) {
        this.aGE = z;
    }

    public final void setProgrammaticRecommend(boolean z) {
        this.aGF = z;
    }

    public final synchronized void start() {
        boolean z;
        try {
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            Log.d("KSAdSDK", "KSAdSDK start call");
            if (this.aGC == null) {
                this.aGC = g.al(this.aGy);
            }
            this.aGC.report();
            SdkConfig sDKConfig = ServiceProvider.getSDKConfig();
            if (Gv()) {
                z = false;
            } else {
                c(sDKConfig);
                z = true;
            }
            if (!this.aGo.get()) {
                f.b(sDKConfig, e.aFP);
                z = true;
            }
            if (this.aGp.get()) {
                c(sDKConfig);
                z = true;
            }
            if (!z) {
                Gy();
                g(new com.kwad.sdk.g.a() { // from class: com.kwad.sdk.o.1
                    @Override // com.kwad.sdk.g.a
                    public final void accept(Object obj) {
                    }
                });
                com.kwad.sdk.a.a.c.Hl().Hn();
                com.kwad.components.core.p.a.vL().vM();
                g gVar = this.aGA;
                if (gVar != null) {
                    gVar.report();
                }
                g gVar2 = this.aGB;
                if (gVar2 != null) {
                    gVar2.report();
                }
                this.aGp.set(true);
                c(sDKConfig);
            }
            com.kwad.sdk.utils.i.schedule(new Runnable() { // from class: com.kwad.sdk.o.3
                @Override // java.lang.Runnable
                public final void run() {
                    if (com.kwad.sdk.core.config.e.Kw()) {
                        com.kwad.sdk.resourceCache.b.cI(o.getContext());
                    }
                }
            }, com.kwad.sdk.core.config.e.Kx(), TimeUnit.SECONDS);
            if (this.aGD == null) {
                this.aGD = g.am(SystemClock.elapsedRealtime() - jElapsedRealtime);
            }
            this.aGC.report();
        } catch (Throwable th) {
            q.s(th);
        }
    }

    public final void unInit() {
        com.kwad.sdk.core.download.b.Lz().bS(getContext());
    }

    private o() {
        this.aGo = new AtomicBoolean(false);
        this.aGp = new AtomicBoolean(false);
        this.aGq = new AtomicBoolean(false);
        this.aGr = new AtomicBoolean(false);
        this.aGs = new AtomicBoolean(false);
        this.aGt = null;
        this.aGu = "";
        this.aGE = true;
        this.aGF = true;
        this.aGG = false;
    }

    public static Object f(String str, Object... objArr) {
        try {
            if ("autoRT".equals(str)) {
                return -1;
            }
            if ("getAutoRevertTime".equals(str)) {
                return 10000;
            }
            boolean z = false;
            if ("TRANSFORM_API_HOST".equals(str)) {
                return com.kwad.sdk.core.network.idc.a.Mo().ab(objArr[0].toString(), "api");
            }
            if ("reportDynamicUpdate".equals(str)) {
                com.kwad.sdk.commercial.c.h((JSONObject) objArr[0]);
                return Boolean.TRUE;
            }
            if (!"enableDynamic".equals(str) || ServiceProvider.Ud() == null) {
                if ("getThrowClassNotFoundSet".equals(str) && com.kwad.sdk.core.config.e.enableInflaterOptimize()) {
                    return com.kwad.sdk.core.config.e.Lb();
                }
                return null;
            }
            if (ba.isInMainProcess(ServiceProvider.Ud()) && com.kwad.framework.a.a.ayM.booleanValue()) {
                z = true;
            }
            return Boolean.valueOf(z);
        } catch (Throwable th) {
            try {
                ServiceProvider.reportSdkCaughtException(th);
            } catch (Throwable unused) {
            }
            return null;
        }
    }

    private static void a(Context context, SdkConfig sdkConfig) {
        if (sdkConfig != null) {
            com.kwad.sdk.service.b.holderSdkConfig(sdkConfig);
        }
        if (context != null) {
            ServiceProvider.cJ(context);
        }
    }

    public static void b(String str, Map<String, String> map, String str2) {
        com.kwad.sdk.core.a.d.a(str, map, str2);
    }
}
