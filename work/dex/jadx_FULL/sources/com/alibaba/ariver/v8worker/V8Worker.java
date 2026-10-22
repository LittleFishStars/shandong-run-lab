package com.alibaba.ariver.v8worker;

import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Process;
import android.os.SystemClock;
import android.taobao.windvane.util.WVNativeCallbackUtil;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.ali.auth.third.login.LoginConstants;
import com.alibaba.ariver.app.api.App;
import com.alibaba.ariver.app.api.Page;
import com.alibaba.ariver.app.api.model.AppConfigModel;
import com.alibaba.ariver.app.api.monitor.RVMonitor;
import com.alibaba.ariver.app.api.point.app.AppPausePoint;
import com.alibaba.ariver.app.api.point.app.AppResumePoint;
import com.alibaba.ariver.app.api.point.page.PageEnterPoint;
import com.alibaba.ariver.app.api.point.page.PageExitPoint;
import com.alibaba.ariver.app.api.point.page.PagePausePoint;
import com.alibaba.ariver.app.api.point.page.PageResumePoint;
import com.alibaba.ariver.app.api.service.TinyAppInnerProxy;
import com.alibaba.ariver.engine.api.RVEngine;
import com.alibaba.ariver.engine.api.Render;
import com.alibaba.ariver.engine.api.bridge.SendToWorkerCallback;
import com.alibaba.ariver.engine.api.extensions.WorkerStartParamInjectPoint;
import com.alibaba.ariver.engine.api.model.AppxVersionStore;
import com.alibaba.ariver.engine.common.worker.BaseWorkerImpl;
import com.alibaba.ariver.kernel.RVConstants;
import com.alibaba.ariver.kernel.RVParams;
import com.alibaba.ariver.kernel.RVStartParams;
import com.alibaba.ariver.kernel.api.extension.ExtensionManager;
import com.alibaba.ariver.kernel.api.extension.ExtensionPoint;
import com.alibaba.ariver.kernel.api.track.EventTrackStore;
import com.alibaba.ariver.kernel.api.track.EventTracker;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.bigdata.BigDataChannelManager;
import com.alibaba.ariver.kernel.common.log.AppLogger;
import com.alibaba.ariver.kernel.common.log.WorkerLog;
import com.alibaba.ariver.kernel.common.service.RVConfigService;
import com.alibaba.ariver.kernel.common.service.RVEnvironmentService;
import com.alibaba.ariver.kernel.common.service.RVExtensionService;
import com.alibaba.ariver.kernel.common.utils.BundleUtils;
import com.alibaba.ariver.kernel.common.utils.ExecutorUtils;
import com.alibaba.ariver.kernel.common.utils.FileUtils;
import com.alibaba.ariver.kernel.common.utils.JSONUtils;
import com.alibaba.ariver.kernel.common.utils.ProcessUtils;
import com.alibaba.ariver.kernel.common.utils.RVKernelUtils;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.ariver.resource.api.models.AppModel;
import com.alibaba.ariver.resource.api.models.PluginModel;
import com.alibaba.ariver.v8worker.extension.V8ImportScriptErrorPoint;
import com.alibaba.ariver.v8worker.extension.V8SendMessageErrorPoint;
import com.alibaba.ariver.v8worker.extension.V8WorkerExtension;
import com.alibaba.ariver.v8worker.extension.V8WorkerJSErrorTracker;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.jsi.standard.js.s;
import com.alibaba.jsi.standard.js.w;
import com.alibaba.jsi.standard.js.y;
import com.alibaba.triver.kit.api.common.TRiverConstants;
import com.alibaba.triver.kit.api.common.TriverAppMonitorConstants;
import com.aliyun.vod.log.core.AliyunLogCommon;
import com.uc.crashsdk.JNIBridge;
import com.zj.adlib.c49;
import com.zj.adlib.u15;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class V8Worker extends BaseWorkerImpl {
    private static final AtomicBoolean G = new AtomicBoolean(false);
    private static volatile boolean H = false;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f24476a = "https://appx/af-appx.worker.min.js";
    private static long an = 0;
    private static String ao = null;
    private static final String as = "jsApi_systemInfo";
    private static final String at = "jsApi_userInfo";
    private static final String au = "jsApi_appInfo";
    private static final String av = "jsApi_tinyLocalStorage";
    private static final String i = "libjsi.so";
    private static final String j = "libwebviewuc.so";
    private static final String k = "Sandboxed";
    private static final String l = "appId";
    private static final String m = "onlineHost";
    private static final String n = "APPX-JSContext";
    private static final String o = "APP-Biz-JSContext";
    private static final String p = "APP-Plugin-JSContext-";
    private static final String q = "https://appx/security-patch.min.js";
    private static final String r = "{console,performance,setTimeout,setInterval,clearTimeout,clearInterval,navigator,bootstrapSubPackage}";
    private static int s = 1;
    private static final String t = "V8Worker_JSI";
    private HandlerThread A;
    private g B;
    private d C;
    private k D;
    private i E;
    private String I;
    private com.alibaba.jsi.standard.c J;
    private com.alibaba.jsi.standard.b K;
    private com.alibaba.jsi.standard.js.o L;
    private com.alibaba.jsi.standard.js.j M;
    private com.alibaba.jsi.standard.js.j N;
    private com.alibaba.jsi.standard.js.c O;
    private n P;
    private List<PluginModel> Q;
    private List<com.alibaba.jsi.standard.b> R;
    private com.alibaba.jsi.standard.b S;
    private boolean U;
    private boolean V;
    private boolean W;
    private int X;
    private boolean ac;
    private String ad;
    private String ae;
    private Runnable af;
    private long ai;
    private long aj;
    private long ak;
    private long al;
    private long am;
    private JSApiCachePoint ap;
    private JSONObject aq;
    private JSONObject ar;
    private String aw;
    private String ax;
    private String ay;
    private HashMap<String, String> az;
    protected Handler b;
    boolean c;
    public boolean d;
    long e;
    long f;
    long g;
    private String v;
    private App y;
    private CountDownLatch z;
    private boolean w = false;
    private boolean x = false;
    private boolean F = false;
    private Set<String> T = new HashSet();
    private boolean Y = true;
    private volatile boolean Z = false;
    private Runnable aa = null;
    private boolean ab = true;
    private boolean ag = false;
    private boolean ah = false;
    private int aA = 0;
    private Handler aB = null;
    private HandlerThread aC = null;
    final Runnable h = new Runnable() { // from class: com.alibaba.ariver.v8worker.V8Worker.5
        @Override // java.lang.Runnable
        public void run() {
            if (V8Worker.this.aA != 0) {
                RVLogger.e(V8Worker.this.getLogTag(), "******** WARNING ******** JSI init timeout in tid: " + V8Worker.this.aA);
                V8Worker v8Worker = V8Worker.this;
                String strA = v8Worker.a(v8Worker.aA);
                if (strA == null || !strA.startsWith(WVNativeCallbackUtil.SEPERATER)) {
                    return;
                }
                String strE = V8Worker.this.e(strA);
                RVLogger.e(V8Worker.this.getLogTag(), "JSI thread stack is: " + strE);
            }
        }
    };
    private String u = "V8Worker_JSI_" + s;

    public V8Worker(App app, String str, @Nullable List<PluginModel> list, @Nullable HandlerThread handlerThread, CountDownLatch countDownLatch) {
        this.y = app;
        this.z = countDownLatch;
        this.v = str;
        if (app != null) {
            this.mAppId = app.getAppId();
        }
        this.Q = list;
        if (app != null) {
            String string = BundleUtils.getString(getStartupParams(), RVParams.START_APP_SESSION_ID);
            this.ae = string;
            if (TextUtils.isEmpty(string)) {
                this.ae = this.mAppId + "_V8Worker_" + app.getNodeId() + LoginConstants.UNDER_LINE + System.currentTimeMillis();
            }
        }
        final int iA = o.a("ta_v8WorkerInitExpires", 15);
        if (iA > 0) {
            this.af = new Runnable() { // from class: com.alibaba.ariver.v8worker.V8Worker.1
                @Override // java.lang.Runnable
                public void run() {
                    if (V8Worker.this.y != null && (V8Worker.this.y.isDestroyed() || V8Worker.this.y.isExited())) {
                        RVLogger.e(V8Worker.this.u, "mApp isDestroyed");
                        return;
                    }
                    if (V8Worker.this.isWorkerReady() && V8Worker.this.isRenderReady() && V8Worker.this.ag && V8Worker.this.ah) {
                        return;
                    }
                    HashMap map = new HashMap();
                    map.put("type", "init");
                    map.put("message", "V8Worker initializing timeout");
                    map.put("expires", String.valueOf(iA));
                    map.put("lastTrack", V8Worker.this.ad);
                    map.put("workerReady", String.valueOf(V8Worker.this.isWorkerReady()));
                    map.put(TriverAppMonitorConstants.KEY_STAGE_RENDER_READY, String.valueOf(V8Worker.this.isRenderReady()));
                    map.put("workerMsg", String.valueOf(V8Worker.this.ah));
                    map.put("renderMsg", String.valueOf(V8Worker.this.ag));
                    ((EventTracker) RVProxy.get(EventTracker.class)).whiteScreen("whiteScreen", "N21629", map);
                    RVLogger.e(V8Worker.this.getLogTag(), "Failed to initialize V8Worker, lastTrack=" + V8Worker.this.ad + ", workerReady=" + String.valueOf(V8Worker.this.isWorkerReady()) + ", renderReady=" + String.valueOf(V8Worker.this.isRenderReady()) + ", workerMsg=" + String.valueOf(V8Worker.this.ah) + ", renderMsg=" + String.valueOf(V8Worker.this.ag));
                    V8Worker.this.a("V8_StartupFailed", true);
                    String logTag = V8Worker.this.getLogTag();
                    StringBuilder sb = new StringBuilder();
                    sb.append("mCleanupOnInitTimeout=");
                    sb.append(V8Worker.this.ac);
                    RVLogger.e(logTag, sb.toString());
                    if (V8Worker.this.ac) {
                        V8Worker.this.s();
                    }
                }
            };
            d("V8_Preparing");
            ExecutorUtils.runOnMain(this.af, iA * 1000);
        }
        if (Looper.myLooper() == null) {
            Looper.prepare();
        }
        if (handlerThread == null) {
            this.A = e();
        } else {
            this.A = handlerThread;
        }
        this.b = new Handler(this.A.getLooper());
        V8Proxy v8Proxy = (V8Proxy) RVProxy.get(V8Proxy.class);
        if (v8Proxy != null) {
            v8Proxy.addAssociatedThread(this.A.getName());
        } else {
            RVLogger.e(this.u, "v8Proxy is null, V8Worker Thread will be controlled: " + this.A.getName());
        }
        if (Looper.myLooper() == Looper.getMainLooper()) {
            RVLogger.e(getLogTag(), "*** ANR WARNING *** DO NOT instantiate V8Worker on main thread");
        }
        I();
        J();
        long jCurrentTimeMillis = System.currentTimeMillis();
        d("V8_InitJSEngine");
        boolean zB = b(this.y);
        ao = "UC";
        long jCurrentTimeMillis2 = System.currentTimeMillis();
        if (!zB) {
            a("V8_InitJSEngineFailed", true);
            throw new IllegalStateException("Failed to initialize JSEngine.");
        }
        RVLogger.d(getLogTag(), "Initialize JSEngine cost = " + (jCurrentTimeMillis2 - jCurrentTimeMillis));
        d("V8_createJsiInstance");
        this.b.post(new Runnable() { // from class: com.alibaba.ariver.v8worker.V8Worker.6
            @Override // java.lang.Runnable
            public void run() {
                V8Worker v8Worker = V8Worker.this;
                v8Worker.a(((BaseWorkerImpl) v8Worker).mAppId, V8Worker.this.A.getThreadId());
            }
        });
        if (x()) {
            registerRenderReadyListener(new BaseWorkerImpl.RenderReadyListener() { // from class: com.alibaba.ariver.v8worker.V8Worker.7
                @Override // com.alibaba.ariver.engine.common.worker.BaseWorkerImpl.RenderReadyListener
                public void onRenderReady() {
                    RVEngine engineProxy;
                    Render renderById;
                    if (V8Worker.this.y == null || V8Worker.this.y.isDestroyed() || V8Worker.this.y.isExited() || (engineProxy = V8Worker.this.y.getEngineProxy()) == null || (renderById = engineProxy.getEngineRouter().getRenderById(null)) == null) {
                        return;
                    }
                    V8Worker.this.e((Page) renderById.getPage());
                }
            });
        }
    }

    private void J() {
        this.U = o.a("ta_v8WorkerMC", true) && !o.a("ta_v8WorkerMCBlackList", this.mAppId, false);
        this.d = o.a("ta_fullLogMsgWhiteList", this.mAppId, false);
        this.V = o.a("ta_v8WorkerAB", true);
        this.W = K();
        this.X = o.a("ta_pauseTimerDelay", 15);
        this.ab = o.a("ta_v8WorkerHandlerPost", true);
        this.ac = o.a("ta_v8WorkerCleanupOnInitTimeout", false);
        this.Y = o.a("ta_v8PauseJSAPI", true);
        RVLogger.d(this.u, "mKeepTimer = " + this.W + ", mPauseTimerDelay = " + this.X + ", mV8WorkerHandlerPost: " + this.ab + ", mCleanupOnInitTimeout: " + this.ac);
    }

    private boolean K() {
        if (o.a("ta_keepTimerAppBlackList", this.mAppId, false)) {
            RVLogger.w(getLogTag(), this.mAppId + " in ta_keepTimerAppBlackList");
            return false;
        }
        boolean zA = o.a("ta_keepTimerAppWhiteList", this.mAppId, false);
        if (zA) {
            RVLogger.w(getLogTag(), this.mAppId + " in ta_keepTimerAppWhiteList");
        }
        return zA;
    }

    private void L() {
        if (this.R == null) {
            this.R = new ArrayList();
        }
    }

    private void M() {
        RVLogger.d(getLogTag(), "createBizJSContext JSContext for App: " + this.mAppId);
        com.alibaba.jsi.standard.js.o oVar = (com.alibaba.jsi.standard.js.o) this.K.a("Object.assign({}, AFAppX.getAppContext(),{console,performance,setTimeout,setInterval,clearTimeout,clearInterval,navigator,bootstrapSubPackage})", "app-biz-" + this.mAppId + ".js");
        if (this.K.h()) {
            String strA = this.K.i().a(this.K);
            RVLogger.e(getLogTag(), "createBizJSContext executeJS js: Object.assign({}, AFAppX.getAppContext(),{console,performance,setTimeout,setInterval,clearTimeout,clearInterval,navigator,bootstrapSubPackage}) error: " + strA);
            a(null, "", this.K, strA, this.y);
            return;
        }
        com.alibaba.jsi.standard.b bVarB = this.J.b(o);
        this.S = bVarB;
        com.alibaba.jsi.standard.js.o oVarG = bVarB.g();
        a(this.S);
        com.alibaba.jsi.standard.js.d dVarI = oVar.i(this.K);
        int iA = dVarI.a(this.K);
        for (int i2 = 0; i2 < iA; i2++) {
            w wVarA = dVarI.a(this.K, i2);
            w wVarD = oVar.d(this.K, wVarA);
            oVarG.b(this.S, wVarA, wVarD);
            if (wVarD != null) {
                wVarD.a();
            }
            if (wVarA != null) {
                wVarA.a();
            }
        }
        this.R.add(this.S);
        oVarG.a(this.S, "importScripts", this.M);
        oVarG.a(this.S, "self", oVarG);
        oVarG.a(this.S, "AlipayTimersExecution", new y());
        oVar.a();
        oVarG.a();
        dVarI.a();
        d("V8_ImportScripts_SecurityJS");
        a("https://appx/security-patch.min.js", this.S);
        d("V8_ImportScripts_BizJS");
        a(this.mWorkerId, this.S);
    }

    private boolean N() {
        String[] strArrSplit;
        List<PluginModel> list = this.Q;
        if ((list != null && list.size() > 0) || "YES".equals(BundleUtils.getString(this.mStartupParams, k, null))) {
            return true;
        }
        RVConfigService rVConfigServiceA = o.a();
        if (rVConfigServiceA == null) {
            return false;
        }
        try {
            String config = rVConfigServiceA.getConfig("ta_SandboxedWhiteList", null);
            if (!TextUtils.isEmpty(config) && (strArrSplit = config.trim().split(",")) != null && strArrSplit.length != 0) {
                if (strArrSplit.length == 1 && "*".equals(strArrSplit[0])) {
                    return true;
                }
                String string = BundleUtils.getString(this.mStartupParams, "appId");
                if (TextUtils.isEmpty(string)) {
                    return false;
                }
                for (String str : strArrSplit) {
                    if (string.equals(str.trim())) {
                        return true;
                    }
                }
                return false;
            }
            return false;
        } catch (Exception e) {
            RVLogger.e(this.u, "getConfig exception", e);
        }
    }

    private void O() {
        if (this.aB == null) {
            HandlerThread handlerThread = new HandlerThread("JsiInitWatchdog");
            this.aC = handlerThread;
            handlerThread.start();
            this.aB = new Handler(this.aC.getLooper());
        }
        this.aA = Process.myTid();
        RVLogger.d(getLogTag(), "start jsi watch dog for tid: " + this.aA);
        this.aB.postDelayed(this.h, 3000L);
    }

    private void P() {
        RVLogger.d(getLogTag(), "stop jsi watch dog");
        Handler handler = this.aB;
        if (handler != null) {
            handler.removeCallbacks(this.h);
        }
        HandlerThread handlerThread = this.aC;
        if (handlerThread != null) {
            handlerThread.quitSafely();
        }
        this.aA = 0;
    }

    public void A() {
    }

    public void B() {
    }

    public void C() {
    }

    public void D() {
    }

    public void E() {
    }

    public void F() {
    }

    public void G() {
    }

    public void H() {
    }

    public void I() {
        if (this.y != null) {
            V8WorkerExtension v8WorkerExtension = new V8WorkerExtension(this);
            ExtensionManager extensionManager = ((RVExtensionService) RVProxy.get(RVExtensionService.class)).getExtensionManager();
            extensionManager.registerExtensionByPoint(this.y, AppPausePoint.class, v8WorkerExtension);
            extensionManager.registerExtensionByPoint(this.y, AppResumePoint.class, v8WorkerExtension);
            extensionManager.registerExtensionByPoint(this.y, PagePausePoint.class, v8WorkerExtension);
            extensionManager.registerExtensionByPoint(this.y, PageResumePoint.class, v8WorkerExtension);
            extensionManager.registerExtensionByPoint(this.y, PageEnterPoint.class, v8WorkerExtension);
            extensionManager.registerExtensionByPoint(this.y, PageExitPoint.class, v8WorkerExtension);
        }
    }

    public native void _dispatchPluginEvent(String str, int i2, String str2, int i3);

    public native void _loadV8Plugins(String str, String str2, String[] strArr);

    public boolean a(int i2, String str) {
        return false;
    }

    @Override // com.alibaba.ariver.engine.common.worker.BaseWorkerImpl, com.alibaba.ariver.engine.api.Worker
    public void destroy() {
        super.destroy();
        s();
    }

    public void e(Page page) {
    }

    @Override // com.alibaba.ariver.engine.common.worker.BaseWorkerImpl
    public String getLogTag() {
        return this.u;
    }

    @Override // com.alibaba.ariver.engine.common.worker.BaseWorkerImpl, com.alibaba.ariver.engine.api.Worker
    public Handler getWorkerHandler() {
        return this.b;
    }

    @Override // com.alibaba.ariver.engine.common.worker.BaseWorkerImpl, com.alibaba.ariver.engine.api.Worker
    public void loadPlugin(String str) {
        super.loadPlugin(str);
        if (k()) {
            return;
        }
        a(str);
    }

    @Override // com.alibaba.ariver.engine.common.worker.BaseWorkerImpl
    public void onAlipayJSBridgeReady() {
        D();
        RVLogger.e(getLogTag(), "onAlipayJSBridgeReady");
        this.w = true;
        App app = this.y;
        if (app == null || app.isDestroyed()) {
            RVLogger.e(getLogTag(), "onAlipayJSBridgeReady app is null || app is destroyed.");
            return;
        }
        E();
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        try {
            CountDownLatch countDownLatch = this.z;
            if (countDownLatch != null) {
                countDownLatch.await(3000L, TimeUnit.SECONDS);
            }
        } catch (InterruptedException e) {
            RVLogger.e(getLogTag(), "onAlipayJSBridgeReady wait exception!", e);
        }
        RVLogger.d(getLogTag(), "onAlipayJSBridgeReady await initLock: " + (SystemClock.elapsedRealtime() - jElapsedRealtime));
        AppConfigModel appConfigModel = (AppConfigModel) this.y.getData(AppConfigModel.class);
        if (appConfigModel != null && "true".equalsIgnoreCase(appConfigModel.getUseDynamicPlugins())) {
            a(true);
        }
        setStartupParams(this.y.getStartParams());
        String appxVersionInWorker = getAppxVersionInWorker();
        if (appxVersionInWorker == null) {
            appxVersionInWorker = "";
        }
        AppxVersionStore appxVersionStore = (AppxVersionStore) this.y.getData(AppxVersionStore.class, true);
        appxVersionStore.workerVersion = appxVersionInWorker;
        this.y.putStringValue("appxWorkerVersion", appxVersionInWorker);
        RVLogger.e(getLogTag(), "detect appx worker version is: " + appxVersionInWorker + ", versionStore: " + appxVersionStore);
        EventTrackStore eventTrackStore = (EventTrackStore) this.y.getData(EventTrackStore.class, true);
        if ("YES".equalsIgnoreCase(BundleUtils.getString(getStartupParams(), RVParams.APPX_ROUTE_FRAMEWORK))) {
            eventTrackStore.fullLinkAttrMap.put(RVParams.APPX_ROUTE_FRAMEWORK, "YES");
        }
        AppModel appModel = (AppModel) this.y.getData(AppModel.class);
        List<PluginModel> plugins = appModel != null ? appModel.getAppInfoModel().getPlugins() : null;
        if (plugins != null) {
            a(plugins);
        }
        tryToInjectStartupParamsAndPushWorker();
    }

    @Override // com.alibaba.ariver.engine.api.Worker
    public void postMessage(String str, SendToWorkerCallback sendToWorkerCallback) {
        a(str, sendToWorkerCallback);
    }

    @Override // com.alibaba.ariver.engine.common.worker.BaseWorkerImpl, com.alibaba.ariver.engine.api.Worker
    public void sendJsonToWorker(JSONObject jSONObject, final SendToWorkerCallback sendToWorkerCallback) {
        if (k()) {
            return;
        }
        final JSONObject jSONObjectA = o.a(jSONObject);
        if ("message".equals(JSONUtils.getString(jSONObject, "handlerName"))) {
            t();
        }
        if (Looper.myLooper() == this.b.getLooper()) {
            a(jSONObjectA, sendToWorkerCallback);
        } else {
            this.b.post(new Runnable() { // from class: com.alibaba.ariver.v8worker.V8Worker.10
                @Override // java.lang.Runnable
                public void run() {
                    V8Worker.this.a(jSONObjectA, sendToWorkerCallback);
                }
            });
        }
    }

    @Override // com.alibaba.ariver.engine.common.worker.BaseWorkerImpl, com.alibaba.ariver.engine.api.Worker
    public void sendMessageToWorker(String str, String str2, String str3, SendToWorkerCallback sendToWorkerCallback) {
        a(str3, sendToWorkerCallback);
    }

    @Override // com.alibaba.ariver.engine.common.worker.BaseWorkerImpl, com.alibaba.ariver.engine.api.Worker
    public void setRenderReady() {
        this.ak = SystemClock.elapsedRealtime();
        d("V8_RenderReady");
        super.setRenderReady();
    }

    @Override // com.alibaba.ariver.engine.common.worker.BaseWorkerImpl, com.alibaba.ariver.engine.api.Worker
    public void setStartupParams(Bundle bundle) {
        d("V8_SetStartupParams");
        super.setStartupParams(bundle);
    }

    @Override // com.alibaba.ariver.engine.common.worker.BaseWorkerImpl
    public void setWorkerReady() {
        this.al = SystemClock.elapsedRealtime();
        d("V8_WorkerReady");
        super.setWorkerReady();
    }

    @Override // com.alibaba.ariver.engine.api.Worker
    public void tryToInjectStartupParamsAndPushWorker() {
        String logTag = getLogTag();
        StringBuilder sb = new StringBuilder();
        sb.append("tryToInjectStartupParamsAndPushWorker, ");
        sb.append(this.x);
        sb.append(", mStartupParams != null? ");
        sb.append(this.mStartupParams != null);
        sb.append(", mAlipayJSBridgeReady? ");
        sb.append(this.w);
        sb.append(", mWorkerId: ");
        sb.append(this.mWorkerId);
        RVLogger.d(logTag, sb.toString());
        if (this.x || this.mStartupParams == null || !this.w || this.mWorkerId == null) {
            return;
        }
        this.x = true;
        if (Looper.myLooper() == this.b.getLooper()) {
            j();
        } else {
            this.b.post(new Runnable() { // from class: com.alibaba.ariver.v8worker.V8Worker.8
                @Override // java.lang.Runnable
                public void run() {
                    V8Worker.this.j();
                }
            });
        }
    }

    public JSConsoleCallback y() {
        return null;
    }

    public void z() {
    }

    public static HandlerThread e() {
        int iMyPid = Process.myPid();
        StringBuilder sb = new StringBuilder();
        sb.append("jsi-worker-jsapi-");
        sb.append(iMyPid);
        sb.append(c49.f40900a);
        int i2 = s;
        s = i2 + 1;
        sb.append(i2);
        HandlerThread handlerThread = new HandlerThread(sb.toString());
        handlerThread.start();
        return handlerThread;
    }

    public static boolean f() {
        return G.get() && H;
    }

    public static String v() {
        try {
            return com.alibaba.jsi.standard.c.l();
        } catch (Throwable unused) {
            return c49.f40900a;
        }
    }

    public String b() {
        return this.v;
    }

    public App c() {
        return this.y;
    }

    public String d() {
        return this.I;
    }

    public g g() {
        return new g(this.y, this);
    }

    public d h() {
        return this.C;
    }

    public g i() {
        return this.B;
    }

    public void j() {
        F();
        a(this.y);
        RVLogger.d(getLogTag(), "doInjectStartupParamsAndPushWorker");
        d("V8_PushWorker");
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (RVKernelUtils.isDebug()) {
            this.mStartupParams.putString(AliyunLogCommon.LogLevel.DEBUG, "framework");
        }
        WorkerStartParamInjectPoint workerStartParamInjectPoint = (WorkerStartParamInjectPoint) ExtensionPoint.as(WorkerStartParamInjectPoint.class).node(this.y).nullable().create();
        if (workerStartParamInjectPoint != null) {
            workerStartParamInjectPoint.injectStartParam(this.mStartupParams);
        }
        n nVar = new n(this, this.mStartupParams);
        this.P = nVar;
        if (!nVar.a()) {
            d("V8_LoadV8Plugins");
            this.P.b();
        }
        G();
        this.U |= "1".equals(BundleUtils.getString(this.mStartupParams, "v8MC", null));
        if (this.F || N()) {
            H();
            if (!this.c) {
                this.c = true;
                d("V8_ImportScript_AppxWorkerJS");
                a("https://appx/af-appx.worker.min.js", this.K);
            }
            JSONObject jSONObject = BundleUtils.toJSONObject(this.mStartupParams);
            d("V8_MergeJsApiCacheParams");
            b(jSONObject);
            String str = "var navigator={userAgent:'" + b() + "'}; Object.assign(__appxStartupParams, " + jSONObject.toJSONString() + ");";
            RVLogger.e(getLogTag(), "use Sandbox multiple JSContext injectParams: " + str);
            d("V8_InjectFullParams");
            b(str, null, this.K);
            try {
                L();
                int i2 = 0;
                while (true) {
                    List<PluginModel> list = this.Q;
                    if (list == null || i2 >= list.size()) {
                        break;
                    }
                    a(this.Q.get(i2).getAppId());
                    i2++;
                }
                B();
                M();
                C();
            } catch (Throwable th) {
                RVLogger.e(getLogTag(), "createPluginJSContext or createBizJSContext error: " + th);
            }
        } else {
            JSONObject jSONObject2 = BundleUtils.toJSONObject(this.mStartupParams);
            d("V8_MergeJsApiCacheParams");
            b(jSONObject2);
            String str2 = "Object.assign(__appxStartupParams, " + jSONObject2.toJSONString() + ");";
            RVLogger.d(getLogTag(), "injectParams: " + str2);
            d("V8_InjectFullParams");
            b(str2, null, this.K);
            d("V8_ImportScripts_BizJS");
            a(this.mWorkerId, this.K);
            B();
            C();
        }
        this.am = System.currentTimeMillis() - jCurrentTimeMillis;
        RVLogger.e(getLogTag(), "doInjectStartupParamsAndPushWorker cost = " + this.am);
        setWorkerReady();
        n nVar2 = this.P;
        if (nVar2 != null) {
            nVar2.c();
        }
        BigDataChannelManager.getInstance().registerReceiveDataCallback(this.mWorkerId, new b(this));
    }

    public boolean k() {
        com.alibaba.jsi.standard.b bVar = this.K;
        return bVar == null || bVar.b() || this.J == null;
    }

    public com.alibaba.jsi.standard.c l() {
        return this.J;
    }

    public com.alibaba.jsi.standard.b m() {
        return this.K;
    }

    public com.alibaba.jsi.standard.b n() {
        return this.S;
    }

    public Handler o() {
        return this.b;
    }

    public void p() {
        RVLogger.d(getLogTag(), "onSessionPause mAppId: " + this.mAppId);
        if (k()) {
            return;
        }
        Runnable runnable = new Runnable() { // from class: com.alibaba.ariver.v8worker.V8Worker.2
            @Override // java.lang.Runnable
            public void run() {
                if (V8Worker.this.k()) {
                    return;
                }
                if (!V8Worker.this.W) {
                    if (V8Worker.this.X <= 0) {
                        RVLogger.w(V8Worker.this.getLogTag(), "stop JsTimers mAppId: " + ((BaseWorkerImpl) V8Worker.this).mAppId);
                        V8Worker.this.E.c();
                        if (V8Worker.this.Y) {
                            V8Worker.this.Z = true;
                        }
                    } else {
                        V8Worker.this.aa = new Runnable() { // from class: com.alibaba.ariver.v8worker.V8Worker.2.1
                            @Override // java.lang.Runnable
                            public void run() {
                                V8Worker.this.aa = null;
                                if (V8Worker.this.k()) {
                                    return;
                                }
                                RVLogger.w(V8Worker.this.getLogTag(), "stop JsTimers mAppId: " + ((BaseWorkerImpl) V8Worker.this).mAppId);
                                V8Worker.this.E.c();
                                if (V8Worker.this.Y) {
                                    V8Worker.this.Z = true;
                                }
                            }
                        };
                        V8Worker v8Worker = V8Worker.this;
                        v8Worker.b.postDelayed(v8Worker.aa, V8Worker.this.X * 1000);
                    }
                }
                if (V8Worker.this.P != null) {
                    V8Worker.this.P.d();
                }
            }
        };
        if (this.ab) {
            this.b.post(runnable);
        } else {
            this.b.postAtFrontOfQueue(runnable);
        }
    }

    public void q() {
        if (this.Z) {
            RVLogger.d(getLogTag(), "enter waitIfAppPaused mAppId: " + this.mAppId);
            while (this.Z && !k()) {
                synchronized (this) {
                    try {
                        if (this.Z) {
                            wait();
                        }
                    } catch (Throwable unused) {
                    }
                }
            }
            RVLogger.d(getLogTag(), "exit waitIfAppPaused mAppId: " + this.mAppId);
        }
    }

    public void r() {
        RVLogger.d(getLogTag(), "onSessionResume mAppId: " + this.mAppId);
        if (k()) {
            return;
        }
        if (this.Z) {
            synchronized (this) {
                this.Z = false;
                notify();
            }
        }
        this.b.post(new Runnable() { // from class: com.alibaba.ariver.v8worker.V8Worker.3
            @Override // java.lang.Runnable
            public void run() {
                if (V8Worker.this.k()) {
                    return;
                }
                if (!V8Worker.this.W) {
                    if (V8Worker.this.aa != null) {
                        V8Worker v8Worker = V8Worker.this;
                        v8Worker.b.removeCallbacks(v8Worker.aa);
                        V8Worker.this.aa = null;
                    }
                    RVLogger.w(V8Worker.this.getLogTag(), "resume JsTimers");
                    V8Worker.this.E.d();
                }
                if (V8Worker.this.P != null) {
                    V8Worker.this.P.c();
                }
            }
        });
    }

    public void s() {
        RVLogger.d(getLogTag(), "V8Worker destroy(), mAppId: " + this.mAppId);
        if (k()) {
            return;
        }
        if (this.Z) {
            synchronized (this) {
                this.Z = false;
                notify();
            }
        }
        this.b.postAtFrontOfQueue(new Runnable() { // from class: com.alibaba.ariver.v8worker.V8Worker.4
            @Override // java.lang.Runnable
            public void run() {
                if (V8Worker.this.k()) {
                    return;
                }
                RVLogger.d(V8Worker.t, "V8Worker start terminate... mAppId: " + ((BaseWorkerImpl) V8Worker.this).mAppId);
                try {
                    if (V8Worker.this.P != null && !V8Worker.this.P.a()) {
                        V8Worker.this.P.e();
                        V8Worker v8Worker = V8Worker.this;
                        v8Worker._dispatchPluginEvent(v8Worker.I, -1, "", 0);
                    }
                    if (V8Worker.this.D != null) {
                        V8Worker.this.D.b();
                    }
                    if (V8Worker.this.C != null) {
                        V8Worker.this.C.a();
                        V8Worker.this.C = null;
                    }
                    if (V8Worker.this.E != null) {
                        V8Worker.this.E.e();
                    }
                    if (V8Worker.this.N != null) {
                        V8Worker.this.N.a();
                    }
                    if (V8Worker.this.L != null) {
                        V8Worker.this.L.a();
                    }
                    if (V8Worker.this.M != null) {
                        V8Worker.this.M.a();
                    }
                    if (V8Worker.this.K != null) {
                        V8Worker.this.K.a();
                    }
                    if (V8Worker.this.R != null) {
                        Iterator it = V8Worker.this.R.iterator();
                        while (it.hasNext()) {
                            ((com.alibaba.jsi.standard.b) it.next()).a();
                        }
                    }
                    if (V8Worker.this.O != null) {
                        V8Worker.this.O.b();
                    }
                    if (RVKernelUtils.isDebug()) {
                        RVLogger.e(V8Worker.this.getLogTag(), "******** WARNING ********, These JS Objects will be leaked:");
                        V8Worker.this.J.j();
                    }
                    if (V8Worker.this.J != null) {
                        V8Worker.this.J.d();
                        V8Worker.this.J = null;
                    }
                    BigDataChannelManager.getInstance().releaseChannelByWorkerId(((BaseWorkerImpl) V8Worker.this).mWorkerId);
                } catch (Throwable th) {
                    try {
                        RVLogger.e(V8Worker.this.getLogTag(), "Caught exception when destroy v8 instance", th);
                    } finally {
                        V8Worker.this.A.quitSafely();
                    }
                }
            }
        });
    }

    public void t() {
        this.ag = true;
    }

    public void u() {
        this.ah = true;
    }

    public Map<String, String> w() {
        HashMap map = new HashMap();
        long j2 = an;
        if (j2 != 0) {
            map.put("v8_engine_cost", String.valueOf(j2));
        }
        long j3 = this.ai;
        if (j3 != 0) {
            map.put("v8_instance_cost", String.valueOf(j3));
        }
        long j4 = this.aj;
        if (j4 != 0) {
            map.put("v8_appx_res_cost", String.valueOf(j4));
        }
        long j5 = this.e;
        if (j5 != 0) {
            map.put("v8_appx_js_cost", String.valueOf(j5));
        }
        long j6 = this.am;
        if (j6 != 0) {
            map.put("v8_biz_js_cost", String.valueOf(j6));
        }
        long j7 = this.f;
        if (j7 != 0) {
            long j8 = this.g;
            if (j8 != 0) {
                map.put("v8_page_wait", o.a(j7, j8));
            }
        }
        long j9 = this.al;
        if (j9 != 0) {
            long j10 = this.ak;
            if (j10 != 0) {
                map.put("v8_render_wait", o.a(j9, j10));
            }
        }
        map.put("v8_type", ao);
        map.put("v8_version", v());
        map.put("v8_mc", String.valueOf(this.U));
        return map;
    }

    public boolean x() {
        return this.U;
    }

    private static String d(App app) {
        V8Proxy v8Proxy = (V8Proxy) RVProxy.get(V8Proxy.class);
        if (v8Proxy != null) {
            String webViewCoreSoPath = v8Proxy.getWebViewCoreSoPath();
            if (!TextUtils.isEmpty(webViewCoreSoPath) && !webViewCoreSoPath.contains(j)) {
                webViewCoreSoPath = webViewCoreSoPath + "/libwebviewuc.so";
            }
            a(v8Proxy);
            int iQuickVerifyWebViewCoreSo = v8Proxy.quickVerifyWebViewCoreSo(webViewCoreSoPath);
            RVLogger.d(t, "getWebViewCoreSoPath quickVerifyWebViewCoreSo: " + iQuickVerifyWebViewCoreSo);
            if (iQuickVerifyWebViewCoreSo == 2) {
                RVLogger.e(t, "getWebViewCoreSoPath V8_UcQuickVerifyFailed!!!");
                ((EventTracker) RVProxy.get(EventTracker.class)).error(app, "V8_UcQuickVerifyFailed", "JSI_Worker V8_UcQuickVerifyFailed");
            }
            if (!FileUtils.exists(webViewCoreSoPath) || iQuickVerifyWebViewCoreSo == 2) {
                RVLogger.e(t, "getWebViewCoreSoPath => " + webViewCoreSoPath);
                v8Proxy.unzipWebViewCoreSo();
                String webViewCoreSoPath2 = v8Proxy.getWebViewCoreSoPath();
                if (!TextUtils.isEmpty(webViewCoreSoPath2)) {
                    if (!webViewCoreSoPath2.contains(j)) {
                        webViewCoreSoPath2 = webViewCoreSoPath2 + "/libwebviewuc.so";
                    }
                    webViewCoreSoPath = webViewCoreSoPath2;
                    if (!FileUtils.exists(webViewCoreSoPath)) {
                        throw new IllegalStateException("UC library libwebviewuc.so can not found");
                    }
                } else {
                    throw new IllegalStateException("getWebViewCoreSoPath return null");
                }
            }
            return webViewCoreSoPath;
        }
        throw new IllegalStateException("getWebViewCoreSoPath v8Proxy is null");
    }

    public void b(JSONObject jSONObject) {
        App app;
        JSONObject jsapiCacheData;
        if (!TextUtils.isEmpty(this.ay)) {
            RVLogger.w(getLogTag(), "inject apiWhiteList = " + this.ay);
            jSONObject.put("jsApiCacheWhitelist", (Object) this.ay);
        }
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        StringBuilder sb = new StringBuilder();
        if (a(at, c())) {
            boolean z = ProcessUtils.isMainProcess() || ((TinyAppInnerProxy) RVProxy.get(TinyAppInnerProxy.class)).isInner(c());
            RVLogger.w(getLogTag(), "packageJsApiCacheStartParams isInnerApp =" + z);
            if (z && (app = this.y) != null && (jsapiCacheData = this.ap.getJsapiCacheData(this.mAppId, JSApiCachePoint.GET_USER_INFO, app)) != null) {
                jSONObject.put(at, (Object) jsapiCacheData);
                sb.append("userInfo");
                sb.append("|");
            }
        }
        if (a(av, c())) {
            JSONObject jSONObject2 = this.aq;
            if (jSONObject2 != null) {
                jSONObject.put(av, (Object) jSONObject2);
                RVLogger.w(getLogTag(), "mTinyStorageData put success");
                sb.append("tinyStorageData");
                sb.append("|");
            } else {
                RVLogger.w(getLogTag(), "mTinyStorageData put fail");
            }
        } else {
            RVLogger.w(getLogTag(), this.mAppId + " " + av + " not isJsApiCacheInWhiteList");
        }
        if (a(as, c())) {
            JSONObject jSONObject3 = this.ar;
            if (jSONObject3 != null) {
                jSONObject.put(as, (Object) jSONObject3);
                RVLogger.w(getLogTag(), "mSystemInfoData put success");
                sb.append(com.alibaba.ariver.remotedebug.b.c.q);
                sb.append("|");
            } else {
                RVLogger.w(getLogTag(), "mSystemInfoData put fail");
            }
        } else {
            RVLogger.w(getLogTag(), this.mAppId + " not isSystemInfoAppIdWhiteList");
        }
        RVLogger.w(getLogTag(), "packageJsApiCacheStartParams cost = " + (SystemClock.elapsedRealtime() - jElapsedRealtime));
        ((EventTracker) RVProxy.get(EventTracker.class)).addAttr(c(), "jsApiCache", sb.toString());
    }

    public void c(Page page) {
        n nVar;
        if (k() || (nVar = this.P) == null) {
            return;
        }
        nVar.c(page);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String e(String str) {
        FileInputStream fileInputStream = null;
        try {
            try {
                FileInputStream fileInputStream2 = new FileInputStream(new File(str));
                try {
                    byte[] bArr = new byte[2048];
                    int i2 = fileInputStream2.read(bArr);
                    if (i2 > 0) {
                        String str2 = new String(bArr, 0, i2);
                        try {
                            fileInputStream2.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        return str2;
                    }
                    fileInputStream2.close();
                } catch (Throwable th) {
                    th = th;
                    fileInputStream = fileInputStream2;
                    try {
                        RVLogger.e(getLogTag(), "readSmallFile error ", th);
                        if (fileInputStream == null) {
                            return "";
                        }
                        fileInputStream.close();
                    } catch (Throwable th2) {
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                            } catch (IOException e2) {
                                e2.printStackTrace();
                            }
                        }
                        throw th2;
                    }
                }
            } catch (Throwable th3) {
                th = th3;
            }
            return "";
        } catch (IOException e3) {
            e3.printStackTrace();
            return "";
        }
    }

    public String c(String str) {
        return this.C.a(str);
    }

    public void c(App app) {
        this.y = app;
        if (app != null) {
            this.mAppId = app.getAppId();
        }
    }

    public boolean a() {
        return this.c;
    }

    public void a(App app) {
        RVConfigService rVConfigService = (RVConfigService) RVProxy.get(RVConfigService.class);
        this.ax = rVConfigService.getConfig("h5_jsApiCacheWhitelist", null);
        this.aw = rVConfigService.getConfig("h5_jsApiCacheAllOpen", null);
        this.ap = (JSApiCachePoint) ExtensionPoint.as(JSApiCachePoint.class).node(app).create();
        if (a(av, c())) {
            this.aq = this.ap.getJsapiCacheData(this.mAppId, JSApiCachePoint.GET_LOCAL_STORAGE, app);
        }
        if (a(as, c())) {
            this.ar = this.ap.getJsapiCacheData(this.mAppId, JSApiCachePoint.GET_SYSTEM_INFO, app);
        }
    }

    public void a(JSONObject jSONObject) {
        if (jSONObject == null || c() == null || this.az == null || !a("jsApi_remoteLog", c())) {
            return;
        }
        jSONObject.put("jsApi_remoteLog", (Object) this.az.get("jsApi_remoteLog"));
    }

    /* JADX WARN: Code duplicated, block: B:37:0x008c  */
    public boolean a(String str, App app) {
        boolean zEqualsIgnoreCase;
        String appId = app.getAppId();
        Bundle startParams = app.getStartParams();
        if (!TextUtils.isEmpty(this.ax) && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(appId)) {
            if (startParams != null) {
                str.hashCode();
                switch (str) {
                    case "jsApi_remoteLog":
                        zEqualsIgnoreCase = "YES".equalsIgnoreCase(BundleUtils.getString(startParams, RVStartParams.KEY_ENABLE_API_CLIENT_CACHE_REMOTELOG));
                        break;
                    case "jsApi_tinyLocalStorage":
                        zEqualsIgnoreCase = "YES".equalsIgnoreCase(BundleUtils.getString(startParams, RVStartParams.KEY_ENABLE_API_CLIENT_CACHE_LOCALSTORAGE));
                        break;
                    case "jsApi_userInfo":
                        zEqualsIgnoreCase = "YES".equalsIgnoreCase(BundleUtils.getString(startParams, RVStartParams.KEY_ENABLE_API_CLIENT_CACHE_USERINFO));
                        break;
                    case "jsApi_systemInfo":
                        zEqualsIgnoreCase = "YES".equalsIgnoreCase(BundleUtils.getString(startParams, RVStartParams.KEY_ENABLE_API_CLIENT_CACHE_SYSTEMINFO));
                        break;
                    default:
                        zEqualsIgnoreCase = false;
                        break;
                }
            } else {
                zEqualsIgnoreCase = false;
            }
            try {
                String[] strArrSplit = this.ax.split("\\|");
                if (strArrSplit == null || strArrSplit.length < 2) {
                    return false;
                }
                if (!e.a(str, strArrSplit[0]) && !zEqualsIgnoreCase) {
                    return false;
                }
                if ("yes".equals(this.aw) && this.ay == null) {
                    b(strArrSplit[0], false);
                }
                if (!e.b(appId, strArrSplit[1]) && !zEqualsIgnoreCase) {
                    return false;
                }
                if (this.az == null) {
                    b(strArrSplit[0], true);
                }
                return true;
            } catch (Throwable unused) {
            }
        }
        return false;
    }

    public void d(Page page) {
        n nVar;
        if (k() || (nVar = this.P) == null) {
            return;
        }
        nVar.d(page);
    }

    public void d(String str) {
        a(str, false);
    }

    private void b(String str, boolean z) {
        if (z) {
            this.az = new HashMap<>();
        }
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            String[] strArrSplit = str.split(",");
            if (strArrSplit == null || strArrSplit.length <= 0) {
                return;
            }
            StringBuilder sb = new StringBuilder();
            for (String str2 : strArrSplit) {
                String[] strArrSplit2 = str2.split(u15.f19942b);
                String str3 = strArrSplit2[0];
                String str4 = strArrSplit2.length > 1 ? strArrSplit2[1] : "";
                sb.append(str3);
                sb.append(",");
                if (z) {
                    this.az.put(str3, str4);
                }
            }
            this.ay = sb.toString();
        } catch (Throwable th) {
            RVLogger.e(getLogTag(), th);
        }
    }

    private static void a(V8Proxy v8Proxy) {
        if (o.a("ta_jsi_verify_webviewcore", 1) != 1) {
            return;
        }
        File file = new File(((RVEnvironmentService) RVProxy.get(RVEnvironmentService.class)).getApplicationContext().getFilesDir(), "jsi_loading_libwebviewuc_so");
        if (file.exists()) {
            try {
                v8Proxy.removeWebViewCore();
                file.delete();
            } catch (Throwable th) {
                RVLogger.e(t, "removeUcCoreIfNeeded", th);
            }
        }
    }

    public static boolean b(App app) {
        try {
            AtomicBoolean atomicBoolean = G;
            synchronized (atomicBoolean) {
                Application applicationContext = ((RVEnvironmentService) RVProxy.get(RVEnvironmentService.class)).getApplicationContext();
                if (atomicBoolean.getAndSet(true) && H) {
                    RVLogger.d(t, "staticInit alreadyInitialized and success!");
                    return true;
                }
                long jElapsedRealtime = SystemClock.elapsedRealtime();
                String strD = d(app);
                String strReplace = strD.replace(j, i);
                if (!FileUtils.exists(strReplace)) {
                    RVLogger.e(t, "staticInit libjsi.so not found: " + strReplace);
                    return false;
                }
                Bundle bundle = new Bundle();
                bundle.putString("jsiSoPath", strReplace);
                bundle.putString("jsEngineSoPath", strD);
                File fileA = a(applicationContext);
                H = com.alibaba.jsi.standard.c.a(applicationContext, bundle);
                a(fileA);
                System.loadLibrary("v8worker-native");
                an = SystemClock.elapsedRealtime() - jElapsedRealtime;
                RVLogger.d(t, "staticInit JSEngine.loadSo result: " + atomicBoolean + " cost: " + an);
                return H;
            }
        } catch (Throwable th) {
            RVLogger.e(t, "staticInit failed: " + th);
            return false;
        }
    }

    private static File a(Context context) {
        if (o.a("ta_jsi_verify_webviewcore", 1) != 1) {
            return null;
        }
        File file = new File(context.getFilesDir(), "jsi_loading_libwebviewuc_so");
        try {
            file.createNewFile();
            RVLogger.d(t, file + " creating success");
            return file;
        } catch (Throwable th) {
            RVLogger.e(t, "createLoadingFlagIfNeeded", th);
            return null;
        }
    }

    private static void a(File file) {
        if (file == null || !file.exists()) {
            return;
        }
        try {
            file.delete();
            RVLogger.d(t, file + " deleting success");
        } catch (Throwable th) {
            RVLogger.e(t, "removeLoadingFlagIfExists", th);
        }
    }

    private void a(com.alibaba.jsi.standard.b bVar) {
        com.alibaba.jsi.standard.js.o oVarG = bVar.g();
        oVarG.b(bVar, "nativeLog");
        oVarG.a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, int i2) {
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        O();
        Application applicationContext = ((RVEnvironmentService) RVProxy.get(RVEnvironmentService.class)).getApplicationContext();
        Bundle bundle = new Bundle();
        V8Proxy v8Proxy = (V8Proxy) RVProxy.get(V8Proxy.class);
        String packageName = v8Proxy != null ? v8Proxy.getPackageName() : "Alipay";
        String str2 = packageName + "-JSEngine-" + str + c49.f40900a + Process.myPid() + c49.f40900a + i2;
        this.I = str2;
        bundle.putString("name", str2);
        bundle.putString("version", "1.0");
        d("V8_CreateIsolate");
        this.J = com.alibaba.jsi.standard.c.a(applicationContext, bundle, this.b);
        if (RVKernelUtils.isDebug()) {
            this.J.b(true);
        }
        d("V8_CreateJSContext");
        this.K = this.J.b(n);
        this.O = new com.alibaba.jsi.standard.js.c(this.J);
        a(this.K);
        P();
        if (!RVKernelUtils.isDebug()) {
            f.a(this.K, y());
        }
        d("V8_SetupWebAPI");
        this.B = g();
        this.E = new i(this.K, this.b, this);
        this.C = a(this.y, this);
        com.alibaba.jsi.standard.js.o oVarG = this.K.g();
        w jVar = new com.alibaba.jsi.standard.js.j(this.K, new a(this), "__nativeFlushQueue__");
        oVarG.a(this.K, "__nativeFlushQueue__", jVar);
        jVar.a();
        w jVar2 = new com.alibaba.jsi.standard.js.j(this.K, this.C, "importScripts");
        oVarG.a(this.K, "importScripts", jVar2);
        jVar2.a();
        k kVar = new k(this);
        this.D = kVar;
        w jVar3 = new com.alibaba.jsi.standard.js.j(this.K, kVar, "__nativeCreateWorker__");
        oVarG.a(this.K, "__nativeCreateWorker__", jVar3);
        jVar3.a();
        oVarG.a(this.K, "self", oVarG);
        RVLogger.e(getLogTag(), "createJsiInstance start loading worker js bridge");
        d("V8_ReadJSBridge");
        String strA = o.a(applicationContext, R.raw.workerjs_v8);
        d("V8_ExecuteJSBridge");
        b(strA, "https://appx/v8.worker.js", this.K);
        try {
            this.M = (com.alibaba.jsi.standard.js.j) oVarG.a(this.K, "importScripts");
            com.alibaba.jsi.standard.js.o oVar = (com.alibaba.jsi.standard.js.o) oVarG.a(this.K, "AlipayJSBridge");
            this.L = oVar;
            this.N = (com.alibaba.jsi.standard.js.j) oVar.a(this.K, "_invokeJS");
        } catch (Throwable th) {
            a("V8_InitJSBridgeFailed", true);
            RVLogger.e(getLogTag(), "createJsiInstance doInitWorker exception: " + th);
        }
        oVarG.a();
        this.ai = SystemClock.elapsedRealtime() - jElapsedRealtime;
        d("V8_InjectInitialParams");
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(RVStartParams.KEY_ENABLE_POLYFILL_WORKER, (Object) Boolean.TRUE);
        jSONObject.put("apiMessageChannel", "console");
        jSONObject.put("isV8Worker", "true");
        a(jSONObject);
        p.a(jSONObject);
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put(TRiverConstants.KEY_ENVIRONMENT_USERAGENT, (Object) b());
        String str3 = ("var navigator=" + jSONObject2.toJSONString() + com.alipay.sdk.m.y.l.b) + "var __appxStartupParams=" + jSONObject.toJSONString() + com.alipay.sdk.m.y.l.b;
        RVLogger.d(getLogTag(), "v8 init inject string: " + str3);
        b(str3, null, this.K);
        long jCurrentTimeMillis = System.currentTimeMillis();
        d("V8_LoadAppxWorkerJS");
        z();
        String strA2 = this.C.a("https://appx/af-appx.worker.min.js");
        this.aj = SystemClock.elapsedRealtime() - jCurrentTimeMillis;
        if (!TextUtils.isEmpty(strA2)) {
            this.c = true;
            try {
                setAppxVersionInWorker(strA2.substring(0, 100).split("\\r?\\n")[2].substring(3));
            } catch (Throwable unused) {
            }
            long jElapsedRealtime2 = SystemClock.elapsedRealtime();
            d("V8_ExecuteAppxWorkerJS");
            b(strA2, "https://appx/af-appx.worker.min.js", this.K);
            this.e = SystemClock.elapsedRealtime() - jElapsedRealtime2;
            A();
            RVLogger.d(getLogTag(), "createJsiInstance Successfully pre-execute https://appx/af-appx.worker.min.js, cost = " + this.e);
        } else {
            RVLogger.e(getLogTag(), "createJsiInstance Failed to pre-execute https://appx/af-appx.worker.min.js");
        }
        d("V8_JSBridgeReady");
        onAlipayJSBridgeReady();
    }

    private void b(com.alibaba.jsi.standard.b bVar) {
        if (bVar == null) {
            return;
        }
        L();
        this.R.add(bVar);
    }

    public String b(String str) {
        return FileUtils.combinePath(BundleUtils.getString(this.mStartupParams, "onlineHost"), "__plugins__/" + str + "/index.worker.js");
    }

    public void b(String str, String str2, com.alibaba.jsi.standard.b bVar) {
        if (k() || TextUtils.isEmpty(str)) {
            return;
        }
        try {
            if (k()) {
                return;
            }
            com.alibaba.jsi.standard.b bVar2 = this.S != null && !TextUtils.isEmpty(str2) && str2.startsWith(WVNativeCallbackUtil.SEPERATER) && str2.endsWith("/index.worker.js") ? this.S : bVar;
            if (bVar2 != null && !bVar2.b()) {
                w wVarA = bVar2.a(str, str2);
                if (bVar2.h()) {
                    String strA = bVar2.i().a(bVar2);
                    RVLogger.e(getLogTag(), "doExecuteScript: " + str2 + " error: " + strA);
                    StringBuilder sb = new StringBuilder();
                    sb.append("加载JS执行环境失败: ");
                    sb.append(strA);
                    String string = sb.toString();
                    HashMap map = new HashMap();
                    map.put("url", str2);
                    ((RVMonitor) RVProxy.get(RVMonitor.class)).errorLog("EXECUTE_JS_CONTEXT_FAIL", string, "Worker", "", null, map);
                    a(null, "", bVar2, strA, this.y);
                }
                if (wVarA != null) {
                    wVarA.a();
                    return;
                }
                return;
            }
            RVLogger.e(getLogTag(), "doExecuteScript: " + str2 + " jsContext == null");
        } catch (Throwable th) {
            ((V8ImportScriptErrorPoint) ExtensionPoint.as(V8ImportScriptErrorPoint.class).node(this.y).create()).onLoadScriptError(th, this.mAppId, "", bVar != null ? bVar.d() : "");
            a("V8_doExecuteScript_error", true);
        }
    }

    public void b(Page page) {
        n nVar;
        if (k() || (nVar = this.P) == null) {
            return;
        }
        nVar.b(page);
    }

    public d a(App app, V8Worker v8Worker) {
        return new d(app, v8Worker);
    }

    public void a(final String str) {
        if (k()) {
            return;
        }
        if (Looper.myLooper() == this.b.getLooper()) {
            if (this.T.contains(str)) {
                RVLogger.e(getLogTag(), "createPluginJSContext  but already loaded: " + str);
                return;
            }
            RVLogger.d(getLogTag(), "createPluginJSContext for plugin: " + str);
            d("V8_PrepareJSContext_" + str);
            String str2 = "Object.assign({}, AFAppX.getPluginContext({pluginId: '" + str + "'})," + r + ")";
            com.alibaba.jsi.standard.js.o oVar = (com.alibaba.jsi.standard.js.o) this.K.a(str2, "app-plugin-" + str + ".js");
            if (this.K.h()) {
                String strA = this.K.i().a(this.K);
                RVLogger.e(getLogTag(), "createPluginJSContext executeJS js: " + str2 + " error: " + strA);
                a(null, str, this.K, strA, this.y);
                return;
            }
            com.alibaba.jsi.standard.b bVarB = this.J.b(p + str);
            com.alibaba.jsi.standard.js.o oVarG = bVarB.g();
            a(bVarB);
            com.alibaba.jsi.standard.js.d dVarI = oVar.i(this.K);
            int iA = dVarI.a(this.K);
            for (int i2 = 0; i2 < iA; i2++) {
                w wVarA = dVarI.a(this.K, i2);
                w wVarD = oVar.d(this.K, wVarA);
                oVarG.b(bVarB, wVarA, wVarD);
                if (wVarD != null) {
                    wVarD.a();
                }
                if (wVarA != null) {
                    wVarA.a();
                }
            }
            oVarG.a(bVarB, "self", oVarG);
            oVarG.a(bVarB, "AlipayTimersExecution", new y());
            dVarI.a();
            oVarG.a();
            oVar.a();
            b(bVarB);
            d("V8_ImportScripts_SecurityJS_" + str);
            a("https://appx/security-patch.min.js", bVarB);
            String strB = b(str);
            d("V8_ImportScripts_PluginJS_" + str);
            a(strB, bVarB);
            this.T.add(str);
            return;
        }
        this.b.post(new Runnable() { // from class: com.alibaba.ariver.v8worker.V8Worker.9
            @Override // java.lang.Runnable
            public void run() {
                V8Worker.this.a(str);
            }
        });
    }

    public void a(boolean z) {
        RVLogger.d(getLogTag(), "setUseSandboxContext: " + z);
        this.F = z;
    }

    public void a(List<PluginModel> list) {
        this.Q = list;
    }

    public void a(String str, com.alibaba.jsi.standard.b bVar) {
        if (k()) {
            return;
        }
        try {
            this.C.a(str, bVar);
        } catch (Exception e) {
            ((V8ImportScriptErrorPoint) ExtensionPoint.as(V8ImportScriptErrorPoint.class).node(this.y).create()).onLoadScriptError(e, this.mAppId, "", bVar != null ? bVar.d() : "");
            a("V8_ImportScriptFailed", true);
        }
    }

    public void a(final String str, final SendToWorkerCallback sendToWorkerCallback) {
        if (k()) {
            if (sendToWorkerCallback != null) {
                sendToWorkerCallback.onCallBack(new JSONObject());
            }
        } else if (Looper.myLooper() == this.b.getLooper()) {
            a(str, null, null, sendToWorkerCallback);
        } else {
            this.b.post(new Runnable() { // from class: com.alibaba.ariver.v8worker.V8Worker.11
                @Override // java.lang.Runnable
                public void run() {
                    V8Worker.this.a(str, null, null, sendToWorkerCallback);
                }
            });
        }
    }

    public void a(Object obj, String str, String str2, SendToWorkerCallback sendToWorkerCallback) {
        w[] wVarArr;
        boolean zB_;
        JSONObject jSONObject;
        if (k()) {
            if (sendToWorkerCallback != null) {
                sendToWorkerCallback.onCallBack(new JSONObject());
                return;
            }
            return;
        }
        int i2 = 0;
        if (TextUtils.isEmpty(str) && TextUtils.isEmpty(str2)) {
            wVarArr = new w[1];
            if (obj instanceof String) {
                wVarArr[0] = new s((String) obj);
            } else if (obj instanceof w) {
                wVarArr[0] = (w) obj;
            }
        } else {
            w[] wVarArr2 = new w[3];
            if (obj instanceof String) {
                wVarArr2[0] = new s((String) obj);
            } else if (obj instanceof w) {
                wVarArr2[0] = (w) obj;
            }
            wVarArr2[1] = new s(str);
            wVarArr2[2] = new s(str2);
            wVarArr = wVarArr2;
        }
        try {
            w wVarA = this.N.a(this.K, this.L, wVarArr);
            zB_ = wVarA instanceof com.alibaba.jsi.standard.js.f ? ((com.alibaba.jsi.standard.js.f) wVarA).b_() : false;
            if (wVarA != null) {
                try {
                    wVarA.a();
                } catch (Throwable th) {
                    th = th;
                    try {
                        ((V8SendMessageErrorPoint) ExtensionPoint.as(V8SendMessageErrorPoint.class).node(this.y).create()).onSendMessageException(th, this.mAppId);
                        a("V8_doSendMessageToWorker_error", true);
                        while (i2 < wVarArr.length) {
                            wVarArr[i2].a();
                            i2++;
                        }
                        if (sendToWorkerCallback == null) {
                            return;
                        } else {
                            jSONObject = new JSONObject();
                        }
                    } catch (Throwable th2) {
                        while (i2 < wVarArr.length) {
                            wVarArr[i2].a();
                            i2++;
                        }
                        if (sendToWorkerCallback != null) {
                            JSONObject jSONObject2 = new JSONObject();
                            jSONObject2.put(RVConstants.EXTRA_PREVENTED, (Object) Boolean.valueOf(zB_));
                            sendToWorkerCallback.onCallBack(jSONObject2);
                        }
                        throw th2;
                    }
                }
            }
            while (i2 < wVarArr.length) {
                wVarArr[i2].a();
                i2++;
            }
            if (sendToWorkerCallback != null) {
                jSONObject = new JSONObject();
                jSONObject.put(RVConstants.EXTRA_PREVENTED, (Object) Boolean.valueOf(zB_));
                sendToWorkerCallback.onCallBack(jSONObject);
            }
        } catch (Throwable th3) {
            th = th3;
            zB_ = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1 */
    /* JADX WARN: Type inference failed for: r0v2, types: [com.alibaba.jsi.standard.js.w] */
    /* JADX WARN: Type inference failed for: r0v3 */
    /* JADX WARN: Type inference failed for: r2v2, types: [com.alibaba.jsi.standard.js.w] */
    public void a(JSONObject jSONObject, SendToWorkerCallback sendToWorkerCallback) {
        Object objA;
        if (k()) {
            return;
        }
        ?? r0 = 0;
        try {
            if (this.V) {
                try {
                    objA = o.a(this.K, jSONObject);
                } catch (Throwable th) {
                    RVLogger.e(getLogTag(), "serialize error!", th);
                    objA = null;
                }
            } else {
                objA = null;
            }
            ?? r2 = objA;
            if (objA == null) {
                try {
                    objA = jSONObject.toJSONString();
                } catch (Throwable th2) {
                    th = th2;
                    r0 = r2;
                    try {
                        ((V8SendMessageErrorPoint) ExtensionPoint.as(V8SendMessageErrorPoint.class).node(this.y).create()).onSendMessageException(th, this.mAppId);
                        a("V8_doSendJsonToWorker_error", true);
                        RVLogger.e(getLogTag(), "Caught exception when doSendJsonToWorker: \n" + th);
                        if (r0 != 0) {
                            return;
                        } else {
                            return;
                        }
                    } finally {
                        if (r0 != 0) {
                            r0.a();
                        }
                    }
                }
            }
            a(objA, null, null, sendToWorkerCallback);
            if (r2 != 0) {
                r2.a();
            }
        } catch (Throwable th3) {
            th = th3;
        }
    }

    public void a(final String str, final String str2, final com.alibaba.jsi.standard.b bVar) {
        if (k()) {
            return;
        }
        if (Looper.myLooper() == this.b.getLooper()) {
            b(str, str2, bVar);
        } else {
            this.b.post(new Runnable() { // from class: com.alibaba.ariver.v8worker.V8Worker.12
                @Override // java.lang.Runnable
                public void run() {
                    V8Worker.this.b(str, str2, bVar);
                }
            });
        }
    }

    public void a(Page page) {
        n nVar;
        if (k() || (nVar = this.P) == null) {
            return;
        }
        nVar.a(page);
    }

    public void a(final int i2, final int i3) {
        n nVar = this.P;
        if (nVar == null || nVar.a() || k()) {
            return;
        }
        this.b.post(new Runnable() { // from class: com.alibaba.ariver.v8worker.V8Worker.13
            @Override // java.lang.Runnable
            public void run() {
                if (V8Worker.this.k()) {
                    return;
                }
                RVLogger.d(V8Worker.this.getLogTag(), "dispatchPageEvent event: " + i2 + ", appId: " + ((BaseWorkerImpl) V8Worker.this).mAppId + ", pageId: " + i3);
                V8Worker v8Worker = V8Worker.this;
                v8Worker._dispatchPluginEvent(v8Worker.d(), i2, ((BaseWorkerImpl) V8Worker.this).mAppId, i3);
            }
        });
    }

    public void a(String str, boolean z) {
        String str2 = "V8Worker_JSI_" + str;
        this.ad = str2;
        if (this.y != null) {
            try {
                ((EventTracker) RVProxy.get(EventTracker.class)).stub(this.y, str2);
                AppLogger.log(new WorkerLog.Builder().setAppId(this.mAppId).setTag(str2).setParentId(this.ae).setState(z ? "error" : "start").build());
            } catch (Throwable th) {
                RVLogger.e(getLogTag(), "trackStub got exception for " + str2, th);
            }
        }
    }

    public boolean a(com.alibaba.jsi.standard.js.a aVar) {
        if (x() && isRenderReady()) {
            try {
                s sVar = (s) aVar.a(0);
                String strA_ = sVar.a_(aVar.b());
                sVar.a();
                if (!com.alibaba.triver.embed.webview.b.f24908a.equals(strA_)) {
                    return false;
                }
                com.alibaba.jsi.standard.js.m mVar = (com.alibaba.jsi.standard.js.m) aVar.a(1);
                int iL = mVar.l();
                mVar.a();
                w wVarA = aVar.a(2);
                String string = o.a(wVarA, aVar.b()).toString();
                wVarA.a();
                return a(iL, string);
            } catch (Throwable th) {
                RVLogger.e(getLogTag(), "postMessageByMessageChannel exception: " + th);
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String a(int i2) {
        try {
            Method declaredMethod = JNIBridge.class.getDeclaredMethod("nativeDumpThreads", String.class, Long.TYPE);
            if (declaredMethod == null) {
                return "";
            }
            declaredMethod.setAccessible(true);
            return (String) declaredMethod.invoke(null, String.valueOf(i2), 0);
        } catch (Throwable th) {
            RVLogger.e(getLogTag(), "readSmallFile error ", th);
            return "";
        }
    }

    public void a(Throwable th, String str, com.alibaba.jsi.standard.b bVar, String str2, App app) {
        if (th != null) {
            str2 = th.getMessage() + " , " + str2;
        }
        String str3 = str2;
        try {
            V8WorkerJSErrorTracker v8WorkerJSErrorTracker = (V8WorkerJSErrorTracker) RVProxy.get(V8WorkerJSErrorTracker.class);
            if (v8WorkerJSErrorTracker != null) {
                v8WorkerJSErrorTracker.trackJsError(str3, this.mAppId, str, bVar != null ? bVar.d() : "", app);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
