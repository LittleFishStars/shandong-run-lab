package com.alibaba.ariver.app;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.Nullable;
import com.alibaba.ariver.app.api.App;
import com.alibaba.ariver.app.api.AppContext;
import com.alibaba.ariver.app.api.EmbedType;
import com.alibaba.ariver.app.api.Page;
import com.alibaba.ariver.app.api.PageContext;
import com.alibaba.ariver.app.api.ParamUtils;
import com.alibaba.ariver.app.api.Visit;
import com.alibaba.ariver.app.api.model.AppConfigModel;
import com.alibaba.ariver.app.api.model.PluginParamModel;
import com.alibaba.ariver.app.api.monitor.RVPerformanceTracker;
import com.alibaba.ariver.app.api.point.biz.VisitUrlPoint;
import com.alibaba.ariver.app.api.point.page.PageBackPoint;
import com.alibaba.ariver.app.api.point.page.PageCreateRenderPoint;
import com.alibaba.ariver.app.api.point.page.PageDestroyPoint;
import com.alibaba.ariver.app.api.point.page.PageEnterPoint;
import com.alibaba.ariver.app.api.point.page.PageExitInterceptPoint;
import com.alibaba.ariver.app.api.point.page.PageExitPoint;
import com.alibaba.ariver.app.api.point.page.PageHidePoint;
import com.alibaba.ariver.app.api.point.page.PageInitPoint;
import com.alibaba.ariver.app.api.point.page.PagePausePoint;
import com.alibaba.ariver.app.api.point.page.PageResumePoint;
import com.alibaba.ariver.app.api.point.page.PageShowPoint;
import com.alibaba.ariver.app.ipc.IpcServerUtils;
import com.alibaba.ariver.app.proxy.RVScreenOrientationProxy;
import com.alibaba.ariver.engine.api.EngineUtils;
import com.alibaba.ariver.engine.api.RVEngine;
import com.alibaba.ariver.engine.api.Render;
import com.alibaba.ariver.engine.api.bridge.model.CreateParams;
import com.alibaba.ariver.engine.api.bridge.model.ExitCallback;
import com.alibaba.ariver.engine.api.bridge.model.GoBackCallback;
import com.alibaba.ariver.engine.api.bridge.model.LoadParams;
import com.alibaba.ariver.engine.api.bridge.model.URLVisitListener;
import com.alibaba.ariver.kernel.RVConstants;
import com.alibaba.ariver.kernel.RVEvents;
import com.alibaba.ariver.kernel.RVStartParams;
import com.alibaba.ariver.kernel.api.extension.Action;
import com.alibaba.ariver.kernel.api.extension.ExtensionManager;
import com.alibaba.ariver.kernel.api.extension.ExtensionPoint;
import com.alibaba.ariver.kernel.api.extension.resolver.ResultResolver;
import com.alibaba.ariver.kernel.api.monitor.PerfId;
import com.alibaba.ariver.kernel.api.node.DataNode;
import com.alibaba.ariver.kernel.api.node.Node;
import com.alibaba.ariver.kernel.api.node.Scope;
import com.alibaba.ariver.kernel.api.track.EventTracker;
import com.alibaba.ariver.kernel.api.track.TrackId;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.service.RVConfigService;
import com.alibaba.ariver.kernel.common.service.executor.ExecutorType;
import com.alibaba.ariver.kernel.common.utils.BundleUtils;
import com.alibaba.ariver.kernel.common.utils.ExecutorUtils;
import com.alibaba.ariver.kernel.common.utils.JSONUtils;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.ariver.kernel.common.utils.RVTraceKey;
import com.alibaba.ariver.kernel.common.utils.RVTraceUtils;
import com.alibaba.ariver.kernel.common.utils.UrlUtils;
import com.alibaba.ariver.kernel.ipc.IpcMessageConstants;
import com.alibaba.ariver.resource.api.ResourceContext;
import com.alibaba.ariver.resource.api.snapshot.RVSnapshotUtils;
import com.alibaba.ariver.resource.runtime.ResourceContextManager;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class PageNode extends NodeInstance implements Page {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static String f23815a = "AriverApp:Page";
    private String c;
    private Bundle d;
    private Bundle e;
    private Render f;
    private EmbedType g;
    private boolean h;
    private boolean i;
    private boolean j;
    private boolean k;
    private boolean l;
    private boolean m;
    protected PageContext mPageContext;
    private final List<Page.RenderReadyListener> n;
    private int o;
    private Page.ExitListener p;
    private PageNode q;
    private App r;
    private boolean s;
    private String t;
    private static AtomicInteger b = new AtomicInteger(1);
    public static final Parcelable.Creator<PageNode> CREATOR = new Parcelable.Creator<PageNode>() { // from class: com.alibaba.ariver.app.PageNode.7
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public PageNode createFromParcel(Parcel parcel) {
            return new PageNode(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public PageNode[] newArray(int i) {
            return new PageNode[i];
        }
    };

    public PageNode(App app, String str, Bundle bundle, Bundle bundle2) {
        this(app, str, bundle, bundle2, EmbedType.NO);
    }

    private void a(String str) {
        JSONObject pageLaunchParams;
        String hash = UrlUtils.getHash(str);
        if (hash == null) {
            RVLogger.w(f23815a, "not fillParam with empty hash url!");
            return;
        }
        if (hash.startsWith(PluginParamModel.PLUGIN_PAGE_PREFIX)) {
            pageLaunchParams = ((PluginParamModel) getApp().getData(PluginParamModel.class, true)).getStartupParams();
        } else {
            AppConfigModel appConfigModel = (AppConfigModel) getApp().getData(AppConfigModel.class);
            pageLaunchParams = (appConfigModel == null || appConfigModel.getPageLaunchParams() == null) ? null : appConfigModel.getPageLaunchParams();
        }
        if (pageLaunchParams == null) {
            RVLogger.w(f23815a, "not fillParam because empty paramSource!");
            return;
        }
        JSONObject jSONObject = JSONUtils.getJSONObject(pageLaunchParams, hash, null);
        if (jSONObject != null) {
            a(jSONObject);
            RVLogger.d(f23815a, "put page param for " + hash + " " + jSONObject);
            this.d.putAll(JSONUtils.toBundle(jSONObject));
        }
    }

    private void b() {
        Bundle startParams = getStartParams();
        if (startParams == null) {
            return;
        }
        if (getRender() != null && getRender().getView() != null && !ParamUtils.isShowTransAnimate(startParams)) {
            getRender().getView().setBackgroundColor(BundleUtils.getInt(startParams, "backgroundColor"));
        }
        if (getRender() == null || getRender().getView() == null || !ParamUtils.transparentBackground(startParams)) {
            return;
        }
        getRender().getView().setBackgroundColor(BundleUtils.getInt(startParams, "backgroundColor"));
    }

    @Override // com.alibaba.ariver.app.api.Page
    public void addRenderReadyListener(Page.RenderReadyListener renderReadyListener) {
        synchronized (this.n) {
            if (this.m) {
                renderReadyListener.onRenderReady();
            }
            this.n.add(renderReadyListener);
        }
    }

    @Override // com.alibaba.ariver.app.api.Page
    public boolean backPressed() {
        Render render;
        ((EventTracker) RVProxy.get(EventTracker.class)).stub(this, TrackId.Stub_BACK_PRESSED);
        PageContext pageContext = this.mPageContext;
        if ((pageContext == null || pageContext.getLoadingView() == null || !this.mPageContext.getLoadingView().backPressed()) && (render = this.f) != null) {
            render.goBack(new GoBackCallback() { // from class: com.alibaba.ariver.app.PageNode.6
                @Override // com.alibaba.ariver.engine.api.bridge.model.GoBackCallback
                public void afterProcess(final boolean z) {
                    ExecutorUtils.runOnMain(new Runnable() { // from class: com.alibaba.ariver.app.PageNode.6.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (PageNode.this.getApp() == null) {
                                RVLogger.d(PageNode.f23815a, "goBack afterProcess but app is null!");
                                return;
                            }
                            boolean booleanValue = PageNode.this.getApp().getBooleanValue(RVConstants.EXTRA_RECEIVED_PREPARE_FINISH);
                            RVLogger.d(PageNode.f23815a, "goBack afterProcess intercept: " + z + ", receivedPrepareFinish: " + booleanValue);
                            if (!z && booleanValue) {
                                AppContext appContext = PageNode.this.getApp().getAppContext();
                                if (PageNode.this.getApp().getChildCount() == 1 && appContext != null && appContext.getContext() != null && appContext.isTaskRoot() && appContext.moveToBackground()) {
                                    RVLogger.d(PageNode.f23815a, "goBack keep alive intercept");
                                    return;
                                }
                            }
                            if (z || PageNode.this.l) {
                                return;
                            }
                            PageNode.this.performBack();
                        }
                    });
                }
            });
        }
        return true;
    }

    @Override // com.alibaba.ariver.app.api.Page
    public void bindContext(PageContext pageContext) {
        RVTraceUtils.traceBeginSection(RVTraceKey.RV_PageNode_bindContext);
        this.mPageContext = pageContext;
        CreateParams createParams = new CreateParams();
        createParams.createUrl = this.c;
        createParams.startParams = getStartParams();
        createParams.useForEmbed = isUseForEmbed();
        createParams.urlVisitListener = new URLVisitListener() { // from class: com.alibaba.ariver.app.PageNode.1
            @Override // com.alibaba.ariver.engine.api.bridge.model.URLVisitListener
            public DataNode onVisitStart(String str) {
                RVLogger.d(PageNode.f23815a, "onVisitStart:" + str);
                VisitNode visitNode = new VisitNode(PageNode.this);
                visitNode.setVisitUrl(str);
                PageNode.this.pushChild(visitNode);
                ((EventTracker) RVProxy.get(EventTracker.class)).stub(visitNode, TrackId.Stub_Visit);
                ((VisitUrlPoint) ExtensionPoint.as(VisitUrlPoint.class).node(PageNode.this).create()).onVisit(visitNode);
                return visitNode;
            }
        };
        createParams.containerHeight = AppUtils.getContainerHeight(pageContext);
        createParams.containerWidth = AppUtils.getContainerWidth(pageContext);
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        RVEngine engineProxy = getApp().getEngineProxy();
        if (this.f == null) {
            RVTraceUtils.traceBeginSection(RVTraceKey.RV_PageNode_createRender);
            this.f = a(pageContext, createParams, engineProxy);
            RVTraceUtils.traceEndSection(RVTraceKey.RV_PageNode_createRender);
        }
        RVTraceUtils.traceBeginSection(RVTraceKey.RV_PageNode_initRender);
        initRender(engineProxy);
        a();
        RVTraceUtils.traceEndSection(RVTraceKey.RV_PageNode_initRender);
        this.t = ((RVScreenOrientationProxy) RVProxy.get(RVScreenOrientationProxy.class)).getScreenOrientation(pageContext.getActivity());
        ((EventTracker) RVProxy.get(EventTracker.class)).cost(this, TrackId.Cost_NXView_Create, SystemClock.elapsedRealtime() - jElapsedRealtime);
        RVTraceUtils.traceEndSection(RVTraceKey.RV_PageNode_bindContext);
    }

    @Override // com.alibaba.ariver.app.api.Page
    public final void destroy() {
        if (this.h) {
            return;
        }
        if (this.j) {
            RVLogger.w(f23815a, "destroy with shadowNode!");
            Bundle bundle = new Bundle();
            bundle.putLong(IpcMessageConstants.EXTRA_PAGE_NODE_ID, getNodeId());
            IpcServerUtils.sendMsgToClient(getApp().getAppId(), getApp().getStartToken(), 10, bundle);
            return;
        }
        this.h = true;
        if (this.f != null && getApp().getEngineProxy() != null) {
            getApp().getEngineProxy().getEngineRouter().unRegisterRender(this.f.getRenderId());
        }
        ((PageDestroyPoint) ExtensionPoint.as(PageDestroyPoint.class).node(this).create()).onPageDestroy(this);
        EngineUtils.sendToRender(getRender(), RVEvents.BEFORE_UNLOAD, null, null);
        EngineUtils.sendToRender(getRender(), RVEvents.BEFORE_DESTROY, null, null);
        Render render = this.f;
        if (render != null) {
            render.destroy();
        }
        PageContext pageContext = this.mPageContext;
        if (pageContext != null) {
            pageContext.destroy();
        }
        onDestroy();
        onFinalized();
    }

    @Override // com.alibaba.ariver.app.api.Page
    public final void enter() {
        final long jElapsedRealtime = SystemClock.elapsedRealtime();
        ((EventTracker) RVProxy.get(EventTracker.class)).stub(this, TrackId.Stub_PageEnter);
        ((RVPerformanceTracker) RVProxy.get(RVPerformanceTracker.class)).track(getApp(), this.c, "pageStart");
        ((PageEnterPoint) ExtensionPoint.as(PageEnterPoint.class).node(this).actionOn(ExecutorType.UI).when(new Action.Complete<Void>() { // from class: com.alibaba.ariver.app.PageNode.2
            @Override // com.alibaba.ariver.kernel.api.extension.Action.Complete
            public void onComplete(Void r6) {
                RVLogger.d(PageNode.f23815a, "page Enter schedule: " + (SystemClock.elapsedRealtime() - jElapsedRealtime));
                PageNode.this.onEnter();
            }
        }).create()).onPageEnter(this);
        RVTraceUtils.traceBeginSection(RVTraceKey.RV_PageNode_applyStartParam);
        b();
        RVTraceUtils.traceEndSection(RVTraceKey.RV_PageNode_applyStartParam);
    }

    @Override // com.alibaba.ariver.app.api.Page
    public final synchronized void exit(final boolean z) {
        if (this.i) {
            RVLogger.w(f23815a, "already exited!");
            return;
        }
        if (!this.j) {
            ((PageExitInterceptPoint) ExtensionPoint.as(PageExitInterceptPoint.class).node(this).resolve(ResultResolver.POSITIVE_RESOLVER).when(new Action.Complete<Boolean>() { // from class: com.alibaba.ariver.app.PageNode.3
                @Override // com.alibaba.ariver.kernel.api.extension.Action.Complete
                public void onComplete(Boolean bool) {
                    if (bool == null || !bool.booleanValue()) {
                        PageNode.this.a(z);
                    } else {
                        RVLogger.d(PageNode.f23815a, "PageExit intercept by extension point.");
                    }
                }
            }).create()).interceptPageExit(this);
            return;
        }
        RVLogger.w(f23815a, "exit with shadowNode!");
        Bundle bundle = new Bundle();
        bundle.putLong(IpcMessageConstants.EXTRA_PAGE_NODE_ID, getNodeId());
        IpcServerUtils.sendMsgToClient(getApp().getAppId(), getApp().getStartToken(), 10, bundle);
    }

    public void fillStartParamsForPreCreatePage(Bundle bundle) {
        if ("no".equalsIgnoreCase(((RVConfigService) RVProxy.get(RVConfigService.class)).getConfigWithProcessCache("h5_fillParamsForPreCreatePage", "yes"))) {
            RVLogger.d(f23815a, "fillStartParamsForPreCreatePage disable");
            return;
        }
        try {
            RVLogger.d(f23815a, "fillStartParamsForPreCreatePage");
            Bundle bundleClone = BundleUtils.clone(bundle);
            bundleClone.putAll(this.d);
            this.d = bundleClone;
        } catch (Exception e) {
            RVLogger.e(f23815a, "fillStartParamsForPreCreatePage error", e);
        }
    }

    public int generatePageId() {
        return b.addAndGet(1);
    }

    @Override // com.alibaba.ariver.app.api.Page
    public App getApp() {
        return (App) getParentNode();
    }

    public PageNode getEmbedPage() {
        return this.q;
    }

    @Override // com.alibaba.ariver.app.api.Page
    public EmbedType getEmbedType() {
        return this.g;
    }

    @Override // com.alibaba.ariver.app.api.Page
    public ExtensionManager getExtensionManager() {
        return NodeInstance.sExtensionManager;
    }

    @Override // com.alibaba.ariver.app.api.Page
    public String getOriginalURI() {
        return this.c;
    }

    @Override // com.alibaba.ariver.app.api.Page
    @Nullable
    public PageContext getPageContext() {
        return this.mPageContext;
    }

    @Override // com.alibaba.ariver.app.api.Page
    public int getPageId() {
        return this.o;
    }

    @Override // com.alibaba.ariver.app.api.Page
    public String getPageType() {
        App app = getApp();
        if (app != null) {
            return app.getAppType();
        }
        return null;
    }

    @Override // com.alibaba.ariver.app.api.Page
    public String getPageURI() {
        Visit visit = (Visit) peekChild();
        return visit != null ? visit.getVisitUrl() : this.c;
    }

    @Override // com.alibaba.ariver.app.NodeInstance, com.alibaba.ariver.kernel.api.node.Node
    public Node getParentNode() {
        Node parentNode = super.getParentNode();
        if (parentNode != null) {
            return parentNode;
        }
        if (this.s) {
            return this.r;
        }
        return null;
    }

    @Override // com.alibaba.ariver.app.api.Page
    public Render getRender() {
        return this.f;
    }

    @Override // com.alibaba.ariver.app.api.Page
    public Bundle getSceneParams() {
        return this.e;
    }

    @Override // com.alibaba.ariver.kernel.api.node.Scope
    public Class<? extends Scope> getScopeType() {
        return Page.class;
    }

    @Override // com.alibaba.ariver.app.api.Page
    public Bundle getStartParams() {
        return this.d;
    }

    @Override // com.alibaba.ariver.app.api.Page
    public final void hide() {
        RVLogger.d(f23815a, "sendToView page event pagePause");
        EngineUtils.sendToRender(getRender(), RVEvents.PAGE_PAUSE, null, null);
        ((PageHidePoint) ExtensionPoint.as(PageHidePoint.class).node(this).create()).onPageHide(this);
        onHide();
    }

    public void init(String str, Bundle bundle, Bundle bundle2) {
        ResourceContext resourceContext;
        RVLogger.d(f23815a, "init Page with url " + str + ", startParams: " + bundle);
        this.c = str;
        this.d = bundle;
        this.e = bundle2;
        a(str);
        try {
            if (RVSnapshotUtils.isHomePage(this.r, str) && RVSnapshotUtils.isSnapshotEnabled(this.r) && (resourceContext = ResourceContextManager.getInstance().get(this.r.getAppId())) != null) {
                String snapshotTitleBarParams = resourceContext.getSnapshotTitleBarParams();
                if (!TextUtils.isEmpty(snapshotTitleBarParams)) {
                    JSONObject object = JSON.parseObject(snapshotTitleBarParams);
                    for (String str2 : object.keySet()) {
                        this.d.putString(str2, object.getString(str2));
                    }
                    RVLogger.d(f23815a, "SnapshotProvider set snapshot titleBar success: " + snapshotTitleBarParams);
                }
            }
        } catch (Throwable th) {
            RVLogger.e(f23815a, "SnapshotProvider set snapshot titleBar params error: " + th);
        }
        this.d.putString("url", str);
        this.o = generatePageId();
        ParamUtils.unifyAll(this.d, true);
        ((PageInitPoint) ExtensionPoint.as(PageInitPoint.class).node(this).create()).onPageInit(this.c, this.d, this.e);
    }

    public void initRender(RVEngine rVEngine) {
        if (!isUseForEmbed()) {
            this.f.getEngine().getEngineRouter().registerRender(this.f.getRenderId(), this.f);
        }
        this.f.init();
    }

    @Override // com.alibaba.ariver.app.api.Page
    public boolean isDestroyed() {
        return this.h;
    }

    @Override // com.alibaba.ariver.app.api.Page
    public boolean isExited() {
        return this.i;
    }

    @Override // com.alibaba.ariver.app.api.Page
    public boolean isPageLoaded() {
        return this.k;
    }

    @Override // com.alibaba.ariver.app.api.Page
    public boolean isRenderReady() {
        boolean z;
        synchronized (this.n) {
            z = this.m;
        }
        return z;
    }

    @Override // com.alibaba.ariver.app.api.Page
    public boolean isShadowNode() {
        return this.j;
    }

    @Override // com.alibaba.ariver.app.api.Page
    public boolean isUseForEmbed() {
        EmbedType embedType = this.g;
        return embedType == EmbedType.FULL || embedType == EmbedType.MINI;
    }

    public void onDestroy() {
    }

    public void onEnter() {
        RVTraceUtils.traceBeginSection(RVTraceKey.RV_PageNode_onEnter);
        RVLogger.d(f23815a, "onEnter " + this.c);
        LoadParams loadParams = new LoadParams();
        loadParams.url = this.c;
        loadParams.isFirstLoad = true;
        ((EventTracker) RVProxy.get(EventTracker.class)).stub(this, TrackId.Stub_LoadUrl);
        ((RVPerformanceTracker) RVProxy.get(RVPerformanceTracker.class)).track(getApp(), this.c, PerfId.loadUrl);
        ((EventTracker) RVProxy.get(EventTracker.class)).stub(this, TrackId.Stub_FirstRequest);
        if (RVStartParams.START_SCENE_CREATE_PAGE.equals(BundleUtils.getString(getStartParams(), RVStartParams.KEY_START_SCENE)) && this.f.hasTriggeredLoad()) {
            RVTraceUtils.traceEndSection(RVTraceKey.RV_PageNode_onEnter);
        } else {
            this.f.load(loadParams);
            RVTraceUtils.traceEndSection(RVTraceKey.RV_PageNode_onEnter);
        }
    }

    @Override // com.alibaba.ariver.app.NodeInstance, com.alibaba.ariver.kernel.api.node.Node
    public synchronized void onFinalized() {
        int childCount = getChildCount();
        if (childCount > 0) {
            for (int i = 0; i < childCount; i++) {
                getChildAt(i).onFinalized();
            }
        }
        super.onFinalized();
    }

    public void onHide() {
    }

    public void onPause() {
        RVLogger.d(f23815a, "onPause");
        this.f.onPause();
    }

    public void onResume() {
        this.f.onResume();
    }

    public void onShow() {
    }

    @Override // com.alibaba.ariver.app.api.Page
    public final void pause() {
        ((PagePausePoint) ExtensionPoint.as(PagePausePoint.class).node(this).create()).onPagePause(this);
        EngineUtils.sendToRender(getRender(), "pause", null, null);
        onPause();
    }

    public synchronized void performBack() {
        this.l = true;
        ((PageBackPoint) ExtensionPoint.as(PageBackPoint.class).node(this).create()).onBackPerformed(this);
        getApp().performBack();
    }

    @Override // com.alibaba.ariver.app.api.Page
    public final void resume() {
        JSONObject jSONObject;
        RVTraceUtils.traceBeginSection(RVTraceKey.RV_PageNode_resume);
        App.PopParams popParams = (App.PopParams) getApp().getData(App.PopParams.class);
        if (popParams != null) {
            jSONObject = new JSONObject();
            jSONObject.put("data", (Object) popParams.data);
            getApp().setData(App.PopParams.class, null);
        } else {
            jSONObject = null;
        }
        ((PageResumePoint) ExtensionPoint.as(PageResumePoint.class).node(this).create()).onPageResume(this);
        EngineUtils.sendToRender(getRender(), "resume", jSONObject, null);
        onResume();
        RVTraceUtils.traceEndSection(RVTraceKey.RV_PageNode_resume);
    }

    public void setEmbedPage(PageNode pageNode) {
        this.q = pageNode;
    }

    @Override // com.alibaba.ariver.app.api.Page
    public void setExitListener(Page.ExitListener exitListener) {
        this.p = exitListener;
    }

    public void setPageId(int i) {
        this.o = i;
    }

    @Override // com.alibaba.ariver.app.api.Page
    public void setPageLoaded() {
        this.k = true;
    }

    public void setPageURI(String str) {
        this.c = str;
    }

    public void setRender(Render render) {
        this.f = render;
    }

    @Override // com.alibaba.ariver.app.api.Page
    public final void show(JSONObject jSONObject) {
        JSONObject jSONObject2;
        if (jSONObject != null) {
            jSONObject2 = new JSONObject();
            jSONObject2.put("data", (Object) jSONObject);
        } else {
            jSONObject2 = null;
        }
        if (!isUseForEmbed()) {
            RVLogger.d(f23815a, "sendToView page event pageResume");
            EngineUtils.sendToRender(getRender(), RVEvents.PAGE_RESUME, jSONObject2, null);
        }
        ((PageShowPoint) ExtensionPoint.as(PageShowPoint.class).node(this).create()).onPageShow(this, null);
        onShow();
    }

    public String toString() {
        String str = getClass().getSimpleName() + "@" + hashCode() + "@uri=" + getPageURI();
        if (this.j) {
            str = str + "@Shadow";
        }
        return str + "@instance=" + getInstanceType();
    }

    @Override // com.alibaba.ariver.app.NodeInstance, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeString(this.c);
        parcel.writeBundle(this.d);
        parcel.writeBundle(this.e);
        parcel.writeInt(this.g.getTypeValue());
    }

    @Deprecated
    public PageNode(App app, String str, Bundle bundle, Bundle bundle2, boolean z) {
        this(app, str, bundle, bundle2, z ? EmbedType.FULL : EmbedType.NO);
    }

    public PageNode(App app, String str, Bundle bundle, Bundle bundle2, EmbedType embedType) {
        super(app);
        this.g = EmbedType.NO;
        this.h = false;
        this.i = false;
        this.j = false;
        this.k = false;
        this.l = false;
        this.n = new ArrayList();
        this.s = true;
        this.r = app;
        RVTraceUtils.traceBeginSection(RVTraceKey.RV_PageNode_constructor);
        ((EventTracker) RVProxy.get(EventTracker.class)).stub(this, TrackId.Stub_PageCreate);
        this.g = embedType;
        this.s = ((RVConfigService) RVProxy.get(RVConfigService.class)).getConfigBoolean("ariver_useParentAppWhenParentNull", true);
        init(str, bundle, bundle2);
        ((EventTracker) RVProxy.get(EventTracker.class)).stub(this, TrackId.Stub_PageCreated);
        RVTraceUtils.asyncTraceEnd(RVTraceKey.RV_pagePhase_createPage);
        RVTraceUtils.asyncTraceBegin(RVTraceKey.RV_pagePhase_waitEngineInit);
        RVTraceUtils.traceEndSection(RVTraceKey.RV_PageNode_constructor);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(final boolean z) {
        RVLogger.d(f23815a, "PageNode " + this + " doExit!");
        PageContext pageContext = this.mPageContext;
        if (pageContext != null && pageContext.getActivity() != null) {
            if (!TextUtils.equals(this.t, ((RVScreenOrientationProxy) RVProxy.get(RVScreenOrientationProxy.class)).getScreenOrientation(this.mPageContext.getActivity()))) {
                ((RVScreenOrientationProxy) RVProxy.get(RVScreenOrientationProxy.class)).setScreenOrientation(this.mPageContext.getActivity(), this.t, this);
            }
        }
        ((PageExitPoint) ExtensionPoint.as(PageExitPoint.class).node(this).actionOn(ExecutorType.UI).when(new Action.Complete<Void>() { // from class: com.alibaba.ariver.app.PageNode.5
            @Override // com.alibaba.ariver.kernel.api.extension.Action.Complete
            public void onComplete(Void r3) {
                RVLogger.d(PageNode.f23815a, "PageNode " + PageNode.this + " doExit onComplete");
                if (PageNode.this.isUseForEmbed()) {
                    PageNode.this.destroy();
                    PageNode.this.onFinalized();
                    return;
                }
                if (PageNode.this.getApp() != null) {
                    PageNode.this.getApp().removePage(PageNode.this, z);
                }
                if (PageNode.this.p != null) {
                    PageNode.this.p.onExit();
                }
            }
        }).create()).onPageExit(this);
    }

    private void a(JSONObject jSONObject) {
        if (getApp() == null || !getApp().isTinyApp() || jSONObject == null || !jSONObject.containsKey("usePresetPopmenu")) {
            return;
        }
        jSONObject.remove("usePresetPopmenu");
    }

    private Render a(PageContext pageContext, CreateParams createParams, RVEngine rVEngine) {
        Render renderCreateRender;
        PageCreateRenderPoint pageCreateRenderPoint = (PageCreateRenderPoint) ExtensionPoint.as(PageCreateRenderPoint.class).node(this).nullable().create();
        if (pageCreateRenderPoint != null && (renderCreateRender = pageCreateRenderPoint.createRender(pageContext.getActivity(), this, createParams)) != null) {
            RVLogger.d(f23815a, "createRender hacked by PageCreateRenderPoint!");
            return renderCreateRender;
        }
        return rVEngine.createRender(pageContext.getActivity(), this, createParams);
    }

    public PageNode(Parcel parcel) {
        super(parcel);
        this.g = EmbedType.NO;
        this.h = false;
        this.i = false;
        this.j = false;
        this.k = false;
        this.l = false;
        this.n = new ArrayList();
        this.s = true;
        this.c = parcel.readString();
        this.d = parcel.readBundle(Page.class.getClassLoader());
        this.e = parcel.readBundle(Page.class.getClassLoader());
        this.g = EmbedType.parse(parcel.readInt());
        this.j = true;
    }

    private void a() {
        synchronized (this.n) {
            this.m = true;
            Iterator<Page.RenderReadyListener> it = this.n.iterator();
            while (it.hasNext()) {
                it.next().onRenderReady();
            }
            this.n.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final boolean z) {
        RVLogger.d(f23815a, "exit " + toString() + " by stack " + Log.getStackTraceString(new Throwable("Just Print")));
        this.i = true;
        if ("yes".equalsIgnoreCase(((RVConfigService) RVProxy.get(RVConfigService.class)).getConfigWithProcessCache("h5_appContextPerExitPage", "no"))) {
            RVLogger.d(f23815a, "run Exit per exit page.");
            AppContext appContext = getApp().getAppContext();
            if (appContext != null) {
                appContext.exitPage(this, z);
            }
        }
        Render render = this.f;
        if (render != null) {
            render.runExit(new ExitCallback() { // from class: com.alibaba.ariver.app.PageNode.4
                @Override // com.alibaba.ariver.engine.api.bridge.model.ExitCallback
                public void afterProcess(boolean z2) {
                    PageNode.this.b(z);
                }
            });
        } else {
            b(z);
        }
    }
}
