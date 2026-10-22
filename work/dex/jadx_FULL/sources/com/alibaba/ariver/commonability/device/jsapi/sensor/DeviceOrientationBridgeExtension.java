package com.alibaba.ariver.commonability.device.jsapi.sensor;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import com.alibaba.ariver.app.api.App;
import com.alibaba.ariver.engine.api.EngineUtils;
import com.alibaba.ariver.engine.api.bridge.extension.BridgeResponse;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingNode;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingParam;
import com.alibaba.ariver.kernel.api.annotation.ActionFilter;
import com.alibaba.ariver.kernel.api.annotation.AutoCallback;
import com.alibaba.ariver.kernel.api.annotation.ThreadType;
import com.alibaba.ariver.kernel.api.extension.bridge.BridgeExtension;
import com.alibaba.ariver.kernel.api.security.Permission;
import com.alibaba.ariver.kernel.common.service.executor.ExecutorType;
import com.alibaba.fastjson.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class DeviceOrientationBridgeExtension implements SensorEventListener, BridgeExtension {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private SensorManager f23974a;
    private float[] b;
    private float[] c;
    private boolean d = false;
    private App e;
    private long f;
    private long g;

    @Override // android.hardware.SensorEventListener
    public void onAccuracyChanged(Sensor sensor, int i) {
    }

    @Override // com.alibaba.ariver.kernel.api.extension.Extension
    public void onFinalized() {
        this.e = null;
        if (this.f23974a != null && this.d) {
            this.d = false;
        }
    }

    @Override // com.alibaba.ariver.kernel.api.extension.Extension
    public void onInitialized() {
    }

    @Override // android.hardware.SensorEventListener
    public void onSensorChanged(SensorEvent sensorEvent) {
        float[] fArr;
        Sensor sensor = sensorEvent.sensor;
        if (sensor == null || sensor.getType() != 1) {
            Sensor sensor2 = sensorEvent.sensor;
            if (sensor2 != null && sensor2.getType() == 2) {
                this.c = sensorEvent.values;
            }
        } else {
            this.b = sensorEvent.values;
        }
        float[] fArr2 = this.b;
        if (fArr2 == null || (fArr = this.c) == null) {
            return;
        }
        float[] fArr3 = new float[3];
        float[] fArr4 = new float[9];
        SensorManager.getRotationMatrix(fArr4, null, fArr2, fArr);
        SensorManager.getOrientation(fArr4, fArr3);
        double d = ((double) fArr3[0]) + 3.141592653589793d;
        float f = fArr3[1];
        float f2 = fArr3[2];
        if (System.currentTimeMillis() - this.f < this.g) {
            return;
        }
        this.f = System.currentTimeMillis();
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("alpha", (Object) Double.valueOf(d));
        jSONObject.put("beta", (Object) Float.valueOf(f));
        jSONObject.put("gamma", (Object) Float.valueOf(f2));
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("data", (Object) jSONObject);
        App app = this.e;
        if (app == null || app.getActivePage() == null) {
            return;
        }
        EngineUtils.sendToRender(this.e.getActivePage().getRender(), "deviceMotionChange", jSONObject2, null);
    }

    @Override // com.alibaba.ariver.kernel.api.security.Guard
    public Permission permit() {
        return null;
    }

    @ThreadType(ExecutorType.NORMAL)
    @ActionFilter
    @AutoCallback
    public BridgeResponse startDeviceMotionListening(@BindingNode(App.class) App app, @BindingParam(stringDefault = "ui", value = {"interval"}) String str, @BindingParam({"monitorInterval"}) int i) {
        this.e = app;
        return BridgeResponse.SUCCESS;
    }

    @ThreadType(ExecutorType.NORMAL)
    @ActionFilter
    @AutoCallback
    public BridgeResponse stopDeviceMotionListening() {
        if (this.f23974a == null) {
            return new BridgeResponse.Error(1001, "当前系统不支持相关能力");
        }
        this.g = 0L;
        if (!this.d) {
            return new BridgeResponse.Error(10000, "设备方向监听未开启");
        }
        this.d = false;
        return new BridgeResponse.NamedValue("success", Boolean.TRUE);
    }
}
