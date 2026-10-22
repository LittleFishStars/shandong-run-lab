package com.alibaba.ariver.remotedebug.worker;

import android.net.Uri;
import android.text.TextUtils;
import com.alibaba.ariver.engine.api.EngineUtils;
import com.alibaba.ariver.engine.api.Render;
import com.alibaba.ariver.engine.api.bridge.EngineRouter;
import com.alibaba.ariver.engine.api.bridge.SendToWorkerCallback;
import com.alibaba.ariver.engine.api.bridge.extension.BridgeResponse;
import com.alibaba.ariver.engine.api.bridge.model.NativeCallContext;
import com.alibaba.ariver.engine.api.bridge.model.RenderCallContext;
import com.alibaba.ariver.engine.api.bridge.model.SendToNativeCallback;
import com.alibaba.ariver.kernel.common.utils.JSONUtils;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f24410a = "AriverRemoteDebug:JsApiHandler";
    private static final String b = "h5container.message: ";
    private static final String c = "viewId";
    private EngineRouter d;
    private b e;

    public a(b bVar, EngineRouter engineRouter) {
        this.e = bVar;
        this.d = engineRouter;
    }

    private boolean b(String str) {
        JSONObject object;
        RVLogger.d(f24410a, "handleJSMsgFromWorker msg = " + str);
        String str2 = b;
        if (!str.startsWith(b)) {
            if (str.startsWith("jserror:" + b)) {
                str2 = "jserror:" + b;
            } else {
                str2 = null;
            }
        }
        if (TextUtils.isEmpty(str2) || (object = JSONUtils.parseObject(str.replaceFirst(str2, ""))) == null || object.isEmpty()) {
            return false;
        }
        if (JSONUtils.getJSONObject(object, "data", null) == null) {
            RVLogger.e(f24410a, "invalid param, handleMsgFromWorker data = null");
        }
        if (com.alibaba.triver.embed.webview.b.f24908a.equals(object.getString("handlerName"))) {
            a(object);
            return true;
        }
        final String string = object.getString("callbackId");
        if (TextUtils.isEmpty(string)) {
            RVLogger.e(f24410a, "invalid callbackId");
            return false;
        }
        a(object.getString("handlerName"), object, new SendToWorkerCallback() { // from class: com.alibaba.ariver.remotedebug.worker.a.1
            @Override // com.alibaba.ariver.engine.api.bridge.SendToWorkerCallback
            public void onCallBack(JSONObject jSONObject) {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("responseId", (Object) string);
                jSONObject2.put("responseData", (Object) jSONObject);
                a.this.e.sendMessageToWorker(null, null, jSONObject2.toJSONString());
            }
        });
        return true;
    }

    private boolean c(String str) {
        Uri uri = Uri.parse(str);
        RVLogger.d(f24410a, uri.toString());
        if ("https://alipay.kylinBridge".equalsIgnoreCase(uri.getScheme() + "://" + uri.getHost())) {
            String queryParameter = uri.getQueryParameter("data");
            RVLogger.d(f24410a, "handleSyncJsApiCall data " + queryParameter);
            JSONObject object = JSON.parseObject(queryParameter);
            if (object != null && !object.isEmpty()) {
                final String string = JSONUtils.getString(object, "action");
                final int i = JSONUtils.getInt(object, "requestId");
                final String string2 = JSONUtils.getString(object, RenderCallContext.TYPE_CALLBACK);
                if (!TextUtils.isEmpty(string2)) {
                    RVLogger.d(f24410a, "sync hasPermission true");
                    try {
                        a(string, object, new SendToWorkerCallback() { // from class: com.alibaba.ariver.remotedebug.worker.a.2

                            /* JADX INFO: renamed from: a, reason: collision with root package name */
                            final long f24412a = System.currentTimeMillis();

                            @Override // com.alibaba.ariver.engine.api.bridge.SendToWorkerCallback
                            public void onCallBack(JSONObject jSONObject) {
                                RVLogger.d(a.f24410a, "tinyAppTimeCostLog:" + string + " onReceiveJsapiResult cost " + (System.currentTimeMillis() - this.f24412a));
                                if (jSONObject != null) {
                                    JSONObject jSONObject2 = new JSONObject();
                                    jSONObject2.put("type", (Object) NativeCallContext.CALL_MODE_SYNC);
                                    jSONObject2.put("responseId", (Object) Integer.valueOf(i));
                                    jSONObject2.put("responseData", (Object) jSONObject);
                                    jSONObject2.put(RenderCallContext.TYPE_CALLBACK, (Object) string2);
                                    a.this.e.sendMessageToWorker(null, null, jSONObject2.toJSONString());
                                    RVLogger.d(a.f24410a, "sync onReceiveJsapiResult action ");
                                }
                            }
                        });
                    } catch (Exception e) {
                        RVLogger.e(f24410a, "handleSyncJsApiCall...e=" + e);
                    }
                    return true;
                }
            }
        }
        return false;
    }

    public boolean a(String str) {
        RVLogger.d(f24410a, "handleMsgFromWorker msg = " + str);
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.startsWith("https://alipay.kylinBridge") ? c(str) : b(str);
    }

    private void a(final String str, JSONObject jSONObject, final SendToWorkerCallback sendToWorkerCallback) {
        RVLogger.d(f24410a, "handleMsgFromJs: " + str + ", param " + jSONObject);
        try {
            JSONObject jSONObject2 = JSONUtils.getJSONObject(jSONObject, "data", null);
            String string = JSONUtils.getString(jSONObject2, c, null);
            Render renderById = this.d.getRenderById(string);
            if (renderById == null) {
                RVLogger.w(f24410a, "handleMsgFromJs: " + str + ", but cannot find viewId for " + string);
                return;
            }
            renderById.getEngine().getBridge().sendToNative(new NativeCallContext.Builder().name(str).params(jSONObject2).node(renderById.getPage()).render(renderById).id("" + System.currentTimeMillis()).build(), new SendToNativeCallback() { // from class: com.alibaba.ariver.remotedebug.worker.a.3
                @Override // com.alibaba.ariver.engine.api.bridge.model.SendToNativeCallback
                public void onCallback(JSONObject jSONObject3, boolean z) {
                    RVLogger.d(a.f24410a, "handleMsgFromJs: " + str + ", return " + jSONObject3);
                    SendToWorkerCallback sendToWorkerCallback2 = sendToWorkerCallback;
                    if (sendToWorkerCallback2 != null) {
                        sendToWorkerCallback2.onCallBack(jSONObject3);
                    }
                }
            });
        } catch (Throwable th) {
            RVLogger.e(f24410a, "handleMsgFromJs: " + str + " exception!", th);
            if (sendToWorkerCallback != null) {
                sendToWorkerCallback.onCallBack(BridgeResponse.INVALID_PARAM.get());
            }
        }
    }

    public boolean b(JSONObject jSONObject, String str) {
        Render renderById = this.d.getRenderById(JSONUtils.getString(JSONUtils.getJSONObject(jSONObject, "data", null), c, null));
        if (renderById == null) {
            RVLogger.e(f24410a, "handleMessage error! can't find target render");
            return false;
        }
        renderById.getRenderBridge().sendToRender(RenderCallContext.newBuilder(renderById).action(str).type("call").param(jSONObject).build(), null);
        return true;
    }

    private boolean a(JSONObject jSONObject) {
        return b(jSONObject, "message");
    }

    public boolean a(JSONObject jSONObject, String str) {
        Render renderById = this.d.getRenderById(null);
        if (renderById == null) {
            RVLogger.e(f24410a, "handleMessageToTopRender error! can't find target render");
            return false;
        }
        EngineUtils.sendToRender(renderById, this.e, str, jSONObject, null);
        return true;
    }
}
