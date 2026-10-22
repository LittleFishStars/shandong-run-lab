package com.beizi.fusion;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.text.TextUtils;
import android.util.Pair;
import android.view.View;
import android.view.ViewGroup;
import androidx.camera.video.AudioStats;
import com.beizi.fusion.model.AdSpacesBean;
import com.beizi.fusion.update.ShakeArcView;
import com.beizi.fusion.widget.ShakeView;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class tn {
    private static SensorManager k0;
    private Map A;
    private boolean B;
    private double C;
    ShakeView G;
    private float I;
    private int M;
    private Sensor N;
    private float O;
    private float R;
    private float S;
    private float T;
    private float U;
    private float V;
    private float W;
    private boolean X;
    private boolean Y;
    private long Z;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f27792a;
    private double a0;
    private double b;
    private boolean b0;
    private double c;
    private int c0;
    private double d;
    private int d0;
    private int e;
    private String e0;
    private int f;
    private long f0;
    private int g;
    private long g0;
    private int h;
    private boolean u;
    private double v;
    private int w;
    private int x;
    private int y;
    private boolean z;
    private int i = 0;
    private int j = 0;
    private float k = -100.0f;
    private float l = -100.0f;
    private float m = -100.0f;
    private int n = 0;
    private c o = null;
    private boolean p = false;
    private int q = 200;
    private long r = 0;
    private ShakeArcView s = null;
    private int t = 0;
    private float[] D = new float[3];
    private float[] E = new float[3];
    private final SensorEventListener F = new b();
    private float H = 0.0f;
    private float J = 0.0f;
    private float K = 0.0f;
    final float L = 0.85f;
    private float P = 1.0E-9f;
    private float[] Q = new float[3];
    private double h0 = 0.35d;
    private float[] i0 = new float[3];
    private Random j0 = new Random();

    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            tn.this.c();
        }
    }

    public class b implements SensorEventListener {
        public b() {
        }

        @Override // android.hardware.SensorEventListener
        public void onAccuracyChanged(Sensor sensor, int i) {
        }

        @Override // android.hardware.SensorEventListener
        public void onSensorChanged(SensorEvent sensorEvent) {
            if (sensorEvent == null) {
                return;
            }
            try {
                Sensor sensor = sensorEvent.sensor;
                if (sensor == null) {
                    return;
                }
                int type = sensor.getType();
                if (type == 1) {
                    if (tn.this.k()) {
                        tn.this.b(sensorEvent);
                        return;
                    } else {
                        tn.this.d(sensorEvent);
                        return;
                    }
                }
                if (type == 2) {
                    tn.this.E = (float[]) sensorEvent.values.clone();
                } else if (type == 4) {
                    if (tn.this.k()) {
                        tn.this.a(sensorEvent);
                    } else {
                        tn.this.c(sensorEvent);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public interface c {
        void a();
    }

    public tn(Context context) {
        this.f27792a = context;
        k0 = (SensorManager) context.getApplicationContext().getSystemService("sensor");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(SensorEvent sensorEvent) {
        float[] fArr;
        int i;
        if (sensorEvent == null || (fArr = sensorEvent.values) == null || fArr.length < 3) {
            return;
        }
        float f = fArr[0];
        float f2 = fArr[1];
        float f3 = fArr[2];
        if (this.k == -100.0f) {
            this.k = f;
        }
        if (this.l == -100.0f) {
            this.l = f2;
        }
        if (this.m == -100.0f) {
            this.m = f3;
        }
        double dAbs = ((double) Math.abs(f - this.k)) / 9.8d;
        double dAbs2 = ((double) Math.abs(f2 - this.l)) / 9.8d;
        double dAbs3 = ((double) Math.abs(f3 - this.m)) / 9.8d;
        double d = this.d;
        if (dAbs > d) {
            this.j++;
            this.k = f;
        }
        if (dAbs2 > d) {
            this.j++;
            this.l = f2;
        }
        if (dAbs3 > d) {
            this.j++;
            this.m = f3;
        }
        if (this.B && this.z) {
            float[] fArr2 = (float[]) sensorEvent.values.clone();
            this.D = fArr2;
            float f4 = fArr2[0] * 0.85f;
            float[] fArr3 = sensorEvent.values;
            fArr2[0] = f4 + (fArr3[0] * 0.14999998f);
            fArr2[1] = (fArr2[1] * 0.85f) + (fArr3[1] * 0.14999998f);
            fArr2[2] = (fArr2[2] * 0.85f) + (fArr3[2] * 0.14999998f);
            b();
        }
        double dB = b(f, f2, f3, this.b);
        if (dB > this.b) {
            double dA = a(f, f2, f3);
            if (this.v < dA) {
                this.v = dA;
            }
            this.n = 1;
        }
        if (this.n == 1 && a(f, f2, f3, this.c)) {
            this.n = 2;
            this.i++;
        }
        a(dAbs, dAbs2, dAbs3, dB);
        int i2 = this.e;
        if ((i2 <= 0 || this.i < i2) && ((i = this.f) <= 0 || this.j < i)) {
            return;
        }
        if (this.B && this.z && this.C < this.x) {
            this.i--;
            return;
        }
        jh.c("ShakeUtil", "mShakeCount = " + this.i + ",dstShakeCount = " + this.e + ",mRotateCount = " + this.j + ",dstRotateCount = " + this.f);
        this.Y = true;
        if (this.X) {
            c();
        }
    }

    private Map g() {
        HashMap map = new HashMap();
        map.put("actionType", 1);
        map.put("maxAcc", Double.valueOf(Double.parseDouble(String.format("%.2f", Double.valueOf(this.v)))));
        if (this.z) {
            map.put("angle", Long.valueOf(Math.round(this.C)));
        }
        return map;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean k() {
        return this.w == 1 && this.b0;
    }

    private void l() {
        try {
            SensorManager sensorManager = k0;
            if (sensorManager != null) {
                Sensor defaultSensor = sensorManager.getDefaultSensor(4);
                this.N = defaultSensor;
                if (defaultSensor != null) {
                    k0.registerListener(this.F, defaultSensor, 1);
                } else {
                    this.X = true;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void o() {
        Pair pairA = a(this.h);
        if (((Boolean) pairA.second).booleanValue()) {
            b9.a(new a(), this.g + (((Integer) pairA.first).intValue() * 10));
        }
    }

    private void p() {
        int i;
        ShakeArcView shakeArcView = this.s;
        if (shakeArcView == null || (i = this.t) == 0) {
            return;
        }
        if (i != 1) {
            if (i == 2) {
                shakeArcView.setMaxProgress(this.e);
            }
        } else {
            if (this.f > 0) {
                double d = this.d;
                if (d > AudioStats.AUDIO_AMPLITUDE_NONE) {
                    shakeArcView.setMaxProgress(d);
                    return;
                }
            }
            shakeArcView.setMaxProgress(this.b);
        }
    }

    public void a(AdSpacesBean.BuyerBean.ShakeViewBean shakeViewBean) {
        if (shakeViewBean == null) {
            return;
        }
        jh.b("ShakeUtil", "setShakeParams mShakeCount:" + shakeViewBean.getShakeCount() + ";mRotateCount:" + shakeViewBean.getRotatCount());
        try {
            this.k = -100.0f;
            this.l = -100.0f;
            this.m = -100.0f;
            this.i = 0;
            this.j = 0;
            this.n = 0;
            h(shakeViewBean.getShakeCount());
            d(shakeViewBean.getShakeStartAmplitude());
            c(shakeViewBean.getShakeEndAmplitude());
            b(shakeViewBean.getRotatAmplitude());
            c(shakeViewBean.getRotatCount());
            f(shakeViewBean.getRandomClickTime());
            e(shakeViewBean.getRandomClickNum());
            b(shakeViewBean.getAnimationInterval());
            p();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void b(double d) {
        this.d = d;
    }

    public void c(double d) {
        this.c = d;
    }

    public void e(int i) {
        this.h = i;
        if (i > 0) {
            o();
        }
    }

    public void f(int i) {
        this.g = i;
    }

    public void h(int i) {
        this.e = i;
    }

    public double i() {
        try {
            double d = this.v;
            if (d > AudioStats.AUDIO_AMPLITUDE_NONE) {
                this.v = d / 9.8d;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return this.v;
    }

    public double j() {
        return this.C;
    }

    public void m() {
        SensorManager sensorManager = k0;
        if (sensorManager != null) {
            sensorManager.registerListener(this.F, sensorManager.getDefaultSensor(1), 100000);
        }
    }

    public void n() {
        this.p = false;
        this.i = 0;
        this.j = 0;
        this.k = -100.0f;
        this.l = -100.0f;
        this.m = -100.0f;
        this.n = 0;
        this.o = null;
        this.f27792a = null;
        this.G = null;
        this.q = 200;
        this.s = null;
        this.R = 0.0f;
        this.S = 0.0f;
        this.T = 0.0f;
        this.U = 0.0f;
        this.V = 0.0f;
        this.W = 0.0f;
        this.O = 0.0f;
        this.Y = false;
        if (this.M > 0) {
            this.X = false;
        }
    }

    public void q() {
        jh.a("BeiZis", "enter unRegisterShakeListenerAndSetDefault");
        SensorManager sensorManager = k0;
        if (sensorManager != null) {
            sensorManager.unregisterListener(this.F);
        }
        n();
        ShakeView shakeView = this.G;
        if (shakeView != null) {
            shakeView.stopShake();
        }
    }

    private double b(float f, float f2, float f3, double d) {
        return Math.sqrt(Math.pow(((double) f) / 9.8d, 2.0d) + Math.pow(((double) f2) / 9.8d, 2.0d) + Math.pow(((double) f3) / 9.8d, 2.0d));
    }

    private int f() {
        int iNextInt = this.x + new Random().nextInt(150 - this.x);
        return iNextInt > 120 ? iNextInt - new Random().nextInt(30) : iNextInt;
    }

    private Map h() {
        HashMap map = new HashMap();
        map.put("actionType", 1);
        Map map2 = this.A;
        if (map2 == null) {
            Double dE = e();
            dE.doubleValue();
            map.put("maxAcc", dE);
            if (this.z) {
                map.put("angle", Integer.valueOf(f()));
                return map;
            }
        } else {
            double dDoubleValue = map2.containsKey("maxAcc") ? ((Double) this.A.get("maxAcc")).doubleValue() : 0.0d;
            if (dDoubleValue <= AudioStats.AUDIO_AMPLITUDE_NONE) {
                dDoubleValue = e().doubleValue();
            }
            map.put("maxAcc", Double.valueOf(dDoubleValue));
            if (this.z) {
                int iRound = this.A.containsKey("angle") ? (int) Math.round(((Double) this.A.get("angle")).doubleValue()) : 0;
                if (iRound > 0) {
                    map.put("angle", Integer.valueOf(iRound));
                    return map;
                }
                map.put("angle", Integer.valueOf(f()));
            }
        }
        return map;
    }

    public void c(int i) {
        this.f = i;
    }

    private Double e() {
        return Double.valueOf(Double.parseDouble(String.format("%.2f", Double.valueOf((((double) new Random().nextInt(1500)) / 100.0d) + 15.0d))));
    }

    public void b(int i) {
        this.q = i;
    }

    public synchronized void c() {
        StringBuilder sb = new StringBuilder();
        sb.append("enter callBackShakeHappened and mShakeStateListener != null ? ");
        sb.append(this.o != null);
        sb.append(",!isCallBack = ");
        sb.append(!this.p);
        jh.a("BeiZis", sb.toString());
        if (this.o != null && !this.p) {
            jh.a("BeiZis", "callback onShakeHappened()");
            ShakeArcView shakeArcView = this.s;
            if (shakeArcView != null && !yp.b(shakeArcView)) {
                jh.c("ShakeUtil", "mShakeCount onShakeHappened mShakeArcView is not show");
                this.k = -100.0f;
                this.l = -100.0f;
                this.m = -100.0f;
                this.i = 0;
                this.j = 0;
                this.n = 0;
                return;
            }
            this.p = true;
            this.o.a();
            ShakeView shakeView = this.G;
            if (shakeView != null) {
                shakeView.stopShake();
                q();
            }
        }
    }

    private void b() {
        float[] fArr = new float[9];
        SensorManager.getRotationMatrix(fArr, null, this.D, this.E);
        float[] fArr2 = {degrees, 0.0f, 0.0f};
        SensorManager.getOrientation(fArr, fArr2);
        float degrees = (float) Math.toDegrees(fArr2[0]);
        if (degrees == 0.0f) {
            return;
        }
        float f = this.H;
        if (f == 0.0f) {
            this.H = degrees;
            return;
        }
        float f2 = degrees - f;
        if (Math.abs(f2) > 180.0f) {
            this.H = fArr2[0];
            return;
        }
        float f3 = this.I + f2;
        this.I = f3;
        if (f3 < this.J) {
            this.J = f3;
        }
        if (f3 > this.K) {
            this.K = f3;
        }
        double dAbs = Math.abs(this.K - this.J);
        if (dAbs <= 360.0d) {
            if (dAbs > 180.0d) {
                this.C = 360.0d - dAbs;
            } else {
                this.C = dAbs;
            }
        }
        double d = this.C;
        if (d > 120.0d) {
            this.C = d - ((double) new Random().nextInt(30));
        }
        this.H = fArr2[0];
    }

    public void g(int i) {
        this.M = i;
        if (i > 0) {
            l();
        } else {
            this.X = true;
        }
    }

    public void a(AdSpacesBean.BuyerBean.CoolShakeViewBean coolShakeViewBean) {
        if (coolShakeViewBean == null) {
            return;
        }
        jh.b("ShakeUtil", "setShakeCoolParams mShakeCount:" + coolShakeViewBean.getShakeCount() + ";mRotateCount:" + coolShakeViewBean.getRotatCount());
        try {
            h(coolShakeViewBean.getShakeCount());
            d(coolShakeViewBean.getShakeStartAmplitude());
            c(coolShakeViewBean.getShakeEndAmplitude());
            b(coolShakeViewBean.getRotatAmplitude());
            c(coolShakeViewBean.getRotatCount());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(SensorEvent sensorEvent) {
        if (sensorEvent != null) {
            try {
                if (!this.p && System.currentTimeMillis() - this.Z >= 50) {
                    Sensor sensor = sensorEvent.sensor;
                    float[] fArr = sensorEvent.values;
                    int type = sensor.getType();
                    if (fArr != null && type == 4) {
                        this.Z = System.currentTimeMillis();
                        float f = this.O;
                        if (f != 0.0f) {
                            float f2 = fArr[0];
                            float f3 = fArr[1];
                            float f4 = fArr[2];
                            float f5 = (sensorEvent.timestamp - f) * this.P;
                            float[] fArr2 = this.Q;
                            fArr2[0] = (float) (((double) fArr2[0]) + Math.toDegrees(f2 * f5));
                            float[] fArr3 = this.Q;
                            fArr3[1] = (float) (((double) fArr3[1]) + Math.toDegrees(f3 * f5));
                            float[] fArr4 = this.Q;
                            fArr4[2] = (float) (((double) fArr4[2]) + Math.toDegrees(f4 * f5));
                            float[] fArr5 = this.Q;
                            float f6 = fArr5[0];
                            if (f6 > 0.0f) {
                                if (f6 > this.U) {
                                    this.U = f6;
                                }
                            } else if (f6 < this.R) {
                                this.R = f6;
                            }
                            float f7 = fArr5[1];
                            if (f7 > 0.0f) {
                                if (f7 > this.V) {
                                    this.V = f7;
                                }
                            } else if (f7 < this.S) {
                                this.S = f7;
                            }
                            float f8 = fArr5[2];
                            if (f8 > 0.0f) {
                                if (f8 > this.W) {
                                    this.W = f8;
                                }
                            } else if (f8 < this.T) {
                                this.T = f8;
                            }
                            double dMax = Math.max(Math.abs(f6), Math.max(Math.abs(this.Q[1]), Math.abs(this.Q[2])));
                            if (this.C < dMax) {
                                this.C = dMax;
                            }
                            if (this.M > 0) {
                                a();
                                if (this.Y && this.X) {
                                    c();
                                }
                            }
                        }
                        this.O = sensorEvent.timestamp;
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(SensorEvent sensorEvent) {
        if (sensorEvent == null) {
            return;
        }
        try {
            float[] fArr = sensorEvent.values;
            if (fArr != null && fArr.length >= 3) {
                double dA = a(fArr[0], fArr[1], fArr[2]);
                if (dA > 10.7d && this.f0 > 0) {
                    this.g0 += System.currentTimeMillis() - this.f0;
                }
                this.f0 = System.currentTimeMillis();
                if (this.v < dA) {
                    this.v = dA;
                }
                if (dA > this.d0) {
                    jh.c("ShakeUtil", "tempShakeAcc:" + dA + ";shakeMaxAngle:" + this.C + ";mShakeDurationTime:" + this.g0 + ";mDirection:" + this.e0);
                }
                if (this.v >= this.d0 && this.C >= this.x && this.g0 >= this.c0) {
                    this.Y = true;
                    if (this.X) {
                        c();
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void a(AdSpacesBean.BuyerBean.AliaseShakeViewBean aliaseShakeViewBean) {
        if (aliaseShakeViewBean == null) {
            return;
        }
        jh.b("ShakeUtil", "setShakeAliaseParams mShakeCount:" + aliaseShakeViewBean.getShakeCount() + ";mRotateCount:" + aliaseShakeViewBean.getRotatCount());
        try {
            h(aliaseShakeViewBean.getShakeCount());
            d(aliaseShakeViewBean.getShakeStartAmplitude());
            c(aliaseShakeViewBean.getShakeEndAmplitude());
            b(aliaseShakeViewBean.getRotatAmplitude());
            c(aliaseShakeViewBean.getRotatCount());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void a(ShakeArcView shakeArcView, int i) {
        jh.b("ShakeUtil", "setShakeFeedback feedback:" + i);
        a(shakeArcView);
        d(i);
        p();
    }

    private void a(double d, double d2, double d3, double d4) {
        double d5;
        ShakeArcView shakeArcView = this.s;
        if (shakeArcView == null) {
            return;
        }
        if (this.t == 2) {
            shakeArcView.setCurrentProgress(this.i);
            return;
        }
        if (this.f > 0 && this.d > AudioStats.AUDIO_AMPLITUDE_NONE) {
            if (d >= d2 && d >= d3) {
                d5 = d;
            } else if (d2 < d || d2 < d3) {
                d5 = (d3 < d || d3 < d2) ? 0.0d : d3;
            } else {
                d5 = d2;
            }
            double dDoubleValue = new BigDecimal(d5).setScale(2, 4).doubleValue();
            if (dDoubleValue >= 0.1d) {
                this.s.setCurrentProgress(dDoubleValue);
                return;
            } else {
                if (dDoubleValue < 0.1d) {
                    this.s.setCurrentProgress(AudioStats.AUDIO_AMPLITUDE_NONE);
                    return;
                }
                return;
            }
        }
        int i = this.e;
        if (i > 0 && this.i >= i) {
            shakeArcView.setCurrentProgress(this.b);
            return;
        }
        double dDoubleValue2 = new BigDecimal(d4).setScale(2, 4).doubleValue();
        if (dDoubleValue2 >= 1.1d) {
            this.s.setCurrentProgress(dDoubleValue2);
        } else if (dDoubleValue2 < 1.1d) {
            this.s.setCurrentProgress(AudioStats.AUDIO_AMPLITUDE_NONE);
        }
    }

    public void d(int i) {
        this.t = i;
    }

    public void d(double d) {
        this.b = d;
    }

    public Map d() {
        int i = this.w;
        if (i == 0) {
            return null;
        }
        if (i == 2) {
            return h();
        }
        if (i != 1) {
            return null;
        }
        if (this.B) {
            return g();
        }
        return h();
    }

    public void a(c cVar) {
        this.o = cVar;
    }

    public void a(ShakeArcView shakeArcView) {
        this.s = shakeArcView;
    }

    private boolean a(float f, float f2, float f3, double d) {
        return Math.sqrt((Math.pow(((double) f) / 9.8d, 2.0d) + Math.pow(((double) f2) / 9.8d, 2.0d)) + Math.pow(((double) f3) / 9.8d, 2.0d)) < d;
    }

    public static Pair a(int i) {
        int iRandom = (int) ((Math.random() * 100.0d) + 1.0d);
        if (iRandom <= i) {
            return new Pair(Integer.valueOf(iRandom), Boolean.TRUE);
        }
        return new Pair(Integer.valueOf(iRandom), Boolean.FALSE);
    }

    public View a(int i, int i2, AdSpacesBean.BuyerBean.PercentPositionBean percentPositionBean) {
        int i3;
        int i4;
        int i5;
        jh.a("BeiZis", "enter getShakeView");
        if (this.f27792a == null || percentPositionBean == null) {
            return null;
        }
        this.G = new ShakeView(this.f27792a);
        String centerX = percentPositionBean.getCenterX();
        String centerY = percentPositionBean.getCenterY();
        String width = percentPositionBean.getWidth();
        String height = percentPositionBean.getHeight();
        if (TextUtils.isEmpty(centerX) || "0".equals(centerX)) {
            centerX = "50%";
        }
        if (TextUtils.isEmpty(centerY) || "0".equals(centerY)) {
            centerY = "50%";
        }
        if (TextUtils.isEmpty(width) || "0".equals(width)) {
            width = "180";
        }
        if (TextUtils.isEmpty(height) || "0".equals(height)) {
            height = "180";
        }
        float fI = so.i(this.f27792a);
        if (centerX.endsWith("%")) {
            i3 = (Integer.parseInt(centerX.substring(0, centerX.indexOf("%"))) * i) / 100;
        } else {
            i3 = Integer.parseInt(centerX);
        }
        if (centerY.endsWith("%")) {
            i4 = (Integer.parseInt(centerY.substring(0, centerY.indexOf("%"))) * i2) / 100;
        } else {
            i4 = Integer.parseInt(centerY);
        }
        int i6 = 400;
        if (width.endsWith("%")) {
            int i7 = Integer.parseInt(width.substring(0, width.indexOf("%")));
            if (fI >= 400.0f) {
                i6 = (i7 * 400) / 100;
            } else {
                i6 = (((int) fI) * i7) / 100;
            }
        } else {
            int i8 = Integer.parseInt(width);
            if (i8 < 400) {
                i6 = i8;
            }
        }
        if (height.endsWith("%")) {
            i5 = (Integer.parseInt(height.substring(0, height.indexOf("%"))) * i6) / 100;
        } else {
            i5 = Integer.parseInt(height);
        }
        int iA = so.a(this.f27792a, i6);
        int iA2 = so.a(this.f27792a, i5);
        int iA3 = so.a(this.f27792a, i3);
        int iA4 = so.a(this.f27792a, i4);
        jh.a("BeiZis", "widthInt = " + iA + ",heightInt = " + iA2);
        if (iA == 0) {
            iA = 180;
        }
        if (iA2 == 0) {
            iA2 = iA;
        }
        ViewGroup.MarginLayoutParams marginLayoutParams = new ViewGroup.MarginLayoutParams(iA, iA2);
        jh.a("BeiZis", "centerYInt = " + iA4 + ",centerXInt = " + iA3 + ",adWidthDp = " + i + ",adHeightDp = " + i2);
        if (iA4 == 0) {
            iA4 = so.a(this.f27792a, i2) / 2;
        }
        if (iA3 == 0) {
            iA3 = so.a(this.f27792a, i) / 2;
        }
        marginLayoutParams.topMargin = iA4 - (iA2 / 2);
        marginLayoutParams.leftMargin = iA3 - (iA / 2);
        this.G.setLayoutParams(marginLayoutParams);
        jh.a("BeiZis", "topMargin = " + marginLayoutParams.topMargin + ",leftMargin = " + marginLayoutParams.leftMargin + ",widthInt = " + iA + ",heightInt = " + iA2);
        this.G.setDownloadApp(Boolean.valueOf(this.u));
        this.G.startShake();
        m();
        return this.G;
    }

    public void a(int i, int i2, boolean z, int i3, Map map) {
        Sensor defaultSensor;
        try {
            this.w = i;
            this.x = i2;
            this.z = z;
            this.y = i3;
            this.A = map;
            if (i2 <= 0) {
                this.x = 35;
            }
            if (i == 1) {
                if (map == null) {
                    this.B = true;
                    return;
                } else if (!map.containsKey("forceUnreal")) {
                    this.B = true;
                    return;
                } else {
                    Object obj = map.get("forceUnreal");
                    if (!(obj instanceof Boolean ? ((Boolean) obj).booleanValue() : false)) {
                        this.B = true;
                    }
                }
            }
            if (this.B && z && (defaultSensor = k0.getDefaultSensor(2)) != null) {
                k0.registerListener(this.F, defaultSensor, 1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private double a(float f, float f2, float f3) {
        return Math.sqrt(Math.pow(f, 2.0d) + Math.pow(f2, 2.0d) + Math.pow(f3, 2.0d));
    }

    public void a(Boolean bool) {
        this.u = bool.booleanValue();
    }

    public void a(double d) {
        if (this.M > 0) {
            return;
        }
        this.a0 = d;
        l();
        this.X = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(SensorEvent sensorEvent) {
        if (sensorEvent != null) {
            try {
                if (!this.p && System.currentTimeMillis() - this.Z >= 50) {
                    Sensor sensor = sensorEvent.sensor;
                    float[] fArr = sensorEvent.values;
                    int type = sensor.getType();
                    if (fArr != null && type == 4) {
                        this.Z = System.currentTimeMillis();
                        float f = this.O;
                        if (f != 0.0f) {
                            float f2 = fArr[0];
                            float f3 = fArr[1];
                            float f4 = fArr[2];
                            double d = this.h0;
                            double d2 = ((double) f2) * d;
                            double d3 = 1.0d - d;
                            float[] fArr2 = this.i0;
                            float f5 = (float) (d2 + (((double) fArr2[0]) * d3));
                            fArr2[0] = f5;
                            float f6 = (float) ((d * ((double) f3)) + (((double) fArr2[1]) * d3));
                            fArr2[1] = f6;
                            float f7 = (float) ((d * ((double) f4)) + (d3 * ((double) fArr2[2])));
                            fArr2[2] = f7;
                            float f8 = (sensorEvent.timestamp - f) * this.P;
                            float[] fArr3 = this.Q;
                            fArr3[0] = (float) (((double) fArr3[0]) + Math.toDegrees(f5 * f8));
                            float[] fArr4 = this.Q;
                            fArr4[1] = (float) (((double) fArr4[1]) + Math.toDegrees(f6 * f8));
                            float[] fArr5 = this.Q;
                            fArr5[2] = (float) (((double) fArr5[2]) + Math.toDegrees(f7 * f8));
                            float[] fArr6 = this.Q;
                            float f9 = fArr6[0];
                            if (f9 > 0.0f) {
                                if (f9 > this.U) {
                                    this.U = f9;
                                }
                            } else if (f9 < this.R) {
                                this.R = f9;
                            }
                            float f10 = fArr6[1];
                            if (f10 > 0.0f) {
                                if (f10 > this.V) {
                                    this.V = f10;
                                }
                            } else if (f10 < this.S) {
                                this.S = f10;
                            }
                            float f11 = fArr6[2];
                            if (f11 > 0.0f) {
                                if (f11 > this.W) {
                                    this.W = f11;
                                }
                            } else if (f11 < this.T) {
                                this.T = f11;
                            }
                            if (k() && ((Math.abs(this.R) > this.x && Math.abs(this.U) > this.x) || ((Math.abs(this.S) > this.x && Math.abs(this.V) > this.x) || (Math.abs(this.T) > this.x && Math.abs(this.W) > this.x)))) {
                                List listAsList = Arrays.asList(Float.valueOf(Math.abs(this.R)), Float.valueOf(Math.abs(this.U)), Float.valueOf(Math.abs(this.S)), Float.valueOf(Math.abs(this.V)), Float.valueOf(Math.abs(this.T)), Float.valueOf(Math.abs(this.W)));
                                Float f12 = (Float) Collections.max(listAsList);
                                int iIndexOf = listAsList.indexOf(f12);
                                if (this.C < f12.floatValue() && (this.v < this.d0 || this.C < this.x)) {
                                    this.C = f12.floatValue();
                                    if (iIndexOf == 0 || iIndexOf == 1) {
                                        this.e0 = "x";
                                    } else if (iIndexOf == 2 || iIndexOf == 3) {
                                        this.e0 = "y";
                                    } else if (iIndexOf == 4 || iIndexOf == 5) {
                                        this.e0 = com.google.android.exoplayer2.source.rtsp.j.o;
                                    }
                                }
                            }
                            double dMax = Math.max(Math.abs(this.Q[0]), Math.max(Math.abs(this.Q[1]), Math.abs(this.Q[2])));
                            if (this.C < dMax) {
                                this.C = dMax;
                            }
                            if (this.M > 0) {
                                a();
                                if (this.Y && this.X) {
                                    c();
                                }
                            }
                        }
                        this.O = sensorEvent.timestamp;
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void a() {
        if (this.y == 0) {
            if ((Math.abs(this.R) <= this.M || Math.abs(this.U) <= this.M) && ((Math.abs(this.S) <= this.M || Math.abs(this.V) <= this.M) && (Math.abs(this.T) <= this.M || Math.abs(this.W) <= this.M))) {
                return;
            }
            jh.a("ShakeUtil", "rotate  xMin: " + String.format("%.4f", Float.valueOf(this.R)) + ",xMax: " + String.format("%.4f", Float.valueOf(this.U)) + ",yMin: " + String.format("%.4f", Float.valueOf(this.S)) + ",yMax: " + String.format("%.4f", Float.valueOf(this.V)) + ",zMin: " + String.format("%.4f", Float.valueOf(this.T)) + ",zMax: " + String.format("%.4f", Float.valueOf(this.W)));
            this.X = true;
            return;
        }
        if (Math.abs(this.R) > this.M || Math.abs(this.U) > this.M || Math.abs(this.S) > this.M || Math.abs(this.V) > this.M || Math.abs(this.T) > this.M || Math.abs(this.W) > this.M) {
            jh.a("ShakeUtil", "rotate  xMin: " + String.format("%.4f", Float.valueOf(this.R)) + ",xMax: " + String.format("%.4f", Float.valueOf(this.U)) + ",yMin: " + String.format("%.4f", Float.valueOf(this.S)) + ",yMax: " + String.format("%.4f", Float.valueOf(this.V)) + ",zMin: " + String.format("%.4f", Float.valueOf(this.T)) + ",zMax: " + String.format("%.4f", Float.valueOf(this.W)));
            this.X = true;
        }
    }

    public void a(double d, double d2) {
        this.b = d;
        this.c = d2;
        this.i = 0;
        this.j = 0;
        this.k = -100.0f;
        this.l = -100.0f;
        this.m = -100.0f;
        this.n = 0;
        this.q = 200;
        this.R = 0.0f;
        this.S = 0.0f;
        this.T = 0.0f;
        this.U = 0.0f;
        this.V = 0.0f;
        this.W = 0.0f;
        this.O = 0.0f;
    }
}
