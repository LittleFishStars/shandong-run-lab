package com.czhj.sdk.common.utils;

import android.os.Build;
import android.os.Environment;
import android.text.TextUtils;
import com.acse.ottn.p3;
import com.acse.ottn.p4;
import com.ali.auth.third.login.LoginConstants;
import com.blankj.utilcode.util.e;
import com.igexin.assist.util.AssistUtils;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Properties;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class RomUtils {
    private static final String A = "ro.build.uiversion";
    private static final String B = "ro.build.MiFavor_version";
    private static final String C = "ro.rom.version";
    private static final String D = "ro.build.rom.id";
    private static final String E = "hw_sc.build.platform.version";
    private static final String G = "unknown";
    private static final String v = "ro.build.version.emui";
    private static final String w = "ro.vivo.os.build.display.id";
    private static final String x = "ro.build.version.incremental";
    private static final String z = "ro.letv.release.version";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String[] f29450a = {AssistUtils.BRAND_HW};
    private static final String[] b = {"vivo"};
    private static final String[] c = {"xiaomi"};
    private static final String[] d = {"oppo"};
    private static final String[] e = {"leeco", "letv"};
    private static final String[] f = {"360", "qiku"};
    private static final String[] g = {"zte"};
    private static final String[] h = {"oneplus"};
    private static final String[] i = {"nubia"};
    private static final String[] j = {"coolpad", "yulong"};
    private static final String[] k = {"lg", "lge"};
    private static final String[] l = {"google"};
    private static final String[] m = {"samsung"};
    private static final String[] n = {AssistUtils.BRAND_MZ};
    private static final String[] o = {"lenovo"};
    private static final String[] p = {"SmartisanOS", "deltainno"};
    private static final String[] q = {"Sense", "htc"};
    private static final String[] r = {"sony"};
    private static final String[] s = {"amigo", "gionee"};
    private static final String[] t = {"motorola"};
    private static final String[] u = {AssistUtils.BRAND_HON};
    private static final String[] y = {e.d, "ro.build.version.oplusrom.display"};
    private static final String[] F = {"msc.config.magic.version", "ro.build.version.magic"};
    private static RomInfo H = null;

    public static class RomInfo {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private String f29451a;
        private String b;
        private String c;

        public String getName() {
            return this.f29451a;
        }

        public String getOsMarket() {
            return this.c;
        }

        public String getVersion() {
            return this.b;
        }

        public String toString() {
            return "RomInfo{name=" + this.f29451a + ", version=" + this.b + ", osMarket=" + this.c + "}";
        }
    }

    private RomUtils() {
        throw new UnsupportedOperationException("u can't instantiate me...");
    }

    private static String a(String str) {
        String strB = !TextUtils.isEmpty(str) ? b(str) : "";
        if (TextUtils.isEmpty(strB) || strB.equals("unknown")) {
            try {
                String str2 = Build.DISPLAY;
                if (!TextUtils.isEmpty(str2)) {
                    strB = str2.toLowerCase();
                }
            } catch (Throwable unused) {
            }
        }
        return TextUtils.isEmpty(strB) ? "unknown" : strB;
    }

    public static boolean a() {
        return a(d(), c(), u);
    }

    private static boolean a(String str, String str2, String... strArr) {
        for (String str3 : strArr) {
            if (str.contains(str3) || str2.contains(str3)) {
                return true;
            }
        }
        return false;
    }

    private static String b(String str) {
        String strC = c(str);
        if (!TextUtils.isEmpty(strC)) {
            return strC;
        }
        String strD = d(str);
        return (TextUtils.isEmpty(strD) && Build.VERSION.SDK_INT < 28) ? e(str) : strD;
    }

    private static boolean b() {
        return !TextUtils.isEmpty(b("ro.build.version.emui"));
    }

    private static String c() {
        try {
            String str = Build.MANUFACTURER;
            return !TextUtils.isEmpty(str) ? str.toLowerCase() : "unknown";
        } catch (Throwable unused) {
            return "unknown";
        }
    }

    private static String c(String str) {
        BufferedReader bufferedReader = null;
        try {
            try {
                BufferedReader bufferedReader2 = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec("getprop " + str).getInputStream()), 1024);
                try {
                    String line = bufferedReader2.readLine();
                    if (line != null) {
                        try {
                            bufferedReader2.close();
                        } catch (Throwable unused) {
                        }
                        return line;
                    }
                    bufferedReader2.close();
                    return "";
                } catch (Throwable unused2) {
                    bufferedReader = bufferedReader2;
                    if (bufferedReader == null) {
                        return "";
                    }
                    bufferedReader.close();
                }
            } catch (Throwable unused3) {
            }
        } catch (Throwable unused4) {
            return "";
        }
    }

    private static String d() {
        try {
            String str = Build.BRAND;
            return !TextUtils.isEmpty(str) ? str.toLowerCase() : "unknown";
        } catch (Throwable unused) {
            return "unknown";
        }
    }

    private static String d(String str) {
        try {
            Properties properties = new Properties();
            properties.load(new FileInputStream(new File(Environment.getRootDirectory(), "build.prop")));
            return properties.getProperty(str, "");
        } catch (Exception unused) {
            return "";
        }
    }

    private static String e(String str) {
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            return (String) cls.getMethod(p3.f, String.class, String.class).invoke(cls, str, "");
        } catch (Exception unused) {
            return "";
        }
    }

    public static RomInfo getRomInfo() {
        RomInfo romInfo;
        RomInfo romInfo2;
        String str;
        RomInfo romInfo3;
        String str2;
        RomInfo romInfo4;
        String str3;
        RomInfo romInfo5;
        String str4;
        RomInfo romInfo6;
        String strA;
        RomInfo romInfo7 = H;
        if (romInfo7 != null) {
            return romInfo7;
        }
        H = new RomInfo();
        String strD = d();
        String strC = c();
        if (!isHarmonyOs()) {
            if (a(strD, strC, f29450a)) {
                H.f29451a = "EMUI";
                String strA2 = a("ro.build.version.emui");
                String[] strArrSplit = strA2.split(LoginConstants.UNDER_LINE);
                if (strArrSplit.length > 1) {
                    romInfo6 = H;
                    strA = strArrSplit[1];
                } else {
                    H.b = strA2;
                }
                H.c = "com.huawei.appmarket";
            } else {
                int i2 = 0;
                if (a(strD, strC, u)) {
                    H.f29451a = "MagicOS";
                    String[] strArr = F;
                    int length = strArr.length;
                    while (i2 < length) {
                        String str5 = strArr[i2];
                        String strA3 = a(str5);
                        if (!TextUtils.isEmpty(str5)) {
                            H.b = strA3;
                        }
                        i2++;
                    }
                    romInfo4 = H;
                    str3 = "com.hihonor.appmarket";
                } else if (a(strD, strC, b)) {
                    H.f29451a = "OriginOS";
                    H.b = a("ro.vivo.os.build.display.id");
                    romInfo4 = H;
                    str3 = "com.bbk.appstore";
                } else if (a(strD, strC, c)) {
                    H.f29451a = "MIUI";
                    H.b = a("ro.build.version.incremental");
                    romInfo4 = H;
                    str3 = "com.xiaomi.market";
                } else {
                    if (a(strD, strC, d)) {
                        H.f29451a = "ColorOS";
                        String[] strArr2 = y;
                        int length2 = strArr2.length;
                        while (i2 < length2) {
                            String str6 = strArr2[i2];
                            String strA4 = a(str6);
                            if (!TextUtils.isEmpty(str6)) {
                                H.b = strA4;
                            }
                            i2++;
                        }
                        if (Build.VERSION.SDK_INT < 29) {
                            romInfo5 = H;
                            str4 = "com.oppo.market";
                        } else {
                            romInfo5 = H;
                            str4 = "com.heytap.market";
                        }
                        romInfo5.c = str4;
                        return H;
                    }
                    if (a(strD, strC, e)) {
                        H.f29451a = "EUI";
                        romInfo3 = H;
                        str2 = "ro.letv.release.version";
                    } else {
                        String[] strArr3 = f;
                        if (a(strD, strC, strArr3)) {
                            H.f29451a = strArr3[0];
                            romInfo3 = H;
                            str2 = "ro.build.uiversion";
                        } else {
                            String[] strArr4 = g;
                            if (a(strD, strC, strArr4)) {
                                H.f29451a = strArr4[0];
                                romInfo3 = H;
                                str2 = "ro.build.MiFavor_version";
                            } else {
                                String[] strArr5 = h;
                                if (a(strD, strC, strArr5)) {
                                    H.f29451a = strArr5[0];
                                    romInfo3 = H;
                                    str2 = "ro.rom.version";
                                } else if (a(strD, strC, i)) {
                                    H.f29451a = "NubiaUI";
                                    H.b = a("ro.build.rom.id");
                                    romInfo4 = H;
                                    str3 = "cn.nubia.neostore";
                                } else {
                                    String[] strArr6 = j;
                                    if (a(strD, strC, strArr6)) {
                                        romInfo = H;
                                        strC = strArr6[0];
                                    } else {
                                        String[] strArr7 = k;
                                        if (a(strD, strC, strArr7)) {
                                            romInfo = H;
                                            strC = strArr7[0];
                                        } else {
                                            String[] strArr8 = l;
                                            if (a(strD, strC, strArr8)) {
                                                romInfo = H;
                                                strC = strArr8[0];
                                            } else {
                                                String[] strArr9 = m;
                                                if (a(strD, strC, strArr9)) {
                                                    romInfo = H;
                                                    strC = strArr9[0];
                                                } else {
                                                    if (a(strD, strC, n)) {
                                                        H.f29451a = "Flyme";
                                                        romInfo2 = H;
                                                        str = "com.meizu.mstore";
                                                    } else {
                                                        String[] strArr10 = o;
                                                        if (a(strD, strC, strArr10)) {
                                                            romInfo = H;
                                                            strC = strArr10[0];
                                                        } else {
                                                            String[] strArr11 = p;
                                                            if (a(strD, strC, strArr11)) {
                                                                H.f29451a = strArr11[0];
                                                                romInfo2 = H;
                                                                str = "com.smartisanos.appstore";
                                                            } else {
                                                                String[] strArr12 = q;
                                                                if (a(strD, strC, strArr12)) {
                                                                    romInfo = H;
                                                                    strC = strArr12[0];
                                                                } else {
                                                                    String[] strArr13 = r;
                                                                    if (a(strD, strC, strArr13)) {
                                                                        romInfo = H;
                                                                        strC = strArr13[0];
                                                                    } else {
                                                                        String[] strArr14 = s;
                                                                        if (a(strD, strC, strArr14)) {
                                                                            romInfo = H;
                                                                            strC = strArr14[0];
                                                                        } else {
                                                                            String[] strArr15 = t;
                                                                            if (a(strD, strC, strArr15)) {
                                                                                romInfo = H;
                                                                                strC = strArr15[0];
                                                                            } else {
                                                                                romInfo = H;
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                    romInfo2.c = str;
                                                    romInfo3 = H;
                                                    str2 = "";
                                                }
                                            }
                                        }
                                    }
                                    romInfo.f29451a = strC;
                                    romInfo3 = H;
                                    str2 = "";
                                }
                            }
                        }
                    }
                    romInfo3.b = a(str2);
                }
                romInfo4.c = str3;
            }
            return H;
        }
        H.f29451a = p4.f23132a;
        romInfo6 = H;
        strA = a("hw_sc.build.platform.version");
        romInfo6.b = strA;
        H.c = "com.huawei.appmarket";
        return H;
    }

    public static boolean isHarmonyOs() {
        if (Build.VERSION.SDK_INT < 29) {
            return false;
        }
        try {
            Class<?> cls = Class.forName("com.huawei.system.BuildEx");
            Object objInvoke = cls.getMethod("getOsBrand", new Class[0]).invoke(cls, new Object[0]);
            if (objInvoke == null) {
                return false;
            }
            return p4.f23132a.equalsIgnoreCase(objInvoke.toString());
        } catch (Throwable unused) {
            return false;
        }
    }

    public static boolean isHuawei() {
        return "EMUI".equals(getRomInfo().f29451a) || isHarmonyOs();
    }
}
