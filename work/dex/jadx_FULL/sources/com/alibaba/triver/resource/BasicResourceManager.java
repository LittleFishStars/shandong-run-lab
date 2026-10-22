package com.alibaba.triver.resource;

import android.app.Application;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.Nullable;
import androidx.camera.video.AudioStats;
import com.alibaba.ariver.app.api.monitor.RVMonitor;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.io.ZipUtils;
import com.alibaba.ariver.kernel.common.network.RVTransportService;
import com.alibaba.ariver.kernel.common.network.download.RVDownloadCallback;
import com.alibaba.ariver.kernel.common.network.download.RVDownloadRequest;
import com.alibaba.ariver.kernel.common.service.RVEnvironmentService;
import com.alibaba.ariver.kernel.common.utils.FileUtils;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.ariver.resource.api.PackageDownloadCallback;
import com.alibaba.ariver.resource.api.PackageInstallCallback;
import com.alibaba.ariver.resource.api.models.AppModel;
import com.alibaba.ariver.resource.api.models.PluginModel;
import com.alibaba.ariver.resource.api.proxy.RVResourceManager;
import com.alibaba.triver.kit.api.appmonitor.TriverLaunchPointer;
import com.alibaba.triver.kit.api.monitor.IPerformanceAndErrorTracker;
import com.alibaba.triver.kit.api.proxy.ITriverAppMonitorProxy;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class BasicResourceManager implements RVResourceManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f25148a = "ResourceManager";

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AppModel appModel) {
        String appVersion;
        String developerVersion;
        String templateId;
        String str = null;
        if (appModel != null) {
            try {
                String appId = appModel.getAppId();
                appVersion = appModel.getAppVersion();
                developerVersion = appModel.getAppInfoModel().getDeveloperVersion();
                templateId = appModel.getAppInfoModel().getTemplateConfig() != null ? appModel.getAppInfoModel().getTemplateConfig().getTemplateId() : null;
                str = appId;
            } catch (Exception e) {
                RVLogger.w(f25148a, e.getMessage());
                return;
            }
        } else {
            templateId = null;
            appVersion = null;
            developerVersion = null;
        }
        ((ITriverAppMonitorProxy) RVProxy.get(ITriverAppMonitorProxy.class)).commitTriverLaunch(TriverLaunchPointer.build().setAppId(str).setVersion(appVersion).setDeveloperVersion(developerVersion).setTemplateId(templateId).setStage("package").setStatus(Double.valueOf(AudioStats.AUDIO_AMPLITUDE_NONE)).create());
    }

    @Override // com.alibaba.ariver.resource.api.proxy.RVResourceManager
    public void deleteDownloadPackage(AppModel appModel) {
        if (appModel == null) {
            return;
        }
        Application applicationContext = ((RVEnvironmentService) RVProxy.get(RVEnvironmentService.class)).getApplicationContext();
        com.alibaba.triver.utils.d.a(applicationContext, appModel.getAppInfoModel().getPackageUrl());
        if (appModel.getAppInfoModel() != null && appModel.getAppInfoModel().getPlugins() != null) {
            List<PluginModel> plugins = appModel.getAppInfoModel().getPlugins();
            for (int i = 0; i < plugins.size(); i++) {
                FileUtils.delete(new File(com.alibaba.triver.utils.d.b(applicationContext), com.alibaba.triver.utils.d.c(plugins.get(i).getPackageUrl())));
                RVLogger.d(RVLogger.makeLogTag(com.alibaba.triver.utils.d.f25269a), "deleteDownloadPackage plugin :" + plugins.get(i).getAppId());
            }
        }
        RVLogger.d(RVLogger.makeLogTag(com.alibaba.triver.utils.d.f25269a), "deleteDownloadPackage main res :" + appModel.getAppId());
    }

    @Override // com.alibaba.ariver.resource.api.proxy.RVResourceManager
    public void deleteInstallStatus(String str) {
    }

    @Override // com.alibaba.ariver.resource.api.proxy.RVResourceManager
    public void downloadApp(final AppModel appModel, boolean z, @Nullable final PackageDownloadCallback packageDownloadCallback) {
        ((RVMonitor) RVProxy.get(RVMonitor.class)).flowLog("START_DOWNLOAD_APP", "http", "Package", appModel.getAppId(), null, null);
        if (packageDownloadCallback == null || appModel.getAppInfoModel() == null) {
            return;
        }
        ((IPerformanceAndErrorTracker) RVProxy.get(IPerformanceAndErrorTracker.class)).sendPerfStageLog("Download", "Start http download app, url = " + appModel.getAppInfoModel().getPackageUrl());
        int i = 3;
        while (true) {
            i--;
            if (i < 0) {
                ((RVMonitor) RVProxy.get(RVMonitor.class)).flowLog("DOWNLOAD_APP_FAILED", "three times over", "Package", appModel.getAppId(), null, null);
                packageDownloadCallback.onFailed(appModel.getAppInfoModel().getPackageUrl(), 1, "three times over");
                g.a(appModel, false, false, "");
                a(appModel);
                return;
            }
            RVTransportService rVTransportService = (RVTransportService) RVProxy.get(RVTransportService.class);
            RVDownloadRequest rVDownloadRequest = new RVDownloadRequest();
            rVDownloadRequest.setDownloadUrl(appModel.getAppInfoModel().getPackageUrl());
            rVDownloadRequest.setDownloadDir(com.alibaba.triver.utils.d.a(((RVEnvironmentService) RVProxy.get(RVEnvironmentService.class)).getApplicationContext()));
            try {
                RVLogger.d(RVLogger.makeLogTag(com.alibaba.triver.utils.d.f25269a), "download basic resource the " + (3 - i) + " time(s).");
                rVTransportService.addDownload(rVDownloadRequest, new RVDownloadCallback() { // from class: com.alibaba.triver.resource.BasicResourceManager.1
                    @Override // com.alibaba.ariver.kernel.common.network.download.RVDownloadCallback
                    public void onCancel(String str) {
                        if (packageDownloadCallback != null) {
                            ((RVMonitor) RVProxy.get(RVMonitor.class)).flowLog("DOWNLOAD_APP_FAILED", "cancel", str, appModel.getAppId(), null, null);
                            packageDownloadCallback.onFailed(appModel.getAppInfoModel().getPackageUrl(), 0, str);
                            g.a(appModel, false, false, "");
                            BasicResourceManager.this.a(appModel);
                        }
                    }

                    @Override // com.alibaba.ariver.kernel.common.network.download.RVDownloadCallback
                    public void onFailed(String str, int i2, String str2) {
                        if (packageDownloadCallback != null) {
                            ((RVMonitor) RVProxy.get(RVMonitor.class)).flowLog("DOWNLOAD_APP_FAILED", String.valueOf(i2), str2, appModel.getAppId(), null, null);
                            packageDownloadCallback.onFailed(appModel.getAppInfoModel().getPackageUrl(), i2, str2);
                            g.a(appModel, false, false, "");
                            BasicResourceManager.this.a(appModel);
                        }
                    }

                    @Override // com.alibaba.ariver.kernel.common.network.download.RVDownloadCallback
                    public void onFinish(@Nullable String str) throws Throwable {
                        FileInputStream fileInputStream;
                        File file = new File(str);
                        try {
                            fileInputStream = new FileInputStream(file);
                        } catch (FileNotFoundException e) {
                            e.printStackTrace();
                            fileInputStream = null;
                        }
                        if (fileInputStream == null) {
                            RVLogger.e(BasicResourceManager.f25148a, "download error");
                            return;
                        }
                        String strA = com.alibaba.triver.utils.d.a(appModel.getAppInfoModel().getPackageUrl());
                        ZipUtils.unZip(fileInputStream, strA);
                        if (packageDownloadCallback != null) {
                            ((RVMonitor) RVProxy.get(RVMonitor.class)).flowLog("DOWNLOAD_APP_SUCCESS", "http", "Package", appModel.getAppId(), null, null);
                            packageDownloadCallback.onFinish(strA);
                            g.a(appModel, true, false, "");
                        }
                        file.deleteOnExit();
                    }

                    @Override // com.alibaba.ariver.kernel.common.network.download.RVDownloadCallback
                    public void onPrepare(String str) {
                    }

                    @Override // com.alibaba.ariver.kernel.common.network.download.RVDownloadCallback
                    public void onProgress(String str, int i2) {
                    }
                });
                ((IPerformanceAndErrorTracker) RVProxy.get(IPerformanceAndErrorTracker.class)).sendPerfStageLog("Download", "End http download app");
                return;
            } catch (Throwable th) {
                try {
                    RVLogger.w(Log.getStackTraceString(th));
                    RVLogger.e(f25148a, "io is wrong");
                    ((IPerformanceAndErrorTracker) RVProxy.get(IPerformanceAndErrorTracker.class)).sendPerfStageLog("Download", "End http download app");
                } catch (Throwable th2) {
                    ((IPerformanceAndErrorTracker) RVProxy.get(IPerformanceAndErrorTracker.class)).sendPerfStageLog("Download", "End http download app");
                    throw th2;
                }
            }
        }
    }

    @Override // com.alibaba.ariver.resource.api.proxy.RVResourceManager
    public String getInstallPath(AppModel appModel) {
        return com.alibaba.triver.utils.d.a(appModel.getAppInfoModel().getPackageUrl());
    }

    @Override // com.alibaba.ariver.resource.api.proxy.RVResourceManager
    @Nullable
    public String getInstalledAppVersion(String str) {
        return null;
    }

    @Override // com.alibaba.ariver.resource.api.proxy.RVResourceManager
    public void installApp(AppModel appModel, @Nullable PackageInstallCallback packageInstallCallback) {
        if (appModel == null || appModel.getAppInfoModel() == null || TextUtils.isEmpty(appModel.getAppInfoModel().getPackageUrl())) {
            if (packageInstallCallback != null) {
                packageInstallCallback.onResult(false, "cannot get packageUrl");
                ((RVMonitor) RVProxy.get(RVMonitor.class)).flowLog("INSTALL_APP_FAILED", "use http cannot get packageUrl", "Package", appModel.getAppId(), null, null);
                a(appModel);
                return;
            }
            return;
        }
        if (packageInstallCallback != null) {
            File file = new File(com.alibaba.triver.utils.d.a(((RVEnvironmentService) RVProxy.get(RVEnvironmentService.class)).getApplicationContext()), com.alibaba.triver.utils.d.c(appModel.getAppInfoModel().getPackageUrl()));
            if (file.exists()) {
                ((RVMonitor) RVProxy.get(RVMonitor.class)).flowLog("INSTALL_APP_SUCCESS", "use http", "Package", appModel.getAppId(), null, null);
            } else {
                ((RVMonitor) RVProxy.get(RVMonitor.class)).flowLog("INSTALL_APP_FAILED", "use http", "Package", appModel.getAppId(), null, null);
                a(appModel);
            }
            packageInstallCallback.onResult(file.exists(), file.getAbsolutePath());
        }
    }

    @Override // com.alibaba.ariver.resource.api.proxy.RVResourceManager
    public boolean isAvailable(AppModel appModel) {
        if (appModel == null || appModel.getAppInfoModel() == null || TextUtils.isEmpty(appModel.getAppInfoModel().getPackageUrl())) {
            return false;
        }
        return new File(com.alibaba.triver.utils.d.a(((RVEnvironmentService) RVProxy.get(RVEnvironmentService.class)).getApplicationContext()), com.alibaba.triver.utils.d.c(appModel.getAppInfoModel().getPackageUrl())).exists();
    }

    @Override // com.alibaba.ariver.resource.api.proxy.RVResourceManager
    public boolean isDownloaded(AppModel appModel) {
        return isAvailable(appModel);
    }
}
