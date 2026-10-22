package com.byazt.aas;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageInfo;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.Looper;
import android.os.StatFs;
import android.taobao.windvane.util.WVNativeCallbackUtil;
import android.text.TextUtils;
import androidx.camera.video.AudioStats;
import com.alibaba.ariver.kernel.RVParams;
import com.aliyun.svideosdk.common.struct.common.CropKey;
import com.baidu.mapapi.SDKInitializer;
import com.beizi.fusion.asnp.adn.ad.model.impl.resp.ad3.ad.nativ.NativeModel;
import com.byazt.ete.dz;
import com.byazt.ete.hq;
import com.byazt.ete.ic;
import com.byazt.ete.ma;
import com.byazt.ete.pu;
import com.byazt.ete.xd;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bytedance.component.sdk.annotation.HungeonFlag;
import com.huachenjie.common.constants.UserConstants;
import com.igexin.push.core.b;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FilenameFilter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.TimeZone;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
@com.byazt.zqa.c(c = {0, 1, 131, MediaPlayer.MEDIA_PLAYER_OPTION_DISABLE_ALGORITHM})
public class nb {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile long f28275a = 0;
    public static volatile int c = 0;
    public static volatile long n = 0;
    public static long sl = -1;
    public static volatile long sp = 0;
    public static volatile boolean t = false;
    public static volatile int tt = 0;
    public static volatile int u = 0;
    public static volatile String uj = null;
    public static volatile int ve = 0;
    public static volatile int x = -1;
    public static String z;
    public static final AtomicBoolean yp = new AtomicBoolean(false);
    public static volatile String m = null;
    public static volatile String nu = null;
    public static volatile String rh = null;
    public static String i = null;
    public static String da = null;

    /* JADX INFO: renamed from: com.byazt.aas.nb$2, reason: invalid class name */
    @com.byazt.zqa.c(c = {0, 1, 131, 2492})
    public static class AnonymousClass2 implements FilenameFilter {
        public Pattern c = Pattern.compile("^cpu[0-9]+$");

        @Override // java.io.FilenameFilter
        public boolean accept(File file, String str) {
            return this.c.matcher(str).matches();
        }
    }

    public static boolean a(ic icVar) {
        int iSl = sl(icVar);
        return iSl == 3 || iSl == 4 || iSl == 9 || iSl == 7 || iSl == 8;
    }

    public static String c(int i2) {
        switch (i2) {
            case 1:
                return "embeded_ad_landingpage";
            case 2:
                return "banner_ad_landingpage";
            case 3:
                return "interaction_landingpage";
            case 4:
                return "splash_ad_landingpage";
            case 5:
                return "fullscreen_interstitial_ad_landingpage";
            case 6:
                return "draw_ad_landingpage";
            case 7:
                return "rewarded_video_landingpage";
            default:
                return null;
        }
    }

    public static boolean c(Context context, String str) {
        Intent intentTt;
        if (context != null && !TextUtils.isEmpty(str)) {
            try {
                if (yv()) {
                    if (!tt(str) || (intentTt = tt(context, str)) == null) {
                        return false;
                    }
                    intentTt.putExtra("START_ONLY_FOR_ANDROID", true);
                    com.byazt.nr.tt.c(context, intentTt, null);
                    return true;
                }
                Intent intentTt2 = tt(context, str);
                if (intentTt2 == null) {
                    return false;
                }
                intentTt2.putExtra("START_ONLY_FOR_ANDROID", true);
                context.startActivity(intentTt2);
                return true;
            } catch (Throwable unused) {
            }
        }
        return false;
    }

