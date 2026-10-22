package cj.mobile;

import android.content.Context;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import cj.mobile.a.r;
import cj.mobile.a.s;
import cj.mobile.constants.RenderAdInfo;
import cj.mobile.listener.CJMediaListener;
import cj.mobile.listener.CJRenderListener;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_13_8952cls.dex */
public class CJRenderNative {
    public Map<String, cj.mobile.a.c> A;
    public Map<String, s> B;
    public Map<String, cj.mobile.a.g> C;
    public boolean D;
    public boolean E;
    public boolean F;
    public int G;
    public int H;
    public int I;
    public int J;
    public long K;
    public int L;
    public boolean M;
    public Handler N;
    public RenderAdInfo O;
    public CJRenderListener P;
    public Runnable Q;
    public Runnable R;
    public Runnable S;
    public Runnable T;
    public Runnable U;
    public final cj.mobile.p.h V;
    public final cj.mobile.p.h W;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Context f21681a;
    public String b;
    public JSONArray c;
    public JSONArray d;
    public String e;
    public int f;
    public int g;
    public int h;
    public int i;
    public int j;
    public String k;
    public String l;
    public CJRenderListener m;
    public String n;
    public String o;
    public boolean p;
    public int q;
    public int r;
    public String s;
    public String t;
    public boolean u;
    public boolean v;
    public Map<String, r> w;
    public Map<String, cj.mobile.a.i> x;
    public Map<String, cj.mobile.a.l> y;
    public Map<String, cj.mobile.a.a> z;

    public class a implements CJRenderListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CJRenderNative f21682a;

        /* JADX INFO: renamed from: cj.mobile.CJRenderNative$a$a, reason: collision with other inner class name */
        public class RunnableC0041a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ String f21683a;
            public final /* synthetic */ String b;
            public final /* synthetic */ a c;

            public RunnableC0041a(a aVar, String str, String str2) {
            }

