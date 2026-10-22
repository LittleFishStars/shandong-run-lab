package com.kwad.sdk.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import androidx.camera.video.AudioStats;
import com.kwad.sdk.service.ServiceProvider;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
public final class ai {
    private static boolean bpt = false;
    private static boolean bpu = false;
    private static String sAppTag = "";

    public static int VA() {
        Context context = ServiceProvider.getContext();
        if (context == null) {
            return 0;
        }
        return b(context, "ksadsdk_perf", "ksadsdk_soft_height", 0);
    }

    public static int VB() {
        int iB = b("ksadsdk_perf", "image_load_total", 0);
        com.kwad.sdk.core.d.c.d("Ks_UnionUtils", "imageLoadTotal:" + iB);
        a("ksadsdk_perf", "image_load_total", 0);
        return iB;
    }

    public static int VC() {
        int iB = b("ksadsdk_perf", "image_load_suc", 0);
        com.kwad.sdk.core.d.c.d("Ks_UnionUtils", "imageLoadSuccess:" + iB);
        a("ksadsdk_perf", "image_load_suc", 0);
        return iB;
    }

    public static int VD() {
        int iB = b("ksadsdk_perf", "image_load_failed", 0);
        com.kwad.sdk.core.d.c.d("Ks_UnionUtils", "imageLoadFailed:" + iB);
        a("ksadsdk_perf", "image_load_failed", 0);
        return iB;
    }

    public static boolean Ve() {
        return bpt;
    }

    public static boolean Vf() {
        return bpu;
    }

    public static boolean Vg() {
        return c(getContext(), "ksadsdk_uaid_enable", "KEY_SDK_UAID_ENABLE", false);
    }

    public static long Vh() {
        return b(getContext(), "ksadsdk_uaid_expire_sec", "KEY_SDK_UAID_EXPIRE_SEC", 0L);
    }

    private static long Vi() {
        return b(getContext(), "ksadsdk_uaid_create_time", "KEY_SDK_UAID_CREATE_TIME", 0L);
    }

    public static String Vj() {
        Context context = getContext();
        return context == null ? "" : b(context, "ksadsdk_interstitial_daily_show_count", "KEY_INTERSTITIAL_DAILY_SHOW_COUNT", "");
    }

    public static String Vk() {
        Context context = getContext();
        return context == null ? "" : b(context, "ksadsdk_reward_full_ad_jump_direct", "KEY_REWARD_FULL_AD_JUMP_DIRECT", "");
    }

    public static String Vl() {
        Context context = getContext();
        if (context == null) {
            return "";
        }
        return bp.WB() ? b(context, "ksadsdk_splash_local_ad_force_active", "KEY_SPLASH_DAILY_SHOW_COUNT", "") : b(context, "ksadsdk_splash_daily_show_count", "KEY_SPLASH_DAILY_SHOW_COUNT", "");
    }

    public static String Vm() {
        Context context = getContext();
        if (context == null) {
            return "";
        }
        return bp.WD() ? i("ksadsdk_reward_full_ad_jump_direct", "KEY_REWARD_AUTO_CALL_APP_CARD_SHOW_COUNT", "") : b(context, "ksadsdk_reward_auto_call_app_card_show_count", "KEY_REWARD_AUTO_CALL_APP_CARD_SHOW_COUNT", "");
    }

    public static String Vn() {
        return i("ksadsdk_interstitial_daily_show_count", "KEY_INTERSTITIAL_AUTO_CALL_APP_CARD_SHOW_COUNT", "");
    }

    public static String Vo() {
        if (!TextUtils.isEmpty(sAppTag)) {
            return sAppTag;
        }
        Context context = getContext();
        return context == null ? "" : b(context, "ksadsdk_pref", "appTag", "");
    }

    public static String Vp() {
        Context context = getContext();
        return context == null ? "" : dn(context);
    }

    public static String Vq() {
        Context context = getContext();
        return context == null ? "" : m1067do(context);
    }

    public static boolean Vr() {
        return !TextUtils.isEmpty(Vq());
    }

    public static boolean Vs() {
        return (TextUtils.isEmpty(Vp()) || Vt()) ? false : true;
    }

    private static boolean Vt() {
        long jCurrentTimeMillis = (System.currentTimeMillis() - Vi()) / 1000;
        long jVh = Vh();
        return jVh != 0 && jCurrentTimeMillis >= jVh;
    }

    public static long Vu() {
        return b("ksadsdk_push_ad_common", "key_push_last_show_time", -1L);
    }

