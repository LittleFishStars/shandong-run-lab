package com.kwad.sdk.utils;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
public final class bl implements SensorEventListener {
    private AtomicBoolean SW;
    private final b bqn;
    private final b bqo;
    private final b bqp;
    private AtomicBoolean bqq;
    private final bk.b bqr;

    public static class a {
        private static final bl bqt = new bl(0);
    }

    public static class b {
        private SensorEvent bqu;
        private long timestamp;

        private b() {
        }

        public final void aa(List<com.kwad.sdk.k.a.e> list) {
            if (this.bqu == null) {
                return;
            }
            com.kwad.sdk.k.a.e eVar = new com.kwad.sdk.k.a.e();
            eVar.sensorType = this.bqu.sensor.getType();
            eVar.timestamp = this.timestamp / 1000;
            for (float f : this.bqu.values) {
                eVar.bmD.add(Float.valueOf(f));
            }
            list.add(eVar);
        }

        public final void b(SensorEvent sensorEvent) {
            this.bqu = sensorEvent;
            this.timestamp = System.currentTimeMillis();
        }

        public /* synthetic */ b(byte b) {
            this();
        }
    }

    public /* synthetic */ bl(byte b2) {
        this();
    }

    public static bl Wp() {
        return a.bqt;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Wr() {
        if (this.SW.get()) {
            i.execute(new bi() { // from class: com.kwad.sdk.utils.bl.3
                @Override // com.kwad.sdk.utils.bi
                public final void doTask() {
                    bk.Wo().a(bl.this);
                    bl.this.SW.compareAndSet(true, false);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void register() {
        if (this.bqq.get() || this.SW.get()) {
            return;
        }
        i.execute(new bi() { // from class: com.kwad.sdk.utils.bl.2
            @Override // com.kwad.sdk.utils.bi
            public final void doTask() {
                try {
                    bk bkVarWo = bk.Wo();
                    bl blVar = bl.this;
                    bkVarWo.a(3, 3, blVar, blVar.bqr);
                    bk bkVarWo2 = bk.Wo();
                    bl blVar2 = bl.this;
                    bkVarWo2.a(2, 3, blVar2, blVar2.bqr);
                    bk bkVarWo3 = bk.Wo();
                    bl blVar3 = bl.this;
                    bkVarWo3.a(4, 3, blVar3, blVar3.bqr);
                    bl.this.SW.set(true);
                } catch (Throwable unused) {
                    bl.this.bqq.set(true);
                }
            }
        });
    }

    public final synchronized List<com.kwad.sdk.k.a.e> Wq() {
        if (!t.UJ()) {
            return null;
        }
        com.kwad.sdk.core.c.b.LW();
        if (com.kwad.sdk.core.c.b.isAppOnForeground()) {
            register();
        }
        ArrayList arrayList = new ArrayList();
        this.bqn.aa(arrayList);
        this.bqo.aa(arrayList);
        this.bqp.aa(arrayList);
        return arrayList;
    }

    @Override // android.hardware.SensorEventListener
    public final void onAccuracyChanged(Sensor sensor, int i) {
    }

    @Override // android.hardware.SensorEventListener
    public final void onSensorChanged(SensorEvent sensorEvent) {
        int type = sensorEvent.sensor.getType();
        if (type == 1) {
            this.bqn.b(sensorEvent);
        } else if (type == 4) {
            this.bqo.b(sensorEvent);
        } else {
            if (type != 9) {
                return;
            }
            this.bqp.b(sensorEvent);
        }
    }

    private bl() {
        byte b2 = 0;
        this.bqn = new b(b2);
        this.bqo = new b(b2);
        this.bqp = new b(b2);
        this.bqq = new AtomicBoolean(false);
        this.SW = new AtomicBoolean(false);
        this.bqr = new bk.b() { // from class: com.kwad.sdk.utils.bl.4
            @Override // com.kwad.sdk.utils.bk.b
            public final void onFailed() {
                bl.this.bqq.compareAndSet(false, true);
            }
        };
        com.kwad.sdk.core.c.b.LW();
        com.kwad.sdk.core.c.b.a(new com.kwad.sdk.core.c.d() { // from class: com.kwad.sdk.utils.bl.1
            @Override // com.kwad.sdk.core.c.d, com.kwad.sdk.core.c.c
            public final void onBackToBackground() {
                super.onBackToBackground();
                bl.this.Wr();
            }

            @Override // com.kwad.sdk.core.c.d, com.kwad.sdk.core.c.c
            public final void onBackToForeground() {
                super.onBackToForeground();
                if (t.UJ()) {
                    bl.this.register();
                }
            }
        });
    }
}
