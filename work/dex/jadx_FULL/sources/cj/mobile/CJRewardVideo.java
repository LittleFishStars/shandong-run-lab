package cj.mobile;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import androidx.annotation.NonNull;
import cj.mobile.listener.CJRewardListener;
import java.io.IOException;
import java.util.HashMap;
import org.json.JSONArray;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_13_8952cls.dex */
public class CJRewardVideo {
    public static CJRewardVideo o0;
    public HashMap<String, cj.mobile.a.i> A;
    public HashMap<String, cj.mobile.a.m> B;
    public cj.mobile.a.n C;
    public HashMap<String, cj.mobile.a.a> D;
    public HashMap<String, cj.mobile.a.l> E;
    public HashMap<String, cj.mobile.a.q> F;
    public HashMap<String, cj.mobile.a.j> G;
    public HashMap<String, cj.mobile.a.h> H;
    public HashMap<String, cj.mobile.a.s> I;
    public HashMap<String, cj.mobile.a.e> J;
    public HashMap<String, cj.mobile.a.c> K;
    public HashMap<String, cj.mobile.a.k> L;
    public String M;
    public String N;
    public boolean O;
    public int P;
    public int Q;
    public String R;
    public String S;
    public boolean T;
    public String U;
    public int V;
    public boolean W;
    public boolean X;
    public boolean Y;
    public long Z;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public JSONArray f21704a;
    public int a0;
    public JSONArray b;
    public boolean b0;
    public String c;
    public int c0;
    public int d;
    public int d0;
    public String e;
    public Handler e0;
    public String f;
    public Handler f0;
    public boolean g;
    public Runnable g0;
    public boolean h;
    public Runnable h0;
    public int i;
    public Runnable i0;
    public int j;
    public Runnable j0;
    public int k;
    public Runnable k0;
    public int l;
    public Runnable l0;
    public boolean m;
    public final cj.mobile.p.h m0;
    public int n;
    public final cj.mobile.p.h n0;
    public int o;
    public boolean p;
    public boolean q;
    public Context r;
    public CJRewardListener s;
    public CJRewardListener t;
    public String u;
    public String v;
    public String w;
    public boolean x;
    public HashMap<String, cj.mobile.a.r> y;
    public HashMap<String, cj.mobile.a.p> z;

    public class a implements CJRewardListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CJRewardVideo f21705a;

        /* JADX INFO: renamed from: cj.mobile.CJRewardVideo$a$a, reason: collision with other inner class name */
        public class RunnableC0042a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ a f21706a;

            public RunnableC0042a(a aVar) {
            }

