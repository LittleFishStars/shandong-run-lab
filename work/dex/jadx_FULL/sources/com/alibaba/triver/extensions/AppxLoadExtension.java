package com.alibaba.triver.extensions;

import android.os.Bundle;
import android.text.TextUtils;
import com.alibaba.ariver.app.api.AppLoadResult;
import com.alibaba.ariver.app.api.point.app.AppLoadInterceptorPoint;
import com.alibaba.ariver.integration.RVMain;
import com.alibaba.ariver.kernel.RVConstants;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.ariver.resource.api.ResourceContext;
import com.alibaba.ariver.resource.api.content.ResourcePackage;
import com.alibaba.ariver.resource.api.models.AppInfoQuery;
import com.alibaba.ariver.resource.api.models.AppModel;
import com.alibaba.ariver.resource.api.proxy.RVAppInfoManager;
import com.alibaba.ariver.resource.content.GlobalPackagePool;
import com.alibaba.triver.Triver;
import com.alibaba.triver.resource.e;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class AppxLoadExtension implements AppLoadInterceptorPoint {
    @Override // com.alibaba.ariver.app.api.point.app.AppLoadInterceptorPoint
    public void intercept(String str, Bundle bundle, Bundle bundle2, AppLoadResult appLoadResult) {
        AppModel appModel;
        ResourcePackage eVar = GlobalPackagePool.getInstance().getPackage(RVConstants.TINY_WEB_COMMON_APPID);
        if (eVar instanceof e) {
            AppModel appModel2 = ((RVAppInfoManager) RVProxy.get(RVAppInfoManager.class)).getAppModel(new AppInfoQuery(RVConstants.TINY_WEB_COMMON_APPID));
            if (appModel2 != null && (appModel = ((e) eVar).getAppModel()) != null && !TextUtils.equals(appModel.getAppVersion(), appModel2.getAppVersion()) && RVMain.getAppRecords() != null && RVMain.getAppRecords().size() <= 1) {
                eVar = new e(new ResourceContext());
                GlobalPackagePool.getInstance().add(eVar);
            }
        } else {
            eVar = new e(new ResourceContext());
            GlobalPackagePool.getInstance().add(eVar);
        }
        try {
            AppModel appModel3 = ((e) eVar).getAppModel();
            if (appModel3 != null) {
                Triver.currentAppxModel = appModel3;
                RVLogger.d("CurrentAppx", "current Appx version is " + appModel3.getAppVersion());
            }
        } catch (Exception e) {
            RVLogger.e("AppxLoadExtension", "getAppxVersion error", e);
        }
    }

    @Override // com.alibaba.ariver.kernel.api.extension.Extension
    public void onFinalized() {
    }

    @Override // com.alibaba.ariver.kernel.api.extension.Extension
    public void onInitialized() {
    }
}
