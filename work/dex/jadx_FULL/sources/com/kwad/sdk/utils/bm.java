package com.kwad.sdk.utils;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.util.SparseArray;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
public class bm {
    private static bm bqv;
    private SensorManager bqw;
    private final List<Integer> bqx;
    private final SparseArray<Sensor> bqy;

    private bm() {
        ArrayList arrayList = new ArrayList();
        this.bqx = arrayList;
        this.bqy = new SparseArray<>();
        arrayList.addAll(Arrays.asList(1, 9, 10, 2, 4));
    }

    public static bm Wt() {
        if (bqv == null) {
            synchronized (bm.class) {
                if (bqv == null) {
                    bqv = new bm();
                }
            }
        }
        return bqv;
    }

    private static boolean Wu() {
        return !be.useSensorManagerDisable();
    }

    private boolean Wv() {
        boolean zWu = Wu();
        com.kwad.sdk.core.d.c.d("SensorManagerWrapper", "checkEnableSensor enable:" + zWu);
        if (zWu) {
            return true;
        }
        this.bqw = null;
        return false;
    }

    private SensorManager em(Context context) {
        if (this.bqw == null) {
            this.bqw = (SensorManager) context.getSystemService("sensor");
        }
        return this.bqw;
    }

    private void en(Context context) {
        SensorManager sensorManagerEm = em(context);
        com.kwad.sdk.core.d.c.w("SensorManagerWrapper", "fetchMultiSensors SensorManager.getSensorList call ");
        List<Sensor> sensorList = sensorManagerEm.getSensorList(-1);
        if (sensorList != null) {
            Iterator<Integer> it = this.bqx.iterator();
            while (it.hasNext()) {
                int iIntValue = it.next().intValue();
                for (Sensor sensor : sensorList) {
                    if (iIntValue == sensor.getType()) {
                        this.bqy.put(iIntValue, sensor);
                        break;
                    }
                }
            }
        }
    }

    public final SensorManager checkAndObtainSensorManager(Context context) {
        if (Wv()) {
            return em(context);
        }
        return null;
    }

    public final Sensor getDefaultSensor(Context context, int i) {
        com.kwad.sdk.core.d.c.d("SensorManagerWrapper", "getDefaultSensor type:" + i);
        if (!Wv()) {
            com.kwad.sdk.core.d.c.w("SensorManagerWrapper", "getDefaultSensor checkEnableSensor not enable sensor");
            return null;
        }
        if (this.bqy.get(i) == null) {
            if (!this.bqx.contains(Integer.valueOf(i))) {
                this.bqx.add(Integer.valueOf(i));
            }
            en(context);
        }
        Sensor sensor = this.bqy.get(i);
        com.kwad.sdk.core.d.c.w("SensorManagerWrapper", "getDefaultSensor result:" + sensor);
        return sensor;
    }

    public final boolean registerListener(Context context, SensorEventListener sensorEventListener, Sensor sensor, int i) {
        com.kwad.sdk.core.d.c.d("SensorManagerWrapper", "registerListener sensor:" + sensor + ", listener: " + sensorEventListener);
        if (!Wv()) {
            return false;
        }
        try {
            return em(context).registerListener(sensorEventListener, sensor, i);
        } catch (Exception unused) {
            return false;
        }
    }

    public final void unregisterListener(SensorEventListener sensorEventListener) {
        SensorManager sensorManager;
        com.kwad.sdk.core.d.c.d("SensorManagerWrapper", "unregisterListener listener:" + sensorEventListener);
        if (Wv() && (sensorManager = this.bqw) != null) {
            try {
                sensorManager.unregisterListener(sensorEventListener);
            } catch (Throwable unused) {
            }
        }
    }
}
