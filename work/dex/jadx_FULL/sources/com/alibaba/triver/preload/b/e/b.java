package com.alibaba.triver.preload.b.e;

import com.alibaba.ariver.engine.api.EngineUtils;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.service.RVEnvironmentService;
import com.alibaba.ariver.kernel.common.service.executor.ExecutorType;
import com.alibaba.ariver.kernel.common.service.executor.RVExecutorService;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.triver.Triver;
import com.alibaba.triver.kit.api.appmonitor.TriverLaunchPointer;
import com.alibaba.triver.kit.api.monitor.IPerformanceAndErrorTracker;
import com.alibaba.triver.kit.api.orange.TROrangeController;
import com.alibaba.triver.kit.api.preload.annotation.RunningAfterAppxJob;
import com.alibaba.triver.kit.api.preload.core.IPreloadJob;
import com.alibaba.triver.kit.api.preload.core.PreloadScheduler;
import com.alibaba.triver.kit.api.proxy.ITriverAppMonitorProxy;
import com.alibaba.triver.kit.api.utils.TRiverUtils;
import com.alibaba.triver.triver_render.render.WMLTRWebView;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class b implements IPreloadJob<com.alibaba.triver.triver_worker.v8worker.jsi.d>, com.alibaba.triver.preload.a.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static int f25133a = 1;
    private String b;

    @RunningAfterAppxJob(true)
    public com.alibaba.triver.triver_worker.v8worker.jsi.d a(Map<String, Object> map, PreloadScheduler.PointType pointType) {
        StringBuilder sb = new StringBuilder();
        sb.append("WorkerPreload_");
        int i = f25133a;
        f25133a = i + 1;
        sb.append(i);
        this.b = sb.toString();
        if (b() || TROrangeController.subProcessEnableRenderWorkerPreload()) {
            return b(map, pointType);
        }
        return null;
    }

    public com.alibaba.triver.triver_worker.v8worker.jsi.d b(Map<String, Object> map, PreloadScheduler.PointType pointType) {
        com.alibaba.triver.triver_worker.v8worker.jsi.d dVar;
        com.alibaba.triver.triver_worker.v8worker.jsi.d dVar2 = null;
        if (!PreloadScheduler.PointType.PROCESS_CREATE.equals(pointType) && !PreloadScheduler.PointType.CLOSE_APP.equals(pointType) && !PreloadScheduler.PointType.AFTER_PAGE_LOADED.equals(pointType)) {
            return null;
        }
        com.alibaba.triver.trace.b.a(com.alibaba.triver.trace.c.b, com.alibaba.triver.trace.c.n, this.b, null);
        if (!TROrangeController.enableJSIWorker()) {
            RVLogger.e("JSIWorker", "jsi worker switch disable");
            return null;
        }
        if (TROrangeController.isThisDeviceInPreloadBlackList()) {
            ((IPerformanceAndErrorTracker) RVProxy.get(IPerformanceAndErrorTracker.class)).sendPerfStageLog("Worker", "this device in preload black list ,preload stop");
            return null;
        }
        if (!TROrangeController.enableBasicWorkerPreload()) {
            return null;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (!TRiverUtils.verifyAppXResource(com.alibaba.triver.preload.b.a.a.b(), "WorkerResourceVerify")) {
            a(System.currentTimeMillis() - jCurrentTimeMillis, 203, this.b);
            return null;
        }
        com.alibaba.triver.triver_worker.v8worker.jsi.d dVar3 = (com.alibaba.triver.triver_worker.v8worker.jsi.d) PreloadScheduler.getInstance().getAndRemoveReadyResult(-1L, com.alibaba.triver.triver_worker.v8worker.jsi.d.class);
        if (dVar3 != null) {
            if (!dVar3.K()) {
                ((IPerformanceAndErrorTracker) RVProxy.get(IPerformanceAndErrorTracker.class)).sendPerfStageLog("Worker", "jsi worker preload , jsi worker has cache , reuse");
                return dVar3;
            }
            try {
                dVar3.destroy();
            } catch (Exception e) {
                e.printStackTrace();
            }
            ((IPerformanceAndErrorTracker) RVProxy.get(IPerformanceAndErrorTracker.class)).sendPerfStageLog("Worker", "jsi worker preload , jsi worker has cache , but has already preload ，can not reuse");
        }
        a();
        if (PreloadScheduler.UA == null) {
            a(System.currentTimeMillis() - jCurrentTimeMillis, 201, this.b);
            return null;
        }
        try {
            dVar = new com.alibaba.triver.triver_worker.v8worker.jsi.d(null, PreloadScheduler.UA, null, null, null);
            try {
                dVar.g(this.b);
            } catch (Exception e2) {
                e = e2;
                dVar2 = dVar;
                e.printStackTrace();
                dVar = dVar2;
            }
        } catch (Exception e3) {
            e = e3;
        }
        long jCurrentTimeMillis2 = System.currentTimeMillis();
        if (dVar != null) {
            a(jCurrentTimeMillis2 - jCurrentTimeMillis, this.b);
            com.alibaba.triver.triver_worker.v8worker.a.a.a(dVar);
        } else {
            a(jCurrentTimeMillis2 - jCurrentTimeMillis, 200, this.b);
        }
        return dVar;
    }

    @Override // com.alibaba.triver.kit.api.preload.core.IPreloadJob
    public String getJobName() {
        return "JSIWorkerPreloadJob";
    }

    @Override // com.alibaba.triver.kit.api.preload.core.IPreloadJob
    public Class<com.alibaba.triver.triver_worker.v8worker.jsi.d> getResultClazz() {
        return com.alibaba.triver.triver_worker.v8worker.jsi.d.class;
    }

    @Override // com.alibaba.triver.kit.api.preload.core.IPreloadJob
    @RunningAfterAppxJob(true)
    public /* synthetic */ com.alibaba.triver.triver_worker.v8worker.jsi.d preLoad(Map map, PreloadScheduler.PointType pointType) {
        return a((Map<String, Object>) map, pointType);
    }

    public static void a() {
        if (PreloadScheduler.UA == null && WMLTRWebView.k()) {
            final CountDownLatch countDownLatch = new CountDownLatch(1);
            ((RVExecutorService) RVProxy.get(RVExecutorService.class)).getExecutor(ExecutorType.UI).execute(new Runnable() { // from class: com.alibaba.triver.preload.b.e.b.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        WMLTRWebView wMLTRWebView = new WMLTRWebView(((RVEnvironmentService) RVProxy.get(RVEnvironmentService.class)).getApplicationContext());
                        PreloadScheduler.UA = wMLTRWebView.getUserAgentString() + " " + EngineUtils.getUserAgentSuffix();
                        wMLTRWebView.destroy();
                    } catch (Throwable th) {
                        try {
                            th.printStackTrace();
                        } finally {
                            countDownLatch.countDown();
                        }
                    }
                }
            });
            try {
                countDownLatch.await(10L, TimeUnit.SECONDS);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.alibaba.triver.preload.a.a
    public void a(long j, String str) {
        ((ITriverAppMonitorProxy) RVProxy.get(ITriverAppMonitorProxy.class)).commitTRiverPreloadPerf(TriverLaunchPointer.build().setStatus(Double.valueOf(1.0d)).create(), "JSIWorker", true, j, 0);
        ((IPerformanceAndErrorTracker) RVProxy.get(IPerformanceAndErrorTracker.class)).sendPerfStageLog("Worker", "jsi worker preload success , cost = " + j);
        com.alibaba.triver.trace.b.a(com.alibaba.triver.trace.c.b, com.alibaba.triver.trace.c.o, str, null);
    }

    @Override // com.alibaba.triver.preload.a.a
    public void a(long j, int i, String str) {
        ((ITriverAppMonitorProxy) RVProxy.get(ITriverAppMonitorProxy.class)).commitTRiverPreloadPerf(TriverLaunchPointer.build().setStatus(Double.valueOf(1.0d)).create(), "JSIWorker", false, j, i);
        ((IPerformanceAndErrorTracker) RVProxy.get(IPerformanceAndErrorTracker.class)).sendPerfStageLog("Worker", "jsi worker preload failed , code = " + i);
        com.alibaba.triver.trace.b.a(com.alibaba.triver.trace.c.b, com.alibaba.triver.trace.c.p, str, null);
    }

    public boolean b() {
        return Triver.isMainProcess(((RVEnvironmentService) RVProxy.get(RVEnvironmentService.class)).getApplicationContext());
    }
}
