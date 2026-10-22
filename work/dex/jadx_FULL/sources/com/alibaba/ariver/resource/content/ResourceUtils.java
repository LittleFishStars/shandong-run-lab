package com.alibaba.ariver.resource.content;

import android.text.TextUtils;
import com.ali.auth.third.login.LoginConstants;
import com.alibaba.ariver.app.api.EntryInfo;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.service.executor.ExecutorType;
import com.alibaba.ariver.kernel.common.utils.ExecutorUtils;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.ariver.resource.api.DownloadInstallCallback;
import com.alibaba.ariver.resource.api.PackageInstallCallback;
import com.alibaba.ariver.resource.api.appinfo.AppUpdaterFactory;
import com.alibaba.ariver.resource.api.appinfo.IAppUpdater;
import com.alibaba.ariver.resource.api.appinfo.UpdateAppCallback;
import com.alibaba.ariver.resource.api.appinfo.UpdateAppException;
import com.alibaba.ariver.resource.api.appinfo.UpdateAppParam;
import com.alibaba.ariver.resource.api.content.ResourcePackage;
import com.alibaba.ariver.resource.api.models.AppInfoQuery;
import com.alibaba.ariver.resource.api.models.AppModel;
import com.alibaba.ariver.resource.api.prepare.UpdateMode;
import com.alibaba.ariver.resource.api.proxy.RVAppInfoManager;
import com.alibaba.ariver.resource.api.proxy.RVResourceManager;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class ResourceUtils {
    public static final String TAG = "AriverRes:ResourceUtils";

    public static void downloadAndInstallApp(final PackageInstallCallback packageInstallCallback, final AppModel appModel) {
        final RVResourceManager rVResourceManager = (RVResourceManager) RVProxy.get(RVResourceManager.class);
        if (rVResourceManager.isDownloaded(appModel)) {
            ExecutorUtils.execute(ExecutorType.NORMAL, new Runnable() { // from class: com.alibaba.ariver.resource.content.ResourceUtils.2
                @Override // java.lang.Runnable
                public void run() {
                    rVResourceManager.installApp(appModel, packageInstallCallback);
                }
            });
        } else {
            rVResourceManager.downloadApp(appModel, true, new DownloadInstallCallback(appModel, true, true, packageInstallCallback));
        }
    }

    public static EntryInfo getEntryInfo(AppModel appModel) {
        if (appModel == null || appModel.getAppInfoModel() == null) {
            return null;
        }
        EntryInfo entryInfo = new EntryInfo();
        entryInfo.title = appModel.getAppInfoModel().getName();
        entryInfo.iconUrl = appModel.getAppInfoModel().getLogo();
        entryInfo.slogan = appModel.getAppInfoModel().getDesc();
        entryInfo.isOffline = false;
        return entryInfo;
    }

    public static String getPkgStatus(ResourcePackage resourcePackage) {
        if (resourcePackage == null) {
            return "";
        }
        return resourcePackage.appId() + LoginConstants.UNDER_LINE + (resourcePackage.count() > 0 ? "Y" : "N") + LoginConstants.UNDER_LINE + resourcePackage.version();
    }

    public static void prepare(final String str, String str2, final PackageInstallCallback packageInstallCallback) {
        AppModel appModel = ((RVAppInfoManager) RVProxy.get(RVAppInfoManager.class)).getAppModel(AppInfoQuery.make(str).version(str2));
        if (appModel != null && !"*".equals(str2)) {
            downloadAndInstallApp(packageInstallCallback, appModel);
            return;
        }
        UpdateAppParam updateAppParam = new UpdateAppParam(str, "*");
        updateAppParam.setForce(true);
        updateAppParam.setUpdateMode(UpdateMode.SYNC_FORCE);
        IAppUpdater iAppUpdaterCreateUpdater = AppUpdaterFactory.createUpdater(str, null);
        if (iAppUpdaterCreateUpdater != null) {
            iAppUpdaterCreateUpdater.updateApp(updateAppParam, new UpdateAppCallback() { // from class: com.alibaba.ariver.resource.content.ResourceUtils.1
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
                    ResourceUtils.downloadAndInstallApp(packageInstallCallback, next);
                }
            });
            return;
        }
        RVLogger.e(TAG, "cannot find app updater for " + str + "!!!");
        if (packageInstallCallback != null) {
            packageInstallCallback.onResult(false, null);
        }
    }
}
