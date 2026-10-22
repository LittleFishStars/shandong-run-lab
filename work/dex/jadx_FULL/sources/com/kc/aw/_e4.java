package com.kc.aw;

import android.hardware.SensorManager;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public final class _e4 implements Runnable {
    public final _e2 _a;

    public _e4(_e2 _e2Var) {
        this._a = _e2Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        _e2._a _aVar;
        _e2 _e2Var = this._a;
        SensorManager sensorManager = _e2Var._c;
        if (sensorManager == null || (_aVar = _e2Var._b) == null) {
            return;
        }
        try {
            sensorManager.unregisterListener(_aVar);
        } catch (Exception unused) {
        }
    }
}