            @Override // java.lang.Runnable
            public void run() {
            }
        }

        public class b implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ a f21684a;

            public b(a aVar) {
            }

            @Override // java.lang.Runnable
            public void run() {
            }
        }

        public class c implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ a f21685a;

            public c(a aVar) {
            }

            @Override // java.lang.Runnable
            public void run() {
            }
        }

        public class d implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ a f21686a;

            public d(a aVar) {
            }

            @Override // java.lang.Runnable
            public void run() {
            }
        }

        public a(CJRenderNative cJRenderNative) {
        }

        @Override // cj.mobile.listener.CJRenderListener
        public void onClick() {
        }

        @Override // cj.mobile.listener.CJRenderListener
        public void onError(String str, String str2) {
        }

        @Override // cj.mobile.listener.CJRenderListener
        public void onLoad() {
        }

        @Override // cj.mobile.listener.CJRenderListener
        public void onShow() {
        }
    }

    public class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CJRenderNative f21687a;

        public b(CJRenderNative cJRenderNative) {
        }

        @Override // java.lang.Runnable
        public void run() {
        }
    }

    public class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f21688a;
        public final /* synthetic */ boolean b;
        public final /* synthetic */ int c;
        public final /* synthetic */ cj.mobile.p.h d;
        public final /* synthetic */ CJRenderNative e;

        public c(CJRenderNative cJRenderNative, String str, boolean z, int i, cj.mobile.p.h hVar) {
        }

        @Override // java.lang.Runnable
        public void run() {
        }
    }

    public class d implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f21689a;
        public final /* synthetic */ boolean b;
        public final /* synthetic */ int c;
        public final /* synthetic */ cj.mobile.p.h d;
        public final /* synthetic */ CJRenderNative e;

        public d(CJRenderNative cJRenderNative, String str, boolean z, int i, cj.mobile.p.h hVar) {
        }

        @Override // java.lang.Runnable
        public void run() {
        }
    }

    public class e implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f21690a;
        public final /* synthetic */ boolean b;
        public final /* synthetic */ int c;
        public final /* synthetic */ cj.mobile.p.h d;
        public final /* synthetic */ CJRenderNative e;

        public e(CJRenderNative cJRenderNative, String str, boolean z, int i, cj.mobile.p.h hVar) {
        }

        @Override // java.lang.Runnable
        public void run() {
        }
    }

    public class f implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f21691a;
        public final /* synthetic */ boolean b;
        public final /* synthetic */ int c;
        public final /* synthetic */ cj.mobile.p.h d;
        public final /* synthetic */ CJRenderNative e;

        public f(CJRenderNative cJRenderNative, String str, boolean z, int i, cj.mobile.p.h hVar) {
        }

        @Override // java.lang.Runnable
        public void run() {
        }
    }

    public class g implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f21692a;
        public final /* synthetic */ boolean b;
        public final /* synthetic */ int c;
        public final /* synthetic */ cj.mobile.p.h d;
        public final /* synthetic */ CJRenderNative e;

        public g(CJRenderNative cJRenderNative, String str, boolean z, int i, cj.mobile.p.h hVar) {
        }

        @Override // java.lang.Runnable
        public void run() {
        }
    }

    public class h implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f21693a;
        public final /* synthetic */ boolean b;
        public final /* synthetic */ int c;
        public final /* synthetic */ cj.mobile.p.h d;
        public final /* synthetic */ CJRenderNative e;

        public h(CJRenderNative cJRenderNative, String str, boolean z, int i, cj.mobile.p.h hVar) {
        }

        @Override // java.lang.Runnable
        public void run() {
        }
    }

    public class i implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f21694a;
        public final /* synthetic */ boolean b;
        public final /* synthetic */ String c;
        public final /* synthetic */ int d;
        public final /* synthetic */ cj.mobile.p.h e;
        public final /* synthetic */ CJRenderNative f;

        public i(CJRenderNative cJRenderNative, String str, boolean z, String str2, int i, cj.mobile.p.h hVar) {
        }

        @Override // java.lang.Runnable
        public void run() {
        }
    }

    public class k implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CJRenderNative f21696a;

        public k(CJRenderNative cJRenderNative) {
        }

        @Override // java.lang.Runnable
        public void run() {
        }
    }

    public class l implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CJRenderNative f21697a;

        public l(CJRenderNative cJRenderNative) {
        }

        @Override // java.lang.Runnable
        public void run() {
        }
    }

    public class m implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CJRenderNative f21698a;

        public m(CJRenderNative cJRenderNative) {
        }

        @Override // java.lang.Runnable
        public void run() {
        }
    }

    public class n implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CJRenderNative f21699a;

        public n(CJRenderNative cJRenderNative) {
        }

        @Override // java.lang.Runnable
        public void run() {
        }
    }

    public class o implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CJRenderNative f21700a;

        public o(CJRenderNative cJRenderNative) {
        }

        @Override // java.lang.Runnable
        public void run() {
        }
    }

    public class p implements cj.mobile.p.h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CJRenderNative f21701a;

        public class a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ p f21702a;

            public a(p pVar) {
            }

            @Override // java.lang.Runnable
            public void run() {
            }
        }

        public p(CJRenderNative cJRenderNative) {
        }

        @Override // cj.mobile.p.h
        public void a(String str, String str2, int i) {
        }

        @Override // cj.mobile.p.h
        public void onError(String str, String str2) {
        }
    }

    public class q implements cj.mobile.p.h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CJRenderNative f21703a;

        public q(CJRenderNative cJRenderNative) {
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

    public void bindMediaView(Context context, ViewGroup viewGroup, CJMediaListener cJMediaListener) {
    }

    public void destroy() {
    }

    public int getEcpm() {
    }

    public String getLoadSuccessType() {
        return this.n;
    }

    public RenderAdInfo getRenderAdInfo() {
    }

    public String getRequestId() {
        return this.e;
    }

    public void initData() {
    }

    public void loadAd(Context context, String str, CJRenderListener cJRenderListener) {
    }

    public CJRenderNative setVideoSound(boolean z) {
        return this;
    }

    public View transformView(Context context, ViewGroup viewGroup, List<View> list) {
    }

    public final void d() {
    }

    public final void e(String str, int i2, boolean z, cj.mobile.p.h hVar) {
    }

    public final void f(String str, int i2, boolean z, cj.mobile.p.h hVar) {
    }

    public class j implements cj.mobile.p.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f21695a;
        public final /* synthetic */ CJRenderNative b;

        public j(CJRenderNative cJRenderNative, Context context) {
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

    public final void d(String str, int i2, boolean z, cj.mobile.p.h hVar) {
    }

    public final void b(String str, int i2, boolean z, cj.mobile.p.h hVar) {
    }

    public final void c(String str, int i2, boolean z, cj.mobile.p.h hVar) {
    }

    public final void a(String str, String str2) {
    }

    public final void a() {
    }

    public final void a(boolean z) {
    }

    public final void a(JSONArray jSONArray, int i2, int i3) {
    }

    public final void a(JSONArray jSONArray, int i2) {
    }

    public final void a(String str, int i2, boolean z, cj.mobile.p.h hVar) {
    }

    public final void a(String str, String str2, int i2, boolean z, cj.mobile.p.h hVar) {
    }
}
