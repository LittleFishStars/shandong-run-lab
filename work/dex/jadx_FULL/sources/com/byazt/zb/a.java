package com.byazt.zb;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import com.google.android.exoplayer2.source.rtsp.j;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 184, 34})
public class a {
    public Context c;
    public WeakReference<x> tt;
    public Map<String, c> ve = new HashMap();
    public SensorEventListener uj = new SensorEventListener() { // from class: com.byazt.zb.a.1
        @Override // android.hardware.SensorEventListener
        public void onAccuracyChanged(Sensor sensor, int i) {
        }

        @Override // android.hardware.SensorEventListener
        public void onSensorChanged(SensorEvent sensorEvent) {
            x xVarUj;
            if (sensorEvent.sensor.getType() != 1 || (xVarUj = a.this.uj()) == null) {
                return;
            }
            float[] fArr = sensorEvent.values;
            float f = fArr[0];
            float f2 = fArr[1];
            float f3 = fArr[2];
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("x", f);
                jSONObject.put("y", f2);
                jSONObject.put(j.o, f3);
                xVarUj.c("accelerometer_callback", jSONObject);
            } catch (Throwable unused) {
            }
        }
    };
    public SensorEventListener n = new SensorEventListener() { // from class: com.byazt.zb.a.12
        @Override // android.hardware.SensorEventListener
        public void onAccuracyChanged(Sensor sensor, int i) {
        }

        @Override // android.hardware.SensorEventListener
        public void onSensorChanged(SensorEvent sensorEvent) {
            x xVarUj;
            if (sensorEvent.sensor.getType() != 4 || (xVarUj = a.this.uj()) == null) {
                return;
            }
            float degrees = (float) Math.toDegrees(sensorEvent.values[0]);
            float degrees2 = (float) Math.toDegrees(sensorEvent.values[1]);
            float degrees3 = (float) Math.toDegrees(sensorEvent.values[2]);
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("x", degrees);
                jSONObject.put("y", degrees2);
                jSONObject.put(j.o, degrees3);
                xVarUj.c("gyro_callback", jSONObject);
            } catch (Throwable unused) {
            }
        }
    };

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public SensorEventListener f29231a = new SensorEventListener() { // from class: com.byazt.zb.a.23
        @Override // android.hardware.SensorEventListener
        public void onAccuracyChanged(Sensor sensor, int i) {
        }

        @Override // android.hardware.SensorEventListener
        public void onSensorChanged(SensorEvent sensorEvent) {
            x xVarUj;
            if (sensorEvent.sensor.getType() != 10 || (xVarUj = a.this.uj()) == null) {
                return;
            }
            float[] fArr = sensorEvent.values;
            float f = fArr[0];
            float f2 = fArr[1];
            float f3 = fArr[2];
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("x", f);
                jSONObject.put("y", f2);
                jSONObject.put(j.o, f3);
                xVarUj.c("accelerometer_grativityless_callback", jSONObject);
            } catch (Throwable unused) {
            }
        }
    };
    public SensorEventListener sp = new SensorEventListener() { // from class: com.byazt.zb.a.34
        @Override // android.hardware.SensorEventListener
        public void onAccuracyChanged(Sensor sensor, int i) {
        }

        @Override // android.hardware.SensorEventListener
        public void onSensorChanged(SensorEvent sensorEvent) {
            if (sensorEvent.sensor.getType() == 1) {
                float[] fArr = sensorEvent.values;
                float[] fArr2 = da.tt;
                System.arraycopy(fArr, 0, fArr2, 0, fArr2.length);
            } else if (sensorEvent.sensor.getType() == 2) {
                float[] fArr3 = sensorEvent.values;
                float[] fArr4 = da.ve;
                System.arraycopy(fArr3, 0, fArr4, 0, fArr4.length);
            }
            float[] fArr5 = da.uj;
            SensorManager.getRotationMatrix(fArr5, null, da.tt, da.ve);
            float[] fArr6 = da.n;
            SensorManager.getOrientation(fArr5, fArr6);
            x xVarUj = a.this.uj();
            if (xVarUj == null) {
                return;
            }
            float f = fArr6[0];
            float f2 = fArr6[1];
            float f3 = fArr6[2];
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("alpha", f);
                jSONObject.put("beta", f2);
                jSONObject.put("gamma", f3);
                xVarUj.c("rotation_vector_callback", jSONObject);
            } catch (Throwable unused) {
            }
        }
    };

    public interface c {
        JSONObject c(JSONObject jSONObject) throws Throwable;
    }

    public a(x xVar) {
        this.c = xVar.getContext();
        this.tt = new WeakReference<>(xVar);
        ve();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.byazt.zb.c n() {
        x xVarUj = uj();
        if (xVarUj == null) {
            return null;
        }
        return xVarUj.nu();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public x uj() {
        WeakReference<x> weakReference = this.tt;
        if (weakReference == null) {
            return null;
        }
        return weakReference.get();
    }

    private void ve() {
        this.ve.put("adInfo", new c() { // from class: com.byazt.zb.a.45
            @Override // com.byazt.zb.a.c
            public JSONObject c(JSONObject jSONObject) throws Throwable {
                x xVarUj = a.this.uj();
                if (xVarUj == null) {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("code", -1);
                    return jSONObject2;
                }
                JSONObject jSONObjectMy = xVarUj.my();
                if (jSONObjectMy != null) {
                    jSONObjectMy.put("code", 1);
                    return jSONObjectMy;
                }
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put("code", -1);
                return jSONObject3;
            }
        });
        this.ve.put("appInfo", new c() { // from class: com.byazt.zb.a.56
            @Override // com.byazt.zb.a.c
            public JSONObject c(JSONObject jSONObject) throws Throwable {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("code", 1);
                jSONObject2.put("appName", "playable_sdk");
                jSONObject2.put("playableSdkEdition", "6.5.1");
                JSONArray jSONArray = new JSONArray();
                Iterator<String> it = a.this.c().iterator();
                while (it.hasNext()) {
                    jSONArray.put(it.next());
                }
                jSONObject2.put("supportList", jSONArray);
                x xVarUj = a.this.uj();
                if (xVarUj != null) {
                    jSONObject2.put("deviceId", xVarUj.a());
                    jSONObject2.put("netType", xVarUj.m());
                    jSONObject2.put("innerAppName", xVarUj.ve());
                    jSONObject2.put("appName", xVarUj.uj());
                    jSONObject2.put("appVersion", xVarUj.n());
                    Map<String, String> mapC = xVarUj.c();
                    for (String str : mapC.keySet()) {
                        jSONObject2.put(str, mapC.get(str));
                    }
                }
                return jSONObject2;
            }
        });
        this.ve.put("playableSDKInfo", new c() { // from class: com.byazt.zb.a.61
            @Override // com.byazt.zb.a.c
            public JSONObject c(JSONObject jSONObject) throws Throwable {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("code", 1);
                jSONObject2.put("appName", "playable_sdk");
                jSONObject2.put("playableSdkEdition", "6.5.1");
                jSONObject2.put("os", "android");
                return jSONObject2;
            }
        });
        this.ve.put("subscribe_app_ad", new c() { // from class: com.byazt.zb.a.62
            @Override // com.byazt.zb.a.c
            public JSONObject c(JSONObject jSONObject) throws Throwable {
                com.byazt.zb.c cVarN = a.this.n();
                JSONObject jSONObject2 = new JSONObject();
                if (cVarN == null) {
                    jSONObject2.put("code", -1);
                    return jSONObject2;
                }
                jSONObject2.put("code", 1);
                return jSONObject2;
            }
        });
        this.ve.put("download_app_ad", new c() { // from class: com.byazt.zb.a.63
            @Override // com.byazt.zb.a.c
            public JSONObject c(JSONObject jSONObject) throws Throwable {
                com.byazt.zb.c cVarN = a.this.n();
                JSONObject jSONObject2 = new JSONObject();
                if (cVarN == null) {
                    jSONObject2.put("code", -1);
                    return jSONObject2;
                }
                jSONObject2.put("code", 1);
                return jSONObject2;
            }
        });
        this.ve.put("isViewable", new c() { // from class: com.byazt.zb.a.2
            @Override // com.byazt.zb.a.c
            public JSONObject c(JSONObject jSONObject) throws Throwable {
                x xVarUj = a.this.uj();
                if (xVarUj == null) {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("code", -1);
                    return jSONObject2;
                }
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put("code", 1);
                jSONObject3.put("viewStatus", xVarUj.x());
                return jSONObject3;
            }
        });
        this.ve.put("getVolume", new c() { // from class: com.byazt.zb.a.3
            @Override // com.byazt.zb.a.c
            public JSONObject c(JSONObject jSONObject) throws Throwable {
                x xVarUj = a.this.uj();
                if (xVarUj == null) {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("code", -1);
                    return jSONObject2;
                }
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put("code", 1);
                jSONObject3.put("endcard_mute", xVarUj.sp());
                return jSONObject3;
            }
        });
        this.ve.put("getScreenSize", new c() { // from class: com.byazt.zb.a.4
            @Override // com.byazt.zb.a.c
            public JSONObject c(JSONObject jSONObject) throws Throwable {
                x xVarUj = a.this.uj();
                if (xVarUj == null) {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("code", -1);
                    return jSONObject2;
                }
                JSONObject jSONObjectRh = xVarUj.rh();
                jSONObjectRh.put("code", 1);
                return jSONObjectRh;
            }
        });
        this.ve.put("start_accelerometer_observer", new c() { // from class: com.byazt.zb.a.5
            @Override // com.byazt.zb.a.c
            public JSONObject c(JSONObject jSONObject) throws Throwable {
                JSONObject jSONObject2 = new JSONObject();
                int iOptInt = 2;
                if (jSONObject != null) {
                    try {
                        iOptInt = jSONObject.optInt("interval_android", 2);
                    } catch (Throwable th) {
                        sp.c("PlayableJsBridge", "invoke start_accelerometer_observer error", th);
                        jSONObject2.put("code", -1);
                        jSONObject2.put("codeMsg", th.toString());
                        return jSONObject2;
                    }
                }
                da.c(a.this.c, a.this.uj, iOptInt);
                jSONObject2.put("code", 1);
                return jSONObject2;
            }
        });
        this.ve.put("close_accelerometer_observer", new c() { // from class: com.byazt.zb.a.6
            @Override // com.byazt.zb.a.c
            public JSONObject c(JSONObject jSONObject) throws Throwable {
                JSONObject jSONObject2 = new JSONObject();
                try {
                    da.c(a.this.c, a.this.uj);
                    jSONObject2.put("code", 1);
                    return jSONObject2;
                } catch (Throwable th) {
                    sp.c("PlayableJsBridge", "invoke close_accelerometer_observer error", th);
                    jSONObject2.put("code", -1);
                    jSONObject2.put("codeMsg", th.toString());
                    return jSONObject2;
                }
            }
        });
        this.ve.put("start_gyro_observer", new c() { // from class: com.byazt.zb.a.7
            @Override // com.byazt.zb.a.c
            public JSONObject c(JSONObject jSONObject) throws Throwable {
                JSONObject jSONObject2 = new JSONObject();
                int iOptInt = 2;
                if (jSONObject != null) {
                    try {
                        iOptInt = jSONObject.optInt("interval_android", 2);
                    } catch (Throwable th) {
                        sp.c("PlayableJsBridge", "invoke start_gyro_observer error", th);
                        jSONObject2.put("code", -1);
                        jSONObject2.put("codeMsg", th.toString());
                        return jSONObject2;
                    }
                }
                da.tt(a.this.c, a.this.n, iOptInt);
                jSONObject2.put("code", 1);
                return jSONObject2;
            }
        });
        this.ve.put("close_gyro_observer", new c() { // from class: com.byazt.zb.a.8
            @Override // com.byazt.zb.a.c
            public JSONObject c(JSONObject jSONObject) throws Throwable {
                JSONObject jSONObject2 = new JSONObject();
                try {
                    da.c(a.this.c, a.this.n);
                    jSONObject2.put("code", 1);
                    return jSONObject2;
                } catch (Throwable th) {
                    sp.c("PlayableJsBridge", "invoke close_gyro_observer error", th);
                    jSONObject2.put("code", -1);
                    jSONObject2.put("codeMsg", th.toString());
                    return jSONObject2;
                }
            }
        });
        this.ve.put("start_accelerometer_grativityless_observer", new c() { // from class: com.byazt.zb.a.9
            @Override // com.byazt.zb.a.c
            public JSONObject c(JSONObject jSONObject) throws Throwable {
                JSONObject jSONObject2 = new JSONObject();
                int iOptInt = 2;
                if (jSONObject != null) {
                    try {
                        iOptInt = jSONObject.optInt("interval_android", 2);
                    } catch (Throwable th) {
                        sp.c("PlayableJsBridge", "invoke start_accelerometer_grativityless_observer error", th);
                        jSONObject2.put("code", -1);
                        jSONObject2.put("codeMsg", th.toString());
                        return jSONObject2;
                    }
                }
                da.ve(a.this.c, a.this.f29231a, iOptInt);
                jSONObject2.put("code", 1);
                return jSONObject2;
            }
        });
        this.ve.put("close_accelerometer_grativityless_observer", new c() { // from class: com.byazt.zb.a.10
            @Override // com.byazt.zb.a.c
            public JSONObject c(JSONObject jSONObject) throws Throwable {
                JSONObject jSONObject2 = new JSONObject();
                try {
                    da.c(a.this.c, a.this.f29231a);
                    jSONObject2.put("code", 1);
                    return jSONObject2;
                } catch (Throwable th) {
                    sp.c("PlayableJsBridge", "invoke close_accelerometer_grativityless_observer error", th);
                    jSONObject2.put("code", -1);
                    jSONObject2.put("codeMsg", th.toString());
                    return jSONObject2;
                }
            }
        });
        this.ve.put("start_rotation_vector_observer", new c() { // from class: com.byazt.zb.a.11
            @Override // com.byazt.zb.a.c
            public JSONObject c(JSONObject jSONObject) throws Throwable {
                JSONObject jSONObject2 = new JSONObject();
                int iOptInt = 2;
                if (jSONObject != null) {
                    try {
                        iOptInt = jSONObject.optInt("interval_android", 2);
                    } catch (Throwable th) {
                        sp.c("PlayableJsBridge", "invoke start_rotation_vector_observer error", th);
                        jSONObject2.put("code", -1);
                        jSONObject2.put("codeMsg", th.toString());
                        return jSONObject2;
                    }
                }
                da.uj(a.this.c, a.this.sp, iOptInt);
                jSONObject2.put("code", 1);
                return jSONObject2;
            }
        });
        this.ve.put("close_rotation_vector_observer", new c() { // from class: com.byazt.zb.a.13
            @Override // com.byazt.zb.a.c
            public JSONObject c(JSONObject jSONObject) throws Throwable {
                JSONObject jSONObject2 = new JSONObject();
                try {
                    da.c(a.this.c, a.this.sp);
                    jSONObject2.put("code", 1);
                    return jSONObject2;
                } catch (Throwable th) {
                    sp.c("PlayableJsBridge", "invoke close_rotation_vector_observer error", th);
                    jSONObject2.put("code", -1);
                    jSONObject2.put("codeMsg", th.toString());
                    return jSONObject2;
                }
            }
        });
        this.ve.put("device_shake", new c() { // from class: com.byazt.zb.a.14
            @Override // com.byazt.zb.a.c
            public JSONObject c(JSONObject jSONObject) throws Throwable {
                JSONObject jSONObject2 = new JSONObject();
                try {
                    da.c(a.this.c, 300L);
                    jSONObject2.put("code", 1);
                    return jSONObject2;
                } catch (Throwable th) {
                    sp.c("PlayableJsBridge", "invoke device_shake error", th);
                    jSONObject2.put("code", -1);
                    jSONObject2.put("codeMsg", th.toString());
                    return jSONObject2;
                }
            }
        });
        this.ve.put("device_shake_short", new c() { // from class: com.byazt.zb.a.15
            @Override // com.byazt.zb.a.c
            public JSONObject c(JSONObject jSONObject) throws Throwable {
                JSONObject jSONObject2 = new JSONObject();
                try {
                    da.c(a.this.c, 150L);
                    jSONObject2.put("code", 1);
                    return jSONObject2;
                } catch (Throwable th) {
                    sp.c("PlayableJsBridge", "invoke device_shake error", th);
                    jSONObject2.put("code", -1);
                    jSONObject2.put("codeMsg", th.toString());
                    return jSONObject2;
                }
            }
        });
        this.ve.put("playable_style", new c() { // from class: com.byazt.zb.a.16
            @Override // com.byazt.zb.a.c
            public JSONObject c(JSONObject jSONObject) throws Throwable {
                x xVarUj = a.this.uj();
                JSONObject jSONObject2 = new JSONObject();
                if (xVarUj == null) {
                    jSONObject2.put("code", -1);
                    return jSONObject2;
                }
                JSONObject jSONObjectTt = xVarUj.tt();
                jSONObjectTt.put("code", 1);
                return jSONObjectTt;
            }
        });
        this.ve.put("sendReward", new c() { // from class: com.byazt.zb.a.17
            @Override // com.byazt.zb.a.c
            public JSONObject c(JSONObject jSONObject) throws Throwable {
                x xVarUj = a.this.uj();
                JSONObject jSONObject2 = new JSONObject();
                if (xVarUj == null) {
                    jSONObject2.put("code", -1);
                    return jSONObject2;
                }
                xVarUj.rl();
                jSONObject2.put("code", 1);
                return jSONObject2;
            }
        });
        this.ve.put("webview_time_track", new c() { // from class: com.byazt.zb.a.18
            @Override // com.byazt.zb.a.c
            public JSONObject c(JSONObject jSONObject) throws Throwable {
                return new JSONObject();
            }
        });
        this.ve.put("playable_event", new c() { // from class: com.byazt.zb.a.19
            @Override // com.byazt.zb.a.c
            public JSONObject c(JSONObject jSONObject) throws Throwable {
                x xVarUj = a.this.uj();
                JSONObject jSONObject2 = new JSONObject();
                if (xVarUj == null || jSONObject == null) {
                    jSONObject2.put("code", -1);
                    return jSONObject2;
                }
                xVarUj.tt(jSONObject.optString("event", null), jSONObject.optJSONObject("params"));
                jSONObject2.put("code", 1);
                return jSONObject2;
            }
        });
        this.ve.put("reportAd", new c() { // from class: com.byazt.zb.a.20
            @Override // com.byazt.zb.a.c
            public JSONObject c(JSONObject jSONObject) throws Throwable {
                x xVarUj = a.this.uj();
                JSONObject jSONObject2 = new JSONObject();
                if (xVarUj == null) {
                    jSONObject2.put("code", -1);
                    return jSONObject2;
                }
                jSONObject2.put("code", 1);
                return jSONObject2;
            }
        });
        this.ve.put("close", new c() { // from class: com.byazt.zb.a.21
            @Override // com.byazt.zb.a.c
            public JSONObject c(JSONObject jSONObject) throws Throwable {
                x xVarUj = a.this.uj();
                JSONObject jSONObject2 = new JSONObject();
                if (xVarUj == null) {
                    jSONObject2.put("code", -1);
                    return jSONObject2;
                }
                jSONObject2.put("code", 1);
                return jSONObject2;
            }
        });
        this.ve.put("openAdLandPageLinks", new c() { // from class: com.byazt.zb.a.22
            @Override // com.byazt.zb.a.c
            public JSONObject c(JSONObject jSONObject) throws Throwable {
                x xVarUj = a.this.uj();
                JSONObject jSONObject2 = new JSONObject();
                if (xVarUj == null) {
                    jSONObject2.put("code", -1);
                    return jSONObject2;
                }
                jSONObject2.put("code", 1);
                return jSONObject2;
            }
        });
        this.ve.put("get_viewport", new c() { // from class: com.byazt.zb.a.24
            @Override // com.byazt.zb.a.c
            public JSONObject c(JSONObject jSONObject) throws Throwable {
                x xVarUj = a.this.uj();
                JSONObject jSONObject2 = new JSONObject();
                if (xVarUj == null) {
                    jSONObject2.put("code", -1);
                    return jSONObject2;
                }
                JSONObject jSONObjectGt = xVarUj.gt();
                jSONObjectGt.put("code", 1);
                return jSONObjectGt;
            }
        });
        this.ve.put("jssdk_load_finish", new c() { // from class: com.byazt.zb.a.25
            @Override // com.byazt.zb.a.c
            public JSONObject c(JSONObject jSONObject) throws Throwable {
                x xVarUj = a.this.uj();
                JSONObject jSONObject2 = new JSONObject();
                if (xVarUj == null) {
                    jSONObject2.put("code", -1);
                    return jSONObject2;
                }
                xVarUj.h();
                jSONObject2.put("code", 1);
                return jSONObject2;
            }
        });
        this.ve.put("playable_material_render_result", new c() { // from class: com.byazt.zb.a.26
            @Override // com.byazt.zb.a.c
            public JSONObject c(JSONObject jSONObject) throws Throwable {
                x xVarUj = a.this.uj();
                JSONObject jSONObject2 = new JSONObject();
                if (xVarUj == null) {
                    jSONObject2.put("code", -1);
                    return jSONObject2;
                }
                xVarUj.sl(jSONObject);
                jSONObject2.put("code", 1);
                return jSONObject2;
            }
        });
        this.ve.put("detect_change_playable_click", new c() { // from class: com.byazt.zb.a.27
            @Override // com.byazt.zb.a.c
            public JSONObject c(JSONObject jSONObject) throws Throwable {
                x xVarUj = a.this.uj();
                JSONObject jSONObject2 = new JSONObject();
                if (xVarUj == null) {
                    jSONObject2.put("code", -1);
                    return jSONObject2;
                }
                JSONObject jSONObjectI = xVarUj.i();
                jSONObjectI.put("code", 1);
                return jSONObjectI;
            }
        });
        this.ve.put("check_camera_permission", new c() { // from class: com.byazt.zb.a.28
            @Override // com.byazt.zb.a.c
            public JSONObject c(JSONObject jSONObject) throws Throwable {
                x xVarUj = a.this.uj();
                JSONObject jSONObject2 = new JSONObject();
                if (xVarUj == null) {
                    jSONObject2.put("code", -1);
                    return jSONObject2;
                }
                JSONObject jSONObjectT = xVarUj.t();
                jSONObjectT.put("code", 1);
                return jSONObjectT;
            }
        });
        this.ve.put("check_external_storage", new c() { // from class: com.byazt.zb.a.29
            @Override // com.byazt.zb.a.c
            public JSONObject c(JSONObject jSONObject) throws Throwable {
                x xVarUj = a.this.uj();
                JSONObject jSONObject2 = new JSONObject();
                if (xVarUj == null) {
                    jSONObject2.put("code", -1);
                    return jSONObject2;
                }
                JSONObject jSONObjectU = xVarUj.u();
                if (jSONObjectU.isNull("result")) {
                    jSONObjectU.put("code", -1);
                } else {
                    jSONObjectU.put("code", 1);
                }
                return jSONObjectU;
            }
        });
        this.ve.put("playable_open_camera", new c() { // from class: com.byazt.zb.a.30
            @Override // com.byazt.zb.a.c
            public JSONObject c(JSONObject jSONObject) throws Throwable {
                x xVarUj = a.this.uj();
                JSONObject jSONObject2 = new JSONObject();
                if (xVarUj == null) {
                    jSONObject2.put("code", -1);
                    return jSONObject2;
                }
                xVarUj.c(jSONObject);
                jSONObject2.put("code", 1);
                return jSONObject2;
            }
        });
        this.ve.put("playable_pick_photo", new c() { // from class: com.byazt.zb.a.31
            @Override // com.byazt.zb.a.c
            public JSONObject c(JSONObject jSONObject) throws Throwable {
                x xVarUj = a.this.uj();
                JSONObject jSONObject2 = new JSONObject();
                if (xVarUj == null) {
                    jSONObject2.put("code", -1);
                    return jSONObject2;
                }
                xVarUj.tt(jSONObject);
                jSONObject2.put("code", 1);
                return jSONObject2;
            }
        });
        this.ve.put("playable_download_media_in_photos", new c() { // from class: com.byazt.zb.a.32
            @Override // com.byazt.zb.a.c
            public JSONObject c(JSONObject jSONObject) throws Throwable {
                x xVarUj = a.this.uj();
                JSONObject jSONObject2 = new JSONObject();
                if (xVarUj == null) {
                    jSONObject2.put("code", -1);
                    return jSONObject2;
                }
                xVarUj.ve(jSONObject);
                jSONObject2.put("code", 1);
                return jSONObject2;
            }
        });
        this.ve.put("playable_preventTouchEvent", new c() { // from class: com.byazt.zb.a.33
            @Override // com.byazt.zb.a.c
            public JSONObject c(JSONObject jSONObject) throws Throwable {
                x xVarUj = a.this.uj();
                JSONObject jSONObject2 = new JSONObject();
                if (xVarUj == null) {
                    jSONObject2.put("code", -1);
                    return jSONObject2;
                }
                xVarUj.uj(jSONObject);
                jSONObject2.put("code", 1);
                return jSONObject2;
            }
        });
        this.ve.put("playable_settings_info", new c() { // from class: com.byazt.zb.a.35
            @Override // com.byazt.zb.a.c
            public JSONObject c(JSONObject jSONObject) throws Throwable {
                x xVarUj = a.this.uj();
                JSONObject jSONObject2 = new JSONObject();
                if (xVarUj == null) {
                    jSONObject2.put("code", -1);
                    return jSONObject2;
                }
                JSONObject jSONObjectYp = xVarUj.yp();
                jSONObjectYp.put("code", 1);
                return jSONObjectYp;
            }
        });
        this.ve.put("playable_load_main_scene", new c() { // from class: com.byazt.zb.a.36
            @Override // com.byazt.zb.a.c
            public JSONObject c(JSONObject jSONObject) throws Throwable {
                x xVarUj = a.this.uj();
                JSONObject jSONObject2 = new JSONObject();
                if (xVarUj == null) {
                    jSONObject2.put("code", -1);
                    return jSONObject2;
                }
                xVarUj.qy();
                jSONObject2.put("code", 1);
                return jSONObject2;
            }
        });
        this.ve.put("playable_enter_section", new c() { // from class: com.byazt.zb.a.37
            @Override // com.byazt.zb.a.c
            public JSONObject c(JSONObject jSONObject) throws Throwable {
                x xVarUj = a.this.uj();
                JSONObject jSONObject2 = new JSONObject();
                if (xVarUj == null) {
                    jSONObject2.put("code", -1);
                    return jSONObject2;
                }
                xVarUj.a(jSONObject);
                jSONObject2.put("code", 1);
                return jSONObject2;
            }
        });
        this.ve.put("playable_end", new c() { // from class: com.byazt.zb.a.38
            @Override // com.byazt.zb.a.c
            public JSONObject c(JSONObject jSONObject) throws Throwable {
                x xVarUj = a.this.uj();
                JSONObject jSONObject2 = new JSONObject();
                if (xVarUj == null) {
                    jSONObject2.put("code", -1);
                    return jSONObject2;
                }
                xVarUj.gu();
                jSONObject2.put("code", 1);
                return jSONObject2;
            }
        });
        this.ve.put("playable_finish_play_playable", new c() { // from class: com.byazt.zb.a.39
            @Override // com.byazt.zb.a.c
            public JSONObject c(JSONObject jSONObject) throws Throwable {
                x xVarUj = a.this.uj();
                JSONObject jSONObject2 = new JSONObject();
                if (xVarUj == null) {
                    jSONObject2.put("code", -1);
                    return jSONObject2;
                }
                xVarUj.gr();
                jSONObject2.put("code", 1);
                return jSONObject2;
            }
        });
        this.ve.put("playable_transfrom_module_show", new c() { // from class: com.byazt.zb.a.40
            @Override // com.byazt.zb.a.c
            public JSONObject c(JSONObject jSONObject) throws Throwable {
                x xVarUj = a.this.uj();
                JSONObject jSONObject2 = new JSONObject();
                if (xVarUj == null) {
                    jSONObject2.put("code", -1);
                    return jSONObject2;
                }
                xVarUj.zm();
                jSONObject2.put("code", 1);
                return jSONObject2;
            }
        });
        this.ve.put("playable_transfrom_module_change_color", new c() { // from class: com.byazt.zb.a.41
            @Override // com.byazt.zb.a.c
            public JSONObject c(JSONObject jSONObject) throws Throwable {
                x xVarUj = a.this.uj();
                JSONObject jSONObject2 = new JSONObject();
                if (xVarUj == null) {
                    jSONObject2.put("code", -1);
                    return jSONObject2;
                }
                xVarUj.yv();
                jSONObject2.put("code", 1);
                return jSONObject2;
            }
        });
        this.ve.put("playable_set_scroll_rect", new c() { // from class: com.byazt.zb.a.42
            @Override // com.byazt.zb.a.c
            public JSONObject c(JSONObject jSONObject) throws Throwable {
                x xVarUj = a.this.uj();
                JSONObject jSONObject2 = new JSONObject();
                if (xVarUj == null) {
                    jSONObject2.put("code", -1);
                    return jSONObject2;
                }
                jSONObject2.put("code", 1);
                return jSONObject2;
            }
        });
        this.ve.put("playable_click_area", new c() { // from class: com.byazt.zb.a.43
            @Override // com.byazt.zb.a.c
            public JSONObject c(JSONObject jSONObject) throws Throwable {
                x xVarUj = a.this.uj();
                JSONObject jSONObject2 = new JSONObject();
                if (xVarUj == null) {
                    jSONObject2.put("code", -1);
                    return jSONObject2;
                }
                xVarUj.sp(jSONObject);
                jSONObject2.put("code", 1);
                return jSONObject2;
            }
        });
        this.ve.put("playable_real_play_start", new c() { // from class: com.byazt.zb.a.44
            @Override // com.byazt.zb.a.c
            public JSONObject c(JSONObject jSONObject) throws Throwable {
                x xVarUj = a.this.uj();
                JSONObject jSONObject2 = new JSONObject();
                if (xVarUj == null) {
                    jSONObject2.put("code", -1);
                    return jSONObject2;
                }
                jSONObject2.put("code", 1);
                return jSONObject2;
            }
        });
        this.ve.put("playable_material_first_frame_show", new c() { // from class: com.byazt.zb.a.46
            @Override // com.byazt.zb.a.c
            public JSONObject c(JSONObject jSONObject) throws Throwable {
                x xVarUj = a.this.uj();
                JSONObject jSONObject2 = new JSONObject();
                if (xVarUj == null) {
                    jSONObject2.put("code", -1);
                    return jSONObject2;
                }
                xVarUj.p();
                jSONObject2.put("code", 1);
                return jSONObject2;
            }
        });
        this.ve.put("playable_stuck_check_pong", new c() { // from class: com.byazt.zb.a.47
            @Override // com.byazt.zb.a.c
            public JSONObject c(JSONObject jSONObject) throws Throwable {
                x xVarUj = a.this.uj();
                JSONObject jSONObject2 = new JSONObject();
                if (xVarUj == null) {
                    jSONObject2.put("code", -1);
                    return jSONObject2;
                }
                xVarUj.md();
                jSONObject2.put("code", 1);
                return jSONObject2;
            }
        });
        this.ve.put("playable_material_adnormal_mask", new c() { // from class: com.byazt.zb.a.48
            @Override // com.byazt.zb.a.c
            public JSONObject c(JSONObject jSONObject) throws Throwable {
                x xVarUj = a.this.uj();
                JSONObject jSONObject2 = new JSONObject();
                if (xVarUj == null) {
                    jSONObject2.put("code", -1);
                    return jSONObject2;
                }
                xVarUj.x(jSONObject);
                jSONObject2.put("code", 1);
                return jSONObject2;
            }
        });
        this.ve.put("playable_long_press_panel", new c() { // from class: com.byazt.zb.a.49
            @Override // com.byazt.zb.a.c
            public JSONObject c(JSONObject jSONObject) throws Throwable {
                x xVarUj = a.this.uj();
                JSONObject jSONObject2 = new JSONObject();
                if (xVarUj == null) {
                    jSONObject2.put("code", -1);
                    return jSONObject2;
                }
                jSONObject2.put("code", 1);
                return jSONObject2;
            }
        });
        this.ve.put("playable_alpha_player_play", new c() { // from class: com.byazt.zb.a.50
            @Override // com.byazt.zb.a.c
            public JSONObject c(JSONObject jSONObject) throws Throwable {
                x xVarUj = a.this.uj();
                JSONObject jSONObject2 = new JSONObject();
                if (xVarUj == null) {
                    jSONObject2.put("code", -1);
                    return jSONObject2;
                }
                jSONObject2.put("code", 1);
                return jSONObject2;
            }
        });
        this.ve.put("playable_transfrom_module_highlight", new c() { // from class: com.byazt.zb.a.51
            @Override // com.byazt.zb.a.c
            public JSONObject c(JSONObject jSONObject) throws Throwable {
                x xVarUj = a.this.uj();
                JSONObject jSONObject2 = new JSONObject();
                if (xVarUj == null) {
                    jSONObject2.put("code", -1);
                    return jSONObject2;
                }
                jSONObject2.put("code", 1);
                return jSONObject2;
            }
        });
        this.ve.put("playable_send_click_event", new c() { // from class: com.byazt.zb.a.52
            @Override // com.byazt.zb.a.c
            public JSONObject c(JSONObject jSONObject) throws Throwable {
                x xVarUj = a.this.uj();
                JSONObject jSONObject2 = new JSONObject();
                if (xVarUj == null) {
                    jSONObject2.put("code", -1);
                    return jSONObject2;
                }
                jSONObject2.put("code", 1);
                return jSONObject2;
            }
        });
        this.ve.put("playable_query_media_permission_declare", new c() { // from class: com.byazt.zb.a.53
            @Override // com.byazt.zb.a.c
            public JSONObject c(JSONObject jSONObject) throws Throwable {
                x xVarUj = a.this.uj();
                JSONObject jSONObject2 = new JSONObject();
                if (xVarUj == null) {
                    jSONObject2.put("code", -1);
                    return jSONObject2;
                }
                JSONObject jSONObjectI = xVarUj.i(jSONObject);
                jSONObjectI.put("code", 1);
                return jSONObjectI;
            }
        });
        this.ve.put("playable_query_media_permission_enable", new c() { // from class: com.byazt.zb.a.54
            @Override // com.byazt.zb.a.c
            public JSONObject c(JSONObject jSONObject) throws Throwable {
                x xVarUj = a.this.uj();
                JSONObject jSONObject2 = new JSONObject();
                if (xVarUj == null) {
                    jSONObject2.put("code", -1);
                    return jSONObject2;
                }
                JSONObject jSONObjectDa = xVarUj.da(jSONObject);
                jSONObjectDa.put("code", 1);
                return jSONObjectDa;
            }
        });
        this.ve.put("playable_apply_media_permission", new c() { // from class: com.byazt.zb.a.55
            @Override // com.byazt.zb.a.c
            public JSONObject c(JSONObject jSONObject) throws Throwable {
                com.byazt.zb.c cVarN = a.this.n();
                JSONObject jSONObject2 = new JSONObject();
                if (cVarN == null) {
                    jSONObject2.put("code", -1);
                    return jSONObject2;
                }
                jSONObject2.put("code", 1);
                return jSONObject2;
            }
        });
        this.ve.put("playable_start_kws", new c() { // from class: com.byazt.zb.a.57
            @Override // com.byazt.zb.a.c
            public JSONObject c(JSONObject jSONObject) throws Throwable {
                com.byazt.zb.c cVarN = a.this.n();
                JSONObject jSONObject2 = new JSONObject();
                if (cVarN == null) {
                    jSONObject2.put("code", -1);
                    return jSONObject2;
                }
                jSONObject2.put("code", 1);
                return jSONObject2;
            }
        });
        this.ve.put("playable_close_kws", new c() { // from class: com.byazt.zb.a.58
            @Override // com.byazt.zb.a.c
            public JSONObject c(JSONObject jSONObject) throws Throwable {
                com.byazt.zb.c cVarN = a.this.n();
                JSONObject jSONObject2 = new JSONObject();
                if (cVarN == null) {
                    jSONObject2.put("code", -1);
                    return jSONObject2;
                }
                jSONObject2.put("code", 1);
                return jSONObject2;
            }
        });
        this.ve.put("playable_video_preload_task_add", new c() { // from class: com.byazt.zb.a.59
            @Override // com.byazt.zb.a.c
            public JSONObject c(JSONObject jSONObject) throws Throwable {
                com.byazt.zb.c cVarN = a.this.n();
                JSONObject jSONObject2 = new JSONObject();
                if (cVarN == null) {
                    jSONObject2.put("code", -1);
                    return jSONObject2;
                }
                jSONObject2.put("code", 1);
                return jSONObject2;
            }
        });
        this.ve.put("playable_video_preload_task_cancel", new c() { // from class: com.byazt.zb.a.60
            @Override // com.byazt.zb.a.c
            public JSONObject c(JSONObject jSONObject) throws Throwable {
                com.byazt.zb.c cVarN = a.this.n();
                JSONObject jSONObject2 = new JSONObject();
                if (cVarN == null) {
                    jSONObject2.put("code", -1);
                    return jSONObject2;
                }
                jSONObject2.put("code", 1);
                return jSONObject2;
            }
        });
    }

    public Set<String> c() {
        return this.ve.keySet();
    }

    public void tt() {
        da.c(this.c, this.uj);
        da.c(this.c, this.n);
        da.c(this.c, this.f29231a);
        da.c(this.c, this.sp);
    }

    public JSONObject c(String str, JSONObject jSONObject) {
        try {
            c cVar = this.ve.get(str);
            if (cVar == null) {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("code", -1);
                return jSONObject2;
            }
            return cVar.c(jSONObject);
        } catch (Throwable th) {
            sp.c("PlayableJsBridge", "invoke error", th);
            return null;
        }
    }
}