    public static String Vv() {
        return getContext() == null ? "" : i("ksadsdk_install_tips_show_count", "init_install_tips_show_count", "");
    }

    public static void Vw() {
        a("ksadsdk_perf", "image_load_total", b("ksadsdk_perf", "image_load_total", 0) + 1);
    }

    public static void Vx() {
        a("ksadsdk_perf", "image_load_suc", b("ksadsdk_perf", "image_load_suc", 0) + 1);
    }

    public static void Vy() {
        a("ksadsdk_perf", "image_load_failed", b("ksadsdk_perf", "image_load_failed", 0) + 1);
    }

    public static double Vz() {
        int iB = b("ksadsdk_perf", "image_load_complete_count", 0);
        long jB = b("ksadsdk_perf", "image_load_complete_total", 0L);
        a("ksadsdk_perf", "image_load_complete_count", 0);
        a("ksadsdk_perf", "image_load_complete_total", 0L);
        return iB == 0 ? AudioStats.AUDIO_AMPLITUDE_NONE : jB / ((double) iB);
    }

    public static void a(String str, String str2, String str3, boolean z) {
        Context context = getContext();
        if (context == null) {
            return;
        }
        a(context, str, str2, str3, true);
    }

    public static long ab(Context context, String str) {
        if (context == null) {
            return 0L;
        }
        return b(context, "ksadsdk_pref", str, 0L);
    }

    public static long ac(Context context, String str) {
        if (context == null) {
            return 0L;
        }
        return b(context, "ksadsdk_download_package_length", str, 0L);
    }

    public static String ad(Context context, String str) {
        return context == null ? "" : b(context, "ksadsdk_download_package_md5", str, "");
    }

    public static void ae(@NonNull Context context, String str) {
        if (context == null) {
            return;
        }
        a(context, "ksadsdk_egid", "KEY_SDK_EGID", str);
    }

    public static void af(@NonNull Context context, String str) {
        if (context == null) {
            return;
        }
        a(context, "ksadsdk_uaid", "KEY_SDK_UAID", str);
    }

    public static void ag(@NonNull Context context, String str) {
        if (context == null) {
            return;
        }
        a(context, "ksadsdk_uaid_token", "KEY_SDK_UAID_TOKEN", str);
    }

    public static void ah(@NonNull Context context, String str) {
        if (context == null) {
            return;
        }
        a("ksadsdk_model", "KEY_SDK_MODEL", str, true);
    }

    public static void ai(Context context, String str) {
        if (context == null) {
            return;
        }
        a(context, "ksadsdk_interstitial_daily_show_count", "KEY_INTERSTITIAL_DAILY_SHOW_COUNT", str);
    }

    public static void aj(@NonNull Context context, String str) {
        if (context == null) {
            return;
        }
        a(context, "ksadsdk_reward_full_ad_jump_direct", "KEY_REWARD_INTERACT_AD_SHOW_INFO", str);
    }

    public static void ak(Context context, String str) {
        if (context == null) {
            return;
        }
        a(context, "ksadsdk_reward_full_ad_jump_direct", "KEY_REWARD_FULL_AD_JUMP_DIRECT", str);
    }

    public static void al(@NonNull Context context, String str) {
        if (context == null) {
            return;
        }
        a(context, "ksadsdk_splash_local_ad_force_active", "KEY_SPLASH_DAILY_SHOW_COUNT", str);
        bp.WA();
    }

    public static void am(Context context, String str) {
        if (context == null) {
            return;
        }
        a(context, "ksadsdk_reward_full_ad_jump_direct", "KEY_REWARD_AUTO_CALL_APP_CARD_SHOW_COUNT", str);
        bp.WC();
    }

    public static void an(Context context, String str) {
        if (context == null) {
            return;
        }
        a(context, "ksadsdk_interstitial_daily_show_count", "KEY_INTERSTITIAL_AUTO_CALL_APP_CARD_SHOW_COUNT", str);
    }

    public static void ao(@NonNull Context context, String str) {
        if (context == null) {
            return;
        }
        a(context, "ksadsdk_device_sig", "KEY_SDK_DEVICE_SIG", str);
    }

    public static void ap(Context context, final String str) {
        if (context == null || TextUtils.isEmpty(str)) {
            return;
        }
        i.execute(new bi() { // from class: com.kwad.sdk.utils.ai.1
            @Override // com.kwad.sdk.utils.bi
            public final void doTask() {
                ai.aq(ServiceProvider.getContext(), str);
            }
        });
    }

