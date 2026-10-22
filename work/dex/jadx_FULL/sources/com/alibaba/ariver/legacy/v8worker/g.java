package com.alibaba.ariver.legacy.v8worker;

import android.net.Uri;
import android.text.TextUtils;
import com.alibaba.ariver.app.api.App;
import com.alibaba.ariver.engine.api.Render;
import com.alibaba.ariver.engine.api.bridge.SendToWorkerCallback;
import com.alibaba.ariver.engine.api.bridge.extension.BridgeResponse;
import com.alibaba.ariver.engine.api.bridge.model.NativeCallContext;
import com.alibaba.ariver.engine.api.bridge.model.RenderCallContext;
import com.alibaba.ariver.engine.api.bridge.model.SendToNativeCallback;
import com.alibaba.ariver.engine.api.proxy.RVJSApiHandlerProxy;
import com.alibaba.ariver.engine.common.worker.BaseWorkerImpl;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.utils.JSONUtils;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.fastjson.JSONObject;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class g {
    private String b;
    private App e;
    private n f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f24309a = "viewId";
    private final int c = 30;
    private boolean d = true;

    public g(App app, n nVar) {
        this.f = nVar;
        this.e = app;
        this.b = nVar.getLogTag() + "_JsApiHandler";
    }

    public void a(long j, NativeCallContext nativeCallContext) {
    }

    public void a(long j, NativeCallContext nativeCallContext, JSONObject jSONObject) {
    }

    private void b(final String str, final JSONObject jSONObject, final SendToWorkerCallback sendToWorkerCallback, final String str2, final int i) {
        com.alibaba.ariver.a.a().post(new Runnable() { // from class: com.alibaba.ariver.legacy.v8worker.g.3
            @Override // java.lang.Runnable
            public void run() {
                g.this.a(str, jSONObject, sendToWorkerCallback, str2, i);
            }
        });
    }

    public void a(String str) {
        Uri uri = Uri.parse(str);
        if (this.d) {
            this.d = false;
        }
        String queryParameter = uri.getQueryParameter("data");
        RVLogger.d(this.b, "handleSyncJsapiRequest data " + queryParameter);
        JSONObject object = JSONUtils.parseObject(queryParameter);
        if (object == null || object.isEmpty()) {
            return;
        }
        final String string = JSONUtils.getString(object, "action");
        String string2 = JSONUtils.getString(object, "applicationId");
        String string3 = JSONUtils.getString(object, RenderCallContext.TYPE_CALLBACK);
        if (!TextUtils.isEmpty(string3)) {
            RVLogger.d(this.b, "sync hasPermission true, render ready " + this.f.isRenderReady());
            int i = this.f.isRenderReady() ? 2000 : 8000;
            int syncTimeout = ((RVJSApiHandlerProxy) RVProxy.get(RVJSApiHandlerProxy.class)).getSyncTimeout(string, this.f.getStartupParams(), object);
            if (syncTimeout > 0) {
                RVLogger.d(this.b, "H5TinyAppProvider.getTyroBlockTime result: " + syncTimeout);
                i = syncTimeout;
            }
            final CountDownLatch countDownLatch = new CountDownLatch(1);
            final StringBuilder sb = new StringBuilder();
            sb.append(string3);
            sb.append("(");
            b(string, object, new SendToWorkerCallback() { // from class: com.alibaba.ariver.legacy.v8worker.g.1

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                final long f24310a = System.currentTimeMillis();

                @Override // com.alibaba.ariver.engine.api.bridge.SendToWorkerCallback
                public void onCallBack(JSONObject jSONObject) {
                    String str2;
                    try {
                        try {
                            long jCurrentTimeMillis = System.currentTimeMillis() - this.f24310a;
                            RVLogger.d(g.this.b, "tinyAppTimeCostLog:" + string + " onReceiveJsapiResult cost " + jCurrentTimeMillis);
                            if (jSONObject != null) {
                                String jSONString = jSONObject.toJSONString();
                                String str3 = g.this.b;
                                StringBuilder sb2 = new StringBuilder();
                                sb2.append("sync action ");
                                sb2.append(string);
                                sb2.append(" sendMsg ");
                                if (jSONString.length() > 200) {
                                    str2 = jSONString.substring(0, 200) + "..";
                                } else {
                                    str2 = jSONString;
                                }
                                sb2.append(str2);
                                RVLogger.d(str3, sb2.toString());
                                sb.append(jSONString);
                            }
                        } catch (Exception e) {
                            RVLogger.e(g.this.b, "sync failed to get byte array", e);
                        }
                    } finally {
                        countDownLatch.countDown();
                    }
                }
            }, string2, i / 30);
            try {
                countDownLatch.await(i, TimeUnit.MILLISECONDS);
            } catch (InterruptedException unused) {
                RVLogger.e(this.b, "sync lock await error!");
            }
            sb.append(")");
            this.f.executeScript(sb.toString());
            return;
        }
        RVLogger.d(this.b, "caution!!! shouldn't be here!!!!");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(final JSONObject jSONObject) {
        if (!this.f.isRenderReady()) {
            this.f.registerRenderReadyListener(new BaseWorkerImpl.RenderReadyListener() { // from class: com.alibaba.ariver.legacy.v8worker.g.4
                @Override // com.alibaba.ariver.engine.common.worker.BaseWorkerImpl.RenderReadyListener
                public void onRenderReady() {
                    g.this.b(jSONObject);
                }
            });
            return;
        }
        RVLogger.d(this.b, "postMessage: " + jSONObject);
        String string = JSONUtils.getString(JSONUtils.getJSONObject(jSONObject, "data", null), "viewId", null);
        Render renderById = this.e.getEngineProxy().getEngineRouter().getRenderById(string);
        if (renderById != null) {
            renderById.getRenderBridge().sendToRender(RenderCallContext.newBuilder(renderById).action("message").type("call").param(jSONObject).build(), null);
            return;
        }
        RVLogger.w(this.b, "postMessage but cannot find viewId: " + string);
    }

    public void a(JSONObject jSONObject) {
        if (jSONObject != null && !jSONObject.isEmpty()) {
            String string = jSONObject.getString("handlerName");
            if (TextUtils.isEmpty(string)) {
                RVLogger.e(this.b, "invalid param, handleAsyncJsapiRequest action = null");
                return;
            }
            RVLogger.d(this.b, "handleAsyncJsapiRequest " + string);
            if (JSONUtils.getJSONObject(jSONObject, "data", null) == null) {
                RVLogger.e(this.b, "invalid param, handleAsyncJsapiRequest data = null");
            }
            if (com.alibaba.triver.embed.webview.b.f24908a.equals(string)) {
                b(jSONObject);
                return;
            }
            final String string2 = jSONObject.getString("callbackId");
            if (TextUtils.isEmpty(string2)) {
                RVLogger.e(this.b, "invalid callbackId");
                return;
            } else {
                b(string, jSONObject, new SendToWorkerCallback() { // from class: com.alibaba.ariver.legacy.v8worker.g.2
                    @Override // com.alibaba.ariver.engine.api.bridge.SendToWorkerCallback
                    public void onCallBack(JSONObject jSONObject2) {
                        JSONObject jSONObject3 = new JSONObject();
                        jSONObject3.put("responseId", (Object) string2);
                        jSONObject3.put("responseData", (Object) jSONObject2);
                        g.this.f.sendMessageToWorker(null, null, jSONObject3.toJSONString());
                    }
                }, this.f.getWorkerId(), MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_FIRST_PACKET_TIME);
                return;
            }
        }
        RVLogger.e(this.b, "invalid param, handleAsyncJsapiRequest");
    }

    public void a(final String str, JSONObject jSONObject, final SendToWorkerCallback sendToWorkerCallback, String str2, int i) {
        try {
            RVLogger.d(this.b, "handleMsgFromJs: " + str + ", param " + jSONObject);
        } catch (Throwable unused) {
        }
        try {
            JSONObject jSONObject2 = JSONUtils.getJSONObject(jSONObject, "data", null);
            String string = JSONUtils.getString(jSONObject2, "viewId", null);
            App app = this.e;
            if (app != null && app.getEngineProxy() != null && this.e.getEngineProxy().getEngineRouter() != null) {
                Render renderById = this.e.getEngineProxy().getEngineRouter().getRenderById(string);
                if (renderById == null) {
                    RVLogger.w(this.b, "handleMsgFromJs: " + str + ", but cannot find viewId for " + string);
                    return;
                }
                final long jCurrentTimeMillis = System.currentTimeMillis();
                final NativeCallContext nativeCallContextBuild = new NativeCallContext.Builder().name(str).params(jSONObject2).node(renderById.getPage()).source(NativeCallContext.FROM_WORKER).render(renderById).build();
                a(jCurrentTimeMillis, nativeCallContextBuild);
                renderById.getEngine().getBridge().sendToNative(nativeCallContextBuild, new SendToNativeCallback() { // from class: com.alibaba.ariver.legacy.v8worker.g.5
                    @Override // com.alibaba.ariver.engine.api.bridge.model.SendToNativeCallback
                    public void onCallback(JSONObject jSONObject3, boolean z) {
                        RVLogger.d(g.this.b, "handleMsgFromJs: " + str + ", return " + jSONObject3);
                        SendToWorkerCallback sendToWorkerCallback2 = sendToWorkerCallback;
                        if (sendToWorkerCallback2 != null) {
                            sendToWorkerCallback2.onCallBack(jSONObject3);
                        }
                        g.this.a(jCurrentTimeMillis, nativeCallContextBuild, jSONObject3);
                    }
                });
                return;
            }
            RVLogger.w(this.b, "handleMsgFromJs: " + str + ", but cannot find viewId for " + string);
        } catch (Throwable th) {
            RVLogger.e(this.b, "handleMsgFromJs: " + str + " exception!", th);
            if (sendToWorkerCallback != null) {
                sendToWorkerCallback.onCallBack(BridgeResponse.INVALID_PARAM.get());
            }
        }
    }
}
