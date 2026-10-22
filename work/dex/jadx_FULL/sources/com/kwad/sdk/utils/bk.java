package com.kwad.sdk.utils;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.ali.auth.third.login.LoginConstants;
import com.kwad.sdk.service.ServiceProvider;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
public class bk {
    private static volatile bk bqi;
    private final Map<String, a> bqj = new ConcurrentHashMap();
    private final Map<String, CopyOnWriteArraySet<SensorEventListener>> bqk = new ConcurrentHashMap();
    private boolean bql = false;

    public static class a implements SensorEventListener {
        private final WeakReference<bk> arz;
        private final String key;

        public a(String str, bk bkVar) {
            this.key = str;
            this.arz = new WeakReference<>(bkVar);
        }

        @Override // android.hardware.SensorEventListener
        public final void onAccuracyChanged(Sensor sensor, int i) {
        }

        @Override // android.hardware.SensorEventListener
        public final void onSensorChanged(SensorEvent sensorEvent) {
            bk bkVar = this.arz.get();
            if (bkVar != null) {
                bkVar.a(this.key, sensorEvent);
            }
        }
    }

    public interface b {
        void onFailed();
    }

    private bk() {
        com.kwad.sdk.core.c.b.LW();
        com.kwad.sdk.core.c.b.a(new com.kwad.sdk.core.c.d() { // from class: com.kwad.sdk.utils.bk.1
            @Override // com.kwad.sdk.core.c.d, com.kwad.sdk.core.c.c
            public final void onBackToBackground() {
                super.onBackToBackground();
                com.kwad.sdk.core.d.c.d("SensorDataManager", "onBackToBackground");
                SensorManager sensorManagerCheckAndObtainSensorManager = bm.Wt().checkAndObtainSensorManager(ServiceProvider.getContext());
                for (String str : bk.this.bqj.keySet()) {
                    try {
                        sensorManagerCheckAndObtainSensorManager.unregisterListener((a) bk.this.bqj.get(str));
                        com.kwad.sdk.core.d.c.d("SensorDataManager", "unregister successfully: " + str);
                    } catch (Throwable unused) {
                    }
                }
            }

            @Override // com.kwad.sdk.core.c.d, com.kwad.sdk.core.c.c
            public final void onBackToForeground() {
                super.onBackToForeground();
                com.kwad.sdk.core.d.c.d("SensorDataManager", "onBackToForeground ");
                SensorManager sensorManagerCheckAndObtainSensorManager = bm.Wt().checkAndObtainSensorManager(ServiceProvider.getContext());
                for (String str : bk.this.bqj.keySet()) {
                    a aVar = (a) bk.this.bqj.get(str);
                    if (aVar != null) {
                        sensorManagerCheckAndObtainSensorManager.registerListener(aVar, bk.a(bk.this, Integer.parseInt(str.split(LoginConstants.UNDER_LINE)[0])), bk.b(bk.this, Integer.parseInt(str.split(LoginConstants.UNDER_LINE)[1])));
                        com.kwad.sdk.core.d.c.d("SensorDataManager", "register successfully: " + str);
                    }
                }
            }
        });
    }

    private static String I(int i, int i2) {
        return i + LoginConstants.UNDER_LINE + i2;
    }

    @NonNull
    public static bk Wo() {
        if (bqi == null) {
            synchronized (bk.class) {
                if (bqi == null) {
                    bqi = new bk();
                }
            }
        }
        return bqi;
    }

    public static /* synthetic */ Sensor a(bk bkVar, int i) {
        return gc(i);
    }

    public static /* synthetic */ int b(bk bkVar, int i) {
        return gd(i);
    }

    @Nullable
    private static Sensor gc(int i) {
        bm bmVarWt = bm.Wt();
        Context context = ServiceProvider.getContext();
        if (i == 1) {
            return bmVarWt.getDefaultSensor(context, 10);
        }
        if (i == 2) {
            return bmVarWt.getDefaultSensor(context, 4);
        }
        if (i == 3) {
            return bmVarWt.getDefaultSensor(context, 1);
        }
        if (i != 4) {
            return null;
        }
        return bmVarWt.getDefaultSensor(context, 9);
    }

    private static int gd(int i) {
        if (i == -3) {
            return 2;
        }
        if (i != -2) {
            return i != -1 ? 3 : 0;
        }
        return 1;
    }

    private void id(String str) {
        a aVar = this.bqj.get(str);
        if (aVar != null) {
            this.bqj.remove(str);
            try {
                bm.Wt().unregisterListener(aVar);
            } catch (Throwable th) {
                com.kwad.sdk.core.d.c.printStackTraceOnly(th);
            }
        }
    }

    private a ie(String str) {
        a aVar = this.bqj.get(str);
        if (aVar != null) {
            return aVar;
        }
        a aVar2 = new a(str, this);
        this.bqj.put(str, aVar2);
        return aVar2;
    }

    public final synchronized void a(int i, int i2, SensorEventListener sensorEventListener, b bVar) {
        Sensor sensorGc = gc(i);
        if (sensorGc == null) {
            if (bVar != null) {
                bVar.onFailed();
            }
            return;
        }
        String strI = I(i, i2);
        CopyOnWriteArraySet<SensorEventListener> copyOnWriteArraySet = this.bqk.get(strI);
        if (copyOnWriteArraySet == null) {
            copyOnWriteArraySet = new CopyOnWriteArraySet<>();
        }
        copyOnWriteArraySet.add(sensorEventListener);
        if (copyOnWriteArraySet.size() == 1) {
            this.bqk.put(strI, copyOnWriteArraySet);
            a(strI, i2, sensorGc);
        }
    }

    public final synchronized void a(SensorEventListener sensorEventListener) {
        for (Map.Entry<String, CopyOnWriteArraySet<SensorEventListener>> entry : this.bqk.entrySet()) {
            CopyOnWriteArraySet<SensorEventListener> value = entry.getValue();
            for (SensorEventListener sensorEventListener2 : value) {
                if (sensorEventListener2.equals(sensorEventListener)) {
                    value.remove(sensorEventListener2);
                    break;
                }
            }
            if (value.size() == 0) {
                id(entry.getKey());
            }
        }
    }

    private void a(String str, int i, Sensor sensor) {
        boolean zUseSensorManagerDisable = be.useSensorManagerDisable();
        this.bql = zUseSensorManagerDisable;
        if (zUseSensorManagerDisable) {
            return;
        }
        bm.Wt().registerListener(ServiceProvider.getContext(), ie(str), sensor, gd(i));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, SensorEvent sensorEvent) {
        CopyOnWriteArraySet<SensorEventListener> copyOnWriteArraySet = this.bqk.get(str);
        if (copyOnWriteArraySet != null) {
            Iterator<SensorEventListener> it = copyOnWriteArraySet.iterator();
            while (it.hasNext()) {
                it.next().onSensorChanged(sensorEvent);
            }
        }
    }
}
