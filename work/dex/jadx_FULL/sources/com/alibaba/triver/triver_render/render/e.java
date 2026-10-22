package com.alibaba.triver.triver_render.render;

import android.os.Handler;
import android.taobao.windvane.extra.uc.WVUCWebChromeClient;
import android.text.TextUtils;
import android.util.Log;
import android.webkit.ConsoleMessage;
import androidx.annotation.NonNull;
import androidx.camera.video.AudioStats;
import com.alibaba.ariver.app.api.Page;
import com.alibaba.ariver.app.api.monitor.RVMonitor;
import com.alibaba.ariver.engine.api.bridge.NativeBridge;
import com.alibaba.ariver.engine.api.bridge.RenderBridge;
import com.alibaba.ariver.engine.api.bridge.model.NativeCallContext;
import com.alibaba.ariver.engine.api.bridge.model.RenderCallContext;
import com.alibaba.ariver.engine.api.bridge.model.SendToNativeCallback;
import com.alibaba.ariver.kernel.api.monitor.ErrId;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.utils.JSONUtils;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.triver.embed.video.fullscreenvideo.TriverEmbedVideoView;
import com.alibaba.triver.kit.api.appmonitor.LaunchMonitorData;
import com.alibaba.triver.kit.api.appmonitor.LaunchMonitorUtils;
import com.alibaba.triver.kit.api.appmonitor.TriverLaunchPointer;
import com.alibaba.triver.kit.api.common.TRiverConstants;
import com.alibaba.triver.kit.api.common.TriverAppMonitorConstants;
import com.alibaba.triver.kit.api.model.FrameType;
import com.alibaba.triver.kit.api.proxy.ITriverAppMonitorProxy;
import com.alibaba.triver.kit.api.proxy.ITriverToolsProxy;
import com.alibaba.triver.kit.api.utils.CommonUtils;
import com.alibaba.triver.kit.api.utils.TRiverUrlUtils;
import com.alibaba.triver.kit.api.utils.TRiverUtils;
import com.uc.webview.export.WebView;
import java.util.HashMap;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class e extends WVUCWebChromeClient {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f25207a = "TBWebEngine:" + e.class.getSimpleName();
    private static final String b = "h5container.message: ";
    private Page c;
    private NativeBridge d;
    private RenderBridge e;
    private Handler f;

    public e(Page page, NativeBridge nativeBridge, RenderBridge renderBridge, @NonNull Handler handler) {
        this.c = page;
        this.d = nativeBridge;
        this.e = renderBridge;
        this.f = handler;
    }

    @Override // android.taobao.windvane.extra.uc.WVUCWebChromeClient
    public boolean onConsoleMessage(final ConsoleMessage consoleMessage) {
        if (consoleMessage != null && this.c != null) {
            this.f.post(new Runnable() { // from class: com.alibaba.triver.triver_render.render.e.1
                @Override // java.lang.Runnable
                public void run() {
                    String strMessage = consoleMessage.message();
                    if (!TextUtils.isEmpty(strMessage) && strMessage.toLowerCase().contains("error") && !strMessage.contains("ShopComponentError") && !strMessage.contains(TriverEmbedVideoView.b)) {
                        HashMap map = new HashMap();
                        map.put(SendToNativeCallback.KEY_MESSAGE, strMessage);
                        if (e.this.c == null || !TRiverUrlUtils.isShop(e.this.c.getApp())) {
                            ((RVMonitor) RVProxy.get(RVMonitor.class)).error(null, ErrId.RV_TYPE_PAGE_ABNORMAL, "小程序-Render报错", "Render报错，页面白屏", new HashMap(), map);
                        } else {
                            ((RVMonitor) RVProxy.get(RVMonitor.class)).error(null, ErrId.RV_TYPE_PAGE_ABNORMAL, "店铺-Render报错", "Render报错，页面白屏", new HashMap(), map);
                        }
                        LaunchMonitorData subMonitorData = LaunchMonitorUtils.getSubMonitorData(e.this.c);
                        if (subMonitorData != null && !subMonitorData.containsKey(TriverAppMonitorConstants.KEY_RENDER_JS_ERROR)) {
                            subMonitorData.addPoint(TriverAppMonitorConstants.KEY_RENDER_JS_ERROR);
                        }
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("message", (Object) strMessage);
                        com.alibaba.triver.trace.b.a(com.alibaba.triver.trace.c.j, com.alibaba.triver.trace.c.aw, TRiverUtils.getSessionId(e.this.c), e.this.c, jSONObject);
                    }
                    if (e.this.c != null && e.this.c.getPageContext() != null && CommonUtils.isApkDebug()) {
                        ((RVMonitor) RVProxy.get(RVMonitor.class)).flowLog("MessageChannel::r2w", strMessage, "Render", "", "", null);
                    }
                    if (e.this.a(strMessage)) {
                        return;
                    }
                    e.super.onConsoleMessage(consoleMessage);
                }
            });
            return true;
        }
        RVLogger.d(f25207a, "onConsoleMessage input illegal: " + consoleMessage + ", " + this.c);
        return true;
    }

    @Override // android.taobao.windvane.extra.uc.WVUCWebChromeClient
    public void onReceivedTitle(WebView webView, String str) {
        super.onReceivedTitle(webView, str);
        if ((!TextUtils.isEmpty(str) && str.startsWith("http")) || this.c.getStartParams() == null || !this.c.getStartParams().containsKey("MINI-PROGRAM-WEB-VIEW-TAG") || this.c.getPageContext() == null || this.c.getPageContext().getTitleBar() == null || this.c.getApp() == null) {
            return;
        }
        if (FrameType.isTool(CommonUtils.getAppFrameType(this.c.getApp())) || FrameType.isPri(CommonUtils.getAppFrameType(this.c.getApp()))) {
            this.c.getPageContext().getTitleBar().setTitle(str, null, null, null, false);
        }
    }

    private boolean b(String str) {
        try {
            String str2 = h.a(this.c) + b;
            JSONObject object = JSONUtils.parseObject(str.startsWith(str2) ? str.replaceFirst(str2, "") : null);
            if (object != null && !object.isEmpty()) {
                String string = JSONUtils.getString(object, "clientId");
                String string2 = JSONUtils.getString(object, "func");
                JSONObject jSONObject = JSONUtils.getJSONObject(object, "param", null);
                if (!TextUtils.isEmpty(string)) {
                    return TextUtils.equals(string2, "internalAPI") && TextUtils.equals(jSONObject.getString("method"), "onAppPerfEvent");
                }
                RVLogger.d(f25207a, "isOnAppPerfEvent clientId is empty");
                return false;
            }
            RVLogger.d(f25207a, "isOnAppPerfEvent msgText json object is empty");
            return false;
        } catch (Exception e) {
            RVLogger.d(f25207a, "isOnAppPerfEvent called with exception : " + e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(String str) {
        Page page;
        String appId;
        if (TextUtils.isEmpty(str) || (page = this.c) == null || (page.isExited() && !b(str))) {
            return false;
        }
        String str2 = f25207a;
        RVLogger.e(str2, str);
        String str3 = h.a(this.c) + b;
        if (str.startsWith(str3)) {
            JSONObject object = JSONUtils.parseObject(str.replaceFirst(str3, ""));
            if (object != null && !object.isEmpty()) {
                final String string = JSONUtils.getString(object, "clientId");
                final String string2 = JSONUtils.getString(object, "func");
                final JSONObject jSONObject = JSONUtils.getJSONObject(object, "param", null);
                if (TextUtils.isEmpty(string)) {
                    RVLogger.d(str2, "clientId IS empty");
                    return false;
                }
                final NativeCallContext nativeCallContextBuild = new NativeCallContext.Builder().name(string2).params(jSONObject).node(this.c).id(string).render(this.c.getRender()).build();
                final long jCurrentTimeMillis = System.currentTimeMillis();
                this.d.sendToNative(nativeCallContextBuild, new SendToNativeCallback() { // from class: com.alibaba.triver.triver_render.render.e.2
                    @Override // com.alibaba.ariver.engine.api.bridge.model.SendToNativeCallback
                    public void onCallback(JSONObject jSONObject2, boolean z) {
                        int i = JSONUtils.getInt(jSONObject2, "error", 0);
                        if (i == 0) {
                            e.this.e.sendToRender(RenderCallContext.newBuilder(e.this.c.getRender()).action(string2).eventId(string).type(RenderCallContext.TYPE_CALLBACK).keep(false).param(jSONObject2).build(), null);
                            try {
                                if (((ITriverToolsProxy) RVProxy.get(ITriverToolsProxy.class)).isToolsOpen()) {
                                    ((RVMonitor) RVProxy.get(RVMonitor.class)).flowLog("RENDER_API_SUCCESS", nativeCallContextBuild.getId() + TRiverConstants.TOOL_SPLIT + string2 + TRiverConstants.TOOL_SPLIT + jSONObject + TRiverConstants.TOOL_SPLIT + e.this.c.getPageURI() + TRiverConstants.TOOL_SPLIT + "TimeCost=" + (System.currentTimeMillis() - jCurrentTimeMillis), "Api", (e.this.c == null || e.this.c.getApp() == null) ? "" : e.this.c.getApp().getAppId(), e.this.c != null ? e.this.c.getPageURI() : "", jSONObject2);
                                }
                                if (e.this.c == null || e.this.c.getApp() == null) {
                                    return;
                                }
                                ((ITriverAppMonitorProxy) RVProxy.get(ITriverAppMonitorProxy.class)).commitTriverJSAPI(TriverLaunchPointer.build().setApp(e.this.c.getApp()).setStartParams(e.this.c.getApp().getStartParams()).setStage("JSAPI").setStatus(Double.valueOf(1.0d)).create(), nativeCallContextBuild.getName(), Double.valueOf(i), "");
                                return;
                            } catch (Exception e) {
                                RVLogger.w(Log.getStackTraceString(e));
                                return;
                            }
                        }
                        e.this.e.sendToRender(RenderCallContext.newBuilder(e.this.c.getRender()).action(string2).eventId(string).type(RenderCallContext.TYPE_CALLBACK).keep(false).param(jSONObject2).build(), null);
                        try {
                            if (((ITriverToolsProxy) RVProxy.get(ITriverToolsProxy.class)).isToolsOpen()) {
                                ((RVMonitor) RVProxy.get(RVMonitor.class)).flowLog("RENDER_API_FAILED", nativeCallContextBuild.getId() + TRiverConstants.TOOL_SPLIT + string2 + TRiverConstants.TOOL_SPLIT + jSONObject + TRiverConstants.TOOL_SPLIT + e.this.c.getPageURI() + TRiverConstants.TOOL_SPLIT + string + TRiverConstants.TOOL_SPLIT + "TimeCost=" + (System.currentTimeMillis() - jCurrentTimeMillis), "Api", (e.this.c == null || e.this.c.getApp() == null) ? "" : e.this.c.getApp().getAppId(), e.this.c != null ? e.this.c.getPageURI() : "", jSONObject2);
                            }
                            if (e.this.c == null || e.this.c.getApp() == null) {
                                return;
                            }
                            ((ITriverAppMonitorProxy) RVProxy.get(ITriverAppMonitorProxy.class)).commitTriverJSAPI(TriverLaunchPointer.build().setApp(e.this.c.getApp()).setStartParams(e.this.c.getApp().getStartParams()).setStage("JSAPI").setStatus(Double.valueOf(AudioStats.AUDIO_AMPLITUDE_NONE)).create(), nativeCallContextBuild.getName(), Double.valueOf(i), jSONObject2.toJSONString());
                        } catch (Exception e2) {
                            RVLogger.w(Log.getStackTraceString(e2));
                        }
                    }
                });
                return true;
            }
            RVLogger.d(str2, "msgText json object is empty");
            return false;
        }
        if (!str.startsWith("invokeJS msgType") && !str.contains("load AlipayJSBridge") && this.c.getApp() != null) {
            if (("AppId/" + this.c.getApp()) != null) {
                appId = this.c.getApp().getAppId();
            } else {
                appId = "," + str;
            }
            RVLogger.d("NBH5AppContentLog", appId);
        }
        int iIndexOf = str.indexOf(b);
        if (iIndexOf >= 0 && str.length() > iIndexOf) {
            RVLogger.d(str2, "handleMsgFromJS token invalid! prefixStr = " + str.substring(0, iIndexOf));
        }
        return false;
    }
}
