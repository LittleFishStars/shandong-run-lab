package com.alibaba.triver.triver_worker.v8worker.jsi;

import android.os.HandlerThread;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.alibaba.ariver.app.api.App;
import com.alibaba.ariver.app.api.monitor.RVMonitor;
import com.alibaba.ariver.kernel.api.monitor.ErrId;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.resource.api.models.AppModel;
import com.alibaba.ariver.resource.api.models.PluginModel;
import com.alibaba.ariver.v8worker.V8Worker;
import com.alibaba.ariver.v8worker.g;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.triver.kit.api.appmonitor.LaunchMonitorData;
import com.alibaba.triver.kit.api.appmonitor.LaunchMonitorUtils;
import com.alibaba.triver.kit.api.common.TriverAppMonitorConstants;
import com.alibaba.triver.kit.api.monitor.IPerformanceAndErrorTracker;
import com.alibaba.triver.kit.api.orange.TROrangeController;
import com.alibaba.triver.kit.api.utils.FileUtils;
import com.alibaba.triver.kit.api.utils.TRiverUrlUtils;
import com.alibaba.triver.kit.api.utils.TRiverUtils;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class d extends V8Worker {
    protected String i;
    private boolean j;
    private App k;
    private volatile boolean l;
    private Map<String, String> m;
    private int n;

    public d(App app, String str, @Nullable List<PluginModel> list, @Nullable HandlerThread handlerThread, CountDownLatch countDownLatch) {
        super(app, str, list, handlerThread, countDownLatch);
        this.j = false;
        this.l = false;
        this.m = new ConcurrentHashMap();
        this.n = 0;
        this.k = app;
    }

    @Override // com.alibaba.ariver.v8worker.V8Worker
    public void A() {
        super.A();
        JSONObject jSONObject = new JSONObject();
        if (this.k == null) {
            jSONObject.put("workerPreloadCtx", (Object) this.i);
        }
        com.alibaba.triver.trace.b.a(com.alibaba.triver.trace.c.i, com.alibaba.triver.trace.c.ar, TRiverUtils.getSessionId(this.k), this.k, (JSONObject) null);
        LaunchMonitorData subMonitorData = LaunchMonitorUtils.getSubMonitorData(this.k);
        if (subMonitorData == null || subMonitorData.containsKey(TriverAppMonitorConstants.KEY_STAGE_WORKER_APPX_LOADED)) {
            return;
        }
        subMonitorData.addPoint(TriverAppMonitorConstants.KEY_STAGE_WORKER_APPX_LOADED);
    }

    @Override // com.alibaba.ariver.v8worker.V8Worker
    public void B() {
        super.B();
        com.alibaba.triver.trace.b.a(com.alibaba.triver.trace.c.i, com.alibaba.triver.trace.c.at, TRiverUtils.getSessionId(this.k), this.k, (JSONObject) null);
        LaunchMonitorData subMonitorData = LaunchMonitorUtils.getSubMonitorData(this.k);
        if (subMonitorData == null || subMonitorData.containsKey(TriverAppMonitorConstants.KEY_STAGE_WORKER_PLUGIN_LOADED)) {
            return;
        }
        subMonitorData.addPoint(TriverAppMonitorConstants.KEY_STAGE_WORKER_PLUGIN_LOADED);
    }

    @Override // com.alibaba.ariver.v8worker.V8Worker
    public void C() {
        super.C();
        com.alibaba.triver.trace.b.a(com.alibaba.triver.trace.c.i, com.alibaba.triver.trace.c.as, TRiverUtils.getSessionId(this.k), this.k, (JSONObject) null);
        LaunchMonitorData subMonitorData = LaunchMonitorUtils.getSubMonitorData(this.k);
        if (subMonitorData == null || subMonitorData.containsKey(TriverAppMonitorConstants.KEY_STAGE_WORKER_APP_LOADED)) {
            return;
        }
        subMonitorData.addPoint(TriverAppMonitorConstants.KEY_STAGE_WORKER_APP_LOADED);
    }

    @Override // com.alibaba.ariver.v8worker.V8Worker
    public void D() {
        super.D();
        LaunchMonitorData subMonitorData = LaunchMonitorUtils.getSubMonitorData(this.k);
        if (subMonitorData == null || subMonitorData.containsKey("afterAppExecute0")) {
            return;
        }
        subMonitorData.addPoint("afterAppExecute0");
    }

    @Override // com.alibaba.ariver.v8worker.V8Worker
    public void E() {
        super.E();
        LaunchMonitorData subMonitorData = LaunchMonitorUtils.getSubMonitorData(this.k);
        if (subMonitorData == null || subMonitorData.containsKey("afterAppExecute1")) {
            return;
        }
        subMonitorData.addPoint("afterAppExecute1");
    }

    @Override // com.alibaba.ariver.v8worker.V8Worker
    public void F() {
        super.F();
        LaunchMonitorData subMonitorData = LaunchMonitorUtils.getSubMonitorData(this.k);
        if (subMonitorData == null || subMonitorData.containsKey("afterAppExecute2")) {
            return;
        }
        subMonitorData.addPoint("afterAppExecute2");
    }

    @Override // com.alibaba.ariver.v8worker.V8Worker
    public void G() {
        super.G();
        LaunchMonitorData subMonitorData = LaunchMonitorUtils.getSubMonitorData(this.k);
        if (subMonitorData == null || subMonitorData.containsKey("afterAppExecute3")) {
            return;
        }
        subMonitorData.addPoint("afterAppExecute3");
    }

    @Override // com.alibaba.ariver.v8worker.V8Worker
    public void H() {
        super.H();
        LaunchMonitorData subMonitorData = LaunchMonitorUtils.getSubMonitorData(this.k);
        if (subMonitorData == null || subMonitorData.containsKey("afterAppExecute4")) {
            return;
        }
        subMonitorData.addPoint("afterAppExecute4");
    }

    public void J() {
        super.onAlipayJSBridgeReady();
    }

    public boolean K() {
        return this.l;
    }

    public void L() {
        if (K() && TROrangeController.enableWorkerCodePreload()) {
            String strD = d(this.k);
            ((IPerformanceAndErrorTracker) RVProxy.get(IPerformanceAndErrorTracker.class)).sendPerfStageLog("Worker", "worker code preload");
            App app = this.k;
            if (app == null || !TROrangeController.enablePrefetchJs(app) || strD == null) {
                return;
            }
            com.alibaba.jsi.standard.b bVarN = n();
            if (bVarN == null) {
                bVarN = m();
            }
            if (bVarN != null) {
                a(strD.replace("index.worker.js", "prefetch.js"), bVarN);
                ((IPerformanceAndErrorTracker) RVProxy.get(IPerformanceAndErrorTracker.class)).sendPerfStageLog("Prefetch", "do Prefetch Js");
            }
        }
    }

    public int M() {
        return this.n;
    }

    public String N() {
        return this.i;
    }

    @Override // com.alibaba.ariver.v8worker.V8Worker
    public com.alibaba.ariver.v8worker.d a(App app, V8Worker v8Worker) {
        return new b(app, v8Worker);
    }

    @Override // com.alibaba.ariver.v8worker.V8Worker
    public String b() {
        return super.b();
    }

    @Override // com.alibaba.ariver.v8worker.V8Worker
    public void c(App app) {
        super.c(app);
        this.k = app;
        if (i() != null) {
            i().a(app);
        }
        if (h() != null) {
            h().a(app);
        }
    }

    public String d(App app) {
        String str;
        AppModel appModel = (AppModel) app.getData(AppModel.class);
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

    public String e(String str) {
        if (str == null) {
            return null;
        }
        return this.m.get(str);
    }

    public boolean f(String str) {
        if (str == null) {
            return false;
        }
        return this.m.containsKey(str);
    }

    @Override // com.alibaba.ariver.v8worker.V8Worker
    public g g() {
        return new c(this.k, this);
    }

    @Override // com.alibaba.ariver.v8worker.V8Worker, com.alibaba.ariver.engine.common.worker.BaseWorkerImpl
    public void onAlipayJSBridgeReady() {
    }

    @Override // com.alibaba.ariver.v8worker.V8Worker
    public void s() {
        super.s();
        com.alibaba.triver.trace.b.a(com.alibaba.triver.trace.c.i, com.alibaba.triver.trace.c.au, TRiverUtils.getSessionId(this.k), this.k, (JSONObject) null);
    }

    @Override // com.alibaba.ariver.v8worker.V8Worker, com.alibaba.ariver.engine.common.worker.BaseWorkerImpl, com.alibaba.ariver.engine.api.Worker
    public void setRenderReady() {
        super.setRenderReady();
        LaunchMonitorData subMonitorData = LaunchMonitorUtils.getSubMonitorData(this.k);
        if (subMonitorData == null || subMonitorData.containsKey(TriverAppMonitorConstants.KEY_STAGE_RENDER_READY)) {
            return;
        }
        subMonitorData.addPoint(TriverAppMonitorConstants.KEY_STAGE_RENDER_READY);
    }

    @Override // com.alibaba.ariver.v8worker.V8Worker
    public void z() {
        super.z();
        if (this.j) {
            return;
        }
        a(FileUtils.getClientExtendConfig(), "Inject CLIENT_EXTEND_CONFIG", m());
        this.j = true;
    }

    public void a(String str, String str2) {
        if (str == null || str2 == null) {
            return;
        }
        this.m.put(str, str2);
    }

    /* JADX WARN: Code duplicated, block: B:37:0x00b7  */
    /* JADX WARN: Code duplicated, block: B:41:? A[RETURN, SYNTHETIC] */
    @Override // com.alibaba.ariver.v8worker.V8Worker
    public void b(String str, String str2, com.alibaba.jsi.standard.b bVar) {
        String str3;
        String str4;
        String str5;
        if (!TextUtils.isEmpty(str2)) {
            ((IPerformanceAndErrorTracker) RVProxy.get(IPerformanceAndErrorTracker.class)).sendPerfStageLog("Worker", "Start Execute JavaScript: " + str2);
        }
        super.b(str, str2, bVar);
        if (!TextUtils.isEmpty(str2)) {
            ((IPerformanceAndErrorTracker) RVProxy.get(IPerformanceAndErrorTracker.class)).sendPerfStageLog("Worker", "End Execute JavaScript: " + str2);
        }
        if (TextUtils.isEmpty(str2) || !TextUtils.isEmpty(str)) {
            return;
        }
        if (str2.contains("hybrid.miniapp.taobao.com/__plugins__")) {
            str3 = "pluginNull";
            str5 = TRiverUrlUtils.isShop(c()) ? "-10" : "-600010";
        } else {
            if (!str2.contains("index.worker.js")) {
                if (!str2.contains("af-appx.worker.min.js")) {
                    str3 = "";
                    str4 = "";
                } else if (c() == null) {
                    str3 = "workerPreloadAppxNull";
                    str5 = "-10000";
                } else {
                    str3 = "appxNull";
                    str5 = TRiverUrlUtils.isShop(c()) ? "-12" : "-600012";
                }
                if (TextUtils.isEmpty(str3)) {
                }
                HashMap map = new HashMap();
                map.put("resourceUrl", str3);
                ((RVMonitor) RVProxy.get(RVMonitor.class)).error(null, ErrId.RV_TYPE_PAGE_ABNORMAL, str4, "Worker 页面资源丢失，页面白屏", new HashMap(), map);
            }
            str3 = "appJSNull";
            str5 = TRiverUrlUtils.isShop(c()) ? "-11" : "-600011";
        }
        str4 = str5;
        if (TextUtils.isEmpty(str3)) {
            HashMap map2 = new HashMap();
            map2.put("resourceUrl", str3);
            ((RVMonitor) RVProxy.get(RVMonitor.class)).error(null, ErrId.RV_TYPE_PAGE_ABNORMAL, str4, "Worker 页面资源丢失，页面白屏", new HashMap(), map2);
        }
    }

    public void g(String str) {
        this.i = str;
    }

    public void a(int i) {
        this.n = i;
    }

    public void b(boolean z) {
        this.l = z;
    }

    @Override // com.alibaba.ariver.v8worker.V8Worker
    public String b(String str) {
        if (this.k != null) {
            String strB = super.b(str);
            if (!strB.startsWith("__plugin__")) {
                return strB;
            }
        }
        return TROrangeController.RENDER_PRELOAD_V_HOST + "/__plugins__/" + str + "/index.worker.js";
    }
}
