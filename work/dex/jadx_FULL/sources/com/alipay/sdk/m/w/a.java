package com.alipay.sdk.m.w;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageInfo;
import android.os.SystemClock;
import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import com.alipay.sdk.app.AlipayApi;
import com.alipay.sdk.m.y.g;
import com.alipay.sdk.m.y.m;
import com.alipay.sdk.m.y.q;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.zj.adlib.c49;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Locale;
import java.util.UUID;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class a {
    public static final String A = "extInfo";
    public static final String B = "ap_link_token";
    public static final String C = "act_info";
    public static final String D = "UTF-8";
    public static final String E = "preheatUserToken";
    public static final String F = "preheatToken";
    public static final String G = "preheatTime";
    public static final String H = "sp_preheatUserToken";
    public static final String I = "new_external_info==";
    public static final String o = "\"&";
    public static final String p = "&";
    public static final String q = "bizcontext=\"";
    public static final String r = "bizcontext=";
    public static final String s = "\"";
    public static final String t = "appkey";
    public static final String u = "ty";
    public static final String v = "sv";
    public static final String w = "an";
    public static final String x = "setting";
    public static final String y = "av";
    public static final String z = "sdk_start_time";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f25519a;
    public String b;
    public Context c;
    public final String d;
    public final long e;
    public final int f;
    public final String g;
    public String h;
    public String i;
    public boolean j = false;
    public boolean k = false;
    public boolean l = false;
    public final ActivityInfo m;
    public final com.alipay.sdk.m.m.b n;

    public a(Context context, String str, String str2) {
        String str3;
        this.f25519a = "";
        this.b = "";
        this.c = null;
        this.h = null;
        this.i = null;
        boolean zIsEmpty = TextUtils.isEmpty(str2);
        this.n = new com.alipay.sdk.m.m.b(context, zIsEmpty);
        String strB = b(str, this.b);
        this.d = strB;
        this.e = SystemClock.elapsedRealtime();
        this.f = q.g();
        ActivityInfo activityInfoA = q.a(context);
        this.m = activityInfoA;
        this.g = str2;
        if (!zIsEmpty) {
            com.alipay.sdk.m.m.a.a(this, com.alipay.sdk.m.m.b.l, "eptyp", str2 + "|" + strB);
            if (activityInfoA != null) {
                str3 = activityInfoA.name + "|" + activityInfoA.launchMode;
            } else {
                str3 = "null";
            }
            com.alipay.sdk.m.m.a.a(this, com.alipay.sdk.m.m.b.l, "actInfo", str3);
            com.alipay.sdk.m.m.a.a(this, com.alipay.sdk.m.m.b.l, NotificationCompat.CATEGORY_SYSTEM, q.a(this));
            com.alipay.sdk.m.m.a.a(this, com.alipay.sdk.m.m.b.l, "sdkv", "7a055d1-dirty");
            com.alipay.sdk.m.m.a.a(this, com.alipay.sdk.m.m.b.l, "registerApp", AlipayApi.f + "");
        }
        try {
            this.c = context.getApplicationContext();
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
            this.f25519a = packageInfo.versionName;
            this.b = packageInfo.packageName;
        } catch (Exception e) {
            g.a(e);
        }
        if (!zIsEmpty) {
            com.alipay.sdk.m.m.a.a(this, com.alipay.sdk.m.m.b.l, "u" + q.g());
            com.alipay.sdk.m.m.a.a(this, com.alipay.sdk.m.m.b.l, com.alipay.sdk.m.m.b.Q, "" + SystemClock.elapsedRealtime());
            com.alipay.sdk.m.m.a.a(context, this, str, this.d);
        }
        if (!zIsEmpty && com.alipay.sdk.m.o.b.i().u()) {
            com.alipay.sdk.m.o.b.i().a(this, this.c, true, 2);
        }
        if (com.alipay.sdk.m.o.b.i().a((a) null)) {
            return;
        }
        this.h = m.a(this, b(), H, "");
        this.i = c(str, this.b);
    }

    public static a f() {
        return null;
    }

    public String a(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        if (str.startsWith(I)) {
            return d(str);
        }
        return f(str) ? c(str) : e(str);
    }

    public Context b() {
        return this.c;
    }

    public String c() {
        return this.b;
    }

    public String d() {
        return this.f25519a;
    }

    public final String e(String str) {
        try {
            String strA = a(str, o, q);
            if (TextUtils.isEmpty(strA)) {
                return str + "&" + a(q, "\"");
            }
            if (!strA.endsWith("\"")) {
                strA = strA + "\"";
            }
            int iIndexOf = str.indexOf(strA);
            return str.substring(0, iIndexOf) + b(strA, q, "\"") + str.substring(iIndexOf + strA.length());
        } catch (Throwable th) {
            com.alipay.sdk.m.m.a.a(this, com.alipay.sdk.m.m.b.l, "fmt2", th, str);
            return str;
        }
    }

    public final boolean f(String str) {
        return !str.contains(o);
    }

    public String g() {
        return this.i;
    }

    public boolean h() {
        return this.k;
    }

    public boolean i() {
        return this.j;
    }

    public boolean j() {
        return this.l;
    }

    public final String b(String str, String str2, String str3) throws JSONException {
        JSONObject jSONObject;
        String strSubstring = str.substring(str2.length());
        boolean z2 = false;
        String strSubstring2 = strSubstring.substring(0, strSubstring.length() - str3.length());
        if (strSubstring2.length() >= 2 && strSubstring2.startsWith("\"") && strSubstring2.endsWith("\"")) {
            jSONObject = new JSONObject(strSubstring2.substring(1, strSubstring2.length() - 1));
            z2 = true;
        } else {
            jSONObject = new JSONObject(strSubstring2);
        }
        String strA = a(jSONObject);
        if (z2) {
            strA = "\"" + strA + "\"";
        }
        return str2 + strA + str3;
    }

    public final String c(String str) {
        try {
            String strA = a(str, "&", r);
            if (TextUtils.isEmpty(strA)) {
                str = str + "&" + a(r, "");
            } else {
                int iIndexOf = str.indexOf(strA);
                str = str.substring(0, iIndexOf) + b(strA, r, "") + str.substring(iIndexOf + strA.length());
            }
        } catch (Throwable th) {
            com.alipay.sdk.m.m.a.a(this, com.alipay.sdk.m.m.b.l, "fmt1", th, str);
        }
        return str;
    }

    public final String d(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str.substring(19));
            jSONObject.put("bizcontext", b(jSONObject.optString("bizcontext")));
            return I + jSONObject.toString();
        } catch (Throwable unused) {
            return str;
        }
    }

    /* JADX INFO: renamed from: com.alipay.sdk.m.w.a$a, reason: collision with other inner class name */
    public static final class C0210a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final HashMap<UUID, a> f25520a = new HashMap<>();
        public static final HashMap<String, a> b = new HashMap<>();
        public static final String c = "i_uuid_b_c";

        public static void a(a aVar, Intent intent) {
            if (aVar == null || intent == null) {
                return;
            }
            UUID uuidRandomUUID = UUID.randomUUID();
            f25520a.put(uuidRandomUUID, aVar);
            intent.putExtra(c, uuidRandomUUID);
        }

        public static a a(Intent intent) {
            if (intent == null) {
                return null;
            }
            Serializable serializableExtra = intent.getSerializableExtra(c);
            if (serializableExtra instanceof UUID) {
                return f25520a.remove((UUID) serializableExtra);
            }
            return null;
        }

        public static void a(a aVar, String str) {
            if (aVar == null || TextUtils.isEmpty(str)) {
                return;
            }
            b.put(str, aVar);
        }

        public static a a(String str) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            return b.remove(str);
        }
    }

    public final String a(String str, String str2, String str3) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        String[] strArrSplit = str.split(str2);
        for (int i = 0; i < strArrSplit.length; i++) {
            if (!TextUtils.isEmpty(strArrSplit[i]) && strArrSplit[i].startsWith(str3)) {
                return strArrSplit[i];
            }
        }
        return null;
    }

    public final String b(String str) throws JSONException {
        return a(new JSONObject(str));
    }

    public static String c(String str, String str2) {
        try {
            Locale locale = Locale.getDefault();
            Object[] objArr = new Object[4];
            if (str == null) {
                str = "";
            }
            objArr[0] = str;
            if (str2 == null) {
                str2 = "";
            }
            objArr[1] = str2;
            objArr[2] = Long.valueOf(System.currentTimeMillis());
            objArr[3] = UUID.randomUUID().toString();
            return q.g(String.format(locale, "%s%s%d%s", objArr));
        } catch (Throwable th) {
            g.c(com.alipay.sdk.m.n.a.B, "generatePreheatTokenError");
            g.a(th);
            return "";
        }
    }

    public static String b(String str, String str2) {
        try {
            Locale locale = Locale.getDefault();
            Object[] objArr = new Object[4];
            if (str == null) {
                str = "";
            }
            objArr[0] = str;
            if (str2 == null) {
                str2 = "";
            }
            objArr[1] = str2;
            objArr[2] = Long.valueOf(System.currentTimeMillis());
            objArr[3] = UUID.randomUUID().toString();
            return String.format("EP%s%s_%s", "1", q.g(String.format(locale, "%s%s%d%s", objArr)), Long.valueOf(System.currentTimeMillis()));
        } catch (Throwable unused) {
            return c49.f40900a;
        }
    }

    public final String a(String str, String str2) {
        return str + a(new JSONObject()) + str2;
    }

    public final JSONObject e() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(B, this.d);
            if (a() && com.alipay.sdk.m.o.b.i().j(null)) {
                jSONObject.put(E, this.h);
                jSONObject.put(F, this.i);
                jSONObject.put(G, System.currentTimeMillis() + "");
            }
        } catch (Throwable unused) {
        }
        return jSONObject;
    }

    public String a(JSONObject jSONObject) {
        String str;
        try {
            if (!jSONObject.has("appkey")) {
                jSONObject.put("appkey", com.alipay.sdk.m.n.a.h);
            }
            if (!jSONObject.has(u)) {
                jSONObject.put(u, "and_lite");
            }
            if (!jSONObject.has(v)) {
                jSONObject.put(v, "h.a.3.8.42");
            }
            if (!jSONObject.has(w)) {
                jSONObject.put(w, this.b);
            }
            if (!jSONObject.has("av")) {
                jSONObject.put("av", this.f25519a);
            }
            if (!jSONObject.has(z)) {
                jSONObject.put(z, System.currentTimeMillis());
            }
            if (!jSONObject.has(A)) {
                jSONObject.put(A, e());
            }
            if (!jSONObject.has(C)) {
                if (this.m != null) {
                    str = this.m.name + "|" + this.m.launchMode;
                } else {
                    str = "null";
                }
                jSONObject.put(C, str);
            }
            return jSONObject.toString();
        } catch (Throwable th) {
            com.alipay.sdk.m.m.a.a(this, com.alipay.sdk.m.m.b.l, "fmt3", th, String.valueOf(jSONObject));
            g.a(th);
            return jSONObject != null ? jSONObject.toString() : "{}";
        }
    }

    public void b(boolean z2) {
        this.j = z2;
    }

    public void c(boolean z2) {
        this.l = z2;
    }

    public static HashMap<String, String> a(a aVar) {
        HashMap<String, String> map = new HashMap<>();
        if (aVar != null) {
            map.put(HiAnalyticsConstant.BI_KEY_SDK_VER, "15.8.42");
            map.put("app_name", aVar.b);
            map.put("token", aVar.d);
            map.put("call_type", aVar.g);
            map.put("ts_api_invoke", String.valueOf(aVar.e));
            com.alipay.sdk.m.y.a.a(aVar, map);
        }
        return map;
    }

    public void a(boolean z2) {
        this.k = z2;
    }

    public boolean a() {
        return !TextUtils.isEmpty(this.h);
    }
}
