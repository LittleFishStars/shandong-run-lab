package com.beizi.fusion;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
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
import com.beizi.ad.lance.ApkBean;
import com.beizi.fusion.bzunified.BeiZiUnifiedAdDownloadAppInfo;
import com.beizi.fusion.bzunified.BeiZiUnifiedAdEventListener;
import com.beizi.fusion.bzunified.BeiZiUnifiedAdResponse;
import com.beizi.fusion.events.EventBean;
import com.beizi.fusion.model.AdSpacesBean;
import com.beizi.fusion.widget.BeiZiAdContainer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class o4 extends d2 {
    private boolean B0;
    private boolean C0;
    private ViewGroup D0;
    private FrameLayout E0;
    private long F0;
    private boolean G0;
    private long H0;
    private BeiZiUnifiedAdResponse I0;
    private FrameLayout J0;
    private BeiZiUnifiedAdEventListener M0;
    private fh Q0;
    private o R0;
    private Context U;
    private jp V;
    private String V0;
    private mi W;
    private String W0;
    private AdSpacesBean.BuyerBean.ShakeViewBean X;
    private AdSpacesBean.BuyerBean.CoolShakeViewBean Y;
    private ri Z;
    private int c0;
    private int d0;
    private View f0;
    private boolean h0;
    private boolean i0;
    private Boolean j0;
    private boolean k0;
    private long l0;
    private long m0;
    private long n0;
    private boolean o0;
    private boolean p0;
    private long q0;
    private int r0;
    private int s0;
    private FrameLayout t0;
    private boolean u0;
    private long w0;
    private String x0;
    private boolean y0;
    private boolean z0;
    private String a0 = null;
    private boolean b0 = false;
    private int e0 = 0;
    private String g0 = null;
    private String[] v0 = new String[4];
    private String A0 = "#00000000";
    private boolean K0 = false;
    private boolean L0 = false;
    private boolean N0 = true;
    private ViewTreeObserver.OnScrollChangedListener O0 = new a();
    private ViewTreeObserver.OnScrollChangedListener P0 = new c();
    public String S0 = "com.beizi.fusion.install.receiver";
    public String T0 = "com.beizi.fusion.download.receiver";
    private int U0 = 0;

    public class a implements ViewTreeObserver.OnScrollChangedListener {
        public a() {
        }

        @Override // android.view.ViewTreeObserver.OnScrollChangedListener
        public void onScrollChanged() {
            try {
                o4 o4Var = o4.this;
                if (o4Var.u0 && !o4Var.o0 && !o4Var.y0) {
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    o4 o4Var2 = o4.this;
                    if (jCurrentTimeMillis - o4Var2.w0 < o4Var2.q0) {
                        return;
                    }
                    long jCurrentTimeMillis2 = System.currentTimeMillis();
                    o4 o4Var3 = o4.this;
                    if (jCurrentTimeMillis2 - o4Var3.n0 < 50) {
                        return;
                    }
                    o4Var3.n0 = System.currentTimeMillis();
                    if (yp.a(o4.this.J0, 0.8d)) {
                        int[] iArr = new int[2];
                        FrameLayout frameLayout = o4.this.J0;
                        if (frameLayout != null) {
                            frameLayout.getLocationOnScreen(iArr);
                        }
                        int i = iArr[1];
                        if (i > 0) {
                            o4 o4Var4 = o4.this;
                            if (o4Var4.s0 == 0) {
                                o4Var4.s0 = i;
                            }
                        }
                        jh.b("BeiZis", "mOnScrollChangedListener mAdSlideScrollDistance:" + o4.this.s0 + ";mAdSlideClickDistance:" + o4.this.r0 + ";screenLocation[1]:" + iArr[1]);
                        int iAbs = Math.abs(o4.this.s0 - iArr[1]);
                        o4 o4Var5 = o4.this;
                        if (iAbs < o4Var5.r0) {
                            return;
                        }
                        o4Var5.a(o4Var5.v0, 0);
                    }
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public class b implements View.OnTouchListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ float[] f27576a;

        public b(float[] fArr) {
            this.f27576a = fArr;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            try {
                if (motionEvent.getAction() == 0) {
                    this.f27576a[0] = motionEvent.getX();
                    this.f27576a[1] = motionEvent.getY();
                    this.f27576a[2] = motionEvent.getRawX();
                    this.f27576a[3] = motionEvent.getRawY();
                    o4 o4Var = o4.this;
                    if (o4Var.B0) {
                        FrameLayout frameLayout = o4Var.E0;
                        FrameLayout frameLayout2 = o4Var.J0;
                        float[] fArr = this.f27576a;
                        o4.this.a(o4Var.a(frameLayout, frameLayout2, fArr[0], fArr[1], fArr[2], fArr[3]), 0);
                    }
                }
                if (motionEvent.getAction() == 1) {
                    o4 o4Var2 = o4.this;
                    if (o4Var2.C0) {
                        FrameLayout frameLayout3 = o4Var2.E0;
                        FrameLayout frameLayout4 = o4Var2.J0;
                        float[] fArr2 = this.f27576a;
                        o4.this.a(o4Var2.a(frameLayout3, frameLayout4, fArr2[0], fArr2[1], fArr2[2], fArr2[3]), 0);
                    }
                }
                o4 o4Var3 = o4.this;
                return o4Var3.B0 || o4Var3.C0;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public class c implements ViewTreeObserver.OnScrollChangedListener {
        public c() {
        }

        @Override // android.view.ViewTreeObserver.OnScrollChangedListener
        public void onScrollChanged() {
            ViewGroup viewGroup;
            try {
                if (o4.this.J0 == null) {
                    return;
                }
                long jCurrentTimeMillis = System.currentTimeMillis();
                o4 o4Var = o4.this;
                if (jCurrentTimeMillis - o4Var.F0 < 100) {
                    return;
                }
                o4Var.F0 = System.currentTimeMillis();
                int[] iArr = new int[2];
                o4.this.J0.getLocationOnScreen(iArr);
                if (iArr[1] < 0) {
                    o4.this.J0.getViewTreeObserver().removeOnScrollChangedListener(this);
                    o4 o4Var2 = o4.this;
                    FrameLayout frameLayout = o4Var2.E0;
                    if (frameLayout == null || (viewGroup = o4Var2.D0) == null) {
                        return;
                    }
                    viewGroup.removeView(frameLayout);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public class d implements View.OnTouchListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        String[] f27578a = new String[4];
        final /* synthetic */ View b;

        public d(View view) {
            this.b = view;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            View view2;
            ViewParent parent;
            try {
                if (motionEvent.getAction() == 0) {
                    o4 o4Var = o4.this;
                    if ((o4Var.B0 || o4Var.C0) && (view2 = this.b) != null && (parent = view2.getParent()) != null) {
                        parent.requestDisallowInterceptTouchEvent(true);
                    }
                    this.f27578a[0] = motionEvent.getX() + "";
                    this.f27578a[1] = motionEvent.getY() + "";
                    this.f27578a[2] = motionEvent.getRawX() + "";
                    this.f27578a[3] = motionEvent.getRawY() + "";
                    o4 o4Var2 = o4.this;
                    if (o4Var2.B0) {
                        o4Var2.a(this.f27578a);
                    }
                }
                if (motionEvent.getAction() == 1) {
                    o4 o4Var3 = o4.this;
                    if (o4Var3.C0) {
                        o4Var3.a(this.f27578a);
                    }
                }
                o4 o4Var4 = o4.this;
                return o4Var4.B0 || o4Var4.C0;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public class e implements ji {
        public e() {
        }

        @Override // com.beizi.fusion.ji
        public void a() {
            o4.this.Y0();
        }

        @Override // com.beizi.fusion.ji
        public void b() {
        }
    }

    public class f implements Runnable {
        public f() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                if (yp.a(o4.this.J0)) {
                    o4 o4Var = o4.this;
                    if (o4Var.o0) {
                        return;
                    }
                    o4Var.G = 2;
                    o4 o4Var2 = o4.this;
                    mi miVar = o4Var2.W;
                    if (miVar != null) {
                        miVar.a(o4Var2.G);
                    }
                    o4.this.Z0();
                    o4.this.B0();
                    o4 o4Var3 = o4.this;
                    mi miVar2 = o4Var3.W;
                    if (miVar2 != null) {
                        miVar2.a(o4Var3.G);
                    }
                }
            } catch (Exception unused) {
            }
        }
    }

    public class g implements ki {
        public g() {
        }

        @Override // com.beizi.fusion.ki
        public void a(mi miVar) {
            o4 o4Var;
            mi miVar2;
            ApkBean apkBeanP;
            Log.d("BeiZis", "showBeiZiNativeUnifiedAd onAdLoaded()");
            o4.this.j = b2.ADLOAD;
            o4 o4Var2 = o4.this;
            o4Var2.j0 = Boolean.valueOf(o4Var2.V.s());
            o4 o4Var3 = o4.this;
            o4Var3.k0 = o4Var3.V.u();
            o4 o4Var4 = o4.this;
            jp jpVar = o4Var4.V;
            if (jpVar != null) {
                o4Var4.E = jpVar.i();
                if (o4.this.E != null) {
                    o4 o4Var5 = o4.this;
                    o4Var5.F = o4Var5.E.c();
                    if (o4.this.F != 0) {
                        o4 o4Var6 = o4.this;
                        o4Var6.G = o4Var6.E.e() + 1;
                    }
                }
                o4 o4Var7 = o4.this;
                o4Var7.H = o4Var7.V.m();
            }
            o4 o4Var8 = o4.this;
            if (o4Var8.k0) {
                o4Var8.l0 = o4Var8.V.f();
                o4.this.b.setIsCacheAd("1");
                if (o4.this.l0 > 0) {
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    o4 o4Var9 = o4.this;
                    o4Var9.b.setCacheTime(String.valueOf(jCurrentTimeMillis - o4Var9.l0));
                }
                o4.this.H0();
            }
            if (o4.this.V.q() != null) {
                try {
                    o4 o4Var10 = o4.this;
                    o4Var10.a(Double.parseDouble(o4Var10.V.q()));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            o4.this.f0();
            if (miVar == null) {
                o4.this.a(-991);
                return;
            }
            miVar.b(1);
            o4 o4Var11 = o4.this;
            o4Var11.W = miVar;
            o4Var11.W0 = miVar.i();
            if ("1".equals(o4.this.W0)) {
                mi miVar3 = o4.this.W;
                if (miVar3 != null && (apkBeanP = miVar3.p()) != null) {
                    o4.this.V0 = apkBeanP.getPkgName();
                }
            } else if ("2".equals(o4.this.W0) && (miVar2 = (o4Var = o4.this).W) != null) {
                o4Var.V0 = miVar2.e();
            }
            o4.this.f1();
        }

        @Override // com.beizi.fusion.ki
        public void onAdFailed(int i) {
            Log.d("BeiZis", "showBeiZiNativeUnifiedAd onAdFailed: " + i);
            o4.this.a(String.valueOf(i), i);
        }
    }

    public class h implements BeiZiUnifiedAdResponse {
        public h() {
        }

        @Override // com.beizi.fusion.bzunified.BeiZiUnifiedAdResponse
        public void bindAdToView(Context context, BeiZiAdContainer beiZiAdContainer, List list) {
            o4.this.a(context, beiZiAdContainer, list);
        }

        @Override // com.beizi.fusion.bzunified.BeiZiUnifiedAdResponse
        public String getAdLogoUrl() {
            return o4.this.W0();
        }

        @Override // com.beizi.fusion.bzunified.BeiZiUnifiedAdResponse
        public String getAppName() {
            return o4.this.S0();
        }

        @Override // com.beizi.fusion.bzunified.BeiZiUnifiedAdResponse
        public int getAppStatus() {
            return o4.this.U0;
        }

        @Override // com.beizi.fusion.bzunified.BeiZiUnifiedAdResponse
        public String getDesc() {
            return o4.this.T0();
        }

        @Override // com.beizi.fusion.bzunified.BeiZiUnifiedAdResponse
        public BeiZiUnifiedAdDownloadAppInfo getDownloadAppInfo() {
            return o4.this.U0();
        }

        @Override // com.beizi.fusion.bzunified.BeiZiUnifiedAdResponse
        public int getECPM() {
            String strS = o4.this.s();
            if (strS == null) {
                return -1;
            }
            try {
                return Integer.parseInt(strS);
            } catch (Exception unused) {
                return -1;
            }
        }

        @Override // com.beizi.fusion.bzunified.BeiZiUnifiedAdResponse
        public Map getExtraInfo() {
            return null;
        }

        @Override // com.beizi.fusion.bzunified.BeiZiUnifiedAdResponse
        public String getIconUrl() {
            return o4.this.V0();
        }

        @Override // com.beizi.fusion.bzunified.BeiZiUnifiedAdResponse
        public String getRewardTaskAction() {
            return o4.this.W0;
        }

        @Override // com.beizi.fusion.bzunified.BeiZiUnifiedAdResponse
        public String getTitle() {
            return o4.this.X0();
        }

        @Override // com.beizi.fusion.bzunified.BeiZiUnifiedAdResponse
        public boolean isValid() {
            return o4.this.b1();
        }

        @Override // com.beizi.fusion.bzunified.BeiZiUnifiedAdResponse
        public void setNativeADEventListener(BeiZiUnifiedAdEventListener beiZiUnifiedAdEventListener) {
            o4.this.a(beiZiUnifiedAdEventListener);
        }
    }

    public class i implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ List f27583a;

        public class a implements ji {
            public a() {
            }

            @Override // com.beizi.fusion.ji
            public void a() {
                o4.this.Y0();
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
                o4.this.Y0();
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
                o4.this.a1();
            }
        }

        public i(List list) {
            this.f27583a = list;
        }

        @Override // java.lang.Runnable
        public void run() {
            jp jpVar;
            try {
                o4 o4Var = o4.this;
                if (o4Var.J0 != null) {
                    o4Var.M0();
                    o4.this.j1();
                    o4 o4Var2 = o4.this;
                    o4Var2.c0 = o4Var2.J0.getWidth();
                    o4 o4Var3 = o4.this;
                    o4Var3.d0 = o4Var3.J0.getHeight();
                    o4 o4Var4 = o4.this;
                    int i = o4Var4.c0;
                    int i2 = o4Var4.d0;
                    o4Var4.a(i, i2, i2);
                }
                o4 o4Var5 = o4.this;
                mi miVar = o4Var5.W;
                if (miVar != null) {
                    miVar.a(o4Var5.G);
                }
                o4 o4Var6 = o4.this;
                if (o4Var6.B0 || o4Var6.C0) {
                    o4Var6.a(this.f27583a);
                } else {
                    List list = this.f27583a;
                    if (list == null || list.size() <= 0) {
                        o4 o4Var7 = o4.this;
                        pi.a(o4Var7.W, o4Var7.J0, new b());
                    } else {
                        o4 o4Var8 = o4.this;
                        pi.a(o4Var8.W, o4Var8.J0, this.f27583a, new a());
                    }
                }
                o4 o4Var9 = o4.this;
                if (!o4Var9.N0 && ("1".equals(o4Var9.W0) || "2".equals(o4.this.W0))) {
                    o4 o4Var10 = o4.this;
                    if (so.a(o4Var10.U, o4Var10.V0)) {
                        o4.this.U0 = 1;
                    }
                    BeiZiUnifiedAdEventListener beiZiUnifiedAdEventListener = o4.this.M0;
                    if (beiZiUnifiedAdEventListener != null) {
                        beiZiUnifiedAdEventListener.onADStatusChanged();
                    }
                }
                o4 o4Var11 = o4.this;
                o4Var11.N0 = false;
                if (o4Var11.K0 || (jpVar = o4Var11.V) == null) {
                    return;
                }
                jpVar.a(o4Var11.J0, new c());
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public class j implements Runnable {
        public j() {
        }

        @Override // java.lang.Runnable
        public void run() {
            o4.this.Z0();
        }
    }

    public class k implements ri.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f27588a;
        final /* synthetic */ int b;

        public class a implements ji {
            public a() {
            }

            @Override // com.beizi.fusion.ji
            public void a() {
                o4.this.Y0();
                o4.this.B0();
            }

            @Override // com.beizi.fusion.ji
            public void b() {
            }
        }

        public k(int i, int i2) {
            this.f27588a = i;
            this.b = i2;
        }

        @Override // com.beizi.fusion.ri.b
        public void a() {
            AdSpacesBean.BuyerBean.CoolShakeViewBean coolShakeViewBean;
            try {
                if (yp.a(o4.this.J0)) {
                    o4 o4Var = o4.this;
                    if (o4Var.y0) {
                        return;
                    }
                    o4Var.o0 = true;
                    o4Var.y0 = true;
                    int[] iArr = new int[2];
                    o4Var.J0.getLocationOnScreen(iArr);
                    int[] iArrB = ol.b(this.f27588a / 2, this.b / 2);
                    o4 o4Var2 = o4.this;
                    if (o4Var2.W != null && o4Var2.J0 != null) {
                        o4Var2.Q0();
                        o4 o4Var3 = o4.this;
                        o4Var3.W.a(o4Var3.J0, String.valueOf(iArrB[0]), String.valueOf(iArrB[1]), String.valueOf(iArrB[0] + iArr[0]), String.valueOf(iArrB[1] + iArr[1]), 2, new a());
                    }
                    o4 o4Var4 = o4.this;
                    if (!o4Var4.b0 || (coolShakeViewBean = o4Var4.Y) == null) {
                        return;
                    }
                    o4Var4.b0 = false;
                    o4Var4.Z.b(coolShakeViewBean);
                    o4 o4Var5 = o4.this;
                    co.b(o4Var5.U, o4Var5.a0, Long.valueOf(System.currentTimeMillis()));
                    qn.a().a(o4.this.a0, System.currentTimeMillis());
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public class l implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ AdSpacesBean.BuyerBean.ShakeViewBean f27590a;

        public l(AdSpacesBean.BuyerBean.ShakeViewBean shakeViewBean) {
            this.f27590a = shakeViewBean;
        }

        @Override // java.lang.Runnable
        public void run() {
            o4.this.Z.a(this.f27590a);
        }
    }

    public class m implements ji {
        public m() {
        }

        @Override // com.beizi.fusion.ji
        public void a() {
            o4.this.Y0();
        }

        @Override // com.beizi.fusion.ji
        public void b() {
        }
    }

    public class n implements View.OnTouchListener {
        public n() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (motionEvent.getAction() == 0) {
                o4 o4Var = o4.this;
                o4Var.u0 = true;
                o4Var.v0[0] = motionEvent.getX() + "";
                o4.this.v0[1] = motionEvent.getY() + "";
                o4.this.v0[2] = motionEvent.getRawX() + "";
                o4.this.v0[3] = motionEvent.getRawY() + "";
            }
            return false;
        }
    }

    public class o extends BroadcastReceiver {
        private o() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent == null) {
                return;
            }
            try {
                o4 o4Var = o4.this;
                if (o4Var.W != null && !TextUtils.isEmpty(o4Var.V0)) {
                    String stringExtra = intent.getStringExtra("pkName");
                    if (!TextUtils.isEmpty(stringExtra) && stringExtra.equals(o4.this.V0)) {
                        if (o4.this.T0.equals(intent.getAction())) {
                            o4 o4Var2 = o4.this;
                            o4Var2.U0 = 4;
                            BeiZiUnifiedAdEventListener beiZiUnifiedAdEventListener = o4Var2.M0;
                            if (beiZiUnifiedAdEventListener != null) {
                                beiZiUnifiedAdEventListener.onADStatusChanged();
                            }
                        }
                    }
                }
            } catch (Exception unused) {
            }
        }
    }

    public o4(Context context, long j2, long j3, AdSpacesBean.BuyerBean buyerBean, AdSpacesBean.ForwardBean forwardBean, m3 m3Var) {
        this.U = context;
        this.H0 = j3;
        this.e = buyerBean;
        this.d = m3Var;
        this.f = forwardBean;
        this.m0 = j2;
        this.h0 = true;
        this.i0 = true;
        C();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void M0() {
        try {
            if (this.W == null || this.h0) {
                return;
            }
            LinearLayout linearLayout = new LinearLayout(this.U);
            linearLayout.setLayoutParams(new FrameLayout.LayoutParams(-2, -2, 17));
            FrameLayout frameLayoutB = bq.b(this.U, this.W.n());
            frameLayoutB.setVisibility(0);
            linearLayout.addView(frameLayoutB, new LinearLayout.LayoutParams(-2, -2, 17.0f));
            View viewA = bq.a(this.U, this.W.a());
            viewA.setVisibility(0);
            linearLayout.addView(viewA, new LinearLayout.LayoutParams(-2, -2, 17.0f));
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) viewA.getLayoutParams();
            layoutParams.setMargins(5, 0, 0, 0);
            layoutParams.gravity = 17;
            viewA.setLayoutParams(layoutParams);
            this.J0.addView(linearLayout, new FrameLayout.LayoutParams(-2, -2, 85));
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) linearLayout.getLayoutParams();
            int iA = so.a(this.U, 6.0f);
            layoutParams2.setMargins(0, 0, iA, iA);
            linearLayout.setLayoutParams(layoutParams2);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private void N0() {
        try {
            if (this.p0 && this.J0 != null && this.U != null) {
                this.t0 = new FrameLayout(this.U);
                int width = this.J0.getWidth();
                int height = this.J0.getHeight();
                if (width <= 0) {
                    width = -1;
                }
                if (height <= 0) {
                    height = -1;
                }
                this.t0.setLayoutParams(new FrameLayout.LayoutParams(width, height));
                this.t0.setBackgroundColor(Color.parseColor(this.A0));
                this.J0.addView(this.t0);
                this.t0.setOnTouchListener(new n());
                this.t0.getViewTreeObserver().addOnScrollChangedListener(this.O0);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private void O0() {
        Handler handler;
        try {
            int iK = k();
            if (iK > 0 && (handler = this.L) != null) {
                handler.postDelayed(new f(), iK);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private void P0() {
        AdSpacesBean.BuyerBean buyerBean;
        AdSpacesBean.NativeOptimizeBean nativeOptimize;
        AdSpacesBean.NativeOptimizeClickAreaBean clickArea;
        try {
            if (this.J0 != null && this.U != null && (buyerBean = this.e) != null) {
                if ((this.B0 || this.C0) && (nativeOptimize = buyerBean.getNativeOptimize()) != null && (clickArea = nativeOptimize.getClickArea()) != null && ol.a(clickArea.getRandomNum())) {
                    int reference = clickArea.getReference();
                    String width = clickArea.getWidth();
                    String height = clickArea.getHeight();
                    String horizontalSpace = clickArea.getHorizontalSpace();
                    String verticalSpace = clickArea.getVerticalSpace();
                    View rootView = this.J0.getRootView();
                    if (rootView == null) {
                        return;
                    }
                    ViewGroup viewGroup = (ViewGroup) rootView.findViewById(android.R.id.content);
                    this.D0 = viewGroup;
                    if (viewGroup == null) {
                        return;
                    }
                    int iJ = so.j(this.U);
                    int iG = so.g(this.U);
                    int width2 = this.J0.getWidth();
                    int height2 = this.J0.getHeight();
                    int[] iArr = new int[2];
                    this.J0.getLocationOnScreen(iArr);
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
                    this.E0 = new FrameLayout(this.U);
                    this.E0.setLayoutParams(new FrameLayout.LayoutParams(iJ, i4));
                    int iA = a(horizontalSpace, iJ, width2, i2);
                    int iB = b(verticalSpace, i4, height2, i3);
                    int iA2 = so.a(this.U, 25.0f);
                    if (iB > iA2) {
                        iB -= iA2;
                    }
                    this.E0.setX(iA);
                    this.E0.setY(iB);
                    this.E0.setBackgroundColor(Color.parseColor(this.A0));
                    this.D0.addView(this.E0);
                    this.E0.setOnTouchListener(new b(new float[4]));
                    this.J0.getViewTreeObserver().addOnScrollChangedListener(this.P0);
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
            if (this.E != null && (riVar = this.Z) != null) {
                if (this.Y == null) {
                    riVar.a(1.9d, 1.5d);
                }
                if (this.G != 1) {
                    return;
                }
                double dB = this.E.b();
                double dA = this.E.a();
                double dC = this.Z.c();
                double d2 = this.Z.d();
                if (dA > AudioStats.AUDIO_AMPLITUDE_NONE && dC > AudioStats.AUDIO_AMPLITUDE_NONE && dC < dA) {
                    this.G = 2;
                } else if (dB > AudioStats.AUDIO_AMPLITUDE_NONE && d2 > AudioStats.AUDIO_AMPLITUDE_NONE && d2 < dB) {
                    this.G = 2;
                }
                mi miVar = this.W;
                if (miVar != null) {
                    miVar.a(this.G);
                }
            }
        } catch (Exception unused) {
        }
    }

    private void R0() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String S0() {
        mi miVar = this.W;
        if (miVar == null) {
            return null;
        }
        return miVar.getAppName();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String T0() {
        ArrayList arrayListL;
        String strD = null;
        try {
            mi miVar = this.W;
            if (miVar != null && !TextUtils.isEmpty(miVar.d())) {
                strD = this.W.d();
                if (TextUtils.isEmpty(strD) && (arrayListL = this.W.l()) != null && arrayListL.size() >= 2) {
                    return (String) arrayListL.get(1);
                }
            }
            return strD;
        } catch (Exception e2) {
            e2.printStackTrace();
            return strD;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public BeiZiUnifiedAdDownloadAppInfo U0() {
        try {
            ApkBean apkBeanP = this.W.p();
            if (apkBeanP == null || TextUtils.isEmpty(apkBeanP.getApkName()) || TextUtils.isEmpty(apkBeanP.getAppDeveloper()) || TextUtils.isEmpty(apkBeanP.getAppVersion()) || TextUtils.isEmpty(apkBeanP.getAppPrivacyUrl()) || TextUtils.isEmpty(apkBeanP.getAppintro())) {
                return null;
            }
            String appPermissionsUrl = apkBeanP.getAppPermissionsUrl();
            String appPermissionsDesc = apkBeanP.getAppPermissionsDesc();
            if (TextUtils.isEmpty(appPermissionsUrl) && TextUtils.isEmpty(appPermissionsDesc)) {
                return null;
            }
            BeiZiUnifiedAdDownloadAppInfo beiZiUnifiedAdDownloadAppInfo = new BeiZiUnifiedAdDownloadAppInfo();
            beiZiUnifiedAdDownloadAppInfo.setAppName(apkBeanP.getApkName());
            beiZiUnifiedAdDownloadAppInfo.setAppVersion(apkBeanP.getAppVersion());
            beiZiUnifiedAdDownloadAppInfo.setAppDeveloper(apkBeanP.getAppDeveloper());
            String appPermissionsUrl2 = apkBeanP.getAppPermissionsUrl();
            if (TextUtils.isEmpty(appPermissionsUrl2)) {
                String appPermissionsDesc2 = apkBeanP.getAppPermissionsDesc();
                if (!TextUtils.isEmpty(appPermissionsDesc2)) {
                    beiZiUnifiedAdDownloadAppInfo.setAppPermission(appPermissionsDesc2);
                }
            } else {
                beiZiUnifiedAdDownloadAppInfo.setAppPermission(appPermissionsUrl2);
            }
            if (!TextUtils.isEmpty(apkBeanP.getAppPrivacyUrl())) {
                beiZiUnifiedAdDownloadAppInfo.setAppPrivacy(apkBeanP.getAppPrivacyUrl());
            }
            beiZiUnifiedAdDownloadAppInfo.setAppIntro(apkBeanP.getAppintro());
            return beiZiUnifiedAdDownloadAppInfo;
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String V0() {
        mi miVar = this.W;
        if (miVar == null || TextUtils.isEmpty(miVar.getIconUrl())) {
            return null;
        }
        return this.W.getIconUrl();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String W0() {
        if (this.V == null) {
            return null;
        }
        try {
            on.e eVarN = this.W.n();
            if (eVarN == null) {
                return null;
            }
            return eVarN.a();
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String X0() {
        ArrayList arrayListL;
        String strB = null;
        try {
            mi miVar = this.W;
            if (miVar != null) {
                strB = miVar.b();
                if (TextUtils.isEmpty(strB) && (arrayListL = this.W.l()) != null && arrayListL.size() >= 1) {
                    return (String) arrayListL.get(0);
                }
            }
            return strB;
        } catch (Exception e2) {
            e2.printStackTrace();
            return strB;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Y0() {
        ri riVar;
        AdSpacesBean.BuyerBean buyerBean;
        try {
            if ("1".equals(this.W0) || "2".equals(this.W0)) {
                if (so.a(this.U, this.V0)) {
                    this.U0 = 1;
                } else if ("2".equals(this.W0)) {
                    this.U0 = 8;
                }
                BeiZiUnifiedAdEventListener beiZiUnifiedAdEventListener = this.M0;
                if (beiZiUnifiedAdEventListener != null) {
                    beiZiUnifiedAdEventListener.onADStatusChanged();
                }
            }
            h1();
            this.o0 = true;
            this.y0 = false;
            this.z0 = false;
            i1();
            if (this.I && (buyerBean = this.e) != null) {
                this.b.setCallBackStrategyUuid(buyerBean.getCallBackStrategyUuid());
                H0();
            }
            Z();
            a(this.U, this.J0, this.H);
            if ((!this.I || this.J || this.F != 0) && this.G != 2) {
                m3 m3Var = this.d;
                if (m3Var != null && m3Var.z() != 2) {
                    this.d.b(x());
                }
                Y();
                I0();
                BeiZiUnifiedAdEventListener beiZiUnifiedAdEventListener2 = this.M0;
                if (beiZiUnifiedAdEventListener2 != null) {
                    beiZiUnifiedAdEventListener2.onADClicked();
                }
                if (this.e0 != 0 && (riVar = this.Z) != null && this.f0 != null) {
                    riVar.h();
                    this.f0.setVisibility(8);
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Z0() {
        FrameLayout frameLayout;
        try {
            if (!this.y0 && !this.o0 && this.W != null && (frameLayout = this.J0) != null) {
                int[] iArr = new int[2];
                int width = frameLayout.getWidth();
                int height = this.J0.getHeight();
                this.J0.getLocationOnScreen(iArr);
                int[] iArrB = ol.b(width / 2, height / 2);
                a(new String[]{String.valueOf(iArrB[0]), String.valueOf(iArrB[1]), String.valueOf(iArrB[0] + iArr[0]), String.valueOf(iArrB[1] + iArr[1])}, 0);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a1() {
        if (this.K0) {
            return;
        }
        Log.d("BeiZis", "showNativeUnifiedAd Callback --> onAdShow()");
        this.w0 = System.currentTimeMillis();
        this.j = b2.ADSHOW;
        if (this.k0) {
            this.b.setIsCacheAd("1");
            if (this.l0 > 0) {
                this.b.setCacheTime(String.valueOf(System.currentTimeMillis() - this.l0));
            }
            H0();
        }
        if (!this.K0) {
            m3 m3Var = this.d;
            if (m3Var != null && m3Var.z() != 2) {
                this.d.d(x());
            }
            this.K0 = true;
            i0();
            d0();
            L0();
        }
        BeiZiUnifiedAdEventListener beiZiUnifiedAdEventListener = this.M0;
        if (beiZiUnifiedAdEventListener != null) {
            beiZiUnifiedAdEventListener.onADExposed();
        }
        N0();
        P0();
        g1();
        O0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean b1() {
        jp jpVar = this.V;
        if (jpVar == null) {
            return false;
        }
        return jpVar.v();
    }

    private boolean c1() {
        AdSpacesBean.BuyerBean.ShakeViewBean shakeViewBean = this.X;
        if (shakeViewBean == null) {
            return false;
        }
        return ol.a(shakeViewBean.getRenderRate());
    }

    private boolean d1() {
        try {
            return System.currentTimeMillis() - so.a(this.U).longValue() < this.Y.getUserProtectTime();
        } catch (Exception e2) {
            e2.printStackTrace();
            return false;
        }
    }

    private void e1() {
        if (this.d == null) {
            return;
        }
        f();
        s5 s5Var = this.g;
        if (s5Var == s5.SUCCESS) {
            k1();
            this.d.a(x(), this.I0);
        } else if (s5Var == s5.FAIL) {
            Log.d("BeiZis", "other worker shown," + x() + " remove");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f1() {
        if (V()) {
            e1();
        } else {
            A();
        }
    }

    private void g1() {
        int iA;
        jp jpVar = this.V;
        if (jpVar == null) {
            return;
        }
        try {
            wk wkVarP = jpVar.p();
            if (wkVarP != null && (iA = wkVarP.a()) > 0) {
                new Handler().postDelayed(new j(), iA);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private void h1() {
        try {
            if (("1".equals(this.W0) || "2".equals(this.W0)) && "1".equals(this.W0) && this.Q0 == null) {
                this.Q0 = fh.a(this.U.getApplicationContext());
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction(this.S0);
                intentFilter.addAction(this.T0);
                o oVar = new o();
                this.R0 = oVar;
                this.Q0.a(oVar, intentFilter);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private void i1() {
        FrameLayout frameLayout;
        FrameLayout frameLayout2;
        try {
            FrameLayout frameLayout3 = this.t0;
            if (frameLayout3 != null && this.O0 != null) {
                frameLayout3.getViewTreeObserver().removeOnScrollChangedListener(this.O0);
            }
            FrameLayout frameLayout4 = this.J0;
            if (frameLayout4 != null && (frameLayout2 = this.t0) != null) {
                frameLayout4.removeView(frameLayout2);
                this.t0 = null;
            }
            FrameLayout frameLayout5 = this.J0;
            if (frameLayout5 != null && this.P0 != null) {
                frameLayout5.getViewTreeObserver().removeOnScrollChangedListener(this.P0);
            }
            ViewGroup viewGroup = this.D0;
            if (viewGroup == null || (frameLayout = this.E0) == null) {
                return;
            }
            viewGroup.removeView(frameLayout);
            this.E0 = null;
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j1() {
        View viewA;
        try {
            mi miVar = this.W;
            if (miVar == null || this.i0 || miVar.p() == null || (viewA = pi.a(this.U, this.W)) == null) {
                return;
            }
            viewA.setLayoutParams(new FrameLayout.LayoutParams((this.J0.getLayoutParams().width * 2) / 3, -2));
            this.J0.addView(viewA, new FrameLayout.LayoutParams(-2, -2, 51));
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private void k1() {
        this.I0 = new h();
    }

    private void l1() {
        o oVar;
        try {
            fh fhVar = this.Q0;
            if (fhVar != null && (oVar = this.R0) != null) {
                fhVar.a(oVar);
            }
            this.Q0 = null;
            this.R0 = null;
        } catch (Exception unused) {
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
        AdSpacesBean.NativeOptimizeBean nativeOptimize = this.e.getNativeOptimize();
        if (nativeOptimize != null) {
            this.x0 = nativeOptimize.getNativeUuid();
            AdSpacesBean.NativeOptimizeAdSlideBean adSlide = nativeOptimize.getAdSlide();
            if (adSlide != null) {
                this.p0 = ol.a(adSlide.getRandomNum());
                this.q0 = adSlide.getNeedTime();
                this.r0 = adSlide.getDistance();
            }
            this.z0 = ol.a(nativeOptimize.getCloseClickNum());
            this.B0 = ol.a(nativeOptimize.getTouchDownNum());
            this.C0 = ol.a(nativeOptimize.getHoldSlideNum());
            this.G0 = ol.a(nativeOptimize.getAddClickNum());
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
        Log.d("BeiZis", x() + ":requestAd:" + this.h + "====" + this.i + "===" + this.H0);
        long j2 = this.H0;
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
            if (!q1.h().v() || (riVar = this.Z) == null) {
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
        jp jpVar = this.V;
        if (jpVar == null) {
            return false;
        }
        return jpVar.v();
    }

    @Override // com.beizi.fusion.d2
    public void T() {
        try {
            ri riVar = this.Z;
            if (riVar != null) {
                riVar.g();
            }
        } catch (Exception unused) {
        }
    }

    @Override // com.beizi.fusion.d2
    public void U() {
        ri riVar;
        try {
            if (!q1.h().v() || (riVar = this.Z) == null) {
                return;
            }
            riVar.a(false);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    @Override // com.beizi.fusion.d2
    public AdSpacesBean.BuyerBean m() {
        return this.e;
    }

    @Override // com.beizi.fusion.d2
    public String n() {
        jp jpVar = this.V;
        if (jpVar == null) {
            return null;
        }
        return jpVar.d();
    }

    @Override // com.beizi.fusion.d2
    public JSONObject p() {
        jp jpVar = this.V;
        if (jpVar == null) {
            return null;
        }
        return jpVar.l();
    }

    @Override // com.beizi.fusion.d2
    public String s() {
        jp jpVar = this.V;
        if (jpVar == null) {
            return null;
        }
        return jpVar.q();
    }

    @Override // com.beizi.fusion.d2
    public String x() {
        return "BEIZI";
    }

    @Override // com.beizi.fusion.d2
    public void z() {
        if (!L() || this.V == null) {
            return;
        }
        F0();
    }

    @Override // com.beizi.fusion.d2
    public void z0() {
        g0();
        K0();
        AdSpacesBean.BuyerBean.ShakeViewBean shakeView = this.e.getShakeView();
        this.X = shakeView;
        if (shakeView != null) {
            this.Y = shakeView.getCoolShakeView();
            this.e0 = this.X.getClkremove();
            this.g0 = this.X.getTitle();
        }
        this.a0 = "cool_" + this.i;
        jp jpVar = new jp(this.U, this.i, new g());
        this.V = jpVar;
        jpVar.b(true);
        try {
            this.V.a(this.b.m167clone());
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        this.V.a((int) this.m0);
        this.V.a(this.e);
        if ("S2S".equals(l())) {
            this.V.c(l());
            m3 m3Var = this.d;
            if (m3Var != null) {
                String strQ = m3Var.q();
                if (!TextUtils.isEmpty(strQ)) {
                    this.V.b(strQ);
                }
            }
        }
        m3 m3Var2 = this.d;
        if (m3Var2 != null) {
            this.V.c(m3Var2.y());
            this.V.d(this.d.v());
            this.V.a(true);
        }
        this.V.w();
    }

    @Override // com.beizi.fusion.d2
    public void g() {
        mi miVar = this.W;
        if (miVar != null) {
            miVar.destroy();
        }
        jp jpVar = this.V;
        if (jpVar != null) {
            jpVar.a();
        }
        ri riVar = this.Z;
        if (riVar != null) {
            riVar.h();
        }
        i1();
        l1();
        R0();
    }

    @Override // com.beizi.fusion.d2
    public b2 h() {
        return this.j;
    }

    private void b(AdSpacesBean.BuyerBean.ShakeViewBean shakeViewBean) {
        if (shakeViewBean == null) {
            try {
                shakeViewBean = this.X;
            } catch (Exception e2) {
                e2.printStackTrace();
                return;
            }
        }
        int regulatoryAngle = shakeViewBean.getRegulatoryAngle();
        int isUnidirection = shakeViewBean.getIsUnidirection();
        ri riVar = this.Z;
        if (riVar != null) {
            riVar.b(regulatoryAngle);
            this.Z.d(isUnidirection);
            f5 f5Var = this.E;
            if (f5Var != null) {
                this.Z.a(f5Var.b());
            }
        }
        if (this.Y == null) {
            this.b0 = true;
            this.Z.a(shakeViewBean);
        } else if (a(shakeViewBean)) {
            this.Z.b(this.Y);
        } else if (d1()) {
            this.Z.b(this.Y);
        } else {
            this.b0 = true;
            this.Z.a(shakeViewBean);
        }
    }

    @Override // com.beizi.fusion.d2
    public void c(Map map) {
        Object obj;
        Object obj2;
        Object obj3;
        try {
            jp jpVar = this.V;
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
            jp jpVar = this.V;
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

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Context context, BeiZiAdContainer beiZiAdContainer, List list) {
        try {
            this.J0 = beiZiAdContainer;
            if (beiZiAdContainer != null) {
                beiZiAdContainer.post(new i(list));
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(BeiZiUnifiedAdEventListener beiZiUnifiedAdEventListener) {
        this.M0 = beiZiUnifiedAdEventListener;
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
            if (!q1.h().u() && c1()) {
                if (this.Z == null) {
                    this.Z = new ri(this.U);
                }
                AdSpacesBean.BuyerBean.ShakeViewBean shakeViewBean = this.X;
                if (shakeViewBean == null || this.Z == null || shakeViewBean.getPosition() == null) {
                    return;
                }
                String shakeViewUuid = this.X.getShakeViewUuid();
                AdSpacesBean.BuyerBean.OrderDataShakeViewBean orderDataShakeViewBeanA = a(this.X.getOrderData(), this.V.c());
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
                this.Z.a(this.j0);
                View viewA = this.Z.a(so.b(this.U, i2), so.b(this.U, i3), this.X.getPosition(), this.g0);
                this.f0 = viewA;
                if (viewA != null) {
                    ViewGroup.LayoutParams layoutParams = viewA.getLayoutParams();
                    if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(marginLayoutParams.width, marginLayoutParams.height);
                        layoutParams2.leftMargin = marginLayoutParams.leftMargin;
                        layoutParams2.topMargin = marginLayoutParams.topMargin;
                        AdSpacesBean.BuyerBean.ShakeViewBean shakeViewBean2 = this.X;
                        if (shakeViewBean2 != null && shakeViewBean2.getIsHideAnim() == 0) {
                            this.J0.addView(this.f0, layoutParams2);
                        }
                    }
                }
                b(shakeView);
                this.Z.a(new k(i2, i3));
                AdSpacesBean.BuyerBean.CoolShakeViewBean coolShakeViewBean = this.Y;
                if (coolShakeViewBean != null) {
                    this.Z.a(coolShakeViewBean, this.a0);
                }
                this.Z.a(this.J0);
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

    private boolean a(AdSpacesBean.BuyerBean.ShakeViewBean shakeViewBean) {
        long jLongValue = ((Long) co.a(this.U, this.a0, (Object) 0L)).longValue();
        if (jLongValue != 0) {
            long jCurrentTimeMillis = System.currentTimeMillis() - jLongValue;
            if (jCurrentTimeMillis < this.Y.getCoolTime()) {
                new Handler().postDelayed(new l(shakeViewBean), this.Y.getCoolTime() - jCurrentTimeMillis);
                return true;
            }
            qn.a().b(this.a0);
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String[] strArr, int i2) {
        FrameLayout frameLayout;
        try {
            i1();
            if (this.W != null && this.J0 != null && !this.y0 && !this.o0) {
                this.o0 = true;
                this.y0 = true;
                EventBean eventBean = this.b;
                if (eventBean != null) {
                    eventBean.setNativeRuleUuid(this.x0);
                    H0();
                }
                mi miVar = this.W;
                if (miVar == null || (frameLayout = this.J0) == null) {
                    return;
                }
                miVar.a(frameLayout, strArr[0], strArr[1], strArr[2], strArr[3], i2, new m());
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
    public void a(List list) {
        FrameLayout frameLayout;
        if (list == null || list.size() == 0) {
            list = new ArrayList();
        }
        if (this.G0 && (frameLayout = this.J0) != null) {
            list.add(frameLayout);
        }
        if (list.size() == 0) {
            return;
        }
        for (View view : list) {
            if (view != null) {
                view.setOnTouchListener(new d(view));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String[] strArr) {
        FrameLayout frameLayout;
        try {
            i1();
            if (this.W != null && this.J0 != null && !this.y0) {
                this.o0 = true;
                this.y0 = true;
                EventBean eventBean = this.b;
                if (eventBean != null) {
                    eventBean.setNativeRuleUuid(this.x0);
                    H0();
                }
                mi miVar = this.W;
                if (miVar == null || (frameLayout = this.J0) == null) {
                    return;
                }
                miVar.a(frameLayout, strArr[0], strArr[1], strArr[2], strArr[3], 0, new e());
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
