package com.beizi.fusion;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.view.View;
import com.beizi.fusion.asnp.adn.ad.model.impl.resp.ad3.ad.nativ.render.interaction.InteractionModel;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public abstract class mn extends q3 implements yc {
    protected SensorManager i;
    private final a j;
    protected final we k;

    public class a implements SensorEventListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private b f27542a;

        public a() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a() {
            this.f27542a = mn.this.i();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void b() {
            this.f27542a = null;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void c() {
            b bVarI = mn.this.i();
            this.f27542a = bVarI;
            bVarI.a();
        }

        @Override // android.hardware.SensorEventListener
        public void onAccuracyChanged(Sensor sensor, int i) {
        }

        @Override // android.hardware.SensorEventListener
        public void onSensorChanged(SensorEvent sensorEvent) {
            float[] fArr;
            b bVar = this.f27542a;
            if (bVar == null || (fArr = sensorEvent.values) == null || fArr.length <= 2) {
                return;
            }
            bVar.a(sensorEvent);
        }
    }

    public interface b {
        void a();

        void a(SensorEvent sensorEvent);
    }

    public mn(Context context) {
        super(context);
        this.k = we.a.a();
        this.j = new a();
    }

    @Override // com.beizi.fusion.q3, com.beizi.fusion.xc
    public /* bridge */ /* synthetic */ void a(dc dcVar) {
        super.a(dcVar);
    }

    @Override // com.beizi.fusion.q3, com.beizi.fusion.xc
    public void b() {
        super.b();
        a(false);
    }

    @Override // com.beizi.fusion.yc
    public we c() {
        return this.k;
    }

    @Override // com.beizi.fusion.q3, com.beizi.fusion.wa
    public /* bridge */ /* synthetic */ va d() {
        return super.d();
    }

    public abstract dd.a f();

    public abstract Sensor[] g();

    public abstract Sensor h();

    public abstract b i();

    public void j() {
        if (this.f.isClickRemoveSensor()) {
            a(false);
            this.h = true;
        }
        a(f());
        this.j.c();
    }

    public void k() {
        if (this.i == null || h() == null || !this.e || this.h) {
            return;
        }
        this.j.a();
        this.i.registerListener(this.j, h(), 1);
        Sensor[] sensorArrG = g();
        try {
            Thread.sleep(300L);
            if (sensorArrG != null) {
                for (Sensor sensor : sensorArrG) {
                    this.i.registerListener(this.j, sensor, 1);
                }
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Override // com.beizi.fusion.q3
    public /* bridge */ /* synthetic */ void a(InteractionModel interactionModel) {
        super.a(interactionModel);
    }

    public Boolean a(SensorEvent sensorEvent, int i) {
        Sensor sensor;
        return Boolean.valueOf((sensorEvent == null || (sensor = sensorEvent.sensor) == null || sensor.getType() != i || sensorEvent.values == null) ? false : true);
    }

    @Override // com.beizi.fusion.q3, com.beizi.fusion.xc
    public void a(View view, d dVar) {
        super.a(view, dVar);
        Context context = view.getContext();
        if (context != null) {
            this.i = (SensorManager) context.getApplicationContext().getSystemService("sensor");
        }
    }

    public void a(boolean z) {
        if (this.i != null) {
            this.j.b();
            this.i.unregisterListener(this.j);
            if (z && this.f.isHideRemoveSensor()) {
                this.h = true;
            }
        }
    }

    @Override // com.beizi.fusion.q3, com.beizi.fusion.xc
    public void a() {
        super.a();
        k();
    }
}