    public static String da(ic icVar) {
        com.byazt.ete.nu nuVarYp;
        if (icVar == null || (nuVarYp = icVar.yp()) == null) {
            return null;
        }
        return nuVarYp.tt();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void eo() {
        List<String> listEn;
        com.byazt.ogz.sl slVarTt = com.byazt.omf.gt.tt();
        if (com.byazt.omf.x.m().lo()) {
            com.byazt.omf.x.m().i(false);
            return;
        }
        if (slVarTt.k() || (listEn = slVarTt.en()) == null) {
            return;
        }
        int iIy = slVarTt.iy();
        for (int i2 = 0; i2 < iIy && i2 < listEn.size(); i2++) {
            Uri uri = Uri.parse(listEn.get(i2));
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setData(uri);
            c(intent, true);
        }
    }

    public static boolean gr(ic icVar) {
        if (icVar == null) {
            return true;
        }
        int iA = com.byazt.omf.gt.tt().a(t(icVar));
        if (iA == 1) {
            return com.byazt.nr.rh.uj(com.byazt.omf.gt.getContext());
        }
        if (iA == 2) {
            return com.byazt.nr.rh.n(com.byazt.omf.gt.getContext()) || com.byazt.nr.rh.uj(com.byazt.omf.gt.getContext()) || com.byazt.nr.rh.a(com.byazt.omf.gt.getContext());
        }
        if (iA != 3) {
            return iA != 5 || com.byazt.nr.rh.uj(com.byazt.omf.gt.getContext()) || com.byazt.nr.rh.a(com.byazt.omf.gt.getContext());
        }
        return false;
    }

    public static String gt(ic icVar) {
        if (icVar.z() != null && !TextUtils.isEmpty(icVar.z().ve())) {
            return icVar.z().ve();
        }
        if (TextUtils.isEmpty(icVar.an())) {
            return !TextUtils.isEmpty(icVar.v_()) ? icVar.v_() : "";
        }
        return icVar.an();
    }

    public static boolean gu() {
        try {
            return new File("/system/bin/su").exists() || new File("/system/xbin/su").exists();
        } catch (Throwable unused) {
            return false;
        }
    }

    public static void h() {
        String strEy = com.byazt.omf.gt.tt().ey();
        try {
            Matcher matcher = Pattern.compile("\\|\\|([a-zA-Z0-9.-]+)\\^").matcher(strEy);
            while (matcher.find()) {
                String strGroup = matcher.group(1);
                if (!TextUtils.isEmpty(strGroup)) {
                    com.byazt.ete.cu.c.add(strGroup);
                }
            }
        } catch (Throwable unused) {
        }
        if (TextUtils.isEmpty(strEy)) {
            return;
        }
        Set<String> set = com.byazt.ete.cu.c;
        if (set.isEmpty()) {
            set.add("empty");
        }
    }

    public static boolean i(ic icVar) {
        JSONObject jSONObjectQ_;
        if (icVar == null || (jSONObjectQ_ = icVar.q_()) == null) {
            return false;
        }
        try {
            int iOptInt = new JSONObject(jSONObjectQ_.optString("compliance_data")).optJSONObject("ad").optInt("pricing_type");
            return iOptInt == 3 || iOptInt == 6;
        } catch (Exception e) {
            com.byazt.nr.m.uj("ToolUtils", "error:" + e.getMessage());
            return false;
        }
    }

    public static String m(ic icVar) {
        JSONObject jSONObjectQ_ = icVar.q_();
        return jSONObjectQ_ != null ? jSONObjectQ_.optString("req_id", "") : "";
    }

    public static String md(ic icVar) {
        if (icVar == null) {
            return null;
        }
        JSONObject jSONObjectUr = icVar.ur();
        String strOptString = jSONObjectUr != null ? jSONObjectUr.optString(b.aC) : null;
        return TextUtils.isEmpty(strOptString) ? p(icVar) : strOptString;
    }

    public static String my(ic icVar) {
        if (icVar == null) {
            return "";
        }
        com.byazt.ete.n nVarZ = icVar.z();
        String strTt = nVarZ != null ? nVarZ.tt() : null;
        return TextUtils.isEmpty(strTt) ? icVar.l() : strTt;
    }

    public static int n(int i2) {
        if (i2 == 1) {
            return 2;
        }
        if (i2 != 2) {
            return (i2 == 3 || i2 == 4 || i2 == 7 || i2 == 8) ? 5 : 3;
        }
        return 4;
    }

    public static JSONObject n(String str) {
        if (TextUtils.isEmpty(str) || str == null || str.isEmpty()) {
            return null;
        }
        try {
            return new JSONObject(str);
        } catch (JSONException e) {
            com.byazt.nr.m.c(e);
            return null;
        }
    }

    public static int nu(ic icVar) {
        JSONObject jSONObjectQ_ = icVar.q_();
        if (jSONObjectQ_ != null) {
            return jSONObjectQ_.optInt("pricing", 0);
        }
        return 0;
    }

    public static String p(ic icVar) {
        Object obj;
        if (icVar == null) {
            return "";
        }
        com.byazt.ete.a aVarRh = icVar.rh();
        String strU = aVarRh != null ? aVarRh.u() : "";
        if (!TextUtils.isEmpty(strU)) {
            return strU;
        }
        com.byazt.ete.n nVarZ = icVar.z();
        if (nVarZ != null) {
            strU = nVarZ.uj();
        }
        if (!TextUtils.isEmpty(strU)) {
            return strU;
        }
        Map<String, Object> mapYt = icVar.yt();
        if (mapYt != null && (obj = mapYt.get("ad_package_name")) != null) {
            strU = obj.toString();
        }
        return !TextUtils.isEmpty(strU) ? strU : icVar.ls();
    }

    public static int qy() {
        if (x >= 0) {
            return x;
        }
        int iTt = com.byazt.by.uj.c().tt("is_root", -1);
        x = iTt;
        return iTt;
    }

    public static int rh(ic icVar) {
        JSONObject jSONObjectQ_ = icVar.q_();
        if (jSONObjectQ_ != null) {
            return jSONObjectQ_.optInt("price", 0);
        }
        return 0;
    }

    public static String rl(ic icVar) {
        if (TextUtils.isEmpty(icVar.v_())) {
            return !TextUtils.isEmpty(icVar.op()) ? icVar.op() : "";
        }
        return icVar.v_();
    }

    public static int sl(ic icVar) {
        JSONObject jSONObjectQ_;
        if (icVar == null || (jSONObjectQ_ = icVar.q_()) == null) {
            return 0;
        }
        return jSONObjectQ_.optInt("ad_slot_type", 0);
    }

    public static boolean sp(ic icVar) {
        if (icVar == null) {
            return false;
        }
        int iSl = sl(icVar);
        return iSl == 5 || iSl == 1 || iSl == 2;
    }

    public static int t(ic icVar) {
        JSONObject jSONObjectQ_;
        if (icVar == null || (jSONObjectQ_ = icVar.q_()) == null) {
            return 0;
        }
        return jSONObjectQ_.optInt("rit", 0);
    }

    public static Intent tt(Context context, String str) {
        Intent launchIntentForPackage = context.getPackageManager().getLaunchIntentForPackage(str);
        if (launchIntentForPackage == null) {
            return null;
        }
        if (Build.VERSION.SDK_INT < 33 && !launchIntentForPackage.hasCategory("android.intent.category.LAUNCHER")) {
            launchIntentForPackage.addCategory("android.intent.category.LAUNCHER");
        }
        launchIntentForPackage.setPackage(null);
        launchIntentForPackage.addFlags(2097152);
        launchIntentForPackage.addFlags(268435456);
        return launchIntentForPackage;
    }

    public static String tt(int i2) {
        switch (i2) {
            case 1:
                return com.byazt.dyf.tt.AD_TAG_BANNER;
            case 2:
                return "interaction";
            case 3:
            case 4:
                return "splash_ad";
            case 5:
            default:
                return com.byazt.dyf.tt.AD_TAG_FEED;
            case 6:
                return "stream";
            case 7:
                return "rewarded_video";
            case 8:
                return "fullscreen_interstitial_ad";
            case 9:
                return "draw_ad";
        }
    }

    public static String u(ic icVar) {
        JSONObject jSONObjectQ_ = icVar.q_();
        return jSONObjectQ_ != null ? jSONObjectQ_.optString("origin_req_id", "") : "";
    }

    private static boolean uj(Intent intent) {
        try {
            List<ResolveInfo> listC = x.c(intent, 65536);
            return listC != null && listC.size() > 0;
        } catch (Throwable unused) {
        }
    }

    public static boolean ve(String str) {
        String[] strArr = {"data", "media", "obb"};
        for (int i2 = 0; i2 < 3; i2++) {
            if (c(strArr[i2], str).exists()) {
                return true;
            }
        }
        return false;
    }

    public static boolean x(ic icVar) {
        if (icVar == null) {
            return false;
        }
        int iSl = sl(icVar);
        return iSl == 3 || iSl == 4;
    }

    public static String yp(ic icVar) {
        JSONObject jSONObjectQ_ = icVar.q_();
        return jSONObjectQ_ != null ? jSONObjectQ_.optString("customer_id", "") : "";
    }

    public static boolean yv(ic icVar) {
        return icVar != null && TextUtils.equals(icVar.gu(), icVar.uj()) && icVar.i() == 3 && !TextUtils.isEmpty(p(icVar));
    }

    public static double z(ic icVar) {
        return ve(icVar.q_());
    }

    private static boolean zb() {
        try {
            return "mounted".equals(com.byazt.bzd.uj.c());
        } catch (Throwable unused) {
            return false;
        }
    }

    public static String zm() {
        return qp.tt(String.format("https://%s", "applog.bytedance.net/service/2/app_log_test/"));
    }

    public static long a(String str) {
        return c(n(str));
    }

    public static boolean gu(ic icVar) {
        if (icVar == null || com.byazt.ete.my.uj(icVar)) {
            return false;
        }
        int iPu = icVar.pu();
        return iPu == 5 || iPu == 4;
    }

    public static int sp(String str) {
        return tt(n(str));
    }

    public static double x(String str) {
        return ve(n(str));
    }

    public static int z() {
        if (tt > 0) {
            return tt;
        }
        int iTt = com.byazt.by.uj.c().tt("cpu_max_freq", 0);
        tt = iTt;
        return iTt;
    }

    public static String da() {
        if (TextUtils.isEmpty(nu) && com.byazt.omf.gt.getContext() != null) {
            try {
                PackageInfo packageInfo = com.byazt.omf.gt.getContext().getPackageManager().getPackageInfo(x(), 0);
                m = String.valueOf(packageInfo.versionCode);
                nu = packageInfo.versionName;
            } catch (Throwable th) {
                com.byazt.nr.m.ve("ToolUtils", "ToolUtils getVersionName throws exception :", th);
            }
        }
        return nu;
    }

    public static int m() {
        if (ve > 0) {
            return ve;
        }
        int iTt = com.byazt.by.uj.c().tt("cpu_min_freq", 0);
        ve = iTt;
        return iTt;
    }

    public static long nu() {
        if (n > 0) {
            return n;
        }
        long jTt = com.byazt.by.uj.c().tt("internal_storage", 0L);
        n = jTt;
        return jTt;
    }

    public static long rh() {
        try {
            StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
            return statFs.getBlockCountLong() * statFs.getBlockSizeLong();
        } catch (Throwable unused) {
            return 0L;
        }
    }

    public static String sl() {
        if (!TextUtils.isEmpty(uj) && !uj.equals("0")) {
            return uj;
        }
        String strTt = com.byazt.by.uj.c().tt("total_memory", "0");
        uj = strTt;
        return strTt;
    }

    public static String t() {
        return String.valueOf(Long.parseLong(sl()) * 1024);
    }

    public static int u() {
        return Math.max(Runtime.getRuntime().availableProcessors(), 0);
    }

    public static boolean uj() {
        return (com.byazt.omf.x.m() == null || com.byazt.omf.x.m().c()) ? false : true;
    }

    public static int yp() {
        if (c > 0) {
            return c;
        }
        int iTt = com.byazt.by.uj.c().tt("cpu_cnt", 0);
        c = iTt;
        return iTt;
    }

    public static boolean zm(ic icVar) {
        return icVar != null && icVar.ab() == 1;
    }

    public static void a() {
        if (com.byazt.omf.p.uj()) {
            ((com.byazt.dna.u) com.byazt.ut.uj.getService("device_info_new")).getWebViewUA(true);
        }
    }

    public static String sp() {
        return UUID.randomUUID().toString();
    }

    public static String u(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        if (str.contains("KLLK")) {
            return str.replace("KLLK", "OPPO");
        }
        return str.contains("kllk") ? str.replace("kllk", "oppo") : "";
    }

    public static int uj(String str) {
        str.hashCode();
        switch (str) {
            case "banner_ad":
                return 2;
            case "rewarded_video":
                return 7;
            case "fullscreen_interstitial_ad":
                return 5;
            case "splash_ad":
            case "cache_splash_ad":
                return 4;
            case "interaction":
                return 3;
            case "draw_ad":
                return 6;
            default:
                return 1;
        }
    }

    @HungeonFlag
    public static String x() {
        if (!TextUtils.isEmpty(rh)) {
            return rh;
        }
        if (com.byazt.omf.gt.getContext() != null) {
            try {
                rh = com.byazt.omf.gt.getContext().getPackageName();
            } catch (Throwable th) {
                com.byazt.nr.m.ve("ToolUtils", "ToolUtils getPackageName throws exception :", th);
            }
        }
        return rh;
    }

    public static void md() {
        if (t && u == com.byazt.ppf.ve.c()) {
            return;
        }
        t = true;
        u = com.byazt.ppf.ve.c();
        com.byazt.sxv.c cVarC = com.byazt.sxv.c.c();
        if (com.byazt.ppf.ve.tt()) {
            cVarC.c("open_live_saas", new com.byazt.ny.ve());
            cVarC.c("open_miniapp", new com.byazt.ny.uj());
            cVarC.c("open_landing_page", new com.byazt.ny.tt());
            cVarC.c("download", new com.byazt.ny.c());
            cVarC.c("open_scheme", new com.byazt.ny.n());
        } else {
            cVarC.c("open_sass_live", new com.byazt.cj.sl());
            cVarC.c("open_miniapp", new com.byazt.cj.t());
            cVarC.c("open_landing_page", new com.byazt.cj.da());
            cVarC.c("download", new com.byazt.cj.sp());
            cVarC.c("open_scheme", new com.byazt.cj.u());
        }
        cVarC.c("open_policy", new com.byazt.cj.yp());
        cVarC.c("end_card", new com.byazt.cj.i());
        cVarC.c("common_popup", new com.byazt.cj.c());
        cVarC.c("desc_popup", new com.byazt.cj.tt());
        cVarC.c("permission_popup", new com.byazt.cj.ve());
        cVarC.c("privacy_popup", new com.byazt.cj.uj());
        cVarC.c("registration_pop", new com.byazt.cj.n());
        cVarC.c("dislike_popup", new com.byazt.cj.a());
        cVarC.c("download_popup", new com.byazt.cj.x());
        cVarC.c("reward_again", new com.byazt.cj.rh());
        cVarC.c("reward_continue", new com.byazt.cj.rh());
        cVarC.c("close_reward", new com.byazt.cj.nu());
        cVarC.c("report_event", new com.byazt.cj.z());
        cVarC.c("report_stats", new com.byazt.cj.m());
    }

    public static long my() {
        if (f28275a > 0) {
            return f28275a;
        }
        long jTt = com.byazt.by.uj.c().tt("free_storage", 0L);
        f28275a = jTt;
        return jTt;
    }

    public static boolean n(ic icVar) {
        int iSl = sl(icVar);
        return (iSl == 9 || iSl == 8 || iSl == 7) && !TextUtils.isEmpty(xd.c(icVar));
    }

    public static JSONObject qy(ic icVar) {
        if (icVar == null) {
            return null;
        }
        return icVar.q_();
    }

    public static long rl() {
        try {
            if (!zb()) {
                return 0L;
            }
            StatFs statFs = new StatFs(com.byazt.nr.sp.ve(com.byazt.omf.gt.getContext(), false, null).getPath());
            return ((long) statFs.getBlockCount()) * ((long) statFs.getBlockSize());
        } catch (Throwable th) {
            com.byazt.nr.m.uj("ToolUtils", th.getMessage());
            return 0L;
        }
    }

    public static String t(String str) {
        return c(str, false, 1);
    }

    public static boolean uj(ic icVar) {
        if (icVar != null) {
            boolean z2 = sl(icVar) == 5;
            if (pu.tt(icVar) == 7 && z2) {
                return true;
            }
        }
        return false;
    }

    public static void ve() {
        if (Looper.getMainLooper() == Looper.myLooper()) {
            com.byazt.nr.da.c().post(new Runnable() { // from class: com.byazt.aas.nb.1
                @Override // java.lang.Runnable
                public void run() {
                    nb.eo();
                }
            });
        } else {
            eo();
        }
    }

    public static boolean yv() {
        Context context = com.byazt.omf.gt.getContext();
        if (context == null) {
            com.byazt.nr.m.ve("params context is null");
            return false;
        }
        boolean z2 = context.getApplicationInfo().targetSdkVersion >= 30 && Build.VERSION.SDK_INT >= 30 && context.checkSelfPermission("android.permission.QUERY_ALL_PACKAGES") != 0;
        StringBuilder sb = new StringBuilder("can query all package = ");
        sb.append(!z2);
        com.byazt.nr.m.c("ToolUtils", sb.toString());
        return !z2;
    }

    public static boolean z(String str) {
        long jM = m(str);
        return jM != 0 && System.currentTimeMillis() - (jM * 1000) > 0;
    }

    public static long gt() {
        if (sp > 0) {
            return sp;
        }
        long jTt = com.byazt.by.uj.c().tt("sdcard_storage", 0L);
        sp = jTt;
        return jTt;
    }

    public static String i() {
        if (TextUtils.isEmpty(m) && com.byazt.omf.gt.getContext() != null) {
            try {
                PackageInfo packageInfo = com.byazt.omf.gt.getContext().getPackageManager().getPackageInfo(x(), 0);
                m = String.valueOf(packageInfo.versionCode);
                nu = packageInfo.versionName;
            } catch (Throwable th) {
                com.byazt.nr.m.ve("ToolUtils", "ToolUtils getVersionCode throws exception :", th);
            }
        }
        return m;
    }

    public static long m(String str) {
        if (TextUtils.isEmpty(str)) {
            return 0L;
        }
        Matcher matcher = Pattern.compile("/([^/]+)/video/tos/cn").matcher(str);
        if (matcher.find()) {
            String strGroup = matcher.group(1);
            if (TextUtils.isEmpty(strGroup)) {
                return 0L;
            }
            try {
                long j = Long.parseLong(strGroup, 16);
                return str.contains("v3-be-pack") ? j + 10800 : j;
            } catch (Exception unused) {
            }
        }
        return 0L;
    }

    private static String nu(String str) {
        if (TextUtils.isEmpty(str)) {
            i = "empty";
            return "api-access.pangolin-sdk-toutiao1.com";
        }
        if (!str.contains("api-access")) {
            i = str;
            return "api-access.pangolin-sdk-toutiao1.com";
        }
        i = null;
        return str;
    }

    private static String rh(String str) {
        if (TextUtils.isEmpty(str)) {
            da = "empty";
            return "log-api.pangolin-sdk-toutiao-b.com/service/2/app_log/";
        }
        if (!str.contains("service/2/app_log")) {
            da = str;
            return "log-api.pangolin-sdk-toutiao-b.com/service/2/app_log/";
        }
        da = null;
        return str;
    }

    public static String sl(String str) {
        return c(str, false, 0);
    }

    public static boolean tt(String str) {
        Context context = com.byazt.omf.gt.getContext();
        if (context == null || TextUtils.isEmpty(str)) {
            return false;
        }
        if (yv()) {
            try {
                return context.getPackageManager().getPackageInfo(str, 0) != null;
            } catch (Throwable unused) {
                return false;
            }
        }
        if (com.byazt.omf.gt.tt().em()) {
            return ve(str);
        }
        return false;
    }

    /* JADX WARN: Code duplicated, block: B:24:0x005a A[Catch: Exception -> 0x005d, TRY_LEAVE, TryCatch #1 {Exception -> 0x005d, blocks: (B:22:0x0055, B:24:0x005a), top: B:38:0x0055 }] */
    /* JADX WARN: Code duplicated, block: B:30:0x0067 A[Catch: Exception -> 0x006a, TRY_LEAVE, TryCatch #2 {Exception -> 0x006a, blocks: (B:28:0x0062, B:30:0x0067), top: B:40:0x0062 }] */
    public static int uj(int i2) {
        BufferedReader bufferedReader;
        Throwable th;
        int i3 = 0;
        FileReader fileReader = null;
        BufferedReader bufferedReader2 = null;
        while (true) {
            i2--;
            if (i2 < 0) {
                return i3;
            }
            try {
                FileReader fileReader2 = new FileReader("/sys/devices/system/cpu/cpu" + i2 + "/cpufreq/cpuinfo_min_freq");
                try {
                    BufferedReader bufferedReader3 = new BufferedReader(fileReader2);
                    try {
                        int i4 = Integer.parseInt(bufferedReader3.readLine());
                        if (i4 < i3 || i3 == 0) {
                            i3 = i4;
                        }
                        try {
                            bufferedReader3.close();
                            fileReader2.close();
                        } catch (Exception unused) {
                        }
                        bufferedReader2 = bufferedReader3;
                        fileReader = fileReader2;
                    } catch (Throwable th2) {
                        th = th2;
                        bufferedReader = bufferedReader3;
                        fileReader = fileReader2;
                        try {
                            com.byazt.nr.m.uj("ToolUtils", th.getMessage());
                            if (bufferedReader != null) {
                                try {
                                    bufferedReader.close();
                                    if (fileReader != null) {
                                        fileReader.close();
                                    }
                                } catch (Exception unused2) {
                                    bufferedReader2 = bufferedReader;
                                }
                            } else if (fileReader != null) {
                                fileReader.close();
                            }
                            bufferedReader2 = bufferedReader;
                        } catch (Throwable th3) {
                            if (bufferedReader != null) {
                                try {
                                    bufferedReader.close();
                                    if (fileReader != null) {
                                        fileReader.close();
                                    }
                                } catch (Exception unused3) {
                                    throw th3;
                                }
                            } else if (fileReader != null) {
                                fileReader.close();
                            }
                            throw th3;
                        }
                    }
                } catch (Throwable th4) {
                    BufferedReader bufferedReader4 = bufferedReader2;
                    th = th4;
                    fileReader = fileReader2;
                    bufferedReader = bufferedReader4;
                }
            } catch (Throwable th5) {
                bufferedReader = bufferedReader2;
                th = th5;
            }
        }
    }

    public static int[] yp(String str) {
        if (TextUtils.isEmpty(str)) {
            return new int[0];
        }
        String[] strArrSplit = str.split(",");
        int[] iArr = new int[strArrSplit.length];
        for (int i2 = 0; i2 < strArrSplit.length; i2++) {
            try {
                iArr[i2] = Integer.parseInt(strArrSplit[i2]);
            } catch (Exception unused) {
            }
        }
        return iArr;
    }

    public static long n() {
        return sl;
    }

    public static boolean ve(ic icVar) {
        return icVar != null && sl(icVar) == 9;
    }

    public static String gr() {
        return qp.tt(Uri.parse(String.format("https://%s", rh(com.byazt.omf.gt.tt().eo()))).buildUpon().appendQueryParameter("datetime", new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date(new Long(System.currentTimeMillis()).longValue()))).toString());
    }

