package com.alibaba.triver.resource;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.Nullable;
import com.alibaba.ariver.app.api.monitor.RVMonitor;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.io.ZipUtils;
import com.alibaba.ariver.kernel.common.network.RVTransportService;
import com.alibaba.ariver.kernel.common.network.download.RVDownloadCallback;
import com.alibaba.ariver.kernel.common.network.download.RVDownloadRequest;
import com.alibaba.ariver.kernel.common.service.RVEnvironmentService;
import com.alibaba.ariver.kernel.common.service.executor.ExecutorType;
import com.alibaba.ariver.kernel.common.service.executor.RVExecutorService;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.ariver.resource.api.models.PluginModel;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class BasicPluginResourceDelegateImpl implements PluginResourceDelegate {
    @Override // com.alibaba.triver.resource.PluginResourceDelegate
    public String downloadApp(final PluginModel pluginModel) {
        if (pluginModel == null) {
            return "";
        }
        int i = 3;
        while (true) {
            i--;
            if (i < 0) {
                return "";
            }
            RVTransportService rVTransportService = (RVTransportService) RVProxy.get(RVTransportService.class);
            RVDownloadRequest rVDownloadRequest = new RVDownloadRequest();
            rVDownloadRequest.setDownloadUrl(pluginModel.getPackageUrl());
            rVDownloadRequest.setDownloadDir(com.alibaba.triver.utils.d.a(((RVEnvironmentService) RVProxy.get(RVEnvironmentService.class)).getApplicationContext()));
            try {
                final CountDownLatch countDownLatch = new CountDownLatch(1);
                final HashMap map = new HashMap();
                RVLogger.d(RVLogger.makeLogTag(com.alibaba.triver.utils.d.f25269a), "plugin download resource the " + (3 - i) + " time(s).");
                rVTransportService.addDownload(rVDownloadRequest, new RVDownloadCallback() { // from class: com.alibaba.triver.resource.BasicPluginResourceDelegateImpl.1
                    @Override // com.alibaba.ariver.kernel.common.network.download.RVDownloadCallback
                    public void onCancel(String str) {
                        ((RVMonitor) RVProxy.get(RVMonitor.class)).flowLog("DOWNLOAD_PLUGIN_CANCELED", "0", str, pluginModel.getAppId(), null, null);
                        countDownLatch.countDown();
                    }

                    @Override // com.alibaba.ariver.kernel.common.network.download.RVDownloadCallback
                    public void onFailed(String str, int i2, String str2) {
                        ((RVMonitor) RVProxy.get(RVMonitor.class)).flowLog("DOWNLOAD_PLUGIN_FAILED", String.valueOf(i2), str2, pluginModel.getAppId(), null, null);
                        countDownLatch.countDown();
                    }

                    @Override // com.alibaba.ariver.kernel.common.network.download.RVDownloadCallback
                    public void onFinish(@Nullable String str) {
                        countDownLatch.countDown();
                        map.put(pluginModel.getAppId(), str);
                    }

                    @Override // com.alibaba.ariver.kernel.common.network.download.RVDownloadCallback
                    public void onPrepare(String str) {
                    }

                    @Override // com.alibaba.ariver.kernel.common.network.download.RVDownloadCallback
                    public void onProgress(String str, int i2) {
                    }
                });
                countDownLatch.await(15000L, TimeUnit.MILLISECONDS);
                String str = (String) map.get(pluginModel.getAppId());
                if (!TextUtils.isEmpty(str)) {
                    File file = new File(str);
                    FileInputStream fileInputStream = new FileInputStream(file);
                    String strB = com.alibaba.triver.utils.d.b(pluginModel.getPackageUrl());
                    ZipUtils.unZip(fileInputStream, strB);
                    file.deleteOnExit();
                    return strB;
                }
                RVLogger.e(RVLogger.makeLogTag(com.alibaba.triver.utils.d.f25269a), "download error");
            } catch (IOException e) {
                RVLogger.w(Log.getStackTraceString(e));
                RVLogger.e(RVLogger.makeLogTag(com.alibaba.triver.utils.d.f25269a), "io is wrong");
            } catch (InterruptedException e2) {
                RVLogger.w(Log.getStackTraceString(e2));
                RVLogger.e(RVLogger.makeLogTag(com.alibaba.triver.utils.d.f25269a), "io is wrong");
            } catch (Throwable th) {
                RVLogger.w(Log.getStackTraceString(th));
                RVLogger.e(RVLogger.makeLogTag(com.alibaba.triver.utils.d.f25269a), "io is wrong");
            }
        }
    }

    @Override // com.alibaba.triver.resource.PluginResourceDelegate
    public String downloadAppAsync(final PluginModel pluginModel, final c cVar) {
        ((RVExecutorService) RVProxy.get(RVExecutorService.class)).getExecutor(ExecutorType.URGENT_DISPLAY).execute(new Runnable() { // from class: com.alibaba.triver.resource.BasicPluginResourceDelegateImpl.2
            @Override // java.lang.Runnable
            public void run() {
                if (TextUtils.isEmpty(BasicPluginResourceDelegateImpl.this.downloadApp(pluginModel))) {
                    cVar.a(pluginModel, 1, "basic download failed");
                    g.a(pluginModel, false, false, "", "", g.f);
                } else {
                    cVar.a(pluginModel);
                    g.a(pluginModel, true, false, "", "", "");
                }
            }
        });
        return null;
    }

    @Override // com.alibaba.triver.resource.PluginResourceDelegate
    public String getInstallPath(PluginModel pluginModel) {
        if (pluginModel == null || TextUtils.isEmpty(pluginModel.getPackageUrl())) {
            return null;
        }
        return new File(com.alibaba.triver.utils.d.b(((RVEnvironmentService) RVProxy.get(RVEnvironmentService.class)).getApplicationContext()), com.alibaba.triver.utils.d.c(pluginModel.getPackageUrl())).getAbsolutePath();
    }

    @Override // com.alibaba.triver.resource.PluginResourceDelegate
    public boolean isAvailable(PluginModel pluginModel) {
        if (pluginModel == null || TextUtils.isEmpty(pluginModel.getPackageUrl())) {
            return false;
        }
        return new File(com.alibaba.triver.utils.d.b(((RVEnvironmentService) RVProxy.get(RVEnvironmentService.class)).getApplicationContext()), com.alibaba.triver.utils.d.c(pluginModel.getPackageUrl())).exists();
    }
}
