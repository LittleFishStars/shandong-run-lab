package com.kwad.components.core.offline.b.a;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import com.kwad.components.offline.api.core.api.ISensorManagerProxy;
import com.kwad.sdk.utils.bm;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public final class s implements ISensorManagerProxy {
    @Override // com.kwad.components.offline.api.core.api.ISensorManagerProxy
    public final SensorManager checkAndObtainSensorManager(Context context) {
        return bm.Wt().checkAndObtainSensorManager(context);
    }

    @Override // com.kwad.components.offline.api.core.api.ISensorManagerProxy
    public final Sensor getDefaultSensor(Context context, int i) {
        return bm.Wt().getDefaultSensor(context, i);
    }

    @Override // com.kwad.components.offline.api.core.api.ISensorManagerProxy
    public final boolean registerListener(Context context, SensorEventListener sensorEventListener, Sensor sensor, int i) {
        return bm.Wt().registerListener(context, sensorEventListener, sensor, i);
    }

    @Override // com.kwad.components.offline.api.core.api.ISensorManagerProxy
    public final void unregisterListener(SensorEventListener sensorEventListener) {
        bm.Wt().unregisterListener(sensorEventListener);
    }
}
