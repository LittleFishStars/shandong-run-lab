package com.alibaba.ariver.jsapi.websocket;

import android.text.TextUtils;
import com.alibaba.ariver.app.api.App;
import com.alibaba.ariver.app.api.Page;
import com.alibaba.ariver.engine.api.bridge.extension.BridgeCallback;
import com.alibaba.ariver.engine.api.bridge.extension.BridgeResponse;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingCallback;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingNode;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingParam;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingRequest;
import com.alibaba.ariver.jsapi.R;
import com.alibaba.ariver.kernel.api.annotation.ActionFilter;
import com.alibaba.ariver.kernel.api.annotation.AutoCallback;
import com.alibaba.ariver.kernel.api.annotation.ThreadType;
import com.alibaba.ariver.kernel.api.extension.ExtensionPoint;
import com.alibaba.ariver.kernel.api.extension.bridge.BridgeExtension;
import com.alibaba.ariver.kernel.api.node.NodeAware;
import com.alibaba.ariver.kernel.api.security.Permission;
import com.alibaba.ariver.kernel.common.service.executor.ExecutorType;
import com.alibaba.ariver.kernel.common.utils.ExecutorUtils;
import com.alibaba.ariver.kernel.common.utils.LangResourceUtil;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.ariver.remotedebug.b;
import com.alibaba.ariver.websocket.core.WebSocketResultEnum;
import com.alibaba.ariver.websocket.core.e;
import com.alibaba.ariver.websocket.core.f;
import com.alibaba.ariver.websocket.proxy.ConnectSocketInterceptPoint;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.sdk.android.oss.common.RequestParameters;
import java.lang.ref.WeakReference;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class WebSocketBridgeExtension implements BridgeExtension, NodeAware<App> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f24181a = "AriverAPIWebSocketBridgeExtension";
    private static final int b = 2;
    private final Map<String, a> c = new HashMap();
    private App d;

    /* JADX INFO: Access modifiers changed from: private */
    public BridgeResponse a(App app, Page page, String str, JSONObject jSONObject, String str2, boolean z, JSONArray jSONArray, JSONObject jSONObject2, boolean z2, String str3) {
        String appId;
        if (z2) {
            appId = b.f24379a + app.getAppId();
        } else {
            appId = app.getAppId();
        }
        String str4 = appId;
        page.getRender().getRenderBridge();
        RVLogger.d(f24181a, String.format("enter connectSocket, appId: %s", str4));
        boolean z3 = z && !TextUtils.isEmpty(str2);
        f fVarB = e.a().b(str4);
        if (fVarB == null) {
            fVarB = e.a().a(str4);
        } else if (z3 && fVarB.d() >= 2) {
            return BridgeResponse.newError(3, "exceed each tiny app max socket count");
        }
        if (fVarB.c(str2)) {
            RVLogger.d(f24181a, "the already appid has a websocket");
            return BridgeResponse.newError(3, LangResourceUtil.getString(R.string.ariver_jsapi_websocket_already_exist));
        }
        if (TextUtils.isEmpty(str)) {
            return a(WebSocketResultEnum.URL_IS_NULL_MSG);
        }
        String strAppendQueryJson2Url = appendQueryJson2Url(str, jSONObject);
        RVLogger.d(f24181a, String.format("url is %s", strAppendQueryJson2Url));
        try {
            String scheme = new URI(strAppendQueryJson2Url).getScheme();
            if (TextUtils.isEmpty(scheme)) {
                RVLogger.d(f24181a, String.format("connect fail : %s ", strAppendQueryJson2Url));
                return a(WebSocketResultEnum.URL_NOT_WELL_FORMAT);
            }
            if (!"ws".equalsIgnoreCase(scheme) && !com.alibaba.ariver.websocket.b.b.equalsIgnoreCase(scheme)) {
                RVLogger.d(f24181a, String.format("url error: %s not ws:// or wss://", strAppendQueryJson2Url));
                return a(WebSocketResultEnum.URL_NOT_WS_OR_WSS);
            }
            RVLogger.d(f24181a, String.format("send request ok, url is : %s ,appid: %s", strAppendQueryJson2Url, str4));
            Map<String, String> mapA = a(jSONObject2);
            mapA.put("User-Agent", str3);
            mapA.remove(RequestParameters.SUBRESOURCE_REFERER);
            String strA = a(jSONArray);
            if (!TextUtils.isEmpty(strA)) {
                mapA.put(com.google.common.net.b.Q1, strA);
            }
            RVLogger.d(f24181a, "protocols: " + strA);
            try {
                a aVar = new a(page, str2, z);
                this.c.put(str4 + str2, aVar);
                fVarB.a(strAppendQueryJson2Url, str2, mapA, aVar);
                return BridgeResponse.SUCCESS;
            } catch (Exception e) {
                return BridgeResponse.newError(3, e.toString());
            }
        } catch (URISyntaxException e2) {
            RVLogger.e(f24181a, e2);
        }
    }

    public static String appendQueryJson2Url(String str, JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                if (!jSONObject.isEmpty()) {
                    StringBuilder sb = new StringBuilder(str);
                    if (str.indexOf("?") <= 0) {
                        sb.append("?");
                    } else if (!str.endsWith("&")) {
                        sb.append("&");
                    }
                    for (Map.Entry<String, Object> entry : jSONObject.entrySet()) {
                        String key = entry.getKey();
                        if (!TextUtils.isEmpty(key)) {
                            sb.append(key);
                            sb.append("=");
                            sb.append(entry.getValue());
                            sb.append("&");
                        }
                    }
                    sb.deleteCharAt(sb.length() - 1);
                    return sb.toString();
                }
            } catch (Throwable th) {
                RVLogger.e(f24181a, "appendQueryJson2Url error.", th);
            }
        }
        return str;
    }

    @ActionFilter
    @AutoCallback
    public BridgeResponse closeSocket(@BindingNode(App.class) App app, @BindingNode(Page.class) Page page, @BindingParam({"socketTaskID"}) String str, @BindingParam({"fromRemoteDebug"}) boolean z) {
        String appId;
        if (z) {
            appId = b.f24379a + app.getAppId();
        } else {
            appId = app.getAppId();
        }
        f fVarB = e.a().b(appId);
        if (fVarB == null) {
            RVLogger.d(f24181a, "closeSocket error , not exist WebsocketSession");
            return BridgeResponse.SUCCESS;
        }
        if (this.c.get(appId + str) == null) {
            RVLogger.d(f24181a, "sendSocketMessage error , no callback!!!");
            return BridgeResponse.SUCCESS;
        }
        fVarB.a(str);
        return BridgeResponse.SUCCESS;
    }

    @ThreadType(ExecutorType.UI)
    @ActionFilter
    public void connectSocket(@BindingNode(App.class) final App app, @BindingNode(Page.class) final Page page, @BindingParam({"url"}) final String str, @BindingParam({"data"}) final JSONObject jSONObject, @BindingParam({"socketTaskID"}) final String str2, @BindingParam({"multiple"}) final boolean z, @BindingParam({"protocols"}) final JSONArray jSONArray, @BindingParam({"header"}) final JSONObject jSONObject2, @BindingParam({"fromRemoteDebug"}) final boolean z2, @BindingRequest JSONObject jSONObject3, @BindingCallback final BridgeCallback bridgeCallback) {
        if (((ConnectSocketInterceptPoint) ExtensionPoint.as(ConnectSocketInterceptPoint.class).node(page).create()).interceptConnectSocket(page, jSONObject3, bridgeCallback)) {
            return;
        }
        final String userAgent = page.getRender().getUserAgent();
        ExecutorUtils.getScheduledExecutor().execute(new Runnable() { // from class: com.alibaba.ariver.jsapi.websocket.WebSocketBridgeExtension.1
            @Override // java.lang.Runnable
            public void run() {
                bridgeCallback.sendBridgeResponse(WebSocketBridgeExtension.this.a(app, page, str, jSONObject, str2, z, jSONArray, jSONObject2, z2, userAgent));
            }
        });
    }

    @Override // com.alibaba.ariver.kernel.api.node.NodeAware
    public Class<App> getNodeType() {
        return App.class;
    }

    @Override // com.alibaba.ariver.kernel.api.extension.Extension
    public void onFinalized() {
        f fVarB;
        this.c.clear();
        if (this.d == null || (fVarB = e.a().b(this.d.getAppId())) == null) {
            return;
        }
        fVarB.b();
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
    public BridgeResponse sendSocketMessage(@BindingNode(App.class) App app, @BindingNode(Page.class) Page page, @BindingParam({"data"}) String str, @BindingParam({"socketTaskID"}) String str2, @BindingParam({"isBuffer"}) boolean z, @BindingParam({"fromRemoteDebug"}) boolean z2) {
        String appId;
        if (z2) {
            appId = b.f24379a + app.getAppId();
        } else {
            appId = app.getAppId();
        }
        f fVarB = e.a().b(appId);
        if (fVarB == null) {
            RVLogger.d(f24181a, "sendSocketMessage error , not exist WebsocketSession");
            return a(WebSocketResultEnum.CANNOT_SEND_UNTIL_CONNECTION_IS_OPEN);
        }
        if (!fVarB.c(str2)) {
            RVLogger.d(f24181a, "sendSocketMessage error , no websocket connection is established");
            return a(WebSocketResultEnum.CANNOT_SEND_UNTIL_CONNECTION_IS_OPEN);
        }
        if (!z2) {
            a aVar = this.c.get(appId + str2);
            if (aVar == null) {
                RVLogger.d(f24181a, "sendSocketMessage error , no callback!!!");
                return a(WebSocketResultEnum.UNKNOW_ERROR);
            }
            aVar.a(page);
        }
        if (str == null) {
            RVLogger.e(f24181a, "Cannot send 'null' data to a WebSocket");
            return BridgeResponse.newError(3, "Cannot send 'null' data to a WebSocket");
        }
        try {
            if (z) {
                fVarB.a(str2, str.getBytes("utf-8"));
            } else {
                fVarB.a(str2, str);
            }
            return BridgeResponse.SUCCESS;
        } catch (Exception e) {
            RVLogger.e(f24181a, "send socket error!", e);
            return BridgeResponse.newError(3, "send socket error! " + e.getMessage());
        }
    }

    @Override // com.alibaba.ariver.kernel.api.node.NodeAware
    public void setNode(WeakReference<App> weakReference) {
        this.d = weakReference.get();
    }

    private BridgeResponse a(WebSocketResultEnum webSocketResultEnum) {
        return BridgeResponse.newError(webSocketResultEnum.getErrCode(), webSocketResultEnum.getErrMsg());
    }

    private String a(JSONArray jSONArray) {
        if (jSONArray == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        for (Object obj : jSONArray) {
            if (obj != null) {
                sb.append(obj.toString());
                sb.append(",");
            }
        }
        return sb.toString();
    }

    private Map<String, String> a(JSONObject jSONObject) {
        HashMap map = new HashMap();
        if (jSONObject != null) {
            try {
                if (!jSONObject.isEmpty()) {
                    for (Map.Entry<String, Object> entry : jSONObject.entrySet()) {
                        String key = entry.getKey();
                        if (!TextUtils.isEmpty(key)) {
                            map.put(key.toLowerCase(), String.valueOf(entry.getValue()));
                        }
                    }
                }
            } catch (Exception e) {
                RVLogger.e(f24181a, "get header error, exception : ", e);
            }
        }
        return map;
    }
}
