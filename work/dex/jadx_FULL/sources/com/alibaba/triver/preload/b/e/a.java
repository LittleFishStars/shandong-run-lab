package com.alibaba.triver.preload.b.e;

import com.alibaba.ariver.app.api.App;
import com.alibaba.ariver.engine.api.bridge.model.NativeCallContext;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.service.executor.ExecutorType;
import com.alibaba.ariver.resource.api.models.AppModel;
import com.alibaba.ariver.resource.api.models.PluginModel;
import com.alibaba.triver.kit.api.monitor.IPerformanceAndErrorTracker;
import com.alibaba.triver.kit.api.orange.TROrangeController;
import com.alibaba.triver.kit.api.preload.annotation.PreloadThreadType;
import com.alibaba.triver.kit.api.preload.core.IPreloadJob;
import com.alibaba.triver.kit.api.preload.core.PreloadScheduler;
import com.alibaba.triver.kit.api.utils.TRiverUrlUtils;
import com.alibaba.triver.kit.api.utils.TRiverUtils;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class a implements IPreloadJob<Boolean> {
    @Override // com.alibaba.triver.kit.api.preload.core.IPreloadJob
    @PreloadThreadType(ExecutorType.URGENT)
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public Boolean preLoad(Map<String, Object> map, PreloadScheduler.PointType pointType) {
        final App app = (App) map.get(NativeCallContext.DOMAIN_APP);
        if (TRiverUtils.isDebugControlPanelApp(app)) {
            return Boolean.FALSE;
        }
        if (TROrangeController.needForceUseV8Worker(app)) {
            return Boolean.FALSE;
        }
        if (!TROrangeController.enableJSIWorkerByAppIdAndTemplateId(app)) {
            return Boolean.FALSE;
        }
        final com.alibaba.triver.triver_worker.v8worker.jsi.d dVarA = a(app);
        if (dVarA == null) {
            return Boolean.FALSE;
        }
        AppModel appModel = (AppModel) app.getData(AppModel.class);
        List<PluginModel> plugins = (appModel == null || appModel.getAppInfoModel() == null || appModel.getAppInfoModel().getPlugins() == null || appModel.getAppInfoModel().getPlugins().size() <= 0) ? null : appModel.getAppInfoModel().getPlugins();
        dVarA.c(app);
        dVarA.a(plugins);
        dVarA.I();
        dVarA.d(app);
        dVarA.getWorkerHandler().post(new Runnable() { // from class: com.alibaba.triver.preload.b.e.a.1
            @Override // java.lang.Runnable
            public void run() {
                dVarA.J();
                dVarA.b(true);
                dVarA.L();
                com.alibaba.triver.triver_worker.v8worker.a.a.a(dVarA, app);
            }
        });
        ((IPerformanceAndErrorTracker) RVProxy.get(IPerformanceAndErrorTracker.class)).sendPerfStageLog("Worker", "JSI worker start execute biz worker code , and prefetch js");
        return Boolean.TRUE;
    }

    @Override // com.alibaba.triver.kit.api.preload.core.IPreloadJob
    public String getJobName() {
        return "JSIWorkerCodePreloadJob";
    }

    @Override // com.alibaba.triver.kit.api.preload.core.IPreloadJob
    public Class<Boolean> getResultClazz() {
        return Boolean.class;
    }

    private com.alibaba.triver.triver_worker.v8worker.jsi.d a(App app) {
        if (TRiverUrlUtils.isShop(app)) {
            c cVar = (c) PreloadScheduler.getInstance().getReadyResult(-1L, c.class);
            if (cVar != null) {
                return cVar.b();
            }
            return null;
        }
        return (com.alibaba.triver.triver_worker.v8worker.jsi.d) PreloadScheduler.getInstance().getReadyResult(-1L, com.alibaba.triver.triver_worker.v8worker.jsi.d.class);
    }
}
