package com.alibaba.triver.resource;

import android.util.Log;
import android.util.Pair;
import androidx.annotation.Nullable;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.ariver.resource.api.PluginDownloadCallback;
import com.alibaba.ariver.resource.api.PluginInstallCallback;
import com.alibaba.ariver.resource.api.models.PluginModel;
import com.alibaba.ariver.resource.api.proxy.RVPluginResourceManager;
import com.alibaba.triver.appinfo.core.PluginInfoCenter;
import com.alibaba.triver.kit.api.monitor.IPerformanceAndErrorTracker;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class BasicPluginResourceManager implements RVPluginResourceManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f25146a = "AriverTriver:PluginInfoCenter";
    private PluginResourceDelegate b;

    public BasicPluginResourceManager(PluginResourceDelegate pluginResourceDelegate) {
        this.b = pluginResourceDelegate;
    }

    @Override // com.alibaba.ariver.resource.api.proxy.RVPluginResourceManager
    public void downloadPlugins(List<PluginModel> list, final PluginDownloadCallback pluginDownloadCallback) {
        if (this.b == null) {
            RVLogger.e(RVLogger.makeLogTag(com.alibaba.triver.utils.d.f25269a), "delegate is null");
            pluginDownloadCallback.onFailed(3, "inner error");
            return;
        }
        if (list.size() == 0) {
            RVLogger.e(RVLogger.makeLogTag(com.alibaba.triver.utils.d.f25269a), "downloadApp but no plugin model.");
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < list.size(); i++) {
            if (!this.b.isAvailable(list.get(i))) {
                arrayList.add(list.get(i));
            }
        }
        if (arrayList.size() <= 0) {
            RVLogger.e(RVLogger.makeLogTag(com.alibaba.triver.utils.d.f25269a), "we should have at least one plugin modle.");
            pluginDownloadCallback.onSuccess();
            return;
        }
        final CountDownLatch countDownLatch = new CountDownLatch(arrayList.size());
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        c cVar = new c() { // from class: com.alibaba.triver.resource.BasicPluginResourceManager.1
            @Override // com.alibaba.triver.resource.c
            public void a(PluginModel pluginModel) {
                countDownLatch.countDown();
            }

            @Override // com.alibaba.triver.resource.c
            public void a(PluginModel pluginModel, int i2, String str) {
                pluginDownloadCallback.onSingleFailed(pluginModel, i2, str);
                atomicBoolean.set(true);
                pluginDownloadCallback.onFailed(1, pluginModel.getAppId() + " download failed");
                countDownLatch.countDown();
            }
        };
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            ((IPerformanceAndErrorTracker) RVProxy.get(IPerformanceAndErrorTracker.class)).sendPerfStageLog("Download", "Start http download plugin, url = " + ((PluginModel) arrayList.get(i2)).getPackageUrl());
            this.b.downloadAppAsync((PluginModel) arrayList.get(i2), cVar);
            ((IPerformanceAndErrorTracker) RVProxy.get(IPerformanceAndErrorTracker.class)).sendPerfStageLog("Download", "End http download plugin, url = " + ((PluginModel) arrayList.get(i2)).getPackageUrl());
        }
        try {
            countDownLatch.await(15000L, TimeUnit.MILLISECONDS);
            if (atomicBoolean.get()) {
                return;
            }
            pluginDownloadCallback.onSuccess();
        } catch (InterruptedException e) {
            if (!atomicBoolean.get()) {
                pluginDownloadCallback.onFailed(2, "request timeout");
            }
            RVLogger.w(Log.getStackTraceString(e));
        }
    }

    @Override // com.alibaba.ariver.resource.api.proxy.RVPluginResourceManager
    public String getInstallPath(PluginModel pluginModel) {
        PluginResourceDelegate pluginResourceDelegate = this.b;
        if (pluginResourceDelegate != null) {
            return pluginResourceDelegate.getInstallPath(pluginModel);
        }
        RVLogger.e(RVLogger.makeLogTag(com.alibaba.triver.utils.d.f25269a), "delegate is null");
        return null;
    }

    @Override // com.alibaba.ariver.resource.api.proxy.RVPluginResourceManager
    public PluginModel getRequiredPlugin(String str, String str2) {
        return PluginInfoCenter.a(str, str2);
    }

    @Override // com.alibaba.ariver.resource.api.proxy.RVPluginResourceManager
    public void installPlugins(List<PluginModel> list, @Nullable PluginInstallCallback pluginInstallCallback) {
        if (this.b == null) {
            pluginInstallCallback.onFailed(2, "delegate is null");
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < list.size(); i++) {
            arrayList.add(Pair.create(list.get(i), this.b.getInstallPath(list.get(i))));
        }
        pluginInstallCallback.onSuccess(arrayList);
    }

    @Override // com.alibaba.ariver.resource.api.proxy.RVPluginResourceManager
    public boolean isAvailable(List<PluginModel> list) {
        if (this.b == null) {
            RVLogger.e(RVLogger.makeLogTag(com.alibaba.triver.utils.d.f25269a), "delegate is null");
            return false;
        }
        for (int i = 0; i < list.size(); i++) {
            if (!this.b.isAvailable(list.get(i))) {
                return false;
            }
        }
        return true;
    }

    @Override // com.alibaba.ariver.resource.api.proxy.RVPluginResourceManager
    public void savePluginModelList(List<PluginModel> list) {
        if (list != null) {
            Iterator<PluginModel> it = list.iterator();
            while (it.hasNext()) {
                PluginInfoCenter.a(it.next());
            }
        }
    }
}
