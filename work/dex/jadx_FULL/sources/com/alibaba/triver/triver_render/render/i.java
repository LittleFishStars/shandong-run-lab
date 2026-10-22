package com.alibaba.triver.triver_render.render;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.net.http.SslError;
import android.taobao.windvane.extra.uc.WVUCWebViewClient;
import android.text.TextUtils;
import android.util.Log;
import com.alibaba.ariver.app.api.App;
import com.alibaba.ariver.app.api.Page;
import com.alibaba.ariver.app.api.monitor.RVMonitor;
import com.alibaba.ariver.app.api.ui.loading.SplashUtils;
import com.alibaba.ariver.app.api.ui.loading.SplashView;
import com.alibaba.ariver.engine.BaseRenderImpl;
import com.alibaba.ariver.engine.api.Render;
import com.alibaba.ariver.engine.api.common.CommonBackPerform;
import com.alibaba.ariver.engine.api.extensions.resources.model.ResourceLoadContext;
import com.alibaba.ariver.engine.api.resources.Resource;
import com.alibaba.ariver.engine.api.resources.ResourceLoadPoint;
import com.alibaba.ariver.kernel.api.extension.ExtensionPoint;
import com.alibaba.ariver.kernel.api.monitor.ErrId;
import com.alibaba.ariver.kernel.api.monitor.PerfId;
import com.alibaba.ariver.kernel.api.security.ApiPermissionCheckResult;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.utils.BundleUtils;
import com.alibaba.ariver.kernel.common.utils.IOUtils;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.ariver.mtop.monitor.RVCountDispatcher;
import com.alibaba.ariver.permission.api.proxy.AuthenticationProxy;
import com.alibaba.ariver.resource.api.content.OfflineResource;
import com.alibaba.ariver.resource.api.content.ResourceQuery;
import com.alibaba.ariver.resource.api.snapshot.RVSnapshotUtils;
import com.alibaba.ariver.resource.content.GlobalPackagePool;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.support.spring.FastJsonJsonView;
import com.alibaba.triver.kit.api.appmonitor.LaunchMonitorData;
import com.alibaba.triver.kit.api.appmonitor.LaunchMonitorUtils;
import com.alibaba.triver.kit.api.common.TriverAppMonitorConstants;
import com.alibaba.triver.kit.api.monitor.IPerformanceAndErrorTracker;
import com.alibaba.triver.kit.api.orange.TBShopOrangeController;
import com.alibaba.triver.kit.api.systemInfo.SystemInfoUtil;
import com.alibaba.triver.kit.api.utils.FileUtils;
import com.alibaba.triver.kit.api.utils.TRiverUrlUtils;
import com.alibaba.triver.kit.api.utils.TRiverUtils;
import com.aliyun.svideosdk.preview.camera.AliyunRecorderProperty;
import com.uc.webview.export.SslErrorHandler;
import com.uc.webview.export.WebResourceRequest;
import com.uc.webview.export.WebResourceResponse;
import com.uc.webview.export.WebView;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Set;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
class i extends WVUCWebViewClient {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f25223a = "REQUEST_FINISH";
    public static final String b = "alipayJsBridgeReadyJsInject";
    public static final String c = "https://hybrid.miniapp.taobao.com/index.js";
    private static final String d = "WVWebViewClient";
    private static final String g = "-9003";
    private static final String h = "SSL_ERROR";
    private Page e;
    private Render f;

    public i(Context context, Page page, Render render) {
        super(context);
        this.e = page;
        this.f = render;
    }

    public static byte[] a(byte[] bArr, byte[] bArr2) {
        if (bArr == null && bArr2 != null) {
            return bArr2;
        }
        if (bArr2 == null && bArr != null) {
            return bArr;
        }
        if (bArr == null && bArr2 == null) {
            return new byte[0];
        }
        byte[] bArr3 = new byte[bArr.length + bArr2.length];
        System.arraycopy(bArr, 0, bArr3, 0, bArr.length);
        System.arraycopy(bArr2, 0, bArr3, bArr.length, bArr2.length);
        return bArr3;
    }

    private String c() {
        return "\n(function() {\n    console.log(\"load AlipayJSBridge dispatchEvent AlipayJSBridgeReady start\")\n\tvar l = document.createEvent('Events');\n\tl.initEvent('AlipayJSBridgeReady', !1, !1);\n\tdocument.dispatchEvent(l);\n\tconsole.log(\"load AlipayJSBridge dispatchEvent AlipayJSBridgeReady end\")\n})()";
    }

    private byte[] d() {
        String str;
        byte[] bytes = null;
        try {
            str = "https://" + new URL(this.e.getPageURI()).getHost() + "/renderComponents.js";
        } catch (MalformedURLException e) {
            e.printStackTrace();
            str = null;
        }
        Resource resourceLoad = str != null ? ((ResourceLoadPoint) ExtensionPoint.as(ResourceLoadPoint.class).node(this.e).create()).load(ResourceLoadContext.newBuilder().originUrl(str).build()) : null;
        if (resourceLoad != null && (bytes = resourceLoad.getBytes()) != null) {
            RVLogger.d("ComponentJs", "componentJs in pkg.");
            return bytes;
        }
        String strE = a.e();
        if (strE != null) {
            bytes = strE.getBytes();
        }
        RVLogger.d("ComponentJs", "componentJs not in pkg.");
        return bytes;
    }

    public boolean b() {
        if (this.f.getView() instanceof WMLTRWebView) {
            return ((WMLTRWebView) this.f.getView()).l();
        }
        return false;
    }

