package com.beizi.fusion;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.camera.video.AudioStats;
import com.beizi.ad.internal.activity.DownloadAppInfoActivity;
import com.beizi.ad.lance.ApkBean;
import com.beizi.fusion.events.EventBean;
import com.beizi.fusion.model.AdSpacesBean;
import com.beizi.fusion.model.UnifiedAdDownloadAppInfo;
import com.beizi.fusion.widget.BZVideoView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class f4 extends n3 {
    private FrameLayout A0;
    private boolean B0;
    private String[] C0;
    private long D0;
    private String E0;
    private boolean F0;
    private boolean G0;
    private String H0;
    private boolean I0;
    private boolean J0;
    private ViewGroup K0;
    private FrameLayout L0;
    private long M0;
    private boolean N0;
    private String[] O0;
    private String[] P0;
    private int Q0;
    private boolean R0;
    private boolean S0;
    private BZVideoView T0;
    private ViewTreeObserver.OnScrollChangedListener U0;
    private ViewTreeObserver.OnScrollChangedListener V0;
    private boolean W0;
    private boolean X0;
    private boolean Y0;
    private boolean Z0;
    private boolean a1;
    private np b1;
    private jp c0;
    private String[] c1;
    private mi d0;
    private FrameLayout d1;
    private AdSpacesBean.BuyerBean.ShakeViewBean e0;
    private int e1;
    private AdSpacesBean.BuyerBean.CoolShakeViewBean f0;
    private boolean f1;
    private ri g0;
    private long g1;
    private String h0;
    private ViewTreeObserver.OnScrollChangedListener h1;
    private boolean i0;
    private int j0;
    private int k0;
    private int l0;
    private View m0;
    private String n0;
    private boolean o0;
    private boolean p0;
    private Boolean q0;
    private boolean r0;
    private long s0;
    private long t0;
    private long u0;
    private boolean v0;
    private boolean w0;
    private long x0;
    private int y0;
    private int z0;

    public class a implements View.OnTouchListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ float[] f27263a;

        public a(float[] fArr) {
            this.f27263a = fArr;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            try {
                if (motionEvent.getAction() == 0) {
                    this.f27263a[0] = motionEvent.getX();
                    this.f27263a[1] = motionEvent.getY();
                    this.f27263a[2] = motionEvent.getRawX();
                    this.f27263a[3] = motionEvent.getRawY();
                    f4 f4Var = f4.this;
                    if (f4Var.I0) {
                        FrameLayout frameLayout = f4Var.L0;
                        FrameLayout frameLayout2 = f4Var.Z;
                        float[] fArr = this.f27263a;
                        f4.this.a(f4Var.a(frameLayout, frameLayout2, fArr[0], fArr[1], fArr[2], fArr[3]), 0);
                    }
                }
                if (motionEvent.getAction() == 1) {
                    f4 f4Var2 = f4.this;
                    if (f4Var2.J0) {
                        FrameLayout frameLayout3 = f4Var2.L0;
                        FrameLayout frameLayout4 = f4Var2.Z;
                        float[] fArr2 = this.f27263a;
                        f4.this.a(f4Var2.a(frameLayout3, frameLayout4, fArr2[0], fArr2[1], fArr2[2], fArr2[3]), 0);
                    }
                }
                f4 f4Var3 = f4.this;
                return f4Var3.I0 || f4Var3.J0;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public class b implements ViewTreeObserver.OnScrollChangedListener {
        public b() {
        }

        @Override // android.view.ViewTreeObserver.OnScrollChangedListener
        public void onScrollChanged() {
            ViewGroup viewGroup;
            try {
                if (f4.this.Z == null) {
                    return;
                }
                long jCurrentTimeMillis = System.currentTimeMillis();
                f4 f4Var = f4.this;
                if (jCurrentTimeMillis - f4Var.M0 < 100) {
                    return;
                }
                f4Var.M0 = System.currentTimeMillis();
                int[] iArr = new int[2];
                f4.this.Z.getLocationOnScreen(iArr);
                if (iArr[1] < 0) {
                    f4.this.Z.getViewTreeObserver().removeOnScrollChangedListener(this);
                    f4 f4Var2 = f4.this;
                    FrameLayout frameLayout = f4Var2.L0;
                    if (frameLayout == null || (viewGroup = f4Var2.K0) == null) {
                        return;
                    }
                    viewGroup.removeView(frameLayout);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public class c implements View.OnTouchListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        String[] f27265a = new String[4];
        final /* synthetic */ View b;

        public c(View view) {
            this.b = view;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            View view2;
            ViewParent parent;
            try {
                if (motionEvent.getAction() == 0) {
                    f4 f4Var = f4.this;
                    if ((f4Var.I0 || f4Var.J0) && (view2 = this.b) != null && (parent = view2.getParent()) != null) {
                        parent.requestDisallowInterceptTouchEvent(true);
                    }
                    this.f27265a[0] = motionEvent.getX() + "";
                    this.f27265a[1] = motionEvent.getY() + "";
                    this.f27265a[2] = motionEvent.getRawX() + "";
                    this.f27265a[3] = motionEvent.getRawY() + "";
                    f4 f4Var2 = f4.this;
                    if (f4Var2.I0) {
                        f4Var2.a(this.f27265a);
                    }
                }
                if (motionEvent.getAction() == 1) {
                    f4 f4Var3 = f4.this;
                    if (f4Var3.J0) {
                        f4Var3.a(this.f27265a);
                    }
                }
                f4 f4Var4 = f4.this;
                return f4Var4.I0 || f4Var4.J0;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public class d implements ji {
        public d() {
        }

        @Override // com.beizi.fusion.ji
        public void a() {
            f4.this.i1();
        }

        @Override // com.beizi.fusion.ji
        public void b() {
        }
    }

    public class e implements View.OnTouchListener {
        public e() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (motionEvent.getAction() == 0) {
                f4 f4Var = f4.this;
                f4Var.f1 = true;
                f4Var.c1[0] = motionEvent.getX() + "";
                f4.this.c1[1] = motionEvent.getY() + "";
                f4.this.c1[2] = motionEvent.getRawX() + "";
                f4.this.c1[3] = motionEvent.getRawY() + "";
            }
            return false;
        }
    }

    public class f implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f27268a;

        public f(int i) {
            this.f27268a = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            try {
                int i = this.f27268a;
                if (i == 1) {
                    BZVideoView bZVideoView = f4.this.T0;
                    if (bZVideoView != null) {
                        bZVideoView.onViewPause(true);
                        return;
                    }
                    return;
                }
                if (i == 2) {
                    f4 f4Var = f4.this;
                    f4Var.a(f4Var.c1);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public class g implements ViewTreeObserver.OnScrollChangedListener {
        public g() {
        }

        @Override // android.view.ViewTreeObserver.OnScrollChangedListener
        public void onScrollChanged() {
            try {
                f4 f4Var = f4.this;
                if (f4Var.f1 && !f4Var.v0) {
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    f4 f4Var2 = f4.this;
                    if (jCurrentTimeMillis - f4Var2.g1 < 100) {
                        return;
                    }
                    f4Var2.g1 = System.currentTimeMillis();
                    int[] iArr = new int[2];
                    FrameLayout frameLayout = f4.this.Z;
                    if (frameLayout != null) {
                        frameLayout.getLocationOnScreen(iArr);
                    }
                    int i = iArr[1];
                    if (i > 0) {
                        f4 f4Var3 = f4.this;
                        if (f4Var3.e1 == 0) {
                            f4Var3.e1 = i;
                        }
                    }
                    if (Math.abs(f4.this.e1 - i) < 30) {
                        return;
                    }
                    f4 f4Var4 = f4.this;
                    f4Var4.a(f4Var4.c1, 0);
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
                if (yp.a(f4.this.Z)) {
                    f4 f4Var = f4.this;
                    if (f4Var.v0) {
                        return;
                    }
                    f4Var.G = 2;
                    f4 f4Var2 = f4.this;
                    mi miVar = f4Var2.d0;
                    if (miVar != null) {
                        miVar.a(f4Var2.G);
                    }
                    f4.this.j1();
                    f4.this.B0();
                    f4 f4Var3 = f4.this;
                    mi miVar2 = f4Var3.d0;
                    if (miVar2 != null) {
                        miVar2.a(f4Var3.G);
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
            f4.this.j = b2.ADLOAD;
            f4 f4Var = f4.this;
            f4Var.q0 = Boolean.valueOf(f4Var.c0.s());
            f4 f4Var2 = f4.this;
            f4Var2.r0 = f4Var2.c0.u();
            f4 f4Var3 = f4.this;
            jp jpVar = f4Var3.c0;
            if (jpVar != null) {
                f4Var3.E = jpVar.i();
                if (f4.this.E != null) {
                    f4 f4Var4 = f4.this;
                    f4Var4.F = f4Var4.E.c();
                    if (f4.this.F != 0) {
                        f4 f4Var5 = f4.this;
                        f4Var5.G = f4Var5.E.e() + 1;
                    }
                }
                f4 f4Var6 = f4.this;
                f4Var6.H = f4Var6.c0.m();
            }
            f4 f4Var7 = f4.this;
            if (f4Var7.r0) {
                f4Var7.s0 = f4Var7.c0.f();
                f4.this.b.setIsCacheAd("1");
                if (f4.this.s0 > 0) {
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    f4 f4Var8 = f4.this;
                    f4Var8.b.setCacheTime(String.valueOf(jCurrentTimeMillis - f4Var8.s0));
                }
                f4.this.H0();
            }
            if (f4.this.c0.q() != null) {
                try {
                    f4 f4Var9 = f4.this;
                    f4Var9.a(Double.parseDouble(f4Var9.c0.q()));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            f4.this.f0();
            if (miVar == null) {
                f4.this.a(-991);
                return;
            }
            f4 f4Var10 = f4.this;
            jp jpVar2 = f4Var10.c0;
            if (jpVar2 != null) {
                f4Var10.b1 = jpVar2.n();
            }
            f4 f4Var11 = f4.this;
            f4Var11.d0 = miVar;
            f4Var11.b1();
        }

        @Override // com.beizi.fusion.ki
        public void onAdFailed(int i) {
            Log.d("BeiZis", "showBeiZiNativeUnifiedAd onAdFailed: " + i);
            f4.this.a(String.valueOf(i), i);
        }
    }

    public class j implements BZVideoView.i {
        public j() {
        }

        @Override // com.beizi.fusion.widget.BZVideoView.i
        public void a(int i, int i2) {
            f4.this.a(i, i2);
        }

        @Override // com.beizi.fusion.widget.BZVideoView.i
        public void b() {
            f4 f4Var = f4.this;
            if (f4Var.W0) {
                return;
            }
            f4Var.W0 = true;
            f4Var.b(0);
        }

        @Override // com.beizi.fusion.widget.BZVideoView.i
        public void a() {
            f4 f4Var = f4.this;
            if (f4Var.a1) {
                return;
            }
            f4Var.a1 = true;
            f4Var.b(100);
        }
    }

    public class k implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ List f27273a;

        public class a implements ji {
            public a() {
            }

            @Override // com.beizi.fusion.ji
            public void a() {
                f4.this.i1();
            }

            @Override // com.beizi.fusion.ji
            public void b() {
                Log.d("BeiZis", "showBeiZiNativeUnifiedAd onAdWillLeaveApplication");
            }
        }

        public class b implements ji {
            public b() {
            }

            @Override // com.beizi.fusion.ji
            public void a() {
                f4.this.i1();
            }

            @Override // com.beizi.fusion.ji
            public void b() {
                Log.d("BeiZis", "showBeiZiNativeUnifiedAd onAdWillLeaveApplication");
            }
        }

        public class c implements oi {
            public c() {
            }

            @Override // com.beizi.fusion.oi
            public void onAdShown() {
                f4.this.k1();
            }
        }

        public k(List list) {
            this.f27273a = list;
        }

        @Override // java.lang.Runnable
        public void run() {
            jp jpVar;
            try {
                f4 f4Var = f4.this;
                if (f4Var.Z != null) {
                    f4Var.d1();
                    f4.this.p1();
                    f4 f4Var2 = f4.this;
                    f4Var2.j0 = f4Var2.Z.getWidth();
                    f4 f4Var3 = f4.this;
                    f4Var3.k0 = f4Var3.Z.getHeight();
                    f4 f4Var4 = f4.this;
                    int i = f4Var4.j0;
                    int i2 = f4Var4.k0;
                    f4Var4.a(i, i2, i2);
                }
                f4 f4Var5 = f4.this;
                mi miVar = f4Var5.d0;
                if (miVar != null) {
                    miVar.a(f4Var5.G);
                }
                f4 f4Var6 = f4.this;
                if (f4Var6.I0 || f4Var6.J0) {
                    f4Var6.b(this.f27273a);
                } else {
                    List list = this.f27273a;
                    if (list == null || list.size() <= 0) {
                        f4 f4Var7 = f4.this;
                        pi.a(f4Var7.d0, f4Var7.Z, new b());
                    } else {
                        f4 f4Var8 = f4.this;
                        pi.a(f4Var8.d0, f4Var8.Z, this.f27273a, new a());
                    }
                }
                f4.this.l1();
                f4 f4Var9 = f4.this;
                if (f4Var9.a0 || (jpVar = f4Var9.c0) == null) {
                    return;
                }
                jpVar.a(f4Var9.Z, new c());
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public class l implements ri.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f27277a;
        final /* synthetic */ int b;

        public class a implements ji {
            public a() {
            }

            @Override // com.beizi.fusion.ji
            public void a() {
                f4.this.i1();
                f4.this.B0();
            }

            @Override // com.beizi.fusion.ji
            public void b() {
            }
        }

        public l(int i, int i2) {
            this.f27277a = i;
            this.b = i2;
        }

        @Override // com.beizi.fusion.ri.b
        public void a() {
            AdSpacesBean.BuyerBean.CoolShakeViewBean coolShakeViewBean;
            try {
                if (yp.a(f4.this.Z)) {
                    f4 f4Var = f4.this;
                    if (f4Var.F0) {
                        return;
                    }
                    f4Var.v0 = true;
                    f4Var.F0 = true;
                    int[] iArr = new int[2];
                    f4Var.Z.getLocationOnScreen(iArr);
                    int[] iArrB = ol.b(this.f27277a / 2, this.b / 2);
                    f4 f4Var2 = f4.this;
                    if (f4Var2.d0 != null && f4Var2.Z != null) {
                        f4Var2.h1();
                        f4 f4Var3 = f4.this;
                        f4Var3.d0.a(f4Var3.Z, String.valueOf(iArrB[0]), String.valueOf(iArrB[1]), String.valueOf(iArrB[0] + iArr[0]), String.valueOf(iArrB[1] + iArr[1]), 2, new a());
                    }
                    f4 f4Var4 = f4.this;
                    if (!f4Var4.i0 || (coolShakeViewBean = f4Var4.f0) == null) {
                        return;
                    }
                    f4Var4.i0 = false;
                    f4Var4.g0.b(coolShakeViewBean);
                    f4 f4Var5 = f4.this;
                    co.b(f4Var5.U, f4Var5.h0, Long.valueOf(System.currentTimeMillis()));
                    qn.a().a(f4.this.h0, System.currentTimeMillis());
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public class m implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ AdSpacesBean.BuyerBean.ShakeViewBean f27279a;

        public m(AdSpacesBean.BuyerBean.ShakeViewBean shakeViewBean) {
            this.f27279a = shakeViewBean;
        }

        @Override // java.lang.Runnable
        public void run() {
            f4.this.g0.a(this.f27279a);
        }
    }

    public class n implements View.OnClickListener {
        public n() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ApkBean apkBeanP;
            try {
                f4 f4Var = f4.this;
                if (f4Var.U == null || (apkBeanP = f4Var.d0.p()) == null) {
                    return;
                }
                String apkName = apkBeanP.getApkName();
                String appPermissionsUrl = apkBeanP.getAppPermissionsUrl();
                String appPermissionsDesc = apkBeanP.getAppPermissionsDesc();
                if (TextUtils.isEmpty(appPermissionsUrl)) {
                    appPermissionsUrl = appPermissionsDesc;
                }
                String appPrivacyUrl = apkBeanP.getAppPrivacyUrl();
                String appintro = apkBeanP.getAppintro();
                Intent intent = new Intent(f4.this.U, (Class<?>) DownloadAppInfoActivity.class);
                intent.putExtra("title_content_key", apkName);
                intent.putExtra("privacy_content_key", appPrivacyUrl);
                intent.putExtra("permission_content_key", appPermissionsUrl);
                intent.putExtra("intro_content_key", appintro);
                intent.setFlags(268435456);
                f4.this.U.startActivity(intent);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public class o implements ji {
        public o() {
        }

        @Override // com.beizi.fusion.ji
        public void a() {
            f4.this.i1();
        }

        @Override // com.beizi.fusion.ji
        public void b() {
        }
    }

    public class p implements View.OnTouchListener {
        public p() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (motionEvent.getAction() == 0) {
                f4 f4Var = f4.this;
                f4Var.B0 = true;
                f4Var.C0[0] = motionEvent.getX() + "";
                f4.this.C0[1] = motionEvent.getY() + "";
                f4.this.C0[2] = motionEvent.getRawX() + "";
                f4.this.C0[3] = motionEvent.getRawY() + "";
            }
            return false;
        }
    }

    public class q implements ViewTreeObserver.OnScrollChangedListener {
        public q() {
        }

        @Override // android.view.ViewTreeObserver.OnScrollChangedListener
        public void onScrollChanged() {
            try {
                f4 f4Var = f4.this;
                if (f4Var.B0 && !f4Var.v0 && !f4Var.F0) {
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    f4 f4Var2 = f4.this;
                    if (jCurrentTimeMillis - f4Var2.D0 < f4Var2.x0) {
                        return;
                    }
                    long jCurrentTimeMillis2 = System.currentTimeMillis();
                    f4 f4Var3 = f4.this;
                    if (jCurrentTimeMillis2 - f4Var3.u0 < 50) {
                        return;
                    }
                    f4Var3.u0 = System.currentTimeMillis();
                    if (yp.a(f4.this.Z, 0.8d)) {
                        int[] iArr = new int[2];
                        FrameLayout frameLayout = f4.this.Z;
                        if (frameLayout != null) {
                            frameLayout.getLocationOnScreen(iArr);
                        }
                        int i = iArr[1];
                        if (i > 0) {
                            f4 f4Var4 = f4.this;
                            if (f4Var4.z0 == 0) {
                                f4Var4.z0 = i;
                            }
                        }
                        jh.b("BeiZis", "mOnScrollChangedListener mAdSlideScrollDistance:" + f4.this.z0 + ";mAdSlideClickDistance:" + f4.this.y0 + ";screenLocation[1]:" + iArr[1]);
                        int iAbs = Math.abs(f4.this.z0 - iArr[1]);
                        f4 f4Var5 = f4.this;
                        if (iAbs < f4Var5.y0) {
                            return;
                        }
                        f4Var5.a(f4Var5.C0, 0);
                    }
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public f4(Context context, long j2, long j3, AdSpacesBean.BuyerBean buyerBean, AdSpacesBean.ForwardBean forwardBean, m3 m3Var, int i2, boolean z, boolean z2) {
        super(context, j3, buyerBean, forwardBean, m3Var, i2);
        this.h0 = null;
        this.i0 = false;
        this.l0 = 0;
        this.n0 = null;
        this.C0 = new String[4];
        this.H0 = "#00000000";
        this.O0 = new String[]{"为您推荐", "精选呈现", "精彩内容更新", "今日推荐"};
        this.P0 = new String[]{"点击发现更多精彩", "点击即刻了解详情", "立即探索新发现", "精选内容不容错过"};
        this.Q0 = new Random().nextInt(4);
        this.U0 = new q();
        this.V0 = new b();
        this.c1 = new String[4];
        this.h1 = new g();
        this.t0 = j2;
        this.o0 = z;
        this.p0 = z2;
        AdSpacesBean.NativeOptimizeBean nativeOptimize = this.e.getNativeOptimize();
        if (nativeOptimize != null) {
            this.E0 = nativeOptimize.getNativeUuid();
            AdSpacesBean.NativeOptimizeAdSlideBean adSlide = nativeOptimize.getAdSlide();
            if (adSlide != null) {
                this.w0 = ol.a(adSlide.getRandomNum());
                this.x0 = adSlide.getNeedTime();
                this.y0 = adSlide.getDistance();
            }
            this.G0 = ol.a(nativeOptimize.getCloseClickNum());
            this.I0 = ol.a(nativeOptimize.getTouchDownNum());
            this.J0 = ol.a(nativeOptimize.getHoldSlideNum());
            this.N0 = ol.a(nativeOptimize.getAddClickNum());
        }
        try {
            List<AdSpacesBean.CallBackStrategyBean> callBackStrategy = this.e.getCallBackStrategy();
            if (callBackStrategy != null && callBackStrategy.size() > 0) {
                this.I = true;
                for (int i3 = 0; i3 < callBackStrategy.size(); i3++) {
                    AdSpacesBean.CallBackStrategyBean callBackStrategyBean = callBackStrategy.get(i3);
                    if ("290.300".equalsIgnoreCase(callBackStrategyBean.getEventCode())) {
                        this.J = ol.a(Integer.parseInt(callBackStrategyBean.getRate()));
                        break;
                    }
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        AdSpacesBean.BuyerBean.ShakeViewBean shakeView = this.e.getShakeView();
        this.e0 = shakeView;
        if (shakeView != null) {
            this.f0 = shakeView.getCoolShakeView();
            this.l0 = this.e0.getClkremove();
            this.n0 = this.e0.getTitle();
        }
        this.h0 = "cool_" + this.i;
    }

    private void e1() {
        try {
            if (this.w0 && this.Z != null && this.U != null) {
                this.A0 = new FrameLayout(this.U);
                int width = this.Z.getWidth();
                int height = this.Z.getHeight();
                if (width <= 0) {
                    width = -1;
                }
                if (height <= 0) {
                    height = -1;
                }
                this.A0.setLayoutParams(new FrameLayout.LayoutParams(width, height));
                this.A0.setBackgroundColor(Color.parseColor(this.H0));
                this.Z.addView(this.A0);
                this.A0.setOnTouchListener(new p());
                this.A0.getViewTreeObserver().addOnScrollChangedListener(this.U0);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private void f1() {
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

    private void g1() {
        AdSpacesBean.BuyerBean buyerBean;
        AdSpacesBean.NativeOptimizeBean nativeOptimize;
        AdSpacesBean.NativeOptimizeClickAreaBean clickArea;
        try {
            if (this.Z != null && this.U != null && (buyerBean = this.e) != null) {
                if ((this.I0 || this.J0) && (nativeOptimize = buyerBean.getNativeOptimize()) != null && (clickArea = nativeOptimize.getClickArea()) != null && ol.a(clickArea.getRandomNum())) {
                    int reference = clickArea.getReference();
                    String width = clickArea.getWidth();
                    String height = clickArea.getHeight();
                    String horizontalSpace = clickArea.getHorizontalSpace();
                    String verticalSpace = clickArea.getVerticalSpace();
                    View rootView = this.Z.getRootView();
                    if (rootView == null) {
                        return;
                    }
                    ViewGroup viewGroup = (ViewGroup) rootView.findViewById(android.R.id.content);
                    this.K0 = viewGroup;
                    if (viewGroup == null) {
                        return;
                    }
                    int iJ = so.j(this.U);
                    int iG = so.g(this.U);
                    int width2 = this.Z.getWidth();
                    int height2 = this.Z.getHeight();
                    int[] iArr = new int[2];
                    this.Z.getLocationOnScreen(iArr);
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
                    this.L0 = new FrameLayout(this.U);
                    this.L0.setLayoutParams(new FrameLayout.LayoutParams(iJ, i4));
                    int iA = a(horizontalSpace, iJ, width2, i2);
                    int iB = b(verticalSpace, i4, height2, i3);
                    int iA2 = so.a(this.U, 25.0f);
                    if (iB > iA2) {
                        iB -= iA2;
                    }
                    this.L0.setX(iA);
                    this.L0.setY(iB);
                    this.L0.setBackgroundColor(Color.parseColor(this.H0));
                    this.K0.addView(this.L0);
                    this.L0.setOnTouchListener(new a(new float[4]));
                    this.Z.getViewTreeObserver().addOnScrollChangedListener(this.V0);
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h1() {
        ri riVar;
        try {
            if (this.E != null && (riVar = this.g0) != null) {
                if (this.f0 == null) {
                    riVar.a(1.9d, 1.5d);
                }
                if (this.G != 1) {
                    return;
                }
                double dB = this.E.b();
                double dA = this.E.a();
                double dC = this.g0.c();
                double d2 = this.g0.d();
                if (dA > AudioStats.AUDIO_AMPLITUDE_NONE && dC > AudioStats.AUDIO_AMPLITUDE_NONE && dC < dA) {
                    this.G = 2;
                } else if (dB > AudioStats.AUDIO_AMPLITUDE_NONE && d2 > AudioStats.AUDIO_AMPLITUDE_NONE && d2 < dB) {
                    this.G = 2;
                }
                mi miVar = this.d0;
                if (miVar != null) {
                    miVar.a(this.G);
                }
            }
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i1() {
        ri riVar;
        AdSpacesBean.BuyerBean buyerBean;
        try {
            this.v0 = true;
            this.F0 = false;
            this.G0 = false;
            o1();
            if (this.I && (buyerBean = this.e) != null) {
                this.b.setCallBackStrategyUuid(buyerBean.getCallBackStrategyUuid());
                H0();
            }
            Z();
            a(this.U, this.Z, this.H);
            if (O()) {
                m3 m3Var = this.d;
                if (m3Var != null && m3Var.z() != 2) {
                    this.d.b(x());
                }
                Y();
                I0();
                if (this.l0 != 0 && (riVar = this.g0) != null && this.m0 != null) {
                    riVar.h();
                    this.m0.setVisibility(8);
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void j1() {
        try {
            if (!this.F0 && !this.v0) {
                double width = this.Z.getWidth();
                int[] iArr = {((int) (0.1d * width)) / 2, (int) (((double) this.Z.getHeight()) * 0.8d)};
                int[] iArrB = ol.b(((int) (width * 0.9d)) / 2, so.a(this.U, 65.0f) / 2);
                a(new String[]{String.valueOf(iArrB[0]), String.valueOf(iArrB[1]), String.valueOf(iArrB[0] + iArr[0]), String.valueOf(iArrB[1] + iArr[1])}, 0);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k1() {
        Log.d("BeiZis", "showNativeUnifiedAd Callback --> onAdShow()");
        this.D0 = System.currentTimeMillis();
        this.j0 = this.Z.getWidth();
        int height = this.Z.getHeight();
        this.k0 = height;
        if (this.j0 < 20 || height < 20) {
            return;
        }
        this.j = b2.ADSHOW;
        if (this.r0) {
            this.b.setIsCacheAd("1");
            if (this.s0 > 0) {
                this.b.setCacheTime(String.valueOf(System.currentTimeMillis() - this.s0));
            }
            H0();
        }
        m3 m3Var = this.d;
        if (m3Var != null && m3Var.z() != 2) {
            this.d.d(x());
        }
        if (!this.a0) {
            this.a0 = true;
            i0();
            d0();
            L0();
        }
        e1();
        g1();
        f1();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l1() {
        try {
            np npVar = this.b1;
            if (npVar != null && this.Z != null && this.U != null) {
                int iB = npVar.b();
                int iA = this.b1.a();
                if (iB != 0) {
                    this.d1 = new FrameLayout(this.U);
                    int width = this.Z.getWidth();
                    int height = this.Z.getHeight();
                    if (width <= 0) {
                        width = -1;
                    }
                    if (height <= 0) {
                        height = -1;
                    }
                    this.d1.setLayoutParams(new FrameLayout.LayoutParams(width, height));
                    this.d1.setBackgroundColor(Color.parseColor(this.H0));
                    this.Z.addView(this.d1);
                    this.d1.setOnTouchListener(new e());
                    if (iB == 1) {
                        this.d1.getViewTreeObserver().addOnScrollChangedListener(this.h1);
                    }
                }
                BZVideoView bZVideoView = this.T0;
                if (bZVideoView == null) {
                    return;
                }
                if (iA == 1) {
                    bZVideoView.addPlayButton();
                }
                this.T0.setOnClickListener(new f(iA));
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private boolean m1() {
        AdSpacesBean.BuyerBean.ShakeViewBean shakeViewBean = this.e0;
        if (shakeViewBean == null) {
            return false;
        }
        return ol.a(shakeViewBean.getRenderRate());
    }

    private boolean n1() {
        try {
            return System.currentTimeMillis() - so.a(this.U).longValue() < this.f0.getUserProtectTime();
        } catch (Exception e2) {
            e2.printStackTrace();
            return false;
        }
    }

    private void o1() {
        FrameLayout frameLayout;
        FrameLayout frameLayout2;
        FrameLayout frameLayout3;
        try {
            FrameLayout frameLayout4 = this.A0;
            if (frameLayout4 != null && this.U0 != null) {
                frameLayout4.getViewTreeObserver().removeOnScrollChangedListener(this.U0);
            }
            FrameLayout frameLayout5 = this.Z;
            if (frameLayout5 != null && (frameLayout3 = this.A0) != null) {
                frameLayout5.removeView(frameLayout3);
                this.A0 = null;
            }
            FrameLayout frameLayout6 = this.Z;
            if (frameLayout6 != null && this.V0 != null) {
                frameLayout6.getViewTreeObserver().removeOnScrollChangedListener(this.V0);
            }
            ViewGroup viewGroup = this.K0;
            if (viewGroup != null && (frameLayout2 = this.L0) != null) {
                viewGroup.removeView(frameLayout2);
                this.L0 = null;
            }
            if (this.Z == null || (frameLayout = this.d1) == null) {
                return;
            }
            if (this.h1 != null) {
                frameLayout.getViewTreeObserver().removeOnScrollChangedListener(this.h1);
            }
            this.Z.removeView(this.d1);
            this.d1 = null;
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p1() {
        View viewA;
        try {
            mi miVar = this.d0;
            if (miVar == null || this.p0 || miVar.p() == null || (viewA = pi.a(this.U, this.d0)) == null) {
                return;
            }
            viewA.setLayoutParams(new FrameLayout.LayoutParams((this.Z.getLayoutParams().width * 2) / 3, -2));
            this.Z.addView(viewA, new FrameLayout.LayoutParams(-2, -2, 51));
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    @Override // com.beizi.fusion.d2
    public void C0() {
        ri riVar;
        try {
            if (!q1.h().v() || (riVar = this.g0) == null) {
                return;
            }
            riVar.g();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    @Override // com.beizi.fusion.n3
    public String M0() {
        String strK;
        ArrayList arrayListL;
        mi miVar = this.d0;
        if (miVar != null) {
            strK = miVar.k();
            if (TextUtils.isEmpty(strK) && (arrayListL = this.d0.l()) != null && arrayListL.size() >= 3) {
                strK = (String) arrayListL.get(2);
            }
        } else {
            strK = null;
        }
        return TextUtils.isEmpty(strK) ? "查看详情" : strK;
    }

    @Override // com.beizi.fusion.n3
    public ViewGroup N0() {
        return this.Z;
    }

    @Override // com.beizi.fusion.n3
    public String O0() {
        ArrayList arrayListL;
        String strD = null;
        try {
            mi miVar = this.d0;
            if (miVar != null && !TextUtils.isEmpty(miVar.d())) {
                strD = this.d0.d();
                if (TextUtils.isEmpty(strD) && (arrayListL = this.d0.l()) != null && arrayListL.size() >= 2) {
                    strD = (String) arrayListL.get(1);
                }
            }
            return TextUtils.isEmpty(strD) ? this.P0[this.Q0] : strD;
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    @Override // com.beizi.fusion.n3
    public UnifiedAdDownloadAppInfo P0() {
        try {
            ApkBean apkBeanP = this.d0.p();
            if (apkBeanP == null) {
                return null;
            }
            UnifiedAdDownloadAppInfo unifiedAdDownloadAppInfo = new UnifiedAdDownloadAppInfo();
            unifiedAdDownloadAppInfo.setAppName(apkBeanP.getApkName());
            unifiedAdDownloadAppInfo.setAppVersion(apkBeanP.getAppVersion());
            unifiedAdDownloadAppInfo.setAppDeveloper(apkBeanP.getAppDeveloper());
            String appPermissionsUrl = apkBeanP.getAppPermissionsUrl();
            if (TextUtils.isEmpty(appPermissionsUrl)) {
                String appPermissionsDesc = apkBeanP.getAppPermissionsDesc();
                if (!TextUtils.isEmpty(appPermissionsDesc)) {
                    unifiedAdDownloadAppInfo.setAppPermission(appPermissionsDesc);
                }
            } else {
                unifiedAdDownloadAppInfo.setAppPermission(appPermissionsUrl);
            }
            if (!TextUtils.isEmpty(apkBeanP.getAppPrivacyUrl())) {
                unifiedAdDownloadAppInfo.setAppPrivacy(apkBeanP.getAppPrivacyUrl());
            }
            unifiedAdDownloadAppInfo.setAppIntro(apkBeanP.getAppintro());
            return unifiedAdDownloadAppInfo;
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    @Override // com.beizi.fusion.n3
    public String Q0() {
        mi miVar = this.d0;
        if (miVar == null || TextUtils.isEmpty(miVar.getIconUrl())) {
            return null;
        }
        return this.d0.getIconUrl();
    }

    @Override // com.beizi.fusion.d2
    public boolean R() {
        jp jpVar = this.c0;
        if (jpVar == null) {
            return false;
        }
        return jpVar.v();
    }

    @Override // com.beizi.fusion.n3
    public String R0() {
        mi miVar = this.d0;
        if (miVar == null || TextUtils.isEmpty(miVar.getImageUrl())) {
            return null;
        }
        return this.d0.getImageUrl();
    }

    @Override // com.beizi.fusion.d2
    public void S() {
        try {
            BZVideoView bZVideoView = this.T0;
            if (bZVideoView != null) {
                bZVideoView.onViewPause(true);
            }
        } catch (Exception unused) {
        }
    }

    @Override // com.beizi.fusion.n3
    public List S0() {
        mi miVar = this.d0;
        if (miVar == null) {
            return null;
        }
        if ((miVar.j() != null) && (this.d0.j().size() > 0)) {
            return this.d0.j();
        }
        return null;
    }

    @Override // com.beizi.fusion.d2
    public void T() {
        try {
            ri riVar = this.g0;
            if (riVar != null) {
                riVar.g();
            }
            BZVideoView bZVideoView = this.T0;
            if (bZVideoView != null) {
                bZVideoView.onViewResume(true);
            }
        } catch (Exception unused) {
        }
    }

    @Override // com.beizi.fusion.n3
    public String T0() {
        if (this.c0 == null) {
            return null;
        }
        try {
            on.e eVarN = this.d0.n();
            if (eVarN == null) {
                return null;
            }
            return eVarN.a();
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    @Override // com.beizi.fusion.d2
    public void U() {
        ri riVar;
        try {
            if (!q1.h().v() || (riVar = this.g0) == null) {
                return;
            }
            riVar.a(false);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    @Override // com.beizi.fusion.n3
    public int U0() {
        return 1;
    }

    @Override // com.beizi.fusion.n3
    public String V0() {
        ArrayList arrayListL;
        String strB = null;
        try {
            mi miVar = this.d0;
            if (miVar != null) {
                strB = miVar.b();
                if (TextUtils.isEmpty(strB) && (arrayListL = this.d0.l()) != null && arrayListL.size() >= 1) {
                    strB = (String) arrayListL.get(0);
                }
            }
            return TextUtils.isEmpty(strB) ? this.O0[this.Q0] : strB;
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    @Override // com.beizi.fusion.n3
    public View W0() {
        mi miVar = this.d0;
        if (miVar == null || this.U == null) {
            return null;
        }
        String strQ = miVar.q();
        if (TextUtils.isEmpty(strQ)) {
            return null;
        }
        String strG = this.d0.g();
        this.T0 = new BZVideoView(this.U);
        boolean zH = this.R0 ? this.S0 : this.d0.h();
        this.T0.setPlayProgressCallback(new j());
        this.T0.initVideoResource(strQ, strG, zH);
        return this.T0;
    }

    @Override // com.beizi.fusion.n3
    public void X0() {
        u0();
        vq.b(this.U, this.h);
        v0();
        Log.d("BeiZis", x() + ":requestAd:" + this.h + "====" + this.i + "===" + this.V);
        long j2 = this.V;
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

    @Override // com.beizi.fusion.n3
    public boolean Y0() {
        mi miVar = this.d0;
        return (miVar == null || TextUtils.isEmpty(miVar.q())) ? false : true;
    }

    @Override // com.beizi.fusion.n3
    public void a1() {
        Object obj;
        this.Z = new FrameLayout(this.U);
        jp jpVar = new jp(this.U, this.i, new i());
        this.c0 = jpVar;
        jpVar.b(true);
        try {
            this.c0.a(this.b.m167clone());
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        this.c0.a((int) this.t0);
        this.c0.a(this.e);
        if ("S2S".equals(l())) {
            this.c0.c(l());
            m3 m3Var = this.d;
            if (m3Var != null) {
                String strQ = m3Var.q();
                if (!TextUtils.isEmpty(strQ)) {
                    this.c0.b(strQ);
                }
            }
        }
        m3 m3Var2 = this.d;
        if (m3Var2 != null) {
            Map mapY = m3Var2.y();
            if (mapY != null && mapY.containsKey(com.alibaba.ariver.jsapi.multimedia.video.a.f) && (obj = mapY.get(com.alibaba.ariver.jsapi.multimedia.video.a.f)) != null && (obj instanceof Boolean)) {
                this.R0 = true;
                this.S0 = ((Boolean) obj).booleanValue();
            }
            this.c0.c(mapY);
            this.c0.d(this.d.v());
        }
        this.c0.w();
    }

    public void d1() {
        try {
            if (this.d0 == null || this.o0) {
                return;
            }
            LinearLayout linearLayout = new LinearLayout(this.U);
            linearLayout.setLayoutParams(new FrameLayout.LayoutParams(-2, -2, 17));
            FrameLayout frameLayoutB = bq.b(this.U, this.d0.n());
            frameLayoutB.setVisibility(0);
            linearLayout.addView(frameLayoutB, new LinearLayout.LayoutParams(-2, -2, 17.0f));
            View viewA = bq.a(this.U, this.d0.a());
            viewA.setVisibility(0);
            linearLayout.addView(viewA, new LinearLayout.LayoutParams(-2, -2, 17.0f));
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) viewA.getLayoutParams();
            layoutParams.setMargins(5, 0, 0, 0);
            layoutParams.gravity = 17;
            viewA.setLayoutParams(layoutParams);
            this.Z.addView(linearLayout, new FrameLayout.LayoutParams(-2, -2, 85));
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) linearLayout.getLayoutParams();
            int iA = so.a(this.U, 6.0f);
            layoutParams2.setMargins(0, 0, iA, iA);
            linearLayout.setLayoutParams(layoutParams2);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    @Override // com.beizi.fusion.d2
    public String n() {
        jp jpVar = this.c0;
        if (jpVar == null) {
            return null;
        }
        return jpVar.d();
    }

    @Override // com.beizi.fusion.d2
    public JSONObject p() {
        jp jpVar = this.c0;
        if (jpVar == null) {
            return null;
        }
        return jpVar.l();
    }

    @Override // com.beizi.fusion.d2
    public String s() {
        jp jpVar = this.c0;
        if (jpVar == null) {
            return null;
        }
        return jpVar.q();
    }

    @Override // com.beizi.fusion.n3, com.beizi.fusion.d2
    public String x() {
        return "BEIZI";
    }

    @Override // com.beizi.fusion.d2
    public void z() {
        if (!L() || this.c0 == null) {
            return;
        }
        F0();
    }

    @Override // com.beizi.fusion.d2
    public void g() {
        try {
            mi miVar = this.d0;
            if (miVar != null) {
                miVar.destroy();
            }
            jp jpVar = this.c0;
            if (jpVar != null) {
                jpVar.a();
            }
            ri riVar = this.g0;
            if (riVar != null) {
                riVar.h();
            }
            BZVideoView bZVideoView = this.T0;
            if (bZVideoView != null) {
                bZVideoView.onViewDestroy();
            }
            o1();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private void b(AdSpacesBean.BuyerBean.ShakeViewBean shakeViewBean) {
        if (shakeViewBean == null) {
            try {
                shakeViewBean = this.e0;
            } catch (Exception e2) {
                e2.printStackTrace();
                return;
            }
        }
        int regulatoryAngle = shakeViewBean.getRegulatoryAngle();
        int isUnidirection = shakeViewBean.getIsUnidirection();
        ri riVar = this.g0;
        if (riVar != null) {
            riVar.b(regulatoryAngle);
            this.g0.d(isUnidirection);
            f5 f5Var = this.E;
            if (f5Var != null) {
                this.g0.a(f5Var.b());
            }
        }
        if (this.f0 == null) {
            this.i0 = true;
            this.g0.a(shakeViewBean);
        } else if (a(shakeViewBean)) {
            this.g0.b(this.f0);
        } else if (n1()) {
            this.g0.b(this.f0);
        } else {
            this.i0 = true;
            this.g0.a(shakeViewBean);
        }
    }

    @Override // com.beizi.fusion.d2
    public void c(Map map) {
        Object obj;
        Object obj2;
        Object obj3;
        try {
            jp jpVar = this.c0;
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
            jp jpVar = this.c0;
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

    @Override // com.beizi.fusion.n3
    public void a(List list) {
        try {
            FrameLayout frameLayout = this.Z;
            if (frameLayout != null) {
                frameLayout.post(new k(list));
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private AdSpacesBean.BuyerBean.OrderDataShakeViewBean a(List list, String str) {
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

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i2, int i3, int i4) {
        AdSpacesBean.BuyerBean.ShakeViewBean shakeView;
        try {
            if (!q1.h().u() && m1()) {
                if (this.g0 == null) {
                    this.g0 = new ri(this.U);
                }
                AdSpacesBean.BuyerBean.ShakeViewBean shakeViewBean = this.e0;
                if (shakeViewBean == null || this.g0 == null || shakeViewBean.getPosition() == null) {
                    return;
                }
                String shakeViewUuid = this.e0.getShakeViewUuid();
                AdSpacesBean.BuyerBean.OrderDataShakeViewBean orderDataShakeViewBeanA = a(this.e0.getOrderData(), this.c0.c());
                if (orderDataShakeViewBeanA == null || orderDataShakeViewBeanA.getShakeView() == null) {
                    shakeView = null;
                } else {
                    shakeView = orderDataShakeViewBeanA.getShakeView();
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
                this.g0.a(this.q0);
                View viewA = this.g0.a(so.b(this.U, i2), so.b(this.U, i3), this.e0.getPosition(), this.n0);
                this.m0 = viewA;
                if (viewA != null) {
                    ViewGroup.LayoutParams layoutParams = viewA.getLayoutParams();
                    if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(marginLayoutParams.width, marginLayoutParams.height);
                        layoutParams2.leftMargin = marginLayoutParams.leftMargin;
                        layoutParams2.topMargin = marginLayoutParams.topMargin;
                        AdSpacesBean.BuyerBean.ShakeViewBean shakeViewBean2 = this.e0;
                        if (shakeViewBean2 != null && shakeViewBean2.getIsHideAnim() == 0) {
                            this.Z.addView(this.m0, layoutParams2);
                        }
                    }
                }
                b(shakeView);
                this.g0.a(new l(i2, i3));
                AdSpacesBean.BuyerBean.CoolShakeViewBean coolShakeViewBean = this.f0;
                if (coolShakeViewBean != null) {
                    this.g0.a(coolShakeViewBean, this.h0);
                }
                this.g0.a(this.Z);
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

    /* JADX INFO: Access modifiers changed from: private */
    public void b(List list) {
        FrameLayout frameLayout;
        if (list == null || list.size() == 0) {
            list = new ArrayList();
        }
        if (this.N0 && (frameLayout = this.Z) != null) {
            list.add(frameLayout);
        }
        if (list.size() == 0) {
            return;
        }
        for (View view : list) {
            if (view != null) {
                view.setOnTouchListener(new c(view));
            }
        }
    }

    @Override // com.beizi.fusion.d2
    public void b(int i2) {
        jp jpVar = this.c0;
        if (jpVar == null) {
            return;
        }
        jpVar.a(this.Z, i2);
    }

    private boolean a(AdSpacesBean.BuyerBean.ShakeViewBean shakeViewBean) {
        long jLongValue = ((Long) co.a(this.U, this.h0, (Object) 0L)).longValue();
        if (jLongValue != 0) {
            long jCurrentTimeMillis = System.currentTimeMillis() - jLongValue;
            if (jCurrentTimeMillis < this.f0.getCoolTime()) {
                new Handler().postDelayed(new m(shakeViewBean), this.f0.getCoolTime() - jCurrentTimeMillis);
                return true;
            }
            qn.a().b(this.h0);
        }
        return false;
    }

    @Override // com.beizi.fusion.n3
    public void a(View view) {
        if (view == null) {
            return;
        }
        view.setOnClickListener(new n());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String[] strArr, int i2) {
        FrameLayout frameLayout;
        try {
            o1();
            if (this.d0 != null && this.Z != null && !this.F0 && !this.v0) {
                this.v0 = true;
                this.F0 = true;
                EventBean eventBean = this.b;
                if (eventBean != null) {
                    eventBean.setNativeRuleUuid(this.E0);
                    H0();
                }
                mi miVar = this.d0;
                if (miVar == null || (frameLayout = this.Z) == null) {
                    return;
                }
                miVar.a(frameLayout, strArr[0], strArr[1], strArr[2], strArr[3], i2, new o());
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
        FrameLayout frameLayout;
        try {
            o1();
            if (this.d0 != null && this.Z != null && !this.F0) {
                this.v0 = true;
                this.F0 = true;
                EventBean eventBean = this.b;
                if (eventBean != null) {
                    eventBean.setNativeRuleUuid(this.E0);
                    H0();
                }
                mi miVar = this.d0;
                if (miVar == null || (frameLayout = this.Z) == null) {
                    return;
                }
                miVar.a(frameLayout, strArr[0], strArr[1], strArr[2], strArr[3], 0, new d());
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
