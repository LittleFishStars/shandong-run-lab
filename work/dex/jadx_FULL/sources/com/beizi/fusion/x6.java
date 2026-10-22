package com.beizi.fusion;

import android.content.Context;
import android.provider.Settings;
import android.text.TextUtils;
import com.alibaba.ariver.kernel.common.service.executor.RVScheduleType;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
class x6 implements yb {
    private String B;
    private String C;
    private String D;
    private boolean E;
    private String F;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f28024a;
    private String b;
    private int c;
    private String d;
    private String e;
    private String f;
    private String h;
    private String i;
    private int j;
    private String k;
    private int l;
    private int m;
    private int n;
    private int o;
    private int p;
    private int q;
    private String r;
    private String s;
    private String t;
    private String u;
    private String v;
    private float w;
    private String x;
    private String y;
    private String z;
    private int A = -1;
    private final int g = z6.i();

    public x6(Context context) {
        this.f28024a = context.getApplicationContext();
    }

    private String b(String str) {
        str.getClass();
        switch (str) {
            case "1":
                return "CMCC";
            case "2":
                return "CUCC";
            case "3":
                return "CTCC";
            default:
                return RVScheduleType.UNKNOW;
        }
    }

    @Override // com.beizi.fusion.yb
    public String A() {
        if (TextUtils.isEmpty(this.r)) {
            this.r = z6.c();
        }
        return this.r;
    }

    @Override // com.beizi.fusion.yb
    public int B() {
        return this.g;
    }

    @Override // com.beizi.fusion.yb
    public int C() {
        if (this.m == 0) {
            this.m = gn.f(this.f28024a);
        }
        return this.m;
    }

    @Override // com.beizi.fusion.yb
    public String D() {
        if (TextUtils.isEmpty(this.k)) {
            this.k = z6.f();
        }
        return this.k;
    }

    @Override // com.beizi.fusion.yb
    public String E() {
        if (TextUtils.isEmpty(this.B)) {
            dk.a().c();
            this.B = dk.a().b();
        }
        return this.B;
    }

    @Override // com.beizi.fusion.yb
    public String F() {
        if (TextUtils.isEmpty(this.v)) {
            this.v = z6.j();
        }
        return this.v;
    }

    public int G() {
        return Settings.Global.getInt(this.f28024a.getContentResolver(), "development_settings_enabled", 0);
    }

    @Override // com.beizi.fusion.yb
    public int a() {
        if (this.j == 0) {
            this.j = wi.a(this.f28024a);
        }
        return this.j;
    }

    @Override // com.beizi.fusion.yb
    public int c() {
        if (this.p == 0) {
            this.p = gn.c(this.f28024a);
        }
        return this.p;
    }

    @Override // com.beizi.fusion.yb
    public String d() {
        if (TextUtils.isEmpty(this.b)) {
            this.b = qp.a().b(this.f28024a);
        }
        return this.b;
    }

    @Override // com.beizi.fusion.yb
    public String e() {
        if (TextUtils.isEmpty(this.d)) {
            this.d = z6.g();
        }
        return this.d;
    }

    @Override // com.beizi.fusion.yb
    public int f() {
        return (G() == 1 || wi.a()) ? 1 : 0;
    }

    @Override // com.beizi.fusion.yb
    public String g() {
        if (TextUtils.isEmpty(this.f)) {
            this.f = z6.h();
        }
        return this.f;
    }

    @Override // com.beizi.fusion.yb
    public String getOAID() {
        if (TextUtils.isEmpty(this.u)) {
            this.u = wj.a().c(this.f28024a);
        }
        if (TextUtils.isEmpty(this.u)) {
            return TextUtils.isEmpty(this.D) ? "" : this.D;
        }
        return this.u;
    }

    @Override // com.beizi.fusion.yb
    public String h() {
        if (TextUtils.isEmpty(this.e)) {
            this.e = z6.b();
        }
        return this.e;
    }

    @Override // com.beizi.fusion.yb
    public float i() {
        if (this.w == 0.0f) {
            this.w = gn.a(this.f28024a);
        }
        return this.w;
    }

    @Override // com.beizi.fusion.yb
    public String j() {
        if (TextUtils.isEmpty(this.h)) {
            this.h = z6.a();
        }
        return this.h;
    }

    @Override // com.beizi.fusion.yb
    public int k() {
        if (this.q == 0) {
            this.q = gn.b(this.f28024a);
        }
        return this.q;
    }

    @Override // com.beizi.fusion.yb
    public String l() {
        if (TextUtils.isEmpty(this.t)) {
            this.t = z6.e();
        }
        return this.t;
    }

    @Override // com.beizi.fusion.yb
    public String m() {
        return "";
    }

    @Override // com.beizi.fusion.yb
    public String n() {
        if (TextUtils.isEmpty(this.s)) {
            this.s = z6.g(this.f28024a);
        }
        return this.s;
    }

    @Override // com.beizi.fusion.yb
    public int o() {
        return pn.c(this.f28024a);
    }

    @Override // com.beizi.fusion.yb
    public int p() {
        if (this.o == 0) {
            this.o = gn.g(this.f28024a);
        }
        return this.o;
    }

    @Override // com.beizi.fusion.yb
    public String q() {
        if (this.E) {
            return b(this.F);
        }
        if (TextUtils.isEmpty(this.i)) {
            this.i = z6.a(this.f28024a);
        }
        return this.i;
    }

    @Override // com.beizi.fusion.yb
    public String r() {
        if (TextUtils.isEmpty(this.y)) {
            this.y = z6.d() + "";
        }
        return this.y;
    }

    @Override // com.beizi.fusion.yb
    public String s() {
        if (TextUtils.isEmpty(this.x)) {
            this.x = z6.c(this.f28024a);
        }
        return this.x;
    }

    @Override // com.beizi.fusion.yb
    public String t() {
        return dk.a().a(this.f28024a);
    }

    @Override // com.beizi.fusion.yb
    public int u() {
        if (this.l == 0) {
            this.l = gn.d(this.f28024a);
        }
        return this.l;
    }

    @Override // com.beizi.fusion.yb
    public int v() {
        if (this.n == 0) {
            this.n = gn.e(this.f28024a);
        }
        return this.n;
    }

    @Override // com.beizi.fusion.yb
    public String w() {
        if (TextUtils.isEmpty(this.C)) {
            this.C = wj.a().a(this.f28024a);
        }
        return this.C;
    }

    @Override // com.beizi.fusion.yb
    public int x() {
        if (this.A == -1) {
            this.A = z6.b(this.f28024a);
        }
        return this.A;
    }

    @Override // com.beizi.fusion.yb
    public int y() {
        if (this.c == 0) {
            this.c = z6.e(this.f28024a);
        }
        return this.c;
    }

    @Override // com.beizi.fusion.yb
    public String z() {
        return dk.a().b(this.f28024a);
    }

    @Override // com.beizi.fusion.yb
    public String b() {
        if (TextUtils.isEmpty(this.z)) {
            this.z = z6.d(this.f28024a);
        }
        return this.z;
    }

    @Override // com.beizi.fusion.yb
    public void a(String str) {
        this.D = str;
    }

    @Override // com.beizi.fusion.yb
    public void a(boolean z, String str) {
        this.E = z;
        this.F = str;
    }
}
