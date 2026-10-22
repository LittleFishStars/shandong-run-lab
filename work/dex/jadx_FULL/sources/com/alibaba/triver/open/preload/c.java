package com.alibaba.triver.open.preload;

import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.triver.kit.api.preload.annotation.RunningAfterAppxJob;
import com.alibaba.triver.kit.api.preload.core.PreloadScheduler;
import com.alibaba.triver.triver_render.render.WMLTRWebView;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class c extends com.alibaba.triver.preload.b.c.b {
    @Override // com.alibaba.triver.preload.b.c.b
    @RunningAfterAppxJob(true)
    public com.alibaba.triver.preload.b.c.c a(Map<String, Object> map, PreloadScheduler.PointType pointType) {
        com.alibaba.triver.preload.b.c.d dVarB;
        com.alibaba.triver.preload.b.c.c cVar = (com.alibaba.triver.preload.b.c.c) PreloadScheduler.getInstance().getReadyResult(-1L, com.alibaba.triver.preload.b.c.c.class);
        if (cVar != null) {
            return cVar;
        }
        RVLogger.e("WVRenderPreLoadJob preload start");
        if (!WMLTRWebView.k() || (dVarB = b()) == null) {
            RVLogger.e("WVRenderPreLoadJob preload uc failed");
            return null;
        }
        com.alibaba.triver.preload.b.c.c cVar2 = new com.alibaba.triver.preload.b.c.c(dVarB.a(), dVarB.b());
        cVar2.a(dVarB.c());
        b(System.currentTimeMillis());
        a(j(), this.b);
        return cVar2;
    }

    @Override // com.alibaba.triver.preload.b.c.b, com.alibaba.triver.preload.b.c.e
    @RunningAfterAppxJob(true)
    public /* synthetic */ com.alibaba.triver.preload.b.c.d b(Map map, PreloadScheduler.PointType pointType) {
        return a((Map<String, Object>) map, pointType);
    }

    @Override // com.alibaba.triver.preload.b.c.b, com.alibaba.triver.kit.api.preload.core.IPreloadJob
    public String getJobName() {
        return "wvrender-preload-open";
    }

    @Override // com.alibaba.triver.preload.b.c.b, com.alibaba.triver.preload.b.c.e, com.alibaba.triver.kit.api.preload.core.IPreloadJob
    @RunningAfterAppxJob(true)
    public /* synthetic */ com.alibaba.triver.preload.b.c.d preLoad(Map map, PreloadScheduler.PointType pointType) {
        return a((Map<String, Object>) map, pointType);
    }
}
