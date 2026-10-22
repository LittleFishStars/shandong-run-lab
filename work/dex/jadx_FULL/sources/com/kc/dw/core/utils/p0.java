package com.kc.dw.core.utils;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Log;
import com.alibaba.android.arouter.utils.Consts;
import com.aliyun.vod.log.struct.AliyunLogKey;
import com.bykv.vk.component.ttvideo.player.MediaFormat;
import com.google.gson.Gson;
import com.huachenjie.common.constants.UserConstants;
import com.kc.dw.core.AdSdk;
import com.kc.dw.core.SsdAdConfig;
import com.kc.dw.core.loader.AdParallelLoader;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import com.zj.adlib.dv9;
import com.zj.adlib.ze1;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;
import okhttp3.ResponseBody;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class p0 extends com.kc.dw.core.utils.b {
    public static String d = null;
    public static PckIdBean e = null;
    public static String f = null;
    public static PackageBean.DClick g = null;
    public static int h = 1;
    public static List<PackageBean.DpFlagBean> i = null;
    public static long j = 0;
    public static int k = 0;
    public static PackageBean.HappyBean l = null;
    public static int m = 0;
    public static int n = 3;
    public static Integer o;
    public static PackageBean.LogBean p;
    public static int q;
    public static List<String> r;
    public static int s;

    @Keep
    public class a implements Callback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Context f39394a;

        public a(Context context) {
            this.f39394a = context;
        }

        public void onFailure(Call call, IOException iOException) {
            try {
                PackageBean packageBean = o0.a().b;
                if (packageBean != null) {
                    p0.a(this.f39394a, packageBean, false);
                    i.a(packageBean.getDefImages());
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        public void onResponse(Call call, Response response) throws IOException {
            PackageBean packageBean;
            try {
                Gson gson = new Gson();
                boolean z = true;
                if (response.code() == 200) {
                    ResponseBody responseBodyBody = response.body();
                    String strDecryptBody = "";
                    if (responseBodyBody != null) {
                        try {
                            strDecryptBody = com.kc.dw.core.loader.a.decryptBody(responseBodyBody.bytes());
                            if (strDecryptBody == null) {
                                strDecryptBody = responseBodyBody.string();
                            }
                        } catch (Throwable th) {
                            th.printStackTrace();
                        }
                    }
                    packageBean = (PackageBean) gson.fromJson(strDecryptBody, PackageBean.class);
                } else if (response.code() == 304) {
                    packageBean = o0.a().b;
                    z = false;
                } else {
                    packageBean = null;
                }
                if (packageBean != null) {
                    p0.g = packageBean.getDclk();
                    p0.j = packageBean.getShakeTimeout();
                    p0.a(this.f39394a, packageBean, z);
                    i.a(packageBean.getDefImages());
                    String json = gson.toJson(p0.g);
                    com.kc.dw.base.a.getSharedPreferences().edit().putString("dclk", json).apply();
                    r.a().b("dclk", json);
                    com.kc.dw.base.a.getSharedPreferences().edit().putLong("shakeTimeout", p0.j).apply();
                    r.a().b("shakeTimeout", p0.j);
                    p0.k = packageBean.getVerbosity();
                    com.kc.dw.base.a.getSharedPreferences().edit().putInt("verbosity", packageBean.getVerbosity()).apply();
                    r.a().b("verbosity", packageBean.getVerbosity());
                    PackageBean.HappyBean happy = packageBean.getHappy();
                    p0.l = happy;
                    if (happy != null) {
                        String json2 = gson.toJson(happy);
                        com.kc.dw.base.a.getSharedPreferences().edit().putString("happybean", json2).apply();
                        r.a().b("happybean", json2);
                    }
                    p0.p = packageBean.getLog();
                    p0.n = packageBean.getUseHttps();
                    r.a().b("useHttps", p0.n);
                    int dpstay = packageBean.getDpstay();
                    p0.m = dpstay;
                    if (dpstay > 0) {
                        com.kc.dw.base.a.getSharedPreferences().edit().putInt("dpstay", p0.m).apply();
                        r.a().b("dpstay", p0.m);
                    }
                    PackageBean.AdBean ad = packageBean.getAd();
                    com.kc.dw.core.utils.b.b = ad;
                    if (ad != null) {
                        r.a().b("pack_ad", gson.toJson(com.kc.dw.core.utils.b.b));
                    }
                    Integer fieldExport = packageBean.getFieldExport();
                    p0.o = fieldExport;
                    if (fieldExport != null && fieldExport.intValue() > 0) {
                        r.a().b("field_export", p0.o.intValue());
                    }
                    int useBrowser = packageBean.getUseBrowser();
                    p0.q = useBrowser;
                    if (useBrowser > 0) {
                        r.a().b("use_browser", p0.q);
                    }
                    int olp = packageBean.getOlp();
                    p0.s = olp;
                    if (olp > 0) {
                        r.a().b("olp", p0.s);
                    }
                    if (packageBean.getDefImages() != null) {
                        List<String> defImages = packageBean.getDefImages();
                        ExecutorService executorService = f0.f39362a;
                        f0.b.f39363a.a(new q0(defImages));
                    }
                    List<String> jbUrlPrefixes = packageBean.getJbUrlPrefixes();
                    p0.r = jbUrlPrefixes;
                    if (jbUrlPrefixes == null || jbUrlPrefixes.isEmpty()) {
                        r rVarA = r.a();
                        rVarA.getClass();
                        try {
                            rVarA.b.remove("jbUrlPrefixes");
                            rVarA.d();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    } else {
                        r.a().b("jbUrlPrefixes", gson.toJson(p0.r));
                    }
                    com.kc.dw.core.utils.b.c = packageBean.getSyncSave();
                    r.a().b("syncSave", com.kc.dw.core.utils.b.c);
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    @Keep
    public class b implements y<n0> {
        @Override // com.kc.dw.core.utils.y
        public /* bridge */ /* synthetic */ void a(n0 n0Var) throws IOException {
        }

        @Override // com.kc.dw.core.utils.y
        public void onFailure(IOException iOException) {
        }
    }

    public static int a(int i2) {
        PackageBean.LogBean logBeanB = com.kc.dw.core.utils.b.b();
        p = logBeanB;
        return (logBeanB == null || logBeanB.getLogSize() == null) ? i2 : p.getLogSize().intValue();
    }

    public static PckIdBean a(List list) {
        StringBuilder sb = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        if (list != null && list.size() > 0) {
            for (int i2 = 0; i2 < list.size(); i2++) {
                PackageBean.AppBean.PackBean packBean = (PackageBean.AppBean.PackBean) list.get(i2);
                if (!TextUtils.isEmpty(packBean.getId())) {
                    d dVar = d.b.f39357a;
                    dVar.getClass();
                    Boolean bool = null;
                    if (!TextUtils.isEmpty(packBean.getId())) {
                        if (dVar.f39355a.isEmpty()) {
                            synchronized (dVar.m) {
                                dVar.a((PackageBean) null);
                            }
                        }
                        String id = packBean.getId();
                        try {
                            if (dVar.b.containsKey(id)) {
                                bool = dVar.b.get(id);
                            }
                        } catch (Throwable unused) {
                        }
                    }
                    if (bool != null) {
                        if (bool.booleanValue()) {
                            if (sb.length() > 0) {
                                sb.append(Consts.DOT);
                            }
                            sb.append(packBean.getId());
                        } else {
                            if (sb2.length() > 0) {
                                sb2.append(Consts.DOT);
                            }
                            sb2.append(packBean.getId());
                        }
                    }
                }
            }
        }
        PckIdBean pckIdBean = new PckIdBean();
        pckIdBean.setApp_y(sb.toString());
        pckIdBean.setApp_n(sb2.toString());
        return pckIdBean;
    }

    /* JADX WARN: Code duplicated, block: B:35:0x0103  */
    public static String a(Context context, PckIdBean pckIdBean, String str) {
        HashMap map = new HashMap();
        if (com.kc.dw.base.a.adConfig() != null) {
            map.put("app_id", com.kc.dw.base.a.adConfig().appId());
        }
        if (!TextUtils.isEmpty("3.0.4.0")) {
            map.put("sdk_version", "3.0.4.0");
            map.put("sdk_version_code", Long.toString(3000400L));
        }
        b(context);
        if (!TextUtils.isEmpty(d)) {
            map.put("app_package", d);
        }
        String str2 = Build.MANUFACTURER;
        if (!TextUtils.isEmpty(str2)) {
            map.put("device_manufacturer", str2);
        }
        String str3 = Build.BRAND;
        if (!TextUtils.isEmpty(str3)) {
            map.put("device_brand", str3);
        }
        String str4 = Build.MODEL;
        if (!TextUtils.isEmpty(str4)) {
            map.put("device_model", str4);
        }
        Locale locale = context.getResources().getConfiguration().locale;
        if (locale != null) {
            map.put(ze1.s, locale.getCountry());
            map.put(MediaFormat.KEY_LANGUAGE, locale.getLanguage());
        }
        map.put("init_uuid", SsdAdConfig.initUUID());
        map.put("inst_uuid", r.a().a("inst_uuid", ""));
        map.put("init_time", Long.toString(SsdAdConfig.initTime()));
        map.put("ver", str);
        if (!TextUtils.isEmpty(AdSdk.getLocalOaid())) {
            map.put("device_oaid", AdSdk.getLocalOaid());
        }
        if (com.kc.dw.base.a.adConfig() == null || com.kc.dw.base.a.adConfig().customController() == null) {
            w0.b(context);
        } else if (com.kc.dw.base.a.adConfig().customController().getAndroidId() != null) {
            f = com.kc.dw.base.a.adConfig().customController().getAndroidId();
        } else if (com.kc.dw.base.a.adConfig().customController().isCanUseAndroidId()) {
            w0.b(context);
        }
        if (!TextUtils.isEmpty(f)) {
            map.put("device_adid", f);
        }
        String app_y = e.getApp_y();
        if (!TextUtils.isEmpty(pckIdBean.getApp_y())) {
            app_y = app_y + Consts.DOT + pckIdBean.getApp_y();
        }
        String app_n = e.getApp_n();
        if (!TextUtils.isEmpty(pckIdBean.getApp_n())) {
            app_n = app_n + Consts.DOT + pckIdBean.getApp_n();
        }
        if (!TextUtils.isEmpty(app_y)) {
            if (app_y.startsWith(Consts.DOT)) {
                app_y = app_y.substring(1);
            }
            map.put("app_y", app_y);
        }
        if (!TextUtils.isEmpty(app_n)) {
            if (app_n.startsWith(Consts.DOT)) {
                app_n = app_n.substring(1);
            }
            map.put(AliyunLogKey.KEY_APP_NAME, app_n);
        }
        DisplayMetrics displayMetricsN = w0.n(context);
        map.put("device_ppi", String.valueOf(displayMetricsN.densityDpi));
        map.put("device_width", String.valueOf(displayMetricsN.widthPixels));
        map.put("device_height", String.valueOf(displayMetricsN.heightPixels));
        map.put("device_density", String.valueOf(displayMetricsN.density));
        return new Gson().toJson(map);
    }

    public static void a(Context context) {
        byte[] bytes;
        try {
            try {
                bytes = v.f39411a.toJson(c(context)).getBytes();
            } catch (Exception e2) {
                e2.printStackTrace();
                bytes = null;
            }
            if (bytes != null && bytes.length != 0) {
                Map<String, String> mapWrapParams = AdParallelLoader.wrapParams(bytes);
                if (mapWrapParams != null && !mapWrapParams.isEmpty()) {
                    z.a(w0.a("https://sdk.1rtb.net/sdk/config/v3", mapWrapParams), new a(context));
                    return;
                }
                Log.e("PackConfigUtil", "map is null, continue");
            }
        } catch (Throwable unused) {
        }
    }

    public static void a(Context context, PackageBean packageBean) {
        if (packageBean != null) {
            try {
                if (packageBean.getApp() == null) {
                    return;
                }
                PackageBean.AppBean app = packageBean.getApp();
                String url = app.getUrl();
                String ver = packageBean.getVer();
                List<PackageBean.AppBean.PackBean> required = app.getRequired();
                List<PackageBean.AppBean.PackBean> others = app.getOthers();
                if ((required == null || required.isEmpty()) && (others == null || others.isEmpty())) {
                    return;
                }
                a(context, required, others, app.getTtl(), ver, url);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public static void a(Context context, PackageBean packageBean, boolean z) {
        PackageBean.SplashBean sty = packageBean.getSty();
        if (sty != null) {
            h = sty.getV();
            com.kc.dw.base.a.getSharedPreferences().edit().putInt("splshsty", h).apply();
            r.a().b("splshsty", h);
        }
        try {
            HashMap<String, Integer> webviewLimitedSchemes = packageBean.getWebviewLimitedSchemes();
            if (webviewLimitedSchemes != null) {
                com.kc.dw.core.utils.b.f39349a = webviewLimitedSchemes;
                String json = new Gson().toJson(webviewLimitedSchemes);
                com.kc.dw.base.a.getSharedPreferences().edit().putString("black_scheme", json).apply();
                r.a().b("black_scheme", json);
            }
        } catch (Throwable unused) {
        }
        try {
            List<PackageBean.DpFlagBean> dpflag = packageBean.getDpflag();
            if (dpflag != null) {
                i = dpflag;
                String json2 = new Gson().toJson(dpflag);
                com.kc.dw.base.a.getSharedPreferences().edit().putString("dpflag", json2).apply();
                r.a().b("dpflag", json2);
            }
        } catch (Throwable unused2) {
        }
        if (packageBean.getApp() != null) {
            if (z) {
                d dVar = d.b.f39357a;
                synchronized (dVar.m) {
                    dVar.a(packageBean);
                }
            }
            d.b.f39357a.a(false, true);
        }
        o0 o0VarA = o0.a();
        o0VarA.getClass();
        try {
            o0VarA.b = packageBean;
            o0VarA.a(v.f39411a.toJson(packageBean));
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static void a(Context context, List<PackageBean.AppBean.PackBean> list, List<PackageBean.AppBean.PackBean> list2, Integer num, String str, String str2) {
        try {
            num.intValue();
            e = a(list);
            num.intValue();
            String strB = d1.b(a(context, a(list2), str));
            HashMap map = new HashMap();
            map.put("data", strB);
            if (!TextUtils.isEmpty(str2)) {
                z.a(str2, null, map, null, new b());
            }
            String json = new Gson().toJson(e);
            com.kc.dw.base.a.getSharedPreferences().edit().putString("pck_id_bean", json).apply();
            r.a().b("pck_id_bean", json);
        } catch (Throwable unused) {
        }
    }

    public static boolean a(Context context, int i2, PackageBean.AppBean.PackBean packBean) {
        boolean z = false;
        if (packBean == null || context == null) {
            return false;
        }
        String query = packBean.getQuery();
        try {
            if (TextUtils.isEmpty(query) || query.contains("://")) {
                Intent uri = Intent.parseUri(query, 0);
                uri.addCategory("android.intent.category.BROWSABLE");
                uri.setComponent(null);
                uri.setSelector(null);
                if (uri.resolveActivity(com.kc.dw.base.a.getContext().getPackageManager()) != null) {
                    z = true;
                }
            } else if (context.getPackageManager().getPackageInfo(query, 256) != null) {
                z = true;
            }
        } catch (Exception unused) {
        }
        if (!TextUtils.isEmpty(packBean.getId())) {
            packBean.setInstalled(z);
        }
        packBean.setLastCheckTime(System.currentTimeMillis());
        packBean.setExpirationTime((((long) i2) * 1000) + packBean.getLastCheckTime());
        return true;
    }

    public static String b(Context context) {
        if (TextUtils.isEmpty(d)) {
            try {
                d = context.getPackageName();
            } catch (Exception unused) {
            }
        }
        return d;
    }

    public static Map<String, Object> c(Context context) {
        HashMap map = new HashMap();
        try {
            PackageBean packageBean = o0.a().b;
            if (packageBean != null && !TextUtils.isEmpty(packageBean.getVer())) {
                map.put("ver", packageBean.getVer());
            }
            Locale locale = context.getResources().getConfiguration().locale;
            if (locale != null) {
                map.put(ze1.s, locale.getCountry());
                map.put(dv9.h, locale.getLanguage());
            }
            map.put("init_time", Long.valueOf(AdSdk.getInitTime()));
            String str = "";
            map.put("app_id", Integer.valueOf(o1.a(com.kc.dw.base.a.adConfig() != null ? com.kc.dw.base.a.adConfig().appId() : "", 0)));
            map.put("network", Integer.valueOf(o1.a(w0.F, 0)));
            map.put("os", 2);
            map.put("commit", "a0b7cd6f");
            map.put("oem", "1005");
            map.put("sdk_code", 3000400L);
            map.put("app_ver", w0.o(com.kc.dw.base.a.getContext()));
            String strB = b(com.kc.dw.base.a.getContext());
            if (strB == null) {
                strB = "";
            }
            map.put("app_pkg", strB);
            map.put(ze1.p, Build.MANUFACTURER);
            map.put("brand", Build.BRAND);
            map.put(ze1.k, Build.MODEL);
            map.put("device_type", Integer.valueOf(k.a()));
            map.put("inst_uuid", r.a().a("inst_uuid", ""));
            map.put("init_uuid", SsdAdConfig.initUUID());
            HashMap map2 = new HashMap(4);
            if (!TextUtils.isEmpty(AdSdk.getLocalOaid())) {
                map2.put("a", AdSdk.getLocalOaid());
            }
            String strC = w0.c(com.kc.dw.base.a.getContext());
            if (strC != null) {
                str = strC;
            }
            map2.put("b", str);
            map.put(UserConstants.URL_PARAMS.b, map2);
            map.put("gzip_crypt_key", com.kc.dw.core.loader.a.getCryptKeyStr());
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return map;
    }

    public static boolean e() {
        try {
            PackageBean.AdBean adBean = com.kc.dw.core.utils.b.b;
            return (adBean == null || adBean.getFeed() == null || com.kc.dw.core.utils.b.b.getFeed().getUseOldStyle() != 1) ? false : true;
        } catch (Exception unused) {
            return false;
        }
    }
}
