package com.alibaba.ariver.commonability.core.b.a;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import com.alibaba.ariver.commonability.core.util.CommonUtils;
import com.alibaba.fastjson.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class a extends e {
    private Context d;
    private float e;
    private int f;
    private int g;
    private com.alibaba.ariver.commonability.core.a.a h;
    private long i;
    private float k;
    private float l;
    private float m;
    private boolean n;
    private int j = 0;
    private SensorEventListener o = new SensorEventListener() { // from class: com.alibaba.ariver.commonability.core.b.a.a.1
        @Override // android.hardware.SensorEventListener
        public void onAccuracyChanged(Sensor sensor, int i) {
        }

        @Override // android.hardware.SensorEventListener
        public void onSensorChanged(SensorEvent sensorEvent) {
            long jCurrentTimeMillis = System.currentTimeMillis();
            long j = jCurrentTimeMillis - a.this.i;
            if (j < a.this.e) {
                return;
            }
            a.this.i = jCurrentTimeMillis;
            float[] fArr = sensorEvent.values;
            float f = fArr[0];
            float f2 = fArr[1];
            float f3 = fArr[2];
            float f4 = f - a.this.k;
            float f5 = f2 - a.this.l;
            float f6 = f3 - a.this.m;
            a.this.k = f;
            a.this.l = f2;
            a.this.m = f3;
            if ((Math.sqrt(((f4 * f4) + (f5 * f5)) + (f6 * f6)) / j) * 10000.0d < a.this.f) {
                return;
            }
            if (a.this.j < a.this.g) {
                a.i(a.this);
                return;
            }
            a.this.j = 0;
            a.this.b();
            a.this.h.a(null, 0);
        }
    };

    public static /* synthetic */ int i(a aVar) {
        int i = aVar.j;
        aVar.j = i + 1;
        return i;
    }

    @Override // com.alibaba.ariver.commonability.core.b.a.e
    public void b() {
        if (this.n) {
            this.n = false;
            ((SensorManager) this.d.getSystemService("sensor")).unregisterListener(this.o);
        }
    }

    @Override // com.alibaba.ariver.commonability.core.a.b
    public void a(Context context, JSONObject jSONObject) {
        this.d = context;
        this.e = CommonUtils.getFloat(jSONObject, "interval", 100.0f);
        this.f = CommonUtils.getInt(jSONObject, "speedThreshold", 1100);
        this.g = CommonUtils.getInt(jSONObject, "countsLimited", 2);
    }

    @Override // com.alibaba.ariver.commonability.core.b.a.e
    public void a(com.alibaba.ariver.commonability.core.a.a aVar) {
        if (this.n) {
            return;
        }
        this.n = true;
        this.h = aVar;
        SensorManager sensorManager = (SensorManager) this.d.getSystemService("sensor");
        sensorManager.registerListener(this.o, sensorManager.getDefaultSensor(1), 3);
    }

    @Override // com.alibaba.ariver.commonability.core.a.b
    public void a() {
        this.d = null;
        this.h = null;
        this.o = null;
    }
}
