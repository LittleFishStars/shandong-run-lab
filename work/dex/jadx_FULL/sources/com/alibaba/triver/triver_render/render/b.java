package com.alibaba.triver.triver_render.render;

import android.app.Activity;
import android.content.Context;
import android.net.http.SslError;
import android.os.Bundle;
import android.taobao.windvane.util.WVNativeCallbackUtil;
import android.text.TextUtils;
import com.alibaba.ariver.app.api.App;
import com.alibaba.ariver.app.api.Page;
import com.alibaba.ariver.app.api.monitor.RVMonitor;
import com.alibaba.ariver.engine.api.Render;
import com.alibaba.ariver.kernel.api.monitor.ErrId;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.service.RVConfigService;
import com.alibaba.ariver.kernel.common.service.RVEnvironmentService;
import com.alibaba.ariver.kernel.common.utils.FileUtils;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.fastjson.support.spring.FastJsonJsonView;
import com.alibaba.triver.kit.api.appmonitor.LaunchMonitorData;
import com.alibaba.triver.kit.api.appmonitor.LaunchMonitorUtils;
import com.alibaba.triver.kit.api.cache.ResourceFallbackCenter;
import com.alibaba.triver.kit.api.common.TRiverConstants;
import com.alibaba.triver.kit.api.common.TriverAppMonitorConstants;
import com.alibaba.triver.kit.api.monitor.IPerformanceAndErrorTracker;
import com.alibaba.triver.kit.api.orange.TBShopOrangeController;
import com.alibaba.triver.kit.api.proxy.IRouterProxy;
import com.alibaba.triver.kit.api.utils.TRiverUrlUtils;
import com.alibaba.triver.kit.api.utils.TRiverUtils;
import com.uc.webview.export.SslErrorHandler;
import com.uc.webview.export.WebResourceRequest;
import com.uc.webview.export.WebResourceResponse;
import com.uc.webview.export.WebView;
import java.lang.ref.WeakReference;
import java.util.HashMap;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class b extends i {
    private static final String d = "https://appx/";

    public b(Context context, Page page, Render render) {
        super(context, page, render);
    }

    private WebResourceResponse c() {
        String strB = b("index.js");
        if (strB == null) {
            strB = ResourceFallbackCenter.readAssert("shop.index.js");
        }
        if (TextUtils.isEmpty(strB)) {
            ((RVMonitor) RVProxy.get(RVMonitor.class)).error(a(), ErrId.RV_TYPE_PAGE_ABNORMAL, "店铺-白屏1", "index.js资源丢失，页面白屏", new HashMap(), new HashMap());
        }
        return ResourceFallbackCenter.getWebRespByString(strB, FastJsonJsonView.DEFAULT_JSONP_CONTENT_TYPE, "utf-8");
    }

    private WebResourceResponse d() {
        String strB = b("index.html");
        if (strB == null) {
            strB = ResourceFallbackCenter.readAssert("shop.index.html");
        }
        if (TextUtils.isEmpty(strB)) {
            ((RVMonitor) RVProxy.get(RVMonitor.class)).error(a(), ErrId.RV_TYPE_PAGE_ABNORMAL, "店铺-白屏3", "index.html 资源丢失，页面白屏", new HashMap(), new HashMap());
        }
        return ResourceFallbackCenter.getWebRespByString(strB, "text/html", "utf-8");
    }

    @Override // com.alibaba.triver.triver_render.render.i
    public /* bridge */ /* synthetic */ Page a() {
        return super.a();
    }

    @Override // com.alibaba.triver.triver_render.render.i
    public /* bridge */ /* synthetic */ boolean b() {
        return super.b();
    }

    @Override // com.alibaba.triver.triver_render.render.i, android.taobao.windvane.extra.uc.WVUCWebViewClient
    public /* bridge */ /* synthetic */ void onPageFinished(WebView webView, String str) throws Throwable {
        super.onPageFinished(webView, str);
    }

    @Override // com.alibaba.triver.triver_render.render.i, android.taobao.windvane.extra.uc.WVUCWebViewClient
    public /* bridge */ /* synthetic */ void onReceivedError(WebView webView, int i, String str, String str2) {
        super.onReceivedError(webView, i, str, str2);
    }

    @Override // com.alibaba.triver.triver_render.render.i, android.taobao.windvane.extra.uc.WVUCWebViewClient
    public /* bridge */ /* synthetic */ void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
        super.onReceivedSslError(webView, sslErrorHandler, sslError);
    }

    @Override // com.alibaba.triver.triver_render.render.i, android.taobao.windvane.extra.uc.WVUCWebViewClient
    public WebResourceResponse shouldInterceptRequest(WebView webView, WebResourceRequest webResourceRequest) {
        if (i.c.equals(webResourceRequest.getUrl().toString())) {
            ((IPerformanceAndErrorTracker) RVProxy.get(IPerformanceAndErrorTracker.class)).sendPerfStageLog("Render", "start request index Js resource");
        }
        WebResourceResponse webResourceResponseShouldInterceptRequest = super.shouldInterceptRequest(webView, webResourceRequest);
        String string = webResourceRequest.getUrl().toString();
        if (webResourceResponseShouldInterceptRequest != null || TextUtils.isEmpty(string)) {
            return webResourceResponseShouldInterceptRequest;
        }
        if (string.startsWith("https://hybrid.miniapp.taobao.com/index.html")) {
            return d();
        }
        if (c(string)) {
            return a(string);
        }
        if (string.startsWith(i.c)) {
            return c();
        }
        if (!string.startsWith("https://appx/")) {
            return webResourceResponseShouldInterceptRequest;
        }
        if (string.contains("#")) {
            string = string.split("#")[0];
        }
        String appxAssertResource = ResourceFallbackCenter.getAppxAssertResource(string);
        if (string.startsWith("https://appx/af-appx.min.js") && !TextUtils.isEmpty(appxAssertResource)) {
            appxAssertResource = appxAssertResource + a.e();
        }
        return ResourceFallbackCenter.getWebRespByString(appxAssertResource, FileUtils.getMimeType(string), "utf-8");
    }

    @Override // com.alibaba.triver.triver_render.render.i, android.taobao.windvane.extra.uc.WVUCWebViewClient
    public /* bridge */ /* synthetic */ boolean shouldOverrideUrlLoading(WebView webView, String str) {
        return super.shouldOverrideUrlLoading(webView, str);
    }

    private WebResourceResponse a(String str) {
        String pluginResource = ResourceFallbackCenter.getPluginResource(d(str), "index.js");
        if (TextUtils.isEmpty(pluginResource) || pluginResource.length() < 100) {
            HashMap map = new HashMap();
            map.put("resourceUrl", str);
            ((RVMonitor) RVProxy.get(RVMonitor.class)).error(null, ErrId.RV_TYPE_PAGE_ABNORMAL, "店铺-白屏2", "index.plugin.js 资源丢失，页面白屏", new HashMap(), map);
            try {
                RVConfigService rVConfigService = (RVConfigService) RVProxy.get(RVConfigService.class);
                boolean z = true;
                if (rVConfigService != null) {
                    try {
                        z = Boolean.parseBoolean(rVConfigService.getConfig("openPatch3", "true"));
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                }
                if (!z) {
                    return ResourceFallbackCenter.getWebRespByString(pluginResource, FastJsonJsonView.DEFAULT_JSONP_CONTENT_TYPE, "utf-8");
                }
                App appByNode = TRiverUtils.getAppByNode(a());
                if (appByNode == null) {
                    return ResourceFallbackCenter.getWebRespByString(pluginResource, FastJsonJsonView.DEFAULT_JSONP_CONTENT_TYPE, "utf-8");
                }
                LaunchMonitorData subMonitorData = LaunchMonitorUtils.getSubMonitorData(appByNode);
                if (subMonitorData == null || (!subMonitorData.containsKey(TriverAppMonitorConstants.KEY_SHOP_ON_DOWNGRADE) && !appByNode.isDestroyed())) {
                    if (subMonitorData != null) {
                        subMonitorData.addPoint(TriverAppMonitorConstants.KEY_SHOP_ON_DOWNGRADE);
                    }
                    String downgradeShopUrl = TBShopOrangeController.getDowngradeShopUrl();
                    String urlParams = TRiverUrlUtils.getUrlParams(appByNode);
                    if (!TextUtils.isEmpty(downgradeShopUrl) && !TextUtils.isEmpty(urlParams)) {
                        String str2 = downgradeShopUrl + "&" + TRiverUrlUtils.getUrlParams(appByNode);
                        RVEnvironmentService rVEnvironmentService = (RVEnvironmentService) RVProxy.get(RVEnvironmentService.class);
                        if (rVEnvironmentService == null) {
                            return ResourceFallbackCenter.getWebRespByString(pluginResource, FastJsonJsonView.DEFAULT_JSONP_CONTENT_TYPE, "utf-8");
                        }
                        WeakReference<Activity> topActivity = rVEnvironmentService.getTopActivity();
                        Context applicationContext = (topActivity == null || topActivity.get() == null) ? rVEnvironmentService.getApplicationContext() : topActivity.get();
                        RVLogger.e("ShopWVWebViewClient", "downgradeUrl: " + str2);
                        ((IRouterProxy) RVProxy.get(IRouterProxy.class)).openURL(applicationContext, null, str2.replace(TRiverConstants.KEY_APP_ID, "ariver_appid"), null, new Bundle());
                        if (!appByNode.isDestroyed()) {
                            appByNode.exit();
                        }
                    }
                    return ResourceFallbackCenter.getWebRespByString(pluginResource, FastJsonJsonView.DEFAULT_JSONP_CONTENT_TYPE, "utf-8");
                }
            } catch (Throwable th2) {
                th2.printStackTrace();
            }
        }
        return ResourceFallbackCenter.getWebRespByString(pluginResource, FastJsonJsonView.DEFAULT_JSONP_CONTENT_TYPE, "utf-8");
    }

    private String b(String str) {
        return ResourceFallbackCenter.getTemplatePkgResource(str);
    }

    private boolean c(String str) {
        if (str == null) {
            return false;
        }
        return str.contains("__plugins__/");
    }

    private String d(String str) {
        if (str == null) {
            return null;
        }
        String[] strArrSplit = str.split(WVNativeCallbackUtil.SEPERATER);
        if (strArrSplit.length < 3) {
            return null;
        }
        return strArrSplit[strArrSplit.length - 2];
    }
}
