package com.ipd.dsp.internal.k1;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Process;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.os.VibratorManager;
import android.text.TextUtils;
import android.view.View;
import androidx.annotation.NonNull;
import com.ipd.dsp.internal.c2.r;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public abstract class a implements com.ipd.dsp.internal.b1.b.c {
    public com.ipd.dsp.internal.e1.d f;
    public com.ipd.dsp.internal.j1.b g;
    public com.ipd.dsp.internal.b1.b h;
    public com.ipd.dsp.internal.x1.c i;
    public final boolean j;
    public int k;
    public b l;
    public Runnable m;

    public static class b implements SensorEventListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public a f38387a;
        public final int b;
        public long c;
        public float d;
        public float e;
        public float f;
        public volatile boolean g;
        public Handler h;
        public final AtomicInteger i;
        public Runnable j;

        public final void a(float f, float f2, float f3) {
            a aVar;
            if (this.i.incrementAndGet() >= 3) {
                this.g = false;
                Runnable runnable = this.j;
                if (runnable != null) {
                    runnable.run();
                    this.j = null;
                    return;
                }
                return;
            }
            if (!this.g || (aVar = this.f38387a) == null) {
                return;
            }
            aVar.a(new float[]{f, f2, f3});
            this.g = false;
            Handler handler = this.h;
            if (handler != null) {
                handler.postDelayed(new Runnable() { // from class: com.zj.adlib.vga
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f45346a.a();
                    }
                }, 1000L);
            }
        }

        public void b() {
            this.f38387a = null;
            Handler handler = this.h;
            if (handler != null) {
                handler.removeCallbacksAndMessages(null);
            }
            this.h = null;
        }

        @Override // android.hardware.SensorEventListener
        public void onAccuracyChanged(Sensor sensor, int i) {
        }

        @Override // android.hardware.SensorEventListener
        public void onSensorChanged(SensorEvent sensorEvent) {
            if (this.g) {
                long j = sensorEvent.timestamp;
                if (j - this.c < 200) {
                    return;
                }
                this.c = j;
                float[] fArr = sensorEvent.values;
                float f = fArr[0];
                float f2 = fArr[1];
                float f3 = fArr[2] - 9.80665f;
                if (Math.abs(f) > this.b && this.d * f <= 0.0f) {
                    a(f, f2, f3);
                    this.d = f;
                } else if (Math.abs(f2) > this.b && this.e * f2 <= 0.0f) {
                    a(f, f2, f3);
                    this.e = f2;
                } else {
                    if (Math.abs(f3) <= this.b || this.f * f3 > 0.0f) {
                        return;
                    }
                    a(f, f2, f3);
                    this.f = f3;
                }
            }
        }

        public b(int i, Runnable runnable) {
            this.c = 0L;
            this.g = true;
            this.h = null;
            this.i = new AtomicInteger(0);
            this.b = i;
            this.j = runnable;
        }

        public final /* synthetic */ void a() {
            try {
                this.g = true;
            } catch (Throwable unused) {
            }
        }

        public void a(a aVar) {
            this.f38387a = aVar;
            this.g = true;
            this.h = new Handler(Looper.getMainLooper());
        }
    }

    public interface c {
        void a();

        void b();

        void onDetachedFromWindow();
    }

    public a(com.ipd.dsp.internal.e1.d dVar, com.ipd.dsp.internal.j1.b bVar) {
        this.f = dVar;
        this.g = bVar;
        com.ipd.dsp.internal.b1.b bVarA = com.ipd.dsp.internal.b1.b.a(dVar, bVar);
        this.h = bVarA;
        if (bVarA instanceof com.ipd.dsp.internal.b1.b.a) {
            ((com.ipd.dsp.internal.b1.b.a) bVarA).a(this);
        }
        boolean z = dVar.w.g;
        this.j = z;
        if (z) {
            Runnable runnable = new Runnable() { // from class: com.zj.adlib.cea
                @Override // java.lang.Runnable
                public final void run() {
                    this.f40956a.f();
                }
            };
            this.m = runnable;
            this.l = new b(dVar.w.h, runnable);
        }
    }

    private void j() {
        try {
            Context context = com.ipd.dsp.internal.l1.a.a().getContext();
            if (context == null || context.checkPermission("android.permission.VIBRATE", Process.myPid(), Process.myUid()) != 0) {
                return;
            }
            Vibrator defaultVibrator = Build.VERSION.SDK_INT >= 31 ? ((VibratorManager) context.getSystemService("vibrator_manager")).getDefaultVibrator() : (Vibrator) context.getSystemService("vibrator");
            if (defaultVibrator == null || !defaultVibrator.hasVibrator()) {
                return;
            }
            defaultVibrator.vibrate(VibrationEffect.createOneShot(400L, -1));
        } catch (Throwable th) {
            r.a(th);
        }
    }

    public void a(com.ipd.dsp.internal.b1.b.e eVar) {
        com.ipd.dsp.internal.b1.b bVar = this.h;
        if (bVar == null || eVar == null) {
            return;
        }
        bVar.c = eVar;
    }

    public abstract void b(@NonNull Context context);

    public void c(Context context) {
        Sensor defaultSensor;
        com.ipd.dsp.internal.x1.c cVar;
        if ((context == null && ((cVar = this.i) == null || cVar.getContext() == null)) || this.l == null) {
            return;
        }
        if (context == null) {
            context = this.i.getContext();
        }
        SensorManager sensorManager = (SensorManager) context.getApplicationContext().getSystemService("sensor");
        if (sensorManager == null || (defaultSensor = sensorManager.getDefaultSensor(1)) == null) {
            return;
        }
        this.l.b();
        sensorManager.unregisterListener(this.l, defaultSensor);
    }

    @Override // com.ipd.dsp.internal.b1.b.c
    public boolean c() {
        return true;
    }

    public void d() {
        com.ipd.dsp.internal.x1.c cVar = this.i;
        a(1, null, cVar != null ? cVar.getTouchCoordsMap() : null);
    }

    public View e() {
        return this.i;
    }

    public final /* synthetic */ void f() {
        k();
        this.l = null;
        this.m = null;
    }

    public void g() {
        this.f = null;
        this.g = null;
        com.ipd.dsp.internal.b1.b bVar = this.h;
        if (bVar != null) {
            bVar.c();
            this.h = null;
        }
        this.i = null;
        this.l = null;
        this.m = null;
    }

    public void h() {
        com.ipd.dsp.internal.j1.b bVar = this.g;
        if (bVar != null) {
            com.ipd.dsp.internal.x1.c cVar = this.i;
            if (cVar != null) {
                bVar.a(new com.ipd.dsp.internal.j1.a(cVar));
            }
            com.ipd.dsp.internal.h1.a.a(this.g, this.k);
        }
    }

    public void i() {
        a((Context) null);
    }

    public void k() {
        c(null);
    }

    @Override // com.ipd.dsp.internal.b1.b.c
    public void onDownloadConfirmDialogDismiss() {
    }

    @Override // com.ipd.dsp.internal.b1.b.c
    public void onDownloadConfirmDialogShow() {
    }

    public void a(int i, float[] fArr, Map<String, Object> map) {
        com.ipd.dsp.internal.h1.a.a(this.g, this.k, i, fArr, map, new com.ipd.dsp.internal.h1.a.d() { // from class: com.zj.adlib.sea
            @Override // com.ipd.dsp.internal.h1.a.d
            public final void a(Object obj) {
                this.f44675a.a((String) obj);
            }
        });
    }

    public final /* synthetic */ void a(String str) {
        if (this.f == null) {
            return;
        }
        try {
            if (!TextUtils.isEmpty(str)) {
                com.ipd.dsp.internal.b1.b bVar = this.h;
                if (bVar instanceof com.ipd.dsp.internal.b1.b.a) {
                    this.f.r.k = str;
                } else if (bVar instanceof com.ipd.dsp.internal.b1.b.d) {
                    this.f.r.j = str;
                }
            }
            com.ipd.dsp.internal.b1.b bVar2 = this.h;
            if (bVar2 != null) {
                bVar2.a();
            }
        } catch (Throwable th) {
            r.a(th);
        }
    }

    public void a(float[] fArr) {
        j();
    }

    public void a(Context context) {
        Sensor defaultSensor;
        com.ipd.dsp.internal.x1.c cVar;
        if ((context == null && ((cVar = this.i) == null || cVar.getContext() == null)) || this.l == null) {
            return;
        }
        if (context == null) {
            context = this.i.getContext();
        }
        SensorManager sensorManager = (SensorManager) context.getApplicationContext().getSystemService("sensor");
        if (sensorManager == null || (defaultSensor = sensorManager.getDefaultSensor(1)) == null) {
            return;
        }
        this.l.a(this);
        sensorManager.registerListener(this.l, defaultSensor, 2);
    }

    public void a(int i) {
        this.k = i;
    }
}