    private static String my(String str) {
        try {
            return Uri.parse(str).buildUpon().appendQueryParameter("aid", "1371").appendQueryParameter("device_platform", "android").appendQueryParameter("version_code", i()).toString();
        } catch (Exception unused) {
            return str;
        }
    }

    private static double ve(JSONObject jSONObject) {
        return jSONObject != null ? jSONObject.optDouble("pack_time", AudioStats.AUDIO_AMPLITUDE_NONE) : AudioStats.AUDIO_AMPLITUDE_NONE;
    }

    public static String c(String str) {
        Uri uri;
        if (TextUtils.isEmpty(str) || (uri = Uri.parse(str)) == null) {
            return "";
        }
        String scheme = uri.getScheme();
        return TextUtils.isEmpty(scheme) ? "" : scheme.toLowerCase(Locale.US);
    }

    /* JADX WARN: Code duplicated, block: B:22:0x0057 A[Catch: Exception -> 0x005a, TRY_LEAVE, TryCatch #1 {Exception -> 0x005a, blocks: (B:20:0x0052, B:22:0x0057), top: B:36:0x0052 }] */
    /* JADX WARN: Code duplicated, block: B:28:0x0064 A[Catch: Exception -> 0x0067, TRY_LEAVE, TryCatch #3 {Exception -> 0x0067, blocks: (B:26:0x005f, B:28:0x0064), top: B:40:0x005f }] */
    public static int ve(int i2) {
        BufferedReader bufferedReader;
        Throwable th;
        int i3 = 0;
        FileReader fileReader = null;
        BufferedReader bufferedReader2 = null;
        while (true) {
            i2--;
            if (i2 < 0) {
                return i3;
            }
            try {
                FileReader fileReader2 = new FileReader("/sys/devices/system/cpu/cpu" + i2 + "/cpufreq/cpuinfo_max_freq");
                try {
                    BufferedReader bufferedReader3 = new BufferedReader(fileReader2);
                    try {
                        int i4 = Integer.parseInt(bufferedReader3.readLine());
                        if (i4 > i3) {
                            i3 = i4;
                        }
                        try {
                            bufferedReader3.close();
                            fileReader2.close();
                        } catch (Exception unused) {
                        }
                        bufferedReader2 = bufferedReader3;
                        fileReader = fileReader2;
                    } catch (Throwable th2) {
                        th = th2;
                        bufferedReader = bufferedReader3;
                        fileReader = fileReader2;
                        try {
                            com.byazt.nr.m.uj("ToolUtils", th.getMessage());
                            if (bufferedReader != null) {
                                try {
                                    bufferedReader.close();
                                    if (fileReader != null) {
                                        fileReader.close();
                                    }
                                } catch (Exception unused2) {
                                    bufferedReader2 = bufferedReader;
                                }
                            } else if (fileReader != null) {
                                fileReader.close();
                            }
                            bufferedReader2 = bufferedReader;
                        } catch (Throwable th3) {
                            if (bufferedReader != null) {
                                try {
                                    bufferedReader.close();
                                    if (fileReader != null) {
                                        fileReader.close();
                                    }
                                } catch (Exception unused3) {
                                    throw th3;
                                }
                            } else if (fileReader != null) {
                                fileReader.close();
                            }
                            throw th3;
                        }
                    }
                } catch (Throwable th4) {
                    BufferedReader bufferedReader4 = bufferedReader2;
                    th = th4;
                    fileReader = fileReader2;
                    bufferedReader = bufferedReader4;
                }
            } catch (Throwable th5) {
                bufferedReader = bufferedReader2;
                th = th5;
            }
        }
    }

