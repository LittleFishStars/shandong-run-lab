package com.zj.adlib;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.google.gson.Gson;
import com.huachenjie.common.bean.AdPlatformSwitch;
import com.huachenjie.common.bean.AdPositionConfig;
import com.huachenjie.common.bean.AdPositionSwitch;
import com.huachenjie.common.bean.CheatConfig;
import com.huachenjie.common.bean.CommonConfig;
import com.huachenjie.common.bean.CustomerServerStatusData;
import huachenjie.sdk.map.lib_base.HCJAddressInfo;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
public class r90 {
    public static final String A = "keyUpdateOaidTime";
    public static final String B = "keyLastShowDoubleTime";
    public static final String C = "keyShowOpenThirdAppTip";
    public static final String D = "key_lottery_theme_config";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static long f44400a = 0;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static CheatConfig f19249a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static CommonConfig f19250a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static CustomerServerStatusData f19251a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static HCJAddressInfo f19252a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final String f19253a = "AppConfigStorage";

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static Map<String, AdPlatformSwitch> f19254a = null;
    public static final String b = "key_common_config";

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public static Map<String, AdPositionSwitch> f19255b = null;
    public static final String c = "key_customer_service";
    public static final String d = "key_location";
    public static final String e = "key_agree_statement_2.7.0";
    public static final String f = "key_showed_version";
    public static final String g = "key_running_cheat_config";
    public static final String h = "key_device_id";
    public static final String i = "KEY_SHOW_UPDATE_TIME";
    public static final String j = "key_app_ad_switch";
    public static final String k = "key_ad_compliance";
    public static final String l = "key_app_ad_position_switch";
    public static final String m = "keyShowFloatingChatRoomGuide";
    public static final String n = "keyShowSignalTowerGuide";
    public static final String o = "keyShowSunshineRunInRunGuide";
    public static final String p = "localWorksVideo";
    public static final String q = "keyPublishTopicHistory";
    public static final String r = "keyShowOpenNotification";
    public static final String s = "keyShowLoginOpenNotification";
    public static final String t = "keyMallAppleSaleTipNoHint";
    public static final String u = "keyMallSearchHistory";
    public static final String v = "keyLastTestUrl";
    public static final String w = "keyOaid";
    public static final String x = "keyLastMapType";
    public static final String y = "keySearchHistory";
    public static final String z = "keyOpenOaidTip";

    public static Boolean A() {
        return (Boolean) zr8.c(f19253a).h(n, Boolean.TRUE);
    }

    public static Boolean B() {
        return (Boolean) zr8.c(f19253a).h(o, Boolean.TRUE);
    }

    public static String C() {
        return (String) zr8.c(f19253a).h(f, "");
    }

    public static long D() {
        return f44400a;
    }

    public static long E() {
        return ((Long) zr8.c(f19253a).h(A, 0L)).longValue();
    }

    public static void F(Context context) {
        zr8.f(f19253a, new p55(context, f19253a), new wp());
    }

    public static boolean G() {
        return ((Boolean) zr8.c(f19253a).h(e, Boolean.FALSE)).booleanValue();
    }

    public static void H(boolean compliance) {
        zr8.c(f19253a).j(k, Boolean.valueOf(compliance));
    }

    public static void I(AdPositionConfig adPositionConfig) {
        if (adPositionConfig == null || adPositionConfig.getAdPositionList() == null || adPositionConfig.getAdPositionList().isEmpty()) {
            return;
        }
        f19255b = new LinkedHashMap();
        if (adPositionConfig.getAdSwitch()) {
            f19255b.put("adSwitch", new AdPositionSwitch());
        }
        for (AdPositionSwitch adPositionSwitch : adPositionConfig.getAdPositionList()) {
            f19255b.put(adPositionSwitch.getAdPositionName(), adPositionSwitch);
        }
        zr8.c(f19253a).j(l, new Gson().toJson(f19255b.values()));
    }

    public static void J(boolean agree) {
        zr8.c(f19253a).j(e, Boolean.valueOf(agree));
    }

    public static void K(List<AdPlatformSwitch> adSwitchList) {
        if (adSwitchList == null || adSwitchList.isEmpty()) {
            return;
        }
        f19254a = new LinkedHashMap();
        for (AdPlatformSwitch adPlatformSwitch : adSwitchList) {
            f19254a.put(adPlatformSwitch.getAdName(), adPlatformSwitch);
        }
        zr8.c(f19253a).j(j, new Gson().toJson(adSwitchList));
    }

