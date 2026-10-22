package com.blankj.utilcode.util;

import android.os.Build;
import android.os.Environment;
import android.text.TextUtils;
import com.acse.ottn.p3;
import com.ali.auth.third.login.LoginConstants;
import com.igexin.assist.util.AssistUtils;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Properties;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final String f1426a = "ro.build.version.emui";
    public static final String b = "ro.vivo.os.build.display.id";
    public static final String c = "ro.build.version.incremental";
    public static final String d = "ro.build.version.opporom";
    public static final String e = "ro.letv.release.version";
    public static final String f = "ro.build.uiversion";
    public static final String g = "ro.build.MiFavor_version";
    public static final String h = "ro.rom.version";
    public static final String i = "ro.build.rom.id";
    public static final String j = "unknown";

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final String[] f1427a = {AssistUtils.BRAND_HW};

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public static final String[] f1428b = {"vivo"};

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public static final String[] f1429c = {"xiaomi"};

    /* JADX INFO: renamed from: d, reason: collision with other field name */
    public static final String[] f1430d = {"oppo"};

    /* JADX INFO: renamed from: e, reason: collision with other field name */
    public static final String[] f1431e = {"leeco", "letv"};

    /* JADX INFO: renamed from: f, reason: collision with other field name */
    public static final String[] f1432f = {"360", "qiku"};

    /* JADX INFO: renamed from: g, reason: collision with other field name */
    public static final String[] f1433g = {"zte"};

    /* JADX INFO: renamed from: h, reason: collision with other field name */
    public static final String[] f1434h = {"oneplus"};

    /* JADX INFO: renamed from: i, reason: collision with other field name */
    public static final String[] f1435i = {"nubia"};

    /* JADX INFO: renamed from: j, reason: collision with other field name */
    public static final String[] f1436j = {"coolpad", "yulong"};
    public static final String[] k = {"lg", "lge"};
    public static final String[] l = {"google"};
    public static final String[] m = {"samsung"};
    public static final String[] n = {AssistUtils.BRAND_MZ};
    public static final String[] o = {"lenovo"};
    public static final String[] p = {"smartisan", "deltainno"};
    public static final String[] q = {"htc"};
    public static final String[] r = {"sony"};
    public static final String[] s = {"gionee", "amigo"};
    public static final String[] t = {"motorola"};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static a f28222a = null;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f28223a;
        public String b;

        public String d() {
            return this.f28223a;
        }

        public String e() {
            return this.b;
        }

        public String toString() {
            return "RomInfo{name=" + this.f28223a + ", version=" + this.b + "}";
        }
    }

    public e() {
        throw new UnsupportedOperationException("u can't instantiate me...");
    }

    public static boolean A() {
        return f1428b[0].equals(c().f28223a);
    }

    public static boolean B() {
        return f1429c[0].equals(c().f28223a);
    }

    public static boolean C() {
        return f1433g[0].equals(c().f28223a);
    }

    public static String a() {
        try {
            String str = Build.BRAND;
            return !TextUtils.isEmpty(str) ? str.toLowerCase() : "unknown";
        } catch (Throwable unused) {
            return "unknown";
        }
    }

    public static String b() {
        try {
            String str = Build.MANUFACTURER;
            return !TextUtils.isEmpty(str) ? str.toLowerCase() : "unknown";
        } catch (Throwable unused) {
            return "unknown";
        }
    }

    public static a c() {
        a aVar = f28222a;
        if (aVar != null) {
            return aVar;
        }
        f28222a = new a();
        String strA = a();
        String strB = b();
        String[] strArr = f1427a;
        if (w(strA, strB, strArr)) {
            f28222a.f28223a = strArr[0];
            String strD = d("ro.build.version.emui");
            String[] strArrSplit = strD.split(LoginConstants.UNDER_LINE);
            if (strArrSplit.length > 1) {
                f28222a.b = strArrSplit[1];
            } else {
                f28222a.b = strD;
            }
            return f28222a;
        }
        String[] strArr2 = f1428b;
        if (w(strA, strB, strArr2)) {
            f28222a.f28223a = strArr2[0];
            f28222a.b = d(b);
            return f28222a;
        }
        String[] strArr3 = f1429c;
        if (w(strA, strB, strArr3)) {
            f28222a.f28223a = strArr3[0];
            f28222a.b = d(c);
            return f28222a;
        }
        String[] strArr4 = f1430d;
        if (w(strA, strB, strArr4)) {
            f28222a.f28223a = strArr4[0];
            f28222a.b = d(d);
            return f28222a;
        }
        String[] strArr5 = f1431e;
        if (w(strA, strB, strArr5)) {
            f28222a.f28223a = strArr5[0];
            f28222a.b = d(e);
            return f28222a;
        }
        String[] strArr6 = f1432f;
        if (w(strA, strB, strArr6)) {
            f28222a.f28223a = strArr6[0];
            f28222a.b = d(f);
            return f28222a;
        }
        String[] strArr7 = f1433g;
        if (w(strA, strB, strArr7)) {
            f28222a.f28223a = strArr7[0];
            f28222a.b = d(g);
            return f28222a;
        }
        String[] strArr8 = f1434h;
        if (w(strA, strB, strArr8)) {
            f28222a.f28223a = strArr8[0];
            f28222a.b = d(h);
            return f28222a;
        }
        String[] strArr9 = f1435i;
        if (w(strA, strB, strArr9)) {
            f28222a.f28223a = strArr9[0];
            f28222a.b = d(i);
            return f28222a;
        }
        String[] strArr10 = f1436j;
        if (w(strA, strB, strArr10)) {
            f28222a.f28223a = strArr10[0];
        } else {
            String[] strArr11 = k;
            if (w(strA, strB, strArr11)) {
                f28222a.f28223a = strArr11[0];
            } else {
                String[] strArr12 = l;
                if (w(strA, strB, strArr12)) {
                    f28222a.f28223a = strArr12[0];
                } else {
                    String[] strArr13 = m;
                    if (w(strA, strB, strArr13)) {
                        f28222a.f28223a = strArr13[0];
                    } else {
                        String[] strArr14 = n;
                        if (w(strA, strB, strArr14)) {
                            f28222a.f28223a = strArr14[0];
                        } else {
                            String[] strArr15 = o;
                            if (w(strA, strB, strArr15)) {
                                f28222a.f28223a = strArr15[0];
                            } else {
                                String[] strArr16 = p;
                                if (w(strA, strB, strArr16)) {
                                    f28222a.f28223a = strArr16[0];
                                } else {
                                    String[] strArr17 = q;
                                    if (w(strA, strB, strArr17)) {
                                        f28222a.f28223a = strArr17[0];
                                    } else {
                                        String[] strArr18 = r;
                                        if (w(strA, strB, strArr18)) {
                                            f28222a.f28223a = strArr18[0];
                                        } else {
                                            String[] strArr19 = s;
                                            if (w(strA, strB, strArr19)) {
                                                f28222a.f28223a = strArr19[0];
                                            } else {
                                                String[] strArr20 = t;
                                                if (w(strA, strB, strArr20)) {
                                                    f28222a.f28223a = strArr20[0];
                                                } else {
                                                    f28222a.f28223a = strB;
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        f28222a.b = d("");
        return f28222a;
    }

    public static String d(String str) {
        String strE = !TextUtils.isEmpty(str) ? e(str) : "";
        if (TextUtils.isEmpty(strE) || strE.equals("unknown")) {
            try {
                String str2 = Build.DISPLAY;
                if (!TextUtils.isEmpty(str2)) {
                    strE = str2.toLowerCase();
                }
            } catch (Throwable unused) {
            }
        }
        return TextUtils.isEmpty(strE) ? "unknown" : strE;
    }

    public static String e(String str) throws Throwable {
        String strG = g(str);
        if (!TextUtils.isEmpty(strG)) {
            return strG;
        }
        String strH = h(str);
        return (TextUtils.isEmpty(strH) && Build.VERSION.SDK_INT < 28) ? f(str) : strH;
    }

    public static String f(String str) {
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            return (String) cls.getMethod(p3.f, String.class, String.class).invoke(cls, str, "");
        } catch (Exception unused) {
            return "";
        }
    }

    public static String g(String str) throws Throwable {
        BufferedReader bufferedReader = null;
        try {
            try {
                BufferedReader bufferedReader2 = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec("getprop " + str).getInputStream()), 1024);
                try {
                    String line = bufferedReader2.readLine();
                    if (line != null) {
                        try {
                            bufferedReader2.close();
                        } catch (IOException unused) {
                        }
                        return line;
                    }
                    bufferedReader2.close();
                    return "";
                } catch (IOException unused2) {
                    bufferedReader = bufferedReader2;
                    if (bufferedReader == null) {
                        return "";
                    }
                    bufferedReader.close();
                } catch (Throwable th) {
                    th = th;
                    bufferedReader = bufferedReader2;
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                        } catch (IOException unused3) {
                        }
                    }
                    throw th;
                }
            } catch (IOException unused4) {
                return "";
            }
        } catch (IOException unused5) {
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static String h(String str) {
        try {
            Properties properties = new Properties();
            properties.load(new FileInputStream(new File(Environment.getRootDirectory(), "build.prop")));
            return properties.getProperty(str, "");
        } catch (Exception unused) {
            return "";
        }
    }

    public static boolean i() {
        return f1432f[0].equals(c().f28223a);
    }

    public static boolean j() {
        return f1436j[0].equals(c().f28223a);
    }

    public static boolean k() {
        return s[0].equals(c().f28223a);
    }

    public static boolean l() {
        return l[0].equals(c().f28223a);
    }

    public static boolean m() {
        return q[0].equals(c().f28223a);
    }

    public static boolean n() {
        return f1427a[0].equals(c().f28223a);
    }

    public static boolean o() {
        return f1431e[0].equals(c().f28223a);
    }

    public static boolean p() {
        return o[0].equals(c().f28223a);
    }

    public static boolean q() {
        return k[0].equals(c().f28223a);
    }

    public static boolean r() {
        return n[0].equals(c().f28223a);
    }

    public static boolean s() {
        return t[0].equals(c().f28223a);
    }

    public static boolean t() {
        return f1435i[0].equals(c().f28223a);
    }

    public static boolean u() {
        return f1434h[0].equals(c().f28223a);
    }

    public static boolean v() {
        return f1430d[0].equals(c().f28223a);
    }

    public static boolean w(String str, String str2, String... strArr) {
        for (String str3 : strArr) {
            if (str.contains(str3) || str2.contains(str3)) {
                return true;
            }
        }
        return false;
    }

    public static boolean x() {
        return m[0].equals(c().f28223a);
    }

    public static boolean y() {
        return p[0].equals(c().f28223a);
    }

    public static boolean z() {
        return r[0].equals(c().f28223a);
    }
}
