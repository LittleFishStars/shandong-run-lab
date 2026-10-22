package com.byazt.gf;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.taobao.windvane.util.ConfigStorage;
import com.byazt.bwm.sp;
import com.byazt.nr.rh;
import com.byazt.qi.a;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 914, 15})
public class uj implements SensorEventListener {
    public static volatile uj c;
    public volatile c my;
    public Sensor yp;
    public Sensor z;
    public volatile boolean tt = false;
    public final List<Float> ve = new ArrayList(1);
    public final List<Float> uj = new ArrayList(1);
    public final List<Float> n = new ArrayList(1);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<Float> f28567a = new ArrayList(1);
    public final List<Float> sp = new ArrayList(1);
    public final List<Float> x = new ArrayList(1);
    public final int i = 0;
    public final int da = 1;
    public final int sl = 2;
    public final int t = 16;
    public final int u = 32;
    public long m = 0;
    public volatile boolean nu = false;
    public volatile AtomicInteger rh = new AtomicInteger(0);
    public volatile int gt = 0;

    public interface c {
        void c(JSONObject jSONObject);
    }

    private uj() {
        this.yp = null;
        this.z = null;
        SensorManager sensorManager = (SensorManager) a.ve().getApplicationContext().getSystemService("sensor");
        if (sensorManager != null) {
            try {
                this.yp = sensorManager.getDefaultSensor(1);
                this.z = sensorManager.getDefaultSensor(2);
            } catch (Exception unused) {
            }
        }
    }

    @Override // android.hardware.SensorEventListener
    public void onAccuracyChanged(Sensor sensor, int i) {
    }

    @Override // android.hardware.SensorEventListener
    public void onSensorChanged(SensorEvent sensorEvent) {
        Sensor sensor;
        this.rh.incrementAndGet();
        if (sensorEvent == null || (sensor = sensorEvent.sensor) == null) {
            return;
        }
        int type = sensor.getType();
        float[] fArr = sensorEvent.values;
        if (fArr == null || fArr.length < 3) {
            return;
        }
        if (type == 1) {
            if (this.ve.size() > 0) {
                a();
                return;
            }
            this.ve.add(Float.valueOf(sensorEvent.values[0]));
            this.uj.add(Float.valueOf(sensorEvent.values[1]));
            this.n.add(Float.valueOf(sensorEvent.values[2]));
            return;
        }
        if (type != 2) {
            return;
        }
        if (this.f28567a.size() > 0) {
            a();
            return;
        }
        this.f28567a.add(Float.valueOf(sensorEvent.values[0]));
        this.sp.add(Float.valueOf(sensorEvent.values[1]));
        this.x.add(Float.valueOf(sensorEvent.values[2]));
    }

