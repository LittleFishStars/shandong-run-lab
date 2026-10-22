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
public abstract class l3 extends d2 implements a2 {
    protected int A0;
    protected int B0;
    private boolean C0;
    private boolean D0;
    private long E0;
    private int F0;
    private int G0;
    private FrameLayout H0;
    private boolean I0;
    private long K0;
    private String L0;
    private boolean M0;
    protected boolean N0;
    private boolean P0;
    private boolean Q0;
    private ViewGroup R0;
    private FrameLayout S0;
    private long T0;
    protected Context U;
    protected BZVideoView U0;
    protected String V;
    protected String V0;
    protected long W;
    protected long X;
    protected float Y;
    protected boolean Y0;
    protected float Z;
    private boolean Z0;
    protected ViewGroup a0;
    private boolean a1;
    protected View b0;
    private boolean b1;
    protected List c0;
    protected boolean c1;
    protected AdSpacesBean.RenderViewBean d0;
    protected List e0;
    protected AdSpacesBean.BuyerBean.ShakeViewBean f0;
    protected AdSpacesBean.BuyerBean.CoolShakeViewBean g0;
    protected ri h0;
    protected AdSpacesBean.BuyerBean.DislikeConfigBean k0;
    protected AdSpacesBean.BuyerBean.DislikeConfigBean l0;
    protected mi r0;
    protected jp s0;
    protected View t0;
    protected AdSpacesBean.ComplainBean u0;
    protected Boolean w0;
    private boolean x0;
    private long y0;
    private long z0;
    protected String i0 = null;
    protected boolean j0 = false;
    protected float m0 = 0.0f;
    protected float n0 = 0.0f;
    protected float o0 = 0.0f;
    protected float p0 = 0.0f;
    protected String q0 = null;
    protected String v0 = null;
    private String[] J0 = new String[4];
    private String O0 = "#00000000";
    private ViewTreeObserver.OnScrollChangedListener W0 = new b();
    private ViewTreeObserver.OnScrollChangedListener X0 = new d();

