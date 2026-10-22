package com.alibaba.ariver.commonability.device.jsapi.sensor;

import com.alibaba.ariver.app.api.Page;
import com.alibaba.ariver.engine.api.EngineUtils;
import com.alibaba.ariver.engine.api.bridge.extension.BridgeCallback;
import com.alibaba.ariver.engine.api.bridge.extension.BridgeResponse;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingCallback;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingNode;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingRequest;
import com.alibaba.ariver.kernel.api.annotation.ActionFilter;
import com.alibaba.ariver.kernel.api.annotation.ThreadType;
import com.alibaba.ariver.kernel.api.extension.bridge.BridgeExtension;
import com.alibaba.ariver.kernel.api.security.Permission;
import com.alibaba.ariver.kernel.common.service.executor.ExecutorType;
import com.alibaba.fastjson.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class SensorBridgeExtension implements BridgeExtension {
    public static final String ON_GYROSCOPE_CHANGE = "gyroscopeChange";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f23975a = "compassChange";
    private static final String b = "accelerometerChange";
    private a c;

    private void a(JSONObject jSONObject, Page page, final BridgeCallback bridgeCallback) {
        this.c.a(-10, page.getPageContext().getActivity(), jSONObject).a(new com.alibaba.ariver.commonability.core.a.a() { // from class: com.alibaba.ariver.commonability.device.jsapi.sensor.SensorBridgeExtension.1
            @Override // com.alibaba.ariver.commonability.core.a.a
            public void a(JSONObject jSONObject2, int i) {
                bridgeCallback.sendBridgeResponse(BridgeResponse.SUCCESS);
                SensorBridgeExtension.this.c.a(-10);
            }
        });
    }

    private void b(boolean z, final Page page, JSONObject jSONObject) {
        if (z) {
            this.c.a(2, page.getPageContext().getActivity(), jSONObject).a(new com.alibaba.ariver.commonability.core.a.a() { // from class: com.alibaba.ariver.commonability.device.jsapi.sensor.SensorBridgeExtension.3
                @Override // com.alibaba.ariver.commonability.core.a.a
                public void a(JSONObject jSONObject2, int i) {
                    JSONObject jSONObject3 = new JSONObject();
                    jSONObject3.put("data", (Object) jSONObject2);
                    EngineUtils.sendToRender(page.getRender(), SensorBridgeExtension.f23975a, jSONObject3, null);
                }
            });
        } else {
            this.c.a(2);
        }
    }

    private void c(boolean z, final Page page, JSONObject jSONObject) {
        if (z) {
            this.c.a(4, page.getPageContext().getActivity(), jSONObject).a(new com.alibaba.ariver.commonability.core.a.a() { // from class: com.alibaba.ariver.commonability.device.jsapi.sensor.SensorBridgeExtension.4
                @Override // com.alibaba.ariver.commonability.core.a.a
                public void a(JSONObject jSONObject2, int i) {
                    JSONObject jSONObject3 = new JSONObject();
                    jSONObject3.put("data", (Object) jSONObject2);
                    EngineUtils.sendToRender(page.getRender(), SensorBridgeExtension.ON_GYROSCOPE_CHANGE, jSONObject3, null);
                }
            });
        } else {
            this.c.a(4);
        }
    }

    @Override // com.alibaba.ariver.kernel.api.extension.Extension
    public void onFinalized() {
        this.c.c();
    }

    @Override // com.alibaba.ariver.kernel.api.extension.Extension
    public void onInitialized() {
        this.c = new a();
    }

    @Override // com.alibaba.ariver.kernel.api.security.Guard
    public Permission permit() {
        return null;
    }

    @ThreadType(ExecutorType.UI)
    @ActionFilter
    public void watchShake(@BindingNode(Page.class) Page page, @BindingRequest JSONObject jSONObject, @BindingCallback BridgeCallback bridgeCallback) {
        if (jSONObject.containsKey("monitorAccelerometer")) {
            a(jSONObject.getBoolean("monitorAccelerometer").booleanValue(), page, jSONObject);
            bridgeCallback.sendBridgeResponse(BridgeResponse.SUCCESS);
        } else if (jSONObject.containsKey("monitorCompass")) {
            b(jSONObject.getBoolean("monitorCompass").booleanValue(), page, jSONObject);
            bridgeCallback.sendBridgeResponse(BridgeResponse.SUCCESS);
        } else if (!jSONObject.containsKey("monitorGyroscope")) {
            a(jSONObject, page, bridgeCallback);
        } else {
            c(jSONObject.getBoolean("monitorGyroscope").booleanValue(), page, jSONObject);
            bridgeCallback.sendBridgeResponse(BridgeResponse.SUCCESS);
        }
    }

    private void a(boolean z, final Page page, JSONObject jSONObject) {
        if (z) {
            this.c.a(1, page.getPageContext().getActivity(), jSONObject).a(new com.alibaba.ariver.commonability.core.a.a() { // from class: com.alibaba.ariver.commonability.device.jsapi.sensor.SensorBridgeExtension.2
                @Override // com.alibaba.ariver.commonability.core.a.a
                public void a(JSONObject jSONObject2, int i) {
                    JSONObject jSONObject3 = new JSONObject();
                    jSONObject3.put("data", (Object) jSONObject2);
                    EngineUtils.sendToRender(page.getRender(), SensorBridgeExtension.b, jSONObject3, null);
                }
            });
        } else {
            this.c.a(1);
        }
    }
}