    public static boolean da(String str) {
        try {
            return Pattern.compile("[一-龥]").matcher(str).find();
        } catch (Throwable unused) {
            return false;
        }
    }

    public static String p() {
        return x() + ".openadsdk.permission.TT_PANGOLIN";
    }

    public static boolean tt(Intent intent, boolean z2) {
        Boolean boolC;
        Uri data = intent.getData();
        if (data == null) {
            return false;
        }
        String strC = yv.c(data);
        if (z2 && (boolC = yv.c(strC, 86400000L)) != null) {
            return boolC.booleanValue();
        }
        boolean zUj = uj(intent);
        yv.c(strC, Boolean.valueOf(zUj));
        return zUj;
    }

    private static File c(String str, String str2) {
        if (z == null) {
            String str3 = System.getenv("EXTERNAL_STORAGE");
            z = str3;
            if (str3 == null) {
                z = "/sdcard";
            }
        }
        return new File(z, "Android/" + str + WVNativeCallbackUtil.SEPERATER + str2);
    }

    public static String i(String str) {
        FileReader fileReader;
        BufferedReader bufferedReader;
        String line;
        try {
            fileReader = new FileReader("/proc/meminfo");
            try {
                bufferedReader = new BufferedReader(fileReader, 4096);
                do {
                    try {
                        line = bufferedReader.readLine();
                        if (line == null) {
                            break;
                        }
                    } catch (Throwable th) {
                        th = th;
                        try {
                            com.byazt.nr.m.c(th);
                            return null;
                        } finally {
                            if (bufferedReader != null) {
                                try {
                                    bufferedReader.close();
                                } catch (Exception unused) {
                                }
                            }
                            if (fileReader != null) {
                                try {
                                    fileReader.close();
                                } catch (Exception unused2) {
                                }
                            }
                        }
                    }
                } while (!line.contains(str));
                if (line == null) {
                    try {
                        bufferedReader.close();
                    } catch (Exception unused3) {
                    }
                    try {
                        fileReader.close();
                    } catch (Exception unused4) {
                    }
                    return null;
                }
                String str2 = line.split("\\s+")[1];
                try {
                    bufferedReader.close();
                } catch (Exception unused5) {
                }
                try {
                    fileReader.close();
                } catch (Exception unused6) {
                }
                return str2;
            } catch (Throwable th2) {
                th = th2;
                bufferedReader = null;
            }
        } catch (Throwable th3) {
            th = th3;
            fileReader = null;
            bufferedReader = null;
        }
    }