    public static void aq(Context context, String str) {
        if (context == null) {
            return;
        }
        a(context, "ksadsdk_pref", "appTag", str);
    }

    public static void ar(Context context, String str) {
        if (context == null) {
            return;
        }
        a("ksadsdk_pref", "webview_ua", str, true);
    }

    @WorkerThread
    public static void as(Context context, String str) {
        if (context == null || TextUtils.isEmpty(str)) {
            return;
        }
        bp.j(context.getApplicationContext(), "ksadsdk_sdk_config_data", str);
    }

    public static void at(Context context, String str) {
        if (context == null) {
            return;
        }
        h("ksadsdk_install_tips_show_count", "init_install_tips_show_count", str);
    }

    private static Map<String, ?> au(Context context, String str) {
        if (context == null) {
            return null;
        }
        if (!ah.hN(str)) {
            return com.kwad.sdk.utils.a.e.aF(context, str).getAll();
        }
        SharedPreferences sharedPreferencesM1068if = bq.m1068if(str);
        if (sharedPreferencesM1068if != null) {
            return sharedPreferencesM1068if.getAll();
        }
        return null;
    }

    public static void ay(String str, String str2) {
        if (str == null || str2 == null) {
            return;
        }
        a("ksadsdk_reward_task_cache", str, str2, true);
    }

    public static void az(String str, String str2) {
        Context context = getContext();
        if (context == null) {
            return;
        }
        h(context, str, str2);
    }

    public static long b(String str, String str2, long j) {
        Context context = getContext();
        return context == null ? j : b(context, str, str2, j);
    }

    public static void be(long j) {
        a("ksadsdk_push_ad_common", "key_push_last_show_time", j);
    }

    public static void bf(long j) {
        a("ksadsdk_perf", "image_load_complete_count", b("ksadsdk_perf", "image_load_complete_count", 0) + 1);
        a("ksadsdk_perf", "image_load_complete_total", b("ksadsdk_perf", "image_load_complete_total", 0L) + j);
    }

    public static void c(Context context, String str, boolean z) {
        if (context == null || TextUtils.isEmpty(str)) {
            return;
        }
        bpt = z;
        bpu = false;
        a("ksadsdk_inner_ec_user_login_bind_info", "inner_ec_login_bind_info", str, true);
    }

    public static void d(@NonNull Context context, long j) {
        if (context == null) {
            return;
        }
        a(context, "ksadsdk_gidExpireTimeMs", "KEY_SDK_EGID", j);
    }

    public static String dm(@NonNull Context context) {
        return context == null ? "" : b(context, "ksadsdk_egid", "KEY_SDK_EGID", "");
    }

    private static String dn(@NonNull Context context) {
        return context == null ? "" : b(context, "ksadsdk_uaid", "KEY_SDK_UAID", "");
    }

    /* JADX INFO: renamed from: do, reason: not valid java name */
    public static String m1067do(@NonNull Context context) {
        return context == null ? "" : b(context, "ksadsdk_uaid_token", "KEY_SDK_UAID_TOKEN", "");
    }

    public static long dp(@NonNull Context context) {
        if (context == null) {
            return 0L;
        }
        return b(context, "ksadsdk_gidExpireTimeMs", "KEY_SDK_EGID", 0L);
    }

    public static int dq(@NonNull Context context) {
        if (context == null) {
            return 0;
        }
        return b(context, "ksadsdk_config_request", "KEY_CONFIG_REQUEST_FAIL", 0);
    }

    public static String dr(@NonNull Context context) {
        if (context == null) {
            return "";
        }
        String strB = b(context, "ksadsdk_model", "KEY_SDK_MODEL", "");
        bq.j(strB, "ksadsdk_model", "KEY_SDK_MODEL");
        return strB;
    }

    public static int ds(@NonNull Context context) {
        if (context == null) {
            return 0;
        }
        return b(context, "ksadsdk_reward_full_ad_jump_direct", "KEY_REWARD_AD_SHOW_INTERACT_INTERVAL_SHOW_COUNT", 0);
    }

    public static String dt(@NonNull Context context) {
        return context == null ? "" : b(context, "ksadsdk_reward_full_ad_jump_direct", "KEY_REWARD_INTERACT_AD_SHOW_INFO", "");
    }

    public static String du(@NonNull Context context) {
        return context == null ? "" : b(context, "ksadsdk_device_sig", "KEY_SDK_DEVICE_SIG", "");
    }

