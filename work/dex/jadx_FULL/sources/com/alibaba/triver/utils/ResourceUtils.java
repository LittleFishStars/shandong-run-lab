package com.alibaba.triver.utils;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.utils.IOUtils;
import com.alibaba.ariver.kernel.common.utils.ImageUtil;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.ariver.resource.api.DownloadInstallCallback;
import com.alibaba.ariver.resource.api.PackageInstallCallback;
import com.alibaba.ariver.resource.api.appinfo.AppUpdaterFactory;
import com.alibaba.ariver.resource.api.appinfo.IAppUpdater;
import com.alibaba.ariver.resource.api.appinfo.UpdateAppCallback;
import com.alibaba.ariver.resource.api.appinfo.UpdateAppException;
import com.alibaba.ariver.resource.api.appinfo.UpdateAppParam;
import com.alibaba.ariver.resource.api.models.AppInfoQuery;
import com.alibaba.ariver.resource.api.models.AppModel;
import com.alibaba.ariver.resource.api.prepare.UpdateMode;
import com.alibaba.ariver.resource.api.proxy.RVAppInfoManager;
import com.alibaba.ariver.resource.api.proxy.RVResourceManager;
import com.alibaba.fastjson.JSON;
import java.io.InputStream;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class ResourceUtils {

    public enum ResourceType {
        ONLINE,
        BASE64,
        INTERNAL
    }

    public static InputStream b(Context context, String str) {
        return context.getAssets().open(str);
    }

    public static ResourceType a(@NonNull String str, String str2) {
        if (str.startsWith(str2)) {
            return ResourceType.INTERNAL;
        }
        if (str.startsWith("https:") || str.startsWith("http:")) {
            return ResourceType.ONLINE;
        }
        return ImageUtil.isBase64Url(str) ? ResourceType.BASE64 : ResourceType.INTERNAL;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(PackageInstallCallback packageInstallCallback, AppModel appModel) {
        RVResourceManager rVResourceManager = (RVResourceManager) RVProxy.get(RVResourceManager.class);
        if (rVResourceManager.isAvailable(appModel)) {
            return;
        }
        rVResourceManager.downloadApp(appModel, true, new DownloadInstallCallback(appModel, true, true, packageInstallCallback));
    }

    public static AppModel a(Context context, String str) {
        return (AppModel) JSON.parseObject(IOUtils.readAsset(context.getResources(), str), AppModel.class);
    }

    public static void a(final String str, String str2, boolean z, Bundle bundle, final PackageInstallCallback packageInstallCallback) {
        AppInfoQuery appInfoQueryDisableCache;
        RVAppInfoManager rVAppInfoManager = (RVAppInfoManager) RVProxy.get(RVAppInfoManager.class);
        if (z) {
            appInfoQueryDisableCache = AppInfoQuery.make(str).version(str2);
        } else {
            appInfoQueryDisableCache = AppInfoQuery.make(str).version(str2).disableCache();
        }
        AppModel appModel = rVAppInfoManager.getAppModel(appInfoQueryDisableCache);
        if (appModel == null) {
            UpdateAppParam updateAppParam = new UpdateAppParam(str, "*");
            updateAppParam.setForce(true);
            updateAppParam.setExtras(bundle);
            updateAppParam.setUpdateMode(UpdateMode.SYNC_FORCE);
            IAppUpdater iAppUpdaterCreateUpdater = AppUpdaterFactory.createUpdater(str, null);
            if (iAppUpdaterCreateUpdater == null) {
                RVLogger.e(com.alibaba.ariver.resource.content.ResourceUtils.TAG, "cannot find app updater for " + str + "!!!");
                if (packageInstallCallback != null) {
                    packageInstallCallback.onResult(false, null);
                    return;
                }
                return;
            }
            iAppUpdaterCreateUpdater.updateApp(updateAppParam, new UpdateAppCallback() { // from class: com.alibaba.triver.utils.ResourceUtils.1
                @Override // com.alibaba.ariver.resource.api.appinfo.UpdateAppCallback
                public void onError(UpdateAppException updateAppException) {
                    packageInstallCallback.onResult(false, updateAppException.getMessage());
                }

                @Override // com.alibaba.ariver.resource.api.appinfo.UpdateAppCallback
                public void onSuccess(List<AppModel> list) {
                    AppModel next;
                    if (list == null) {
                        next = null;
                        break;
                    }
                    Iterator<AppModel> it = list.iterator();
                    do {
                        if (!it.hasNext()) {
                            next = null;
                            break;
                        }
                        next = it.next();
                    } while (!TextUtils.equals(str, next.getAppId()));
                    if (next == null) {
                        packageInstallCallback.onResult(false, "update no appInfo!");
                    }
                    ResourceUtils.b(packageInstallCallback, next);
                }
            });
            return;
        }
        b(packageInstallCallback, appModel);
    }
}
