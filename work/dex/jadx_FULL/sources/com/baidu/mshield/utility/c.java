package com.baidu.mshield.utility;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Base64;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.UUID;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String f26724a;

    public static String a(String str) {
        try {
            String str2 = new String(com.baidu.mshield.b.f.a.a(Base64.decode(str, 10), com.baidu.mshield.b.f.a.a(16)), "UTF-8");
            return !TextUtils.isEmpty(str2) ? str2 : "";
        } catch (Throwable th) {
            com.baidu.mshield.b.c.a.a(th);
            return "";
        }
    }

    public static synchronized String b(Context context) {
        try {
            if (!TextUtils.isEmpty(f26724a)) {
                return f26724a;
            }
            String strA = a(context, false);
            if (!TextUtils.isEmpty(strA)) {
                f26724a = strA;
                return strA;
            }
            com.baidu.mshield.sharedpreferences.a aVarA = com.baidu.mshield.sharedpreferences.a.a(context);
            String strQ = aVarA.q();
            if (!TextUtils.isEmpty(strQ)) {
                try {
                    String strA2 = a(strQ);
                    if (!TextUtils.isEmpty(strA2)) {
                        f26724a = strA2;
                        return strA2;
                    }
                } catch (Throwable th) {
                    com.baidu.mshield.b.c.a.a(th);
                }
            }
            String strN = aVarA.n();
            if (!TextUtils.isEmpty(strN)) {
                aVarA.i(new String(Base64.encode(com.baidu.mshield.b.f.a.b(strN.getBytes("UTF-8"), com.baidu.mshield.b.f.a.a(16)), 10), "UTF-8"));
                f26724a = strN;
                return strN;
            }
            String strC = c(context);
            String strE = e(context);
            if (TextUtils.isEmpty(strE)) {
                strE = "0";
            }
            String str = strC + "|" + new StringBuffer(strE).reverse().toString();
            String str2 = new String(Base64.encode(com.baidu.mshield.b.f.a.b(str.getBytes("UTF-8"), com.baidu.mshield.b.f.a.a(16)), 10), "UTF-8");
            String strN2 = aVarA.n();
            if (!TextUtils.isEmpty(strN2)) {
                f26724a = strN2;
                return strN2;
            }
            aVarA.h(str);
            aVarA.i(str2);
            f26724a = str;
            return str;
        } catch (Throwable th2) {
            com.baidu.mshield.b.c.a.a(th2);
            return "";
        }
    }

    public static String c(Context context) {
        String strE;
        String strA = "";
        try {
            strE = e(context);
            try {
                strA = a(context);
            } catch (Throwable th) {
                th = th;
                com.baidu.mshield.b.c.a.a(th);
            }
        } catch (Throwable th2) {
            th = th2;
            strE = "";
        }
        return a((strE + strA + UUID.randomUUID().toString()).getBytes(), true);
    }

    public static String d(Context context) {
        try {
            try {
                if (TextUtils.isEmpty(com.baidu.sec.privacy.e.a.a(context).c("bd_setting_i", true))) {
                    e(context);
                }
                TextUtils.isEmpty(e(context));
                return "";
            } catch (Exception unused) {
                return "";
            }
        } catch (Throwable th) {
            com.baidu.mshield.b.c.a.a(th);
            return "";
        }
    }

    @SuppressLint({"MissingPermission"})
    public static String e(Context context) {
        return "";
    }

    public static String f(Context context) {
        return "";
    }

    public static String g(Context context) {
        try {
            Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
            DisplayMetrics displayMetrics = new DisplayMetrics();
            defaultDisplay.getMetrics(displayMetrics);
            if (displayMetrics.widthPixels < displayMetrics.heightPixels) {
                return displayMetrics.widthPixels + "*" + displayMetrics.heightPixels;
            }
            return displayMetrics.heightPixels + "*" + displayMetrics.widthPixels;
        } catch (Throwable th) {
            com.baidu.mshield.b.c.a.a(th);
            return "";
        }
    }

    public static String h(Context context) {
        try {
            String strF = com.baidu.mshield.sharedpreferences.a.a(context).f();
            return !TextUtils.isEmpty(strF) ? strF : "";
        } catch (Throwable th) {
            com.baidu.mshield.b.c.a.a(th);
            return "";
        }
    }

    public static String i(Context context) {
        try {
            if (TextUtils.isEmpty(com.baidu.mshield.b.e.a.d(context, "bd_setting_i"))) {
                e(context);
            }
            TextUtils.isEmpty(e(context));
        } catch (Throwable unused) {
        }
        return "";
    }

    public static String j(Context context) {
        String strC;
        try {
            String strA = a(context);
            try {
                strC = com.baidu.sec.privacy.e.a.a(context).c("bd_setting_i", true);
                try {
                    if (TextUtils.isEmpty(strC)) {
                        strC = e(context);
                    }
                } catch (Throwable th) {
                    th = th;
                    com.baidu.mshield.b.c.a.a(th);
                }
            } catch (Throwable th2) {
                th = th2;
                strC = "";
            }
            String strC2 = com.baidu.sec.privacy.e.a.a(context).c("com.baidu.deviceid", true);
            if (TextUtils.isEmpty(strC2)) {
                strC2 = com.baidu.sec.privacy.e.a.a(context).c(a(("com.baidu" + strC + strA).getBytes(), true), true);
            }
            if (strC2 == null) {
                return "";
            }
            String strE = e(context);
            if (TextUtils.isEmpty(strE)) {
                strE = "0";
            }
            return strC2 + "|" + new StringBuffer(strE).reverse().toString();
        } catch (Throwable unused) {
            return "";
        }
    }

    public static String a(Context context) {
        return com.baidu.mshield.core.a.a("arid");
    }

    public static String a(byte[] bArr, boolean z) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.reset();
            messageDigest.update(bArr);
            return a(messageDigest.digest(), "", z);
        } catch (NoSuchAlgorithmException e) {
            com.baidu.mshield.b.c.a.a(e);
            return null;
        }
    }

    public static String a(byte[] bArr, String str, boolean z) {
        StringBuilder sb = new StringBuilder();
        for (byte b : bArr) {
            String hexString = Integer.toHexString(b & 255);
            if (z) {
                hexString = hexString.toUpperCase();
            }
            if (hexString.length() == 1) {
                sb.append("0");
            }
            sb.append(hexString);
            sb.append(str);
        }
        return sb.toString();
    }

    public static String a() {
        return Build.DISPLAY;
    }

    public static String a(Context context, boolean z) {
        try {
            Bundle bundleA = g.a(context, "getRemoteZid", null, z, null, false);
            if (bundleA == null) {
                return "";
            }
            String string = bundleA.getString("_zid");
            return !TextUtils.isEmpty(string) ? string : "";
        } catch (Throwable th) {
            a.a(th);
            return "";
        }
    }
}
