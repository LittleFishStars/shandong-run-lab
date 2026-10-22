package com.alibaba.triver.extensions;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.alibaba.ariver.app.api.App;
import com.alibaba.ariver.app.api.AppRestartResult;
import com.alibaba.ariver.app.api.Page;
import com.alibaba.ariver.app.api.point.app.AppDestroyPoint;
import com.alibaba.ariver.app.api.point.app.AppExitPoint;
import com.alibaba.ariver.app.api.point.app.AppLoadPoint;
import com.alibaba.ariver.app.api.point.app.AppPausePoint;
import com.alibaba.ariver.app.api.point.app.AppRestartPoint;
import com.alibaba.ariver.app.api.point.app.AppResumePoint;
import com.alibaba.ariver.app.api.point.app.AppStartPoint;
import com.alibaba.ariver.app.api.point.app.PushWindowPoint;
import com.alibaba.ariver.app.api.point.engine.EngineInitFailedPoint;
import com.alibaba.ariver.app.api.point.page.BackPressedPoint;
import com.alibaba.ariver.app.api.point.page.PageBackPoint;
import com.alibaba.ariver.app.api.point.page.PageDestroyPoint;
import com.alibaba.ariver.app.api.point.page.PageEnterPoint;
import com.alibaba.ariver.app.api.point.page.PageExitPoint;
import com.alibaba.ariver.app.api.point.page.PageHidePoint;
import com.alibaba.ariver.app.api.point.page.PageInitPoint;
import com.alibaba.ariver.app.api.point.page.PagePausePoint;
import com.alibaba.ariver.app.api.point.page.PageResumePoint;
import com.alibaba.ariver.app.api.point.page.PageShowPoint;
import com.alibaba.ariver.app.api.ui.loading.SplashView;
import com.alibaba.ariver.app.api.ui.titlebar.TitleBar;
import com.alibaba.ariver.kernel.RVParams;
import com.alibaba.ariver.kernel.api.extension.ExtensionPoint;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.service.executor.ExecutorType;
import com.alibaba.ariver.kernel.common.service.executor.RVExecutorService;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.ariver.mtop.monitor.RVCountDispatcher;
import com.alibaba.ariver.resource.api.models.AppInfoQuery;
import com.alibaba.ariver.resource.api.models.AppModel;
import com.alibaba.ariver.resource.api.proxy.RVAppInfoManager;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.triver.content.e;
import com.alibaba.triver.kit.api.appmonitor.LaunchMonitorData;
import com.alibaba.triver.kit.api.appmonitor.LaunchMonitorUtils;
import com.alibaba.triver.kit.api.appmonitor.TriverLaunchPointer;
import com.alibaba.triver.kit.api.common.TRiverConstants;
import com.alibaba.triver.kit.api.common.TriverAppMonitorConstants;
import com.alibaba.triver.kit.api.preload.core.PreloadScheduler;
import com.alibaba.triver.kit.api.proxy.ITriverAppMonitorProxy;
import com.alibaba.triver.kit.api.proxy.ITriverMonitorProxy;
import com.alibaba.triver.point.OnPreloadPoint;
import com.alibaba.triver.utils.CommonUtils;
import com.alibaba.triver.utils.PageUtils;
import com.ut.mini.UTAnalytics;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class AppLifecycleExtension implements AppDestroyPoint, AppExitPoint, AppLoadPoint, AppPausePoint, AppRestartPoint, AppResumePoint, AppStartPoint, PushWindowPoint, EngineInitFailedPoint, BackPressedPoint, PageBackPoint, PageDestroyPoint, PageEnterPoint, PageExitPoint, PageHidePoint, PageInitPoint, PagePausePoint, PageResumePoint, PageShowPoint, RVCountDispatcher.b {
    private static volatile WeakReference<Page> c;
    private static volatile WeakReference<App> d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f24928a = "appLifecycle";
    private ConcurrentHashMap<Page, a> b = new ConcurrentHashMap<>();
    private Map<String, String> e = null;
    private boolean f = false;

    public class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f24931a;
        public int b;
        public long c;
        public int d;
        public int e;
        public long f;
        public int g;
        public int h;

        private a() {
        }
    }

    private void a(Page page) {
        c = new WeakReference<>(page);
        if (page == null || this.b.get(page) != null) {
            return;
        }
        this.b.put(page, new a());
    }

    private void b(Page page) {
        Bundle startParams = page.getStartParams();
        if (startParams.containsKey(TRiverConstants.KEY_SPM_ORIGIN_URL)) {
            HashMap map = new HashMap();
            map.put(TRiverConstants.KEY_SPM_ORIGIN_URL, startParams.get(TRiverConstants.KEY_SPM_ORIGIN_URL));
            ((ITriverMonitorProxy) RVProxy.get(ITriverMonitorProxy.class)).updateNextPageProperties(page, map);
        }
    }

    private void c(Page page) {
        AppModel appModel = ((RVAppInfoManager) RVProxy.get(RVAppInfoManager.class)).getAppModel(new AppInfoQuery(page.getApp().getAppId()));
        if (appModel == null || appModel.getExtendInfos() == null || appModel.getExtendInfos().getJSONObject("sellerInfo") == null || appModel.getExtendInfos().getJSONObject("sellerInfo").getString("sellerId") == null) {
            return;
        }
        ((ITriverMonitorProxy) RVProxy.get(ITriverMonitorProxy.class)).updatePageProperties(page, (Map) JSON.toJavaObject(appModel.getExtendInfos().getJSONObject("sellerInfo"), Map.class));
    }

    public static App getCurrentApp() {
        if (d != null) {
            return d.get();
        }
        return null;
    }

    public static Page getCurrentPage() {
        if (c != null) {
            return c.get();
        }
        return null;
    }

    @Override // com.alibaba.ariver.app.api.point.page.BackPressedPoint
    public Boolean handleBackPressed(Page page) {
        if (page == null) {
            return null;
        }
        RVLogger.d(RVLogger.makeLogTag("appLifecycle"), "handleBackPressed appId:" + page.getApp().getAppId() + " ,url:" + page.getPageURI());
        return null;
    }

    @Override // com.alibaba.ariver.app.api.point.app.PushWindowPoint
    public boolean handlePushWindow(Page page, String str, Bundle bundle, Bundle bundle2) {
        bundle.remove("navigationBarForceEnable");
        bundle.remove(RVParams.LONG_PULL_REFRESH);
        bundle.remove(RVParams.LONG_CAN_PULL_DOWN);
        bundle.remove("navigationBarTextStyle");
        bundle.remove("showNavigationBar");
        String[] pushWindowParamsFilterList = CommonUtils.getPushWindowParamsFilterList();
        if (pushWindowParamsFilterList != null) {
            for (String str2 : pushWindowParamsFilterList) {
                bundle.remove(str2);
            }
        }
        return false;
    }

    @Override // com.alibaba.ariver.app.api.point.app.AppLoadPoint
    public void loadApp(String str, Bundle bundle, Bundle bundle2, AppLoadPoint.LoadResultCallback loadResultCallback) {
        RVLogger.d(RVLogger.makeLogTag("appLifecycle"), "loadApp appId:" + str + " ,url:");
    }

    @Override // com.alibaba.ariver.app.api.point.app.AppDestroyPoint
    public void onAppDestroy(App app) {
        RVLogger.d(RVLogger.makeLogTag("appLifecycle"), "onAppDestroy appId:" + app.getAppId() + " ,url:" + PageUtils.getRecentUrl(app));
        try {
            UTAnalytics.getInstance().getUTSceneTracker().endScene("miniApp");
        } catch (Throwable th) {
            th.printStackTrace();
        }
        this.e = null;
        if (app.getSceneParams() == null || !app.getSceneParams().getBoolean(TriverAppMonitorConstants.KEY_STAGE_WORKER_APPX_LOADED)) {
            if (app.getAppContext() == null || app.getAppContext().getSplashView() == null || app.getAppContext().getSplashView().getStatus() != SplashView.Status.ERROR) {
                ((ITriverAppMonitorProxy) RVProxy.get(ITriverAppMonitorProxy.class)).commitTriverLaunch(TriverLaunchPointer.build().setApp(app).setStage(TriverAppMonitorConstants.KEY_STAGE_USER_CANCEL).setStartParams(app.getStartParams()).setStatus(Double.valueOf(1.0d)).create());
            }
        }
    }

    @Override // com.alibaba.ariver.app.api.point.app.AppExitPoint
    public void onAppExit(App app) {
        if (app != null) {
            try {
                if (TextUtils.isEmpty(app.getAppId())) {
                    return;
                }
                RVLogger.d(RVLogger.makeLogTag("appLifecycle"), "onAppStart appId:" + app.getAppId() + " ,url:" + PageUtils.getRecentUrl(app));
            } catch (Throwable th) {
                RVLogger.e("appLifecycle", th);
            }
        }
    }

    @Override // com.alibaba.ariver.app.api.point.app.AppPausePoint
    public void onAppPause(App app) {
        if (app != null) {
            RVLogger.d(RVLogger.makeLogTag("appLifecycle"), "onAppPause appId:" + app.getAppId() + " ,url:" + PageUtils.getRecentUrl(app));
        }
        try {
            this.f = true;
            this.e = UTAnalytics.getInstance().getUTSceneTracker().endScene("miniApp");
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.alibaba.ariver.app.api.point.app.AppRestartPoint
    public AppRestartResult onAppRestart(App app, Bundle bundle, Bundle bundle2) {
        RVLogger.d(RVLogger.makeLogTag("appLifecycle"), "onAppRestart appId:" + app.getAppId() + " ,url:" + PageUtils.getRecentUrl(app));
        return null;
    }

    @Override // com.alibaba.ariver.app.api.point.app.AppResumePoint
    public void onAppResume(App app) {
        RVLogger.d(RVLogger.makeLogTag("appLifecycle"), "onAppResume appId:" + app.getAppId() + " ,url:" + PageUtils.getRecentUrl(app));
        try {
            Map<String, String> map = this.e;
            if (map != null && map.size() > 0) {
                UTAnalytics.getInstance().getUTSceneTracker().beginScene("miniApp", this.e, (Map) null);
            } else if (this.f) {
                this.f = false;
                UTAnalytics.getInstance().getUTSceneTracker().beginScene("miniApp", (Map) null, (Map) null);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.alibaba.ariver.app.api.point.app.AppStartPoint
    public void onAppStart(App app) {
        try {
            a(app);
        } catch (Throwable th) {
            th.printStackTrace();
        }
        RVLogger.d(RVLogger.makeLogTag("appLifecycle"), "onAppStart appId:" + app.getAppId() + " ,url:" + PageUtils.getRecentUrl(app));
        try {
            if (this.e == null) {
                HashMap map = new HashMap();
                map.put("spm-url", TRiverConstants.KEY_SPM_ORIGIN_URL);
                UTAnalytics.getInstance().getUTSceneTracker().beginScene("miniApp", (Map) null, map);
            }
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    @Override // com.alibaba.ariver.app.api.point.page.PageBackPoint
    public void onBackPerformed(Page page) {
        if (page == null) {
            return;
        }
        RVLogger.d(RVLogger.makeLogTag("appLifecycle"), "onBackPerformed appId:" + page.getApp().getAppId() + " ,url:" + page.getPageURI());
    }

    @Override // com.alibaba.ariver.app.api.point.engine.EngineInitFailedPoint
    public EngineInitFailedPoint.Action onEngineInitFailed() {
        return EngineInitFailedPoint.Action.SHOW_ERROR;
    }

    @Override // com.alibaba.ariver.mtop.monitor.RVCountDispatcher.b
    public void onEvent(RVCountDispatcher.a aVar) {
        Page currentPage = getCurrentPage();
        try {
            if (aVar.a() == 1) {
                if (currentPage != null) {
                    RVCountDispatcher.d dVar = (RVCountDispatcher.d) aVar;
                    int i = dVar.h;
                    if (i == 1) {
                        this.b.get(currentPage).f24931a++;
                    } else if (i == 2) {
                        this.b.get(currentPage).b++;
                    } else if (i == 3) {
                        this.b.get(currentPage).c += dVar.i;
                    }
                }
            } else if (aVar.a() == 2) {
                RVCountDispatcher.c cVar = (RVCountDispatcher.c) aVar;
                int i2 = cVar.h;
                if (i2 == 1) {
                    this.b.get(currentPage).d++;
                } else if (i2 == 2) {
                    this.b.get(currentPage).e++;
                } else if (i2 == 3) {
                    this.b.get(currentPage).f += cVar.i;
                }
            } else if (aVar.a() == 3) {
                int i3 = ((RVCountDispatcher.e) aVar).g;
                if (i3 == 1) {
                    this.b.get(currentPage).g++;
                } else if (i3 == 2) {
                    this.b.get(currentPage).h++;
                }
            }
        } catch (Throwable unused) {
        }
    }

    @Override // com.alibaba.ariver.kernel.api.extension.Extension
    public void onFinalized() {
        ((RVCountDispatcher) RVProxy.get(RVCountDispatcher.class)).removeListener(1, this);
        ((RVCountDispatcher) RVProxy.get(RVCountDispatcher.class)).removeListener(2, this);
        ((RVCountDispatcher) RVProxy.get(RVCountDispatcher.class)).removeListener(3, this);
    }

    @Override // com.alibaba.ariver.kernel.api.extension.Extension
    public void onInitialized() {
        ((RVCountDispatcher) RVProxy.get(RVCountDispatcher.class)).addListener(1, this);
        ((RVCountDispatcher) RVProxy.get(RVCountDispatcher.class)).addListener(2, this);
        ((RVCountDispatcher) RVProxy.get(RVCountDispatcher.class)).addListener(3, this);
    }

    @Override // com.alibaba.ariver.app.api.point.page.PageDestroyPoint
    public void onPageDestroy(Page page) {
        if (page == null) {
            return;
        }
        RVLogger.d(RVLogger.makeLogTag("appLifecycle"), "onPageInit appId:" + page.getApp().getAppId() + " ,url:" + page.getPageURI());
    }

    @Override // com.alibaba.ariver.app.api.point.page.PageEnterPoint
    public void onPageEnter(Page page) {
        a(page);
        RVLogger.d(RVLogger.makeLogTag("appLifecycle"), "onPageEnter appId:" + page.getApp().getAppId() + " ,url:" + page.getOriginalURI());
        try {
            ((ITriverAppMonitorProxy) RVProxy.get(ITriverAppMonitorProxy.class)).commitTriverLaunch(TriverLaunchPointer.build().setPage(page).setStage("pageStart").setStartParams(page.getApp().getStartParams()).setStatus(Double.valueOf(1.0d)).create());
            LaunchMonitorData launchMonitorData = new LaunchMonitorData();
            launchMonitorData.addPoint("pageStart");
            page.setData(LaunchMonitorData.class, launchMonitorData);
            b(page);
            c(page);
        } catch (Exception e) {
            RVLogger.e("appLifecycle", e);
        }
    }

    @Override // com.alibaba.ariver.app.api.point.page.PageExitPoint
    public void onPageExit(final Page page) {
        List<String> succeedPreloadName;
        if (page == null) {
            return;
        }
        LaunchMonitorUtils.commitPageMonitor(page);
        ITriverMonitorProxy iTriverMonitorProxy = (ITriverMonitorProxy) RVProxy.get(ITriverMonitorProxy.class);
        try {
            iTriverMonitorProxy.addData2Performance(page.getApp(), "networkSum", "" + (this.b.get(page).f24931a + this.b.get(page).b));
            iTriverMonitorProxy.addData2Performance(page.getApp(), "networkErrSum", "" + this.b.get(page).b);
            iTriverMonitorProxy.addData2Performance(page.getApp(), "networkDurationSum", "" + this.b.get(page).c);
            iTriverMonitorProxy.addData2Performance(page.getApp(), "mtopSum", "" + (this.b.get(page).d + this.b.get(page).e));
            iTriverMonitorProxy.addData2Performance(page.getApp(), "mtopErrSum", "" + this.b.get(page).e);
            iTriverMonitorProxy.addData2Performance(page.getApp(), "mtopDurationSum", "" + this.b.get(page).f);
            iTriverMonitorProxy.addData2Performance(page.getApp(), "resourceSum", "" + this.b.get(page).g);
            iTriverMonitorProxy.addData2Performance(page.getApp(), "resourceErrSum", "" + this.b.get(page).h);
            if (page.getApp() != null && (succeedPreloadName = PreloadScheduler.getInstance().getSucceedPreloadName(page.getApp().getStartToken())) != null) {
                Iterator<String> it = succeedPreloadName.iterator();
                while (it.hasNext()) {
                    iTriverMonitorProxy.addData2Performance(page.getApp(), it.next(), "true");
                }
            }
            this.b.remove(page);
        } catch (Throwable th) {
            RVLogger.e(TRiverConstants.TAG, "addData2Performance error!" + th.getMessage());
        }
        ((RVExecutorService) RVProxy.get(RVExecutorService.class)).getExecutor(ExecutorType.UI).execute(new Runnable() { // from class: com.alibaba.triver.extensions.AppLifecycleExtension.1
            @Override // java.lang.Runnable
            public void run() {
                if (page.getPageContext() != null) {
                    TitleBar titleBar = page.getPageContext().getTitleBar();
                    if (titleBar instanceof e) {
                        e eVar = (e) titleBar;
                        eVar.a().onHide();
                        eVar.a().onDestroy();
                    }
                }
            }
        });
        RVLogger.d(RVLogger.makeLogTag("appLifecycle"), "onPageExit appId:" + page.getApp().getAppId() + " ,url:" + page.getPageURI());
    }

    @Override // com.alibaba.ariver.app.api.point.page.PageHidePoint
    public void onPageHide(Page page) {
        if (page == null) {
            return;
        }
        RVLogger.d(RVLogger.makeLogTag("appLifecycle"), "onPageHide appId:" + page.getApp().getAppId() + " ,url:" + page.getPageURI());
    }

    @Override // com.alibaba.ariver.app.api.point.page.PageInitPoint
    public void onPageInit(String str, Bundle bundle, Bundle bundle2) {
        RVLogger.d(RVLogger.makeLogTag("appLifecycle"), "onPageInit appId:XXX ,url:" + str);
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: com.alibaba.triver.extensions.AppLifecycleExtension.2
            @Override // java.lang.Runnable
            public void run() {
                ((OnPreloadPoint) ExtensionPoint.as(OnPreloadPoint.class).create()).openPagePointPreload(AppLifecycleExtension.getCurrentPage());
            }
        }, 2000L);
    }

    @Override // com.alibaba.ariver.app.api.point.page.PagePausePoint
    public void onPagePause(Page page) {
        if (page == null) {
            return;
        }
        if (LaunchMonitorUtils.canReportPageOnPause(page)) {
            LaunchMonitorUtils.commitPageMonitor(page);
        }
        try {
            ((ITriverMonitorProxy) RVProxy.get(ITriverMonitorProxy.class)).addData2Performance(page.getApp(), "networkSum", "" + (this.b.get(page).f24931a + this.b.get(page).b));
            ((ITriverMonitorProxy) RVProxy.get(ITriverMonitorProxy.class)).addData2Performance(page.getApp(), "networkErrSum", "" + this.b.get(page).b);
            ((ITriverMonitorProxy) RVProxy.get(ITriverMonitorProxy.class)).addData2Performance(page.getApp(), "networkDurationSum", "" + this.b.get(page).c);
            ((ITriverMonitorProxy) RVProxy.get(ITriverMonitorProxy.class)).addData2Performance(page.getApp(), "mtopSum", "" + (this.b.get(page).d + this.b.get(page).e));
            ((ITriverMonitorProxy) RVProxy.get(ITriverMonitorProxy.class)).addData2Performance(page.getApp(), "mtopErrSum", "" + this.b.get(page).e);
            ((ITriverMonitorProxy) RVProxy.get(ITriverMonitorProxy.class)).addData2Performance(page.getApp(), "mtopDurationSum", "" + this.b.get(page).f);
            ((ITriverMonitorProxy) RVProxy.get(ITriverMonitorProxy.class)).addData2Performance(page.getApp(), "resourceSum", "" + this.b.get(page).g);
            ((ITriverMonitorProxy) RVProxy.get(ITriverMonitorProxy.class)).addData2Performance(page.getApp(), "resourceErrSum", "" + this.b.get(page).h);
            AppModel appModel = ((RVAppInfoManager) RVProxy.get(RVAppInfoManager.class)).getAppModel(new AppInfoQuery(page.getApp().getAppId()));
            if (appModel != null) {
                if (appModel.getAppInfoModel() != null && appModel.getAppInfoModel().getTemplateConfig() != null) {
                    ((ITriverMonitorProxy) RVProxy.get(ITriverMonitorProxy.class)).addData2Performance(page.getApp(), "templateId", "" + appModel.getAppInfoModel().getTemplateConfig().getTemplateId());
                }
                if (appModel.getExtendInfos() != null) {
                    ((ITriverMonitorProxy) RVProxy.get(ITriverMonitorProxy.class)).addData2Performance(page.getApp(), "bizType", appModel.getExtendInfos().getInteger("bizType").toString());
                    ((ITriverMonitorProxy) RVProxy.get(ITriverMonitorProxy.class)).addData2Performance(page.getApp(), TRiverConstants.KEY_SUB_BIZ_TYPE, appModel.getExtendInfos().getInteger(TRiverConstants.KEY_SUB_BIZ_TYPE).toString());
                }
            }
        } catch (Throwable th) {
            RVLogger.e(TRiverConstants.TAG, "addData2Performance error!" + th.getMessage());
        }
        RVLogger.d(RVLogger.makeLogTag("appLifecycle"), "onPagePause appId:" + page.getApp().getAppId() + " ,url:" + page.getPageURI());
    }

    @Override // com.alibaba.ariver.app.api.point.page.PageResumePoint
    public void onPageResume(Page page) {
        if (page == null) {
            return;
        }
        RVLogger.d(RVLogger.makeLogTag("appLifecycle"), "onPageResume appId:" + page.getApp().getAppId() + " ,url:" + page.getPageURI());
    }

    @Override // com.alibaba.ariver.app.api.point.page.PageShowPoint
    public void onPageShow(Page page, JSONObject jSONObject) {
        if (page == null) {
            return;
        }
        a(page);
        RVLogger.d(RVLogger.makeLogTag("appLifecycle"), "onPageShow appId:" + page.getApp().getAppId() + " ,url:" + page.getPageURI());
    }

    private void a(App app) {
        d = new WeakReference<>(app);
    }
}