    public static void L(CheatConfig config) {
        if (config == null) {
            return;
        }
        f19249a = config;
        zr8.c(f19253a).j(g, new Gson().toJson(config));
    }

    public static void M(CommonConfig config) {
        if (config == null) {
            return;
        }
        f19250a = config;
        zr8.c(f19253a).j(b, new Gson().toJson(config));
    }

    public static void N(CustomerServerStatusData data) {
        if (data == null) {
            return;
        }
        f19251a = data;
        zr8.c(f19253a).j(c, new Gson().toJson(data));
    }

    public static void O(String deviceId) {
        zr8.c(f19253a).j(h, deviceId);
    }

    public static void P(int mapType) {
        zr8.c(f19253a).j(x, Integer.valueOf(mapType));
    }

    public static void Q(long lastTime) {
        zr8.c(f19253a).j(B, Long.valueOf(lastTime));
    }

    public static void R(String url) {
        zr8.c(f19253a).j(v, url);
    }

    public static void S(String videoInfos) {
        zr8.c(f19253a).j(p, videoInfos);
    }

    public static void T(String configJson) {
        if (TextUtils.isEmpty(configJson)) {
            return;
        }
        zr8.c(f19253a).j(D, configJson);
    }

    public static void U(boolean saleTip) {
        zr8.c(f19253a).j(t, Boolean.valueOf(saleTip));
    }

    public static void V(String jsonStr) {
        zr8.c(f19253a).j(u, jsonStr);
    }

    public static void W(String oaid) {
        zr8.c(f19253a).j(w, oaid);
    }

    public static void X(boolean showTip) {
        zr8.c(f19253a).j(z, Boolean.valueOf(showTip));
    }

    public static void Y(String jsonStr) {
        zr8.c(f19253a).j(q, jsonStr);
    }

    public static void Z(String jsonStr) {
        zr8.c(f19253a).j(y, jsonStr);
    }

    public static void a(String str, String str2, boolean z2) {
        if (f19255b.get("adSwitch") == null) {
            f19255b.put("adSwitch", new AdPositionSwitch());
        }
        AdPositionSwitch adPositionSwitch = f19255b.get(str);
        if (adPositionSwitch == null) {
            f19255b.put(str, new AdPositionSwitch(str, z2 ? 1 : 0, "", "", "", str2));
        } else {
            adPositionSwitch.setAdType(z2 ? 1 : 0);
            adPositionSwitch.setAdAgencyName(str2);
        }
    }

    public static void a0() {
        zr8.c(f19253a).j(m, Boolean.FALSE);
    }

    public static void b() {
        zr8.c(f19253a).j(D, "");
    }

    public static void b0() {
        zr8.c(f19253a).j(s, Boolean.FALSE);
    }

    public static boolean c() {
        return ((Boolean) zr8.c(f19253a).h(k, Boolean.TRUE)).booleanValue();
    }

    public static void c0() {
        zr8.c(f19253a).j(r, Boolean.FALSE);
    }

    @Nullable
    public static AdPositionSwitch d(String adName) {
        if (f19255b == null) {
            f19255b = new LinkedHashMap();
            AdPositionSwitch[] adPositionSwitchArr = (AdPositionSwitch[]) new Gson().fromJson((String) zr8.c(f19253a).h(l, ""), AdPositionSwitch[].class);
            if (adPositionSwitchArr == null || adPositionSwitchArr.length == 0) {
                return null;
            }
            for (AdPositionSwitch adPositionSwitch : adPositionSwitchArr) {
                f19255b.put(adPositionSwitch.getAdPositionName(), adPositionSwitch);
            }
        }
        return f19255b.get(adName);
    }

    public static void d0(boolean showTip) {
        zr8.c(f19253a).j(C, Boolean.valueOf(showTip));
    }

    @Nullable
    public static AdPlatformSwitch e(String adName) {
        if (f19254a == null) {
            f19254a = new LinkedHashMap();
            AdPlatformSwitch[] adPlatformSwitchArr = (AdPlatformSwitch[]) new Gson().fromJson((String) zr8.c(f19253a).h(j, ""), AdPlatformSwitch[].class);
            if (adPlatformSwitchArr == null || adPlatformSwitchArr.length == 0) {
                return null;
            }
            for (AdPlatformSwitch adPlatformSwitch : adPlatformSwitchArr) {
                f19254a.put(adPlatformSwitch.getAdName(), adPlatformSwitch);
            }
        }
        return f19254a.get(adName);
    }

