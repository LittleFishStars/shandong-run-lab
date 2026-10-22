package com.beizi.fusion;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.camera.video.AudioStats;
import com.beizi.fusion.events.EventBean;
import com.beizi.fusion.model.AdSpacesBean;
import com.beizi.fusion.widget.BZVideoView;
import com.beizi.fusion.work.splash.SplashContainer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class g4 extends d2 implements a2 {
    private long A0;
    private int B0;
    private int C0;
    private FrameLayout D0;
    private boolean E0;
    private long G0;
    private String H0;
    private boolean I0;
    private boolean J0;
    private boolean L0;
    private boolean M0;
    private ViewGroup N0;
    private FrameLayout O0;
    private long P0;
    private AdSpacesBean.ComplainBean Q0;
    private boolean R0;
    private long S0;
    private Context U;
    private String V;
    private BZVideoView V0;
    private long W;
    private boolean W0;
    private long X;
    private boolean X0;
    private float Y;
    private boolean Y0;
    private float Z;
    private boolean Z0;
    private gi a0;
    private boolean a1;
    private ViewGroup b0;
    private View c0;
    private List d0;
    private AdSpacesBean.RenderViewBean e0;
    private List f0;
    private AdSpacesBean.BuyerBean.ShakeViewBean g0;
    private AdSpacesBean.BuyerBean.CoolShakeViewBean h0;
    private ri i0;
    private AdSpacesBean.BuyerBean.DislikeConfigBean l0;
    private AdSpacesBean.BuyerBean.DislikeConfigBean m0;
    private mi s0;
    private Boolean u0;
    private long v0;
    private int w0;
    private int x0;
    private boolean y0;
    private boolean z0;
    private String j0 = null;
    private boolean k0 = false;
    private float n0 = 0.0f;
    private float o0 = 0.0f;
    private float p0 = 0.0f;
    private float q0 = 0.0f;
    private String r0 = null;
    private String t0 = null;
    private String[] F0 = new String[4];
    private String K0 = "#00000000";
    private ViewTreeObserver.OnScrollChangedListener T0 = new d();
    private ViewTreeObserver.OnScrollChangedListener U0 = new f();

    public class a implements e7.c {
        public a() {
        }

        @Override // com.beizi.fusion.e7.c
        public void a() {
            try {
                if (g4.this.d != null && g4.this.d.z() != 2) {
                    g4.this.d.a(g4.this.x(), g4.this.c0);
                }
                g4.this.b0();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public class b implements ji {
        public b() {
        }

        @Override // com.beizi.fusion.ji
        public void a() {
            g4.this.T0();
        }

        @Override // com.beizi.fusion.ji
        public void b() {
        }
    }

    public class c implements View.OnTouchListener {
        public c() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (motionEvent.getAction() == 0) {
                g4 g4Var = g4.this;
                g4Var.E0 = true;
                g4Var.F0[0] = motionEvent.getX() + "";
                g4.this.F0[1] = motionEvent.getY() + "";
                g4.this.F0[2] = motionEvent.getRawX() + "";
                g4.this.F0[3] = motionEvent.getRawY() + "";
            }
            return false;
        }
    }

    public class d implements ViewTreeObserver.OnScrollChangedListener {
        public d() {
        }

        @Override // android.view.ViewTreeObserver.OnScrollChangedListener
        public void onScrollChanged() {
            try {
                g4 g4Var = g4.this;
                if (g4Var.E0 && !g4Var.y0 && !g4Var.I0) {
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    g4 g4Var2 = g4.this;
                    if (jCurrentTimeMillis - g4Var2.G0 < g4Var2.A0) {
                        return;
                    }
                    long jCurrentTimeMillis2 = System.currentTimeMillis();
                    g4 g4Var3 = g4.this;
                    if (jCurrentTimeMillis2 - g4Var3.v0 < 50) {
                        return;
                    }
                    g4Var3.v0 = System.currentTimeMillis();
                    if (yp.a(g4.this.c0, 0.8d)) {
                        int[] iArr = new int[2];
                        View view = g4.this.c0;
                        if (view != null) {
                            view.getLocationOnScreen(iArr);
                        }
                        int i = iArr[1];
                        if (i > 0) {
                            g4 g4Var4 = g4.this;
                            if (g4Var4.C0 == 0) {
                                g4Var4.C0 = i;
                            }
                        }
                        int iAbs = Math.abs(g4.this.C0 - i);
                        g4 g4Var5 = g4.this;
                        if (iAbs < g4Var5.B0) {
                            return;
                        }
                        g4Var5.a(g4Var5.F0, 0);
                    }
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public class e implements View.OnTouchListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ float[] f27317a;

        public e(float[] fArr) {
            this.f27317a = fArr;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            try {
                if (motionEvent.getAction() == 0) {
                    this.f27317a[0] = motionEvent.getX();
                    this.f27317a[1] = motionEvent.getY();
                    this.f27317a[2] = motionEvent.getRawX();
                    this.f27317a[3] = motionEvent.getRawY();
                    g4 g4Var = g4.this;
                    if (g4Var.L0) {
                        FrameLayout frameLayout = g4Var.O0;
                        ViewGroup viewGroup = g4Var.b0;
                        float[] fArr = this.f27317a;
                        g4.this.a(g4Var.a(frameLayout, viewGroup, fArr[0], fArr[1], fArr[2], fArr[3]), 0);
                    }
                }
                if (motionEvent.getAction() == 1) {
                    g4 g4Var2 = g4.this;
                    if (g4Var2.M0) {
                        FrameLayout frameLayout2 = g4Var2.O0;
                        ViewGroup viewGroup2 = g4Var2.b0;
                        float[] fArr2 = this.f27317a;
                        g4.this.a(g4Var2.a(frameLayout2, viewGroup2, fArr2[0], fArr2[1], fArr2[2], fArr2[3]), 0);
                    }
                }
                g4 g4Var3 = g4.this;
                return g4Var3.L0 || g4Var3.M0;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public class f implements ViewTreeObserver.OnScrollChangedListener {
        public f() {
        }

        @Override // android.view.ViewTreeObserver.OnScrollChangedListener
        public void onScrollChanged() {
            ViewGroup viewGroup;
            try {
                if (g4.this.b0 == null) {
                    return;
                }
                long jCurrentTimeMillis = System.currentTimeMillis();
                g4 g4Var = g4.this;
                if (jCurrentTimeMillis - g4Var.P0 < 100) {
                    return;
                }
                g4Var.P0 = System.currentTimeMillis();
                int[] iArr = new int[2];
                g4.this.b0.getLocationOnScreen(iArr);
                if (iArr[1] < 0) {
                    g4.this.b0.getViewTreeObserver().removeOnScrollChangedListener(this);
                    g4 g4Var2 = g4.this;
                    FrameLayout frameLayout = g4Var2.O0;
                    if (frameLayout == null || (viewGroup = g4Var2.N0) == null) {
                        return;
                    }
                    viewGroup.removeView(frameLayout);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public class g implements View.OnTouchListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        String[] f27319a = new String[4];

        public g() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            ViewGroup viewGroup;
            ViewParent parent;
            try {
                if (motionEvent.getAction() == 0) {
                    g4 g4Var = g4.this;
                    if ((g4Var.L0 || g4Var.M0) && (viewGroup = g4Var.b0) != null && (parent = viewGroup.getParent()) != null) {
                        parent.requestDisallowInterceptTouchEvent(true);
                    }
                    this.f27319a[0] = motionEvent.getX() + "";
                    this.f27319a[1] = motionEvent.getY() + "";
                    this.f27319a[2] = motionEvent.getRawX() + "";
                    this.f27319a[3] = motionEvent.getRawY() + "";
                    g4 g4Var2 = g4.this;
                    if (g4Var2.L0) {
                        g4Var2.a(this.f27319a);
                    }
                }
                if (motionEvent.getAction() == 1) {
                    g4 g4Var3 = g4.this;
                    if (g4Var3.M0) {
                        g4Var3.a(this.f27319a);
                    }
                }
                g4 g4Var4 = g4.this;
                return g4Var4.L0 || g4Var4.M0;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public class h implements ji {
        public h() {
        }

        @Override // com.beizi.fusion.ji
        public void a() {
            g4.this.T0();
        }

        @Override // com.beizi.fusion.ji
        public void b() {
        }
    }

    public class i implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Bitmap f27321a;
        final /* synthetic */ ImageView b;

        public class a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ BitmapDrawable f27322a;

            public a(BitmapDrawable bitmapDrawable) {
                this.f27322a = bitmapDrawable;
            }

            @Override // java.lang.Runnable
            public void run() {
                ImageView imageView;
                try {
                    BitmapDrawable bitmapDrawable = this.f27322a;
                    if (bitmapDrawable == null || (imageView = i.this.b) == null) {
                        return;
                    }
                    imageView.setBackground(bitmapDrawable);
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        }

        public i(Bitmap bitmap, ImageView imageView) {
            this.f27321a = bitmap;
            this.b = imageView;
        }

        @Override // java.lang.Runnable
        public void run() {
            Bitmap bitmap;
            try {
                Context context = g4.this.U;
                if (context == null || (bitmap = this.f27321a) == null) {
                    return;
                }
                BitmapDrawable bitmapDrawable = new BitmapDrawable(pf.a(context, bitmap, 20.0f));
                if (g4.this.L != null) {
                    g4.this.L.post(new a(bitmapDrawable));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public class j implements Runnable {
        public j() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                if (yp.a(g4.this.b0)) {
                    g4 g4Var = g4.this;
                    if (g4Var.y0) {
                        return;
                    }
                    g4Var.G = 2;
                    g4 g4Var2 = g4.this;
                    mi miVar = g4Var2.s0;
                    if (miVar != null) {
                        miVar.a(g4Var2.G);
                    }
                    g4.this.U0();
                    g4.this.B0();
                    g4 g4Var3 = g4.this;
                    mi miVar2 = g4Var3.s0;
                    if (miVar2 != null) {
                        miVar2.a(g4Var3.G);
                    }
                }
            } catch (Exception unused) {
            }
        }
    }

    public class k implements ki {
        public k() {
        }

        @Override // com.beizi.fusion.ki
        public void a(mi miVar) {
            Log.d("BeiZis", "showBeiZiNativeAd onAdLoaded()");
            g4.this.j = b2.ADLOAD;
            g4 g4Var = g4.this;
            g4Var.s0 = miVar;
            g4Var.u0 = Boolean.valueOf(g4Var.a0.s());
            g4 g4Var2 = g4.this;
            g4Var2.R0 = g4Var2.a0.u();
            g4 g4Var3 = g4.this;
            gi giVar = g4Var3.a0;
            if (giVar != null) {
                g4Var3.E = giVar.i();
                if (g4.this.E != null) {
                    g4 g4Var4 = g4.this;
                    g4Var4.F = g4Var4.E.c();
                    if (g4.this.F != 0) {
                        g4 g4Var5 = g4.this;
                        g4Var5.G = g4Var5.E.e() + 1;
                    }
                }
                g4 g4Var6 = g4.this;
                g4Var6.H = g4Var6.a0.m();
            }
            g4 g4Var7 = g4.this;
            if (g4Var7.R0) {
                g4Var7.S0 = g4Var7.a0.f();
                g4.this.b.setIsCacheAd("1");
                if (g4.this.S0 > 0) {
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    g4 g4Var8 = g4.this;
                    g4Var8.b.setCacheTime(String.valueOf(jCurrentTimeMillis - g4Var8.S0));
                }
                g4.this.H0();
            }
            if (g4.this.a0.q() != null) {
                try {
                    g4 g4Var9 = g4.this;
                    g4Var9.a(Double.parseDouble(g4Var9.a0.q()));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            g4.this.f0();
            if (miVar == null) {
                g4.this.a(-991);
            } else {
                g4.this.f(miVar);
            }
        }

        @Override // com.beizi.fusion.ki
        public void onAdFailed(int i) {
            Log.d("BeiZis", "showBeiZiNativeAd onAdFailed: " + i);
            g4.this.a(String.valueOf(i), i);
        }
    }

    public class l implements BZVideoView.i {
        public l() {
        }

        @Override // com.beizi.fusion.widget.BZVideoView.i
        public void a(int i, int i2) {
            g4.this.a(i, i2);
        }

        @Override // com.beizi.fusion.widget.BZVideoView.i
        public void b() {
            g4 g4Var = g4.this;
            if (g4Var.W0) {
                return;
            }
            g4Var.W0 = true;
            g4Var.b(0);
        }

        @Override // com.beizi.fusion.widget.BZVideoView.i
        public void a() {
            g4 g4Var = g4.this;
            if (g4Var.a1) {
                return;
            }
            g4Var.a1 = true;
            g4Var.b(100);
        }
    }

    public class m implements Runnable {
        public m() {
        }

        @Override // java.lang.Runnable
        public void run() {
            g4 g4Var = g4.this;
            gi giVar = g4Var.a0;
            int optimizeSize = g4Var.e0.getOptimizeSize();
            g4 g4Var2 = g4.this;
            giVar.a(optimizeSize, g4Var2.V0, g4Var2.b0, g4Var2.e0.getDirection());
        }
    }

    public class n implements ji {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        boolean f27327a = false;

        public n() {
        }

        @Override // com.beizi.fusion.ji
        public void a() {
            g4.this.T0();
        }

        @Override // com.beizi.fusion.ji
        public void b() {
            Log.d("BeiZis", "showBeiZiNativeAd onAdWillLeaveApplication");
        }
    }

    public class o implements oi {
        public o() {
        }

        @Override // com.beizi.fusion.oi
        public void onAdShown() {
            Log.d("BeiZis", "showBeiZiNativeAd onAdShown()");
            g4.this.G0 = System.currentTimeMillis();
            g4.this.j = b2.ADSHOW;
            g4 g4Var = g4.this;
            if (g4Var.R0) {
                g4Var.b.setIsCacheAd("1");
                if (g4.this.S0 > 0) {
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    g4 g4Var2 = g4.this;
                    g4Var2.b.setCacheTime(String.valueOf(jCurrentTimeMillis - g4Var2.S0));
                }
                g4.this.H0();
            }
            if (g4.this.d != null && g4.this.d.z() != 2) {
                g4.this.d.d(g4.this.x());
            }
            g4.this.i0();
            g4.this.d0();
            g4.this.L0();
            g4.this.M0();
            g4.this.Q0();
            g4.this.N0();
        }
    }

    public class q implements v5.b {
        public q() {
        }

        @Override // com.beizi.fusion.v5.b
        public void a(String str) {
            try {
                g4 g4Var = g4.this;
                co.b(g4Var.U, g4Var.t0, Long.valueOf(System.currentTimeMillis()));
                g4.this.b.setComplain(str);
                g4.this.H0();
                g4.this.c0();
                g4.this.b1();
                if (g4.this.d != null && g4.this.d.z() != 2) {
                    g4.this.d.a(g4.this.x(), g4.this.c0);
                }
                g4.this.b0();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public class r implements ri.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f27332a;
        final /* synthetic */ int b;
        final /* synthetic */ mi c;

        public class a implements ji {
            public a() {
            }

            @Override // com.beizi.fusion.ji
            public void a() {
                g4.this.T0();
                g4.this.B0();
            }

            @Override // com.beizi.fusion.ji
            public void b() {
            }
        }

        public r(int i, int i2, mi miVar) {
            this.f27332a = i;
            this.b = i2;
            this.c = miVar;
        }

        @Override // com.beizi.fusion.ri.b
        public void a() {
            AdSpacesBean.BuyerBean.CoolShakeViewBean coolShakeViewBean;
            try {
                if (yp.a(g4.this.c0)) {
                    g4 g4Var = g4.this;
                    if (g4Var.I0) {
                        return;
                    }
                    g4Var.y0 = true;
                    g4Var.I0 = true;
                    int[] iArr = new int[2];
                    g4Var.c0.getLocationOnScreen(iArr);
                    int[] iArrB = ol.b(this.f27332a / 2, this.b / 2);
                    if (this.c != null) {
                        g4 g4Var2 = g4.this;
                        if (g4Var2.c0 != null) {
                            g4Var2.R0();
                            this.c.a(g4.this.c0, String.valueOf(iArrB[0]), String.valueOf(iArrB[1]), String.valueOf(iArrB[0] + iArr[0]), String.valueOf(iArrB[1] + iArr[1]), 2, new a());
                        }
                    }
                    g4 g4Var3 = g4.this;
                    if (!g4Var3.k0 || (coolShakeViewBean = g4Var3.h0) == null) {
                        return;
                    }
                    g4Var3.k0 = false;
                    g4Var3.i0.b(coolShakeViewBean);
                    g4 g4Var4 = g4.this;
                    co.b(g4Var4.U, g4Var4.j0, Long.valueOf(System.currentTimeMillis()));
                    qn.a().a(g4.this.j0, System.currentTimeMillis());
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public class s implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ AdSpacesBean.BuyerBean.ShakeViewBean f27334a;

        public s(AdSpacesBean.BuyerBean.ShakeViewBean shakeViewBean) {
            this.f27334a = shakeViewBean;
        }

        @Override // java.lang.Runnable
        public void run() {
            g4.this.i0.a(this.f27334a);
        }
    }

    public class t implements View.OnTouchListener {
        public t() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (motionEvent.getAction() != 1) {
                return false;
            }
            g4.this.n0 = motionEvent.getX();
            g4.this.o0 = motionEvent.getY();
            g4.this.p0 = motionEvent.getRawX();
            g4.this.q0 = motionEvent.getRawY();
            return false;
        }
    }

    public class u implements View.OnClickListener {
        public u() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!g4.this.W0()) {
                g4.this.d1();
                return;
            }
            g4 g4Var = g4.this;
            g4Var.J0 = false;
            g4.this.a(new String[]{String.valueOf(g4Var.n0), String.valueOf(g4.this.o0), String.valueOf(g4.this.p0), String.valueOf(g4.this.q0)}, 0);
        }
    }

    public g4(Context context, String str, long j2, long j3, AdSpacesBean.BuyerBean buyerBean, AdSpacesBean.ForwardBean forwardBean, m3 m3Var, float f2, float f3) {
        this.U = context;
        this.V = str;
        this.W = j2;
        this.X = j3;
        this.e = buyerBean;
        this.d = m3Var;
        this.f = forwardBean;
        this.Y = f2;
        this.Z = f3;
        this.b0 = new SplashContainer(context);
        C();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void M0() {
        try {
            if (this.z0 && this.b0 != null && this.U != null) {
                this.D0 = new FrameLayout(this.U);
                int width = this.b0.getWidth();
                int height = this.b0.getHeight();
                if (width <= 0) {
                    width = -1;
                }
                if (height <= 0) {
                    height = -1;
                }
                this.D0.setLayoutParams(new FrameLayout.LayoutParams(width, height));
                this.D0.setBackgroundColor(Color.parseColor(this.K0));
                this.b0.addView(this.D0);
                this.D0.setOnTouchListener(new c());
                this.D0.getViewTreeObserver().addOnScrollChangedListener(this.T0);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void N0() {
        Handler handler;
        try {
            int iK = k();
            if (iK > 0 && (handler = this.L) != null) {
                handler.postDelayed(new j(), iK);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private void O0() {
        ViewGroup viewGroup = this.b0;
        if (viewGroup == null) {
            return;
        }
        viewGroup.setOnTouchListener(new g());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void P0() {
        try {
            AdSpacesBean.ComplainBean complainBean = this.Q0;
            if (complainBean != null && complainBean.getOpen() == 1) {
                v5 v5Var = new v5();
                v5Var.a(this.U, this.b0, "1");
                v5Var.a(new q());
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Q0() {
        AdSpacesBean.BuyerBean buyerBean;
        AdSpacesBean.NativeOptimizeBean nativeOptimize;
        AdSpacesBean.NativeOptimizeClickAreaBean clickArea;
        try {
            if (this.b0 != null && this.U != null && (buyerBean = this.e) != null) {
                if ((this.L0 || this.M0) && (nativeOptimize = buyerBean.getNativeOptimize()) != null && (clickArea = nativeOptimize.getClickArea()) != null && ol.a(clickArea.getRandomNum())) {
                    int reference = clickArea.getReference();
                    String width = clickArea.getWidth();
                    String height = clickArea.getHeight();
                    String horizontalSpace = clickArea.getHorizontalSpace();
                    String verticalSpace = clickArea.getVerticalSpace();
                    View rootView = this.b0.getRootView();
                    if (rootView == null) {
                        return;
                    }
                    ViewGroup viewGroup = (ViewGroup) rootView.findViewById(android.R.id.content);
                    this.N0 = viewGroup;
                    if (viewGroup == null) {
                        return;
                    }
                    int iJ = so.j(this.U);
                    int iG = so.g(this.U);
                    int width2 = this.b0.getWidth();
                    int height2 = this.b0.getHeight();
                    int[] iArr = new int[2];
                    this.b0.getLocationOnScreen(iArr);
                    int i2 = iArr[0];
                    int i3 = iArr[1];
                    int i4 = -1;
                    if (reference == 0) {
                        iJ = width2;
                        iG = height2;
                    } else if (reference != 1) {
                        iJ = -1;
                        iG = -1;
                    }
                    try {
                        if (!TextUtils.isEmpty(width)) {
                            iJ = width.endsWith("%") ? (Integer.parseInt(width.substring(0, width.indexOf("%"))) * iJ) / 100 : Integer.parseInt(width);
                        }
                        if (!TextUtils.isEmpty(height)) {
                            iG = height.endsWith("%") ? (Integer.parseInt(height.substring(0, height.indexOf("%"))) * iG) / 100 : Integer.parseInt(height);
                        }
                    } catch (NumberFormatException e2) {
                        e2.printStackTrace();
                    }
                    if (iJ < 0) {
                        iJ = -1;
                    }
                    if (iG >= 0) {
                        i4 = iG;
                    }
                    this.O0 = new FrameLayout(this.U);
                    this.O0.setLayoutParams(new FrameLayout.LayoutParams(iJ, i4));
                    int iA = a(horizontalSpace, iJ, width2, i2);
                    int iB = b(verticalSpace, i4, height2, i3);
                    int iA2 = so.a(this.U, 25.0f);
                    if (iB > iA2) {
                        iB -= iA2;
                    }
                    this.O0.setX(iA);
                    this.O0.setY(iB);
                    this.O0.setBackgroundColor(Color.parseColor(this.K0));
                    this.N0.addView(this.O0);
                    this.O0.setOnTouchListener(new e(new float[4]));
                    this.b0.getViewTreeObserver().addOnScrollChangedListener(this.U0);
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void R0() {
        ri riVar;
        try {
            if (this.E != null && (riVar = this.i0) != null) {
                if (this.h0 == null) {
                    riVar.a(1.9d, 1.5d);
                }
                if (this.G != 1) {
                    return;
                }
                double dB = this.E.b();
                double dA = this.E.a();
                double dC = this.i0.c();
                double d2 = this.i0.d();
                if (dA > AudioStats.AUDIO_AMPLITUDE_NONE && dC > AudioStats.AUDIO_AMPLITUDE_NONE && dC < dA) {
                    this.G = 2;
                } else if (dB > AudioStats.AUDIO_AMPLITUDE_NONE && d2 > AudioStats.AUDIO_AMPLITUDE_NONE && d2 < dB) {
                    this.G = 2;
                }
                mi miVar = this.s0;
                if (miVar != null) {
                    miVar.a(this.G);
                }
            }
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void S0() {
        AdSpacesBean.BuyerBean.DislikeConfigBean dislikeConfig = this.e.getDislikeConfig();
        this.l0 = dislikeConfig;
        if (dislikeConfig == null) {
            return;
        }
        String dislikeUuid = dislikeConfig.getDislikeUuid();
        AdSpacesBean.BuyerBean.DislikeConfigBean dislikeConfigBeanA = a(this.l0.getOrderData(), this.a0.c());
        if (dislikeConfigBeanA != null) {
            this.m0 = dislikeConfigBeanA;
            dislikeUuid = dislikeConfigBeanA.getDislikeUuid();
        }
        EventBean eventBean = this.b;
        if (eventBean != null) {
            eventBean.setDislikeUuid(dislikeUuid);
            H0();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void T0() {
        AdSpacesBean.BuyerBean buyerBean;
        Log.d("BeiZis", "showBeiZiNativeAd onAdWasClicked");
        this.y0 = true;
        this.I0 = false;
        this.J0 = false;
        a1();
        if (this.I && (buyerBean = this.e) != null) {
            this.b.setCallBackStrategyUuid(buyerBean.getCallBackStrategyUuid());
            H0();
        }
        Z();
        a(this.U, this.b0, this.H);
        if (O()) {
            m3 m3Var = this.d;
            if (m3Var != null && m3Var.z() != 2) {
                this.d.b(x());
            }
            Y();
            I0();
            gi giVar = this.a0;
            if (giVar != null) {
                giVar.y();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void U0() {
        try {
            if (!this.I0 && !this.y0) {
                double width = this.b0.getWidth();
                int[] iArr = {((int) (0.1d * width)) / 2, (int) (((double) this.b0.getHeight()) * 0.8d)};
                int[] iArrB = ol.b(((int) (width * 0.9d)) / 2, so.a(this.U, 65.0f) / 2);
                a(new String[]{String.valueOf(iArrB[0]), String.valueOf(iArrB[1]), String.valueOf(iArrB[0] + iArr[0]), String.valueOf(iArrB[1] + iArr[1])}, 0);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean V0() {
        AdSpacesBean.BuyerBean.DislikeConfigBean dislikeConfigBean = this.m0;
        if (dislikeConfigBean != null) {
            return dislikeConfigBean.getIsHide() == 0;
        }
        AdSpacesBean.BuyerBean.DislikeConfigBean dislikeConfigBean2 = this.l0;
        return dislikeConfigBean2 != null && dislikeConfigBean2.getIsHide() == 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean W0() {
        return this.J0;
    }

    private boolean X0() {
        AdSpacesBean.BuyerBean.ShakeViewBean shakeViewBean = this.g0;
        if (shakeViewBean == null) {
            return false;
        }
        return ol.a(shakeViewBean.getRenderRate());
    }

    private boolean Y0() {
        try {
            return System.currentTimeMillis() - so.a(this.U).longValue() < this.h0.getUserProtectTime();
        } catch (Exception e2) {
            e2.printStackTrace();
            return false;
        }
    }

    private boolean Z0() {
        try {
            AdSpacesBean.BuyerBean.DislikeConfigBean dislikeConfigBean = this.m0;
            if (dislikeConfigBean != null) {
                return dislikeConfigBean.getIsShowDialog() == 1;
            }
            AdSpacesBean.BuyerBean.DislikeConfigBean dislikeConfigBean2 = this.l0;
            return dislikeConfigBean2 != null && dislikeConfigBean2.getIsShowDialog() == 1;
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return false;
    }

    private void a1() {
        FrameLayout frameLayout;
        FrameLayout frameLayout2;
        try {
            FrameLayout frameLayout3 = this.D0;
            if (frameLayout3 != null && this.T0 != null) {
                frameLayout3.getViewTreeObserver().removeOnScrollChangedListener(this.T0);
            }
            ViewGroup viewGroup = this.b0;
            if (viewGroup != null && (frameLayout2 = this.D0) != null) {
                viewGroup.removeView(frameLayout2);
                this.D0 = null;
            }
            ViewGroup viewGroup2 = this.b0;
            if (viewGroup2 != null && this.U0 != null) {
                viewGroup2.getViewTreeObserver().removeOnScrollChangedListener(this.U0);
            }
            ViewGroup viewGroup3 = this.N0;
            if (viewGroup3 == null || (frameLayout = this.O0) == null) {
                return;
            }
            viewGroup3.removeView(frameLayout);
            this.O0 = null;
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b1() {
        try {
            LinearLayout linearLayout = new LinearLayout(this.U);
            linearLayout.setOrientation(1);
            linearLayout.setGravity(17);
            linearLayout.setBackgroundColor(Color.parseColor("#FFFFFF"));
            ImageView imageView = new ImageView(this.U);
            imageView.setImageResource(R.drawable.beizi_icon_checkbox);
            imageView.setColorFilter(Color.parseColor("#000000"));
            linearLayout.addView(imageView);
            TextView textView = new TextView(this.U);
            textView.setText("投诉成功，我们将重视您的反馈。");
            textView.setTextColor(Color.parseColor("#000000"));
            textView.setTextSize(2, 13.0f);
            textView.setGravity(17);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
            layoutParams.setMargins(0, 30, 0, 0);
            linearLayout.addView(textView, layoutParams);
            this.c0.measure(0, 0);
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(this.c0.getMeasuredWidth(), this.c0.getMeasuredHeight());
            layoutParams2.gravity = 17;
            this.b0.addView(linearLayout, layoutParams2);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /* JADX WARN: Code duplicated, block: B:13:0x0063  */
    private void c1() {
        float fM;
        int iA;
        try {
            String strQ = this.s0.q();
            if (TextUtils.isEmpty(strQ)) {
                return;
            }
            String strG = this.s0.g();
            this.V0 = new BZVideoView(this.U);
            boolean zH = this.s0.h();
            this.V0.setPlayProgressCallback(new l());
            this.V0.initVideoResource(strQ, strG, zH);
            int iA2 = so.a(this.U, this.Y);
            float f2 = this.Z;
            if (f2 > 0.0f) {
                iA = so.a(this.U, f2);
            } else {
                mi miVar = this.s0;
                if (miVar != null) {
                    fM = (float) ((((double) miVar.m()) * 1.0d) / ((double) this.s0.o()));
                    if (fM <= 1.0f) {
                        fM = 1.7f;
                    }
                } else {
                    fM = 1.7f;
                }
                iA = (int) (iA2 / fM);
            }
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(iA2, iA);
            ViewGroup viewGroup = this.b0;
            if (viewGroup != null) {
                viewGroup.removeAllViews();
                this.b0.setLayoutParams(layoutParams);
                this.b0.setBackgroundColor(Color.parseColor("#000000"));
                this.b0.addView(this.V0, layoutParams);
                a(this.s0);
                P0();
                e(this.s0);
                a(this.s0, iA2, iA, 0);
                S0();
                if (V0()) {
                    b(this.s0);
                }
                ViewGroup viewGroup2 = this.b0;
                this.c0 = viewGroup2;
                ri riVar = this.i0;
                if (riVar != null) {
                    riVar.a(viewGroup2);
                }
            }
            gi giVar = this.a0;
            if (giVar != null && this.e0 != null) {
                giVar.a(this.f0);
                this.a0.b(this.e0.getOptimizePercent());
                jh.a("BeiZis", "percent = " + this.e0.getOptimizePercent());
                this.b0.post(new m());
            }
            d(this.s0);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d1() {
        try {
            if (Z0()) {
                e7.a aVar = new e7.a(this.U);
                aVar.a(new a());
                aVar.a().show();
            } else {
                m3 m3Var = this.d;
                if (m3Var != null && m3Var.z() != 2) {
                    this.d.a(x(), this.c0);
                }
                b0();
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    @Override // com.beizi.fusion.d2
    public void A0() {
        if (this.d == null) {
            return;
        }
        this.h = this.e.getAppId();
        this.i = this.e.getSpaceId();
        this.c = this.e.getBuyerSpaceUuId();
        this.Q0 = this.e.getComplain();
        this.t0 = "complain_config_" + this.i;
        AdSpacesBean.NativeOptimizeBean nativeOptimize = this.e.getNativeOptimize();
        if (nativeOptimize != null) {
            this.H0 = nativeOptimize.getNativeUuid();
            AdSpacesBean.NativeOptimizeAdSlideBean adSlide = nativeOptimize.getAdSlide();
            if (adSlide != null) {
                this.z0 = ol.a(adSlide.getRandomNum());
                this.A0 = adSlide.getNeedTime();
                this.B0 = adSlide.getDistance();
            }
            this.J0 = ol.a(nativeOptimize.getCloseClickNum());
            this.L0 = ol.a(nativeOptimize.getTouchDownNum());
            this.M0 = ol.a(nativeOptimize.getHoldSlideNum());
        }
        try {
            List<AdSpacesBean.CallBackStrategyBean> callBackStrategy = this.e.getCallBackStrategy();
            if (callBackStrategy != null && callBackStrategy.size() > 0) {
                this.I = true;
                for (int i2 = 0; i2 < callBackStrategy.size(); i2++) {
                    AdSpacesBean.CallBackStrategyBean callBackStrategyBean = callBackStrategy.get(i2);
                    if ("290.300".equalsIgnoreCase(callBackStrategyBean.getEventCode())) {
                        this.J = ol.a(Integer.parseInt(callBackStrategyBean.getRate()));
                        break;
                    }
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        List<AdSpacesBean.RenderViewBean> renderView = this.e.getRenderView();
        this.d0 = renderView;
        if (renderView != null && renderView.size() > 0) {
            AdSpacesBean.RenderViewBean renderViewBean = (AdSpacesBean.RenderViewBean) this.d0.get(0);
            this.e0 = renderViewBean;
            this.f0 = k6.a(renderViewBean.getDpLinkUrlList());
        }
        ik ikVar = this.f27152a;
        if (ikVar != null) {
            EventBean eventBeanB = ikVar.a().b(this.c);
            this.b = eventBeanB;
            if (eventBeanB != null) {
                D();
                u0();
                vq.b(this.U, this.h);
                v0();
            }
        }
        Log.d("BeiZis", x() + ":requestAd:" + this.h + "====" + this.i + "===" + this.X);
        long j2 = this.X;
        if (j2 > 0) {
            this.L.sendEmptyMessageDelayed(1, j2);
            return;
        }
        m3 m3Var = this.d;
        if (m3Var == null || m3Var.n() >= 1 || this.d.z() == 2) {
            return;
        }
        z0();
    }

    @Override // com.beizi.fusion.d2
    public void C0() {
        ri riVar;
        try {
            if (!q1.h().v() || (riVar = this.i0) == null) {
                return;
            }
            riVar.g();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    @Override // com.beizi.fusion.d2
    public void G0() {
    }

    @Override // com.beizi.fusion.d2
    public boolean R() {
        gi giVar = this.a0;
        if (giVar == null) {
            return false;
        }
        return giVar.v();
    }

    @Override // com.beizi.fusion.d2
    public void S() {
        try {
            BZVideoView bZVideoView = this.V0;
            if (bZVideoView != null) {
                bZVideoView.onViewPause(true);
            }
        } catch (Exception unused) {
        }
    }

    @Override // com.beizi.fusion.d2
    public void T() {
        try {
            ri riVar = this.i0;
            if (riVar != null) {
                riVar.g();
            }
            BZVideoView bZVideoView = this.V0;
            if (bZVideoView != null) {
                bZVideoView.onViewResume(true);
            }
        } catch (Exception unused) {
        }
    }

    @Override // com.beizi.fusion.d2
    public void U() {
        ri riVar;
        try {
            if (!q1.h().v() || (riVar = this.i0) == null) {
                return;
            }
            riVar.a(false);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    @Override // com.beizi.fusion.d2
    public String x() {
        return "BEIZI";
    }

    @Override // com.beizi.fusion.d2
    public void z0() {
        g0();
        K0();
        AdSpacesBean.BuyerBean.ShakeViewBean shakeView = this.e.getShakeView();
        this.g0 = shakeView;
        if (shakeView != null) {
            this.h0 = shakeView.getCoolShakeView();
        }
        this.j0 = "cool_" + this.i;
        this.r0 = "dl_cool_" + this.i;
        if (this.Y <= 0.0f) {
            this.Y = so.i(this.U);
        }
        if (this.Z <= 0.0f) {
            this.Z = 0.0f;
        }
        gi giVar = new gi(this.U, this.i, 3, new k());
        this.a0 = giVar;
        giVar.b(true);
        try {
            this.a0.a(this.b.m167clone());
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        this.a0.a((int) this.W);
        this.a0.a(this.e);
        if ("S2S".equals(l())) {
            this.a0.c(l());
            m3 m3Var = this.d;
            if (m3Var != null) {
                String strQ = m3Var.q();
                if (!TextUtils.isEmpty(strQ)) {
                    this.a0.b(strQ);
                }
            }
        }
        m3 m3Var2 = this.d;
        if (m3Var2 != null) {
            this.a0.c(m3Var2.y());
            this.a0.d(this.d.v());
        }
        this.a0.w();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(mi miVar) {
        View viewA;
        if (miVar == null) {
            return;
        }
        try {
            if (miVar.p() == null || (viewA = pi.a(this.U, miVar)) == null) {
                return;
            }
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams((this.b0.getLayoutParams().width * 2) / 3, -2);
            layoutParams.gravity = 83;
            this.b0.addView(viewA, layoutParams);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(mi miVar) {
        if (miVar == null) {
            a(-991);
            return;
        }
        if (TextUtils.isEmpty(miVar.q())) {
            ArrayList arrayListJ = this.s0.j();
            if (arrayListJ == null || arrayListJ.size() == 0) {
                Log.d("BeiZis", "showBeiZiNativeAd imageUrls address is null");
                a(-991);
                return;
            }
            c((String) arrayListJ.get(0));
        } else {
            c1();
        }
        mi miVar2 = this.s0;
        if (miVar2 != null) {
            miVar2.a(this.G);
        }
        if (this.L0 || this.M0) {
            O0();
        } else {
            pi.a(miVar, this.b0, new n());
        }
        gi giVar = this.a0;
        if (giVar != null) {
            giVar.a(this.b0, new o());
        }
    }

    @Override // com.beizi.fusion.d2
    public void g() {
        mi miVar = this.s0;
        if (miVar != null) {
            miVar.destroy();
        }
        gi giVar = this.a0;
        if (giVar != null) {
            giVar.a();
        }
        ri riVar = this.i0;
        if (riVar != null) {
            riVar.h();
        }
        a1();
    }

    @Override // com.beizi.fusion.d2
    public b2 h() {
        return this.j;
    }

    @Override // com.beizi.fusion.d2
    public AdSpacesBean.BuyerBean m() {
        return this.e;
    }

    @Override // com.beizi.fusion.d2
    public String n() {
        gi giVar = this.a0;
        if (giVar == null) {
            return null;
        }
        return giVar.d();
    }

    @Override // com.beizi.fusion.d2
    public JSONObject p() {
        gi giVar = this.a0;
        if (giVar == null) {
            return null;
        }
        return giVar.l();
    }

    @Override // com.beizi.fusion.d2
    public View r() {
        return this.c0;
    }

    @Override // com.beizi.fusion.d2
    public String s() {
        gi giVar = this.a0;
        if (giVar == null) {
            return null;
        }
        return giVar.q();
    }

    @Override // com.beizi.fusion.d2
    public void z() {
        if (!L() || this.a0 == null) {
            return;
        }
        F0();
    }

    private void c(mi miVar) {
        m3 m3Var = this.d;
        if (m3Var == null) {
            return;
        }
        Log.d("BeiZis", x() + " NativeAdWorker:" + m3Var.C().toString());
        f();
        s5 s5Var = this.g;
        if (s5Var == s5.SUCCESS) {
            if (this.c0 != null) {
                this.d.b(x(), this.c0);
                return;
            } else {
                this.d.a(10140);
                return;
            }
        }
        if (s5Var == s5.FAIL) {
            Log.d("BeiZis", "other worker shown," + x() + " remove");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(mi miVar) {
        if (V()) {
            c(miVar);
        } else {
            A();
        }
    }

    private AdSpacesBean.BuyerBean.OrderDataShakeViewBean b(List list, String str) {
        if (list != null && str != null) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                AdSpacesBean.BuyerBean.OrderDataShakeViewBean orderDataShakeViewBean = (AdSpacesBean.BuyerBean.OrderDataShakeViewBean) it.next();
                List<String> orderList = orderDataShakeViewBean.getOrderList();
                if (orderList != null && orderList.contains(str)) {
                    return orderDataShakeViewBean;
                }
            }
        }
        return null;
    }

    @Override // com.beizi.fusion.d2
    public void d(Map map) {
        Object obj;
        Object obj2;
        Object obj3;
        Object obj4;
        try {
            gi giVar = this.a0;
            if (giVar == null) {
                return;
            }
            giVar.b(map);
            if (map.containsKey("winPrice") && (obj4 = map.get("winPrice")) != null && (obj4 instanceof String)) {
                String str = (String) obj4;
                if (!TextUtils.isEmpty(str)) {
                    this.b.setWinPrice(str);
                }
            }
            if (map.containsKey("adnId") && (obj3 = map.get("adnId")) != null && (obj3 instanceof String)) {
                String str2 = (String) obj3;
                if (!TextUtils.isEmpty(str2)) {
                    this.b.setAdnId(str2);
                }
            }
            if (map.containsKey("highestLossPrice") && (obj2 = map.get("highestLossPrice")) != null && (obj2 instanceof String)) {
                String str3 = (String) obj2;
                if (!TextUtils.isEmpty(str3)) {
                    this.b.setHighestLossPrice(str3);
                }
            }
            if (map.containsKey("auctionExt") && (obj = map.get("auctionExt")) != null && (obj instanceof String)) {
                String str4 = (String) obj;
                if (!TextUtils.isEmpty(str4)) {
                    this.b.setSecondPrice(str4);
                }
            }
            H0();
            s0();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(mi miVar) {
        try {
            LinearLayout linearLayout = new LinearLayout(this.U);
            linearLayout.setLayoutParams(new FrameLayout.LayoutParams(-2, -2, 17));
            FrameLayout frameLayoutB = bq.b(this.U, miVar.n());
            frameLayoutB.setVisibility(0);
            linearLayout.addView(frameLayoutB, new LinearLayout.LayoutParams(-2, -2, 17.0f));
            View viewA = bq.a(this.U, miVar.a());
            viewA.setVisibility(0);
            linearLayout.addView(viewA, new LinearLayout.LayoutParams(-2, -2, 17.0f));
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) viewA.getLayoutParams();
            layoutParams.setMargins(5, 0, 0, 0);
            layoutParams.gravity = 17;
            viewA.setLayoutParams(layoutParams);
            this.b0.addView(linearLayout, new FrameLayout.LayoutParams(-2, -2, 85));
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) linearLayout.getLayoutParams();
            int iA = so.a(this.U, 12.0f);
            layoutParams2.setMargins(0, 0, iA, iA);
            linearLayout.setLayoutParams(layoutParams2);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private void b(AdSpacesBean.BuyerBean.ShakeViewBean shakeViewBean) {
        if (shakeViewBean == null) {
            shakeViewBean = this.g0;
        }
        int regulatoryAngle = shakeViewBean.getRegulatoryAngle();
        int isUnidirection = shakeViewBean.getIsUnidirection();
        ri riVar = this.i0;
        if (riVar != null) {
            riVar.b(regulatoryAngle);
            this.i0.d(isUnidirection);
            f5 f5Var = this.E;
            if (f5Var != null) {
                this.i0.a(f5Var.b());
            }
        }
        if (this.h0 == null) {
            this.k0 = true;
            this.i0.a(shakeViewBean);
        } else if (a(shakeViewBean)) {
            this.i0.b(this.h0);
        } else if (Y0()) {
            this.i0.b(this.h0);
        } else {
            this.k0 = true;
            this.i0.a(shakeViewBean);
        }
    }

    private void c(String str) {
        ImageView imageView = new ImageView(this.U);
        imageView.setVisibility(0);
        of.a((Context) null).a(str, new p(imageView));
    }

    @Override // com.beizi.fusion.d2
    public void c(Map map) {
        Object obj;
        Object obj2;
        Object obj3;
        try {
            gi giVar = this.a0;
            if (giVar == null) {
                return;
            }
            giVar.a(map);
            if (map.containsKey("winPrice") && (obj3 = map.get("winPrice")) != null && (obj3 instanceof String)) {
                String str = (String) obj3;
                if (!TextUtils.isEmpty(str)) {
                    this.b.setWinPrice(str);
                }
            }
            if (map.containsKey("adnId") && (obj2 = map.get("adnId")) != null && (obj2 instanceof String)) {
                String str2 = (String) obj2;
                if (!TextUtils.isEmpty(str2)) {
                    this.b.setAdnId(str2);
                }
            }
            if (map.containsKey("lossReason") && (obj = map.get("lossReason")) != null && (obj instanceof String)) {
                String str3 = (String) obj;
                if (!TextUtils.isEmpty(str3)) {
                    this.b.setLossReason(str3);
                }
            }
            H0();
            r0();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(mi miVar) {
        ImageView imageView = new ImageView(this.U);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(85, 85);
        imageView.setPadding(25, 15, 15, 25);
        imageView.setLayoutParams(layoutParams);
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        imageView.setVisibility(0);
        imageView.setImageResource(R.drawable.beizi_close);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(85, 85);
        layoutParams2.gravity = 5;
        this.b0.addView(imageView, layoutParams2);
        imageView.setOnTouchListener(new t());
        imageView.setOnClickListener(new u());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(mi miVar, int i2, int i3, int i4) {
        AdSpacesBean.BuyerBean.ShakeViewBean shakeView;
        try {
            if (!q1.h().u() && X0()) {
                if (this.i0 == null) {
                    this.i0 = new ri(this.U);
                }
                AdSpacesBean.BuyerBean.ShakeViewBean shakeViewBean = this.g0;
                if (shakeViewBean == null || this.i0 == null || shakeViewBean.getPosition() == null) {
                    return;
                }
                String shakeViewUuid = this.g0.getShakeViewUuid();
                AdSpacesBean.BuyerBean.OrderDataShakeViewBean orderDataShakeViewBeanB = b(this.g0.getOrderData(), this.a0.c());
                if (orderDataShakeViewBeanB == null || orderDataShakeViewBeanB.getShakeView() == null) {
                    shakeView = null;
                } else {
                    shakeView = orderDataShakeViewBeanB.getShakeView();
                    if (shakeView != null) {
                        shakeViewUuid = shakeView.getShakeViewUuid();
                    }
                }
                EventBean eventBean = this.b;
                if (eventBean != null) {
                    eventBean.setShakeViewUuid(shakeViewUuid);
                    H0();
                }
                if (i3 <= 0) {
                    i3 = i4;
                }
                this.i0.a(this.u0);
                View viewA = this.i0.a(so.b(this.U, i2), so.b(this.U, i3), this.g0.getPosition());
                if (viewA != null) {
                    ViewGroup.LayoutParams layoutParams = viewA.getLayoutParams();
                    if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(marginLayoutParams.width, marginLayoutParams.height);
                        if (this.V0 != null) {
                            layoutParams2.gravity = 17;
                        } else {
                            layoutParams2.leftMargin = marginLayoutParams.leftMargin;
                            layoutParams2.topMargin = marginLayoutParams.topMargin;
                        }
                        AdSpacesBean.BuyerBean.ShakeViewBean shakeViewBean2 = this.g0;
                        if (shakeViewBean2 != null && shakeViewBean2.getIsHideAnim() == 0) {
                            this.b0.addView(viewA, layoutParams2);
                        }
                    }
                }
                b(shakeView);
                this.i0.a(new r(i2, i3, miVar));
                AdSpacesBean.BuyerBean.CoolShakeViewBean coolShakeViewBean = this.h0;
                if (coolShakeViewBean != null) {
                    this.i0.a(coolShakeViewBean, this.j0);
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private int b(String str, int i2, int i3, int i4) {
        int i5;
        int i6;
        try {
            if (TextUtils.isEmpty(str)) {
                return i4;
            }
            if (!com.ipd.dsp.internal.e1.f.l.equals(str)) {
                if ("center".equals(str)) {
                    if (i2 > i3) {
                        i6 = (i2 - i3) / 2;
                        i4 -= i6;
                    } else {
                        i5 = (i3 - i2) / 2;
                        i4 += i5;
                    }
                } else if (!com.ipd.dsp.internal.e1.f.n.equals(str)) {
                    i4 = 0;
                } else if (i2 > i3) {
                    i6 = i2 - i3;
                    i4 -= i6;
                } else {
                    i5 = i3 - i2;
                    i4 += i5;
                }
            }
            if (i4 < 0) {
                return 0;
            }
            return i4;
        } catch (Exception e2) {
            e2.printStackTrace();
            return i4;
        }
    }

    public class p implements of.f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ ImageView f27329a;

        public class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                g4 g4Var = g4.this;
                gi giVar = g4Var.a0;
                int optimizeSize = g4Var.e0.getOptimizeSize();
                p pVar = p.this;
                ImageView imageView = pVar.f27329a;
                g4 g4Var2 = g4.this;
                giVar.a(optimizeSize, imageView, g4Var2.b0, g4Var2.e0.getDirection());
            }
        }

        public p(ImageView imageView) {
            this.f27329a = imageView;
        }

        @Override // com.beizi.fusion.of.f
        public void a(Bitmap bitmap) {
            ViewGroup.LayoutParams layoutParams;
            try {
                Log.d("BeiZis", "showBeiZiNativeAd onBitmapLoaded");
                int width = bitmap.getWidth();
                int height = bitmap.getHeight();
                float f = (float) ((((double) width) * 1.0d) / ((double) height));
                g4 g4Var = g4.this;
                int iA = so.a(g4Var.U, g4Var.Y);
                g4 g4Var2 = g4.this;
                float f2 = g4Var2.Z;
                int iA2 = f2 > 0.0f ? so.a(g4Var2.U, f2) : (int) (iA / f);
                ImageView imageView = this.f27329a;
                if (imageView != null && (layoutParams = imageView.getLayoutParams()) != null) {
                    layoutParams.width = iA;
                    layoutParams.height = iA2;
                    this.f27329a.setLayoutParams(layoutParams);
                }
                ImageView imageView2 = this.f27329a;
                if (imageView2 != null) {
                    g4.this.a(iA, iA2, f, bitmap, imageView2);
                    this.f27329a.setImageBitmap(bitmap);
                }
                g4 g4Var3 = g4.this;
                g4Var3.w0 = iA;
                g4Var3.x0 = iA2;
                if (iA2 < 0) {
                    g4Var3.x0 = height;
                }
                FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(iA, iA2);
                ViewGroup viewGroup = g4.this.b0;
                if (viewGroup != null) {
                    viewGroup.removeAllViews();
                    g4.this.b0.setLayoutParams(layoutParams2);
                    StringBuilder sb = new StringBuilder();
                    sb.append("mNativeAd != null ? ");
                    boolean z = true;
                    sb.append(g4.this.a0 != null);
                    sb.append(",renderViewBean != null ? ");
                    if (g4.this.e0 == null) {
                        z = false;
                    }
                    sb.append(z);
                    jh.a("BeiZis", sb.toString());
                    g4.this.b0.addView(this.f27329a, layoutParams2);
                    g4 g4Var4 = g4.this;
                    g4Var4.a(g4Var4.s0);
                    g4.this.P0();
                    g4 g4Var5 = g4.this;
                    g4Var5.e(g4Var5.s0);
                    g4 g4Var6 = g4.this;
                    g4Var6.a(g4Var6.s0, iA, iA2, bitmap.getHeight());
                    g4.this.S0();
                    if (g4.this.V0()) {
                        g4 g4Var7 = g4.this;
                        g4Var7.b(g4Var7.s0);
                    }
                    g4 g4Var8 = g4.this;
                    ViewGroup viewGroup2 = g4Var8.b0;
                    g4Var8.c0 = viewGroup2;
                    ri riVar = g4Var8.i0;
                    if (riVar != null) {
                        riVar.a(viewGroup2);
                    }
                }
                g4 g4Var9 = g4.this;
                gi giVar = g4Var9.a0;
                if (giVar != null && g4Var9.e0 != null) {
                    giVar.a(g4Var9.f0);
                    g4 g4Var10 = g4.this;
                    g4Var10.a0.b(g4Var10.e0.getOptimizePercent());
                    jh.a("BeiZis", "percent = " + g4.this.e0.getOptimizePercent());
                    g4.this.b0.post(new a());
                }
                g4 g4Var11 = g4.this;
                g4Var11.d(g4Var11.s0);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        @Override // com.beizi.fusion.of.f
        public void a() {
            Log.d("BeiZis", "showBeiZiNativeAd onBitmapLoadFailed");
            g4.this.a("sdk custom error ".concat("onBitmapLoadFailed"), 99991);
        }
    }

    @Override // com.beizi.fusion.d2
    public void b(int i2) {
        gi giVar = this.a0;
        if (giVar == null) {
            return;
        }
        giVar.a(this.b0, i2);
    }

    private boolean a(AdSpacesBean.BuyerBean.ShakeViewBean shakeViewBean) {
        long jLongValue = ((Long) co.a(this.U, this.j0, (Object) 0L)).longValue();
        if (jLongValue != 0) {
            long jCurrentTimeMillis = System.currentTimeMillis() - jLongValue;
            if (jCurrentTimeMillis < this.h0.getCoolTime()) {
                new Handler().postDelayed(new s(shakeViewBean), this.h0.getCoolTime() - jCurrentTimeMillis);
                return true;
            }
            qn.a().b(this.j0);
        }
        return false;
    }

    private AdSpacesBean.BuyerBean.DislikeConfigBean a(List list, String str) {
        AdSpacesBean.BuyerBean.DislikeConfigBean dislike;
        if (list != null && str != null) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                AdSpacesBean.BuyerBean.OrderDataDislikeConfigBean orderDataDislikeConfigBean = (AdSpacesBean.BuyerBean.OrderDataDislikeConfigBean) it.next();
                List<String> orderList = orderDataDislikeConfigBean.getOrderList();
                if (orderList != null && orderList.contains(str) && (dislike = orderDataDislikeConfigBean.getDislike()) != null) {
                    return dislike;
                }
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String[] strArr, int i2) {
        View view;
        try {
            a1();
            if (this.s0 != null && this.c0 != null && !this.I0 && !this.y0) {
                this.y0 = true;
                this.I0 = true;
                EventBean eventBean = this.b;
                if (eventBean != null) {
                    eventBean.setNativeRuleUuid(this.H0);
                    H0();
                }
                mi miVar = this.s0;
                if (miVar == null || (view = this.c0) == null) {
                    return;
                }
                miVar.a(view, strArr[0], strArr[1], strArr[2], strArr[3], 0, new b());
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private int a(String str, int i2, int i3, int i4) {
        int i5;
        int i6;
        try {
            if (TextUtils.isEmpty(str)) {
                return i4;
            }
            if (!"left".equals(str)) {
                if ("center".equals(str)) {
                    if (i2 > i3) {
                        i6 = (i2 - i3) / 2;
                        i4 -= i6;
                    } else {
                        i5 = (i3 - i2) / 2;
                        i4 += i5;
                    }
                } else if (!"right".equals(str)) {
                    i4 = 0;
                } else if (i2 > i3) {
                    i6 = i2 - i3;
                    i4 -= i6;
                } else {
                    i5 = i3 - i2;
                    i4 += i5;
                }
            }
            if (i4 < 0) {
                return 0;
            }
            return i4;
        } catch (Exception e2) {
            e2.printStackTrace();
            return i4;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String[] a(View view, View view2, float f2, float f3, float f4, float f5) {
        String[] strArr = new String[0];
        try {
            String[] strArr2 = {f2 + "", f3 + "", f4 + "", f5 + ""};
            if (view == null || view2 == null) {
                return strArr2;
            }
            try {
                view.getLocationOnScreen(new int[2]);
                int width = (int) ((((double) f2) * 100.0d) / ((double) view.getWidth()));
                int height = (int) ((((double) f3) * 100.0d) / ((double) view.getHeight()));
                int width2 = view2.getWidth();
                int height2 = view2.getHeight();
                int[] iArr = new int[2];
                view2.getLocationOnScreen(iArr);
                int i2 = (width2 * width) / 100;
                int i3 = (height2 * height) / 100;
                int i4 = iArr[0] + i2;
                int i5 = iArr[1] + i3;
                strArr2[0] = i2 + "";
                strArr2[1] = i3 + "";
                strArr2[2] = i4 + "";
                strArr2[3] = i5 + "";
                return strArr2;
            } catch (Exception e2) {
                try {
                    e2.printStackTrace();
                    return strArr2;
                } catch (Exception e3) {
                    e = e3;
                    strArr = strArr2;
                    e.printStackTrace();
                    return strArr;
                }
            }
        } catch (Exception e4) {
            e = e4;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String[] strArr) {
        View view;
        try {
            a1();
            if (this.s0 != null && this.c0 != null && !this.I0) {
                this.y0 = true;
                this.I0 = true;
                EventBean eventBean = this.b;
                if (eventBean != null) {
                    eventBean.setNativeRuleUuid(this.H0);
                    H0();
                }
                mi miVar = this.s0;
                if (miVar == null || (view = this.c0) == null) {
                    return;
                }
                miVar.a(view, strArr[0], strArr[1], strArr[2], strArr[3], 0, new h());
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i2, int i3, float f2, Bitmap bitmap, ImageView imageView) {
        try {
            float fAbs = Math.abs(((float) ((((double) i2) * 1.0d) / ((double) i3))) - f2);
            if (fAbs > 0.15f) {
                w3.c().e().execute(new i(bitmap, imageView));
            } else if (imageView != null) {
                if (fAbs > 0.1d) {
                    imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                } else {
                    imageView.setScaleType(ImageView.ScaleType.FIT_XY);
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i2, int i3) {
        double d2 = i3;
        double d3 = i2;
        if (d2 >= 0.25d * d3 && !this.X0) {
            this.X0 = true;
            b(25);
        }
        if (d2 >= 0.5d * d3 && !this.Y0) {
            this.Y0 = true;
            b(50);
        }
        if (d2 < d3 * 0.75d || this.Z0) {
            return;
        }
        this.Z0 = true;
        b(75);
    }
}
