package com.alibaba.triver.preload.b.a;

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
import com.alibaba.triver.utils.CommonUtils;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class a {
    public static e a() {
        RVAppInfoManager rVAppInfoManager;
        AppModel appModel;
        try {
            if (CommonUtils.closeAppxPreload() || (rVAppInfoManager = (RVAppInfoManager) RVProxy.get(RVAppInfoManager.class)) == null || (appModel = rVAppInfoManager.getAppModel(AppInfoQuery.make(RVConstants.TINY_WEB_COMMON_APPID).version("*"))) == null) {
                return null;
            }
            ResourcePackage eVar = GlobalPackagePool.getInstance().getPackage(RVConstants.TINY_WEB_COMMON_APPID);
            if (!(eVar instanceof e)) {
                eVar = new e(new ResourceContext());
                GlobalPackagePool.getInstance().add(eVar);
            }
            if (((e) eVar).getAppModel() != null) {
                Triver.currentAppxModel = appModel;
                RVLogger.d("CurrentAppx", "current Appx version is " + appModel.getAppVersion());
            }
            return (e) eVar;
        } catch (Exception e) {
            RVLogger.e("AppxLoadUtils", "loadAppx2Global error", e);
            return null;
        }
    }

    public static e b() {
        ResourcePackage resourcePackage = GlobalPackagePool.getInstance().getPackage(RVConstants.TINY_WEB_COMMON_APPID);
        if (resourcePackage instanceof e) {
            return (e) resourcePackage;
        }
        return null;
    }

    public static AppModel c() {
        ResourcePackage resourcePackage = GlobalPackagePool.getInstance().getPackage(RVConstants.TINY_WEB_COMMON_APPID);
        if (resourcePackage instanceof e) {
            return ((e) resourcePackage).getAppModel();
        }
        return null;
    }
}