    public static String uj(Context context) {
        try {
            return context.getResources().getString(context.getPackageManager().getPackageInfo(context.getPackageName(), 0).applicationInfo.labelRes);
        } catch (Exception unused) {
            return "";
        }
    }

    public static boolean c(Intent intent, boolean z2) {
        if (intent != null && yv()) {
            return tt(intent, z2);
        }
        return false;
    }

    public static boolean tt() {
        try {
            PackageInfo packageInfo = com.byazt.omf.gt.getContext().getPackageManager().getPackageInfo(com.byazt.omf.gt.getContext().getPackageName(), 0);
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd", Locale.ROOT);
            return simpleDateFormat.format(Long.valueOf(System.currentTimeMillis())).compareTo(simpleDateFormat.format(Long.valueOf(packageInfo.firstInstallTime))) > 0;
        } catch (Throwable unused) {
            return true;
        }
    }

    public static long ve(Context context) {
        int i2;
        try {
            i2 = context.getApplicationInfo().minSdkVersion;
            try {
                com.byazt.nr.m.c("ToolUtils", "minSdkVersion = ", Integer.valueOf(i2));
            } catch (Throwable unused) {
            }
        } catch (Throwable unused2) {
            i2 = -1;
        }
        return i2;
    }

    public static boolean c(Intent intent) {
        if (intent != null && yv()) {
            return tt(intent, false);
        }
        return false;
    }

