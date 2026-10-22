package com.beizi.fusion;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import androidx.camera.video.AudioStats;
import com.ali.auth.third.login.LoginConstants;
import com.alibaba.alibclinkpartner.linkpartner.constants.ALPParamConstant;
import com.beizi.ad.internal.activity.BeiZiDownloadDialogActivity;
import com.beizi.ad.lance.ApkBean;
import com.beizi.ad.v2.activity.BeiZiLandingActivity;
import com.beizi.ad.v2.activity.BeiZiLandingPageActivity;
import com.huachenjie.common.video.VideoPlayerActivity;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.zj.adlib.bv9;
import com.zj.adlib.u15;
import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class on {
    private boolean A;
    private wk A0;
    private x1.b.C0333b B;
    private nh B0;
    private int C;
    private gp C0;
    private String D;
    private cl D0;
    private String E;
    private List E0;
    private String F;
    public boolean F0;
    private String G;
    private String G0;
    private String H;
    public x4 H0;
    private String I;
    private np I0;
    private String J;
    private uk J0;
    private String K;
    private f5 K0;
    private String L;
    private int L0;
    private String M;
    private int M0;
    private String N;
    private String O;
    private x1.b.a P;
    private boolean Q;
    private boolean R;
    private int T;
    private w5 U;
    private x1.b V;
    private List W;
    private String X;
    public th Y;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private i7 f27622a;
    private String a0;
    private String b0;
    private String c0;
    private String e0;
    private String f0;
    private String g0;
    private int h0;
    private String i0;
    private String j0;
    private String k0;
    private String l;
    private String l0;
    private String m0;
    private im n0;
    private x1.g o;
    private String o0;
    private String p;
    private String p0;
    private String q;
    private String q0;
    private String r;
    private String r0;
    private n7 s;
    private c4 s0;
    private List t0;
    private long u;
    private int u0;
    private boolean v;
    private int v0;
    private boolean w;
    private int w0;
    private boolean x;
    private boolean y;
    private kj y0;
    private boolean z;
    private kj z0;
    private int b = 0;
    private boolean c = false;
    private boolean d = false;
    private int e = 0;
    private int f = 0;
    private boolean g = false;
    private int h = 0;
    private e i = new e();
    private e j = new e();
    private boolean k = true;
    private boolean m = false;
    private x1.e n = new x1.e();
    private int t = 0;
    private int S = -1;
    private List Z = new LinkedList();
    private boolean d0 = false;
    private boolean x0 = true;

    public class a implements Comparator {
        public a() {
        }

        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(x1.d dVar, x1.d dVar2) {
            try {
                int i = Integer.parseInt(dVar.r()) - Integer.parseInt(dVar2.r());
                if (i > 0) {
                    return -1;
                }
                return i < 0 ? 1 : 0;
            } catch (Exception e) {
                e.printStackTrace();
                return -1;
            }
        }
    }

    public class b implements m1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Context f27624a;

        public b(Context context) {
            this.f27624a = context;
        }

        @Override // com.beizi.fusion.m1
        public void a() {
            try {
                x1.b.C0333b c0333b = on.this.B;
                if (c0333b != null) {
                    List listK = c0333b.k();
                    on.this.B.q(null);
                    bm.a(listK);
                }
            } catch (Exception unused) {
            }
        }

        @Override // com.beizi.fusion.m1
        public void b() {
            try {
                on onVar = on.this;
                if (onVar.x0) {
                    x1.b.C0333b c0333b = onVar.B;
                    if (c0333b != null) {
                        List listJ = c0333b.j();
                        on.this.B.p(null);
                        bm.a(listJ);
                    }
                    on.this.e(this.f27624a);
                }
            } catch (Exception unused) {
            }
        }
    }

    public class c implements Comparator {
        public c() {
        }

        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(x1.d dVar, x1.d dVar2) {
            try {
                int i = Integer.parseInt(dVar.r()) - Integer.parseInt(dVar2.r());
                if (i > 0) {
                    return -1;
                }
                return i < 0 ? 1 : 0;
            } catch (Exception e) {
                e.printStackTrace();
                return -1;
            }
        }
    }

    public class d implements m1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f27626a;
        final /* synthetic */ Context b;

        public d(int i, Context context) {
            this.f27626a = i;
            this.b = context;
        }

        @Override // com.beizi.fusion.m1
        public void a() {
        }

        @Override // com.beizi.fusion.m1
        public void b() {
            try {
                if (this.f27626a == 0) {
                    on onVar = on.this;
                    onVar.x0 = true;
                    onVar.c(this.b);
                }
            } catch (Exception unused) {
                on onVar2 = on.this;
                onVar2.x0 = false;
                x1.b.C0333b c0333b = onVar2.B;
                if (c0333b != null) {
                    List listC = c0333b.c();
                    on.this.B.e(null);
                    bm.a(listC);
                }
                on.this.a(this.b);
            }
        }
    }

    public static class e {
        public static int c = 0;
        public static int d = 1;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        String f27627a;
        int b = 0;

        public String a() {
            return this.f27627a;
        }

        public int b() {
            return this.b;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(String str) {
            this.f27627a = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(int i) {
            this.b = i;
        }
    }

    public on(String str, Map map, th thVar) {
        if (str == null) {
            return;
        }
        this.Y = thVar;
        this.m0 = str;
        try {
            f(x1.i.a(str));
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        q0();
    }

    private void a(x1.b bVar) {
        this.V = bVar;
        this.W = bVar.v();
        this.B = bVar.m();
        this.C = bVar.n();
        this.D = bVar.a();
        this.E = bVar.t();
        this.F = bVar.b();
        this.G = bVar.d();
        if (TextUtils.isEmpty(this.E)) {
            this.E = "lance";
        }
        if (TextUtils.isEmpty(this.D)) {
            this.D = "BeiZi";
        }
        if (TextUtils.isEmpty(this.F)) {
            this.F = "Ad Download";
        }
        this.H = bVar.i();
        this.I = bVar.c();
        this.J = bVar.f();
        this.K = bVar.g();
        this.L = bVar.h();
        this.M = bVar.e();
        this.N = bVar.j();
        x1.b.a aVarL = bVar.l();
        this.P = aVarL;
        if (aVarL != null) {
            if (aVarL.a() == 1) {
                this.Q = true;
            }
            if (this.P.b() == 1) {
                this.R = true;
            }
            this.T = this.P.c();
        }
    }

    private boolean c(x1.i iVar) {
        if (iVar.b() > 0) {
            x1.j jVar = (x1.j) iVar.a().get(0);
            this.f27622a = jVar.c();
            this.b = jVar.r();
            this.c = jVar.n();
            this.d = jVar.e();
            this.e = jVar.m();
            this.f = jVar.l();
            this.g = jVar.f();
            List listB = jVar.b();
            this.t0 = listB;
            if (listB != null && listB.size() > 0) {
                this.l = ((x1.d) this.t0.get(0)).r();
                this.p = ((x1.d) this.t0.get(0)).u();
                this.X = ((x1.d) this.t0.get(0)).b();
                this.t = ((x1.d) this.t0.get(0)).k();
                this.u = (iVar.d() / 1000000) + ((long) (this.t * 1000));
                this.o0 = ((x1.d) this.t0.get(0)).s();
                this.q0 = ((x1.d) this.t0.get(0)).q();
                this.r0 = ((x1.d) this.t0.get(0)).e();
            }
            this.o = jVar.d();
            this.H0 = jVar.g();
            this.K0 = jVar.h();
            this.M0 = jVar.t();
            if (jVar.a() > 0) {
                int i = 0;
                for (x1.d dVar : jVar.b()) {
                    if (i == 0) {
                        this.X = dVar.b();
                        kh.a("BeiZisAd", "mAdid = " + this.X);
                    }
                    if (dVar.d() <= 0 || dVar.c().get(0) == null) {
                        x1.c cVarA = dVar.a();
                        if (cVarA != null) {
                            if (cVarA.b() != null) {
                                this.i.a(cVarA.b());
                                this.i.a(e.c);
                            } else {
                                this.i.a(cVarA.a());
                                this.i.a(e.d);
                            }
                            if (cVarA.d() != null) {
                                this.j.a(cVarA.d());
                                this.j.a(e.c);
                            } else {
                                this.j.a(cVarA.c());
                                this.j.a(e.d);
                            }
                        }
                        if (dVar.i() > 0) {
                            for (x1.a aVar : dVar.j()) {
                                this.s = aVar.c();
                                this.p0 = aVar.d();
                                b(aVar.d());
                                if (aVar.b() > 0) {
                                    if (this.s == n7.RENDER_VIDEO) {
                                        this.g0 = ((x1.f) aVar.a().get(0)).a();
                                    } else {
                                        this.r = ((x1.f) aVar.a().get(0)).a();
                                    }
                                }
                            }
                        }
                        if (dVar.l() != null) {
                            x1.b bVarL = dVar.l();
                            a(bVarL);
                            this.a0 = bVarL.p();
                            this.c0 = bVarL.u();
                            if (this.Y == th.REWARDEDVIDEO) {
                                this.b0 = bVarL.k();
                            } else {
                                this.b0 = Uri.decode(bVarL.k());
                            }
                        }
                        x1.e eVarV = dVar.v();
                        if (eVarV != null) {
                            this.n.a(eVarV.c());
                            this.n.b(eVarV.b());
                            this.n.a(eVarV.a());
                        }
                        this.U = dVar.h();
                        this.y0 = dVar.n();
                        this.A0 = dVar.p();
                        this.B0 = dVar.m();
                        this.D0 = dVar.g();
                        this.E0 = dVar.f();
                        this.J0 = dVar.o();
                    }
                    i++;
                    if (!TextUtils.isEmpty(this.r) || !TextUtils.isEmpty(this.g0) || m0()) {
                        break;
                    }
                }
            }
        }
        if (TextUtils.isEmpty(this.r) && TextUtils.isEmpty(this.g0) && !m0()) {
            return false;
        }
        this.d0 = true;
        return true;
    }

    private void d(Context context) {
        if (context == null) {
            return;
        }
        a4.j().a(new b(context));
        if (b(context)) {
            return;
        }
        c(context);
    }

    private boolean e(x1.i iVar) {
        if (iVar.b() > 0) {
            x1.j jVar = (x1.j) iVar.a().get(0);
            this.f27622a = jVar.c();
            this.b = jVar.r();
            this.c = jVar.n();
            this.d = jVar.e();
            this.e = jVar.m();
            this.f = jVar.l();
            this.g = jVar.f();
            List listB = jVar.b();
            this.t0 = listB;
            if (listB != null && listB.size() > 0) {
                this.l = ((x1.d) this.t0.get(0)).r();
                this.p = ((x1.d) this.t0.get(0)).u();
                this.X = ((x1.d) this.t0.get(0)).b();
                this.t = ((x1.d) this.t0.get(0)).k();
                this.u = (iVar.d() / 1000000) + ((long) (this.t * 1000));
                this.o0 = ((x1.d) this.t0.get(0)).s();
                this.q0 = ((x1.d) this.t0.get(0)).q();
                this.r0 = ((x1.d) this.t0.get(0)).e();
            }
            this.o = jVar.d();
            this.H0 = jVar.g();
            this.K0 = jVar.h();
            this.M0 = jVar.t();
            if (jVar.a() > 0) {
                int i = 0;
                for (x1.d dVar : jVar.b()) {
                    if (i == 0) {
                        this.X = dVar.b();
                        kh.a("BeiZisAd", "mAdid = " + this.X);
                    }
                    if (dVar.d() <= 0 || dVar.c().get(0) == null) {
                        x1.c cVarA = dVar.a();
                        if (cVarA != null) {
                            if (cVarA.b() != null) {
                                this.i.a(cVarA.b());
                                this.i.a(e.c);
                            } else {
                                this.i.a(cVarA.a());
                                this.i.a(e.d);
                            }
                            if (cVarA.d() != null) {
                                this.j.a(cVarA.d());
                                this.j.a(e.c);
                            } else {
                                this.j.a(cVarA.c());
                                this.j.a(e.d);
                            }
                        }
                        if (dVar.i() > 0) {
                            for (x1.a aVar : dVar.j()) {
                                this.s = aVar.c();
                                this.p0 = aVar.d();
                                b(aVar.d());
                                a(aVar);
                            }
                        }
                        if (dVar.l() != null) {
                            x1.b bVarL = dVar.l();
                            a(bVarL);
                            this.a0 = bVarL.p();
                            this.c0 = bVarL.u();
                            if (this.Y == th.REWARDEDVIDEO) {
                                this.b0 = bVarL.k();
                            } else {
                                this.b0 = Uri.decode(bVarL.k());
                            }
                        }
                        x1.e eVarV = dVar.v();
                        if (eVarV != null) {
                            this.n.a(eVarV.c());
                            this.n.b(eVarV.b());
                            this.n.a(eVarV.a());
                        }
                        this.U = dVar.h();
                        this.y0 = dVar.n();
                        this.A0 = dVar.p();
                        this.B0 = dVar.m();
                        this.J0 = dVar.o();
                    }
                    i++;
                    if (!TextUtils.isEmpty(this.i0) || !TextUtils.isEmpty(this.g0) || !TextUtils.isEmpty(this.l0) || m0()) {
                        break;
                    }
                }
            }
        }
        if (TextUtils.isEmpty(this.i0) && TextUtils.isEmpty(this.g0) && TextUtils.isEmpty(this.l0) && !m0()) {
            return false;
        }
        this.d0 = true;
        return true;
    }

    private void f(x1.i iVar) {
        if (a(iVar)) {
            th thVar = this.Y;
            if (thVar == th.NEW_SPLASH) {
                c(iVar);
                return;
            }
            if (thVar == th.REWARDEDVIDEO) {
                d(iVar);
            } else if (thVar != th.NATIVE) {
                e(iVar);
            } else {
                b(iVar);
            }
        }
    }

    private boolean f0() {
        oh ohVarD;
        try {
            f5 f5Var = this.K0;
            if (f5Var == null || (ohVarD = f5Var.d()) == null) {
                return false;
            }
            int iE = ohVarD.e();
            return iE == 1 || iE == 2;
        } catch (Exception unused) {
            return false;
        }
    }

    private boolean j0() {
        int i = this.C;
        if (i == 2) {
            return !TextUtils.isEmpty(this.G) && this.G.startsWith("http");
        }
        return i == 5 && !TextUtils.isEmpty(this.G);
    }

    private boolean k0() {
        if (TextUtils.isEmpty(this.D) || TextUtils.isEmpty(this.I) || TextUtils.isEmpty(this.H) || TextUtils.isEmpty(this.L) || TextUtils.isEmpty(this.N)) {
            return false;
        }
        if (TextUtils.isEmpty(this.K) && TextUtils.isEmpty(this.J)) {
            return false;
        }
        int i = this.C;
        return i == 2 || i == 5;
    }

    private boolean m0() {
        return this.s == n7.RENDER_UNIFIED || !TextUtils.isEmpty(this.p0);
    }

    private void q0() {
    }

    public String A() {
        return this.G;
    }

    public kj B() {
        return this.z0;
    }

    public int C() {
        return this.t;
    }

    public String D() {
        return this.i0;
    }

    public int E() {
        return this.C;
    }

    public String F() {
        return this.a0;
    }

    public String G() {
        return this.j0;
    }

    public e H() {
        return this.j;
    }

    public String I() {
        return this.r;
    }

    public n7 J() {
        return this.s;
    }

    public int K() {
        return this.f;
    }

    public int L() {
        return this.e;
    }

    public String M() {
        x1.b bVar = this.V;
        if (bVar == null) {
            return null;
        }
        return bVar.r();
    }

    public String N() {
        x1.b bVar = this.V;
        if (bVar == null) {
            return null;
        }
        return bVar.s();
    }

    public mi O() {
        return this.s0;
    }

    public np P() {
        return this.I0;
    }

    public kj Q() {
        try {
            kj kjVar = this.y0;
            if (kjVar != null) {
                String strG = kjVar.g();
                if (TextUtils.isEmpty(strG)) {
                    th thVar = this.Y;
                    if (thVar == th.NEW_SPLASH || thVar == th.NATIVE) {
                        strG = I();
                    } else if (thVar == th.INTERSTITIAL) {
                        strG = D();
                    } else if (thVar == th.REWARDEDVIDEO) {
                        strG = G();
                    } else if (thVar == th.SPLASHUNIFIED) {
                        strG = c0();
                    }
                }
                this.y0.c(strG);
            }
            return this.y0;
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public wk R() {
        return this.A0;
    }

    public String S() {
        return this.q0;
    }

    public String T() {
        return this.E;
    }

    public String U() {
        int i = this.u0;
        return i > 0 ? String.valueOf(i) : this.l;
    }

    public String V() {
        return this.o0;
    }

    public im W() {
        return this.n0;
    }

    public Map X() {
        if (this.n == null) {
            return null;
        }
        HashMap map = new HashMap();
        map.put("forceUnreal", Boolean.valueOf(this.n.c()));
        if (this.n.b() > AudioStats.AUDIO_AMPLITUDE_NONE) {
            map.put("maxAcc", Double.valueOf(this.n.b()));
        }
        if (this.n.a() > AudioStats.AUDIO_AMPLITUDE_NONE) {
            map.put("angle", Double.valueOf(this.n.a()));
        }
        return map;
    }

    public String Y() {
        return this.f0;
    }

    public int Z() {
        return this.M0;
    }

    public void a(Map map) {
    }

    public String a0() {
        return this.p0;
    }

    public void b(boolean z) {
        this.m = z;
    }

    public String b0() {
        return this.e0;
    }

    public void c(boolean z) {
    }

    public String c0() {
        return this.l0;
    }

    public int d0() {
        return this.h0;
    }

    public String e0() {
        return this.g0;
    }

    public i7 g() {
        return this.f27622a;
    }

    public boolean g0() {
        return this.d;
    }

    public e h() {
        return this.i;
    }

    public boolean h0() {
        return this.Q;
    }

    public String i() {
        return this.r0;
    }

    public boolean i0() {
        return TextUtils.isEmpty(this.b0) && k0() && j0();
    }

    public String j() {
        return this.D;
    }

    public String k() {
        return this.I;
    }

    public String l() {
        return this.G;
    }

    public boolean l0() {
        return this.c;
    }

    public String m() {
        return this.k0;
    }

    public String n() {
        return this.J;
    }

    public boolean n0() {
        return System.currentTimeMillis() < this.u;
    }

    public String o() {
        return this.K;
    }

    public boolean o0() {
        return !TextUtils.isEmpty(this.g0);
    }

    public String p() {
        return this.L;
    }

    public boolean p0() {
        return this.T == 1;
    }

    public String q() {
        return this.H;
    }

    public String r() {
        return this.N;
    }

    public String s() {
        try {
            JSONObject jSONObject = new JSONObject();
            x1.g gVar = this.o;
            if (gVar != null) {
                jSONObject.put("raiseSortPrice", gVar.e());
                jSONObject.put("effectRate", this.o.c());
                jSONObject.put("auctionType", this.o.a());
                jSONObject.put("isLastLook", this.o.d());
                jSONObject.put("winPriceMin", this.o.g());
                jSONObject.put("winPriceMax", this.o.f());
                jSONObject.put("customData", this.o.b());
            } else {
                jSONObject.put("raiseSortPrice", -1);
                jSONObject.put("effectRate", -1);
                jSONObject.put("auctionType", -1);
                jSONObject.put("isLastLook", -1);
                jSONObject.put("winPriceMin", "");
                jSONObject.put("winPriceMax", "");
                jSONObject.put("customData", "");
            }
            try {
                int i = this.v0;
                if (i > 0) {
                    jSONObject.put("secondPrice", i);
                } else if (!TextUtils.isEmpty(this.p)) {
                    jSONObject.put("secondPrice", Integer.parseInt(this.p));
                }
            } catch (NumberFormatException | JSONException unused) {
            }
            return h2.b(rg.a(), u8.a(jSONObject.toString()));
        } catch (Exception unused2) {
            return null;
        }
    }

    public x4 t() {
        return this.H0;
    }

    public int u() {
        return this.L0;
    }

    public List v() {
        return this.E0;
    }

    public f5 w() {
        oh ohVarD;
        try {
            f5 f5Var = this.K0;
            if (f5Var != null && (ohVarD = f5Var.d()) != null) {
                int iB = ohVarD.b();
                int iD = ohVarD.d();
                if (iB == 0 && iD == 0) {
                    ohVarD.b(2);
                    this.K0.a(ohVarD);
                }
            }
            return this.K0;
        } catch (Exception unused) {
            return null;
        }
    }

    public cl x() {
        return this.D0;
    }

    public Map y() {
        if (this.U == null) {
            return null;
        }
        try {
            HashMap map = new HashMap();
            if (this.U.d() > AudioStats.AUDIO_AMPLITUDE_NONE) {
                map.put("maxAcc", Double.valueOf(this.U.d()));
            }
            if (this.U.a() > AudioStats.AUDIO_AMPLITUDE_NONE) {
                map.put("angle", Double.valueOf(this.U.a()));
            }
            if (this.U.c() > AudioStats.AUDIO_AMPLITUDE_NONE) {
                map.put("duration", Double.valueOf(this.U.c()));
            }
            if (!TextUtils.isEmpty(this.U.b())) {
                map.put(HiAnalyticsConstant.HaKey.BI_KEY_DIRECTION, this.U.b());
            }
            return map;
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public String z() {
        return this.b0;
    }

    private boolean b(x1.i iVar) {
        if (iVar.b() > 0) {
            x1.j jVar = (x1.j) iVar.a().get(0);
            this.f27622a = jVar.c();
            this.b = jVar.r();
            this.t0 = jVar.b();
            this.c = jVar.n();
            this.d = jVar.e();
            this.e = jVar.m();
            this.f = jVar.l();
            this.g = jVar.f();
            this.u0 = jVar.u();
            this.v0 = jVar.v();
            this.y0 = jVar.p();
            this.A0 = jVar.q();
            this.C0 = jVar.w();
            this.o = jVar.d();
            this.H0 = jVar.g();
            this.I0 = jVar.o();
            this.K0 = jVar.h();
            this.M0 = jVar.t();
            List list = this.t0;
            if (list != null && list.size() > 0) {
                Collections.sort(this.t0, new a());
                for (x1.d dVar : this.t0) {
                    int iX = dVar.x();
                    if (iX == 0) {
                        this.w0 = iX;
                        this.l = dVar.r();
                        this.p = dVar.u();
                        this.X = dVar.b();
                        this.t = dVar.k();
                        this.u = (iVar.d() / 1000000) + ((long) (this.t * 1000));
                        this.o0 = dVar.s();
                        this.q0 = dVar.q();
                        this.r0 = dVar.e();
                        if (dVar.i() < 0) {
                            break;
                        }
                        for (x1.a aVar : dVar.j()) {
                            if (aVar.c() == n7.RENDER_JSON || aVar.c() == n7.RENDER_UNIFIED) {
                                try {
                                    x1.c cVarA = dVar.a();
                                    if (cVarA != null) {
                                        if (cVarA.b() != null) {
                                            this.i.a(cVarA.b());
                                            this.i.a(e.c);
                                        } else {
                                            this.i.a(cVarA.a());
                                            this.i.a(e.d);
                                        }
                                        if (cVarA.d() != null) {
                                            this.j.a(cVarA.d());
                                            this.j.a(e.c);
                                        } else {
                                            this.j.a(cVarA.c());
                                            this.j.a(e.d);
                                        }
                                    }
                                    this.s = aVar.c();
                                    this.p0 = aVar.d();
                                    c4 c4VarA = c4.a(new JSONObject(aVar.d()));
                                    this.s0 = c4VarA;
                                    c4VarA.a(H());
                                    this.s0.b(h());
                                    this.r = this.s0.getImageUrl();
                                    if (dVar.l() != null) {
                                        a(dVar.l());
                                        x1.b bVarL = dVar.l();
                                        this.a0 = bVarL.p();
                                        this.b0 = bVarL.k();
                                        this.c0 = bVarL.u();
                                        this.s0.c(!po.b(this.a0) ? this.a0 : this.c0);
                                        this.s0.d(this.b0);
                                        this.s0.a(dVar.l());
                                        List listV = bVarL.v();
                                        if (listV != null && listV.size() > 0) {
                                            for (int i = 0; i < listV.size(); i++) {
                                                String strA = ((x1.h) listV.get(i)).a();
                                                if (!TextUtils.isEmpty(strA)) {
                                                    this.s0.a(strA);
                                                }
                                                String strG = ((x1.h) listV.get(i)).g();
                                                if (!TextUtils.isEmpty(strG)) {
                                                    this.s0.b(strG);
                                                }
                                            }
                                        }
                                    }
                                    x1.e eVarV = dVar.v();
                                    if (eVarV != null) {
                                        this.n.a(eVarV.c());
                                        this.n.b(eVarV.b());
                                        this.n.a(eVarV.a());
                                    }
                                    if (this.U == null) {
                                        this.U = dVar.h();
                                    }
                                    if (this.y0 == null) {
                                        this.y0 = dVar.n();
                                    }
                                    if (this.A0 == null) {
                                        this.A0 = dVar.p();
                                    }
                                    if (this.B0 == null) {
                                        this.B0 = dVar.m();
                                    }
                                    this.J0 = dVar.o();
                                    c4 c4Var = this.s0;
                                    if (c4Var != null) {
                                        c4Var.a(Q());
                                        this.s0.a(this.B0);
                                        this.s0.a(this.t0);
                                        this.s0.a(this.C0);
                                        this.s0.b(this.c);
                                        this.s0.a(this.J0);
                                        this.s0.a(this.K0);
                                    }
                                } catch (JSONException unused) {
                                }
                                if (this.s0 != null || m0()) {
                                    this.d0 = true;
                                    return true;
                                }
                            }
                        }
                        break;
                    }
                }
            }
        }
        return false;
    }

    public String d() {
        return this.m0;
    }

    public void d(boolean z) {
        this.v = z;
    }

    private boolean d(x1.i iVar) {
        if (iVar.b() > 0) {
            x1.j jVar = (x1.j) iVar.a().get(0);
            this.f27622a = jVar.c();
            this.b = jVar.r();
            this.c = jVar.n();
            this.d = jVar.e();
            this.e = jVar.m();
            this.f = jVar.l();
            this.g = jVar.f();
            this.t0 = jVar.b();
            this.u0 = jVar.u();
            this.v0 = jVar.v();
            if (jVar.s() != null) {
                this.n0 = jVar.s();
                this.U = jVar.i();
                this.y0 = jVar.p();
                this.z0 = jVar.j();
                this.A0 = jVar.q();
                this.B0 = jVar.k();
            }
            List list = this.t0;
            if (list != null && list.size() > 0) {
                Collections.sort(this.t0, new c());
                for (x1.d dVar : this.t0) {
                    int iX = dVar.x();
                    if (iX == 0 || iX == 1) {
                        this.w0 = iX;
                        this.l = dVar.r();
                        this.p = dVar.u();
                        this.X = dVar.b();
                        this.t = dVar.k();
                        this.u = (iVar.d() / 1000000) + ((long) (this.t * 1000));
                        this.o0 = dVar.s();
                        this.q0 = dVar.q();
                        this.r0 = dVar.e();
                        if (dVar.d() > 0 && dVar.c().get(0) != null) {
                            break;
                        }
                        x1.c cVarA = dVar.a();
                        if (cVarA != null) {
                            if (cVarA.b() != null) {
                                this.i.a(cVarA.b());
                                this.i.a(e.c);
                            } else {
                                this.i.a(cVarA.a());
                                this.i.a(e.d);
                            }
                            if (cVarA.d() != null) {
                                this.j.a(cVarA.d());
                                this.j.a(e.c);
                            } else {
                                this.j.a(cVarA.c());
                                this.j.a(e.d);
                            }
                        }
                        if (dVar.i() > 0) {
                            for (x1.a aVar : dVar.j()) {
                                this.s = aVar.c();
                                this.p0 = aVar.d();
                                a(aVar.d());
                            }
                        }
                        if (dVar.l() != null) {
                            x1.b bVarL = dVar.l();
                            a(bVarL);
                            this.a0 = bVarL.p();
                            this.c0 = bVarL.u();
                            if (this.Y == th.REWARDEDVIDEO) {
                                this.b0 = bVarL.k();
                            } else {
                                this.b0 = Uri.decode(bVarL.k());
                            }
                        }
                        x1.e eVarV = dVar.v();
                        if (eVarV != null) {
                            this.n.a(eVarV.c());
                            this.n.b(eVarV.b());
                            this.n.a(eVarV.a());
                        }
                        if (this.U == null) {
                            this.U = dVar.h();
                        }
                        if (this.n0 == null) {
                            this.n0 = dVar.t();
                        }
                        if (this.y0 == null) {
                            this.y0 = dVar.n();
                        }
                        if (this.A0 == null) {
                            this.A0 = dVar.p();
                        }
                        if (this.B0 == null) {
                            this.B0 = dVar.m();
                        }
                        this.J0 = dVar.o();
                        break;
                    }
                }
            }
            this.o = jVar.d();
            this.H0 = jVar.g();
            this.K0 = jVar.h();
            this.M0 = jVar.t();
        }
        if (TextUtils.isEmpty(this.g0) && TextUtils.isEmpty(this.j0) && !m0()) {
            return false;
        }
        this.d0 = true;
        return true;
    }

    public void f(View view, String str) {
        List listV;
        String strG;
        int i = this.h;
        if (i <= 0) {
            this.h = i + 1;
            x1.b bVar = this.V;
            if (bVar == null || (listV = bVar.v()) == null) {
                return;
            }
            for (int i2 = 0; i2 < listV.size(); i2++) {
                x1.h hVar = (x1.h) listV.get(i2);
                if (hVar != null && !TextUtils.isEmpty(hVar.g()) && view != null) {
                    if (!TextUtils.isEmpty(str)) {
                        strG = hVar.g().replace("__REQUESTUUID__", str);
                    } else {
                        strG = hVar.g();
                    }
                    if (!TextUtils.isEmpty(this.q)) {
                        strG = strG.replace(uo.f27840a, this.q);
                    }
                    if (this.v) {
                        strG = strG.replace(uo.b, "1");
                    }
                    new h5(po.a(0, view, strG)).executeOnExecutor(w3.c().g(), new Void[0]);
                }
            }
        }
    }

    private boolean f(Context context) {
        x1.b bVar = this.V;
        if (bVar == null) {
            return false;
        }
        try {
            if (bVar.o() == 0) {
                return false;
            }
            String strR = this.V.r();
            String strS = this.V.s();
            String strQ = this.V.q();
            if (!TextUtils.isEmpty(strR) && !TextUtils.isEmpty(strS)) {
                return hq.a(context, strR, strS, strQ);
            }
            String strW = this.V.w();
            if (!TextUtils.isEmpty(strW)) {
                return hq.a(context, strW);
            }
            return false;
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private boolean a(x1.i iVar) {
        return iVar.c() == 0;
    }

    public void a(View view, String str, String str2, String str3, String str4, String str5, String str6, boolean z, String str7) {
        Context context;
        x1.b.C0333b c0333b;
        x1.b.C0333b c0333b2;
        View rootView;
        String strA;
        kh.a("BeiZisAd", "handleClick========" + z);
        if (!z && this.V != null && this.W != null) {
            for (int i = 0; i < this.W.size(); i++) {
                x1.h hVar = (x1.h) this.W.get(i);
                if (hVar != null && !TextUtils.isEmpty(hVar.a())) {
                    if (!TextUtils.isEmpty(str7)) {
                        strA = pp.a(hVar.a(), str, str2, str3, str4, str5, str6, "").replace("__REQUESTUUID__", str7);
                    } else {
                        strA = pp.a(hVar.a(), str, str2, str3, str4, str5, str6, "");
                    }
                    if (this.v) {
                        strA = strA.replace(uo.b, "1");
                    }
                    new h5(po.a(view, strA)).executeOnExecutor(w3.c().g(), new Void[0]);
                }
            }
            this.W = null;
        }
        if (f0()) {
            return;
        }
        kh.a("BeiZisAd", "mDeepLinkUrl:" + this.b0 + ",appDownloadURL = " + this.G + ",mLandingPageUrl = " + this.a0);
        if (view != null) {
            try {
                context = view.getContext();
            } catch (Exception unused) {
                context = null;
            }
        } else {
            context = null;
        }
        try {
            if (!(context instanceof Activity) && view != null && view.getRootView() != null && (rootView = view.getRootView()) != null) {
                context = rootView.getContext();
            }
        } catch (Exception unused2) {
        }
        if (context == null) {
            return;
        }
        if (!TextUtils.isEmpty(this.b0)) {
            try {
                boolean z2 = pg.a(context, this.b0) || a8.a(context, this.E) || this.b0.startsWith("hwpps://landingpage") || this.b0.startsWith("intent") || this.b0.startsWith("hap://");
                if (z2 && (c0333b2 = this.B) != null) {
                    List listF = c0333b2.f();
                    this.B.h(null);
                    bm.a(listF);
                }
                this.x0 = true;
                d(context);
                if (!z2 && (c0333b = this.B) != null) {
                    List listG = c0333b.g();
                    this.B.i(null);
                    bm.a(listG);
                }
                x1.b.C0333b c0333b3 = this.B;
                if (c0333b3 != null) {
                    List listD = c0333b3.d();
                    this.B.f(null);
                    bm.a(listD);
                    return;
                }
                return;
            } catch (Exception unused3) {
                this.x0 = false;
                x1.b.C0333b c0333b4 = this.B;
                if (c0333b4 != null) {
                    List listC = c0333b4.c();
                    this.B.e(null);
                    bm.a(listC);
                }
                a(context);
                return;
            }
        }
        a(context);
    }

    public int f() {
        return this.w0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(Context context) {
        if (context == null) {
            return;
        }
        if (f(context)) {
            x1.b.C0333b c0333b = this.B;
            if (c0333b != null) {
                List listH = c0333b.h();
                this.B.k(null);
                bm.a(listH);
                return;
            }
            return;
        }
        if (TextUtils.isEmpty(this.a0) || !this.a0.startsWith("http")) {
            return;
        }
        try {
            if (this.k) {
                Intent intent = new Intent(context, (Class<?>) BeiZiLandingPageActivity.class);
                Bundle bundle = new Bundle();
                bundle.putBoolean("isRedirectionCanJump", this.Q);
                bundle.putBoolean("isDownload", k0());
                if (!TextUtils.isEmpty(this.b0)) {
                    boolean z = true;
                    if (this.T != 1) {
                        z = false;
                    }
                    bundle.putBoolean("webDeepLink", z);
                    bundle.putString("deeplinkUrl", this.b0);
                }
                if (!TextUtils.isEmpty(this.a0)) {
                    bundle.putString("landingPageUrl", this.a0);
                }
                x1.b.C0333b c0333b2 = this.B;
                if (c0333b2 != null) {
                    bundle.putSerializable("followTrackExt", c0333b2);
                }
                nh nhVar = this.B0;
                if (nhVar != null) {
                    bundle.putSerializable("lpOptimizeModule", nhVar);
                }
                intent.putExtra("data", bundle);
                intent.setFlags(268435456);
                context.startActivity(intent);
                return;
            }
            Intent intent2 = new Intent("android.intent.action.VIEW", Uri.parse(Uri.decode(this.a0)));
            intent2.addFlags(268435456);
            context.startActivity(intent2);
        } catch (Exception unused) {
        }
    }

    public String c() {
        return this.X;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(Context context) {
        Intent uri;
        if (context == null) {
            return;
        }
        Uri uri2 = Uri.parse(this.b0);
        if (uri2.getScheme() != null && uri2.getScheme().equals("bzopen") && !TextUtils.isEmpty(uri2.getHost()) && uri2.getPathSegments().size() > 0) {
            Intent intent = new Intent();
            intent.setAction("android.intent.action.MAIN");
            intent.setFlags(268435456);
            intent.addCategory("android.intent.category.LAUNCHER");
            String queryParameter = uri2.getQueryParameter("flags");
            if (!TextUtils.isEmpty(queryParameter)) {
                try {
                    if (!queryParameter.startsWith("0x") && !queryParameter.startsWith("0X")) {
                        intent.setFlags(Integer.parseInt(queryParameter));
                    } else {
                        intent.setFlags(Integer.parseInt(queryParameter.substring(2), 16));
                    }
                } catch (Exception unused) {
                }
            }
            intent.setComponent(new ComponentName(uri2.getHost(), uri2.getPathSegments().get(0)));
            String queryParameter2 = uri2.getQueryParameter("rect");
            if (!TextUtils.isEmpty(queryParameter2)) {
                try {
                    String[] strArrSplit = queryParameter2.split(u15.f19942b);
                    if (strArrSplit.length == 4) {
                        Rect rect = new Rect();
                        rect.set(Integer.parseInt(strArrSplit[0]), Integer.parseInt(strArrSplit[1]), Integer.parseInt(strArrSplit[2]), Integer.parseInt(strArrSplit[3]));
                        intent.setSourceBounds(rect);
                    }
                } catch (Exception unused2) {
                }
            }
            context.startActivity(intent);
            return;
        }
        if (this.b0.startsWith("hwpps://landingpage")) {
            Intent intent2 = new Intent();
            intent2.setData(uri2);
            intent2.addFlags(268435456);
            context.startActivity(intent2);
            return;
        }
        if (this.b0.startsWith("intent")) {
            try {
                uri = Intent.parseUri(this.b0, 1);
                try {
                    uri.addFlags(268435456);
                } catch (Exception unused3) {
                }
            } catch (Exception unused4) {
                uri = null;
            }
            context.startActivity(uri);
            return;
        }
        Intent intent3 = new Intent("android.intent.action.VIEW", uri2);
        intent3.addFlags(805339136);
        context.startActivity(intent3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Context context) {
        try {
            if (k0() && j0()) {
                int i = this.C;
                if (i == 2) {
                    if (a8.a(context, this.E)) {
                        a8.b(context, this.E);
                        x1.b.C0333b c0333b = this.B;
                        if (c0333b != null) {
                            List listI = c0333b.i();
                            this.B.l(null);
                            bm.a(listI);
                            return;
                        }
                        return;
                    }
                    a(context, 1);
                    return;
                }
                if (i == 5) {
                    if (pg.a(context, this.G)) {
                        if (!this.R && this.S != 0) {
                            a(context, 2);
                            return;
                        }
                        a(this.G, context);
                        x1.b.C0333b c0333b2 = this.B;
                        if (c0333b2 != null) {
                            List listI2 = c0333b2.i();
                            this.B.l(null);
                            bm.a(listI2);
                            return;
                        }
                        return;
                    }
                    e(context);
                    return;
                }
                return;
            }
            e(context);
        } catch (Exception unused) {
        }
    }

    public void d(View view, String str) {
        x1.d dVarA;
        x1.b bVarL;
        List listV;
        String strF;
        if (this.z || this.V == null || (dVarA = a(0)) == null || (bVarL = dVarA.l()) == null || (listV = bVarL.v()) == null) {
            return;
        }
        this.z = true;
        for (int i = 0; i < listV.size(); i++) {
            x1.h hVar = (x1.h) listV.get(i);
            if (hVar != null && !TextUtils.isEmpty(hVar.f()) && view != null) {
                if (!TextUtils.isEmpty(str)) {
                    strF = hVar.f().replace("__REQUESTUUID__", str);
                } else {
                    strF = hVar.f();
                }
                if (this.v) {
                    strF = strF.replace(uo.b, "1");
                }
                new h5(po.a(0, view, strF)).executeOnExecutor(w3.c().g(), new Void[0]);
            }
        }
    }

    public void e(View view, String str) {
        x1.d dVarA;
        x1.b bVarL;
        List listV;
        String strC;
        if (this.w || this.V == null || (dVarA = a(0)) == null || (bVarL = dVarA.l()) == null || (listV = bVarL.v()) == null) {
            return;
        }
        this.w = true;
        for (int i = 0; i < listV.size(); i++) {
            x1.h hVar = (x1.h) listV.get(i);
            if (hVar != null && !TextUtils.isEmpty(hVar.c()) && view != null) {
                if (!TextUtils.isEmpty(str)) {
                    strC = hVar.c().replace("__REQUESTUUID__", str);
                } else {
                    strC = hVar.c();
                }
                if (this.v) {
                    strC = strC.replace(uo.b, "1");
                }
                new h5(po.a(0, view, strC)).executeOnExecutor(w3.c().g(), new Void[0]);
            }
        }
    }

    private void a(Context context, int i) {
        try {
            File fileF = a8.f(context);
            String absolutePath = fileF != null ? fileF.getAbsolutePath() : "";
            ApkBean apkBean = new ApkBean(this.G, this.E + ".apk", this.E, absolutePath, this.D, this.F, context.getPackageName() + ".bz.fileprovider", this.B, this.H, this.I, this.J, this.K, this.L, this.M, this.N);
            apkBean.setFileMD5(this.O);
            Bundle bundle = new Bundle();
            bundle.putSerializable("apkBean", apkBean);
            bundle.putInt("type", i);
            bundle.putBoolean("isCanJump", this.Q);
            bundle.putBoolean("isDownload", k0());
            if (i == 2) {
                x1.b.C0333b c0333b = this.B;
                if (c0333b != null) {
                    bundle.putStringArrayList("openList", (ArrayList) c0333b.i());
                }
                bundle.putString("landingPageUrl", this.a0);
            }
            if (!TextUtils.isEmpty(this.b0)) {
                bundle.putString("deeplinkUrl", this.b0);
                bundle.putInt("webDeepLink", this.T);
            }
            Serializable serializable = this.B0;
            if (serializable != null) {
                bundle.putSerializable("lpOptimizeModule", serializable);
            }
            Intent intent = new Intent(context, (Class<?>) BeiZiDownloadDialogActivity.class);
            intent.putExtra("data", bundle);
            intent.setFlags(268435456);
            context.startActivity(intent);
        } catch (Exception unused) {
        }
    }

    public boolean b() {
        return this.d0;
    }

    private void b(String str) {
        JSONArray jSONArrayA;
        JSONArray jSONArrayA2;
        try {
            if (!TextUtils.isEmpty(str) && str.startsWith(bv9.b)) {
                JSONObject jSONObject = new JSONObject(str);
                this.e0 = ng.e(jSONObject, "Headline");
                this.f0 = ng.e(jSONObject, "Body");
                this.k0 = ng.e(jSONObject, "AppIcon");
                this.i0 = ng.e(jSONObject, "Image");
                this.g0 = ng.e(jSONObject, VideoPlayerActivity.t);
                this.j0 = ng.e(jSONObject, "lauchImageUrl");
                if (TextUtils.isEmpty(this.i0) && (jSONArrayA2 = ng.a(jSONObject, "Images")) != null && jSONArrayA2.length() > 0) {
                    this.i0 = (String) jSONArrayA2.get(0);
                }
                if (TextUtils.isEmpty(this.g0) && (jSONArrayA = ng.a(jSONObject, "Videos")) != null && jSONArrayA.length() > 0) {
                    this.g0 = (String) jSONArrayA.get(0);
                }
                if (jSONObject.has("apkFileMD5")) {
                    this.O = ng.e(jSONObject, "apkFileMD5");
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public List e() {
        return this.t0;
    }

    public void c(View view, String str) {
        x1.d dVarA;
        x1.b bVarL;
        List listV;
        String strE;
        if (this.y || this.V == null || (dVarA = a(0)) == null || (bVarL = dVarA.l()) == null || (listV = bVarL.v()) == null) {
            return;
        }
        this.y = true;
        for (int i = 0; i < listV.size(); i++) {
            x1.h hVar = (x1.h) listV.get(i);
            if (hVar != null && !TextUtils.isEmpty(hVar.e()) && view != null) {
                if (!TextUtils.isEmpty(str)) {
                    strE = hVar.e().replace("__REQUESTUUID__", str);
                } else {
                    strE = hVar.e();
                }
                if (this.v) {
                    strE = strE.replace(uo.b, "1");
                }
                new h5(po.a(0, view, strE)).executeOnExecutor(w3.c().g(), new Void[0]);
            }
        }
    }

    public void e(boolean z) {
        this.F0 = z;
    }

    public void b(Map map) {
        Object obj;
        if (map == null) {
            return;
        }
        try {
            if (map.containsKey("auctionExt") && (obj = map.get("auctionExt")) != null) {
                if (obj instanceof String) {
                    this.q = (String) obj;
                }
                if (TextUtils.isEmpty(this.q)) {
                    return;
                }
                String strB = h2.b(rg.a(), this.q);
                this.q = strB;
                this.q = Uri.encode(strB);
            }
        } catch (Exception unused) {
        }
    }

    private void a(String str, Context context) {
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
        intent.setFlags(268435456);
        try {
            context.startActivity(intent);
        } catch (ActivityNotFoundException unused) {
        }
    }

    public void a(View view, g5 g5Var, String str, String str2, boolean z, String str3, int i) {
        Context context;
        x1.b.C0333b c0333b;
        x1.b.C0333b c0333b2;
        String strA;
        kh.a("BeiZisAd", "handleClick========" + z);
        this.S = i;
        if (!z && this.V != null && this.W != null) {
            for (int i2 = 0; i2 < this.W.size(); i2++) {
                x1.h hVar = (x1.h) this.W.get(i2);
                if (hVar != null && !TextUtils.isEmpty(hVar.a())) {
                    if (!TextUtils.isEmpty(str3)) {
                        strA = pp.a(hVar.a(), g5Var, str, str2, "", i).replace("__REQUESTUUID__", str3);
                    } else {
                        strA = pp.a(hVar.a(), g5Var, str, str2, "", i);
                    }
                    if (this.v) {
                        strA = strA.replace(uo.b, "1");
                    }
                    new h5(po.a(view, strA)).executeOnExecutor(w3.c().g(), new Void[0]);
                }
            }
            this.W = null;
        }
        if (f0()) {
            return;
        }
        kh.a("BeiZisAd", "mDeepLinkUrl:" + this.b0 + ",appDownloadURL = " + this.G + ",mLandingPageUrl = " + this.a0);
        if (view != null) {
            try {
                context = view.getContext();
            } catch (Exception unused) {
                context = null;
            }
        } else {
            context = null;
        }
        try {
            kh.a("BeiZisAd", "context:" + context + "; flag =" + (context instanceof Activity));
            if (!(context instanceof Activity) && view != null && view.getRootView() != null) {
                View rootView = view.getRootView();
                if (rootView != null) {
                    context = rootView.getContext();
                }
                kh.a("BeiZisAd", " rootView context:" + context + "; flag =" + (context instanceof Activity));
            }
        } catch (Exception unused2) {
        }
        if (context == null) {
            return;
        }
        if (this.s == n7.RENDER_UNIFIED && this.F0) {
            try {
                if (TextUtils.isEmpty(this.G0)) {
                    this.G0 = po.a();
                }
                f8.a().a(this.B, this.G0);
                Intent intent = new Intent(context, (Class<?>) BeiZiLandingActivity.class);
                intent.setFlags(268435456);
                Bundle bundle = new Bundle();
                bundle.putString("requestUUID", this.G0);
                bundle.putBoolean("isRedirectionCanJump", this.Q);
                bundle.putBoolean("isDownload", k0());
                if (!TextUtils.isEmpty(this.b0)) {
                    bundle.putBoolean("webDeepLink", this.T == 1);
                    bundle.putString("deeplinkUrl", this.b0);
                }
                if (!TextUtils.isEmpty(this.a0)) {
                    bundle.putString("landingPageUrl", this.a0);
                }
                x1.b.C0333b c0333b3 = this.B;
                if (c0333b3 != null) {
                    bundle.putSerializable("followTrackExt", c0333b3);
                }
                nh nhVar = this.B0;
                if (nhVar != null) {
                    bundle.putSerializable("lpOptimizeModule", nhVar);
                }
                bundle.putString("apkName", this.D);
                bundle.putString("appDeveloper", this.I);
                bundle.putString("appVersion", this.H);
                bundle.putString("appPrivacyUrl", this.L);
                bundle.putString("appintro", this.N);
                bundle.putString("appPermissionsUrl", this.K);
                bundle.putString("appPermissionsDesc", this.J);
                bundle.putInt("interactType", this.C);
                bundle.putString("appDownloadURL", this.G);
                bundle.putString(ALPParamConstant.PACKAGENAME, this.E);
                bundle.putString("appDesc", this.F);
                bundle.putString("appIconURL", this.M);
                bundle.putBoolean("isCloseConfirmDialog", this.R);
                x1.b bVar = this.V;
                if (bVar != null && bVar.o() == 1) {
                    bundle.putInt("isMiniProgram", this.V.o());
                    bundle.putString("miniProgramId", this.V.r());
                    bundle.putString("miniProgramPath", this.V.s());
                    bundle.putString("miniProgramExt", this.V.q());
                    bundle.putString("wechat_canvas", this.V.w());
                }
                uk ukVar = this.J0;
                if (ukVar != null) {
                    bundle.putString(LoginConstants.TOKEN_INFO, ukVar.c());
                    bundle.putString("oppoReqId", this.J0.b());
                }
                intent.putExtra("data", bundle);
                context.startActivity(intent);
                return;
            } catch (Exception unused3) {
                return;
            }
        }
        if (!TextUtils.isEmpty(this.b0)) {
            try {
                boolean z2 = pg.a(context, this.b0) || a8.a(context, this.E) || this.b0.startsWith("hwpps://landingpage") || this.b0.startsWith("intent") || this.b0.startsWith("hap://");
                this.x0 = true;
                d(context);
                if (z2 && (c0333b2 = this.B) != null) {
                    List listF = c0333b2.f();
                    this.B.h(null);
                    bm.a(listF);
                }
                if (!z2 && (c0333b = this.B) != null) {
                    List listG = c0333b.g();
                    this.B.i(null);
                    bm.a(listG);
                }
                x1.b.C0333b c0333b4 = this.B;
                if (c0333b4 != null) {
                    List listD = c0333b4.d();
                    this.B.f(null);
                    bm.a(listD);
                    return;
                }
                return;
            } catch (Exception unused4) {
                this.x0 = false;
                x1.b.C0333b c0333b5 = this.B;
                if (c0333b5 != null) {
                    List listC = c0333b5.c();
                    this.B.e(null);
                    bm.a(listC);
                }
                a(context);
                return;
            }
        }
        a(context);
    }

    public void b(View view, String str) {
        x1.d dVarA;
        x1.b bVarL;
        List listV;
        String strD;
        if (this.x || this.V == null || (dVarA = a(0)) == null || (bVarL = dVarA.l()) == null || (listV = bVarL.v()) == null) {
            return;
        }
        this.x = true;
        for (int i = 0; i < listV.size(); i++) {
            x1.h hVar = (x1.h) listV.get(i);
            if (hVar != null && !TextUtils.isEmpty(hVar.d()) && view != null) {
                if (!TextUtils.isEmpty(str)) {
                    strD = hVar.d().replace("__REQUESTUUID__", str);
                } else {
                    strD = hVar.d();
                }
                if (this.v) {
                    strD = strD.replace(uo.b, "1");
                }
                new h5(po.a(0, view, strD)).executeOnExecutor(w3.c().g(), new Void[0]);
            }
        }
    }

    private boolean b(Context context) {
        try {
            uk ukVar = this.J0;
            if (ukVar == null) {
                return false;
            }
            String strC = ukVar.c();
            String strB = this.J0.b();
            int iA = this.J0.a();
            if (TextUtils.isEmpty(strC) || TextUtils.isEmpty(strB) || !a4.j().p()) {
                return false;
            }
            String strA = h3.a(strC);
            if (TextUtils.isEmpty(strA)) {
                return false;
            }
            new zh().a(this.b0, strA, strB, new d(iA, context));
            return true;
        } catch (Exception e2) {
            e2.printStackTrace();
            return false;
        }
    }

    public void b(int i) {
        this.L0 = i;
    }

    private void a(x1.a aVar) {
        List listA;
        x1.f fVar;
        if (aVar == null) {
            return;
        }
        try {
            if (aVar.c() == n7.RENDER_PIC && (listA = aVar.a()) != null && listA.size() != 0 && (fVar = (x1.f) listA.get(0)) != null) {
                this.l0 = fVar.a();
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private void a(String str) {
        try {
            if (!TextUtils.isEmpty(str) && str.startsWith(bv9.b)) {
                JSONObject jSONObject = new JSONObject(str);
                if (jSONObject.has("title")) {
                    this.e0 = ng.e(jSONObject, "title");
                }
                if (jSONObject.has("desc")) {
                    this.f0 = ng.e(jSONObject, "desc");
                }
                if (jSONObject.has("appIcon")) {
                    this.k0 = ng.e(jSONObject, "appIcon");
                }
                if (jSONObject.has("lauchImageUrl")) {
                    this.j0 = ng.e(jSONObject, "lauchImageUrl");
                }
                if (jSONObject.has(VideoPlayerActivity.t)) {
                    this.g0 = ng.e(jSONObject, VideoPlayerActivity.t);
                }
                if (jSONObject.has("videoTime")) {
                    this.h0 = ng.c(jSONObject, "videoTime");
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void a(View view, String str) {
        x1.d dVarA;
        x1.b bVarL;
        List listV;
        String strB;
        if (this.A || this.V == null || (dVarA = a(0)) == null || (bVarL = dVarA.l()) == null || (listV = bVarL.v()) == null) {
            return;
        }
        this.A = true;
        for (int i = 0; i < listV.size(); i++) {
            x1.h hVar = (x1.h) listV.get(i);
            if (hVar != null && !TextUtils.isEmpty(hVar.b()) && view != null) {
                if (!TextUtils.isEmpty(str)) {
                    strB = hVar.b().replace("__REQUESTUUID__", str);
                } else {
                    strB = hVar.b();
                }
                if (this.v) {
                    strB = strB.replace(uo.b, "1");
                }
                new h5(po.a(0, view, strB)).executeOnExecutor(w3.c().g(), new Void[0]);
            }
        }
    }

    public void a(boolean z) {
        try {
            this.x0 = z;
            c4 c4Var = this.s0;
            if (c4Var != null) {
                c4Var.a(z);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void a(View view, g5 g5Var, String str, String str2, String str3, int i) {
        String strA;
        try {
            this.S = i;
            if (this.V == null || this.W == null) {
                return;
            }
            for (int i2 = 0; i2 < this.W.size(); i2++) {
                x1.h hVar = (x1.h) this.W.get(i2);
                if (hVar != null && !TextUtils.isEmpty(hVar.a())) {
                    if (!TextUtils.isEmpty(str3)) {
                        strA = pp.a(hVar.a(), g5Var, str, str2, "", i).replace("__REQUESTUUID__", str3);
                    } else {
                        strA = pp.a(hVar.a(), g5Var, str, str2, "", i);
                    }
                    if (this.v) {
                        strA = strA.replace(uo.b, "1");
                    }
                    new h5(po.a(view, strA)).executeOnExecutor(w3.c().g(), new Void[0]);
                }
            }
            this.W = null;
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void a(x1.d dVar, View view, String str) {
        x1.b bVarL;
        String strG;
        if (dVar == null || (bVarL = dVar.l()) == null) {
            return;
        }
        dVar.b(true);
        List listV = bVarL.v();
        if (listV != null) {
            for (int i = 0; i < listV.size(); i++) {
                x1.h hVar = (x1.h) listV.get(i);
                if (hVar != null && !TextUtils.isEmpty(hVar.g()) && view != null) {
                    if (!TextUtils.isEmpty(str)) {
                        strG = hVar.g().replace("__REQUESTUUID__", str);
                    } else {
                        strG = hVar.g();
                    }
                    if (!TextUtils.isEmpty(this.q)) {
                        strG = strG.replace(uo.f27840a, this.q);
                    }
                    if (this.v) {
                        strG = strG.replace(uo.b, "1");
                    }
                    new h5(po.a(0, view, strG)).executeOnExecutor(w3.c().g(), new Void[0]);
                }
                hVar.j(null);
            }
        }
    }

    public void a(x1.d dVar, View view, g5 g5Var, String str, String str2, boolean z, String str3, int i) {
        String strA;
        a(dVar);
        x1.b bVarL = dVar.l();
        if (bVarL == null) {
            return;
        }
        dVar.a(true);
        List listV = bVarL.v();
        if (listV != null) {
            for (int i2 = 0; i2 < listV.size(); i2++) {
                x1.h hVar = (x1.h) listV.get(i2);
                if (hVar != null && !TextUtils.isEmpty(hVar.a())) {
                    if (!TextUtils.isEmpty(str3)) {
                        strA = pp.a(hVar.a(), g5Var, str, str2, "", i).replace("__REQUESTUUID__", str3);
                    } else {
                        strA = pp.a(hVar.a(), g5Var, str, str2, "", i);
                    }
                    if (this.v) {
                        strA = strA.replace(uo.b, "1");
                    }
                    new h5(po.a(view, strA)).executeOnExecutor(w3.c().g(), new Void[0]);
                }
                hVar.a(null);
            }
        }
        a(view, g5Var, str, str2, z, str3, i);
    }

    private void a(x1.d dVar) {
        if (dVar == null) {
            return;
        }
        x1.b bVarL = dVar.l();
        if (bVarL != null) {
            a(bVarL);
            this.a0 = bVarL.p();
            this.c0 = bVarL.u();
            if (this.Y == th.REWARDEDVIDEO) {
                this.b0 = bVarL.k();
            } else {
                this.b0 = Uri.decode(bVarL.k());
            }
        }
        this.J0 = null;
        this.J0 = dVar.o();
    }

    public x1.d a(int i) {
        List list = this.t0;
        if (list != null && !list.isEmpty()) {
            for (x1.d dVar : this.t0) {
                if (dVar.x() == i) {
                    return dVar;
                }
            }
        }
        return null;
    }

    public void a(String str, String str2, String str3) {
        try {
            im imVar = this.n0;
            if (imVar == null) {
                return;
            }
            String strL = imVar.l();
            if (TextUtils.isEmpty(strL)) {
                return;
            }
            this.n0.a((String) null);
            if (!TextUtils.isEmpty(str)) {
                strL = strL.replace("__REQUESTUUID__", str);
            }
            if (strL.contains(".UTC_TS.")) {
                strL = strL.replaceAll(".UTC_TS.", String.valueOf(System.currentTimeMillis()));
            }
            if (strL.contains("__USER_ID__") && !TextUtils.isEmpty(str2)) {
                strL = strL.replace("__USER_ID__", str2);
            }
            if (strL.contains("__USER_CUSTOM_DATA__") && !TextUtils.isEmpty(str3)) {
                strL = strL.replace("__USER_CUSTOM_DATA__", Uri.encode(str3));
            }
            new h5(strL).executeOnExecutor(w3.c().g(), new Void[0]);
        } catch (Exception unused) {
        }
    }

    public void a() {
        f8.a().a(this.G0);
    }
}
