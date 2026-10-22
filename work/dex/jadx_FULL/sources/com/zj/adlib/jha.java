package com.zj.adlib;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.text.TextUtils;
import cn.hzjizhun.admin.base.ad.RcSdk;
import cn.hzjizhun.admin.base.m0;
import java.util.ArrayList;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public final class jha {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static jha f42588a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final int f17396a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final boolean f17398a;
    public final int b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public String f17399b;
    public final int c;
    public final String d;
    public final String e;
    public final String f;
    public final String g;
    public final String h;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public String f17397a = "";

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public String f17400c = "";

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v2, types: [android.content.pm.PackageManager] */
    /* JADX WARN: Type inference failed for: r1v1, types: [java.util.Iterator] */
    /* JADX WARN: Type inference failed for: r1v14, types: [boolean] */
    /* JADX WARN: Type inference failed for: r1v15 */
    /* JADX WARN: Type inference failed for: r1v2, types: [java.util.Iterator] */
    /* JADX WARN: Type inference failed for: r1v3 */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r3v4, types: [java.lang.reflect.Method] */
    /* JADX WARN: Type inference failed for: r4v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r4v3, types: [java.lang.Object[]] */
    /* JADX WARN: Type inference failed for: r4v4 */
    /* JADX WARN: Type inference failed for: r9v2, types: [java.lang.String] */
    public jha() {
        PackageInfo packageInfo;
        PackageInfo packageInfo2;
        this.f17399b = "";
        this.d = "";
        this.e = "";
        this.f = "";
        this.g = "";
        ArrayList arrayList = new ArrayList();
        this.f17398a = false;
        String str = "com.xiaomi.market";
        arrayList.add("com.xiaomi.market");
        ?? r4 = "com.huawei.appmarket";
        arrayList.add("com.huawei.appmarket");
        arrayList.add("com.huawei.hwid");
        arrayList.add("com.bbk.appstore");
        arrayList.add("com.oppo.market");
        arrayList.add("com.heytap.market");
        ?? it = arrayList.iterator();
        while (true) {
            if (it.hasNext()) {
                ?? r9 = (String) it.next();
                try {
                    continue;
                    if (!this.f17398a && (packageInfo2 = RcSdk.e().getPackageManager().getPackageInfo(r9, 0)) != null) {
                        if (r9.equals("com.bbk.appstore")) {
                            this.f17398a = true;
                            this.d = packageInfo2.versionName;
                            this.f17396a = packageInfo2.versionCode;
                        } else if (r9.equals("com.oppo.market") || r9.equals("com.heytap.market")) {
                            this.f17398a = true;
                            this.e = packageInfo2.versionName;
                            this.b = packageInfo2.versionCode;
                        } else if (r9.equals(str)) {
                            this.f17398a = true;
                        } else if (r9.equals(r4)) {
                            this.f17398a = true;
                            this.f = packageInfo2.versionName;
                            this.c = packageInfo2.versionCode;
                        } else {
                            r9.equals("com.huawei.hwid");
                        }
                    }
                } catch (Throwable unused) {
                }
            }
            try {
                Class<?> cls = Class.forName("com.huawei.system.BuildEx");
                r4 = new Object[0];
                str = "Harmony";
                it = "Harmony".equalsIgnoreCase(cls.getMethod("getOsBrand", new Class[0]).invoke(cls, r4).toString());
                break;
            } catch (Throwable unused2) {
                it = 0;
            }
        }
        if (it != 0) {
            try {
                packageInfo = RcSdk.e().getPackageManager().getPackageInfo("com.huawei.hwid", 0);
            } catch (Throwable unused3) {
                packageInfo = null;
            }
        } else {
            packageInfo = null;
        }
        if (packageInfo != null) {
            this.h = packageInfo.versionCode + "";
            this.g = packageInfo.versionName;
        }
        this.f17399b = alb.b("appName");
    }

    public static jha a() {
        if (f42588a == null) {
            synchronized (jha.class) {
                if (f42588a == null) {
                    f42588a = new jha();
                }
            }
        }
        return f42588a;
    }

    public static void b(kha khaVar) {
        String str;
        String strA;
        try {
            jha jhaVarA = a();
            if (TextUtils.isEmpty(jhaVarA.f17397a)) {
                try {
                    Context contextE = RcSdk.e();
                    str = contextE.getPackageManager().getPackageInfo(contextE.getPackageName(), 0).versionName;
                    jhaVarA.f17397a = str;
                } catch (Throwable unused) {
                    str = "";
                }
            } else {
                str = jhaVarA.f17397a;
            }
            khaVar.f17688c = str;
            khaVar.f17684a = c();
            if (TextUtils.isEmpty(jhaVarA.f17400c)) {
                strA = m0.a();
                jhaVarA.f17400c = strA;
            } else {
                strA = jhaVarA.f17400c;
            }
            khaVar.r = strA;
            khaVar.s = jhaVarA.d;
            khaVar.u = jhaVarA.f;
            khaVar.t = jhaVarA.e;
            khaVar.f17693f = jhaVarA.f17396a;
            khaVar.h = jhaVarA.c;
            khaVar.f17695g = jhaVarA.b;
            khaVar.w = jhaVarA.h;
            khaVar.v = jhaVarA.g;
        } catch (Throwable unused2) {
        }
    }

    public static String c() {
        try {
            return RcSdk.e() == null ? "" : RcSdk.e().getPackageName();
        } catch (Throwable unused) {
            return "";
        }
    }
}
