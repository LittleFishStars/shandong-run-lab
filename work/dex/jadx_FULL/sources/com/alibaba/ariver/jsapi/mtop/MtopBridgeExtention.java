package com.alibaba.ariver.jsapi.mtop;

import android.os.Bundle;
import android.text.TextUtils;
import com.alibaba.ariver.app.api.App;
import com.alibaba.ariver.app.api.mtop.IMtopProxy;
import com.alibaba.ariver.app.api.mtop.SendMtopParams;
import com.alibaba.ariver.app.api.mtop.SendMtopResponse;
import com.alibaba.ariver.engine.api.bridge.extension.BridgeCallback;
import com.alibaba.ariver.engine.api.bridge.extension.BridgeResponse;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingApiContext;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingCallback;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingNode;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingParam;
import com.alibaba.ariver.engine.api.bridge.model.ApiContext;
import com.alibaba.ariver.engine.api.bridge.model.SendToNativeCallback;
import com.alibaba.ariver.kernel.api.annotation.ActionFilter;
import com.alibaba.ariver.kernel.api.annotation.ThreadType;
import com.alibaba.ariver.kernel.api.extension.ExtensionPoint;
import com.alibaba.ariver.kernel.api.extension.bridge.BridgeExtension;
import com.alibaba.ariver.kernel.api.security.Permission;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.service.executor.ExecutorType;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.ariver.permission.api.extension.OfficialAppPoint;
import com.alibaba.ariver.resource.api.models.AppInfoScene;
import com.alibaba.ariver.resource.api.models.AppModel;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alipay.sdk.m.o.b;
import java.nio.charset.Charset;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class MtopBridgeExtention implements BridgeExtension {
    public static void callback(BridgeCallback bridgeCallback, SendMtopResponse sendMtopResponse) {
        JSONObject jSONObject = new JSONObject();
        if (sendMtopResponse != null) {
            try {
                if (!sendMtopResponse.success) {
                    jSONObject.put("error", TextUtils.isDigitsOnly(sendMtopResponse.errorCode) ? sendMtopResponse.errorCode : 3);
                    jSONObject.put("errorCode", (Object) sendMtopResponse.errorCode);
                    jSONObject.put("message", (Object) sendMtopResponse.errorMsg);
                    jSONObject.put(SendToNativeCallback.KEY_MESSAGE, (Object) sendMtopResponse.errorMsg);
                }
                byte[] bArr = sendMtopResponse.data;
                if (bArr != null && bArr.length > 0) {
                    String str = new String(bArr, Charset.forName("UTF-8"));
                    if (!TextUtils.isEmpty(str)) {
                        jSONObject.putAll(JSON.parseObject(str));
                        jSONObject.put("success", (Object) Boolean.valueOf(sendMtopResponse.success));
                    }
                }
            } catch (Exception e) {
                jSONObject.put("message", (Object) e.getMessage());
                jSONObject.put(SendToNativeCallback.KEY_MESSAGE, (Object) e.getMessage());
                jSONObject.put("errorCode", (Object) 6);
                jSONObject.put("error", (Object) 6);
            }
        } else {
            bridgeCallback.sendBridgeResponse(BridgeResponse.UNKNOWN_ERROR);
        }
        bridgeCallback.sendJSONResponse(jSONObject);
    }

    @Override // com.alibaba.ariver.kernel.api.extension.Extension
    public void onFinalized() {
    }

    @Override // com.alibaba.ariver.kernel.api.extension.Extension
    public void onInitialized() {
    }

    @Override // com.alibaba.ariver.kernel.api.security.Guard
    public Permission permit() {
        return null;
    }

    @ThreadType(ExecutorType.NETWORK)
    @ActionFilter
    public void sendMtop(@BindingParam(required = true, value = {"api", "apiName"}) final String str, @BindingParam({"v"}) String str2, @BindingParam({"needLogin"}) Boolean bool, @BindingParam(stringDefault = "AutoLoginAndManualLogin", value = {"sessionOption"}) String str3, @BindingParam(stringDefault = "GET", value = {"method"}) String str4, @BindingParam(stringDefault = "originaljson", value = {"dataType"}) String str5, @BindingParam({"secType"}) int i, @BindingParam({"data"}) JSONObject jSONObject, @BindingParam({"ext_headers"}) JSONObject jSONObject2, @BindingParam({"ext_querys"}) JSONObject jSONObject3, @BindingParam(intDefault = 20000, value = {b.r0}) int i2, @BindingParam({"ttid"}) String str6, @BindingParam({"pageUrl"}) String str7, @BindingParam({"x-ua"}) String str8, @BindingParam({"mpHost"}) String str9, @BindingParam({"accountSite"}) String str10, @BindingNode(App.class) App app, @BindingApiContext ApiContext apiContext, @BindingCallback final BridgeCallback bridgeCallback) {
        final long jCurrentTimeMillis = System.currentTimeMillis();
        AppModel appModel = (AppModel) app.getData(AppModel.class);
        SendMtopParams sendMtopParams = new SendMtopParams(apiContext.getAppId(), app.getStartParams());
        sendMtopParams.api = str;
        sendMtopParams.v = str2;
        sendMtopParams.forceLogin = bool;
        boolean z = false;
        sendMtopParams.needLogin = bool != null ? bool.booleanValue() : false;
        if (!((OfficialAppPoint) ExtensionPoint.as(OfficialAppPoint.class).node(app).create()).isOfficial(apiContext.getPluginId()) && a.a(app, appModel, apiContext.getPluginId())) {
            z = true;
        }
        sendMtopParams.needAuth = z;
        sendMtopParams.ignoreAuth = a.a(appModel, apiContext.getPluginId(), str);
        sendMtopParams.sessionOption = str3;
        sendMtopParams.dataType = str5;
        sendMtopParams.method = str4;
        sendMtopParams.ttid = str6;
        sendMtopParams.wuaFlag = i;
        sendMtopParams.timer = i2;
        sendMtopParams.userAgent = str8;
        sendMtopParams.pageUrl = str7;
        sendMtopParams.accountSite = str10;
        sendMtopParams.mpHost = str9;
        if (jSONObject != null) {
            for (String str11 : jSONObject.keySet()) {
                Object obj = jSONObject.get(str11);
                if (obj != null) {
                    sendMtopParams.addData(str11, obj.toString());
                }
            }
        }
        if (jSONObject2 != null) {
            for (String str12 : jSONObject2.keySet()) {
                Object obj2 = jSONObject2.get(str12);
                if (obj2 != null) {
                    sendMtopParams.addHeader(str12, obj2.toString());
                }
            }
        }
        if (jSONObject3 != null) {
            for (String str13 : jSONObject3.keySet()) {
                Object obj3 = jSONObject3.get(str13);
                if (obj3 != null) {
                    sendMtopParams.addParameterMap(str13, obj3.toString());
                }
            }
        }
        Bundle startParams = app.getStartParams();
        if (startParams != null) {
            String string = startParams.getString(AppInfoScene.PARAM_SCENE);
            String string2 = startParams.getString(AppInfoScene.PARAM_SOURCE);
            if (TextUtils.isEmpty(string) && TextUtils.isEmpty(string2)) {
                string = AppInfoScene.ONLINE.name();
                string2 = "online";
            }
            JSONObject jSONObject4 = new JSONObject();
            jSONObject4.put(AppInfoScene.PARAM_SCENE, (Object) string);
            jSONObject4.put(AppInfoScene.PARAM_SOURCE, (Object) string2);
            sendMtopParams.addHeader(a.h, jSONObject4.toJSONString());
        }
        sendMtopParams.setHeaders(a.a(app, appModel, apiContext));
        sendMtopParams.addExtraDara("pluginId", apiContext.getPluginId());
        IMtopProxy iMtopProxy = (IMtopProxy) RVProxy.get(IMtopProxy.class);
        if (iMtopProxy != null) {
            iMtopProxy.requestAsync(app, sendMtopParams, new IMtopProxy.Callback() { // from class: com.alibaba.ariver.jsapi.mtop.MtopBridgeExtention.1
                @Override // com.alibaba.ariver.app.api.mtop.IMtopProxy.Callback
                public void onResult(SendMtopResponse sendMtopResponse) {
                    RVLogger.d("AriverSendMtop", "sendMtop " + str + " cost:" + (System.currentTimeMillis() - jCurrentTimeMillis) + "ms");
                    MtopBridgeExtention.callback(bridgeCallback, sendMtopResponse);
                }
            });
        } else {
            callback(bridgeCallback, null);
        }
    }
}
