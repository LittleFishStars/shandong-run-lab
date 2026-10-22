package com.alibaba.ariver.v8worker;

import android.net.Uri;
import android.os.ConditionVariable;
import android.os.Handler;
import android.os.SystemClock;
import android.text.TextUtils;
import com.alibaba.ariver.app.api.App;
import com.alibaba.ariver.app.api.Page;
import com.alibaba.ariver.engine.api.RVEngine;
import com.alibaba.ariver.engine.api.Render;
import com.alibaba.ariver.engine.api.bridge.EngineRouter;
import com.alibaba.ariver.engine.api.bridge.NativeBridge;
import com.alibaba.ariver.engine.api.bridge.SendToWorkerCallback;
import com.alibaba.ariver.engine.api.bridge.extension.BridgeResponse;
import com.alibaba.ariver.engine.api.bridge.model.NativeCallContext;
import com.alibaba.ariver.engine.api.bridge.model.RenderCallContext;
import com.alibaba.ariver.engine.api.bridge.model.SendToNativeCallback;
import com.alibaba.ariver.engine.api.proxy.RVJSApiHandlerProxy;
import com.alibaba.ariver.engine.common.worker.BaseWorkerImpl;
import com.alibaba.ariver.jsapi.internalapi.InternalApiBridgeExtension;
import com.alibaba.ariver.kernel.api.node.Node;
import com.alibaba.ariver.kernel.api.track.EventTrackStore;
import com.alibaba.ariver.kernel.api.track.EventTracker;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.service.RVConfigService;
import com.alibaba.ariver.kernel.common.utils.JSONUtils;
import com.alibaba.ariver.kernel.common.utils.RVKernelUtils;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.ariver.kernel.common.utils.TypeUtils;
import com.alibaba.ariver.resource.api.prerun.AppxPrerunChecker;
import com.alibaba.fastjson.JSONObject;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f24499a;
    private App b;
    private V8Worker c;
    private V8Proxy d;
    private boolean e;
    private boolean f;
    private List<String> h;
    private boolean g = false;
    private final String i = "viewId";
    private final String j = "internalAPI";

    public g(App app, V8Worker v8Worker) {
        this.c = v8Worker;
        this.b = app;
        this.f24499a = v8Worker.getLogTag() + "_JsApiHandler";
        a();
    }

    public void a(long j, NativeCallContext nativeCallContext) {
    }

    public void a(long j, NativeCallContext nativeCallContext, JSONObject jSONObject) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(final JSONObject jSONObject) {
        if (!this.c.isRenderReady()) {
            this.c.registerRenderReadyListener(new BaseWorkerImpl.RenderReadyListener() { // from class: com.alibaba.ariver.v8worker.g.3
                @Override // com.alibaba.ariver.engine.common.worker.BaseWorkerImpl.RenderReadyListener
                public void onRenderReady() {
                    g.this.b(jSONObject);
                }
            });
            return;
        }
        String string = JSONUtils.getString(JSONUtils.getJSONObject(jSONObject, "data", null), "viewId", null);
        App app = this.b;
        if (app != null && app.getEngineProxy() != null && this.b.getEngineProxy().getEngineRouter() != null) {
            Render renderById = this.b.getEngineProxy().getEngineRouter().getRenderById(string);
            if (renderById != null) {
                renderById.getRenderBridge().sendToRender(RenderCallContext.newBuilder(renderById).action("message").type("call").param(jSONObject).build(), null);
                return;
            }
            RVLogger.w(this.f24499a, "postMessage but cannot find viewId: " + string);
            return;
        }
        RVLogger.e(this.f24499a, "handleMsgFromJs: getEngineProxy() is null");
    }

    private void a() {
        this.d = (V8Proxy) RVProxy.get(V8Proxy.class);
        App app = this.b;
        String appId = app != null ? app.getAppId() : null;
        App app2 = this.b;
        this.e = AppxPrerunChecker.isPrerunWorkerApp(appId, app2 != null ? app2.getStartParams() : null);
        RVConfigService rVConfigService = (RVConfigService) RVProxy.get(RVConfigService.class);
        if (rVConfigService != null) {
            try {
                String config = rVConfigService.getConfig("ta_interceptInternalAPI", "");
                this.g = config != null && "1".equals(config.trim());
                this.h = JSONUtils.toStringArray(rVConfigService.getConfigJSONArray("ta_internalAPIList"));
            } catch (Exception e) {
                RVLogger.e(this.f24499a, e);
            }
        }
    }

    public boolean a(String str, JSONObject jSONObject) {
        if (!this.e) {
            return false;
        }
        if ("internalAPI".equalsIgnoreCase(str)) {
            try {
                str = jSONObject.getJSONObject("data").getString("method");
            } catch (Exception unused) {
                RVLogger.d(this.f24499a, "internalAPI but not have method");
            }
        }
        if (!AppxPrerunChecker.isPrerunAction(str)) {
            return false;
        }
        RVLogger.d(this.f24499a, "prerun action is\t" + str);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public NativeCallContext b(Page page, String str, JSONObject jSONObject, SendToWorkerCallback sendToWorkerCallback, String str2, boolean z) {
        if (this.b.isDestroyed()) {
            return null;
        }
        JSONObject jSONObject2 = JSONUtils.getJSONObject(jSONObject, "data", null);
        String string = JSONUtils.getString(jSONObject2, "viewId", null);
        RVEngine engineProxy = this.b.getEngineProxy();
        if (engineProxy != null && !engineProxy.isDestroyed()) {
            EngineRouter engineRouter = engineProxy.getEngineRouter();
            if (engineRouter == null) {
                RVLogger.e(this.f24499a, "serialHandleMsgFromJs engineRouter is null");
                return null;
            }
            if (str.equals("internalAPI")) {
                if (this.g) {
                    RVLogger.d(this.f24499a, "serialHandleMsgFromJs, ta_interceptInternalAPI is opened");
                    return a(engineRouter, jSONObject2, page, string, sendToWorkerCallback, str2, z);
                }
                RVLogger.d(this.f24499a, "serialHandleMsgFromJs, ta_interceptInternalAPI is closed");
            }
            return new NativeCallContext.Builder().name(str).params(jSONObject2).node(page == null ? this.b : page).id("worker_" + NativeCallContext.generateUniqueId()).render(engineRouter.getRenderById(string)).source(NativeCallContext.FROM_WORKER).originalData(str2).callMode(z ? NativeCallContext.CALL_MODE_SYNC : "async").build();
        }
        RVLogger.e(this.f24499a, "serialHandleMsgFromJs engine is null or is destroyed");
        return null;
    }

    /* JADX WARN: Code duplicated, block: B:19:0x0090 A[PHI: r1
      0x0090: PHI (r1v32 int) = (r1v11 int), (r1v16 int) binds: [B:18:0x008e, B:24:0x00aa] A[DONT_GENERATE, DONT_INLINE]] */
    public void a(String str) {
        int i;
        String queryParameter = Uri.parse(str).getQueryParameter("data");
        RVLogger.d(this.f24499a, "handleSyncJsapiRequest data " + queryParameter);
        JSONObject object = JSONUtils.parseObject(queryParameter);
        if (object == null || object.isEmpty()) {
            return;
        }
        final String string = JSONUtils.getString(object, "action");
        final String string2 = JSONUtils.getString(object, RenderCallContext.TYPE_CALLBACK);
        if (!TextUtils.isEmpty(string2)) {
            V8Proxy v8Proxy = this.d;
            if (v8Proxy != null) {
                boolean zHasSyncApiPermission = v8Proxy.hasSyncApiPermission(string);
                RVLogger.d(this.f24499a, "handleSyncJsapiRequest  hasPermission " + zHasSyncApiPermission + ", render ready " + this.c.isRenderReady());
                if (zHasSyncApiPermission) {
                    int i2 = this.c.isRenderReady() ? 2000 : 8000;
                    int syncTimeout = ((RVJSApiHandlerProxy) RVProxy.get(RVJSApiHandlerProxy.class)).getSyncTimeout(string, this.c.getStartupParams(), object);
                    if (syncTimeout <= 0) {
                        RVConfigService rVConfigService = (RVConfigService) RVProxy.get(RVConfigService.class);
                        syncTimeout = rVConfigService != null ? TypeUtils.parseInt(rVConfigService.getConfigWithProcessCache("h5_syncJsapiTimeout", "-1")) : -1;
                        if (syncTimeout > 0) {
                            i = syncTimeout;
                        } else {
                            i = i2;
                        }
                    } else {
                        i = syncTimeout;
                    }
                    final JSONObject jSONObject = new JSONObject();
                    final ConditionVariable conditionVariable = new ConditionVariable();
                    a(string, object, new SendToWorkerCallback() { // from class: com.alibaba.ariver.v8worker.g.1

                        /* JADX INFO: renamed from: a, reason: collision with root package name */
                        final long f24500a = System.currentTimeMillis();

                        @Override // com.alibaba.ariver.engine.api.bridge.SendToWorkerCallback
                        public void onCallBack(JSONObject jSONObject2) {
                            try {
                                try {
                                    long jCurrentTimeMillis = System.currentTimeMillis() - this.f24500a;
                                    RVLogger.d(g.this.f24499a, "handleSyncJsapiRequest: " + string + " onReceiveJsapiResult cost " + jCurrentTimeMillis);
                                    if (jSONObject2 != null) {
                                        jSONObject.put("result", (Object) jSONObject2);
                                        String jSONString = jSONObject2.toJSONString();
                                        String str2 = g.this.f24499a;
                                        StringBuilder sb = new StringBuilder();
                                        sb.append("sync action ");
                                        sb.append(string);
                                        sb.append(", callback: ");
                                        sb.append(string2);
                                        sb.append(" result ");
                                        if (jSONString.length() > 1500) {
                                            jSONString = jSONString.substring(0, 1500) + "..";
                                        }
                                        sb.append(jSONString);
                                        RVLogger.d(str2, sb.toString());
                                    } else {
                                        JSONObject jSONObject3 = new JSONObject();
                                        jSONObject3.put("error", (Object) 999);
                                        jSONObject3.put(SendToNativeCallback.KEY_MESSAGE, (Object) "System Error: Empty Response");
                                        RVLogger.d(g.this.f24499a, "sync action " + string + ", callback: " + string2 + " result is null");
                                        jSONObject.put("result", (Object) jSONObject3);
                                    }
                                } catch (Exception e) {
                                    RVLogger.e(g.this.f24499a, "sync failed to get byte array", e);
                                }
                            } finally {
                                conditionVariable.open();
                            }
                        }
                    }, queryParameter, true);
                    StringBuilder sb = new StringBuilder();
                    sb.append(string2);
                    sb.append("(");
                    if (jSONObject.containsKey("result")) {
                        sb.append(jSONObject.getJSONObject("result").toJSONString());
                    } else {
                        boolean z = !conditionVariable.block(i);
                        if (z) {
                            RVLogger.e(this.f24499a, "handleSyncJsapiRequest timeout!!!, sync action " + string + ", callback: " + string2 + " url: " + str);
                        }
                        if (!z && jSONObject.containsKey("result")) {
                            sb.append(jSONObject.getJSONObject("result").toJSONString());
                        } else {
                            RVLogger.d(this.f24499a, "sync action " + string + ", callback: " + string2 + " Operation Timeout, timeout is " + z);
                            JSONObject jSONObject2 = new JSONObject();
                            jSONObject2.put("error", (Object) 999);
                            jSONObject2.put(SendToNativeCallback.KEY_MESSAGE, (Object) "System Error: Operation Timeout");
                            sb.append(jSONObject2.toJSONString());
                        }
                    }
                    sb.append(")");
                    String string3 = sb.toString();
                    V8Worker v8Worker = this.c;
                    v8Worker.a(string3, (String) null, v8Worker.m());
                    return;
                }
                RVLogger.e(this.f24499a, "handleSyncJsapiRequest has no permission, action: " + string);
                return;
            }
            throw new IllegalStateException("getWebViewCoreSoPath v8Proxy is null");
        }
        RVLogger.e(this.f24499a, "caution!!! shouldn't be here!!!!");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        EventTrackStore eventTrackStore;
        try {
            Map<String, String> mapW = this.c.w();
            if (mapW != null) {
                Page activePage = this.b.getActivePage();
                if (activePage != null) {
                    eventTrackStore = (EventTrackStore) activePage.getData(EventTrackStore.class, true);
                } else {
                    eventTrackStore = (EventTrackStore) this.b.getData(EventTrackStore.class, true);
                }
                eventTrackStore.fullLinkAttrMap.putAll(mapW);
            }
        } catch (Throwable th) {
            RVLogger.e(this.f24499a, "trackPerfEvent exception", th);
        }
    }

    public void a(JSONObject jSONObject) {
        if (jSONObject != null && !jSONObject.isEmpty()) {
            final String string = jSONObject.getString("handlerName");
            if (TextUtils.isEmpty(string)) {
                RVLogger.e(this.f24499a, "invalid param, handleAsyncJsapiRequest action = null");
                return;
            }
            try {
                RVLogger.d(this.f24499a, "handleAsyncJsapiRequest: " + jSONObject.toString());
            } catch (Throwable th) {
                if (RVKernelUtils.isDebug()) {
                    RVLogger.e(this.f24499a, "handleAsyncJsapiRequest", th);
                }
            }
            JSONObject jSONObject2 = JSONUtils.getJSONObject(jSONObject, "data", null);
            if (jSONObject2 == null) {
                RVLogger.e(this.f24499a, "invalid param, handleAsyncJsapiRequest data = null");
                return;
            }
            String string2 = JSONUtils.toString(jSONObject2);
            if (com.alibaba.triver.embed.webview.b.f24908a.equals(string)) {
                this.c.u();
                b(jSONObject);
                return;
            }
            final String string3 = jSONObject.getString("callbackId");
            if (TextUtils.isEmpty(string3)) {
                RVLogger.e(this.f24499a, "invalid callbackId");
                return;
            } else {
                a(string, jSONObject, new SendToWorkerCallback() { // from class: com.alibaba.ariver.v8worker.g.2
                    @Override // com.alibaba.ariver.engine.api.bridge.SendToWorkerCallback
                    public void onCallBack(JSONObject jSONObject3) {
                        JSONObject jSONObject4 = new JSONObject();
                        jSONObject4.put("responseId", (Object) string3);
                        jSONObject4.put("responseData", (Object) jSONObject3);
                        g.this.c.sendJsonToWorker(jSONObject4, null);
                        RVLogger.d(g.this.f24499a, "[DONE] async action: " + string + ", callbackId: " + string3);
                    }
                }, string2, false);
                return;
            }
        }
        RVLogger.e(this.f24499a, "invalid param, handleAsyncJsapiRequest");
    }

    public void a(final String str, final JSONObject jSONObject, final SendToWorkerCallback sendToWorkerCallback, final String str2, final boolean z) {
        if (this.b == null || this.c.isDestroyed()) {
            return;
        }
        final long jElapsedRealtime = SystemClock.elapsedRealtime();
        V8Worker v8Worker = this.c;
        if (v8Worker.f == 0) {
            v8Worker.f = jElapsedRealtime;
        }
        Page activePage = this.b.getActivePage();
        if (activePage == null) {
            if (a(str, jSONObject)) {
                if (!this.f) {
                    this.f = true;
                    RVLogger.d(this.f24499a, this.b.getAppId() + " support PreRun action");
                    ((EventTracker) RVProxy.get(EventTracker.class)).addAttr(this.b, "actualPreRunWorker", "yes");
                }
                RVLogger.d(this.f24499a, this.b.getAppId() + " handleMsgFromJsWhenPageReady PreRunWorkerAction");
                a(null, str, jSONObject, sendToWorkerCallback, str2, z);
                return;
            }
            this.b.addPageReadyListener(new App.PageReadyListener() { // from class: com.alibaba.ariver.v8worker.g.4
                @Override // com.alibaba.ariver.app.api.App.PageReadyListener
                public void onPageReady(Page page) {
                    if (g.this.c.g == 0) {
                        g.this.c.g = jElapsedRealtime;
                        g.this.b();
                    }
                    g.this.a(page, str, jSONObject, sendToWorkerCallback, str2, z);
                }
            });
            return;
        }
        V8Worker v8Worker2 = this.c;
        if (v8Worker2.g == 0) {
            v8Worker2.g = jElapsedRealtime;
            b();
        }
        a(activePage, str, jSONObject, sendToWorkerCallback, str2, z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final Page page, final String str, final JSONObject jSONObject, final SendToWorkerCallback sendToWorkerCallback, final String str2, final boolean z) {
        Runnable runnable = new Runnable() { // from class: com.alibaba.ariver.v8worker.g.5
            @Override // java.lang.Runnable
            public void run() {
                try {
                    JSONObject jSONObject2 = JSONUtils.getJSONObject(jSONObject, "data", null);
                    if (g.this.b == null) {
                        RVLogger.e(g.this.f24499a, "handleMsgFromJsWhenPageReady: getEngineProxy() is null");
                        return;
                    }
                    RVEngine engineProxy = g.this.b.getEngineProxy();
                    if (engineProxy != null && !engineProxy.isDestroyed()) {
                        if (engineProxy.getEngineRouter() == null) {
                            RVLogger.e(g.this.f24499a, "handleMsgFromJsWhenPageReady engineRouter is null, action: " + str + " params: " + jSONObject2);
                            return;
                        }
                        final long jCurrentTimeMillis = System.currentTimeMillis();
                        final NativeCallContext nativeCallContextB = g.this.b(page, str, jSONObject, sendToWorkerCallback, str2, z);
                        boolean z2 = true;
                        boolean z3 = "internalAPI".equals(str) && g.this.g;
                        g.this.a(jCurrentTimeMillis, nativeCallContextB);
                        NativeBridge bridge = engineProxy.getBridge();
                        SendToNativeCallback sendToNativeCallback = new SendToNativeCallback() { // from class: com.alibaba.ariver.v8worker.g.5.1
                            @Override // com.alibaba.ariver.engine.api.bridge.model.SendToNativeCallback
                            public void onCallback(JSONObject jSONObject3, boolean z4) {
                                SendToWorkerCallback sendToWorkerCallback2 = sendToWorkerCallback;
                                if (sendToWorkerCallback2 != null) {
                                    sendToWorkerCallback2.onCallBack(jSONObject3);
                                }
                                g.this.a(jCurrentTimeMillis, nativeCallContextB, jSONObject3);
                            }
                        };
                        if (z3) {
                            z2 = false;
                        }
                        bridge.sendToNative(nativeCallContextB, sendToNativeCallback, z2);
                        return;
                    }
                    RVLogger.e(g.this.f24499a, "handleMsgFromJsWhenPageReady engine is null or is destroyed, action: " + str + " params: " + jSONObject2);
                } catch (Throwable th) {
                    RVLogger.e(g.this.f24499a, "handleMsgFromJsWhenPageReady: " + str + " exception!", th);
                    SendToWorkerCallback sendToWorkerCallback2 = sendToWorkerCallback;
                    if (sendToWorkerCallback2 != null) {
                        sendToWorkerCallback2.onCallBack(BridgeResponse.INVALID_PARAM.get());
                    }
                }
            }
        };
        Handler dispatchHandler = this.d.getDispatchHandler(str);
        if (dispatchHandler == null) {
            runnable.run();
        } else {
            dispatchHandler.post(runnable);
        }
    }

    private NativeCallContext a(EngineRouter engineRouter, JSONObject jSONObject, Page page, String str, SendToWorkerCallback sendToWorkerCallback, String str2, boolean z) {
        List<String> list;
        String string = JSONUtils.getString(jSONObject, "method", "");
        JSONObject jSONObject2 = JSONUtils.getJSONObject(jSONObject, "param", null);
        if (TextUtils.isEmpty(string) || engineRouter == null) {
            return null;
        }
        if (!InternalApiBridgeExtension.API_INIT_LIST.contains(string) && ((list = this.h) == null || !list.contains(string))) {
            if (sendToWorkerCallback != null) {
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put("error", (Object) ("internalAPI has no permission: " + string));
                sendToWorkerCallback.onCallBack(jSONObject3);
            }
            RVLogger.d(this.f24499a, "handleInternalAPI...realMethod is not allowed");
            return null;
        }
        NativeCallContext.Builder builderParams = new NativeCallContext.Builder().name(string).params(jSONObject2);
        Node node = page;
        if (page == null) {
            node = this.b;
        }
        return builderParams.node(node).id("InternalAPI_worker_" + NativeCallContext.generateUniqueId()).render(engineRouter.getRenderById(str)).originalData(str2).callMode(z ? NativeCallContext.CALL_MODE_SYNC : "async").build();
    }

    public void a(App app) {
        this.b = app;
    }
}
