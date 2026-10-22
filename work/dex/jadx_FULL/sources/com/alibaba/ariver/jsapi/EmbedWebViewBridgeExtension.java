package com.alibaba.ariver.jsapi;

import android.text.TextUtils;
import com.alibaba.alibcprotocol.base.AlibcProtocolConstant;
import com.alibaba.ariver.app.api.Page;
import com.alibaba.ariver.engine.api.bridge.extension.BridgeResponse;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingNode;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingRequest;
import com.alibaba.ariver.engine.api.bridge.model.RenderCallContext;
import com.alibaba.ariver.engine.api.embedview.IEmbedView;
import com.alibaba.ariver.kernel.RVConstants;
import com.alibaba.ariver.kernel.RVEvents;
import com.alibaba.ariver.kernel.api.annotation.ActionFilter;
import com.alibaba.ariver.kernel.api.annotation.AutoCallback;
import com.alibaba.ariver.kernel.api.extension.bridge.BridgeExtension;
import com.alibaba.ariver.kernel.api.security.Permission;
import com.alibaba.ariver.kernel.common.utils.BundleUtils;
import com.alibaba.ariver.kernel.common.utils.JSONUtils;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.fastjson.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class EmbedWebViewBridgeExtension implements BridgeExtension {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f24112a = "AriverAPI:EmbedWebViewBridgeExtension";
    private static final String b = "message";

    @ActionFilter
    @AutoCallback
    public JSONObject getEmbedWebViewEnv(@BindingNode(Page.class) Page page) {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(AlibcProtocolConstant.INTERCEPT_TYPE_MINIPROGRAM, (Object) Boolean.valueOf(page.isUseForEmbed()));
        return jSONObject;
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

    @ActionFilter
    @AutoCallback
    public BridgeResponse postWebViewMessage(@BindingNode(Page.class) Page page, @BindingRequest JSONObject jSONObject) {
        if (page == null || page.getPageContext() == null) {
            return BridgeResponse.UNKNOWN_ERROR;
        }
        String string = page.getSceneParams().getString(RVConstants.EXTRA_EMBED_VIEW_ID);
        if (TextUtils.isEmpty(string)) {
            RVLogger.e(f24112a, "Can't find the viewId");
            return BridgeResponse.newError(10, "no viewId");
        }
        try {
            String string2 = JSONUtils.getString(jSONObject, "type");
            IEmbedView iEmbedViewFindViewById = page.getPageContext().getEmbedViewManager().findViewById(string);
            if ("message".equals(string2)) {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("detail", (Object) JSONUtils.getJSONObject(jSONObject, "detail", null));
                jSONObject2.put("type", "message");
                iEmbedViewFindViewById.sendEvent(RVEvents.WEBVIEW_ON_FROM_MESSAGE, jSONObject2, null);
            } else {
                JSONObject jSONObject3 = new JSONObject();
                int i = JSONUtils.getInt(jSONObject, RenderCallContext.TYPE_CALLBACK);
                JSONObject jSONObject4 = JSONUtils.getJSONObject(jSONObject, "param", null);
                jSONObject3.put("viewId", (Object) BundleUtils.getString(page.getSceneParams(), "viewId"));
                jSONObject3.put("type", (Object) string2);
                jSONObject3.put(RenderCallContext.TYPE_CALLBACK, (Object) Integer.valueOf(i));
                jSONObject3.put("param", (Object) jSONObject4);
                iEmbedViewFindViewById.sendEvent(RVEvents.WEBVIEW_ON_FROM_MESSAGE, jSONObject3, null);
            }
            return BridgeResponse.SUCCESS;
        } catch (Exception e) {
            RVLogger.e(f24112a, "postWebViewMessage exception!", e);
            return BridgeResponse.newError(11, "java exception happen!" + e.getMessage());
        }
    }
}
