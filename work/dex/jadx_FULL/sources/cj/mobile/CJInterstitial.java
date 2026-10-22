package cj.mobile;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import cj.mobile.ad.ZFSDK;
import cj.mobile.listener.CJInterstitialListener;
import java.io.IOException;
import java.util.Map;
import org.json.JSONArray;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_13_8952cls.dex */
public class CJInterstitial {
    public Map<String, cj.mobile.a.q> A;
    public Map<String, cj.mobile.a.j> B;
    public Map<String, cj.mobile.a.h> C;
    public Map<String, cj.mobile.a.b> D;
    public Map<String, cj.mobile.a.s> E;
    public Map<String, cj.mobile.a.e> F;
    public Map<String, cj.mobile.a.c> G;
    public Map<String, cj.mobile.a.g> H;
    public Map<String, ZFSDK> I;
    public Map<String, cj.mobile.a.k> J;
    public String K;
    public String L;
    public String M;
    public boolean N;
    public int O;
    public int P;
    public String Q;
    public String R;
    public boolean S;
    public boolean T;
    public int U;
    public int V;
    public long W;
    public int X;
    public boolean Y;
    public int Z;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public JSONArray f21607a;
    public int a0;
    public JSONArray b;
    public Handler b0;
    public String c;
    public boolean c0;
    public int d;
    public Runnable d0;
    public String e;
    public Runnable e0;
    public String f;
    public Runnable f0;
    public int g;
    public Runnable g0;
    public int h;
    public Runnable h0;
    public boolean i;
    public Runnable i0;
    public int j;
    public final cj.mobile.p.h j0;
    public int k;
    public final cj.mobile.p.h k0;
    public int l;
    public boolean m;
    public boolean n;
    public boolean o;
    public Context p;
    public CJInterstitialListener q;
    public CJInterstitialListener r;
    public String s;
    public Map<String, cj.mobile.a.r> t;
    public Map<String, cj.mobile.a.p> u;
    public Map<String, cj.mobile.a.i> v;
    public Map<String, cj.mobile.a.a> w;
    public cj.mobile.a.n x;
    public Map<String, cj.mobile.a.l> y;
    public Map<String, cj.mobile.a.m> z;

    public class a implements CJInterstitialListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CJInterstitial f21608a;

        /* JADX INFO: renamed from: cj.mobile.CJInterstitial$a$a, reason: collision with other inner class name */
        public class RunnableC0039a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ a f21609a;

            public RunnableC0039a(a aVar) {
            }

