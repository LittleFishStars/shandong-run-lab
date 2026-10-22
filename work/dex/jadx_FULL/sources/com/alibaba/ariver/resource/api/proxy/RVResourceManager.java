package com.alibaba.ariver.resource.api.proxy;

import androidx.annotation.Nullable;
import com.alibaba.ariver.kernel.common.Proxiable;
import com.alibaba.ariver.resource.api.PackageDownloadCallback;
import com.alibaba.ariver.resource.api.PackageInstallCallback;
import com.alibaba.ariver.resource.api.models.AppModel;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public interface RVResourceManager extends Proxiable {
    void deleteDownloadPackage(AppModel appModel);

    void deleteInstallStatus(String str);

    void downloadApp(AppModel appModel, boolean z, @Nullable PackageDownloadCallback packageDownloadCallback);

    String getInstallPath(AppModel appModel);

    @Nullable
    String getInstalledAppVersion(String str);

    void installApp(AppModel appModel, @Nullable PackageInstallCallback packageInstallCallback);

    boolean isAvailable(AppModel appModel);

    boolean isDownloaded(AppModel appModel);
}
