package com.beizi.fusion;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorManager;
import android.view.KeyEvent;
import android.view.View;
import androidx.camera.video.AudioStats;
import com.beizi.fusion.asnp.adn.ad.ad.nativead.render.view.asnp.interaction.ScopeEulerAngleView;
import com.beizi.fusion.asnp.adn.ad.model.impl.resp.ad3.ad.nativ.render.interaction.InteractionModel;
import com.beizi.fusion.asnp.adn.ad.model.impl.resp.ad3.ad.nativ.render.interaction.form.EulerAngleModel;
import com.beizi.fusion.asnp.adn.ad.model.impl.resp.ad3.ad.nativ.render.interaction.form.axis.AxisModel;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public final class r8 extends mn {
    private final Map l;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final double f27719a;
        private final String b;
        private double c;

        private a(String str, String str2) {
            this.f27719a = no.g(str);
            this.b = str2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(String str) {
            double dG = no.g(str);
            if (dG <= AudioStats.AUDIO_AMPLITUDE_NONE) {
                dG = this.f27719a;
            }
            this.c = dG;
        }
    }

    public r8(Context context) {
        super(context);
        this.l = new HashMap();
    }

    private b a(EulerAngleModel eulerAngleModel, String str) {
        if (eulerAngleModel == null) {
            return null;
        }
        AxisModel xAxis = eulerAngleModel.getXAxis();
        AxisModel yAxis = eulerAngleModel.getYAxis();
        AxisModel zAxis = eulerAngleModel.getZAxis();
        return "Cooling".equalsIgnoreCase(str) ? new b(a(xAxis, str), b(xAxis, str), a(yAxis, str), b(yAxis, str), a(zAxis, str), b(zAxis, str), str) : new b(a(xAxis, "Normal"), b(xAxis, "Normal"), a(yAxis, "Normal"), b(yAxis, "Normal"), a(zAxis, "Normal"), b(zAxis, "Normal"), str);
    }

    private String b(AxisModel axisModel, String str) {
        if (axisModel == null || axisModel.getDirection() == null) {
            return "";
        }
        return "Cooling".equalsIgnoreCase(str) ? axisModel.getDirection().getCool() : axisModel.getDirection().getNormal();
    }

    private void l() {
        b bVarA;
        InteractionModel interactionModel = this.f;
        if (interactionModel == null || (bVarA = a(interactionModel.getEulerAngle(), "Cooling")) == null) {
            return;
        }
        this.l.put("Cooling", bVarA);
    }

    private void m() {
        b bVarA;
        InteractionModel interactionModel = this.f;
        if (interactionModel == null || (bVarA = a(interactionModel.getEulerAngle(), "Normal")) == null) {
            return;
        }
        this.l.put("Normal", bVarA);
    }

    private void n() {
        b bVarA;
        InteractionModel interactionModel = this.f;
        if (interactionModel == null || (bVarA = a(interactionModel.getEulerAngle(), "Passive")) == null) {
            return;
        }
        EulerAngleModel eulerAngle = this.f.getEulerAngle();
        AxisModel xAxis = eulerAngle.getXAxis();
        AxisModel yAxis = eulerAngle.getYAxis();
        AxisModel zAxis = eulerAngle.getZAxis();
        bVarA.a("X", a(xAxis, "Passive"));
        bVarA.a("Y", a(yAxis, "Passive"));
        bVarA.a("Z", a(zAxis, "Passive"));
        bVarA.a(this.f.getPassivationTime(), this.f.getPassivationType());
        this.l.put("Passive", bVarA);
    }

    @Override // com.beizi.fusion.q3
    public void e() {
        this.l.clear();
        m();
        n();
        l();
    }

    @Override // com.beizi.fusion.mn
    public dd.a f() {
        return dd.a.EULER_INTERACTIVE_TRIGGER;
    }

    @Override // com.beizi.fusion.mn
    public Sensor[] g() {
        return new Sensor[0];
    }

    @Override // com.beizi.fusion.mn
    public Sensor h() {
        SensorManager sensorManager = this.i;
        if (sensorManager != null) {
            return sensorManager.getDefaultSensor(4);
        }
        return null;
    }

    @Override // com.beizi.fusion.mn
    public mn.b i() {
        if (this.f == null) {
            return null;
        }
        ko koVar = (ko) tp.a().b(this.b);
        if (koVar.a(this.f.getProtectTime()) || koVar.a(this.g, this.f.getCoolTime())) {
            return (mn.b) this.l.get("Cooling");
        }
        return this.f.getPassivationTime() > 0 ? (mn.b) this.l.get("Passive") : (mn.b) this.l.get("Normal");
    }

    @Override // com.beizi.fusion.mn
    public void j() {
        super.j();
    }

    public long o() {
        return 50L;
    }

    private String a(AxisModel axisModel, String str) {
        if (axisModel == null || axisModel.getAngle() == null) {
            return "";
        }
        if ("Cooling".equalsIgnoreCase(str)) {
            return axisModel.getAngle().getCool();
        }
        if ("Normal".equalsIgnoreCase(str)) {
            return axisModel.getAngle().getNormal();
        }
        return axisModel.getAngle().getPassivation();
    }

    public class b implements mn.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final float f27720a;
        private final a b;
        private final a c;
        private final a d;
        private final String e;
        private boolean f;
        private long g;
        private int h;
        private boolean i;
        private boolean j;
        private long k;
        private double l;
        private double m;
        private double n;
        private float o;
        private float p;
        private float q;
        private float[] r;
        private float[] s;
        private float[] t;
        private long u;
        private long v;

        public class a extends en {
            public a(int i, int i2, long j) {
                super(i, i2, j);
            }

            @Override // com.beizi.fusion.en
            public void a(ValueAnimator valueAnimator) {
                b bVar = b.this;
                if (bVar.h == 1) {
                    bVar.a(((double) ((Integer) valueAnimator.getAnimatedValue()).intValue()) / 10.0d);
                }
            }

            @Override // com.beizi.fusion.en
            public void b(Animator animator) {
                b.this.b();
            }

            @Override // com.beizi.fusion.en
            public void d(Animator animator) {
                b.this.a(1.0d);
                b bVar = b.this;
                bVar.a(bVar.e);
            }
        }

        private b(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
            this.f27720a = 1.0E-9f;
            this.f = false;
            this.i = false;
            this.j = false;
            this.k = 0L;
            this.o = 0.0f;
            this.p = 0.0f;
            this.q = 0.0f;
            this.r = new float[2];
            this.s = new float[2];
            this.t = new float[2];
            this.u = 0L;
            this.v = 0L;
            a aVar = new a(str, str2);
            this.b = aVar;
            a aVar2 = new a(str3, str4);
            this.c = aVar2;
            a aVar3 = new a(str5, str6);
            this.d = aVar3;
            this.e = str7;
            this.l = aVar.f27719a;
            this.m = aVar2.f27719a;
            this.n = aVar3.f27719a;
        }

        private void b(SensorEvent sensorEvent) {
            if (r8.this.a(sensorEvent, 4).booleanValue()) {
                long j = this.k;
                if (j != 0) {
                    float[] fArr = sensorEvent.values;
                    float f = fArr[0];
                    float f2 = fArr[1];
                    float f3 = fArr[2];
                    float f4 = (sensorEvent.timestamp - j) * 1.0E-9f;
                    this.o += (float) Math.toDegrees(f * f4);
                    this.p += (float) Math.toDegrees(f2 * f4);
                    this.q += (float) Math.toDegrees(f3 * f4);
                    a(this.o, this.r);
                    a(this.p, this.s);
                    a(this.q, this.t);
                    a(this.o, this.p, this.q);
                    if (a(this.l, this.o, this.b.b, this.r) || a(this.m, this.p, this.c.b, this.s) || a(this.n, this.q, this.d.b, this.t)) {
                        this.j = false;
                        r8.this.k.a(4, this.r[1], this.s[1], this.t[1], 0.0f, System.currentTimeMillis() - this.v);
                        r8.this.j();
                    }
                }
                this.k = sensorEvent.timestamp;
            }
        }

        private void c() {
            if (this.f) {
                return;
            }
            this.f = true;
            long j = this.g;
            if (j > 0) {
                new a(10, 1, j).c();
            } else {
                b();
            }
        }

        @Override // com.beizi.fusion.mn.b
        public void a(SensorEvent sensorEvent) {
            if (this.v == 0) {
                this.v = System.currentTimeMillis();
            }
            if (this.i) {
                c();
            }
            if (!this.j) {
                this.j = true;
                a(this.b.b, this.c.b, this.d.b);
            }
            long jCurrentTimeMillis = System.currentTimeMillis();
            if (jCurrentTimeMillis - this.u > r8.this.o()) {
                this.u = jCurrentTimeMillis;
                b(sensorEvent);
            }
        }

        @Override // com.beizi.fusion.mn.b
        public void a() {
            this.k = 0L;
            this.v = 0L;
            this.r = new float[2];
            this.s = new float[2];
            this.t = new float[2];
            this.o = 0.0f;
            this.p = 0.0f;
            this.q = 0.0f;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void b() {
            this.l = this.b.f27719a;
            this.m = this.c.f27719a;
            this.n = this.d.f27719a;
            a("Normal");
        }

        private void a(float f, float[] fArr) {
            if (f > 0.0f) {
                if (f > fArr[1]) {
                    fArr[1] = f;
                }
            } else if (f < fArr[0]) {
                fArr[0] = f;
            }
        }

        private boolean a(double d, float f, String str, float[] fArr) {
            if (d > AudioStats.AUDIO_AMPLITUDE_NONE) {
                if ("2".equals(str)) {
                    return f > 0.0f && ((double) Math.abs(f)) >= d;
                }
                if ("1".equals(str)) {
                    return f < 0.0f && ((double) Math.abs(f)) >= d;
                }
                if ("0".equals(str)) {
                    return ((double) Math.abs(f)) >= d;
                }
                if ("3".equals(str) && Math.abs(fArr[0]) >= d && Math.abs(fArr[1]) >= d) {
                    return true;
                }
            }
            return false;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(long j, int i) {
            this.g = j;
            this.h = i;
            this.i = true;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(String str, String str2) {
            if ("X".equals(str)) {
                this.b.a(str2);
            }
            if ("Y".equals(str)) {
                this.c.a(str2);
            }
            if ("Z".equals(str)) {
                this.d.a(str2);
            }
        }

        private void a(float f, float f2, float f3) {
            View view = r8.this.d;
            if (view == null || !(view instanceof ScopeEulerAngleView)) {
                return;
            }
            double[] dArr = {a(this.l, f, this.b.b, false), a(this.m, f2, this.c.b, true), a(this.n, f3, this.d.b, false)};
            Arrays.sort(dArr);
            ((ScopeEulerAngleView) r8.this.d).setCurrentProgress(dArr[2]);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(String str) {
            KeyEvent.Callback callback = r8.this.d;
            if (callback == null || !(callback instanceof je)) {
                return;
            }
            ((je) callback).updateByInteractiveStatus(str);
        }

        private void a(String str, String str2, String str3) {
            View view = r8.this.d;
            if (view == null || !(view instanceof ScopeEulerAngleView)) {
                return;
            }
            ((ScopeEulerAngleView) view).startInteractionAnimation(str, str2, str3);
        }

        private double a(double d, float f, String str, boolean z) {
            return (d <= AudioStats.AUDIO_AMPLITUDE_NONE || ((!"2".equals(str) || (!z ? f > 0.0f : f < 0.0f)) && ((!"1".equals(str) || (!z ? f < 0.0f : f > 0.0f)) && !"0".equals(str)))) ? AudioStats.AUDIO_AMPLITUDE_NONE : ((double) (Math.abs(f) * 100.0f)) / d;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(double d) {
            a aVar = this.b;
            double d2 = aVar.f27719a;
            this.l = d2 + ((aVar.c - d2) * d);
            a aVar2 = this.c;
            double d3 = aVar2.f27719a;
            this.m = d3 + ((aVar2.c - d3) * d);
            a aVar3 = this.d;
            double d4 = aVar3.f27719a;
            this.n = d4 + ((aVar3.c - d4) * d);
        }
    }
}