    public static String dv(Context context) {
        if (context == null) {
            return "";
        }
        String strI = i("ksadsdk_pref", "webview_ua", "");
        bq.j(strI, "ksadsdk_pref", "webview_ua");
        return strI;
    }

    @WorkerThread
    public static String dw(Context context) {
        if (bp.Wy()) {
            return bp.aE(context.getApplicationContext(), "ksadsdk_sdk_config_data");
        }
        String strI = bq.i("ksadsdk_sdk_config_data", "config_str", "");
        bp.i(context.getApplicationContext(), "ksadsdk_sdk_config_data", strI);
        return strI;
    }

    public static void e(Context context, String str, long j) {
        if (context == null) {
            return;
        }
        a(context, "ksadsdk_pref", str, j);
    }

    public static void f(Context context, String str, long j) {
        if (context == null) {
            return;
        }
        a(context, "ksadsdk_download_package_length", str, j);
    }

    public static void fW(int i) {
        Context context = ServiceProvider.getContext();
        if (context == null) {
            return;
        }
        a(context, "ksadsdk_perf", "ksadsdk_soft_height", i);
    }

    public static void g(Context context, String str, String str2) {
        if (context == null) {
            return;
        }
        a(context, "ksadsdk_download_package_md5", str, str2);
    }

    @Nullable
    public static Context getContext() {
        return ServiceProvider.Ud();
    }

    public static String getEGid() {
        Context context = getContext();
        return context == null ? "" : dm(context);
    }

    public static void h(String str, String str2, String str3) {
        Context context = getContext();
        if (context == null) {
            return;
        }
        a(context, str, str2, str3);
    }

    @Nullable
    public static Map<String, ?> hO(String str) {
        Context context = getContext();
        if (context == null) {
            return null;
        }
        return au(context, str);
    }

    public static String i(String str, String str2, String str3) {
        Context context = getContext();
        return context == null ? str3 : b(context, str, str2, str3);
    }

    public static void j(String str, String str2, String str3) {
        if (ah.hN(str2)) {
            bq.j(str, str2, str3);
        }
    }

    public static void l(@NonNull Context context, int i) {
        if (context == null) {
            return;
        }
        a(context, "ksadsdk_config_request", "KEY_CONFIG_REQUEST_FAIL", i);
    }

    public static void m(@NonNull Context context, int i) {
        if (context == null) {
            return;
        }
        a(context, "ksadsdk_reward_full_ad_jump_direct", "KEY_REWARD_AD_SHOW_INTERACT_INTERVAL_SHOW_COUNT", i);
    }

    public static void e(@NonNull Context context, long j) {
        if (context == null) {
            return;
        }
        a(context, "ksadsdk_uaid_create_time", "KEY_SDK_UAID_CREATE_TIME", j);
    }

    public static void f(@NonNull Context context, long j) {
        if (context == null) {
            return;
        }
        a(context, "ksadsdk_uaid_expire_sec", "KEY_SDK_UAID_EXPIRE_SEC", j);
    }

    public static void g(Context context, boolean z) {
        if (context == null) {
            return;
        }
        bpu = true;
        az("ksadsdk_inner_ec_user_login_bind_info", "inner_ec_login_bind_info");
    }

    public static void l(String str, String str2, boolean z) {
        Context context = getContext();
        if (context == null) {
            return;
        }
        b(context, str, str2, z);
    }

    public static boolean m(String str, String str2, boolean z) {
        Context context = getContext();
        return context == null ? z : c(context, str, str2, z);
    }

    public static void a(String str, String str2, long j) {
        Context context = getContext();
        if (context == null) {
            return;
        }
        a(context, str, str2, j);
    }

    public static int b(String str, String str2, int i) {
        Context context = getContext();
        return context == null ? i : b(context, str, str2, i);
    }

    public static void e(@NonNull Context context, boolean z) {
        if (context == null) {
            return;
        }
        b(context, "ksadsdk_uaid_enable", "KEY_SDK_UAID_ENABLE", z);
    }

    public static String f(Context context, boolean z) {
        if (context == null || bpu) {
            return "";
        }
        if (z) {
            bpt = false;
        }
        return i("ksadsdk_inner_ec_user_login_bind_info", "inner_ec_login_bind_info", "");
    }

    public static void h(Context context, String str, String str2) {
        if (context == null) {
            return;
        }
        if (ah.hN(str)) {
            bq.az(str, str2);
        } else {
            com.kwad.sdk.utils.a.e.aF(context, str).remove(str2);
            ah.aw(str2, "");
        }
    }

