package com.alibaba.ariver.commonability.device.jsapi.clipboard;

import android.text.ClipboardManager;
import android.text.TextUtils;
import com.alibaba.ariver.commonability.core.util.b;
import com.alibaba.ariver.commonability.device.proxy.RVCommonAbilityProxy;
import com.alibaba.ariver.engine.api.bridge.extension.BridgeCallback;
import com.alibaba.ariver.engine.api.bridge.extension.BridgeResponse;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingApiContext;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingCallback;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingParam;
import com.alibaba.ariver.engine.api.bridge.model.ApiContext;
import com.alibaba.ariver.kernel.api.annotation.ActionFilter;
import com.alibaba.ariver.kernel.api.annotation.Remote;
import com.alibaba.ariver.kernel.api.annotation.ThreadType;
import com.alibaba.ariver.kernel.api.extension.bridge.BridgeExtension;
import com.alibaba.ariver.kernel.api.security.Permission;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.service.RVEnvironmentService;
import com.alibaba.ariver.kernel.common.service.executor.ExecutorType;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.fastjson.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class ClipboardBridgeExtension implements BridgeExtension {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f23954a = "ClipboardBridgeExtension";
    private static final String b = "text";
    private static final String c = "source";

    @Remote
    @ThreadType(ExecutorType.UI)
    @ActionFilter
    public void getClipboard(@BindingParam(stringDefault = "tinyapp", value = {"source"}) String str, @BindingApiContext ApiContext apiContext, @BindingCallback final BridgeCallback bridgeCallback) {
        CharSequence text;
        RVEnvironmentService rVEnvironmentService = (RVEnvironmentService) RVProxy.get(RVEnvironmentService.class);
        if (rVEnvironmentService == null) {
            bridgeCallback.sendBridgeResponse(BridgeResponse.UNKNOWN_ERROR);
            return;
        }
        RVClipboardProxy rVClipboardProxy = (RVClipboardProxy) RVProxy.get(RVClipboardProxy.class);
        if (rVClipboardProxy != null && b.a("ta_use_aclipboard", true)) {
            rVClipboardProxy.getText(str, new RVClipboardProxy.a<String>() { // from class: com.alibaba.ariver.commonability.device.jsapi.clipboard.ClipboardBridgeExtension.2
                @Override // com.alibaba.ariver.commonability.device.jsapi.clipboard.RVClipboardProxy.a
                public void a(String str2) {
                    if (str2 == null) {
                        bridgeCallback.sendBridgeResponse(BridgeResponse.newError(60000, "系统禁止获取剪贴板内容"));
                        return;
                    }
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("text", (Object) str2);
                    bridgeCallback.sendJSONResponse(jSONObject);
                }
            });
            return;
        }
        try {
            text = ((ClipboardManager) rVEnvironmentService.getApplicationContext().getSystemService("clipboard")).getText();
        } catch (Throwable th) {
            RVLogger.e(f23954a, th);
            text = null;
        }
        String string = text != null ? text.toString() : "";
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("text", (Object) string);
        bridgeCallback.sendBridgeResponse(new BridgeResponse(jSONObject));
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

    @Remote
    @ThreadType(ExecutorType.UI)
    @ActionFilter
    public void setClipboard(@BindingParam(stringDefault = "", value = {"text"}) String str, @BindingApiContext ApiContext apiContext, @BindingParam(stringDefault = "tinyapp", value = {"source"}) String str2, @BindingCallback final BridgeCallback bridgeCallback) {
        if (TextUtils.isEmpty(str)) {
            bridgeCallback.sendBridgeResponse(BridgeResponse.INVALID_PARAM);
            return;
        }
        RVCommonAbilityProxy rVCommonAbilityProxy = (RVCommonAbilityProxy) RVProxy.get(RVCommonAbilityProxy.class);
        if (rVCommonAbilityProxy != null && rVCommonAbilityProxy.getClipboardTextHandler() != null && TextUtils.equals(str2, "tinyapp")) {
            str = rVCommonAbilityProxy.getClipboardTextHandler().a(str);
        }
        RVClipboardProxy rVClipboardProxy = (RVClipboardProxy) RVProxy.get(RVClipboardProxy.class);
        if (rVClipboardProxy != null && b.a("ta_use_aclipboard", true)) {
            rVClipboardProxy.setText(str2, str, new RVClipboardProxy.a<Boolean>() { // from class: com.alibaba.ariver.commonability.device.jsapi.clipboard.ClipboardBridgeExtension.1
                @Override // com.alibaba.ariver.commonability.device.jsapi.clipboard.RVClipboardProxy.a
                public void a(Boolean bool) {
                    if (bool.booleanValue()) {
                        bridgeCallback.sendBridgeResponse(BridgeResponse.SUCCESS);
                    } else {
                        bridgeCallback.sendBridgeResponse(BridgeResponse.newError(60001, "系统禁止写入剪贴板"));
                    }
                }
            });
            return;
        }
        RVEnvironmentService rVEnvironmentService = (RVEnvironmentService) RVProxy.get(RVEnvironmentService.class);
        if (rVEnvironmentService == null) {
            bridgeCallback.sendBridgeResponse(BridgeResponse.UNKNOWN_ERROR);
        } else {
            ((ClipboardManager) rVEnvironmentService.getApplicationContext().getSystemService("clipboard")).setText(str);
            bridgeCallback.sendBridgeResponse(BridgeResponse.SUCCESS);
        }
    }
}
