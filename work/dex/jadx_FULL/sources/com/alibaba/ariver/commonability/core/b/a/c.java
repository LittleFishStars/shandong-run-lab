package com.alibaba.ariver.commonability.core.b.a;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import com.alibaba.ariver.commonability.core.util.CommonUtils;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.fastjson.JSONObject;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class c extends e {
    private static final String d = "CommonAbility#CompassSensorService";
    private volatile float e;
    private float[] g;
    private float[] h;
    private com.alibaba.ariver.commonability.core.a.a i;
    private Context j;
    private boolean k;
    private String l;
    private Long f = Long.valueOf(System.currentTimeMillis());
    private SensorEventListener m = new SensorEventListener() { // from class: com.alibaba.ariver.commonability.core.b.a.c.1
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
            if ((type == 2 || type == 1) && System.currentTimeMillis() - c.this.f.longValue() > c.this.e) {
                c.this.f = Long.valueOf(System.currentTimeMillis());
                if (type == 2) {
                    try {
                        c.this.g = sensorEvent.values;
                    } catch (Exception unused) {
                        return;
                    }
                }
                if (type == 1) {
                    c.this.h = sensorEvent.values;
                }
                if (c.this.i != null && c.this.g != null && c.this.h != null) {
                    c cVar = c.this;
                    cVar.a(cVar.i, c.this.g, c.this.h);
                }
            }
        }
    };

    @Override // com.alibaba.ariver.commonability.core.b.a.e
    public void b() {
        if (this.k) {
            this.k = false;
            ((SensorManager) this.j.getSystemService("sensor")).unregisterListener(this.m);
        }
    }

    @Override // com.alibaba.ariver.commonability.core.a.b
    public void a(Context context, JSONObject jSONObject) {
        this.j = context;
        if (com.alibaba.ariver.commonability.core.util.b.a("ta_sensor_compass_interval", true)) {
            this.e = jSONObject.containsKey("interval") ? jSONObject.getFloatValue("interval") : 0.5f;
            this.e *= 1000.0f;
        } else {
            this.e = CommonUtils.getInt(jSONObject, "interval", 100);
        }
        this.l = CommonUtils.getString(jSONObject, "samplingPeriodUs", "");
        RVLogger.d(d, "interval:" + this.e + ",samplingPeriodUs:" + this.l);
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    @Override // com.alibaba.ariver.commonability.core.b.a.e
    public void a(com.alibaba.ariver.commonability.core.a.a aVar) {
        if (this.k) {
            return;
        }
        this.k = true;
        this.i = aVar;
        String str = this.l;
        str.hashCode();
        byte b = -1;
        switch (str.hashCode()) {
            case -1039745817:
                if (str.equals("normal")) {
                    b = 0;
                }
                break;
            case 3732:
                if (str.equals("ui")) {
                    b = 1;
                }
                break;
            case 3165170:
                if (str.equals("game")) {
                    b = 2;
                }
                break;
        }
        int i = 3;
        switch (b) {
            case 0:
                this.e = 200.0f;
                break;
            case 1:
                this.e = 60.0f;
                i = 2;
                break;
            case 2:
                this.e = 20.0f;
                i = 1;
                break;
        }
        SensorManager sensorManager = (SensorManager) this.j.getSystemService("sensor");
        Sensor defaultSensor = sensorManager.getDefaultSensor(2);
        Sensor defaultSensor2 = sensorManager.getDefaultSensor(1);
        sensorManager.registerListener(this.m, defaultSensor, i);
        sensorManager.registerListener(this.m, defaultSensor2, i);
    }

    @Override // com.alibaba.ariver.commonability.core.a.b
    public void a() {
        this.m = null;
        this.i = null;
        this.j = null;
    }

    public void a(com.alibaba.ariver.commonability.core.a.a aVar, float[] fArr, float[] fArr2) {
        JSONObject jSONObject = new JSONObject();
        float[] fArr3 = new float[9];
        SensorManager.getRotationMatrix(fArr3, null, fArr2, fArr);
        float[] fArr4 = {degrees, 0.0f, 0.0f};
        SensorManager.getOrientation(fArr3, fArr4);
        float degrees = (float) Math.toDegrees(fArr4[0]);
        jSONObject.put(HiAnalyticsConstant.HaKey.BI_KEY_DIRECTION, (Object) Integer.valueOf((int) ((degrees + 360.0f) % 360.0f)));
        aVar.a(jSONObject, 2);
    }
}
