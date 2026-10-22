package com.alibaba.triver.preload.b.d;

import com.alibaba.ariver.kernel.api.annotation.ThreadType;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.service.executor.ExecutorType;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.triver.kit.api.common.TRiverConstants;
import com.alibaba.triver.kit.api.orange.TROrangeController;
import com.alibaba.triver.kit.api.preload.core.IPreloadJob;
import com.alibaba.triver.kit.api.preload.core.PreloadScheduler;
import com.alibaba.triver.kit.api.proxy.IZCacheProxy;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class a implements IPreloadJob<Object> {
    @Override // com.alibaba.triver.kit.api.preload.core.IPreloadJob
    public String getJobName() {
        return "AppPackagePreloadJob";
    }

    @Override // com.alibaba.triver.kit.api.preload.core.IPreloadJob
    public Class<Object> getResultClazz() {
        return null;
    }

    @Override // com.alibaba.triver.kit.api.preload.core.IPreloadJob
    @ThreadType(ExecutorType.NORMAL)
    public Object preLoad(Map<String, Object> map, PreloadScheduler.PointType pointType) {
        JSONArray pkgPreloadList;
        try {
            if (TROrangeController.enablePkgPreload() && PreloadScheduler.PointType.PROCESS_CREATE.equals(pointType) && (pkgPreloadList = TROrangeController.getPkgPreloadList()) != null && pkgPreloadList.size() > 0) {
                for (Object obj : pkgPreloadList) {
                    if (obj instanceof String) {
                        ((IZCacheProxy) RVProxy.get(IZCacheProxy.class)).updatePackRemote(String.valueOf(obj), null, 6);
                    }
                }
            }
        } catch (Throwable th) {
            RVLogger.e(TRiverConstants.TAG, "preload resource: ", th);
        }
        return null;
    }
}