    private synchronized void a() {
        if (!this.tt && this.ve.size() > 0 && this.f28567a.size() > 0) {
            this.tt = true;
            n();
            com.byazt.bwm.n.tt(new sp("har") { // from class: com.byazt.gf.uj.1
                @Override // java.lang.Runnable
                public void run() {
                    JSONObject jSONObject = new JSONObject();
                    try {
                        float[] fArrC = ve.c(uj.this.ve, uj.this.uj, uj.this.n, uj.this.f28567a, uj.this.sp, uj.this.x);
                        uj.this.c(fArrC);
                        long jCurrentTimeMillis = System.currentTimeMillis();
                        long jA = n.c().a();
                        long jSp = n.c().sp();
                        int iVe = (int) (((n.c().ve() / 1000) / 60) / 60);
                        if (iVe <= 0) {
                            iVe = 1;
                        }
                        jSONObject.put("azimuth_unit", jA);
                        jSONObject.put("angle_unit", jSp);
                        LinkedList<JSONObject> linkedListC = tt.c().c(0L);
                        jSONObject.put("active", Arrays.toString(ve.c(linkedListC, iVe)));
                        com.byazt.gf.c.c().c(iVe);
                        jSONObject.put("screen", Arrays.toString(com.byazt.gf.c.c().ve()));
                        jSONObject.put("network", Arrays.toString(com.byazt.gf.c.c().tt()));
                        jSONObject.put("support_net", com.byazt.gf.c.c().uj());
                        jSONObject.put("sim_status", com.byazt.gf.c.c().n());
                        int[][] iArrC = ve.c(linkedListC, jA, jSp);
                        jSONObject.put("ax", Arrays.toString(iArrC[0]));
                        jSONObject.put("ay", Arrays.toString(iArrC[1]));
                        jSONObject.put("az", Arrays.toString(iArrC[2]));
                        int[][] iArrC2 = ve.c(tt.c().c(10800000L), jA, jSp);
                        jSONObject.put("ax3", Arrays.toString(iArrC2[0]));
                        jSONObject.put("ay3", Arrays.toString(iArrC2[1]));
                        jSONObject.put("az3", Arrays.toString(iArrC2[2]));
                        int[][] iArrC3 = ve.c(tt.c().c(ConfigStorage.DEFAULT_MAX_AGE), jA, jSp);
                        jSONObject.put("ax6", Arrays.toString(iArrC3[0]));
                        jSONObject.put("ay6", Arrays.toString(iArrC3[1]));
                        jSONObject.put("az6", Arrays.toString(iArrC3[2]));
                        jSONObject.put("angleAvg", Arrays.toString(fArrC));
                        jSONObject.put("timestamp", jCurrentTimeMillis);
                    } catch (Exception unused) {
                        jSONObject = null;
                    }
                    if (uj.this.my != null) {
                        uj.this.my.c(jSONObject);
                    }
                    uj.this.sp();
                    uj.this.nu = false;
                }
            });
        } else {
            if (this.rh.get() > 3) {
                n();
                sp();
                this.nu = false;
            }
        }
    }

    private void n() {
        this.rh = new AtomicInteger(0);
        SensorManager sensorManager = (SensorManager) a.ve().getApplicationContext().getSystemService("sensor");
        if (sensorManager != null) {
            Sensor sensor = this.yp;
            if (sensor != null) {
                sensorManager.unregisterListener(this, sensor);
            }
            Sensor sensor2 = this.z;
            if (sensor2 != null) {
                sensorManager.unregisterListener(this, sensor2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sp() {
        this.ve.clear();
        this.uj.clear();
        this.n.clear();
        this.f28567a.clear();
        this.sp.clear();
        this.x.clear();
    }

    public synchronized boolean tt() {
        int i;
        int i2;
        this.gt = 0;
        if (this.nu) {
            return false;
        }
        if (this.yp == null || this.z == null) {
            this.gt |= this.yp == null ? 2 : 0;
            int i3 = this.gt;
            i = this.z == null ? 16 : 0;
            i2 = i3;
        } else {
            this.nu = false;
            SensorManager sensorManager = (SensorManager) a.ve().getApplicationContext().getSystemService("sensor");
            i = 1;
            if (sensorManager != null) {
                try {
                    boolean zRegisterListener = sensorManager.registerListener(this, this.yp, 1);
                    boolean zRegisterListener2 = sensorManager.registerListener(this, this.z, 1);
                    if (zRegisterListener && zRegisterListener2) {
                        this.nu = true;
                        this.tt = false;
                    } else {
                        this.gt |= 32;
                        n();
                        sp();
                    }
                } catch (Exception unused) {
                    i2 = this.gt;
                    i = 32;
                    this.gt = i2 | i;
                }
                return this.nu;
            }
            i2 = this.gt;
        }
        this.gt = i2 | i;
        return this.nu;
    }

    public long uj() {
        return this.m;
    }

    public boolean ve() {
        return this.nu;
    }

    public static uj c() {
        if (c == null) {
            synchronized (uj.class) {
                if (c == null) {
                    c = new uj();
                }
            }
        }
        return c;
    }

    public void c(c cVar) {
        this.my = cVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(float[] fArr) {
        this.m = System.currentTimeMillis();
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("t", uj());
            jSONObject.put("val", new JSONArray(fArr));
            tt.c().c(jSONObject, "sp_angle");
            tt.c().c(rh.ve(a.ve()));
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }
}
