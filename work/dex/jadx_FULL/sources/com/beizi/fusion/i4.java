package com.beizi.fusion;

import android.content.Context;
import android.graphics.Color;
import android.os.Handler;
import android.os.Message;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.camera.video.AudioStats;
import com.alibaba.ariver.engine.api.bridge.model.NativeCallContext;
import com.beizi.fusion.events.EventBean;
import com.beizi.fusion.model.AdSpacesBean;
import com.beizi.fusion.update.ShakeArcView;
import com.beizi.fusion.widget.BZVideoView;
import com.beizi.fusion.widget.CircleProgressView;
import com.beizi.fusion.widget.ScrollClickView;
import com.beizi.fusion.widget.SkipView;
import com.beizi.fusion.work.splash.SplashContainer;
import com.googlecode.mp4parser.boxes.mp4.samplegrouping.RollRecoveryEntry;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class i4 extends d2 implements tn.c, sl.c, hn.d {
    AdSpacesBean.BuyerBean.RegionalClickViewBean D0;
    AdSpacesBean.BuyerBean.ScrollClickBean E0;
    AdSpacesBean.BuyerBean.ScrollClickBean F0;
    AdSpacesBean.BuyerBean.ScrollClickBean G0;
    AdSpacesBean.BuyerBean.FullScreenClickBean H0;
    View.OnClickListener J0;
    private tn K0;
    private sl L0;
    private hn M0;
    private AdSpacesBean.BuyerBean.RollViewBean N0;
    private AdSpacesBean.BuyerBean.CoolRollViewBean O0;
    private jm P0;
    private AdSpacesBean.BuyerBean.EulerAngleViewBean Q0;
    private r7 R0;
    private List S0;
    private View T0;
    private Context U;
    private Boolean U0;
    private String V;
    private long W;
    private cj X;
    private int X0;
    private ViewGroup Y;
    private int Y0;
    private ViewGroup Z;
    private boolean Z0;
    private View a0;
    private int a1;
    private List b0;
    private boolean b1;
    private long c1;
    private boolean e1;
    private boolean f1;
    private boolean g1;
    private boolean h1;
    private jn i1;
    private in j1;
    private long k0;
    private boolean k1;
    private long l0;
    private lj l1;
    private boolean m0;
    private CircleProgressView n0;
    private AdSpacesBean.PositionBean o0;
    private AdSpacesBean.PositionBean p0;
    private float q0;
    private float r0;
    private AdSpacesBean.RenderViewBean s0;
    private int t0;
    private int u0;
    private String v0;
    private String w0;
    private String x0;
    AdSpacesBean.BuyerBean.ShakeViewBean y0;
    private AdSpacesBean.BuyerBean.CoolShakeViewBean z0;
    private List c0 = new ArrayList();
    private List d0 = new ArrayList();
    private boolean e0 = false;
    private boolean f0 = false;
    private boolean g0 = false;
    private boolean h0 = false;
    private boolean i0 = false;
    private long j0 = 5000;
    private String A0 = null;
    private boolean B0 = false;
    private int C0 = -1;
    private String I0 = "full";
    private boolean V0 = false;
    private boolean W0 = false;
    private int d1 = 5;

    public class a implements in.d {
        public a() {
        }

        @Override // com.beizi.fusion.in.d
        public void a(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8) {
            try {
                i4 i4Var = i4.this;
                if (!i4Var.k1) {
                    co.b(i4Var.U, i4Var.A0, Long.valueOf(System.currentTimeMillis()));
                }
                i4 i4Var2 = i4.this;
                i4Var2.I0 = "scroll";
                i4Var2.b.setClickType(i4.this.I0);
                i4.this.H0();
                jh.a("BeiZis", "enter onScrollSlideCallBack ");
                i4.this.a(str, str2, str3, str4, str5, str6, str7, str8, 1);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public class c implements r7.c {
        public c() {
        }

        @Override // com.beizi.fusion.r7.c
        public void a() {
            try {
                i4 i4Var = i4.this;
                i4Var.I0 = "eulerAngle";
                i4Var.b.setClickType("eulerAngle");
                i4.this.H0();
                i4.this.a("", "", "", "", "", "", "", "", 2);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public class d implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ float[] f27382a;
        final /* synthetic */ ImageView b;
        final /* synthetic */ float[] c;
        final /* synthetic */ float d;
        final /* synthetic */ float e;

        public d(float[] fArr, ImageView imageView, float[] fArr2, float f, float f2) {
            this.f27382a = fArr;
            this.b = imageView;
            this.c = fArr2;
            this.d = f;
            this.e = f2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int left;
            int top;
            int i;
            int i2;
            try {
                float f = this.f27382a[0] / this.b.getLayoutParams().width;
                float f2 = this.c[0] / this.b.getLayoutParams().height;
                i4 i4Var = i4.this;
                View view2 = i4Var.T0;
                if (view2 != null) {
                    i2 = view2.getLayoutParams().width;
                    i = i4.this.T0.getLayoutParams().height;
                    left = i4.this.T0.getLeft();
                    top = i4.this.T0.getTop();
                } else {
                    int i3 = (int) (((double) this.d) * 0.9d);
                    int iA = so.a(i4Var.U, 65.0f);
                    left = (int) ((((double) this.d) * 0.1d) / 2.0d);
                    top = (int) (((double) this.e) * 0.8d);
                    i = iA;
                    i2 = i3;
                }
                int i4 = (int) (i2 * f);
                int i5 = (int) (i * f2);
                int i6 = left + i4;
                int i7 = top + i5;
                i4.this.b(i4 + ".0", i5 + ".0", i6 + ".0", i7 + ".0", i4 + ".0", i5 + ".0", i6 + ".0", i7 + ".0");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public class e implements View.OnTouchListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ float[] f27383a;
        final /* synthetic */ float[] b;
        final /* synthetic */ float[] c;
        final /* synthetic */ float[] d;

        public e(float[] fArr, float[] fArr2, float[] fArr3, float[] fArr4) {
            this.f27383a = fArr;
            this.b = fArr2;
            this.c = fArr3;
            this.d = fArr4;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            try {
                if (motionEvent.getAction() == 0) {
                    this.f27383a[0] = motionEvent.getX();
                    this.b[0] = motionEvent.getY();
                    this.c[0] = motionEvent.getRawX();
                    this.d[0] = motionEvent.getRawY();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            return false;
        }
    }

    public class f implements lj.e {
        public f() {
        }

        @Override // com.beizi.fusion.lj.e
        public void a() {
            i4.this.U0();
        }

        @Override // com.beizi.fusion.lj.e
        public void b() {
        }
    }

    public class g implements Runnable {
        public g() {
        }

        @Override // java.lang.Runnable
        public void run() {
            i4.this.U0();
        }
    }

    public class h implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ float[] f27386a;
        final /* synthetic */ ImageView b;
        final /* synthetic */ float[] c;
        final /* synthetic */ float d;
        final /* synthetic */ float e;

        public h(float[] fArr, ImageView imageView, float[] fArr2, float f, float f2) {
            this.f27386a = fArr;
            this.b = imageView;
            this.c = fArr2;
            this.d = f;
            this.e = f2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int left;
            int top;
            int i;
            int i2;
            try {
                float f = this.f27386a[0] / this.b.getLayoutParams().width;
                float f2 = this.c[0] / this.b.getLayoutParams().height;
                i4 i4Var = i4.this;
                View view2 = i4Var.T0;
                if (view2 != null) {
                    i2 = view2.getLayoutParams().width;
                    i = i4.this.T0.getLayoutParams().height;
                    left = i4.this.T0.getLeft();
                    top = i4.this.T0.getTop();
                } else {
                    int i3 = (int) (((double) this.d) * 0.9d);
                    int iA = so.a(i4Var.U, 65.0f);
                    left = (int) ((((double) this.d) * 0.1d) / 2.0d);
                    top = (int) (((double) this.e) * 0.8d);
                    i = iA;
                    i2 = i3;
                }
                int i4 = (int) (i2 * f);
                int i5 = (int) (i * f2);
                int i6 = left + i4;
                int i7 = top + i5;
                i4.this.b(i4 + ".0", i5 + ".0", i6 + ".0", i7 + ".0", i4 + ".0", i5 + ".0", i6 + ".0", i7 + ".0");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public class i implements View.OnTouchListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ float[] f27387a;
        final /* synthetic */ float[] b;
        final /* synthetic */ float[] c;
        final /* synthetic */ float[] d;

        public i(float[] fArr, float[] fArr2, float[] fArr3, float[] fArr4) {
            this.f27387a = fArr;
            this.b = fArr2;
            this.c = fArr3;
            this.d = fArr4;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            try {
                if (motionEvent.getAction() == 0) {
                    this.f27387a[0] = motionEvent.getX();
                    this.b[0] = motionEvent.getY();
                    this.c[0] = motionEvent.getRawX();
                    this.d[0] = motionEvent.getRawY();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            return false;
        }
    }

    public class j implements Runnable {
        public j() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                if (yp.a(i4.this.Z)) {
                    i4 i4Var = i4.this;
                    if (i4Var.f1) {
                        return;
                    }
                    i4Var.G = 2;
                    i4.this.U0();
                    i4.this.B0();
                }
            } catch (Exception unused) {
            }
        }
    }

    public class l implements zl {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ boolean f27390a;

        public l(boolean z) {
            this.f27390a = z;
        }

        @Override // com.beizi.fusion.zl
        public void e() {
            if (this.f27390a) {
                i4.this.k1();
            }
        }
    }

    public class m implements ViewTreeObserver.OnGlobalLayoutListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        boolean f27391a;
        boolean b;

        public class a implements View.OnTouchListener {
            public a() {
            }

            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                return true;
            }
        }

        public m() {
        }

        public void a(boolean z) {
            cj cjVar;
            if (z || (cjVar = i4.this.X) == null) {
                return;
            }
            cjVar.a(new a());
        }

        /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            try {
                ViewGroup viewGroup = i4.this.Z;
                if (viewGroup == null) {
                    return;
                }
                viewGroup.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                if (i4.this.e == null) {
                    return;
                }
                AdSpacesBean.BuyerBean.FullScreenClickBean fullScreenClickBean = i4.this.H0;
                if (fullScreenClickBean != null) {
                    String fullScreenClickUuid = fullScreenClickBean.getFullScreenClickUuid();
                    i4 i4Var = i4.this;
                    AdSpacesBean.BuyerBean.OrderDataFullScreenClickBean orderDataFullScreenClickBeanB = i4Var.b(i4Var.H0.getOrderData(), i4.this.X.c());
                    if (orderDataFullScreenClickBeanB != null) {
                        AdSpacesBean.BuyerBean.FullScreenClickBean fullScreenClick = orderDataFullScreenClickBeanB.getFullScreenClick();
                        if (fullScreenClick != null) {
                            fullScreenClickUuid = fullScreenClick.getFullScreenClickUuid();
                            this.b = ol.a(fullScreenClick.getRandomClickNum());
                            jh.a("BeiZis", "beizi clickable = " + this.b);
                            a(this.b);
                        }
                    } else {
                        this.f27391a = ol.a(i4.this.H0.getRandomClickNum());
                        jh.a("BeiZis", "beizi clickable Two = " + this.f27391a);
                        a(this.f27391a);
                    }
                    if (i4.this.b != null) {
                        i4.this.b.setFullScreenClickUuid(fullScreenClickUuid);
                        i4.this.H0();
                    }
                }
                i4.this.l1();
                if (i4.this.e.getInteractionRules() != null && i4.this.e.getInteractionRules().size() > 0) {
                    String strA = c2.a(i4.this.e.getInteractionRules(), ol.b(100));
                    switch (strA.hashCode()) {
                        case -1671124246:
                            if (strA.equals("eulerAngle")) {
                                if (q1.h().u()) {
                                    i4.this.X0();
                                    return;
                                }
                                i4.this.V0();
                            }
                            break;
                        case -907680051:
                            if (strA.equals("scroll")) {
                                i4.this.b1();
                            }
                            break;
                        case -690338273:
                            if (strA.equals("regional")) {
                                i4.this.X0();
                            }
                            break;
                        case 3506301:
                            if (strA.equals(RollRecoveryEntry.TYPE)) {
                                if (q1.h().u()) {
                                    i4.this.X0();
                                    return;
                                }
                                i4.this.Y0();
                            }
                            break;
                        case 109399814:
                            if (strA.equals("shake")) {
                                if (q1.h().u()) {
                                    i4.this.X0();
                                    return;
                                }
                                i4.this.d1();
                            }
                            break;
                    }
                } else if (q1.h().u()) {
                    i4.this.X0();
                    i4.this.b1();
                } else {
                    i4.this.d1();
                    i4.this.X0();
                    i4.this.b1();
                    i4.this.Y0();
                    i4.this.V0();
                }
                i4.this.M0();
                i4.this.O0();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public class n implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ AdSpacesBean.BuyerBean.ShakeViewBean f27393a;

        public n(AdSpacesBean.BuyerBean.ShakeViewBean shakeViewBean) {
            this.f27393a = shakeViewBean;
        }

        @Override // java.lang.Runnable
        public void run() {
            i4 i4Var = i4.this;
            i4Var.B0 = true;
            i4Var.K0.a(this.f27393a);
        }
    }

    public class o implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ AdSpacesBean.BuyerBean.ShakeViewBean f27394a;

        public o(AdSpacesBean.BuyerBean.ShakeViewBean shakeViewBean) {
            this.f27394a = shakeViewBean;
        }

        @Override // java.lang.Runnable
        public void run() {
            i4 i4Var = i4.this;
            i4Var.B0 = true;
            i4Var.K0.a(this.f27394a);
        }
    }

    public class p implements View.OnTouchListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        float f27395a;
        float b;
        float c;
        float d;
        float e;
        float f;
        final /* synthetic */ int g;
        final /* synthetic */ String h;
        final /* synthetic */ hn.d i;

        public p(int i, String str, hn.d dVar) {
            this.g = i;
            this.h = str;
            this.i = dVar;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            int action = motionEvent.getAction();
            if (action == 0) {
                this.f27395a = motionEvent.getX();
                this.b = motionEvent.getY();
                this.c = motionEvent.getX();
                this.d = motionEvent.getY();
                this.e = motionEvent.getRawX();
                this.f = motionEvent.getRawY();
            } else if (action == 1) {
                jh.c("ScrollClickUtil", "mCurPosX = " + this.c + ",mCurPosY = " + this.d + ",mPosX = " + this.f27395a + ",mPosY = " + this.b);
                float f = this.d - this.b;
                if (f <= 0.0f || Math.abs(f) <= this.g) {
                    float f2 = this.d - this.b;
                    if (f2 >= 0.0f || Math.abs(f2) <= this.g) {
                        float f3 = this.c - this.f27395a;
                        if (f3 >= 0.0f || Math.abs(f3) <= this.g) {
                            float f4 = this.c - this.f27395a;
                            if (f4 > 0.0f && Math.abs(f4) > this.g && ("right".equalsIgnoreCase(this.h) || i4.this.g1)) {
                                i4.this.a(this.i, this.f27395a + "", this.b + "", this.e + "", this.f + "", motionEvent.getX() + "", motionEvent.getY() + "", motionEvent.getRawX() + "", motionEvent.getRawY() + "");
                            }
                        } else if ("left".equalsIgnoreCase(this.h) || i4.this.g1) {
                            i4.this.a(this.i, this.f27395a + "", this.b + "", this.e + "", this.f + "", motionEvent.getX() + "", motionEvent.getY() + "", motionEvent.getRawX() + "", motionEvent.getRawY() + "");
                        }
                    } else if (ScrollClickView.DIR_UP.equalsIgnoreCase(this.h) || i4.this.g1) {
                        i4.this.a(this.i, this.f27395a + "", this.b + "", this.e + "", this.f + "", motionEvent.getX() + "", motionEvent.getY() + "", motionEvent.getRawX() + "", motionEvent.getRawY() + "");
                    }
                } else if (ScrollClickView.DIR_DOWN.equalsIgnoreCase(this.h) || i4.this.g1) {
                    i4.this.a(this.i, this.f27395a + "", this.b + "", this.e + "", this.f + "", motionEvent.getX() + "", motionEvent.getY() + "", motionEvent.getRawX() + "", motionEvent.getRawY() + "");
                }
            } else if (action == 2) {
                this.c = motionEvent.getX();
                this.d = motionEvent.getY();
            }
            return true;
        }
    }

    public class q implements Comparator {
        public q() {
        }

        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(AdSpacesBean.RenderViewBean renderViewBean, AdSpacesBean.RenderViewBean renderViewBean2) {
            return renderViewBean2.getLevel() - renderViewBean.getLevel();
        }
    }

    public class r implements View.OnClickListener {
        public r() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            try {
                i4 i4Var = i4.this;
                if (i4Var.h1 && !i4Var.f1) {
                    i4Var.h1 = false;
                    i4Var.U0();
                } else {
                    cj cjVar = i4Var.X;
                    if (cjVar != null) {
                        cjVar.b();
                    }
                    i4.this.a0();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public class s implements jn.f {
        public s() {
        }

        @Override // com.beizi.fusion.jn.f
        public void a(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8) {
            try {
                i4 i4Var = i4.this;
                if (!i4Var.k1) {
                    co.b(i4Var.U, i4Var.A0, Long.valueOf(System.currentTimeMillis()));
                }
                i4 i4Var2 = i4.this;
                i4Var2.I0 = "scroll";
                i4Var2.b.setClickType(i4.this.I0);
                i4.this.H0();
                jh.a("BeiZis", "enter onScrollSlideCallBack ");
                i4.this.a(str, str2, str3, str4, str5, str6, str7, str8, 1);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public i4(Context context, String str, long j2, View view, ViewGroup viewGroup, AdSpacesBean.BuyerBean buyerBean, AdSpacesBean.ForwardBean forwardBean, List list, int i2, int i3, m3 m3Var) {
        this.U = context;
        this.V = str;
        this.W = j2;
        this.Y = viewGroup;
        this.e = buyerBean;
        this.f = forwardBean;
        this.d = m3Var;
        this.Z = new SplashContainer(context);
        this.a0 = view;
        this.b0 = list;
        this.X0 = i2;
        this.Y0 = i3;
        C();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void M0() {
        List listH;
        ViewGroup viewGroup;
        int i2;
        int i3;
        int i4;
        int i5;
        try {
            cj cjVar = this.X;
            if (cjVar != null && (listH = cjVar.h()) != null && !listH.isEmpty() && (viewGroup = this.Z) != null) {
                float width = viewGroup.getWidth();
                float height = this.Z.getHeight();
                if (width == 0.0f) {
                    width = this.q0;
                }
                float f2 = width;
                if (height == 0.0f) {
                    height = this.r0;
                }
                float f3 = height;
                Iterator it = listH.iterator();
                while (it.hasNext()) {
                    c5 c5Var = (c5) it.next();
                    if (c5Var != null) {
                        cl clVarC = c5Var.c();
                        String strE = clVarC.e();
                        String strC = clVarC.c();
                        String strA = clVarC.a();
                        String strB = clVarC.b();
                        if (TextUtils.isEmpty(strE) || strE.equals("0")) {
                            i2 = (int) f2;
                        } else {
                            i2 = strE.endsWith("%") ? (((int) f2) * Integer.parseInt(strE.substring(0, strE.indexOf("%")))) / 100 : so.a(this.U, Integer.parseInt(strE));
                        }
                        if (TextUtils.isEmpty(strC) || strC.equals("0")) {
                            i3 = (int) f3;
                        } else {
                            i3 = strC.endsWith("%") ? (((int) f3) * Integer.parseInt(strC.substring(0, strC.indexOf("%")))) / 100 : so.a(this.U, Integer.parseInt(strC));
                        }
                        if (TextUtils.isEmpty(strA) || strA.equals("0")) {
                            i4 = (int) f2;
                        } else {
                            i4 = strA.endsWith("%") ? (((int) f2) * Integer.parseInt(strA.substring(0, strA.indexOf("%")))) / 100 : so.a(this.U, Integer.parseInt(strA));
                        }
                        if (TextUtils.isEmpty(strB) || strB.equals("0")) {
                            i5 = (int) f3;
                        } else {
                            i5 = strB.endsWith("%") ? (((int) f3) * Integer.parseInt(strB.substring(0, strB.indexOf("%")))) / 100 : so.a(this.U, Integer.parseInt(strB));
                        }
                        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(i2, i3);
                        int i6 = i5 - (i3 / 2);
                        int i7 = i4 - (i2 / 2);
                        if (i6 < 0) {
                            i6 = 0;
                        }
                        if (i7 < 0) {
                            i7 = 0;
                        }
                        layoutParams.topMargin = i6;
                        layoutParams.leftMargin = i7;
                        ImageView imageView = new ImageView(this.U);
                        imageView.setVisibility(0);
                        imageView.setLayoutParams(layoutParams);
                        String strA2 = c5Var.a();
                        if (!TextUtils.isEmpty(strA2) && strA2.startsWith("#")) {
                            imageView.setBackgroundColor(Color.parseColor(strA2));
                        }
                        String strB2 = c5Var.b();
                        if (!TextUtils.isEmpty(strB2) && strB2.contains("http")) {
                            z3.a(this.U).a(strB2).a(imageView);
                        }
                        float[] fArr = new float[1];
                        float[] fArr2 = new float[1];
                        Iterator it2 = it;
                        imageView.setOnClickListener(new h(fArr, imageView, fArr2, f2, f3));
                        imageView.setOnTouchListener(new i(fArr, fArr2, new float[1], new float[1]));
                        this.Z.addView(imageView, layoutParams);
                        it = it2;
                    }
                }
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

    /* JADX INFO: Access modifiers changed from: private */
    public void O0() {
        View viewF1 = f1();
        if (this.n0 != null) {
            this.Y.addView(this.n0, new FrameLayout.LayoutParams(-2, -2));
        }
        this.X.a(viewF1);
        Q0();
        if (this.m0) {
            q1();
        }
    }

    private void P0() {
        tn tnVar;
        try {
            if (this.E != null && (tnVar = this.K0) != null) {
                if (this.z0 == null) {
                    tnVar.a(1.9d, 1.5d);
                }
                if (this.G != 1) {
                    return;
                }
                double dB = this.E.b();
                double dA = this.E.a();
                double dI = this.K0.i();
                double dJ = this.K0.j();
                if (dA > AudioStats.AUDIO_AMPLITUDE_NONE && dI > AudioStats.AUDIO_AMPLITUDE_NONE && dI < dA) {
                    this.G = 2;
                } else {
                    if (dB <= AudioStats.AUDIO_AMPLITUDE_NONE || dJ <= AudioStats.AUDIO_AMPLITUDE_NONE || dJ >= dB) {
                        return;
                    }
                    this.G = 2;
                }
            }
        } catch (Exception unused) {
        }
    }

    private void Q0() {
        cl clVarJ;
        if (!this.m0) {
            View view = this.a0;
            if (view != null) {
                view.setVisibility(0);
                this.a0.setAlpha(1.0f);
                return;
            }
            return;
        }
        if (this.o0 == null || this.s0 == null) {
            n1();
            return;
        }
        float f2 = this.q0;
        float height = this.Y.getHeight();
        if (height == 0.0f) {
            height = this.r0 - so.a(this.U, 100.0f);
        }
        int width = (int) (((double) f2) * this.o0.getWidth() * 0.01d);
        if (this.o0.getHeight() < 12.0d) {
            n1();
            return;
        }
        int height2 = (int) (((double) width) * this.o0.getHeight() * 0.01d);
        int paddingHeight = (int) (((double) height2) * this.s0.getPaddingHeight() * 0.01d);
        if (paddingHeight < 0) {
            paddingHeight = 0;
        }
        ((SkipView) this.a0).setData(this.u0, paddingHeight);
        e(this.d1);
        this.Y.addView(this.a0, new FrameLayout.LayoutParams(width, height2));
        float centerX = (((float) (this.o0.getCenterX() * 0.01d)) * f2) - (width / 2);
        float centerY = (((float) (this.o0.getCenterY() * 0.01d)) * height) - (height2 / 2);
        try {
            cj cjVar = this.X;
            if (cjVar != null && (clVarJ = cjVar.j()) != null) {
                String strA = clVarJ.a();
                String strD = clVarJ.d();
                if (!TextUtils.isEmpty(strA)) {
                    centerX = strA.endsWith("%") ? (f2 * Integer.parseInt(strA.substring(0, strA.indexOf("%")))) / 100.0f : Integer.parseInt(strA);
                }
                if (!TextUtils.isEmpty(strD)) {
                    centerY = strD.endsWith("%") ? ((height * Integer.parseInt(strD.substring(0, strD.indexOf("%")))) / 100.0f) + (height2 / 2) : Integer.parseInt(strD);
                }
            }
        } catch (Exception unused) {
        }
        this.a0.setX(centerX);
        this.a0.setY(centerY);
        View view2 = this.a0;
        if (view2 != null) {
            view2.setVisibility(0);
        }
    }

    private void R0() {
        try {
            this.f1 = true;
            cj cjVar = this.X;
            if (cjVar != null) {
                cjVar.x();
            }
            lj ljVar = this.l1;
            if (ljVar != null) {
                ljVar.c();
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void S0() {
        try {
            lj ljVar = this.l1;
            if (ljVar != null) {
                ljVar.b();
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private void T0() {
        ViewGroup viewGroup;
        boolean z;
        cj cjVar = this.X;
        if (cjVar == null || !cjVar.t() || (viewGroup = this.Y) == null) {
            B();
            return;
        }
        viewGroup.removeAllViews();
        this.Y.addView(this.Z);
        AdSpacesBean.BuyerBean buyerBean = this.e;
        boolean z2 = false;
        if (buyerBean != null) {
            boolean z3 = buyerBean.getIsImageSpeed() == 1;
            z = this.e.getIsHideInteraction() == 1;
            z2 = z3;
        } else {
            z = false;
        }
        if (!z2) {
            k1();
            return;
        }
        this.X.a(new l(z));
        if (z) {
            return;
        }
        k1();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void U0() {
        try {
            if (this.f1) {
                return;
            }
            this.f1 = true;
            this.I0 = "regionalClick";
            this.b.setClickType("regionalClick");
            H0();
            jh.a("BeiZis", "enter onClick");
            double width = this.Z.getWidth();
            int[] iArr = {((int) (0.1d * width)) / 2, (int) (((double) this.Z.getHeight()) * 0.8d)};
            int[] iArrB = ol.b(((int) (width * 0.9d)) / 2, so.a(this.U, 65.0f) / 2);
            a(String.valueOf(iArrB[0]), String.valueOf(iArrB[1]), String.valueOf(iArrB[0] + iArr[0]), String.valueOf(iArrB[1] + iArr[1]), String.valueOf(iArrB[0]), String.valueOf(iArrB[1]), String.valueOf(iArrB[0] + iArr[0]), String.valueOf(iArrB[1] + iArr[1]), 0);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void V0() {
        try {
            AdSpacesBean.BuyerBean.EulerAngleViewBean eulerAngleRule = this.e.getEulerAngleRule();
            this.Q0 = eulerAngleRule;
            if (eulerAngleRule == null) {
                return;
            }
            AdSpacesBean.BuyerBean.OrderDataEulerAngleViewBean orderDataEulerAngleViewBeanA = a(eulerAngleRule.getOrderData(), this.X.c());
            AdSpacesBean.BuyerBean.EulerAngleViewBean eulerAngleRule2 = (orderDataEulerAngleViewBeanA == null || orderDataEulerAngleViewBeanA.getEulerAngleRule() == null) ? null : orderDataEulerAngleViewBeanA.getEulerAngleRule();
            if (eulerAngleRule2 != null) {
                EventBean eventBean = this.b;
                if (eventBean != null) {
                    eventBean.setEulerAngleUuid(eulerAngleRule2.getEulerAngleUuid());
                    H0();
                }
            } else {
                EventBean eventBean2 = this.b;
                if (eventBean2 != null) {
                    eventBean2.setEulerAngleUuid(this.Q0.getEulerAngleUuid());
                    H0();
                }
            }
            if (this.R0 == null) {
                this.R0 = new r7(this.U, this.i, this.Q0, eulerAngleRule2);
            }
            this.R0.a(this.U0);
            this.R0.a(this.Y, so.b(this.U, this.Z.getWidth()), so.b(this.U, this.Z.getHeight()));
            this.R0.a(new c());
            this.R0.e();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private void W0() {
        if (this.E0 == null) {
            return;
        }
        hn hnVar = new hn(this.U);
        this.M0 = hnVar;
        if (this.k1) {
            hnVar.a(this.G0);
        } else {
            AdSpacesBean.BuyerBean.ScrollClickBean scrollClickBean = this.F0;
            if (scrollClickBean != null) {
                hnVar.a(scrollClickBean);
            } else {
                hnVar.a(this.E0);
            }
        }
        this.M0.a(this.U0);
        View viewA = this.M0.a(so.b(this.U, this.Z.getWidth()), so.b(this.U, this.Z.getHeight()), this.E0.getPosition());
        if (viewA != null) {
            ViewGroup.LayoutParams layoutParams = viewA.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(marginLayoutParams.width, marginLayoutParams.height);
                layoutParams2.leftMargin = marginLayoutParams.leftMargin;
                layoutParams2.topMargin = marginLayoutParams.topMargin;
                try {
                    this.Y.addView(viewA, layoutParams2);
                    this.M0.a(this);
                    a(this.E0.getScrollDirection(), this.E0.getScrollDistance(), this);
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void X0() {
        try {
            if (this.D0 == null && q1.h().u()) {
                AdSpacesBean.BuyerBean.RegionalClickViewBean regionalClickViewBean = new AdSpacesBean.BuyerBean.RegionalClickViewBean();
                this.D0 = regionalClickViewBean;
                regionalClickViewBean.setTitleColor("#FFFFFF");
                this.D0.setTitle("点击跳转至网页或第三方应用");
                this.D0.setRegionalClickUuid("-4");
                this.D0.setIsDisableClick(0);
                AdSpacesBean.BuyerBean.PercentPositionBean percentPositionBean = new AdSpacesBean.BuyerBean.PercentPositionBean();
                percentPositionBean.setCenterX("50%");
                percentPositionBean.setCenterY("80%");
                this.D0.setPosition(percentPositionBean);
            }
            AdSpacesBean.BuyerBean.RegionalClickViewBean regionalClickViewBean2 = this.D0;
            if (regionalClickViewBean2 == null || this.L0 == null || regionalClickViewBean2.getPosition() == null) {
                return;
            }
            String regionalClickUuid = this.D0.getRegionalClickUuid();
            AdSpacesBean.BuyerBean.OrderDataRegionalClickViewBean orderDataRegionalClickViewBeanC = c(this.D0.getOrderData(), this.X.c());
            if (orderDataRegionalClickViewBeanC != null) {
                AdSpacesBean.BuyerBean.RegionalClickViewBean regionalClickView = orderDataRegionalClickViewBeanC.getRegionalClickView();
                if (regionalClickView != null) {
                    regionalClickUuid = regionalClickView.getRegionalClickUuid();
                }
                this.L0.a(regionalClickView);
            } else {
                this.L0.a(this.D0);
            }
            EventBean eventBean = this.b;
            if (eventBean != null) {
                eventBean.setRegionalClickUuid(regionalClickUuid);
                H0();
            }
            this.L0.a(this.U0);
            View viewA = this.L0.a(so.b(this.U, this.Z.getWidth()), so.b(this.U, this.Z.getHeight()), this.D0.getPosition(), true);
            this.T0 = viewA;
            if (viewA != null) {
                ViewGroup.LayoutParams layoutParams = viewA.getLayoutParams();
                if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                    ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                    FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(marginLayoutParams.width, marginLayoutParams.height);
                    layoutParams2.leftMargin = marginLayoutParams.leftMargin;
                    layoutParams2.topMargin = marginLayoutParams.topMargin;
                    try {
                        this.Y.addView(this.T0, layoutParams2);
                        this.L0.a(this);
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                }
            }
        } catch (Exception e3) {
            e3.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Y0() {
        try {
            AdSpacesBean.BuyerBean.RollViewBean rollView = this.e.getRollView();
            this.N0 = rollView;
            if (rollView == null) {
                return;
            }
            AdSpacesBean.BuyerBean.OrderDataRollViewBean orderDataRollViewBeanD = d(rollView.getOrderData(), this.X.c());
            AdSpacesBean.BuyerBean.RollViewBean rollView2 = (orderDataRollViewBeanD == null || orderDataRollViewBeanD.getRollView() == null) ? null : orderDataRollViewBeanD.getRollView();
            if (rollView2 == null) {
                rollView2 = this.N0;
            }
            if (rollView2.getPosition() == null) {
                return;
            }
            EventBean eventBean = this.b;
            if (eventBean != null) {
                eventBean.setRollViewUuid(rollView2.getRollViewUuid());
                H0();
            }
            if (this.P0 == null) {
                this.P0 = new jm(this.U);
            }
            this.P0.a(this.U0);
            this.P0.a(this.Y, so.b(this.U, this.Z.getWidth()), so.b(this.U, this.Z.getHeight()), rollView2);
            AdSpacesBean.BuyerBean.RollViewBean rollViewBean = this.N0;
            if (rollViewBean != null) {
                this.O0 = rollViewBean.getCoolRollView();
            }
            a(rollView2);
            this.P0.a();
            this.P0.a(new b(rollView2.getIsClick()));
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private void Z0() {
        try {
            if (this.E0 != null) {
                this.i1 = new jn(this.U);
                int width = this.Z.getWidth();
                int height = this.Z.getHeight();
                if (this.k1) {
                    this.i1.a(this.G0, g1(), this.U0.booleanValue(), width, height);
                } else {
                    AdSpacesBean.BuyerBean.ScrollClickBean scrollClickBean = this.F0;
                    if (scrollClickBean != null) {
                        this.i1.a(scrollClickBean, g1(), this.U0.booleanValue(), width, height);
                    } else {
                        this.i1.a(this.E0, g1(), this.U0.booleanValue(), width, height);
                    }
                }
                View viewA = this.i1.a(this.Z);
                ViewGroup.LayoutParams layoutParams = viewA.getLayoutParams();
                if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                    FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, -2);
                    layoutParams2.topMargin = ((ViewGroup.MarginLayoutParams) layoutParams).topMargin;
                    ViewGroup viewGroup = this.Y;
                    if (viewGroup != null) {
                        viewGroup.addView(viewA, layoutParams2);
                    }
                }
                this.i1.a(new s());
                this.i1.k();
            }
        } catch (Exception unused) {
        }
    }

    private void a1() {
        try {
            if (this.E0 != null) {
                this.j1 = new in(this.U);
                int width = this.Z.getWidth();
                int height = this.Z.getHeight();
                if (this.k1) {
                    this.j1.a(this.G0, g1(), this.U0.booleanValue(), width, height);
                } else {
                    AdSpacesBean.BuyerBean.ScrollClickBean scrollClickBean = this.F0;
                    if (scrollClickBean != null) {
                        this.j1.a(scrollClickBean, g1(), this.U0.booleanValue(), width, height);
                    } else {
                        this.j1.a(this.E0, g1(), this.U0.booleanValue(), width, height);
                    }
                }
                View viewA = this.j1.a(this.Z);
                ViewGroup.LayoutParams layoutParams = viewA.getLayoutParams();
                if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                    ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                    FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(marginLayoutParams.width, layoutParams.height);
                    layoutParams2.topMargin = marginLayoutParams.topMargin;
                    layoutParams2.leftMargin = marginLayoutParams.leftMargin;
                    ViewGroup viewGroup = this.Y;
                    if (viewGroup != null) {
                        viewGroup.addView(viewA, layoutParams2);
                    }
                }
                this.j1.a(new a());
                this.j1.i();
            }
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b1() {
        int style;
        String scrollClickUuid;
        try {
            AdSpacesBean.BuyerBean.ScrollClickBean scrollClickBean = this.E0;
            if (scrollClickBean == null) {
                return;
            }
            AdSpacesBean.BuyerBean.ScrollClickBean coolScrollClick = scrollClickBean.getCoolScrollClick();
            this.G0 = coolScrollClick;
            if (coolScrollClick != null && (c(coolScrollClick.getUserProtectTime()) || b(this.G0.getCoolTime()))) {
                this.k1 = true;
            }
            if (this.k1) {
                style = this.G0.getStyle();
            } else {
                AdSpacesBean.BuyerBean.OrderDataScrollViewOrderBean orderDataScrollViewOrderBeanE = e(this.E0.getOrderData(), this.X.c());
                if (orderDataScrollViewOrderBeanE != null) {
                    this.F0 = orderDataScrollViewOrderBeanE.getScrollClick();
                }
                AdSpacesBean.BuyerBean.ScrollClickBean scrollClickBean2 = this.F0;
                style = scrollClickBean2 != null ? scrollClickBean2.getStyle() : this.E0.getStyle();
            }
            if (this.k1) {
                scrollClickUuid = this.G0.getScrollClickUuid();
            } else {
                AdSpacesBean.BuyerBean.ScrollClickBean scrollClickBean3 = this.F0;
                scrollClickUuid = scrollClickBean3 != null ? scrollClickBean3.getScrollClickUuid() : this.E0.getScrollClickUuid();
            }
            EventBean eventBean = this.b;
            if (eventBean != null) {
                eventBean.setScrollClickUuid(scrollClickUuid);
                H0();
            }
            if (style == 1) {
                Z0();
            } else if (style == 2) {
                a1();
            } else {
                W0();
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private void c1() {
        View view;
        View.OnClickListener onClickListener;
        if (this.m0 || (view = this.a0) == null || (onClickListener = this.J0) == null) {
            return;
        }
        view.setOnClickListener(onClickListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d1() {
        AdSpacesBean.BuyerBean.ShakeViewBean shakeView;
        try {
            if (this.K0 == null) {
                this.K0 = new tn(this.U);
            }
            AdSpacesBean.BuyerBean.ShakeViewBean shakeViewBean = this.y0;
            if (shakeViewBean == null || this.K0 == null || shakeViewBean.getPosition() == null) {
                return;
            }
            this.V0 = true;
            String shakeViewUuid = this.y0.getShakeViewUuid();
            AdSpacesBean.BuyerBean.OrderDataShakeViewBean orderDataShakeViewBeanF = f(this.y0.getOrderData(), this.X.c());
            if (orderDataShakeViewBeanF == null || orderDataShakeViewBeanF.getShakeView() == null) {
                shakeView = null;
            } else {
                shakeView = orderDataShakeViewBeanF.getShakeView();
                if (shakeView != null) {
                    shakeViewUuid = shakeView.getShakeViewUuid();
                }
            }
            EventBean eventBean = this.b;
            if (eventBean != null) {
                eventBean.setShakeViewUuid(shakeViewUuid);
                H0();
            }
            this.K0.a(this.U0);
            View viewA = this.K0.a(so.b(this.U, this.Z.getWidth()), so.b(this.U, this.Z.getHeight()), this.y0.getPosition());
            if (viewA != null) {
                ViewGroup.LayoutParams layoutParams = viewA.getLayoutParams();
                if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                    ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                    FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(marginLayoutParams.width, marginLayoutParams.height);
                    layoutParams2.leftMargin = marginLayoutParams.leftMargin;
                    layoutParams2.topMargin = marginLayoutParams.topMargin;
                    this.Y.addView(viewA, layoutParams2);
                }
            }
            m1();
            b(shakeView);
            this.K0.a(this);
            a(shakeView, viewA);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r7v0 */
    /* JADX WARN: Type inference failed for: r7v1 */
    /* JADX WARN: Type inference failed for: r7v4 */
    /* JADX WARN: Type inference failed for: r7v5 */
    /* JADX WARN: Type inference failed for: r7v6 */
    /* JADX WARN: Type inference failed for: r7v7 */
    /* JADX WARN: Type inference failed for: r7v8 */
    /* JADX WARN: Type inference failed for: r7v9 */
    private void e1() {
        boolean z = false;
        for (int i2 = 0; i2 < this.b0.size(); i2++) {
            AdSpacesBean.RenderViewBean renderViewBean = (AdSpacesBean.RenderViewBean) this.b0.get(i2);
            String type = renderViewBean.getType();
            if ("SKIPVIEW".equals(type)) {
                this.d0.add(renderViewBean);
            } else if ("MATERIALVIEW".equals(type)) {
                this.c0.add(renderViewBean);
            }
        }
        if (this.d0.size() > 0) {
            AdSpacesBean.RenderViewBean renderViewBean2 = (AdSpacesBean.RenderViewBean) this.d0.get(0);
            this.s0 = renderViewBean2;
            if (renderViewBean2 != null) {
                this.p0 = renderViewBean2.getTapPosition();
                this.o0 = this.s0.getLayerPosition();
                long skipViewTotalTime = this.s0.getSkipViewTotalTime();
                if (skipViewTotalTime > 0) {
                    this.j0 = skipViewTotalTime;
                }
                long skipUnavailableTime = this.s0.getSkipUnavailableTime();
                if (skipUnavailableTime > 0) {
                    this.l0 = skipUnavailableTime;
                }
                this.t0 = this.s0.getShowCountDown();
                this.u0 = this.s0.getShowBorder();
                String skipText = this.s0.getSkipText();
                this.v0 = skipText;
                if (TextUtils.isEmpty(skipText)) {
                    this.v0 = "跳过";
                }
                String textColor = this.s0.getTextColor();
                this.w0 = textColor;
                if (TextUtils.isEmpty(textColor)) {
                    this.w0 = "#FFFFFF";
                }
                String countDownColor = this.s0.getCountDownColor();
                this.x0 = countDownColor;
                if (TextUtils.isEmpty(countDownColor)) {
                    this.x0 = "#FFFFFF";
                }
                this.h1 = ol.a(this.s0.getRandomClick());
                List<AdSpacesBean.PassPolicyBean> passPolicy = this.s0.getPassPolicy();
                if (passPolicy != null && passPolicy.size() > 0) {
                    for (AdSpacesBean.PassPolicyBean passPolicyBean : passPolicy) {
                        String passType = passPolicyBean.getPassType();
                        int passPercent = passPolicyBean.getPassPercent();
                        passType.getClass();
                        ?? r7 = -1;
                        r7 = -1;
                        r7 = -1;
                        r7 = -1;
                        switch (passType.hashCode()) {
                            case 601561940:
                                if (passType.equals("RANDOMPASS")) {
                                    r7 = z;
                                }
                                break;
                            case 1028793094:
                                if (passType.equals("WAITPASS")) {
                                    r7 = 1;
                                }
                                break;
                            case 1122973890:
                                if (passType.equals("LAYERPASS")) {
                                    r7 = 2;
                                }
                                break;
                        }
                        switch (r7) {
                            case 0:
                                this.f0 = ol.a(passPercent);
                                break;
                            case 1:
                                this.e0 = ol.a(passPercent);
                                break;
                            case 2:
                                AdSpacesBean.PositionBean positionBean = this.o0;
                                if (positionBean != null && this.p0 != null) {
                                    double centerX = positionBean.getCenterX();
                                    double centerY = this.o0.getCenterY();
                                    double width = this.o0.getWidth();
                                    double height = this.o0.getHeight();
                                    double centerX2 = this.p0.getCenterX();
                                    double centerY2 = this.p0.getCenterY();
                                    double width2 = this.p0.getWidth();
                                    double height2 = this.p0.getHeight();
                                    if ((centerX > AudioStats.AUDIO_AMPLITUDE_NONE && centerX2 > AudioStats.AUDIO_AMPLITUDE_NONE && centerX != centerX2) || ((centerY > AudioStats.AUDIO_AMPLITUDE_NONE && centerY2 > AudioStats.AUDIO_AMPLITUDE_NONE && centerY != centerY2) || ((width > AudioStats.AUDIO_AMPLITUDE_NONE && width2 > AudioStats.AUDIO_AMPLITUDE_NONE && width != width2) || (height > AudioStats.AUDIO_AMPLITUDE_NONE && height2 > AudioStats.AUDIO_AMPLITUDE_NONE && height != height2)))) {
                                        this.g0 = ol.a(passPercent);
                                    }
                                    if (width2 * height2 < width * height) {
                                        this.h0 = true;
                                    }
                                    break;
                                }
                                break;
                            default:
                                continue;
                        }
                        z = false;
                    }
                }
            }
        }
        if (this.c0.size() > 0) {
            Collections.sort(this.c0, new q());
        }
    }

    private View f1() {
        View view;
        String str;
        this.J0 = new r();
        if (this.m0) {
            View view2 = this.a0;
            if (view2 != null) {
                view2.setVisibility(8);
                view2.setAlpha(0.0f);
            }
            SkipView skipView = new SkipView(this.U);
            this.a0 = skipView;
            skipView.setOnClickListener(this.J0);
            CircleProgressView circleProgressView = new CircleProgressView(this.U);
            this.n0 = circleProgressView;
            circleProgressView.setAlpha(0.0f);
            view = this.n0;
            str = "beizi";
        } else {
            view = this.a0;
            if (view != null) {
                CircleProgressView circleProgressView2 = new CircleProgressView(this.U);
                this.n0 = circleProgressView2;
                circleProgressView2.setAlpha(0.0f);
                view = this.n0;
                str = NativeCallContext.DOMAIN_APP;
            } else {
                str = "buyer";
            }
        }
        EventBean eventBean = this.b;
        if (eventBean != null) {
            eventBean.setSkipType(str);
            H0();
        }
        return view;
    }

    private boolean g1() {
        cj cjVar = this.X;
        if (cjVar == null) {
            return false;
        }
        try {
            wk wkVarP = cjVar.p();
            if (wkVarP == null) {
                return false;
            }
            boolean z = true;
            if (wkVarP.d() != 1) {
                z = false;
            }
            this.g1 = z;
            return z;
        } catch (Exception e2) {
            e2.printStackTrace();
            return false;
        }
    }

    private boolean h1() {
        try {
            if (this.e.getInteractionRules() != null && this.e.getInteractionRules().size() > 0) {
                if ("shake".equals(c2.a(this.e.getInteractionRules(), ol.b(100))) && !q1.h().u() && this.y0 != null) {
                    return true;
                }
            } else if (!q1.h().u() && this.y0 != null) {
                return true;
            }
            return false;
        } catch (Exception e2) {
            e2.printStackTrace();
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i1() {
        m3 m3Var = this.d;
        if (m3Var == null) {
            return;
        }
        Log.d("BeiZis", "splashWorkers:" + m3Var.C().toString());
        f();
        s5 s5Var = this.g;
        if (s5Var == s5.SUCCESS) {
            c1();
            this.d.b(x(), (View) null);
        } else if (s5Var == s5.FAIL) {
            Log.d("BeiZis", "other worker shown," + x() + " remove");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j1() {
        cj cjVar = this.X;
        if (cjVar == null) {
            return;
        }
        try {
            wk wkVarP = cjVar.p();
            if (wkVarP == null) {
                return;
            }
            int iA = wkVarP.a();
            boolean z = true;
            if (wkVarP.d() != 1) {
                z = false;
            }
            this.g1 = z;
            if (iA <= 0) {
                return;
            }
            new Handler().postDelayed(new g(), iA);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k1() {
        StringBuilder sb = new StringBuilder();
        sb.append("shakeViewBean != null ? ");
        sb.append(this.y0 != null);
        sb.append(",regionalClickViewBean != null ? ");
        sb.append(this.D0 != null);
        sb.append(",fullScreenClickBean != null ? ");
        sb.append(this.H0 != null);
        jh.a("BeiZis", sb.toString());
        this.Z.getViewTreeObserver().addOnGlobalLayoutListener(new m());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l1() {
        try {
            List list = this.S0;
            if (list != null && list.size() != 0) {
                for (AdSpacesBean.ScreenConfigVoBean screenConfigVoBean : this.S0) {
                    float width = this.Z.getWidth();
                    float height = this.Z.getHeight();
                    if (width == 0.0f) {
                        width = this.q0;
                    }
                    float f2 = width;
                    float f3 = height == 0.0f ? this.r0 : height;
                    String screenW = screenConfigVoBean.getScreenW();
                    String screenH = screenConfigVoBean.getScreenH();
                    String screenX = screenConfigVoBean.getScreenX();
                    String screenY = screenConfigVoBean.getScreenY();
                    int i2 = (TextUtils.isEmpty(screenW) || screenW.equals("0")) ? (int) f2 : screenW.endsWith("%") ? (((int) f2) * Integer.parseInt(screenW.substring(0, screenW.indexOf("%")))) / 100 : so.a(this.U, Integer.parseInt(screenW));
                    int i3 = (TextUtils.isEmpty(screenH) || screenH.equals("0")) ? (int) f3 : screenH.endsWith("%") ? (((int) f3) * Integer.parseInt(screenH.substring(0, screenH.indexOf("%")))) / 100 : so.a(this.U, Integer.parseInt(screenH));
                    int i4 = (TextUtils.isEmpty(screenX) || screenX.equals("0")) ? (int) f2 : screenX.endsWith("%") ? (((int) f2) * Integer.parseInt(screenX.substring(0, screenX.indexOf("%")))) / 100 : so.a(this.U, Integer.parseInt(screenX));
                    int i5 = (TextUtils.isEmpty(screenY) || screenY.equals("0")) ? (int) f3 : screenY.endsWith("%") ? (((int) f3) * Integer.parseInt(screenY.substring(0, screenY.indexOf("%")))) / 100 : so.a(this.U, Integer.parseInt(screenY));
                    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(i2, i3);
                    int i6 = i5 - (i3 / 2);
                    int i7 = i4 - (i2 / 2);
                    if (i6 < 0) {
                        i6 = 0;
                    }
                    if (i7 < 0) {
                        i7 = 0;
                    }
                    layoutParams.topMargin = i6;
                    layoutParams.leftMargin = i7;
                    ImageView imageView = new ImageView(this.U);
                    imageView.setScaleType(ImageView.ScaleType.FIT_XY);
                    imageView.setVisibility(0);
                    imageView.setLayoutParams(layoutParams);
                    String screenImage = screenConfigVoBean.getScreenImage();
                    if (!TextUtils.isEmpty(screenImage) && screenImage.contains("http")) {
                        z3.a(this.U).a(screenImage).a(imageView);
                    }
                    float[] fArr = new float[1];
                    float[] fArr2 = new float[1];
                    imageView.setOnClickListener(new d(fArr, imageView, fArr2, f2, f3));
                    imageView.setOnTouchListener(new e(fArr, fArr2, new float[1], new float[1]));
                    this.Y.addView(imageView, layoutParams);
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private void m1() {
        AdSpacesBean.BuyerBean.ShakeViewBean shakeViewBean = this.y0;
        if (shakeViewBean == null) {
            return;
        }
        int sensorParam = shakeViewBean.getSensorParam();
        int compliantAngle = this.y0.getCompliantAngle();
        boolean zIsReturnAngle = this.y0.isReturnAngle();
        int isUnidirection = this.y0.getIsUnidirection();
        cj cjVar = this.X;
        Map mapR = cjVar != null ? cjVar.r() : null;
        tn tnVar = this.K0;
        if (tnVar == null) {
            return;
        }
        tnVar.a(sensorParam, compliantAngle, zIsReturnAngle, isUnidirection, mapR);
    }

    private void n1() {
        int i2 = (int) (((double) this.q0) * 0.15d);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(i2, (int) (((double) i2) * 0.45d));
        layoutParams.gravity = 53;
        layoutParams.topMargin = so.a(this.U, 20.0f);
        layoutParams.rightMargin = so.a(this.U, 20.0f);
        ViewGroup viewGroup = this.Y;
        if (viewGroup != null) {
            viewGroup.addView(this.a0, layoutParams);
        }
        View view = this.a0;
        if (view != null) {
            this.t0 = 1;
            this.u0 = 1;
            ((SkipView) view).setData(1, 0);
            ((SkipView) this.a0).setText(String.format("跳过 %d", Integer.valueOf(this.d1)));
            this.a0.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o1() {
        float pivotX;
        float pivotY;
        int height;
        try {
            View view = this.a0;
            if (view == null) {
                return;
            }
            int[] iArr = new int[2];
            view.getLocationOnScreen(iArr);
            if (this.p0 != null) {
                float f2 = this.q0;
                float height2 = this.Y.getHeight();
                if (height2 == 0.0f) {
                    height2 = this.r0 - so.a(this.U, 100.0f);
                }
                int width = (int) (((double) f2) * this.p0.getWidth() * 0.01d);
                int height3 = (int) (((double) width) * this.p0.getHeight() * 0.01d);
                ViewGroup.LayoutParams layoutParams = this.n0.getLayoutParams();
                layoutParams.width = width;
                layoutParams.height = height3;
                this.n0.setLayoutParams(layoutParams);
                pivotX = (f2 * ((float) (this.p0.getCenterX() * 0.01d))) - (width / 2);
                pivotY = height2 * ((float) (this.p0.getCenterY() * 0.01d));
                height = height3 / 2;
            } else {
                pivotX = (iArr[0] + this.a0.getPivotX()) - (this.n0.getWidth() / 2);
                pivotY = iArr[1] + this.a0.getPivotY();
                height = this.n0.getHeight() / 2;
            }
            this.n0.setX(pivotX);
            this.n0.setY(pivotY - height);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p1() {
        cj cjVar = this.X;
        if (cjVar == null || this.Y == null || this.Z == null) {
            return;
        }
        try {
            kj kjVarO = cjVar.o();
            if (kjVarO != null && kjVarO.f() > 0) {
                this.l1 = new lj();
                this.l1.a(kjVarO.h() == 0 ? this.Y : this.Z, this.Z.getWidth(), this.Z.getHeight(), kjVarO, new f());
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private void q1() {
        if (this.e0) {
            l0();
        }
        if (this.f0) {
            n0();
        }
        if (this.g0) {
            m0();
        }
        if (this.h0) {
            o0();
        }
        this.k0 = this.j0 - this.l0;
    }

    @Override // com.beizi.fusion.d2
    public void A0() {
        if (this.d == null) {
            return;
        }
        this.h = this.e.getAppId();
        this.i = this.e.getSpaceId();
        this.c = this.e.getBuyerSpaceUuId();
        this.A0 = "splash_cool_" + this.i;
        this.a1 = this.e.getMinShowTime();
        jh.c("BeiZis", "AdWorker chanel = " + this.c);
        boolean z = false;
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
        long sleepTime = this.f.getSleepTime();
        if (this.d.I()) {
            sleepTime = Math.max(sleepTime, this.f.getHotRequestDelay());
        }
        List list = this.b0;
        if (list != null && list.size() > 0) {
            z = true;
        }
        this.m0 = z;
        if (z) {
            e1();
        }
        Log.d("BeiZis", x() + ":requestAd:" + this.h + "====" + this.i + "===" + sleepTime);
        if (sleepTime > 0) {
            this.L.sendEmptyMessageDelayed(1, sleepTime);
        } else {
            m3 m3Var = this.d;
            if (m3Var != null && m3Var.n() < 1 && this.d.z() != 2) {
                z0();
            }
        }
        this.q0 = so.h(this.U);
        this.r0 = so.e(this.U);
        this.L0 = new sl(this.U);
    }

    @Override // com.beizi.fusion.d2
    public void G0() {
        Log.d("BeiZis", x() + " out make show ad");
        try {
            T0();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.beizi.fusion.d2
    public String x() {
        return "BEIZI";
    }

    @Override // com.beizi.fusion.d2
    public void z0() {
        Object obj;
        EventBean eventBean;
        AdSpacesBean.BuyerBean.ShakeViewBean shakeView = this.e.getShakeView();
        this.y0 = shakeView;
        if (shakeView != null) {
            this.z0 = shakeView.getCoolShakeView();
        }
        this.D0 = this.e.getRegionalClickView();
        this.H0 = this.e.getFullScreenClick();
        this.E0 = this.e.getScrollClick();
        this.S0 = this.e.getScreenConfigVo();
        try {
            AdSpacesBean.BuyerBean buyerBean = this.e;
            if (buyerBean != null && buyerBean.getIsImageSpeed() == 1 && (eventBean = this.b) != null) {
                eventBean.setIsImageSpeed("1");
                H0();
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        g0();
        K0();
        k kVar = new k();
        cj cjVar = new cj(this.U, this.Z, null, this.i);
        this.X = cjVar;
        cjVar.a((int) this.W);
        this.X.a(this.e);
        try {
            this.X.a(this.b.m167clone());
        } catch (Exception e3) {
            e3.printStackTrace();
        }
        this.X.a(10, 20, 10, 10);
        this.X.b(true);
        this.X.a(kVar);
        this.X.a(so.a(this.U, this.X0), so.a(this.U, this.Y0));
        if ("S2S".equals(l())) {
            this.X.c(l());
            m3 m3Var = this.d;
            if (m3Var != null) {
                String strQ = m3Var.q();
                if (!TextUtils.isEmpty(strQ)) {
                    this.X.b(strQ);
                }
            }
        }
        m3 m3Var2 = this.d;
        if (m3Var2 != null) {
            Map mapY = m3Var2.y();
            this.X.c(mapY);
            if (mapY != null && mapY.containsKey("returnInteraction") && (obj = mapY.get("returnInteraction")) != null && (obj instanceof Boolean)) {
                this.e1 = ((Boolean) obj).booleanValue();
            }
            this.X.d(this.d.v());
        }
        this.X.w();
    }

    public class k extends p1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        boolean f27389a = false;

        public k() {
        }

        @Override // com.beizi.fusion.p1
        public void a(int i) {
            Log.d("BeiZis", "showBeiZiSplash onAdFailedToLoad:" + i);
            i4.this.a(String.valueOf(i), i);
        }

        @Override // com.beizi.fusion.p1
        public void b() {
            Log.d("BeiZis", "showBeiZiSplash onAdClosed()");
            try {
                if (i4.this.d != null) {
                    i4.this.d.c(i4.this.x());
                }
                i4.this.b0();
                tn tnVar = i4.this.K0;
                if (tnVar != null) {
                    tnVar.q();
                }
                sl slVar = i4.this.L0;
                if (slVar != null) {
                    slVar.a();
                }
                hn hnVar = i4.this.M0;
                if (hnVar != null) {
                    hnVar.b();
                }
                jm jmVar = i4.this.P0;
                if (jmVar != null) {
                    jmVar.c();
                }
                r7 r7Var = i4.this.R0;
                if (r7Var != null) {
                    r7Var.f();
                }
                jn jnVar = i4.this.i1;
                if (jnVar != null) {
                    jnVar.c();
                }
                in inVar = i4.this.j1;
                if (inVar != null) {
                    inVar.c();
                }
                i4.this.S0();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        @Override // com.beizi.fusion.p1
        public void c() {
            if (q1.h().t() && i4.this.W - (System.currentTimeMillis() - i4.this.d.u()) < i4.this.a1) {
                Log.d("BeiZis", "showBeiZiSplash onAdLoaded slow");
                i4 i4Var = i4.this;
                i4Var.Z0 = true;
                i4Var.a(String.valueOf(3), 3);
                return;
            }
            Log.d("BeiZis", "showBeiZiSplash onAdLoaded:" + System.currentTimeMillis());
            i4 i4Var2 = i4.this;
            i4Var2.d1 = i4Var2.X.e();
            i4.this.j = b2.ADLOAD;
            if (i4.this.X.q() != null) {
                try {
                    i4 i4Var3 = i4.this;
                    i4Var3.a(Double.parseDouble(i4Var3.X.q()));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            i4 i4Var4 = i4.this;
            i4Var4.U0 = Boolean.valueOf(i4Var4.X.s());
            i4 i4Var5 = i4.this;
            i4Var5.b1 = i4Var5.X.u();
            i4 i4Var6 = i4.this;
            cj cjVar = i4Var6.X;
            if (cjVar != null) {
                i4Var6.E = cjVar.i();
                if (i4.this.E != null) {
                    i4 i4Var7 = i4.this;
                    i4Var7.F = i4Var7.E.c();
                    if (i4.this.F != 0) {
                        i4 i4Var8 = i4.this;
                        i4Var8.G = i4Var8.E.e() + 1;
                    }
                }
                i4 i4Var9 = i4.this;
                i4Var9.H = i4Var9.X.m();
            }
            i4 i4Var10 = i4.this;
            if (i4Var10.b1) {
                i4Var10.c1 = i4Var10.X.f();
                i4.this.b.setIsCacheAd("1");
                if (i4.this.c1 > 0) {
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    i4 i4Var11 = i4.this;
                    i4Var11.b.setCacheTime(String.valueOf(jCurrentTimeMillis - i4Var11.c1));
                }
                i4.this.H0();
            }
            i4.this.f0();
            if (i4.this.V()) {
                i4.this.i1();
            } else {
                i4.this.A();
            }
        }

        @Override // com.beizi.fusion.p1
        public void d() {
            Log.d("BeiZis", "showBeiZiSplash onAdShown()");
            i4.this.j = b2.ADSHOW;
            i4 i4Var = i4.this;
            if (i4Var.b1) {
                i4Var.b.setIsCacheAd("1");
                if (i4.this.c1 > 0) {
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    i4 i4Var2 = i4.this;
                    i4Var2.b.setCacheTime(String.valueOf(jCurrentTimeMillis - i4Var2.c1));
                }
                i4.this.H0();
            }
            if (i4.this.d != null) {
                if (i4.this.d.z() != 2) {
                    i4.this.d.d(i4.this.x());
                }
                i4.this.L0();
            }
            i4.this.i0();
            i4.this.y0();
            i4.this.d0();
            i4.this.p1();
            i4.this.j1();
            i4.this.N0();
        }

        @Override // com.beizi.fusion.p1
        public void a() {
            Log.d("BeiZis", "showBeiZiSplash onAdClicked()");
            co.b(i4.this.U, "uniteTime", Long.valueOf(System.currentTimeMillis()));
            if (i4.this.I && i4.this.e != null) {
                i4.this.b.setCallBackStrategyUuid(i4.this.e.getCallBackStrategyUuid());
                i4.this.H0();
            }
            i4.this.Z();
            i4 i4Var = i4.this;
            i4Var.a(i4Var.U, i4Var.Y, i4Var.H);
            if (i4.this.O()) {
                i4 i4Var2 = i4.this;
                i4Var2.W0 = true;
                if (i4Var2.d != null) {
                    i4.this.d.b(i4.this.x());
                    i4.this.I0();
                }
                i4.this.Y();
            }
        }

        @Override // com.beizi.fusion.p1
        public void a(long j) {
            try {
                if (!this.f27389a) {
                    i4.this.o1();
                    this.f27389a = true;
                }
                i4 i4Var = i4.this;
                if (i4Var.m0) {
                    long j2 = i4Var.l0;
                    if (j2 > 0 && j2 <= i4Var.j0) {
                        if (i4Var.e0) {
                            long j3 = i4Var.k0;
                            if (j3 > 0 && j > j3) {
                                i4Var.i0 = true;
                                i4Var.a0.setAlpha(0.2f);
                            } else {
                                i4Var.i0 = false;
                                i4Var.a0.setAlpha(1.0f);
                            }
                        }
                        i4 i4Var2 = i4.this;
                        if (i4Var2.l0 == i4Var2.j0) {
                            i4Var2.a0.setEnabled(false);
                        } else {
                            i4Var2.a0.setEnabled(true);
                        }
                    }
                    i4.this.e(Math.round(j / 1000.0f));
                }
                if (i4.this.d == null || i4.this.d.z() == 2) {
                    return;
                }
                i4.this.d.a(j);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private AdSpacesBean.BuyerBean.OrderDataRollViewBean d(List list, String str) {
        if (list != null && str != null) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                AdSpacesBean.BuyerBean.OrderDataRollViewBean orderDataRollViewBean = (AdSpacesBean.BuyerBean.OrderDataRollViewBean) it.next();
                List<String> orderList = orderDataRollViewBean.getOrderList();
                if (orderList != null && orderList.contains(str)) {
                    return orderDataRollViewBean;
                }
            }
        }
        return null;
    }

    private AdSpacesBean.BuyerBean.OrderDataScrollViewOrderBean e(List list, String str) {
        if (list != null && str != null) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                AdSpacesBean.BuyerBean.OrderDataScrollViewOrderBean orderDataScrollViewOrderBean = (AdSpacesBean.BuyerBean.OrderDataScrollViewOrderBean) it.next();
                List<String> orderList = orderDataScrollViewOrderBean.getOrderList();
                if (orderList != null && orderList.contains(str)) {
                    return orderDataScrollViewOrderBean;
                }
            }
        }
        return null;
    }

    private AdSpacesBean.BuyerBean.OrderDataShakeViewBean f(List list, String str) {
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
    public boolean R() {
        cj cjVar = this.X;
        if (cjVar == null) {
            return false;
        }
        return cjVar.v();
    }

    @Override // com.beizi.fusion.d2
    public void S() {
        BZVideoView bZVideoViewY;
        try {
            cj cjVar = this.X;
            if (cjVar == null || (bZVideoViewY = cjVar.y()) == null) {
                return;
            }
            bZVideoViewY.onViewPause(true);
        } catch (Exception unused) {
        }
    }

    @Override // com.beizi.fusion.d2
    public void T() {
        BZVideoView bZVideoViewY;
        try {
            cj cjVar = this.X;
            if (cjVar == null || (bZVideoViewY = cjVar.y()) == null) {
                return;
            }
            bZVideoViewY.onViewResume(true);
        } catch (Exception unused) {
        }
    }

    @Override // com.beizi.fusion.d2
    public void g() {
        super.g();
        cj cjVar = this.X;
        if (cjVar != null) {
            cjVar.a();
            this.X = null;
        }
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
        cj cjVar = this.X;
        if (cjVar == null) {
            return null;
        }
        return cjVar.d();
    }

    @Override // com.beizi.fusion.d2
    public Map o() {
        try {
            if (!this.e1) {
                if (!this.W0) {
                    return null;
                }
                if (this.V0) {
                    tn tnVar = this.K0;
                    if (tnVar == null) {
                        return null;
                    }
                    return tnVar.d();
                }
                AdSpacesBean.BuyerBean.ShakeViewBean shakeViewBean = this.y0;
                if (shakeViewBean == null || shakeViewBean.getSensorParam() == 0) {
                    return null;
                }
                HashMap map = new HashMap();
                map.put("actionType", 0);
                return map;
            }
            if (!h1()) {
                HashMap map2 = new HashMap();
                map2.put("actionType", 0);
                return map2;
            }
            cj cjVar = this.X;
            if (cjVar == null) {
                return null;
            }
            Map mapK = cjVar.k();
            if (mapK == null) {
                mapK = new HashMap();
                mapK.put("maxAcc", 15);
                mapK.put("angle", 35);
                mapK.put("duration", 3000);
                mapK.put(HiAnalyticsConstant.HaKey.BI_KEY_DIRECTION, "x或y或z");
            }
            mapK.put("actionType", 1);
            return mapK;
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    @Override // com.beizi.fusion.d2
    public JSONObject p() {
        cj cjVar = this.X;
        if (cjVar == null) {
            return null;
        }
        return cjVar.l();
    }

    @Override // com.beizi.fusion.d2
    public String s() {
        cj cjVar = this.X;
        if (cjVar == null) {
            return null;
        }
        return cjVar.q();
    }

    @Override // com.beizi.fusion.d2
    public void z() {
        if (!L() || this.X == null) {
            return;
        }
        F0();
    }

    private boolean c(long j2) {
        try {
            return System.currentTimeMillis() - so.a(this.U).longValue() < j2;
        } catch (Exception e2) {
            e2.printStackTrace();
            return false;
        }
    }

    private void b(AdSpacesBean.BuyerBean.ShakeViewBean shakeViewBean) {
        AdSpacesBean.BuyerBean.ShakeViewBean shakeViewBean2 = shakeViewBean != null ? shakeViewBean : this.y0;
        int regulatoryAngle = shakeViewBean2.getRegulatoryAngle();
        tn tnVar = this.K0;
        if (tnVar != null) {
            tnVar.g(regulatoryAngle);
            f5 f5Var = this.E;
            if (f5Var != null) {
                this.K0.a(f5Var.b());
            }
        }
        AdSpacesBean.BuyerBean.CoolShakeViewBean coolShakeViewBean = this.z0;
        if (coolShakeViewBean == null) {
            if (a(shakeViewBean)) {
                AdSpacesBean.BuyerBean.AliaseShakeViewBean aliaseShakeView = shakeViewBean2.getAliaseShakeView();
                if (aliaseShakeView != null) {
                    this.K0.a(aliaseShakeView);
                    new Handler().postDelayed(new n(shakeViewBean2), ol.b(aliaseShakeView.getPassivationTime()));
                    return;
                }
                return;
            }
            this.B0 = true;
            this.K0.a(shakeViewBean2);
            return;
        }
        if (b(coolShakeViewBean.getCoolTime())) {
            this.C0 = this.z0.getFeedback();
            this.K0.a(this.z0);
            return;
        }
        if (c(this.z0.getUserProtectTime())) {
            this.C0 = this.z0.getFeedback();
            this.K0.a(this.z0);
        } else {
            if (a(shakeViewBean)) {
                AdSpacesBean.BuyerBean.AliaseShakeViewBean aliaseShakeView2 = shakeViewBean2.getAliaseShakeView();
                if (aliaseShakeView2 != null) {
                    this.K0.a(aliaseShakeView2);
                    new Handler().postDelayed(new o(shakeViewBean2), ol.b(aliaseShakeView2.getPassivationTime()));
                    return;
                }
                return;
            }
            this.B0 = true;
            this.K0.a(shakeViewBean2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(int i2) {
        if (this.t0 == 1) {
            String strValueOf = String.valueOf(i2);
            String str = this.v0 + " ";
            String str2 = str + strValueOf;
            SpannableString spannableString = new SpannableString(str2);
            spannableString.setSpan(new ForegroundColorSpan(Color.parseColor(this.w0)), 0, str.length(), 33);
            spannableString.setSpan(new ForegroundColorSpan(Color.parseColor(this.x0)), str2.indexOf(strValueOf), str2.length(), 33);
            ((SkipView) this.a0).setText(spannableString);
            return;
        }
        SpannableString spannableString2 = new SpannableString(this.v0);
        spannableString2.setSpan(new ForegroundColorSpan(Color.parseColor(this.w0)), 0, this.v0.length(), 33);
        ((SkipView) this.a0).setText(spannableString2);
    }

    @Override // com.beizi.fusion.d2
    public void d(Map map) {
        Object obj;
        Object obj2;
        Object obj3;
        Object obj4;
        try {
            cj cjVar = this.X;
            if (cjVar == null) {
                return;
            }
            cjVar.b(map);
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

    private AdSpacesBean.BuyerBean.OrderDataRegionalClickViewBean c(List list, String str) {
        if (list != null && str != null) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                AdSpacesBean.BuyerBean.OrderDataRegionalClickViewBean orderDataRegionalClickViewBean = (AdSpacesBean.BuyerBean.OrderDataRegionalClickViewBean) it.next();
                List<String> orderList = orderDataRegionalClickViewBean.getOrderList();
                if (orderList != null && orderList.contains(str)) {
                    return orderDataRegionalClickViewBean;
                }
            }
        }
        return null;
    }

    public class b implements jm.e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f27380a;

        public b(int i) {
            this.f27380a = i;
        }

        @Override // com.beizi.fusion.jm.e
        public void a() {
            i4 i4Var = i4.this;
            if (i4Var.B0 && i4Var.O0 != null) {
                co.b(i4Var.U, i4Var.A0, Long.valueOf(System.currentTimeMillis()));
            }
            i4 i4Var2 = i4.this;
            i4Var2.I0 = RollRecoveryEntry.TYPE;
            i4Var2.b.setClickType(RollRecoveryEntry.TYPE);
            i4.this.H0();
            jh.a("BeiZis", "enter onRollHappened  ");
            i4.this.a("", "", "", "", "", "", "", "", 5);
        }

        @Override // com.beizi.fusion.jm.e
        public void a(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8) {
            if (this.f27380a == 1) {
                i4 i4Var = i4.this;
                i4Var.I0 = "regionalClick";
                i4Var.b.setClickType("regionalClick");
                i4.this.H0();
                jh.a("BeiZis", "enter onClickHappened  ");
                i4.this.a(str, str2, str3, str4, str5, str6, str7, str8, 0);
                i4.this.P0.b();
            }
        }
    }

    @Override // com.beizi.fusion.d2
    public void a(Message message) {
        EventBean eventBean = this.b;
        if (eventBean != null) {
            int i2 = message.what;
            if (this.Z0) {
                i2 = 10180;
            }
            eventBean.setError(String.valueOf(i2));
            this.b.setErrorCode(String.valueOf(i2));
            H0();
            e0();
        }
    }

    @Override // com.beizi.fusion.d2
    public void c(Map map) {
        Object obj;
        Object obj2;
        Object obj3;
        try {
            cj cjVar = this.X;
            if (cjVar == null) {
                return;
            }
            cjVar.a(map);
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

    private boolean a(AdSpacesBean.BuyerBean.ShakeViewBean shakeViewBean) {
        if (shakeViewBean != null) {
            AdSpacesBean.BuyerBean.AliaseShakeViewBean aliaseShakeView = shakeViewBean.getAliaseShakeView();
            if (aliaseShakeView == null || aliaseShakeView.getPassivationTime() <= 0) {
                return false;
            }
            return aliaseShakeView.getShakeCount() > 0 || aliaseShakeView.getRotatCount() > 0;
        }
        AdSpacesBean.BuyerBean.AliaseShakeViewBean aliaseShakeView2 = this.y0.getAliaseShakeView();
        if (this.y0.getAliaseShakeView() == null || aliaseShakeView2.getPassivationTime() <= 0) {
            return false;
        }
        return aliaseShakeView2.getShakeCount() > 0 || aliaseShakeView2.getRotatCount() > 0;
    }

    private void a(AdSpacesBean.BuyerBean.ShakeViewBean shakeViewBean, View view) {
        if (this.C0 == -1) {
            this.C0 = this.y0.getFeedback();
            if (shakeViewBean != null) {
                this.C0 = shakeViewBean.getFeedback();
            }
        }
        if (this.C0 == 0 || view == null || this.K0 == null) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            ShakeArcView shakeArcView = new ShakeArcView(this.U);
            shakeArcView.setLineRadius(5);
            int i2 = (int) (((double) marginLayoutParams.width) * 0.5d);
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(i2, i2);
            layoutParams2.leftMargin = marginLayoutParams.leftMargin + (((marginLayoutParams.width - i2) - 12) / 2);
            layoutParams2.topMargin = (int) (((double) marginLayoutParams.topMargin) + (((double) marginLayoutParams.height) * 0.08d));
            this.Y.addView(shakeArcView, layoutParams2);
            this.K0.a(shakeArcView, this.C0);
        }
    }

    private boolean b(long j2) {
        long jLongValue = ((Long) co.a(this.U, this.A0, (Object) 0L)).longValue();
        return jLongValue != 0 && System.currentTimeMillis() - jLongValue < j2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public AdSpacesBean.BuyerBean.OrderDataFullScreenClickBean b(List list, String str) {
        if (list != null && str != null) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                AdSpacesBean.BuyerBean.OrderDataFullScreenClickBean orderDataFullScreenClickBean = (AdSpacesBean.BuyerBean.OrderDataFullScreenClickBean) it.next();
                List<String> orderList = orderDataFullScreenClickBean.getOrderList();
                if (orderList != null && orderList.contains(str)) {
                    return orderDataFullScreenClickBean;
                }
            }
        }
        return null;
    }

    private void a(String str, int i2, hn.d dVar) {
        this.X.b(new p(so.a(this.U, i2), str, dVar));
    }

    @Override // com.beizi.fusion.sl.c
    public void b(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8) {
        this.I0 = "regionalClick";
        this.b.setClickType("regionalClick");
        H0();
        jh.a("BeiZis", "enter onRegionClickByPosition ");
        a(str, str2, str3, str4, str5, str6, str7, str8, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(hn.d dVar, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8) {
        try {
            if (!this.k1) {
                co.b(this.U, this.A0, Long.valueOf(System.currentTimeMillis()));
            }
            if (dVar != null) {
                dVar.a(str, str2, str3, str4, str5, str6, str7, str8);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private AdSpacesBean.BuyerBean.OrderDataEulerAngleViewBean a(List list, String str) {
        if (list != null && str != null) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                AdSpacesBean.BuyerBean.OrderDataEulerAngleViewBean orderDataEulerAngleViewBean = (AdSpacesBean.BuyerBean.OrderDataEulerAngleViewBean) it.next();
                List<String> orderList = orderDataEulerAngleViewBean.getOrderList();
                if (orderList != null && orderList.contains(str)) {
                    return orderDataEulerAngleViewBean;
                }
            }
        }
        return null;
    }

    @Override // com.beizi.fusion.hn.d
    public void b() {
        this.I0 = "scroll";
        this.b.setClickType("scroll");
        H0();
        jh.a("BeiZis", "enter onScrollDistanceMeet ");
        R0();
    }

    @Override // com.beizi.fusion.tn.c
    public void a() {
        if (this.B0 && this.z0 != null) {
            co.b(this.U, this.A0, Long.valueOf(System.currentTimeMillis()));
        }
        this.I0 = "shake";
        this.b.setClickType("shake");
        H0();
        jh.a("BeiZis", "enter onShakeHappened  ");
        P0();
        a("", "", "", "", "", "", "", "", 2);
        B0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, int i2) {
        try {
            this.f1 = true;
            cj cjVar = this.X;
            if (cjVar != null) {
                cjVar.a(str, str2, str3, str4, str5, str6, str7, str8, i2, this.G);
            }
            lj ljVar = this.l1;
            if (ljVar != null) {
                ljVar.c();
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    @Override // com.beizi.fusion.hn.d
    public void a(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8) {
        this.I0 = "scroll";
        this.b.setClickType("scroll");
        H0();
        jh.a("BeiZis", "enter onScrollDistanceMeetByPosition ");
        a(str, str2, str3, str4, str5, str6, str7, str8, 1);
    }

    private void a(AdSpacesBean.BuyerBean.RollViewBean rollViewBean) {
        AdSpacesBean.BuyerBean.CoolRollViewBean coolRollViewBean = this.O0;
        if (coolRollViewBean == null) {
            this.B0 = true;
            this.P0.a(rollViewBean);
        } else if (b(coolRollViewBean.getCoolTime())) {
            this.P0.a(this.O0);
        } else if (c(this.O0.getUserProtectTime())) {
            this.P0.a(this.O0);
        } else {
            this.B0 = true;
            this.P0.a(rollViewBean);
        }
    }
}
