package com.alibaba.triver.basic.api;

import android.app.Activity;
import android.util.DisplayMetrics;
import com.alibaba.ariver.app.api.App;
import com.alibaba.ariver.commonability.device.jsapi.system.SystemInfoBridgeExtension;
import com.alibaba.ariver.engine.api.Render;
import com.alibaba.ariver.engine.api.bridge.extension.BridgeCallback;
import com.alibaba.ariver.engine.api.bridge.extension.BridgeResponse;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingApiContext;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingCallback;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingNode;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingParam;
import com.alibaba.ariver.engine.api.bridge.model.ApiContext;
import com.alibaba.ariver.kernel.api.annotation.ActionFilter;
import com.alibaba.ariver.kernel.api.annotation.ThreadType;
import com.alibaba.ariver.kernel.api.extension.ExtensionPoint;
import com.alibaba.ariver.kernel.common.service.executor.ExecutorType;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.ariver.v8worker.JSApiCachePoint;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.triver.kit.api.orange.TROrangeController;
import com.alibaba.triver.kit.api.utils.TRiverUrlUtils;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class TriverSystemInfoBridgeExtension extends SystemInfoBridgeExtension {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f24684a = "TriverSystemInfoBridgeExtension";

    private static int a(Render render) {
        if (render == null || render.getView() == null) {
            return 0;
        }
        return render.getView().getHeight();
    }

    public static void processShopWindowHeight(ApiContext apiContext, JSONObject jSONObject) {
        Render render;
        if (jSONObject == null) {
            return;
        }
        try {
            jSONObject.put("ignoreContainerPV", (Object) Boolean.TRUE);
            if (apiContext == null || (render = apiContext.getRender()) == null) {
                return;
            }
            int iA = a(render);
            Activity activity = render.getActivity();
            DisplayMetrics displayMetrics = new DisplayMetrics();
            activity.getWindowManager().getDefaultDisplay().getRealMetrics(displayMetrics);
            if (iA <= 0) {
                iA = displayMetrics.heightPixels;
            }
            jSONObject.put("screenHeight", (Object) Integer.valueOf(iA));
            jSONObject.put("screenWidth", (Object) Integer.valueOf(displayMetrics.widthPixels));
            jSONObject.put("pixelRatio", (Object) Float.valueOf(displayMetrics.density));
            jSONObject.put("windowHeight", (Object) Integer.valueOf(Math.round(iA / displayMetrics.density)));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @ThreadType(ExecutorType.URGENT)
    @ActionFilter
    public void getSystemInfo(@BindingApiContext final ApiContext apiContext, @BindingNode(App.class) final App app, @BindingCallback final BridgeCallback bridgeCallback, @BindingParam(booleanDefault = true, value = {"needCache"}) boolean z) {
        JSONObject jsapiCacheData;
        RVLogger.e(f24684a, "call getSystemInfo");
        JSApiCachePoint jSApiCachePoint = (JSApiCachePoint) ExtensionPoint.as(JSApiCachePoint.class).node(app).create();
        if (jSApiCachePoint != null) {
            jsapiCacheData = jSApiCachePoint.getJsapiCacheData(app.getAppId(), JSApiCachePoint.GET_SYSTEM_INFO, app);
            if (jsapiCacheData != null && jsapiCacheData.size() > 0 && TRiverUrlUtils.isShop(app)) {
                processShopWindowHeight(apiContext, jsapiCacheData);
            }
        } else {
            jsapiCacheData = null;
        }
        if (jsapiCacheData == null || jsapiCacheData.size() <= 0 || !TROrangeController.useNewSystemInfo()) {
            super.getSystemInfo(apiContext, app, new BridgeCallback() { // from class: com.alibaba.triver.basic.api.TriverSystemInfoBridgeExtension.1
                @Override // com.alibaba.ariver.engine.api.bridge.extension.BridgeCallback
                public void sendBridgeResponse(BridgeResponse bridgeResponse) {
                    bridgeCallback.sendBridgeResponse(bridgeResponse);
                }

                @Override // com.alibaba.ariver.engine.api.bridge.extension.BridgeCallback
                public void sendJSONResponse(JSONObject jSONObject, boolean z2) {
                    if (TRiverUrlUtils.isShop(app)) {
                        TriverSystemInfoBridgeExtension.processShopWindowHeight(apiContext, jSONObject);
                    }
                    bridgeCallback.sendJSONResponse(jSONObject, z2);
                }

                @Override // com.alibaba.ariver.engine.api.bridge.extension.BridgeCallback
                public void sendJSONResponse(JSONObject jSONObject) {
                    if (TRiverUrlUtils.isShop(app)) {
                        TriverSystemInfoBridgeExtension.processShopWindowHeight(apiContext, jSONObject);
                    }
                    bridgeCallback.sendJSONResponse(jSONObject);
                }
            }, z);
        } else {
            bridgeCallback.sendJSONResponse(jsapiCacheData);
        }
    }
}
