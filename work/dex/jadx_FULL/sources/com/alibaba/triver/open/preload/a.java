package com.alibaba.triver.open.preload;

import com.alibaba.ariver.kernel.RVConstants;
import com.alibaba.ariver.resource.api.ResourceContext;
import com.alibaba.ariver.resource.api.content.ResourcePackage;
import com.alibaba.ariver.resource.content.GlobalPackagePool;
import com.alibaba.triver.kit.api.preload.annotation.AppxJob;
import com.alibaba.triver.kit.api.preload.core.IPreloadJob;
import com.alibaba.triver.kit.api.preload.core.PreloadScheduler;
import com.alibaba.triver.resource.e;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class a implements IPreloadJob<e> {
    @Override // com.alibaba.triver.kit.api.preload.core.IPreloadJob
    @AppxJob(true)
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public e preLoad(Map<String, Object> map, PreloadScheduler.PointType pointType) {
        ResourcePackage eVar = GlobalPackagePool.getInstance().getPackage(RVConstants.TINY_WEB_COMMON_APPID);
        if (!(eVar instanceof e)) {
            eVar = new e(new ResourceContext());
            GlobalPackagePool.getInstance().add(eVar);
        }
        return (e) eVar;
    }

    @Override // com.alibaba.triver.kit.api.preload.core.IPreloadJob
    public String getJobName() {
        return "appx-preload-open";
    }

    @Override // com.alibaba.triver.kit.api.preload.core.IPreloadJob
    public Class<e> getResultClazz() {
        return e.class;
    }
}
