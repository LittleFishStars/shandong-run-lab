package com.alibaba.ariver.jsapi;

import com.alibaba.ariver.app.api.Page;
import com.alibaba.ariver.app.api.PageContext;
import com.alibaba.ariver.engine.api.bridge.extension.BridgeCallback;
import com.alibaba.ariver.engine.api.bridge.extension.BridgeResponse;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingCallback;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingNode;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingParam;
import com.alibaba.ariver.engine.api.embedview.IEmbedViewManager;
import com.alibaba.ariver.kernel.api.annotation.ActionFilter;
import com.alibaba.ariver.kernel.api.annotation.AutoCallback;
import com.alibaba.ariver.kernel.api.annotation.ThreadType;
import com.alibaba.ariver.kernel.api.extension.bridge.BridgeExtension;
import com.alibaba.ariver.kernel.api.security.Permission;
import com.alibaba.ariver.kernel.common.service.executor.ExecutorType;
import com.alibaba.fastjson.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class EmbedViewBridgeExtension implements BridgeExtension {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f24111a = "2.0";

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

    @ThreadType(ExecutorType.UI)
    @ActionFilter("NBComponent.remove")
    @AutoCallback
    public BridgeResponse remove(@BindingParam({"element"}) String str, @BindingParam({"version"}) String str2, @BindingCallback BridgeCallback bridgeCallback, @BindingNode(Page.class) Page page) {
        if ("2.0".equalsIgnoreCase(str2)) {
            return new BridgeResponse.Error(2, "cover-view is not supported!");
        }
        PageContext pageContext = page.getPageContext();
        if (pageContext == null) {
            return BridgeResponse.UNKNOWN_ERROR;
        }
        pageContext.getEmbedViewManager().destroyView(str);
        return BridgeResponse.SUCCESS;
    }

    @ThreadType(ExecutorType.UI)
    @ActionFilter("NBComponent.render")
    public void render(@BindingParam({"element"}) String str, @BindingParam({"props"}) JSONObject jSONObject, @BindingParam({"data"}) JSONObject jSONObject2, @BindingParam({"version"}) String str2, @BindingCallback BridgeCallback bridgeCallback, @BindingNode(Page.class) Page page) {
        if ("2.0".equalsIgnoreCase(str2)) {
            bridgeCallback.sendBridgeResponse(new BridgeResponse.Error(2, "cover-view is not supported!"));
            return;
        }
        PageContext pageContext = page.getPageContext();
        if (pageContext == null) {
            bridgeCallback.sendBridgeResponse(BridgeResponse.UNKNOWN_ERROR);
            return;
        }
        IEmbedViewManager embedViewManager = pageContext.getEmbedViewManager();
        if (embedViewManager == null) {
            bridgeCallback.sendBridgeResponse(BridgeResponse.UNKNOWN_ERROR);
            return;
        }
        if (jSONObject != null && !jSONObject.isEmpty()) {
            if (jSONObject2 == null) {
                jSONObject2 = new JSONObject();
            }
            jSONObject2.putAll(jSONObject);
        }
        jSONObject2.put("element", (Object) str);
        embedViewManager.dispatchRender(str, jSONObject2, bridgeCallback);
    }

    @ThreadType(ExecutorType.UI)
    @ActionFilter("NBComponent.sendMessage")
    public void sendMessage(@BindingParam({"element"}) String str, @BindingParam({"actionType"}) String str2, @BindingParam({"data"}) JSONObject jSONObject, @BindingParam({"version"}) String str3, @BindingCallback BridgeCallback bridgeCallback, @BindingNode(Page.class) Page page) {
        if ("2.0".equalsIgnoreCase(str3)) {
            bridgeCallback.sendBridgeResponse(new BridgeResponse.Error(2, "cover-view is not supported!"));
            return;
        }
        PageContext pageContext = page.getPageContext();
        if (pageContext == null) {
            bridgeCallback.sendBridgeResponse(BridgeResponse.UNKNOWN_ERROR);
            return;
        }
        IEmbedViewManager embedViewManager = pageContext.getEmbedViewManager();
        if (embedViewManager == null) {
            bridgeCallback.sendBridgeResponse(BridgeResponse.UNKNOWN_ERROR);
        } else {
            embedViewManager.dispatchSendMessage(str, str2, jSONObject, bridgeCallback);
        }
    }
}
