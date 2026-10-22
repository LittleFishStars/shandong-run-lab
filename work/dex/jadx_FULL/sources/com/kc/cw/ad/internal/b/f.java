package com.kc.cw.ad.internal.b;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.content.MutableContextWrapper;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Pair;
import android.view.View;
import android.webkit.WebView;
import com.alibaba.alibclinkpartner.linkpartner.constants.ALPParamConstant;
import com.kc.cw.ad.NativeAdResponse;
import com.kc.cw.ad.a.h;
import com.kc.cw.ad.a.i;
import com.kc.cw.ad.internal.j;
import com.kc.cw.ad.internal.k;
import com.kc.cw.ad.internal.l;
import com.kc.cw.ad.internal.o;
import com.kc.cw.ad.internal.p;
import com.kc.cw.ad.internal.q;
import com.kc.cw.ad.internal.t;
import com.kc.cw.ad.internal.u;
import com.kc.cw.ad.internal.utilities.ViewUtil;
import com.kc.cw.ad.model.AdLogoInfo;
import com.kc.cw.ad.model.ComplianceInfo;
import com.kc.cw.ad.model.ShakeValue;
import com.kc.cw.ad.utils.OctUtil;
import com.kc.cw.ad.utils.ThreadUtils;
import com.kc.openset.R;
import com.kc.openset.sdk.dsp.util.QdActivityType;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import com.tencent.mm.opensdk.modelbiz.WXLaunchMiniProgram;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;
import java.io.File;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class f {
    private int A;
    private int B;
    private boolean C;
    private int D;
    private AdLogoInfo E;
    private AdLogoInfo F;
    private boolean G;
    private boolean H;
    private boolean I;
    private boolean J;
    private int K;
    private int L;
    private String M;
    private String N;
    private int O;
    private int P;
    private int Q;
    private int R;
    private int S;
    private int T;
    private boolean U;
    private boolean V;
    private boolean W;
    private boolean X;
    private Boolean Y;
    private boolean Z;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f38916a;
    private ComplianceInfo aA;
    private i aB;
    private com.kc.cw.ad.a.c.b aC;
    private com.kc.cw.ad.a.c.o aD;
    private com.kc.cw.ad.a.c.w aE;
    private List<com.kc.cw.ad.a.c.i> aF;
    private String aG;
    private String aH;
    private long aI;
    private p aJ;
    private com.kc.cw.ad.internal.d aK;
    private List<Pair<j, String>> aL;
    private String aM;
    private String aN;
    private String aO;
    private String aP;
    private String aQ;
    private String aR;
    private boolean aS;
    private boolean aT;
    private boolean aU;
    private boolean aV;
    private LinkedList<String> aW;
    private HashMap<String, Object> aX;
    private boolean aY;
    private boolean aZ;
    private boolean aa;
    private String ab;
    private String ac;
    private String ad;
    private String ae;
    private String af;
    private String ag;
    private String ah;
    private int ai;
    private Map<String, Object> aj;
    private com.kc.cw.ad.b.a ak;
    private e al;
    private com.kc.cw.ad.a.c.k am;
    private com.kc.cw.ad.a.c.l an;
    private com.kc.cw.ad.a.c.y ao;
    private h ap;
    private ShakeValue aq;
    private WebView ar;
    private com.kc.cw.ad.a.e as;
    private k.a at;
    private com.kc.cw.ad.a.c.b.a au;
    private int av;
    private String aw;
    private String ax;
    private String ay;
    private String az;
    public String b;
    private boolean ba;
    private long bb;
    private long bc;
    private boolean bd;
    private int be;
    private boolean bf;
    private boolean bg;
    private com.kc.cw.ad.a.g.a c;
    private int d;
    private int e;
    private int f;
    private int g;
    private int h;
    private int i;
    private int j;
    private boolean k;
    private boolean l;
    private boolean m;
    private boolean n;
    private boolean o;
    private boolean p;
    private boolean q;
    private boolean r;
    private boolean s;
    private boolean t;
    private boolean u;
    private boolean v;
    private boolean w;
    private boolean x;
    private boolean y;
    private boolean z;

    /* JADX INFO: renamed from: com.kc.cw.ad.internal.b.f$6, reason: invalid class name */
    @Keep
    public class AnonymousClass6 implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Context f38923a;
        final int b;
        final f c;

        public AnonymousClass6(f fVar, Context context, int i) {
            this.c = fVar;
            this.f38923a = context;
            this.b = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            OctUtil.a().a(this.f38923a, this.c.aP, this.c.aQ, this.c.n, new OctUtil.C(this) { // from class: com.kc.cw.ad.internal.b.f.6.1

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                final AnonymousClass6 f38924a;

                {
                    this.f38924a = this;
                }

                @Override // com.kc.cw.ad.utils.OctUtil.C
                public String e(String str) {
                    AnonymousClass6 anonymousClass6 = this.f38924a;
                    anonymousClass6.c.a(anonymousClass6.f38923a, str, anonymousClass6.b);
                    return null;
                }
            });
        }
    }

    public f(com.kc.cw.ad.a.c.t tVar, com.kc.cw.ad.internal.d dVar, p pVar, String str, String str2) {
        this.d = 0;
        this.e = 1;
        this.f = 0;
        this.g = 0;
        this.h = 0;
        this.i = 0;
        this.j = 0;
        this.k = false;
        this.l = false;
        this.m = false;
        this.n = false;
        this.o = false;
        this.p = false;
        this.q = false;
        this.r = true;
        this.s = false;
        this.t = true;
        this.u = false;
        this.v = false;
        this.w = false;
        this.x = false;
        this.y = false;
        this.z = false;
        this.A = 0;
        this.B = 0;
        this.C = false;
        this.D = 0;
        this.E = new AdLogoInfo();
        this.F = new AdLogoInfo();
        this.G = false;
        this.R = 0;
        this.T = 1;
        this.U = false;
        this.V = false;
        this.W = true;
        this.X = true;
        this.aL = new LinkedList();
        this.aW = new LinkedList<>();
        this.aX = new HashMap<>();
        this.aY = false;
        this.aZ = false;
        this.be = 0;
        if (tVar == null) {
            com.kc.cw.ad.internal.c.f.a();
            return;
        }
        com.kc.cw.ad.internal.c.f.a(tVar.toString());
        this.aK = dVar;
        this.aJ = pVar;
        this.ad = str;
        this.aO = str2;
        a(tVar);
    }

    public f(boolean z) {
        this.d = 0;
        this.e = 1;
        this.f = 0;
        this.g = 0;
        this.h = 0;
        this.i = 0;
        this.j = 0;
        this.k = false;
        this.l = false;
        this.m = false;
        this.n = false;
        this.o = false;
        this.p = false;
        this.q = false;
        this.r = true;
        this.s = false;
        this.t = true;
        this.u = false;
        this.v = false;
        this.w = false;
        this.x = false;
        this.y = false;
        this.z = false;
        this.A = 0;
        this.B = 0;
        this.C = false;
        this.D = 0;
        this.E = new AdLogoInfo();
        this.F = new AdLogoInfo();
        this.G = false;
        this.R = 0;
        this.T = 1;
        this.U = false;
        this.V = false;
        this.W = true;
        this.X = true;
        this.aL = new LinkedList();
        this.aW = new LinkedList<>();
        this.aX = new HashMap<>();
        this.aY = false;
        this.be = 0;
        this.aZ = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, String str, int i2) {
        List<com.kc.cw.ad.a.c.i> listT;
        StringBuilder sb;
        Context contextL;
        com.kc.cw.ad.a.c.k kVar;
        try {
            com.kc.cw.ad.a.c.b bVar = this.aC;
            if (bVar == null || i2 != 1 || (listT = bVar.t()) == null) {
                return;
            }
            for (int i3 = 0; i3 < listT.size(); i3++) {
                com.kc.cw.ad.a.c.i iVar = listT.get(i3);
                if (iVar != null && !TextUtils.isEmpty(iVar.c())) {
                    String strC = iVar.c();
                    if (strC.contains("track=oct")) {
                        if (this.U) {
                            sb = new StringBuilder();
                            sb.append(strC);
                            sb.append("&opt=10");
                        } else if (this.V) {
                            sb = new StringBuilder();
                            sb.append(strC);
                            sb.append("&opt=1");
                        } else if (!this.W) {
                            sb = new StringBuilder();
                            sb.append(strC);
                            sb.append("&opt=4");
                        } else if (this.X) {
                            Boolean bool = Boolean.TRUE;
                            Boolean bool2 = this.Y;
                            if (bool != bool2) {
                                if (Boolean.FALSE == bool2) {
                                    sb = new StringBuilder();
                                    sb.append(strC);
                                    sb.append("&opt=8");
                                } else if (this.P != 0) {
                                    sb = new StringBuilder();
                                    sb.append(strC);
                                    sb.append("&opt=");
                                    sb.append(this.P);
                                } else if (this.Z) {
                                    sb = new StringBuilder();
                                    sb.append(strC);
                                    sb.append("&opt=12");
                                }
                            }
                            String str2 = strC + "&result=" + i;
                            if (i == 0 && (contextL = q.a().l()) != null && (kVar = this.am) != null && kVar.a() == 1) {
                                new com.kc.cw.ad.d.a().a(contextL, this.am.c(), this.am.d(), this.am.b());
                            }
                            a(str2, str);
                        } else {
                            sb = new StringBuilder();
                            sb.append(strC);
                            sb.append("&opt=11");
                        }
                        strC = sb.toString();
                        String str3 = strC + "&result=" + i;
                        if (i == 0) {
                            new com.kc.cw.ad.d.a().a(contextL, this.am.c(), this.am.d(), this.am.b());
                        }
                        a(str3, str);
                    } else if (i == 0) {
                        new com.kc.cw.ad.internal.i(strC).b();
                    }
                }
            }
        } catch (Exception e) {
            com.kc.cw.ad.d.b.f.a("OctopusAd", "An Exception Caught", e);
        }
    }

    private void a(Context context, int i) {
        try {
            if (TextUtils.isEmpty(this.aN)) {
                return;
            }
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(this.aN));
            intent.setFlags(268500993);
            context.startActivity(intent);
        } catch (Exception e) {
            b(context);
            a(-9, e.getMessage(), i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Context context, String str, int i) {
        int i2;
        if (context != null) {
            try {
                if (TextUtils.isEmpty(str)) {
                    return;
                }
                String strSubstring = "";
                if (str.equals("1")) {
                    i2 = 1;
                } else if (str.equals("-1")) {
                    i2 = -1;
                } else if (str.startsWith("-2,")) {
                    strSubstring = str.substring(3);
                    i2 = -2;
                } else if (str.equals("-3")) {
                    i2 = -3;
                } else if (str.equals("-4")) {
                    if (this.aU) {
                        b(context);
                    }
                    i2 = -4;
                } else {
                    strSubstring = str;
                    i2 = -5;
                }
                if (i2 == -1 || i2 == -2 || i2 == -3) {
                    a(context, i);
                }
                a(i2, strSubstring, i);
            } catch (Exception e) {
                com.kc.cw.ad.d.b.f.a("OctopusAd", "An Exception Caught", e);
            }
        }
    }

    private void a(com.kc.cw.ad.a.c.b bVar) {
        this.aC = bVar;
        this.aF = bVar.t();
        this.au = bVar.p();
        this.as = bVar.r();
        this.av = bVar.d();
        this.aw = bVar.e();
        this.ax = bVar.f();
        this.ay = bVar.g();
        this.az = bVar.h();
        this.aA = bVar.i();
        this.aB = bVar.q();
        this.aM = bVar.a();
        this.aN = bVar.b();
        this.aQ = bVar.c();
        this.aS = bVar.m();
        this.aT = bVar.l();
        this.aU = bVar.n();
        this.aV = bVar.o();
        this.aR = bVar.j();
        if (TextUtils.isEmpty(this.ax)) {
            this.ax = "OctopusAd";
        }
        if (TextUtils.isEmpty(this.aw)) {
            this.aw = "OctopusAd";
        }
        if (TextUtils.isEmpty(this.ay)) {
            this.ay = "Ad Download";
        }
        if (!TextUtils.isEmpty(this.ae)) {
            if (this.ae.startsWith("https://") || this.ae.startsWith("http://")) {
                new t(this.ae).a(new com.kc.cw.ad.internal.c.d.a(this) { // from class: com.kc.cw.ad.internal.b.f.1

                    /* JADX INFO: renamed from: a, reason: collision with root package name */
                    final f f38917a;

                    {
                        this.f38917a = this;
                    }

                    @Override // com.kc.cw.ad.internal.c.d.a
                    public void a(int i, boolean z, String str) {
                        if (!z || TextUtils.isEmpty(str)) {
                            return;
                        }
                        try {
                            this.f38917a.c(new JSONObject(str).optString("data"));
                        } catch (Exception e) {
                            com.kc.cw.ad.d.b.f.a("OctopusAd", "An Exception Caught", e);
                        }
                    }
                }).b();
            } else {
                c(this.ae);
            }
        }
        if (this.aV) {
            ThreadUtils.runOnUIThread(new Runnable(this) { // from class: com.kc.cw.ad.internal.b.f.2

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                final f f38918a;

                {
                    this.f38918a = this;
                }

                @Override // java.lang.Runnable
                public void run() {
                    try {
                        if (TextUtils.isEmpty(this.f38918a.aM)) {
                            return;
                        }
                        Context contextL = q.a().l();
                        this.f38918a.ar = new WebView(new MutableContextWrapper(contextL));
                        com.kc.cw.ad.internal.c.t.a(this.f38918a.ar);
                        this.f38918a.ar.loadUrl(this.f38918a.aM);
                    } catch (Exception e) {
                        com.kc.cw.ad.d.b.f.a("OctopusAd", "An Exception Caught", e);
                    }
                }
            });
        }
    }

    private void a(com.kc.cw.ad.a.c.t tVar) {
        this.ab = tVar.h();
        this.ac = tVar.i();
        this.ag = tVar.k();
        this.T = tVar.e();
        this.X = tVar.l();
        this.Y = tVar.m();
        this.Z = tVar.n();
        this.aa = tVar.o();
        this.am = tVar.p();
        this.an = tVar.q();
        this.ao = tVar.r();
        this.af = tVar.j();
        this.ap = tVar.s();
        this.aj = tVar.u();
        this.aq = tVar.t();
        if (b(tVar)) {
            p pVar = this.aJ;
            if (pVar == p.PREFETCH) {
                if (d(tVar)) {
                    return;
                }
            } else if (pVar == p.NATIVE || pVar == p.BANNER || pVar == p.DRAW) {
                if (e(tVar)) {
                    return;
                }
            } else if (c(tVar)) {
                return;
            }
            f(tVar);
        }
    }

    private void a(com.kc.cw.ad.a.d dVar) {
        StringBuilder sb;
        String str;
        if (this.aC == null || this.aF == null) {
            return;
        }
        for (int i = 0; i < this.aF.size(); i++) {
            com.kc.cw.ad.a.c.i iVar = this.aF.get(i);
            if (iVar != null && !TextUtils.isEmpty(iVar.b())) {
                String strB = iVar.b();
                if (strB.contains("?rv=1")) {
                    ViewUtil.openLocalBrowser(strB, this.j);
                } else {
                    if (strB.contains("track=oct")) {
                        if (this.U) {
                            sb = new StringBuilder();
                            sb.append(strB);
                            str = "&opt=10";
                        } else if (this.V) {
                            sb = new StringBuilder();
                            sb.append(strB);
                            str = "&opt=1";
                        } else if (!this.W) {
                            sb = new StringBuilder();
                            sb.append(strB);
                            str = "&opt=4";
                        } else if (this.X) {
                            Boolean bool = Boolean.TRUE;
                            Boolean bool2 = this.Y;
                            if (bool != bool2) {
                                if (Boolean.FALSE == bool2) {
                                    sb = new StringBuilder();
                                    sb.append(strB);
                                    str = "&opt=8";
                                } else if (this.P != 0) {
                                    sb = new StringBuilder();
                                    sb.append(strB);
                                    sb.append("&opt=");
                                    sb.append(this.P);
                                    strB = sb.toString();
                                } else if (this.Z) {
                                    sb = new StringBuilder();
                                    sb.append(strB);
                                    str = "&opt=12";
                                }
                            }
                        } else {
                            sb = new StringBuilder();
                            sb.append(strB);
                            str = "&opt=11";
                        }
                        sb.append(str);
                        strB = sb.toString();
                    }
                    String strA = com.kc.cw.ad.internal.c.q.a(strB, dVar, this.as);
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    com.kc.cw.ad.internal.d dVar2 = this.aK;
                    if (dVar2 != null) {
                        jCurrentTimeMillis = dVar2.i();
                    }
                    new u("clk", this.M, this.ad, jCurrentTimeMillis, strA, this.aS).a();
                }
            }
        }
        this.aF = null;
    }

    private void a(String str, String str2) {
        new Thread(new Runnable(this, str2, str) { // from class: com.kc.cw.ad.internal.b.f.4

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final String f38920a;
            final String b;
            final f c;

            {
                this.c = this;
                this.f38920a = str2;
                this.b = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                byte[] bytes;
                try {
                    if (TextUtils.isEmpty(this.f38920a)) {
                        bytes = new byte[0];
                    } else {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("message", this.f38920a);
                        bytes = jSONObject.toString().getBytes();
                    }
                    com.kc.cw.ad.d.b.d.a(this.b, bytes);
                } catch (Exception e) {
                    com.kc.cw.ad.d.b.f.a("OctopusAd", "An Exception Caught", e);
                }
            }
        }).start();
    }

    private boolean a(Context context) {
        if (this.aB == null || !com.kc.cw.ad.d.b.i.b("com.tencent.mm.opensdk.openapi.IWXAPI")) {
            return false;
        }
        IWXAPI iwxapiCreateWXAPI = WXAPIFactory.createWXAPI(context, this.aB.b());
        if (!iwxapiCreateWXAPI.isWXAppInstalled()) {
            return false;
        }
        WXLaunchMiniProgram.Req req = new WXLaunchMiniProgram.Req();
        req.userName = this.aB.c();
        req.path = this.aB.a();
        req.miniprogramType = 0;
        return iwxapiCreateWXAPI.sendReq(req);
    }

    private void ao() {
        if (this.aK != null) {
            o.a(new l("COPY", e(), this.ad, System.currentTimeMillis() - this.aK.i(), this.ae));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ap() {
        if (this.at != null) {
            k.a().b(this.at);
        }
    }

    private void aq() {
        if (!q.a().f() || TextUtils.isEmpty(this.ag)) {
            return;
        }
        q.a().a(this.Q);
        com.kc.cw.ad.a.a aVar = new com.kc.cw.ad.a.a();
        aVar.g(this.M);
        aVar.a(this.ad);
        aVar.f(this.ag);
        q.a().l.put("dpForbid", aVar);
    }

    private void b(Context context) {
        WebView webView;
        if (TextUtils.isEmpty(this.aM)) {
            return;
        }
        if (!this.aT || !this.G) {
            ViewUtil.openSystemBrowser(context, this.aM);
            return;
        }
        if (this.aM.startsWith("http")) {
            aq();
            if (!this.aV || (webView = this.ar) == null) {
                ViewUtil.openLocalBrowser(this.aM, this.j);
            } else {
                ViewUtil.openLocalBrowser(webView, this.j);
            }
        }
    }

    private boolean b(com.kc.cw.ad.a.c.t tVar) {
        return tVar.b() == 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            ClipboardManager clipboardManager = (ClipboardManager) q.a().l().getSystemService("clipboard");
            if (clipboardManager != null) {
                clipboardManager.setPrimaryClip(ClipData.newPlainText("wordText", str));
                ao();
            }
        } catch (Exception e) {
            com.kc.cw.ad.d.b.f.a("OctopusAd", "An Exception Caught", e);
        }
    }

    private boolean c(com.kc.cw.ad.a.c.t tVar) {
        List<Pair<j, String>> list;
        j jVar;
        AdLogoInfo adLogoInfo;
        int i;
        AdLogoInfo adLogoInfo2;
        int i2;
        if (tVar.a() > 0) {
            com.kc.cw.ad.a.c.v vVar = tVar.v().get(0);
            this.c = vVar.c();
            this.d = vVar.d();
            this.ae = vVar.e();
            this.e = vVar.f() == com.kc.cw.ad.a.g.h.PORTRAIT ? 1 : 2;
            this.i = Integer.parseInt(vVar.h());
            this.h = Integer.parseInt(vVar.i());
            if (vVar.j() != null && af() == com.kc.cw.ad.a.g.a.ADP_INTERSTITIAL) {
                com.kc.cw.ad.a.c.f fVarJ = vVar.j();
                this.f = Integer.parseInt(fVarJ.a());
                this.g = Integer.parseInt(fVarJ.b());
            } else if (!com.kc.cw.ad.internal.c.p.a(vVar.b()) && af() == com.kc.cw.ad.a.g.a.ADP_REWARD) {
                a("REWARD_ITEM", (Object) vVar.b());
            }
            this.M = vVar.a();
            this.k = vVar.x();
            this.l = vVar.y();
            this.m = vVar.z();
            this.Q = vVar.A();
            this.S = vVar.B();
            this.n = vVar.C();
            this.o = vVar.D();
            this.p = vVar.E();
            this.ah = vVar.J();
            this.ai = vVar.K();
            this.q = vVar.F();
            this.r = vVar.v();
            this.s = vVar.H();
            this.t = vVar.w();
            this.u = vVar.m();
            this.v = vVar.n();
            this.w = vVar.o();
            this.x = vVar.p();
            this.y = vVar.q();
            this.z = vVar.r();
            this.A = vVar.t();
            this.B = vVar.s();
            this.C = vVar.G();
            this.aD = vVar.k();
            this.aE = vVar.l();
            this.O = vVar.L();
            this.L = vVar.g();
            this.j = vVar.u();
            List<com.kc.cw.ad.a.c.d> listM = vVar.M();
            if (listM != null && !listM.isEmpty()) {
                this.K = listM.get(0).j();
                this.N = listM.get(0).k();
                this.aI = listM.get(0).c();
            }
            if (this.k && this.i == 0 && this.h == 0) {
                this.i = 720;
                this.h = 1280;
            }
            if (vVar.N() > 0) {
                int i3 = 0;
                for (com.kc.cw.ad.a.c.d dVar : vVar.M()) {
                    if (i3 == 0) {
                        this.aH = dVar.b();
                        com.kc.cw.ad.d.b.f.a("OctopusAd", "mAdid = " + this.aH);
                    }
                    if (dVar.i() <= 0 || dVar.h().get(0) == null) {
                        this.aG = dVar.a();
                        com.kc.cw.ad.a.c.C0966c c0966cF = dVar.f();
                        if (c0966cF != null) {
                            if (TextUtils.isEmpty(c0966cF.a())) {
                                this.E.setAdurl(c0966cF.b());
                                adLogoInfo = this.E;
                                i = AdLogoInfo.TYPE_TEXT;
                            } else {
                                this.E.setAdurl(c0966cF.a());
                                adLogoInfo = this.E;
                                i = AdLogoInfo.TYPE_PIC;
                            }
                            adLogoInfo.setType(i);
                            if (TextUtils.isEmpty(c0966cF.c())) {
                                this.F.setAdurl(c0966cF.d());
                                adLogoInfo2 = this.F;
                                i2 = AdLogoInfo.TYPE_TEXT;
                            } else {
                                this.F.setAdurl(c0966cF.c());
                                adLogoInfo2 = this.F;
                                i2 = AdLogoInfo.TYPE_PIC;
                            }
                            adLogoInfo2.setType(i2);
                        }
                        if (dVar.e() > 0) {
                            for (com.kc.cw.ad.a.c.a aVar : dVar.g()) {
                                if (this.r) {
                                    for (int i4 = 0; i4 < aVar.d(); i4++) {
                                        if (!com.kc.cw.ad.internal.c.p.a(aVar.c().get(i4).a())) {
                                            this.aW.add(aVar.c().get(i4).a());
                                        }
                                    }
                                }
                                if (aVar.d() > 0) {
                                    String strA = aVar.c().get(0).a();
                                    if (aVar.a() == com.kc.cw.ad.a.g.f.RENDER_VIDEO || aVar.a() == com.kc.cw.ad.a.g.f.RENDER_VAST_VIDEO) {
                                        list = this.aL;
                                        jVar = j.VIDEO;
                                    } else {
                                        list = this.aL;
                                        jVar = j.IMAGE;
                                    }
                                    list.add(Pair.create(jVar, strA));
                                }
                            }
                        }
                        if (dVar.d() != null) {
                            com.kc.cw.ad.a.c.b bVarD = dVar.d();
                            a(bVarD);
                            com.kc.cw.ad.a.c.i iVarK = bVarD.k();
                            if (iVarK != null && !TextUtils.isEmpty(iVarK.a())) {
                                this.f38916a = iVarK.a();
                            }
                            if (iVarK != null && !TextUtils.isEmpty(iVarK.b())) {
                                this.b = iVarK.b();
                            }
                        }
                    }
                    i3++;
                    if (!this.aL.isEmpty()) {
                        break;
                    }
                }
            }
        } else {
            com.kc.cw.ad.internal.c.f.e(com.kc.cw.ad.internal.c.f.e, com.kc.cw.ad.internal.c.f.a(R.string.blank_ad));
        }
        if (this.aL.isEmpty()) {
            return false;
        }
        this.aY = true;
        return true;
    }

    private boolean d(com.kc.cw.ad.a.c.t tVar) {
        if (tVar.a() > 0) {
            for (com.kc.cw.ad.a.c.v vVar : tVar.v()) {
                this.r = vVar.v();
                if (vVar.N() > 0) {
                    for (com.kc.cw.ad.a.c.d dVar : vVar.M()) {
                        if (dVar.i() <= 0 || dVar.h().get(0) == null) {
                            if (dVar.e() > 0) {
                                for (com.kc.cw.ad.a.c.a aVar : dVar.g()) {
                                    if (this.r) {
                                        for (int i = 0; i < aVar.d(); i++) {
                                            if (!com.kc.cw.ad.internal.c.p.a(aVar.c().get(i).a())) {
                                                this.aW.add(aVar.c().get(i).a());
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        if (this.aW.isEmpty()) {
            return false;
        }
        this.aY = true;
        return true;
    }

    private boolean e(com.kc.cw.ad.a.c.t tVar) {
        AdLogoInfo adLogoInfo;
        int i;
        AdLogoInfo adLogoInfo2;
        int i2;
        if (tVar.a() > 0) {
            com.kc.cw.ad.a.c.v vVar = tVar.v().get(0);
            this.c = vVar.c();
            this.d = vVar.d();
            this.ae = vVar.e();
            this.e = vVar.f() == com.kc.cw.ad.a.g.h.PORTRAIT ? 1 : 2;
            this.i = Integer.parseInt(vVar.h());
            this.h = Integer.parseInt(vVar.i());
            this.L = vVar.g();
            List<com.kc.cw.ad.a.c.d> listM = vVar.M();
            if (listM != null && !listM.isEmpty()) {
                this.K = listM.get(0).j();
                this.N = listM.get(0).k();
                this.aI = listM.get(0).c();
            }
            this.M = vVar.a();
            this.k = vVar.x();
            this.l = vVar.y();
            this.m = vVar.z();
            this.Q = vVar.A();
            this.S = vVar.B();
            this.n = vVar.C();
            this.o = vVar.D();
            this.p = vVar.E();
            this.ah = vVar.J();
            this.ai = vVar.K();
            this.q = vVar.F();
            this.r = vVar.v();
            this.s = vVar.H();
            this.t = vVar.w();
            this.u = vVar.m();
            this.v = vVar.n();
            this.w = vVar.o();
            this.x = vVar.p();
            this.y = vVar.q();
            this.z = vVar.r();
            this.A = vVar.t();
            this.B = vVar.s();
            this.C = vVar.G();
            this.aD = vVar.k();
            this.aE = vVar.l();
            this.O = vVar.L();
            this.j = vVar.u();
            if (this.k && this.i == 0 && this.h == 0) {
                this.i = 720;
                this.h = 1280;
            }
            if (vVar.N() > 0) {
                for (com.kc.cw.ad.a.c.d dVar : vVar.M()) {
                    if (dVar.i() <= 0 || dVar.h().get(0) == null) {
                        this.aG = dVar.a();
                        if (dVar.e() >= 0) {
                            for (com.kc.cw.ad.a.c.a aVar : dVar.g()) {
                                if (this.r) {
                                    for (int i3 = 0; i3 < aVar.d(); i3++) {
                                        if (!com.kc.cw.ad.internal.c.p.a(aVar.c().get(i3).a())) {
                                            this.aW.add(aVar.c().get(i3).a());
                                        }
                                    }
                                }
                                if (aVar.a() == com.kc.cw.ad.a.g.f.RENDER_JSON || aVar.a() == com.kc.cw.ad.a.g.f.RENDER_VIDEO) {
                                    if (aVar.d() > 0) {
                                        try {
                                            com.kc.cw.ad.a.c.C0966c c0966cF = dVar.f();
                                            if (c0966cF != null) {
                                                if (TextUtils.isEmpty(c0966cF.a())) {
                                                    this.E.setAdurl(c0966cF.b());
                                                    adLogoInfo = this.E;
                                                    i = AdLogoInfo.TYPE_TEXT;
                                                } else {
                                                    this.E.setAdurl(c0966cF.a());
                                                    adLogoInfo = this.E;
                                                    i = AdLogoInfo.TYPE_PIC;
                                                }
                                                adLogoInfo.setType(i);
                                                if (TextUtils.isEmpty(c0966cF.c())) {
                                                    this.F.setAdurl(c0966cF.d());
                                                    adLogoInfo2 = this.F;
                                                    i2 = AdLogoInfo.TYPE_TEXT;
                                                } else {
                                                    this.F.setAdurl(c0966cF.c());
                                                    adLogoInfo2 = this.F;
                                                    i2 = AdLogoInfo.TYPE_PIC;
                                                }
                                                adLogoInfo2.setType(i2);
                                            }
                                            e eVarA = e.a(new JSONObject(aVar.b()));
                                            this.al = eVarA;
                                            eVarA.a(this);
                                            this.al.c(O());
                                            this.al.a(r());
                                            this.al.b(an());
                                            this.al.a(am());
                                            this.al.b(vVar.I());
                                            if (aVar.a() == com.kc.cw.ad.a.g.f.RENDER_VIDEO) {
                                                this.al.a(true);
                                            }
                                            if (dVar.d() != null) {
                                                a(dVar.d());
                                                com.kc.cw.ad.a.c.b bVarD = dVar.d();
                                                this.al.b(!com.kc.cw.ad.internal.c.p.a(this.aM) ? this.aM : this.aR);
                                                this.al.a(dVar.d());
                                                com.kc.cw.ad.a.c.i iVarK = bVarD.k();
                                                if (iVarK != null && !TextUtils.isEmpty(iVarK.a())) {
                                                    this.al.c(iVarK.a());
                                                }
                                                if (iVarK != null && !TextUtils.isEmpty(iVarK.b())) {
                                                    this.al.d(iVarK.b());
                                                }
                                                List<com.kc.cw.ad.a.c.i> listT = bVarD.t();
                                                if (listT != null && !listT.isEmpty()) {
                                                    for (int i4 = 0; i4 < listT.size(); i4++) {
                                                        String strB = listT.get(i4).b();
                                                        if (!TextUtils.isEmpty(strB)) {
                                                            this.al.d(strB);
                                                        }
                                                        String strA = listT.get(i4).a();
                                                        if (!TextUtils.isEmpty(strA)) {
                                                            this.al.c(strA);
                                                        }
                                                    }
                                                }
                                            }
                                        } catch (Exception e) {
                                            com.kc.cw.ad.d.b.f.a("OctopusAd", "An Exception Caught", e);
                                        }
                                        if (this.al != null) {
                                            this.aY = true;
                                            return true;
                                        }
                                    } else {
                                        continue;
                                    }
                                }
                            }
                        } else {
                            continue;
                        }
                    }
                }
            }
        } else {
            com.kc.cw.ad.internal.c.f.e(com.kc.cw.ad.internal.c.f.e, com.kc.cw.ad.internal.c.f.a(R.string.blank_ad));
        }
        if (this.aL.isEmpty()) {
            return false;
        }
        this.aY = true;
        return true;
    }

    private boolean f(com.kc.cw.ad.a.c.t tVar) {
        if (tVar.a() > 0) {
            com.kc.cw.ad.a.c.v vVar = tVar.v().get(0);
            List<com.kc.cw.ad.a.c.d> listM = vVar.M();
            if (listM != null && !listM.isEmpty()) {
                com.kc.cw.ad.a.c.d dVar = listM.get(0);
                if (dVar.d() != null) {
                    com.kc.cw.ad.a.c.b bVarD = dVar.d();
                    a(bVarD);
                    com.kc.cw.ad.a.c.i iVarK = bVarD.k();
                    if (iVarK != null && !TextUtils.isEmpty(iVarK.a())) {
                        this.f38916a = iVarK.a();
                    }
                    if (iVarK != null && !TextUtils.isEmpty(iVarK.b())) {
                        this.b = iVarK.b();
                    }
                }
            }
            this.c = vVar.c();
            this.d = vVar.d();
            this.ae = vVar.e();
            this.e = vVar.f() == com.kc.cw.ad.a.g.h.PORTRAIT ? 1 : 2;
            this.h = Integer.parseInt(vVar.h());
            this.i = Integer.parseInt(vVar.i());
            this.L = vVar.g();
            List<com.kc.cw.ad.a.c.d> listM2 = vVar.M();
            if (listM2 != null && !listM2.isEmpty()) {
                this.K = listM2.get(0).j();
                this.N = listM2.get(0).k();
                this.aI = listM2.get(0).c();
            }
            this.f = 0;
            this.g = 0;
            if (vVar.j() != null && af() == com.kc.cw.ad.a.g.a.ADP_INTERSTITIAL) {
                com.kc.cw.ad.a.c.f fVarJ = vVar.j();
                this.f = Integer.parseInt(fVarJ.a());
                this.g = Integer.parseInt(fVarJ.b());
            }
        }
        return false;
    }

    public boolean A() {
        return this.t;
    }

    public int B() {
        return this.T;
    }

    public boolean C() {
        return this.u;
    }

    public boolean D() {
        return this.v;
    }

    public int E() {
        return this.A;
    }

    public int F() {
        return this.B;
    }

    public int G() {
        return this.g;
    }

    public int H() {
        return this.f;
    }

    public int I() {
        return this.e;
    }

    public int J() {
        return this.d;
    }

    public com.kc.cw.ad.a.c.o K() {
        return this.aD;
    }

    public com.kc.cw.ad.a.c.w L() {
        return this.aE;
    }

    public boolean M() {
        return this.w;
    }

    public boolean N() {
        return this.x;
    }

    public boolean O() {
        return this.y;
    }

    public boolean P() {
        return this.z;
    }

    public boolean Q() {
        return this.X;
    }

    public Boolean R() {
        return this.Y;
    }

    public boolean S() {
        return this.Z;
    }

    public boolean T() {
        return this.aa;
    }

    public boolean U() {
        return this.m;
    }

    public boolean V() {
        return this.p;
    }

    public boolean W() {
        return this.o;
    }

    public String X() {
        return this.aN;
    }

    public String Y() {
        return this.aM;
    }

    public String Z() {
        return this.aQ;
    }

    public com.kc.cw.ad.a.c.b a() {
        return this.aC;
    }

    public void a(int i) {
        com.kc.cw.ad.internal.d dVar;
        if (this.I || (dVar = this.aK) == null) {
            return;
        }
        this.I = true;
        o.a(new l("CHANGECONFIG", dVar.c(), this.aK.e(), i, System.currentTimeMillis() - this.aK.i()));
    }

    public void a(int i, String str, String str2) {
        if (this.J) {
            return;
        }
        this.J = true;
        new com.kc.cw.ad.internal.i(com.kc.cw.ad.internal.c.q.a(q.a().n() + "/sdk/lurl?win_price=${WIN_PRICE}&lose_reason=${LOSS_REASON}&win_bidder=${WIN_BIDDER}&slot_id=${SLOT_ID}&adx_code=zysdk2", i, str, str2, this.M)).b();
    }

    public void a(Context context, int i, boolean z, boolean z2, boolean z3, com.kc.cw.ad.a.d dVar, int i2) {
        boolean z4;
        int i3 = i;
        if (!TextUtils.isEmpty(this.ah)) {
            try {
                OctUtil.a().setInfo(this.ah);
                a(OctUtil.a().changeConfig());
                k.a().a(new k.a(this) { // from class: com.kc.cw.ad.internal.b.f.5

                    /* JADX INFO: renamed from: a, reason: collision with root package name */
                    final f f38921a;

                    {
                        this.f38921a = this;
                    }

                    @Override // com.kc.cw.ad.internal.k.a
                    public void a(String str) {
                        if ("AppSelfForeground".equals(str)) {
                            new Handler().postDelayed(new Runnable(this, this) { // from class: com.kc.cw.ad.internal.b.f.5.1

                                /* JADX INFO: renamed from: a, reason: collision with root package name */
                                final k.a f38922a;
                                final AnonymousClass5 b;

                                {
                                    this.b = this;
                                    this.f38922a = this;
                                }

                                @Override // java.lang.Runnable
                                public void run() {
                                    try {
                                        OctUtil.a().resumeConfig();
                                    } catch (Throwable th) {
                                        com.kc.cw.ad.d.b.f.a("OctopusAd", "A Throwable Caught", th);
                                    }
                                    k.a().b(this.f38922a);
                                }
                            }, this.f38921a.ai);
                        }
                    }
                });
            } catch (Throwable th) {
                com.kc.cw.ad.d.b.f.a("OctopusAd", "A Throwable Caught", th);
            }
        }
        this.P = i3;
        this.U = z;
        this.V = z2;
        this.W = z3;
        if (z) {
            this.P = 10;
        } else if (z2) {
            this.P = 1;
        }
        com.kc.cw.ad.d.b.f.a("OctopusAd", "handleClick========" + this.H);
        if (!this.H) {
            this.H = true;
            a(dVar);
        }
        com.kc.cw.ad.d.b.f.a("OctopusAd", "mDeepLinkUrl:" + this.aN + ",appDownloadURL = " + this.az + ",mLandingPageUrl = " + this.aM);
        boolean zD = com.kc.cw.ad.d.b.i.d(context, this.ax);
        if ((!this.l || zD || this.av == 3) && !TextUtils.isEmpty(this.aN)) {
            try {
                if (q.a().f() && ((z4 = this.m) || this.n)) {
                    if (!z4) {
                        this.aQ = null;
                    }
                    this.aP = this.aN;
                    try {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put(ALPParamConstant.PACKAGENAME, this.ax);
                        jSONObject.put("link", this.aN);
                        this.aP = jSONObject.toString();
                    } catch (Exception e) {
                        com.kc.cw.ad.d.b.f.a("OctopusAd", "An Exception Caught", e);
                    }
                    if (this.S <= 0 || !Build.MANUFACTURER.equalsIgnoreCase("vivo") || q.a().y) {
                        OctUtil.a().a(context, this.aP, this.aQ, this.n, new OctUtil.C(this, context, i2) { // from class: com.kc.cw.ad.internal.b.f.7

                            /* JADX INFO: renamed from: a, reason: collision with root package name */
                            final Context f38925a;
                            final int b;
                            final f c;

                            {
                                this.c = this;
                                this.f38925a = context;
                                this.b = i2;
                            }

                            @Override // com.kc.cw.ad.utils.OctUtil.C
                            public String e(String str) {
                                this.c.a(this.f38925a, str, this.b);
                                return null;
                            }
                        });
                    } else {
                        q.a().y = true;
                        OctUtil.a().a(context.getApplicationContext(), 1003);
                        new Handler().postDelayed(new AnonymousClass6(this, context, i2), this.S);
                    }
                } else {
                    a(context, i2);
                }
                ap();
                this.at = new k.a(this, i2) { // from class: com.kc.cw.ad.internal.b.f.8

                    /* JADX INFO: renamed from: a, reason: collision with root package name */
                    final int f38926a;
                    final f b;

                    {
                        this.b = this;
                        this.f38926a = i2;
                    }

                    @Override // com.kc.cw.ad.internal.k.a
                    public void a(String str) {
                        if ("AppBackground".equals(str)) {
                            this.b.a(0, "", this.f38926a);
                            this.b.ap();
                        }
                    }
                };
                k.a().a(this.at);
                a(9, "", i2);
                return;
            } catch (Throwable th2) {
                b(context);
                a(-9, th2.getMessage(), i2);
                return;
            }
        }
        if (TextUtils.isEmpty(this.az) || this.av != 2) {
            if (this.av == 6) {
                boolean zA = a(context);
                a(zA ? 0 : -2, "", i2);
                if (zA) {
                    return;
                }
            }
            b(context);
            return;
        }
        if (zD) {
            com.kc.cw.ad.d.b.c.a(context, this.ax);
            return;
        }
        if (ad() && i3 == 0) {
            i3 = 6;
        }
        File fileA = com.kc.cw.ad.d.b.c.a(context);
        String absolutePath = fileA != null ? fileA.getAbsolutePath() : "";
        com.kc.cw.ad.d.c.a(context).b(context).a(this.ad).a(this.ak).a(this.aA).a(ad()).a(i3).a(this.aC).a(new com.kc.cw.ad.d.b(this.az, this.ax + ".apk", this.ax, absolutePath, this.aw, this.ay, context.getPackageName() + ".ssad.provider", this.au)).c();
    }

    public void a(View view, int i, boolean z, com.kc.cw.ad.a.d dVar) {
        Context contextL = view == null ? q.a().l() : view.getContext();
        int i2 = this.R + 1;
        this.R = i2;
        a(contextL, i, this.U, this.V, z, dVar, i2);
    }

    public void a(com.kc.cw.ad.a.a aVar, boolean z) {
        com.kc.cw.ad.internal.d dVar = this.aK;
        if (dVar != null) {
            dVar.c(System.currentTimeMillis());
            if (aVar != null) {
                aVar.c(System.currentTimeMillis());
            }
            o.a(new l("IMP", this.aK.c(), this.aK.a(), System.currentTimeMillis() - this.aK.h(), z));
        }
    }

    public void a(com.kc.cw.ad.b.a aVar) {
        this.ak = aVar;
    }

    public void a(String str) {
        com.kc.cw.ad.internal.d dVar = this.aK;
        if (dVar != null) {
            o.a(new l("RENDERFAIL", dVar.c(), this.aK.a(), System.currentTimeMillis() - this.aK.h(), str));
        }
    }

    public void a(String str, Object obj) {
        this.aX.put(str, obj);
    }

    public void a(boolean z) {
        this.G = z;
    }

    public void a(boolean z, com.kc.cw.ad.a aVar) {
        List<com.kc.cw.ad.a.c.i> listT;
        StringBuilder sb;
        String str;
        this.W = z;
        int i = this.D;
        if (i <= 0) {
            this.D = i + 1;
            if (!com.kc.cw.ad.internal.c.p.a(this.f38916a)) {
                new com.kc.cw.ad.internal.i(this.f38916a).b();
                this.f38916a = "";
            }
            com.kc.cw.ad.a.c.b bVar = this.aC;
            if (bVar == null || (listT = bVar.t()) == null) {
                return;
            }
            for (int i2 = 0; i2 < listT.size(); i2++) {
                com.kc.cw.ad.a.c.i iVar = listT.get(i2);
                if (iVar != null && !TextUtils.isEmpty(iVar.a())) {
                    String strA = iVar.a();
                    if (strA.contains("?rv=1")) {
                        ViewUtil.openLocalBrowser(strA, this.j);
                    } else {
                        if (strA.contains("track=oct")) {
                            if (this.U) {
                                sb = new StringBuilder();
                                sb.append(strA);
                                str = "&opt=10";
                            } else if (this.V) {
                                sb = new StringBuilder();
                                sb.append(strA);
                                str = "&opt=1";
                            } else if (!z) {
                                sb = new StringBuilder();
                                sb.append(strA);
                                str = "&opt=4";
                            } else if (!this.X) {
                                sb = new StringBuilder();
                                sb.append(strA);
                                str = "&opt=11";
                            }
                            sb.append(str);
                            strA = sb.toString();
                        }
                        long jCurrentTimeMillis = System.currentTimeMillis();
                        com.kc.cw.ad.internal.d dVar = this.aK;
                        if (dVar != null) {
                            jCurrentTimeMillis = dVar.h();
                        }
                        u uVar = new u(QdActivityType.IMP, this.M, this.ad, jCurrentTimeMillis, strA, this.aS);
                        if (strA.contains("track=octimp")) {
                            uVar.a(new com.kc.cw.ad.internal.c.d.a(this, aVar, z) { // from class: com.kc.cw.ad.internal.b.f.3

                                /* JADX INFO: renamed from: a, reason: collision with root package name */
                                final com.kc.cw.ad.a f38919a;
                                final boolean b;
                                final f c;

                                {
                                    this.c = this;
                                    this.f38919a = aVar;
                                    this.b = z;
                                }

                                @Override // com.kc.cw.ad.internal.c.d.a
                                public void a(int i3, boolean z2, String str2) {
                                    com.kc.cw.ad.a aVar2 = this.f38919a;
                                    if (aVar2 != null) {
                                        if (z2) {
                                            z2 = this.b;
                                        }
                                        aVar2.a(z2);
                                    }
                                }
                            });
                        }
                        uVar.a();
                    }
                }
            }
        }
    }

    public ShakeValue aa() {
        return this.aq;
    }

    public Map<String, Object> ab() {
        return this.aj;
    }

    public void ac() {
        com.kc.cw.ad.internal.d dVar;
        if (this.I || (dVar = this.aK) == null) {
            return;
        }
        this.I = true;
        o.a(new l("CLOSE", dVar.c(), this.aK.e(), System.currentTimeMillis() - this.aK.i()));
    }

    public boolean ad() {
        com.kc.cw.ad.a.c.w wVar = this.aE;
        return (wVar == null || wVar.b() == null || this.aE.b().a() != 1) ? false : true;
    }

    public LinkedList<String> ae() {
        return this.aW;
    }

    public com.kc.cw.ad.a.g.a af() {
        return this.c;
    }

    public int ag() {
        return this.Q;
    }

    public void ah() {
        List<com.kc.cw.ad.a.c.z> listS;
        com.kc.cw.ad.a.c.b bVar = this.aC;
        if (bVar == null || this.ba || (listS = bVar.s()) == null) {
            return;
        }
        this.bb = System.currentTimeMillis();
        for (int i = 0; i < listS.size(); i++) {
            b(listS.get(i).a());
            this.ba = true;
        }
    }

    public void ai() {
        List<com.kc.cw.ad.a.c.z> listS;
        com.kc.cw.ad.a.c.b bVar = this.aC;
        if (bVar == null || this.bd || !this.ba || (listS = bVar.s()) == null) {
            return;
        }
        for (int i = 0; i < listS.size(); i++) {
            b(listS.get(i).b());
            this.bd = true;
        }
    }

    public void aj() {
        List<com.kc.cw.ad.a.c.z> listS;
        com.kc.cw.ad.a.c.b bVar = this.aC;
        if (bVar == null || this.bf || !this.ba || (listS = bVar.s()) == null) {
            return;
        }
        this.bc = System.currentTimeMillis();
        for (int i = 0; i < listS.size(); i++) {
            b(listS.get(i).f());
            this.bf = true;
        }
    }

    public void ak() {
        List<com.kc.cw.ad.a.c.z> listS;
        com.kc.cw.ad.a.c.b bVar = this.aC;
        if (bVar == null || this.bg || !this.ba || (listS = bVar.s()) == null) {
            return;
        }
        for (int i = 0; i < listS.size(); i++) {
            b(listS.get(i).g());
            this.bg = true;
        }
    }

    public void al() {
        d();
        ap();
        if (this.ar != null) {
            ThreadUtils.runOnUIThread(new Runnable(this) { // from class: com.kc.cw.ad.internal.b.f.9

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                final f f38927a;

                {
                    this.f38927a = this;
                }

                @Override // java.lang.Runnable
                public void run() {
                    try {
                        if (this.f38927a.ar != null) {
                            this.f38927a.ar.destroy();
                            this.f38927a.ar = null;
                        }
                    } catch (Exception unused) {
                    }
                }
            });
        } else {
            ak();
        }
    }

    public AdLogoInfo am() {
        return this.E;
    }

    public AdLogoInfo an() {
        return this.F;
    }

    public void b() {
        if (this.aK != null) {
            o.a(new l("SHOW", e(), this.ad, System.currentTimeMillis() - this.aK.h()));
        }
    }

    public void b(int i) {
        if (this.J) {
            return;
        }
        this.J = true;
        new com.kc.cw.ad.internal.i(com.kc.cw.ad.internal.c.q.a(q.a().n() + "/sdk/nurl?second_price=${SECOND_PRICE}&slot_id=${SLOT_ID}&adx_code=zysdk2", i, this.M)).b();
    }

    public void b(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        new com.kc.cw.ad.internal.i(com.kc.cw.ad.internal.c.q.a(str, this.ap, this.bb, this.bc)).b();
    }

    public void b(boolean z) {
        com.kc.cw.ad.internal.d dVar = this.aK;
        if (dVar != null) {
            o.a(new l("CLK", dVar.c(), this.aK.a(), System.currentTimeMillis() - this.aK.i(), z));
        }
    }

    public void c() {
        if (this.aK != null) {
            o.a(new l("FEEDBACK", e(), this.ad, System.currentTimeMillis() - this.aK.i()));
        }
    }

    public void c(int i) {
        List<com.kc.cw.ad.a.c.z> listS;
        String strE;
        com.kc.cw.ad.a.c.b bVar = this.aC;
        if (bVar == null || this.be == i || !this.ba || (listS = bVar.s()) == null) {
            return;
        }
        for (int i2 = 0; i2 < listS.size(); i2++) {
            com.kc.cw.ad.a.c.z zVar = listS.get(i2);
            if (i == 1) {
                strE = zVar.c();
            } else if (i == 2) {
                strE = zVar.d();
            } else {
                strE = i == 3 ? zVar.e() : "";
            }
            b(strE);
            this.be = i;
        }
    }

    public void c(boolean z) {
        this.V = z;
    }

    public void d() {
        if (this.aK != null) {
            o.a(new l("DESTROY", e(), this.ad, System.currentTimeMillis() - this.aK.i()));
        }
    }

    public void d(boolean z) {
        this.U = z;
    }

    public String e() {
        return this.M;
    }

    public String f() {
        return this.ab;
    }

    public String g() {
        return this.ac;
    }

    public String h() {
        return this.af;
    }

    public String i() {
        return this.aO;
    }

    public com.kc.cw.ad.a.c.l j() {
        return this.an;
    }

    public com.kc.cw.ad.a.c.y k() {
        return this.ao;
    }

    public NativeAdResponse l() {
        return this.al;
    }

    public p m() {
        return this.aJ;
    }

    public List<Pair<j, String>> n() {
        return this.aL;
    }

    public int o() {
        return this.h;
    }

    public int p() {
        return this.i;
    }

    public int q() {
        return this.K;
    }

    public int r() {
        return this.L;
    }

    public String s() {
        return this.N;
    }

    public long t() {
        return this.aI;
    }

    public boolean u() {
        return this.aY;
    }

    public boolean v() {
        return this.aZ;
    }

    public HashMap<String, Object> w() {
        return this.aX;
    }

    public boolean x() {
        return this.k;
    }

    public boolean y() {
        return this.q;
    }

    public boolean z() {
        return this.r;
    }
}
