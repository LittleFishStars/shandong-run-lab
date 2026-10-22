package com.alibaba.ariver.resource.api;

import androidx.annotation.Nullable;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.service.executor.ExecutorType;
import com.alibaba.ariver.kernel.common.utils.ExecutorUtils;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.ariver.resource.api.models.AppModel;
import com.alibaba.ariver.resource.api.proxy.RVResourceManager;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class DownloadInstallCallback implements PackageDownloadCallback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f24416a = "AriverRes:DownloadInstallCallback";
    private boolean b;
    private boolean c;
    private PackageInstallCallback d;
    private AppModel e;

    public DownloadInstallCallback(AppModel appModel) {
        this(appModel, false, false, null);
    }

    @Override // com.alibaba.ariver.resource.api.PackageDownloadCallback
    public void onCancel(@Nullable String str) {
        RVLogger.d(f24416a, "onCancel, url: " + str);
    }

    @Override // com.alibaba.ariver.resource.api.PackageDownloadCallback
    public void onFailed(String str, int i, String str2) {
        RVLogger.d(f24416a, "onFinish, url: " + str + ", errorCode: " + i + ", errorMsg: " + str2);
        PackageInstallCallback packageInstallCallback = this.d;
        if (packageInstallCallback != null) {
            packageInstallCallback.onResult(false, null);
        }
    }

    @Override // com.alibaba.ariver.resource.api.PackageDownloadCallback
    public void onFinish(@Nullable String str) {
        final RVResourceManager rVResourceManager;
        RVLogger.d(f24416a, "onFinish, url: " + str);
        if (!this.b || (rVResourceManager = (RVResourceManager) RVProxy.get(RVResourceManager.class)) == null) {
            return;
        }
        ExecutorUtils.execute(this.c ? ExecutorType.URGENT_DISPLAY : ExecutorType.IO, new Runnable() { // from class: com.alibaba.ariver.resource.api.DownloadInstallCallback.1
            @Override // java.lang.Runnable
            public void run() {
                rVResourceManager.installApp(DownloadInstallCallback.this.e, DownloadInstallCallback.this.d);
            }
        });
    }

    @Override // com.alibaba.ariver.resource.api.PackageDownloadCallback
    public void onPrepare(@Nullable String str) {
    }

    @Override // com.alibaba.ariver.resource.api.PackageDownloadCallback
    public void onProgress(String str, int i) {
    }

    public DownloadInstallCallback(AppModel appModel, boolean z, boolean z2, @Nullable PackageInstallCallback packageInstallCallback) {
        this.e = appModel;
        this.b = z;
        this.c = z2;
        this.d = packageInstallCallback;
    }
}
