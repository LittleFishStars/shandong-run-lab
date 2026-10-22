package com.alipay.sdk.m.o;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.os.Build;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import android.widget.TextView;
import com.alipay.sdk.m.y.d;
import com.alipay.sdk.m.y.g;
import com.alipay.sdk.m.y.l;
import com.alipay.sdk.m.y.q;
import java.util.Random;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class c {
    public static final String d = "virtualImeiAndImsi";
    public static final String e = "virtual_imei";
    public static final String f = "virtual_imsi";
    public static volatile c g;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f25479a;
    public String b = "sdk-and-lite";
    public String c;

    public c() {
        String strA = com.alipay.sdk.m.l.a.a();
        if (com.alipay.sdk.m.l.a.b()) {
            return;
        }
        this.b += '_' + strA;
    }

    public static synchronized c a() {
        if (g == null) {
            g = new c();
        }
        return g;
    }

    public static String b() {
        return Long.toHexString(System.currentTimeMillis()) + (new Random().nextInt(9000) + 1000);
    }

    public static String d() {
        return "-1;-1";
    }

    public static String e() {
        return "1";
    }

    public static String f() {
        Context contextB = com.alipay.sdk.m.w.b.c().b();
        SharedPreferences sharedPreferences = contextB.getSharedPreferences(d, 0);
        String string = sharedPreferences.getString(e, null);
        if (!TextUtils.isEmpty(string)) {
            return string;
        }
        String strB = TextUtils.isEmpty(com.alipay.sdk.m.x.a.a(contextB).f()) ? b() : d.b(contextB).b();
        sharedPreferences.edit().putString(e, strB).apply();
        return strB;
    }

    public static String g() {
        String strC;
        Context contextB = com.alipay.sdk.m.w.b.c().b();
        SharedPreferences sharedPreferences = contextB.getSharedPreferences(d, 0);
        String string = sharedPreferences.getString(f, null);
        if (!TextUtils.isEmpty(string)) {
            return string;
        }
        if (TextUtils.isEmpty(com.alipay.sdk.m.x.a.a(contextB).f())) {
            String strD = com.alipay.sdk.m.w.b.c().d();
            strC = (TextUtils.isEmpty(strD) || strD.length() < 18) ? b() : strD.substring(3, 18);
        } else {
            strC = d.b(contextB).c();
        }
        String str = strC;
        sharedPreferences.edit().putString(f, str).apply();
        return str;
    }

    public static String h() {
        return "00";
    }

    public static String i() {
        return "-1";
    }

    public String c() {
        return this.c;
    }

    public static synchronized void a(String str) {
        g.b(com.alipay.sdk.m.n.a.B, "setRsaPublicKey");
        if (TextUtils.isEmpty(str)) {
            return;
        }
        PreferenceManager.getDefaultSharedPreferences(com.alipay.sdk.m.w.b.c().b()).edit().putString(com.alipay.sdk.m.n.b.i, str).apply();
        com.alipay.sdk.m.n.a.g = str;
    }

    public static String b(Context context) {
        if (context == null) {
            return "";
        }
        try {
            StringBuilder sb = new StringBuilder();
            String packageName = context.getPackageName();
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(packageName, 0);
            sb.append("(");
            sb.append(packageName);
            sb.append(l.b);
            sb.append(packageInfo.versionCode);
            sb.append(")");
            return sb.toString();
        } catch (Exception unused) {
            return "";
        }
    }

    public static String a(Context context) {
        return Float.toString(new TextView(context).getTextSize());
    }

    public String a(com.alipay.sdk.m.w.a aVar, com.alipay.sdk.m.x.a aVar2, boolean z) {
        Context contextB = com.alipay.sdk.m.w.b.c().b();
        d dVarB = d.b(contextB);
        if (TextUtils.isEmpty(this.f25479a)) {
            this.f25479a = "Msp/15.8.42 (" + q.f() + l.b + q.e() + l.b + q.c(contextB) + l.b + q.e(contextB) + l.b + q.f(contextB) + l.b + a(contextB);
        }
        String strC = d.d(contextB).c();
        String strB = q.b(contextB);
        String strE = e();
        String strC2 = dVarB.c();
        String strB2 = dVarB.b();
        String strG = g();
        String strF = f();
        if (aVar2 != null) {
            this.c = aVar2.e();
        }
        String strReplace = Build.MANUFACTURER.replace(l.b, " ");
        String strReplace2 = Build.MODEL.replace(l.b, " ");
        boolean zE = com.alipay.sdk.m.w.b.e();
        String strD = dVarB.d();
        String strI = i();
        String strH = h();
        StringBuilder sb = new StringBuilder();
        sb.append(this.f25479a);
        sb.append(l.b);
        sb.append(strC);
        sb.append(l.b);
        sb.append(strB);
        sb.append(l.b);
        sb.append(strE);
        sb.append(l.b);
        sb.append(strC2);
        sb.append(l.b);
        sb.append(strB2);
        sb.append(l.b);
        sb.append(this.c);
        sb.append(l.b);
        sb.append(strReplace);
        sb.append(l.b);
        sb.append(strReplace2);
        sb.append(l.b);
        sb.append(zE);
        sb.append(l.b);
        sb.append(strD);
        sb.append(l.b);
        sb.append(d());
        sb.append(l.b);
        sb.append(this.b);
        sb.append(l.b);
        sb.append(strG);
        sb.append(l.b);
        sb.append(strF);
        sb.append(l.b);
        sb.append(strI);
        sb.append(l.b);
        sb.append(strH);
        if (aVar2 != null) {
            String strA = com.alipay.sdk.m.a0.b.a(aVar, contextB, com.alipay.sdk.m.x.a.a(contextB).f(), com.alipay.sdk.m.a0.b.c(aVar, contextB));
            if (!TextUtils.isEmpty(strA)) {
                sb.append(";;;");
                sb.append(strA);
            }
        }
        sb.append(")");
        return sb.toString();
    }
}
