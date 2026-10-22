package com.beizi.fusion;

import android.content.Context;
import android.graphics.Color;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.camera.video.AudioStats;
import com.beizi.fusion.model.AdSpacesBean;
import com.beizi.fusion.widget.ShakeView;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class ri {
    private static SensorManager Q;
    private float C;
    private float D;
    private float E;
    private float F;
    private float G;
    private float H;
    private boolean I;
    private boolean J;
    private long K;
    private double L;
    private boolean M;
    private double N;
    private double O;
    private int P;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f27724a;
    private double b;
    private double c;
    private double d;
    private int e;
    private int f;
    private AdSpacesBean.BuyerBean.CoolShakeViewBean r;
    private String s;
    private boolean u;
    ShakeView w;
    private int x;
    private Sensor y;
    private float z;
    private int g = 0;
    private int h = 0;
    private float i = -100.0f;
    private float j = -100.0f;
    private float k = -100.0f;
    private int l = 0;
    private b m = null;
    private boolean n = false;
    private int o = 200;
    private View p = null;
    private long q = 0;
    private boolean t = false;
    private final SensorEventListener v = new a();
    private float A = 1.0E-9f;
    private float[] B = new float[3];

    public class a implements SensorEventListener {
        public a() {
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
                    ri.this.b(sensorEvent);
                } else if (type == 4) {
                    ri.this.a(sensorEvent);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public interface b {
        void a();
    }

    public ri(Context context) {
        this.f27724a = context;
        Q = (SensorManager) context.getApplicationContext().getSystemService("sensor");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(SensorEvent sensorEvent) {
        int i;
        if (System.currentTimeMillis() - this.q < 200) {
            return;
        }
        if (!yp.a(this.p)) {
            g();
            return;
        }
        if (this.t && this.r != null && !TextUtils.isEmpty(this.s) && qn.a().a(this.s) > 0) {
            b(this.r);
        }
        float[] fArr = sensorEvent.values;
        if (fArr == null || fArr.length < 3) {
            return;
        }
        float f = fArr[0];
        float f2 = fArr[1];
        float f3 = fArr[2];
        if (this.i == -100.0f) {
            this.i = f;
        }
        if (this.j == -100.0f) {
            this.j = f2;
        }
        if (this.k == -100.0f) {
            this.k = f3;
        }
        double dAbs = ((double) Math.abs(f - this.i)) / 9.8d;
        double dAbs2 = ((double) Math.abs(f2 - this.j)) / 9.8d;
        double dAbs3 = ((double) Math.abs(f3 - this.k)) / 9.8d;
        double d = this.d;
        if (dAbs > d) {
            this.h++;
            this.i = f;
        }
        if (dAbs2 > d) {
            this.h++;
            this.j = f2;
        }
        if (dAbs3 > d) {
            this.h++;
            this.k = f3;
        }
        if (b(f, f2, f3, this.b)) {
            double dA = a(f, f2, f3);
            if (this.N < dA) {
                this.N = dA;
            }
            this.l = 1;
        }
        if (this.l == 1 && a(f, f2, f3, this.c)) {
            this.l = 2;
            this.g++;
        }
        int i2 = this.e;
        if ((i2 > 0 && this.g >= i2) || ((i = this.f) > 0 && this.h >= i)) {
            this.J = true;
            jh.c("ShakeUtil", "mShakeCount = " + this.g + ",dstShakeCount = " + this.e + ",mRotateCount = " + this.h + ",dstRotateCount = " + this.f);
            if (this.J && this.I) {
                b();
            }
        }
        this.q = System.currentTimeMillis();
    }

    private void e() {
        try {
            SensorManager sensorManager = Q;
            if (sensorManager != null) {
                Sensor defaultSensor = sensorManager.getDefaultSensor(4);
                this.y = defaultSensor;
                if (defaultSensor == null) {
                    this.I = true;
                } else {
                    this.M = true;
                    Q.registerListener(this.v, defaultSensor, 1);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void a(AdSpacesBean.BuyerBean.ShakeViewBean shakeViewBean) {
        if (shakeViewBean == null) {
            return;
        }
        jh.a("BeiZis", "setShakeParams shakeCount:" + shakeViewBean.getShakeCount() + ";rotatCount:" + shakeViewBean.getRotatCount());
        try {
            this.t = true;
            c(shakeViewBean.getShakeCount());
            d(shakeViewBean.getShakeStartAmplitude());
            c(shakeViewBean.getShakeEndAmplitude());
            b(shakeViewBean.getRotatAmplitude());
            a(shakeViewBean.getRotatCount());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void c(double d) {
        this.c = d;
    }

    public void d(double d) {
        this.b = d;
    }

    public void f() {
        SensorManager sensorManager = Q;
        if (sensorManager != null) {
            sensorManager.registerListener(this.v, sensorManager.getDefaultSensor(1), 100000);
        }
    }

    public void g() {
        this.i = -100.0f;
        this.j = -100.0f;
        this.k = -100.0f;
        this.l = 0;
        this.o = 200;
        this.g = 0;
        this.h = 0;
        this.n = false;
        this.C = 0.0f;
        this.D = 0.0f;
        this.E = 0.0f;
        this.F = 0.0f;
        this.G = 0.0f;
        this.H = 0.0f;
        this.z = 0.0f;
        this.J = false;
        if (this.x <= 0 || !this.M) {
            return;
        }
        this.I = false;
    }

    public void h() {
        jh.a("BeiZis", "enter unRegisterShakeListenerAndSetDefault");
        SensorManager sensorManager = Q;
        if (sensorManager != null) {
            sensorManager.unregisterListener(this.v);
        }
        g();
        ShakeView shakeView = this.w;
        if (shakeView != null) {
            shakeView.stopShake();
        }
        this.m = null;
        this.f27724a = null;
        this.w = null;
    }

    public void c(int i) {
        this.e = i;
    }

    public double d() {
        return this.O;
    }

    public double c() {
        try {
            double d = this.N;
            if (d > AudioStats.AUDIO_AMPLITUDE_NONE) {
                this.N = d / 9.8d;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return this.N;
    }

    public void d(int i) {
        this.P = i;
    }

    public void a(AdSpacesBean.BuyerBean.CoolShakeViewBean coolShakeViewBean, String str) {
        a(coolShakeViewBean);
        a(str);
    }

    public void a(b bVar) {
        this.m = bVar;
    }

    public void a(int i) {
        this.f = i;
    }

    public void a(AdSpacesBean.BuyerBean.CoolShakeViewBean coolShakeViewBean) {
        this.r = coolShakeViewBean;
    }

    public void a(String str) {
        this.s = str;
    }

    private boolean a(float f, float f2, float f3, double d) {
        return Math.sqrt((Math.pow(((double) f) / 9.8d, 2.0d) + Math.pow(((double) f2) / 9.8d, 2.0d)) + Math.pow(((double) f3) / 9.8d, 2.0d)) < d;
    }

    public void a(View view) {
        this.p = view;
    }

    public View a(int i, int i2, AdSpacesBean.BuyerBean.PercentPositionBean percentPositionBean) {
        int i3;
        int i4;
        int i5;
        jh.a("BeiZis", "enter getShakeView");
        if (this.f27724a == null || percentPositionBean == null) {
            return null;
        }
        this.w = new ShakeView(this.f27724a);
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
        float fI = so.i(this.f27724a);
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
        int iA = so.a(this.f27724a, i6);
        int iA2 = so.a(this.f27724a, i5);
        int iA3 = so.a(this.f27724a, i3);
        int iA4 = so.a(this.f27724a, i4);
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
            iA4 = so.a(this.f27724a, i2) / 2;
        }
        if (iA3 == 0) {
            iA3 = so.a(this.f27724a, i) / 2;
        }
        marginLayoutParams.topMargin = iA4 - (iA2 / 2);
        marginLayoutParams.leftMargin = iA3 - (iA / 2);
        this.w.setLayoutParams(marginLayoutParams);
        jh.a("BeiZis", "topMargin = " + marginLayoutParams.topMargin + ",leftMargin = " + marginLayoutParams.leftMargin + ",widthInt = " + iA + ",heightInt = " + iA2);
        this.w.setDownloadApp(Boolean.valueOf(this.u));
        this.w.startShake();
        f();
        return this.w;
    }

    public void b(AdSpacesBean.BuyerBean.CoolShakeViewBean coolShakeViewBean) {
        if (coolShakeViewBean == null) {
            return;
        }
        jh.b("ShakeUtil", "setShakeCoolParams mShakeCount:" + coolShakeViewBean.getShakeCount() + ";mRotateCount:" + coolShakeViewBean.getRotatCount());
        try {
            this.t = false;
            c(coolShakeViewBean.getShakeCount());
            d(coolShakeViewBean.getShakeStartAmplitude());
            c(coolShakeViewBean.getShakeEndAmplitude());
            b(coolShakeViewBean.getRotatAmplitude());
            a(coolShakeViewBean.getRotatCount());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void b(double d) {
        this.d = d;
    }

    private boolean b(float f, float f2, float f3, double d) {
        return Math.sqrt((Math.pow(((double) f) / 9.8d, 2.0d) + Math.pow(((double) f2) / 9.8d, 2.0d)) + Math.pow(((double) f3) / 9.8d, 2.0d)) > d;
    }

    public synchronized void b() {
        StringBuilder sb = new StringBuilder();
        sb.append("enter callBackShakeHappened and mShakeStateListener != null ? ");
        sb.append(this.m != null);
        sb.append(",!isCallBack = ");
        sb.append(!this.n);
        jh.a("BeiZis", sb.toString());
        if (this.m == null || this.n) {
            return;
        }
        jh.a("BeiZis", "callback onShakeHappened()");
        this.n = true;
        this.m.a();
    }

    public void b(int i) {
        this.x = i;
        if (i > 0) {
            e();
        } else {
            this.I = true;
        }
    }

    public View a(int i, int i2, AdSpacesBean.BuyerBean.PercentPositionBean percentPositionBean, String str) {
        int i3;
        int i4;
        int i5;
        View view;
        jh.a("BeiZis", "enter getShakeView");
        if (this.f27724a == null || percentPositionBean == null) {
            return null;
        }
        String centerX = percentPositionBean.getCenterX();
        String centerY = percentPositionBean.getCenterY();
        String width = percentPositionBean.getWidth();
        String height = percentPositionBean.getHeight();
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
        float fI = so.i(this.f27724a);
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
        int iA = so.a(this.f27724a, i6);
        int iA2 = so.a(this.f27724a, i5);
        int iA3 = so.a(this.f27724a, i3);
        int iA4 = so.a(this.f27724a, i4);
        jh.a("BeiZis", "widthInt = " + iA + ",heightInt = " + iA2);
        if (iA == 0) {
            iA = 360;
        }
        if (iA2 == 0) {
            iA2 = 108;
        }
        ViewGroup.MarginLayoutParams marginLayoutParams = new ViewGroup.MarginLayoutParams(iA, iA2);
        jh.a("BeiZis", "centerYInt = " + iA4 + ",centerXInt = " + iA3 + ",adWidthDp = " + i + ",adHeightDp = " + i2);
        float f = (float) i2;
        int iA5 = (so.a(this.f27724a, f) - iA4) - iA2;
        if (iA5 < 0) {
            iA5 = so.a(this.f27724a, f) / 4;
        }
        marginLayoutParams.topMargin = iA5;
        marginLayoutParams.leftMargin = iA3;
        if (TextUtils.isEmpty(str)) {
            ImageView imageView = new ImageView(this.f27724a);
            if (!this.u) {
                imageView.setImageResource(R.drawable.beizi_icon_shake_native);
                view = imageView;
            } else {
                imageView.setImageResource(R.drawable.beizi_icon_shake_native_download);
                view = imageView;
            }
        } else {
            TextView textView = new TextView(this.f27724a);
            textView.setText(str);
            textView.setTextColor(Color.parseColor("#FFFFFFFF"));
            textView.setShadowLayer(5.0f, 4.0f, 4.0f, Color.parseColor("#8C000000"));
            view = textView;
        }
        view.setLayoutParams(marginLayoutParams);
        jh.a("BeiZis", "topMargin = " + marginLayoutParams.topMargin + ",leftMargin = " + marginLayoutParams.leftMargin + ",widthInt = " + iA + ",heightInt = " + iA2);
        f();
        return view;
    }

    public void a(Boolean bool) {
        this.u = bool.booleanValue();
    }

    public void a(boolean z) {
        this.n = !z;
    }

    public void a(double d) {
        if (this.x > 0) {
            return;
        }
        this.L = d;
        e();
        this.I = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(SensorEvent sensorEvent) {
        if (sensorEvent != null) {
            try {
                if (!this.n && System.currentTimeMillis() - this.K >= 50) {
                    Sensor sensor = sensorEvent.sensor;
                    float[] fArr = sensorEvent.values;
                    int type = sensor.getType();
                    if (fArr != null && type == 4) {
                        this.K = System.currentTimeMillis();
                        float f = this.z;
                        if (f != 0.0f) {
                            float f2 = fArr[0];
                            float f3 = fArr[1];
                            float f4 = fArr[2];
                            float f5 = (sensorEvent.timestamp - f) * this.A;
                            float[] fArr2 = this.B;
                            fArr2[0] = (float) (((double) fArr2[0]) + Math.toDegrees(f2 * f5));
                            float[] fArr3 = this.B;
                            fArr3[1] = (float) (((double) fArr3[1]) + Math.toDegrees(f3 * f5));
                            float[] fArr4 = this.B;
                            fArr4[2] = (float) (((double) fArr4[2]) + Math.toDegrees(f4 * f5));
                            float[] fArr5 = this.B;
                            float f6 = fArr5[0];
                            if (f6 > 0.0f) {
                                if (f6 > this.F) {
                                    this.F = f6;
                                }
                            } else if (f6 < this.C) {
                                this.C = f6;
                            }
                            float f7 = fArr5[1];
                            if (f7 > 0.0f) {
                                if (f7 > this.G) {
                                    this.G = f7;
                                }
                            } else if (f7 < this.D) {
                                this.D = f7;
                            }
                            float f8 = fArr5[2];
                            if (f8 > 0.0f) {
                                if (f8 > this.H) {
                                    this.H = f8;
                                }
                            } else if (f8 < this.E) {
                                this.E = f8;
                            }
                            double dMax = Math.max(Math.abs(f6), Math.max(Math.abs(this.B[1]), Math.abs(this.B[2])));
                            if (this.O < dMax) {
                                this.O = dMax;
                            }
                            if (this.x > 0) {
                                a();
                                if (this.J && this.I) {
                                    b();
                                }
                            }
                        }
                        this.z = sensorEvent.timestamp;
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private double a(float f, float f2, float f3) {
        return Math.sqrt(Math.pow(f, 2.0d) + Math.pow(f2, 2.0d) + Math.pow(f3, 2.0d));
    }

    private void a() {
        if (this.P == 0) {
            if ((Math.abs(this.C) <= this.x || Math.abs(this.F) <= this.x) && ((Math.abs(this.D) <= this.x || Math.abs(this.G) <= this.x) && (Math.abs(this.E) <= this.x || Math.abs(this.H) <= this.x))) {
                return;
            }
            jh.a("ShakeUtil", "rotate  xMin: " + String.format("%.4f", Float.valueOf(this.C)) + ",xMax: " + String.format("%.4f", Float.valueOf(this.F)) + ",yMin: " + String.format("%.4f", Float.valueOf(this.D)) + ",yMax: " + String.format("%.4f", Float.valueOf(this.G)) + ",zMin: " + String.format("%.4f", Float.valueOf(this.E)) + ",zMax: " + String.format("%.4f", Float.valueOf(this.H)));
            this.I = true;
            return;
        }
        if (Math.abs(this.C) > this.x || Math.abs(this.F) > this.x || Math.abs(this.D) > this.x || Math.abs(this.G) > this.x || Math.abs(this.E) > this.x || Math.abs(this.H) > this.x) {
            jh.a("ShakeUtil", "rotate  xMin: " + String.format("%.4f", Float.valueOf(this.C)) + ",xMax: " + String.format("%.4f", Float.valueOf(this.F)) + ",yMin: " + String.format("%.4f", Float.valueOf(this.D)) + ",yMax: " + String.format("%.4f", Float.valueOf(this.G)) + ",zMin: " + String.format("%.4f", Float.valueOf(this.E)) + ",zMax: " + String.format("%.4f", Float.valueOf(this.H)));
            this.I = true;
        }
    }

    public void a(double d, double d2) {
        this.b = d;
        this.c = d2;
        this.i = -100.0f;
        this.j = -100.0f;
        this.k = -100.0f;
        this.l = 0;
        this.o = 200;
        this.g = 0;
        this.h = 0;
        this.C = 0.0f;
        this.D = 0.0f;
        this.E = 0.0f;
        this.F = 0.0f;
        this.G = 0.0f;
        this.H = 0.0f;
        this.z = 0.0f;
        this.J = false;
        if (this.x <= 0 || !this.M) {
            return;
        }
        this.I = false;
    }
}
