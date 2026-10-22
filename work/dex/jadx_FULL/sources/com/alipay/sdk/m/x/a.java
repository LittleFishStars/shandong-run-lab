package com.alipay.sdk.m.x;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.alipay.sdk.m.p.e;
import com.alipay.sdk.m.y.g;
import java.util.Random;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class a {
    public static final String g = "alipay_tid_storage";
    public static final String h = "tidinfo";
    public static final String i = "tid";
    public static final String j = "client_key";
    public static final String k = "timestamp";
    public static final String l = "vimei";
    public static final String m = "vimsi";
    public static Context n;
    public static a o;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f25525a;
    public String b;
    public long c;
    public String d;
    public String e;
    public boolean f = false;

    public final void b(Context context) {
        if (context != null) {
            n = context.getApplicationContext();
        }
        if (this.f) {
            return;
        }
        this.f = true;
        l();
    }

    public String c() {
        String hexString = Long.toHexString(System.currentTimeMillis());
        return hexString.length() > 10 ? hexString.substring(hexString.length() - 10) : hexString;
    }

    public final String d() {
        return Long.toHexString(System.currentTimeMillis()) + (new Random().nextInt(9000) + 1000);
    }

    public String e() {
        return this.b;
    }

    public String f() {
        return this.f25525a;
    }

    public Long g() {
        return Long.valueOf(this.c);
    }

    public String h() {
        return this.d;
    }

    public String i() {
        return this.e;
    }

    public boolean j() {
        return k();
    }

    public boolean k() {
        return TextUtils.isEmpty(this.f25525a) || TextUtils.isEmpty(this.b) || TextUtils.isEmpty(this.d) || TextUtils.isEmpty(this.e);
    }

    /* JADX WARN: Code duplicated, block: B:24:0x006e  */
    /* JADX WARN: Code duplicated, block: B:25:0x0072  */
    public final void l() {
        String strOptString;
        String strOptString2;
        String strOptString3;
        String str;
        Long lValueOf = Long.valueOf(System.currentTimeMillis());
        String strOptString4 = null;
        try {
            String strA = C0212a.a(g, h, true);
            if (TextUtils.isEmpty(strA)) {
                str = null;
                strOptString2 = null;
                strOptString3 = null;
            } else {
                JSONObject jSONObject = new JSONObject(strA);
                strOptString = jSONObject.optString("tid", "");
                try {
                    strOptString2 = jSONObject.optString(j, "");
                    try {
                        lValueOf = Long.valueOf(jSONObject.optLong("timestamp", System.currentTimeMillis()));
                        strOptString3 = jSONObject.optString(l, "");
                        try {
                            strOptString4 = jSONObject.optString(m, "");
                        } catch (Exception e) {
                            e = e;
                            g.a(e);
                        }
                    } catch (Exception e2) {
                        e = e2;
                        strOptString3 = null;
                    }
                } catch (Exception e3) {
                    e = e3;
                    strOptString2 = null;
                    strOptString3 = strOptString2;
                    g.a(e);
                    str = strOptString4;
                    strOptString4 = strOptString;
                    g.b(com.alipay.sdk.m.n.a.B, "tid_str: load");
                    if (a(strOptString4, strOptString2, strOptString3, str)) {
                        m();
                        return;
                    }
                    this.f25525a = strOptString4;
                    this.b = strOptString2;
                    this.c = lValueOf.longValue();
                    this.d = strOptString3;
                    this.e = str;
                }
                str = strOptString4;
                strOptString4 = strOptString;
            }
        } catch (Exception e4) {
            e = e4;
            strOptString = null;
            strOptString2 = null;
        }
        g.b(com.alipay.sdk.m.n.a.B, "tid_str: load");
        if (a(strOptString4, strOptString2, strOptString3, str)) {
            m();
            return;
        }
        this.f25525a = strOptString4;
        this.b = strOptString2;
        this.c = lValueOf.longValue();
        this.d = strOptString3;
        this.e = str;
    }

    public final void m() {
        this.f25525a = "";
        this.b = c();
        this.c = System.currentTimeMillis();
        this.d = d();
        this.e = d();
        C0212a.b(g, h);
    }

    public final void n() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("tid", this.f25525a);
            jSONObject.put(j, this.b);
            jSONObject.put("timestamp", this.c);
            jSONObject.put(l, this.d);
            jSONObject.put(m, this.e);
            C0212a.a(g, h, jSONObject.toString(), true);
        } catch (Exception e) {
            g.a(e);
        }
    }

    public final void o() {
    }

    public static synchronized a a(Context context) {
        if (o == null) {
            o = new a();
        }
        if (n == null) {
            o.b(context);
        }
        return o;
    }

    /* JADX INFO: renamed from: com.alipay.sdk.m.x.a$a, reason: collision with other inner class name */
    public static class C0212a {
        public static boolean a(String str, String str2) {
            if (a.n == null) {
                return false;
            }
            return a.n.getSharedPreferences(str, 0).contains(str2);
        }

        public static void b(String str, String str2) {
            if (a.n == null) {
                return;
            }
            a.n.getSharedPreferences(str, 0).edit().remove(str2).apply();
        }

        public static boolean c(String str, String str2) {
            if (a.n == null) {
                return false;
            }
            return a.n.getSharedPreferences(str, 0).contains(str2);
        }

        public static String d(String str, String str2) {
            return a(str, str2, true);
        }

        public static String a(String str, String str2, boolean z) {
            if (a.n == null) {
                return null;
            }
            String string = a.n.getSharedPreferences(str, 0).getString(str2, null);
            if (!TextUtils.isEmpty(string) && z) {
                string = e.a(a(), string, string);
                if (TextUtils.isEmpty(string)) {
                    g.b(com.alipay.sdk.m.n.a.B, "tid_str: pref failed");
                }
            }
            g.b(com.alipay.sdk.m.n.a.B, "tid_str: from local");
            return string;
        }

        public static void a(String str, String str2, String str3) {
            a(str, str2, str3, true);
        }

        public static void a(String str, String str2, String str3, boolean z) {
            if (a.n == null) {
                return;
            }
            SharedPreferences sharedPreferences = a.n.getSharedPreferences(str, 0);
            if (z) {
                String strA = a();
                String strB = e.b(strA, str3, str3);
                if (TextUtils.isEmpty(strB)) {
                    String.format("LocalPreference::putLocalPreferences failed %s，%s", str3, strA);
                }
                str3 = strB;
            }
            sharedPreferences.edit().putString(str2, str3).apply();
        }

        public static String a() {
            String packageName;
            try {
                packageName = a.n.getApplicationContext().getPackageName();
            } catch (Throwable th) {
                g.a(th);
                packageName = "";
            }
            return (packageName + "0000000000000000000000000000").substring(0, 24);
        }
    }

    public void b() {
        g.b(com.alipay.sdk.m.n.a.B, "tid_str: del");
        m();
    }

    public final boolean a(String str, String str2, String str3, String str4) {
        return TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3) || TextUtils.isEmpty(str4);
    }

    public void a(String str, String str2) {
        g.b(com.alipay.sdk.m.n.a.B, "tid_str: save");
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        this.f25525a = str;
        this.b = str2;
        this.c = System.currentTimeMillis();
        n();
        o();
    }

    public final void a(String str, String str2, String str3, String str4, Long l2) {
        if (a(str, str2, str3, str4)) {
            return;
        }
        this.f25525a = str;
        this.b = str2;
        this.d = str3;
        this.e = str4;
        if (l2 == null) {
            this.c = System.currentTimeMillis();
        } else {
            this.c = l2.longValue();
        }
        n();
    }
}
