package com.kc.aw;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.text.TextUtils;
import com.kc.aw.lib.helper.imp.SensorListener;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.lang.reflect.Field;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public final class _mg {
    public static final ConcurrentHashMap<String, SensorManager> _a = new ConcurrentHashMap<>();
    public static final ConcurrentHashMap<String, _m7> _b = new ConcurrentHashMap<>();
    public static final ConcurrentHashMap<String, AtomicBoolean> _c = new ConcurrentHashMap<>();

    @Keep
    public final class _a {
        public final Context _a;

        public _a(Context context) {
            this._a = context;
        }

        public final void _a(String str, SensorListener sensorListener) {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            ConcurrentHashMap<String, AtomicBoolean> concurrentHashMap = _mg._c;
            AtomicBoolean atomicBoolean = concurrentHashMap.get(str);
            if (atomicBoolean != null && atomicBoolean.get()) {
                concurrentHashMap.remove(str);
                return;
            }
            ConcurrentHashMap<String, _m7> concurrentHashMap2 = _mg._b;
            if (concurrentHashMap2.containsKey(str)) {
                return;
            }
            SensorManager sensorManager = TextUtils.isEmpty(str) ? null : _mg._a.get(str);
            if (sensorManager == null) {
                try {
                    sensorManager = (SensorManager) this._a.getApplicationContext().getSystemService("sensor");
                    if (sensorManager == null) {
                        return;
                    }
                } catch (Exception unused) {
                    return;
                }
            }
            Sensor defaultSensor = sensorManager.getDefaultSensor(1);
            if (defaultSensor == null) {
                return;
            }
            try {
                Sensor defaultSensor2 = sensorManager.getDefaultSensor(4);
                boolean z = defaultSensor2 != null;
                sensorListener._a = z;
                if (z) {
                    sensorManager.registerListener(sensorListener, defaultSensor2, 1);
                }
                sensorManager.registerListener(sensorListener, defaultSensor, 1);
                if (!TextUtils.isEmpty(str)) {
                    concurrentHashMap2.put(str, sensorListener);
                }
                if (TextUtils.isEmpty(str)) {
                    return;
                }
                _mg._a.put(str, sensorManager);
            } catch (Exception unused2) {
            }
        }
    }

    @Keep
    public interface _b {
        void _a(float f, float f2, float f3, double d, float f4);
    }

    public static void _a(Context context, _b _bVar, _mf _mfVar) {
        float f;
        float f2;
        if (context != null) {
            _a _aVar = new _a(context);
            SensorListener sensorListener = new SensorListener();
            sensorListener._b = _bVar;
            int i = _mfVar._b;
            _m6 _m6Var = _mfVar._f;
            if (_m6Var != null) {
                f = _m6Var._a;
                f2 = _m6Var._b;
            } else {
                f = 35.0f;
                f2 = 3.0f;
            }
            try {
                Field declaredField = SensorListener.class.getDeclaredField("defaultSpeed");
                declaredField.setAccessible(true);
                declaredField.set(sensorListener, Integer.valueOf(i));
                declaredField.setAccessible(false);
            } catch (Exception unused) {
                System.out.println();
            }
            try {
                Field declaredField2 = SensorListener.class.getDeclaredField("mainDegree");
                declaredField2.setAccessible(true);
                declaredField2.set(sensorListener, Float.valueOf(f));
                declaredField2.setAccessible(false);
            } catch (Exception unused2) {
                System.out.println();
            }
            try {
                Field declaredField3 = SensorListener.class.getDeclaredField("minorDegree");
                declaredField3.setAccessible(true);
                declaredField3.set(sensorListener, Float.valueOf(f2));
                declaredField3.setAccessible(false);
            } catch (Exception unused3) {
                System.out.println();
            }
            _aVar._a(_mfVar._a, sensorListener);
        }
    }

    public static void _a(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        _c.put(str, new AtomicBoolean(true));
        _m7 _m7VarRemove = TextUtils.isEmpty(str) ? null : _b.remove(str);
        SensorManager sensorManagerRemove = TextUtils.isEmpty(str) ? null : _a.remove(str);
        if (sensorManagerRemove != null && _m7VarRemove != null) {
            try {
                sensorManagerRemove.unregisterListener(_m7VarRemove);
            } catch (Exception unused) {
            }
        }
        if (_m7VarRemove != null) {
            try {
                _m7VarRemove._a();
            } catch (Exception unused2) {
            }
        }
        _c.remove(str);
    }
}
