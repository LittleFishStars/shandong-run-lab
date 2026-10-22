package com.alibaba.ariver.engine.common.bridge;

import com.alibaba.ariver.engine.api.bridge.RenderBridge;
import com.alibaba.ariver.engine.api.bridge.model.RenderCallContext;
import com.alibaba.ariver.engine.api.bridge.model.SendToRenderCallback;
import com.alibaba.ariver.engine.api.security.EventSendInterceptorPoint;
import com.alibaba.ariver.kernel.api.extension.ExtensionPoint;
import com.alibaba.ariver.kernel.api.extension.resolver.ResultResolver;
import com.alibaba.ariver.kernel.api.node.Node;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.fastjson.JSONObject;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public abstract class BaseRenderBridgeImpl implements RenderBridge {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f24058a = "AriverEngine:" + BaseRenderBridgeImpl.class.getSimpleName();
    private final Map<String, SendToRenderCallback> b = new HashMap();
    private Node c;
    private EventSendInterceptorPoint d;

    public BaseRenderBridgeImpl(Node node) {
        this.c = node;
        this.d = (EventSendInterceptorPoint) ExtensionPoint.as(EventSendInterceptorPoint.class).node(node).useCache(true).defaultValue(Boolean.FALSE).resolve(new ResultResolver<Boolean>() { // from class: com.alibaba.ariver.engine.common.bridge.BaseRenderBridgeImpl.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.alibaba.ariver.kernel.api.extension.resolver.ResultResolver
            public Boolean resolve(List<Boolean> list) {
                if (list == null || list.isEmpty()) {
                    return Boolean.TRUE;
                }
                Iterator<Boolean> it = list.iterator();
                while (it.hasNext()) {
                    if (!it.next().booleanValue()) {
                        return Boolean.FALSE;
                    }
                }
                return Boolean.TRUE;
            }
        }).create();
    }

    private boolean a(String str, JSONObject jSONObject) {
        return this.d.needIntercept(str, jSONObject);
    }

    public abstract void executeSendToRender(RenderCallContext renderCallContext, SendToRenderCallback sendToRenderCallback);

    @Override // com.alibaba.ariver.engine.api.bridge.RenderBridge
    public void sendToRender(RenderCallContext renderCallContext, SendToRenderCallback sendToRenderCallback, boolean z) {
        if (!z || !a(renderCallContext.getAction(), renderCallContext.getParam())) {
            if (sendToRenderCallback != null) {
                RVLogger.d(this.f24058a, "sendToRender " + renderCallContext.getAction() + " record callback " + renderCallContext.getEventId());
                this.b.put(renderCallContext.getEventId(), sendToRenderCallback);
            }
            executeSendToRender(renderCallContext, sendToRenderCallback);
            return;
        }
        if (sendToRenderCallback != null) {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("prevent", (Object) Boolean.FALSE);
            sendToRenderCallback.onCallBack(jSONObject);
            RVLogger.d(this.f24058a, renderCallContext.getAction() + " H5 onCallback for " + renderCallContext.getAction() + " invoke was prevented");
        }
        RVLogger.d(this.f24058a, "sender" + this.c.hashCode() + " send event[" + renderCallContext.getAction() + "] was intercepted by extension");
    }

    @Override // com.alibaba.ariver.engine.api.bridge.RenderBridge
    public SendToRenderCallback takeCallback(String str) {
        RVLogger.d(this.f24058a, "try takeCallback: " + str);
        return this.b.remove(str);
    }

    public JSONObject warpData(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        JSONObject jSONObject2 = jSONObject.getJSONObject("data");
        if (jSONObject2 != null && jSONObject2.size() == 1) {
            return jSONObject2;
        }
        JSONObject jSONObject3 = new JSONObject();
        jSONObject3.put("data", (Object) jSONObject);
        return jSONObject3;
    }

    @Override // com.alibaba.ariver.engine.api.bridge.RenderBridge
    public void sendToRender(RenderCallContext renderCallContext, SendToRenderCallback sendToRenderCallback) {
        sendToRender(renderCallContext, sendToRenderCallback, true);
    }
}
