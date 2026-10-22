package com.alibaba.triver.triver_render.render;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.taobao.windvane.extra.uc.WVUCWebView;
import android.taobao.windvane.extra.uc.WVUCWebViewClient;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.alibaba.ariver.app.api.Page;
import com.alibaba.ariver.app.api.PageContext;
import com.alibaba.ariver.app.api.monitor.RVMonitor;
import com.alibaba.ariver.app.view.EmbedPageContext;
import com.alibaba.ariver.engine.BaseRenderImpl;
import com.alibaba.ariver.engine.api.EngineUtils;
import com.alibaba.ariver.engine.api.RVEngine;
import com.alibaba.ariver.engine.api.bridge.RenderBridge;
import com.alibaba.ariver.engine.api.bridge.model.CreateParams;
import com.alibaba.ariver.engine.api.bridge.model.ExitCallback;
import com.alibaba.ariver.engine.api.bridge.model.GoBackCallback;
import com.alibaba.ariver.engine.api.bridge.model.LoadParams;
import com.alibaba.ariver.engine.api.bridge.model.ScrollChangedCallback;
import com.alibaba.ariver.engine.api.common.CommonBackPerform;
import com.alibaba.ariver.engine.api.embedview.EmbedViewProvider;
import com.alibaba.ariver.engine.api.embedview.IEmbedView;
import com.alibaba.ariver.jsapi.logging.RVPerformanceTrackerImpl;
import com.alibaba.ariver.kernel.api.extension.ExtensionManager;
import com.alibaba.ariver.kernel.api.extension.ExtensionPoint;
import com.alibaba.ariver.kernel.api.monitor.ErrId;
import com.alibaba.ariver.kernel.api.node.DataNode;
import com.alibaba.ariver.kernel.api.security.ApiPermissionCheckResult;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.service.RVExtensionService;
import com.alibaba.ariver.kernel.common.utils.BundleUtils;
import com.alibaba.ariver.kernel.common.utils.ExecutorUtils;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.ariver.permission.api.proxy.AuthenticationProxy;
import com.alibaba.ariver.resource.api.models.AppModel;
import com.alibaba.ariver.resource.api.models.PluginModel;
import com.alibaba.ariver.tracedebug.point.TraceDebugPoint;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.triver.kit.api.appmonitor.LaunchMonitorData;
import com.alibaba.triver.kit.api.appmonitor.LaunchMonitorUtils;
import com.alibaba.triver.kit.api.common.TRiverConstants;
import com.alibaba.triver.kit.api.common.TriverAppMonitorConstants;
import com.alibaba.triver.kit.api.monitor.IPerformanceAndErrorTracker;
import com.alibaba.triver.kit.api.orange.TBShopOrangeController;
import com.alibaba.triver.kit.api.orange.TROrangeController;
import com.alibaba.triver.kit.api.preload.core.PreloadScheduler;
import com.alibaba.triver.kit.api.preload.tsr.TSRResource;
import com.alibaba.triver.kit.api.proxy.IConfigProxy;
import com.alibaba.triver.kit.api.render.ITRRender;
import com.alibaba.triver.kit.api.systemInfo.SystemInfoUtil;
import com.alibaba.triver.kit.api.utils.TRiverUrlUtils;
import com.alibaba.triver.kit.api.utils.TRiverUtils;
import com.alibaba.triver.triver_render.R;
import com.alibaba.triver.triver_render.extension.PagePulldownPoint;
import com.alibaba.triver.triver_render.view.refresh.RefreshHeader;
import com.alibaba.triver.triver_render.view.refresh.TriverSwipeRefreshLayout;
import com.aliyun.svideosdk.preview.camera.AliyunRecorderProperty;
import com.uc.webview.export.WebSettings;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class g extends BaseRenderImpl implements ITRRender {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f25213a = "CREATE_RENDER_FINISH";
    public static final String b = "RENDER_DESTROY";
    public static final String c = "template_snapshot_js_file";
    public static final String d = "tr_template_file_cache";
    private static final String e = "WVRenderImpl";
    private static AtomicInteger f = new AtomicInteger(1);
    private static final String s = "-9002";
    private static final String t = "page permission deny";
    private final boolean g;
    private Activity h;
    private Page i;
    private CreateParams j;
    private RenderBridge k;
    private int l;
    private d m;
    private Context n;
    private ViewGroup o;
    private Handler p;
    private boolean q;
    private String r;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f25221a;

        private a() {
        }
    }

    public g(RVEngine rVEngine, Activity activity, DataNode dataNode, CreateParams createParams, WMLTRWebView wMLTRWebView, @NonNull Handler handler) {
        ViewGroup viewGroup;
        Page page;
        Page page2;
        super(rVEngine, activity, dataNode, createParams);
        this.r = null;
        ((IPerformanceAndErrorTracker) RVProxy.get(IPerformanceAndErrorTracker.class)).sendPerfStageLog("Render", "Start create render");
        this.i = (Page) dataNode;
        this.l = f.addAndGet(1);
        this.n = activity.getApplicationContext();
        Page page3 = this.i;
        if (page3 == null || page3.getApp() == null || !"68687029".equals(this.i.getApp().getAppId())) {
            RVProxy.set(EmbedViewProvider.class, new WVEmbedViewProvider(createParams != null ? createParams.startParams : null));
        }
        boolean z = this.i.getApp().getStartParams() != null ? this.i.getApp().getStartParams().getBoolean("embedInWeex") : false;
        boolean z2 = z && (this.i.getApp().getStartParams() != null ? this.i.getApp().getStartParams().getBoolean("enablePullDown") : true);
        this.g = z2;
        this.p = handler;
        if (!h.a()) {
            setBackPerform(new CommonBackPerform(this) { // from class: com.alibaba.triver.triver_render.render.g.1
                @Override // com.alibaba.ariver.engine.api.common.CommonBackPerform
                public void performBack(GoBackCallback goBackCallback) {
                    goBackCallback.afterProcess(false);
                }
            });
        }
        a(z2);
        if (this.i.getPageContext() instanceof EmbedPageContext) {
            Context context = this.i.getApp().getAppContext().getContext();
            if (z) {
                this.m = new WVNestedScrollingWebView(activity, this.i);
            } else {
                WMLTRWebView wMLTRWebView2 = new WMLTRWebView(activity, this.i);
                this.m = wMLTRWebView2;
                wMLTRWebView2.d().setLayoutParams(new ViewGroup.LayoutParams(createParams.containerWidth, createParams.containerHeight));
            }
            WebSettings settings = ((WMLTRWebView) this.m).getSettings();
            settings.setJavaScriptEnabled(true);
            settings.setAppCacheEnabled(true);
            settings.setUseWideViewPort(true);
            settings.setDomStorageEnabled(true);
            settings.setSupportZoom(false);
            settings.setBuiltInZoomControls(false);
            if (!z) {
                settings.setLoadWithOverviewMode(true);
            }
            ((WMLTRWebView) this.m).setVerticalScrollBarEnabled(true);
            ((WMLTRWebView) this.m).setScrollBarStyle(0);
            this.m.setWebViewClient(new WVUCWebViewClient(context));
        } else if (wMLTRWebView != null) {
            wMLTRWebView.setPage(this.i);
            wMLTRWebView.setOuterCtx(activity);
            this.m = wMLTRWebView;
        } else {
            this.m = new WMLTRWebView(activity, this.i);
        }
        ((IPerformanceAndErrorTracker) RVProxy.get(IPerformanceAndErrorTracker.class)).sendPerfStageLog("Render", "End create render");
        this.h = activity;
        try {
            RVMonitor rVMonitor = (RVMonitor) RVProxy.get(RVMonitor.class);
            Page page4 = this.i;
            String appId = (page4 == null || page4.getApp() == null) ? "" : this.i.getApp().getAppId();
            Page page5 = this.i;
            rVMonitor.flowLog(f25213a, "Render create finish", "Render", appId, page5 != null ? page5.getPageURI() : "", null);
        } catch (Exception unused) {
        }
        this.m.d().setId(R.id.triver_webview_id);
        if ((this.m instanceof WVUCWebView) && (page2 = this.i) != null && page2.getApp() != null) {
            ((WVUCWebView) this.m).setPerformanceDelegate(new com.alibaba.triver.triver_render.a.a(this.i.getApp()));
        }
        try {
            ExtensionManager extensionManager = ((RVExtensionService) RVProxy.get(RVExtensionService.class)).getExtensionManager();
            if (extensionManager != null && (page = this.i) != null) {
                extensionManager.registerExtensionByPoint(page.getApp(), TraceDebugPoint.class, ExtensionPoint.as(TraceDebugPoint.class).create());
            }
        } catch (Throwable th) {
            RVLogger.d(e, th.getMessage());
        }
        if (!this.g || (viewGroup = this.o) == null) {
            return;
        }
        viewGroup.addView(this.m.d(), new ViewGroup.LayoutParams(-1, -1));
    }

    private String c() {
        return "\n(function() {\n    console.log(\"load AlipayJSBridge dispatchEvent AlipayJSBridgeReady start\")\n\tvar l = document.createEvent('Events');\n\tl.initEvent('AlipayJSBridgeReady', !1, !1);\n\tdocument.dispatchEvent(l);\n\tconsole.log(\"load AlipayJSBridge dispatchEvent AlipayJSBridgeReady end\")\n})()";
    }

    private void e() {
    }

    @Override // com.alibaba.triver.kit.api.render.ITRRender
    public void evaluateJavascript(String str) {
        d dVar = this.m;
        if (dVar != null) {
            dVar.evaluateJavascript(str);
        }
    }

    @Override // com.alibaba.ariver.engine.BaseRenderImpl, com.alibaba.ariver.engine.api.Render
    public Activity getActivity() {
        return this.h;
    }

    @Override // com.alibaba.ariver.engine.BaseRenderImpl, com.alibaba.ariver.engine.api.Render
    public String getAppId() {
        try {
            return this.i.getApp().getAppId();
        } catch (Exception e2) {
            e2.printStackTrace();
            return "";
        }
    }

    @Override // com.alibaba.ariver.engine.api.Render
    @Nullable
    public Bitmap getCapture(int i) {
        try {
            if (i == 2) {
                return com.alibaba.triver.triver_render.utils.b.a(this.i.getPageContext().getActivity());
            }
            if (i == 0) {
                return com.alibaba.triver.triver_render.utils.b.a(this.m.d());
            }
            RVLogger.e(e, "unknown type");
            return null;
        } catch (Exception e2) {
            RVLogger.e(e, "getCapture exception:", e2);
            return null;
        }
    }

    @Override // com.alibaba.ariver.engine.api.Render
    public int getPageId() {
        return this.l;
    }

    @Override // com.alibaba.ariver.engine.api.Render
    public RenderBridge getRenderBridge() {
        return this.k;
    }

    @Override // com.alibaba.ariver.engine.BaseRenderImpl, com.alibaba.ariver.engine.api.Render
    public String getRenderId() {
        return this.l + "";
    }

    @Override // com.alibaba.ariver.engine.api.Render
    public int getScrollY() {
        return this.m.d().getScrollY();
    }

    @Override // com.alibaba.ariver.engine.BaseRenderImpl, com.alibaba.ariver.engine.api.Render
    public Bundle getStartParams() {
        Page page = this.i;
        if (page != null) {
            return page.getStartParams();
        }
        return null;
    }

    @Override // com.alibaba.ariver.engine.BaseRenderImpl, com.alibaba.ariver.engine.api.Render
    public synchronized String getUserAgent() {
        d dVar = this.m;
        if (dVar != null && (dVar instanceof WMLTRWebView)) {
            return this.m.getUserAgentString() + " " + EngineUtils.getUserAgentSuffix();
        }
        return super.getUserAgent();
    }

    @Override // com.alibaba.ariver.engine.api.Render
    public View getView() {
        return this.g ? this.o : this.m.d();
    }

    @Override // com.alibaba.ariver.engine.BaseRenderImpl, com.alibaba.ariver.engine.api.Render
    public void goBack(GoBackCallback goBackCallback) {
        Page page = this.i;
        if (page != null && page.getPageContext() != null) {
            if (TextUtils.isEmpty(this.i.getApp().getAppId())) {
                return;
            }
            try {
                if (AliyunRecorderProperty.SURFACE_ROTATION_MODE_FALSE.equals(((IConfigProxy) RVProxy.get(IConfigProxy.class)).getConfigsByGroupAndName("triver_common_config", TRiverConstants.ORANGE_KEY_WEBVIEW_BACK_OPEN, "true"))) {
                    return;
                }
            } catch (Throwable th) {
                RVLogger.d(e, th.getMessage());
            }
            PageContext pageContext = this.i.getPageContext();
            if (pageContext.getEmbedViewManager() != null && pageContext.getEmbedViewManager().findAllEmbedView() != null) {
                for (IEmbedView iEmbedView : pageContext.getEmbedViewManager().findAllEmbedView()) {
                    if ("webview".equals(iEmbedView.getType())) {
                        Object view = iEmbedView.getView(0, 0, "", null, null);
                        if (view instanceof WMLTRWebView) {
                            WMLTRWebView wMLTRWebView = (WMLTRWebView) view;
                            if (wMLTRWebView.canGoBack()) {
                                wMLTRWebView.goBack();
                                goBackCallback.afterProcess(true);
                                return;
                            }
                        } else {
                            continue;
                        }
                    }
                }
            }
        }
        super.goBack(goBackCallback);
    }

    @Override // com.alibaba.ariver.engine.api.Render
    public void init() {
        boolean z;
        ((IPerformanceAndErrorTracker) RVProxy.get(IPerformanceAndErrorTracker.class)).sendPerfStageLog("Render", "Start init render");
        this.k = new f(this.i, this);
        this.m.setWebChromeClient(new e(this.i, getEngine().getBridge(), this.k, this.p));
        if (TRiverUrlUtils.isShop(this.i.getApp())) {
            this.m.setWebViewClient(new b(this.n, this.i, this));
        } else {
            this.m.setWebViewClient(new i(this.n, this.i, this));
        }
        ((WMLTRWebView) this.m).setAttachBottomListener(new android.taobao.windvane.d.a() { // from class: com.alibaba.triver.triver_render.render.g.3
            @Override // android.taobao.windvane.d.a
            public void a() {
                JSONObject jSONObject = new JSONObject();
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("tbViewScrollToLower", (Object) Boolean.TRUE);
                jSONObject.put("data", (Object) jSONObject2);
                EngineUtils.sendToRender(g.this, "tbViewScrollToLower", jSONObject, null);
            }
        });
        HashMap map = new HashMap();
        map.put("startupParams", BundleUtils.toJSONObject(this.i.getStartParams()).toString());
        StringBuilder sb = new StringBuilder();
        d dVar = this.m;
        if ((dVar instanceof WMLTRWebView) && ((WMLTRWebView) dVar).l()) {
            Page page = this.i;
            sb.append(h.a(map, page, page.getRender().getRenderId()));
        } else {
            Page page2 = this.i;
            sb.append(h.b(map, page2, page2.getRender().getRenderId()));
        }
        String string = sb.toString();
        RVLogger.d(e, "onPageFinished, inject bridge: " + string);
        boolean z2 = ((WVUCWebView) this.m).getCurrentViewCoreType() == 2;
        this.q = z2;
        if (z2) {
            ((RVMonitor) RVProxy.get(RVMonitor.class)).error(this.i, ErrId.RV_TYPE_WEBVIEW_ERROR, ErrId.ErrCodeWebview.H5_UC_FAIL_USE_SYS_WEBVIEW, "Webview Error", new HashMap(), new HashMap());
        } else {
            RVLogger.e(e, "Using uc core, inject");
            AppModel appModel = (AppModel) this.i.getApp().getData(AppModel.class);
            String str = "window.__appxPlugins = [";
            if (appModel == null || appModel.getAppInfoModel() == null || appModel.getAppInfoModel().getPlugins() == null || appModel.getAppInfoModel().getPlugins().size() <= 0) {
                z = false;
            } else {
                List<PluginModel> plugins = appModel.getAppInfoModel().getPlugins();
                String str2 = "";
                for (int i = 0; i < plugins.size(); i++) {
                    str2 = str2 + "'__plugins__/" + plugins.get(i).getAppId() + "/index.js',";
                }
                str = "window.__appxPlugins = [" + str2 + "]";
                RVLogger.d(e, "plugin inject code in webview: " + str);
                z = true;
            }
            String str3 = z ? str : "";
            StringBuilder sb2 = new StringBuilder();
            if (TROrangeController.useNativeInput(this.i.getApp())) {
                sb2.append(";window.ENABLEINPAGEINPUT = true;");
            }
            this.r = string + str3 + sb2.toString();
            if (((WMLTRWebView) this.m).l()) {
                this.m.evaluateJavascript(this.r);
            } else {
                ((WMLTRWebView) this.m).injectJsEarly(this.r);
            }
        }
        RVLogger.d(RVPerformanceTrackerImpl.TAG, String.format("Track[Stage] %s, [timeStamp] %d", "renderInitFinish", Long.valueOf(SystemClock.elapsedRealtime())));
        ((IPerformanceAndErrorTracker) RVProxy.get(IPerformanceAndErrorTracker.class)).sendPerfStageLog("Render", "End init render");
    }

    @Override // com.alibaba.ariver.engine.BaseRenderImpl, com.alibaba.ariver.engine.api.Render
    public void load(LoadParams loadParams) {
        Bundle bundle;
        super.load(loadParams);
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("url", (Object) loadParams.url);
        com.alibaba.triver.trace.b.a(com.alibaba.triver.trace.c.h, com.alibaba.triver.trace.c.ah, TRiverUtils.getSessionId(getStartParams()), this.i, jSONObject);
        ((IPerformanceAndErrorTracker) RVProxy.get(IPerformanceAndErrorTracker.class)).sendPerfStageLog("Render", "Start render load url");
        ApiPermissionCheckResult apiPermissionCheckResultInterceptUrlForTiny = RVProxy.get(AuthenticationProxy.class) != null ? ((AuthenticationProxy) RVProxy.get(AuthenticationProxy.class)).interceptUrlForTiny(loadParams.url, getAppId(), this.i, false) : ApiPermissionCheckResult.DENY;
        if (apiPermissionCheckResultInterceptUrlForTiny == null || !apiPermissionCheckResultInterceptUrlForTiny.isSuccess()) {
            com.alibaba.triver.trace.b.a(com.alibaba.triver.trace.c.h, com.alibaba.triver.trace.c.ai, TRiverUtils.getSessionId(getStartParams()), this.i, s, t, jSONObject);
            this.m.a("https://market.m.taobao.com/app/xaas/miniapp-webview-error/pages/index");
        } else {
            LaunchMonitorData subMonitorData = LaunchMonitorUtils.getSubMonitorData(this.i);
            if (subMonitorData != null && !subMonitorData.containsKey(TriverAppMonitorConstants.KEY_STAGE_LOAD_MAIN_HTML)) {
                subMonitorData.addPoint(TriverAppMonitorConstants.KEY_STAGE_LOAD_MAIN_HTML);
            }
            if (loadParams.url.contains("index.html") && ((WMLTRWebView) this.m).l()) {
                ((WMLTRWebView) this.m).a(this.i);
                a(loadParams);
                jSONObject.put("isPreload", (Object) "true");
                com.alibaba.triver.trace.b.a(com.alibaba.triver.trace.c.h, com.alibaba.triver.trace.c.aj, TRiverUtils.getSessionId(this.i), this.i, jSONObject);
                if (this.m.i()) {
                    d();
                    a();
                } else {
                    new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: com.alibaba.triver.triver_render.render.g.4
                        @Override // java.lang.Runnable
                        public void run() {
                            g.this.d();
                            g.this.a();
                        }
                    }, 50L);
                }
            } else {
                this.m.a(loadParams.url);
            }
        }
        CreateParams createParams = this.j;
        if (createParams == null || (bundle = createParams.startParams) == null || !bundle.containsKey("backgroundColor")) {
            return;
        }
        ((WMLTRWebView) this.m).getCoreView().setBackgroundColor(Integer.valueOf((String) this.j.startParams.get("backgroundColor")).intValue() | (-16777216));
    }

    @Override // com.alibaba.ariver.engine.BaseRenderImpl
    public void onDestroy() {
        e();
        com.alibaba.triver.trace.b.a(com.alibaba.triver.trace.c.h, "RENDER_DESTROY", TRiverUtils.getSessionId(getStartParams()), this.i, (JSONObject) null);
        ExecutorUtils.runOnMain(new Runnable() { // from class: com.alibaba.triver.triver_render.render.g.5
            @Override // java.lang.Runnable
            public void run() {
                List<IEmbedView> listFindAllEmbedView;
                try {
                    if (g.this.i != null && g.this.i.getPageContext() != null) {
                        PageContext pageContext = g.this.i.getPageContext();
                        if (pageContext.getEmbedViewManager() != null && (listFindAllEmbedView = pageContext.getEmbedViewManager().findAllEmbedView()) != null) {
                            Iterator<IEmbedView> it = listFindAllEmbedView.iterator();
                            while (it.hasNext()) {
                                it.next().onDestroy();
                            }
                        }
                    }
                    g.this.m.e();
                    ((RVMonitor) RVProxy.get(RVMonitor.class)).flowLog("RENDER_DESTROY", "Render destroy finish", "Render", (g.this.i == null || g.this.i.getApp() == null) ? "" : g.this.i.getApp().getAppId(), g.this.i != null ? g.this.i.getPageURI() : "", null);
                    g.this.h = null;
                    g.this.i = null;
                } catch (Exception unused) {
                }
            }
        }, 500L);
    }

    @Override // com.alibaba.ariver.engine.BaseRenderImpl, com.alibaba.ariver.engine.api.Render
    public void onPause() {
        List<IEmbedView> listFindAllEmbedView;
        e();
        d dVar = this.m;
        if (dVar != null) {
            try {
                dVar.g();
                Page page = this.i;
                if (page == null || page.getPageContext() == null) {
                    return;
                }
                PageContext pageContext = this.i.getPageContext();
                if (pageContext.getEmbedViewManager() == null || (listFindAllEmbedView = pageContext.getEmbedViewManager().findAllEmbedView()) == null) {
                    return;
                }
                Iterator<IEmbedView> it = listFindAllEmbedView.iterator();
                while (it.hasNext()) {
                    it.next().onWebViewPause();
                }
            } catch (Exception e2) {
                RVLogger.e(e, "onPause exception:", e2);
            }
        }
    }

    @Override // com.alibaba.ariver.engine.BaseRenderImpl, com.alibaba.ariver.engine.api.Render
    public void onResume() {
        List<IEmbedView> listFindAllEmbedView;
        d dVar = this.m;
        if (dVar != null) {
            try {
                dVar.h();
                Page page = this.i;
                if (page == null || page.getPageContext() == null) {
                    return;
                }
                PageContext pageContext = this.i.getPageContext();
                if (pageContext.getEmbedViewManager() == null || (listFindAllEmbedView = pageContext.getEmbedViewManager().findAllEmbedView()) == null) {
                    return;
                }
                Iterator<IEmbedView> it = listFindAllEmbedView.iterator();
                while (it.hasNext()) {
                    it.next().onWebViewResume();
                }
            } catch (Exception e2) {
                RVLogger.e(e, "onResume exception:", e2);
            }
        }
    }

    @Override // com.alibaba.ariver.engine.BaseRenderImpl, com.alibaba.ariver.engine.api.Render
    public void runExit(ExitCallback exitCallback) {
        super.runExit(exitCallback);
    }

    @Override // com.alibaba.ariver.engine.api.Render
    public void setScrollChangedCallback(final ScrollChangedCallback scrollChangedCallback) {
        if (this.m.d() == null || !(this.m.d() instanceof d)) {
            this.m.d().setOnScrollChangeListener(new View.OnScrollChangeListener() { // from class: com.alibaba.triver.triver_render.render.g.6
                @Override // android.view.View.OnScrollChangeListener
                public void onScrollChange(View view, int i, int i2, int i3, int i4) {
                    scrollChangedCallback.onScroll(i - i3, i2 - i4);
                }
            });
        } else {
            ((d) this.m.d()).setScrollListener(scrollChangedCallback);
        }
    }

    @Override // com.alibaba.ariver.engine.api.Render
    public void showErrorView(View view) {
    }

    private void b() {
        this.m.evaluateJavascript(c());
        ((IPerformanceAndErrorTracker) RVProxy.get(IPerformanceAndErrorTracker.class)).sendPerfStageLog("Render", "index js already exe, request aliPayReady");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        Page page = this.i;
        if (page != null && TBShopOrangeController.enableNSR(page.getApp()) && TBShopOrangeController.enableTemplateJs()) {
            ((IPerformanceAndErrorTracker) RVProxy.get(IPerformanceAndErrorTracker.class)).sendPerfStageLog("Render", "Render Template Snapshot");
            String strA = a(this.i);
            String systemInfoInner = SystemInfoUtil.getSystemInfoInner(this.i);
            if (TextUtils.isEmpty(strA) || TextUtils.isEmpty(systemInfoInner)) {
                return;
            }
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("templateSnapshotData", (Object) strA);
                jSONObject.put("systemInfoData", (Object) systemInfoInner);
                com.alibaba.triver.trace.b.a(com.alibaba.triver.trace.c.h, com.alibaba.triver.trace.c.al, TRiverUtils.getSessionId(this.i), this.i, jSONObject);
                Page page2 = this.i;
                if (page2 != null && page2.getApp() != null && this.i.getApp().getAppContext() != null && this.i.getApp().getAppContext().getSplashView() != null) {
                    this.i.getApp().getAppContext().getSplashView().exit(null);
                }
                this.m.evaluateJavascript(";(typeof window.renderTemplateSnapshot === 'function') && window.renderTemplateSnapshot({data:'" + strA + "',systemInfo:'" + systemInfoInner + "'});");
                ((IPerformanceAndErrorTracker) RVProxy.get(IPerformanceAndErrorTracker.class)).sendPerfStageLog("Render", "Render TemplateSnapshot execute");
                LaunchMonitorData subMonitorData = LaunchMonitorUtils.getSubMonitorData(this.i);
                if (subMonitorData != null) {
                    subMonitorData.addPoint(TriverAppMonitorConstants.KEY_STAGE_TEMPLATE_SNAPSHOT_RENDER_HIT);
                }
                LaunchMonitorData pageMonitorData = LaunchMonitorUtils.getPageMonitorData(this.i);
                if (pageMonitorData != null) {
                    pageMonitorData.addPoint(TriverAppMonitorConstants.KEY_STAGE_TEMPLATE_SNAPSHOT_RENDER_HIT);
                }
            } catch (Throwable th) {
                RVLogger.e(e, th);
            }
        }
    }

    private void a(boolean z) {
        if (z) {
            TriverSwipeRefreshLayout triverSwipeRefreshLayout = new TriverSwipeRefreshLayout(this.n);
            this.o = triverSwipeRefreshLayout;
            triverSwipeRefreshLayout.a(true);
            ((TriverSwipeRefreshLayout) this.o).b(false);
            ((TriverSwipeRefreshLayout) this.o).c(false);
            ((TriverSwipeRefreshLayout) this.o).setPullRefreshDistance(30);
            ((TriverSwipeRefreshLayout) this.o).setDistanceToRefresh(350);
            ((TriverSwipeRefreshLayout) this.o).setHeaderView(new com.alibaba.triver.triver_render.view.refresh.d(this.n));
            ((TriverSwipeRefreshLayout) this.o).setOnPullRefreshListener(new TriverSwipeRefreshLayout.a() { // from class: com.alibaba.triver.triver_render.render.g.2
                @Override // com.alibaba.triver.triver_render.view.refresh.TriverSwipeRefreshLayout.a
                public void a() {
                }

                @Override // com.alibaba.triver.triver_render.view.refresh.TriverSwipeRefreshLayout.a
                public void a(int i) {
                    RVLogger.d(g.e, "onPullDistance: " + i);
                    if (g.this.i == null || g.this.i.getApp() == null) {
                        return;
                    }
                    ((PagePulldownPoint) ExtensionPoint.as(PagePulldownPoint.class).node(g.this.i.getApp()).create()).onReachPullRefreshDistance(g.this.i.getApp(), i);
                }

                @Override // com.alibaba.triver.triver_render.view.refresh.TriverSwipeRefreshLayout.a
                public void a(RefreshHeader.RefreshState refreshState, RefreshHeader.RefreshState refreshState2) {
                }
            });
        }
    }

    private void a(LoadParams loadParams) {
        try {
            String rawFragment = new URL(loadParams.url).toURI().getRawFragment();
            if (new URL(this.m.getUrl()).toURI().getFragment().equals(rawFragment)) {
                return;
            }
            this.m.evaluateJavascript("window.location.hash = \"" + rawFragment + "\";");
        } catch (MalformedURLException e2) {
            e2.printStackTrace();
        } catch (URISyntaxException e3) {
            e3.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        d dVar = this.m;
        if ((dVar instanceof WMLTRWebView) && ((WMLTRWebView) dVar).n()) {
            b();
        } else {
            this.m.evaluateJavascript("var newscript = document.createElement(\"script\");\nnewscript.src=\"https://hybrid.miniapp.taobao.com/index.js\";\ndocument.body.appendChild(newscript);\n");
            ((IPerformanceAndErrorTracker) RVProxy.get(IPerformanceAndErrorTracker.class)).sendPerfStageLog("Render", "start request index Js code");
        }
    }

    public static String a(final Page page) {
        final Timer timer = new Timer();
        final a aVar = new a();
        final int templateShopFetchRetryCount = TBShopOrangeController.getTemplateShopFetchRetryCount();
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        timer.schedule(new TimerTask() { // from class: com.alibaba.triver.triver_render.render.g.7

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            int f25220a = 0;

            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                try {
                    Log.d("getTSRData", "do get");
                    if (TRiverUrlUtils.isShop(page.getApp())) {
                        com.alibaba.triver.prefetch.mtop.d dVarA = com.alibaba.triver.prefetch.mtop.d.a();
                        Page page2 = page;
                        String strA = dVarA.a(page2 != null ? page2.getApp().getStartParams().getString(TRiverConstants.KEY_ORI_URL) : null);
                        if (this.f25220a == templateShopFetchRetryCount || !TextUtils.isEmpty(strA)) {
                            aVar.f25221a = strA;
                            countDownLatch.countDown();
                            timer.cancel();
                        }
                    } else {
                        try {
                            if (TextUtils.isEmpty(aVar.f25221a)) {
                                Page page3 = page;
                                TSRResource tSRResource = (TSRResource) PreloadScheduler.getInstance().getAndRemoveReadyResult((page3 == null || page3.getApp() == null) ? -1L : page.getApp().getStartToken(), TSRResource.class);
                                if (this.f25220a == templateShopFetchRetryCount || tSRResource != null) {
                                    aVar.f25221a = tSRResource.getTsrData();
                                    countDownLatch.countDown();
                                    timer.cancel();
                                }
                            }
                        } catch (Exception e2) {
                            e2.printStackTrace();
                        }
                    }
                    this.f25220a++;
                } catch (Exception e3) {
                    e3.printStackTrace();
                }
            }
        }, 0L, 50L);
        try {
            countDownLatch.await(templateShopFetchRetryCount * 50, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e2) {
            e2.printStackTrace();
        }
        return aVar.f25221a;
    }
}
