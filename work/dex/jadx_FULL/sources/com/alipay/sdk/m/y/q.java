package com.alipay.sdk.m.y;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.ConditionVariable;
import android.os.Looper;
import android.os.Process;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import com.acse.ottn.p3;
import com.alipay.sdk.app.EnvUtils;
import com.aliyun.openapiutil.Client;
import com.igexin.assist.util.AssistUtils;
import com.kwad.components.offline.api.IOfflineCompo;
import com.zj.adlib.c49;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.lang.ref.WeakReference;
import java.math.BigInteger;
import java.net.URL;
import java.net.URLDecoder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.security.interfaces.RSAPublicKey;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f25544a = "com.alipay.android.app";
    public static final String b = "com.eg.android.AlipayGphone";
    public static final String c = "hk.alipay.wallet";
    public static final String d = "hk.alipay.walletRC";
    public static final String e = "com.eg.android.AlipayGphoneRC";
    public static final int f = 99;
    public static final int h = 125;
    public static final int i = 460;
    public static final String[] g = {"10.1.5.1013151", "10.1.5.1013148"};
    public static final char[] j = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '+', '/'};

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Activity f25545a;

        public a(Activity activity) {
            this.f25545a = activity;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f25545a.finish();
        }
    }

    public class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Runnable f25546a;
        public final /* synthetic */ ConditionVariable b;

        public b(Runnable runnable, ConditionVariable conditionVariable) {
            this.f25546a = runnable;
            this.b = conditionVariable;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                this.f25546a.run();
            } finally {
                this.b.open();
            }
        }
    }

    public static String a(String str, String str2, String str3) {
        try {
            int iIndexOf = str3.indexOf(str) + str.length();
            if (iIndexOf <= str.length()) {
                return "";
            }
            int iIndexOf2 = !TextUtils.isEmpty(str2) ? str3.indexOf(str2, iIndexOf) : 0;
            return iIndexOf2 < 1 ? str3.substring(iIndexOf) : str3.substring(iIndexOf, iIndexOf2);
        } catch (Throwable unused) {
            return "";
        }
    }

    public static String b() {
        if (EnvUtils.isSandBox()) {
            return TextUtils.equals("hk.alipay.wallet", com.alipay.sdk.m.l.a.d.get(0).f25478a) ? d : e;
        }
        try {
            return com.alipay.sdk.m.l.a.d.get(0).f25478a;
        } catch (Throwable unused) {
            return "com.eg.android.AlipayGphone";
        }
    }

    public static String b(Context context) {
        return "-1;-1";
    }

    public static String c(String str) {
        return (EnvUtils.isSandBox() && TextUtils.equals(str, e)) ? "com.eg.android.AlipayGphoneRC.IAlixPay" : "com.eg.android.AlipayGphone.IAlixPay";
    }

    public static int d(String str) {
        for (int i2 = 0; i2 < 64; i2++) {
            if (str.equals(String.valueOf(j[i2]))) {
                return i2;
            }
        }
        return 0;
    }

    public static String e(com.alipay.sdk.m.w.a aVar, String str) {
        try {
            return URLDecoder.decode(str, "utf-8");
        } catch (UnsupportedEncodingException e2) {
            com.alipay.sdk.m.m.a.a(aVar, com.alipay.sdk.m.m.b.l, com.alipay.sdk.m.m.b.B, e2);
            return "";
        }
    }

    public static String f() {
        return "Android " + Build.VERSION.RELEASE;
    }

    public static String g(Context context) {
        String strF = f();
        String strE = e();
        String strC = c(context);
        String strF2 = f(context);
        StringBuilder sb = new StringBuilder();
        if (com.alipay.sdk.m.o.b.i().x()) {
            sb.append(" (");
            sb.append(strF);
            sb.append(l.b);
            sb.append(strE);
            sb.append(l.b);
            sb.append(strC);
            sb.append(l.b);
            sb.append(l.b);
            sb.append(strF2);
            sb.append(")");
            sb.append("(sdk android)");
            return sb.toString();
        }
        sb.append(" (");
        sb.append(strF);
        sb.append(l.b);
        sb.append(strE);
        sb.append(l.b);
        sb.append(strC);
        sb.append(l.b);
        sb.append(l.b);
        sb.append(strF2);
        sb.append(l.b);
        sb.append("15.8.42");
        sb.append(")");
        sb.append("(sdk android)");
        return sb.toString();
    }

    public static JSONObject h(String str) {
        try {
            return new JSONObject(str);
        } catch (Throwable unused) {
            return new JSONObject();
        }
    }

    public static String i(String str) {
        try {
            Uri uri = Uri.parse(str);
            return String.format("%s%s", uri.getAuthority(), uri.getPath());
        } catch (Throwable th) {
            g.a(th);
            return c49.f40900a;
        }
    }

    public static String f(Context context) {
        DisplayMetrics displayMetricsD = d(context);
        return displayMetricsD.widthPixels + "*" + displayMetricsD.heightPixels;
    }

    public static String c(Context context) {
        return context.getResources().getConfiguration().locale.toString();
    }

    public static String d() {
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("/proc/version"), 256);
            try {
                String line = bufferedReader.readLine();
                bufferedReader.close();
                Matcher matcher = Pattern.compile("\\w+\\s+\\w+\\s+([^\\s]+)\\s+\\(([^\\s@]+(?:@[^\\s.]+)?)[^)]*\\)\\s+\\((?:[^(]*\\([^)]*\\))?[^)]*\\)\\s+([^\\s]+)\\s+(?:PREEMPT\\s+)?(.+)").matcher(line);
                if (!matcher.matches() || matcher.groupCount() < 4) {
                    return "Unavailable";
                }
                return matcher.group(1) + "\n" + matcher.group(2) + " " + matcher.group(3) + "\n" + matcher.group(4);
            } catch (Throwable th) {
                bufferedReader.close();
                throw th;
            }
        } catch (IOException unused) {
            return "Unavailable";
        }
    }

    public static String e() {
        String strD = d();
        int iIndexOf = strD.indexOf(c49.f40900a);
        if (iIndexOf != -1) {
            strD = strD.substring(0, iIndexOf);
        }
        int iIndexOf2 = strD.indexOf("\n");
        if (iIndexOf2 != -1) {
            strD = strD.substring(0, iIndexOf2);
        }
        return "Linux " + strD;
    }

    public static boolean h(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(f25544a, 128) != null;
        } catch (PackageManager.NameNotFoundException unused) {
            return false;
        }
    }

    public static Map<String, String> b(String str) {
        HashMap map = new HashMap();
        for (String str2 : str.split("&")) {
            int iIndexOf = str2.indexOf("=", 1);
            if (-1 != iIndexOf) {
                map.put(str2.substring(0, iIndexOf), URLDecoder.decode(str2.substring(iIndexOf + 1)));
            }
        }
        return map;
    }

    public static boolean h() {
        return Thread.currentThread() == Looper.getMainLooper().getThread();
    }

    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final PackageInfo f25547a;
        public final int b;
        public final String c;

        public c(PackageInfo packageInfo, int i, String str) {
            this.f25547a = packageInfo;
            this.b = i;
            this.c = str;
        }

        public boolean a(com.alipay.sdk.m.w.a aVar) {
            Signature[] signatureArr = this.f25547a.signatures;
            if (signatureArr == null || signatureArr.length == 0) {
                return false;
            }
            for (Signature signature : signatureArr) {
                String strA = q.a(aVar, signature.toByteArray());
                if (strA != null && !TextUtils.equals(strA, this.c)) {
                    com.alipay.sdk.m.m.a.b(aVar, com.alipay.sdk.m.m.b.l, com.alipay.sdk.m.m.b.D, String.format("Got %s, expected %s", strA, this.c));
                    return true;
                }
            }
            return false;
        }

        public boolean a() {
            return this.f25547a.versionCode < this.b;
        }
    }

    public static String a(com.alipay.sdk.m.w.a aVar, byte[] bArr) {
        BigInteger modulus;
        try {
            PublicKey publicKey = ((X509Certificate) CertificateFactory.getInstance("X.509").generateCertificate(new ByteArrayInputStream(bArr))).getPublicKey();
            if (!(publicKey instanceof RSAPublicKey) || (modulus = ((RSAPublicKey) publicKey).getModulus()) == null) {
                return null;
            }
            return modulus.toString(16);
        } catch (Exception e2) {
            com.alipay.sdk.m.m.a.a(aVar, "auth", com.alipay.sdk.m.m.b.x, e2);
            return null;
        }
    }

    public static String c(com.alipay.sdk.m.w.a aVar, String str) {
        try {
            return (String) Class.forName("android.os.SystemProperties").getMethod(p3.f, String.class).invoke(null, str);
        } catch (Exception e2) {
            com.alipay.sdk.m.m.a.b(aVar, com.alipay.sdk.m.m.b.l, "rflex", e2.getClass().getSimpleName());
            return null;
        }
    }

    public static boolean f(String str) {
        return Pattern.compile("^http(s)?://([a-z0-9_\\-]+\\.)*(alipaydev|alipay|taobao)\\.(com|net|hk)(:\\d+)?(/.*)?$").matcher(str).matches();
    }

    public static String e(Context context) {
        String strB = p.b(context);
        return strB.substring(0, strB.indexOf("://"));
    }

    public static Map<String, String> b(com.alipay.sdk.m.w.a aVar, String str) {
        HashMap map = new HashMap(4);
        int iIndexOf = str.indexOf(63);
        if (iIndexOf != -1 && iIndexOf < str.length() - 1) {
            for (String str2 : str.substring(iIndexOf + 1).split("&")) {
                int iIndexOf2 = str2.indexOf(61, 1);
                if (iIndexOf2 != -1 && iIndexOf2 < str2.length() - 1) {
                    map.put(str2.substring(0, iIndexOf2), e(aVar, str2.substring(iIndexOf2 + 1)));
                }
            }
        }
        return map;
    }

    public static int c() {
        try {
            String lowerCase = Build.BRAND.toLowerCase();
            String lowerCase2 = Build.MANUFACTURER.toLowerCase();
            if (a(AssistUtils.BRAND_HW, lowerCase, lowerCase2)) {
                return 1;
            }
            if (a("oppo", lowerCase, lowerCase2)) {
                return 2;
            }
            if (a("vivo", lowerCase, lowerCase2)) {
                return 4;
            }
            if (a("lenovo", lowerCase, lowerCase2)) {
                return 8;
            }
            if (a("xiaomi", lowerCase, lowerCase2)) {
                return 16;
            }
            return a("oneplus", lowerCase, lowerCase2) ? 32 : 0;
        } catch (Exception unused) {
            return 61440;
        }
    }

    public static int e(String str) {
        try {
            String strK = com.alipay.sdk.m.o.b.i().k();
            if (TextUtils.isEmpty(strK)) {
                return 0;
            }
            return (b(strK, "").contains(str) ? 2 : 0) | 1;
        } catch (Throwable unused) {
            return 61440;
        }
    }

    public static DisplayMetrics d(Context context) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager) context.getApplicationContext().getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
        return displayMetrics;
    }

    public static c a(com.alipay.sdk.m.w.a aVar, Context context, List<com.alipay.sdk.m.o.b.C0199b> list) {
        c cVarA;
        if (list == null) {
            return null;
        }
        for (com.alipay.sdk.m.o.b.C0199b c0199b : list) {
            if (c0199b != null && (cVarA = a(aVar, context, c0199b.f25478a, c0199b.b, c0199b.c)) != null && !cVarA.a(aVar) && !cVarA.a()) {
                return cVarA;
            }
        }
        return null;
    }

    public static c a(com.alipay.sdk.m.w.a aVar, Context context, String str, int i2, String str2) {
        PackageInfo packageInfoA;
        if (EnvUtils.isSandBox()) {
            if ("com.eg.android.AlipayGphone".equals(str)) {
                str = e;
            } else if ("hk.alipay.wallet".equals(str)) {
                str = d;
            }
        }
        try {
            packageInfoA = a(context, str);
        } catch (Throwable th) {
            com.alipay.sdk.m.m.a.b(aVar, "auth", com.alipay.sdk.m.m.b.v, th.getMessage());
            packageInfoA = null;
        }
        if (a(aVar, packageInfoA)) {
            return a(packageInfoA, i2, str2);
        }
        return null;
    }

    public static boolean d(com.alipay.sdk.m.w.a aVar, String str) {
        try {
            int iE = e(str);
            com.alipay.sdk.m.m.a.a(aVar, com.alipay.sdk.m.m.b.l, "bindExt", "" + iE);
            return com.alipay.sdk.m.o.b.i().q() && (iE & 2) == 2;
        } catch (Throwable unused) {
            return false;
        }
    }

    public static String g(String str) {
        return a(str, true);
    }

    public static int g() {
        try {
            return Process.myUid();
        } catch (Throwable th) {
            g.a(th);
            return IOfflineCompo.Priority.HIGHEST;
        }
    }

    public static String b(com.alipay.sdk.m.w.a aVar, Context context) {
        return a(aVar, context, context.getPackageName());
    }

    public static int b(int i2) {
        return i2 / 100000;
    }

    public static String b(String str, String str2) {
        String string = Settings.Secure.getString(((Application) com.alipay.sdk.m.w.b.c().b()).getContentResolver(), str);
        return string != null ? string : str2;
    }

    public static boolean a(com.alipay.sdk.m.w.a aVar, PackageInfo packageInfo) {
        String str = "";
        boolean z = false;
        if (packageInfo == null) {
            str = "info == null";
        } else {
            Signature[] signatureArr = packageInfo.signatures;
            if (signatureArr == null) {
                str = "info.signatures == null";
            } else if (signatureArr.length <= 0) {
                str = "info.signatures.length <= 0";
            } else {
                z = true;
            }
        }
        if (!z) {
            com.alipay.sdk.m.m.a.b(aVar, "auth", com.alipay.sdk.m.m.b.w, str);
        }
        return z;
    }

    public static boolean b(com.alipay.sdk.m.w.a aVar) {
        if (aVar == null || TextUtils.isEmpty(aVar.g)) {
            return false;
        }
        return aVar.g.toLowerCase().contains("auth");
    }

    public static PackageInfo a(Context context, String str) throws PackageManager.NameNotFoundException {
        return context.getPackageManager().getPackageInfo(str, 192);
    }

    public static c a(PackageInfo packageInfo, int i2, String str) {
        if (packageInfo == null) {
            return null;
        }
        return new c(packageInfo, i2, str);
    }

    public static long a(String str) {
        return a(str, 6);
    }

    public static long a(String str, int i2) {
        int iPow = (int) Math.pow(2.0d, i2);
        int length = str.length();
        long j2 = 0;
        int i3 = 0;
        int i4 = length;
        while (i3 < length) {
            int i5 = i3 + 1;
            j2 += ((long) Integer.parseInt(String.valueOf(d(str.substring(i3, i5))))) * ((long) Math.pow(iPow, i4 - 1));
            i4--;
            i3 = i5;
        }
        return j2;
    }

    public static int a() {
        String strD = com.alipay.sdk.m.w.b.c().d();
        if (TextUtils.isEmpty(strD)) {
            return -1;
        }
        String strReplaceAll = strD.replaceAll("=", "");
        if (strReplaceAll.length() >= 5) {
            strReplaceAll = strReplaceAll.substring(0, 5);
        }
        int iA = (int) (a(strReplaceAll) % 10000);
        return iA < 0 ? iA * (-1) : iA;
    }

    public static boolean a(com.alipay.sdk.m.w.a aVar, Context context, List<com.alipay.sdk.m.o.b.C0199b> list, boolean z) {
        try {
            for (com.alipay.sdk.m.o.b.C0199b c0199b : list) {
                if (c0199b != null) {
                    String str = c0199b.f25478a;
                    if (EnvUtils.isSandBox()) {
                        if ("com.eg.android.AlipayGphone".equals(str)) {
                            str = e;
                        } else if ("hk.alipay.wallet".equals(str)) {
                            str = d;
                        }
                    }
                    try {
                        PackageInfo packageInfo = context.getPackageManager().getPackageInfo(str, 128);
                        if (packageInfo != null) {
                            if (!z) {
                                return true;
                            }
                            com.alipay.sdk.m.m.a.a(aVar, com.alipay.sdk.m.m.b.l, com.alipay.sdk.m.m.b.X, packageInfo.packageName + "|" + packageInfo.versionName);
                            return true;
                        }
                        continue;
                    } catch (PackageManager.NameNotFoundException unused) {
                        continue;
                    }
                }
            }
            return false;
        } catch (Throwable th) {
            com.alipay.sdk.m.m.a.a(aVar, com.alipay.sdk.m.m.b.l, com.alipay.sdk.m.m.b.h0, th);
            return false;
        }
    }

    public static boolean a(PackageInfo packageInfo) {
        if (packageInfo == null) {
            return false;
        }
        try {
            String str = packageInfo.versionName;
            String[] strArr = g;
            return TextUtils.equals(str, strArr[0]) || TextUtils.equals(str, strArr[1]);
        } catch (Throwable unused) {
            return false;
        }
    }

    public static String a(int i2) {
        Random random = new Random();
        StringBuilder sb = new StringBuilder();
        for (int i3 = 0; i3 < i2; i3++) {
            int iNextInt = random.nextInt(3);
            if (iNextInt == 0) {
                sb.append(String.valueOf((char) Math.round((Math.random() * 25.0d) + 65.0d)));
            } else if (iNextInt == 1) {
                sb.append(String.valueOf((char) Math.round((Math.random() * 25.0d) + 97.0d)));
            } else if (iNextInt == 2) {
                sb.append(String.valueOf(new Random().nextInt(10)));
            }
        }
        return sb.toString();
    }

    public static boolean a(com.alipay.sdk.m.w.a aVar, String str, Activity activity) {
        String strSubstring;
        if (TextUtils.isEmpty(str)) {
            return true;
        }
        if (activity == null) {
            return false;
        }
        if (!str.toLowerCase().startsWith(com.alipay.sdk.m.n.a.o.toLowerCase()) && !str.toLowerCase().startsWith(com.alipay.sdk.m.n.a.p.toLowerCase())) {
            if (!TextUtils.equals(str, com.alipay.sdk.m.n.a.r) && !TextUtils.equals(str, a("http", com.alipay.sdk.m.n.a.t))) {
                if (!str.startsWith(com.alipay.sdk.m.n.a.q)) {
                    return false;
                }
                try {
                    String strSubstring2 = str.substring(str.indexOf(com.alipay.sdk.m.n.a.q) + 24);
                    int i2 = Integer.parseInt(strSubstring2.substring(strSubstring2.lastIndexOf(com.alipay.sdk.m.n.a.u) + 10));
                    if (i2 != com.alipay.sdk.m.l.c.SUCCEEDED.c() && i2 != com.alipay.sdk.m.l.c.PAY_WAITTING.c()) {
                        com.alipay.sdk.m.l.c cVarA = com.alipay.sdk.m.l.c.a(com.alipay.sdk.m.l.c.FAILED.c());
                        com.alipay.sdk.m.l.b.a(com.alipay.sdk.m.l.b.a(cVarA.c(), cVarA.b(), ""));
                    } else {
                        if (com.alipay.sdk.m.n.a.y) {
                            StringBuilder sb = new StringBuilder();
                            String strDecode = URLDecoder.decode(str);
                            String strDecode2 = URLDecoder.decode(strDecode);
                            String str2 = strDecode2.substring(strDecode2.indexOf(com.alipay.sdk.m.n.a.q) + 24, strDecode2.lastIndexOf(com.alipay.sdk.m.n.a.u)).split(com.alipay.sdk.m.n.a.w)[0];
                            int iIndexOf = strDecode.indexOf(com.alipay.sdk.m.n.a.w) + 12;
                            sb.append(str2);
                            sb.append(com.alipay.sdk.m.n.a.w);
                            sb.append(strDecode.substring(iIndexOf, strDecode.indexOf("&", iIndexOf)));
                            sb.append(strDecode.substring(strDecode.indexOf("&", iIndexOf)));
                            strSubstring = sb.toString();
                        } else {
                            String strDecode3 = URLDecoder.decode(str);
                            strSubstring = strDecode3.substring(strDecode3.indexOf(com.alipay.sdk.m.n.a.q) + 24, strDecode3.lastIndexOf(com.alipay.sdk.m.n.a.u));
                        }
                        com.alipay.sdk.m.l.c cVarA2 = com.alipay.sdk.m.l.c.a(i2);
                        com.alipay.sdk.m.l.b.a(com.alipay.sdk.m.l.b.a(cVarA2.c(), cVarA2.b(), strSubstring));
                    }
                } catch (Exception unused) {
                    com.alipay.sdk.m.l.b.a(com.alipay.sdk.m.l.b.e());
                }
                activity.runOnUiThread(new a(activity));
                return true;
            }
            com.alipay.sdk.m.l.b.a(com.alipay.sdk.m.l.b.a());
            activity.finish();
            return true;
        }
        try {
            c cVarA3 = a(aVar, activity, com.alipay.sdk.m.l.a.d);
            if (cVarA3 != null && !cVarA3.a() && !cVarA3.a(aVar)) {
                if (str.startsWith("intent://platformapi/startapp")) {
                    str = str.replaceFirst("intent://platformapi/startapp\\?", com.alipay.sdk.m.n.a.o);
                }
                activity.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)));
            }
        } catch (Throwable unused2) {
        }
        return true;
    }

    public static String a(com.alipay.sdk.m.w.a aVar, Context context, String str) {
        try {
            return context.getPackageManager().getPackageInfo(str, 128).versionName;
        } catch (Throwable th) {
            com.alipay.sdk.m.m.a.a(aVar, com.alipay.sdk.m.m.b.l, com.alipay.sdk.m.m.b.v, th);
            return "";
        }
    }

    public static String a(String str, boolean z) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(Client.HASH_SHA256);
            messageDigest.update(str.getBytes());
            byte[] bArrDigest = messageDigest.digest();
            if (z && bArrDigest.length > 16) {
                byte[] bArr = new byte[16];
                System.arraycopy(bArrDigest, 0, bArr, 0, 16);
                return a(bArr);
            }
            return a(bArrDigest);
        } catch (NoSuchAlgorithmException unused) {
            return "";
        }
    }

    public static String a(byte[] bArr) {
        StringBuilder sb = new StringBuilder(bArr.length * 2);
        for (byte b2 : bArr) {
            sb.append(Character.forDigit((b2 & 240) >> 4, 16));
            sb.append(Character.forDigit(b2 & com.google.common.base.a.q, 16));
        }
        return sb.toString();
    }

    public static ActivityInfo a(Context context) {
        try {
            if (context instanceof Activity) {
                Activity activity = (Activity) context;
                for (ActivityInfo activityInfo : context.getPackageManager().getPackageInfo(context.getPackageName(), 1).activities) {
                    if (TextUtils.equals(activityInfo.name, activity.getClass().getName())) {
                        return activityInfo;
                    }
                }
            }
            return null;
        } catch (Throwable th) {
            g.a(th);
            return null;
        }
    }

    public static String a(com.alipay.sdk.m.w.a aVar) {
        return c(aVar, "ro.build.fingerprint");
    }

    public static <T> T a(WeakReference<T> weakReference) {
        if (weakReference == null) {
            return null;
        }
        return weakReference.get();
    }

    public static boolean a(com.alipay.sdk.m.w.a aVar, String str) {
        try {
            String host = new URL(str).getHost();
            return host.endsWith(com.alipay.sdk.m.n.a.C) || host.endsWith(com.alipay.sdk.m.n.a.D);
        } catch (Throwable th) {
            com.alipay.sdk.m.m.a.a(aVar, com.alipay.sdk.m.m.b.l, "ckUrlErr", th);
            return false;
        }
    }

    public static JSONObject a(Intent intent) {
        Bundle extras;
        JSONObject jSONObject = new JSONObject();
        if (intent != null && (extras = intent.getExtras()) != null) {
            for (String str : extras.keySet()) {
                try {
                    jSONObject.put(str, String.valueOf(extras.get(str)));
                } catch (Throwable unused) {
                }
            }
        }
        return jSONObject;
    }

    public static Map<String, String> a(JSONObject jSONObject) {
        HashMap map = new HashMap();
        if (jSONObject == null) {
            return map;
        }
        Iterator<String> itKeys = jSONObject.keys();
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            try {
                map.put(next, jSONObject.optString(next));
            } catch (Throwable th) {
                g.a(th);
            }
        }
        return map;
    }

    public static boolean a(Object obj, Object... objArr) {
        if (objArr == null || objArr.length == 0) {
            return obj == null;
        }
        for (Object obj2 : objArr) {
            if ((obj == null && obj2 == null) || (obj != null && obj.equals(obj2))) {
                return true;
            }
        }
        return false;
    }

    public static boolean a(long j2, Runnable runnable, String str) {
        if (runnable == null) {
            return false;
        }
        ConditionVariable conditionVariable = new ConditionVariable();
        Thread thread = new Thread(new b(runnable, conditionVariable));
        if (!TextUtils.isEmpty(str)) {
            thread.setName(str);
        }
        thread.start();
        try {
            if (j2 <= 0) {
                conditionVariable.block();
                return true;
            }
            return conditionVariable.block(j2);
        } catch (Throwable unused) {
        }
    }

    public static String a(String str, String str2) {
        return str + str2;
    }

    public static String a(com.alipay.sdk.m.w.a aVar, Context context) {
        try {
            String strA = m.a(aVar, context, "alipay_cashier_ap_fi", "");
            if (!TextUtils.isEmpty(strA)) {
                return strA;
            }
            try {
                m.b(aVar, context, "alipay_cashier_ap_fi", com.alipay.sdk.m.j.a.a("FU", System.currentTimeMillis(), new com.alipay.sdk.m.j.d(), (short) 0, new com.alipay.sdk.m.j.f()).a());
                String strA2 = m.a(aVar, context, "alipay_cashier_ap_fi", "");
                if (!TextUtils.isEmpty(strA2)) {
                    return strA2;
                }
                com.alipay.sdk.m.m.a.b(aVar, com.alipay.sdk.m.m.b.l, "e_regen_empty", "");
                return "";
            } catch (Exception e2) {
                com.alipay.sdk.m.m.a.b(aVar, com.alipay.sdk.m.m.b.l, "e_gen", e2.getClass().getSimpleName());
                return "";
            }
        } catch (Exception e3) {
            com.alipay.sdk.m.m.a.a(aVar, com.alipay.sdk.m.m.b.l, "e_gen_err", e3);
            return "";
        }
    }

    public static void a(String str, String str2, Context context, com.alipay.sdk.m.w.a aVar) {
        if (context == null || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || b(aVar) || !com.alipay.sdk.m.o.b.i().z()) {
            return;
        }
        try {
            Intent intent = new Intent(com.alipay.sdk.m.n.b.l);
            intent.putExtra("bizType", str);
            intent.putExtra("exName", str2);
            intent.setPackage(context.getPackageName());
            context.sendBroadcast(intent);
            com.alipay.sdk.m.m.a.a(aVar, com.alipay.sdk.m.m.b.l, "AppNotify", str + "|" + str2);
        } catch (Exception unused) {
        }
    }

    public static String a(File file) throws NoSuchAlgorithmException, IOException {
        int i2;
        MessageDigest messageDigest = MessageDigest.getInstance(Client.HASH_SHA256);
        FileInputStream fileInputStream = new FileInputStream(file);
        try {
            byte[] bArr = new byte[1024];
            while (true) {
                int i3 = fileInputStream.read(bArr);
                if (i3 == -1) {
                    break;
                }
                messageDigest.update(bArr, 0, i3);
            }
            fileInputStream.close();
            byte[] bArrDigest = messageDigest.digest();
            StringBuilder sb = new StringBuilder();
            for (byte b2 : bArrDigest) {
                String hexString = Integer.toHexString(b2 & 255);
                if (hexString.length() == 1) {
                    sb.append('0');
                }
                sb.append(hexString);
            }
            return sb.toString();
        } catch (Throwable th) {
            try {
                fileInputStream.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }
}
