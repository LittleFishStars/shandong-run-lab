package com.alibaba.ariver.app;

import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import android.taobao.windvane.util.WVNativeCallbackUtil;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.Nullable;
import com.alibaba.ariver.app.api.App;
import com.alibaba.ariver.app.api.AppContext;
import com.alibaba.ariver.app.api.AppLoadResult;
import com.alibaba.ariver.app.api.AppManager;
import com.alibaba.ariver.app.api.AppRestartResult;
import com.alibaba.ariver.app.api.EntryInfo;
import com.alibaba.ariver.app.api.Page;
import com.alibaba.ariver.app.api.ParamUtils;
import com.alibaba.ariver.app.api.monitor.RVMonitor;
import com.alibaba.ariver.app.api.monitor.RVPerformanceTracker;
import com.alibaba.ariver.app.api.point.app.AppDestroyPoint;
import com.alibaba.ariver.app.api.point.app.AppExitPoint;
import com.alibaba.ariver.app.api.point.app.AppInteractionPoint;
import com.alibaba.ariver.app.api.point.app.AppLeaveHintPoint;
import com.alibaba.ariver.app.api.point.app.AppLoadPoint;
import com.alibaba.ariver.app.api.point.app.AppOnConfigurationChangedPoint;
import com.alibaba.ariver.app.api.point.app.AppOnLoadResultPoint;
import com.alibaba.ariver.app.api.point.app.AppPausePoint;
import com.alibaba.ariver.app.api.point.app.AppRestartPoint;
import com.alibaba.ariver.app.api.point.app.AppResumePoint;
import com.alibaba.ariver.app.api.point.engine.EngineInitFailedPoint;
import com.alibaba.ariver.app.api.point.engine.EngineInitSuccessPoint;
import com.alibaba.ariver.app.api.point.page.PagePushInterceptPoint;
import com.alibaba.ariver.app.api.ui.DialogService;
import com.alibaba.ariver.app.api.ui.darkmode.ThemeUtils;
import com.alibaba.ariver.app.api.ui.loading.SplashView;
import com.alibaba.ariver.app.api.ui.tabbar.TabBar;
import com.alibaba.ariver.app.ipc.ClientMsgReceiver;
import com.alibaba.ariver.app.ipc.IpcClientUtils;
import com.alibaba.ariver.app.ipc.IpcServerUtils;
import com.alibaba.ariver.app.proxy.RVPageFactory;
import com.alibaba.ariver.engine.api.EngineFactory;
import com.alibaba.ariver.engine.api.EngineUtils;
import com.alibaba.ariver.engine.api.RVEngine;
import com.alibaba.ariver.engine.api.bridge.model.EngineInitCallback;
import com.alibaba.ariver.engine.api.bridge.model.EngineSetupCallback;
import com.alibaba.ariver.engine.api.bridge.model.InitParams;
import com.alibaba.ariver.engine.api.bridge.model.SendToRenderCallback;
import com.alibaba.ariver.jsapi.logging.RVPerformanceTrackerImpl;
import com.alibaba.ariver.kernel.RVConstants;
import com.alibaba.ariver.kernel.RVEvents;
import com.alibaba.ariver.kernel.RVParams;
import com.alibaba.ariver.kernel.RVStartParams;
import com.alibaba.ariver.kernel.api.extension.Action;
import com.alibaba.ariver.kernel.api.extension.ExtensionManager;
import com.alibaba.ariver.kernel.api.extension.ExtensionPoint;
import com.alibaba.ariver.kernel.api.monitor.ErrId;
import com.alibaba.ariver.kernel.api.monitor.PerfId;
import com.alibaba.ariver.kernel.api.node.Scope;
import com.alibaba.ariver.kernel.api.track.EventTracker;
import com.alibaba.ariver.kernel.api.track.TrackId;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.immutable.ImmutableBundle;
import com.alibaba.ariver.kernel.common.log.AppLog;
import com.alibaba.ariver.kernel.common.log.AppLogContext;
import com.alibaba.ariver.kernel.common.log.AppLogUtils;
import com.alibaba.ariver.kernel.common.log.AppLogger;
import com.alibaba.ariver.kernel.common.log.PageSource;
import com.alibaba.ariver.kernel.common.multiinstance.MultiInstanceUtils;
import com.alibaba.ariver.kernel.common.network.NetworkUtil;
import com.alibaba.ariver.kernel.common.service.RVConfigService;
import com.alibaba.ariver.kernel.common.service.executor.ExecutorType;
import com.alibaba.ariver.kernel.common.utils.BundleUtils;
import com.alibaba.ariver.kernel.common.utils.ExecutorUtils;
import com.alibaba.ariver.kernel.common.utils.FileUtils;
import com.alibaba.ariver.kernel.common.utils.JSONUtils;
import com.alibaba.ariver.kernel.common.utils.PatternUtils;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.ariver.kernel.common.utils.RVTraceKey;
import com.alibaba.ariver.kernel.common.utils.RVTraceUtils;
import com.alibaba.ariver.kernel.common.utils.UrlUtils;
import com.alibaba.ariver.kernel.ipc.IpcMessageHandler;
import com.alibaba.ariver.resource.api.models.AppModel;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.ipd.dsp.internal.e1.b;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class AppNode extends NodeInstance implements App {
    public static final Parcelable.Creator<AppNode> CREATOR = new Parcelable.Creator<AppNode>() { // from class: com.alibaba.ariver.app.AppNode.12
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public AppNode createFromParcel(Parcel parcel) {
            return new AppNode(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public AppNode[] newArray(int i) {
            return new AppNode[i];
        }
    };
    public static final String ENGINE_INIT_FAIL_CODE = "0";
    public static final String ENGINE_INIT_FAIL_MSG = "engine init failed!";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f23811a = "AriverApp:App";
    private static final String b = "WEB_TINY";
    private static final String o = "isWaitExit";
    protected String appId;
    private String c;
    private Callable<Boolean> d;
    private boolean e;
    private boolean f;
    private boolean g;
    private Object h;
    private boolean i;
    private boolean j;
    private boolean k;
    private String l;
    private PageNode m;
    protected AppContext mAppContext;
    protected AppManager mAppManager;
    protected String mAppType;
    protected String mAppVersion;
    protected ImmutableBundle mImmutableStartParams;
    protected Bundle mSceneParams;
    protected Bundle mStartParams;
    protected long mStartToken;
    private boolean n;
    private AtomicInteger p;
    private String q;
    private RVEngine r;
    private AtomicBoolean s;
    private IpcMessageHandler t;
    private Object u;
    private boolean v;
    private final List<App.PageReadyListener> w;
    private NetworkUtil.NetworkListener x;

    /* JADX INFO: renamed from: com.alibaba.ariver.app.AppNode$13, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass13 {
        static final /* synthetic */ int[] $SwitchMap$com$alibaba$ariver$app$api$point$engine$EngineInitFailedPoint$Action;

        static {
            int[] iArr = new int[EngineInitFailedPoint.Action.values().length];
            $SwitchMap$com$alibaba$ariver$app$api$point$engine$EngineInitFailedPoint$Action = iArr;
            try {
                iArr[EngineInitFailedPoint.Action.IGNORE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$alibaba$ariver$app$api$point$engine$EngineInitFailedPoint$Action[EngineInitFailedPoint.Action.REENTER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$alibaba$ariver$app$api$point$engine$EngineInitFailedPoint$Action[EngineInitFailedPoint.Action.EXIT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$alibaba$ariver$app$api$point$engine$EngineInitFailedPoint$Action[EngineInitFailedPoint.Action.SHOW_ALERT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$alibaba$ariver$app$api$point$engine$EngineInitFailedPoint$Action[EngineInitFailedPoint.Action.SHOW_ERROR.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    /* JADX INFO: renamed from: com.alibaba.ariver.app.AppNode$6, reason: invalid class name */
    public class AnonymousClass6 implements Runnable {
        final /* synthetic */ PageNode val$preCreatePage;

        public AnonymousClass6(PageNode pageNode) {
            this.val$preCreatePage = pageNode;
        }

        @Override // java.lang.Runnable
        public void run() {
            RVTraceUtils.traceBeginSection(RVTraceKey.RV_AppNode_EngineInitSuccess);
            ((EngineInitSuccessPoint) ExtensionPoint.as(EngineInitSuccessPoint.class).node(AppNode.this).when(new Action.Complete<Void>() { // from class: com.alibaba.ariver.app.AppNode.6.1
                @Override // com.alibaba.ariver.kernel.api.extension.Action.Complete
                public void onComplete(Void r1) {
                    ExecutorUtils.runOnMain(new Runnable() { // from class: com.alibaba.ariver.app.AppNode.6.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            try {
                                RVTraceUtils.asyncTraceEnd(RVTraceKey.RV_pagePhase_postToMain);
                                RVTraceUtils.asyncTraceBegin(RVTraceKey.RV_pagePhase_pageStart);
                                RVTraceUtils.traceBeginSection(RVTraceKey.RV_AppNode_EngineInitSuccessPointOnComplete);
                                if (AppNode.this.s.get()) {
                                    RVLogger.d(AppNode.f23811a, "app has been destroyed!");
                                    return;
                                }
                                PageNode pageNodeCreatePage = AnonymousClass6.this.val$preCreatePage;
                                if (pageNodeCreatePage == null) {
                                    RVLogger.d(AppNode.f23811a, "normal createPage " + AppNode.this.l);
                                    Bundle bundleClone = BundleUtils.clone(AppNode.this.mStartParams);
                                    Bundle bundleClone2 = BundleUtils.clone(AppNode.this.mSceneParams);
                                    PagePushInterceptPoint pagePushInterceptPoint = (PagePushInterceptPoint) ExtensionPoint.as(PagePushInterceptPoint.class).node(AppNode.this).nullable().create();
                                    if (pagePushInterceptPoint != null) {
                                        AppNode appNode = AppNode.this;
                                        String strInterceptPushPage = pagePushInterceptPoint.interceptPushPage(appNode, appNode.l, bundleClone);
                                        if (!TextUtils.isEmpty(strInterceptPushPage)) {
                                            AppNode.this.l = strInterceptPushPage;
                                        }
                                    }
                                    RVPageFactory rVPageFactory = (RVPageFactory) RVProxy.get(RVPageFactory.class);
                                    AppNode appNode2 = AppNode.this;
                                    pageNodeCreatePage = rVPageFactory.createPage(appNode2, appNode2.l, bundleClone, bundleClone2);
                                    ((EventTracker) RVProxy.get(EventTracker.class)).addAttr(pageNodeCreatePage, TrackId.Attr_isPreCreatePage, "0");
                                } else {
                                    ((EventTracker) RVProxy.get(EventTracker.class)).addAttr(pageNodeCreatePage, TrackId.Attr_isPreCreatePage, "1");
                                    pageNodeCreatePage.fillStartParamsForPreCreatePage(AppNode.this.mStartParams);
                                }
                                PageSource pageSource = ((AppLogContext) pageNodeCreatePage.getData(AppLogContext.class, true)).getPageSource();
                                pageSource.sourceType = PageSource.SourceType.START_APP;
                                pageSource.sourcePageAppLogToken = BundleUtils.getString(AppNode.this.mStartParams, RVStartParams.KEY_SOURCE_PAGE_APP_LOG_TOKEN);
                                pageSource.sourceDesc = " appId: " + BundleUtils.getString(AppNode.this.mStartParams, RVStartParams.KEY_START_APP_SOURCE_ID) + " chinfo: " + BundleUtils.getString(AppNode.this.mStartParams, RVStartParams.KEY_CHINFO);
                                AppNode.this.pushChild(pageNodeCreatePage);
                                ((EventTracker) RVProxy.get(EventTracker.class)).stub(AppNode.this, TrackId.Stub_PageInit);
                                RVPerformanceTracker rVPerformanceTracker = (RVPerformanceTracker) RVProxy.get(RVPerformanceTracker.class);
                                AppNode appNode3 = AppNode.this;
                                rVPerformanceTracker.track(appNode3, appNode3.getStartUrl(), PerfId.pageInit);
                                AppNode.this.mAppContext.start(pageNodeCreatePage);
                                AppNode.this.onPageStarted(pageNodeCreatePage);
                            } finally {
                                RVTraceUtils.traceEndSection(RVTraceKey.RV_AppNode_EngineInitSuccessPointOnComplete);
                            }
                        }
                    });
                }
            }).create()).onInitSuccess();
            RVTraceUtils.traceEndSection(RVTraceKey.RV_AppNode_EngineInitSuccess);
        }
    }

    public AppNode(AppManager appManager) {
        super(appManager);
        this.d = null;
        this.e = false;
        this.f = false;
        this.g = false;
        this.h = new Object();
        this.i = false;
        this.j = false;
        this.k = true;
        this.n = false;
        this.p = new AtomicInteger(2);
        this.s = new AtomicBoolean(false);
        this.u = new Object();
        this.v = false;
        this.w = new ArrayList();
        this.mAppManager = appManager;
        this.t = createAppMsgReceiver();
    }

    private void a() {
        JSONArray jSONArray;
        RVConfigService rVConfigService = (RVConfigService) RVProxy.get(RVConfigService.class);
        if (rVConfigService == null || (jSONArray = JSONUtils.getJSONArray(rVConfigService.getConfigJSONObject("h5_jsapiandPluginsConfig"), "extensions", null)) == null) {
            return;
        }
        getExtensionManager().getExtensionRegistry().unRegister(Arrays.asList(jSONArray.toArray(new String[0])));
    }

    private synchronized void b() {
        RVTraceUtils.traceBeginSection(RVTraceKey.RV_AppNode_start);
        AppLog.Builder appId = new AppLog.Builder().setAppId(this.appId);
        Bundle bundle = this.mStartParams;
        AppLogger.log(appId.setDesc(bundle == null ? "" : bundle.toString()).setParentId(BundleUtils.getString(this.mStartParams, RVParams.START_APP_SESSION_ID)).setState(AppLog.APP_LOG_CONTAINER_START).build());
        RVLogger.d(f23811a, "start " + this.appId);
        final long jElapsedRealtime = SystemClock.elapsedRealtime();
        final Bundle startParams = getStartParams();
        ((AppLoadPoint) ExtensionPoint.as(AppLoadPoint.class).node(this).create()).loadApp(this.appId, startParams, getSceneParams(), new AppLoadPoint.LoadResultCallback() { // from class: com.alibaba.ariver.app.AppNode.4
            @Override // com.alibaba.ariver.app.api.point.app.AppLoadPoint.LoadResultCallback
            public void onResult(AppLoadResult appLoadResult) {
                AppModel appModel;
                RVTraceUtils.traceBeginSection(RVTraceKey.RV_AppNode_AppLoadPointOnResult);
                RVLogger.d(AppNode.f23811a, "loadApp onResult " + AppNode.this.appId + " result " + appLoadResult + " cost " + (SystemClock.elapsedRealtime() - jElapsedRealtime));
                ((AppOnLoadResultPoint) ExtensionPoint.as(AppOnLoadResultPoint.class).node(AppNode.this).create()).onLoadResult(AppNode.this, appLoadResult);
                String aliasPage = AppUtils.getAliasPage(startParams, AppNode.this);
                if (!TextUtils.isEmpty(aliasPage) && (appModel = (AppModel) AppNode.this.getData(AppModel.class)) != null && appModel.getAppInfoModel() != null) {
                    String strCombinePath = FileUtils.combinePath(appModel.getAppInfoModel().getVhost(), "index.html#" + aliasPage);
                    appLoadResult.mainHtmlUrl = strCombinePath;
                    startParams.putString("url", strCombinePath);
                }
                AppNode.this.a(appLoadResult, jElapsedRealtime);
                RVTraceUtils.traceEndSection(RVTraceKey.RV_AppNode_AppLoadPointOnResult);
            }
        });
        AppLogger.log(new AppLog.Builder().setAppId(this.appId).setParentId(BundleUtils.getString(this.mStartParams, RVParams.START_APP_SESSION_ID)).setState(AppLog.APP_LOG_CONTAINER_FINISH).build());
        RVTraceUtils.traceEndSection(RVTraceKey.RV_AppNode_start);
    }

    private void c() {
        if (this.p.decrementAndGet() <= 0) {
            onStart();
        }
    }

    @Override // com.alibaba.ariver.app.api.App
    public void addPageReadyListener(App.PageReadyListener pageReadyListener) {
        synchronized (this.w) {
            RVLogger.d(f23811a, "addPageReadyListener");
            Page activePage = getActivePage();
            if (activePage != null) {
                pageReadyListener.onPageReady(activePage);
            } else {
                this.w.add(pageReadyListener);
            }
        }
    }

    @Override // com.alibaba.ariver.app.api.App
    public final boolean backPressed() {
        AppContext appContext = this.mAppContext;
        if (appContext != null && appContext.getFontBar() != null && this.mAppContext.getFontBar().onBackPressed()) {
            RVLogger.d(f23811a, "backPressed: intercept by font bar");
            return true;
        }
        if (getSplashView() != null && getSplashView().backPressed()) {
            RVLogger.d(f23811a, "backPressed: just exit on splash loading");
            return true;
        }
        Page activePage = getActivePage();
        if (activePage != null) {
            return activePage.backPressed();
        }
        destroy();
        return true;
    }

    @Override // com.alibaba.ariver.app.api.App
    public void bindContext(AppContext appContext) {
        RVTraceUtils.traceBeginSection(RVTraceKey.RV_AppNode_bindContext);
        try {
            RVLogger.d(f23811a, "bindContext.....");
            this.mAppContext = appContext;
            ClientMsgReceiver.getInstance().registerAppHandler(this);
            if (isExited()) {
                RVLogger.w(f23811a, "bindContext but already exit in AppMsgReceiver!");
                RVTraceUtils.traceEndSection(RVTraceKey.RV_AppNode_bindContext);
                return;
            }
            a();
            RVTraceUtils.traceBeginSection(RVTraceKey.RV_AppNode_bindContext_trySetProxyAndStart);
            synchronized (this.u) {
                a(this.mAppType);
            }
            RVLogger.d(f23811a, "bindContext ready, try trigger onStart!");
            c();
            RVTraceUtils.traceEndSection(RVTraceKey.RV_AppNode_bindContext_trySetProxyAndStart);
            RVTraceUtils.traceEndSection(RVTraceKey.RV_AppNode_bindContext);
        } catch (Throwable th) {
            RVTraceUtils.traceEndSection(RVTraceKey.RV_AppNode_bindContext);
            throw th;
        }
    }

    public AppMsgReceiver createAppMsgReceiver() {
        return new AppMsgReceiver(this);
    }

    public final synchronized void destroy() {
        if (this.s.get()) {
            return;
        }
        if (this.j) {
            RVLogger.d(f23811a, "destroy with shadowNode!");
            IpcServerUtils.sendMsgToClient(getAppId(), getStartToken(), 4, null);
            return;
        }
        RVLogger.d(f23811a, "destroy " + this + " with stack " + Log.getStackTraceString(new Throwable("Just Print")));
        this.s.set(true);
        ((AppDestroyPoint) ExtensionPoint.as(AppDestroyPoint.class).node(this).actionOn(ExecutorType.UI).when(new Action.Complete<Void>() { // from class: com.alibaba.ariver.app.AppNode.11
            @Override // com.alibaba.ariver.kernel.api.extension.Action.Complete
            public void onComplete(Void r1) {
                AppNode.this.onDestroy();
            }
        }).create()).onAppDestroy(this);
    }

    @Override // com.alibaba.ariver.app.api.App
    public final synchronized void exit() {
        if (this.i) {
            return;
        }
        RVLogger.d(f23811a, "exitApp with stack " + Log.getStackTraceString(new Throwable("Just Print")));
        this.i = true;
        if (!this.j) {
            ((AppExitPoint) ExtensionPoint.as(AppExitPoint.class).node(this).actionOn(ExecutorType.UI).when(new Action.Complete<Void>() { // from class: com.alibaba.ariver.app.AppNode.10
                @Override // com.alibaba.ariver.kernel.api.extension.Action.Complete
                public void onComplete(Void r1) {
                    AppNode.this.onExit();
                }
            }).create()).onAppExit(this);
        } else {
            RVLogger.d(f23811a, "exit with shadowNode!");
            IpcServerUtils.sendMsgToClient(getAppId(), getStartToken(), 4, null);
        }
    }

    @Override // com.alibaba.ariver.app.api.App
    public Page getActivePage() {
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            Page pageByIndex = getPageByIndex(childCount);
            if (!pageByIndex.isUseForEmbed() && !pageByIndex.isExited()) {
                return pageByIndex;
            }
        }
        return null;
    }

    @Override // com.alibaba.ariver.app.api.App
    public int getAlivePageCount() {
        int childCount = getChildCount();
        int childCount2 = getChildCount();
        for (int i = 0; i < childCount2; i++) {
            if (getPageByIndex(i).isExited()) {
                childCount--;
            }
        }
        return childCount;
    }

    @Override // com.alibaba.ariver.app.api.App
    public AppContext getAppContext() {
        return this.mAppContext;
    }

    @Override // com.alibaba.ariver.app.api.App
    public String getAppId() {
        return this.appId;
    }

    public AppManager getAppManager() {
        return this.mAppManager;
    }

    @Override // com.alibaba.ariver.app.api.App
    public String getAppType() {
        return this.mAppType;
    }

    @Override // com.alibaba.ariver.app.api.App
    public String getAppVersion() {
        return this.mAppVersion;
    }

    @Override // com.alibaba.ariver.app.api.App
    public RVEngine getEngineProxy() {
        return this.r;
    }

    @Override // com.alibaba.ariver.app.api.App
    public ExtensionManager getExtensionManager() {
        return NodeInstance.sExtensionManager;
    }

    @Override // com.alibaba.ariver.app.api.App
    public IpcMessageHandler getMsgHandler() {
        return this.t;
    }

    public ImmutableBundle getOriginalStartParams() {
        return this.mImmutableStartParams;
    }

    @Override // com.alibaba.ariver.app.api.App
    public Page getPageByIndex(int i) {
        return (Page) getChildAt(i);
    }

    @Override // com.alibaba.ariver.app.api.App
    public Page getPageByNodeId(long j) {
        return (Page) getChild(j);
    }

    @Override // com.alibaba.ariver.app.api.App
    public Bundle getSceneParams() {
        return this.mSceneParams;
    }

    @Override // com.alibaba.ariver.kernel.api.node.Scope
    public Class<? extends Scope> getScopeType() {
        return App.class;
    }

    public SplashView getSplashView() {
        AppContext appContext = this.mAppContext;
        if (appContext != null) {
            return appContext.getSplashView();
        }
        return null;
    }

    @Override // com.alibaba.ariver.app.api.App
    public Bundle getStartParams() {
        return this.mStartParams;
    }

    @Override // com.alibaba.ariver.app.api.App
    public long getStartToken() {
        return this.mStartToken;
    }

    @Override // com.alibaba.ariver.app.api.App
    public String getStartUrl() {
        return this.l;
    }

    @Override // com.alibaba.ariver.app.api.App
    public void init(String str, Bundle bundle, Bundle bundle2) {
        setInstanceType(MultiInstanceUtils.getInstanceTypeFromParam(bundle));
        this.appId = str;
        this.mStartParams = bundle;
        this.mSceneParams = bundle2;
        this.mStartToken = BundleUtils.getLong(bundle2, RVConstants.EXTRA_START_TOKEN, 0L);
        this.mImmutableStartParams = new ImmutableBundle(this.mStartParams);
        this.mAppType = bundle2.getString("appType", b);
        ParamUtils.unifyAll(this.mStartParams, false);
        EntryInfo entryInfo = (EntryInfo) BundleUtils.getParcelable(this.mSceneParams, RVConstants.EXTRA_ENTRY_INFO);
        if (entryInfo != null) {
            setData(EntryInfo.class, entryInfo);
        }
        RVLogger.d(f23811a, "init with appType: " + this.mAppType);
        ((EventTracker) RVProxy.get(EventTracker.class)).stub(this, TrackId.Stub_AppInit);
        ((RVPerformanceTracker) RVProxy.get(RVPerformanceTracker.class)).init(RVPerformanceTrackerImpl.RV_PERFORMANCE_APP_STARTUP_TYPE, str, Long.valueOf(this.mStartToken), getStartUrl());
        this.n = true;
    }

    @Override // com.alibaba.ariver.app.api.App
    public final boolean isDestroyed() {
        return this.s.get();
    }

    @Override // com.alibaba.ariver.app.api.App
    public boolean isExited() {
        return this.i;
    }

    @Override // com.alibaba.ariver.app.api.App
    public boolean isFirstPage() {
        if (getAlivePageCount() == 1) {
            return true;
        }
        AppContext appContext = this.mAppContext;
        if (appContext == null || appContext.getTabBar() == null) {
            return false;
        }
        Page activePage = getActivePage();
        return activePage != null && this.mAppContext.getTabBar().isTabPage(activePage);
    }

    public boolean isInited() {
        return this.n;
    }

    @Override // com.alibaba.ariver.app.api.App
    public boolean isShadowNode() {
        return this.j;
    }

    @Override // com.alibaba.ariver.app.api.App
    public boolean isTinyApp() {
        return b.equalsIgnoreCase(getAppType());
    }

    @Override // com.alibaba.ariver.app.api.App
    public void onConfigurationChanged(Configuration configuration) {
        ((AppOnConfigurationChangedPoint) ExtensionPoint.as(AppOnConfigurationChangedPoint.class).node(this).create()).onConfigurationChanged(this, configuration, ThemeUtils.getColorScheme(configuration));
    }

    public void onDestroy() {
        AppContext appContext;
        RVLogger.d(f23811a, "onDestroy " + this);
        if (this.x != null && (appContext = this.mAppContext) != null) {
            NetworkUtil.removeListener(appContext.getContext(), this.x);
        }
        RVEngine rVEngine = this.r;
        if (rVEngine != null) {
            rVEngine.destroy();
            this.r = null;
        }
        AppContext appContext2 = this.mAppContext;
        if (appContext2 != null) {
            appContext2.destroy();
            this.mAppContext = null;
        }
        onFinalized();
    }

    public synchronized void onExit() {
        a(true);
        destroy();
    }

    public void onPageStarted(Page page) {
        if (this.mAppContext == null) {
            return;
        }
        RVLogger.d(f23811a, "onPageStarted");
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        synchronized (this.w) {
            Iterator<App.PageReadyListener> it = this.w.iterator();
            while (it.hasNext()) {
                it.next().onPageReady(page);
            }
            RVLogger.d(f23811a, "onPageStarted flush pageReadyListener size: " + this.w.size() + " cost: " + (SystemClock.elapsedRealtime() - jElapsedRealtime));
            this.w.clear();
        }
        this.x = new NetworkUtil.NetworkListener() { // from class: com.alibaba.ariver.app.AppNode.7
            @Override // com.alibaba.ariver.kernel.common.network.NetworkUtil.NetworkListener
            public void onNetworkChanged(NetworkUtil.Network network, NetworkUtil.Network network2) {
                AppNode.this.a(network2);
            }
        };
        NetworkUtil.addListener(this.mAppContext.getContext(), this.x);
    }

    public void onRestart(final AppRestartResult appRestartResult, Bundle bundle, Bundle bundle2) {
        RVTraceUtils.traceBeginSection(RVTraceKey.RV_AppNode_onRestart);
        RVLogger.d(f23811a, "onRestart with " + appRestartResult);
        if (getAppContext() == null) {
            return;
        }
        try {
            this.mStartParams.putString("url", appRestartResult.startUrl);
            if (bundle != null) {
                this.mStartParams.putAll(bundle);
            }
            this.mStartParams.putString(RVStartParams.KEY_ENABLE_POLYFILL_WORKER, "true");
            if (bundle2 != null) {
                this.mSceneParams.putAll(bundle2);
            }
            this.mImmutableStartParams = new ImmutableBundle(appRestartResult.startParam);
            this.f = true;
            JSONObject jSONObject = new JSONObject();
            jSONObject.putAll(BundleUtils.toJSONObject(bundle));
            if (appRestartResult.canRestart) {
                jSONObject.put("shouldNotReLaunch", (Object) Boolean.TRUE);
            }
            Boolean bool = Boolean.TRUE;
            jSONObject.put("isAliveStartup", (Object) bool);
            RVLogger.d(f23811a, "send appResume with data: " + jSONObject);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("data", (Object) jSONObject);
            jSONObject2.put("isAliveStartup", (Object) bool);
            AppUtils.sendToApp(this, RVEvents.APP_RESUME, jSONObject2, new SendToRenderCallback() { // from class: com.alibaba.ariver.app.AppNode.2
                @Override // com.alibaba.ariver.engine.api.bridge.model.SendToRenderCallback
                public void onCallBack(JSONObject jSONObject3) {
                    if (!appRestartResult.canRestart || !AppNode.this.isTinyApp()) {
                        AppNode.this.v = false;
                        return;
                    }
                    if (jSONObject3 != null) {
                        RVLogger.d(AppNode.f23811a, "resume onCallback: " + jSONObject3);
                    }
                    ExecutorUtils.runOnMain(new Runnable() { // from class: com.alibaba.ariver.app.AppNode.2.1
                        @Override // java.lang.Runnable
                        public void run() {
                            AnonymousClass2 anonymousClass2 = AnonymousClass2.this;
                            String str = appRestartResult.startUrl;
                            Bundle bundleClone = BundleUtils.clone(AppNode.this.getStartParams());
                            bundleClone.putString(RVStartParams.KEY_FROM_TYPE, RVStartParams.FROM_TYPE_PUSH_RELAUNCH);
                            Bundle bundleClone2 = BundleUtils.clone(AppNode.this.getSceneParams());
                            AnonymousClass2 anonymousClass3 = AnonymousClass2.this;
                            if (appRestartResult.closeAllWindow) {
                                AppNode.this.relaunchToUrl(str, bundleClone, bundleClone2);
                            } else {
                                AppNode.this.pushPage(str, bundleClone, bundleClone2);
                            }
                            AppNode.this.v = false;
                        }
                    });
                }
            });
            if (isTinyApp()) {
                RVTraceUtils.traceEndSection(RVTraceKey.RV_AppNode_onRestart);
            } else {
                relaunchToUrl(appRestartResult.startUrl, BundleUtils.clone(getStartParams()), bundle2);
            }
        } catch (Throwable th) {
            RVLogger.w(f23811a, "putParams error! not restart", th);
        }
    }

    public void onStart() {
        RVEngine rVEngine = this.r;
        RVTraceUtils.traceBeginSection(RVTraceKey.RV_AppNode_onStart);
        RVLogger.d(f23811a, "onStart:" + this.l);
        preProcessStartParams();
        InitParams initParams = new InitParams();
        initParams.mainResourceUrl = this.q;
        initParams.startParams = this.mStartParams;
        ((EventTracker) RVProxy.get(EventTracker.class)).stub(this, TrackId.Stub_AppStart);
        RVTraceUtils.asyncTraceEnd(RVTraceKey.RV_appPhase_waitLoadApp);
        RVTraceUtils.asyncTraceBegin(RVTraceKey.RV_pagePhase_createPage);
        ((RVPerformanceTracker) RVProxy.get(RVPerformanceTracker.class)).track(this, getStartUrl(), "appStart");
        this.mStartParams.putString(RVStartParams.KEY_ENABLE_POLYFILL_WORKER, "true");
        this.mStartParams.putBoolean(RVStartParams.KEY_DISCARD_CAN_RENDER, true);
        RVLogger.printPerformanceLog(b.F, "End create app");
        if (rVEngine == null || rVEngine.isDestroyed()) {
            RVLogger.e(f23811a, "engine is null or isDestroyed!");
            return;
        }
        final PageNode pageNodeCreatePage = null;
        boolean zEquals = TextUtils.equals(((RVConfigService) RVProxy.get(RVConfigService.class)).getConfigWithProcessCache("ta_disable_pre_create_page", null), "yes");
        PageNode pageNode = this.m;
        if (pageNode != null) {
            pageNode.setPageURI(this.l);
            Bundle startParams = this.m.getStartParams();
            if (startParams != null) {
                startParams.putString("url", this.l);
            }
            pageNodeCreatePage = this.m;
        } else if (!zEquals) {
            RVLogger.d(f23811a, "ahead createPage " + this.l);
            Bundle bundleClone = BundleUtils.clone(this.mStartParams);
            Bundle bundleClone2 = BundleUtils.clone(this.mSceneParams);
            PagePushInterceptPoint pagePushInterceptPoint = (PagePushInterceptPoint) ExtensionPoint.as(PagePushInterceptPoint.class).node(this).nullable().create();
            if (pagePushInterceptPoint != null) {
                String strInterceptPushPage = pagePushInterceptPoint.interceptPushPage(this, this.l, bundleClone);
                if (!TextUtils.isEmpty(strInterceptPushPage)) {
                    this.l = strInterceptPushPage;
                }
            }
            pageNodeCreatePage = ((RVPageFactory) RVProxy.get(RVPageFactory.class)).createPage(this, this.l, bundleClone, bundleClone2);
        }
        this.r.init(initParams, new EngineInitCallback() { // from class: com.alibaba.ariver.app.AppNode.5
            @Override // com.alibaba.ariver.engine.api.bridge.model.EngineInitCallback
            public void initResult(boolean z, String str) {
                RVTraceUtils.traceBeginSection(RVTraceKey.RV_AppNode_EngineInitResult);
                RVLogger.d(AppNode.f23811a, "EngineInitCallback initResult success: " + z);
                if (z) {
                    RVTraceUtils.asyncTraceEnd(RVTraceKey.RV_pagePhase_waitEngineInit);
                    RVTraceUtils.asyncTraceBegin(RVTraceKey.RV_pagePhase_postToMain);
                    ((EventTracker) RVProxy.get(EventTracker.class)).stub(AppNode.this, TrackId.Stub_EngineInit);
                    RVPerformanceTracker rVPerformanceTracker = (RVPerformanceTracker) RVProxy.get(RVPerformanceTracker.class);
                    AppNode appNode = AppNode.this;
                    rVPerformanceTracker.track(appNode, appNode.getStartUrl(), PerfId.engineInit);
                    AppNode.this.a(pageNodeCreatePage);
                } else {
                    AppNode.this.b(pageNodeCreatePage);
                }
                RVTraceUtils.traceEndSection(RVTraceKey.RV_AppNode_EngineInitResult);
            }
        });
        RVTraceUtils.traceEndSection(RVTraceKey.RV_AppNode_onStart);
    }

    @Override // com.alibaba.ariver.app.api.App
    public void onUserInteraction() {
        ((AppInteractionPoint) ExtensionPoint.as(AppInteractionPoint.class).node(this).create()).onAppInteraction(this);
    }

    @Override // com.alibaba.ariver.app.api.App
    public void onUserLeaveHint() {
        ((AppLeaveHintPoint) ExtensionPoint.as(AppLeaveHintPoint.class).node(this).create()).onAppLeaveHint(this);
    }

    @Override // com.alibaba.ariver.app.api.App
    public void pause() {
        AppUtils.sendToApp(this, RVEvents.APP_PAUSE, null, null);
        this.e = true;
        ((AppPausePoint) ExtensionPoint.as(AppPausePoint.class).node(this).create()).onAppPause(this);
    }

    @Override // com.alibaba.ariver.app.api.App
    public void performBack() {
        if (isFirstPage()) {
            RVLogger.d(f23811a, "performBack with firstPage, direct exit!");
            exit();
            return;
        }
        RVLogger.d(f23811a, "performBack just exit active page");
        Page activePage = getActivePage();
        if (activePage != null) {
            activePage.exit(true);
        }
    }

    @Override // com.alibaba.ariver.app.api.App
    public synchronized void popPage(@Nullable JSONObject jSONObject) {
        if (this.j) {
            RVLogger.w(f23811a, "popPage with shadowNode not work!");
            return;
        }
        if (jSONObject != null) {
            RVLogger.d(f23811a, "popPage with param " + jSONObject);
            setData(App.PopParams.class, new App.PopParams(jSONObject));
        }
        Page activePage = getActivePage();
        if (activePage != null) {
            activePage.exit(true);
        }
    }

    @Override // com.alibaba.ariver.app.api.App
    public void popTo(final int i, final boolean z, final JSONObject jSONObject) {
        if (this.j) {
            RVLogger.w(f23811a, "popTo with shadowNode not work!");
        } else {
            ExecutorUtils.runOnMain(new Runnable() { // from class: com.alibaba.ariver.app.AppNode.9
                @Override // java.lang.Runnable
                public void run() {
                    JSONObject jSONObject2 = jSONObject;
                    if (jSONObject2 != null) {
                        AppNode.this.setData(App.PopParams.class, new App.PopParams(jSONObject2));
                    }
                    int childCount = AppNode.this.getChildCount();
                    ArrayList arrayList = new ArrayList();
                    int i2 = i;
                    if (i2 < 0) {
                        int i3 = i2 + childCount;
                        RVLogger.d(AppNode.f23811a, "popTo " + i + " to minIndex " + i3);
                        for (int i4 = childCount - 1; i4 >= i3; i4--) {
                            Page pageByIndex = AppNode.this.getPageByIndex(i4);
                            if (pageByIndex != null) {
                                if (pageByIndex.isUseForEmbed() && i3 > 0) {
                                    i3--;
                                }
                                pageByIndex.putBooleanValue(AppNode.o, true);
                                arrayList.add(pageByIndex);
                            }
                        }
                    } else {
                        int i5 = childCount - 1;
                        RVLogger.d(AppNode.f23811a, "popTo " + i + " to maxIndex " + i5);
                        for (int i6 = i + 1; i6 <= i5; i6++) {
                            Page pageByIndex2 = AppNode.this.getPageByIndex(i6);
                            if (pageByIndex2 != null) {
                                pageByIndex2.putBooleanValue(AppNode.o, true);
                                arrayList.add(pageByIndex2);
                            }
                        }
                    }
                    Iterator it = arrayList.iterator();
                    while (it.hasNext()) {
                        ((Page) it.next()).exit(z);
                    }
                }
            });
        }
    }

    public void preCreateInit(String str, Bundle bundle, Bundle bundle2) {
        this.appId = str;
        this.mStartParams = bundle;
        this.mSceneParams = bundle2;
        this.mStartToken = BundleUtils.getLong(bundle2, RVConstants.EXTRA_START_TOKEN, 0L);
        this.mImmutableStartParams = new ImmutableBundle(this.mStartParams);
        this.mAppType = bundle2.getString("appType", b);
        ParamUtils.unifyAll(this.mStartParams, false);
        EntryInfo entryInfo = (EntryInfo) BundleUtils.getParcelable(this.mSceneParams, RVConstants.EXTRA_ENTRY_INFO);
        if (entryInfo != null) {
            setData(EntryInfo.class, entryInfo);
        }
    }

    @Override // com.alibaba.ariver.app.api.App
    public Page preCreatePage() {
        PageNode pageNodeCreatePage = ((RVPageFactory) RVProxy.get(RVPageFactory.class)).createPage(this, this.l, BundleUtils.clone(this.mStartParams), BundleUtils.clone(this.mSceneParams));
        this.m = pageNodeCreatePage;
        return pageNodeCreatePage;
    }

    public void preProcessStartParams() {
        AppModel appModel = (AppModel) BundleUtils.getParcelable(getSceneParams(), "appInfo");
        if (getStartParams().containsKey(RVStartParams.KEY_BACK_BEHAVIOR)) {
            return;
        }
        if (appModel != null) {
            getStartParams().putString(RVStartParams.KEY_BACK_BEHAVIOR, RVStartParams.BACK_BEHAVIOR_POP);
        } else {
            getStartParams().putString(RVStartParams.KEY_BACK_BEHAVIOR, "back");
        }
    }

    @Override // com.alibaba.ariver.app.api.App
    public synchronized boolean pushPage(String str, Bundle bundle, Bundle bundle2) {
        if (this.j) {
            RVLogger.w(f23811a, "pushPage with shadowNode not work!");
            return false;
        }
        RVLogger.d(f23811a, "pushPage " + str + " with stack: " + Log.getStackTraceString(new Throwable("Just Print")));
        Page activePage = getActivePage();
        if (activePage != null) {
            activePage.hide();
        }
        PageNode pageNodeCreatePage = ((RVPageFactory) RVProxy.get(RVPageFactory.class)).createPage(this, str, bundle, bundle2);
        pushChild(pageNodeCreatePage);
        PageSource pageSource = ((AppLogContext) pageNodeCreatePage.getData(AppLogContext.class, true)).getPageSource();
        pageSource.sourceType = PageSource.SourceType.PUSH_WINDOW;
        if (activePage != null) {
            pageSource.sourcePageAppLogToken = AppLogUtils.getParentId(activePage);
            pageSource.sourceDesc = activePage.getPageURI();
        }
        AppContext appContext = this.mAppContext;
        if (appContext == null) {
            return false;
        }
        if (appContext.getTabBar() == null || !this.mAppContext.getTabBar().isTabPage(pageNodeCreatePage)) {
            return this.mAppContext.pushPage(pageNodeCreatePage);
        }
        return this.mAppContext.getTabBar().switchTab(this.mAppContext.getTabBar().getIndexByPage(pageNodeCreatePage), 3);
    }

    @Override // com.alibaba.ariver.app.api.App
    public void relaunchToUrl(String str, Bundle bundle, Bundle bundle2) {
        if (this.j) {
            RVLogger.w(f23811a, "relaunchToUrl with shadowNode not work!");
            return;
        }
        if (isExited()) {
            RVLogger.w(f23811a, "relaunchToUrl failed because already exited!");
            return;
        }
        RVLogger.d(f23811a, "relaunchToUrl " + str + " with stack: " + Log.getStackTraceString(new Throwable("Just Print")));
        if (getActivePage() != null) {
            String pageURI = getActivePage().getPageURI();
            if (str.startsWith("#")) {
                int iIndexOf = pageURI.indexOf(35);
                if (iIndexOf != -1) {
                    str = pageURI.substring(0, iIndexOf) + str;
                }
            } else if (isTinyApp() || TextUtils.isEmpty(str) || !str.startsWith(WVNativeCallbackUtil.SEPERATER)) {
                str = UrlUtils.mergeUrl(pageURI, str);
            } else {
                AppModel appModel = (AppModel) getData(AppModel.class);
                if (appModel != null) {
                    str = FileUtils.combinePath(appModel.getAppInfoModel().getVhost(), str);
                }
            }
        }
        a(false);
        pushPage(str, bundle, bundle2);
        this.v = false;
    }

    @Override // com.alibaba.ariver.app.api.App
    public void removePage(Page page, boolean z) {
        if (this.j) {
            RVLogger.w(f23811a, "removePage with shadowNode not work!");
            return;
        }
        RVLogger.d(f23811a, "exitPage: " + page);
        if (page.isDestroyed()) {
            RVLogger.w(f23811a, "exitPage but already destroyed! " + page);
            return;
        }
        App.PopParams popParams = (App.PopParams) getData(App.PopParams.class);
        JSONObject jSONObject = popParams != null ? popParams.data : null;
        if (getChild(page.getNodeId()) != null) {
            RVLogger.w(f23811a, "exitPage but not a child! " + page);
            removeChild(page);
        }
        AppContext appContext = this.mAppContext;
        if (appContext != null) {
            appContext.exitPage(page, z);
        }
        page.destroy();
        Page activePage = getActivePage();
        if (activePage != null && !activePage.getBooleanValue(o)) {
            activePage.show(jSONObject);
        }
        if (activePage == null && z) {
            this.mAppManager.exitApp(getNodeId());
        }
    }

    @Override // com.alibaba.ariver.app.api.App
    public final void restart(final Bundle bundle, final Bundle bundle2) {
        if (this.j) {
            RVLogger.w(f23811a, "restart with shadowNode not work!");
            return;
        }
        if (this.v) {
            RVLogger.w(f23811a, "cannot restart during restarting");
            return;
        }
        ParamUtils.unify(bundle, "url", false);
        String string = BundleUtils.getString(bundle, "url");
        if (!isTinyApp()) {
            if (TextUtils.isEmpty(string)) {
                RVLogger.d(f23811a, "not restart because of url == null in h5");
                return;
            }
            ParamUtils.unify(bundle, RVParams.LONG_CAN_DESTROY, false);
            if (!BundleUtils.getBoolean(bundle, RVParams.LONG_CAN_DESTROY, true)) {
                RVLogger.d(f23811a, "not restart because of canDestroy == false in h5");
                return;
            }
        }
        this.v = true;
        this.k = true;
        this.c = BundleUtils.getString(bundle, RVParams.START_APP_SESSION_ID);
        AppLogger.log(new AppLog.Builder().setState(AppLog.APP_LOG_CONTAINER_AWAKE).setAppId(this.appId).setDesc(bundle == null ? "" : bundle.toString()).setParentId(this.c).build());
        AppRestartResult appRestartResult = new AppRestartResult();
        appRestartResult.startUrl = string;
        appRestartResult.closeAllWindow = false;
        appRestartResult.canRestart = true;
        appRestartResult.startParam = bundle;
        try {
            this.mStartParams.putBundle(RVStartParams.KEY_RESTART_START_PARAMS, bundle);
        } catch (Exception e) {
            RVLogger.w(f23811a, "putParams restart start params error!", e);
        }
        ((AppRestartPoint) ExtensionPoint.as(AppRestartPoint.class).node(this).defaultValue(appRestartResult).when(new Action.Complete<AppRestartResult>() { // from class: com.alibaba.ariver.app.AppNode.1
            @Override // com.alibaba.ariver.kernel.api.extension.Action.Complete
            public void onComplete(AppRestartResult appRestartResult2) {
                RVLogger.d(AppNode.f23811a, "restart with " + appRestartResult2);
                if (appRestartResult2 != null && !appRestartResult2.startParam.containsKey("page")) {
                    String aliasPage = AppUtils.getAliasPage(appRestartResult2.startParam, AppNode.this);
                    if (!TextUtils.isEmpty(aliasPage)) {
                        appRestartResult2.startParam.putString("page", aliasPage);
                    }
                }
                if (appRestartResult2 != null && appRestartResult2.canRestart) {
                    AppNode.this.onRestart(appRestartResult2, appRestartResult2.startParam, bundle2);
                } else {
                    AppNode.this.onRestart(appRestartResult2, bundle, bundle2);
                    AppNode.this.v = false;
                }
            }
        }).create()).onAppRestart(this, bundle, bundle2);
    }

    @Override // com.alibaba.ariver.app.api.App
    public final void restartFromServer(@Nullable Bundle bundle) {
        Bundle bundle2 = new Bundle();
        bundle2.putBundle(RVConstants.EXTRA_START_PARAMS, bundle);
        IpcClientUtils.sendMsgToServerByApp(this, 8, bundle2);
    }

    /* JADX WARN: Code duplicated, block: B:31:0x00bb  */
    @Override // com.alibaba.ariver.app.api.App
    public void resume() {
        boolean z;
        RVLogger.d(f23811a, "resume with mSendResumeInRestart: " + this.f);
        String string = this.c;
        if (string == null) {
            string = BundleUtils.getString(this.mStartParams, RVParams.START_APP_SESSION_ID);
        }
        if (this.k) {
            AppLogger.log(new AppLog.Builder().setState(AppLog.APP_LOG_APPEARANCE_START).setAppId(this.appId).setParentId(string).build());
        }
        String stringValue = getStringValue("lastCalledJsApi");
        putStringValue("lastCalledJsApi", null);
        if (!TextUtils.isEmpty(stringValue)) {
            JSONArray jSONArray = JSONUtils.getJSONArray(((RVConfigService) RVProxy.get(RVConfigService.class)).getConfigJSONObject("h5_callResumeAfterAuthConfig"), stringValue, null);
            if (jSONArray != null && !jSONArray.isEmpty()) {
                int i = 0;
                while (true) {
                    if (i < jSONArray.size()) {
                        if (PatternUtils.matchRegex(jSONArray.getString(i), this.appId)) {
                            z = false;
                            break;
                        }
                        i++;
                    }
                }
            }
            if (z && this.e && !this.f) {
                AppUtils.sendToApp(this, RVEvents.APP_RESUME, null, null);
            }
            this.f = false;
            ((AppResumePoint) ExtensionPoint.as(AppResumePoint.class).node(this).create()).onAppResume(this);
            if (this.k) {
                AppLogger.log(new AppLog.Builder().setState(AppLog.APP_LOG_APPEARANCE_FINISH).setAppId(this.appId).setParentId(string).build());
            }
            this.k = false;
        }
        RVLogger.w(f23811a, "lastCalledJsApi is null");
        z = true;
        if (z) {
            AppUtils.sendToApp(this, RVEvents.APP_RESUME, null, null);
        }
        this.f = false;
        ((AppResumePoint) ExtensionPoint.as(AppResumePoint.class).node(this).create()).onAppResume(this);
        if (this.k) {
            AppLogger.log(new AppLog.Builder().setState(AppLog.APP_LOG_APPEARANCE_FINISH).setAppId(this.appId).setParentId(string).build());
        }
        this.k = false;
    }

    @Override // com.alibaba.ariver.app.api.App
    public void setAppType(String str) {
        this.mAppType = str;
    }

    public void setEngineProxy(RVEngine rVEngine) {
        this.r = rVEngine;
    }

    @Override // com.alibaba.ariver.app.api.App
    public final void start() {
        synchronized (this.h) {
            if (this.g) {
                RVLogger.d(f23811a, "try start but mAlreadyStarted true!");
            } else {
                this.g = true;
                b();
            }
        }
    }

    public String toString() {
        String str = getClass().getSimpleName() + "@" + this.mStartToken + "@appid=" + getAppId();
        if (this.j) {
            str = str + "@Shadow";
        }
        return str + "@instance=" + getInstanceType();
    }

    @Override // com.alibaba.ariver.app.NodeInstance, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeString(this.appId);
        parcel.writeLong(this.mStartToken);
        parcel.writeString(this.mAppType);
        String str = this.mAppVersion;
        if (str == null) {
            str = "";
        }
        parcel.writeString(str);
        parcel.writeBundle(this.mStartParams);
        parcel.writeBundle(this.mSceneParams);
        String str2 = this.l;
        parcel.writeString(str2 != null ? str2 : "");
        b(parcel, EntryInfo.class);
        b(parcel, AppModel.class);
    }

    private void a(boolean z) {
        RVLogger.w(f23811a, "exitAllPages: " + z);
        int i = 0;
        if (getAppContext() != null && getAppContext().getTabBar() != null) {
            TabBar tabBar = getAppContext().getTabBar();
            int childCount = getChildCount();
            ArrayList arrayList = new ArrayList();
            while (i < childCount) {
                Page pageByIndex = getPageByIndex(i);
                ((Page.AnimStore) pageByIndex.getData(Page.AnimStore.class, true)).disableExit = true;
                if (!tabBar.isTabPage(pageByIndex)) {
                    arrayList.add(pageByIndex);
                }
                i++;
            }
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                ((Page) it.next()).exit(z);
            }
            getAppContext().getTabBar().reset();
            return;
        }
        int childCount2 = getChildCount();
        ArrayList arrayList2 = new ArrayList();
        while (i < childCount2) {
            Page pageByIndex2 = getPageByIndex(i);
            ((Page.AnimStore) pageByIndex2.getData(Page.AnimStore.class, true)).disableExit = true;
            arrayList2.add(pageByIndex2);
            i++;
        }
        Iterator it2 = arrayList2.iterator();
        while (it2.hasNext()) {
            ((Page) it2.next()).exit(z);
        }
    }

    public AppNode(Parcel parcel) {
        super(parcel);
        this.d = null;
        this.e = false;
        this.f = false;
        this.g = false;
        this.h = new Object();
        this.i = false;
        this.j = false;
        this.k = true;
        this.n = false;
        this.p = new AtomicInteger(2);
        this.s = new AtomicBoolean(false);
        this.u = new Object();
        this.v = false;
        this.w = new ArrayList();
        this.appId = parcel.readString();
        this.mStartToken = parcel.readLong();
        this.mAppType = parcel.readString();
        this.mAppVersion = parcel.readString();
        this.mStartParams = parcel.readBundle(AppNode.class.getClassLoader());
        this.mSceneParams = parcel.readBundle(AppNode.class.getClassLoader());
        this.l = parcel.readString();
        this.j = true;
        a(parcel, EntryInfo.class);
        a(parcel, AppModel.class);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(final PageNode pageNode) {
        RVLogger.d(f23811a, "onEngineInitFailed! type: " + getAppType());
        this.g = false;
        ((EventTracker) RVProxy.get(EventTracker.class)).error(this, "EngineInitFail", null);
        ((RVMonitor) RVProxy.get(RVMonitor.class)).error(getActivePage(), ErrId.RV_TYPE_APP_PREPARE_ERROR, "EngineInitFail", "", null, null);
        if (this.s.get()) {
            RVLogger.d(f23811a, "app has been destroyed!");
        } else {
            ((EngineInitFailedPoint) ExtensionPoint.as(EngineInitFailedPoint.class).node(this).defaultValue(EngineInitFailedPoint.Action.IGNORE).resolve(EngineInitFailedPoint.RESULT_RESOLVER).when(new Action.Complete<EngineInitFailedPoint.Action>() { // from class: com.alibaba.ariver.app.AppNode.8
                @Override // com.alibaba.ariver.kernel.api.extension.Action.Complete
                public void onComplete(EngineInitFailedPoint.Action action) {
                    RVLogger.d(AppNode.f23811a, "EngineInitFailedPoint got result: " + action);
                    int i = AnonymousClass13.$SwitchMap$com$alibaba$ariver$app$api$point$engine$EngineInitFailedPoint$Action[action.ordinal()];
                    if (i == 1) {
                        AppNode.this.a(pageNode);
                        return;
                    }
                    if (i == 2) {
                        AppNode.this.start();
                        return;
                    }
                    if (i == 3) {
                        RVLogger.d(AppNode.f23811a, "EngineInitCallback initResult faile and splashView is null ");
                        AppNode.this.exit();
                    } else if (i == 4) {
                        ExecutorUtils.runOnMain(new Runnable() { // from class: com.alibaba.ariver.app.AppNode.8.1
                            @Override // java.lang.Runnable
                            public void run() {
                                ((DialogService) RVProxy.get(DialogService.class)).showErrorDialog(AppNode.this, false);
                            }
                        });
                    } else if (AppNode.this.getSplashView() != null) {
                        AppNode.this.getSplashView().showError("0", AppNode.ENGINE_INIT_FAIL_MSG, null);
                    }
                }
            }).create()).onEngineInitFailed();
        }
    }

    private void a(String str) {
        if (this.r != null && TextUtils.equals(str, this.mAppType)) {
            RVLogger.d(f23811a, "trySetupEngineProxy already setup with " + str);
            return;
        }
        RVLogger.d(f23811a, "trySetupEngineProxy with appType: " + str);
        String engineType = ((EngineFactory) RVProxy.get(EngineFactory.class)).getEngineType(str);
        putStringValue(RVParams.APP_ENGINE_TYPE, engineType);
        if (this.mAppContext == null) {
            RVLogger.d(f23811a, "trySetupEngineProxy cannot init without appContext!");
            return;
        }
        final long jElapsedRealtime = SystemClock.elapsedRealtime();
        RVEngine rVEngineCreateEngine = ((EngineFactory) RVProxy.get(EngineFactory.class)).createEngine(engineType, this, this.appId);
        this.r = rVEngineCreateEngine;
        if (!rVEngineCreateEngine.isReady() && getSplashView() != null) {
            RVLogger.d(f23811a, "showLoading because engine not ready");
            getSplashView().showLoading((EntryInfo) getData(EntryInfo.class, false));
        }
        this.r.setup(this.mStartParams, this.mSceneParams, new EngineSetupCallback() { // from class: com.alibaba.ariver.app.AppNode.3
            @Override // com.alibaba.ariver.engine.api.bridge.model.EngineSetupCallback
            public void setupResult(boolean z, String str2) {
                if (!z) {
                    RVLogger.d(AppNode.f23811a, "onSetupFail, msg=" + str2);
                    return;
                }
                RVLogger.d(AppNode.f23811a, "onSetupFinish, cost=" + (SystemClock.elapsedRealtime() - jElapsedRealtime));
                ((EventTracker) RVProxy.get(EventTracker.class)).stub(AppNode.this, TrackId.Stub_EngineSetup);
            }
        });
    }

    private void b(Parcel parcel, Class<? extends Parcelable> cls) {
        Parcelable parcelable = (Parcelable) getData(cls);
        if (parcelable != null) {
            parcel.writeInt(1);
            parcel.writeParcelable(parcelable, 0);
        } else {
            parcel.writeInt(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AppLoadResult appLoadResult, long j) {
        try {
            RVTraceUtils.traceBeginSection(RVTraceKey.RV_AppNode_onLoadResult);
            synchronized (this.u) {
                if (!TextUtils.equals(appLoadResult.appType, this.mAppType)) {
                    this.r = null;
                    this.mAppType = appLoadResult.appType;
                }
                a(appLoadResult.appType);
            }
            this.q = appLoadResult.mainJsUrl;
            this.l = appLoadResult.mainHtmlUrl;
            this.mAppVersion = appLoadResult.appVersion;
            ((EventTracker) RVProxy.get(EventTracker.class)).stub(this, TrackId.Stub_PkgLoad);
            ((EventTracker) RVProxy.get(EventTracker.class)).cost(this, TrackId.Stub_PkgLoad, SystemClock.elapsedRealtime() - j);
            if (this.s.get()) {
                RVLogger.d(f23811a, "app has been destroyed!");
                RVTraceUtils.traceEndSection(RVTraceKey.RV_AppNode_onLoadResult);
            } else {
                this.d = appLoadResult.waitLoadFuture;
                RVLogger.d(f23811a, "onLoadResult ready, try trigger onStart!");
                c();
                RVTraceUtils.traceEndSection(RVTraceKey.RV_AppNode_onLoadResult);
            }
        } catch (Throwable th) {
            RVTraceUtils.traceEndSection(RVTraceKey.RV_AppNode_onLoadResult);
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(PageNode pageNode) {
        boolean z;
        AnonymousClass6 anonymousClass6 = new AnonymousClass6(pageNode);
        Callable<Boolean> callable = this.d;
        if (callable != null) {
            try {
                z = !callable.call().booleanValue();
            } catch (Exception e) {
                RVLogger.e(f23811a, "onEngineInitSuccess get waitLoadFuture exception!", e);
                z = false;
            }
        } else {
            z = false;
        }
        RVLogger.d(f23811a, "onEngineInitSuccess startPageAsync: " + z);
        if (z) {
            ExecutorUtils.execute(ExecutorType.URGENT_DISPLAY, anonymousClass6);
        } else {
            anonymousClass6.run();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(NetworkUtil.Network network) {
        Page activePage = getActivePage();
        if (activePage == null || activePage.getRender() == null) {
            return;
        }
        String strTransferNetworkType = NetworkUtil.transferNetworkType(network);
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("isConnected", (Object) Boolean.valueOf(!"none".equals(strTransferNetworkType)));
        jSONObject.put("networkType", (Object) strTransferNetworkType);
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("data", (Object) jSONObject);
        EngineUtils.sendToRender(activePage.getRender(), RVEvents.NETWORK_CHANGE, jSONObject2, null);
    }

    private <T extends Parcelable> void a(Parcel parcel, Class<T> cls) {
        Parcelable parcelable;
        if (parcel.readInt() != 1 || (parcelable = parcel.readParcelable(AppNode.class.getClassLoader())) == null) {
            return;
        }
        setData(cls, parcelable);
    }
}
