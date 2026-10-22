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
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.camera.video.AudioStats;
import androidx.constraintlayout.motion.widget.Key;
import com.ali.auth.third.login.LoginConstants;
import com.beizi.fusion.model.AdSpacesBean;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class sn {
    private long A;
    private String D;
    private AnimatorSet G;
    private String H;
    private boolean I;
    private int K;
    private Sensor L;
    private float M;
    private float P;
    private float Q;
    private float R;
    private float S;
    private float T;
    private float U;
    private boolean V;
    private boolean W;
    private long X;
    private boolean Y;
    private double Z;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f27759a;
    private double a0;
    private AdSpacesBean.BuyerBean.ShakeViewBean b;
    private double b0;
    private AdSpacesBean.BuyerBean.ShakeViewBean c;
    private int c0;
    private AdSpacesBean.BuyerBean.AliaseShakeViewBean d;
    private AdSpacesBean.BuyerBean.CoolShakeViewBean e;
    private AdSpacesBean.BuyerBean.PercentPositionBean f;
    private SensorManager l;
    private Sensor m;
    private float o;
    private float p;
    private float q;
    private double s;
    private double t;
    private double u;
    private int v;
    private int w;
    private double g = 9.8d;
    private int h = -100;
    private int i = 0;
    private int j = 1;
    private int k = 2;
    private f n = null;
    private int r = 0;
    private int x = 0;
    private int y = 0;
    private boolean z = true;
    private boolean B = false;
    private boolean C = false;
    private int E = 80;
    private float F = 30.0f;
    private final SensorEventListener J = new e();
    private float N = 1.0E-9f;
    private float[] O = new float[3];

    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            sn.this.u();
        }
    }

    public class b implements of.f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ ImageView f27761a;

        public b(ImageView imageView) {
            this.f27761a = imageView;
        }

        @Override // com.beizi.fusion.of.f
        public void a() {
        }

        @Override // com.beizi.fusion.of.f
        public void a(Bitmap bitmap) {
            try {
                ImageView imageView = this.f27761a;
                if (imageView == null || bitmap == null) {
                    return;
                }
                imageView.setImageBitmap(bitmap);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public class c implements of.f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ ImageView f27762a;

        public c(ImageView imageView) {
            this.f27762a = imageView;
        }

        @Override // com.beizi.fusion.of.f
        public void a() {
        }

        @Override // com.beizi.fusion.of.f
        public void a(Bitmap bitmap) {
            try {
                ImageView imageView = this.f27762a;
                if (imageView == null || bitmap == null) {
                    return;
                }
                imageView.setImageBitmap(bitmap);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public class d implements Animator.AnimatorListener {
        public d() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            try {
                AnimatorSet animatorSet = sn.this.G;
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

    public class e implements SensorEventListener {
        public e() {
        }

        @Override // android.hardware.SensorEventListener
        public void onAccuracyChanged(Sensor sensor, int i) {
        }

        @Override // android.hardware.SensorEventListener
        public void onSensorChanged(SensorEvent sensorEvent) {
            Sensor sensor;
            if (sensorEvent == null || (sensor = sensorEvent.sensor) == null) {
                return;
            }
            int type = sensor.getType();
            if (type == 1) {
                sn.this.b(sensorEvent);
            } else if (type == 4) {
                sn.this.a(sensorEvent);
            }
        }
    }

    public interface f {
        void a();
    }

    public sn(Context context, AdSpacesBean.BuyerBean.ShakeViewBean shakeViewBean, String str, String str2) {
        float f2 = -100;
        this.o = f2;
        this.p = f2;
        this.q = f2;
        this.D = null;
        this.I = false;
        try {
            this.f27759a = context;
            this.b = shakeViewBean;
            if (!TextUtils.isEmpty(str)) {
                this.D = "beizi_cool_" + str;
            }
            AdSpacesBean.BuyerBean.OrderDataShakeViewBean orderDataShakeViewBeanA = a(shakeViewBean.getOrderData(), str2);
            if (orderDataShakeViewBeanA != null && orderDataShakeViewBeanA.getShakeView() != null) {
                this.c = orderDataShakeViewBeanA.getShakeView();
            }
            AdSpacesBean.BuyerBean.ShakeViewBean shakeViewBean2 = this.b;
            if (shakeViewBean2 != null) {
                this.e = shakeViewBean2.getCoolShakeView();
                this.K = shakeViewBean.getRegulatoryAngle();
                this.c0 = this.b.getIsUnidirection();
            }
            AdSpacesBean.BuyerBean.ShakeViewBean shakeViewBean3 = this.c;
            if (shakeViewBean3 != null) {
                this.d = shakeViewBean3.getAliaseShakeView();
                this.f = this.c.getPosition();
                List<String> imageURL = this.c.getImageURL();
                if (imageURL != null && imageURL.size() > 0) {
                    this.H = imageURL.get(0);
                }
                this.K = this.c.getRegulatoryAngle();
                this.c0 = this.c.getIsUnidirection();
            } else {
                AdSpacesBean.BuyerBean.ShakeViewBean shakeViewBean4 = this.b;
                if (shakeViewBean4 != null) {
                    this.d = shakeViewBean4.getAliaseShakeView();
                    this.f = this.b.getPosition();
                    List<String> imageURL2 = this.b.getImageURL();
                    if (imageURL2 != null && imageURL2.size() > 0) {
                        this.H = imageURL2.get(0);
                    }
                }
            }
            if (!f()) {
                this.I = false;
                return;
            }
            this.I = true;
            r();
            o();
            q();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private boolean f() {
        double shakeStartAmplitude;
        double shakeEndAmplitude;
        int shakeCount;
        AdSpacesBean.BuyerBean.ShakeViewBean shakeViewBean = this.c;
        if (shakeViewBean != null) {
            shakeStartAmplitude = shakeViewBean.getShakeStartAmplitude();
            shakeEndAmplitude = this.c.getShakeEndAmplitude();
            shakeCount = this.c.getShakeCount();
        } else {
            AdSpacesBean.BuyerBean.ShakeViewBean shakeViewBean2 = this.b;
            if (shakeViewBean2 != null) {
                shakeStartAmplitude = shakeViewBean2.getShakeStartAmplitude();
                shakeEndAmplitude = this.b.getShakeEndAmplitude();
                shakeCount = this.b.getShakeCount();
            } else {
                shakeStartAmplitude = 0.0d;
                shakeEndAmplitude = 0.0d;
                shakeCount = 0;
            }
        }
        return shakeStartAmplitude > AudioStats.AUDIO_AMPLITUDE_NONE && shakeEndAmplitude > AudioStats.AUDIO_AMPLITUDE_NONE && shakeCount > 0;
    }

    private boolean g() {
        try {
            AdSpacesBean.BuyerBean.AliaseShakeViewBean aliaseShakeViewBean = this.d;
            return aliaseShakeViewBean != null && aliaseShakeViewBean.getPassivationTime() > 0 && (this.d.getShakeCount() > 0 || this.d.getRotatCount() > 0);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private boolean h() {
        try {
            AdSpacesBean.BuyerBean.CoolShakeViewBean coolShakeViewBean = this.e;
            if (coolShakeViewBean == null) {
                return false;
            }
            if (coolShakeViewBean.getShakeCount() > 0 || this.e.getRotatCount() > 0) {
                return true;
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return false;
    }

    private boolean i() {
        try {
            if (this.e == null || TextUtils.isEmpty(this.D)) {
                return false;
            }
            long coolTime = this.e.getCoolTime();
            long jLongValue = ((Long) pm.b(this.f27759a, this.D, 0L)).longValue();
            return jLongValue != 0 && System.currentTimeMillis() - jLongValue < coolTime;
        } catch (Exception e2) {
            e2.printStackTrace();
            return false;
        }
    }

    private boolean j() {
        try {
            AdSpacesBean.BuyerBean.CoolShakeViewBean coolShakeViewBean = this.e;
            if (coolShakeViewBean == null) {
                return false;
            }
            return System.currentTimeMillis() - to.e(this.f27759a) < coolShakeViewBean.getUserProtectTime();
        } catch (Exception e2) {
            e2.printStackTrace();
            return false;
        }
    }

    private void n() {
        try {
            SensorManager sensorManager = this.l;
            if (sensorManager != null) {
                Sensor defaultSensor = sensorManager.getDefaultSensor(4);
                this.L = defaultSensor;
                if (defaultSensor != null) {
                    this.l.registerListener(this.J, defaultSensor, 1);
                } else {
                    this.V = true;
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private void o() {
        try {
            kh.a("ShakeUtil", "registerShakeListener");
            this.C = true;
            p();
            if (this.l == null) {
                this.l = (SensorManager) this.f27759a.getApplicationContext().getSystemService("sensor");
            }
            if (this.m == null) {
                this.m = this.l.getDefaultSensor(1);
            }
            this.l.registerListener(this.J, this.m, 2);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private void p() {
        this.x = 0;
        this.y = 0;
        float f2 = this.h;
        this.o = f2;
        this.p = f2;
        this.q = f2;
        this.r = this.i;
        this.P = 0.0f;
        this.Q = 0.0f;
        this.R = 0.0f;
        this.S = 0.0f;
        this.T = 0.0f;
        this.U = 0.0f;
        this.M = 0.0f;
        this.W = false;
        if (this.K > 0) {
            this.V = false;
        } else if (this.Z > AudioStats.AUDIO_AMPLITUDE_NONE) {
            this.V = true;
        }
        this.Y = false;
    }

    private void r() {
        try {
            p();
            if (!j() && !i()) {
                this.B = false;
            } else if (h()) {
                this.B = true;
            } else {
                this.B = false;
            }
            if (this.B) {
                t();
            } else if (g()) {
                s();
            } else {
                u();
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private void s() {
        try {
            if (this.d == null) {
                return;
            }
            kh.a("ShakeUtil", "setShakeSensitivityAliase");
            c(this.d.getShakeCount());
            d(this.d.getShakeStartAmplitude());
            c(this.d.getShakeEndAmplitude());
            b(this.d.getRotatAmplitude());
            b(this.d.getRotatCount());
            new Handler().postDelayed(new a(), a(this.d.getPassivationTime()));
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private void t() {
        try {
            if (this.e == null) {
                return;
            }
            kh.a("ShakeUtil", "setShakeSensitivityCool");
            c(this.e.getShakeCount());
            d(this.e.getShakeStartAmplitude());
            c(this.e.getShakeEndAmplitude());
            b(this.e.getRotatAmplitude());
            b(this.e.getRotatCount());
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u() {
        try {
            kh.a("ShakeUtil", "setShakeSensitivityNormal");
            p();
            AdSpacesBean.BuyerBean.ShakeViewBean shakeViewBean = this.c;
            if (shakeViewBean != null) {
                c(shakeViewBean.getShakeCount());
                d(this.c.getShakeStartAmplitude());
                c(this.c.getShakeEndAmplitude());
                b(this.c.getRotatAmplitude());
                b(this.c.getRotatCount());
                return;
            }
            AdSpacesBean.BuyerBean.ShakeViewBean shakeViewBean2 = this.b;
            if (shakeViewBean2 != null) {
                c(shakeViewBean2.getShakeCount());
                d(this.b.getShakeStartAmplitude());
                c(this.b.getShakeEndAmplitude());
                b(this.b.getRotatAmplitude());
                b(this.b.getRotatCount());
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private void v() {
        try {
            kh.a("ShakeUtil", "unRegisterShakeListener");
            this.C = false;
            SensorManager sensorManager = this.l;
            if (sensorManager != null) {
                sensorManager.unregisterListener(this.J);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void a(AdSpacesBean.BuyerBean.ShakeViewBean shakeViewBean) {
        this.b = shakeViewBean;
    }

    public void b(double d2) {
        this.u = d2;
    }

    public String c() {
        return this.H;
    }

    public void d(ViewGroup viewGroup) {
        if (viewGroup != null) {
            try {
                if (this.f27759a != null && this.I) {
                    ImageView imageView = new ImageView(this.f27759a);
                    imageView.setVisibility(0);
                    imageView.setImageResource(R.mipmap.beizi_interaction_icon_shake);
                    if (!TextUtils.isEmpty(this.H)) {
                        of.a(this.f27759a).b(this.H, new b(imageView));
                    }
                    int[] iArrC = c(viewGroup);
                    if (viewGroup instanceof RelativeLayout) {
                        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
                        int i = iArrC[0];
                        if (i > 0) {
                            layoutParams.width = i;
                        }
                        int i2 = iArrC[1];
                        if (i2 > 0) {
                            layoutParams.height = i2;
                        }
                        layoutParams.leftMargin = iArrC[2];
                        layoutParams.topMargin = iArrC[3];
                        layoutParams.addRule(17);
                        viewGroup.addView(imageView, layoutParams);
                    } else if (viewGroup instanceof FrameLayout) {
                        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, -2, 17);
                        int i3 = iArrC[0];
                        if (i3 > 0) {
                            layoutParams2.width = i3;
                        }
                        int i4 = iArrC[1];
                        if (i4 > 0) {
                            layoutParams2.height = i4;
                        }
                        layoutParams2.leftMargin = iArrC[2];
                        layoutParams2.topMargin = iArrC[3];
                        viewGroup.addView(imageView, layoutParams2);
                    } else if (viewGroup instanceof LinearLayout) {
                        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, -2, 17.0f);
                        int i5 = iArrC[0];
                        if (i5 > 0) {
                            layoutParams3.width = i5;
                        }
                        int i6 = iArrC[1];
                        if (i6 > 0) {
                            layoutParams3.height = i6;
                        }
                        layoutParams3.leftMargin = iArrC[2];
                        layoutParams3.topMargin = iArrC[3];
                        viewGroup.addView(imageView, layoutParams3);
                    } else {
                        ViewGroup.LayoutParams layoutParams4 = new ViewGroup.LayoutParams(-1, -2);
                        int i7 = iArrC[0];
                        if (i7 > 0) {
                            layoutParams4.width = i7;
                        }
                        int i8 = iArrC[1];
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

    public double e() {
        return this.b0;
    }

    public void k() {
        try {
            v();
            this.b = null;
            this.c = null;
            this.e = null;
            this.d = null;
            this.f = null;
            this.f27759a = null;
            this.l = null;
            this.m = null;
            this.n = null;
            AnimatorSet animatorSet = this.G;
            if (animatorSet != null) {
                animatorSet.removeAllListeners();
            }
            this.G = null;
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void l() {
        try {
            this.z = false;
            v();
            p();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void m() {
        try {
            if (!this.C && this.I) {
                this.z = true;
                r();
                o();
                q();
                a(this.Z);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void q() {
        if (this.K > 0) {
            n();
        } else {
            this.V = true;
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

    /* JADX WARN: Code duplicated, block: B:62:0x0167 A[Catch: Exception -> 0x01cf, TryCatch #0 {Exception -> 0x01cf, blocks: (B:4:0x0010, B:7:0x0016, B:10:0x0036, B:13:0x003d, B:15:0x0043, B:18:0x004a, B:20:0x0065, B:21:0x006b, B:24:0x00a7, B:27:0x00ae, B:29:0x00b4, B:32:0x00bb, B:34:0x00c1, B:39:0x00dd, B:41:0x00e3, B:46:0x00ff, B:48:0x0107, B:53:0x0123, B:55:0x0129, B:60:0x0144, B:62:0x0167, B:64:0x016c, B:65:0x016f, B:56:0x0139, B:58:0x013f, B:49:0x0117, B:51:0x011d, B:42:0x00f3, B:44:0x00f9, B:35:0x00d1, B:37:0x00d7, B:67:0x01b3), top: B:72:0x0010 }] */
    /* JADX WARN: Code duplicated, block: B:64:0x016c A[Catch: Exception -> 0x01cf, TryCatch #0 {Exception -> 0x01cf, blocks: (B:4:0x0010, B:7:0x0016, B:10:0x0036, B:13:0x003d, B:15:0x0043, B:18:0x004a, B:20:0x0065, B:21:0x006b, B:24:0x00a7, B:27:0x00ae, B:29:0x00b4, B:32:0x00bb, B:34:0x00c1, B:39:0x00dd, B:41:0x00e3, B:46:0x00ff, B:48:0x0107, B:53:0x0123, B:55:0x0129, B:60:0x0144, B:62:0x0167, B:64:0x016c, B:65:0x016f, B:56:0x0139, B:58:0x013f, B:49:0x0117, B:51:0x011d, B:42:0x00f3, B:44:0x00f9, B:35:0x00d1, B:37:0x00d7, B:67:0x01b3), top: B:72:0x0010 }] */
    private int[] c(ViewGroup viewGroup) {
        int i;
        int i2;
        int i3;
        int i4;
        int iA;
        int iA2;
        int[] iArr = new int[4];
        if (viewGroup != null) {
            try {
                AdSpacesBean.BuyerBean.PercentPositionBean percentPositionBean = this.f;
                if (percentPositionBean != null) {
                    String centerX = percentPositionBean.getCenterX();
                    String centerY = this.f.getCenterY();
                    String width = this.f.getWidth();
                    String height = this.f.getHeight();
                    if (TextUtils.isEmpty(centerX) || "0".equals(centerX)) {
                        centerX = "10";
                    }
                    if (TextUtils.isEmpty(centerY) || "0".equals(centerY)) {
                        centerY = "10";
                    }
                    viewGroup.measure(0, 0);
                    int iB = bq.b(this.f27759a, viewGroup.getMeasuredWidth());
                    int iB2 = bq.b(this.f27759a, viewGroup.getMeasuredHeight());
                    if (iB <= 0) {
                        iB = to.j(this.f27759a);
                    }
                    kh.a("ShakeUtil", "position containerWidth:" + iB + ";containerHeight:" + iB2 + com.alipay.sdk.m.y.l.b + viewGroup.getLayoutParams().width + com.alipay.sdk.m.y.l.b + viewGroup.getLayoutParams().height);
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
                    if (!height.endsWith("%")) {
                        if (!TextUtils.isEmpty(width)) {
                            i4 = Integer.parseInt(height);
                        }
                        int iA3 = bq.a(this.f27759a, i3);
                        int iA4 = bq.a(this.f27759a, i5);
                        iA = bq.a(this.f27759a, i);
                        iA2 = bq.a(this.f27759a, i2);
                        iArr[0] = iA3;
                        iArr[1] = iA4;
                        if (iA > 0) {
                            iArr[2] = iA;
                        }
                        if (iA2 > 0) {
                            iArr[3] = iA2;
                        }
                        kh.a("ShakeUtil", "position widthInt:" + iArr[0] + ";heightInt:" + iArr[1] + ";centerX:" + iArr[2] + ";centerY:" + iArr[3] + com.alipay.sdk.m.y.l.b + centerX + com.alipay.sdk.m.y.l.b + centerY);
                        return iArr;
                    }
                    i4 = (Integer.parseInt(height.substring(0, height.indexOf("%"))) * i3) / 100;
                    i5 = i4;
                    int iA5 = bq.a(this.f27759a, i3);
                    int iA6 = bq.a(this.f27759a, i5);
                    iA = bq.a(this.f27759a, i);
                    iA2 = bq.a(this.f27759a, i2);
                    iArr[0] = iA5;
                    iArr[1] = iA6;
                    if (iA > 0) {
                        iArr[2] = iA;
                    }
                    if (iA2 > 0) {
                        iArr[3] = iA2;
                    }
                    kh.a("ShakeUtil", "position widthInt:" + iArr[0] + ";heightInt:" + iArr[1] + ";centerX:" + iArr[2] + ";centerY:" + iArr[3] + com.alipay.sdk.m.y.l.b + centerX + com.alipay.sdk.m.y.l.b + centerY);
                    return iArr;
                }
            } catch (Exception e2) {
                e2.printStackTrace();
                return iArr;
            }
        }
        int iA7 = bq.a(this.f27759a, 20.0f);
        int iA8 = bq.a(this.f27759a, 10.0f);
        iArr[0] = iA7;
        iArr[1] = iA7;
        iArr[2] = iA8;
        iArr[3] = iA8;
        return iArr;
    }

    public void b(int i) {
        this.w = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(SensorEvent sensorEvent) {
        float[] fArr;
        try {
            if (System.currentTimeMillis() - this.A >= 100 && sensorEvent != null && this.z && (fArr = sensorEvent.values) != null && fArr.length >= 3) {
                this.A = System.currentTimeMillis();
                float f2 = fArr[0];
                float f3 = fArr[1];
                float f4 = fArr[2];
                double dA = a(f2, f3, f4);
                if (dA > this.s) {
                    double dB = b(f2, f3, f4);
                    if (this.a0 < dB) {
                        this.a0 = dB;
                    }
                    this.r = this.j;
                }
                if (dA <= this.t && this.r == this.j) {
                    this.r = this.k;
                    this.x++;
                }
                int i = this.v;
                if (i <= 0 || this.x < i) {
                    return;
                }
                this.W = true;
                kh.d("ShakeUtil", " current: " + String.format("%.4f", Double.valueOf(dA)) + ", execute: " + this.x + ", count: " + this.v + LoginConstants.UNDER_LINE + this.w + ", shake: " + this.s + LoginConstants.UNDER_LINE + this.t);
                if (this.W && this.V) {
                    b();
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public View a(ViewGroup viewGroup) {
        if (viewGroup != null) {
            try {
                if (this.f27759a != null && this.I) {
                    ImageView imageView = new ImageView(this.f27759a);
                    imageView.setVisibility(0);
                    imageView.setImageResource(R.drawable.beizi_icon_shake_native);
                    if (!TextUtils.isEmpty(this.H)) {
                        of.a(this.f27759a).b(this.H, new c(imageView));
                    }
                    int[] iArrB = b(viewGroup);
                    if (viewGroup instanceof RelativeLayout) {
                        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
                        int i = iArrB[0];
                        if (i > 0) {
                            layoutParams.width = i;
                        }
                        int i2 = iArrB[1];
                        if (i2 > 0) {
                            layoutParams.height = i2;
                        }
                        layoutParams.leftMargin = iArrB[2];
                        layoutParams.topMargin = iArrB[3];
                        layoutParams.addRule(83);
                        viewGroup.addView(imageView, layoutParams);
                        return imageView;
                    }
                    if (viewGroup instanceof FrameLayout) {
                        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, -2, 83);
                        int i3 = iArrB[0];
                        if (i3 > 0) {
                            layoutParams2.width = i3;
                        }
                        int i4 = iArrB[1];
                        if (i4 > 0) {
                            layoutParams2.height = i4;
                        }
                        viewGroup.addView(imageView, layoutParams2);
                        return imageView;
                    }
                    if (viewGroup instanceof LinearLayout) {
                        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, -2, 83.0f);
                        int i5 = iArrB[0];
                        if (i5 > 0) {
                            layoutParams3.width = i5;
                        }
                        int i6 = iArrB[1];
                        if (i6 > 0) {
                            layoutParams3.height = i6;
                        }
                        layoutParams3.leftMargin = iArrB[2];
                        layoutParams3.topMargin = iArrB[3];
                        viewGroup.addView(imageView, layoutParams3);
                        return imageView;
                    }
                    ViewGroup.LayoutParams layoutParams4 = new ViewGroup.LayoutParams(-1, -2);
                    int i7 = iArrB[0];
                    if (i7 > 0) {
                        layoutParams4.width = i7;
                    }
                    int i8 = iArrB[1];
                    if (i8 > 0) {
                        layoutParams4.height = i8;
                    }
                    viewGroup.addView(imageView, layoutParams4);
                    return imageView;
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return null;
    }

    private synchronized void b() {
        try {
            if (this.n != null && this.z && !this.Y) {
                this.Y = true;
                kh.a("ShakeUtil", "callBackResult");
                l();
                if (!this.B && !TextUtils.isEmpty(this.D)) {
                    pm.d(this.f27759a, this.D, Long.valueOf(System.currentTimeMillis()));
                }
                this.n.a();
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /* JADX WARN: Code duplicated, block: B:72:0x0181 A[Catch: Exception -> 0x01e9, TryCatch #0 {Exception -> 0x01e9, blocks: (B:4:0x0010, B:7:0x0016, B:10:0x0034, B:13:0x003b, B:15:0x0041, B:18:0x0048, B:20:0x004e, B:23:0x0056, B:25:0x005c, B:28:0x0064, B:30:0x007f, B:31:0x0085, B:34:0x00c1, B:37:0x00c8, B:39:0x00ce, B:42:0x00d5, B:44:0x00db, B:49:0x00f7, B:51:0x00fd, B:56:0x0119, B:58:0x0121, B:63:0x013d, B:65:0x0143, B:70:0x015e, B:72:0x0181, B:74:0x0186, B:75:0x0189, B:66:0x0153, B:68:0x0159, B:59:0x0131, B:61:0x0137, B:52:0x010d, B:54:0x0113, B:45:0x00eb, B:47:0x00f1, B:77:0x01cd), top: B:82:0x0010 }] */
    /* JADX WARN: Code duplicated, block: B:74:0x0186 A[Catch: Exception -> 0x01e9, TryCatch #0 {Exception -> 0x01e9, blocks: (B:4:0x0010, B:7:0x0016, B:10:0x0034, B:13:0x003b, B:15:0x0041, B:18:0x0048, B:20:0x004e, B:23:0x0056, B:25:0x005c, B:28:0x0064, B:30:0x007f, B:31:0x0085, B:34:0x00c1, B:37:0x00c8, B:39:0x00ce, B:42:0x00d5, B:44:0x00db, B:49:0x00f7, B:51:0x00fd, B:56:0x0119, B:58:0x0121, B:63:0x013d, B:65:0x0143, B:70:0x015e, B:72:0x0181, B:74:0x0186, B:75:0x0189, B:66:0x0153, B:68:0x0159, B:59:0x0131, B:61:0x0137, B:52:0x010d, B:54:0x0113, B:45:0x00eb, B:47:0x00f1, B:77:0x01cd), top: B:82:0x0010 }] */
    private int[] b(ViewGroup viewGroup) {
        int i;
        int i2;
        int i3;
        int i4;
        int iA;
        int iA2;
        int[] iArr = new int[4];
        if (viewGroup != null) {
            try {
                AdSpacesBean.BuyerBean.PercentPositionBean percentPositionBean = this.f;
                if (percentPositionBean != null) {
                    String centerX = percentPositionBean.getCenterX();
                    String centerY = this.f.getCenterY();
                    String width = this.f.getWidth();
                    String height = this.f.getHeight();
                    if (TextUtils.isEmpty(centerX) || "0".equals(centerX)) {
                        centerX = "0";
                    }
                    if (TextUtils.isEmpty(centerY) || "0".equals(centerY)) {
                        centerY = "0";
                    }
                    if (TextUtils.isEmpty(width) || "0".equals(width)) {
                        width = "120";
                    }
                    if (TextUtils.isEmpty(height) || "0".equals(height)) {
                        height = "36";
                    }
                    viewGroup.measure(0, 0);
                    int iB = bq.b(this.f27759a, viewGroup.getMeasuredWidth());
                    int iB2 = bq.b(this.f27759a, viewGroup.getMeasuredHeight());
                    if (iB <= 0) {
                        iB = to.j(this.f27759a);
                    }
                    kh.a("ShakeUtil", "position containerWidth:" + iB + ";containerHeight:" + iB2 + com.alipay.sdk.m.y.l.b + viewGroup.getLayoutParams().width + com.alipay.sdk.m.y.l.b + viewGroup.getLayoutParams().height);
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
                        int iA3 = bq.a(this.f27759a, i3);
                        int iA4 = bq.a(this.f27759a, i5);
                        iA = bq.a(this.f27759a, i);
                        iA2 = bq.a(this.f27759a, i2);
                        iArr[0] = iA3;
                        iArr[1] = iA4;
                        if (iA > 0) {
                            iArr[2] = iA;
                        }
                        if (iA2 > 0) {
                            iArr[3] = iA2;
                        }
                        kh.a("ShakeUtil", "position widthInt:" + iArr[0] + ";heightInt:" + iArr[1] + ";centerX:" + iArr[2] + ";centerY:" + iArr[3] + com.alipay.sdk.m.y.l.b + centerX + com.alipay.sdk.m.y.l.b + centerY);
                        return iArr;
                    }
                    i5 = i4;
                    int iA5 = bq.a(this.f27759a, i3);
                    int iA6 = bq.a(this.f27759a, i5);
                    iA = bq.a(this.f27759a, i);
                    iA2 = bq.a(this.f27759a, i2);
                    iArr[0] = iA5;
                    iArr[1] = iA6;
                    if (iA > 0) {
                        iArr[2] = iA;
                    }
                    if (iA2 > 0) {
                        iArr[3] = iA2;
                    }
                    kh.a("ShakeUtil", "position widthInt:" + iArr[0] + ";heightInt:" + iArr[1] + ";centerX:" + iArr[2] + ";centerY:" + iArr[3] + com.alipay.sdk.m.y.l.b + centerX + com.alipay.sdk.m.y.l.b + centerY);
                    return iArr;
                }
            } catch (Exception e2) {
                e2.printStackTrace();
                return iArr;
            }
        }
        int iA7 = bq.a(this.f27759a, 120.0f);
        int iA8 = bq.a(this.f27759a, 36.0f);
        iArr[0] = iA7;
        iArr[1] = iA8;
        iArr[2] = 0;
        iArr[3] = 0;
        return iArr;
    }

    public void c(double d2) {
        this.t = d2;
    }

    public void c(int i) {
        this.v = i;
    }

    public void d(double d2) {
        this.s = d2;
    }

    public void a(ImageView imageView) {
        try {
            ArrayList arrayList = new ArrayList();
            a(imageView, arrayList, Key.ROTATION, 0.0f, this.F);
            a(imageView, arrayList, Key.ROTATION, this.F, 0.0f);
            a(imageView, arrayList, Key.ROTATION, 0.0f, -this.F);
            a(imageView, arrayList, Key.ROTATION, -this.F, 0.0f);
            if (arrayList.size() > 0) {
                AnimatorSet animatorSet = new AnimatorSet();
                this.G = animatorSet;
                animatorSet.addListener(new d());
                this.G.playSequentially(arrayList);
                this.G.start();
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public double d() {
        try {
            double d2 = this.a0;
            if (d2 > AudioStats.AUDIO_AMPLITUDE_NONE) {
                this.a0 = d2 / this.g;
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return this.a0;
    }

    private void a(ImageView imageView, List list, String str, float f2, float f3) {
        try {
            ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(imageView, str, f2, f3);
            objectAnimatorOfFloat.setDuration(this.E);
            list.add(objectAnimatorOfFloat);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public int a(int i) {
        return (int) ((Math.random() * ((double) i)) + 1.0d);
    }

    public void a(f fVar) {
        this.n = fVar;
    }

    private double a(float f2, float f3, float f4) {
        try {
            return Math.sqrt(Math.pow(((double) f2) / this.g, 2.0d) + Math.pow(((double) f3) / this.g, 2.0d) + Math.pow(((double) f4) / this.g, 2.0d));
        } catch (Exception e2) {
            e2.printStackTrace();
            return AudioStats.AUDIO_AMPLITUDE_NONE;
        }
    }

    public void a(double d2) {
        if (this.K > 0) {
            return;
        }
        this.Z = d2;
        n();
        this.V = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(SensorEvent sensorEvent) {
        if (sensorEvent != null) {
            try {
                if (!this.Y && System.currentTimeMillis() - this.X >= 50) {
                    Sensor sensor = sensorEvent.sensor;
                    float[] fArr = sensorEvent.values;
                    int type = sensor.getType();
                    if (fArr != null && type == 4) {
                        this.X = System.currentTimeMillis();
                        float f2 = this.M;
                        if (f2 != 0.0f) {
                            float f3 = fArr[0];
                            float f4 = fArr[1];
                            float f5 = fArr[2];
                            float f6 = (sensorEvent.timestamp - f2) * this.N;
                            float[] fArr2 = this.O;
                            fArr2[0] = (float) (((double) fArr2[0]) + Math.toDegrees(f3 * f6));
                            float[] fArr3 = this.O;
                            fArr3[1] = (float) (((double) fArr3[1]) + Math.toDegrees(f4 * f6));
                            float[] fArr4 = this.O;
                            fArr4[2] = (float) (((double) fArr4[2]) + Math.toDegrees(f5 * f6));
                            float[] fArr5 = this.O;
                            float f7 = fArr5[0];
                            if (f7 > 0.0f) {
                                if (f7 > this.S) {
                                    this.S = f7;
                                }
                            } else if (f7 < this.P) {
                                this.P = f7;
                            }
                            float f8 = fArr5[1];
                            if (f8 > 0.0f) {
                                if (f8 > this.T) {
                                    this.T = f8;
                                }
                            } else if (f8 < this.Q) {
                                this.Q = f8;
                            }
                            float f9 = fArr5[2];
                            if (f9 > 0.0f) {
                                if (f9 > this.U) {
                                    this.U = f9;
                                }
                            } else if (f9 < this.R) {
                                this.R = f9;
                            }
                            double dMax = Math.max(Math.abs(f7), Math.max(Math.abs(this.O[1]), Math.abs(this.O[2])));
                            if (this.b0 < dMax) {
                                this.b0 = dMax;
                            }
                            if (this.K > 0) {
                                a();
                                if (this.W && this.V) {
                                    b();
                                }
                            }
                        }
                        this.M = sensorEvent.timestamp;
                    }
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    private double b(float f2, float f3, float f4) {
        return Math.sqrt(Math.pow(f2, 2.0d) + Math.pow(f3, 2.0d) + Math.pow(f4, 2.0d));
    }

    private void a() {
        if (this.c0 == 0) {
            if ((Math.abs(this.P) <= this.K || Math.abs(this.S) <= this.K) && ((Math.abs(this.Q) <= this.K || Math.abs(this.T) <= this.K) && (Math.abs(this.R) <= this.K || Math.abs(this.U) <= this.K))) {
                return;
            }
            kh.a("ShakeUtil", "rotate  xMin: " + String.format("%.4f", Float.valueOf(this.P)) + ",xMax: " + String.format("%.4f", Float.valueOf(this.S)) + ",yMin: " + String.format("%.4f", Float.valueOf(this.Q)) + ",yMax: " + String.format("%.4f", Float.valueOf(this.T)) + ",zMin: " + String.format("%.4f", Float.valueOf(this.R)) + ",zMax: " + String.format("%.4f", Float.valueOf(this.U)));
            this.V = true;
            return;
        }
        if (Math.abs(this.P) > this.K || Math.abs(this.S) > this.K || Math.abs(this.Q) > this.K || Math.abs(this.T) > this.K || Math.abs(this.R) > this.K || Math.abs(this.U) > this.K) {
            kh.a("ShakeUtil", "rotate  xMin: " + String.format("%.4f", Float.valueOf(this.P)) + ",xMax: " + String.format("%.4f", Float.valueOf(this.S)) + ",yMin: " + String.format("%.4f", Float.valueOf(this.Q)) + ",yMax: " + String.format("%.4f", Float.valueOf(this.T)) + ",zMin: " + String.format("%.4f", Float.valueOf(this.R)) + ",zMax: " + String.format("%.4f", Float.valueOf(this.U)));
            this.V = true;
        }
    }

    public void a(double d2, double d3) {
        if (this.e != null) {
            return;
        }
        this.s = d2;
        this.t = d3;
        this.x = 0;
        this.y = 0;
        float f2 = this.h;
        this.o = f2;
        this.p = f2;
        this.q = f2;
        this.r = this.i;
        this.P = 0.0f;
        this.Q = 0.0f;
        this.R = 0.0f;
        this.S = 0.0f;
        this.T = 0.0f;
        this.U = 0.0f;
        this.M = 0.0f;
    }
}
