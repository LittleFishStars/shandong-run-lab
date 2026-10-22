package com.alibaba.triver.triver_render.render;

import android.text.TextUtils;
import android.webkit.ValueCallback;
import com.alibaba.ariver.engine.api.Render;
import com.alibaba.ariver.engine.api.bridge.model.RenderCallContext;
import com.alibaba.ariver.engine.api.bridge.model.SendToRenderCallback;
import com.alibaba.ariver.engine.common.bridge.BaseRenderBridgeImpl;
import com.alibaba.ariver.kernel.RVEvents;
import com.alibaba.ariver.kernel.api.node.Node;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.service.RVConfigService;
import com.alibaba.ariver.kernel.common.service.executor.ExecutorType;
import com.alibaba.ariver.kernel.common.service.executor.RVExecutorService;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.triver.triver_render.R;
import com.uc.webview.export.WebView;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class f extends BaseRenderBridgeImpl {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f25210a = "TBWebEngine:" + f.class.getSimpleName();
    private static List<String> d = new ArrayList();
    private static List<String> e = new ArrayList();
    private WebView b;
    private Map<String, SendToRenderCallback> c;

    static {
        d.add("JSPlugin_AlipayH5Share");
        d.add(RVEvents.BEFORE_UNLOAD);
        d.add("message");
        d.add(RVEvents.NBCOMPONENT_CANRENDER);
        e.add("showNetWorkCheckActivity");
        e.add("showUCFailDialog");
        e.add("setKeyboardType");
        e.add("monitorH5Performance");
        e.add("getStartupParams");
    }

    public f(Node node, Render render) {
        super(node);
        WebView view = render.getView();
        String str = f25210a;
        StringBuilder sb = new StringBuilder();
        sb.append("WVRenderBridge init: ");
        boolean z = view instanceof WebView;
        sb.append(z);
        RVLogger.e(str, sb.toString());
        if (z) {
            this.b = view;
        } else if (view.findViewById(R.id.triver_webview_id) instanceof WebView) {
            this.b = view.findViewById(R.id.triver_webview_id);
        }
        this.c = new ConcurrentHashMap();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(String str) {
        try {
            if (str.startsWith("javascript")) {
                this.b.evaluateJavascript(str, (ValueCallback) null);
            }
        } catch (Throwable th) {
            RVLogger.e(f25210a, "loadUrl exception.", th);
        }
    }

    @Override // com.alibaba.ariver.engine.common.bridge.BaseRenderBridgeImpl
    public void executeSendToRender(final RenderCallContext renderCallContext, final SendToRenderCallback sendToRenderCallback) {
        if (sendToRenderCallback != null) {
            this.c.put(renderCallContext.getEventId(), sendToRenderCallback);
        }
        if ("yes".equalsIgnoreCase(((RVConfigService) RVProxy.get(RVConfigService.class)).getConfigWithProcessCache("h5_postWebOnUi", null))) {
            ((RVExecutorService) RVProxy.get(RVExecutorService.class)).getExecutor(ExecutorType.UI).execute(new Runnable() { // from class: com.alibaba.triver.triver_render.render.f.2
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        f.this.a(renderCallContext, sendToRenderCallback);
                    } catch (Throwable th) {
                        RVLogger.e(f.f25210a, th);
                    }
                }
            });
            return;
        }
        try {
            a(renderCallContext, sendToRenderCallback);
        } catch (Throwable th) {
            RVLogger.e(f25210a, th);
        }
    }

    public void a(JSONObject jSONObject) {
        String str = "AlipayJSBridge._invokeJS(" + JSON.toJSONString(jSONObject.toJSONString()) + ")";
        a("javascript:(function(){if(typeof AlipayJSBridge === 'object'){" + str + "}})();");
        RVLogger.d(f25210a, "jsapi rep:" + str);
    }

    public void a(final String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        ((RVExecutorService) RVProxy.get(RVExecutorService.class)).getExecutor(ExecutorType.UI).execute(new Runnable() { // from class: com.alibaba.triver.triver_render.render.f.1
            @Override // java.lang.Runnable
            public void run() {
                f.this.b(str);
            }
        });
    }

    public void a(RenderCallContext renderCallContext, SendToRenderCallback sendToRenderCallback) {
        JSONObject jSONObject = new JSONObject();
        if (TextUtils.isEmpty(renderCallContext.getAction()) || !renderCallContext.getAction().contains("cameraFrame")) {
            jSONObject.put("clientId", (Object) renderCallContext.getEventId());
            jSONObject.put("func", (Object) renderCallContext.getAction());
            jSONObject.put("param", (Object) renderCallContext.getParam());
            jSONObject.put("msgType", (Object) renderCallContext.getType());
            jSONObject.put("keepCallback", (Object) Boolean.valueOf(renderCallContext.getKeep()));
            a(jSONObject);
        }
    }
}