            @Override // java.lang.Runnable
            public void run() {
            }
        }

        public class b implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ String f21610a;
            public final /* synthetic */ String b;
            public final /* synthetic */ a c;

            public b(a aVar, String str, String str2) {
            }

            @Override // java.lang.Runnable
            public void run() {
            }
        }

        public class c implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ a f21611a;

            public c(a aVar) {
            }

            @Override // java.lang.Runnable
            public void run() {
            }
        }

        public class d implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ a f21612a;

            public d(a aVar) {
            }

            @Override // java.lang.Runnable
            public void run() {
            }
        }

        public class e implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ a f21613a;

            public e(a aVar) {
            }

            @Override // java.lang.Runnable
            public void run() {
            }
        }

        public a(CJInterstitial cJInterstitial) {
        }

        @Override // cj.mobile.listener.CJInterstitialListener
        public void onClick() {
        }

        @Override // cj.mobile.listener.CJInterstitialListener
        public void onClose() {
        }

        @Override // cj.mobile.listener.CJInterstitialListener
        public void onError(String str, String str2) {
        }

        @Override // cj.mobile.listener.CJInterstitialListener
        public void onLoad() {
        }

        @Override // cj.mobile.listener.CJInterstitialListener
        public void onShow() {
        }
    }

    public class a0 implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CJInterstitial f21614a;

        public a0(CJInterstitial cJInterstitial) {
        }

        @Override // java.lang.Runnable
        public void run() {
        }
    }

    public class b implements cj.mobile.p.h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CJInterstitial f21615a;

        public b(CJInterstitial cJInterstitial) {
        }

        @Override // cj.mobile.p.h
        public void a(String str, String str2, int i) {
        }

        @Override // cj.mobile.p.h
        public void onError(String str, String str2) {
        }
    }

    public class b0 implements cj.mobile.p.h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CJInterstitial f21616a;

        public class a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ b0 f21617a;

            public a(b0 b0Var) {
            }

            @Override // java.lang.Runnable
            public void run() {
            }
        }

        public b0(CJInterstitial cJInterstitial) {
        }

        @Override // cj.mobile.p.h
        public void a(String str, String str2, int i) {
        }

        @Override // cj.mobile.p.h
        public void onError(String str, String str2) {
        }
    }

    public class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CJInterstitial f21618a;

        public c(CJInterstitial cJInterstitial) {
        }

        @Override // java.lang.Runnable
        public void run() {
        }
    }

    public class d implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f21619a;
        public final /* synthetic */ boolean b;
        public final /* synthetic */ int c;
        public final /* synthetic */ cj.mobile.p.h d;
        public final /* synthetic */ CJInterstitial e;

        public d(CJInterstitial cJInterstitial, String str, boolean z, int i, cj.mobile.p.h hVar) {
        }

        @Override // java.lang.Runnable
        public void run() {
        }
    }

    public class e implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f21620a;
        public final /* synthetic */ boolean b;
        public final /* synthetic */ int c;
        public final /* synthetic */ cj.mobile.p.h d;
        public final /* synthetic */ CJInterstitial e;

        public e(CJInterstitial cJInterstitial, String str, boolean z, int i, cj.mobile.p.h hVar) {
        }

        @Override // java.lang.Runnable
        public void run() {
        }
    }

    public class f implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f21621a;
        public final /* synthetic */ boolean b;
        public final /* synthetic */ int c;
        public final /* synthetic */ cj.mobile.p.h d;
        public final /* synthetic */ CJInterstitial e;

        public f(CJInterstitial cJInterstitial, String str, boolean z, int i, cj.mobile.p.h hVar) {
        }

        @Override // java.lang.Runnable
        public void run() {
        }
    }

    public class g implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f21622a;
        public final /* synthetic */ boolean b;
        public final /* synthetic */ int c;
        public final /* synthetic */ cj.mobile.p.h d;
        public final /* synthetic */ CJInterstitial e;

        public g(CJInterstitial cJInterstitial, String str, boolean z, int i, cj.mobile.p.h hVar) {
        }

        @Override // java.lang.Runnable
        public void run() {
        }
    }

    public class h implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f21623a;
        public final /* synthetic */ boolean b;
        public final /* synthetic */ int c;
        public final /* synthetic */ cj.mobile.p.h d;
        public final /* synthetic */ CJInterstitial e;

        public h(CJInterstitial cJInterstitial, String str, boolean z, int i, cj.mobile.p.h hVar) {
        }

        @Override // java.lang.Runnable
        public void run() {
        }
    }

    public class i implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f21624a;
        public final /* synthetic */ boolean b;
        public final /* synthetic */ int c;
        public final /* synthetic */ cj.mobile.p.h d;
        public final /* synthetic */ CJInterstitial e;

        public i(CJInterstitial cJInterstitial, String str, boolean z, int i, cj.mobile.p.h hVar) {
        }

        @Override // java.lang.Runnable
        public void run() {
        }
    }

    public class j implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f21625a;
        public final /* synthetic */ boolean b;
        public final /* synthetic */ int c;
        public final /* synthetic */ cj.mobile.p.h d;
        public final /* synthetic */ CJInterstitial e;

        public j(CJInterstitial cJInterstitial, String str, boolean z, int i, cj.mobile.p.h hVar) {
        }

        @Override // java.lang.Runnable
        public void run() {
        }
    }

    public class k implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f21626a;
        public final /* synthetic */ boolean b;
        public final /* synthetic */ int c;
        public final /* synthetic */ cj.mobile.p.h d;
        public final /* synthetic */ CJInterstitial e;

        public k(CJInterstitial cJInterstitial, String str, boolean z, int i, cj.mobile.p.h hVar) {
        }

        @Override // java.lang.Runnable
        public void run() {
        }
    }

    public class l implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f21627a;
        public final /* synthetic */ boolean b;
        public final /* synthetic */ int c;
        public final /* synthetic */ cj.mobile.p.h d;
        public final /* synthetic */ CJInterstitial e;

        public l(CJInterstitial cJInterstitial, String str, boolean z, int i, cj.mobile.p.h hVar) {
        }

        @Override // java.lang.Runnable
        public void run() {
        }
    }

    public class m implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f21628a;
        public final /* synthetic */ boolean b;
        public final /* synthetic */ int c;
        public final /* synthetic */ cj.mobile.p.h d;
        public final /* synthetic */ CJInterstitial e;

        public m(CJInterstitial cJInterstitial, String str, boolean z, int i, cj.mobile.p.h hVar) {
        }

        @Override // java.lang.Runnable
        public void run() {
        }
    }

    public class n implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f21629a;
        public final /* synthetic */ boolean b;
        public final /* synthetic */ int c;
        public final /* synthetic */ cj.mobile.p.h d;
        public final /* synthetic */ CJInterstitial e;

        public n(CJInterstitial cJInterstitial, String str, boolean z, int i, cj.mobile.p.h hVar) {
        }

        @Override // java.lang.Runnable
        public void run() {
        }
    }

    public class o implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ cj.mobile.p.h f21630a;
        public final /* synthetic */ CJInterstitial b;

        public o(CJInterstitial cJInterstitial, cj.mobile.p.h hVar) {
        }

        @Override // java.lang.Runnable
        public void run() {
        }
    }

    public class p implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f21631a;
        public final /* synthetic */ boolean b;
        public final /* synthetic */ String c;
        public final /* synthetic */ int d;
        public final /* synthetic */ cj.mobile.p.h e;
        public final /* synthetic */ CJInterstitial f;

        public p(CJInterstitial cJInterstitial, String str, boolean z, String str2, int i, cj.mobile.p.h hVar) {
        }

        @Override // java.lang.Runnable
        public void run() {
        }
    }

    public class q implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f21632a;
        public final /* synthetic */ boolean b;
        public final /* synthetic */ int c;
        public final /* synthetic */ cj.mobile.p.h d;
        public final /* synthetic */ CJInterstitial e;

        public q(CJInterstitial cJInterstitial, String str, boolean z, int i, cj.mobile.p.h hVar) {
        }

        @Override // java.lang.Runnable
        public void run() {
        }
    }

    public class r implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f21633a;
        public final /* synthetic */ boolean b;
        public final /* synthetic */ String c;
        public final /* synthetic */ int d;
        public final /* synthetic */ cj.mobile.p.h e;
        public final /* synthetic */ CJInterstitial f;

        public r(CJInterstitial cJInterstitial, String str, boolean z, String str2, int i, cj.mobile.p.h hVar) {
        }

        @Override // java.lang.Runnable
        public void run() {
        }
    }

    public class s implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f21634a;
        public final /* synthetic */ boolean b;
        public final /* synthetic */ int c;
        public final /* synthetic */ cj.mobile.p.h d;
        public final /* synthetic */ CJInterstitial e;

        public s(CJInterstitial cJInterstitial, String str, boolean z, int i, cj.mobile.p.h hVar) {
        }

        @Override // java.lang.Runnable
        public void run() {
        }
    }

    public class t implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f21635a;
        public final /* synthetic */ boolean b;
        public final /* synthetic */ int c;
        public final /* synthetic */ cj.mobile.p.h d;
        public final /* synthetic */ CJInterstitial e;

        public t(CJInterstitial cJInterstitial, String str, boolean z, int i, cj.mobile.p.h hVar) {
        }

        @Override // java.lang.Runnable
        public void run() {
        }
    }

    public class v implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CJInterstitial f21637a;

        public v(CJInterstitial cJInterstitial) {
        }

        @Override // java.lang.Runnable
        public void run() {
        }
    }

    public class w implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CJInterstitial f21638a;

        public w(CJInterstitial cJInterstitial) {
        }

        @Override // java.lang.Runnable
        public void run() {
        }
    }

    public class x implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CJInterstitial f21639a;

        public x(CJInterstitial cJInterstitial) {
        }

        @Override // java.lang.Runnable
        public void run() {
        }
    }

    public class y implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CJInterstitial f21640a;

        public y(CJInterstitial cJInterstitial) {
        }

        @Override // java.lang.Runnable
        public void run() {
        }
    }

    public class z implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CJInterstitial f21641a;

        public z(CJInterstitial cJInterstitial) {
        }

        @Override // java.lang.Runnable
        public void run() {
        }
    }

    public void biddingResult() {
    }

    public void destroy() {
    }

    public String getAdType() {
        return this.L;
    }

    public int getEcpm() {
    }

    public String getRequestId() {
        return this.c;
    }

    public boolean isValid() {
    }

    public void loadAd(Context context, String str, CJInterstitialListener cJInterstitialListener) {
    }

    public CJInterstitial setIsVideoSound(boolean z2) {
        this.c0 = z2;
        return this;
    }

    public void setListener(CJInterstitialListener cJInterstitialListener) {
        this.r = cJInterstitialListener;
    }

    public void showAd(Activity activity) {
    }

    public final void h(String str, int i2, boolean z2, cj.mobile.p.h hVar) {
    }

    public final void i(String str, int i2, boolean z2, cj.mobile.p.h hVar) {
    }

    public final void j(String str, int i2, boolean z2, cj.mobile.p.h hVar) {
    }

    public final void k(String str, int i2, boolean z2, cj.mobile.p.h hVar) {
    }

    public final void l(String str, int i2, boolean z2, cj.mobile.p.h hVar) {
    }

    public final void m(String str, int i2, boolean z2, cj.mobile.p.h hVar) {
    }

    public final void n(String str, int i2, boolean z2, cj.mobile.p.h hVar) {
    }

    public final void g(String str, int i2, boolean z2, cj.mobile.p.h hVar) {
    }

    public final void d() {
    }

    public final void e() {
    }

    public final void f(String str, int i2, boolean z2, cj.mobile.p.h hVar) {
    }

    public class u implements cj.mobile.p.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f21636a;
        public final /* synthetic */ Context b;
        public final /* synthetic */ CJInterstitial c;

        public u(CJInterstitial cJInterstitial, String str, Context context) {
        }

        @Override // cj.mobile.p.d
        public void a(IOException iOException) {
        }

        @Override // cj.mobile.p.d
        public void a(String str) {
        }
    }

    public final void b() {
    }

    public final void c() {
    }

    public final void d(String str, int i2, boolean z2, cj.mobile.p.h hVar) {
    }

    public final void b(String str, int i2, boolean z2, cj.mobile.p.h hVar) {
    }

    public final void c(String str, int i2, boolean z2, cj.mobile.p.h hVar) {
    }

    public final void a(String str, String str2) {
    }

    public final void e(String str, int i2, boolean z2, cj.mobile.p.h hVar) {
    }

    public final void a() {
    }

    public final void a(boolean z2) {
    }

    public final synchronized void a(JSONArray jSONArray, int i2, int i3) {
    }

    public final void a(JSONArray jSONArray, int i2) {
    }

    public final void a(String str, int i2, boolean z2, cj.mobile.p.h hVar) {
    }

    public final void a(int i2, cj.mobile.p.h hVar) {
    }

    public final void a(String str, int i2, String str2, boolean z2, cj.mobile.p.h hVar) {
    }

    public final void a(String str, String str2, int i2, boolean z2, cj.mobile.p.h hVar) {
    }

    public final void a(String str) {
    }

    public final void a(JSONArray jSONArray, String str) {
    }
}
