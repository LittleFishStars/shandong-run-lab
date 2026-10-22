package com.alibaba.triver.preload.b.c;

import android.app.Application;
import android.util.Log;
import com.alibaba.ariver.engine.api.resources.Resource;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.service.RVEnvironmentService;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.ariver.resource.api.content.ResourceQuery;
import com.alibaba.ariver.resource.content.AppxResourcePackage;
import com.alibaba.triver.kit.api.orange.TROrangeController;
import com.alibaba.triver.kit.api.preload.annotation.RunningAfterAppxJob;
import com.alibaba.triver.kit.api.preload.core.PreloadScheduler;
import com.alibaba.triver.kit.api.utils.NativeSwitchController;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class b extends e {
    @RunningAfterAppxJob(true)
    public c a(Map<String, Object> map, PreloadScheduler.PointType pointType) {
        StringBuilder sb = new StringBuilder();
        sb.append("RenderPreload_");
        int i = e.f25128a;
        e.f25128a = i + 1;
        sb.append(i);
        this.b = sb.toString();
        try {
            if (NativeSwitchController.isEnableNative() && !NativeSwitchController.enableRenderPreload()) {
                Log.e("Render", "render preload native switch is disable");
                return null;
            }
        } catch (Throwable th) {
            RVLogger.e("Render预启失败：" + th.getMessage());
        }
        if ((!f() && !TROrangeController.subProcessEnableRenderWorkerPreload()) || !TROrangeController.enableBasicRenderPreload()) {
            return null;
        }
        com.alibaba.triver.trace.b.a(com.alibaba.triver.trace.c.b, com.alibaba.triver.trace.c.q, this.b, null);
        a(System.currentTimeMillis());
        d dVarB = super.b(map, pointType);
        if (dVarB == null) {
            return null;
        }
        c cVar = new c(dVarB.a(), dVarB.b());
        cVar.a(dVarB.c());
        cVar.b(dVarB.g());
        b(System.currentTimeMillis());
        a(j(), this.b);
        return cVar;
    }

    @Override // com.alibaba.triver.preload.b.c.e
    public String a() {
        return "BasicRender";
    }

    @Override // com.alibaba.triver.preload.b.c.e
    @RunningAfterAppxJob(true)
    public /* synthetic */ d b(Map map, PreloadScheduler.PointType pointType) {
        return a((Map<String, Object>) map, pointType);
    }

    @Override // com.alibaba.triver.kit.api.preload.core.IPreloadJob
    public String getJobName() {
        return "BasicMiniAppRenderPreloadJob";
    }

    @Override // com.alibaba.triver.preload.b.c.e, com.alibaba.triver.kit.api.preload.core.IPreloadJob
    @RunningAfterAppxJob(true)
    public /* synthetic */ d preLoad(Map map, PreloadScheduler.PointType pointType) {
        return a((Map<String, Object>) map, pointType);
    }

    @Override // com.alibaba.triver.preload.b.c.e
    public InputStream a(String str, AppxResourcePackage appxResourcePackage) {
        Resource resource = appxResourcePackage != null ? appxResourcePackage.get(new ResourceQuery(str)) : null;
        InputStream stream = resource != null ? resource.getStream() : null;
        Application applicationContext = ((RVEnvironmentService) RVProxy.get(RVEnvironmentService.class)).getApplicationContext();
        if (stream != null || applicationContext == null) {
            return stream;
        }
        try {
            return applicationContext.getResources().getAssets().open("af-appx.min.js");
        } catch (IOException e) {
            e.printStackTrace();
            return stream;
        }
    }
}
