package com.alibaba.ariver.jsapi.engine;

import android.text.TextPaint;
import android.text.TextUtils;
import com.alibaba.ariver.app.api.Page;
import com.alibaba.ariver.engine.api.bridge.extension.BridgeResponse;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingApiContext;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingNode;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingParam;
import com.alibaba.ariver.engine.api.bridge.model.ApiContext;
import com.alibaba.ariver.kernel.api.annotation.ActionFilter;
import com.alibaba.ariver.kernel.api.annotation.AutoCallback;
import com.alibaba.ariver.kernel.api.annotation.ThreadType;
import com.alibaba.ariver.kernel.api.extension.ExtensionManager;
import com.alibaba.ariver.kernel.api.extension.bridge.BridgeExtension;
import com.alibaba.ariver.kernel.api.security.Permission;
import com.alibaba.ariver.kernel.common.service.executor.ExecutorType;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.fastjson.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class EngineBridgeExtension implements BridgeExtension {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f24143a = "AriverAPI:EngineBridgeExtension";

    @ActionFilter
    @AutoCallback
    public JSONObject checkJSAPI(@BindingNode(Page.class) Page page, @BindingParam({"api"}) String str) {
        boolean zIsJsApiAvailable = isJsApiAvailable(page, str);
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("available", (Object) Boolean.valueOf(zIsJsApiAvailable));
        return jSONObject;
    }

    @ThreadType(ExecutorType.UI)
    @ActionFilter
    @AutoCallback
    public BridgeResponse h5PageReload(@BindingApiContext ApiContext apiContext) {
        apiContext.getRender().reload();
        return BridgeResponse.SUCCESS;
    }

    public boolean isJsApiAvailable(Page page, String str) {
        ExtensionManager extensionManager = page.getExtensionManager();
        return (extensionManager == null || extensionManager.findActionMeta(page, str) == null) ? false : true;
    }

    @ActionFilter
    @AutoCallback
    public BridgeResponse measureText(@BindingParam(floatDefault = 10.0f, name = {"fontSize"}) float f, @BindingParam({"fontWeight"}) String str, @BindingParam(name = {"text"}, required = true) String str2) {
        try {
            TextPaint textPaint = new TextPaint();
            textPaint.setTextSize(f);
            textPaint.setFakeBoldText(!TextUtils.isEmpty(str) && "bold".equals(str));
            return BridgeResponse.newValue("width", Float.valueOf(textPaint.measureText(str2, 0, str2.length())));
        } catch (Throwable th) {
            RVLogger.e(f24143a, "measureText exception!", th);
            return BridgeResponse.UNKNOWN_ERROR;
        }
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
}