    @Override // android.taobao.windvane.extra.uc.WVUCWebViewClient
    public void onPageFinished(WebView webView, String str) throws Throwable {
        CommonBackPerform backPerform;
        LaunchMonitorData launchMonitorData;
        super.onPageFinished(webView, str);
        Page page = this.e;
        if (page != null && page.getApp() != null && (this.e.getApp().getBooleanValue(TriverAppMonitorConstants.KEY_STAGE_SNAPSHOT_HIT) || this.e.getApp().getBooleanValue(TriverAppMonitorConstants.KEY_STAGE_TEMPLATE_SNAPSHOT_HIT))) {
            App app = this.e.getApp();
            if (app != null && app.getData(LaunchMonitorData.class) != null && (launchMonitorData = (LaunchMonitorData) app.getData(LaunchMonitorData.class)) != null && !launchMonitorData.containsKey("uc_t2_time")) {
                launchMonitorData.addPoint("uc_t2_time");
            }
            if (RVSnapshotUtils.isHomePage(app, this.e.getPageURI())) {
                try {
                    LaunchMonitorData subMonitorData = LaunchMonitorUtils.getSubMonitorData(this.e);
                    if (subMonitorData != null) {
                        subMonitorData.addPoint(TriverAppMonitorConstants.KEY_STAGE_SNAPSHOT_HIT);
                    }
                    if (this.e.getApp().getBooleanValue(TriverAppMonitorConstants.KEY_STAGE_TEMPLATE_SNAPSHOT_HIT) && subMonitorData != null) {
                        subMonitorData.addPoint(TriverAppMonitorConstants.KEY_STAGE_TEMPLATE_SNAPSHOT_HIT);
                    }
                    LaunchMonitorData pageMonitorData = LaunchMonitorUtils.getPageMonitorData(this.e);
                    if (pageMonitorData != null) {
                        pageMonitorData.addPoint(TriverAppMonitorConstants.KEY_STAGE_SNAPSHOT_HIT);
                    }
                    if (this.e.getApp().getBooleanValue(TriverAppMonitorConstants.KEY_STAGE_TEMPLATE_SNAPSHOT_HIT) && pageMonitorData != null) {
                        pageMonitorData.addPoint(TriverAppMonitorConstants.KEY_STAGE_TEMPLATE_SNAPSHOT_HIT);
                    }
                } catch (Exception unused) {
                    RVLogger.e(d, "snapshot hit monitor error!");
                }
            }
            if (SplashUtils.useSuperSplash(this.e.getApp().getStartParams())) {
                SplashView splashView = this.e.getApp().getAppContext() == null ? null : this.e.getApp().getAppContext().getSplashView();
                if (splashView != null && splashView.getStatus() == SplashView.Status.LOADING) {
                    splashView.exit(null);
                }
            }
            ((IPerformanceAndErrorTracker) RVProxy.get(IPerformanceAndErrorTracker.class)).sendPerfStageLog("[Snapshot]firstScreen", PerfId.firstScreen);
            ((IPerformanceAndErrorTracker) RVProxy.get(IPerformanceAndErrorTracker.class)).sendPerfStageLog("[Snapshot]firstScreenPaint", "firstScreenPaint");
        }
        if (webView.getCurrentViewCoreType() == 2) {
            RVLogger.e(d, "Using system core, inject");
            HashMap map = new HashMap();
            map.put("startupParams", BundleUtils.toJSONObject(this.e.getStartParams()).toString());
            Page page2 = this.e;
            webView.loadUrl(com.alibaba.ariver.remotedebug.b.k + h.b(map, page2, page2.getRender().getRenderId()));
        }
        Render render = this.f;
        if (render != null && (render instanceof BaseRenderImpl) && (backPerform = ((BaseRenderImpl) render).getBackPerform()) != null) {
            backPerform.updatePageStatus(CommonBackPerform.FINISHED);
        }
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("isPreload", (Object) AliyunRecorderProperty.SURFACE_ROTATION_MODE_FALSE);
        com.alibaba.triver.trace.b.a(com.alibaba.triver.trace.c.h, com.alibaba.triver.trace.c.aj, TRiverUtils.getSessionId(this.e), this.e, jSONObject);
        ((IPerformanceAndErrorTracker) RVProxy.get(IPerformanceAndErrorTracker.class)).sendPerfStageLog("Render", "End render load url");
    }

    @Override // android.taobao.windvane.extra.uc.WVUCWebViewClient
    public void onReceivedError(WebView webView, int i, String str, String str2) {
        Page page = this.e;
        if (page != null && page.getApp() != null) {
            RVCountDispatcher.e eVar = new RVCountDispatcher.e();
            eVar.g = 2;
            ((RVCountDispatcher) RVProxy.get(RVCountDispatcher.class)).dispatch(eVar);
        }
        new JSONObject().put("failingUrl", (Object) str2);
        com.alibaba.triver.trace.b.a(com.alibaba.triver.trace.c.h, com.alibaba.triver.trace.c.an, TRiverUtils.getSessionId(this.e), this.e, String.valueOf(i), str, (JSONObject) null);
    }

