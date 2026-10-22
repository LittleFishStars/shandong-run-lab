package com.alibaba.triver.preload.b.a;

import com.alibaba.triver.kit.api.preload.annotation.AppxJob;
import com.alibaba.triver.kit.api.preload.core.IPreloadJob;
import com.alibaba.triver.kit.api.preload.core.PreloadScheduler;
import com.alibaba.triver.resource.e;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class b implements IPreloadJob<e> {
    @Override // com.alibaba.triver.kit.api.preload.core.IPreloadJob
    @AppxJob(true)
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public e preLoad(Map<String, Object> map, PreloadScheduler.PointType pointType) {
        return a.a();
    }

    @Override // com.alibaba.triver.kit.api.preload.core.IPreloadJob
    public String getJobName() {
        return "appx-preload";
    }

    @Override // com.alibaba.triver.kit.api.preload.core.IPreloadJob
    public Class<e> getResultClazz() {
        return e.class;
    }
}