    public static void a(String str, String str2, int i) {
        Context context = getContext();
        if (context == null) {
            return;
        }
        a(context, str, str2, i);
    }

    public static String b(Context context, String str, String str2, String str3) {
        String string;
        if (context == null) {
            return str3;
        }
        if (ah.hN(str)) {
            string = bq.i(str, str2, str3);
            if (com.kwad.framework.a.a.pe.booleanValue()) {
                com.kwad.sdk.core.d.c.d("Ks_UnionUtils", "getString From Sp key:" + str2 + " value:" + string);
            }
        } else {
            string = com.kwad.sdk.utils.a.e.aF(context, str).getString(str2, str3);
            ah.ax(str2, string);
            if (com.kwad.framework.a.a.pe.booleanValue()) {
                com.kwad.sdk.core.d.c.d("Ks_UnionUtils", "getString key:" + str2 + " value:" + string);
            }
        }
        return com.kwad.sdk.core.a.c.isEncodeKsSdk(string) ? com.kwad.sdk.core.a.c.decodeKsSdk(string) : string;
    }

    private static boolean c(Context context, String str, String str2, boolean z) {
        if (context == null) {
            return z;
        }
        if (ah.hN(str)) {
            return bq.m(str, str2, z);
        }
        return com.kwad.sdk.utils.a.e.aF(context, str).getBoolean(str2, z);
    }

    public static void a(Context context, @NonNull String str, @NonNull String str2, String str3) {
        if (context == null) {
            return;
        }
        if (ah.hN(str)) {
            bq.h(str, str2, str3);
            if (com.kwad.framework.a.a.pe.booleanValue()) {
                com.kwad.sdk.core.d.c.d("Ks_UnionUtils", "putString Sp key:" + str2 + " value:" + str3);
                return;
            }
            return;
        }
        com.kwad.sdk.utils.a.e.aF(context, str).putString(str2, str3);
        if (com.kwad.framework.a.a.pe.booleanValue()) {
            com.kwad.sdk.core.d.c.d("Ks_UnionUtils", "putString key:" + str2 + " value:" + str3);
        }
        ah.aw(str2, str3);
    }

    private static void a(Context context, @NonNull String str, @NonNull String str2, String str3, boolean z) {
        if (context == null) {
            return;
        }
        if (ah.hN(str)) {
            bq.a(str, str2, str3, z);
            if (com.kwad.framework.a.a.pe.booleanValue()) {
                com.kwad.sdk.core.d.c.d("Ks_UnionUtils", "putString Sp key:" + str2 + " value:" + str3);
                return;
            }
            return;
        }
        com.kwad.sdk.utils.a.e.aF(context, str).putString(str2, str3);
        if (com.kwad.framework.a.a.pe.booleanValue()) {
            com.kwad.sdk.core.d.c.d("Ks_UnionUtils", "putString key:" + str2 + " value:" + str3);
        }
        ah.aw(str2, str3);
    }

    private static long b(Context context, String str, String str2, long j) {
        if (context == null) {
            return j;
        }
        if (ah.hN(str)) {
            return bq.b(str, str2, j);
        }
        return com.kwad.sdk.utils.a.e.aF(context, str).getLong(str2, j);
    }

    private static int b(Context context, String str, String str2, int i) {
        if (context == null) {
            return i;
        }
        if (ah.hN(str)) {
            return bq.b(str, str2, i);
        }
        return com.kwad.sdk.utils.a.e.aF(context, str).getInt(str2, i);
    }

    private static void b(Context context, String str, String str2, boolean z) {
        if (context == null) {
            return;
        }
        if (ah.hN(str)) {
            bq.l(str, str2, z);
        } else {
            com.kwad.sdk.utils.a.e.aF(context, str).putBoolean(str2, z);
        }
    }

    private static void a(Context context, String str, String str2, long j) {
        if (context == null) {
            return;
        }
        if (ah.hN(str)) {
            bq.a(str, str2, j);
        } else {
            com.kwad.sdk.utils.a.e.aF(context, str).putLong(str2, j);
        }
    }

    private static void a(Context context, String str, String str2, int i) {
        if (context == null) {
            return;
        }
        if (ah.hN(str)) {
            bq.a(str, str2, i);
        } else {
            com.kwad.sdk.utils.a.e.aF(context, str).putInt(str2, i);
        }
    }
}