    @Override // android.taobao.windvane.extra.uc.WVUCWebViewClient
    public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
        try {
            JSONObject jSONObject = new JSONObject();
            if (sslError != null) {
                jSONObject.put("url", (Object) sslError.getUrl());
            }
            com.alibaba.triver.trace.b.a(com.alibaba.triver.trace.c.h, com.alibaba.triver.trace.c.ao, TRiverUtils.getSessionId(this.e), this.e, g, h, jSONObject);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX WARN: Code duplicated, block: B:127:0x0285  */
    /* JADX WARN: Code duplicated, block: B:134:0x02c4 A[Catch: Exception -> 0x031f, TryCatch #10 {Exception -> 0x031f, blocks: (B:132:0x02c0, B:134:0x02c4, B:136:0x02ce), top: B:257:0x02c0 }] */
    /* JADX WARN: Code duplicated, block: B:149:0x031a  */
    /* JADX WARN: Code duplicated, block: B:154:0x0356  */
    /* JADX WARN: Code duplicated, block: B:158:0x0380 A[Catch: Exception -> 0x03b1, TryCatch #9 {Exception -> 0x03b1, blocks: (B:156:0x0378, B:158:0x0380, B:160:0x0386, B:163:0x038e, B:165:0x0398), top: B:255:0x0378 }] */
    /* JADX WARN: Code duplicated, block: B:171:0x03e4 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:186:0x043c  */
    /* JADX WARN: Code duplicated, block: B:194:0x0477 A[Catch: Exception -> 0x048b, TryCatch #2 {Exception -> 0x048b, blocks: (B:192:0x0460, B:194:0x0477, B:196:0x0482), top: B:241:0x0460 }] */
    /* JADX WARN: Code duplicated, block: B:202:0x0493  */
    /* JADX WARN: Code duplicated, block: B:205:0x04f1 A[Catch: all -> 0x0519, TryCatch #13 {all -> 0x0519, blocks: (B:203:0x04c6, B:205:0x04f1, B:207:0x04f7, B:209:0x0506, B:211:0x050a, B:213:0x0513), top: B:263:0x04c6 }] */
    /* JADX WARN: Code duplicated, block: B:208:0x0504  */
    /* JADX WARN: Code duplicated, block: B:211:0x050a A[Catch: all -> 0x0519, TryCatch #13 {all -> 0x0519, blocks: (B:203:0x04c6, B:205:0x04f1, B:207:0x04f7, B:209:0x0506, B:211:0x050a, B:213:0x0513), top: B:263:0x04c6 }] */
    /* JADX WARN: Code duplicated, block: B:212:0x0511  */
    /* JADX WARN: Code duplicated, block: B:218:0x051e  */
    /* JADX WARN: Code duplicated, block: B:222:0x0542 A[Catch: all -> 0x0567, TryCatch #3 {all -> 0x0567, blocks: (B:220:0x0524, B:222:0x0542, B:224:0x0548, B:226:0x0556, B:228:0x055a, B:230:0x0562), top: B:243:0x0524 }] */
    /* JADX WARN: Code duplicated, block: B:225:0x0554  */
    /* JADX WARN: Code duplicated, block: B:228:0x055a A[Catch: all -> 0x0567, TryCatch #3 {all -> 0x0567, blocks: (B:220:0x0524, B:222:0x0542, B:224:0x0548, B:226:0x0556, B:228:0x055a, B:230:0x0562), top: B:243:0x0524 }] */
    /* JADX WARN: Code duplicated, block: B:229:0x0560  */
    /* JADX WARN: Code duplicated, block: B:235:0x056c A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:243:0x0524 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:255:0x0378 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:94:0x01bd  */
    /* JADX WARN: Instruction removed from duplicated block: B:202:0x0493, please report this as an issue */
    @Override // android.taobao.windvane.extra.uc.WVUCWebViewClient
    public WebResourceResponse shouldInterceptRequest(WebView webView, WebResourceRequest webResourceRequest) {
        CharSequence charSequence;
        String str;
        CharSequence charSequence2;
        Resource offlineResource;
        String str2;
        String str3;
        CharSequence charSequence3;
        String str4;
        WebResourceResponse webResourceResponseShouldInterceptRequest;
        Page page;
        String appId;
        Page page2;
        String pageURI;
        Page page3;
        String appId2;
        Page page4;
        String pageURI2;
        File file;
        byte[] toByte;
        Page page5;
        Page page6;
        LaunchMonitorData subMonitorData;
        Resource resource;
        byte[] bArrA;
        Class<ResourceLoadPoint> cls = ResourceLoadPoint.class;
        Page page7 = this.e;
        if (page7 != null && page7.getApp() != null) {
            RVCountDispatcher.e eVar = new RVCountDispatcher.e();
            eVar.g = 1;
            ((RVCountDispatcher) RVProxy.get(RVCountDispatcher.class)).dispatch(eVar);
        }
        String string = webResourceRequest.getUrl() != null ? webResourceRequest.getUrl().toString() : "";
        if (!TextUtils.isEmpty(string) && string.contains("af-appx.min.css") && b()) {
            return null;
        }
        if (!TextUtils.isEmpty(string) && string.contains("af-appx.min.js") && b()) {
            return null;
        }
        if (!TextUtils.isEmpty(string) && string.contains("templateSnapshot.js") && b()) {
            return null;
        }
        if (a(string) && b()) {
            WebResourceResponse webResourceResponse = new WebResourceResponse(FastJsonJsonView.DEFAULT_JSONP_CONTENT_TYPE, "utf-8", new ByteArrayInputStream("//This plugin resource has already execute.\n".getBytes()));
            HashMap map = new HashMap();
            map.put("Access-Control-Allow-Origin", "*");
            map.put("Cache-Control", "no-cache");
            webResourceResponse.setResponseHeaders(map);
            return webResourceResponse;
        }
        Page page8 = this.e;
        try {
            try {
                if (page8 == null || page8.getApp() == null || !TRiverUrlUtils.isShop(this.e.getApp()) || !string.startsWith("https://appx/af-appx.min.js")) {
                    charSequence = "hybrid.miniapp.taobao.com/index.html";
                    str = "";
                    charSequence2 = "https://appx/af-appx.min.js";
                } else {
                    byte[] bArrD = d();
                    str = "";
                    charSequence2 = "https://appx/af-appx.min.js";
                    offlineResource = GlobalPackagePool.getInstance().get(ResourceQuery.asUrl("https://appx/af-appx.min.js"));
                    if (offlineResource != null && offlineResource.getBytes().length > 0) {
                        charSequence = "hybrid.miniapp.taobao.com/index.html";
                        if ((offlineResource.getHeaders() == null || !offlineResource.getHeaders().containsKey("componentJS")) && (bArrA = a(offlineResource.getBytes(), bArrD)) != null && bArrA.length > 0) {
                            offlineResource.setBytes(bArrA);
                            offlineResource.addHeader("componentJS", "true");
                        }
                        if (!TextUtils.isEmpty(string) || !string.contains("hybrid.miniapp.taobao.com/templateSnapshot.js") || b()) {
                            cls = cls;
                            str2 = "true";
                            str3 = string;
                        } else {
                            if (!TBShopOrangeController.enableTemplateJs()) {
                                return null;
                            }
                            offlineResource = ((ResourceLoadPoint) ExtensionPoint.as(cls).node(this.e).create()).load(ResourceLoadContext.newBuilder().originUrl(string).build());
                            try {
                                String strA = g.a(this.e);
                                String systemInfoInner = SystemInfoUtil.getSystemInfoInner(this.e);
                                if (offlineResource != null && !TextUtils.isEmpty(strA) && !TextUtils.isEmpty(systemInfoInner)) {
                                    Page page9 = this.e;
                                    if (page9 != null) {
                                        try {
                                            if (page9.getApp() == null || this.e.getApp().getAppContext() == null || this.e.getApp().getAppContext().getSplashView() == null) {
                                                str2 = "true";
                                            } else {
                                                str2 = "true";
                                                try {
                                                    this.e.getApp().getAppContext().getSplashView().exit(null);
                                                } catch (Exception e) {
                                                    e = e;
                                                    cls = cls;
                                                    str3 = string;
                                                    RVLogger.e(d, e);
                                                    HashMap map2 = new HashMap();
                                                    map2.put(com.alibaba.triver.triver_render.view.canvas.tinyapp.c.f25231a, e.toString());
                                                    ((RVMonitor) RVProxy.get(RVMonitor.class)).error(a(), ErrId.RV_TYPE_PAGE_ABNORMAL, "店铺-快照失败", "白屏-快照失败", new HashMap(), map2);
                                                    page6 = this.e;
                                                    if (page6 == null) {
                                                        charSequence3 = charSequence;
                                                        str4 = str3;
                                                    } else {
                                                        charSequence3 = charSequence;
                                                        str4 = str3;
                                                    }
                                                    if (offlineResource == null) {
                                                        offlineResource = ((ResourceLoadPoint) ExtensionPoint.as(cls).node(this.e).create()).load(ResourceLoadContext.newBuilder().originUrl(str4).build());
                                                    }
                                                    if (offlineResource != null) {
                                                        try {
                                                            if (str4.equals(c)) {
                                                                offlineResource.setBytes(a(offlineResource.getBytes(), c().getBytes()));
                                                                offlineResource.addHeader(b, str2);
                                                            }
                                                        } catch (Exception e2) {
                                                            RVLogger.e(d, e2);
                                                            HashMap map3 = new HashMap();
                                                            map3.put(com.alibaba.triver.triver_render.view.canvas.tinyapp.c.f25231a, e2.toString());
                                                            ((RVMonitor) RVProxy.get(RVMonitor.class)).error(a(), ErrId.RV_TYPE_PAGE_ABNORMAL, "小程序-白屏1", "AlipayJSBridgeReady执行失败", new HashMap(), map3);
                                                        }
                                                    }
                                                    if (!TextUtils.isEmpty(str4)) {
                                                        HashMap map4 = new HashMap();
                                                        map4.put("resourceUrl", str4);
                                                        ((RVMonitor) RVProxy.get(RVMonitor.class)).error(this.e, ErrId.RV_TYPE_PAGE_ABNORMAL, "小程序-白屏2", "白屏-页面资源丢失", new HashMap(), map4);
                                                    }
                                                    if (offlineResource == null) {
                                                        try {
                                                            file = new File(FileUtils.apUrlToFilePath(webResourceRequest.getUrl().toString()));
                                                            if (file.exists()) {
                                                                offlineResource = new OfflineResource(str4, toByte, "image/jpeg");
                                                            }
                                                        } catch (Exception e3) {
                                                            RVLogger.e(d, e3);
                                                        }
                                                    }
                                                    if (offlineResource != null) {
                                                        webResourceResponseShouldInterceptRequest = super.shouldInterceptRequest(webView, webResourceRequest);
                                                        if (webResourceResponseShouldInterceptRequest != null) {
                                                            return null;
                                                        }
                                                        try {
                                                            RVMonitor rVMonitor = (RVMonitor) RVProxy.get(RVMonitor.class);
                                                            String str5 = "request finish: " + str4;
                                                            page = this.e;
                                                            if (page != null) {
                                                                appId = str;
                                                            } else {
                                                                appId = str;
                                                            }
                                                            page2 = this.e;
                                                            if (page2 != null) {
                                                                pageURI = page2.getPageURI();
                                                            } else {
                                                                pageURI = str;
                                                            }
                                                            rVMonitor.flowLog(f25223a, str5, "Render", appId, pageURI, null);
                                                        } catch (Throwable th) {
                                                            RVLogger.e(d, th);
                                                        }
                                                        return webResourceResponseShouldInterceptRequest;
                                                    }
                                                    RVLogger.d(d, "shouldInterceptRequest got resource: " + offlineResource);
                                                    WebResourceResponse webResourceResponse2 = new WebResourceResponse(offlineResource.getMimeType(), offlineResource.getEncoding(), offlineResource.getStream());
                                                    HashMap map5 = new HashMap();
                                                    map5.put("Access-Control-Allow-Origin", "*");
                                                    map5.put("Cache-Control", "no-cache");
                                                    webResourceResponse2.setResponseHeaders(map5);
                                                    try {
                                                        HashMap map6 = new HashMap();
                                                        map6.put("from", "intercept");
                                                        RVMonitor rVMonitor2 = (RVMonitor) RVProxy.get(RVMonitor.class);
                                                        String str6 = "request finish: " + str4;
                                                        page3 = this.e;
                                                        if (page3 != null) {
                                                            appId2 = str;
                                                        } else {
                                                            appId2 = str;
                                                        }
                                                        page4 = this.e;
                                                        if (page4 != null) {
                                                            pageURI2 = page4.getPageURI();
                                                        } else {
                                                            pageURI2 = str;
                                                        }
                                                        rVMonitor2.flowLog(f25223a, str6, "Render", appId2, pageURI2, map6);
                                                    } catch (Throwable th2) {
                                                        RVLogger.e(d, th2);
                                                    }
                                                    return webResourceResponse2;
                                                }
                                            }
                                        } catch (Exception e4) {
                                            e = e4;
                                            str2 = "true";
                                        }
                                    } else {
                                        str2 = "true";
                                    }
                                    try {
                                        String str7 = ";(typeof window.renderTemplateSnapshot === 'function') && window.renderTemplateSnapshot({data:'" + strA + "',systemInfo:'" + systemInfoInner + "'});";
                                        String str8 = IOUtils.read(offlineResource.getStream());
                                        if (TextUtils.isEmpty(str8)) {
                                            cls = cls;
                                            resource = offlineResource;
                                            str3 = string;
                                        } else {
                                            resource = offlineResource;
                                            try {
                                                JSONObject jSONObject = new JSONObject();
                                                cls = cls;
                                                try {
                                                    jSONObject.put("templateSnapshotData", (Object) strA);
                                                    jSONObject.put("systemInfoData", (Object) systemInfoInner);
                                                    str3 = string;
                                                    try {
                                                        com.alibaba.triver.trace.b.a(com.alibaba.triver.trace.c.h, com.alibaba.triver.trace.c.al, TRiverUtils.getSessionId(this.e), this.e, jSONObject);
                                                    } catch (Exception e5) {
                                                        e = e5;
                                                        offlineResource = resource;
                                                        RVLogger.e(d, e);
                                                        HashMap map7 = new HashMap();
                                                        map7.put(com.alibaba.triver.triver_render.view.canvas.tinyapp.c.f25231a, e.toString());
                                                        ((RVMonitor) RVProxy.get(RVMonitor.class)).error(a(), ErrId.RV_TYPE_PAGE_ABNORMAL, "店铺-快照失败", "白屏-快照失败", new HashMap(), map7);
                                                        page6 = this.e;
                                                        if (page6 == null) {
                                                            charSequence3 = charSequence;
                                                            str4 = str3;
                                                        } else {
                                                            charSequence3 = charSequence;
                                                            str4 = str3;
                                                        }
                                                        if (offlineResource == null) {
                                                            offlineResource = ((ResourceLoadPoint) ExtensionPoint.as(cls).node(this.e).create()).load(ResourceLoadContext.newBuilder().originUrl(str4).build());
                                                        }
                                                        if (offlineResource != null) {
                                                            if (str4.equals(c)) {
                                                                offlineResource.setBytes(a(offlineResource.getBytes(), c().getBytes()));
                                                                offlineResource.addHeader(b, str2);
                                                            }
                                                        }
                                                        if (!TextUtils.isEmpty(str4)) {
                                                            HashMap map8 = new HashMap();
                                                            map8.put("resourceUrl", str4);
                                                            ((RVMonitor) RVProxy.get(RVMonitor.class)).error(this.e, ErrId.RV_TYPE_PAGE_ABNORMAL, "小程序-白屏2", "白屏-页面资源丢失", new HashMap(), map8);
                                                        }
                                                        if (offlineResource == null) {
                                                            file = new File(FileUtils.apUrlToFilePath(webResourceRequest.getUrl().toString()));
                                                            if (file.exists()) {
                                                                offlineResource = new OfflineResource(str4, toByte, "image/jpeg");
                                                            }
                                                        }
                                                        if (offlineResource != null) {
                                                            webResourceResponseShouldInterceptRequest = super.shouldInterceptRequest(webView, webResourceRequest);
                                                            if (webResourceResponseShouldInterceptRequest != null) {
                                                                return null;
                                                            }
                                                            RVMonitor rVMonitor3 = (RVMonitor) RVProxy.get(RVMonitor.class);
                                                            String str9 = "request finish: " + str4;
                                                            page = this.e;
                                                            if (page != null) {
                                                                appId = str;
                                                            } else {
                                                                appId = str;
                                                            }
                                                            page2 = this.e;
                                                            if (page2 != null) {
                                                                pageURI = page2.getPageURI();
                                                            } else {
                                                                pageURI = str;
                                                            }
                                                            rVMonitor3.flowLog(f25223a, str9, "Render", appId, pageURI, null);
                                                            return webResourceResponseShouldInterceptRequest;
                                                        }
                                                        RVLogger.d(d, "shouldInterceptRequest got resource: " + offlineResource);
                                                        WebResourceResponse webResourceResponse3 = new WebResourceResponse(offlineResource.getMimeType(), offlineResource.getEncoding(), offlineResource.getStream());
                                                        HashMap map9 = new HashMap();
                                                        map9.put("Access-Control-Allow-Origin", "*");
                                                        map9.put("Cache-Control", "no-cache");
                                                        webResourceResponse3.setResponseHeaders(map9);
                                                        HashMap map10 = new HashMap();
                                                        map10.put("from", "intercept");
                                                        RVMonitor rVMonitor4 = (RVMonitor) RVProxy.get(RVMonitor.class);
                                                        String str10 = "request finish: " + str4;
                                                        page3 = this.e;
                                                        if (page3 != null) {
                                                            appId2 = str;
                                                        } else {
                                                            appId2 = str;
                                                        }
                                                        page4 = this.e;
                                                        if (page4 != null) {
                                                            pageURI2 = page4.getPageURI();
                                                        } else {
                                                            pageURI2 = str;
                                                        }
                                                        rVMonitor4.flowLog(f25223a, str10, "Render", appId2, pageURI2, map10);
                                                        return webResourceResponse3;
                                                    }
                                                } catch (Exception e6) {
                                                    e = e6;
                                                    str3 = string;
                                                    offlineResource = resource;
                                                    RVLogger.e(d, e);
                                                    HashMap map11 = new HashMap();
                                                    map11.put(com.alibaba.triver.triver_render.view.canvas.tinyapp.c.f25231a, e.toString());
                                                    ((RVMonitor) RVProxy.get(RVMonitor.class)).error(a(), ErrId.RV_TYPE_PAGE_ABNORMAL, "店铺-快照失败", "白屏-快照失败", new HashMap(), map11);
                                                    page6 = this.e;
                                                    if (page6 == null) {
                                                        charSequence3 = charSequence;
                                                        str4 = str3;
                                                    } else {
                                                        charSequence3 = charSequence;
                                                        str4 = str3;
                                                    }
                                                    if (offlineResource == null) {
                                                        offlineResource = ((ResourceLoadPoint) ExtensionPoint.as(cls).node(this.e).create()).load(ResourceLoadContext.newBuilder().originUrl(str4).build());
                                                    }
                                                    if (offlineResource != null) {
                                                        if (str4.equals(c)) {
                                                            offlineResource.setBytes(a(offlineResource.getBytes(), c().getBytes()));
                                                            offlineResource.addHeader(b, str2);
                                                        }
                                                    }
                                                    if (!TextUtils.isEmpty(str4)) {
                                                        HashMap map12 = new HashMap();
                                                        map12.put("resourceUrl", str4);
                                                        ((RVMonitor) RVProxy.get(RVMonitor.class)).error(this.e, ErrId.RV_TYPE_PAGE_ABNORMAL, "小程序-白屏2", "白屏-页面资源丢失", new HashMap(), map12);
                                                    }
                                                    if (offlineResource == null) {
                                                        file = new File(FileUtils.apUrlToFilePath(webResourceRequest.getUrl().toString()));
                                                        if (file.exists()) {
                                                            offlineResource = new OfflineResource(str4, toByte, "image/jpeg");
                                                        }
                                                    }
                                                    if (offlineResource != null) {
                                                        webResourceResponseShouldInterceptRequest = super.shouldInterceptRequest(webView, webResourceRequest);
                                                        if (webResourceResponseShouldInterceptRequest != null) {
                                                            return null;
                                                        }
                                                        RVMonitor rVMonitor5 = (RVMonitor) RVProxy.get(RVMonitor.class);
                                                        String str11 = "request finish: " + str4;
                                                        page = this.e;
                                                        if (page != null) {
                                                            appId = str;
                                                        } else {
                                                            appId = str;
                                                        }
                                                        page2 = this.e;
                                                        if (page2 != null) {
                                                            pageURI = page2.getPageURI();
                                                        } else {
                                                            pageURI = str;
                                                        }
                                                        rVMonitor5.flowLog(f25223a, str11, "Render", appId, pageURI, null);
                                                        return webResourceResponseShouldInterceptRequest;
                                                    }
                                                    RVLogger.d(d, "shouldInterceptRequest got resource: " + offlineResource);
                                                    WebResourceResponse webResourceResponse4 = new WebResourceResponse(offlineResource.getMimeType(), offlineResource.getEncoding(), offlineResource.getStream());
                                                    HashMap map13 = new HashMap();
                                                    map13.put("Access-Control-Allow-Origin", "*");
                                                    map13.put("Cache-Control", "no-cache");
                                                    webResourceResponse4.setResponseHeaders(map13);
                                                    HashMap map14 = new HashMap();
                                                    map14.put("from", "intercept");
                                                    RVMonitor rVMonitor6 = (RVMonitor) RVProxy.get(RVMonitor.class);
                                                    String str12 = "request finish: " + str4;
                                                    page3 = this.e;
                                                    if (page3 != null) {
                                                        appId2 = str;
                                                    } else {
                                                        appId2 = str;
                                                    }
                                                    page4 = this.e;
                                                    if (page4 != null) {
                                                        pageURI2 = page4.getPageURI();
                                                    } else {
                                                        pageURI2 = str;
                                                    }
                                                    rVMonitor6.flowLog(f25223a, str12, "Render", appId2, pageURI2, map14);
                                                    return webResourceResponse4;
                                                }
                                            } catch (Exception e7) {
                                                e = e7;
                                                cls = cls;
                                            }
                                        }
                                        WebResourceResponse webResourceResponse5 = new WebResourceResponse(FastJsonJsonView.DEFAULT_JSONP_CONTENT_TYPE, "uft-8", new ByteArrayInputStream((str8 + str7).getBytes()));
                                        HashMap map15 = new HashMap();
                                        map15.put("Access-Control-Allow-Origin", "*");
                                        map15.put("Cache-Control", "no-cache");
                                        webResourceResponse5.setResponseHeaders(map15);
                                        LaunchMonitorData subMonitorData2 = LaunchMonitorUtils.getSubMonitorData(this.e);
                                        if (subMonitorData2 != null) {
                                            subMonitorData2.addPoint(TriverAppMonitorConstants.KEY_STAGE_TEMPLATE_SNAPSHOT_RENDER_HIT);
                                        }
                                        LaunchMonitorData pageMonitorData = LaunchMonitorUtils.getPageMonitorData(this.e);
                                        if (pageMonitorData != null) {
                                            pageMonitorData.addPoint(TriverAppMonitorConstants.KEY_STAGE_TEMPLATE_SNAPSHOT_RENDER_HIT);
                                        }
                                        return webResourceResponse5;
                                    } catch (Exception e8) {
                                        e = e8;
                                        str3 = string;
                                        RVLogger.e(d, e);
                                        HashMap map16 = new HashMap();
                                        map16.put(com.alibaba.triver.triver_render.view.canvas.tinyapp.c.f25231a, e.toString());
                                        ((RVMonitor) RVProxy.get(RVMonitor.class)).error(a(), ErrId.RV_TYPE_PAGE_ABNORMAL, "店铺-快照失败", "白屏-快照失败", new HashMap(), map16);
                                        page6 = this.e;
                                        if (page6 == null) {
                                            charSequence3 = charSequence;
                                            str4 = str3;
                                        } else {
                                            charSequence3 = charSequence;
                                            str4 = str3;
                                        }
                                        if (offlineResource == null) {
                                            offlineResource = ((ResourceLoadPoint) ExtensionPoint.as(cls).node(this.e).create()).load(ResourceLoadContext.newBuilder().originUrl(str4).build());
                                        }
                                        if (offlineResource != null) {
                                            if (str4.equals(c)) {
                                                offlineResource.setBytes(a(offlineResource.getBytes(), c().getBytes()));
                                                offlineResource.addHeader(b, str2);
                                            }
                                        }
                                        if (!TextUtils.isEmpty(str4)) {
                                            HashMap map17 = new HashMap();
                                            map17.put("resourceUrl", str4);
                                            ((RVMonitor) RVProxy.get(RVMonitor.class)).error(this.e, ErrId.RV_TYPE_PAGE_ABNORMAL, "小程序-白屏2", "白屏-页面资源丢失", new HashMap(), map17);
                                        }
                                        if (offlineResource == null) {
                                            file = new File(FileUtils.apUrlToFilePath(webResourceRequest.getUrl().toString()));
                                            if (file.exists()) {
                                                offlineResource = new OfflineResource(str4, toByte, "image/jpeg");
                                            }
                                        }
                                        if (offlineResource != null) {
                                            webResourceResponseShouldInterceptRequest = super.shouldInterceptRequest(webView, webResourceRequest);
                                            if (webResourceResponseShouldInterceptRequest != null) {
                                                return null;
                                            }
                                            RVMonitor rVMonitor7 = (RVMonitor) RVProxy.get(RVMonitor.class);
                                            String str13 = "request finish: " + str4;
                                            page = this.e;
                                            if (page != null) {
                                                appId = str;
                                            } else {
                                                appId = str;
                                            }
                                            page2 = this.e;
                                            if (page2 != null) {
                                                pageURI = page2.getPageURI();
                                            } else {
                                                pageURI = str;
                                            }
                                            rVMonitor7.flowLog(f25223a, str13, "Render", appId, pageURI, null);
                                            return webResourceResponseShouldInterceptRequest;
                                        }
                                        RVLogger.d(d, "shouldInterceptRequest got resource: " + offlineResource);
                                        WebResourceResponse webResourceResponse6 = new WebResourceResponse(offlineResource.getMimeType(), offlineResource.getEncoding(), offlineResource.getStream());
                                        HashMap map18 = new HashMap();
                                        map18.put("Access-Control-Allow-Origin", "*");
                                        map18.put("Cache-Control", "no-cache");
                                        webResourceResponse6.setResponseHeaders(map18);
                                        HashMap map19 = new HashMap();
                                        map19.put("from", "intercept");
                                        RVMonitor rVMonitor8 = (RVMonitor) RVProxy.get(RVMonitor.class);
                                        String str14 = "request finish: " + str4;
                                        page3 = this.e;
                                        if (page3 != null) {
                                            appId2 = str;
                                        } else {
                                            appId2 = str;
                                        }
                                        page4 = this.e;
                                        if (page4 != null) {
                                            pageURI2 = page4.getPageURI();
                                        } else {
                                            pageURI2 = str;
                                        }
                                        rVMonitor8.flowLog(f25223a, str14, "Render", appId2, pageURI2, map19);
                                        return webResourceResponse6;
                                    }
                                }
                                cls = cls;
                                str2 = "true";
                                str3 = string;
                                offlineResource = offlineResource;
                            } catch (Exception e9) {
                                e = e9;
                                str2 = "true";
                            }
                        }
                        page6 = this.e;
                        if (page6 == null && TBShopOrangeController.enableNSR(page6.getApp()) && !b()) {
                            charSequence3 = charSequence;
                            str4 = str3;
                            try {
                                if (str4.contains(charSequence3) && (offlineResource = ((ResourceLoadPoint) ExtensionPoint.as(cls).node(this.e).create()).load(ResourceLoadContext.newBuilder().originUrl(str4.replace("index.html", "templateSnapshot.html")).build())) != null && (subMonitorData = LaunchMonitorUtils.getSubMonitorData(this.e)) != null) {
                                    subMonitorData.addPoint(TriverAppMonitorConstants.KEY_STAGE_TEMPLATE_SNAPSHOT_HIT);
                                }
                            } catch (Exception e10) {
                                e = e10;
                                RVLogger.e(d, e);
                                RVLogger.e(d, e);
                                HashMap map20 = new HashMap();
                                map20.put(com.alibaba.triver.triver_render.view.canvas.tinyapp.c.f25231a, e.toString());
                                ((RVMonitor) RVProxy.get(RVMonitor.class)).error(a(), ErrId.RV_TYPE_PAGE_ABNORMAL, "店铺—骨架屏加载失败", "白屏-骨架屏失败", new HashMap(), map20);
                            }
                        } else {
                            charSequence3 = charSequence;
                            str4 = str3;
                        }
                        if (offlineResource == null) {
                            offlineResource = ((ResourceLoadPoint) ExtensionPoint.as(cls).node(this.e).create()).load(ResourceLoadContext.newBuilder().originUrl(str4).build());
                        }
                        if (offlineResource != null) {
                            if (str4.equals(c) && b() && (offlineResource.getHeaders() == null || !offlineResource.getHeaders().containsKey(b))) {
                                offlineResource.setBytes(a(offlineResource.getBytes(), c().getBytes()));
                                offlineResource.addHeader(b, str2);
                            }
                        }
                        if (!TextUtils.isEmpty(str4) && ((offlineResource == null || offlineResource.getBytes().length < 1) && (page5 = this.e) != null && !TRiverUrlUtils.isShop(page5.getApp()) && (str4.contains(charSequence2) || str4.contains(charSequence3) || str4.contains("hybrid.miniapp.taobao.com/index.js")))) {
                            HashMap map110 = new HashMap();
                            map110.put("resourceUrl", str4);
                            ((RVMonitor) RVProxy.get(RVMonitor.class)).error(this.e, ErrId.RV_TYPE_PAGE_ABNORMAL, "小程序-白屏2", "白屏-页面资源丢失", new HashMap(), map110);
                        }
                        if (offlineResource == null && webResourceRequest.getUrl() != null && !TextUtils.isEmpty(webResourceRequest.getUrl().toString()) && webResourceRequest.getUrl().toString().startsWith(com.alibaba.ariver.commonability.file.g.e)) {
                            file = new File(FileUtils.apUrlToFilePath(webResourceRequest.getUrl().toString()));
                            if (file.exists() && (toByte = IOUtils.readToByte(new FileInputStream(file))) != null) {
                                offlineResource = new OfflineResource(str4, toByte, "image/jpeg");
                            }
                        }
                        if (offlineResource != null) {
                            webResourceResponseShouldInterceptRequest = super.shouldInterceptRequest(webView, webResourceRequest);
                            if (webResourceResponseShouldInterceptRequest != null) {
                                return null;
                            }
                            RVMonitor rVMonitor9 = (RVMonitor) RVProxy.get(RVMonitor.class);
                            String str15 = "request finish: " + str4;
                            page = this.e;
                            if (page != null || page.getApp() == null) {
                                appId = str;
                            } else {
                                appId = this.e.getApp().getAppId();
                            }
                            page2 = this.e;
                            if (page2 != null) {
                                pageURI = page2.getPageURI();
                            } else {
                                pageURI = str;
                            }
                            rVMonitor9.flowLog(f25223a, str15, "Render", appId, pageURI, null);
                            return webResourceResponseShouldInterceptRequest;
                        }
                        RVLogger.d(d, "shouldInterceptRequest got resource: " + offlineResource);
                        WebResourceResponse webResourceResponse7 = new WebResourceResponse(offlineResource.getMimeType(), offlineResource.getEncoding(), offlineResource.getStream());
                        HashMap map111 = new HashMap();
                        map111.put("Access-Control-Allow-Origin", "*");
                        map111.put("Cache-Control", "no-cache");
                        webResourceResponse7.setResponseHeaders(map111);
                        HashMap map112 = new HashMap();
                        map112.put("from", "intercept");
                        RVMonitor rVMonitor10 = (RVMonitor) RVProxy.get(RVMonitor.class);
                        String str16 = "request finish: " + str4;
                        page3 = this.e;
                        if (page3 != null || page3.getApp() == null) {
                            appId2 = str;
                        } else {
                            appId2 = this.e.getApp().getAppId();
                        }
                        page4 = this.e;
                        if (page4 != null) {
                            pageURI2 = page4.getPageURI();
                        } else {
                            pageURI2 = str;
                        }
                        rVMonitor10.flowLog(f25223a, str16, "Render", appId2, pageURI2, map112);
                        return webResourceResponse7;
                    }
                    charSequence = "hybrid.miniapp.taobao.com/index.html";
                }
                page6 = this.e;
                if (page6 == null) {
                    charSequence3 = charSequence;
                    str4 = str3;
                } else {
                    charSequence3 = charSequence;
                    str4 = str3;
                }
            } catch (Exception e11) {
                e = e11;
                charSequence3 = charSequence;
                str4 = str3;
            }
            if (!TextUtils.isEmpty(string)) {
                cls = cls;
                str2 = "true";
                str3 = string;
            } else {
                cls = cls;
                str2 = "true";
                str3 = string;
            }
        } catch (Exception e12) {
            e = e12;
            cls = cls;
            str2 = "true";
        }
        offlineResource = null;
        if (offlineResource == null) {
            offlineResource = ((ResourceLoadPoint) ExtensionPoint.as(cls).node(this.e).create()).load(ResourceLoadContext.newBuilder().originUrl(str4).build());
        }
        if (offlineResource != null) {
            if (str4.equals(c)) {
                offlineResource.setBytes(a(offlineResource.getBytes(), c().getBytes()));
                offlineResource.addHeader(b, str2);
            }
        }
        if (!TextUtils.isEmpty(str4)) {
            HashMap map113 = new HashMap();
            map113.put("resourceUrl", str4);
            ((RVMonitor) RVProxy.get(RVMonitor.class)).error(this.e, ErrId.RV_TYPE_PAGE_ABNORMAL, "小程序-白屏2", "白屏-页面资源丢失", new HashMap(), map113);
        }
        if (offlineResource == null) {
            file = new File(FileUtils.apUrlToFilePath(webResourceRequest.getUrl().toString()));
            if (file.exists()) {
                offlineResource = new OfflineResource(str4, toByte, "image/jpeg");
            }
        }
        if (offlineResource != null) {
            webResourceResponseShouldInterceptRequest = super.shouldInterceptRequest(webView, webResourceRequest);
            if (webResourceResponseShouldInterceptRequest != null) {
                return null;
            }
            RVMonitor rVMonitor11 = (RVMonitor) RVProxy.get(RVMonitor.class);
            String str17 = "request finish: " + str4;
            page = this.e;
            if (page != null) {
                appId = str;
            } else {
                appId = str;
            }
            page2 = this.e;
            if (page2 != null) {
                pageURI = page2.getPageURI();
            } else {
                pageURI = str;
            }
            rVMonitor11.flowLog(f25223a, str17, "Render", appId, pageURI, null);
            return webResourceResponseShouldInterceptRequest;
        }
        RVLogger.d(d, "shouldInterceptRequest got resource: " + offlineResource);
        WebResourceResponse webResourceResponse8 = new WebResourceResponse(offlineResource.getMimeType(), offlineResource.getEncoding(), offlineResource.getStream());
        HashMap map114 = new HashMap();
        map114.put("Access-Control-Allow-Origin", "*");
        map114.put("Cache-Control", "no-cache");
        webResourceResponse8.setResponseHeaders(map114);
        HashMap map115 = new HashMap();
        map115.put("from", "intercept");
        RVMonitor rVMonitor12 = (RVMonitor) RVProxy.get(RVMonitor.class);
        String str18 = "request finish: " + str4;
        page3 = this.e;
        if (page3 != null) {
            appId2 = str;
        } else {
            appId2 = str;
        }
        page4 = this.e;
        if (page4 != null) {
            pageURI2 = page4.getPageURI();
        } else {
            pageURI2 = str;
        }
        rVMonitor12.flowLog(f25223a, str18, "Render", appId2, pageURI2, map115);
        return webResourceResponse8;
    }

    @Override // android.taobao.windvane.extra.uc.WVUCWebViewClient
    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        ApiPermissionCheckResult apiPermissionCheckResultInterceptUrlForTiny;
        Uri uri = Uri.parse(str);
        if (uri == null) {
            return super.shouldOverrideUrlLoading(webView, str);
        }
        String scheme = uri.getScheme();
        if (!"https".equals(scheme) && !"http".equals(scheme)) {
            try {
                Intent uri2 = Intent.parseUri(str, 1);
                if (webView.getContext() != null) {
                    webView.getContext().startActivity(uri2);
                    return true;
                }
            } catch (Throwable th) {
                RVLogger.w(Log.getStackTraceString(th));
            }
        }
        if (RVProxy.get(AuthenticationProxy.class) == null || this.e.getApp() == null) {
            apiPermissionCheckResultInterceptUrlForTiny = ApiPermissionCheckResult.DENY;
        } else {
            apiPermissionCheckResultInterceptUrlForTiny = ((AuthenticationProxy) RVProxy.get(AuthenticationProxy.class)).interceptUrlForTiny(str, this.e.getApp() != null ? this.e.getApp().getAppId() : "", this.e, false);
        }
        if (apiPermissionCheckResultInterceptUrlForTiny == null || !apiPermissionCheckResultInterceptUrlForTiny.isSuccess()) {
            return true;
        }
        return super.shouldOverrideUrlLoading(webView, str);
    }

    private boolean a(String str) {
        Set<String> alreadyLoadedPluginUrlSet;
        if (str == null || !(this.f.getView() instanceof WMLTRWebView) || (alreadyLoadedPluginUrlSet = ((WMLTRWebView) this.f.getView()).getAlreadyLoadedPluginUrlSet()) == null) {
            return false;
        }
        return alreadyLoadedPluginUrlSet.contains(str);
    }

    public Page a() {
        return this.e;
    }
}
