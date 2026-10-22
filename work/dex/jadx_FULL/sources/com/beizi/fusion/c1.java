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
public final class c1 extends mn {
    private final Map l;

    public enum b {
        SHAKE_STATUS_START,
        SHAKE_STATUS_STANDBY
    }

    public c1(Context context) {
        super(context);
        this.l = new HashMap();
    }

    private a a(ShakeModel shakeModel, String str) {
        if (shakeModel == null) {
            return null;
        }
        StatusParamModel startAmplitude = shakeModel.getStartAmplitude();
        StatusParamModel endAmplitude = shakeModel.getEndAmplitude();
        StatusParamModel count = shakeModel.getCount();
        StatusParamModel axial = shakeModel.getAxial();
        return new a(startAmplitude != null ? no.g(a(startAmplitude, str)) : -1.0d, endAmplitude != null ? no.g(a(endAmplitude, str)) : -1.0d, count != null ? no.i(a(count, str)) : 0, axial != null ? a(axial, str) : "", str);
    }

    private void l() {
        a aVarA;
        InteractionModel interactionModel = this.f;
        if (interactionModel == null || (aVarA = a(interactionModel.getShake(), "Cooling")) == null) {
            return;
        }
        this.l.put("Cooling", aVarA);
    }

    private void m() {
        a aVarA;
        InteractionModel interactionModel = this.f;
        if (interactionModel == null || (aVarA = a(interactionModel.getShake(), "Normal")) == null) {
            return;
        }
        this.l.put("Normal", aVarA);
    }

    private void n() {
        ShakeModel shake;
        a aVarA;
        InteractionModel interactionModel = this.f;
        if (interactionModel == null || (aVarA = a((shake = interactionModel.getShake()), "Passive")) == null) {
            return;
        }
        StatusParamModel startAmplitude = shake.getStartAmplitude();
        StatusParamModel endAmplitude = shake.getEndAmplitude();
        StatusParamModel count = shake.getCount();
        aVarA.a(startAmplitude != null ? no.a(startAmplitude.getPassivation(), -1.0d) : -1.0d, endAmplitude != null ? no.a(endAmplitude.getPassivation(), -1.0d) : -1.0d, count != null ? no.i(count.getPassivation()) : 0);
        aVarA.a(this.f.getPassivationTime(), this.f.getPassivationType());
        this.l.put("Passive", aVarA);
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
        return new Sensor[0];
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
        super.j();
    }

    public long o() {
        return 50L;
    }

    public class a implements mn.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f27118a;
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
        private b r;
        private long s;
        private float[] t;
        private float[] u;
        private float[] v;
        private float[] w;
        private long x;

        /* JADX INFO: renamed from: com.beizi.fusion.c1$a$a, reason: collision with other inner class name */
        public class C0302a extends en {
            public C0302a(int i, int i2, long j) {
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
                aVar.b();
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
            this.r = b.SHAKE_STATUS_STANDBY;
            this.s = 0L;
            this.t = new float[2];
            this.u = new float[2];
            this.v = new float[2];
            this.w = new float[2];
            this.x = 0L;
            this.e = str2;
            this.d = d;
            this.c = d2;
            this.f27118a = i;
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
                i = this.f27118a;
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

        private void b(SensorEvent sensorEvent) {
            if (c1.this.a(sensorEvent, 1).booleanValue()) {
                float[] fArr = sensorEvent.values;
                float f = fArr[0];
                float f2 = fArr[1];
                float f3 = fArr[2];
                double dA = a(f, f2, f3, "XYZ");
                a(f, this.t);
                a(f2, this.u);
                a(f3, this.v);
                a((float) dA, this.w);
                double dA2 = a(f, f2, f3, this.b);
                if (dA < 1.1d || this.q == AudioStats.AUDIO_AMPLITUDE_NONE) {
                    this.q = Math.min(dA2, 1.0d);
                }
                double d = dA2 - this.q;
                double d2 = this.i - 1.0d;
                double d3 = this.j - 1.0d;
                if (d >= d2) {
                    this.r = b.SHAKE_STATUS_START;
                    return;
                }
                if (d > d3 || this.r != b.SHAKE_STATUS_START) {
                    return;
                }
                this.p++;
                d();
                this.r = b.SHAKE_STATUS_STANDBY;
                int i = this.k;
                if (i <= 0 || this.p < i) {
                    return;
                }
                c1.this.k.a(1, a(this.t), a(this.u), a(this.v), this.w[1], System.currentTimeMillis() - this.x);
                c1.this.j();
            }
        }

        private void c() {
            if (this.m) {
                return;
            }
            this.m = true;
            long j = this.n;
            if (j > 0) {
                new C0302a(10, 1, j).c();
            } else {
                b();
            }
        }

        private void d() {
            View view = c1.this.d;
            if (view == null || !(view instanceof ScopeShakeView)) {
                return;
            }
            ((ScopeShakeView) view).setMaxProgress(this.k);
            ((ScopeShakeView) c1.this.d).setProgress(this.p);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(long j, int i) {
            this.n = j;
            this.o = i;
        }

        @Override // com.beizi.fusion.mn.b
        public void a(SensorEvent sensorEvent) {
            if (this.x == 0) {
                this.x = System.currentTimeMillis();
            }
            if (this.l) {
                c();
            }
            long jCurrentTimeMillis = System.currentTimeMillis();
            if (jCurrentTimeMillis - this.s > c1.this.o()) {
                this.s = jCurrentTimeMillis;
                b(sensorEvent);
            }
        }

        @Override // com.beizi.fusion.mn.b
        public void a() {
            this.x = 0L;
        }

        private float a(float[] fArr) {
            return Math.max(Math.abs(fArr[0]), Math.abs(fArr[1]));
        }

        private void a(float f, float[] fArr) {
            if (f > fArr[1]) {
                fArr[1] = f;
            }
            if (f < fArr[0]) {
                fArr[0] = f;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(String str) {
            KeyEvent.Callback callback = c1.this.d;
            if (callback == null || !(callback instanceof je)) {
                return;
            }
            ((je) callback).updateByInteractiveStatus(str);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(double d) {
            double d2 = this.d;
            this.i = d2 + ((this.f - d2) * d);
            double d3 = this.c;
            this.j = d3 + ((this.g - d3) * d);
            this.k = this.h;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void b() {
            this.i = this.d;
            this.j = this.c;
            this.k = this.f27118a;
            a("Normal");
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
}