    public static List<String> c() {
        ArrayList arrayList = new ArrayList();
        if (com.byazt.omf.gt.tt().nc() && com.byazt.omf.x.m().nu().alist()) {
            Iterator<ResolveInfo> it = x.c(new Intent("android.intent.action.MAIN"), 131072).iterator();
            while (it.hasNext()) {
                ActivityInfo activityInfo = it.next().activityInfo;
                if (activityInfo != null) {
                    String str = activityInfo.packageName;
                    if (!TextUtils.isEmpty(str) && !arrayList.contains(str)) {
                        arrayList.add(str);
                    }
                }
            }
        }
        return arrayList;
    }

    public static void ve(Intent intent) {
        if (intent == null) {
            return;
        }
        Uri data = intent.getData();
        if (data == null) {
            intent.addFlags(268435456);
        } else if (com.byazt.omf.gt.tt().rh(data.getScheme())) {
            intent.addFlags(805339136);
        } else {
            intent.addFlags(268435456);
        }
    }

    public static String tt(ic icVar) {
        if (icVar == null) {
            return null;
        }
        try {
            return tt(sl(icVar));
        } catch (Throwable unused) {
            return null;
        }
    }

    private static int tt(JSONObject jSONObject) {
        if (jSONObject != null) {
            return jSONObject.optInt("ut", 0);
        }
        return 0;
    }

    public static Map<String, Object> tt(boolean z2, ic icVar, long j, long j2, String str) {
        HashMap map = new HashMap();
        map.put("creative_id", icVar.uj());
        map.put("load_time", Long.valueOf(j));
        if (!z2) {
            map.put(SDKInitializer.SDK_BROADTCAST_INTENT_EXTRA_INFO_KEY_ERROR_CODE, Long.valueOf(j2));
            if (TextUtils.isEmpty(str)) {
                str = "unknown";
            }
            map.put(SDKInitializer.SDK_BROADTCAST_INTENT_EXTRA_INFO_KEY_ERROR_MESSAGE, str);
        }
        return map;
    }

    public static int c(ic icVar) {
        int iGr = com.byazt.omf.gt.tt().gr();
        int iIntValue = 0;
        if (iGr != -1) {
            return (iGr == 0 || iGr != 1) ? 0 : 1;
        }
        try {
            ma maVarSp = pu.sp(icVar);
            dz dzVarA = pu.a(icVar);
            if (maVarSp != null) {
                String strA = maVarSp.a();
                if (!TextUtils.isEmpty(strA)) {
                    iIntValue = Integer.valueOf(strA).intValue();
                }
            } else if (dzVarA != null) {
                String strT = dzVarA.t();
                if (!TextUtils.isEmpty(strT)) {
                    iIntValue = Integer.valueOf(strT).intValue();
                }
            }
            return iIntValue;
        } catch (Exception e) {
            com.byazt.nr.m.uj(RVParams.SHOW_TITLE_LOADING, e.getMessage());
            return iIntValue;
        }
    }

    public static String tt(long j, long j2) {
        return String.valueOf(((int) (Math.abs(j2 - j) / 86400000)) + 1);
    }

    public static int tt(com.byazt.dj.tt ttVar) {
        if (ttVar == null) {
            return 0;
        }
        try {
            return Integer.parseInt(ttVar.uj());
        } catch (Exception unused) {
            return 0;
        }
    }

    public static long tt(Context context) {
        int i2;
        try {
            i2 = context.getApplicationInfo().targetSdkVersion;
            try {
                com.byazt.nr.m.c("ToolUtils", "targetSdkVersion = ", Integer.valueOf(i2));
            } catch (Throwable unused) {
            }
        } catch (Throwable unused2) {
            i2 = -1;
        }
        return i2;
    }

    public static ic tt(Intent intent) {
        ic icVarC;
        if (intent == null) {
            return null;
        }
        try {
            String stringExtra = intent.getStringExtra("multi_process_materialmeta");
            if (!TextUtils.isEmpty(stringExtra) && (icVarC = com.byazt.omf.c.c(new JSONObject(stringExtra))) != null) {
                return icVarC;
            }
        } catch (Exception e) {
            com.byazt.nr.m.ve("ToolUtils", "getMaterialMeta from intent failed", e);
        }
        String stringExtra2 = intent.getStringExtra("multi_process_materialmeta_key");
        ic icVar = (ic) com.byazt.omf.rl.tt(stringExtra2, ic.class);
        if (icVar != null) {
            return icVar;
        }
        com.byazt.it.ve veVarC = com.byazt.vif.uj.c(com.byazt.vxy.c.uj(), "sp_meta");
        String strVe = com.byazt.nr.c.ve(veVarC.get(stringExtra2, ""));
        try {
            if (TextUtils.isEmpty(strVe)) {
                com.byazt.nr.m.uj("ToolUtils", "getMaterialMeta from keva failed , md5" + stringExtra2);
                return null;
            }
            return com.byazt.omf.c.c(new JSONObject(strVe));
        } catch (Exception e2) {
            com.byazt.nr.m.c(e2);
            com.byazt.nr.m.ve("ToolUtils", "getMaterialMeta from keva failed", e2);
            return null;
        } finally {
            veVarC.remove(stringExtra2);
        }
    }

    private static long c(JSONObject jSONObject) {
        if (jSONObject != null) {
            return jSONObject.optLong(UserConstants.URL_PARAMS.b, 0L);
        }
        return 0L;
    }

    public static String c(ic icVar, String str) {
        JSONObject jSONObjectQ_ = icVar.q_();
        return jSONObjectQ_ != null ? jSONObjectQ_.optString("rit", str) : str;
    }

