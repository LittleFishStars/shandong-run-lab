package com.alibaba.ariver.commonability.core.b.a;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import com.alibaba.ariver.commonability.core.util.CommonUtils;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.fastjson.JSONObject;
import com.google.android.exoplayer2.source.rtsp.j;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class d extends e {
    private static final int d = 50;
    private static final String e = "CommonAbility#GyroscopeSensorService";
    private SensorEventListener f;
    private SensorEventListener g;
    private SensorEventListener h;
    private float[] i;
    private float[] j;
    private float[] k;
    private volatile int l = 50;
    private long m = System.currentTimeMillis();
    private com.alibaba.ariver.commonability.core.a.a n;
    private Context o;
    private float p;
    private String q;
    private boolean r;

    public class a implements SensorEventListener {
        private a() {
        }

        @Override // android.hardware.SensorEventListener
        public void onAccuracyChanged(Sensor sensor, int i) {
        }

        @Override // android.hardware.SensorEventListener
        public void onSensorChanged(SensorEvent sensorEvent) {
            Sensor sensor;
            if (sensorEvent == null || sensorEvent.values == null || (sensor = sensorEvent.sensor) == null) {
                return;
            }
            int type = sensor.getType();
            if (type == 1) {
                d.this.i = sensorEvent.values;
            } else if (type == 2) {
                d.this.j = sensorEvent.values;
            } else if (type == 4) {
                d.this.k = sensorEvent.values;
            }
            d.this.d();
        }
    }

    public d() {
        this.f = new a();
        this.g = new a();
        this.h = new a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        if (this.i == null || this.j == null || this.k == null) {
            return;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (jCurrentTimeMillis - this.m < this.l) {
            return;
        }
        this.m = jCurrentTimeMillis;
        float[] fArr = this.k;
        float f = fArr[0];
        float f2 = fArr[1];
        float f3 = fArr[2];
        if (this.n == null) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("x", (Object) Float.valueOf(f));
        jSONObject.put("y", (Object) Float.valueOf(f2));
        jSONObject.put(j.o, (Object) Float.valueOf(f3));
        this.n.a(jSONObject, 4);
    }

    @Override // com.alibaba.ariver.commonability.core.b.a.e
    public void b() {
        if (this.r) {
            this.r = false;
            SensorManager sensorManager = (SensorManager) this.o.getSystemService("sensor");
            if (sensorManager == null) {
                return;
            }
            sensorManager.unregisterListener(this.f);
            sensorManager.unregisterListener(this.g);
            sensorManager.unregisterListener(this.h);
        }
    }

    @Override // com.alibaba.ariver.commonability.core.a.b
    public void a(Context context, JSONObject jSONObject) {
        this.o = context;
        if (com.alibaba.ariver.commonability.core.util.b.a("ta_sensor_gyroscope_interval", true)) {
            this.p = jSONObject.containsKey("interval") ? jSONObject.getFloatValue("interval") : 0.5f;
        } else {
            this.p = CommonUtils.getFloat(jSONObject, "interval", 0.5f);
        }
        this.q = CommonUtils.getString(jSONObject, "samplingPeriodUs", "");
        RVLogger.d(e, "interval:" + this.p + ",samplingPeriodUs:" + this.q);
    }

    @Override // com.alibaba.ariver.commonability.core.b.a.e
    public void a(com.alibaba.ariver.commonability.core.a.a aVar) {
        int i;
        if (this.r) {
            return;
        }
        int i2 = 1;
        this.r = true;
        SensorManager sensorManager = (SensorManager) this.o.getSystemService("sensor");
        if (sensorManager == null) {
            return;
        }
        Sensor defaultSensor = sensorManager.getDefaultSensor(4);
        Sensor defaultSensor2 = sensorManager.getDefaultSensor(1);
        Sensor defaultSensor3 = sensorManager.getDefaultSensor(2);
        this.n = aVar;
        this.l = 50;
        float f = this.p;
        if (f != 0.0f) {
            this.l = (int) (f * 1000.0f);
        }
        if ((this.l < 0 || this.l >= 20) && (this.l < 20 || this.l >= 60)) {
            i = (this.l < 60 || this.l >= 200) ? 3 : 2;
        } else {
            i = 1;
        }
        String str = this.q;
        str.hashCode();
        switch (str) {
            case "normal":
                this.l = 200;
                i2 = 3;
                break;
            case "ui":
                this.l = 60;
                i2 = 2;
                break;
            case "game":
                this.l = 20;
                break;
            default:
                i2 = i;
                break;
        }
        sensorManager.registerListener(this.f, defaultSensor, i2);
        sensorManager.registerListener(this.g, defaultSensor2, i2);
        sensorManager.registerListener(this.h, defaultSensor3, i2);
    }

    @Override // com.alibaba.ariver.commonability.core.a.b
    public void a() {
        this.o = null;
        this.n = null;
        this.i = null;
        this.j = null;
        this.k = null;
    }
}
