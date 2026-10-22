package com.kc.aw.lib.helper.imp;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import com.kc.aw._m7;
import com.kc.aw._mg;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.lang.reflect.Array;
import java.util.LinkedList;
import java.util.Locale;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class SensorListener implements _m7 {
    public boolean _a;
    public _mg._b _b;
    public long _c;
    public long _g;
    private double defaultSpeed = 1500.0d;
    private float mainDegree = 35.0f;
    private float minorDegree = 3.0f;
    public float _d = 0.0f;
    public float _e = 0.0f;
    public float _f = 0.0f;
    public final LinkedList _h = new LinkedList();
    public final float[] _i = new float[3];
    public boolean _j = false;
    public float _k = 0.0f;

    @Keep
    public static final class _a {
        public long _a;
        public float[] _b;

        public _a(long j, float[] fArr) {
            this._a = j;
            float[] fArr2 = new float[3];
            this._b = fArr2;
            System.arraycopy(fArr, 0, fArr2, 0, 3);
        }
    }

    @Override // com.kc.aw._m7
    public final void _a() {
        this._b = null;
    }

    @Override // android.hardware.SensorEventListener
    public final void onAccuracyChanged(Sensor sensor, int i) {
    }

    @Override // android.hardware.SensorEventListener
    public final void onSensorChanged(SensorEvent sensorEvent) {
        Long lValueOf;
        _mg._b _bVar;
        Long lValueOf2;
        _a _aVar;
        float[] fArr;
        if ((sensorEvent == null || sensorEvent.sensor == null || (fArr = sensorEvent.values) == null || fArr.length < 3) ? false : true) {
            if (sensorEvent.sensor.getType() == 4 && this._a) {
                long jCurrentTimeMillis = System.currentTimeMillis();
                long j = jCurrentTimeMillis - this._g;
                if (j < 100) {
                    lValueOf2 = null;
                } else {
                    this._g = jCurrentTimeMillis;
                    lValueOf2 = Long.valueOf(j);
                }
                if (lValueOf2 != null) {
                    long jNanoTime = System.nanoTime();
                    float[] fArr2 = new float[3];
                    for (int i = 0; i < 3; i++) {
                        float[] fArr3 = this._i;
                        float f = (sensorEvent.values[i] * 0.7f) + (fArr3[i] * 0.3f);
                        fArr2[i] = f;
                        fArr3[i] = f;
                    }
                    this._h.add(new _a(jNanoTime, fArr2));
                    while (!this._h.isEmpty() && (_aVar = (_a) this._h.peek()) != null && jNanoTime - _aVar._a > 2000000000) {
                        this._h.poll();
                    }
                    if (this._h.size() >= 2) {
                        float[][] fArr4 = (float[][]) Array.newInstance((Class<?>) Float.TYPE, 3, 2);
                        _a _aVar2 = null;
                        for (_a _aVar3 : this._h) {
                            if (_aVar2 != null) {
                                float f2 = (_aVar3._a - _aVar2._a) / 1.0E9f;
                                for (int i2 = 0; i2 < 3; i2++) {
                                    float f3 = _aVar3._b[i2];
                                    if (Math.abs(f3) > 0.3f) {
                                        float degrees = (float) Math.toDegrees(f3 * f2);
                                        if (degrees > 0.0f) {
                                            float[] fArr5 = fArr4[i2];
                                            fArr5[0] = fArr5[0] + degrees;
                                        } else {
                                            float[] fArr6 = fArr4[i2];
                                            fArr6[1] = Math.abs(degrees) + fArr6[1];
                                        }
                                    }
                                }
                            }
                            _aVar2 = _aVar3;
                        }
                        for (int i3 = 0; i3 < 3; i3++) {
                            float[] fArr7 = fArr4[i3];
                            float f4 = fArr7[0];
                            float f5 = fArr7[1];
                            float f6 = this.minorDegree;
                            boolean z = f4 >= f6 && f5 >= this.mainDegree;
                            boolean z2 = f5 >= f6 && f4 >= this.mainDegree;
                            if ((z || z2) && !this._j) {
                                this._j = true;
                                float f7 = z ? f5 : f4;
                                if (!z) {
                                    f4 = f5;
                                }
                                this._k = Float.parseFloat(String.format(Locale.CHINA, "%.2f", Float.valueOf(f7 + f4)));
                            }
                        }
                        if (!this._j) {
                            this._j = false;
                        }
                    }
                }
            }
            if (sensorEvent.sensor.getType() == 1) {
                long jCurrentTimeMillis2 = System.currentTimeMillis();
                long j2 = jCurrentTimeMillis2 - this._c;
                if (j2 < 100) {
                    lValueOf = null;
                } else {
                    this._c = jCurrentTimeMillis2;
                    lValueOf = Long.valueOf(j2);
                }
                if (lValueOf == null) {
                    return;
                }
                float[] fArr8 = sensorEvent.values;
                float f8 = fArr8[0];
                float f9 = fArr8[1];
                float f10 = fArr8[2];
                float f11 = f8 - this._d;
                float f12 = f9 - this._e;
                float f13 = f10 - this._f;
                this._d = f8;
                this._e = f9;
                this._f = f10;
                double d = Double.parseDouble(String.format(Locale.CHINA, "%.2f", Double.valueOf((Math.sqrt((f13 * f13) + ((f12 * f12) + (f11 * f11))) / lValueOf.longValue()) * 10000.0d)));
                if (d >= this.defaultSpeed) {
                    if (!this._a) {
                        _bVar = this._b;
                        if (_bVar == null) {
                            return;
                        }
                    } else if (!this._j || (_bVar = this._b) == null) {
                        return;
                    }
                    _bVar._a(f8, f9, f10, d, this._k);
                }
            }
        }
    }
}
