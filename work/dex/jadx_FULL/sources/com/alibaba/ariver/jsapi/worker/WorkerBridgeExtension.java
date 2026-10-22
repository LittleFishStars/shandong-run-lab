package com.alibaba.ariver.jsapi.worker;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import com.alibaba.ariver.app.api.App;
import com.alibaba.ariver.app.api.Page;
import com.alibaba.ariver.app.api.model.AppConfigModel;
import com.alibaba.ariver.app.api.monitor.RVMonitor;
import com.alibaba.ariver.engine.api.RVEngine;
import com.alibaba.ariver.engine.api.Worker;
import com.alibaba.ariver.engine.api.bridge.EngineRouter;
import com.alibaba.ariver.engine.api.bridge.extension.BridgeCallback;
import com.alibaba.ariver.engine.api.bridge.extension.BridgeResponse;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingApiContext;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingCallback;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingNode;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingParam;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingRequest;
import com.alibaba.ariver.engine.api.bridge.model.ApiContext;
import com.alibaba.ariver.engine.api.extensions.CreateWorkerPoint;
import com.alibaba.ariver.engine.api.extensions.WorkerCreateConfigPoint;
import com.alibaba.ariver.engine.api.model.WorkerStore;
import com.alibaba.ariver.engine.api.point.WorkerExceptionPoint;
import com.alibaba.ariver.kernel.RVConstants;
import com.alibaba.ariver.kernel.api.annotation.ActionFilter;
import com.alibaba.ariver.kernel.api.annotation.AutoCallback;
import com.alibaba.ariver.kernel.api.annotation.ThreadType;
import com.alibaba.ariver.kernel.api.extension.ExtensionPoint;
import com.alibaba.ariver.kernel.api.extension.bridge.BridgeExtension;
import com.alibaba.ariver.kernel.api.security.Permission;
import com.alibaba.ariver.kernel.api.track.Event;
import com.alibaba.ariver.kernel.api.track.EventAttr;
import com.alibaba.ariver.kernel.api.track.EventTracker;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.service.RVEnvironmentService;
import com.alibaba.ariver.kernel.common.service.executor.ExecutorType;
import com.alibaba.ariver.kernel.common.utils.ExecutorUtils;
import com.alibaba.ariver.kernel.common.utils.JSONUtils;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.ariver.resource.api.PluginDownloadCallback;
import com.alibaba.ariver.resource.api.PluginInstallCallback;
import com.alibaba.ariver.resource.api.ResourceContext;
import com.alibaba.ariver.resource.api.content.ResourcePackage;
import com.alibaba.ariver.resource.api.extension.PackageQueryPoint;
import com.alibaba.ariver.resource.api.models.AppModel;
import com.alibaba.ariver.resource.api.models.DynamicPluginInfo;
import com.alibaba.ariver.resource.api.models.PluginModel;
import com.alibaba.ariver.resource.api.proxy.RVPluginResourceManager;
import com.alibaba.ariver.resource.api.storage.PluginStore;
import com.alibaba.ariver.resource.runtime.ResourceContextManager;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.triver.kit.api.common.TriverAppMonitorConstants;
import com.alibaba.triver.trace.c;
import com.alipay.sdk.m.y.k;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
@Keep
public class WorkerBridgeExtension implements BridgeExtension {
    private static final String LOAD_PLUGIN_KEY_URL = "url";
    private static final String MONITOR_REGISTER_WORK_SUCCESS = "register_work_success";
    private static final String TAG = "AriverEngine:WorkerBridgeExtension";
    private Map<String, Future<BridgeResponse>> mLoadedPlugins = new ConcurrentHashMap();

    /* JADX INFO: renamed from: com.alibaba.ariver.jsapi.worker.WorkerBridgeExtension$2, reason: invalid class name */
    public class AnonymousClass2 implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Worker f24185a;
        final /* synthetic */ JSONObject b;

