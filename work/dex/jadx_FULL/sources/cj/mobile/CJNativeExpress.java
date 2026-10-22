package cj.mobile;

import android.content.Context;
import android.os.Handler;
import android.view.View;
import cj.mobile.ad.ZFSDK;
import cj.mobile.listener.CJNativeExpressListener;
import java.io.IOException;
import java.util.Map;
import org.json.JSONArray;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_13_8952cls.dex */
public class CJNativeExpress {
    public int A;
    public int B;
    public int C;
    public int D;
    public Handler E;
    public long F;
    public int G;
    public boolean H;
    public boolean I;
    public int J;
    public Map<String, cj.mobile.a.r> K;
    public Map<String, cj.mobile.a.p> L;
    public Map<String, cj.mobile.a.i> M;
    public Map<String, cj.mobile.a.a> N;
    public Map<String, cj.mobile.a.q> O;
    public Map<String, cj.mobile.a.l> P;
    public Map<String, cj.mobile.a.b> Q;
    public Map<String, cj.mobile.a.h> R;
    public Map<String, cj.mobile.a.j> S;
    public Map<String, cj.mobile.a.s> T;
    public Map<String, cj.mobile.a.e> U;
    public Map<String, cj.mobile.a.c> V;
    public Map<String, cj.mobile.a.f> W;
    public Map<String, ZFSDK> X;
    public Map<String, cj.mobile.a.k> Y;
    public Map<String, cj.mobile.a.g> Z;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public JSONArray f21646a;
    public CJNativeExpressListener a0;
    public JSONArray b;
    public Runnable b0;
    public String c;
    public Runnable c0;
    public int d;
    public Runnable d0;
    public String e;
    public Runnable e0;
    public String f;
    public Runnable f0;
    public int g;
    public Runnable g0;
    public int h;
    public cj.mobile.p.h h0;
    public int i;
    public final cj.mobile.p.h i0;
    public int j;
    public boolean k;
    public boolean l;
    public boolean m;
    public Context n;
    public CJNativeExpressListener o;
    public String p;
    public int q;
    public int r;
    public int s;
    public String t;
    public String u;
    public String v;
    public boolean w;
    public int x;
    public int y;
    public boolean z;

    public class a implements CJNativeExpressListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CJNativeExpress f21647a;

        /* JADX INFO: renamed from: cj.mobile.CJNativeExpress$a$a, reason: collision with other inner class name */
        public class RunnableC0040a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ View f21648a;
            public final /* synthetic */ a b;

            public RunnableC0040a(a aVar, View view) {
            }

