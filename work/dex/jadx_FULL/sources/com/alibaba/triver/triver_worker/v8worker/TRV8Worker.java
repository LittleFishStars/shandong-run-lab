package com.alibaba.triver.triver_worker.v8worker;

import android.os.Handler;
import android.os.HandlerThread;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.alibaba.ariver.app.api.App;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.legacy.v8worker.g;
import com.alibaba.ariver.legacy.v8worker.n;
import com.alibaba.ariver.resource.api.models.AppModel;
import com.alibaba.ariver.resource.api.models.PluginModel;
import com.alibaba.triver.kit.api.appmonitor.LaunchMonitorData;
import com.alibaba.triver.kit.api.appmonitor.LaunchMonitorUtils;
import com.alibaba.triver.kit.api.common.TriverAppMonitorConstants;
import com.alibaba.triver.kit.api.monitor.IPerformanceAndErrorTracker;
import com.alibaba.triver.kit.api.orange.TROrangeController;
import com.alibaba.triver.kit.api.systemInfo.SystemInfoUtil;
import com.alibaba.triver.kit.api.utils.FileUtils;
import java.io.Serializable;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class TRV8Worker extends n implements Serializable {
    private int COUNT;
    private App app;
    private boolean dslExec;
    private Handler mHandler;
    private HandlerThread mHandlerThread;
    private a mV8WorkerInitListener;
    private boolean preload;

    public interface a {
        void a(TRV8Worker tRV8Worker);

        void b(TRV8Worker tRV8Worker);
    }

    public TRV8Worker(App app, String str, @Nullable List<PluginModel> list, @Nullable HandlerThread handlerThread, a aVar) {
        super(app, str, list, handlerThread);
        this.COUNT = 0;
        this.preload = false;
        this.dslExec = false;
        this.app = app;
        ((IPerformanceAndErrorTracker) RVProxy.get(IPerformanceAndErrorTracker.class)).sendPerfStageLog("Worker", "Worker start");
        this.mV8WorkerInitListener = aVar;
    }

    private String updateWorkerId() {
        String str;
        AppModel appModel = (AppModel) this.app.getData(AppModel.class);
        if (appModel == null) {
            return null;
        }
        String vhost = appModel.getAppInfoModel().getVhost();
        String workerId = getWorkerId();
        if (workerId != null) {
            return workerId;
        }
        if (vhost.startsWith("https://")) {
            str = vhost + "/index.worker.js";
        } else {
            str = "https://" + vhost + "/index.worker.js";
        }
        String str2 = str;
        setWorkerId(str2);
        return str2;
    }

    public void AlipayJSBridgeReady() {
        super.onAlipayJSBridgeReady();
        a aVar = this.mV8WorkerInitListener;
        if (aVar != null) {
            aVar.b(this);
        }
    }

    @Override // com.alibaba.ariver.legacy.v8worker.n
    public void beforeAppXExecute() {
        super.beforeAppXExecute();
        if (this.dslExec) {
            return;
        }
        executeScript(FileUtils.getClientExtendConfig(), "Inject CLIENT_EXTEND_CONFIG", 0);
        this.dslExec = true;
    }

    @Override // com.alibaba.ariver.legacy.v8worker.n
    public g createJsApiHandler(App app) {
        return new com.alibaba.triver.triver_worker.v8worker.a(app, this);
    }

    @Override // com.alibaba.ariver.legacy.v8worker.n, com.alibaba.ariver.engine.common.worker.BaseWorkerImpl, com.alibaba.ariver.engine.api.Worker
    public void destroy() {
        super.destroy();
        HandlerThread handlerThread = this.mHandlerThread;
        if (handlerThread != null) {
            handlerThread.quitSafely();
            this.mHandlerThread = null;
        }
        if (this.mHandler != null) {
            this.mHandler = null;
        }
    }

    @Override // com.alibaba.ariver.legacy.v8worker.n
    public void doExecuteScript(Object obj, String str, int i) {
        if (!TextUtils.isEmpty(str)) {
            ((IPerformanceAndErrorTracker) RVProxy.get(IPerformanceAndErrorTracker.class)).sendPerfStageLog("Worker", "Start Execute JavaScript: " + str);
        }
        super.doExecuteScript(obj, str, i);
        if (TextUtils.isEmpty(str)) {
            return;
        }
        ((IPerformanceAndErrorTracker) RVProxy.get(IPerformanceAndErrorTracker.class)).sendPerfStageLog("Worker", "End Execute JavaScript: " + str);
    }

    @Override // com.alibaba.ariver.legacy.v8worker.n
    public void doInit() {
        super.doInit();
        a aVar = this.mV8WorkerInitListener;
        if (aVar != null) {
            aVar.a(this);
        }
    }

    @Override // com.alibaba.ariver.legacy.v8worker.n
    public String getNavigator() {
        App app = this.app;
        if (app == null || app.getActivePage() == null) {
            return super.getNavigator();
        }
        return "{userAgent:'" + getUserAgent() + "', systemInfo: '" + SystemInfoUtil.getSystemInfoInner(this.app.getActivePage()) + "'}";
    }

    @Override // com.alibaba.ariver.engine.common.worker.BaseWorkerImpl, com.alibaba.ariver.engine.api.Worker
    public Handler getWorkerHandler() {
        if (this.mHandler == null) {
            synchronized (this) {
                if (this.mHandler == null) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("triver-worker-post-message-");
                    int i = this.COUNT;
                    this.COUNT = i + 1;
                    sb.append(i);
                    HandlerThread handlerThread = new HandlerThread(sb.toString(), 5);
                    this.mHandlerThread = handlerThread;
                    handlerThread.start();
                    this.mHandler = new Handler(this.mHandlerThread.getLooper());
                }
            }
        }
        return this.mHandler;
    }

    public boolean isPreload() {
        return this.preload;
    }

    @Override // com.alibaba.ariver.legacy.v8worker.n, com.alibaba.ariver.engine.common.worker.BaseWorkerImpl
    public void onAlipayJSBridgeReady() {
        if (isPreload() && TROrangeController.enableWorkerCodePreload()) {
            String strUpdateWorkerId = updateWorkerId();
            super.onAlipayJSBridgeReady();
            ((IPerformanceAndErrorTracker) RVProxy.get(IPerformanceAndErrorTracker.class)).sendPerfStageLog("Worker", "worker code preload");
            App app = this.app;
            if (app == null || !TROrangeController.enablePrefetchJs(app) || strUpdateWorkerId == null) {
                return;
            }
            doImportScripts(strUpdateWorkerId.replace("index.worker.js", "prefetch.js"));
            ((IPerformanceAndErrorTracker) RVProxy.get(IPerformanceAndErrorTracker.class)).sendPerfStageLog("Prefetch", "do Prefetch Js");
        }
    }

    public void setPreload(boolean z) {
        this.preload = z;
    }

    @Override // com.alibaba.ariver.engine.common.worker.BaseWorkerImpl, com.alibaba.ariver.engine.api.Worker
    public void setRenderReady() {
        super.setRenderReady();
        LaunchMonitorData subMonitorData = LaunchMonitorUtils.getSubMonitorData(this.app);
        if (subMonitorData == null || subMonitorData.containsKey(TriverAppMonitorConstants.KEY_STAGE_RENDER_READY)) {
            return;
        }
        subMonitorData.addPoint(TriverAppMonitorConstants.KEY_STAGE_RENDER_READY);
    }
}