    public static String c(com.byazt.dj.tt ttVar) {
        String strDecryptWithCBC;
        try {
            JSONObject jSONObject = new JSONObject(ttVar.rl());
            int iOptInt = jSONObject.optInt("cypher");
            String strOptString = jSONObject.optString("message");
            if (iOptInt == 3) {
                strDecryptWithCBC = com.byazt.nr.c.ve(strOptString);
            } else if (iOptInt == 4) {
                com.byazt.dna.n nVarTt = gr.tt();
                strDecryptWithCBC = nVarTt == null ? "" : nVarTt.decryptWithCBC(strOptString);
                if (strDecryptWithCBC == null) {
                    strDecryptWithCBC = "";
                }
            } else {
                strDecryptWithCBC = null;
            }
            JSONArray jSONArrayOptJSONArray = new JSONObject(strDecryptWithCBC).optJSONArray("creatives");
            StringBuilder sb = new StringBuilder();
            if (jSONArrayOptJSONArray != null) {
                for (int i2 = 0; i2 < jSONArrayOptJSONArray.length(); i2++) {
                    String strOptString2 = ((JSONObject) jSONArrayOptJSONArray.get(i2)).optString("material_key");
                    if (i2 != 0) {
                        sb.append("," + strOptString2);
                    } else {
                        sb.append(strOptString2);
                    }
                }
            }
            return sb.toString();
        } catch (Exception unused) {
            return null;
        }
    }

    public static String tt(ic icVar, String str) {
        hq hqVarA_;
        if (icVar == null || (hqVarA_ = icVar.A_()) == null || hqVarA_.tt() != 1 || TextUtils.isEmpty(str)) {
            return str;
        }
        StringBuilder sb = new StringBuilder(str);
        if (str.indexOf("?") != -1) {
            sb.append("&");
        } else {
            sb.append("?");
        }
        sb.append("open_method=");
        if (!com.byazt.wdw.uj.ve().c()) {
            sb.append(2);
            return sb.toString();
        }
        sb.append(hqVarA_.a());
        return sb.toString();
    }

    public static Map<String, Object> c(long j, ic icVar, com.byazt.fk.sp spVar) {
        HashMap map = new HashMap();
        map.put("video_start_duration", Long.valueOf(j));
        if (icVar != null) {
            if (!TextUtils.isEmpty(icVar.uj())) {
                map.put("creative_id", icVar.uj());
            }
            com.byazt.jzl.uj ujVarZ = xd.z(icVar);
            if (ujVarZ != null) {
                map.put(CropKey.VIDEO_RESOLUTION, ujVarZ.getResolution());
                map.put("video_size", Long.valueOf(ujVarZ.getSize()));
            }
        }
        c(map, spVar);
        return map;
    }

    public static Map<String, Object> c(boolean z2, ic icVar, long j, long j2, String str) {
        HashMap map = new HashMap();
        map.put("creative_id", icVar.uj());
        map.put("load_time", Long.valueOf(j));
        com.byazt.jzl.uj ujVarZ = xd.z(icVar);
        if (ujVarZ != null) {
            map.put("video_size", Long.valueOf(ujVarZ.getSize()));
            map.put(CropKey.VIDEO_RESOLUTION, ujVarZ.getResolution());
            map.put("video_preload_size", Long.valueOf(ujVarZ.getVideoPreloadSize()));
        }
        if (!z2) {
            map.put(SDKInitializer.SDK_BROADTCAST_INTENT_EXTRA_INFO_KEY_ERROR_CODE, Long.valueOf(j2));
            if (TextUtils.isEmpty(str)) {
                str = "unknown";
            }
            map.put(SDKInitializer.SDK_BROADTCAST_INTENT_EXTRA_INFO_KEY_ERROR_MESSAGE, str);
        }
        return map;
    }

    public static Map<String, Object> c(ic icVar, long j, com.byazt.fk.sp spVar) {
        HashMap map = new HashMap();
        map.put("creative_id", icVar.uj());
        map.put("buffers_time", Long.valueOf(j));
        com.byazt.jzl.uj ujVarZ = xd.z(icVar);
        if (ujVarZ != null) {
            map.put("video_size", Long.valueOf(ujVarZ.getSize()));
            map.put(CropKey.VIDEO_RESOLUTION, ujVarZ.getResolution());
        }
        c(map, spVar);
        return map;
    }

    private static void c(Map<String, Object> map, com.byazt.fk.sp spVar) {
        if (map.containsKey(CropKey.VIDEO_RESOLUTION) || spVar == null) {
            return;
        }
        try {
            map.put(CropKey.VIDEO_RESOLUTION, String.format(Locale.getDefault(), "%d×%d", Integer.valueOf(spVar.getVideoWidth()), Integer.valueOf(spVar.getVideoHeight())));
        } catch (Throwable unused) {
        }
    }

    public static String c(Context context) {
        try {
            return context.getResources().getConfiguration().getLocales().get(0).getLanguage();
        } catch (Exception e) {
            com.byazt.nr.m.uj("ToolUtils", e.toString());
            return "";
        }
    }

    public static boolean c(boolean z2, ic icVar, String str, boolean z3) {
        if (z2 || icVar == null) {
            return false;
        }
        try {
            com.byazt.ete.nu nuVarYp = icVar.yp();
            if (!(icVar.x_() || (nuVarYp != null && nuVarYp.ve() == 2 && !nuVarYp.c() && com.byazt.omf.tt.c().get("dpl_reject_by_dialog", false)))) {
                return false;
            }
            String strX = icVar.x();
            if (TextUtils.isEmpty(strX) && nuVarYp != null && nuVarYp.n() == 1 && !TextUtils.isEmpty(nuVarYp.uj())) {
                strX = nuVarYp.uj();
            }
            if (!TextUtils.isEmpty(strX)) {
                com.byazt.omf.or.c(strX, icVar, str, z3);
                return true;
            }
        } catch (Throwable unused) {
        }
        return false;
    }

    public static String c(String str, boolean z2) {
        return c(str, z2, 0);
    }

    private static String c(String str, boolean z2, int i2) {
        String strMy = i2 == 0 ? com.byazt.omf.gt.tt().my() : nu(com.byazt.omf.gt.tt().p());
        String str2 = "/ad_union_qa/sdk/get_ads";
        if (com.byazt.zlb.ve.c() && com.byazt.omf.x.m().tx() && TextUtils.equals(str, "/api/ad/union/sdk/get_ads/")) {
            strMy = com.byazt.omf.x.m().v();
            str = "/ad_union_qa/sdk/get_ads";
        }
        if (com.byazt.omf.x.m().iu() != null && x().equals("com.pangolin_demo.toutiao") && TextUtils.equals(str, "/api/ad/union/sdk/get_ads/")) {
            strMy = com.byazt.omf.x.m().v();
        } else {
            str2 = str;
        }
        String strC = String.format("https://%s%s", strMy, str2);
        if (qp.c()) {
            if (!z2) {
                strC = qp.tt(strC);
            }
            String strC2 = qp.c("testIp.txt");
            if (strC2 != null) {
                strC = qp.c(strC, strC2);
            }
        }
        return z2 ? my(strC) : strC;
    }

