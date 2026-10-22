package com.huachenjie.common.run_component;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import com.huachenjie.common.base.BaseSimpleComponent;
import com.huachenjie.common.run_interface.RunStateChangeListener;
import com.huachenjie.common.step.keep.StepDetectListener;
import com.zj.adlib.i4a;
import com.zj.adlib.lr8;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
public class StepComponent extends BaseSimpleComponent implements RunStateChangeListener {
    public static final String f = "StepComponent";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Context f33886a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Sensor f8860a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public SensorManager f8862a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public StepChangeCallBack f8863a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public lr8 f8864a;
    public int K = 0;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public boolean f8865a = true;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final SensorEventListener f8861a = new a();

    public interface StepChangeCallBack {
        void a(int stepCount);
    }

    public class a implements SensorEventListener {
        public a() {
        }

        @Override // android.hardware.SensorEventListener
        public void onAccuracyChanged(Sensor sensor, int accuracy) {
        }

        @Override // android.hardware.SensorEventListener
        public void onSensorChanged(SensorEvent event) {
            if (StepComponent.this.f8864a != null) {
                lr8 lr8Var = StepComponent.this.f8864a;
                long j = event.timestamp;
                float[] fArr = event.values;
                lr8Var.a(j, fArr[0], fArr[1], fArr[2]);
            }
        }
    }

    public class b implements StepDetectListener {
        public b() {
        }

        @Override // com.huachenjie.common.step.keep.StepDetectListener
        public void a(long timestamp) {
            if (StepComponent.this.f8865a) {
                return;
            }
            StepComponent.this.p(1);
        }
    }

    public static /* synthetic */ class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f33889a;

        static {
            int[] iArr = new int[RunStateChangeListener.State.values().length];
            f33889a = iArr;
            try {
                iArr[RunStateChangeListener.State.normal.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f33889a[RunStateChangeListener.State.autoPause.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f33889a[RunStateChangeListener.State.userPause.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f33889a[RunStateChangeListener.State.faceRecognition.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f33889a[RunStateChangeListener.State.nfcCheck.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f33889a[RunStateChangeListener.State.finish.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    public StepComponent(Context context) {
        this.f33886a = context;
        initData();
        n();
    }

    @Override // com.huachenjie.common.run_interface.RunStateChangeListener
    public void b(RunStateChangeListener.State state, Map<String, Object> map) {
        switch (c.f33889a[state.ordinal()]) {
            case 1:
                k();
                break;
            case 2:
            case 3:
            case 4:
            case 5:
                h();
                break;
            case 6:
                j();
                break;
        }
    }

    public final boolean f() {
        lr8 lr8Var = new lr8();
        this.f8864a = lr8Var;
        lr8Var.c(new b());
        return this.f8862a.registerListener(this.f8861a, this.f8860a, 1);
    }

    public final void g() {
        boolean zF;
        if (this.f8860a == null) {
            this.f8860a = this.f8862a.getDefaultSensor(1);
        }
        if (this.f8860a != null) {
            zF = f();
            if (zF) {
                i4a.g(f, "使用加速度传感器计步");
            }
        } else {
            zF = false;
        }
        if (zF) {
            return;
        }
        i4a.g(f, "步测传感器和加速度传感器都损坏");
    }

    public final void h() {
        this.f8865a = true;
    }

    public void i(StepChangeCallBack callback) {
        this.f8863a = callback;
    }

    public final void initData() {
        j();
    }

    public final void j() {
        this.K = 0;
    }

    public final void k() {
        this.f8865a = false;
    }

    public void l(int initialStep) {
        this.K = initialStep;
    }

    public void m(int threadValue) {
    }

    public final void n() {
        if (this.f8862a == null) {
            this.f8862a = (SensorManager) this.f33886a.getSystemService("sensor");
        }
        if (this.f8862a == null) {
            i4a.g(f, "SensorManager损坏");
        } else {
            g();
        }
    }

    public final void o() {
        SensorManager sensorManager = this.f8862a;
        if (sensorManager == null || this.f8860a == null) {
            return;
        }
        sensorManager.unregisterListener(this.f8861a);
    }

    @Override // com.huachenjie.common.base.BaseSimpleComponent, com.huachenjie.common.base.ILifecycleCallback
    public void onDestroy() {
        this.f8863a = null;
        j();
        o();
        this.f33886a = null;
        super.onDestroy();
    }

    public final void p(int step) {
        this.K += step;
        i4a.g(f, "监听到步数变化，总步数为：" + this.K);
        StepChangeCallBack stepChangeCallBack = this.f8863a;
        if (stepChangeCallBack != null) {
            stepChangeCallBack.a(this.K);
        }
    }
}
