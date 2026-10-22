package cj.mobile.jt.core;

import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_13_8952cls.dex */
public class AdSettings {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String f22453a = null;
    public static String b = null;
    public static boolean c = true;
    public static boolean d = false;
    public static boolean e = true;
    public static boolean f = true;
    public static boolean g = true;
    public static boolean h = true;
    public static boolean i = true;
    public static boolean j = true;
    public static boolean k = true;
    public static boolean l = true;
    public static JuTuiLocation m = null;
    public static String n = "";
    public static String o = "";
    public static String p = "";
    public static String q = "";
    public static List r;

    public static String getAppId() {
        return f22453a;
    }

    public static String getToken() {
        return b;
    }

    public static void init(JuTuiPrivacyController juTuiPrivacyController) {
    }

    public static boolean isDebug() {
        return d;
    }

    public static boolean needPersonalRecommend() {
        return c;
    }

    public static void setAppId(String str) {
        f22453a = str;
    }

    public static void setNeedPersonalRecommend(boolean z) {
        c = z;
    }

    public static void setToken(String str) {
        b = str;
    }
}