    public static boolean c(long j, long j2) {
        long j3 = j2 - j;
        return j3 < 86400000 && j3 > -86400000 && c(j) == c(j2);
    }

    public static long c(long j) {
        return (j + ((long) TimeZone.getDefault().getOffset(j))) / 86400000;
    }

    public static void c(ic icVar, JSONObject jSONObject) {
        Uri uri;
        int i2;
        try {
            String strDa = da(icVar);
            int i3 = 3;
            if (TextUtils.isEmpty(strDa)) {
                i2 = 3;
                uri = null;
            } else {
                uri = Uri.parse(strDa);
                i2 = 0;
            }
            boolean zYv = yv();
            if (zYv && uri != null) {
                Intent intent = new Intent("android.intent.action.VIEW");
                intent.setData(uri);
                i2 = tt(intent, false) ? 1 : 2;
            }
            jSONObject.putOpt("scheme_status", Integer.valueOf(i2));
            String strMd = md(icVar);
            if (!TextUtils.isEmpty(strMd)) {
                i3 = ve(strMd) ? 1 : 2;
            }
            jSONObject.put("hit_status", i3);
            jSONObject.putOpt("alist", Boolean.valueOf(com.byazt.omf.x.m().nu().alist()));
            jSONObject.putOpt("query_auth", Integer.valueOf(zYv ? 1 : 0));
            jSONObject.putOpt(NativeModel.JSON_KEY_SCHEME, uri != null ? yv.c(uri) : null);
            jSONObject.putOpt("hit_pkg", strMd);
        } catch (Throwable th) {
            com.byazt.nr.m.ve("ToolUtils", th);
        }
    }

    public static Bundle c(int i2, Bundle bundle) {
        int i3 = bundle.getInt("callback_extra_key_reward_amount");
        String string = bundle.getString("callback_extra_key_reward_name");
        int i4 = bundle.getInt("callback_extra_key_error_code");
        String string2 = bundle.getString("callback_extra_key_error_msg");
        float f = bundle.getFloat("callback_extra_key_reward_propose");
        boolean z2 = bundle.getBoolean("callback_extra_key_video_complete_reward");
        boolean z3 = bundle.getBoolean("callback_extra_key_is_server_verify");
        Bundle bundle2 = new Bundle();
        bundle2.putInt("reward_extra_key_error_code", i4);
        bundle2.putString("reward_extra_key_error_msg", string2);
        bundle2.putString("reward_extra_key_reward_name", string);
        bundle2.putInt("reward_extra_key_reward_amount", i3);
        bundle2.putFloat("reward_extra_key_reward_propose", f);
        bundle2.putBoolean("reward_extra_key_is_server_verify", z3);
        if (i2 == 0) {
            bundle2.putBoolean("reward_extra_key_has_video_complete_reward", z2);
        }
        return bundle2;
    }

    public static String c(int[] iArr) {
        if (iArr == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (int i2 = 0; i2 < iArr.length; i2++) {
            if (i2 < iArr.length - 1) {
                sb.append(iArr[i2] + ",");
            } else {
                sb.append(iArr[i2]);
            }
        }
        return sb.toString();
    }

    public static void c(Intent intent, ic icVar) {
        if (icVar == null) {
            return;
        }
        if (!com.byazt.omf.gt.tt().xw()) {
            intent.putExtra("multi_process_materialmeta", icVar.yg().toString());
            return;
        }
        String strRl = icVar.rl();
        intent.putExtra("multi_process_materialmeta_key", strRl);
        if (com.byazt.nr.gt.c(com.byazt.omf.gt.getContext()) && !com.byazt.omf.p.uj()) {
            com.byazt.omf.rl.c(strRl, icVar, ic.class);
        } else {
            com.byazt.vif.uj.c(com.byazt.vxy.c.uj(), "sp_meta").put(strRl, com.byazt.nr.c.tt(icVar.yg().toString()));
        }
    }

    public static void c(Map<String, Object> map, JSONObject jSONObject, String str) {
        if (jSONObject == null || map == null) {
            return;
        }
        if (!com.byazt.omf.gt.tt().xw()) {
            map.put("multi_process_materialmeta", jSONObject.toString());
            return;
        }
        map.put("multi_process_materialmeta_key", str);
        if (com.byazt.nr.gt.c(com.byazt.omf.gt.getContext())) {
            com.byazt.omf.rl.c(str, com.byazt.omf.c.c(jSONObject), ic.class);
        } else {
            eo.c("sp_meta").put(str, com.byazt.nr.c.tt(jSONObject.toString()));
        }
    }

    public static void c(Map<String, Object> map, ic icVar) {
        if (icVar == null || map == null) {
            return;
        }
        if (!com.byazt.omf.gt.tt().xw()) {
            map.put("multi_process_materialmeta", icVar.yg().toString());
            return;
        }
        String strRl = icVar.rl();
        map.put("multi_process_materialmeta_key", strRl);
        if (com.byazt.nr.gt.c(com.byazt.omf.gt.getContext()) && !com.byazt.omf.p.uj()) {
            com.byazt.omf.rl.c(strRl, icVar, ic.class);
        } else {
            com.byazt.vif.uj.c(com.byazt.vxy.c.uj(), "sp_meta").put(strRl, com.byazt.nr.c.tt(icVar.yg().toString()));
        }
    }

    public static boolean c(String str, ic icVar, Context context) {
        if (TextUtils.isEmpty(str) || icVar == null || context == null) {
            return false;
        }
        HashMap map = new HashMap();
        map.put("material_meta", icVar);
        map.put("context", context);
        com.byazt.ppf.ve.c(str, icVar.yg(), map);
        return true;
    }

    public static boolean c(String str, AtomicInteger atomicInteger) {
        if (TextUtils.isEmpty(str) || atomicInteger == null) {
            return true;
        }
        if (atomicInteger.get() == 1) {
            return false;
        }
        if (str.startsWith("bytedance") || str.startsWith("nativeapp")) {
            return true;
        }
        if (!(str.startsWith("https:") || str.startsWith("http:"))) {
            return true;
        }
        Set<String> set = com.byazt.ete.cu.c;
        if (set.isEmpty()) {
            h();
        }
        String host = Uri.parse(str).getHost();
        if (TextUtils.isEmpty(host) || set.isEmpty()) {
            return true;
        }
        for (String str2 : set) {
            if (!TextUtils.isEmpty(str2) && host.contains(str2)) {
                return true;
            }
        }
        return false;
    }
}