        public AnonymousClass2(Worker worker, JSONObject jSONObject) {
            this.f24185a = worker;
            this.b = jSONObject;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f24185a.isWorkerReady()) {
                this.f24185a.sendJsonToWorker(this.b, null);
            } else {
                this.f24185a.registerWorkerReadyListener(new Worker.WorkerReadyListener() { // from class: com.alibaba.ariver.jsapi.worker.WorkerBridgeExtension.2.1
                    @Override // com.alibaba.ariver.engine.api.Worker.WorkerReadyListener
                    public void onWorkerReady() {
                        AnonymousClass2.this.f24185a.getWorkerHandler().post(new Runnable() { // from class: com.alibaba.ariver.jsapi.worker.WorkerBridgeExtension.2.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                AnonymousClass2 anonymousClass2 = AnonymousClass2.this;
                                anonymousClass2.f24185a.sendJsonToWorker(anonymousClass2.b, null);
                            }
                        });
                    }
                });
            }
        }
    }

    public class a implements Future<BridgeResponse> {
        private App b;
        private ApiContext c;
        private Worker d;
        private String e;
        private String f;
        private BridgeResponse g = null;
        private PluginModel h = null;

        public a(App app, Worker worker, String str, String str2, ApiContext apiContext) {
            this.b = app;
            this.d = worker;
            this.e = str;
            this.f = str2;
            this.c = apiContext;
        }

        @Override // java.util.concurrent.Future
        public boolean cancel(boolean z) {
            return false;
        }

        @Override // java.util.concurrent.Future
        public boolean isCancelled() {
            return false;
        }

        @Override // java.util.concurrent.Future
        public boolean isDone() {
            return this.g != null;
        }

        @Override // java.util.concurrent.Future
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public synchronized BridgeResponse get() {
            BridgeResponse bridgeResponse = this.g;
            if (bridgeResponse != null) {
                return bridgeResponse;
            }
            AppModel appModel = (AppModel) this.b.getData(AppModel.class, false);
            if (appModel != null && appModel.getAppInfoModel() != null && appModel.getAppInfoModel().getPlugins() != null) {
                Iterator<PluginModel> it = appModel.getAppInfoModel().getPlugins().iterator();
                while (it.hasNext()) {
                    if (TextUtils.equals(it.next().getAppId(), this.e)) {
                        RVLogger.d(WorkerBridgeExtension.TAG, "loadPlugin hit static pluginList!");
                        BridgeResponse.NamedValue namedValueNewValue = BridgeResponse.newValue("url", "__plugins__/" + this.e + "/index.js");
                        this.g = namedValueNewValue;
                        return namedValueNewValue;
                    }
                }
            }
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            final RVPluginResourceManager rVPluginResourceManager = (RVPluginResourceManager) RVProxy.get(RVPluginResourceManager.class);
            this.h = new com.alibaba.ariver.jsapi.worker.a().a(this.b.getAppId(), this.e, this.f, this.b, this.c);
            RVLogger.d(WorkerBridgeExtension.TAG, "loadPlugin cost: " + (SystemClock.elapsedRealtime() - jElapsedRealtime));
            PluginModel pluginModel = this.h;
            if (pluginModel == null) {
                this.g = BridgeResponse.newError(5, "cannot get pluginModel!");
                ((RVMonitor) RVProxy.get(RVMonitor.class)).errorLog(c.K, "动态插件加载失败：pluginId=" + this.e + "@" + this.f, "AppInfo", this.b.getAppId(), null, null);
                return this.g;
            }
            pluginModel.setRequireVersion(this.f);
            final CountDownLatch countDownLatch = new CountDownLatch(1);
            if (!rVPluginResourceManager.isAvailable(Collections.singletonList(this.h))) {
                RVLogger.d(WorkerBridgeExtension.TAG, "loadPlugin not installed, just enter download install process!");
                rVPluginResourceManager.downloadPlugins(Collections.singletonList(this.h), new PluginDownloadCallback() { // from class: com.alibaba.ariver.jsapi.worker.WorkerBridgeExtension.a.1
                    @Override // com.alibaba.ariver.resource.api.PluginDownloadCallback
                    public void onFailed(int i, String str) {
                        a.this.g = BridgeResponse.newError(9, "download error: " + str);
                        countDownLatch.countDown();
                    }

                    @Override // com.alibaba.ariver.resource.api.PluginDownloadCallback
                    public void onSingleFailed(PluginModel pluginModel2, int i, String str) {
                    }

                    @Override // com.alibaba.ariver.resource.api.PluginDownloadCallback
                    public void onSuccess() {
                        rVPluginResourceManager.installPlugins(Collections.singletonList(a.this.h), new PluginInstallCallback() { // from class: com.alibaba.ariver.jsapi.worker.WorkerBridgeExtension.a.1.1
                            @Override // com.alibaba.ariver.resource.api.PluginInstallCallback
                            public void onFailed(int i, String str) {
                                a.this.g = BridgeResponse.newError(10, "install error: " + str);
                                countDownLatch.countDown();
                            }

                            @Override // com.alibaba.ariver.resource.api.PluginInstallCallback
                            public void onSingleFailed(PluginModel pluginModel2, int i, String str) {
                            }

                            @Override // com.alibaba.ariver.resource.api.PluginInstallCallback
                            public void onSuccess(List<Pair<PluginModel, String>> list) {
                                a aVar = a.this;
                                aVar.g = aVar.a(aVar.h);
                                countDownLatch.countDown();
                            }
                        });
                    }
                });
                countDownLatch.await();
                return this.g;
            }
            RVLogger.d(WorkerBridgeExtension.TAG, "loadPlugin installed, just enter load plugin!");
            BridgeResponse bridgeResponseA = a(this.h);
            this.g = bridgeResponseA;
            return bridgeResponseA;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public BridgeResponse a(PluginModel pluginModel) {
            BridgeResponse bridgeResponseNewValue;
            ResourceContext resourceContext = ResourceContextManager.getInstance().get(this.b.getAppId());
            ResourcePackage resourcePackageCreatePluginPackage = ((PackageQueryPoint) ExtensionPoint.as(PackageQueryPoint.class).node(this.b).create()).createPluginPackage(pluginModel, resourceContext);
            if (resourcePackageCreatePluginPackage == null) {
                bridgeResponseNewValue = BridgeResponse.newError(5, "cannot create PluginPackage!");
            } else {
                resourcePackageCreatePluginPackage.setup(true);
                resourceContext.addPackage(resourcePackageCreatePluginPackage);
                resourcePackageCreatePluginPackage.waitForSetup();
                this.d.loadPlugin(this.e);
                bridgeResponseNewValue = BridgeResponse.newValue("url", "__plugins__/" + this.e + "/index.js");
                ((RVMonitor) RVProxy.get(RVMonitor.class)).flowLog(c.J, "动态插件加载成功: " + pluginModel.toString(), "AppInfo", this.b.getAppId(), null, null);
                WorkerBridgeExtension.this.savePluginInfoToApp(pluginModel, this.b);
            }
            ((PluginStore) this.b.getData(PluginStore.class, true)).putDynamicPluginModel(pluginModel);
            return bridgeResponseNewValue;
        }

        @Override // java.util.concurrent.Future
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public BridgeResponse get(long j, @NonNull TimeUnit timeUnit) {
            return get();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void createNormalWorker(Context context, Worker worker, RVEngine rVEngine, Page page, String str, String str2, BridgeCallback bridgeCallback) {
        Worker workerCreateWorker;
        if (worker == null) {
            try {
                workerCreateWorker = rVEngine.createWorker(context, page, str, str2);
            } catch (Throwable th) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("state", k.j);
                jSONObject.put(com.alibaba.triver.triver_render.view.canvas.tinyapp.c.f25231a, (Object) ("createWorker exception! " + th.getMessage()));
                bridgeCallback.sendJSONResponse(jSONObject);
                RVLogger.e(TAG, "createWorker exception!", th);
                Event eventError = ((EventTracker) RVProxy.get(EventTracker.class)).error(page, "WebEngineError", th.getMessage());
                if (eventError != null) {
                    eventError.putAttr(EventAttr.Key_abnormalCode, "registerWorkerError").putAttr(EventAttr.Key_abnormalMsg, th.getMessage());
                }
                ((WorkerExceptionPoint) ExtensionPoint.as(WorkerExceptionPoint.class).node(page).create()).onCreateWorkerException(th.getMessage());
                return;
            }
        } else {
            workerCreateWorker = worker;
        }
        page.getApp().getEngineProxy().getEngineRouter().registerWorker(str, workerCreateWorker);
        RVLogger.d(TAG, "success setServiceWorkerID " + str);
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("state", "installed");
        bridgeCallback.sendJSONResponse(jSONObject2);
        try {
            ((RVMonitor) RVProxy.get(RVMonitor.class)).flowLog(MONITOR_REGISTER_WORK_SUCCESS, "Render registerWork success", "Render", page.getApp() != null ? page.getApp().getAppId() : "", page.getPageURI(), null);
        } catch (Throwable th2) {
            RVLogger.e(TAG, "flowLog exception:", th2);
        }
    }

    private void createWorkerInner(final Page page, final BridgeCallback bridgeCallback, final String str, final RVEngine rVEngine, final Context context, final String str2) {
        Worker workerCreateWorker = ((CreateWorkerPoint) ExtensionPoint.as(CreateWorkerPoint.class).node(page).create()).createWorker(context, page, str, str2);
        if (workerCreateWorker != null) {
            RVLogger.d(TAG, "REGISTER_WORKER create ExtensionWorker " + workerCreateWorker);
        } else {
            RVLogger.d(TAG, "REGISTER_WORKER create NormalWorker");
            WorkerCreateConfigPoint workerCreateConfigPoint = (WorkerCreateConfigPoint) ExtensionPoint.as(WorkerCreateConfigPoint.class).node(page).nullable().create();
            if (workerCreateConfigPoint != null && workerCreateConfigPoint.isAsyncCreateWorker(page, str, str2)) {
                ExecutorUtils.execute(ExecutorType.URGENT, new Runnable() { // from class: com.alibaba.ariver.jsapi.worker.WorkerBridgeExtension.1
                    @Override // java.lang.Runnable
                    public void run() {
                        RVLogger.d("registerWorker in worker thread,workerId  :\t" + str);
                        WorkerBridgeExtension.this.createNormalWorker(context, null, rVEngine, page, str, str2, bridgeCallback);
                    }
                });
                return;
            }
            workerCreateWorker = null;
        }
        RVLogger.d("registerWorker in UI thread,workerId  :\t" + str);
        createNormalWorker(context, workerCreateWorker, rVEngine, page, str, str2, bridgeCallback);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void savePluginInfoToApp(PluginModel pluginModel, App app) {
        if (app == null || pluginModel == null) {
            return;
        }
        DynamicPluginInfo dynamicPluginInfo = app.getData(DynamicPluginInfo.class) == null ? new DynamicPluginInfo() : (DynamicPluginInfo) app.getData(DynamicPluginInfo.class);
        dynamicPluginInfo.addPlugin(pluginModel);
        app.setData(DynamicPluginInfo.class, dynamicPluginInfo);
    }

    /* JADX WARN: Code duplicated, block: B:26:0x0094 A[Catch: all -> 0x00f0, TryCatch #0 {, blocks: (B:3:0x0001, B:5:0x001b, B:8:0x0023, B:10:0x002d, B:13:0x003c, B:15:0x0046, B:26:0x0094, B:28:0x00a4, B:30:0x00a9, B:33:0x00b1, B:38:0x00d2, B:25:0x008d, B:41:0x00e4, B:44:0x00e8, B:34:0x00c1, B:17:0x0057, B:19:0x0067, B:21:0x0074), top: B:50:0x0001, inners: #1, #2 }] */
    /* JADX WARN: Code duplicated, block: B:28:0x00a4 A[Catch: all -> 0x00f0, TryCatch #0 {, blocks: (B:3:0x0001, B:5:0x001b, B:8:0x0023, B:10:0x002d, B:13:0x003c, B:15:0x0046, B:26:0x0094, B:28:0x00a4, B:30:0x00a9, B:33:0x00b1, B:38:0x00d2, B:25:0x008d, B:41:0x00e4, B:44:0x00e8, B:34:0x00c1, B:17:0x0057, B:19:0x0067, B:21:0x0074), top: B:50:0x0001, inners: #1, #2 }] */
    /* JADX WARN: Code duplicated, block: B:29:0x00a7  */
    /* JADX WARN: Code duplicated, block: B:32:0x00af  */
    @ThreadType(ExecutorType.IO)
    @ActionFilter
    @AutoCallback
    public synchronized BridgeResponse loadPlugin(@BindingParam(required = true, value = {"plugin"}) String str, @BindingNode(App.class) App app, @BindingApiContext ApiContext apiContext) {
        String str2;
        Worker workerById = app.getEngineProxy().getEngineRouter().getWorkerById(((WorkerStore) app.getData(WorkerStore.class, true)).workerId);
        if (workerById == null) {
            return BridgeResponse.newError(5, "cannot loadPlugin without worker!");
        }
        AppConfigModel appConfigModel = (AppConfigModel) app.getData(AppConfigModel.class);
        if (appConfigModel != null && "true".equalsIgnoreCase(appConfigModel.getUseDynamicPlugins())) {
            if (((RVPluginResourceManager) RVProxy.get(RVPluginResourceManager.class)) == null) {
                return BridgeResponse.UNKNOWN_ERROR;
            }
            String[] strArrSplit = str.split("@");
            String str3 = strArrSplit[0];
            if (!this.mLoadedPlugins.containsKey(str3)) {
                ((WorkerStore) app.getData(WorkerStore.class, true)).dynamicLoadedPlugins.add(str3);
                if (strArrSplit.length > 1) {
                    str2 = strArrSplit[1];
                } else {
                    str2 = "*";
                }
                if (TextUtils.isEmpty(str2)) {
                    str2 = "*";
                }
                this.mLoadedPlugins.put(str3, new a(app, workerById, str3, str2, apiContext));
                return this.mLoadedPlugins.get(str3).get();
            }
            try {
                BridgeResponse bridgeResponse = this.mLoadedPlugins.get(str3).get();
                if (bridgeResponse != null && JSONUtils.contains(bridgeResponse.get(), "url")) {
                    RVLogger.w(TAG, "loadPlugin got cache: " + bridgeResponse);
                    return bridgeResponse;
                }
                ((WorkerStore) app.getData(WorkerStore.class, true)).dynamicLoadedPlugins.add(str3);
                if (strArrSplit.length > 1) {
                    str2 = strArrSplit[1];
                } else {
                    str2 = "*";
                }
                if (TextUtils.isEmpty(str2)) {
                    str2 = "*";
                }
                this.mLoadedPlugins.put(str3, new a(app, workerById, str3, str2, apiContext));
                try {
                    return this.mLoadedPlugins.get(str3).get();
                } catch (Throwable th) {
                    RVLogger.w(TAG, "loadPlugin error!", th);
                    return BridgeResponse.newError(6, th.getMessage());
                }
            } catch (Throwable th2) {
                RVLogger.w(TAG, "loadPlugin error!", th2);
            }
            throw th;
        }
        return BridgeResponse.newError(5, "loadPlugin but no \"useDynamicPlugins\"!");
    }

    @Override // com.alibaba.ariver.kernel.api.extension.Extension
    public void onFinalized() {
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
    public BridgeResponse postMessage(@BindingNode(Page.class) Page page, @BindingRequest JSONObject jSONObject, @BindingParam(name = {RVConstants.KEY_POST_MESSAGE}) String str) {
        String str2 = ((WorkerStore) page.getData(WorkerStore.class, true)).workerId;
        EngineRouter engineRouter = page.getApp().getEngineProxy().getEngineRouter();
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("handlerName", (Object) "message");
        if (TextUtils.isEmpty(str)) {
            jSONObject2.put("data", (Object) jSONObject);
        } else {
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put(RVConstants.KEY_POST_MESSAGE, (Object) str);
            jSONObject2.put("data", (Object) jSONObject3);
        }
        jSONObject2.getJSONObject("data").put(MediationConstant.KEY_USE_POLICY_PAGE_ID, (Object) Long.valueOf(page.getNodeId()));
        jSONObject2.getJSONObject("data").put("viewId", (Object) page.getRender().getRenderId());
        Worker workerById = engineRouter.getWorkerById(str2);
        if (workerById != null) {
            workerById.getWorkerHandler().post(new AnonymousClass2(workerById, jSONObject2));
            return BridgeResponse.SUCCESS;
        }
        RVLogger.e(TAG, "postMessage but cannot find worker for workerId: " + str2);
        return BridgeResponse.newError(10, "cannot find worker for id: " + str2);
    }

    @ThreadType(ExecutorType.UI)
    @ActionFilter
    public void registerWorker(@BindingNode(Page.class) Page page, @BindingApiContext ApiContext apiContext, @BindingCallback BridgeCallback bridgeCallback, @BindingParam({"worker"}) String str) {
        RVLogger.d(TAG, String.format("Track[Stage] %s, [timeStamp] %d", TriverAppMonitorConstants.KEY_STAGE_RENDER_FRAMEWORK_FINISH, Long.valueOf(SystemClock.elapsedRealtime())));
        if (str.contains("?")) {
            str = str.substring(0, str.indexOf("?"));
        }
        String str2 = str;
        RVEngine engineProxy = page.getApp().getEngineProxy();
        EngineRouter engineRouter = engineProxy.getEngineRouter();
        ((WorkerStore) page.getData(WorkerStore.class, true)).workerId = str2;
        ((WorkerStore) page.getApp().getData(WorkerStore.class, true)).workerId = str2;
        ((WorkerStore) page.getApp().getData(WorkerStore.class, true)).hasReceivedRegisterWorker = true;
        if (engineRouter.getWorkerById(str2) != null) {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("state", "installed");
            bridgeCallback.sendJSONResponse(jSONObject);
            try {
                ((RVMonitor) RVProxy.get(RVMonitor.class)).flowLog(MONITOR_REGISTER_WORK_SUCCESS, "Render registerWork success", "Render", page.getApp() != null ? page.getApp().getAppId() : "", page.getPageURI(), null);
                return;
            } catch (Throwable th) {
                RVLogger.e(TAG, "flowLog exception:", th);
                return;
            }
        }
        if (TextUtils.isEmpty(str2)) {
            bridgeCallback.sendBridgeResponse(BridgeResponse.INVALID_PARAM);
            return;
        }
        RVLogger.d(TAG, "REGISTER_WORKER worker: " + str2);
        createWorkerInner(page, bridgeCallback, str2, engineProxy, ((RVEnvironmentService) RVProxy.get(RVEnvironmentService.class)).getApplicationContext(), page.getRender().getUserAgent());
    }
}
