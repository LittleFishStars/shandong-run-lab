package com.autonavi.aps.amapapi.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.text.TextUtils;
import com.alibaba.ariver.kernel.RVParams;
import com.aliyun.vod.log.struct.AliyunLogKey;
import com.amap.api.col.p0003l.fh;
import com.kuaishou.weapon.p0.t;
import com.zj.adlib.a7b;
import com.zj.adlib.mbb;
import com.zj.adlib.o9b;
import com.zj.adlib.r4b;
import com.zj.adlib.s4b;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public final class a {
    private static volatile boolean h = false;
    private static boolean i = true;
    private static int j = 1000;
    private static int k = 200;
    private static boolean l = false;
    private static int m = 20;
    private static int n = 0;
    private static volatile int o = 0;
    private static boolean p = true;
    private static boolean q = false;
    private static int r = -1;
    private static long s;
    private static ArrayList<String> t = new ArrayList<>();
    private static ArrayList<String> u = new ArrayList<>();
    private static volatile boolean v = false;
    private static boolean w = true;
    private static long x = 300000;
    private static boolean y = false;
    private static double z = 0.618d;
    private static boolean A = true;
    private static int B = 80;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static long f26200a = 3600000;
    private static boolean C = false;
    private static boolean D = true;
    private static boolean E = false;
    public static volatile long b = 0;
    static boolean c = true;
    private static boolean F = true;
    private static long G = -1;
    private static boolean H = true;
    private static int I = 1;
    private static boolean J = false;
    private static int K = 5;
    private static boolean L = false;
    private static String M = "CMjAzLjEwNy4xLjEvMTU0MDgxL2Q";
    private static long N = 0;
    public static boolean d = false;
    public static boolean e = false;
    public static int f = 20480;
    public static int g = 10800000;

    public static void a(final Context context) {
        if (h) {
            return;
        }
        h = true;
        fh.i(context, b.c(), b.d(), new fh.a() { // from class: com.autonavi.aps.amapapi.utils.a.1
            @Override // com.amap.api.col.3l.fh.a
            public final void a(fh.c cVar) {
                a.a(context, cVar);
            }
        });
    }

    public static int b() {
        return k;
    }

    public static int c() {
        if (o < 0) {
            o = 0;
        }
        return o;
    }

    public static long d() {
        return x;
    }

    public static boolean e() {
        return w;
    }

    public static boolean f() {
        return y;
    }

    public static double g() {
        return z;
    }

    public static boolean h() {
        return A;
    }

    public static int i() {
        return B;
    }

    public static boolean j() {
        return D;
    }

    public static boolean k() {
        return E;
    }

    public static boolean l() {
        return c;
    }

    public static boolean m() {
        return F;
    }

    public static long n() {
        return G;
    }

    public static boolean o() {
        return L;
    }

    public static boolean p() {
        return J;
    }

    public static String q() {
        return s4b.v(M);
    }

    public static boolean r() {
        return H && I > 0;
    }

    public static int s() {
        return I;
    }

    public static long t() {
        return N;
    }

    private static void b(JSONObject jSONObject, SharedPreferences.Editor editor) {
        if (jSONObject == null) {
            return;
        }
        try {
            JSONObject jSONObject2 = jSONObject.getJSONObject("197");
            if (jSONObject2 != null) {
                boolean zX = fh.x(jSONObject2.optString("able"), false);
                h.a(editor, "197a", zX);
                if (zX) {
                    h.a(editor, "197dv", jSONObject2.optString(com.alipay.sdk.m.w.a.v, ""));
                    h.a(editor, "197tv", jSONObject2.optString("tv", ""));
                } else {
                    h.a(editor, "197dv", "");
                    h.a(editor, "197tv", "");
                }
            }
        } catch (Throwable unused) {
        }
    }

    private static void d(JSONObject jSONObject, SharedPreferences.Editor editor) {
        if (jSONObject == null) {
            return;
        }
        try {
            boolean zX = fh.x(jSONObject.optString("re"), true);
            c = zX;
            h.a(editor, "fr", zX);
        } catch (Throwable th) {
            b.a(th, "AuthUtil", "checkReLocationAble");
        }
    }

    private static void e(JSONObject jSONObject, SharedPreferences.Editor editor) {
        JSONArray jSONArrayOptJSONArray;
        try {
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("15O");
            if (jSONObjectOptJSONObject != null) {
                if (fh.x(jSONObjectOptJSONObject.optString("able"), false) && ((jSONArrayOptJSONArray = jSONObjectOptJSONObject.optJSONArray("fl")) == null || jSONArrayOptJSONArray.length() <= 0 || jSONArrayOptJSONArray.toString().contains(Build.MANUFACTURER))) {
                    G = jSONObjectOptJSONObject.optInt("iv", 30) * 1000;
                } else {
                    G = -1L;
                }
                h.a(editor, "awsi", G);
            }
        } catch (Throwable unused) {
        }
    }

    private static void f(JSONObject jSONObject, SharedPreferences.Editor editor) {
        if (jSONObject == null) {
            return;
        }
        try {
            JSONObject jSONObject2 = jSONObject.getJSONObject("17Y");
            if (jSONObject2 != null) {
                boolean zX = fh.x(jSONObject2.optString("able"), false);
                d = zX;
                h.a(editor, "17ya", zX);
                boolean zX2 = fh.x(jSONObject2.optString("mup"), false);
                e = zX2;
                h.a(editor, "17ym", zX2);
                int iOptInt = jSONObject2.optInt("max", 20);
                if (iOptInt > 0) {
                    h.a(editor, "17yx", iOptInt);
                    f = iOptInt * 1024;
                }
                int iOptInt2 = jSONObject2.optInt("inv", 3);
                if (iOptInt2 > 0) {
                    h.a(editor, "17yi", iOptInt2);
                    g = iOptInt2 * 60 * 60 * 1000;
                }
            }
        } catch (Throwable unused) {
        }
    }

    private static void g(JSONObject jSONObject, SharedPreferences.Editor editor) {
        try {
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("15U");
            if (jSONObjectOptJSONObject != null) {
                boolean zX = fh.x(jSONObjectOptJSONObject.optString("able"), true);
                int iOptInt = jSONObjectOptJSONObject.optInt("yn", I);
                N = jSONObjectOptJSONObject.optLong("sysTime", N);
                h.a(editor, "15ua", zX);
                h.a(editor, "15un", iOptInt);
                h.a(editor, "15ust", N);
            }
        } catch (Throwable unused) {
        }
    }

    private static void h(JSONObject jSONObject, SharedPreferences.Editor editor) {
        int i2;
        if (jSONObject == null) {
            return;
        }
        try {
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("17J");
            if (jSONObjectOptJSONObject != null) {
                boolean zX = fh.x(jSONObjectOptJSONObject.optString("able"), false);
                J = zX;
                h.a(editor, "ok9", zX);
                if (zX) {
                    String strOptString = jSONObjectOptJSONObject.optString("auth");
                    String strOptString2 = jSONObjectOptJSONObject.optString(AliyunLogKey.KEY_HEIGHT);
                    M = strOptString2;
                    h.a(editor, "ok11", strOptString2);
                    fh.x(strOptString, false);
                    L = fh.x(jSONObjectOptJSONObject.optString("nr"), false);
                    String strOptString3 = jSONObjectOptJSONObject.optString(RVParams.TOOLBAR_MENU);
                    if (TextUtils.isEmpty(strOptString3) || (i2 = Integer.parseInt(strOptString3)) <= 0 || i2 >= 20) {
                        return;
                    }
                    K = i2;
                    h.a(editor, "ok10", i2);
                }
            }
        } catch (Throwable unused) {
        }
    }

    public static boolean a() {
        return i;
    }

    public static void c(Context context) {
        try {
            r4b r4bVarC = b.c();
            r4bVarC.c(i);
            a7b.d(context, r4bVarC);
        } catch (Throwable unused) {
        }
    }

    private static void a(fh.c cVar, SharedPreferences.Editor editor) {
        try {
            fh.c.a aVar = cVar.f859a;
            if (aVar != null) {
                boolean z2 = aVar.f864a;
                i = z2;
                h.a(editor, com.alibaba.triver.triver_render.view.canvas.tinyapp.c.f25231a, z2);
                JSONObject jSONObject = aVar.f25941a;
                if (jSONObject != null) {
                    j = jSONObject.optInt("fn", j);
                    int iOptInt = jSONObject.optInt("mpn", k);
                    k = iOptInt;
                    if (iOptInt > 500) {
                        k = 500;
                    }
                    if (k < 30) {
                        k = 30;
                    }
                    l = fh.x(jSONObject.optString("igu"), false);
                    m = jSONObject.optInt("ms", m);
                    o = jSONObject.optInt("rot", 0);
                    n = jSONObject.optInt("pms", 0);
                }
                o9b.c(j, l, m, n);
                mbb.f(l, n);
                h.a(editor, "fn", j);
                h.a(editor, "mpn", k);
                h.a(editor, "igu", l);
                h.a(editor, "ms", m);
                h.a(editor, "rot", o);
                h.a(editor, "pms", n);
            }
        } catch (Throwable th) {
            b.a(th, "AuthUtil", "loadConfigDataUploadException");
        }
    }

    private static void c(JSONObject jSONObject, SharedPreferences.Editor editor) {
        try {
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("13J");
            if (jSONObjectOptJSONObject != null) {
                boolean zX = fh.x(jSONObjectOptJSONObject.optString("able"), true);
                A = zX;
                if (zX) {
                    B = jSONObjectOptJSONObject.optInt("c", B);
                }
                h.a(editor, "13J_able", A);
                h.a(editor, "13J_c", B);
            }
        } catch (Throwable th) {
            b.a(th, "AuthUtil", "loadConfigDataGpsGeoAble");
        }
    }

    public static void b(Context context) {
        if (v) {
            return;
        }
        v = true;
        try {
            i = h.a(context, "pref", com.alibaba.triver.triver_render.view.canvas.tinyapp.c.f25231a, i);
            c(context);
        } catch (Throwable th) {
            b.a(th, "AuthUtil", "loadLastAbleState p1");
        }
        try {
            j = h.a(context, "pref", "fn", j);
            k = h.a(context, "pref", "mpn", k);
            l = h.a(context, "pref", "igu", l);
            m = h.a(context, "pref", "ms", m);
            o = h.a(context, "pref", "rot", 0);
            int iA = h.a(context, "pref", "pms", 0);
            n = iA;
            o9b.c(j, l, m, iA);
            mbb.f(l, n);
        } catch (Throwable th2) {
            b.a(th2, "AuthUtil", "loadLastAbleState p2");
        }
        try {
            w = h.a(context, "pref", "ca", w);
            x = h.a(context, "pref", "ct", x);
            y = h.a(context, "pref", "11G_fa", y);
            double dDoubleValue = Double.valueOf(h.a(context, "pref", "11G_ms", String.valueOf(z))).doubleValue();
            z = dDoubleValue;
            z = Math.max(0.2d, dDoubleValue);
        } catch (Throwable th3) {
            b.a(th3, "AuthUtil", "loadLastAbleState p3");
        }
        try {
            c = h.a(context, "pref", "fr", c);
        } catch (Throwable th4) {
            b.a(th4, "AuthUtil", "loadLastAbleState p4");
        }
        try {
            F = h.a(context, "pref", "asw", F);
        } catch (Throwable th5) {
            b.a(th5, "AuthUtil", "loadLastAbleState p5");
        }
        try {
            G = h.a(context, "pref", "awsi", G);
        } catch (Throwable th6) {
            b.a(th6, "AuthUtil", "loadLastAbleState p6");
        }
        try {
            H = h.a(context, "pref", "15ua", H);
            I = h.a(context, "pref", "15un", I);
            N = h.a(context, "pref", "15ust", N);
        } catch (Throwable th7) {
            b.a(th7, "AuthUtil", "loadLastAbleState p7");
        }
        try {
            J = h.a(context, "pref", "ok9", J);
            K = h.a(context, "pref", "ok10", K);
            M = h.a(context, "pref", "ok11", M);
        } catch (Throwable th8) {
            b.a(th8, "AuthUtil", "loadLastAbleState p8");
        }
        try {
            d = h.a(context, "pref", "17ya", false);
            e = h.a(context, "pref", "17ym", false);
            g = h.a(context, "pref", "17yi", 2) * 60 * 60 * 1000;
            f = h.a(context, "pref", "17yx", 100) * 1024;
        } catch (Throwable th9) {
            b.a(th9, "AuthUtil", "loadLastAbleState p9");
        }
        try {
            b = i.b();
            f26200a = h.a(context, "pref", "13S_at", f26200a);
            D = h.a(context, "pref", "13S_nla", D);
            A = h.a(context, "pref", "13J_able", A);
            B = h.a(context, "pref", "13J_c", B);
        } catch (Throwable th10) {
            b.a(th10, "AuthUtil", "loadLastAbleState p10");
        }
        fh.D(context);
        try {
            String strA = h.a(context, "pref", "13S_mlpl", (String) null);
            if (!TextUtils.isEmpty(strA)) {
                E = a(context, new JSONArray(s4b.v(strA)));
            }
        } catch (Throwable th11) {
            b.a(th11, "AuthUtil", "loadLastAbleState p11");
        }
        try {
            boolean zA = h.a(context, "pref", "197a", false);
            String strA2 = h.a(context, "pref", "197dv", "");
            String strA3 = h.a(context, "pref", "197tv", "");
            if (zA && b.f26202a.equals(strA2)) {
                for (String str : b.b) {
                    if (str.equals(strA3)) {
                        b.f26202a = strA3;
                    }
                }
            }
        } catch (Throwable th12) {
            b.a(th12, "AuthUtil", "loadLastAbleState p12");
        }
    }

    private static void a(JSONObject jSONObject, SharedPreferences.Editor editor) {
        try {
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("11G");
            if (jSONObjectOptJSONObject != null) {
                boolean zX = fh.x(jSONObjectOptJSONObject.optString("able"), true);
                w = zX;
                if (zX) {
                    x = jSONObjectOptJSONObject.optInt("c", 300) * 1000;
                }
                y = fh.x(jSONObjectOptJSONObject.optString("fa"), false);
                z = Math.min(1.0d, Math.max(0.2d, jSONObjectOptJSONObject.optDouble("ms", 0.618d)));
                h.a(editor, "ca", w);
                h.a(editor, "ct", x);
                h.a(editor, "11G_fa", y);
                h.a(editor, "11G_ms", String.valueOf(z));
            }
        } catch (Throwable th) {
            b.a(th, "AuthUtil", "loadConfigDataCacheAble");
        }
    }

    public static boolean a(Context context, fh.c cVar) {
        SharedPreferences.Editor editorA;
        try {
            editorA = h.a(context, "pref");
            try {
                a(cVar, editorA);
                c(context);
                JSONObject jSONObject = cVar.c;
                if (jSONObject == null) {
                    if (editorA != null) {
                        try {
                            h.a(editorA);
                        } catch (Throwable unused) {
                        }
                    }
                    return true;
                }
                a(context, jSONObject, editorA);
                a(jSONObject, editorA);
                c(jSONObject, editorA);
                e(jSONObject, editorA);
                g(jSONObject, editorA);
                f(jSONObject, editorA);
                h(jSONObject, editorA);
                b(jSONObject, editorA);
                if (editorA != null) {
                    try {
                        h.a(editorA);
                    } catch (Throwable unused2) {
                    }
                }
                return true;
            } catch (Throwable unused3) {
                if (editorA == null) {
                    return false;
                }
                try {
                    h.a(editorA);
                    return false;
                } catch (Throwable unused4) {
                    return false;
                }
            }
        } catch (Throwable unused5) {
            editorA = null;
        }
    }

    public static boolean a(long j2) {
        if (!w) {
            return false;
        }
        long jA = i.a() - j2;
        long j3 = x;
        return j3 < 0 || jA < j3;
    }

    private static void a(Context context, JSONObject jSONObject, SharedPreferences.Editor editor) {
        try {
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("13S");
            if (jSONObjectOptJSONObject != null) {
                try {
                    long jOptInt = jSONObjectOptJSONObject.optInt(t.u, 123) * 60 * 1000;
                    f26200a = jOptInt;
                    h.a(editor, "13S_at", jOptInt);
                } catch (Throwable th) {
                    b.a(th, "AuthUtil", "requestSdkAuthInterval");
                }
                d(jSONObjectOptJSONObject, editor);
                try {
                    boolean zX = fh.x(jSONObjectOptJSONObject.optString("nla"), true);
                    D = zX;
                    h.a(editor, "13S_nla", zX);
                } catch (Throwable unused) {
                }
                try {
                    boolean zX2 = fh.x(jSONObjectOptJSONObject.optString("asw"), true);
                    F = zX2;
                    h.a(editor, "asw", zX2);
                } catch (Throwable unused2) {
                }
                try {
                    JSONArray jSONArrayOptJSONArray = jSONObjectOptJSONObject.optJSONArray("mlpl");
                    if (jSONArrayOptJSONArray != null && jSONArrayOptJSONArray.length() > 0 && context != null) {
                        h.a(editor, "13S_mlpl", s4b.r(jSONArrayOptJSONArray.toString()));
                        E = a(context, jSONArrayOptJSONArray);
                    } else {
                        E = false;
                        h.a(editor, "13S_mlpl");
                    }
                } catch (Throwable unused3) {
                }
            }
        } catch (Throwable th2) {
            b.a(th2, "AuthUtil", "loadConfigAbleStatus");
        }
    }

    private static boolean a(Context context, JSONArray jSONArray) {
        if (jSONArray != null) {
            try {
                if (jSONArray.length() > 0 && context != null) {
                    for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                        if (i.b(context, jSONArray.getString(i2))) {
                            return true;
                        }
                    }
                }
            } catch (Throwable unused) {
            }
        }
        return false;
    }
}
