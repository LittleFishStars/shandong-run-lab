package com.kc.dw.core;

import android.content.Context;
import android.os.Build;
import android.renderscript.RenderScript;
import android.text.TextUtils;
import com.baidu.mobads.sdk.api.AdSettings;
import com.beizi.fusion.BeiZis;
import com.bytedance.sdk.openadsdk.TTAdSdk;
import com.bytedance.sdk.openadsdk.api.init.PAGSdk;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.heytap.msp.mobad.api.MobAdManager;
import com.huawei.hms.ads.HwAds;
import com.igexin.assist.util.AssistUtils;
import com.jd.ad.sdk.bl.initsdk.JADYunSdk;
import com.kc.dw.core.domain.SdkAdInfo;
import com.kc.dw.core.safe.j;
import com.kc.dw.core.service.logrecord.d;
import com.kc.dw.core.utils.LogUtil;
import com.kc.dw.core.utils.PackageBean;
import com.kc.dw.core.utils.d0;
import com.kc.dw.core.utils.l;
import com.kc.dw.core.utils.n1;
import com.kc.dw.core.utils.o0;
import com.kc.dw.core.utils.p0;
import com.kc.dw.core.utils.r;
import com.kc.dw.core.utils.s;
import com.kwad.sdk.api.KsAdSDK;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import com.qq.e.comm.managers.status.SDKStatus;
import com.sigmob.windad.WindAds;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class AdSdk extends com.kc.dw.base.a {
    private static final String TAG = "AdSdk";
    private static long initSuccTime = 0;
    private static long initTime = 0;
    public static boolean isTestMode = false;
    private static String local_oaid = null;
    private static String oaid = null;
    private static int oaid_errno = -1;

    @Keep
    public class a extends j {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final SsdAdConfig f39235a;

        public a(SsdAdConfig ssdAdConfig) {
            this.f39235a = ssdAdConfig;
        }

        @Override // com.kc.dw.core.safe.j
        public void safeRun() {
            com.kc.dw.core.s2s.a.a("");
            s.a(com.kc.dw.base.a.context, this.f39235a.getAuthority());
        }
    }

    @Keep
    public class b extends j {

        @Keep
        public class a extends TypeToken<List<PackageBean.DpFlagBean>> {
            public a(b bVar) {
            }
        }

        /* JADX INFO: renamed from: com.kc.dw.core.AdSdk$b$b, reason: collision with other inner class name */
        @Keep
        public class C1022b extends TypeToken<List<String>> {
            public C1022b(b bVar) {
            }
        }

        @Override // com.kc.dw.core.safe.j
        public void safeRun() {
            PackageBean.HappyBean happyBean;
            r.a().a("", "");
            if (r.a().a("inst_uuid", "").isEmpty()) {
                r.a().b("inst_uuid", SsdAdConfig.initUUID());
            }
            try {
                if (TextUtils.isEmpty(com.kc.dw.base.a.getSharedPreferences().getString("install_time", ""))) {
                    com.kc.dw.base.a.getSharedPreferences().edit().putString("install_time", String.valueOf(System.currentTimeMillis())).apply();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            Gson gson = new Gson();
            try {
                p0.h = r.a().a("splshsty", 1);
                String strA = r.a().a("dpflag", "");
                if (!TextUtils.isEmpty(strA)) {
                    p0.i = (List) gson.fromJson(strA, new a(this).getType());
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
            try {
                String strA2 = r.a().a("black_scheme", "");
                if (!TextUtils.isEmpty(strA2)) {
                    com.kc.dw.core.utils.b.f39349a = AdSdk.getStringIntegerHashMap(strA2);
                }
            } catch (Throwable unused) {
            }
            try {
                String strA3 = r.a().a("happybean", "");
                if (!TextUtils.isEmpty(strA3) && (happyBean = (PackageBean.HappyBean) gson.fromJson(strA3, PackageBean.HappyBean.class)) != null) {
                    p0.l = happyBean;
                }
            } catch (Throwable th2) {
                th2.printStackTrace();
            }
            p0.m = r.a().a("dpstay", 2);
            p0.o = Integer.valueOf(r.a().a("field_export", 0));
            p0.q = r.a().a("use_browser", 0);
            p0.s = r.a().a("olp", 0);
            com.kc.dw.core.utils.b.c = r.a().a("syncSave", 0);
            p0.j = r.a().a("shakeTimeout", 0L);
            p0.k = r.a().a("verbosity", 0);
            try {
                String strA4 = r.a().a("pack_ad", "");
                if (!TextUtils.isEmpty(strA4)) {
                    com.kc.dw.core.utils.b.b = (PackageBean.AdBean) gson.fromJson(strA4, PackageBean.AdBean.class);
                }
            } catch (Throwable th3) {
                th3.printStackTrace();
            }
            RenderScript renderScript = d0.f39358a;
            try {
                d0.f39358a = RenderScript.create(com.kc.dw.base.a.getContext());
            } catch (Throwable th4) {
                th4.printStackTrace();
            }
            try {
                String strA5 = r.a().a("jbUrlPrefixes", "");
                if (TextUtils.isEmpty(strA5)) {
                    return;
                }
                p0.r = (List) gson.fromJson(strA5, new C1022b(this).getType());
            } catch (Exception e2) {
                LogUtil.dev(AdSdk.TAG, e2);
            }
        }
    }

    public static IAdManager getAdManager() {
        return new MAdManager();
    }

    public static String getAdmobVersionName() {
        if (com.kc.dw.base.a.adConfig() != null && !com.kc.dw.base.a.adConfig().isUseMediation()) {
            return null;
        }
        try {
            Class.forName("com.google.android.gms.ads.MobileAds").getDeclaredMethod("getVersionString", new Class[0]).setAccessible(true);
            return "21.0.0";
        } catch (Throwable unused) {
            return null;
        }
    }

    public static String getBDVersionName() {
        if (com.kc.dw.base.a.adConfig() != null && !com.kc.dw.base.a.adConfig().isUseMediation()) {
            return null;
        }
        try {
            Class.forName("com.baidu.mobads.sdk.api.SplashInteractionListener");
            return AdSettings.getSDKVersion();
        } catch (Throwable unused) {
            return null;
        }
    }

    public static String getBZVersionName() {
        if (com.kc.dw.base.a.adConfig() != null && !com.kc.dw.base.a.adConfig().isUseMediation()) {
            return null;
        }
        try {
            Class.forName("com.beizi.fusion.BeiZis");
            return BeiZis.getSdkVersion();
        } catch (Throwable unused) {
            return null;
        }
    }

    public static String getCSJVersionName() {
        if (com.kc.dw.base.a.adConfig() != null && !com.kc.dw.base.a.adConfig().isUseMediation()) {
            return null;
        }
        try {
            Class.forName("com.bytedance.sdk.openadsdk.TTAdConstant");
            return TTAdSdk.getAdManager().getSDKVersion();
        } catch (Throwable unused) {
            return null;
        }
    }

    public static String getDuoMengVersionName() {
        if (com.kc.dw.base.a.adConfig() != null && !com.kc.dw.base.a.adConfig().isUseMediation()) {
            return null;
        }
        try {
            Method declaredMethod = Class.forName("com.domob.sdk.l.b").getDeclaredMethod("getSdkVersion", new Class[0]);
            declaredMethod.setAccessible(true);
            return (String) declaredMethod.invoke(null, new Object[0]);
        } catch (Throwable unused) {
            return null;
        }
    }

    public static String getGDTVersionName() {
        if (com.kc.dw.base.a.adConfig() != null && !com.kc.dw.base.a.adConfig().isUseMediation()) {
            return null;
        }
        try {
            return SDKStatus.getIntegrationSDKVersion();
        } catch (Throwable unused) {
            return null;
        }
    }

    public static String getHWVersionName() {
        if (com.kc.dw.base.a.adConfig() != null && !com.kc.dw.base.a.adConfig().isUseMediation()) {
            return null;
        }
        try {
            if (AssistUtils.BRAND_HW.equalsIgnoreCase(Build.MANUFACTURER)) {
                Class.forName("com.huawei.hms.ads.HwAds");
                return HwAds.getSDKVersion();
            }
        } catch (Throwable unused) {
        }
        return null;
    }

    public static long getInitSuccTime() {
        return initSuccTime;
    }

    public static long getInitTime() {
        return initTime;
    }

    public static String getJDVersionName() {
        if (com.kc.dw.base.a.adConfig() != null && !com.kc.dw.base.a.adConfig().isUseMediation()) {
            return null;
        }
        try {
            return JADYunSdk.getSDKVersion();
        } catch (Throwable unused) {
            return null;
        }
    }

    public static String getKSVersionName() {
        if (com.kc.dw.base.a.adConfig() != null && !com.kc.dw.base.a.adConfig().isUseMediation()) {
            return null;
        }
        try {
            Class.forName("com.kwad.sdk.api.KsAdSDK");
            return KsAdSDK.getSDKVersion();
        } catch (Throwable unused) {
            return null;
        }
    }

    public static String getLocalOaid() {
        String str = l.f39380a;
        local_oaid = str;
        if ((TextUtils.isEmpty(str) || "unknown".equals(local_oaid)) && com.kc.dw.base.a.adConfig() != null && com.kc.dw.base.a.adConfig().customController() != null) {
            local_oaid = com.kc.dw.base.a.adConfig().customController().getOaid();
        }
        return local_oaid;
    }

    public static String getMimoVersionName() {
        if (com.kc.dw.base.a.adConfig() != null && !com.kc.dw.base.a.adConfig().isUseMediation()) {
            return null;
        }
        try {
            if ("Xiaomi".equalsIgnoreCase(Build.MANUFACTURER)) {
                Class.forName("com.miui.zeus.mimo.sdk.BuildConfig");
                return "5.1.7";
            }
        } catch (Throwable unused) {
        }
        return null;
    }

    public static String getOPPOVersionName() {
        if (com.kc.dw.base.a.adConfig() != null && !com.kc.dw.base.a.adConfig().isUseMediation()) {
            return null;
        }
        try {
            if ("OPPO".equalsIgnoreCase(Build.MANUFACTURER)) {
                Class.forName("com.heytap.msp.mobad.api.MobAdManager");
                return MobAdManager.getInstance().getSdkVerName();
            }
        } catch (Throwable unused) {
        }
        return null;
    }

    public static String getOaid() {
        String str = l.f39380a;
        oaid = str;
        if (TextUtils.isEmpty(str) && com.kc.dw.base.a.adConfig() != null && com.kc.dw.base.a.adConfig().customController() != null) {
            oaid = com.kc.dw.base.a.adConfig().customController().getOaid();
        }
        return oaid;
    }

    public static int getOaid_errno() {
        return oaid_errno;
    }

    public static String getPangleVersionName() {
        if (com.kc.dw.base.a.adConfig() != null && !com.kc.dw.base.a.adConfig().isUseMediation()) {
            return null;
        }
        try {
            Class.forName("com.bytedance.sdk.openadsdk.api.init.PAGSdk");
            return PAGSdk.getSDKVersion();
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public static String getSGMVersionName() {
        if (com.kc.dw.base.a.adConfig() != null && !com.kc.dw.base.a.adConfig().isUseMediation()) {
            return null;
        }
        try {
            Class.forName("com.sigmob.windad.WindAds");
            return WindAds.getVersion();
        } catch (Throwable unused) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static HashMap<String, Integer> getStringIntegerHashMap(String str) throws JSONException {
        HashMap<String, Integer> map = new HashMap<>();
        JSONObject jSONObject = new JSONObject(str.toString());
        Iterator<String> itKeys = jSONObject.keys();
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            map.put(next, (Integer) jSONObject.get(next));
        }
        return map;
    }

    public static String getVersionName() {
        return "3.0.4.0";
    }

    public static String getWxVersionName() {
        try {
            return "" + com.kc.dw.base.a.getContext().getPackageManager().getApplicationInfo("com.tencent.mm", 128).metaData.getInt("com.tencent.mm.BuildInfo.OPEN_SDK_VERSION", 0);
        } catch (Throwable unused) {
            return null;
        }
    }

    public static void init(Context context, SsdAdConfig ssdAdConfig) {
        try {
            if (com.kc.dw.base.a.adConfig != null) {
                return;
            }
            if (ssdAdConfig == null) {
                throw new IllegalArgumentException("config is null");
            }
            initTime = System.currentTimeMillis();
            com.kc.dw.base.a.context = context.getApplicationContext();
            com.kc.dw.base.a.adConfig = ssdAdConfig;
            o0.a();
            com.kc.dw.core.router.a.a(com.kc.dw.core.router.service.b.class, new com.kc.dw.core.service.a());
            com.kc.dw.core.router.a.a(com.kc.dw.core.router.service.c.class, new d());
            com.kc.dw.core.service.logrecord.a.a(5, "e0", null);
            new Thread(new a(ssdAdConfig)).start();
            setInstallTime();
            initSuccTime = System.currentTimeMillis();
        } catch (Exception e) {
            com.kc.dw.base.a.adConfig = null;
            e.printStackTrace();
            LogUtil.e(TAG, "SDK INIT ERROR");
        }
    }

    /* JADX WARN: Code duplicated, block: B:40:0x0099  */
    private static void initOtherSdks() {
        byte b2;
        if (com.kc.dw.base.a.adConfig() == null || !com.kc.dw.base.a.adConfig().isUseMediation() || com.kc.dw.base.a.adConfig().getInitSdkMap() == null) {
            return;
        }
        for (Map.Entry<String, Object> entry : com.kc.dw.base.a.adConfig().getInitSdkMap().entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();
            if (value instanceof String) {
                String str = (String) value;
                if (!TextUtils.isEmpty(key) && !TextUtils.isEmpty(str)) {
                    key.getClass();
                    int iHashCode = key.hashCode();
                    if (iHashCode != 2408) {
                        if (iHashCode != 67034) {
                            if (iHashCode != 70423) {
                                if (iHashCode == 62961147 && key.equals("BAIDU")) {
                                    b2 = 3;
                                } else {
                                    b2 = -1;
                                }
                            } else if (key.equals("GDT")) {
                                b2 = 2;
                            } else {
                                b2 = -1;
                            }
                        } else if (key.equals("CSJ")) {
                            b2 = 1;
                        } else {
                            b2 = -1;
                        }
                    } else if (key.equals("KS")) {
                        b2 = 0;
                    } else {
                        b2 = -1;
                    }
                    if (b2 == 0) {
                        throw null;
                    }
                    if (b2 == 1) {
                        throw null;
                    }
                    if (b2 == 2) {
                        throw null;
                    }
                    if (b2 == 3) {
                        throw null;
                    }
                }
            } else if (value instanceof Map) {
                try {
                    if (((Boolean) ((Map) value).get("isUseMediation")).booleanValue()) {
                        n1.b = true;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void initSdkIfNot(Context context, SdkAdInfo sdkAdInfo) {
        sdkAdInfo.getSdk();
        throw null;
    }

    private static void setInstallTime() {
        new Thread(new b()).start();
    }

    public static void setOaid_errno(int i) {
        oaid_errno = i;
    }
}
