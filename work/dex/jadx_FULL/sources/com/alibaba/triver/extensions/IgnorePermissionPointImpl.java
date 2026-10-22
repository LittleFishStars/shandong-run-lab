package com.alibaba.triver.extensions;

import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.service.RVConfigService;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.ariver.permission.api.extension.IgnorePermissionPoint;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class IgnorePermissionPointImpl implements IgnorePermissionPoint {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static String f24950a = "AriverPermission:" + IgnorePermissionPointImpl.class.getSimpleName();

    @Override // com.alibaba.ariver.permission.api.extension.IgnorePermissionPoint
    public boolean ignoreAppPermission(String str) {
        if (!((RVConfigService) RVProxy.get(RVConfigService.class)).getConfigBoolean("h5_jsapi_permission", false)) {
            return false;
        }
        RVLogger.d(f24950a, "accessor" + str + " debug app permission check switch is close");
        return true;
    }

    @Override // com.alibaba.ariver.kernel.api.extension.Extension
    public void onFinalized() {
    }

    @Override // com.alibaba.ariver.kernel.api.extension.Extension
    public void onInitialized() {
    }
}
