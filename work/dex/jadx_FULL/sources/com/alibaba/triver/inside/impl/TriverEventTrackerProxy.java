package com.alibaba.triver.inside.impl;

import android.text.TextUtils;
import com.alibaba.ariver.app.api.App;
import com.alibaba.ariver.app.api.Page;
import com.alibaba.ariver.app.api.monitor.RVMonitor;
import com.alibaba.ariver.kernel.api.monitor.PerfId;
import com.alibaba.ariver.kernel.api.node.Node;
import com.alibaba.ariver.kernel.api.track.Event;
import com.alibaba.ariver.kernel.api.track.EventTracker;
import com.alibaba.ariver.kernel.api.track.TrackId;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.service.executor.ExecutorType;
import com.alibaba.ariver.kernel.common.utils.ExecutorUtils;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.ariver.resource.api.snapshot.RVSnapshotUtils;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.triver.kit.api.appmonitor.LaunchMonitorData;
import com.alibaba.triver.kit.api.appmonitor.LaunchMonitorUtils;
import com.alibaba.triver.kit.api.common.TriverAppMonitorConstants;
import com.alibaba.triver.kit.api.monitor.IPerformanceAndErrorTracker;
import com.alibaba.triver.kit.api.orange.TROrangeController;
import com.alibaba.triver.kit.api.preload.core.PreloadScheduler;
import com.alibaba.triver.kit.api.proxy.ITriverMonitorProxy;
import com.alibaba.triver.kit.api.utils.TRiverUtils;
import com.alibaba.triver.trace.c;
import com.huawei.hms.framework.network.grs.GrsBaseInfo;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class TriverEventTrackerProxy implements EventTracker {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f24996a = "TriverEventTrackerProxy";

    private static void a(App app) {
        if (TROrangeController.enableSecondaryPagePreload(app)) {
            ExecutorUtils.runOnMain(new Runnable() { // from class: com.alibaba.triver.inside.impl.TriverEventTrackerProxy.1
                @Override // java.lang.Runnable
                public void run() {
                    ExecutorUtils.runNotOnMain(ExecutorType.URGENT, new Runnable() { // from class: com.alibaba.triver.inside.impl.TriverEventTrackerProxy.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            ((IPerformanceAndErrorTracker) RVProxy.get(IPerformanceAndErrorTracker.class)).sendPerfStageLog("SecondaryPagePreload", "start preload");
                            PreloadScheduler.getInstance().preLoad(PreloadScheduler.PointType.AFTER_PAGE_LOADED, null);
                        }
                    });
                }
            }, 2000L);
        }
    }

    @Override // com.alibaba.ariver.kernel.api.track.EventTracker
    public void addAttr(Node node, String str, String str2) {
    }

    @Override // com.alibaba.ariver.kernel.api.track.EventTracker
    public Event cost(Node node, String str, long j) {
        return null;
    }

    @Override // com.alibaba.ariver.kernel.api.track.EventTracker
    public Event error(Node node, String str, String str2) {
        return null;
    }

    @Override // com.alibaba.ariver.kernel.api.track.EventTracker
    public void event(Node node, Event event) {
        App app;
        LaunchMonitorData subMonitorData;
        LaunchMonitorData pageMonitorData;
        try {
            if (node instanceof App) {
                app = (App) node;
            } else {
                app = node instanceof Page ? ((Page) node).getApp() : null;
            }
            if (TextUtils.equals(event.getKey(), TrackId.Stub_JS_PageLoaded) && (node instanceof Page)) {
                Page page = (Page) node;
                ((IPerformanceAndErrorTracker) RVProxy.get(IPerformanceAndErrorTracker.class)).sendPerfStageLog("Page", TriverAppMonitorConstants.KEY_STAGE_PAGE_LOADED);
                a(app);
                com.alibaba.triver.trace.b.a(c.g, c.az, TRiverUtils.getSessionId(app), app, page, (JSONObject) null);
                if (page != null && (pageMonitorData = LaunchMonitorUtils.getPageMonitorData(page)) != null && !pageMonitorData.containsKey(TriverAppMonitorConstants.KEY_STAGE_PAGE_LOADED)) {
                    pageMonitorData.addPoint(TriverAppMonitorConstants.KEY_STAGE_PAGE_LOADED);
                }
                if (app != null && app.getData(LaunchMonitorData.class) != null && (subMonitorData = LaunchMonitorUtils.getSubMonitorData(page)) != null && !subMonitorData.containsKey(TriverAppMonitorConstants.KEY_STAGE_PAGE_LOADED)) {
                    subMonitorData.addPoint(TriverAppMonitorConstants.KEY_STAGE_PAGE_LOADED);
                }
                if (node != null && ((Page) node).getApp() != null && !RVSnapshotUtils.isSnapshotEnabled(((Page) node).getApp())) {
                    ((ITriverMonitorProxy) RVProxy.get(ITriverMonitorProxy.class)).addStagePerformance(((Page) node).getApp(), PerfId.firstScreen);
                    ((IPerformanceAndErrorTracker) RVProxy.get(IPerformanceAndErrorTracker.class)).sendPerfStageLog(PerfId.firstScreen, PerfId.firstScreen);
                }
                ((RVMonitor) RVProxy.get(RVMonitor.class)).flowLog("PAGE_LOADED", "pageLoaded： " + ((Page) node).getPageURI(), TrackId.Stub_PAGE_LOAD, (node == null || ((Page) node).getApp() == null) ? "" : ((Page) node).getApp().getAppId(), node != null ? ((Page) node).getPageURI() : "", null);
            } else if (TextUtils.equals(event.getKey(), TrackId.Stub_JS_AppLoaded)) {
                ((IPerformanceAndErrorTracker) RVProxy.get(IPerformanceAndErrorTracker.class)).sendPerfStageLog(GrsBaseInfo.CountryCodeSource.APP, TriverAppMonitorConstants.KEY_STAGE_APP_LOADED);
                ((RVMonitor) RVProxy.get(RVMonitor.class)).flowLog("APP_LOADED", TriverAppMonitorConstants.KEY_STAGE_APP_LOADED, "appLoad", app != null ? app.getAppId() : "", "", null);
                com.alibaba.triver.trace.b.a(c.g, c.az, TRiverUtils.getSessionId(app), app, (JSONObject) null);
                LaunchMonitorData subMonitorData2 = LaunchMonitorUtils.getSubMonitorData(app);
                if (subMonitorData2 != null && !subMonitorData2.containsKey(TriverAppMonitorConstants.KEY_STAGE_APP_LOADED)) {
                    subMonitorData2.addPoint(TriverAppMonitorConstants.KEY_STAGE_APP_LOADED);
                }
                if (node != null && ((Page) node).getApp() != null) {
                    ((Page) node).getApp().putBooleanValue(TriverAppMonitorConstants.KEY_STAGE_APP_LOADED, true);
                }
            } else if (TextUtils.equals(event.getKey(), TrackId.Stub_JS_RenderFrameworkLoaded) && (node instanceof Page)) {
                ((RVMonitor) RVProxy.get(RVMonitor.class)).flowLog("Render", "renderFrameworkLoaded： " + ((Page) node).getPageURI(), "appLoad", (node == null || ((Page) node).getApp() == null) ? "" : ((Page) node).getApp().getAppId(), node != null ? ((Page) node).getPageURI() : "", null);
                Page page2 = (Page) node;
                if (page2 != null) {
                    try {
                        LaunchMonitorData pageMonitorData2 = LaunchMonitorUtils.getPageMonitorData(page2);
                        if (pageMonitorData2 != null && !pageMonitorData2.containsKey(TriverAppMonitorConstants.KEY_STAGE_RENDER_FRAMEWORK_FINISH)) {
                            pageMonitorData2.addPoint(TriverAppMonitorConstants.KEY_STAGE_RENDER_FRAMEWORK_FINISH);
                        }
                    } catch (Exception e) {
                        RVLogger.w(f24996a, e.getMessage());
                    }
                }
                LaunchMonitorData subMonitorData3 = LaunchMonitorUtils.getSubMonitorData(page2);
                if (subMonitorData3 != null && !subMonitorData3.containsKey(TriverAppMonitorConstants.KEY_STAGE_RENDER_FRAMEWORK_FINISH)) {
                    subMonitorData3.addPoint(TriverAppMonitorConstants.KEY_STAGE_RENDER_FRAMEWORK_FINISH);
                }
            } else if (TextUtils.equals(event.getKey(), TrackId.Stub_JS_WorkerFrameworkLoaded)) {
                ((IPerformanceAndErrorTracker) RVProxy.get(IPerformanceAndErrorTracker.class)).sendPerfStageLog("Appx", TriverAppMonitorConstants.KEY_STAGE_WORKER_FRAMEWORK_LOADED);
                LaunchMonitorData subMonitorData4 = LaunchMonitorUtils.getSubMonitorData(app);
                if (subMonitorData4 != null && !subMonitorData4.containsKey(TriverAppMonitorConstants.KEY_STAGE_WORKER_FRAMEWORK_LOADED)) {
                    subMonitorData4.addPoint(TriverAppMonitorConstants.KEY_STAGE_WORKER_FRAMEWORK_LOADED);
                }
            }
            RVLogger.printPerformanceLog(event.getKey(), event.getKey());
        } catch (Exception e2) {
            RVLogger.e(f24996a, "event: ", e2);
        }
    }

    @Override // com.alibaba.ariver.kernel.api.track.EventTracker
    public Event interceptLoad(Node node, String str, Map<String, Object> map) {
        return null;
    }

    @Override // com.alibaba.ariver.kernel.api.track.EventTracker
    public void logPageAbnormal(Node node) {
    }

    @Override // com.alibaba.ariver.kernel.api.track.EventTracker
    public Event stub(Node node, String str) {
        App app;
        try {
            if (node instanceof App) {
                app = (App) node;
            } else {
                app = node instanceof Page ? ((Page) node).getApp() : null;
            }
            if (str.equals(TrackId.Stub_LoadMainResource_Begin)) {
                ((ITriverMonitorProxy) RVProxy.get(ITriverMonitorProxy.class)).addStagePerformance(app, str);
                com.alibaba.triver.trace.b.a(c.g, c.X, TRiverUtils.getSessionId(app), app, (JSONObject) null);
                LaunchMonitorData subMonitorData = LaunchMonitorUtils.getSubMonitorData(app);
                if (subMonitorData != null) {
                    subMonitorData.addPoint(TriverAppMonitorConstants.KEY_STAGE_MAIN_PACKAGE_LOAD_START);
                }
            } else if (str.equals(TrackId.Stub_LoadMainResource_End)) {
                ((ITriverMonitorProxy) RVProxy.get(ITriverMonitorProxy.class)).addStagePerformance(app, str);
                com.alibaba.triver.trace.b.a(c.g, c.Y, TRiverUtils.getSessionId(app), app, (JSONObject) null);
                LaunchMonitorData subMonitorData2 = LaunchMonitorUtils.getSubMonitorData(app);
                if (subMonitorData2 != null) {
                    subMonitorData2.addPoint(TriverAppMonitorConstants.KEY_STAGE_MAIN_PACKAGE_LOAD_FINISH);
                }
            } else if (str.equals(TrackId.Stub_PkgLoad)) {
                ((ITriverMonitorProxy) RVProxy.get(ITriverMonitorProxy.class)).addStagePerformance(app, str);
                com.alibaba.triver.trace.b.a(c.g, c.Z, TRiverUtils.getSessionId(app), app, (JSONObject) null);
                LaunchMonitorData subMonitorData3 = LaunchMonitorUtils.getSubMonitorData(app);
                if (subMonitorData3 != null) {
                    subMonitorData3.addPoint(TriverAppMonitorConstants.KEY_STAGE_PACKAGE_PREPARE_FINISH);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override // com.alibaba.ariver.kernel.api.track.EventTracker
    public Event stub(Node node, String str, long j) {
        return null;
    }

    @Override // com.alibaba.ariver.kernel.api.track.EventTracker
    public Event whiteScreen(Node node, String str, String str2, String str3, Map<String, Object> map) {
        return null;
    }

    @Override // com.alibaba.ariver.kernel.api.track.EventTracker
    public Event whiteScreen(Node node, String str, String str2, Map<String, Object> map) {
        return null;
    }

    @Override // com.alibaba.ariver.kernel.api.track.EventTracker
    public Event whiteScreen(String str, String str2, Map<String, Object> map) {
        return null;
    }
}