            @Override // java.lang.Runnable
            public void run() {
            }
        }

        public class b implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ String f21649a;
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
            public final /* synthetic */ View f21650a;
            public final /* synthetic */ a b;

            public c(a aVar, View view) {
            }

            @Override // java.lang.Runnable
            public void run() {
            }
        }

        public class d implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ View f21651a;
            public final /* synthetic */ a b;

            public d(a aVar, View view) {
            }

            @Override // java.lang.Runnable
            public void run() {
            }
        }

        public class e implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ View f21652a;
            public final /* synthetic */ a b;

            public e(a aVar, View view) {
            }

            @Override // java.lang.Runnable
            public void run() {
            }
        }

        public a(CJNativeExpress cJNativeExpress) {
        }

        @Override // cj.mobile.listener.CJNativeExpressListener
        public void loadSuccess(View view) {
        }

        @Override // cj.mobile.listener.CJNativeExpressListener
        public void onClick(View view) {
        }

        @Override // cj.mobile.listener.CJNativeExpressListener
        public void onClose(View view) {
        }

        @Override // cj.mobile.listener.CJNativeExpressListener
        public void onError(String str, String str2) {
        }

        @Override // cj.mobile.listener.CJNativeExpressListener
        public void onShow(View view) {
        }
    }

    public class b implements cj.mobile.p.h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CJNativeExpress f21653a;

        public b(CJNativeExpress cJNativeExpress) {
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
        public final /* synthetic */ String f21654a;
        public final /* synthetic */ boolean b;
        public final /* synthetic */ int c;
        public final /* synthetic */ String d;
        public final /* synthetic */ cj.mobile.p.h e;
        public final /* synthetic */ CJNativeExpress f;

        public c(CJNativeExpress cJNativeExpress, String str, boolean z, int i, String str2, cj.mobile.p.h hVar) {
        }

        @Override // java.lang.Runnable
        public void run() {
        }
    }

    public class d implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f21655a;
        public final /* synthetic */ boolean b;
        public final /* synthetic */ int c;
        public final /* synthetic */ cj.mobile.p.h d;
        public final /* synthetic */ CJNativeExpress e;

        public d(CJNativeExpress cJNativeExpress, String str, boolean z, int i, cj.mobile.p.h hVar) {
        }

        @Override // java.lang.Runnable
        public void run() {
        }
    }

    public class e implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f21656a;
        public final /* synthetic */ boolean b;
        public final /* synthetic */ int c;
        public final /* synthetic */ cj.mobile.p.h d;
        public final /* synthetic */ CJNativeExpress e;

        public e(CJNativeExpress cJNativeExpress, String str, boolean z, int i, cj.mobile.p.h hVar) {
        }

        @Override // java.lang.Runnable
        public void run() {
        }
    }

    public class f implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f21657a;
        public final /* synthetic */ boolean b;
        public final /* synthetic */ int c;
        public final /* synthetic */ cj.mobile.p.h d;
        public final /* synthetic */ CJNativeExpress e;

        public f(CJNativeExpress cJNativeExpress, String str, boolean z, int i, cj.mobile.p.h hVar) {
        }

        @Override // java.lang.Runnable
        public void run() {
        }
    }

    public class g implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f21658a;
        public final /* synthetic */ boolean b;
        public final /* synthetic */ int c;
        public final /* synthetic */ cj.mobile.p.h d;
        public final /* synthetic */ CJNativeExpress e;

        public g(CJNativeExpress cJNativeExpress, String str, boolean z, int i, cj.mobile.p.h hVar) {
        }

        @Override // java.lang.Runnable
        public void run() {
        }
    }

    public class h implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f21659a;
        public final /* synthetic */ boolean b;
        public final /* synthetic */ int c;
        public final /* synthetic */ cj.mobile.p.h d;
        public final /* synthetic */ CJNativeExpress e;

        public h(CJNativeExpress cJNativeExpress, String str, boolean z, int i, cj.mobile.p.h hVar) {
        }

        @Override // java.lang.Runnable
        public void run() {
        }
    }

    public class i implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f21660a;
        public final /* synthetic */ boolean b;
        public final /* synthetic */ int c;
        public final /* synthetic */ cj.mobile.p.h d;
        public final /* synthetic */ CJNativeExpress e;

        public i(CJNativeExpress cJNativeExpress, String str, boolean z, int i, cj.mobile.p.h hVar) {
        }

        @Override // java.lang.Runnable
        public void run() {
        }
    }

    public class j implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f21661a;
        public final /* synthetic */ boolean b;
        public final /* synthetic */ int c;
        public final /* synthetic */ cj.mobile.p.h d;
        public final /* synthetic */ CJNativeExpress e;

        public j(CJNativeExpress cJNativeExpress, String str, boolean z, int i, cj.mobile.p.h hVar) {
        }

        @Override // java.lang.Runnable
        public void run() {
        }
    }

    public class k implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f21662a;
        public final /* synthetic */ boolean b;
        public final /* synthetic */ int c;
        public final /* synthetic */ cj.mobile.p.h d;
        public final /* synthetic */ CJNativeExpress e;

        public k(CJNativeExpress cJNativeExpress, String str, boolean z, int i, cj.mobile.p.h hVar) {
        }

        @Override // java.lang.Runnable
        public void run() {
        }
    }

    public class l implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f21663a;
        public final /* synthetic */ boolean b;
        public final /* synthetic */ int c;
        public final /* synthetic */ cj.mobile.p.h d;
        public final /* synthetic */ CJNativeExpress e;

        public l(CJNativeExpress cJNativeExpress, String str, boolean z, int i, cj.mobile.p.h hVar) {
        }

        @Override // java.lang.Runnable
        public void run() {
        }
    }

    public class m implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f21664a;
        public final /* synthetic */ boolean b;
        public final /* synthetic */ int c;
        public final /* synthetic */ cj.mobile.p.h d;
        public final /* synthetic */ CJNativeExpress e;

        public m(CJNativeExpress cJNativeExpress, String str, boolean z, int i, cj.mobile.p.h hVar) {
        }

        @Override // java.lang.Runnable
        public void run() {
        }
    }

    public class n implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f21665a;
        public final /* synthetic */ boolean b;
        public final /* synthetic */ int c;
        public final /* synthetic */ cj.mobile.p.h d;
        public final /* synthetic */ CJNativeExpress e;

        public n(CJNativeExpress cJNativeExpress, String str, boolean z, int i, cj.mobile.p.h hVar) {
        }

        @Override // java.lang.Runnable
        public void run() {
        }
    }

    public class o implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f21666a;
        public final /* synthetic */ boolean b;
        public final /* synthetic */ String c;
        public final /* synthetic */ int d;
        public final /* synthetic */ cj.mobile.p.h e;
        public final /* synthetic */ CJNativeExpress f;

        public o(CJNativeExpress cJNativeExpress, String str, boolean z, String str2, int i, cj.mobile.p.h hVar) {
        }

        @Override // java.lang.Runnable
        public void run() {
        }
    }

    public class p implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f21667a;
        public final /* synthetic */ boolean b;
        public final /* synthetic */ int c;
        public final /* synthetic */ String d;
        public final /* synthetic */ cj.mobile.p.h e;
        public final /* synthetic */ CJNativeExpress f;

        public p(CJNativeExpress cJNativeExpress, String str, boolean z, int i, String str2, cj.mobile.p.h hVar) {
        }

        @Override // java.lang.Runnable
        public void run() {
        }
    }

    public class q implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f21668a;
        public final /* synthetic */ boolean b;
        public final /* synthetic */ int c;
        public final /* synthetic */ cj.mobile.p.h d;
        public final /* synthetic */ CJNativeExpress e;

        public q(CJNativeExpress cJNativeExpress, String str, boolean z, int i, cj.mobile.p.h hVar) {
        }

        @Override // java.lang.Runnable
        public void run() {
        }
    }

    public class r implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f21669a;
        public final /* synthetic */ boolean b;
        public final /* synthetic */ int c;
        public final /* synthetic */ cj.mobile.p.h d;
        public final /* synthetic */ CJNativeExpress e;

        public r(CJNativeExpress cJNativeExpress, String str, boolean z, int i, cj.mobile.p.h hVar) {
        }

        @Override // java.lang.Runnable
        public void run() {
        }
    }

    public class t implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CJNativeExpress f21671a;

        public t(CJNativeExpress cJNativeExpress) {
        }

        @Override // java.lang.Runnable
        public void run() {
        }
    }

    public class u implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CJNativeExpress f21672a;

        public u(CJNativeExpress cJNativeExpress) {
        }

        @Override // java.lang.Runnable
        public void run() {
        }
    }

    public class v implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CJNativeExpress f21673a;

        public v(CJNativeExpress cJNativeExpress) {
        }

        @Override // java.lang.Runnable
        public void run() {
        }
    }

    public class w implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CJNativeExpress f21674a;

        public w(CJNativeExpress cJNativeExpress) {
        }

        @Override // java.lang.Runnable
        public void run() {
        }
    }

    public class x implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CJNativeExpress f21675a;

        public x(CJNativeExpress cJNativeExpress) {
        }

        @Override // java.lang.Runnable
        public void run() {
        }
    }

    public class y implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CJNativeExpress f21676a;

        public y(CJNativeExpress cJNativeExpress) {
        }

        @Override // java.lang.Runnable
        public void run() {
        }
    }

    public class z implements cj.mobile.p.h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CJNativeExpress f21677a;

        public class a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ z f21678a;

            public a(z zVar) {
            }

            @Override // java.lang.Runnable
            public void run() {
            }
        }

        public z(CJNativeExpress cJNativeExpress) {
        }

        @Override // cj.mobile.p.h
        public void a(String str, String str2, int i) {
        }

        @Override // cj.mobile.p.h
        public void onError(String str, String str2) {
        }
    }

    public void biddingResult() {
    }

    public void destroy() {
    }

    public String getAdType() {
        return this.u;
    }

    public int getEcpm() {
    }

    public String getRequestId() {
        return this.c;
    }

    public void initData() {
    }

    public void loadAd(Context context, int i2, int i3, String str, CJNativeExpressListener cJNativeExpressListener) {
    }

    public final void f(String str, int i2, boolean z2, cj.mobile.p.h hVar) {
    }

    public final void g(String str, int i2, boolean z2, cj.mobile.p.h hVar) {
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

    public final void d() {
    }

    public final void e() {
    }

    public class s implements cj.mobile.p.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f21670a;
        public final /* synthetic */ CJNativeExpress b;

        public s(CJNativeExpress cJNativeExpress, Context context) {
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

    public final void c(String str, int i2, boolean z2, cj.mobile.p.h hVar) {
    }

    public final void d(String str, int i2, boolean z2, cj.mobile.p.h hVar) {
    }

    public final void e(String str, int i2, boolean z2, cj.mobile.p.h hVar) {
    }

    public final void b(String str, int i2, boolean z2, cj.mobile.p.h hVar) {
    }

    public final void c() {
    }

    public final void a(String str, String str2) {
    }

    public final void b(String str, int i2, String str2, boolean z2, cj.mobile.p.h hVar) {
    }

    public final void a() {
    }

    public final void a(boolean z2) {
    }

    public final void a(JSONArray jSONArray, int i2, int i3) {
    }

    public final void a(JSONArray jSONArray, int i2) {
    }

    public final void a(String str, int i2, boolean z2, String str2, cj.mobile.p.h hVar) {
    }

    public final void a(String str, int i2, boolean z2, cj.mobile.p.h hVar) {
    }

    public final void a(String str, int i2, String str2, boolean z2, cj.mobile.p.h hVar) {
    }

    public final void a(JSONArray jSONArray) {
    }
}
