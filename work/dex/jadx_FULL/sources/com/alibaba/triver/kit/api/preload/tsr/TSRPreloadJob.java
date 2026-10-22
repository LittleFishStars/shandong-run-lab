package com.alibaba.triver.kit.api.preload.tsr;

import com.alibaba.ariver.app.api.activity.StartClientBundle;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.triver.kit.api.preload.core.IPreloadJob;
import com.alibaba.triver.kit.api.preload.core.PreloadScheduler;
import java.io.Serializable;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class TSRPreloadJob implements IPreloadJob<TSRResource>, Serializable {
    private static final String ORI_URL_KEY = "ori_url";

    private String getLaunchUrl(Map<String, Object> map) {
        return ((StartClientBundle) map.get("startParamsBundle")).startParams.getString("ori_url");
    }

    @Override // com.alibaba.triver.kit.api.preload.core.IPreloadJob
    public String getJobName() {
        return "TSRPreloadJob";
    }

    @Override // com.alibaba.triver.kit.api.preload.core.IPreloadJob
    public Class<TSRResource> getResultClazz() {
        return TSRResource.class;
    }

    @Override // com.alibaba.triver.kit.api.preload.core.IPreloadJob
    public /* bridge */ /* synthetic */ TSRResource preLoad(Map map, PreloadScheduler.PointType pointType) {
        return preLoad((Map<String, Object>) map, pointType);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.alibaba.triver.kit.api.preload.core.IPreloadJob
    public final TSRResource preLoad(Map<String, Object> map, PreloadScheduler.PointType pointType) {
        PreloadScheduler.getInstance().getAndRemoveReadyResult(-1L, TSRResource.class);
        ITSRProxy iTSRProxy = (ITSRProxy) RVProxy.get(ITSRProxy.class);
        return new TSRResource(iTSRProxy != null ? iTSRProxy.getTemplateSnapshotData(map, getLaunchUrl(map)) : "");
    }
}
