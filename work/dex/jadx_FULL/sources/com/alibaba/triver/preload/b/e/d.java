package com.alibaba.triver.preload.b.e;

import android.text.TextUtils;
import com.alibaba.ariver.app.api.App;
import com.alibaba.ariver.engine.api.bridge.model.NativeCallContext;
import com.alibaba.ariver.kernel.api.extension.ExtensionPoint;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.service.executor.ExecutorType;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.ariver.resource.api.models.AppModel;
import com.alibaba.ariver.resource.api.models.PluginModel;
import com.alibaba.triver.Triver;
import com.alibaba.triver.kit.api.monitor.IPerformanceAndErrorTracker;
import com.alibaba.triver.kit.api.orange.TROrangeController;
import com.alibaba.triver.kit.api.preload.annotation.PreloadThreadType;
import com.alibaba.triver.kit.api.preload.core.IPreloadJob;
import com.alibaba.triver.kit.api.preload.core.PreloadScheduler;
import com.alibaba.triver.kit.api.utils.TRiverUtils;
import com.alibaba.triver.point.WorkerPreloadPoint;
import com.alibaba.triver.triver_worker.v8worker.TRV8Worker;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class d implements IPreloadJob<TRV8Worker> {
    @Override // com.alibaba.triver.kit.api.preload.core.IPreloadJob
    @PreloadThreadType(ExecutorType.URGENT)
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public TRV8Worker preLoad(Map<String, Object> map, PreloadScheduler.PointType pointType) {
        TRV8Worker tRV8Worker;
        ((IPerformanceAndErrorTracker) RVProxy.get(IPerformanceAndErrorTracker.class)).sendPerfStageLog("Preload", "Start V8WorkerPreLoadJob");
        final App app = (App) map.get(NativeCallContext.DOMAIN_APP);
        TRV8Worker tRV8Worker2 = null;
        if (TROrangeController.enableJSIWorkerByAppIdAndTemplateId(app)) {
            RVLogger.e("TRV8Worker", "jsi worker enable , v8worker close");
            return null;
        }
        if (!TROrangeController.enableWorkerCodePreload() || TRiverUtils.isDebugControlPanelApp(app) || TRiverUtils.isCanalApp(app)) {
            return null;
        }
        if (PreloadScheduler.PointType.CLOSE_APP == pointType) {
            PreloadScheduler.getInstance().getAndRemoveReadyResult(-1L, TRV8Worker.class);
            return null;
        }
        if (PreloadScheduler.PointType.CREATE_APP != pointType || TextUtils.isEmpty(PreloadScheduler.UA) || !Triver.isInitUCJSEngine()) {
            return null;
        }
        PreloadScheduler.getInstance().getAndRemoveReadyResult(-1L, TRV8Worker.class);
        if (app != null) {
            try {
                AppModel appModel = (AppModel) app.getData(AppModel.class);
                List<PluginModel> plugins = (appModel == null || appModel.getAppInfoModel() == null || appModel.getAppInfoModel().getPlugins() == null || appModel.getAppInfoModel().getPlugins().size() <= 0) ? null : appModel.getAppInfoModel().getPlugins();
                RVLogger.printPerformanceLog("V8Worker", "V8Worker preload start");
                tRV8Worker = new TRV8Worker(app, PreloadScheduler.UA, plugins, null, new TRV8Worker.a() { // from class: com.alibaba.triver.preload.b.e.d.1
                    @Override // com.alibaba.triver.triver_worker.v8worker.TRV8Worker.a
                    public void a(TRV8Worker tRV8Worker3) {
                        RVLogger.printPerformanceLog("V8Worker", "V8Worker preload end");
                    }

                    @Override // com.alibaba.triver.triver_worker.v8worker.TRV8Worker.a
                    public void b(TRV8Worker tRV8Worker3) {
                        ((WorkerPreloadPoint) ExtensionPoint.as(WorkerPreloadPoint.class).node(app).create()).onWorkerPreloaded(app, tRV8Worker3);
                    }
                });
                try {
                    tRV8Worker.setPreload(true);
                } catch (Throwable unused) {
                    tRV8Worker2 = tRV8Worker;
                    RVLogger.e("TRV8Worker preLoad exception!");
                    tRV8Worker = tRV8Worker2;
                }
            } catch (Throwable unused2) {
            }
            RVLogger.e("TRV8Worker preLoad success!");
            ((IPerformanceAndErrorTracker) RVProxy.get(IPerformanceAndErrorTracker.class)).sendPerfStageLog("Preload", "End V8WorkerPreLoadJob");
            return tRV8Worker;
        }
        return null;
    }

    @Override // com.alibaba.triver.kit.api.preload.core.IPreloadJob
    public String getJobName() {
        return "v8worker-preload";
    }

    @Override // com.alibaba.triver.kit.api.preload.core.IPreloadJob
    public Class<TRV8Worker> getResultClazz() {
        return TRV8Worker.class;
    }
}