            @Override // java.lang.Runnable
            public void run() {
            }
        }

        public class b implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ String f21707a;
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
            public final /* synthetic */ a f21708a;

            public c(a aVar) {
            }

            @Override // java.lang.Runnable
            public void run() {
            }
        }

        public class d implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ a f21709a;

            public d(a aVar) {
            }

            @Override // java.lang.Runnable
            public void run() {
            }
        }

        public class e implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ a f21710a;

            public e(a aVar) {
            }

            @Override // java.lang.Runnable
            public void run() {
            }
        }

        public class f implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ a f21711a;

            public f(a aVar) {
            }

            @Override // java.lang.Runnable
            public void run() {
            }
        }

        public class g implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ a f21712a;

            public g(a aVar) {
            }

            @Override // java.lang.Runnable
            public void run() {
            }
        }

        public class h implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ String f21713a;
            public final /* synthetic */ a b;

            public h(a aVar, String str) {
            }

            @Override // java.lang.Runnable
            public void run() {
            }
        }

        public a(CJRewardVideo cJRewardVideo) {
        }

        @Override // cj.mobile.listener.CJRewardListener
        public void onClick() {
        }

        @Override // cj.mobile.listener.CJRewardListener
        public void onClose() {
        }

        @Override // cj.mobile.listener.CJRewardListener
        public void onError(String str, String str2) {
        }

        @Override // cj.mobile.listener.CJRewardListener
        public void onLoad() {
        }

        @Override // cj.mobile.listener.CJRewardListener
        public void onReward(String str) {
        }

        @Override // cj.mobile.listener.CJRewardListener
        public void onShow() {
        }

        @Override // cj.mobile.listener.CJRewardListener
        public void onVideoEnd() {
        }

        @Override // cj.mobile.listener.CJRewardListener
        public void onVideoStart() {
        }
    }

    public class b implements cj.mobile.p.h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CJRewardVideo f21714a;

        public class a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ b f21715a;

            public a(b bVar) {
            }

            @Override // java.lang.Runnable
            public void run() {
            }
        }

        public b(CJRewardVideo cJRewardVideo) {
        }

        @Override // cj.mobile.p.h
        public void a(String str, String str2, int i) {
        }

        @Override // cj.mobile.p.h
        public void onError(String str, String str2) {
        }
    }

    public class c implements cj.mobile.p.h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CJRewardVideo f21716a;

        public c(CJRewardVideo cJRewardVideo) {
        }

        @Override // cj.mobile.p.h
        public void a(String str, String str2, int i) {
        }

        @Override // cj.mobile.p.h
        public void onError(String str, String str2) {
        }
    }

    public class d implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CJRewardVideo f21717a;

        public d(CJRewardVideo cJRewardVideo) {
        }

        @Override // java.lang.Runnable
        public void run() {
        }
    }

    public class e implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f21718a;
        public final /* synthetic */ boolean b;
        public final /* synthetic */ int c;
        public final /* synthetic */ cj.mobile.p.h d;
        public final /* synthetic */ CJRewardVideo e;

        public e(CJRewardVideo cJRewardVideo, String str, boolean z, int i, cj.mobile.p.h hVar) {
        }

        @Override // java.lang.Runnable
        public void run() {
        }
    }

    public class f implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f21719a;
        public final /* synthetic */ boolean b;
        public final /* synthetic */ int c;
        public final /* synthetic */ cj.mobile.p.h d;
        public final /* synthetic */ CJRewardVideo e;

        public f(CJRewardVideo cJRewardVideo, String str, boolean z, int i, cj.mobile.p.h hVar) {
        }

        @Override // java.lang.Runnable
        public void run() {
        }
    }

    public class g implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f21720a;
        public final /* synthetic */ boolean b;
        public final /* synthetic */ int c;
        public final /* synthetic */ cj.mobile.p.h d;
        public final /* synthetic */ CJRewardVideo e;

        public g(CJRewardVideo cJRewardVideo, String str, boolean z, int i, cj.mobile.p.h hVar) {
        }

        @Override // java.lang.Runnable
        public void run() {
        }
    }

    public class h implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f21721a;
        public final /* synthetic */ boolean b;
        public final /* synthetic */ int c;
        public final /* synthetic */ cj.mobile.p.h d;
        public final /* synthetic */ CJRewardVideo e;

        public h(CJRewardVideo cJRewardVideo, String str, boolean z, int i, cj.mobile.p.h hVar) {
        }

        @Override // java.lang.Runnable
        public void run() {
        }
    }

    public class i implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f21722a;
        public final /* synthetic */ boolean b;
        public final /* synthetic */ int c;
        public final /* synthetic */ cj.mobile.p.h d;
        public final /* synthetic */ CJRewardVideo e;

        public i(CJRewardVideo cJRewardVideo, String str, boolean z, int i, cj.mobile.p.h hVar) {
        }

        @Override // java.lang.Runnable
        public void run() {
        }
    }

    public class j implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f21723a;
        public final /* synthetic */ boolean b;
        public final /* synthetic */ int c;
        public final /* synthetic */ cj.mobile.p.h d;
        public final /* synthetic */ CJRewardVideo e;

        public j(CJRewardVideo cJRewardVideo, String str, boolean z, int i, cj.mobile.p.h hVar) {
        }

        @Override // java.lang.Runnable
        public void run() {
        }
    }

    public class k implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f21724a;
        public final /* synthetic */ boolean b;
        public final /* synthetic */ int c;
        public final /* synthetic */ cj.mobile.p.h d;
        public final /* synthetic */ CJRewardVideo e;

        public k(CJRewardVideo cJRewardVideo, String str, boolean z, int i, cj.mobile.p.h hVar) {
        }

        @Override // java.lang.Runnable
        public void run() {
        }
    }

    public class l implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f21725a;
        public final /* synthetic */ boolean b;
        public final /* synthetic */ int c;
        public final /* synthetic */ cj.mobile.p.h d;
        public final /* synthetic */ CJRewardVideo e;

        public l(CJRewardVideo cJRewardVideo, String str, boolean z, int i, cj.mobile.p.h hVar) {
        }

        @Override // java.lang.Runnable
        public void run() {
        }
    }

    public class m implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f21726a;
        public final /* synthetic */ boolean b;
        public final /* synthetic */ String c;
        public final /* synthetic */ int d;
        public final /* synthetic */ cj.mobile.p.h e;
        public final /* synthetic */ CJRewardVideo f;

        public m(CJRewardVideo cJRewardVideo, String str, boolean z, String str2, int i, cj.mobile.p.h hVar) {
        }

        @Override // java.lang.Runnable
        public void run() {
        }
    }

    public class n implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f21727a;
        public final /* synthetic */ cj.mobile.p.h b;
        public final /* synthetic */ CJRewardVideo c;

        public n(CJRewardVideo cJRewardVideo, int i, cj.mobile.p.h hVar) {
        }

        @Override // java.lang.Runnable
        public void run() {
        }
    }

    public class o implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f21728a;
        public final /* synthetic */ boolean b;
        public final /* synthetic */ int c;
        public final /* synthetic */ cj.mobile.p.h d;
        public final /* synthetic */ CJRewardVideo e;

        public o(CJRewardVideo cJRewardVideo, String str, boolean z, int i, cj.mobile.p.h hVar) {
        }

        @Override // java.lang.Runnable
        public void run() {
        }
    }

    public class p implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f21729a;
        public final /* synthetic */ boolean b;
        public final /* synthetic */ String c;
        public final /* synthetic */ int d;
        public final /* synthetic */ cj.mobile.p.h e;
        public final /* synthetic */ CJRewardVideo f;

        public p(CJRewardVideo cJRewardVideo, String str, boolean z, String str2, int i, cj.mobile.p.h hVar) {
        }

        @Override // java.lang.Runnable
        public void run() {
        }
    }

    public class q implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f21730a;
        public final /* synthetic */ boolean b;
        public final /* synthetic */ int c;
        public final /* synthetic */ cj.mobile.p.h d;
        public final /* synthetic */ CJRewardVideo e;

        public q(CJRewardVideo cJRewardVideo, String str, boolean z, int i, cj.mobile.p.h hVar) {
        }

        @Override // java.lang.Runnable
        public void run() {
        }
    }

    public class r implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f21731a;
        public final /* synthetic */ boolean b;
        public final /* synthetic */ int c;
        public final /* synthetic */ cj.mobile.p.h d;
        public final /* synthetic */ CJRewardVideo e;

        public r(CJRewardVideo cJRewardVideo, String str, boolean z, int i, cj.mobile.p.h hVar) {
        }

        @Override // java.lang.Runnable
        public void run() {
        }
    }

    public class s extends Handler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CJRewardVideo f21732a;

        public s(CJRewardVideo cJRewardVideo, Looper looper) {
        }

        @Override // android.os.Handler
        public void handleMessage(@NonNull Message message) {
        }
    }

    public class u implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CJRewardVideo f21734a;

        public u(CJRewardVideo cJRewardVideo) {
        }

        @Override // java.lang.Runnable
        public void run() {
        }
    }

    public class v implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CJRewardVideo f21735a;

        public v(CJRewardVideo cJRewardVideo) {
        }

        @Override // java.lang.Runnable
        public void run() {
        }
    }

    public class w implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CJRewardVideo f21736a;

        public w(CJRewardVideo cJRewardVideo) {
        }

        @Override // java.lang.Runnable
        public void run() {
        }
    }

    public class x implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CJRewardVideo f21737a;

        public x(CJRewardVideo cJRewardVideo) {
        }

        @Override // java.lang.Runnable
        public void run() {
        }
    }

    public class y implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CJRewardVideo f21738a;

        public y(CJRewardVideo cJRewardVideo) {
        }

        @Override // java.lang.Runnable
        public void run() {
        }
    }

    public class z implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CJRewardVideo f21739a;

        public z(CJRewardVideo cJRewardVideo) {
        }

        @Override // java.lang.Runnable
        public void run() {
        }
    }

    public static CJRewardVideo getInstance() {
    }

    public void biddingResult() {
    }

    public void destroy() {
    }

    public String getAdType() {
        return this.U;
    }

    public int getEcpm() {
    }

    public String getRequestId() {
        return this.c;
    }

    public void initData() {
    }

    public boolean isLoading() {
        return this.Y;
    }

    public boolean isValid() {
    }

    public void loadAd(String str) {
    }

    public CJRewardVideo setCjPosId(String str) {
        this.u = str;
        return this;
    }

    public CJRewardVideo setExtend(String str) {
        this.w = str;
        return this;
    }

    public CJRewardVideo setIsPreLoad(boolean z2) {
        this.p = z2;
        return this;
    }

    public CJRewardVideo setIsServiceShow(boolean z2) {
        this.x = z2;
        return this;
    }

    public CJRewardVideo setIsVideoSound(boolean z2) {
        this.q = z2;
        return this;
    }

    public CJRewardVideo setListener(CJRewardListener cJRewardListener) {
        this.t = cJRewardListener;
        return this;
    }

    public CJRewardVideo setMainActivity(Context context) {
        this.r = context;
        return this;
    }

    public CJRewardVideo setUserId(String str) {
        this.v = str;
        return this;
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

    public final void d() {
    }

    public final void e(String str, int i2, boolean z2, cj.mobile.p.h hVar) {
    }

    public final void f(String str, int i2, boolean z2, cj.mobile.p.h hVar) {
    }

    public final void g(String str, int i2, boolean z2, cj.mobile.p.h hVar) {
    }

    public class t implements cj.mobile.p.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CJRewardVideo f21733a;

        public t(CJRewardVideo cJRewardVideo) {
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

    public final void b(String str, int i2, String str2, boolean z2, cj.mobile.p.h hVar) {
    }

    public final void a(String str, String str2) {
    }

    public final void a() {
    }

    public final void a(boolean z2) {
    }

    public final void a(JSONArray jSONArray, int i2, int i3) {
    }

    public final void a(JSONArray jSONArray, int i2) {
    }

    public final void a(String str, int i2, boolean z2, cj.mobile.p.h hVar) {
    }

    public final void a(String str, int i2, String str2, boolean z2, cj.mobile.p.h hVar) {
    }

    public final void a(int i2, cj.mobile.p.h hVar) {
    }

    public final void a(String str) {
    }

    public final void a(JSONArray jSONArray, String str) {
    }
}
