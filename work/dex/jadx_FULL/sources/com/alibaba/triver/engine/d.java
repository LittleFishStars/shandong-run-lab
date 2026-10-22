package com.alibaba.triver.engine;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.taobao.windvane.jsbridge.WVJsBridge;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.alibaba.ariver.app.api.App;
import com.alibaba.ariver.app.api.Page;
import com.alibaba.ariver.app.api.monitor.RVMonitor;
import com.alibaba.ariver.engine.BaseEngineImpl;
import com.alibaba.ariver.engine.api.Render;
import com.alibaba.ariver.engine.api.Worker;
import com.alibaba.ariver.engine.api.bridge.model.CreateParams;
import com.alibaba.ariver.engine.api.bridge.model.EngineInitCallback;
import com.alibaba.ariver.engine.api.bridge.model.EngineSetupCallback;
import com.alibaba.ariver.engine.api.bridge.model.InitParams;
import com.alibaba.ariver.kernel.api.extension.ExtensionPoint;
import com.alibaba.ariver.kernel.api.monitor.ErrId;
import com.alibaba.ariver.kernel.api.node.Node;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.service.RVEnvironmentService;
import com.alibaba.ariver.kernel.common.service.executor.ExecutorType;
import com.alibaba.ariver.kernel.common.service.executor.RVExecutorService;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.ariver.resource.api.models.AppInfoModel;
import com.alibaba.ariver.resource.api.models.AppModel;
import com.alibaba.ariver.resource.api.models.PluginModel;
import com.alibaba.ariver.resource.api.models.TemplateConfigModel;
import com.alibaba.ariver.resource.api.snapshot.ISnapshotProxy;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.triver.kit.api.appmonitor.LaunchMonitorData;
import com.alibaba.triver.kit.api.appmonitor.LaunchMonitorUtils;
import com.alibaba.triver.kit.api.common.TRiverConstants;
import com.alibaba.triver.kit.api.common.TriverAppMonitorConstants;
import com.alibaba.triver.kit.api.monitor.IPerformanceAndErrorTracker;
import com.alibaba.triver.kit.api.orange.TBShopOrangeController;
import com.alibaba.triver.kit.api.orange.TROrangeController;
import com.alibaba.triver.kit.api.preload.core.PreloadScheduler;
import com.alibaba.triver.kit.api.proxy.IConfigProxy;
import com.alibaba.triver.kit.api.proxy.IEnvProxy;
import com.alibaba.triver.kit.api.proxy.ITriverMonitorProxy;
import com.alibaba.triver.kit.api.utils.CommonUtils;
import com.alibaba.triver.kit.api.utils.TRiverUrlUtils;
import com.alibaba.triver.kit.api.utils.TRiverUtils;
import com.alibaba.triver.point.TriverAnalyticsPoint;
import com.alibaba.triver.resource.e;
import com.alibaba.triver.triver_render.render.WMLTRWebView;
import com.alibaba.triver.triver_render.render.g;
import com.alibaba.triver.triver_worker.v8worker.TRV8Worker;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class d extends BaseEngineImpl {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f24919a = "TriverEngineImpl";
    private static final String b = "-9001";
    private static final String c = "uc core init fail";
    private static final String d = "uc init success";
    private Worker e;
    private HandlerThread f;
    private b g;

    public d(String str, Node node) {
        super(str, node);
        this.e = null;
        this.f = new HandlerThread("TriverRenderChannelThread");
        this.g = new b();
        this.f.start();
    }

    private TRV8Worker a(final App app, String str, final String str2) {
        List<PluginModel> plugins = null;
        final TRV8Worker tRV8Worker = !TRiverUtils.isDebugControlPanelApp(app) ? (TRV8Worker) PreloadScheduler.getInstance().getAndRemoveReadyResult(app != null ? app.getStartToken() : -1L, TRV8Worker.class) : null;
        if (tRV8Worker == null) {
            RVLogger.e("TRV8Worker preLoad miss");
            RVLogger.printPerformanceLog("V8Worker", "V8Worker preload miss");
            AppModel appModel = (AppModel) app.getData(AppModel.class);
            if (appModel != null && appModel.getAppInfoModel() != null && appModel.getAppInfoModel().getPlugins() != null && appModel.getAppInfoModel().getPlugins().size() > 0) {
                plugins = appModel.getAppInfoModel().getPlugins();
            }
            tRV8Worker = new TRV8Worker(app, str, plugins, null, null);
        } else {
            RVLogger.e("TRV8Worker preLoad hit");
            RVLogger.printPerformanceLog("V8Worker", "V8Worker preload hit");
            LaunchMonitorData subMonitorData = LaunchMonitorUtils.getSubMonitorData(app);
            if (subMonitorData != null && !subMonitorData.containsKey(TriverAppMonitorConstants.KEY_STAGE_WORKER_PRELOAD_HIT)) {
                subMonitorData.addPoint(TriverAppMonitorConstants.KEY_STAGE_WORKER_PRELOAD_HIT);
            }
        }
        if (!tRV8Worker.isPreload() || !TROrangeController.enableWorkerCodePreload()) {
            tRV8Worker.getWorkerHandler().post(new Runnable() { // from class: com.alibaba.triver.engine.d.2
                @Override // java.lang.Runnable
                public void run() {
                    tRV8Worker.setWorkerId(str2);
                    tRV8Worker.setRenderReady();
                    LaunchMonitorData subMonitorData2 = LaunchMonitorUtils.getSubMonitorData(app);
                    if (subMonitorData2 != null && !subMonitorData2.containsKey("callRenderReady")) {
                        subMonitorData2.addPoint("callRenderReady");
                    }
                    tRV8Worker.AlipayJSBridgeReady();
                    RVLogger.e("TRiver Use TRV8Worker");
                }
            });
            return tRV8Worker;
        }
        tRV8Worker.getWorkerHandler().post(new Runnable() { // from class: com.alibaba.triver.engine.d.1
            @Override // java.lang.Runnable
            public void run() {
                tRV8Worker.setRenderReady();
            }
        });
        LaunchMonitorData subMonitorData2 = LaunchMonitorUtils.getSubMonitorData(app);
        if (subMonitorData2 != null && !subMonitorData2.containsKey("callRenderReady")) {
            subMonitorData2.addPoint("callRenderReady");
        }
        return tRV8Worker;
    }

    /* JADX WARN: Code duplicated, block: B:15:0x003f  */
    private com.alibaba.triver.triver_worker.v8worker.jsi.d b(App app, String str, String str2) {
        final com.alibaba.triver.triver_worker.v8worker.jsi.d dVarB;
        com.alibaba.triver.triver_worker.v8worker.jsi.d dVar;
        long startToken = app != null ? app.getStartToken() : -1L;
        List<PluginModel> plugins = null;
        if (TRiverUtils.isDebugControlPanelApp(app)) {
            dVarB = null;
        } else if (TRiverUrlUtils.isShop(app)) {
            com.alibaba.triver.preload.b.e.c cVar = (com.alibaba.triver.preload.b.e.c) PreloadScheduler.getInstance().getAndRemoveReadyResult(startToken, com.alibaba.triver.preload.b.e.c.class);
            if (cVar != null) {
                dVarB = cVar.b();
                if (!a(app, dVarB)) {
                    b(dVarB);
                    dVarB = null;
                }
            } else {
                dVarB = null;
            }
        } else {
            dVarB = (com.alibaba.triver.triver_worker.v8worker.jsi.d) PreloadScheduler.getInstance().getAndRemoveReadyResult(startToken, com.alibaba.triver.triver_worker.v8worker.jsi.d.class);
        }
        if (TROrangeController.isBadBucket() || !a(dVarB)) {
            if (dVarB != null) {
                ((IPerformanceAndErrorTracker) RVProxy.get(IPerformanceAndErrorTracker.class)).sendPerfStageLog("Worker", "worker appX version not match");
            }
            b(dVarB);
            dVarB = null;
        }
        AppModel appModel = (AppModel) app.getData(AppModel.class);
        if (appModel != null && appModel.getAppInfoModel() != null && appModel.getAppInfoModel().getPlugins() != null && appModel.getAppInfoModel().getPlugins().size() > 0) {
            plugins = appModel.getAppInfoModel().getPlugins();
        }
        List<PluginModel> list = plugins;
        if (dVarB == null || !dVarB.K()) {
            dVar = new com.alibaba.triver.triver_worker.v8worker.jsi.d(app, str, list, null, null);
            dVar.setWorkerId(str2);
            dVar.J();
            dVar.setRenderReady();
            LaunchMonitorData subMonitorData = LaunchMonitorUtils.getSubMonitorData(app);
            if (subMonitorData != null && !subMonitorData.containsKey("callRenderReady")) {
                subMonitorData.addPoint("callRenderReady");
            }
        } else {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("workerPreloadCtx", (Object) dVarB.N());
            com.alibaba.triver.trace.b.a(com.alibaba.triver.trace.c.i, com.alibaba.triver.trace.c.aq, TRiverUtils.getSessionId(app), app, jSONObject);
            dVarB.c(app);
            dVarB.d(app);
            dVarB.getWorkerHandler().post(new Runnable() { // from class: com.alibaba.triver.engine.d.3
                @Override // java.lang.Runnable
                public void run() {
                    dVarB.setRenderReady();
                }
            });
            LaunchMonitorData subMonitorData2 = LaunchMonitorUtils.getSubMonitorData(app);
            if (subMonitorData2 != null && !subMonitorData2.containsKey("callRenderReady")) {
                subMonitorData2.addPoint("callRenderReady");
            }
            LaunchMonitorData subMonitorData3 = LaunchMonitorUtils.getSubMonitorData(app);
            if (subMonitorData3 != null && !subMonitorData3.containsKey(TriverAppMonitorConstants.KEY_STAGE_WORKER_APPX_LOADED)) {
                subMonitorData3.addPoint(TriverAppMonitorConstants.KEY_STAGE_WORKER_APPX_LOADED);
            }
            dVar = dVarB;
        }
        if (dVarB != null && !dVarB.K()) {
            b(dVarB);
        }
        if (dVarB == dVar) {
            if (TRiverUrlUtils.isShop(app)) {
                c(dVar);
            }
            TRiverUtils.toastInDebug("JSI Worker 预启动命中");
            RVLogger.printPerformanceLog("Worker", "Worker preload 命中");
            LaunchMonitorData subMonitorData4 = LaunchMonitorUtils.getSubMonitorData(app);
            if (subMonitorData4 != null) {
                subMonitorData4.addPoint(TriverAppMonitorConstants.KEY_STAGE_WORKER_PRELOAD_HIT);
            }
        }
        return dVar;
    }

    private void c(com.alibaba.triver.triver_worker.v8worker.jsi.d dVar) {
        if (getTopRender() == null || dVar == null) {
            return;
        }
        Activity activity = getTopRender().getActivity();
        if (dVar.i() instanceof com.alibaba.triver.triver_worker.v8worker.jsi.c) {
            Set<String> setA = ((com.alibaba.triver.triver_worker.v8worker.jsi.c) dVar.i()).a();
            StringBuilder sb = new StringBuilder();
            Iterator<String> it = setA.iterator();
            while (it.hasNext()) {
                sb.append(it.next());
                sb.append("\n");
            }
            if (sb.length() != 0) {
                TRiverUtils.alertInDebug(activity, sb.toString(), "店铺Worker预加载信息");
            }
        }
    }

    @Override // com.alibaba.ariver.engine.api.RVEngine
    public Render createRender(Activity activity, Node node, CreateParams createParams) {
        WMLTRWebView wMLTRWebView;
        ((IPerformanceAndErrorTracker) RVProxy.get(IPerformanceAndErrorTracker.class)).sendPerfStageLog("Render", "Start create render");
        boolean z = true;
        if (TROrangeController.enableWVJSBridgeEnable()) {
            WVJsBridge.getInstance().setEnabled(true);
        }
        a(activity, node);
        Page page = (Page) node;
        App app = page != null ? page.getApp() : null;
        if (page != null) {
            try {
                try {
                    if (!TRiverUrlUtils.isShop(page.getApp())) {
                        HashMap map = new HashMap();
                        map.put("miniAppBucketId", String.valueOf(TROrangeController.bucketId));
                        map.put("isMiniApp", "true");
                        ((ITriverMonitorProxy) RVProxy.get(ITriverMonitorProxy.class)).updatePageProperties(page.getPageContext().getActivity(), map);
                    }
                    if (!TRiverUrlUtils.isShop(page.getApp())) {
                        HashMap map2 = new HashMap();
                        map2.put("miniAppBucketId", String.valueOf(TROrangeController.bucketId));
                        map2.put("fromMiniApp", "true");
                        ((ITriverMonitorProxy) RVProxy.get(ITriverMonitorProxy.class)).updateNextPageProperties(page.getPageContext().getActivity(), map2);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } catch (Throwable th) {
                HashMap map3 = new HashMap();
                map3.put(com.alibaba.triver.triver_render.view.canvas.tinyapp.c.f25231a, th.toString());
                ((RVMonitor) RVProxy.get(RVMonitor.class)).error(null, ErrId.RV_TYPE_PAGE_ABNORMAL, "小程序-白屏-Crash6", "craeteRender", new HashMap(), map3);
                c.a(app, null);
                return null;
            }
        }
        JSONObject jSONObject = new JSONObject();
        if (createParams != null) {
            com.alibaba.triver.trace.b.a(com.alibaba.triver.trace.c.h, com.alibaba.triver.trace.c.ad, TRiverUtils.getSessionId(createParams.startParams), page, jSONObject);
        }
        if (page != null) {
            try {
                b bVar = this.g;
                if (bVar != null) {
                    bVar.a(page.getApp());
                }
            } catch (Exception e2) {
                HashMap map4 = new HashMap();
                map4.put(com.alibaba.triver.triver_render.view.canvas.tinyapp.c.f25231a, e2.toString());
                ((RVMonitor) RVProxy.get(RVMonitor.class)).error(null, ErrId.RV_TYPE_PAGE_ABNORMAL, "小程序-白屏-Crash4", "setShopRuntimeDowngradeTimer", new HashMap(), map4);
            }
        }
        if (TRiverUtils.isAuthPage(page.getOriginalURI())) {
            if (createParams != null) {
                com.alibaba.triver.trace.b.a(com.alibaba.triver.trace.c.h, com.alibaba.triver.trace.c.ae, TRiverUtils.getSessionId(createParams.startParams), page, jSONObject);
            }
            return "true".equals(((IConfigProxy) RVProxy.get(IConfigProxy.class)).getConfigsByGroupAndName("triver_common_config", TRiverConstants.ORANGE_KEY_SUBSCRIBE_SWITCH, "true")) ? new com.alibaba.triver.support.ui.auth.settings.b(this, activity, page, createParams) : new com.alibaba.triver.support.ui.auth.settings.a(this, activity, page, createParams);
        }
        try {
            ISnapshotProxy iSnapshotProxy = (ISnapshotProxy) RVProxy.get(ISnapshotProxy.class);
            if (iSnapshotProxy == null || !iSnapshotProxy.isSnapshotFileExist(page.getApp())) {
                z = false;
            }
            WMLTRWebView wMLTRWebViewA = (!"AriverApp".equals(((IEnvProxy) RVProxy.get(IEnvProxy.class)).getAppGroup()) && TRiverUrlUtils.isShop(page.getApp())) ? a(page, z) : b(page, z);
            wMLTRWebView = wMLTRWebViewA;
        } catch (Exception e3) {
            HashMap map5 = new HashMap();
            map5.put(com.alibaba.triver.triver_render.view.canvas.tinyapp.c.f25231a, e3.toString());
            ((RVMonitor) RVProxy.get(RVMonitor.class)).error(null, ErrId.RV_TYPE_PAGE_ABNORMAL, "小程序-白屏-Crash5", "createRenderForCommon", new HashMap(), map5);
            wMLTRWebView = null;
        }
        if (createParams != null) {
            try {
                com.alibaba.triver.trace.b.a(com.alibaba.triver.trace.c.h, com.alibaba.triver.trace.c.ag, TRiverUtils.getSessionId(createParams.startParams), page, jSONObject);
            } catch (Exception e4) {
                RVLogger.w(f24919a, e4.getMessage());
            }
        }
        LaunchMonitorData subMonitorData = LaunchMonitorUtils.getSubMonitorData(page);
        if (subMonitorData != null && !subMonitorData.containsKey(TriverAppMonitorConstants.KEY_STAGE_RENDER_START)) {
            subMonitorData.addPoint(TriverAppMonitorConstants.KEY_STAGE_RENDER_START);
        }
        return new g(this, activity, (Page) node, createParams, wMLTRWebView, new Handler(this.f.getLooper()));
    }

    @Override // com.alibaba.ariver.engine.api.RVEngine
    public Worker createWorker(Context context, Node node, String str, String str2) {
        PreloadScheduler.UA = str2;
        App app = (App) node.bubbleFindNode(App.class);
        ((IPerformanceAndErrorTracker) RVProxy.get(IPerformanceAndErrorTracker.class)).sendPerfStageLog("Worker", "register worker");
        try {
            LaunchMonitorData subMonitorData = LaunchMonitorUtils.getSubMonitorData(app);
            if (subMonitorData != null) {
                subMonitorData.addPoint(TriverAppMonitorConstants.KEY_STAGE_WORKER_START);
            }
            boolean zNeedForceUseV8Worker = TROrangeController.needForceUseV8Worker(app);
            boolean zEnableJSIWorkerByAppIdAndTemplateId = TROrangeController.enableJSIWorkerByAppIdAndTemplateId(app);
            boolean zIsAppInJSIWorkerBlackList = TROrangeController.isAppInJSIWorkerBlackList(app);
            boolean zShopForceUseJSI = TBShopOrangeController.shopForceUseJSI(app);
            if ((!zEnableJSIWorkerByAppIdAndTemplateId || zNeedForceUseV8Worker || zIsAppInJSIWorkerBlackList) && !zShopForceUseJSI) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("core", (Object) "V8");
                com.alibaba.triver.trace.b.a(com.alibaba.triver.trace.c.i, com.alibaba.triver.trace.c.ap, TRiverUtils.getSessionId(app), app, jSONObject);
                ((IPerformanceAndErrorTracker) RVProxy.get(IPerformanceAndErrorTracker.class)).sendPerfStageLog("Worker", "register worker ,use v8 worker , forceUseV8Worker = " + zNeedForceUseV8Worker);
                this.e = a(app, str2, str);
                if (subMonitorData != null && !subMonitorData.containsKey(TriverAppMonitorConstants.KEY_STAGE_WORKER_APPX_LOADED)) {
                    subMonitorData.addPoint(TriverAppMonitorConstants.KEY_STAGE_WORKER_APPX_LOADED);
                }
            } else {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("core", (Object) "JSI");
                com.alibaba.triver.trace.b.a(com.alibaba.triver.trace.c.i, com.alibaba.triver.trace.c.ap, TRiverUtils.getSessionId(app), app, jSONObject2);
                ((IPerformanceAndErrorTracker) RVProxy.get(IPerformanceAndErrorTracker.class)).sendPerfStageLog("Worker", "register worker ,use jsi worker");
                this.e = b(app, str2, str);
            }
            Bundle sceneParams = app != null ? app.getSceneParams() : null;
            if (sceneParams != null) {
                sceneParams.putBoolean(TriverAppMonitorConstants.KEY_STAGE_WORKER_APPX_LOADED, true);
            }
            ((ITriverMonitorProxy) RVProxy.get(ITriverMonitorProxy.class)).addStagePerformance(app, "frameworkLoaded");
        } catch (Exception e) {
            HashMap map = new HashMap();
            map.put(com.alibaba.triver.triver_render.view.canvas.tinyapp.c.f25231a, e.toString());
            ((RVMonitor) RVProxy.get(RVMonitor.class)).error(null, ErrId.RV_TYPE_PAGE_ABNORMAL, "小程序-白屏-Crash7", "createWorker", new HashMap(), map);
            c.a(app, null);
        }
        return this.e;
    }

    @Override // com.alibaba.ariver.engine.api.RVEngine
    public String getInstanceId() {
        return null;
    }

    @Override // com.alibaba.ariver.engine.BaseEngineImpl, com.alibaba.ariver.engine.api.RVEngine
    public void init(InitParams initParams, EngineInitCallback engineInitCallback) {
        try {
            super.init(this.initParams, engineInitCallback);
            JSONObject jSONObject = new JSONObject();
            if ("AriverApp".equals(((IEnvProxy) RVProxy.get(IEnvProxy.class)).getAppGroup())) {
                jSONObject.put("appType", (Object) "AriverApp");
            } else {
                jSONObject.put("appType", (Object) "AliApp");
            }
            if (initParams != null) {
                com.alibaba.triver.trace.b.a(com.alibaba.triver.trace.c.h, com.alibaba.triver.trace.c.aa, TRiverUtils.getSessionId(initParams.startParams), getAppId(), jSONObject);
            }
            if (WMLTRWebView.j()) {
                if (initParams != null) {
                    com.alibaba.triver.trace.b.a(com.alibaba.triver.trace.c.h, com.alibaba.triver.trace.c.ab, TRiverUtils.getSessionId(initParams.startParams), getAppId(), jSONObject);
                }
                engineInitCallback.initResult(true, d);
                return;
            }
            if ("AriverApp".equals(((IEnvProxy) RVProxy.get(IEnvProxy.class)).getAppGroup())) {
                engineInitCallback.initResult(false, c);
                if (initParams != null) {
                    com.alibaba.triver.trace.b.a(com.alibaba.triver.trace.c.h, com.alibaba.triver.trace.c.ac, TRiverUtils.getSessionId(initParams.startParams), getAppId(), b, c, jSONObject);
                    return;
                }
                return;
            }
            WMLTRWebView.k();
            jSONObject.put("waitUCTime", (Object) Integer.valueOf(TROrangeController.waitUCInitTime()));
            if (WMLTRWebView.j()) {
                if (initParams != null) {
                    com.alibaba.triver.trace.b.a(com.alibaba.triver.trace.c.h, com.alibaba.triver.trace.c.ab, TRiverUtils.getSessionId(initParams.startParams), getAppId(), jSONObject);
                }
                engineInitCallback.initResult(true, d);
            } else {
                if (initParams != null) {
                    com.alibaba.triver.trace.b.a(com.alibaba.triver.trace.c.h, com.alibaba.triver.trace.c.ac, TRiverUtils.getSessionId(initParams.startParams), getAppId(), b, c, jSONObject);
                }
                engineInitCallback.initResult(false, c);
            }
        } catch (Exception e) {
            engineInitCallback.initResult(false, c);
            HashMap map = new HashMap();
            map.put(com.alibaba.triver.triver_render.view.canvas.tinyapp.c.f25231a, e.toString());
            ((RVMonitor) RVProxy.get(RVMonitor.class)).error(null, ErrId.RV_TYPE_PAGE_ABNORMAL, "小程序-白屏-Crash3", "initEngine", new HashMap(), map);
        }
    }

    @Override // com.alibaba.ariver.engine.api.RVEngine
    public boolean isReady() {
        return false;
    }

    @Override // com.alibaba.ariver.engine.BaseEngineImpl
    public void onDestroy() {
        Worker worker = this.e;
        if (worker != null) {
            worker.destroy();
        }
        super.onDestroy();
        try {
            this.f.quitSafely();
            b bVar = this.g;
            if (bVar != null) {
                bVar.a();
            }
        } catch (Throwable th) {
            RVLogger.e("mRenderChannelThread quit error", th);
        }
    }

    @Override // com.alibaba.ariver.engine.api.RVEngine
    public void setup(Bundle bundle, Bundle bundle2, EngineSetupCallback engineSetupCallback) {
    }

    private void c(Page page, boolean z) {
        RVLogger.e("Render", "Webview preLoad hit");
        RVLogger.printPerformanceLog("Render", "Render preload 命中");
        try {
            final Application applicationContext = ((RVEnvironmentService) RVProxy.get(RVEnvironmentService.class)).getApplicationContext();
            if (applicationContext != null && CommonUtils.isApkDebug(applicationContext)) {
                ((RVExecutorService) RVProxy.get(RVExecutorService.class)).getExecutor(ExecutorType.UI).execute(new Runnable() { // from class: com.alibaba.triver.engine.d.6
                    @Override // java.lang.Runnable
                    public void run() {
                        Toast.makeText(applicationContext, "命中 Render预启", 1).show();
                    }
                });
            }
            if (page != null) {
                LaunchMonitorData subMonitorData = LaunchMonitorUtils.getSubMonitorData(page);
                if (subMonitorData != null) {
                    subMonitorData.addPoint(TriverAppMonitorConstants.KEY_STAGE_RENDER_PRELOAD_HIT);
                }
                if (!z || subMonitorData == null) {
                    return;
                }
                subMonitorData.addPoint(TriverAppMonitorConstants.KEY_STAGE_TEMPLATE_SNAPSHOT_HIT);
            }
        } catch (Exception unused) {
            RVLogger.e(f24919a, "snapshot hit monitor error!");
        }
    }

    private void c(Page page) {
        LaunchMonitorData subMonitorData = LaunchMonitorUtils.getSubMonitorData(page);
        if (subMonitorData != null) {
            subMonitorData.addPoint(TriverAppMonitorConstants.KEY_STAGE_RENDER_PRELOAD_TEMPLATE_VERSION_MISS);
        }
        RVLogger.e("Render", "template version miss , will not use preload webView");
    }

    private boolean a(com.alibaba.triver.triver_worker.v8worker.jsi.d dVar) {
        e eVarB;
        return (dVar == null || (eVarB = com.alibaba.triver.preload.b.a.a.b()) == null || eVarB.hashCode() != dVar.M()) ? false : true;
    }

    private boolean a(App app, com.alibaba.triver.triver_worker.v8worker.jsi.d dVar) {
        AppModel appModel;
        AppInfoModel appInfoModel;
        if (app == null || (appModel = (AppModel) app.getData(AppModel.class)) == null || (appInfoModel = appModel.getAppInfoModel()) == null) {
            return false;
        }
        List<PluginModel> plugins = appInfoModel.getPlugins();
        if (plugins == null) {
            return true;
        }
        for (PluginModel pluginModel : plugins) {
            String appId = pluginModel.getAppId();
            if (dVar.f(appId)) {
                String developerVersion = pluginModel.getDeveloperVersion();
                String strE = dVar.e(appId);
                if (!TextUtils.equals(developerVersion, strE)) {
                    ((IPerformanceAndErrorTracker) RVProxy.get(IPerformanceAndErrorTracker.class)).sendPerfStageLog("ShopWorker", "plugin = " + appId + " preload plugin version = " + strE + " , pluginModel version is = " + developerVersion + ", not match");
                    return false;
                }
            }
        }
        return true;
    }

    private boolean a(com.alibaba.triver.preload.b.c.d dVar) {
        e eVarB = com.alibaba.triver.preload.b.a.a.b();
        return (eVarB == null || dVar == null || dVar.c() != eVarB.hashCode()) ? false : true;
    }

    private boolean a(com.alibaba.triver.preload.b.c.d dVar, App app) {
        AppModel appModel;
        TemplateConfigModel templateConfig;
        if (app == null || dVar == null || (appModel = (AppModel) app.getData(AppModel.class)) == null || (templateConfig = appModel.getAppInfoModel().getTemplateConfig()) == null) {
            return false;
        }
        String templateVersion = templateConfig.getTemplateVersion();
        String strF = dVar.f();
        if (templateVersion != null) {
            return templateVersion.equals(strF);
        }
        return false;
    }

    private WMLTRWebView a(Page page, boolean z) {
        WMLTRWebView wMLTRWebViewA;
        WMLTRWebView wMLTRWebView = null;
        if (TRiverUtils.isDebugControlPanelApp(page.getApp())) {
            return null;
        }
        if (z) {
            b(page);
            return null;
        }
        if (com.alibaba.triver.utils.CommonUtils.isRrenderPreloadVHost(com.alibaba.triver.utils.CommonUtils.getVhost(page.getApp()))) {
            com.alibaba.triver.preload.b.c.d dVar = (com.alibaba.triver.preload.b.c.d) page.getData(com.alibaba.triver.preload.b.c.d.class);
            page.setData(com.alibaba.triver.preload.b.c.d.class, null);
            if (dVar != null) {
                if (a(dVar)) {
                    if (TRiverUrlUtils.isShop(page.getApp())) {
                        if (dVar.a().m()) {
                            if (a(dVar, page.getApp())) {
                                wMLTRWebViewA = dVar.a();
                                JSONObject jSONObject = new JSONObject();
                                jSONObject.put("renderPreloadCtx", (Object) dVar.g());
                                com.alibaba.triver.trace.b.a(com.alibaba.triver.trace.c.h, com.alibaba.triver.trace.c.af, TRiverUtils.getSessionId(page), page, jSONObject);
                            } else {
                                c(page);
                            }
                        } else {
                            wMLTRWebViewA = dVar.a();
                        }
                        wMLTRWebView = wMLTRWebViewA;
                    }
                } else {
                    a(page);
                }
            }
            if (wMLTRWebView != null) {
                c(page, dVar.a().m());
            } else {
                b(dVar);
                RVLogger.e("Render", "Webview preLoad miss");
            }
        } else {
            RVLogger.e("Render", "preload switch disable");
        }
        return wMLTRWebView;
    }

    private void b(final com.alibaba.triver.triver_worker.v8worker.jsi.d dVar) {
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: com.alibaba.triver.engine.d.4
            @Override // java.lang.Runnable
            public void run() {
                try {
                    com.alibaba.triver.triver_worker.v8worker.jsi.d dVar2 = dVar;
                    if (dVar2 != null) {
                        dVar2.destroy();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }, 10000L);
    }

    private void b(final com.alibaba.triver.preload.b.c.d dVar) {
        if (dVar != null) {
            try {
                new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: com.alibaba.triver.engine.d.5
                    @Override // java.lang.Runnable
                    public void run() {
                        RVLogger.e("Render", "release missed webview");
                        dVar.d();
                    }
                }, 10000L);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private WMLTRWebView b(Page page, boolean z) {
        WMLTRWebView wMLTRWebViewA = null;
        if (TRiverUtils.isDebugControlPanelApp(page.getApp())) {
            return null;
        }
        if (z) {
            b(page);
            return null;
        }
        if (com.alibaba.triver.utils.CommonUtils.isRrenderPreloadVHost(com.alibaba.triver.utils.CommonUtils.getVhost(page.getApp()))) {
            com.alibaba.triver.preload.b.c.d dVar = (com.alibaba.triver.preload.b.c.d) page.getData(com.alibaba.triver.preload.b.c.c.class);
            page.setData(com.alibaba.triver.preload.b.c.c.class, null);
            if (dVar != null) {
                if (a(dVar)) {
                    wMLTRWebViewA = dVar.a();
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("renderPreloadCtx", (Object) dVar.g());
                    com.alibaba.triver.trace.b.a(com.alibaba.triver.trace.c.h, com.alibaba.triver.trace.c.af, TRiverUtils.getSessionId(page), page, jSONObject);
                } else {
                    a(page);
                }
            }
            if (wMLTRWebViewA != null) {
                c(page, false);
            } else {
                b(dVar);
                RVLogger.e("Render", "Webview preLoad miss");
            }
        } else {
            RVLogger.e("Render", "preload switch disable");
        }
        return wMLTRWebViewA;
    }

    private void a(Page page) {
        RVLogger.e("Render", "Preload Render APPX version do not match the appx version in memory.");
        LaunchMonitorData subMonitorData = LaunchMonitorUtils.getSubMonitorData(page);
        if (subMonitorData != null) {
            subMonitorData.addPoint(TriverAppMonitorConstants.KEY_STAGE_RENDER_PRELOAD_APPX_MISS);
        }
    }

    private void b(Page page) {
        LaunchMonitorData subMonitorData = LaunchMonitorUtils.getSubMonitorData(page);
        if (subMonitorData != null) {
            subMonitorData.addPoint(TriverAppMonitorConstants.KEY_STAGE_RENDER_PRELOAD_SNPASHOT_MISS);
        }
        RVLogger.e("Render", "snapshot enable , will not use preload webView");
    }

    private void a(final Activity activity, final Node node) {
        if (com.alibaba.triver.utils.CommonUtils.isApkDebug() && !TRiverUtils.isDebugControlPanelApp(TRiverUtils.getAppByNode(node))) {
            new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: com.alibaba.triver.engine.d.7
                @Override // java.lang.Runnable
                public void run() {
                    Activity activity2 = activity;
                    if (activity2 == null) {
                        return;
                    }
                    try {
                        View decorView = activity2.getWindow().getDecorView();
                        if (decorView != null && (decorView instanceof ViewGroup)) {
                            TextView textView = new TextView(activity);
                            textView.setText("Prefetch");
                            textView.setTextColor(-65536);
                            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
                            layoutParams.gravity = 8388627;
                            ((ViewGroup) decorView).addView(textView, layoutParams);
                            textView.setOnClickListener(new View.OnClickListener() { // from class: com.alibaba.triver.engine.d.7.1
                                @Override // android.view.View.OnClickListener
                                public void onClick(View view) {
                                    TriverAnalyticsPoint triverAnalyticsPoint = (TriverAnalyticsPoint) ExtensionPoint.as(TriverAnalyticsPoint.class).create();
                                    AnonymousClass7 anonymousClass7 = AnonymousClass7.this;
                                    triverAnalyticsPoint.showPrefetchActivity(activity, node);
                                }
                            });
                        }
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                }
            }, 2000L);
        }
    }
}
