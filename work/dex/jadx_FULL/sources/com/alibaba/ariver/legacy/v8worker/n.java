package com.alibaba.ariver.legacy.v8worker;

import android.app.Application;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.MessageQueue;
import android.text.TextUtils;
import android.util.Log;
import android.widget.Toast;
import androidx.annotation.Nullable;
import com.alibaba.ariver.app.api.App;
import com.alibaba.ariver.app.api.Page;
import com.alibaba.ariver.app.api.model.AppConfigModel;
import com.alibaba.ariver.app.api.point.app.AppPausePoint;
import com.alibaba.ariver.app.api.point.app.AppResumePoint;
import com.alibaba.ariver.app.api.point.page.PageEnterPoint;
import com.alibaba.ariver.app.api.point.page.PageExitPoint;
import com.alibaba.ariver.app.api.point.page.PagePausePoint;
import com.alibaba.ariver.app.api.point.page.PageResumePoint;
import com.alibaba.ariver.engine.api.bridge.SendToWorkerCallback;
import com.alibaba.ariver.engine.api.extensions.WorkerStartParamInjectPoint;
import com.alibaba.ariver.engine.common.worker.BaseWorkerImpl;
import com.alibaba.ariver.kernel.RVConstants;
import com.alibaba.ariver.kernel.api.extension.ExtensionManager;
import com.alibaba.ariver.kernel.api.extension.ExtensionPoint;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.bigdata.BigDataChannelManager;
import com.alibaba.ariver.kernel.common.service.RVConfigService;
import com.alibaba.ariver.kernel.common.service.RVEnvironmentService;
import com.alibaba.ariver.kernel.common.service.RVExtensionService;
import com.alibaba.ariver.kernel.common.utils.BundleUtils;
import com.alibaba.ariver.kernel.common.utils.ExecutorUtils;
import com.alibaba.ariver.kernel.common.utils.FileUtils;
import com.alibaba.ariver.kernel.common.utils.RVKernelUtils;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.ariver.legacy.v8worker.extension.V8ImportScriptErrorPoint;
import com.alibaba.ariver.legacy.v8worker.extension.V8JSErrorPoint;
import com.alibaba.ariver.legacy.v8worker.extension.V8SendMessageErrorPoint;
import com.alibaba.ariver.legacy.v8worker.extension.V8WorkerExtension;
import com.alibaba.ariver.resource.api.models.AppInfoScene;
import com.alibaba.ariver.resource.api.models.AppModel;
import com.alibaba.ariver.resource.api.models.PluginModel;
import com.alibaba.fastjson.JSONObject;
import com.alipay.mobile.jsengine.Delegate;
import com.alipay.mobile.jsengine.JSEngine2;
import com.alipay.mobile.jsengine.v8.Releasable;
import com.alipay.mobile.jsengine.v8.V8;
import com.alipay.mobile.jsengine.v8.V8Array;
import com.alipay.mobile.jsengine.v8.V8Context;
import com.alipay.mobile.jsengine.v8.V8Function;
import com.alipay.mobile.jsengine.v8.V8Object;
import com.alipay.mobile.jsengine.v8.V8Value;
import com.aliyun.vod.log.core.AliyunLogCommon;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CountDownLatch;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class n extends BaseWorkerImpl {
    public static final String APPX_SECURITY_JS_URL = "https://appx/security-patch.min.js";
    public static final String APPX_WORKER_JS_URL = "https://appx/af-appx.worker.min.js";
    public static final String BUGME_END = "/*BUGME_END*/";
    public static final String BUGME_START = "/*BUGME_START*/";
    private static final String RUNTIME_VARS = "{console,performance,setTimeout,setInterval,clearTimeout,clearInterval,navigator}";
    private static int V8_WORKER_INDEX = 1;
    private V8Object mAlipayJSBridge;
    private App mApp;
    private V8Context mAppContext;
    private boolean mAppxLoaded;
    private boolean mEnableArrayBuffer;
    private boolean mEnableInspector;
    private boolean mEnableMessageChannel;
    private boolean mEnableTestNewV8;
    private Handler mHandler;
    private HandlerThread mHandlerThread;
    private V8Function mImportScripts;
    private d mImportScriptsCallback;
    private V8Function mInvokeJS;
    private boolean mIsDebugScene;
    protected g mJsApiHandler;
    private i mJsTimer;
    private boolean mKeepTimer;
    private List<PluginModel> mPluginModelList;
    private V8Object mSandbox;
    private String mTag;
    private String mUserAgent;
    private List<V8Context> mV8Contexts;
    private String mV8Flags;
    private l mV8Plugins;
    private V8 mV8Runtime;
    private o mWorkerJsapiCallback;
    private Delegate sJSDelegate;
    private CountDownLatch mInitLock = new CountDownLatch(1);
    private boolean mUseSandboxContext = false;
    private boolean mAlipayJSBridgeReady = false;
    private boolean mWorkerPushed = false;
    private Set<String> mLoadedPlugins = new HashSet();

    public n(App app, String str, @Nullable List<PluginModel> list, @Nullable HandlerThread handlerThread) {
        this.mIsDebugScene = false;
        this.mApp = null;
        this.sJSDelegate = null;
        if (Looper.myLooper() == null) {
            Looper.prepare();
        }
        if (handlerThread == null) {
            this.mHandlerThread = prepareWorkerThread();
        } else {
            this.mHandlerThread = handlerThread;
        }
        this.mApp = app;
        V8WorkerExtension v8WorkerExtension = new V8WorkerExtension(this);
        ExtensionManager extensionManager = ((RVExtensionService) RVProxy.get(RVExtensionService.class)).getExtensionManager();
        extensionManager.registerExtensionByPoint(this.mApp, AppPausePoint.class, v8WorkerExtension);
        extensionManager.registerExtensionByPoint(this.mApp, AppResumePoint.class, v8WorkerExtension);
        extensionManager.registerExtensionByPoint(this.mApp, PagePausePoint.class, v8WorkerExtension);
        extensionManager.registerExtensionByPoint(this.mApp, PageResumePoint.class, v8WorkerExtension);
        extensionManager.registerExtensionByPoint(this.mApp, PageEnterPoint.class, v8WorkerExtension);
        extensionManager.registerExtensionByPoint(this.mApp, PageExitPoint.class, v8WorkerExtension);
        this.mIsDebugScene = AppInfoScene.DEBUG == AppInfoScene.extractScene(app.getStartParams());
        this.mHandler = new Handler(this.mHandlerThread.getLooper());
        StringBuilder sb = new StringBuilder();
        sb.append("V8Worker_");
        int i = V8_WORKER_INDEX;
        V8_WORKER_INDEX = i + 1;
        sb.append(i);
        this.mTag = sb.toString();
        this.mUserAgent = str;
        this.mAppId = this.mApp.getAppId();
        this.mPluginModelList = list;
        this.mV8Contexts = new ArrayList();
        this.mV8Plugins = new l(this, this.mApp.getStartParams());
        Application applicationContext = ((RVEnvironmentService) RVProxy.get(RVEnvironmentService.class)).getApplicationContext();
        if (ExecutorUtils.isMainThread()) {
            RVLogger.e(getLogTag(), "*** ANR WARNING *** DO NOT instantiate V8Worker on main thread");
        }
        RVConfigService rVConfigServiceA = m.a();
        if (rVConfigServiceA != null) {
            try {
                String config = rVConfigServiceA.getConfig("ta_v8WorkerMC", "");
                this.mEnableMessageChannel = config != null && "1".equals(config.trim());
            } catch (Exception e) {
                RVLogger.e(this.mTag, "getConfig exception", e);
            }
            try {
                String config2 = rVConfigServiceA.getConfig("ta_v8WorkerAB", "");
                this.mEnableArrayBuffer = config2 != null && "1".equals(config2.trim());
            } catch (Exception e2) {
                RVLogger.e(this.mTag, "getConfig exception", e2);
            }
            try {
                String config3 = rVConfigServiceA.getConfig("ta_test_new_v8", "");
                this.mEnableTestNewV8 = config3 != null && "1".equals(config3.trim());
            } catch (Exception e3) {
                RVLogger.e(this.mTag, "getConfig exception", e3);
            }
            try {
                this.mV8Flags = rVConfigServiceA.getConfig("ta_v8_flags", "");
            } catch (Exception e4) {
                RVLogger.e(this.mTag, "getConfig exception", e4);
            }
        }
        this.mKeepTimer = m.a(this.mApp.getStartParams(), "keepTimer", "ta_keepTimerAppWhiteList", this.mAppId, false);
        RVLogger.e(this.mTag, "mKeepTimer = " + this.mKeepTimer);
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (this.sJSDelegate == null) {
            this.sJSDelegate = ((V8Proxy) RVProxy.get(V8Proxy.class)).generateDelegate();
        }
        if (this.mEnableTestNewV8) {
            this.mV8Plugins.a();
        }
        boolean zInitialize = JSEngine2.Initialize(this.sJSDelegate);
        long jCurrentTimeMillis2 = System.currentTimeMillis();
        if (!zInitialize) {
            if (RVKernelUtils.isDebug()) {
                Toast.makeText(applicationContext, "JSEngine initialize failed", 1).show();
            }
            throw new IllegalStateException("Failed to initialize JSEngine.");
        }
        if (!TextUtils.isEmpty(this.mV8Flags)) {
            RVLogger.e(getLogTag(), "V8 Flags: " + this.mV8Flags);
            V8.setFlags(this.mV8Flags);
        }
        String logTag = getLogTag();
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Initialize JSEngine cost = ");
        long j = jCurrentTimeMillis2 - jCurrentTimeMillis;
        sb2.append(j);
        RVLogger.e(logTag, sb2.toString());
        if (RVKernelUtils.isDebug()) {
            Toast.makeText(applicationContext, "V8Worker: " + j + "ms", 0).show();
        }
        this.mHandler.post(new Runnable() { // from class: com.alibaba.ariver.legacy.v8worker.n.1
            @Override // java.lang.Runnable
            public void run() {
                n.this.doInit();
            }
        });
    }

    private boolean disablePluginSandbox(Bundle bundle) {
        if (bundle == null) {
            return false;
        }
        try {
            if (bundle.containsKey("disablePluginSandBox")) {
                return Boolean.valueOf(bundle.get("disablePluginSandBox").toString()).booleanValue();
            }
            return false;
        } catch (Throwable th) {
            RVLogger.w(Log.getStackTraceString(th));
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:23:0x0053 A[DONT_GENERATE] */
    /* JADX WARN: Code duplicated, block: B:39:? A[RETURN, SYNTHETIC] */
    public void doSendJsonToWorker(JSONObject jSONObject, SendToWorkerCallback sendToWorkerCallback) {
        if (isReleased()) {
            return;
        }
        System.currentTimeMillis();
        V8Value v8ValueA = null;
        v8ValueA = null;
        v8Value = null;
        v8ValueA = null;
        V8Value v8Value = null;
        try {
            if (this.mEnableArrayBuffer) {
                try {
                    v8ValueA = m.a(this.mV8Runtime, jSONObject);
                    v8Value = v8ValueA;
                } catch (Throwable th) {
                    RVLogger.e(getLogTag(), "serialize error!", th);
                }
            }
            V8Value v8Value2 = v8Value;
            Object jSONString = v8Value;
            if (v8Value == null) {
                try {
                    jSONString = jSONObject.toJSONString();
                } catch (Throwable th2) {
                    th = th2;
                    v8ValueA = v8Value2;
                    try {
                        ((V8SendMessageErrorPoint) ExtensionPoint.as(V8SendMessageErrorPoint.class).node(this.mApp).create()).onSendMessageException(th, this.mAppId);
                    } finally {
                        if (v8ValueA != null) {
                            v8ValueA.release();
                        }
                    }
                }
            }
            doSendMessageToWorker(jSONObject, jSONString, null, null, sendToWorkerCallback);
            if (v8Value2 != null) {
                v8Value2.release();
            }
        } catch (Throwable th3) {
            th = th3;
            ((V8SendMessageErrorPoint) ExtensionPoint.as(V8SendMessageErrorPoint.class).node(this.mApp).create()).onSendMessageException(th, this.mAppId);
        }
    }

    public static HandlerThread prepareWorkerThread() {
        HandlerThread handlerThread = new HandlerThread("worker-jsapi-" + V8_WORKER_INDEX);
        handlerThread.start();
        return handlerThread;
    }

    private boolean useSandbox() {
        List<PluginModel> list = this.mPluginModelList;
        return list != null && list.size() > 0;
    }

    public void beforeAppXExecute() {
    }

    public d createImportScriptCallback() {
        return new d(this.mApp, this);
    }

    public g createJsApiHandler(App app) {
        return new g(app, this);
    }

    @Override // com.alibaba.ariver.engine.common.worker.BaseWorkerImpl, com.alibaba.ariver.engine.api.Worker
    public void destroy() {
        super.destroy();
        terminate();
    }

    public void dispatchPageEvent(final int i, final int i2) {
        if (!this.mV8Plugins.a() || isReleased()) {
            return;
        }
        this.mHandler.post(new Runnable() { // from class: com.alibaba.ariver.legacy.v8worker.n.3
            @Override // java.lang.Runnable
            public void run() {
                if (n.this.isReleased()) {
                    return;
                }
                RVLogger.d(n.this.getLogTag(), "dispatchPageEvent event: " + i + ", appId: " + ((BaseWorkerImpl) n.this).mAppId + ", pageId: " + i2);
                n.this.mV8Runtime.dispatchPluginEvent(i, ((BaseWorkerImpl) n.this).mAppId, i2);
                RVLogger.d(n.this.getLogTag(), "PageEvent event handled, " + i + ", appId: " + ((BaseWorkerImpl) n.this).mAppId + ", pageId: " + i2);
            }
        });
    }

    public void doCreatePluginContext(final String str) {
        V8Context v8Context;
        try {
            if (Looper.myLooper() != this.mHandler.getLooper()) {
                this.mHandler.post(new Runnable() { // from class: com.alibaba.ariver.legacy.v8worker.n.9
                    @Override // java.lang.Runnable
                    public void run() {
                        n.this.doCreatePluginContext(str);
                    }
                });
                return;
            }
            if (this.mLoadedPlugins.contains(str)) {
                RVLogger.e(getLogTag(), "Prepare JSContext but already loaded !!! " + str);
                return;
            }
            RVLogger.e(getLogTag(), "Prepare JSContext for plugin: " + str);
            if (disablePluginSandbox(this.mStartupParams)) {
                v8Context = null;
            } else {
                V8Context v8Context2 = this.mAppContext;
                if (v8Context2 != null) {
                    v8Context2.exit();
                }
                V8Object v8ObjectExecuteObjectScript = this.mV8Runtime.executeObjectScript("Object.assign({}, AFAppX.getPluginContext({pluginId: '" + str + "'})," + RUNTIME_VARS + ")");
                V8 v8 = this.mV8Runtime;
                StringBuilder sb = new StringBuilder();
                sb.append("Plugin: ");
                sb.append(str);
                v8Context = new V8Context(v8, v8ObjectExecuteObjectScript, sb.toString());
                v8ObjectExecuteObjectScript.release();
                v8Context.enter();
                this.mV8Contexts.add(v8Context);
            }
            doImportScripts("https://appx/security-patch.min.js");
            doImportScripts(FileUtils.combinePath(BundleUtils.getString(this.mStartupParams, "onlineHost"), "__plugins__/" + str + "/index.worker.js"));
            if (v8Context != null && !disablePluginSandbox(this.mStartupParams)) {
                v8Context.exit();
                V8Context v8Context3 = this.mAppContext;
                if (v8Context3 != null) {
                    v8Context3.enter();
                }
            }
            this.mLoadedPlugins.add(str);
        } catch (Throwable th) {
            ((V8JSErrorPoint) ExtensionPoint.as(V8JSErrorPoint.class).node(this.mApp).create()).onException(th.getMessage(), this.mAppId, str);
        }
    }

    public void doExecuteScript(Object obj, String str, int i) {
        String str2;
        if (isReleased()) {
            return;
        }
        if (this.mAppContext != null && this.mIsDebugScene && !TextUtils.isEmpty(str) && str.equalsIgnoreCase(this.mWorkerId)) {
            RVLogger.d(getLogTag(), "doExecuteScript main js, handle debug scene!");
            if (obj instanceof byte[]) {
                str2 = new String((byte[]) obj);
            } else {
                str2 = obj instanceof String ? (String) obj : null;
            }
            if (str2 != null) {
                int iIndexOf = str2.indexOf(BUGME_START);
                int iIndexOf2 = str2.indexOf(BUGME_END);
                if (iIndexOf >= 0 && iIndexOf2 >= 0) {
                    obj = str2.substring(0, iIndexOf) + str2.substring(iIndexOf2 + 13);
                }
            }
        }
        try {
            if (obj instanceof String) {
                this.mV8Runtime.executeVoidScript((String) obj, str, i);
            } else if (obj instanceof byte[]) {
                this.mV8Runtime.executeVoidScript((byte[]) obj, str, i);
            }
            this.mV8Runtime.pumpMessageLoop(false);
        } catch (Throwable th) {
            ((V8JSErrorPoint) ExtensionPoint.as(V8JSErrorPoint.class).node(this.mApp).create()).onException(th.getMessage(), this.mAppId, "");
        }
    }

    public void doImportScripts(String str) {
        if (isReleased()) {
            return;
        }
        try {
            this.mImportScriptsCallback.a(str);
        } catch (Exception e) {
            ((V8ImportScriptErrorPoint) ExtensionPoint.as(V8ImportScriptErrorPoint.class).node(this.mApp).create()).onLoadScriptError(e, this.mAppId);
        }
    }

    public void doInit() {
        long jCurrentTimeMillis = System.currentTimeMillis();
        this.mJsApiHandler = createJsApiHandler(this.mApp);
        l lVar = this.mV8Plugins;
        this.mV8Runtime = V8.createV8Runtime("self", lVar.c, lVar.d, this);
        if (RVKernelUtils.isDebug()) {
            this.mEnableInspector = this.mV8Runtime.enableDebugAgent(TextUtils.isEmpty(this.mWorkerId) ? "Loading..." : this.mWorkerId);
        }
        if (!this.mEnableInspector) {
            e.a(this.mV8Runtime);
        }
        this.mJsTimer = new i(this.mV8Runtime, this.mHandler);
        this.mImportScriptsCallback = createImportScriptCallback();
        this.mWorkerJsapiCallback = new o(this);
        this.mV8Runtime.registerJavaMethod(this.mImportScriptsCallback, "importScripts").registerJavaMethod(this.mWorkerJsapiCallback, "__nativeCreateWorker__").registerJavaMethod(new a(this), "__nativeFlushQueue__");
        RVLogger.e(getLogTag(), "start loading worker js bridge");
        doExecuteScript(((V8Proxy) RVProxy.get(V8Proxy.class)).getV8JS(), "https://appx/v8.worker.js", 0);
        try {
            this.mImportScripts = (V8Function) this.mV8Runtime.getObject("importScripts");
            V8Object object = this.mV8Runtime.getObject("AlipayJSBridge");
            this.mAlipayJSBridge = object;
            this.mInvokeJS = (V8Function) object.getObject("_invokeJS");
        } catch (Exception e) {
            RVLogger.e(getLogTag(), "doInitWorker exception = " + e.getMessage());
        }
        RVLogger.e(getLogTag(), "doInitWorker cost = " + (System.currentTimeMillis() - jCurrentTimeMillis));
        doExecuteScript("var navigator=" + getNavigator() + ", __appxStartupParams={enablePolyfillWorker: true, apiMessageChannel:'console', isV8Worker:'true'};", null, 0);
        long jCurrentTimeMillis2 = System.currentTimeMillis();
        String strB = this.mImportScriptsCallback.b("https://appx/af-appx.worker.min.js");
        if (TextUtils.isEmpty(strB)) {
            RVLogger.e(getLogTag(), "*** Failed to pre-execute https://appx/af-appx.worker.min.js");
        } else {
            this.mAppxLoaded = true;
            try {
                setAppxVersionInWorker(strB.substring(0, 100).split("\\r?\\n")[2].substring(3));
            } catch (Throwable unused) {
            }
            beforeAppXExecute();
            doExecuteScript(strB, "https://appx/af-appx.worker.min.js", 0);
            RVLogger.e(getLogTag(), "*** Successfully pre-execute https://appx/af-appx.worker.min.js, cost = " + (System.currentTimeMillis() - jCurrentTimeMillis2));
        }
        onAlipayJSBridgeReady();
    }

    public void doInjectStartupParamsAndPushWorker() {
        RVLogger.e(getLogTag(), "doInjectStartupParamsAndPushWorker");
        AppConfigModel appConfigModel = (AppConfigModel) this.mApp.getData(AppConfigModel.class);
        if (appConfigModel != null && "true".equalsIgnoreCase(appConfigModel.getUseDynamicPlugins())) {
            setUseSandboxContext(true);
        }
        AppModel appModel = (AppModel) this.mApp.getData(AppModel.class);
        List<PluginModel> plugins = appModel != null ? appModel.getAppInfoModel().getPlugins() : null;
        if (plugins != null) {
            setPluginModelList(plugins);
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (RVKernelUtils.isDebug()) {
            this.mStartupParams.putString(AliyunLogCommon.LogLevel.DEBUG, "framework");
        }
        WorkerStartParamInjectPoint workerStartParamInjectPoint = (WorkerStartParamInjectPoint) ExtensionPoint.as(WorkerStartParamInjectPoint.class).node(this.mApp).nullable().create();
        if (workerStartParamInjectPoint != null) {
            workerStartParamInjectPoint.injectStartParam(this.mStartupParams);
        }
        if (this.mEnableInspector) {
            this.mV8Runtime.enableDebugAgent(this.mWorkerId);
        }
        this.mEnableMessageChannel |= "1".equals(BundleUtils.getString(this.mStartupParams, "v8MC", null));
        int i = 0;
        if (this.mUseSandboxContext || useSandbox()) {
            if (!this.mAppxLoaded) {
                this.mAppxLoaded = true;
                doImportScripts("https://appx/af-appx.worker.min.js");
            }
            String str = "var navigator=" + getNavigator() + "; Object.assign(__appxStartupParams, " + BundleUtils.toJSONObject(this.mStartupParams).toJSONString() + ");";
            RVLogger.e(getLogTag(), str);
            doExecuteScript(str, null, 0);
            while (true) {
                List<PluginModel> list = this.mPluginModelList;
                if (list == null || i >= list.size()) {
                    break;
                }
                doCreatePluginContext(this.mPluginModelList.get(i).getAppId());
                i++;
            }
            try {
                RVLogger.e(getLogTag(), "Prepare JSContext for App: " + this.mAppId);
                if (!disablePluginSandbox(this.mStartupParams)) {
                    RVLogger.e(this.mTag, "useSandbox");
                    V8Object v8ObjectExecuteObjectScript = this.mV8Runtime.executeObjectScript("Object.assign({}, AFAppX.getAppContext(),{console,performance,setTimeout,setInterval,clearTimeout,clearInterval,navigator})");
                    this.mAppContext = new V8Context(this.mV8Runtime, v8ObjectExecuteObjectScript, "App Context");
                    v8ObjectExecuteObjectScript.release();
                    this.mAppContext.enter();
                    this.mV8Contexts.add(this.mAppContext);
                    this.mAppContext.add("importScripts", this.mImportScripts);
                }
            } catch (Throwable th) {
                ((V8SendMessageErrorPoint) ExtensionPoint.as(V8SendMessageErrorPoint.class).node(this.mApp).create()).onSendMessageException(th, this.mAppId);
            }
            doImportScripts("https://appx/security-patch.min.js");
            doImportScripts(this.mWorkerId);
        } else {
            String str2 = "Object.assign(__appxStartupParams, " + BundleUtils.toJSONObject(this.mStartupParams).toJSONString() + ");";
            RVLogger.e(getLogTag(), str2);
            doExecuteScript(str2, null, 0);
            doImportScripts(this.mWorkerId);
        }
        RVLogger.e(getLogTag(), "doInjectStartupParamsAndPushWorker cost = " + (System.currentTimeMillis() - jCurrentTimeMillis));
        setWorkerReady();
        this.mV8Plugins.b();
        BigDataChannelManager.getInstance().registerReceiveDataCallback(this.mWorkerId, new b(this));
        Looper.myQueue().addIdleHandler(new MessageQueue.IdleHandler() { // from class: com.alibaba.ariver.legacy.v8worker.n.8
            @Override // android.os.MessageQueue.IdleHandler
            public boolean queueIdle() {
                if (!n.this.isReleased()) {
                    n.this.mV8Runtime.pumpMessageLoop(true);
                }
                return true;
            }
        });
    }

    public void doSendMessageToWorker(JSONObject jSONObject, Object obj, String str, String str2, SendToWorkerCallback sendToWorkerCallback) {
        if (isReleased()) {
            if (sendToWorkerCallback != null) {
                sendToWorkerCallback.onCallBack(new JSONObject());
                return;
            }
            return;
        }
        V8Array v8Array = new V8Array(this.mV8Runtime);
        v8Array.push(obj);
        if (str != null) {
            v8Array.push(str);
        }
        if (str2 != null) {
            v8Array.push(str2);
        }
        boolean z = false;
        try {
            Object objCall = this.mInvokeJS.call(this.mAlipayJSBridge, v8Array);
            boolean zBooleanValue = objCall instanceof Boolean ? ((Boolean) objCall).booleanValue() : false;
            try {
                if (objCall instanceof Releasable) {
                    ((Releasable) objCall).release();
                }
                this.mV8Runtime.pumpMessageLoop(false);
                v8Array.release();
                if (sendToWorkerCallback != null) {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put(RVConstants.EXTRA_PREVENTED, (Object) Boolean.valueOf(zBooleanValue));
                    sendToWorkerCallback.onCallBack(jSONObject2);
                }
            } catch (Throwable th) {
                th = th;
                z = zBooleanValue;
                try {
                    ((V8SendMessageErrorPoint) ExtensionPoint.as(V8SendMessageErrorPoint.class).node(this.mApp).create()).onSendMessageException(th, this.mAppId);
                } finally {
                    v8Array.release();
                    if (sendToWorkerCallback != null) {
                        JSONObject jSONObject3 = new JSONObject();
                        jSONObject3.put(RVConstants.EXTRA_PREVENTED, (Object) Boolean.valueOf(z));
                        sendToWorkerCallback.onCallBack(jSONObject3);
                    }
                }
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public void executeScript(String str) {
        executeScript((Object) str, (String) null, 0);
    }

    public void flushCodeCache() {
        if (isReleased()) {
            return;
        }
        this.mHandler.post(new Runnable() { // from class: com.alibaba.ariver.legacy.v8worker.n.2
            @Override // java.lang.Runnable
            public void run() {
                if (n.this.isReleased()) {
                    return;
                }
                n.this.mV8Runtime.flushCodeCache();
            }
        });
    }

    Handler getHandler() {
        return this.mHandler;
    }

    public g getJsApiHandler() {
        return this.mJsApiHandler;
    }

    @Override // com.alibaba.ariver.engine.common.worker.BaseWorkerImpl
    public String getLogTag() {
        return this.mTag;
    }

    public String getNavigator() {
        return "{userAgent:'" + getUserAgent() + "'}";
    }

    public String getUserAgent() {
        return this.mUserAgent;
    }

    public V8 getV8Runtime() {
        return this.mV8Runtime;
    }

    public boolean isAppxLoaded() {
        return this.mAppxLoaded;
    }

    public boolean isReleased() {
        V8 v8 = this.mV8Runtime;
        return v8 == null || v8.isReleased();
    }

    @Override // com.alibaba.ariver.engine.common.worker.BaseWorkerImpl, com.alibaba.ariver.engine.api.Worker
    public void loadPlugin(String str) {
        super.loadPlugin(str);
        doCreatePluginContext(str);
    }

    public String loadResource(String str) {
        return this.mImportScriptsCallback.b(str);
    }

    @Override // com.alibaba.ariver.engine.common.worker.BaseWorkerImpl
    public void onAlipayJSBridgeReady() {
        RVLogger.e(getLogTag(), "onAlipayJSBridgeReady");
        this.mAlipayJSBridgeReady = true;
        setStartupParams(this.mApp.getStartParams());
        tryToInjectStartupParamsAndPushWorker();
    }

    public void onDispatchTaskOnJsThread() {
        if (isReleased()) {
            return;
        }
        this.mHandler.post(new Runnable() { // from class: com.alibaba.ariver.legacy.v8worker.n.11
            @Override // java.lang.Runnable
            public void run() {
                if (n.this.isReleased()) {
                    return;
                }
                n.this.mV8Runtime.dispatchPluginEvent(-1, "", 0);
            }
        });
    }

    public void onFrontendMessage(final long j, final String str) {
        if (isReleased()) {
            return;
        }
        this.mHandler.post(new Runnable() { // from class: com.alibaba.ariver.legacy.v8worker.n.10
            @Override // java.lang.Runnable
            public void run() {
                if (n.this.isReleased()) {
                    return;
                }
                n.this.mV8Runtime.dispatchFrontendMessage(j, str);
            }
        });
    }

    public void onPageClose(Page page) {
        this.mV8Plugins.d(page);
    }

    public void onPageCreate(Page page) {
        this.mV8Plugins.a(page);
    }

    public void onPagePause(Page page) {
        this.mV8Plugins.c(page);
    }

    public void onPageResume(Page page) {
        this.mV8Plugins.b(page);
    }

    public void onSessionPause() {
        if (isReleased()) {
            return;
        }
        this.mHandler.post(new Runnable() { // from class: com.alibaba.ariver.legacy.v8worker.n.4
            @Override // java.lang.Runnable
            public void run() {
                if (n.this.mV8Runtime.isReleased()) {
                    return;
                }
                if (!n.this.mKeepTimer) {
                    n.this.mJsTimer.c();
                }
                n.this.mV8Plugins.c();
            }
        });
    }

    public void onSessionResume() {
        if (isReleased()) {
            return;
        }
        this.mHandler.post(new Runnable() { // from class: com.alibaba.ariver.legacy.v8worker.n.5
            @Override // java.lang.Runnable
            public void run() {
                if (n.this.isReleased()) {
                    return;
                }
                if (!n.this.mKeepTimer) {
                    n.this.mJsTimer.d();
                }
                n.this.mV8Plugins.b();
            }
        });
    }

    @Override // com.alibaba.ariver.engine.api.Worker
    public void postMessage(String str, SendToWorkerCallback sendToWorkerCallback) {
        sendMessageToWorker(str, sendToWorkerCallback);
    }

    public void prepareMessageChannel(Page page) {
    }

    @Override // com.alibaba.ariver.engine.common.worker.BaseWorkerImpl, com.alibaba.ariver.engine.api.Worker
    public void sendJsonToWorker(final JSONObject jSONObject, final SendToWorkerCallback sendToWorkerCallback) {
        if (isReleased()) {
            return;
        }
        if (Looper.myLooper() == this.mHandler.getLooper()) {
            doSendJsonToWorker(jSONObject, sendToWorkerCallback);
        } else {
            this.mHandler.post(new Runnable() { // from class: com.alibaba.ariver.legacy.v8worker.n.13
                @Override // java.lang.Runnable
                public void run() {
                    n.this.doSendJsonToWorker(jSONObject, sendToWorkerCallback);
                }
            });
        }
    }

    @Override // com.alibaba.ariver.engine.common.worker.BaseWorkerImpl, com.alibaba.ariver.engine.api.Worker
    public void sendMessageToWorker(String str, String str2, String str3, SendToWorkerCallback sendToWorkerCallback) {
        sendMessageToWorker(str3, sendToWorkerCallback);
    }

    public void setPluginModelList(List<PluginModel> list) {
        this.mPluginModelList = list;
    }

    public void setUseSandboxContext(boolean z) {
        RVLogger.d(getLogTag(), "setUseSandboxContext: " + z);
        this.mUseSandboxContext = z;
    }

    public void terminate() {
        if (isReleased()) {
            return;
        }
        this.mHandler.post(new Runnable() { // from class: com.alibaba.ariver.legacy.v8worker.n.6
            @Override // java.lang.Runnable
            public void run() {
                if (n.this.isReleased()) {
                    return;
                }
                try {
                    n.this.mV8Plugins.d();
                    if (n.this.mWorkerJsapiCallback != null) {
                        n.this.mWorkerJsapiCallback.b();
                    }
                    if (n.this.mJsTimer != null) {
                        n.this.mJsTimer.e();
                    }
                    if (n.this.mInvokeJS != null) {
                        n.this.mInvokeJS.release();
                    }
                    if (n.this.mAlipayJSBridge != null) {
                        n.this.mAlipayJSBridge.release();
                    }
                    if (n.this.mImportScripts != null) {
                        n.this.mImportScripts.release();
                    }
                    if (n.this.mSandbox != null) {
                        n.this.mSandbox.release();
                    }
                    if (n.this.mV8Contexts != null && !n.this.mV8Contexts.isEmpty()) {
                        Iterator it = n.this.mV8Contexts.iterator();
                        while (it.hasNext()) {
                            ((V8Context) it.next()).release();
                        }
                    }
                    try {
                        n.this.mV8Runtime.release();
                    } catch (Throwable th) {
                        RVLogger.e(n.this.getLogTag(), "Caught exception when release v8 vm", th);
                    }
                    try {
                        BigDataChannelManager.getInstance().releaseChannelByWorkerId(((BaseWorkerImpl) n.this).mWorkerId);
                    } catch (Throwable th2) {
                        RVLogger.e(th2.getMessage());
                    }
                } catch (Throwable th3) {
                    try {
                        RVLogger.e(n.this.getLogTag(), "Caught exception when destroy v8 instance", th3);
                    } finally {
                        n.this.mHandlerThread.quitSafely();
                    }
                }
            }
        });
    }

    public boolean tryPostMessageByMessageChannel(V8Array v8Array) {
        return false;
    }

    @Override // com.alibaba.ariver.engine.api.Worker
    public void tryToInjectStartupParamsAndPushWorker() {
        String logTag = getLogTag();
        StringBuilder sb = new StringBuilder();
        sb.append("tryToInjectStartupParamsAndPushWorker, ");
        sb.append(this.mWorkerPushed);
        sb.append(", mStartupParams != null? ");
        sb.append(this.mStartupParams != null);
        sb.append(", mAlipayJSBridgeReady? ");
        sb.append(this.mAlipayJSBridgeReady);
        sb.append(", mWorkerId: ");
        sb.append(this.mWorkerId);
        RVLogger.d(logTag, sb.toString());
        if (this.mWorkerPushed || this.mStartupParams == null || !this.mAlipayJSBridgeReady || this.mWorkerId == null) {
            return;
        }
        this.mWorkerPushed = true;
        if (Looper.myLooper() == this.mHandler.getLooper()) {
            doInjectStartupParamsAndPushWorker();
        } else {
            this.mHandler.post(new Runnable() { // from class: com.alibaba.ariver.legacy.v8worker.n.7
                @Override // java.lang.Runnable
                public void run() {
                    n.this.doInjectStartupParamsAndPushWorker();
                }
            });
        }
    }

    public void executeScript(String str, String str2, int i) {
        executeScript((Object) str, str2, i);
    }

    public void sendMessageToWorker(final Object obj, final SendToWorkerCallback sendToWorkerCallback) {
        if (isReleased()) {
            if (sendToWorkerCallback != null) {
                sendToWorkerCallback.onCallBack(new JSONObject());
            }
        } else if (Looper.myLooper() == this.mHandler.getLooper()) {
            doSendMessageToWorker(null, obj, null, null, sendToWorkerCallback);
        } else {
            this.mHandler.post(new Runnable() { // from class: com.alibaba.ariver.legacy.v8worker.n.12
                @Override // java.lang.Runnable
                public void run() {
                    n.this.doSendMessageToWorker(null, obj, null, null, sendToWorkerCallback);
                }
            });
        }
    }

    public void executeScript(Object obj) {
        executeScript(obj, (String) null, 0);
    }

    public void executeScript(final Object obj, final String str, final int i) {
        if (Looper.myLooper() == this.mHandler.getLooper()) {
            doExecuteScript(obj, str, i);
        } else {
            this.mHandler.post(new Runnable() { // from class: com.alibaba.ariver.legacy.v8worker.n.14
                @Override // java.lang.Runnable
                public void run() {
                    n.this.doExecuteScript(obj, str, i);
                }
            });
        }
    }
}
