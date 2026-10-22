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
import com.beizi.fusion.asnp.adn.ad.ad.nativead.render.view.asnp.interaction.ScopeShakeView;
import com.beizi.fusion.asnp.adn.ad.model.impl.resp.ad3.ad.nativ.render.interaction.InteractionModel;
import com.beizi.fusion.asnp.adn.ad.model.impl.resp.ad3.ad.nativ.render.interaction.form.ShakeModel;
import com.beizi.fusion.asnp.adn.ad.model.impl.resp.ad3.ad.nativ.render.interaction.form.par.StatusParamModel;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public final class yh extends mn {
    private final Map l;
    private boolean m;
    private boolean n;
    private float[] o;
    private float[] p;
    private float[] q;
    private float[] r;
    private float[] s;
    private float[] t;
    private float[] u;
    private long v;

    public class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final float f28063a;
        private final int b;
        private float c;
        private float d;
        private float e;
        private float f;
        private long g;
        private int h;
        private int i;
        private boolean j;
        private boolean k;
        private int l;
        private long m;

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
                b.this.a();
            }

            @Override // com.beizi.fusion.en
            public void d(Animator animator) {
                b.this.a(1.0d);
            }
        }

        private b(int i) {
            this.f28063a = 1.0E-9f;
            this.d = 0.0f;
            this.e = 0.0f;
            this.f = 0.0f;
            this.m = 0L;
            this.b = i;
            this.l = i;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(double d) {
            int i = this.b;
            this.l = (int) (((double) i) + (((double) (this.i - i)) * d));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void b(SensorEvent sensorEvent) {
            if (this.j) {
                c();
            }
            long jCurrentTimeMillis = System.currentTimeMillis();
            if (jCurrentTimeMillis - this.m > yh.this.o()) {
                this.m = jCurrentTimeMillis;
                a(sensorEvent);
            }
        }

        private void c() {
            if (this.k) {
                return;
            }
            this.k = true;
            long j = this.g;
            if (j > 0) {
                new a(10, 1, j).c();
            } else {
                a();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a() {
            this.l = this.b;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(int i) {
            this.j = true;
            this.i = i;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(long j, int i) {
            this.g = j;
            this.h = i;
        }

        private void a(SensorEvent sensorEvent) {
            if (yh.this.a(sensorEvent, 4).booleanValue()) {
                float f = this.c;
                if (f != 0.0f) {
                    float[] fArr = sensorEvent.values;
                    float f2 = fArr[0];
                    float f3 = fArr[1];
                    float f4 = fArr[2];
                    float f5 = (sensorEvent.timestamp - f) * 1.0E-9f;
                    this.d += (float) Math.toDegrees(f2 * f5);
                    this.e += (float) Math.toDegrees(f3 * f5);
                    this.f += (float) Math.toDegrees(f4 * f5);
                    a(this.d, yh.this.o);
                    a(this.e, yh.this.p);
                    a(this.f, yh.this.q);
                    if (a(yh.this.o) || a(yh.this.p) || a(yh.this.q)) {
                        yh yhVar = yh.this;
                        yhVar.n = true;
                        yhVar.j();
                    }
                }
                this.c = sensorEvent.timestamp;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void b() {
            this.c = 0.0f;
            yh yhVar = yh.this;
            yhVar.o = new float[2];
            yhVar.p = new float[2];
            yhVar.q = new float[2];
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

        private boolean a(float[] fArr) {
            return Math.abs(fArr[0]) >= ((float) this.l) && Math.abs(fArr[1]) >= ((float) this.l);
        }
    }

    public enum d {
        SHAKE_STATUS_START,
        SHAKE_STATUS_STANDBY
    }

    public yh(Context context) {
        super(context);
        this.l = new HashMap();
        this.m = false;
        this.n = false;
        this.o = new float[2];
        this.p = new float[2];
        this.q = new float[2];
        this.r = new float[2];
        this.s = new float[2];
        this.t = new float[2];
        this.u = new float[2];
        this.v = 0L;
    }

    private c a(ShakeModel shakeModel, String str) {
        if (shakeModel == null) {
            return null;
        }
        StatusParamModel startAmplitude = shakeModel.getStartAmplitude();
        StatusParamModel endAmplitude = shakeModel.getEndAmplitude();
        StatusParamModel count = shakeModel.getCount();
        StatusParamModel axial = shakeModel.getAxial();
        StatusParamModel regulatoryAngle = shakeModel.getRegulatoryAngle();
        return new c(startAmplitude != null ? no.g(a(startAmplitude, str)) : -1.0d, endAmplitude != null ? no.g(a(endAmplitude, str)) : -1.0d, count != null ? no.i(a(count, str)) : 0, axial != null ? a(axial, str) : "", str, regulatoryAngle != null ? no.i(a(regulatoryAngle, str)) : 0);
    }

    private void l() {
        c cVarA;
        InteractionModel interactionModel = this.f;
        if (interactionModel == null || (cVarA = a(interactionModel.getShake(), "Cooling")) == null) {
            return;
        }
        this.l.put("Cooling", cVarA);
    }

    private void m() {
        c cVarA;
        InteractionModel interactionModel = this.f;
        if (interactionModel == null || (cVarA = a(interactionModel.getShake(), "Normal")) == null) {
            return;
        }
        this.l.put("Normal", cVarA);
    }

    private void n() {
        ShakeModel shake;
        c cVarA;
        InteractionModel interactionModel = this.f;
        if (interactionModel == null || (cVarA = a((shake = interactionModel.getShake()), "Passive")) == null) {
            return;
        }
        StatusParamModel startAmplitude = shake.getStartAmplitude();
        StatusParamModel endAmplitude = shake.getEndAmplitude();
        StatusParamModel count = shake.getCount();
        StatusParamModel regulatoryAngle = shake.getRegulatoryAngle();
        double dA = startAmplitude != null ? no.a(startAmplitude.getPassivation(), -1.0d) : -1.0d;
        double dA2 = endAmplitude != null ? no.a(endAmplitude.getPassivation(), -1.0d) : -1.0d;
        int i = count != null ? no.i(count.getPassivation()) : 0;
        int i2 = regulatoryAngle != null ? no.i(regulatoryAngle.getPassivation()) : 0;
        cVarA.f28064a.a(this.f.getPassivationTime(), this.f.getPassivationType());
        cVarA.f28064a.a(dA, dA2, i);
        cVarA.b.a(this.f.getPassivationTime(), this.f.getPassivationType());
        cVarA.b.a(i2);
        this.l.put("Passive", cVarA);
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
        return dd.a.SHAKE_INTERACTIVE_TRIGGER;
    }

    @Override // com.beizi.fusion.mn
    public Sensor[] g() {
        SensorManager sensorManager = this.i;
        if (sensorManager == null) {
            return null;
        }
        Sensor defaultSensor = sensorManager.getDefaultSensor(4);
        if (defaultSensor != null) {
            return new Sensor[]{defaultSensor};
        }
        this.n = true;
        return null;
    }

    @Override // com.beizi.fusion.mn
    public Sensor h() {
        SensorManager sensorManager = this.i;
        if (sensorManager != null) {
            return sensorManager.getDefaultSensor(1);
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
        if (this.m && this.n) {
            long jCurrentTimeMillis = System.currentTimeMillis() - this.v;
            this.k.a(1, a(this.r), a(this.s), a(this.t), this.u[1], jCurrentTimeMillis);
            we weVar = this.k;
            float f = this.o[1];
            float f2 = this.p[1];
            weVar.a(4, f, f2, f2, 0.0f, jCurrentTimeMillis);
            super.j();
        }
    }

    public long o() {
        return 50L;
    }

    public class c implements mn.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final a f28064a;
        private final b b;

        private c(double d, double d2, int i, String str, String str2, int i2) {
            this.f28064a = new a(d, d2, i, str, str2);
            this.b = new b(i2);
        }

        @Override // com.beizi.fusion.mn.b
        public void a(SensorEvent sensorEvent) {
            yh yhVar = yh.this;
            if (yhVar.v == 0) {
                yhVar.v = System.currentTimeMillis();
            }
            if (yh.this.a(sensorEvent, 4).booleanValue()) {
                this.b.b(sensorEvent);
            }
            if (yh.this.a(sensorEvent, 1).booleanValue()) {
                this.f28064a.b(sensorEvent);
            }
        }

        @Override // com.beizi.fusion.mn.b
        public void a() {
            yh yhVar = yh.this;
            yhVar.m = false;
            yhVar.n = false;
            yhVar.v = 0L;
            this.f28064a.b();
            this.b.b();
        }
    }

    public class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f28062a;
        private final String b;
        private final double c;
        private final double d;
        private final String e;
        private double f;
        private double g;
        private int h;
        private double i;
        private double j;
        private int k;
        private boolean l;
        private boolean m;
        private long n;
        private int o;
        private int p;
        private double q;
        private d r;
        private long s;

        /* JADX INFO: renamed from: com.beizi.fusion.yh$a$a, reason: collision with other inner class name */
        public class C0336a extends en {
            public C0336a(int i, int i2, long j) {
                super(i, i2, j);
            }

            @Override // com.beizi.fusion.en
            public void a(ValueAnimator valueAnimator) {
                a aVar = a.this;
                if (aVar.o == 1) {
                    aVar.a(((double) ((Integer) valueAnimator.getAnimatedValue()).intValue()) / 10.0d);
                }
            }

            @Override // com.beizi.fusion.en
            public void b(Animator animator) {
                a aVar = a.this;
                aVar.p = 0;
                aVar.a();
            }

            @Override // com.beizi.fusion.en
            public void d(Animator animator) {
                a aVar = a.this;
                aVar.p = 0;
                aVar.a(1.0d);
                a aVar2 = a.this;
                aVar2.a(aVar2.e);
            }
        }

        private a(double d, double d2, int i, String str, String str2) {
            this.l = false;
            this.m = false;
            this.p = 0;
            this.q = AudioStats.AUDIO_AMPLITUDE_NONE;
            this.r = d.SHAKE_STATUS_STANDBY;
            this.s = 0L;
            this.e = str2;
            this.d = d;
            this.c = d2;
            this.f28062a = i;
            this.b = str;
            this.k = i;
            this.i = d;
            this.j = d2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(double d, double d2, int i) {
            this.f = d;
            this.g = d2;
            this.h = i;
            if (i <= 0) {
                i = this.f28062a;
            }
            this.k = i;
            if (d <= AudioStats.AUDIO_AMPLITUDE_NONE) {
                d = this.d;
            }
            this.i = d;
            if (d2 <= AudioStats.AUDIO_AMPLITUDE_NONE) {
                d2 = this.c;
            }
            this.j = d2;
            this.l = true;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void b() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void b(SensorEvent sensorEvent) {
            if (this.l) {
                c();
            }
            long jCurrentTimeMillis = System.currentTimeMillis();
            if (jCurrentTimeMillis - this.s > yh.this.o()) {
                this.s = jCurrentTimeMillis;
                a(sensorEvent);
            }
        }

        private void c() {
            if (this.m) {
                return;
            }
            this.m = true;
            long j = this.n;
            if (j > 0) {
                new C0336a(10, 1, j).c();
            } else {
                a();
            }
        }

        private void d() {
            View view = yh.this.d;
            if (view == null || !(view instanceof ScopeShakeView)) {
                return;
            }
            ((ScopeShakeView) view).setMaxProgress(this.k);
            ((ScopeShakeView) yh.this.d).setProgress(this.p);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(long j, int i) {
            this.n = j;
            this.o = i;
        }

        private void a(float f, float[] fArr) {
            if (f > fArr[1]) {
                fArr[1] = f;
            }
            if (f < fArr[0]) {
                fArr[0] = f;
            }
        }

        private void a(SensorEvent sensorEvent) {
            if (yh.this.a(sensorEvent, 1).booleanValue()) {
                float[] fArr = sensorEvent.values;
                float f = fArr[0];
                float f2 = fArr[1];
                float f3 = fArr[2];
                double dA = a(f, f2, f3, "XYZ");
                a(f, yh.this.r);
                a(f2, yh.this.s);
                a(f3, yh.this.t);
                a((float) dA, yh.this.u);
                double dA2 = a(f, f2, f3, this.b);
                if (dA < 1.1d || this.q == AudioStats.AUDIO_AMPLITUDE_NONE) {
                    this.q = Math.min(dA2, 1.0d);
                }
                double d = dA2 - this.q;
                double d2 = this.i - 1.0d;
                double d3 = this.j - 1.0d;
                if (d >= d2) {
                    this.r = d.SHAKE_STATUS_START;
                    return;
                }
                if (d > d3 || this.r != d.SHAKE_STATUS_START) {
                    return;
                }
                this.p++;
                d();
                this.r = d.SHAKE_STATUS_STANDBY;
                int i = this.k;
                if (i <= 0 || this.p < i) {
                    return;
                }
                yh yhVar = yh.this;
                yhVar.m = true;
                yhVar.j();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(String str) {
            KeyEvent.Callback callback = yh.this.d;
            if (callback == null || !(callback instanceof je)) {
                return;
            }
            ((je) callback).updateByInteractiveStatus(str);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a() {
            this.i = this.d;
            this.j = this.c;
            this.k = this.f28062a;
            a("Normal");
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(double d) {
            double d2 = this.d;
            this.i = d2 + ((this.f - d2) * d);
            double d3 = this.c;
            this.j = d3 + ((this.g - d3) * d);
            this.k = this.h;
        }

        private double a(float f, float f2, float f3, String str) {
            String upperCase = str.toUpperCase();
            boolean zContains = upperCase.contains("X");
            double dPow = AudioStats.AUDIO_AMPLITUDE_NONE;
            if (zContains) {
                dPow = AudioStats.AUDIO_AMPLITUDE_NONE + Math.pow(f / 9.80665f, 2.0d);
            }
            if (upperCase.contains("Y")) {
                dPow += Math.pow(f2 / 9.80665f, 2.0d);
            }
            if (upperCase.contains("Z")) {
                dPow += Math.pow(f3 / 9.80665f, 2.0d);
            }
            return Math.sqrt(dPow);
        }
    }

    private String a(StatusParamModel statusParamModel, String str) {
        if ("Cooling".equalsIgnoreCase(str)) {
            return statusParamModel.getCool();
        }
        return statusParamModel.getNormal();
    }

    private float a(float[] fArr) {
        return Math.max(Math.abs(fArr[0]), Math.abs(fArr[1]));
    }
}
