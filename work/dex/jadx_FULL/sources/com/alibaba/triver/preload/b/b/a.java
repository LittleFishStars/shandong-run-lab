package com.alibaba.triver.preload.b.b;

import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.service.RVEnvironmentService;
import com.alibaba.triver.kit.api.preload.core.IPreloadJob;
import com.alibaba.triver.kit.api.preload.core.PreloadScheduler;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class a implements IPreloadJob<Void> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f25123a = "ProcessPreloadAfterDiedJob";

    @Override // com.alibaba.triver.kit.api.preload.core.IPreloadJob
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public Void preLoad(Map<String, Object> map, PreloadScheduler.PointType pointType) {
        try {
            com.alibaba.triver.container.a.a().a(((RVEnvironmentService) RVProxy.get(RVEnvironmentService.class)).getApplicationContext(), 5000L);
            return null;
        } catch (Exception unused) {
            return null;
        }
    }

    @Override // com.alibaba.triver.kit.api.preload.core.IPreloadJob
    public String getJobName() {
        return "process-preload";
    }

    @Override // com.alibaba.triver.kit.api.preload.core.IPreloadJob
    public Class<Void> getResultClazz() {
        return null;
    }
}
