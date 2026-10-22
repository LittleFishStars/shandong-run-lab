package com.kc.aw;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Handler;
import android.os.Looper;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public final class _e2 {
    public Sensor _a;
    public _a _b;
    public final SensorManager _c;
    public final _e1 _d;
    public Handler _e;
    public _e3 _f;

    @Keep
    public final class _a implements SensorEventListener {
        public boolean _a = false;
        public final _e2 _b;

        public _a(_e2 _e2Var) {
            this._b = _e2Var;
        }

        @Override // android.hardware.SensorEventListener
        public final void onAccuracyChanged(Sensor sensor, int i) {
        }

        @Override // android.hardware.SensorEventListener
        public final void onSensorChanged(SensorEvent sensorEvent) {
            if (_e2._a(this._b, sensorEvent) && sensorEvent.sensor.getType() == 4 && !this._a) {
                this._a = true;
                _e1 _e1Var = this._b._d;
                if (_e1Var != null) {
                    float[] fArr = sensorEvent.values;
                    ((_c7) _e1Var)._a(fArr[0], fArr[1], fArr[2]);
                }
                _e2 _e2Var = this._b;
                _e2Var.getClass();
                com.kc.aw.lib.utils._d._b(new _e4(_e2Var));
                _e3 _e3Var = _e2Var._f;
                if (_e3Var != null) {
                    _e2Var._e.removeCallbacks(_e3Var);
                }
            }
        }
    }

    public _e2(Context context, _c7 _c7Var) {
        this._d = _c7Var;
        SensorManager sensorManager = (SensorManager) context.getSystemService("sensor");
        this._c = sensorManager;
        if (sensorManager == null) {
            return;
        }
        this._a = sensorManager.getDefaultSensor(4);
        this._e = new Handler(Looper.getMainLooper());
    }

    public static boolean _a(_e2 _e2Var, SensorEvent sensorEvent) {
        float[] fArr;
        _e2Var.getClass();
        return (sensorEvent == null || sensorEvent.sensor == null || (fArr = sensorEvent.values) == null || fArr.length < 3) ? false : true;
    }

    public final void _a() {
        if (this._a == null) {
            _e1 _e1Var = this._d;
            if (_e1Var != null) {
                ((_c7) _e1Var)._a(0.0f, 0.0f, 0.0f);
            }
            com.kc.aw.lib.utils._d._b(new _e4(this));
            _e3 _e3Var = this._f;
            if (_e3Var != null) {
                this._e.removeCallbacks(_e3Var);
                return;
            }
            return;
        }
        this._b = new _a(this);
        try {
            _e3 _e3Var2 = new _e3(this);
            this._f = _e3Var2;
            this._e.postDelayed(_e3Var2, 500L);
            SensorManager sensorManager = this._c;
            if (sensorManager != null) {
                sensorManager.registerListener(this._b, this._a, 2);
            }
        } catch (Exception unused) {
            _e1 _e1Var2 = this._d;
            if (_e1Var2 != null) {
                ((_c7) _e1Var2)._a(0.0f, 0.0f, 0.0f);
            }
            com.kc.aw.lib.utils._d._b(new _e4(this));
            _e3 _e3Var3 = this._f;
            if (_e3Var3 != null) {
                this._e.removeCallbacks(_e3Var3);
            }
        }
    }
}