    public static void e0() {
        zr8.c(f19253a).j(n, Boolean.FALSE);
    }

    public static CheatConfig f() {
        if (f19249a == null) {
            CheatConfig cheatConfig = (CheatConfig) new Gson().fromJson((String) zr8.c(f19253a).h(g, ""), CheatConfig.class);
            f19249a = cheatConfig;
            if (cheatConfig == null) {
                return new CheatConfig();
            }
        }
        return f19249a;
    }

    public static void f0() {
        zr8.c(f19253a).j(o, Boolean.FALSE);
    }

    public static CommonConfig g() {
        if (f19250a == null) {
            CommonConfig commonConfig = (CommonConfig) new Gson().fromJson((String) zr8.c(f19253a).h(b, ""), CommonConfig.class);
            f19250a = commonConfig;
            if (commonConfig == null) {
                f19250a = new CommonConfig();
            }
        }
        return f19250a;
    }

    public static void g0(long time) {
        zr8.c(f19253a).j(i, Long.valueOf(time));
    }

    public static CustomerServerStatusData h() {
        if (f19251a == null) {
            String str = (String) zr8.c(f19253a).h(c, (Object) null);
            if (!TextUtils.isEmpty(str)) {
                f19251a = (CustomerServerStatusData) new Gson().fromJson(str, CustomerServerStatusData.class);
            }
        }
        return f19251a;
    }

    public static void h0(String version) {
        zr8.c(f19253a).j(f, version);
    }

    public static String i() {
        return (String) zr8.c(f19253a).h(h, "");
    }

    public static void i0(long offset) {
        f44400a = offset;
    }

    public static int j() {
        return ((Integer) zr8.c(f19253a).h(x, 1)).intValue();
    }

    public static void j0(long updateTime) {
        zr8.c(f19253a).j(A, Long.valueOf(updateTime));
    }

    public static long k() {
        return ((Long) zr8.c(f19253a).h(B, 0L)).longValue();
    }

    public static void k0(HCJAddressInfo addressInfo) {
        f19252a = addressInfo;
        zr8.c(f19253a).j(d, addressInfo == null ? "" : new Gson().toJson(addressInfo));
    }

    public static Long l() {
        return (Long) zr8.c(f19253a).h(i, 0L);
    }

    public static String m() {
        return (String) zr8.c(f19253a).h(v, "");
    }

    public static String n() {
        return (String) zr8.c(f19253a).h(p, "");
    }

    public static HCJAddressInfo o() {
        if (f19252a == null) {
            f19252a = (HCJAddressInfo) new Gson().fromJson((String) zr8.c(f19253a).h(d, ""), HCJAddressInfo.class);
        }
        if (f19252a == null) {
            f19252a = new HCJAddressInfo();
        }
        return f19252a;
    }

    public static String p() {
        return (String) zr8.c(f19253a).h(D, "");
    }

    public static boolean q() {
        return ((Boolean) zr8.c(f19253a).h(t, Boolean.FALSE)).booleanValue();
    }

    public static String r() {
        return (String) zr8.c(f19253a).h(u, "");
    }

    @Nullable
    public static String s() {
        return (String) zr8.c(f19253a).h(w, (Object) null);
    }

    public static boolean t() {
        return ((Boolean) zr8.c(f19253a).h(z, Boolean.FALSE)).booleanValue();
    }

    public static String u() {
        return (String) zr8.c(f19253a).h(q, "");
    }

    public static String v() {
        return (String) zr8.c(f19253a).h(y, "");
    }

    public static Boolean w() {
        return (Boolean) zr8.c(f19253a).h(m, Boolean.TRUE);
    }

    public static Boolean x() {
        return (Boolean) zr8.c(f19253a).h(s, Boolean.TRUE);
    }

    public static Boolean y() {
        return (Boolean) zr8.c(f19253a).h(r, Boolean.TRUE);
    }

    public static boolean z() {
        return ((Boolean) zr8.c(f19253a).h(C, Boolean.TRUE)).booleanValue();
    }
}
