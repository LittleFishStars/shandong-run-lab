package com.kc.cw.ad.d;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.kc.cw.ad.internal.p;
import com.kc.cw.ad.internal.utilities.ViewUtil;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.util.Random;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile long f38820a;
    private static SensorManager b;
    private View A;
    private float B;
    private Context c;
    private double d;
    private double e;
    private double f;
    private int g;
    private int h;
    private int k;
    private com.kc.cw.ad.e.b m;
    private a n;
    private View z;
    private int i = 0;
    private int j = 0;
    private int l = 0;
    private boolean o = false;
    private String p = "50%";
    private String q = "60%";
    private String r = "140";
    private String s = "140";
    private boolean t = false;
    private boolean u = false;
    private boolean v = false;
    private boolean w = false;
    private boolean x = false;
    private boolean y = false;
    private final float[] C = new float[3];
    private int D = 2;
    private final SensorEventListener E = new SensorEventListener(this) { // from class: com.kc.cw.ad.d.l.1

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final l f38821a;

        {
            this.f38821a = this;
        }

        @Override // android.hardware.SensorEventListener
        public void onAccuracyChanged(Sensor sensor, int i) {
        }

        /* JADX WARN: Code duplicated, block: B:46:0x016a  */
        /* JADX WARN: Code duplicated, block: B:64:0x01f4  */
        /* JADX WARN: Code duplicated, block: B:66:0x0202 A[DONT_INVERT] */
        /* JADX WARN: Code duplicated, block: B:67:0x0204  */
        /* JADX WARN: Code duplicated, block: B:68:0x0206  */
        /* JADX WARN: Code duplicated, block: B:69:0x0208 A[DONT_INVERT] */
        /* JADX WARN: Code duplicated, block: B:70:0x020a A[DONT_INVERT] */
        /* JADX WARN: Code duplicated, block: B:71:0x020c  */
        /* JADX WARN: Code duplicated, block: B:72:0x020e  */
        /* JADX WARN: Code duplicated, block: B:73:0x0210 A[DONT_INVERT] */
        /* JADX WARN: Code duplicated, block: B:74:0x0212  */
        /* JADX WARN: Code duplicated, block: B:75:0x0214  */
        /* JADX WARN: Code duplicated, block: B:77:0x0218  */
        /* JADX WARN: Code duplicated, block: B:80:0x0253  */
        /* JADX WARN: Code duplicated, block: B:83:? A[RETURN, SYNTHETIC] */
        @Override // android.hardware.SensorEventListener
        public void onSensorChanged(SensorEvent sensorEvent) {
            int degrees;
            int degrees2;
            int i;
            int iAbs;
            int iAbs2;
            int iMax;
            int i2;
            com.kc.cw.ad.a.d dVar;
            int iNextInt;
            float[] fArr = sensorEvent.values;
            if (fArr.length < 3) {
                return;
            }
            int degrees3 = 0;
            float f = fArr[0];
            float f2 = fArr[1];
            float f3 = fArr[2];
            if (sensorEvent.sensor.getType() != 1) {
                if (sensorEvent.sensor.getType() == 4) {
                    if (this.f38821a.h == 0) {
                        return;
                    }
                    if (this.f38821a.B != 0.0f) {
                        float f4 = (sensorEvent.timestamp - this.f38821a.B) * 1.0E-9f;
                        float[] fArr2 = this.f38821a.C;
                        fArr2[0] = fArr2[0] + (f * f4);
                        float[] fArr3 = this.f38821a.C;
                        fArr3[1] = fArr3[1] + (f2 * f4);
                        float[] fArr4 = this.f38821a.C;
                        fArr4[2] = fArr4[2] + (f4 * f3);
                        degrees3 = (int) Math.toDegrees(this.f38821a.C[0]);
                        degrees = (int) Math.toDegrees(this.f38821a.C[1]);
                        degrees2 = (int) Math.toDegrees(this.f38821a.C[2]);
                    } else {
                        degrees = 0;
                        degrees2 = 0;
                    }
                    this.f38821a.B = sensorEvent.timestamp;
                    double d = degrees3;
                    if (d > this.f38821a.f) {
                        this.f38821a.t = true;
                        l.i(this.f38821a);
                    }
                    if (d < (-this.f38821a.f)) {
                        this.f38821a.u = true;
                        l.i(this.f38821a);
                    }
                    double d2 = degrees;
                    if (d2 > this.f38821a.f) {
                        this.f38821a.v = true;
                        l.i(this.f38821a);
                    }
                    if (d2 < (-this.f38821a.f)) {
                        this.f38821a.w = true;
                        l.i(this.f38821a);
                    }
                    double d3 = degrees2;
                    if (d3 > this.f38821a.f) {
                        this.f38821a.x = true;
                        l.i(this.f38821a);
                    }
                    if (d3 < (-this.f38821a.f)) {
                        this.f38821a.y = true;
                        l.i(this.f38821a);
                    }
                    i = degrees3;
                    degrees3 = degrees2;
                }
                if (this.f38821a.i >= this.f38821a.g) {
                    if ((this.f38821a.h < 2 || this.f38821a.j < this.f38821a.h) && !((this.f38821a.t && this.f38821a.u) || ((this.f38821a.v && this.f38821a.w) || (this.f38821a.x && this.f38821a.y)))) {
                        return;
                    }
                    float fAbs = Math.abs(f);
                    float fAbs2 = Math.abs(f2);
                    float fAbs3 = Math.abs(f3);
                    float fMax = Math.max(Math.max(fAbs, fAbs2), fAbs3);
                    float fA = this.f38821a.a(fAbs, fMax);
                    float fA2 = this.f38821a.a(fAbs2, fMax);
                    float fA3 = this.f38821a.a(fAbs3, fMax);
                    double dA = this.f38821a.a(fA, fA2, fA3);
                    iAbs = Math.abs(i);
                    iAbs2 = Math.abs(degrees);
                    iMax = Math.max(Math.max(iAbs, iAbs2), Math.abs(degrees3));
                    if (iMax < 35) {
                        iNextInt = new Random().nextInt(30) + 35;
                        if (iAbs == iMax) {
                            if (i < 0) {
                                i = -iNextInt;
                            } else {
                                i = iNextInt;
                            }
                        } else if (iAbs2 == iMax) {
                            if (degrees < 0) {
                                degrees = -iNextInt;
                            } else {
                                degrees = iNextInt;
                            }
                        } else if (degrees3 < 0) {
                            degrees3 = -iNextInt;
                        } else {
                            degrees3 = iNextInt;
                        }
                        i2 = iNextInt;
                    } else {
                        i2 = iMax;
                    }
                    dVar = new com.kc.cw.ad.a.d(this.f38821a.k, this.f38821a.d(), this.f38821a.e(), fA, fA2, fA3, (int) dA, i2, Math.max(this.f38821a.i, this.f38821a.j));
                    if (this.f38821a.k == 1) {
                        dVar.a(i, degrees, degrees3, new Random().nextInt(500) + 3000);
                    }
                    this.f38821a.a(dVar);
                }
            }
            l lVar = this.f38821a;
            if (lVar.a(f, f2, f3, lVar.d)) {
                this.f38821a.l = 1;
            }
            if (this.f38821a.l == 1) {
                l lVar2 = this.f38821a;
                if (lVar2.b(f, f2, f3, lVar2.e)) {
                    this.f38821a.l = 2;
                    l.d(this.f38821a);
                }
            }
            i = 0;
            degrees = 0;
            if (this.f38821a.i >= this.f38821a.g) {
                if (this.f38821a.h < 2) {
                    return;
                } else {
                    return;
                }
                float fAbs4 = Math.abs(f);
                float fAbs5 = Math.abs(f2);
                float fAbs6 = Math.abs(f3);
                float fMax2 = Math.max(Math.max(fAbs4, fAbs5), fAbs6);
                float fA4 = this.f38821a.a(fAbs4, fMax2);
                float fA5 = this.f38821a.a(fAbs5, fMax2);
                float fA6 = this.f38821a.a(fAbs6, fMax2);
                double dA2 = this.f38821a.a(fA4, fA5, fA6);
                iAbs = Math.abs(i);
                iAbs2 = Math.abs(degrees);
                iMax = Math.max(Math.max(iAbs, iAbs2), Math.abs(degrees3));
                if (iMax < 35) {
                    iNextInt = new Random().nextInt(30) + 35;
                    if (iAbs == iMax) {
                        if (i < 0) {
                            i = -iNextInt;
                        } else {
                            i = iNextInt;
                        }
                    } else if (iAbs2 == iMax) {
                        if (degrees < 0) {
                            degrees = -iNextInt;
                        } else {
                            degrees = iNextInt;
                        }
                    } else if (degrees3 < 0) {
                        degrees3 = -iNextInt;
                    } else {
                        degrees3 = iNextInt;
                    }
                    i2 = iNextInt;
                } else {
                    i2 = iMax;
                }
                dVar = new com.kc.cw.ad.a.d(this.f38821a.k, this.f38821a.d(), this.f38821a.e(), fA4, fA5, fA6, (int) dA2, i2, Math.max(this.f38821a.i, this.f38821a.j));
                if (this.f38821a.k == 1) {
                    dVar.a(i, degrees, degrees3, new Random().nextInt(500) + 3000);
                }
                this.f38821a.a(dVar);
            }
        }
    };

    @Keep
    public interface a {
        void a(com.kc.cw.ad.a.d dVar);
    }

    public l(Context context) {
        this.c = context;
        b = (SensorManager) context.getApplicationContext().getSystemService("sensor");
        f();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public double a(float f, float f2, float f3) {
        return Math.sqrt(Math.pow(f, 2.0d) + Math.pow(f2, 2.0d) + Math.pow(f3, 2.0d));
    }

    private void a(long j) {
        new Handler().postDelayed(new Runnable(this) { // from class: com.kc.cw.ad.d.l.2

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final l f38822a;

            {
                this.f38822a = this;
            }

            @Override // java.lang.Runnable
            public void run() {
                try {
                    this.f38822a.b();
                } catch (Exception e) {
                    com.kc.cw.ad.d.b.f.a("OctopusAd", "An Exception Caught", e);
                }
            }
        }, j);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(float f, float f2, float f3, double d) {
        return Math.sqrt((Math.pow(((double) f) / 9.8d, 2.0d) + Math.pow(((double) f2) / 9.8d, 2.0d)) + Math.pow(((double) f3) / 9.8d, 2.0d)) > d;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean b(float f, float f2, float f3, double d) {
        return Math.sqrt((Math.pow(((double) f) / 9.8d, 2.0d) + Math.pow(((double) f2) / 9.8d, 2.0d)) + Math.pow(((double) f3) / 9.8d, 2.0d)) > d;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int d() {
        Context context;
        View view = this.z;
        int width = view != null ? view.getWidth() : 0;
        return (width > 0 || (context = this.c) == null) ? width : ViewUtil.getScreenWidth(context);
    }

    public static /* synthetic */ int d(l lVar) {
        int i = lVar.i;
        lVar.i = i + 1;
        return i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int e() {
        Context context;
        View view = this.z;
        int height = view != null ? view.getHeight() : 0;
        return (height > 0 || (context = this.c) == null) ? height : ViewUtil.getScreenHeight(context);
    }

    private void f() {
        a(1.5d);
        b(1.5d);
        c(35.0d);
        c(2);
        a(1);
    }

    private void g() {
        SensorManager sensorManager = b;
        if (sensorManager != null) {
            sensorManager.unregisterListener(this.E);
        }
    }

    private void h() {
        com.kc.cw.ad.e.b bVar = this.m;
        if (bVar != null) {
            bVar.b();
            ViewUtil.removeChildFromParent(this.m);
            this.m = null;
        }
    }

    public static /* synthetic */ int i(l lVar) {
        int i = lVar.j;
        lVar.j = i + 1;
        return i;
    }

    public float a(float f, float f2) {
        return (f != f2 || f > 15.0f) ? f : (15.0f + f) - ((int) f);
    }

    /* JADX WARN: Code duplicated, block: B:72:0x01b4  */
    public View a(View view, View view2, float f, String str, p pVar, boolean z) {
        String str2;
        int i;
        int i2;
        int i3;
        int i4;
        float f2;
        float f3;
        float f4;
        com.kc.cw.ad.d.b.f.a("OctopusAd", "enter getShakeView");
        if (this.c == null || view == null || view2 == null) {
            return null;
        }
        if (this.h == 0 && this.g == 0) {
            return null;
        }
        this.z = view;
        this.A = view2;
        int iPx2dip = ViewUtil.px2dip(view2.getContext(), view2.getWidth());
        int iPx2dip2 = ViewUtil.px2dip(view2.getContext(), view2.getHeight());
        if (TextUtils.isEmpty(str)) {
            str2 = this.k == 0 ? "摇一摇跳转至\n第三方应用或详情页" : "转一转跳转至\n第三方应用或详情页";
        } else {
            str2 = str;
        }
        if (TextUtils.isEmpty(this.p) || "0".equals(this.p)) {
            this.p = "50%";
        }
        if (TextUtils.isEmpty(this.q) || "0".equals(this.q)) {
            this.q = "50%";
        }
        if (TextUtils.isEmpty(this.r) || "0".equals(this.r)) {
            this.r = "180";
        }
        if (TextUtils.isEmpty(this.s) || "0".equals(this.s)) {
            this.s = "180";
        }
        if (this.p.endsWith("%")) {
            String str3 = this.p;
            i = (Integer.parseInt(str3.substring(0, str3.indexOf("%"))) * iPx2dip) / 100;
        } else {
            i = Integer.parseInt(this.p);
        }
        if (this.q.endsWith("%")) {
            String str4 = this.q;
            i2 = (Integer.parseInt(str4.substring(0, str4.indexOf("%"))) * iPx2dip2) / 100;
        } else {
            i2 = Integer.parseInt(this.q);
        }
        if (this.r.endsWith("%")) {
            String str5 = this.r;
            i3 = (Integer.parseInt(str5.substring(0, str5.indexOf("%"))) * iPx2dip) / 100;
        } else {
            i3 = Integer.parseInt(this.r);
        }
        if (i3 > iPx2dip) {
            i3 = iPx2dip;
        }
        if (this.s.endsWith("%")) {
            String str6 = this.s;
            i4 = (Integer.parseInt(str6.substring(0, str6.indexOf("%"))) * iPx2dip2) / 100;
        } else {
            i4 = Integer.parseInt(this.s);
        }
        if (i4 > iPx2dip2) {
            i4 = iPx2dip2;
        }
        int iDip2px = ViewUtil.dip2px(this.c, i3);
        int iDip2px2 = ViewUtil.dip2px(this.c, i4);
        int iDip2px3 = ViewUtil.dip2px(this.c, i);
        int iDip2px4 = ViewUtil.dip2px(this.c, i2);
        com.kc.cw.ad.d.b.f.a("OctopusAd", "widthInt = " + iDip2px + ",heightInt = " + iDip2px2);
        com.kc.cw.ad.d.b.f.a("OctopusAd", "centerYInt = " + iDip2px4 + ",centerXInt = " + iDip2px3 + ",adWidthDp = " + iPx2dip + ",adHeightDp = " + iPx2dip2);
        if (iDip2px4 == 0) {
            iDip2px4 = ViewUtil.dip2px(this.c, iPx2dip2) / 2;
        }
        if (z) {
            f2 = 1.0f;
        } else {
            if (pVar == p.BANNER) {
                f4 = 0.5f;
            } else if (pVar == p.INTERSTITIAL || pVar == p.NATIVE) {
                f4 = iPx2dip / 360.0f;
            } else {
                f2 = 1.0f;
            }
            f2 = f4;
        }
        if (f2 < 1.0f) {
            iDip2px = (int) (iDip2px * f2);
            iDip2px2 = (int) (iDip2px2 * f2);
            f3 = f * f2;
        } else {
            f3 = f;
        }
        com.kc.cw.ad.e.b bVar = new com.kc.cw.ad.e.b(this.c, iDip2px, f3, f2, this.k);
        this.m = bVar;
        bVar.setTitleText(str2);
        if (pVar == p.NATIVE || pVar == p.BANNER) {
            this.m.setLayoutParams(new FrameLayout.LayoutParams(iDip2px, -2, 17));
        } else {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(iDip2px, -2);
            ((ViewGroup.MarginLayoutParams) layoutParams).topMargin = iDip2px4 - (iDip2px2 / 2);
            ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin = iDip2px3 - (iDip2px / 2);
            this.m.setLayoutParams(layoutParams);
            com.kc.cw.ad.d.b.f.a("OctopusAd", "topMargin = " + ((ViewGroup.MarginLayoutParams) layoutParams).topMargin + ",leftMargin = " + ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin + ",widthInt = " + iDip2px + ",heightInt = " + iDip2px2);
        }
        this.m.a();
        return this.m;
    }

    public void a() {
        com.kc.cw.ad.d.b.f.a("OctopusAd", "enter unRegisterShakeListenerAndSetDefault");
        h();
        g();
        c();
    }

    public void a(double d) {
        this.d = d;
    }

    public void a(int i) {
        this.g = i;
    }

    public void a(View view) {
        try {
            this.A = view;
            SensorManager sensorManager = b;
            if (sensorManager != null) {
                sensorManager.registerListener(this.E, sensorManager.getDefaultSensor(1), 2);
                SensorManager sensorManager2 = b;
                sensorManager2.registerListener(this.E, sensorManager2.getDefaultSensor(4), 2);
            }
        } catch (Exception e) {
            com.kc.cw.ad.d.b.f.a("OctopusAd", "An Exception Caught", e);
        }
    }

    public void a(com.kc.cw.ad.a.c.u uVar) {
        if (uVar == null) {
            return;
        }
        a(uVar.d());
        b(uVar.d());
        c(uVar.f());
        c(uVar.c());
        b(uVar.h());
        a(1);
    }

    public void a(com.kc.cw.ad.a.d dVar) {
        View view = this.A;
        if (view == null || !view.isShown()) {
            b();
            return;
        }
        if (System.currentTimeMillis() - f38820a <= 1000) {
            b();
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("enter callBackShakeHappened and mShakeStateListener != null ? ");
        sb.append(this.n != null);
        sb.append(",!isCallBack = ");
        sb.append(!this.o);
        com.kc.cw.ad.d.b.f.a("OctopusAd", sb.toString());
        if (this.n == null || this.o) {
            return;
        }
        com.kc.cw.ad.d.b.f.a("OctopusAd", "callback onShakeHappened()");
        this.n.a(dVar);
        this.o = true;
        int i = this.D;
        if (i == 1) {
            g();
            c();
        } else if (i == 2) {
            a();
        } else if (i == 3) {
            a(2000L);
        }
        f38820a = System.currentTimeMillis();
    }

    public void a(a aVar) {
        this.n = aVar;
    }

    public void a(String str, String str2, String str3, String str4) {
        this.p = str;
        this.q = str2;
        this.r = str3;
        this.s = str4;
    }

    public void b() {
        this.t = false;
        this.u = false;
        this.v = false;
        this.w = false;
        this.x = false;
        this.y = false;
        this.o = false;
        this.i = 0;
        this.j = 0;
        this.l = 0;
    }

    public void b(double d) {
        this.e = d;
    }

    public void b(int i) {
        this.k = i;
    }

    public void c() {
        this.t = false;
        this.u = false;
        this.v = false;
        this.w = false;
        this.x = false;
        this.y = false;
        this.o = false;
        this.i = 0;
        this.j = 0;
        this.l = 0;
        this.n = null;
        this.c = null;
        this.m = null;
        this.A = null;
    }

    public void c(double d) {
        this.f = d;
    }

    public void c(int i) {
        this.h = i;
    }
}
