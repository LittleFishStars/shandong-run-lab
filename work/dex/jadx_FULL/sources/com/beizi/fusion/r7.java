package com.beizi.fusion;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Handler;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.camera.video.AudioStats;
import com.beizi.fusion.model.AdSpacesBean;
import com.beizi.fusion.widget.EulerAngleView;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class r7 {
    private static SensorManager F;
    private float A;
    private float B;
    private float C;
    private float D;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f27716a;
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
    private EulerAngleView t;
    private c u;
    private String w;
    private Boolean x;
    private float y;
    private float z;
    private float h = 1.0E-9f;
    private float[] i = new float[3];
    private double k = AudioStats.AUDIO_AMPLITUDE_NONE;
    private double l = AudioStats.AUDIO_AMPLITUDE_NONE;
    private double m = AudioStats.AUDIO_AMPLITUDE_NONE;
    private boolean q = false;
    private int r = 0;
    private boolean v = false;
    private SensorEventListener E = new b();

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ double f27717a;
        final /* synthetic */ double b;
        final /* synthetic */ double c;

        public a(double d, double d2, double d3) {
            this.f27717a = d;
            this.b = d2;
            this.c = d3;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                r7 r7Var = r7.this;
                r7Var.q = true;
                r7Var.s = 0.0f;
                float[] fArr = r7Var.i;
                fArr[0] = 0.0f;
                fArr[1] = 0.0f;
                fArr[2] = 0.0f;
                r7Var.k = this.f27717a;
                r7Var.l = this.b;
                r7Var.m = this.c;
            } catch (Exception unused) {
            }
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
            try {
                r7.this.a(sensorEvent);
            } catch (Exception unused) {
            }
        }
    }

    public interface c {
        void a();
    }

    public r7(Context context, String str, AdSpacesBean.BuyerBean.EulerAngleViewBean eulerAngleViewBean, AdSpacesBean.BuyerBean.EulerAngleViewBean eulerAngleViewBean2) {
        this.w = null;
        F = (SensorManager) context.getApplicationContext().getSystemService("sensor");
        this.f27716a = context;
        this.b = eulerAngleViewBean;
        this.c = eulerAngleViewBean2;
        this.w = "splash_cool_" + str;
        c();
        b();
    }

    private boolean a(long j) {
        try {
            long jLongValue = ((Long) co.a(this.f27716a, this.w, (Object) 0L)).longValue();
            return jLongValue != 0 && System.currentTimeMillis() - jLongValue < j;
        } catch (Exception unused) {
            return false;
        }
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
                        if ("x".equalsIgnoreCase(eulerAngleRuleBean.getAxis())) {
                            if (passivationTime <= 0 || eulerAngleRuleBean.getPangle() <= AudioStats.AUDIO_AMPLITUDE_NONE) {
                                this.k = eulerAngleRuleBean.getAngle();
                            } else {
                                this.k = eulerAngleRuleBean.getPangle();
                            }
                            angle = eulerAngleRuleBean.getAngle();
                            this.n = eulerAngleRuleBean.getDirection();
                        } else if ("y".equalsIgnoreCase(eulerAngleRuleBean.getAxis())) {
                            if (passivationTime <= 0 || eulerAngleRuleBean.getPangle() <= AudioStats.AUDIO_AMPLITUDE_NONE) {
                                this.l = eulerAngleRuleBean.getAngle();
                            } else {
                                this.l = eulerAngleRuleBean.getPangle();
                            }
                            angle2 = eulerAngleRuleBean.getAngle();
                            this.o = eulerAngleRuleBean.getDirection();
                        } else if (com.google.android.exoplayer2.source.rtsp.j.o.equalsIgnoreCase(eulerAngleRuleBean.getAxis())) {
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
                    new Handler().postDelayed(new a(angle, angle2, angle3), ol.b(passivationTime));
                }
            }
        } catch (Exception unused) {
        }
    }

    private void c() {
        try {
            AdSpacesBean.BuyerBean.EulerAngleViewBean eulerAngleViewBean = this.b;
            if (eulerAngleViewBean != null) {
                this.f = eulerAngleViewBean.getCoolRule();
            }
            AdSpacesBean.BuyerBean.EulerAngleViewBean eulerAngleViewBean2 = this.c;
            if (eulerAngleViewBean2 != null) {
                this.e = eulerAngleViewBean2.getNomalRule();
                this.g = this.c.getRender();
            } else {
                AdSpacesBean.BuyerBean.EulerAngleViewBean eulerAngleViewBean3 = this.b;
                if (eulerAngleViewBean3 != null) {
                    this.e = eulerAngleViewBean3.getNomalRule();
                    this.g = this.b.getRender();
                }
            }
            AdSpacesBean.BuyerBean.EulerAngleViewRuleBean eulerAngleViewRuleBean = this.f;
            if (eulerAngleViewRuleBean == null) {
                this.q = true;
                this.d = this.e;
            } else if (a(eulerAngleViewRuleBean.getCoolTime())) {
                this.q = false;
                this.d = this.f;
            } else if (b(this.f.getUserProtectTime())) {
                this.q = false;
                this.d = this.f;
            } else {
                this.q = true;
                this.d = this.e;
            }
        } catch (Exception unused) {
        }
    }

    private boolean d() {
        try {
            if (this.k > AudioStats.AUDIO_AMPLITUDE_NONE) {
                if ("2".equals(this.n)) {
                    float f = this.i[0];
                    if (f > 0.0f && Math.abs(f) >= this.k) {
                        return true;
                    }
                } else if ("1".equals(this.n)) {
                    float f2 = this.i[0];
                    if (f2 < 0.0f && Math.abs(f2) >= this.k) {
                        return true;
                    }
                } else if ("0".equals(this.n)) {
                    if (Math.abs(this.i[0]) >= this.k) {
                        return true;
                    }
                } else if ("3".equals(this.n) && Math.abs(this.y) >= this.k && Math.abs(this.B) > this.k) {
                    return true;
                }
            }
            if (this.l > AudioStats.AUDIO_AMPLITUDE_NONE) {
                if ("2".equals(this.o)) {
                    float f3 = this.i[1];
                    if (f3 < 0.0f && Math.abs(f3) >= this.l) {
                        return true;
                    }
                } else if ("1".equals(this.o)) {
                    float f4 = this.i[1];
                    if (f4 > 0.0f && Math.abs(f4) >= this.l) {
                        return true;
                    }
                } else if ("0".equals(this.o)) {
                    if (Math.abs(this.i[1]) >= this.l) {
                        return true;
                    }
                } else if ("3".equals(this.o) && Math.abs(this.z) >= this.l && Math.abs(this.C) > this.l) {
                    return true;
                }
            }
            if (this.m > AudioStats.AUDIO_AMPLITUDE_NONE) {
                if ("2".equals(this.p)) {
                    float f5 = this.i[2];
                    if (f5 > 0.0f && Math.abs(f5) >= this.m) {
                        return true;
                    }
                } else if ("1".equals(this.p)) {
                    float f6 = this.i[2];
                    if (f6 < 0.0f && Math.abs(f6) >= this.m) {
                        return true;
                    }
                } else if ("0".equals(this.p)) {
                    if (Math.abs(this.i[2]) >= this.m) {
                        return true;
                    }
                } else if ("3".equals(this.p) && Math.abs(this.A) >= this.m && Math.abs(this.D) > this.m) {
                    return true;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public void e() {
        try {
            SensorManager sensorManager = F;
            if (sensorManager != null) {
                Sensor defaultSensor = sensorManager.getDefaultSensor(4);
                this.j = defaultSensor;
                if (defaultSensor != null) {
                    F.registerListener(this.E, defaultSensor, 1);
                }
            }
        } catch (Exception unused) {
        }
    }

    public void f() {
        try {
            jh.a("BeiZis", "enter unRegisterListener");
            SensorManager sensorManager = F;
            if (sensorManager != null) {
                sensorManager.unregisterListener(this.E);
            }
            EulerAngleView eulerAngleView = this.t;
            if (eulerAngleView != null) {
                eulerAngleView.onDestroy();
            }
            this.t = null;
            this.f27716a = null;
            this.u = null;
        } catch (Exception unused) {
        }
    }

    public void a(ViewGroup viewGroup, int i, int i2) {
        AdSpacesBean.BuyerBean.EulerAngleRenderBean eulerAngleRenderBean;
        int iA;
        int iA2;
        int i3;
        int i4;
        try {
            if (this.f27716a != null && (eulerAngleRenderBean = this.g) != null && viewGroup != null) {
                String centerX = eulerAngleRenderBean.getCenterX();
                String centerY = this.g.getCenterY();
                String width = this.g.getWidth();
                String height = this.g.getHeight();
                if (TextUtils.isEmpty(centerX) || "0".equals(centerX)) {
                    centerX = "85%";
                }
                if (TextUtils.isEmpty(centerY) || "0".equals(centerY)) {
                    centerY = "50%";
                }
                if (TextUtils.isEmpty(width) || "0".equals(width)) {
                    width = "120";
                }
                if (TextUtils.isEmpty(height) || "0".equals(height)) {
                    height = "120";
                }
                float fI = so.i(this.f27716a);
                int i5 = 100;
                if (centerX.endsWith("%")) {
                    iA = (Integer.parseInt(centerX.substring(0, centerX.indexOf("%"))) * i) / 100;
                } else {
                    iA = Integer.parseInt(centerX);
                }
                if (centerY.endsWith("%")) {
                    iA2 = (Integer.parseInt(centerY.substring(0, centerY.indexOf("%"))) * i2) / 100;
                } else {
                    iA2 = Integer.parseInt(centerY);
                }
                if (width.endsWith("%")) {
                    i3 = (((int) fI) * Integer.parseInt(width.substring(0, width.indexOf("%")))) / 100;
                } else {
                    i3 = Integer.parseInt(width);
                }
                if (height.endsWith("%")) {
                    i4 = (Integer.parseInt(height.substring(0, height.indexOf("%"))) * i3) / 100;
                } else {
                    i4 = Integer.parseInt(height);
                }
                if (i3 == 0) {
                    i3 = 100;
                }
                if (i4 != 0) {
                    i5 = i4;
                }
                if (iA2 == 0) {
                    iA2 = so.a(this.f27716a, i2) / 2;
                }
                if (iA == 0) {
                    iA = so.a(this.f27716a, i) / 2;
                }
                int iA3 = so.a(this.f27716a, i3);
                int iA4 = so.a(this.f27716a, i5);
                int iA5 = so.a(this.f27716a, iA);
                int iA6 = so.a(this.f27716a, iA2);
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
                EulerAngleView eulerAngleView = new EulerAngleView(this.f27716a);
                this.t = eulerAngleView;
                eulerAngleView.setEulerAngleViewRuleBean(this.d);
                this.t.setEulerAngleRenderBean(this.g);
                this.t.setAnimationViewWidthAndHeight(iA3, iA4);
                this.t.setDownloadApp(this.x);
                this.t.buildEulerAngleView();
                this.t.measure(0, 0);
                int measuredWidth = this.t.getMeasuredWidth();
                int measuredHeight = this.t.getMeasuredHeight();
                jh.a("BeiZis", "centerYInt = " + iA6 + ",centerXInt = " + iA5 + ",adWidthDp = " + i + ",adHeightDp = " + i2 + ",widthInt = " + iA3 + ",heightInt = " + iA4 + ",viewWidth = " + measuredWidth + ",viewHeight = " + measuredHeight);
                layoutParams.topMargin = iA6 - (measuredHeight / 2);
                layoutParams.leftMargin = iA5 - (measuredWidth / 2);
                viewGroup.addView(this.t, layoutParams);
                this.t.startContinuousRotations();
            }
        } catch (NumberFormatException unused) {
        }
    }

    private boolean b(long j) {
        try {
            return System.currentTimeMillis() - so.a(this.f27716a).longValue() < j;
        } catch (Exception unused) {
            return false;
        }
    }

    public void a(c cVar) {
        this.u = cVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(SensorEvent sensorEvent) {
        if (sensorEvent != null) {
            try {
                if (this.v) {
                    return;
                }
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
                            if (f6 > this.B) {
                                this.B = f6;
                            }
                        } else if (f6 < this.y) {
                            this.y = f6;
                        }
                        float f7 = fArr5[1];
                        if (f7 > 0.0f) {
                            if (f7 > this.C) {
                                this.C = f7;
                            }
                        } else if (f7 < this.z) {
                            this.z = f7;
                        }
                        float f8 = fArr5[2];
                        if (f8 > 0.0f) {
                            if (f8 > this.D) {
                                this.D = f8;
                            }
                        } else if (f8 < this.A) {
                            this.A = f8;
                        }
                        EulerAngleView eulerAngleView = this.t;
                        if (eulerAngleView != null) {
                            eulerAngleView.setAngle(this.k, this.l, this.m);
                            EulerAngleView eulerAngleView2 = this.t;
                            float[] fArr6 = this.i;
                            eulerAngleView2.setCurrentProgress(fArr6[0], fArr6[1], fArr6[2]);
                        }
                        jh.a("ShakeUtil", "rotate  x: " + String.format("%.4f", Float.valueOf(this.i[0])) + ",y: " + String.format("%.4f", Float.valueOf(this.i[1])) + ",z: " + String.format("%.4f", Float.valueOf(this.i[2])) + ",x : " + this.k + ",y : " + this.l + ",z : " + this.m);
                        if (d()) {
                            a();
                        }
                    }
                    this.s = sensorEvent.timestamp;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void a() {
        try {
            if (this.u == null || this.v || !yp.b(this.t)) {
                return;
            }
            this.v = true;
            if (this.q && this.f != null) {
                co.b(this.f27716a, this.w, Long.valueOf(System.currentTimeMillis()));
            }
            this.u.a();
            f();
            jh.a("ShakeUtil", "onEulerAngleHappened");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void a(Boolean bool) {
        this.x = bool;
    }
}
