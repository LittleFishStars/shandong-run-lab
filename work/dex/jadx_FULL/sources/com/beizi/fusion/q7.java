package com.beizi.fusion;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Handler;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.camera.video.AudioStats;
import androidx.constraintlayout.motion.widget.Key;
import com.beizi.fusion.model.AdSpacesBean;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class q7 {
    private static final String R = "q7";
    private static SensorManager S;
    private AnimatorSet H;
    private boolean I;
    private String J;
    private float K;
    private float L;
    private float M;
    private float N;
    private float O;
    private float P;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f27679a;
    private AdSpacesBean.BuyerBean.EulerAngleViewBean b;
    private AdSpacesBean.BuyerBean.EulerAngleViewBean c;
    private AdSpacesBean.BuyerBean.EulerAngleViewRuleBean d;
    private AdSpacesBean.BuyerBean.EulerAngleViewRuleBean e;
    private AdSpacesBean.BuyerBean.EulerAngleViewRuleBean f;
    private AdSpacesBean.BuyerBean.EulerAngleRenderBean g;
    private Sensor j;
    private String n;
    private String o;
    private String p;
    private float s;
    private e t;
    private String w;
    private float h = 1.0E-9f;
    private float[] i = new float[3];
    private double k = AudioStats.AUDIO_AMPLITUDE_NONE;
    private double l = AudioStats.AUDIO_AMPLITUDE_NONE;
    private double m = AudioStats.AUDIO_AMPLITUDE_NONE;
    private boolean q = false;
    private int r = 0;
    private boolean u = true;
    private boolean v = false;
    String x = "x";
    String y = "y";
    String z = com.google.android.exoplayer2.source.rtsp.j.o;
    String A = "0";
    String B = "1";
    String C = "2";
    private int D = 350;
    private float E = 60.0f;
    private float F = 60.0f;
    private float G = 30.0f;
    private SensorEventListener Q = new d();

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ double f27680a;
        final /* synthetic */ double b;
        final /* synthetic */ double c;

        public a(double d, double d2, double d3) {
            this.f27680a = d;
            this.b = d2;
            this.c = d3;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                q7 q7Var = q7.this;
                q7Var.s = 0.0f;
                float[] fArr = q7Var.i;
                fArr[0] = 0.0f;
                fArr[1] = 0.0f;
                fArr[2] = 0.0f;
                q7Var.k = this.f27680a;
                q7Var.l = this.b;
                q7Var.m = this.c;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public class b implements of.f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ ImageView f27681a;

        public b(ImageView imageView) {
            this.f27681a = imageView;
        }

        @Override // com.beizi.fusion.of.f
        public void a() {
        }

        @Override // com.beizi.fusion.of.f
        public void a(Bitmap bitmap) {
            try {
                ImageView imageView = this.f27681a;
                if (imageView == null || bitmap == null) {
                    return;
                }
                imageView.setImageBitmap(bitmap);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public class c implements Animator.AnimatorListener {
        public c() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            try {
                AnimatorSet animatorSet = q7.this.H;
                if (animatorSet != null) {
                    animatorSet.start();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
        }
    }

    public class d implements SensorEventListener {
        public d() {
        }

        @Override // android.hardware.SensorEventListener
        public void onAccuracyChanged(Sensor sensor, int i) {
        }

        @Override // android.hardware.SensorEventListener
        public void onSensorChanged(SensorEvent sensorEvent) {
            try {
                q7.this.a(sensorEvent);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public interface e {
        void a();
    }

    public q7(Context context, AdSpacesBean.BuyerBean.EulerAngleViewBean eulerAngleViewBean, String str, String str2) {
        this.w = null;
        this.I = false;
        this.f27679a = context;
        this.b = eulerAngleViewBean;
        this.w = "beizi_cool_" + str;
        AdSpacesBean.BuyerBean.OrderDataEulerAngleViewBean orderDataEulerAngleViewBeanA = a(this.b.getOrderData(), str2);
        if (orderDataEulerAngleViewBeanA != null && orderDataEulerAngleViewBeanA.getEulerAngleRule() != null) {
            this.c = orderDataEulerAngleViewBeanA.getEulerAngleRule();
        }
        AdSpacesBean.BuyerBean.EulerAngleViewBean eulerAngleViewBean2 = this.b;
        if (eulerAngleViewBean2 != null) {
            this.f = eulerAngleViewBean2.getCoolRule();
        }
        AdSpacesBean.BuyerBean.EulerAngleViewBean eulerAngleViewBean3 = this.c;
        if (eulerAngleViewBean3 != null) {
            this.e = eulerAngleViewBean3.getNomalRule();
            this.g = this.c.getRender();
        } else {
            AdSpacesBean.BuyerBean.EulerAngleViewBean eulerAngleViewBean4 = this.b;
            if (eulerAngleViewBean4 != null) {
                this.e = eulerAngleViewBean4.getNomalRule();
                this.g = this.b.getRender();
            }
        }
        if (!e()) {
            this.I = false;
            return;
        }
        this.I = true;
        d();
        m();
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

    private void b() {
        List<AdSpacesBean.BuyerBean.EulerAngleRuleBean> rules;
        try {
            AdSpacesBean.BuyerBean.EulerAngleViewRuleBean eulerAngleViewRuleBean = this.d;
            if (eulerAngleViewRuleBean != null && (rules = eulerAngleViewRuleBean.getRules()) != null && rules.size() != 0) {
                int passivationTime = this.d.getPassivationTime();
                double angle = 0.0d;
                double angle2 = 0.0d;
                double angle3 = 0.0d;
                for (AdSpacesBean.BuyerBean.EulerAngleRuleBean eulerAngleRuleBean : rules) {
                    if (eulerAngleRuleBean != null) {
                        if (this.x.equalsIgnoreCase(eulerAngleRuleBean.getAxis())) {
                            if (passivationTime <= 0 || eulerAngleRuleBean.getPangle() <= AudioStats.AUDIO_AMPLITUDE_NONE) {
                                this.k = eulerAngleRuleBean.getAngle();
                            } else {
                                this.k = eulerAngleRuleBean.getPangle();
                            }
                            angle = eulerAngleRuleBean.getAngle();
                            this.n = eulerAngleRuleBean.getDirection();
                        } else if (this.y.equalsIgnoreCase(eulerAngleRuleBean.getAxis())) {
                            if (passivationTime <= 0 || eulerAngleRuleBean.getPangle() <= AudioStats.AUDIO_AMPLITUDE_NONE) {
                                this.l = eulerAngleRuleBean.getAngle();
                            } else {
                                this.l = eulerAngleRuleBean.getPangle();
                            }
                            angle2 = eulerAngleRuleBean.getAngle();
                            this.o = eulerAngleRuleBean.getDirection();
                        } else if (this.z.equalsIgnoreCase(eulerAngleRuleBean.getAxis())) {
                            if (passivationTime <= 0 || eulerAngleRuleBean.getPangle() <= AudioStats.AUDIO_AMPLITUDE_NONE) {
                                this.m = eulerAngleRuleBean.getAngle();
                            } else {
                                this.m = eulerAngleRuleBean.getPangle();
                            }
                            angle3 = eulerAngleRuleBean.getAngle();
                            this.p = eulerAngleRuleBean.getDirection();
                        }
                    }
                }
                if (passivationTime > 0) {
                    new Handler().postDelayed(new a(angle, angle2, angle3), a(passivationTime));
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private void d() {
        try {
            if (!i() && !h()) {
                this.q = false;
            } else if (f()) {
                this.q = true;
            } else {
                this.q = false;
            }
            if (this.q) {
                this.d = this.f;
                b();
            } else {
                this.d = this.e;
                b();
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private boolean e() {
        List<AdSpacesBean.BuyerBean.EulerAngleRuleBean> rules;
        AdSpacesBean.BuyerBean.EulerAngleViewRuleBean eulerAngleViewRuleBean = this.e;
        if (eulerAngleViewRuleBean != null && (rules = eulerAngleViewRuleBean.getRules()) != null && rules.size() != 0) {
            for (AdSpacesBean.BuyerBean.EulerAngleRuleBean eulerAngleRuleBean : rules) {
                if (eulerAngleRuleBean != null) {
                    String axis = eulerAngleRuleBean.getAxis();
                    double angle = eulerAngleRuleBean.getAngle();
                    if (!TextUtils.isEmpty(axis) && angle > AudioStats.AUDIO_AMPLITUDE_NONE) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean f() {
        try {
            AdSpacesBean.BuyerBean.EulerAngleViewRuleBean eulerAngleViewRuleBean = this.f;
            return (eulerAngleViewRuleBean == null || eulerAngleViewRuleBean.getRules() == null || this.f.getRules().size() <= 0 || this.f.getStyle() == null) ? false : true;
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private boolean g() {
        try {
            if (this.k > AudioStats.AUDIO_AMPLITUDE_NONE) {
                if (this.C.equals(this.n)) {
                    float f = this.i[0];
                    if (f > 0.0f && Math.abs(f) >= this.k) {
                        return true;
                    }
                } else if (this.B.equals(this.n)) {
                    float f2 = this.i[0];
                    if (f2 < 0.0f && Math.abs(f2) >= this.k) {
                        return true;
                    }
                } else if (this.A.equals(this.n)) {
                    if (Math.abs(this.i[0]) >= this.k) {
                        return true;
                    }
                } else if ("3".equals(this.n) && Math.abs(this.K) >= this.k && Math.abs(this.N) > this.k) {
                    return true;
                }
            }
            if (this.l > AudioStats.AUDIO_AMPLITUDE_NONE) {
                if (this.C.equals(this.o)) {
                    float f3 = this.i[1];
                    if (f3 < 0.0f && Math.abs(f3) >= this.l) {
                        return true;
                    }
                } else if (this.B.equals(this.o)) {
                    float f4 = this.i[1];
                    if (f4 > 0.0f && Math.abs(f4) >= this.l) {
                        return true;
                    }
                } else if (this.A.equals(this.o)) {
                    if (Math.abs(this.i[1]) >= this.l) {
                        return true;
                    }
                } else if ("3".equals(this.o) && Math.abs(this.L) >= this.l && Math.abs(this.O) > this.l) {
                    return true;
                }
            }
            if (this.m > AudioStats.AUDIO_AMPLITUDE_NONE) {
                if (this.C.equals(this.p)) {
                    float f5 = this.i[2];
                    if (f5 > 0.0f && Math.abs(f5) >= this.m) {
                        return true;
                    }
                } else if (this.B.equals(this.p)) {
                    float f6 = this.i[2];
                    if (f6 < 0.0f && Math.abs(f6) >= this.m) {
                        return true;
                    }
                } else if (this.A.equals(this.p)) {
                    if (Math.abs(this.i[2]) >= this.m) {
                        return true;
                    }
                } else if ("3".equals(this.p) && Math.abs(this.M) >= this.m && Math.abs(this.P) > this.m) {
                    return true;
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return false;
    }

    private boolean h() {
        try {
            AdSpacesBean.BuyerBean.EulerAngleViewRuleBean eulerAngleViewRuleBean = this.f;
            if (eulerAngleViewRuleBean == null) {
                return false;
            }
            long coolTime = eulerAngleViewRuleBean.getCoolTime();
            long jLongValue = ((Long) pm.b(this.f27679a, this.w, 0L)).longValue();
            return jLongValue != 0 && System.currentTimeMillis() - jLongValue < coolTime;
        } catch (Exception e2) {
            e2.printStackTrace();
            return false;
        }
    }

    private boolean i() {
        try {
            AdSpacesBean.BuyerBean.EulerAngleViewRuleBean eulerAngleViewRuleBean = this.f;
            if (eulerAngleViewRuleBean == null) {
                return false;
            }
            return System.currentTimeMillis() - to.e(this.f27679a) < eulerAngleViewRuleBean.getUserProtectTime();
        } catch (Exception e2) {
            e2.printStackTrace();
            return false;
        }
    }

    private void m() {
        try {
            if (S == null) {
                S = (SensorManager) this.f27679a.getApplicationContext().getSystemService("sensor");
            }
            if (this.j == null) {
                this.j = S.getDefaultSensor(4);
            }
            S.registerListener(this.Q, this.j, 1);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private void n() {
        this.s = 0.0f;
        float[] fArr = this.i;
        fArr[0] = 0.0f;
        fArr[1] = 0.0f;
        fArr[2] = 0.0f;
        this.K = 0.0f;
        this.L = 0.0f;
        this.M = 0.0f;
        this.N = 0.0f;
        this.O = 0.0f;
        this.P = 0.0f;
    }

    private void o() {
        try {
            kh.a(R, "enter unRegisterListener");
            SensorManager sensorManager = S;
            if (sensorManager != null) {
                sensorManager.unregisterListener(this.Q);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public String c() {
        return this.J;
    }

    public void j() {
        try {
            o();
            this.b = null;
            this.c = null;
            this.d = null;
            this.e = null;
            this.f = null;
            this.g = null;
            this.f27679a = null;
            this.t = null;
            S = null;
            this.j = null;
            AnimatorSet animatorSet = this.H;
            if (animatorSet != null) {
                animatorSet.removeAllListeners();
            }
            this.H = null;
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void k() {
        this.u = false;
        n();
        o();
    }

    public void l() {
        if (this.v || !this.I) {
            return;
        }
        this.u = true;
        n();
        d();
        m();
    }

    public int a(int i) {
        return (int) ((Math.random() * ((double) i)) + 1.0d);
    }

    public void a(e eVar) {
        this.t = eVar;
    }

    /* JADX WARN: Code duplicated, block: B:62:0x0167 A[Catch: Exception -> 0x01cf, TryCatch #0 {Exception -> 0x01cf, blocks: (B:4:0x000e, B:7:0x0014, B:10:0x0034, B:13:0x003b, B:15:0x0041, B:18:0x0048, B:20:0x0063, B:21:0x0069, B:24:0x00a7, B:27:0x00ae, B:29:0x00b4, B:32:0x00bb, B:34:0x00c1, B:39:0x00dd, B:41:0x00e3, B:46:0x00ff, B:48:0x0107, B:53:0x0123, B:55:0x0129, B:60:0x0144, B:62:0x0167, B:64:0x016c, B:65:0x016f, B:56:0x0139, B:58:0x013f, B:49:0x0117, B:51:0x011d, B:42:0x00f3, B:44:0x00f9, B:35:0x00d1, B:37:0x00d7, B:67:0x01b3), top: B:72:0x000e }] */
    /* JADX WARN: Code duplicated, block: B:64:0x016c A[Catch: Exception -> 0x01cf, TryCatch #0 {Exception -> 0x01cf, blocks: (B:4:0x000e, B:7:0x0014, B:10:0x0034, B:13:0x003b, B:15:0x0041, B:18:0x0048, B:20:0x0063, B:21:0x0069, B:24:0x00a7, B:27:0x00ae, B:29:0x00b4, B:32:0x00bb, B:34:0x00c1, B:39:0x00dd, B:41:0x00e3, B:46:0x00ff, B:48:0x0107, B:53:0x0123, B:55:0x0129, B:60:0x0144, B:62:0x0167, B:64:0x016c, B:65:0x016f, B:56:0x0139, B:58:0x013f, B:49:0x0117, B:51:0x011d, B:42:0x00f3, B:44:0x00f9, B:35:0x00d1, B:37:0x00d7, B:67:0x01b3), top: B:72:0x000e }] */
    private int[] a(ViewGroup viewGroup) {
        int i;
        int i2;
        int i3;
        int i4;
        int iA;
        int iA2;
        int[] iArr = new int[4];
        if (viewGroup != null) {
            try {
                AdSpacesBean.BuyerBean.EulerAngleRenderBean eulerAngleRenderBean = this.g;
                if (eulerAngleRenderBean != null) {
                    String centerX = eulerAngleRenderBean.getCenterX();
                    String centerY = this.g.getCenterY();
                    String width = this.g.getWidth();
                    String height = this.g.getHeight();
                    if (TextUtils.isEmpty(centerX) || "0".equals(centerX)) {
                        centerX = "10";
                    }
                    if (TextUtils.isEmpty(centerY) || "0".equals(centerY)) {
                        centerY = "10";
                    }
                    viewGroup.measure(0, 0);
                    int iB = bq.b(this.f27679a, viewGroup.getMeasuredWidth());
                    int iB2 = bq.b(this.f27679a, viewGroup.getMeasuredHeight());
                    if (iB <= 0) {
                        iB = to.j(this.f27679a);
                    }
                    String str = R;
                    kh.a(str, "position containerWidth:" + iB + ";containerHeight:" + iB2 + com.alipay.sdk.m.y.l.b + viewGroup.getLayoutParams().width + com.alipay.sdk.m.y.l.b + viewGroup.getLayoutParams().height);
                    if (TextUtils.isEmpty(width) || "0".equals(width)) {
                        width = "20";
                    }
                    if (TextUtils.isEmpty(height) || "0".equals(height)) {
                        height = "20";
                    }
                    if (centerX.endsWith("%")) {
                        i = (Integer.parseInt(centerX.substring(0, centerX.indexOf("%"))) * iB) / 100;
                    } else {
                        i = !TextUtils.isEmpty(centerX) ? Integer.parseInt(centerX) : 0;
                    }
                    if (centerY.endsWith("%")) {
                        i2 = (iB2 * Integer.parseInt(centerY.substring(0, centerY.indexOf("%")))) / 100;
                    } else {
                        i2 = !TextUtils.isEmpty(centerY) ? Integer.parseInt(centerY) : 0;
                    }
                    int i5 = 20;
                    if (width.endsWith("%")) {
                        i3 = (iB * Integer.parseInt(width.substring(0, width.indexOf("%")))) / 100;
                    } else {
                        i3 = !TextUtils.isEmpty(width) ? Integer.parseInt(width) : 20;
                    }
                    if (height.endsWith("%")) {
                        i4 = (Integer.parseInt(height.substring(0, height.indexOf("%"))) * i3) / 100;
                    } else {
                        if (!TextUtils.isEmpty(width)) {
                            i4 = Integer.parseInt(height);
                        }
                        int iA3 = bq.a(this.f27679a, i3);
                        int iA4 = bq.a(this.f27679a, i5);
                        iA = bq.a(this.f27679a, i);
                        iA2 = bq.a(this.f27679a, i2);
                        iArr[0] = iA3;
                        iArr[1] = iA4;
                        if (iA > 0) {
                            iArr[2] = iA;
                        }
                        if (iA2 > 0) {
                            iArr[3] = iA2;
                        }
                        kh.a(str, "position widthInt:" + iArr[0] + ";heightInt:" + iArr[1] + ";centerX:" + iArr[2] + ";centerY:" + iArr[3] + com.alipay.sdk.m.y.l.b + centerX + com.alipay.sdk.m.y.l.b + centerY);
                        return iArr;
                    }
                    i5 = i4;
                    int iA5 = bq.a(this.f27679a, i3);
                    int iA6 = bq.a(this.f27679a, i5);
                    iA = bq.a(this.f27679a, i);
                    iA2 = bq.a(this.f27679a, i2);
                    iArr[0] = iA5;
                    iArr[1] = iA6;
                    if (iA > 0) {
                        iArr[2] = iA;
                    }
                    if (iA2 > 0) {
                        iArr[3] = iA2;
                    }
                    kh.a(str, "position widthInt:" + iArr[0] + ";heightInt:" + iArr[1] + ";centerX:" + iArr[2] + ";centerY:" + iArr[3] + com.alipay.sdk.m.y.l.b + centerX + com.alipay.sdk.m.y.l.b + centerY);
                    return iArr;
                }
            } catch (Exception e2) {
                e2.printStackTrace();
                return iArr;
            }
        }
        int iA7 = bq.a(this.f27679a, 20.0f);
        int iA8 = bq.a(this.f27679a, 10.0f);
        iArr[0] = iA7;
        iArr[1] = iA7;
        iArr[2] = iA8;
        iArr[3] = iA8;
        return iArr;
    }

    public void b(ViewGroup viewGroup) {
        AdSpacesBean.BuyerBean.EulerAngleStyleBean style;
        List<String> imgs;
        if (viewGroup != null) {
            try {
                if (this.f27679a != null && this.I) {
                    ImageView imageView = new ImageView(this.f27679a);
                    imageView.setVisibility(0);
                    imageView.setImageResource(R.mipmap.beizi_interaction_icon_euler_angle);
                    AdSpacesBean.BuyerBean.EulerAngleViewRuleBean eulerAngleViewRuleBean = this.d;
                    if (eulerAngleViewRuleBean != null && (style = eulerAngleViewRuleBean.getStyle()) != null && (imgs = style.getImgs()) != null && imgs.size() > 0) {
                        this.J = imgs.get(0);
                    }
                    if (!TextUtils.isEmpty(this.J)) {
                        of.a(this.f27679a).b(this.J, new b(imageView));
                    }
                    int[] iArrA = a(viewGroup);
                    if (viewGroup instanceof RelativeLayout) {
                        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
                        int i = iArrA[0];
                        if (i > 0) {
                            layoutParams.width = i;
                        }
                        int i2 = iArrA[1];
                        if (i2 > 0) {
                            layoutParams.height = i2;
                        }
                        layoutParams.leftMargin = iArrA[2];
                        layoutParams.topMargin = iArrA[3];
                        layoutParams.addRule(17);
                        viewGroup.addView(imageView, layoutParams);
                    } else if (viewGroup instanceof FrameLayout) {
                        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, -2, 17);
                        int i3 = iArrA[0];
                        if (i3 > 0) {
                            layoutParams2.width = i3;
                        }
                        int i4 = iArrA[1];
                        if (i4 > 0) {
                            layoutParams2.height = i4;
                        }
                        layoutParams2.leftMargin = iArrA[2];
                        layoutParams2.topMargin = iArrA[3];
                        viewGroup.addView(imageView, layoutParams2);
                    } else if (viewGroup instanceof LinearLayout) {
                        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, -2, 17.0f);
                        int i5 = iArrA[0];
                        if (i5 > 0) {
                            layoutParams3.width = i5;
                        }
                        int i6 = iArrA[1];
                        if (i6 > 0) {
                            layoutParams3.height = i6;
                        }
                        layoutParams3.leftMargin = iArrA[2];
                        layoutParams3.topMargin = iArrA[3];
                        viewGroup.addView(imageView, layoutParams3);
                    } else {
                        ViewGroup.LayoutParams layoutParams4 = new ViewGroup.LayoutParams(-1, -2);
                        int i7 = iArrA[0];
                        if (i7 > 0) {
                            layoutParams4.width = i7;
                        }
                        int i8 = iArrA[1];
                        if (i8 > 0) {
                            layoutParams4.height = i8;
                        }
                        viewGroup.addView(imageView, layoutParams4);
                    }
                    a(imageView);
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public void a(ImageView imageView) {
        try {
            ArrayList arrayList = new ArrayList();
            if (!TextUtils.isEmpty(this.n)) {
                if (this.C.equals(this.n)) {
                    a(imageView, arrayList, "rotationX", 0.0f, -this.E);
                    a(imageView, arrayList, "rotationX", -this.E, 0.0f);
                } else if (this.B.equals(this.n)) {
                    a(imageView, arrayList, "rotationX", 0.0f, this.E);
                    a(imageView, arrayList, "rotationX", this.E, 0.0f);
                } else {
                    a(imageView, arrayList, "rotationX", 0.0f, this.E);
                    a(imageView, arrayList, "rotationX", this.E, 0.0f);
                    a(imageView, arrayList, "rotationX", 0.0f, -this.E);
                    a(imageView, arrayList, "rotationX", -this.E, 0.0f);
                }
            }
            if (!TextUtils.isEmpty(this.o)) {
                if (this.C.equals(this.o)) {
                    a(imageView, arrayList, "rotationY", 0.0f, -this.F);
                    a(imageView, arrayList, "rotationY", -this.F, 0.0f);
                } else if (this.B.equals(this.o)) {
                    a(imageView, arrayList, "rotationY", 0.0f, this.F);
                    a(imageView, arrayList, "rotationY", this.F, 0.0f);
                } else {
                    a(imageView, arrayList, "rotationY", 0.0f, this.F);
                    a(imageView, arrayList, "rotationY", this.F, 0.0f);
                    a(imageView, arrayList, "rotationY", 0.0f, -this.F);
                    a(imageView, arrayList, "rotationY", -this.F, 0.0f);
                }
            }
            if (!TextUtils.isEmpty(this.p)) {
                if (this.C.equals(this.p)) {
                    a(imageView, arrayList, Key.ROTATION, 0.0f, -this.G);
                    a(imageView, arrayList, Key.ROTATION, -this.G, 0.0f);
                } else if (this.B.equals(this.p)) {
                    a(imageView, arrayList, Key.ROTATION, 0.0f, this.G);
                    a(imageView, arrayList, Key.ROTATION, this.G, 0.0f);
                } else {
                    a(imageView, arrayList, Key.ROTATION, 0.0f, this.G);
                    a(imageView, arrayList, Key.ROTATION, this.G, 0.0f);
                    a(imageView, arrayList, Key.ROTATION, 0.0f, -this.G);
                    a(imageView, arrayList, Key.ROTATION, -this.G, 0.0f);
                }
            }
            if (this.H != null) {
                this.H = null;
            }
            if (arrayList.size() > 0) {
                AnimatorSet animatorSet = new AnimatorSet();
                this.H = animatorSet;
                animatorSet.addListener(new c());
                this.H.playSequentially(arrayList);
                this.H.start();
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private void a(ImageView imageView, List list, String str, float f, float f2) {
        try {
            ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(imageView, str, f, f2);
            objectAnimatorOfFloat.setDuration(this.D);
            list.add(objectAnimatorOfFloat);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(SensorEvent sensorEvent) {
        if (sensorEvent != null) {
            try {
                if (this.u) {
                    Sensor sensor = sensorEvent.sensor;
                    float[] fArr = sensorEvent.values;
                    int type = sensor.getType();
                    if (fArr != null && type == 4) {
                        float f = this.s;
                        if (f != 0.0f) {
                            float f2 = fArr[0];
                            float f3 = fArr[1];
                            float f4 = fArr[2];
                            float f5 = (sensorEvent.timestamp - f) * this.h;
                            float[] fArr2 = this.i;
                            fArr2[0] = (float) (((double) fArr2[0]) + Math.toDegrees(f2 * f5));
                            float[] fArr3 = this.i;
                            fArr3[1] = (float) (((double) fArr3[1]) + Math.toDegrees(f3 * f5));
                            float[] fArr4 = this.i;
                            fArr4[2] = (float) (((double) fArr4[2]) + Math.toDegrees(f4 * f5));
                            float[] fArr5 = this.i;
                            float f6 = fArr5[0];
                            if (f6 > 0.0f) {
                                if (f6 > this.N) {
                                    this.N = f6;
                                }
                            } else if (f6 < this.K) {
                                this.K = f6;
                            }
                            float f7 = fArr5[1];
                            if (f7 > 0.0f) {
                                if (f7 > this.O) {
                                    this.O = f7;
                                }
                            } else if (f7 < this.L) {
                                this.L = f7;
                            }
                            float f8 = fArr5[2];
                            if (f8 > 0.0f) {
                                if (f8 > this.P) {
                                    this.P = f8;
                                }
                            } else if (f8 < this.M) {
                                this.M = f8;
                            }
                            kh.a(R, "rotate  x: " + String.format("%.4f", Float.valueOf(this.i[0])) + ",y: " + String.format("%.4f", Float.valueOf(this.i[1])) + ",z: " + String.format("%.4f", Float.valueOf(this.i[2])) + ",x : " + this.k + ",y : " + this.l + ",z : " + this.m);
                            if (g()) {
                                a();
                            }
                        }
                        this.s = sensorEvent.timestamp;
                    }
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    private void a() {
        try {
            if (this.t != null && this.u) {
                kh.a(R, "onEulerAngleHappened");
                k();
                if (!this.q) {
                    pm.d(this.f27679a, this.w, Long.valueOf(System.currentTimeMillis()));
                }
                this.t.a();
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