    public class a implements View.OnTouchListener {
        public a() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (motionEvent.getAction() == 0) {
                l3 l3Var = l3.this;
                l3Var.I0 = true;
                l3Var.J0[0] = motionEvent.getX() + "";
                l3.this.J0[1] = motionEvent.getY() + "";
                l3.this.J0[2] = motionEvent.getRawX() + "";
                l3.this.J0[3] = motionEvent.getRawY() + "";
            }
            return false;
        }
    }

    public class b implements ViewTreeObserver.OnScrollChangedListener {
        public b() {
        }

        @Override // android.view.ViewTreeObserver.OnScrollChangedListener
        public void onScrollChanged() {
            try {
                l3 l3Var = l3.this;
                if (l3Var.I0 && !l3Var.C0 && !l3Var.M0) {
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    l3 l3Var2 = l3.this;
                    if (jCurrentTimeMillis - l3Var2.K0 < l3Var2.E0) {
                        return;
                    }
                    long jCurrentTimeMillis2 = System.currentTimeMillis();
                    l3 l3Var3 = l3.this;
                    if (jCurrentTimeMillis2 - l3Var3.z0 < 50) {
                        return;
                    }
                    l3Var3.z0 = System.currentTimeMillis();
                    if (yp.a(l3.this.b0, 0.8d)) {
                        int[] iArr = new int[2];
                        View view = l3.this.b0;
                        if (view != null) {
                            view.getLocationOnScreen(iArr);
                        }
                        int i = iArr[1];
                        if (i > 0) {
                            l3 l3Var4 = l3.this;
                            if (l3Var4.G0 == 0) {
                                l3Var4.G0 = i;
                            }
                        }
                        int iAbs = Math.abs(l3.this.G0 - i);
                        l3 l3Var5 = l3.this;
                        if (iAbs < l3Var5.F0) {
                            return;
                        }
                        l3Var5.a(l3Var5.J0, 0);
                    }
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public class c implements View.OnTouchListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ float[] f27487a;

        public c(float[] fArr) {
            this.f27487a = fArr;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            try {
                if (motionEvent.getAction() == 0) {
                    this.f27487a[0] = motionEvent.getX();
                    this.f27487a[1] = motionEvent.getY();
                    this.f27487a[2] = motionEvent.getRawX();
                    this.f27487a[3] = motionEvent.getRawY();
                    l3 l3Var = l3.this;
                    if (l3Var.P0) {
                        FrameLayout frameLayout = l3Var.S0;
                        ViewGroup viewGroup = l3Var.a0;
                        float[] fArr = this.f27487a;
                        l3.this.a(l3Var.a(frameLayout, viewGroup, fArr[0], fArr[1], fArr[2], fArr[3]), 0);
                    }
                }
                if (motionEvent.getAction() == 1) {
                    l3 l3Var2 = l3.this;
                    if (l3Var2.Q0) {
                        FrameLayout frameLayout2 = l3Var2.S0;
                        ViewGroup viewGroup2 = l3Var2.a0;
                        float[] fArr2 = this.f27487a;
                        l3.this.a(l3Var2.a(frameLayout2, viewGroup2, fArr2[0], fArr2[1], fArr2[2], fArr2[3]), 0);
                    }
                }
                l3 l3Var3 = l3.this;
                return l3Var3.P0 || l3Var3.Q0;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public class d implements ViewTreeObserver.OnScrollChangedListener {
        public d() {
        }

        @Override // android.view.ViewTreeObserver.OnScrollChangedListener
        public void onScrollChanged() {
            ViewGroup viewGroup;
            try {
                if (l3.this.a0 == null) {
                    return;
                }
                long jCurrentTimeMillis = System.currentTimeMillis();
                l3 l3Var = l3.this;
                if (jCurrentTimeMillis - l3Var.T0 < 50) {
                    return;
                }
                l3Var.T0 = System.currentTimeMillis();
                int[] iArr = new int[2];
                l3.this.a0.getLocationOnScreen(iArr);
                if (iArr[1] < 0) {
                    l3.this.a0.getViewTreeObserver().removeOnScrollChangedListener(this);
                    l3 l3Var2 = l3.this;
                    FrameLayout frameLayout = l3Var2.S0;
                    if (frameLayout == null || (viewGroup = l3Var2.R0) == null) {
                        return;
                    }
                    viewGroup.removeView(frameLayout);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public class e implements View.OnTouchListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        String[] f27489a = new String[4];

        public e() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            ViewGroup viewGroup;
            ViewParent parent;
            try {
                if (motionEvent.getAction() == 0) {
                    l3 l3Var = l3.this;
                    if ((l3Var.P0 || l3Var.Q0) && (viewGroup = l3Var.a0) != null && (parent = viewGroup.getParent()) != null) {
                        parent.requestDisallowInterceptTouchEvent(true);
                    }
                    this.f27489a[0] = motionEvent.getX() + "";
                    this.f27489a[1] = motionEvent.getY() + "";
                    this.f27489a[2] = motionEvent.getRawX() + "";
                    this.f27489a[3] = motionEvent.getRawY() + "";
                    l3 l3Var2 = l3.this;
                    if (l3Var2.P0) {
                        l3Var2.a(this.f27489a);
                    }
                }
                if (motionEvent.getAction() == 1) {
                    l3 l3Var3 = l3.this;
                    if (l3Var3.Q0) {
                        l3Var3.a(this.f27489a);
                    }
                }
                l3 l3Var4 = l3.this;
                return l3Var4.P0 || l3Var4.Q0;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public class f implements ji {
        public f() {
        }

        @Override // com.beizi.fusion.ji
        public void a() {
            l3.this.S0();
        }

        @Override // com.beizi.fusion.ji
        public void b() {
        }
    }

    public class g implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Bitmap f27491a;
        final /* synthetic */ ImageView b;

        public class a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ BitmapDrawable f27492a;

            public a(BitmapDrawable bitmapDrawable) {
                this.f27492a = bitmapDrawable;
            }

            @Override // java.lang.Runnable
            public void run() {
                ImageView imageView;
                try {
                    BitmapDrawable bitmapDrawable = this.f27492a;
                    if (bitmapDrawable == null || (imageView = g.this.b) == null) {
                        return;
                    }
                    imageView.setBackground(bitmapDrawable);
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        }

        public g(Bitmap bitmap, ImageView imageView) {
            this.f27491a = bitmap;
            this.b = imageView;
        }

        @Override // java.lang.Runnable
        public void run() {
            Bitmap bitmap;
            try {
                Context context = l3.this.U;
                if (context == null || (bitmap = this.f27491a) == null) {
                    return;
                }
                BitmapDrawable bitmapDrawable = new BitmapDrawable(pf.a(context, bitmap, 20.0f));
                if (l3.this.L != null) {
                    l3.this.L.post(new a(bitmapDrawable));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public class h implements Runnable {
        public h() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                if (yp.a(l3.this.a0)) {
                    l3 l3Var = l3.this;
                    if (l3Var.C0) {
                        return;
                    }
                    l3Var.G = 2;
                    l3 l3Var2 = l3.this;
                    mi miVar = l3Var2.r0;
                    if (miVar != null) {
                        miVar.a(l3Var2.G);
                    }
                    l3.this.T0();
                    l3.this.B0();
                    l3 l3Var3 = l3.this;
                    mi miVar2 = l3Var3.r0;
                    if (miVar2 != null) {
                        miVar2.a(l3Var3.G);
                    }
                }
            } catch (Exception unused) {
            }
        }
    }

    public class i implements ki {
        public i() {
        }

        @Override // com.beizi.fusion.ki
        public void a(mi miVar) {
            Log.d("BeiZis", "showBeiZiNativeUnifiedAd onAdLoaded()");
            l3.this.j = b2.ADLOAD;
            l3 l3Var = l3.this;
            l3Var.w0 = Boolean.valueOf(l3Var.s0.s());
            l3 l3Var2 = l3.this;
            l3Var2.x0 = l3Var2.s0.u();
            l3 l3Var3 = l3.this;
            jp jpVar = l3Var3.s0;
            if (jpVar != null) {
                l3Var3.E = jpVar.i();
                if (l3.this.E != null) {
                    l3 l3Var4 = l3.this;
                    l3Var4.F = l3Var4.E.c();
                    if (l3.this.F != 0) {
                        l3 l3Var5 = l3.this;
                        l3Var5.G = l3Var5.E.e() + 1;
                    }
                }
                l3 l3Var6 = l3.this;
                l3Var6.H = l3Var6.s0.m();
            }
            l3 l3Var7 = l3.this;
            if (l3Var7.x0) {
                l3Var7.y0 = l3Var7.s0.f();
                l3.this.b.setIsCacheAd("1");
                if (l3.this.y0 > 0) {
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    l3 l3Var8 = l3.this;
                    l3Var8.b.setCacheTime(String.valueOf(jCurrentTimeMillis - l3Var8.y0));
                }
                l3.this.H0();
            }
            if (l3.this.s0.q() != null) {
                try {
                    l3 l3Var9 = l3.this;
                    l3Var9.a(Double.parseDouble(l3Var9.s0.q()));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            l3.this.f0();
            if (miVar == null) {
                l3.this.a(-991);
                return;
            }
            l3 l3Var10 = l3.this;
            l3Var10.r0 = miVar;
            l3Var10.b1();
        }

        @Override // com.beizi.fusion.ki
        public void onAdFailed(int i) {
            Log.d("BeiZis", "showBeiZiNativeUnifiedAd onAdFailed: " + i);
            l3.this.a(String.valueOf(i), i);
        }
    }

    public class j implements of.f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ TextView f27495a;
        final /* synthetic */ ImageView b;

        public j(TextView textView, ImageView imageView) {
            this.f27495a = textView;
            this.b = imageView;
        }

        @Override // com.beizi.fusion.of.f
        public void a() {
        }

        @Override // com.beizi.fusion.of.f
        public void a(Bitmap bitmap) {
            try {
                TextView textView = this.f27495a;
                if (textView != null) {
                    textView.setVisibility(8);
                }
                ImageView imageView = this.b;
                if (imageView != null) {
                    imageView.setVisibility(0);
                    this.b.setImageBitmap(bitmap);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public class k implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ View f27496a;

        public k(View view) {
            this.f27496a = view;
        }

        @Override // java.lang.Runnable
        public void run() {
            l3 l3Var = l3.this;
            jp jpVar = l3Var.s0;
            int optimizeSize = l3Var.d0.getOptimizeSize();
            View view = this.f27496a;
            l3 l3Var2 = l3.this;
            jpVar.a(optimizeSize, view, l3Var2.a0, l3Var2.d0.getDirection());
        }
    }

    public class l implements ji {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        boolean f27497a = false;

        public l() {
        }

        @Override // com.beizi.fusion.ji
        public void a() {
            l3.this.S0();
        }

        @Override // com.beizi.fusion.ji
        public void b() {
            Log.d("BeiZis", "showBeiZiNativeAd onAdWillLeaveApplication");
        }
    }

    public class m implements oi {
        public m() {
        }

        @Override // com.beizi.fusion.oi
        public void onAdShown() {
            Log.d("BeiZis", "showBeiZiNativeAd onAdShown()");
            l3.this.K0 = System.currentTimeMillis();
            l3.this.j = b2.ADSHOW;
            l3 l3Var = l3.this;
            if (l3Var.x0) {
                l3Var.b.setIsCacheAd("1");
                if (l3.this.y0 > 0) {
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    l3 l3Var2 = l3.this;
                    l3Var2.b.setCacheTime(String.valueOf(jCurrentTimeMillis - l3Var2.y0));
                }
                l3.this.H0();
            }
            if (l3.this.d != null && l3.this.d.z() != 2) {
                l3.this.d.d(l3.this.x());
            }
            l3.this.i0();
            l3.this.d0();
            l3.this.L0();
            l3.this.M0();
            l3.this.P0();
            l3.this.N0();
        }
    }

    public class n implements ri.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f27499a;
        final /* synthetic */ int b;
        final /* synthetic */ mi c;

        public class a implements ji {
            public a() {
            }

            @Override // com.beizi.fusion.ji
            public void a() {
                l3.this.S0();
                l3.this.B0();
            }

            @Override // com.beizi.fusion.ji
            public void b() {
            }
        }

        public n(int i, int i2, mi miVar) {
            this.f27499a = i;
            this.b = i2;
            this.c = miVar;
        }

        @Override // com.beizi.fusion.ri.b
        public void a() {
            AdSpacesBean.BuyerBean.CoolShakeViewBean coolShakeViewBean;
            try {
                if (yp.a(l3.this.b0)) {
                    l3 l3Var = l3.this;
                    if (l3Var.M0) {
                        return;
                    }
                    l3Var.C0 = true;
                    l3Var.M0 = true;
                    int[] iArr = new int[2];
                    l3Var.b0.getLocationOnScreen(iArr);
                    int[] iArrB = ol.b(this.f27499a / 2, this.b / 2);
                    if (this.c != null) {
                        l3 l3Var2 = l3.this;
                        if (l3Var2.b0 != null) {
                            l3Var2.Q0();
                            this.c.a(l3.this.b0, String.valueOf(iArrB[0]), String.valueOf(iArrB[1]), String.valueOf(iArrB[0] + iArr[0]), String.valueOf(iArrB[1] + iArr[1]), 2, new a());
                        }
                    }
                    l3 l3Var3 = l3.this;
                    if (!l3Var3.j0 || (coolShakeViewBean = l3Var3.g0) == null) {
                        return;
                    }
                    l3Var3.j0 = false;
                    l3Var3.h0.b(coolShakeViewBean);
                    l3 l3Var4 = l3.this;
                    co.b(l3Var4.U, l3Var4.i0, Long.valueOf(System.currentTimeMillis()));
                    qn.a().a(l3.this.i0, System.currentTimeMillis());
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public class o implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ AdSpacesBean.BuyerBean.ShakeViewBean f27501a;

        public o(AdSpacesBean.BuyerBean.ShakeViewBean shakeViewBean) {
            this.f27501a = shakeViewBean;
        }

        @Override // java.lang.Runnable
        public void run() {
            l3.this.h0.a(this.f27501a);
        }
    }

    public class p implements e7.c {
        public p() {
        }

        @Override // com.beizi.fusion.e7.c
        public void a() {
            try {
                if (l3.this.d != null && l3.this.d.z() != 2) {
                    l3.this.d.a(l3.this.x(), l3.this.b0);
                }
                l3.this.b0();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public class q implements ji {
        public q() {
        }

        @Override // com.beizi.fusion.ji
        public void a() {
            l3.this.S0();
        }

        @Override // com.beizi.fusion.ji
        public void b() {
        }
    }

    public l3(Context context, String str, long j2, long j3, AdSpacesBean.BuyerBean buyerBean, AdSpacesBean.ForwardBean forwardBean, m3 m3Var, float f2, float f3) {
        this.U = context;
        this.V = str;
        this.W = j2;
        this.X = j3;
        this.e = buyerBean;
        this.d = m3Var;
        this.f = forwardBean;
        this.Y = f2;
        this.Z = f3;
        this.a0 = new SplashContainer(context);
        C();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void M0() {
        try {
            if (this.D0 && this.a0 != null && this.U != null) {
                this.H0 = new FrameLayout(this.U);
                int width = this.a0.getWidth();
                int height = this.a0.getHeight();
                if (width <= 0) {
                    width = -1;
                }
                if (height <= 0) {
                    height = -1;
                }
                this.H0.setLayoutParams(new FrameLayout.LayoutParams(width, height));
                this.H0.setBackgroundColor(Color.parseColor(this.O0));
                this.a0.addView(this.H0);
                this.H0.setOnTouchListener(new a());
                this.H0.getViewTreeObserver().addOnScrollChangedListener(this.W0);
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
                handler.postDelayed(new h(), iK);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private void O0() {
        ViewGroup viewGroup = this.a0;
        if (viewGroup == null) {
            return;
        }
        viewGroup.setOnTouchListener(new e());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void P0() {
        AdSpacesBean.BuyerBean buyerBean;
        AdSpacesBean.NativeOptimizeBean nativeOptimize;
        AdSpacesBean.NativeOptimizeClickAreaBean clickArea;
        try {
            if (this.a0 != null && this.U != null && (buyerBean = this.e) != null) {
                if ((this.P0 || this.Q0) && (nativeOptimize = buyerBean.getNativeOptimize()) != null && (clickArea = nativeOptimize.getClickArea()) != null && ol.a(clickArea.getRandomNum())) {
                    int reference = clickArea.getReference();
                    String width = clickArea.getWidth();
                    String height = clickArea.getHeight();
                    String horizontalSpace = clickArea.getHorizontalSpace();
                    String verticalSpace = clickArea.getVerticalSpace();
                    View rootView = this.a0.getRootView();
                    if (rootView == null) {
                        return;
                    }
                    ViewGroup viewGroup = (ViewGroup) rootView.findViewById(android.R.id.content);
                    this.R0 = viewGroup;
                    if (viewGroup == null) {
                        return;
                    }
                    int iJ = so.j(this.U);
                    int iG = so.g(this.U);
                    int width2 = this.a0.getWidth();
                    int height2 = this.a0.getHeight();
                    int[] iArr = new int[2];
                    this.a0.getLocationOnScreen(iArr);
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
                    this.S0 = new FrameLayout(this.U);
                    this.S0.setLayoutParams(new FrameLayout.LayoutParams(iJ, i4));
                    int iA = a(horizontalSpace, iJ, width2, i2);
                    int iB = b(verticalSpace, i4, height2, i3);
                    int iA2 = so.a(this.U, 25.0f);
                    if (iB > iA2) {
                        iB -= iA2;
                    }
                    this.S0.setX(iA);
                    this.S0.setY(iB);
                    this.S0.setBackgroundColor(Color.parseColor(this.O0));
                    this.R0.addView(this.S0);
                    this.S0.setOnTouchListener(new c(new float[4]));
                    this.a0.getViewTreeObserver().addOnScrollChangedListener(this.X0);
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Q0() {
        ri riVar;
        try {
            if (this.E != null && (riVar = this.h0) != null) {
                if (this.g0 == null) {
                    riVar.a(1.9d, 1.5d);
                }
                if (this.G != 1) {
                    return;
                }
                double dB = this.E.b();
                double dA = this.E.a();
                double dC = this.h0.c();
                double d2 = this.h0.d();
                if (dA > AudioStats.AUDIO_AMPLITUDE_NONE && dC > AudioStats.AUDIO_AMPLITUDE_NONE && dC < dA) {
                    this.G = 2;
                } else if (dB > AudioStats.AUDIO_AMPLITUDE_NONE && d2 > AudioStats.AUDIO_AMPLITUDE_NONE && d2 < dB) {
                    this.G = 2;
                }
                mi miVar = this.r0;
                if (miVar != null) {
                    miVar.a(this.G);
                }
            }
        } catch (Exception unused) {
        }
    }

    private void R0() {
        AdSpacesBean.BuyerBean.DislikeConfigBean dislikeConfig = this.e.getDislikeConfig();
        this.k0 = dislikeConfig;
        if (dislikeConfig == null) {
            return;
        }
        String dislikeUuid = dislikeConfig.getDislikeUuid();
        AdSpacesBean.BuyerBean.DislikeConfigBean dislikeConfigBeanA = a(this.k0.getOrderData(), this.s0.c());
        if (dislikeConfigBeanA != null) {
            this.l0 = dislikeConfigBeanA;
            dislikeUuid = dislikeConfigBeanA.getDislikeUuid();
        }
        EventBean eventBean = this.b;
        if (eventBean != null) {
            eventBean.setDislikeUuid(dislikeUuid);
            H0();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void S0() {
        AdSpacesBean.BuyerBean buyerBean;
        Log.d("BeiZis", "showBeiZiNativeAd onAdWasClicked");
        this.C0 = true;
        this.M0 = false;
        this.N0 = false;
        a1();
        if (this.I && (buyerBean = this.e) != null) {
            this.b.setCallBackStrategyUuid(buyerBean.getCallBackStrategyUuid());
            H0();
        }
        Z();
        a(this.U, this.a0, this.H);
        if (O()) {
            m3 m3Var = this.d;
            if (m3Var != null && m3Var.z() != 2) {
                this.d.b(x());
            }
            Y();
            I0();
            jp jpVar = this.s0;
            if (jpVar != null) {
                jpVar.y();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void T0() {
        try {
            if (!this.M0 && !this.C0) {
                double width = this.a0.getWidth();
                int[] iArr = {((int) (0.1d * width)) / 2, (int) (((double) this.a0.getHeight()) * 0.8d)};
                int[] iArrB = ol.b(((int) (width * 0.9d)) / 2, so.a(this.U, 65.0f) / 2);
                a(new String[]{String.valueOf(iArrB[0]), String.valueOf(iArrB[1]), String.valueOf(iArrB[0] + iArr[0]), String.valueOf(iArrB[1] + iArr[1])}, 0);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private boolean W0() {
        AdSpacesBean.BuyerBean.ShakeViewBean shakeViewBean = this.f0;
        if (shakeViewBean == null) {
            return false;
        }
        return ol.a(shakeViewBean.getRenderRate());
    }

    private boolean X0() {
        try {
            return System.currentTimeMillis() - so.a(this.U).longValue() < this.g0.getUserProtectTime();
        } catch (Exception e2) {
            e2.printStackTrace();
            return false;
        }
    }

    private boolean Y0() {
        try {
            AdSpacesBean.BuyerBean.DislikeConfigBean dislikeConfigBean = this.l0;
            if (dislikeConfigBean != null) {
                return dislikeConfigBean.getIsShowDialog() == 1;
            }
            AdSpacesBean.BuyerBean.DislikeConfigBean dislikeConfigBean2 = this.k0;
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
            FrameLayout frameLayout3 = this.H0;
            if (frameLayout3 != null && this.W0 != null) {
                frameLayout3.getViewTreeObserver().removeOnScrollChangedListener(this.W0);
            }
            ViewGroup viewGroup = this.a0;
            if (viewGroup != null && (frameLayout2 = this.H0) != null) {
                viewGroup.removeView(frameLayout2);
                this.H0 = null;
            }
            ViewGroup viewGroup2 = this.a0;
            if (viewGroup2 != null && this.X0 != null) {
                viewGroup2.getViewTreeObserver().removeOnScrollChangedListener(this.X0);
            }
            ViewGroup viewGroup3 = this.R0;
            if (viewGroup3 == null || (frameLayout = this.S0) == null) {
                return;
            }
            viewGroup3.removeView(frameLayout);
            this.S0 = null;
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
        this.u0 = this.e.getComplain();
        this.v0 = "complain_config_" + this.i;
        AdSpacesBean.NativeOptimizeBean nativeOptimize = this.e.getNativeOptimize();
        if (nativeOptimize != null) {
            this.L0 = nativeOptimize.getNativeUuid();
            AdSpacesBean.NativeOptimizeAdSlideBean adSlide = nativeOptimize.getAdSlide();
            if (adSlide != null) {
                this.D0 = ol.a(adSlide.getRandomNum());
                this.E0 = adSlide.getNeedTime();
                this.F0 = adSlide.getDistance();
            }
            this.N0 = ol.a(nativeOptimize.getCloseClickNum());
            this.P0 = ol.a(nativeOptimize.getTouchDownNum());
            this.Q0 = ol.a(nativeOptimize.getHoldSlideNum());
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
        this.c0 = renderView;
        if (renderView != null && renderView.size() > 0) {
            AdSpacesBean.RenderViewBean renderViewBean = (AdSpacesBean.RenderViewBean) this.c0.get(0);
            this.d0 = renderViewBean;
            this.e0 = k6.a(renderViewBean.getDpLinkUrlList());
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
            if (!q1.h().v() || (riVar = this.h0) == null) {
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
        jp jpVar = this.s0;
        if (jpVar == null) {
            return false;
        }
        return jpVar.v();
    }

    @Override // com.beizi.fusion.d2
    public void S() {
        BZVideoView bZVideoView;
        try {
            if (TextUtils.isEmpty(this.V0) || (bZVideoView = this.U0) == null) {
                return;
            }
            bZVideoView.onViewPause(true);
        } catch (Exception unused) {
        }
    }

    @Override // com.beizi.fusion.d2
    public void T() {
        BZVideoView bZVideoView;
        try {
            ri riVar = this.h0;
            if (riVar != null) {
                riVar.g();
            }
            if (TextUtils.isEmpty(this.V0) || (bZVideoView = this.U0) == null) {
                return;
            }
            bZVideoView.onViewResume(true);
        } catch (Exception unused) {
        }
    }

    @Override // com.beizi.fusion.d2
    public void U() {
        ri riVar;
        try {
            if (!q1.h().v() || (riVar = this.h0) == null) {
                return;
            }
            riVar.a(false);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public boolean U0() {
        AdSpacesBean.BuyerBean.DislikeConfigBean dislikeConfigBean = this.l0;
        if (dislikeConfigBean != null) {
            return dislikeConfigBean.getIsHide() == 0;
        }
        AdSpacesBean.BuyerBean.DislikeConfigBean dislikeConfigBean2 = this.k0;
        return dislikeConfigBean2 != null && dislikeConfigBean2.getIsHide() == 0;
    }

    public boolean V0() {
        return this.N0;
    }

    public void Z0() {
        try {
            if (!V()) {
                A();
                return;
            }
            m3 m3Var = this.d;
            if (m3Var == null) {
                return;
            }
            Log.d("BeiZis", x() + " NativeAdWorker:" + m3Var.C().toString());
            f();
            s5 s5Var = this.g;
            if (s5Var == s5.SUCCESS) {
                if (this.b0 != null) {
                    this.d.b(x(), this.b0);
                    return;
                } else {
                    this.d.a(10140);
                    return;
                }
            }
            if (s5Var == s5.FAIL) {
                Log.d("BeiZis", "other worker shown," + x() + " remove");
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public abstract void a(mi miVar);

    public abstract void b1();

    public void c1() {
        try {
            mi miVar = this.r0;
            if (miVar != null && this.t0 != null) {
                miVar.a(this.G);
                if (!this.P0 && !this.Q0) {
                    pi.a(this.r0, this.t0, new l());
                    return;
                }
                O0();
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void d1() {
        View view;
        try {
            jp jpVar = this.s0;
            if (jpVar != null && (view = this.t0) != null) {
                jpVar.a(view, new m());
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void e1() {
        try {
            if (Y0()) {
                e7.a aVar = new e7.a(this.U);
                aVar.a(new p());
                aVar.a().show();
            } else {
                m3 m3Var = this.d;
                if (m3Var != null && m3Var.z() != 2) {
                    this.d.a(x(), this.b0);
                }
                b0();
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    @Override // com.beizi.fusion.d2
    public String x() {
        return "BEIZI";
    }

    @Override // com.beizi.fusion.d2
    public void z() {
        if (!L() || this.s0 == null) {
            return;
        }
        F0();
    }

    @Override // com.beizi.fusion.d2
    public void z0() {
        g0();
        K0();
        AdSpacesBean.BuyerBean.ShakeViewBean shakeView = this.e.getShakeView();
        this.f0 = shakeView;
        if (shakeView != null) {
            this.g0 = shakeView.getCoolShakeView();
        }
        this.i0 = "cool_" + this.i;
        this.q0 = "dl_cool_" + this.i;
        if (this.Y <= 0.0f) {
            this.Y = so.i(this.U);
        }
        if (this.Z <= 0.0f) {
            this.Z = 0.0f;
        }
        jp jpVar = new jp(this.U, this.i, new i());
        this.s0 = jpVar;
        jpVar.b(true);
        try {
            this.s0.a(this.b.m167clone());
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        this.s0.a((int) this.W);
        this.s0.a(this.e);
        if ("S2S".equals(l())) {
            this.s0.c(l());
            m3 m3Var = this.d;
            if (m3Var != null) {
                String strQ = m3Var.q();
                if (!TextUtils.isEmpty(strQ)) {
                    this.s0.b(strQ);
                }
            }
        }
        m3 m3Var2 = this.d;
        if (m3Var2 != null) {
            this.s0.c(m3Var2.y());
            this.s0.d(this.d.v());
        }
        this.s0.w();
    }

    @Override // com.beizi.fusion.d2
    public void g() {
        mi miVar = this.r0;
        if (miVar != null) {
            miVar.destroy();
        }
        jp jpVar = this.s0;
        if (jpVar != null) {
            jpVar.a();
        }
        ri riVar = this.h0;
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
        jp jpVar = this.s0;
        if (jpVar == null) {
            return null;
        }
        return jpVar.d();
    }

    @Override // com.beizi.fusion.d2
    public JSONObject p() {
        jp jpVar = this.s0;
        if (jpVar == null) {
            return null;
        }
        return jpVar.l();
    }

    @Override // com.beizi.fusion.d2
    public View r() {
        return this.b0;
    }

    @Override // com.beizi.fusion.d2
    public String s() {
        jp jpVar = this.s0;
        if (jpVar == null) {
            return null;
        }
        return jpVar.q();
    }

    @Override // com.beizi.fusion.d2
    public void c(Map map) {
        Object obj;
        Object obj2;
        Object obj3;
        try {
            jp jpVar = this.s0;
            if (jpVar == null) {
                return;
            }
            jpVar.a(map);
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

    @Override // com.beizi.fusion.d2
    public void d(Map map) {
        Object obj;
        Object obj2;
        Object obj3;
        Object obj4;
        try {
            jp jpVar = this.s0;
            if (jpVar == null) {
                return;
            }
            jpVar.b(map);
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

    private void b(AdSpacesBean.BuyerBean.ShakeViewBean shakeViewBean) {
        if (shakeViewBean == null) {
            shakeViewBean = this.f0;
        }
        int regulatoryAngle = shakeViewBean.getRegulatoryAngle();
        int isUnidirection = shakeViewBean.getIsUnidirection();
        ri riVar = this.h0;
        if (riVar != null) {
            riVar.b(regulatoryAngle);
            this.h0.d(isUnidirection);
            f5 f5Var = this.E;
            if (f5Var != null) {
                this.h0.a(f5Var.b());
            }
        }
        if (this.g0 == null) {
            this.j0 = true;
            this.h0.a(shakeViewBean);
        } else if (a(shakeViewBean)) {
            this.h0.b(this.g0);
        } else if (X0()) {
            this.h0.b(this.g0);
        } else {
            this.j0 = true;
            this.h0.a(shakeViewBean);
        }
    }

    public void a(TextView textView, ImageView imageView) {
        ArrayList arrayListL;
        try {
            mi miVar = this.r0;
            if (miVar == null) {
                return;
            }
            String strK = miVar.k();
            if (TextUtils.isEmpty(strK) && (arrayListL = this.r0.l()) != null && arrayListL.size() >= 3) {
                strK = (String) arrayListL.get(2);
            }
            if (TextUtils.isEmpty(strK)) {
                if (textView != null) {
                    textView.setVisibility(8);
                }
                if (imageView != null) {
                    imageView.setVisibility(8);
                    return;
                }
                return;
            }
            if (strK.startsWith("http")) {
                of.a((Context) null).a(strK, new j(textView, imageView));
                return;
            }
            if (imageView != null) {
                imageView.setVisibility(8);
            }
            if (textView != null) {
                textView.setVisibility(0);
                textView.setText(strK);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void a(View view) {
        try {
            int iA = so.a(this.U, this.Y);
            float f2 = this.Z;
            int iA2 = f2 > 0.0f ? so.a(this.U, f2) : -2;
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(iA, iA2);
            ViewGroup viewGroup = this.a0;
            if (viewGroup != null) {
                viewGroup.removeAllViews();
                StringBuilder sb = new StringBuilder();
                sb.append("mNativeAd != null ? ");
                boolean z = true;
                sb.append(this.s0 != null);
                sb.append(",renderViewBean != null ? ");
                if (this.d0 == null) {
                    z = false;
                }
                sb.append(z);
                jh.a("BeiZis", sb.toString());
                this.a0.addView(this.t0, layoutParams);
                this.t0.measure(0, 0);
                a(this.r0, iA, iA2, this.t0.getMeasuredHeight());
                R0();
                if (U0()) {
                    a(this.r0);
                }
                ViewGroup viewGroup2 = this.a0;
                this.b0 = viewGroup2;
                ri riVar = this.h0;
                if (riVar != null) {
                    riVar.a(viewGroup2);
                }
            }
            jp jpVar = this.s0;
            if (jpVar == null || this.d0 == null) {
                return;
            }
            jpVar.a(this.e0);
            this.s0.b(this.d0.getOptimizePercent());
            jh.a("BeiZis", "percent = " + this.d0.getOptimizePercent());
            this.a0.post(new k(view));
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

    @Override // com.beizi.fusion.d2
    public void b(int i2) {
        jp jpVar = this.s0;
        if (jpVar == null) {
            return;
        }
        jpVar.a(this.a0, i2);
    }

    private void a(mi miVar, int i2, int i3, int i4) {
        AdSpacesBean.BuyerBean.ShakeViewBean shakeView;
        try {
            if (!q1.h().u() && W0()) {
                if (this.h0 == null) {
                    this.h0 = new ri(this.U);
                }
                AdSpacesBean.BuyerBean.ShakeViewBean shakeViewBean = this.f0;
                if (shakeViewBean == null || this.h0 == null || shakeViewBean.getPosition() == null) {
                    return;
                }
                String shakeViewUuid = this.f0.getShakeViewUuid();
                AdSpacesBean.BuyerBean.OrderDataShakeViewBean orderDataShakeViewBeanB = b(this.f0.getOrderData(), this.s0.c());
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
                this.h0.a(this.w0);
                View viewA = this.h0.a(so.b(this.U, i2), so.b(this.U, i3), this.f0.getPosition());
                if (viewA != null) {
                    ViewGroup.LayoutParams layoutParams = viewA.getLayoutParams();
                    if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(marginLayoutParams.width, marginLayoutParams.height);
                        layoutParams2.leftMargin = marginLayoutParams.leftMargin;
                        layoutParams2.topMargin = marginLayoutParams.topMargin;
                        AdSpacesBean.BuyerBean.ShakeViewBean shakeViewBean2 = this.f0;
                        if (shakeViewBean2 != null && shakeViewBean2.getIsHideAnim() == 0) {
                            this.a0.addView(viewA, layoutParams2);
                        }
                    }
                }
                b(shakeView);
                this.h0.a(new n(i2, i3, miVar));
                AdSpacesBean.BuyerBean.CoolShakeViewBean coolShakeViewBean = this.g0;
                if (coolShakeViewBean != null) {
                    this.h0.a(coolShakeViewBean, this.i0);
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private boolean a(AdSpacesBean.BuyerBean.ShakeViewBean shakeViewBean) {
        long jLongValue = ((Long) co.a(this.U, this.i0, (Object) 0L)).longValue();
        if (jLongValue != 0) {
            long jCurrentTimeMillis = System.currentTimeMillis() - jLongValue;
            if (jCurrentTimeMillis < this.g0.getCoolTime()) {
                new Handler().postDelayed(new o(shakeViewBean), this.g0.getCoolTime() - jCurrentTimeMillis);
                return true;
            }
            qn.a().b(this.i0);
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

    public void a(String[] strArr, int i2) {
        View view;
        try {
            a1();
            if (this.r0 != null && this.b0 != null && !this.M0 && !this.C0) {
                this.C0 = true;
                this.M0 = true;
                EventBean eventBean = this.b;
                if (eventBean != null) {
                    eventBean.setNativeRuleUuid(this.L0);
                    H0();
                }
                mi miVar = this.r0;
                if (miVar == null || (view = this.b0) == null) {
                    return;
                }
                miVar.a(view, strArr[0], strArr[1], strArr[2], strArr[3], 0, new q());
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
            if (this.r0 != null && this.b0 != null && !this.M0) {
                this.C0 = true;
                this.M0 = true;
                EventBean eventBean = this.b;
                if (eventBean != null) {
                    eventBean.setNativeRuleUuid(this.L0);
                    H0();
                }
                mi miVar = this.r0;
                if (miVar == null || (view = this.b0) == null) {
                    return;
                }
                miVar.a(view, strArr[0], strArr[1], strArr[2], strArr[3], 0, new f());
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void a(int i2, int i3, float f2, Bitmap bitmap, ImageView imageView) {
        try {
            float fAbs = Math.abs(((float) ((((double) i2) * 1.0d) / ((double) i3))) - f2);
            if (fAbs > 0.15f) {
                w3.c().e().execute(new g(bitmap, imageView));
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

    public void a(int i2, int i3) {
        double d2 = i3;
        double d3 = i2;
        if (d2 >= 0.25d * d3 && !this.Z0) {
            this.Z0 = true;
            b(25);
        }
        if (d2 >= 0.5d * d3 && !this.a1) {
            this.a1 = true;
            b(50);
        }
        if (d2 < d3 * 0.75d || this.b1) {
            return;
        }
        this.b1 = true;
        b(75);
    }
}
