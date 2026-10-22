package com.alipay.sdk.m.o;

import android.content.Context;
import android.text.TextUtils;
import com.alipay.sdk.m.y.f;
import com.alipay.sdk.m.y.g;
import com.alipay.sdk.m.y.m;
import com.alipay.sdk.m.y.q;
import com.aliyun.vod.log.struct.AliyunLogKey;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public final class b {
    public static final String A0 = "bind_use_imp";
    public static final String B0 = "bind_use_allow_activity_starts";
    public static final String C0 = "retry_bnd_once";
    public static final String D0 = "skip_trans";
    public static final String E0 = "start_trans";
    public static final String F0 = "up_before_pay";
    public static final String G0 = "lck_k";
    public static final String H0 = "use_sc_lck_a";
    public static final String I0 = "utdid_factor";
    public static final String J0 = "cfg_max_time";
    public static final String K0 = "get_oa_id";
    public static final String L0 = "notifyFailApp";
    public static final String M0 = "startactivity_in_ui_thread";
    public static final String N0 = "optimize_trans_activity_degrade";
    public static final String O0 = "register_app_degrade_2";
    public static final String P = "DynCon";
    public static final String P0 = "sdk_pre_heat";
    public static final int Q = 10000;
    public static final String Q0 = "external_sdk_data_degrade";
    public static final String R = "https://h5.m.taobao.com/mlapp/olist.html";
    public static final String R0 = "local_web_pay";
    public static final int S = 10;
    public static final String S0 = "degrade_web_ua_version";
    public static final boolean T = true;
    public static final String T0 = "intercept_batch";
    public static final boolean U = false;
    public static final String U0 = "debug_upgrade_warn";
    public static final boolean V = true;
    public static final String V0 = "fetch_config_when_register_app";
    public static final boolean W = true;
    public static final String W0 = "gray_log_print_performance";
    public static final boolean X = false;
    public static final String X0 = "enable_china_mobile_bridge_mode";
    public static final boolean Y = true;
    public static final String Y0 = "trans_act_start_sleep_time";
    public static final boolean Z = false;
    public static final String Z0 = "degrade_check_version_when_register_app";
    public static final boolean a0 = false;
    public static final String a1 = "enable_hk_z32_flowcut";
    public static final boolean b0 = false;
    public static final String b1 = "bind_with_startActivity";
    public static final boolean c0 = true;
    public static final String c1 = "enableStartActivityFallback";
    public static final String d0 = "";
    public static final String d1 = "enableBindExFallback";
    public static final boolean e0 = false;
    public static final String e1 = "degrade_exit_local_web_pay_on_back";
    public static final boolean f0 = false;
    public static b f1 = null;
    public static final int g0 = 1000;
    public static final boolean h0 = true;
    public static final String i0 = "";
    public static final boolean j0 = false;
    public static final boolean k0 = false;
    public static final int l0 = 1000;
    public static final int m0 = 20000;
    public static final boolean n0 = false;
    public static final boolean o0 = false;
    public static final long p0 = 200;
    public static final String q0 = "alipay_cashier_dynamic_config";
    public static final String r0 = "timeout";
    public static final String s0 = "h5_port_degrade";
    public static final String t0 = "st_sdk_config";
    public static final String u0 = "tbreturl";
    public static final String v0 = "launchAppSwitch";
    public static final String w0 = "configQueryInterval";
    public static final String x0 = "deg_log_mcgw";
    public static final String y0 = "deg_start_srv_first";
    public static final String z0 = "prev_jump_dual";
    public Boolean E;
    public Boolean F;
    public Boolean G;
    public Boolean H;
    public boolean I;
    public long J;
    public boolean K;
    public JSONObject L;
    public boolean M;
    public List<C0199b> N;
    public int O;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f25476a = 10000;
    public boolean b = false;
    public String c = R;
    public int d = 10;
    public boolean e = true;
    public boolean f = false;
    public boolean g = false;
    public boolean h = false;
    public boolean i = true;
    public boolean j = true;
    public boolean k = false;
    public boolean l = true;
    public boolean m = false;
    public boolean n = false;
    public boolean o = false;
    public boolean p = true;
    public String q = "";
    public String r = "";
    public boolean s = false;
    public boolean t = false;
    public boolean u = false;
    public int v = 1000;
    public boolean w = false;
    public Boolean x = null;
    public Boolean y = null;
    public Boolean z = null;
    public Boolean A = null;
    public Boolean B = null;
    public Boolean C = null;
    public com.alipay.sdk.m.o.a D = new com.alipay.sdk.m.o.a();

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.alipay.sdk.m.w.a f25477a;
        public final /* synthetic */ Context b;
        public final /* synthetic */ boolean c;
        public final /* synthetic */ int d;

        public a(com.alipay.sdk.m.w.a aVar, Context context, boolean z, int i) {
            this.f25477a = aVar;
            this.b = context;
            this.c = z;
            this.d = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                com.alipay.sdk.m.t.b bVarA = new com.alipay.sdk.m.u.b().a(this.f25477a, this.b);
                if (bVarA != null) {
                    b.this.a(this.f25477a, bVarA.a());
                    b.this.k(com.alipay.sdk.m.w.a.f());
                    com.alipay.sdk.m.m.a.a(this.f25477a, com.alipay.sdk.m.m.b.l, "offcfg|" + this.c + "|" + this.d);
                }
            } catch (Throwable th) {
                g.a(th);
            }
        }
    }

    public b() {
        Boolean bool = Boolean.FALSE;
        this.E = bool;
        this.F = bool;
        this.G = bool;
        this.H = null;
        this.I = false;
        this.J = 200L;
        this.K = false;
        this.M = true;
        this.N = null;
        this.O = -1;
    }

    public boolean A() {
        return this.s;
    }

    public boolean B() {
        return this.M;
    }

    public boolean C() {
        return this.b;
    }

    public boolean D() {
        return this.f;
    }

    public boolean E() {
        return this.o;
    }

    public final JSONObject F() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(r0, l());
        jSONObject.put(s0, C());
        jSONObject.put(u0, s());
        jSONObject.put(w0, e());
        jSONObject.put(v0, C0199b.a(m()));
        jSONObject.put(T0, j());
        jSONObject.put(x0, g());
        jSONObject.put(y0, h());
        jSONObject.put(z0, o());
        jSONObject.put(A0, c());
        jSONObject.put(B0, b());
        jSONObject.put(C0, p());
        jSONObject.put(D0, r());
        jSONObject.put(E0, E());
        jSONObject.put(F0, u());
        jSONObject.put(H0, q());
        jSONObject.put(G0, k());
        jSONObject.put(b1, d());
        jSONObject.put(J0, f());
        jSONObject.put(K0, B());
        jSONObject.put(L0, z());
        jSONObject.put(c1, A());
        jSONObject.put(d1, y());
        jSONObject.put(M0, D());
        jSONObject.put(com.alipay.sdk.m.y.a.b, a());
        f.a(jSONObject, N0, this.x);
        f.a(jSONObject, O0, this.y);
        f.a(jSONObject, P0, this.A);
        f.a(jSONObject, Q0, this.B);
        f.a(jSONObject, R0, this.C);
        f.a(jSONObject, S0, this.z);
        f.a(jSONObject, U0, this.D.a());
        f.a(jSONObject, V0, this.E);
        f.a(jSONObject, W0, this.F);
        f.a(jSONObject, X0, this.G);
        f.a(jSONObject, a1, this.H);
        f.a(jSONObject, e1, Boolean.valueOf(this.I));
        f.a(jSONObject, Z0, Boolean.valueOf(this.K));
        jSONObject.put(Y0, t());
        return jSONObject;
    }

    public boolean b() {
        return this.l;
    }

    public boolean c() {
        return this.k;
    }

    public String d() {
        return this.r;
    }

    public int e() {
        return this.d;
    }

    public final int f() {
        return this.v;
    }

    public boolean g() {
        return this.h;
    }

    public boolean h() {
        return this.i;
    }

    public boolean i(com.alipay.sdk.m.w.a aVar) {
        a(aVar, R0, String.valueOf(this.C));
        Boolean bool = this.C;
        return (bool == null || !bool.booleanValue() || com.alipay.sdk.m.l.a.c()) ? false : true;
    }

    public boolean j() {
        return this.e;
    }

    public String k() {
        return this.q;
    }

    public int l() {
        int i = this.f25476a;
        if (i < 1000 || i > 20000) {
            g.b(P, "time(def) = 10000");
            return 10000;
        }
        g.b(P, "time = " + this.f25476a);
        return this.f25476a;
    }

    public List<C0199b> m() {
        return this.N;
    }

    public String n() {
        return this.D.b();
    }

    public boolean o() {
        return this.j;
    }

    public boolean p() {
        return this.m;
    }

    public boolean q() {
        return this.u;
    }

    public boolean r() {
        return this.n;
    }

    public String s() {
        return this.c;
    }

    public long t() {
        long j = this.J;
        if (j <= 0) {
            return 200L;
        }
        return j;
    }

    public boolean u() {
        return this.p;
    }

    public void v() {
        Context contextB = com.alipay.sdk.m.w.b.c().b();
        String strA = m.a(com.alipay.sdk.m.w.a.f(), contextB, q0, null);
        try {
            this.O = Integer.parseInt(m.a(com.alipay.sdk.m.w.a.f(), contextB, I0, "-1"));
        } catch (Exception unused) {
        }
        a(strA);
    }

    public boolean w() {
        return this.K;
    }

    public boolean x() {
        Boolean bool = this.z;
        return bool != null && bool.booleanValue();
    }

    public boolean y() {
        return this.t;
    }

    public boolean z() {
        return this.w;
    }

    public boolean b(com.alipay.sdk.m.w.a aVar) {
        a(aVar, N0, String.valueOf(this.x));
        Boolean bool = this.x;
        return bool != null && bool.booleanValue();
    }

    public boolean c(com.alipay.sdk.m.w.a aVar) {
        a(aVar, O0, String.valueOf(this.y));
        Boolean bool = this.y;
        return bool != null && bool.booleanValue();
    }

    public boolean d(com.alipay.sdk.m.w.a aVar) {
        a(aVar, a1, String.valueOf(this.H));
        Boolean bool = this.H;
        return bool != null && bool.booleanValue();
    }

    public boolean e(com.alipay.sdk.m.w.a aVar) {
        a(aVar, e1, String.valueOf(this.I));
        return !this.I;
    }

    public boolean f(com.alipay.sdk.m.w.a aVar) {
        a(aVar, V0, String.valueOf(this.E));
        Boolean bool = this.E;
        return bool != null && bool.booleanValue();
    }

    public boolean g(com.alipay.sdk.m.w.a aVar) {
        a(aVar, X0, String.valueOf(this.G));
        Boolean bool = this.G;
        return bool != null && bool.booleanValue();
    }

    public boolean h(com.alipay.sdk.m.w.a aVar) {
        a(aVar, W0, String.valueOf(this.F));
        Boolean bool = this.F;
        return bool != null && bool.booleanValue();
    }

    public boolean j(com.alipay.sdk.m.w.a aVar) {
        a(aVar, P0, String.valueOf(this.A));
        Boolean bool = this.A;
        return bool != null && bool.booleanValue();
    }

    public final void k(com.alipay.sdk.m.w.a aVar) {
        try {
            m.b(aVar, com.alipay.sdk.m.w.b.c().b(), q0, F().toString());
        } catch (Exception e) {
            g.a(e);
        }
    }

    /* JADX INFO: renamed from: com.alipay.sdk.m.o.b$b, reason: collision with other inner class name */
    public static final class C0199b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f25478a;
        public final int b;
        public final String c;

        public C0199b(String str, int i, String str2) {
            this.f25478a = str;
            this.b = i;
            this.c = str2;
        }

        public static C0199b a(JSONObject jSONObject) {
            if (jSONObject == null) {
                return null;
            }
            return new C0199b(jSONObject.optString(AliyunLogKey.KEY_PART_NUMBER), jSONObject.optInt("v", 0), jSONObject.optString("pk"));
        }

        public String toString() {
            return String.valueOf(a(this));
        }

        public static List<C0199b> a(JSONArray jSONArray) {
            if (jSONArray == null) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            int length = jSONArray.length();
            for (int i = 0; i < length; i++) {
                C0199b c0199bA = a(jSONArray.optJSONObject(i));
                if (c0199bA != null) {
                    arrayList.add(c0199bA);
                }
            }
            return arrayList;
        }

        public static JSONObject a(C0199b c0199b) {
            if (c0199b == null) {
                return null;
            }
            try {
                return new JSONObject().put(AliyunLogKey.KEY_PART_NUMBER, c0199b.f25478a).put("v", c0199b.b).put("pk", c0199b.c);
            } catch (JSONException e) {
                g.a(e);
                return null;
            }
        }

        public static JSONArray a(List<C0199b> list) {
            if (list == null) {
                return null;
            }
            JSONArray jSONArray = new JSONArray();
            Iterator<C0199b> it = list.iterator();
            while (it.hasNext()) {
                jSONArray.put(a(it.next()));
            }
            return jSONArray;
        }
    }

    public static b i() {
        if (f1 == null) {
            b bVar = new b();
            f1 = bVar;
            bVar.v();
        }
        return f1;
    }

    public JSONObject a() {
        return this.L;
    }

    public boolean a(com.alipay.sdk.m.w.a aVar) {
        a(aVar, Q0, String.valueOf(this.B));
        Boolean bool = this.B;
        return bool != null && bool.booleanValue();
    }

    public void a(boolean z) {
        this.g = z;
    }

    public final void a(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            a(new JSONObject(str));
        } catch (Throwable th) {
            g.a(th);
        }
    }

    public final void a(com.alipay.sdk.m.w.a aVar, String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject(t0);
            com.alipay.sdk.m.y.a.a(aVar, jSONObjectOptJSONObject, com.alipay.sdk.m.y.a.a(aVar, jSONObject));
            if (jSONObjectOptJSONObject != null) {
                a(jSONObjectOptJSONObject);
            } else {
                g.e(P, "empty config");
            }
        } catch (Throwable th) {
            g.a(th);
        }
    }

    public final void a(JSONObject jSONObject) {
        g.d(com.alipay.sdk.m.n.a.B, "readFromJson:" + jSONObject);
        this.f25476a = jSONObject.optInt(r0, 10000);
        this.b = jSONObject.optBoolean(s0, false);
        this.c = jSONObject.optString(u0, R).trim();
        this.d = jSONObject.optInt(w0, 10);
        this.N = C0199b.a(jSONObject.optJSONArray(v0));
        this.e = jSONObject.optBoolean(T0, true);
        this.h = jSONObject.optBoolean(x0, false);
        this.i = jSONObject.optBoolean(y0, true);
        this.j = jSONObject.optBoolean(z0, true);
        this.k = jSONObject.optBoolean(A0, false);
        this.l = jSONObject.optBoolean(B0, true);
        this.m = jSONObject.optBoolean(C0, false);
        this.n = jSONObject.optBoolean(D0, false);
        this.o = jSONObject.optBoolean(E0, false);
        this.p = jSONObject.optBoolean(F0, true);
        this.q = jSONObject.optString(G0, "");
        this.u = jSONObject.optBoolean(H0, false);
        this.w = jSONObject.optBoolean(L0, false);
        this.r = jSONObject.optString(b1, "");
        this.v = jSONObject.optInt(J0, 1000);
        this.M = jSONObject.optBoolean(K0, true);
        this.s = jSONObject.optBoolean(c1, false);
        this.t = jSONObject.optBoolean(d1, false);
        this.f = jSONObject.optBoolean(M0, false);
        this.L = jSONObject.optJSONObject(com.alipay.sdk.m.y.a.b);
        if (jSONObject.has(N0)) {
            this.x = Boolean.valueOf(jSONObject.optBoolean(N0, false));
        } else {
            this.x = null;
        }
        if (jSONObject.has(O0)) {
            this.y = Boolean.valueOf(jSONObject.optBoolean(O0, false));
        } else {
            this.y = null;
        }
        if (jSONObject.has(P0)) {
            this.A = Boolean.valueOf(jSONObject.optBoolean(P0, false));
        } else {
            this.A = null;
        }
        if (jSONObject.has(Q0)) {
            this.B = Boolean.valueOf(jSONObject.optBoolean(Q0, false));
        } else {
            this.B = null;
        }
        if (jSONObject.has(R0)) {
            this.C = Boolean.valueOf(jSONObject.optBoolean(R0, false));
        } else {
            this.C = null;
        }
        if (jSONObject.has(S0)) {
            this.z = Boolean.valueOf(jSONObject.optBoolean(S0, false));
        } else {
            this.z = null;
        }
        this.D.a(jSONObject.optString(U0, null));
        if (jSONObject.has(V0)) {
            this.E = Boolean.valueOf(jSONObject.optBoolean(V0, false));
        } else {
            this.E = null;
        }
        if (jSONObject.has(W0)) {
            this.F = Boolean.valueOf(jSONObject.optBoolean(W0, false));
        } else {
            this.F = null;
        }
        if (jSONObject.has(X0)) {
            this.G = Boolean.valueOf(jSONObject.optBoolean(X0, false));
        } else {
            this.G = null;
        }
        if (jSONObject.has(a1)) {
            this.H = Boolean.valueOf(jSONObject.optBoolean(a1, false));
        } else {
            this.H = null;
        }
        this.I = jSONObject.optBoolean(e1, false);
        this.K = jSONObject.optBoolean(Z0, false);
        this.J = jSONObject.optLong(Y0, 200L);
    }

    public void a(com.alipay.sdk.m.w.a aVar, Context context, boolean z, int i) {
        com.alipay.sdk.m.m.a.a(aVar, com.alipay.sdk.m.m.b.l, "oncfg|" + z + "|" + i);
        a aVar2 = new a(aVar, context, z, i);
        if (z && !q.h()) {
            int iF = f();
            if (q.a(iF, aVar2, "AlipayDCPBlok")) {
                return;
            }
            com.alipay.sdk.m.m.a.b(aVar, com.alipay.sdk.m.m.b.l, com.alipay.sdk.m.m.b.m0, "" + iF);
            return;
        }
        Thread thread = new Thread(aVar2);
        thread.setName("AlipayDCP");
        thread.start();
    }

    public boolean a(Context context, int i) {
        if (this.O == -1) {
            this.O = q.a();
            m.b(com.alipay.sdk.m.w.a.f(), context, I0, String.valueOf(this.O));
        }
        return this.O < i;
    }

    public final void a(com.alipay.sdk.m.w.a aVar, String str, String str2) {
        if (aVar == null) {
            return;
        }
        com.alipay.sdk.m.m.a.a(aVar, com.alipay.sdk.m.m.b.l, "getConfig", str + "|" + str2);
    }
}
